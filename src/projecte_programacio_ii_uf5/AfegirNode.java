package projecte_programacio_ii_uf5;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AfegirNode {
    
    public static void AfegirNode(String fitxer, String id, String TagName, String newTextContent) {
        
        try {
            String filepath = "/home/inge/NetBeansProjects/"
                + "PROJECTE_PROGRAMACIO_II_UF5/"
                + "src/projecte_programacio_ii_uf5/" + fitxer + ".xml";
            
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            
            docFactory.setValidating(true);
            
            try {
                Element mamifer = doc.getElementById(id);
                String existeix = mamifer.getNodeValue();
                System.err.println("Ja existeix Mamifer amb ID = " + id + "\ncreació cancelada ... tria altra ID!\n");
            
                Element newElement = doc.createElement(TagName);
                mamifer.appendChild(newElement);

                newElement.appendChild(doc.createTextNode(newTextContent));

                // write the content into xml file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();

                //Afegim el DTD extern per usar les ID:
    //          http://stackoverflow.com/questions/6637076/parsing-xml-with-dom-doctype-gets-erased
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "mamifers.dtd");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filepath));
                transformer.transform(source, result);

                System.out.println("Node " + TagName + " afegit ....... [OK]");
                
                }catch(NullPointerException e){
                    System.err.println("No existeix Mamifer amb ID = " + id + "\nno posible afegir node ... tria altra ID!\n");
                }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ModifyXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ModifyXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ModifyXMLFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
