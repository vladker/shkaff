package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlBase64Binary extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_base64Binary");

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Factory {
        private Factory() {
        }

        public static XmlBase64Binary newInstance() {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().newInstance(XmlBase64Binary.type, null);
        }

        public static XmlBase64Binary newValue(Object obj) {
            return (XmlBase64Binary) XmlBase64Binary.type.newValue(obj);
        }

        public static XmlBase64Binary parse(String str) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(str, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary newInstance(XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().newInstance(XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(String str, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(str, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(File file) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(file, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(File file, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(file, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(URL url) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(url, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(URL url, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(url, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(InputStream inputStream) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(Reader reader) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(reader, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(reader, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(Node node) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(node, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(Node node, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(node, XmlBase64Binary.type, xmlOptions);
        }

        public static XmlBase64Binary parse(XMLStreamReader xMLStreamReader) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBase64Binary.type, (XmlOptions) null);
        }

        public static XmlBase64Binary parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlBase64Binary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBase64Binary.type, xmlOptions);
        }
    }

    byte[] getByteArrayValue();

    void setByteArrayValue(byte[] bArr);
}
