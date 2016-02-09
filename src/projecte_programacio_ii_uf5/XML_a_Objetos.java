package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public static void XML_a_Objeto(String animal, ArrayList <Animal> llista){
        
        String animals = animal + "s";
        String TagNameAnimal = animal;
        if ("Peixo".equals(animal)){
            TagNameAnimal = "Peix";
        }
        String valAttr = null;
        
        try {

            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/projecte_programacio_ii_uf5/" + animals + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            //nom arrel fitxer
            String docRoot = doc.getDocumentElement().getNodeName();
            System.out.println("\n\nLLEGINT NODES => " + docRoot + ".xml" + "\n=============================");

            //busca tots nodes amb TagName <Mamifer> i els guarda a la llista
            NodeList nodeAnimal = doc.getElementsByTagName(TagNameAnimal);
            System.out.println("Total " + docRoot + ": " + nodeAnimal.getLength());

                for(int i = 0; i < nodeAnimal.getLength(); i++){

                    ArrayList <String> valors = new ArrayList <>();

                    Element animalNode = doc.getElementById(String.valueOf(i));
                    if(animalNode.getNodeType() == Node.ELEMENT_NODE){
                        System.out.println("\n\nInformació node\n===============");
                        String nomNode = animalNode.getNodeName();
                        valAttr = animalNode.getAttribute("id");
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

                    switch (animals) {
                        case "Mamifers" : 
                            llista.add(
                                new Mamifer(
                                        valAttr,
                                        valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                        valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                        valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            break;
                    }

                }   

            }catch (ParserConfigurationException | SAXException | IOException ex) {
                Logger.getLogger(Lectura_By_ID_ALL.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
