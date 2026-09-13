package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTItems extends XmlObject {
    public static final DocumentFactory<CTItems> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTItems> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctitemsecdftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTItem addNewItem();

    long getCount();

    CTItem getItemArray(int i5);

    CTItem[] getItemArray();

    List<CTItem> getItemList();

    CTItem insertNewItem(int i5);

    boolean isSetCount();

    void removeItem(int i5);

    void setCount(long j6);

    void setItemArray(int i5, CTItem cTItem);

    void setItemArray(CTItem[] cTItemArr);

    int sizeOfItemArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
