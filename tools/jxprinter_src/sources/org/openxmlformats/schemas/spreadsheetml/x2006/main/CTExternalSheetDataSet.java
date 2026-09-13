package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTExternalSheetDataSet extends XmlObject {
    public static final DocumentFactory<CTExternalSheetDataSet> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTExternalSheetDataSet> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctexternalsheetdataset07adtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExternalSheetData addNewSheetData();

    CTExternalSheetData getSheetDataArray(int i5);

    CTExternalSheetData[] getSheetDataArray();

    List<CTExternalSheetData> getSheetDataList();

    CTExternalSheetData insertNewSheetData(int i5);

    void removeSheetData(int i5);

    void setSheetDataArray(int i5, CTExternalSheetData cTExternalSheetData);

    void setSheetDataArray(CTExternalSheetData[] cTExternalSheetDataArr);

    int sizeOfSheetDataArray();
}
