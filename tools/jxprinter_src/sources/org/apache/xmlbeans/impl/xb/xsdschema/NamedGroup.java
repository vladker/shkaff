package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface NamedGroup extends RealGroup {
    public static final DocumentFactory<NamedGroup> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface All extends org.apache.xmlbeans.impl.xb.xsdschema.All {
        public static final ElementFactory<All> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<All> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "all82daelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }
    }

    static {
        DocumentFactory<NamedGroup> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "namedgroup878dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Group
    void xsetName(XmlNCName xmlNCName);
}
