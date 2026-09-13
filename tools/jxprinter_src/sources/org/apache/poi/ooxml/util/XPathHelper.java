package org.apache.poi.ooxml.util;

import androidx.webkit.ProxyConfig;
import com.microsoft.schemas.compatibility.AlternateContentDocument;
import java.util.Locale;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPathFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Internal;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlAnyTypeImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XPathHelper {
    private static final String MAC_DML_NS = "http://schemas.microsoft.com/office/mac/drawingml/2008/main";
    private static final String MC_NS = "http://schemas.openxmlformats.org/markup-compatibility/2006";
    private static final String OSGI_ERROR = "Schemas (*.xsb) for <CLASS> can't be loaded - usually this happens when OSGI loading is used and the thread context classloader has no reference to the xmlbeans classes - please either verify if the <XSB>.xsb is on the classpath or alternatively try to use the poi-ooxml-full-x.x.jar";
    static final XPathFactory xpathFactory;
    private static final Logger LOG = LogManager.getLogger((Class<?>) XPathHelper.class);
    private static final QName ALTERNATE_CONTENT_TAG = new QName("http://schemas.openxmlformats.org/markup-compatibility/2006", "AlternateContent");

    static {
        XPathFactory xPathFactoryNewInstance = XPathFactory.newInstance();
        xpathFactory = xPathFactoryNewInstance;
        trySetFeature(xPathFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
    }

    private XPathHelper() {
    }

    public static XPathFactory getFactory() {
        return xpathFactory;
    }

    @Internal
    public static <T extends XmlObject> T selectProperty(XmlObject xmlObject, Class<T> cls, XSLFShape.ReparseFactory<T> reparseFactory, QName[]... qNameArr) {
        XmlCursor xmlCursorNewCursor = xmlObject.newCursor();
        try {
            XmlCursor xmlCursorSelectProperty = selectProperty(xmlCursorNewCursor, qNameArr, 0, reparseFactory != null, false);
            if (xmlCursorSelectProperty == null) {
                if (xmlCursorSelectProperty != null) {
                    xmlCursorSelectProperty.close();
                }
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return null;
            }
            try {
                T t6 = (T) xmlCursorSelectProperty.getObject();
                if (t6 instanceof XmlAnyTypeImpl) {
                    String strReplace = OSGI_ERROR.replace("<CLASS>", cls.getSimpleName()).replace("<XSB>", cls.getSimpleName().toLowerCase(Locale.ROOT) + ProxyConfig.MATCH_ALL_SCHEMES);
                    if (reparseFactory == null) {
                        throw new XmlException(strReplace);
                    }
                    t6 = (T) reparseFactory.parse(xmlCursorSelectProperty.newXMLStreamReader());
                }
                xmlCursorSelectProperty.close();
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return t6;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        xmlCursorSelectProperty.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                if (xmlCursorNewCursor != null) {
                    try {
                        xmlCursorNewCursor.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        }
    }

    private static void trySetFeature(XPathFactory xPathFactory, String str, boolean z6) {
        try {
            xPathFactory.setFeature(str, z6);
        } catch (AbstractMethodError e) {
            LOG.atWarn().withThrowable(e).log("Cannot set XPathFactory feature ({}) because outdated XML parser in classpath", str);
        } catch (Exception e6) {
            LOG.atWarn().withThrowable(e6).log("XPathFactory Feature ({}) unsupported", str);
        }
    }

    private static XmlCursor selectProperty(XmlCursor xmlCursor, QName[][] qNameArr, int i5, boolean z6, boolean z7) throws XmlException {
        AlternateContentDocument.AlternateContent alternateContent;
        XmlCursor xmlCursorSelectProperty;
        for (QName qName : qNameArr[i5]) {
            boolean child = xmlCursor.toChild(qName);
            while (child) {
                if (i5 == qNameArr.length - 1) {
                    return xmlCursor;
                }
                xmlCursor.push();
                XmlCursor xmlCursorSelectProperty2 = selectProperty(xmlCursor, qNameArr, i5 + 1, z6, false);
                if (xmlCursorSelectProperty2 != null) {
                    return xmlCursorSelectProperty2;
                }
                xmlCursor.pop();
                child = xmlCursor.toNextSibling(qName);
            }
        }
        if (z7 || !xmlCursor.toChild(ALTERNATE_CONTENT_TAG)) {
            return null;
        }
        XmlObject object = xmlCursor.getObject();
        if (object instanceof AlternateContentDocument.AlternateContent) {
            alternateContent = (AlternateContentDocument.AlternateContent) object;
        } else if (z6) {
            try {
                alternateContent = AlternateContentDocument.Factory.parse(xmlCursor.newXMLStreamReader()).getAlternateContent();
            } catch (XmlException e) {
                throw new XmlException("unable to parse AlternateContent element", e);
            }
        } else {
            throw new XmlException(OSGI_ERROR.replace("<CLASS>", "AlternateContent").replace("<XSB>", "alternatecontentelement"));
        }
        int iSizeOfChoiceArray = alternateContent.sizeOfChoiceArray();
        for (int i6 = 0; i6 < iSizeOfChoiceArray; i6++) {
            AlternateContentDocument.AlternateContent.Choice choiceArray = alternateContent.getChoiceArray(i6);
            XmlCursor xmlCursorNewCursor = choiceArray.newCursor();
            try {
                if (MAC_DML_NS.equalsIgnoreCase(xmlCursorNewCursor.namespaceForPrefix(choiceArray.getRequires())) || (xmlCursorSelectProperty = selectProperty(xmlCursorNewCursor, qNameArr, i5, z6, true)) == null || xmlCursorSelectProperty == xmlCursorNewCursor) {
                    xmlCursorNewCursor.close();
                } else {
                    xmlCursorNewCursor.close();
                    return xmlCursorSelectProperty;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor != null) {
                        try {
                            xmlCursorNewCursor.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
        if (!alternateContent.isSetFallback()) {
            return null;
        }
        XmlCursor xmlCursorNewCursor2 = alternateContent.getFallback().newCursor();
        try {
            XmlCursor xmlCursorSelectProperty3 = selectProperty(xmlCursorNewCursor2, qNameArr, i5, z6, true);
            if (xmlCursorSelectProperty3 != xmlCursorNewCursor2) {
            }
            return xmlCursorSelectProperty3;
        } finally {
            if (xmlCursorNewCursor2 != null) {
                xmlCursorNewCursor2.close();
            }
        }
    }
}
