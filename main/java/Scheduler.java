// Scheduler


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Scheduler {
    static public void main(String[] arg) {
        boolean validate = true;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setValidating(validate);
        dbf.setNamespaceAware(true);
        dbf.setIgnoringElementContentWhitespace(true);

        // Parse the input to produce a parse tree with its root
        // in the form of a Document object
        Document doc = null;
        try {
            DocumentBuilder builder = dbf.newDocumentBuilder();
            builder.setErrorHandler(new MyErrorHandler());
            InputSource is = new InputSource("C:\\Users\\Maor\\Desktop\\Phone Support\\__Oppo1.xml");
            doc = builder.parse(is);
        } catch (SAXException e) {
            System.exit(1);
        } catch (ParserConfigurationException e) {
            System.err.println(e);
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
        dump(doc);
    }

    private static void dump(Document doc) {
        dumpLoop((Node) doc, "");
    }

    private static void dumpLoop(Node node, String indent) {
        switch (node.getNodeType()) {
            case Node.CDATA_SECTION_NODE:
                System.out.println(indent + "CDATA_SECTION_NODE");
                break;
            case Node.COMMENT_NODE:
                System.out.println(indent + "COMMENT_NODE");
                break;
            case Node.DOCUMENT_FRAGMENT_NODE:
                System.out.println(indent + "DOCUMENT_FRAGMENT_NODE");
                break;
            case Node.DOCUMENT_NODE:
                System.out.println(indent + "DOCUMENT_NODE");
                break;
            case Node.DOCUMENT_TYPE_NODE:
                System.out.println(indent + "DOCUMENT_TYPE_NODE");
                break;
            case Node.ELEMENT_NODE:
                System.out.println(indent + "ELEMENT_NODE");
                break;
            case Node.ENTITY_NODE:
                System.out.println(indent + "ENTITY_NODE");
                break;
            case Node.ENTITY_REFERENCE_NODE:
                System.out.println(indent + "ENTITY_REFERENCE_NODE");
                break;
            case Node.NOTATION_NODE:
                System.out.println(indent + "NOTATION_NODE");
                break;
            case Node.PROCESSING_INSTRUCTION_NODE:
                System.out.println(indent + "PROCESSING_INSTRUCTION_NODE");
                break;
            case Node.TEXT_NODE:
                System.out.print(indent + "TEXT_NODE");
                System.out.println(" : "+node.getTextContent());
                break;
            default:
                System.out.println(indent + "Unknown node");
                break;
        }

        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++){
            dumpLoop(list.item(i), indent + "   ");
        }
    }
}


class MyErrorHandler implements ErrorHandler {
    public void warning(SAXParseException e) throws SAXException {
        show("Warning", e);
        throw (e);
    }

    public void error(SAXParseException e) throws SAXException {
        show("Error", e);
        throw (e);
    }

    public void fatalError(SAXParseException e) throws SAXException {
        show("Fatal Error", e);
        throw (e);
    }

    private void show(String type, SAXParseException e) {
        System.out.println(type + ": " + e.getMessage());
        System.out.println("Line " + e.getLineNumber() + " Column " + e.getColumnNumber());
        System.out.println("System ID: " + e.getSystemId());
    }
}