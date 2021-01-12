package ST3Example2.ua.kharkov.knure.dkolesnikov.st3example.constants;

import java.io.File;

/**
 * Holds application constants.
 * 
 * @author D.Kolesnikov
 * 
 */
public final class Constants {
	// files
	// TODO remove in production
	public static final String PATH = "src/main/java/ST3Example2/";
	public static final String VALID_XML_FILE = PATH + "Test.xml";
	public static final String INVALID_XML_FILE = PATH + "Test-invalid.xml";
	public static final String XSD_FILE = PATH + "Test.xsd";
	public static final String XSD_FILE_URI = new File(new File("").getAbsolutePath(), XSD_FILE).getAbsolutePath();
	
	// this package contains jaxb entities. To get entities use the following
	// command: xjc Test.xsd -p PACKAGE_FOR_ENTITIES -d YOUR_SRC_FOLDER
	public static final String JAXB__PACKAGE = "ua.kharkov.knure.dkolesnikov.st3example.entity";
	
	// default encoding
	//public static final String ENCODING_DEFAULT = "UTF-8";
	
	// your own namespace
	public static final String MY_NS__URI = "http://knure.kharkov.ua/jt/st3example";
	public static final String MY_NS__PREFIX = "st3";
	
	// for schema location
	public static final String SCHEMA_LOCATION__URI = 
			"http://knure.kharkov.ua/jt/st3example Test.xsd";
	public static final String SCHEMA_LOCATION__ATTR_NAME = "schemaLocation";
	public static final String SCHEMA_LOCATION__ATTR_FQN = "xsi:schemaLocation";
	public static final String XSI_SPACE__PREFIX = "xsi";

	// validation features
	public static final String FEATURE__TURN_VALIDATION_ON = 
			"http://xml.org/sax/features/validation";
	public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON = 
			"http://apache.org/xml/features/validation/schema";
	public static final String JAXP_SCHEMA_LANGUAGE =
		    "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	public static final String JAXP_SCHEMA_SOURCE =
			"http://java.sun.com/xml/jaxp/properties/schemaSource";

	// full qualified names of classes
	public static final String CLASS__XERCES_SAX_PARSER = 
			"org.apache.xerces.parsers.SAXParser";
	public static final String CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL = 
			"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
	public static final String CLASS__SAX_PARSER_FACTORY_INTERNAL = 
			"com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl";
	public static final String CLASS__XML_SCHEMA_FACTORY_INTERNAL = 
			"com.sun.org.apache.xerces.internal.jaxp.validation.XMLSchemaFactory";
}