package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSheetData extends XmlObject {
    public static final DocumentFactory<CTSheetData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheetData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheetdata8408type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTRow addNewRow();

    CTRow getRowArray(int i5);

    CTRow[] getRowArray();

    List<CTRow> getRowList();

    CTRow insertNewRow(int i5);

    void removeRow(int i5);

    void setRowArray(int i5, CTRow cTRow);

    void setRowArray(CTRow[] cTRowArr);

    int sizeOfRowArray();
}
