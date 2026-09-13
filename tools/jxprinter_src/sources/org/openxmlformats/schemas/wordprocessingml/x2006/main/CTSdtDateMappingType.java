package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSdtDateMappingType extends XmlObject {
    public static final DocumentFactory<CTSdtDateMappingType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSdtDateMappingType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsdtdatemappingtype5fb1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STSdtDateMappingType.Enum getVal();

    boolean isSetVal();

    void setVal(STSdtDateMappingType.Enum r6);

    void unsetVal();

    STSdtDateMappingType xgetVal();

    void xsetVal(STSdtDateMappingType sTSdtDateMappingType);
}
