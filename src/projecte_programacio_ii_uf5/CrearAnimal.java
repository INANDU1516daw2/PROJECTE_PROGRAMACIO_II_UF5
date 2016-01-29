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
    
    public static void CrearAnimal(String fitxer, String id, String nom, String raça, String edat,
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
                    System.err.println("\nJa existeix Mamifer amb ID = " + id + "\ncreació cancelada ... tria altra ID!\n");
                
                }catch(NullPointerException e){
                    
                    System.out.println("Efectuant creació ...\n");
                    
                    Element mamifer = doc.createElement("Mamifer");
                    docRoot.appendChild(mamifer);
                    mamifer.setAttribute("id", id);

                    Element nomTag = doc.createElement("nom");
                    mamifer.appendChild(nomTag);
                    nomTag.appendChild(doc.createTextNode(nom));

                    Element raçaTag = doc.createElement("raça");
                    mamifer.appendChild(raçaTag);
                    raçaTag.appendChild(doc.createTextNode(raça));

                    Element edatTag = doc.createElement("edat");
                    mamifer.appendChild(edatTag);
                    edatTag.appendChild(doc.createTextNode(edat));

                    Element sexeTag = doc.createElement("sexe");
                    mamifer.appendChild(sexeTag);
                    sexeTag.appendChild(doc.createTextNode(sexe));

                    Element pesTag = doc.createElement("pes");
                    mamifer.appendChild(pesTag);
                    pesTag.appendChild(doc.createTextNode(pes));
                    
                }
                
//                NodeList docNodes = docRoot.getChildNodes();
//                System.out.println(docNodes.getLength());
//            

                
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            
            //Afegim el DTD extern per usar les ID:
//          http://stackoverflow.com/questions/6637076/parsing-xml-with-dom-doctype-gets-erased
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "mamifers.dtd");
            
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
