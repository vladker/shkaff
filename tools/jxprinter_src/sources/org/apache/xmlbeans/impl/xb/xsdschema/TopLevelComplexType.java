package org.apache.xmlbeans.impl.xb.xsdschema;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlNCName;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.metadata.system.sXMLSCHEMA.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TopLevelComplexType extends ComplexType {
    public static final DocumentFactory<TopLevelComplexType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<TopLevelComplexType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "toplevelcomplextypee58atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    String getName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    boolean isSetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void setName(String str);

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void unsetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    XmlNCName xgetName();

    @Override // org.apache.xmlbeans.impl.xb.xsdschema.ComplexType
    void xsetName(XmlNCName xmlNCName);
}
