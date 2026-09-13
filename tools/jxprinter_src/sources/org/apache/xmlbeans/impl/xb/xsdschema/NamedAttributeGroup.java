package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface NamedAttributeGroup extends AttributeGroup {
    public static final DocumentFactory<NamedAttributeGroup> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<NamedAttributeGroup> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "namedattributegroup2e29type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup
    void xsetName(XmlNCName xmlNCName);
}
