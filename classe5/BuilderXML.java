import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
//
public class BuilderXML{
    public static void main(String[] args) {
        try{
            DocumentBuilder dbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dbuilder.newDocument();

            Element arrel = doc.createElement("Pokedex");
            doc.appendChild(arrel);

            Element pokemon = doc.createElement("Pokemon");
            pokemon.setAttribute("pokemon", "Pikachu");
            arrel.appendChild(pokemon);

            Element hp = doc.createElement("hp");
            hp.appendChild(doc.createTextNode("100"));
            pokemon.appendChild(hp);
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.transform(new DOMSource(doc), new StreamResult(new File("sortida.xml")));
        } catch (Exception e) {
        }
    }
}
