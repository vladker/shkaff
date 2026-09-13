package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SelectorDocument extends XmlObject {
    public static final DocumentFactory<SelectorDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Selector extends Annotated {
        public static final ElementFactory<Selector> Factory;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Xpath extends XmlToken {
            public static final ElementFactory<Xpath> Factory;
            public static final SchemaType type;

            static {
                ElementFactory<Xpath> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "xpath6f9aattrtype");
                Factory = elementFactory;
                type = elementFactory.getType();
            }
        }

        static {
            ElementFactory<Selector> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "selector233felemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        String getXpath();

        void setXpath(String str);

        Xpath xgetXpath();

        void xsetXpath(Xpath xpath);
    }

    static {
        DocumentFactory<SelectorDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "selectorcb44doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Selector addNewSelector();

    Selector getSelector();

    void setSelector(Selector selector);
}
