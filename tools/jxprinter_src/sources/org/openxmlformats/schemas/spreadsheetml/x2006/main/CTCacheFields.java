package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCacheFields extends XmlObject {
    public static final DocumentFactory<CTCacheFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCacheFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcachefieldsf5fatype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCacheField addNewCacheField();

    CTCacheField getCacheFieldArray(int i5);

    CTCacheField[] getCacheFieldArray();

    List<CTCacheField> getCacheFieldList();

    long getCount();

    CTCacheField insertNewCacheField(int i5);

    boolean isSetCount();

    void removeCacheField(int i5);

    void setCacheFieldArray(int i5, CTCacheField cTCacheField);

    void setCacheFieldArray(CTCacheField[] cTCacheFieldArr);

    void setCount(long j6);

    int sizeOfCacheFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
