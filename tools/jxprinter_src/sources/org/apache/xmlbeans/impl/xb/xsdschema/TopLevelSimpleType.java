package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TopLevelSimpleType extends SimpleType {
    public static final DocumentFactory<TopLevelSimpleType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TopLevelSimpleType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "toplevelsimpletypec958type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.SimpleType
    void xsetName(XmlNCName xmlNCName);
}
