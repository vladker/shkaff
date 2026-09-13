package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlTokenSource {
    XmlDocumentProperties documentProperties();

    void dump();

    Node getDomNode();

    Object monitor();

    XmlCursor newCursor();

    Node newDomNode();

    Node newDomNode(XmlOptions xmlOptions);

    InputStream newInputStream();

    InputStream newInputStream(XmlOptions xmlOptions);

    Reader newReader();

    Reader newReader(XmlOptions xmlOptions);

    XMLStreamReader newXMLStreamReader();

    XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions);

    void save(File file);

    void save(File file, XmlOptions xmlOptions);

    void save(OutputStream outputStream);

    void save(OutputStream outputStream, XmlOptions xmlOptions);

    void save(Writer writer);

    void save(Writer writer, XmlOptions xmlOptions);

    void save(ContentHandler contentHandler, LexicalHandler lexicalHandler);

    void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions);

    String xmlText();

    String xmlText(XmlOptions xmlOptions);
}
