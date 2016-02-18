package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_a_Objeto_TreeSet {
    
    public static void XML_a_Objeto_TreeSet(String vacuna, TreeSet <Vacuna> llista){

        String valAttr = null;
        
        try {

            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/projecte_programacio_ii_uf5/" + vacuna + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            //nom arrel fitxer
            String docRoot = doc.getDocumentElement().getNodeName();
            System.out.println("\n\nLLEGINT NODES => " + docRoot + ".xml" + "\n=============================");

            //busca tots nodes amb TagName <Vacuna> i els guarda a la llista
            NodeList nodeVacunes = doc.getElementsByTagName("Vacuna");
            System.out.println("Total " + docRoot + ": " + nodeVacunes.getLength());
            
            

                for(int i = 0; i < nodeVacunes.getLength(); i++){
                    
                ArrayList <String> valors = new ArrayList <>();
                    
                    Node animalNode = nodeVacunes.item(i);
                    
                    if(animalNode.getNodeType() == Node.ELEMENT_NODE){
                        Element element = (Element) animalNode;
                        System.out.println("\n\nInformació node\n===============");
                        String nomNode = element.getNodeName();
                        valAttr = element.getAttribute("id");
                        System.out.println("Tipus: " + nomNode + "\nid: " + valAttr);
                    }
                    
                    NodeList animalContent = animalNode.getChildNodes();
                    
                    for(int j = 0; j < animalContent.getLength(); j++){
                        Node node = animalContent.item(j);
                        if(node.getNodeType() == Node.ELEMENT_NODE){
                            String camp = node.getNodeName();
                            String camp_valor = node.getFirstChild().getTextContent();
                            System.out.println(camp + ": " + camp_valor);

                            valors.add(camp_valor); //afegim el TextContent al array
                        }
                    }

                    llista.add( new Vacuna( valors.get(0), valors.get(1) ) );
                    System.out.println(valors.get(0) + "\n" + valors.get(1));

                }   

            }catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(Lectura_By_ID_ALL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    
}
