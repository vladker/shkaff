package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSheets extends XmlObject {
    public static final DocumentFactory<CTSheets> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSheets> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsheets49fdtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSheet addNewSheet();

    CTSheet getSheetArray(int i5);

    CTSheet[] getSheetArray();

    List<CTSheet> getSheetList();

    CTSheet insertNewSheet(int i5);

    void removeSheet(int i5);

    void setSheetArray(int i5, CTSheet cTSheet);

    void setSheetArray(CTSheet[] cTSheetArr);

    int sizeOfSheetArray();
}
