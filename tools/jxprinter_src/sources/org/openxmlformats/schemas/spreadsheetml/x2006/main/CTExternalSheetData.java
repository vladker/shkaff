package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalSheetData extends XmlObject {
    public static final DocumentFactory<CTExternalSheetData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalSheetData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalsheetdatafd3dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalRow addNewRow();

    boolean getRefreshError();

    CTExternalRow getRowArray(int i5);

    CTExternalRow[] getRowArray();

    List<CTExternalRow> getRowList();

    long getSheetId();

    CTExternalRow insertNewRow(int i5);

    boolean isSetRefreshError();

    void removeRow(int i5);

    void setRefreshError(boolean z6);

    void setRowArray(int i5, CTExternalRow cTExternalRow);

    void setRowArray(CTExternalRow[] cTExternalRowArr);

    void setSheetId(long j6);

    int sizeOfRowArray();

    void unsetRefreshError();

    XmlBoolean xgetRefreshError();

    XmlUnsignedInt xgetSheetId();

    void xsetRefreshError(XmlBoolean xmlBoolean);

    void xsetSheetId(XmlUnsignedInt xmlUnsignedInt);
}
