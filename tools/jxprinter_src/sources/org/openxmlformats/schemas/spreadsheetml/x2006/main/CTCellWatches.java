package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCellWatches extends XmlObject {
    public static final DocumentFactory<CTCellWatches> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCellWatches> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcellwatches531atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCellWatch addNewCellWatch();

    CTCellWatch getCellWatchArray(int i5);

    CTCellWatch[] getCellWatchArray();

    List<CTCellWatch> getCellWatchList();

    CTCellWatch insertNewCellWatch(int i5);

    void removeCellWatch(int i5);

    void setCellWatchArray(int i5, CTCellWatch cTCellWatch);

    void setCellWatchArray(CTCellWatch[] cTCellWatchArr);

    int sizeOfCellWatchArray();
}
