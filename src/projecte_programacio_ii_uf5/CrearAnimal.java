package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
import static java.sql.Types.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CrearAnimal {
    
    public static void CrearAnimal(String fitxer, String NodeAnimal, String id, String nom, String raça, String edat,
            String sexe, String pes) {
        
//            String esp_vida, String vertebrat, String alimentacio, 
//            String reproduccio, String ecosistema
 
	  try {
 
                String filepath = "/home/inge/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/projecte_programacio_ii_uf5/" + fitxer + ".xml";
                
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.parse(filepath);

                docFactory.setValidating(true);

                Element docRoot = doc.getDocumentElement();
                
                
                //COMPROVEM MAMIFER AM MATEIX ID NO EXISTEIX ABANS CREARLO
                
                try {
                    Element mamifer = doc.getElementById(id);
                    String existeix = mamifer.getNodeValue();
                    System.err.println("\nJa existeix Animal amb ID = " + id + "\ncreació cancelada ... tria altra ID!\n");
                
                }catch(NullPointerException e){
                    
                    System.out.println("Efectuant creació ...\n");
                    
                    Element Animal = doc.createElement(NodeAnimal);
                    docRoot.appendChild(Animal);
                    Animal.setAttribute("id", id);

                    Element nomTag = doc.createElement("nom");
                    Animal.appendChild(nomTag);
                    nomTag.appendChild(doc.createTextNode(nom));

                    Element raçaTag = doc.createElement("raça");
                    Animal.appendChild(raçaTag);
                    raçaTag.appendChild(doc.createTextNode(raça));

                    Element edatTag = doc.createElement("edat");
                    Animal.appendChild(edatTag);
                    edatTag.appendChild(doc.createTextNode(edat));

                    Element sexeTag = doc.createElement("sexe");
                    Animal.appendChild(sexeTag);
                    sexeTag.appendChild(doc.createTextNode(sexe));

                    Element pesTag = doc.createElement("pes");
                    Animal.appendChild(pesTag);
                    pesTag.appendChild(doc.createTextNode(pes));
                    
                }
                
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            /* Afegim el DTD extern per usar les ID:
             * Mirem de quin tipus animal es el fitxer XML i afegim el DTD de la seva especie
             * Documentacio: http://stackoverflow.com/questions/6637076/parsing-xml-with-dom-doctype-gets-erased
            */
            
            switch (fitxer) {
            case "Mamifers":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Mamifers.dtd");
                    break;
            case "Reptils":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Reptils.dtd");
                    break;
            case "Peixos":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Peixos.dtd");
                    break;
            case "Amfibis":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Amfibis.dtd");
                    break;
            case "Aus":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Aus.dtd");
                    break;
            case "Artropodes":
                    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Artropodes.dtd");
                    break;
            }
            
            
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            
//            System.out.println("Nou Mamifer["+id+"] creat ....... [OK]");
 
	  } catch (ParserConfigurationException | TransformerException pce) {
	  } catch (SAXException | IOException ex) {
            Logger.getLogger(CrearAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
    
}
