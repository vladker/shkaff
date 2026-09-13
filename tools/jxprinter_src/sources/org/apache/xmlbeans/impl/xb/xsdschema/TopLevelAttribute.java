package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TopLevelAttribute extends Attribute {
    public static final DocumentFactory<TopLevelAttribute> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TopLevelAttribute> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "toplevelattributeb338type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.Attribute
    void xsetName(XmlNCName xmlNCName);
}
