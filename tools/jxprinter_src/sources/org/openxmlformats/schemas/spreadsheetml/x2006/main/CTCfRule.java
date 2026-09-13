package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCfRule extends XmlObject {
    public static final DocumentFactory<CTCfRule> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCfRule> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcfrule3548type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    void addFormula(String str);

    CTColorScale addNewColorScale();

    CTDataBar addNewDataBar();

    CTExtensionList addNewExtLst();

    STFormula addNewFormula();

    CTIconSet addNewIconSet();

    boolean getAboveAverage();

    boolean getBottom();

    CTColorScale getColorScale();

    CTDataBar getDataBar();

    long getDxfId();

    boolean getEqualAverage();

    CTExtensionList getExtLst();

    String getFormulaArray(int i5);

    String[] getFormulaArray();

    List<String> getFormulaList();

    CTIconSet getIconSet();

    STConditionalFormattingOperator.Enum getOperator();

    boolean getPercent();

    int getPriority();

    long getRank();

    int getStdDev();

    boolean getStopIfTrue();

    String getText();

    STTimePeriod.Enum getTimePeriod();

    STCfType.Enum getType();

    void insertFormula(int i5, String str);

    STFormula insertNewFormula(int i5);

    boolean isSetAboveAverage();

    boolean isSetBottom();

    boolean isSetColorScale();

    boolean isSetDataBar();

    boolean isSetDxfId();

    boolean isSetEqualAverage();

    boolean isSetExtLst();

    boolean isSetIconSet();

    boolean isSetOperator();

    boolean isSetPercent();

    boolean isSetRank();

    boolean isSetStdDev();

    boolean isSetStopIfTrue();

    boolean isSetText();

    boolean isSetTimePeriod();

    boolean isSetType();

    void removeFormula(int i5);

    void setAboveAverage(boolean z6);

    void setBottom(boolean z6);

    void setColorScale(CTColorScale cTColorScale);

    void setDataBar(CTDataBar cTDataBar);

    void setDxfId(long j6);

    void setEqualAverage(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFormulaArray(int i5, String str);

    void setFormulaArray(String[] strArr);

    void setIconSet(CTIconSet cTIconSet);

    void setOperator(STConditionalFormattingOperator.Enum r6);

    void setPercent(boolean z6);

    void setPriority(int i5);

    void setRank(long j6);

    void setStdDev(int i5);

    void setStopIfTrue(boolean z6);

    void setText(String str);

    void setTimePeriod(STTimePeriod.Enum r6);

    void setType(STCfType.Enum r6);

    int sizeOfFormulaArray();

    void unsetAboveAverage();

    void unsetBottom();

    void unsetColorScale();

    void unsetDataBar();

    void unsetDxfId();

    void unsetEqualAverage();

    void unsetExtLst();

    void unsetIconSet();

    void unsetOperator();

    void unsetPercent();

    void unsetRank();

    void unsetStdDev();

    void unsetStopIfTrue();

    void unsetText();

    void unsetTimePeriod();

    void unsetType();

    XmlBoolean xgetAboveAverage();

    XmlBoolean xgetBottom();

    STDxfId xgetDxfId();

    XmlBoolean xgetEqualAverage();

    STFormula xgetFormulaArray(int i5);

    STFormula[] xgetFormulaArray();

    List<STFormula> xgetFormulaList();

    STConditionalFormattingOperator xgetOperator();

    XmlBoolean xgetPercent();

    XmlInt xgetPriority();

    XmlUnsignedInt xgetRank();

    XmlInt xgetStdDev();

    XmlBoolean xgetStopIfTrue();

    XmlString xgetText();

    STTimePeriod xgetTimePeriod();

    STCfType xgetType();

    void xsetAboveAverage(XmlBoolean xmlBoolean);

    void xsetBottom(XmlBoolean xmlBoolean);

    void xsetDxfId(STDxfId sTDxfId);

    void xsetEqualAverage(XmlBoolean xmlBoolean);

    void xsetFormulaArray(int i5, STFormula sTFormula);

    void xsetFormulaArray(STFormula[] sTFormulaArr);

    void xsetOperator(STConditionalFormattingOperator sTConditionalFormattingOperator);

    void xsetPercent(XmlBoolean xmlBoolean);

    void xsetPriority(XmlInt xmlInt);

    void xsetRank(XmlUnsignedInt xmlUnsignedInt);

    void xsetStdDev(XmlInt xmlInt);

    void xsetStopIfTrue(XmlBoolean xmlBoolean);

    void xsetText(XmlString xmlString);

    void xsetTimePeriod(STTimePeriod sTTimePeriod);

    void xsetType(STCfType sTCfType);
}
