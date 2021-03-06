package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
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

public class Lectura_By_ID_ALL {
    
    public static void Lectura_By_ID (String fitxer) {
        
        try {
            //    public static void Lectura_By_ID (String fitxer, String id) {
            
            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/"
                    + "src/projecte_programacio_ii_uf5/" + fitxer + ".xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();
            
//            Element mamifer = doc.getElementById(id);
            
            //nom arrel fitxer
            String docRoot = doc.getDocumentElement().getNodeName();
            System.out.println(docRoot + "\n=================");
            
            //busca tots nodes amb TagName <Mamifer> i els guarda a la llista
            NodeList Mamifers = doc.getElementsByTagName("Mamifer");
            System.out.println("Total mamifers: " + Mamifers.getLength());
            
            System.out.println("\nContingut node\n==============");
            
            for(int i = 0; i < Mamifers.getLength(); i++){
//                    Node mamiferNode = Mamifers.item(i);
                Element mamiferNode = doc.getElementById(String.valueOf(i));
                if(mamiferNode.getNodeType() == Node.ELEMENT_NODE){
                    System.out.println("\nInformació node\n======================");
                    String nomNode = mamiferNode.getNodeName();
                    String valAttr = mamiferNode.getAttribute("id");
                    System.out.println("Tipus: " + nomNode + "\nid: " + valAttr);
                }
                NodeList MamiferContent = mamiferNode.getChildNodes();
                for(int j = 0; j < MamiferContent.getLength(); j++){
                    Node node = MamiferContent.item(j);
                    if(node.getNodeType() == Node.ELEMENT_NODE){
                        String camp = node.getNodeName();
                        String camp_valor = node.getFirstChild().getTextContent();
                        System.out.println(camp + ": " + camp_valor);
                    }
                }
                System.out.println("======================\n");
            }   
        
        
        }catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Lectura_By_ID_ALL.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    
}//endClass