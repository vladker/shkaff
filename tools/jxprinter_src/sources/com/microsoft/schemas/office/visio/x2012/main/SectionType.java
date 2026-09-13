package com.microsoft.schemas.office.visio.x2012.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface SectionType extends XmlObject {
    public static final DocumentFactory<SectionType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<SectionType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "sectiontype30a6type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CellType addNewCell();

    RowType addNewRow();

    TriggerType addNewTrigger();

    CellType getCellArray(int i5);

    CellType[] getCellArray();

    List<CellType> getCellList();

    boolean getDel();

    long getIX();

    String getN();

    RowType getRowArray(int i5);

    RowType[] getRowArray();

    List<RowType> getRowList();

    TriggerType getTriggerArray(int i5);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i5);

    RowType insertNewRow(int i5);

    TriggerType insertNewTrigger(int i5);

    boolean isSetDel();

    boolean isSetIX();

    void removeCell(int i5);

    void removeRow(int i5);

    void removeTrigger(int i5);

    void setCellArray(int i5, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setDel(boolean z6);

    void setIX(long j6);

    void setN(String str);

    void setRowArray(int i5, RowType rowType);

    void setRowArray(RowType[] rowTypeArr);

    void setTriggerArray(int i5, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfRowArray();

    int sizeOfTriggerArray();

    void unsetDel();

    void unsetIX();

    XmlBoolean xgetDel();

    XmlUnsignedInt xgetIX();

    XmlString xgetN();

    void xsetDel(XmlBoolean xmlBoolean);

    void xsetIX(XmlUnsignedInt xmlUnsignedInt);

    void xsetN(XmlString xmlString);
}
