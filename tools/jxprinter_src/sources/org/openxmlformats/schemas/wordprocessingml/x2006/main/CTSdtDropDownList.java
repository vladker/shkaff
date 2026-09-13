package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSdtDropDownList extends XmlObject {
    public static final DocumentFactory<CTSdtDropDownList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSdtDropDownList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsdtdropdownlist5880type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTSdtListItem addNewListItem();

    String getLastValue();

    CTSdtListItem getListItemArray(int i5);

    CTSdtListItem[] getListItemArray();

    List<CTSdtListItem> getListItemList();

    CTSdtListItem insertNewListItem(int i5);

    boolean isSetLastValue();

    void removeListItem(int i5);

    void setLastValue(String str);

    void setListItemArray(int i5, CTSdtListItem cTSdtListItem);

    void setListItemArray(CTSdtListItem[] cTSdtListItemArr);

    int sizeOfListItemArray();

    void unsetLastValue();

    STString xgetLastValue();

    void xsetLastValue(STString sTString);
}
