package org.apache.xmlbeans.impl.common;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xmlbeans.XmlOptions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class StaxHelper {
    private static final Logger LOG = LogManager.getLogger((Class<?>) StaxHelper.class);

    private StaxHelper() {
    }

    public static XMLEventFactory newXMLEventFactory(XmlOptions xmlOptions) {
        return XMLEventFactory.newFactory();
    }

    public static XMLInputFactory newXMLInputFactory(XmlOptions xmlOptions) {
        XMLInputFactory xMLInputFactoryNewFactory = XMLInputFactory.newFactory();
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.isNamespaceAware", true);
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.isValidating", false);
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.supportDTD", xmlOptions.isLoadDTDGrammar());
        trySetProperty(xMLInputFactoryNewFactory, "javax.xml.stream.isSupportingExternalEntities", xmlOptions.isLoadExternalDTD());
        return xMLInputFactoryNewFactory;
    }

    public static XMLOutputFactory newXMLOutputFactory(XmlOptions xmlOptions) {
        XMLOutputFactory xMLOutputFactoryNewFactory = XMLOutputFactory.newFactory();
        trySetProperty(xMLOutputFactoryNewFactory, "javax.xml.stream.isRepairingNamespaces", true);
        return xMLOutputFactoryNewFactory;
    }

    private static void trySetProperty(XMLInputFactory xMLInputFactory, String str, boolean z6) {
        try {
            xMLInputFactory.setProperty(str, Boolean.valueOf(z6));
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set StAX property {} because outdated StAX parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("StAX Property unsupported: {}", str);
        }
    }

    private static void trySetProperty(XMLOutputFactory xMLOutputFactory, String str, boolean z6) {
        try {
            xMLOutputFactory.setProperty(str, Boolean.valueOf(z6));
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set StAX property {} because outdated StAX parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("StAX Property unsupported: {}", str);
        }
    }
}
