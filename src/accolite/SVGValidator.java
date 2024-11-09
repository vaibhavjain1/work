package accolite;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.apache.batik.parser.AWTTransformProducer;
import org.apache.batik.parser.TransformListParser;
import org.apache.batik.util.XMLResourceDescriptor;
import org.apache.commons.io.IOUtils;
import org.h2.store.fs.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import org.xml.sax.InputSource;

public class SVGValidator {

	public static void main(String[] args) throws ParseException, ParserConfigurationException, IOException, SAXException {
		System.out.println(IsSvgFile());
	}

	private static boolean IsSvgFile() throws IOException {
		File file = new File("D:\\a.svg");
		String content = Files.readString(Paths.get("D:\\a.svg"), Charset.defaultCharset());
/*

		String parser = XMLResourceDescriptor.getXMLParserClassName();
		SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
		f.createSVGDocument(file.toURI().toString());*/

		/*TransformListParser p = new TransformListParser();
		AWTTransformProducer tp = new AWTTransformProducer();
		p.setTransformListHandler(tp);
		p.parse(content);*/

		//String parser = XMLResourceDescriptor.getXMLParserClassName();
		SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName());

		// Convert the SVG string to an InputStream
		InputStream inputStream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));

		// Parse the SVG content to an SVG document
		Document document = factory.createDocument(null, inputStream);

        return true;
    }
}
