package org.apache.poi.ooxml.util;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.stream.events.Namespace;
import org.apache.poi.util.XMLHelper;
import org.apache.xmlbeans.impl.common.Sax2Dom;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class DocumentHelper {
    private static final DocumentBuilder documentBuilderSingleton = newDocumentBuilder();

    private DocumentHelper() {
    }

    public static void addNamespaceDeclaration(Element element, String str, String str2) {
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", Sax2Dom.XMLNS_STRING + str, str2);
    }

    public static Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    public static DocumentBuilder newDocumentBuilder() {
        return XMLHelper.newDocumentBuilder();
    }

    public static Document readDocument(InputStream inputStream) {
        return newDocumentBuilder().parse(inputStream);
    }

    public static void addNamespaceDeclaration(Element element, Namespace namespace) {
        addNamespaceDeclaration(element, namespace.getPrefix(), namespace.getNamespaceURI());
    }

    public static Document readDocument(InputSource inputSource) {
        return newDocumentBuilder().parse(inputSource);
    }
}
