package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPatternFill extends XmlObject {
    public static final DocumentFactory<CTPatternFill> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPatternFill> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpatternfill7452type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTColor addNewBgColor();

    CTColor addNewFgColor();

    CTColor getBgColor();

    CTColor getFgColor();

    STPatternType.Enum getPatternType();

    boolean isSetBgColor();

    boolean isSetFgColor();

    boolean isSetPatternType();

    void setBgColor(CTColor cTColor);

    void setFgColor(CTColor cTColor);

    void setPatternType(STPatternType.Enum r6);

    void unsetBgColor();

    void unsetFgColor();

    void unsetPatternType();

    STPatternType xgetPatternType();

    void xsetPatternType(STPatternType sTPatternType);
}
