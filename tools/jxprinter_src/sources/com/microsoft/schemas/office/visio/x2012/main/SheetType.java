package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.AbstractDocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface SheetType extends XmlObject {
    public static final AbstractDocumentFactory<SheetType> Factory;
    public static final SchemaType type;

    static {
        AbstractDocumentFactory<SheetType> abstractDocumentFactory = new AbstractDocumentFactory<>(TypeSystemHolder.typeSystem, "sheettype25actype");
        Factory = abstractDocumentFactory;
        type = abstractDocumentFactory.getType();
    }

    CellType addNewCell();

    SectionType addNewSection();

    TriggerType addNewTrigger();

    CellType getCellArray(int i5);

    CellType[] getCellArray();

    List<CellType> getCellList();

    long getFillStyle();

    long getLineStyle();

    SectionType getSectionArray(int i5);

    SectionType[] getSectionArray();

    List<SectionType> getSectionList();

    long getTextStyle();

    TriggerType getTriggerArray(int i5);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i5);

    SectionType insertNewSection(int i5);

    TriggerType insertNewTrigger(int i5);

    boolean isSetFillStyle();

    boolean isSetLineStyle();

    boolean isSetTextStyle();

    void removeCell(int i5);

    void removeSection(int i5);

    void removeTrigger(int i5);

    void setCellArray(int i5, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setFillStyle(long j6);

    void setLineStyle(long j6);

    void setSectionArray(int i5, SectionType sectionType);

    void setSectionArray(SectionType[] sectionTypeArr);

    void setTextStyle(long j6);

    void setTriggerArray(int i5, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfSectionArray();

    int sizeOfTriggerArray();

    void unsetFillStyle();

    void unsetLineStyle();

    void unsetTextStyle();

    XmlUnsignedInt xgetFillStyle();

    XmlUnsignedInt xgetLineStyle();

    XmlUnsignedInt xgetTextStyle();

    void xsetFillStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetLineStyle(XmlUnsignedInt xmlUnsignedInt);

    void xsetTextStyle(XmlUnsignedInt xmlUnsignedInt);
}
