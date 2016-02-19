package controlador;

import model.Mamifer;
import model.Animal;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class XML_a_ArrayList {
    
    public static void RecuperaDades(String animal, ArrayList <Animal> llista){
        
        String animals = animal + "s";
        String TagNameAnimal = animal;
        if ("Peixo".equals(animal)){
            TagNameAnimal = "Peix";
        }
        String valAttr = null;
        
        try {

            File xml = new File("/home/"+System.getProperty("user.name")+"/NetBeansProjects/"
                    + "PROJECTE_PROGRAMACIO_II_UF5/" + "src/dades/" + animals + ".xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            doc.getDocumentElement().normalize();

            NodeList nodeAnimal = doc.getElementsByTagName(TagNameAnimal);

                for(int i = 0; i < nodeAnimal.getLength(); i++){

                    ArrayList <String> valors = new ArrayList <>();

                    Element animalNode = doc.getElementById(String.valueOf(i));
                    
                    if(animalNode.getNodeType() == Node.ELEMENT_NODE){
                        String nomNode = animalNode.getNodeName();
                        valAttr = animalNode.getAttribute("id");
                    }
                    
                    NodeList animalContent = animalNode.getChildNodes();
                    
                    for(int j = 0; j < animalContent.getLength(); j++){
                        Node node = animalContent.item(j);
                        if(node.getNodeType() == Node.ELEMENT_NODE){
                            String camp = node.getNodeName();
                            String camp_valor = node.getFirstChild().getTextContent();
                            valors.add(camp_valor); //afegim el TextContent al array
                        }
                    }
 
                    switch (animals) {
                        case "Mamifers" : 
                            llista.add(
                                new Mamifer (
                                    valAttr,   //ID
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Mamifer creat en memoria");
                            break;
                            
                        case "Aus" : 
                            llista.add(
                                new Au (
                                    valAttr,   //ID
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Au creat en memoria");
                            break;
                            
                        case "Amfibis" : 
                            llista.add(
                                new Amfibi (
                                    valAttr,
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Amfibi creat en memoria");
                            break;
                            
                        case "Artropodes" : 
                            llista.add(
                                new Artropode (
                                    valAttr,
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Artropode creat en memoria");
                            break;
                            
                        case "Reptils" : 
                            llista.add(
                                new Reptil (
                                    valAttr,
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Reptil creat en memoria");
                            break;
                            
                        case "Peixos" : 
                            llista.add(
                                new Peix (
                                    valAttr,
                                    valors.get(0), valors.get(1), valors.get(2), valors.get(3),
                                    valors.get(4), valors.get(5), valors.get(6), valors.get(7), 
                                    valors.get(8), valors.get(9), valors.get(10), valors.get(11)
                                )
                            );
                            System.out.println("Objecte Peix creat en memoria");
                            break;
                    }

                }
                
            }catch (ParserConfigurationException | SAXException | IOException ex) {
                System.err.println(ex);
            }

        }
}
