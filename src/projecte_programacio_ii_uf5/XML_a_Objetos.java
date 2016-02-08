package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

public class XML_a_Objetos {
    
    public static void XML_a_Objeto(String fitxer, ArrayList <Animal> llistaMamifers){

        try {

            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/"
                    + "src/projecte_programacio_ii_uf5/" + fitxer + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            //nom arrel fitxer
            String docRoot = doc.getDocumentElement().getNodeName();
            System.out.println("\n\n" + docRoot + "\n=================");

            //busca tots nodes amb TagName <Mamifer> i els guarda a la llista
            NodeList Mamifers = doc.getElementsByTagName("Mamifer");
            System.out.println("Total mamifers: " + Mamifers.getLength());

            for(int i = 0; i < Mamifers.getLength(); i++){
                  
                ArrayList <String> valors = new ArrayList <>();
                
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
                        
                        valors.add(camp_valor); //afegim el TextContent al array
                    }
                }
       
                llistaMamifers.add(
                    new Mamifer(
                            valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                            valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                            valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                    )
                );
                
//                Iterator <String> mi_iterador = valors.iterator();
//
//                while(mi_iterador.hasNext()){
//                    
//                }
                
//                llistaMamifers.add(new Mamifer(nom, raça, ID, ID_pare, ID_mare, edat,
//                        femeni, pes, esp_vida, vertebrat, alimentacio, reproduccio, ecosistema, vacunacio));
                
                System.out.println("======================\n");
            }   

            

        }catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Lectura_By_ID_ALL.class.getName()).log(Level.SEVERE, null, ex);
        }







    //        llistaMamifers.add(new Mamifer());
    //    
        
//            Iterator <Animal> mi_iterador = llistaMamifers.iterator();
//            
//            while(mi_iterador.hasNext()){
//                System.out.println(mi_iterador.next().toString());
//            }




        }

}
