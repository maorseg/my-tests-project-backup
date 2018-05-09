import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserDemo {

    public static void main(String[] args) {

        try {
            File inputFile = new File("C:\\Users\\Maor\\Desktop\\Phone Support\\__SamsungGSM.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        }

        catch
            (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class UserHandler extends DefaultHandler {

    // Elements to parse: PhoneRegions and Model name
    boolean bPhoneRegions = false;
    boolean bName = false;

    // Method called at the start of the document element
    public void startElement(
            String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("PhoneRegions")) {
            bPhoneRegions = true;
        }
            else if (qName.equalsIgnoreCase("Name")) {
            bName = true;
        }
    }

    // Method called with the text contents in between the start and end tags of an XML document element
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bPhoneRegions) {
            System.out.println("PhoneRegions: " + new String(ch, start, length) + "\n");
            bPhoneRegions = false;

        } else if (bName) {
            System.out.println("Name: " + new String(ch, start, length));
            bName = false;

        }
     }
}

