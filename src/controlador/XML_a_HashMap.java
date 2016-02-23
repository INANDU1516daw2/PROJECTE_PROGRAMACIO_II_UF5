package controlador;

import model.Encarregat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import model.Amfibi;
import model.Artropode;
import model.Au;
import model.Peix;
import model.Reptil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_a_HashMap {
    
    public static void RecuperaDades(String encarregat, HashMap <Encarregat,Integer> llista){
        
        
        String encarregats = encarregat + "s";
        String TagNameEncarregat = encarregat;
       
        String valAttr = null;
        
        try {

            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/dades/" + encarregats + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList nodeEncarregat = doc.getElementsByTagName(TagNameEncarregat);

                for(int i = 0; i < nodeEncarregat.getLength(); i++){

                    ArrayList <String> valors = new ArrayList <>();

                    Element encarregatNode = doc.getElementById(String.valueOf(i));
                    
                    if(encarregatNode.getNodeType() == Node.ELEMENT_NODE){
                        String nomNode = encarregatNode.getNodeName();
                        valAttr = encarregatNode.getAttribute("id");
                    }
                    
                    NodeList encarregatContent = encarregatNode.getChildNodes();
                    
                    for(int j = 0; j < encarregatContent.getLength(); j++){
                        Node node = encarregatContent.item(j);
                        if(node.getNodeType() == Node.ELEMENT_NODE){
                            String camp = node.getNodeName();
                            String camp_valor = node.getFirstChild().getTextContent();
                            valors.add(camp_valor); //afegim el TextContent al array
                        }
                    }
                    Encarregat e1 = new Encarregat("1",valors.get(0), valors.get(1), valors.get(2));
 
                    llista.put(e1, 1);
                    
                            System.out.println("Objecte Encarregat creat en memoria");
                            

                }
                
            }catch (ParserConfigurationException | SAXException | IOException ex) {
                System.err.println(ex);
            }

        }
}
