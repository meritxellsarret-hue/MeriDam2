import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
public class  LecturaXML{
    public static void main(String[] args) {
        File file = new File("car.xml");
        try {
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();
            Document doc = constructor.parse(file);
            doc.getDocumentElement().normalize();
            NodeList llista = doc.getElementsByTagName("car");
            System.out.println("Numero de cochest: " +llista.getLength());
            for (int i = 0; i < llista.getLength(); i++) {
                Node node = llista.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element)node;
                    System.out.println("Modelo =" +e.getElementsByTagName("brand").item(0) + e.getAttribute("year"));
                }
            }
        } catch (Exception e) {    
        }
    }
}
