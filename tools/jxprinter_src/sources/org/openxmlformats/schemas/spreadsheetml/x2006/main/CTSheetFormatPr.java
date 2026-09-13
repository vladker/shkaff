package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSheetFormatPr extends XmlObject {
    public static final DocumentFactory<CTSheetFormatPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheetFormatPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheetformatprdef7type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getBaseColWidth();

    boolean getCustomHeight();

    double getDefaultColWidth();

    double getDefaultRowHeight();

    short getOutlineLevelCol();

    short getOutlineLevelRow();

    boolean getThickBottom();

    boolean getThickTop();

    boolean getZeroHeight();

    boolean isSetBaseColWidth();

    boolean isSetCustomHeight();

    boolean isSetDefaultColWidth();

    boolean isSetOutlineLevelCol();

    boolean isSetOutlineLevelRow();

    boolean isSetThickBottom();

    boolean isSetThickTop();

    boolean isSetZeroHeight();

    void setBaseColWidth(long j6);

    void setCustomHeight(boolean z6);

    void setDefaultColWidth(double d);

    void setDefaultRowHeight(double d);

    void setOutlineLevelCol(short s6);

    void setOutlineLevelRow(short s6);

    void setThickBottom(boolean z6);

    void setThickTop(boolean z6);

    void setZeroHeight(boolean z6);

    void unsetBaseColWidth();

    void unsetCustomHeight();

    void unsetDefaultColWidth();

    void unsetOutlineLevelCol();

    void unsetOutlineLevelRow();

    void unsetThickBottom();

    void unsetThickTop();

    void unsetZeroHeight();

    XmlUnsignedInt xgetBaseColWidth();

    XmlBoolean xgetCustomHeight();

    XmlDouble xgetDefaultColWidth();

    XmlDouble xgetDefaultRowHeight();

    XmlUnsignedByte xgetOutlineLevelCol();

    XmlUnsignedByte xgetOutlineLevelRow();

    XmlBoolean xgetThickBottom();

    XmlBoolean xgetThickTop();

    XmlBoolean xgetZeroHeight();

    void xsetBaseColWidth(XmlUnsignedInt xmlUnsignedInt);

    void xsetCustomHeight(XmlBoolean xmlBoolean);

    void xsetDefaultColWidth(XmlDouble xmlDouble);

    void xsetDefaultRowHeight(XmlDouble xmlDouble);

    void xsetOutlineLevelCol(XmlUnsignedByte xmlUnsignedByte);

    void xsetOutlineLevelRow(XmlUnsignedByte xmlUnsignedByte);

    void xsetThickBottom(XmlBoolean xmlBoolean);

    void xsetThickTop(XmlBoolean xmlBoolean);

    void xsetZeroHeight(XmlBoolean xmlBoolean);
}
