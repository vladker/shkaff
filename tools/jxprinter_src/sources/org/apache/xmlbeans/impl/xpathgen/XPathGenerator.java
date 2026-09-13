package org.apache.xmlbeans.impl.xpathgen;

import A3.AbstractC0157z;
import androidx.collection.a;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.NameUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XPathGenerator {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static int countTextTokens(XmlCursor xmlCursor) {
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            xmlCursor.push();
            xmlCursor.toParent();
            XmlCursor.TokenType firstContentToken = xmlCursor.toFirstContentToken();
            int i5 = 0;
            int i6 = 0;
            while (!firstContentToken.isEnd()) {
                if (firstContentToken.isText()) {
                    if (xmlCursor.comparePosition(xmlCursorNewCursor) > 0) {
                        i6++;
                    } else {
                        i5++;
                    }
                } else if (firstContentToken.isStart()) {
                    xmlCursor.toEndToken();
                }
                firstContentToken = xmlCursor.toNextToken();
            }
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            xmlCursor.pop();
            if (i6 == 0) {
                return 0;
            }
            return i5;
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

    private static String generateInternal(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) {
        if (xmlCursor.isStartdoc()) {
            return "";
        }
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return Consts.DOT;
        }
        QName name = xmlCursor.getName();
        XmlCursor xmlCursorNewCursor = xmlCursor.newCursor();
        try {
            if (!xmlCursor.toParent()) {
                String str = PackagingURIHelper.FORWARD_SLASH_STRING + name;
                if (xmlCursorNewCursor != null) {
                    xmlCursorNewCursor.close();
                }
                return str;
            }
            xmlCursor.push();
            if (!xmlCursor.toChild(name)) {
                throw new IllegalStateException("Must have at least one child with name: " + name);
            }
            int i5 = 0;
            int i6 = 1;
            do {
                if (xmlCursor.isAtSamePositionAs(xmlCursorNewCursor)) {
                    i5 = i6;
                } else {
                    i6++;
                }
            } while (xmlCursor.toNextSibling(name));
            xmlCursor.pop();
            if (xmlCursorNewCursor != null) {
                xmlCursorNewCursor.close();
            }
            String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (i6 == 1) {
                return strGenerateInternal + '/' + qnameToString(name, namespaceContext);
            }
            return strGenerateInternal + '/' + qnameToString(name, namespaceContext) + '[' + i5 + ']';
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

    public static String generateXPath(XmlCursor xmlCursor, XmlCursor xmlCursor2, NamespaceContext namespaceContext) throws XPathGenerationException {
        if (xmlCursor == null) {
            throw new IllegalArgumentException("Null node");
        }
        if (namespaceContext == null) {
            throw new IllegalArgumentException("Null namespace context");
        }
        XmlCursor.TokenType tokenTypeCurrentTokenType = xmlCursor.currentTokenType();
        if (xmlCursor2 != null && xmlCursor.isAtSamePositionAs(xmlCursor2)) {
            return Consts.DOT;
        }
        int iIntValue = tokenTypeCurrentTokenType.intValue();
        if (iIntValue == 1 || iIntValue == 3) {
            return generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        }
        if (iIntValue == 5) {
            int iCountTextTokens = countTextTokens(xmlCursor);
            xmlCursor.toParent();
            String strGenerateInternal = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
            if (iCountTextTokens == 0) {
                return a.n(strGenerateInternal, "/text()");
            }
            return strGenerateInternal + "/text()[position()=" + iCountTextTokens + ']';
        }
        if (iIntValue == 6) {
            QName name = xmlCursor.getName();
            xmlCursor.toParent();
            StringBuilder sbX = AbstractC0157z.x(generateInternal(xmlCursor, xmlCursor2, namespaceContext), "/@");
            sbX.append(qnameToString(name, namespaceContext));
            return sbX.toString();
        }
        if (iIntValue != 7) {
            throw new XPathGenerationException("Cannot generate XPath for cursor position: " + tokenTypeCurrentTokenType.toString());
        }
        QName name2 = xmlCursor.getName();
        xmlCursor.toParent();
        String strGenerateInternal2 = generateInternal(xmlCursor, xmlCursor2, namespaceContext);
        String localPart = name2.getLocalPart();
        return localPart.length() == 0 ? a.n(strGenerateInternal2, "/@xmlns") : a.o(strGenerateInternal2, "/@xmlns:", localPart);
    }

    public static void main(String[] strArr) {
        NamespaceContext namespaceContext = new NamespaceContext() { // from class: org.apache.xmlbeans.impl.xpathgen.XPathGenerator.1
            @Override // javax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String str) {
                if ("ns".equals(str)) {
                    return "http://a.com";
                }
                return null;
            }

            @Override // javax.xml.namespace.NamespaceContext
            public String getPrefix(String str) {
                return null;
            }

            @Override // javax.xml.namespace.NamespaceContext
            public Iterator getPrefixes(String str) {
                return null;
            }
        };
        XmlCursor xmlCursorNewCursor = XmlObject.Factory.parse("<root>\n<ns:a xmlns:ns=\"http://a.com\"><b foo=\"value\">text1<c/>text2<c/>text3<c>text</c>text4</b></ns:a>\n</root>").newCursor();
        try {
            xmlCursorNewCursor.toFirstContentToken();
            xmlCursorNewCursor.toFirstContentToken();
            xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.toFirstChild();
            xmlCursorNewCursor.push();
            System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
            xmlCursorNewCursor.pop();
            xmlCursorNewCursor.toNextSibling();
            xmlCursorNewCursor.toNextSibling();
            xmlCursorNewCursor.push();
            System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
            xmlCursorNewCursor.pop();
            XmlCursor xmlCursorNewCursor2 = xmlCursorNewCursor.newCursor();
            try {
                xmlCursorNewCursor2.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor2.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toFirstContentToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toPrevToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toFirstAttribute();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toParent();
                xmlCursorNewCursor.toNextToken();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, xmlCursorNewCursor2, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor2.close();
                xmlCursorNewCursor.push();
                System.out.println(generateXPath(xmlCursorNewCursor, null, namespaceContext));
                xmlCursorNewCursor.pop();
                xmlCursorNewCursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (xmlCursorNewCursor2 != null) {
                        try {
                            xmlCursorNewCursor2.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
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

    private static String qnameToString(QName qName, NamespaceContext namespaceContext) throws XPathGenerationException {
        String localPart = qName.getLocalPart();
        String namespaceURI = qName.getNamespaceURI();
        if (namespaceURI.length() == 0) {
            return localPart;
        }
        String prefix = qName.getPrefix();
        if (prefix != null && prefix.length() > 0 && namespaceURI.equals(namespaceContext.getNamespaceURI(prefix))) {
            return prefix + NameUtil.COLON + localPart;
        }
        String prefix2 = namespaceContext.getPrefix(namespaceURI);
        if (prefix2 == null) {
            throw new XPathGenerationException("Could not obtain a prefix for URI: ".concat(namespaceURI));
        }
        if (prefix2.length() == 0) {
            throw new XPathGenerationException("Can not use default prefix in XPath for URI: ".concat(namespaceURI));
        }
        return prefix2 + NameUtil.COLON + localPart;
    }
}
