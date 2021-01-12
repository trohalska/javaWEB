package trohalska.xml.xmlParserDemo.src.main.java.com.epam.training.xmldemo;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Usage of API documented as @since 1.9+
 */
public class XSLTransformDemo {
	public static void main(String[] args) throws TransformerException {
		TransformerFactory factory = TransformerFactory.newDefaultInstance();
		Transformer t = factory.newTransformer(new StreamSource("xml/xslt/content.xsl"));
		t.transform (new StreamSource("xml/xslt/content.xml"), new StreamResult("xml/xslt/content.out.html"));

		t = factory.newTransformer(new StreamSource("xml/xslt/cd.xsl"));
		t.setOutputProperty(OutputKeys.METHOD, "html");
		t.setOutputProperty(OutputKeys.ENCODING, "UTF8");
		t.setOutputProperty(OutputKeys.INDENT, "no");
		t.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "about:legacy-compat");
		
		t.transform (new StreamSource("xml/xslt/cd.xml"), new StreamResult("xml/xslt/cd.out.html"));

		t = factory.newTransformer(new StreamSource("xml/xslt/books_xml2xml.xsl"));
		t.transform (new StreamSource("xml/xslt/books.xml"), new StreamResult("xml/xslt/books.out.xml"));

		t = factory.newTransformer(new StreamSource("xml/xslt/books.xsl"));
		t.transform (new StreamSource("xml/xslt/books.xml"), new StreamResult("xml/xslt/books.out.html"));
	}
}
