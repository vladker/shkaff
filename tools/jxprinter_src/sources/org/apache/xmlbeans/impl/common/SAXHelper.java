package org.apache.xmlbeans.impl.common;

import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.SAXParserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.r;
import org.apache.xmlbeans.XmlOptions;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class SAXHelper {
    private static long lastLog;
    private static final Logger LOG = LogManager.getLogger((Class<?>) SAXHelper.class);
    public static final EntityResolver IGNORING_ENTITY_RESOLVER = new r(1);

    private SAXHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InputSource lambda$static$0(String str, String str2) {
        return new InputSource(new StringReader(""));
    }

    public static XMLReader newXMLReader(XmlOptions xmlOptions) throws SAXException {
        XMLReader xMLReader = saxFactory(xmlOptions).newSAXParser().getXMLReader();
        xMLReader.setEntityResolver(IGNORING_ENTITY_RESOLVER);
        trySetSAXFeature(xMLReader, "http://javax.xml.XMLConstants/feature/secure-processing");
        trySetXercesSecurityManager(xMLReader, xmlOptions);
        return xMLReader;
    }

    public static SAXParserFactory saxFactory() {
        return saxFactory(new XmlOptions());
    }

    private static void trySetSAXFeature(SAXParserFactory sAXParserFactory, String str, boolean z6) {
        try {
            sAXParserFactory.setFeature(str, z6);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because outdated XML parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("SAX Feature unsupported: {}", str);
        }
    }

    private static void trySetXercesSecurityManager(XMLReader xMLReader, XmlOptions xmlOptions) {
        try {
            Class<?> cls = Class.forName(new String[]{"org.apache.xerces.util.SecurityManager"}[0]);
            try {
                Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                cls.getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
                xMLReader.setProperty(XMLBeansConstants.SECURITY_MANAGER, objNewInstance);
            } catch (Throwable th) {
                if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + lastLog) {
                    LOG.atWarn().withThrowable(th).log("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
                    lastLog = System.currentTimeMillis();
                }
                try {
                    xMLReader.setProperty(XMLBeansConstants.ENTITY_EXPANSION_LIMIT, Integer.valueOf(xmlOptions.getEntityExpansionLimit()));
                } catch (SAXException e) {
                    if (System.currentTimeMillis() > TimeUnit.MINUTES.toMillis(5L) + lastLog) {
                        LOG.atWarn().withThrowable(e).log("SAX Security Manager could not be setup [log suppressed for 5 minutes]");
                        lastLog = System.currentTimeMillis();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static SAXParserFactory saxFactory(XmlOptions xmlOptions) {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setValidating(false);
        sAXParserFactoryNewInstance.setNamespaceAware(true);
        trySetSAXFeature(sAXParserFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_DTD_GRAMMAR, xmlOptions.isLoadDTDGrammar());
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_LOAD_EXTERNAL_DTD, xmlOptions.isLoadExternalDTD());
        trySetSAXFeature(sAXParserFactoryNewInstance, XMLBeansConstants.FEATURE_DISALLOW_DOCTYPE_DECL, xmlOptions.disallowDocTypeDeclaration());
        return sAXParserFactoryNewInstance;
    }

    private static void trySetSAXFeature(XMLReader xMLReader, String str) {
        try {
            xMLReader.setFeature(str, true);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set SAX feature {} because outdated XML parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("SAX Feature unsupported: {}", str);
        }
    }
}
