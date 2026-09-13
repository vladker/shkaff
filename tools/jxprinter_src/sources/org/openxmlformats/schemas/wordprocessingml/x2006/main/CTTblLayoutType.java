package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTTblLayoutType extends XmlObject {
    public static final DocumentFactory<CTTblLayoutType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTblLayoutType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttbllayouttype6830type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STTblLayoutType.Enum getType();

    boolean isSetType();

    void setType(STTblLayoutType.Enum r6);

    void unsetType();

    STTblLayoutType xgetType();

    void xsetType(STTblLayoutType sTTblLayoutType);
}
