package org.apache.xmlbeans.impl.common;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class DocumentHelper {
    private static final Logger LOG = LogManager.getLogger((Class<?>) DocumentHelper.class);
    private static final DocumentBuilder documentBuilderSingleton = newDocumentBuilder(new XmlOptions());
    private static long lastLog;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        private String asString(SAXParseException sAXParseException) {
            StringBuilder sb = new StringBuilder();
            String systemId = sAXParseException.getSystemId();
            if (systemId != null) {
                int iLastIndexOf = systemId.lastIndexOf(47);
                if (iLastIndexOf != -1) {
                    systemId = systemId.substring(iLastIndexOf + 1);
                }
                sb.append(systemId);
            }
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getLineNumber());
            sb.append(NameUtil.COLON);
            sb.append(sAXParseException.getColumnNumber());
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            return sb.toString();
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
            DocumentHelper.LOG.atError().withThrowable(sAXParseException).log(asString(sAXParseException));
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
            DocumentHelper.LOG.atFatal().withThrowable(sAXParseException).log(asString(sAXParseException));
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
            DocumentHelper.LOG.atWarn().withThrowable(sAXParseException).log(asString(sAXParseException));
        }
    }

    private DocumentHelper() {
    }

    public static Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    private static DocumentBuilderFactory documentBuilderFactory(XmlOptions xmlOptions) {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySetFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptions.isLoadDTDGrammar());
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptions.isLoadExternalDTD());
        trySetFeature(documentBuilderFactoryNewInstance, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, xmlOptions.disallowDocTypeDeclaration());
        trySetXercesSecurityManager(documentBuilderFactoryNewInstance, xmlOptions);
        return documentBuilderFactoryNewInstance;
    }

    public static DocumentBuilder newDocumentBuilder(XmlOptions xmlOptions) {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactory(xmlOptions).newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
            return documentBuilderNewDocumentBuilder;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
    }

    public static Document readDocument(XmlOptions xmlOptions, InputStream inputStream) {
        return newDocumentBuilder(xmlOptions).parse(inputStream);
    }

    private static void trySetFeature(DocumentBuilderFactory documentBuilderFactory, String str, boolean z6) {
        try {
            documentBuilderFactory.setFeature(str, z6);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because of outdated XML parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("SAX Feature unsupported: {}", str);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory, XmlOptions xmlOptions) {
        try {
            Object objNewInstance = Class.forName(new String[]{"org.apache.xerces.util.SecurityManager"}[0]).getDeclaredConstructor(null).newInstance(null);
            objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
            documentBuilderFactory.setAttribute(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
        } catch (ClassNotFoundException unused) {
            try {
                documentBuilderFactory.setAttribute(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
            } catch (Throwable th) {
                if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + lastLog) {
                    LOG.atWarn().withThrowable(th).log("DocumentBuilderFactory Entity Expansion Limit could not be setup [log suppressed for 5 minutes]");
                    lastLog = System.currentTimeMillis();
                }
            }
        } catch (Throwable th2) {
            if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + lastLog) {
                LOG.atWarn().withThrowable(th2).log("DocumentBuilderFactory Security Manager could not be setup [log suppressed for 5 minutes]");
                lastLog = System.currentTimeMillis();
            }
            documentBuilderFactory.setAttribute(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
        }
    }

    public static Document readDocument(XmlOptions xmlOptions, InputSource inputSource) {
        return newDocumentBuilder(xmlOptions).parse(inputSource);
    }
}
