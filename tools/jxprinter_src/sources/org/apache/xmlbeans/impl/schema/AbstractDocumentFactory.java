package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class AbstractDocumentFactory<T> extends ElementFactory<T> {
    public AbstractDocumentFactory(SchemaTypeSystem schemaTypeSystem, String str) {
        super(schemaTypeSystem, str);
    }

    public T parse(String str) {
        return (T) getTypeLoader().parse(str, getType(), (XmlOptions) null);
    }

    public T parse(String str, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(str, getType(), xmlOptions);
    }

    public T parse(File file) {
        return (T) getTypeLoader().parse(file, getType(), (XmlOptions) null);
    }

    public T parse(File file, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(file, getType(), xmlOptions);
    }

    public T parse(URL url) {
        return (T) getTypeLoader().parse(url, getType(), (XmlOptions) null);
    }

    public T parse(URL url, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(url, getType(), xmlOptions);
    }

    public T parse(InputStream inputStream) {
        return (T) getTypeLoader().parse(inputStream, getType(), (XmlOptions) null);
    }

    public T parse(InputStream inputStream, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(inputStream, getType(), xmlOptions);
    }

    public T parse(Reader reader) {
        return (T) getTypeLoader().parse(reader, getType(), (XmlOptions) null);
    }

    public T parse(Reader reader, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(reader, getType(), xmlOptions);
    }

    public T parse(XMLStreamReader xMLStreamReader) {
        return (T) getTypeLoader().parse(xMLStreamReader, getType(), (XmlOptions) null);
    }

    public T parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(xMLStreamReader, getType(), xmlOptions);
    }

    public T parse(Node node) {
        return (T) getTypeLoader().parse(node, getType(), (XmlOptions) null);
    }

    public T parse(Node node, XmlOptions xmlOptions) {
        return (T) getTypeLoader().parse(node, getType(), xmlOptions);
    }
}
