package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCustomSheetViews extends XmlObject {
    public static final DocumentFactory<CTCustomSheetViews> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomSheetViews> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomsheetviewsc069type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustomSheetView addNewCustomSheetView();

    CTCustomSheetView getCustomSheetViewArray(int i5);

    CTCustomSheetView[] getCustomSheetViewArray();

    List<CTCustomSheetView> getCustomSheetViewList();

    CTCustomSheetView insertNewCustomSheetView(int i5);

    void removeCustomSheetView(int i5);

    void setCustomSheetViewArray(int i5, CTCustomSheetView cTCustomSheetView);

    void setCustomSheetViewArray(CTCustomSheetView[] cTCustomSheetViewArr);

    int sizeOfCustomSheetViewArray();
}
