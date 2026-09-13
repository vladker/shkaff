package org.apache.poi.util;

import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.validation.SchemaFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.xmlbeans.impl.common.NameUtil;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class XMLHelper {
    static final String FEATURE_DISALLOW_DOCTYPE_DECL = "http://apache.org/xml/features/disallow-doctype-decl";
    static final String FEATURE_EXTERNAL_ENTITIES = "http://xml.org/sax/features/external-general-entities";
    static final String FEATURE_LOAD_DTD_GRAMMAR = "http://apache.org/xml/features/nonvalidating/load-dtd-grammar";
    static final String FEATURE_LOAD_EXTERNAL_DTD = "http://apache.org/xml/features/nonvalidating/load-external-dtd";
    static final String FEATURE_PARAMETER_ENTITIES = "http://xml.org/sax/features/external-parameter-entities";
    static final String METHOD_ENTITY_EXPANSION_XERCES = "setEntityExpansionLimit";
    static final String PROPERTY_ENTITY_EXPANSION_LIMIT = "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit";
    static final String PROPERTY_SECURITY_MANAGER = "http://apache.org/xml/properties/security-manager";
    private static long lastLog;
    static final String[] SECURITY_MANAGERS = {"org.apache.xerces.util.SecurityManager"};
    private static final Logger LOG = LogManager.getLogger((Class<?>) XMLHelper.class);
    private static final DocumentBuilderFactory documentBuilderFactory = getDocumentBuilderFactory();
    private static final SAXParserFactory saxFactory = getSaxParserFactory();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        private void printError(Level level, SAXParseException sAXParseException) {
            int iLastIndexOf;
            String systemId = sAXParseException.getSystemId();
            if (systemId != null && (iLastIndexOf = systemId.lastIndexOf(47)) != -1) {
                systemId = systemId.substring(iLastIndexOf + 1);
            }
            StringBuilder sb = new StringBuilder();
            if (systemId == null) {
                systemId = "";
            }
            sb.append(systemId);
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getLineNumber());
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getColumnNumber());
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getMessage());
            XMLHelper.LOG.atLevel(level).withThrowable(sAXParseException).log(sb.toString());
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
            printError(Level.ERROR, sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
            printError(Level.FATAL, sAXParseException);
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
            printError(Level.WARN, sAXParseException);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface SecurityFeature {
        void accept(String str, boolean z6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @FunctionalInterface
    public interface SecurityProperty {
        void accept(String str, Object obj);
    }

    private XMLHelper() {
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        quietSet(new p(documentBuilderFactoryNewInstance, 1), "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        quietSet(new p(documentBuilderFactoryNewInstance, 1), "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), FEATURE_EXTERNAL_ENTITIES, false);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), FEATURE_PARAMETER_ENTITIES, false);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 0), "http://apache.org/xml/features/disallow-doctype-decl", true);
        trySet((SecurityFeature) new p(documentBuilderFactoryNewInstance, 2), "XIncludeAware", false);
        Object xercesSecurityManager = getXercesSecurityManager();
        if (xercesSecurityManager != null && trySet(new p(documentBuilderFactoryNewInstance, 1), "http://apache.org/xml/properties/security-manager", xercesSecurityManager)) {
            return documentBuilderFactoryNewInstance;
        }
        trySet((SecurityProperty) new p(documentBuilderFactoryNewInstance, 1), "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", (Object) 1);
        return documentBuilderFactoryNewInstance;
    }

    public static SAXParserFactory getSaxParserFactory() throws Throwable {
        try {
            SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
            sAXParserFactoryNewInstance.setValidating(false);
            sAXParserFactoryNewInstance.setNamespaceAware(true);
            trySet((SecurityFeature) new n(sAXParserFactoryNewInstance, 2), "http://javax.xml.XMLConstants/feature/secure-processing", true);
            trySet((SecurityFeature) new n(sAXParserFactoryNewInstance, 2), "http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            trySet((SecurityFeature) new n(sAXParserFactoryNewInstance, 2), "http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            trySet((SecurityFeature) new n(sAXParserFactoryNewInstance, 2), FEATURE_EXTERNAL_ENTITIES, false);
            trySet((SecurityFeature) new n(sAXParserFactoryNewInstance, 2), "http://apache.org/xml/features/disallow-doctype-decl", true);
            return sAXParserFactoryNewInstance;
        } catch (Error e) {
            e = e;
            logThrowable(e, "Failed to create SAXParserFactory", ProcessIdUtil.DEFAULT_PROCESSID);
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            logThrowable(e, "Failed to create SAXParserFactory", ProcessIdUtil.DEFAULT_PROCESSID);
            throw e;
        } catch (Exception e7) {
            logThrowable(e7, "Failed to create SAXParserFactory", ProcessIdUtil.DEFAULT_PROCESSID);
            throw new RuntimeException("Failed to create SAXParserFactory", e7);
        }
    }

    public static SchemaFactory getSchemaFactory() {
        SchemaFactory schemaFactoryNewInstance = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        schemaFactoryNewInstance.getClass();
        trySet((SecurityFeature) new m(schemaFactoryNewInstance), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        quietSet(new m(schemaFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        quietSet(new m(schemaFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        quietSet(new m(schemaFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        return schemaFactoryNewInstance;
    }

    public static TransformerFactory getTransformerFactory() {
        TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
        transformerFactoryNewInstance.getClass();
        trySet((SecurityFeature) new q(transformerFactoryNewInstance), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        quietSet(new q(transformerFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalDTD", "");
        quietSet(new q(transformerFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalStylesheet", "");
        quietSet(new q(transformerFactoryNewInstance), "http://javax.xml.XMLConstants/property/accessExternalSchema", "");
        return transformerFactoryNewInstance;
    }

    private static Object getXercesSecurityManager() {
        for (String str : SECURITY_MANAGERS) {
            try {
                Object objNewInstance = Class.forName(str).getDeclaredConstructor(null).newInstance(null);
                objNewInstance.getClass().getMethod(METHOD_ENTITY_EXPANSION_XERCES, Integer.TYPE).invoke(objNewInstance, 1);
                return objNewInstance;
            } catch (ClassNotFoundException unused) {
            } catch (Throwable th) {
                logThrowable(th, "SAX Feature unsupported", str);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputSource ignoreEntity(String str, String str2) {
        return new InputSource(new StringReader(""));
    }

    private static void logThrowable(Throwable th, String str, String str2) {
        if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + lastLog) {
            LOG.atWarn().withThrowable(th).log("{} [log suppressed for 5 minutes] {}", str, str2);
            lastLog = System.currentTimeMillis();
        }
    }

    public static DocumentBuilder newDocumentBuilder() {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(new r(0));
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
            return documentBuilderNewDocumentBuilder;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
    }

    public static Transformer newTransformer() throws TransformerConfigurationException {
        Transformer transformerNewTransformer = getTransformerFactory().newTransformer();
        transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
        transformerNewTransformer.setOutputProperty("indent", "no");
        transformerNewTransformer.setOutputProperty("method", "xml");
        return transformerNewTransformer;
    }

    public static XMLEventFactory newXMLEventFactory() {
        return XMLEventFactory.newInstance();
    }

    public static XMLInputFactory newXMLInputFactory() {
        XMLInputFactory xMLInputFactoryNewInstance = XMLInputFactory.newInstance();
        xMLInputFactoryNewInstance.getClass();
        trySet((SecurityFeature) new n(xMLInputFactoryNewInstance, 0), "javax.xml.stream.isNamespaceAware", true);
        trySet((SecurityFeature) new n(xMLInputFactoryNewInstance, 0), "javax.xml.stream.isValidating", false);
        trySet((SecurityFeature) new n(xMLInputFactoryNewInstance, 0), "javax.xml.stream.supportDTD", false);
        trySet((SecurityFeature) new n(xMLInputFactoryNewInstance, 0), "javax.xml.stream.isSupportingExternalEntities", false);
        return xMLInputFactoryNewInstance;
    }

    public static XMLOutputFactory newXMLOutputFactory() {
        XMLOutputFactory xMLOutputFactoryNewInstance = XMLOutputFactory.newInstance();
        xMLOutputFactoryNewInstance.getClass();
        trySet((SecurityFeature) new n(xMLOutputFactoryNewInstance, 1), "javax.xml.stream.isRepairingNamespaces", true);
        return xMLOutputFactoryNewInstance;
    }

    public static XMLReader newXMLReader() throws SAXException {
        XMLReader xMLReader = saxFactory.newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(new r(0));
        trySet((SecurityFeature) new o(xMLReader), "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySet((SecurityFeature) new o(xMLReader), FEATURE_EXTERNAL_ENTITIES, false);
        Object xercesSecurityManager = getXercesSecurityManager();
        if (xercesSecurityManager != null && trySet(new o(xMLReader), "http://apache.org/xml/properties/security-manager", xercesSecurityManager)) {
            return xMLReader;
        }
        trySet((SecurityProperty) new o(xMLReader), "http://www.oracle.com/xml/jaxp/properties/entityExpansionLimit", (Object) 1);
        return xMLReader;
    }

    private static boolean quietSet(SecurityProperty securityProperty, String str, Object obj) {
        try {
            securityProperty.accept(str, obj);
            return true;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    private static boolean trySet(SecurityFeature securityFeature, String str, boolean z6) {
        try {
            securityFeature.accept(str, z6);
            return true;
        } catch (Error e) {
            logThrowable(e, "Cannot set SAX feature because outdated XML parser in classpath", str);
            return false;
        } catch (Exception e6) {
            logThrowable(e6, "SAX Feature unsupported", str);
            return false;
        }
    }

    private static boolean trySet(SecurityProperty securityProperty, String str, Object obj) {
        try {
            securityProperty.accept(str, obj);
            return true;
        } catch (Error e) {
            logThrowable(e, "Cannot set SAX feature because outdated XML parser in classpath", str);
            return false;
        } catch (Exception e6) {
            logThrowable(e6, "SAX Feature unsupported", str);
            return false;
        }
    }
}
