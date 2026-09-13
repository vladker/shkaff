package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalRow extends XmlObject {
    public static final DocumentFactory<CTExternalRow> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalRow> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalrowa22etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalCell addNewCell();

    CTExternalCell getCellArray(int i5);

    CTExternalCell[] getCellArray();

    List<CTExternalCell> getCellList();

    long getR();

    CTExternalCell insertNewCell(int i5);

    void removeCell(int i5);

    void setCellArray(int i5, CTExternalCell cTExternalCell);

    void setCellArray(CTExternalCell[] cTExternalCellArr);

    void setR(long j6);

    int sizeOfCellArray();

    XmlUnsignedInt xgetR();

    void xsetR(XmlUnsignedInt xmlUnsignedInt);
}
