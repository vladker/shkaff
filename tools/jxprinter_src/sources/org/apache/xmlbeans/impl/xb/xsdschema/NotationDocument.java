package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface NotationDocument extends XmlObject {
    public static final DocumentFactory<NotationDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Notation extends Annotated {
        public static final ElementFactory<Notation> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Notation> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "notation8b1felemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        String getName();

        String getPublic();

        String getSystem();

        boolean isSetPublic();

        boolean isSetSystem();

        void setName(String str);

        void setPublic(String str);

        void setSystem(String str);

        void unsetPublic();

        void unsetSystem();

        XmlNCName xgetName();

        Public xgetPublic();

        XmlAnyURI xgetSystem();

        void xsetName(XmlNCName xmlNCName);

        void xsetPublic(Public r6);

        void xsetSystem(XmlAnyURI xmlAnyURI);
    }

    static {
        DocumentFactory<NotationDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "notation3381doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Notation addNewNotation();

    Notation getNotation();

    void setNotation(Notation notation);
}
