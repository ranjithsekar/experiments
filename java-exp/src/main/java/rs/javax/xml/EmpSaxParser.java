package rs.javax.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EmpSaxParser {
  public static void main(String[] args) throws Exception {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    
    SAXParser saxParser = factory.newSAXParser();
    DefaultHandler handler = new DefaultHandler() {

      boolean a = false;
      boolean b = false;

      public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("qName :" + qName);
        System.out.println("uri :" + uri);

        System.out.println("attributes: " + attributes);
        if (qName.equalsIgnoreCase("test:a")) {
          a = true;
        }

      }

      public void characters(char ch[], int start, int length) throws SAXException {
        if (a) {
          System.out.println("First Name : " + new String(ch, start, length));
          a = false;
        }
      }

      public void endElement(String uri, String localName, String qName) throws SAXException {

        System.out.println("End Element :" + qName);
      }
    };

    saxParser.parse("emp.xml", handler);
  }
}
