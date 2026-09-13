package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPatternFillProperties extends XmlObject {
    public static final DocumentFactory<CTPatternFillProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPatternFillProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpatternfillproperties3637type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTColor addNewBgClr();

    CTColor addNewFgClr();

    CTColor getBgClr();

    CTColor getFgClr();

    STPresetPatternVal.Enum getPrst();

    boolean isSetBgClr();

    boolean isSetFgClr();

    boolean isSetPrst();

    void setBgClr(CTColor cTColor);

    void setFgClr(CTColor cTColor);

    void setPrst(STPresetPatternVal.Enum r6);

    void unsetBgClr();

    void unsetFgClr();

    void unsetPrst();

    STPresetPatternVal xgetPrst();

    void xsetPrst(STPresetPatternVal sTPresetPatternVal);
}
