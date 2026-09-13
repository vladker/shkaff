package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSlideIdList extends XmlObject {
    public static final DocumentFactory<CTSlideIdList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSlideIdList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctslideidlist70a5type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSlideIdListEntry addNewSldId();

    CTSlideIdListEntry getSldIdArray(int i5);

    CTSlideIdListEntry[] getSldIdArray();

    List<CTSlideIdListEntry> getSldIdList();

    CTSlideIdListEntry insertNewSldId(int i5);

    void removeSldId(int i5);

    void setSldIdArray(int i5, CTSlideIdListEntry cTSlideIdListEntry);

    void setSldIdArray(CTSlideIdListEntry[] cTSlideIdListEntryArr);

    int sizeOfSldIdArray();
}
