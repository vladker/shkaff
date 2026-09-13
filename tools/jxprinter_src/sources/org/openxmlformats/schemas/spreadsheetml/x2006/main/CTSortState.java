package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSortState extends XmlObject {
    public static final DocumentFactory<CTSortState> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSortState> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsortstatea372type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTSortCondition addNewSortCondition();

    boolean getCaseSensitive();

    boolean getColumnSort();

    CTExtensionList getExtLst();

    String getRef();

    CTSortCondition getSortConditionArray(int i5);

    CTSortCondition[] getSortConditionArray();

    List<CTSortCondition> getSortConditionList();

    STSortMethod$Enum getSortMethod();

    CTSortCondition insertNewSortCondition(int i5);

    boolean isSetCaseSensitive();

    boolean isSetColumnSort();

    boolean isSetExtLst();

    boolean isSetSortMethod();

    void removeSortCondition(int i5);

    void setCaseSensitive(boolean z6);

    void setColumnSort(boolean z6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRef(String str);

    void setSortConditionArray(int i5, CTSortCondition cTSortCondition);

    void setSortConditionArray(CTSortCondition[] cTSortConditionArr);

    void setSortMethod(STSortMethod$Enum sTSortMethod$Enum);

    int sizeOfSortConditionArray();

    void unsetCaseSensitive();

    void unsetColumnSort();

    void unsetExtLst();

    void unsetSortMethod();

    XmlBoolean xgetCaseSensitive();

    XmlBoolean xgetColumnSort();

    STRef xgetRef();

    STSortMethod xgetSortMethod();

    void xsetCaseSensitive(XmlBoolean xmlBoolean);

    void xsetColumnSort(XmlBoolean xmlBoolean);

    void xsetRef(STRef sTRef);

    void xsetSortMethod(STSortMethod sTSortMethod);
}
