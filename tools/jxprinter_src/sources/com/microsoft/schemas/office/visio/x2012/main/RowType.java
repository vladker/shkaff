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
public interface RowType extends XmlObject {
    public static final DocumentFactory<RowType> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<RowType> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "rowtype03d1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CellType addNewCell();

    TriggerType addNewTrigger();

    CellType getCellArray(int i5);

    CellType[] getCellArray();

    List<CellType> getCellList();

    boolean getDel();

    long getIX();

    String getLocalName();

    String getN();

    String getT();

    TriggerType getTriggerArray(int i5);

    TriggerType[] getTriggerArray();

    List<TriggerType> getTriggerList();

    CellType insertNewCell(int i5);

    TriggerType insertNewTrigger(int i5);

    boolean isSetDel();

    boolean isSetIX();

    boolean isSetLocalName();

    boolean isSetN();

    boolean isSetT();

    void removeCell(int i5);

    void removeTrigger(int i5);

    void setCellArray(int i5, CellType cellType);

    void setCellArray(CellType[] cellTypeArr);

    void setDel(boolean z6);

    void setIX(long j6);

    void setLocalName(String str);

    void setN(String str);

    void setT(String str);

    void setTriggerArray(int i5, TriggerType triggerType);

    void setTriggerArray(TriggerType[] triggerTypeArr);

    int sizeOfCellArray();

    int sizeOfTriggerArray();

    void unsetDel();

    void unsetIX();

    void unsetLocalName();

    void unsetN();

    void unsetT();

    XmlBoolean xgetDel();

    XmlUnsignedInt xgetIX();

    XmlString xgetLocalName();

    XmlString xgetN();

    XmlString xgetT();

    void xsetDel(XmlBoolean xmlBoolean);

    void xsetIX(XmlUnsignedInt xmlUnsignedInt);

    void xsetLocalName(XmlString xmlString);

    void xsetN(XmlString xmlString);

    void xsetT(XmlString xmlString);
}
