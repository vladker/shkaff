package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlSaxHandler;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlObjectFactory<T> extends DocumentFactory<T> {
    private final boolean isAnyType;

    public XmlObjectFactory(String str) {
        this(XmlBeans.getBuiltinTypeSystem(), str);
    }

    private SchemaType getInnerType() {
        if (this.isAnyType) {
            return null;
        }
        return getType();
    }

    public DOMImplementation newDomImplementation() {
        return XmlBeans.getContextTypeLoader().newDomImplementation(null);
    }

    @Override // org.apache.xmlbeans.impl.schema.DocumentFactory, org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance() {
        return (T) XmlBeans.getContextTypeLoader().newInstance(getInnerType(), null);
    }

    public T newValue(Object obj) {
        return (T) getType().newValue(obj);
    }

    public XmlSaxHandler newXmlSaxHandler() {
        return XmlBeans.getContextTypeLoader().newXmlSaxHandler(getInnerType(), null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(String str) {
        return (T) XmlBeans.getContextTypeLoader().parse(str, getInnerType(), (XmlOptions) null);
    }

    public XmlObjectFactory(SchemaTypeSystem schemaTypeSystem, String str) {
        super(schemaTypeSystem, str);
        this.isAnyType = "_BI_anyType".equals(str);
    }

    public DOMImplementation newDomImplementation(XmlOptions xmlOptions) {
        return XmlBeans.getContextTypeLoader().newDomImplementation(xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.DocumentFactory, org.apache.xmlbeans.impl.schema.ElementFactory
    public T newInstance(XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().newInstance(getInnerType(), xmlOptions);
    }

    public XmlSaxHandler newXmlSaxHandler(XmlOptions xmlOptions) {
        return XmlBeans.getContextTypeLoader().newXmlSaxHandler(getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(String str, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(str, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(File file) {
        return (T) XmlBeans.getContextTypeLoader().parse(file, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(File file, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(file, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(URL url) {
        return (T) XmlBeans.getContextTypeLoader().parse(url, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(URL url, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(url, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(InputStream inputStream) {
        return (T) XmlBeans.getContextTypeLoader().parse(inputStream, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(XMLStreamReader xMLStreamReader) {
        return (T) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(InputStream inputStream, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(inputStream, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(Reader reader) {
        return (T) XmlBeans.getContextTypeLoader().parse(reader, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(Reader reader, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(reader, getInnerType(), xmlOptions);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(Node node) {
        return (T) XmlBeans.getContextTypeLoader().parse(node, getInnerType(), (XmlOptions) null);
    }

    @Override // org.apache.xmlbeans.impl.schema.AbstractDocumentFactory
    public T parse(Node node, XmlOptions xmlOptions) {
        return (T) XmlBeans.getContextTypeLoader().parse(node, getInnerType(), xmlOptions);
    }
}
