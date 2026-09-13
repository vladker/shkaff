package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCustomerDataList extends XmlObject {
    public static final DocumentFactory<CTCustomerDataList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomerDataList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomerdatalist8b7ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCustomerData addNewCustData();

    CTTagsData addNewTags();

    CTCustomerData getCustDataArray(int i5);

    CTCustomerData[] getCustDataArray();

    List<CTCustomerData> getCustDataList();

    CTTagsData getTags();

    CTCustomerData insertNewCustData(int i5);

    boolean isSetTags();

    void removeCustData(int i5);

    void setCustDataArray(int i5, CTCustomerData cTCustomerData);

    void setCustDataArray(CTCustomerData[] cTCustomerDataArr);

    void setTags(CTTagsData cTTagsData);

    int sizeOfCustDataArray();

    void unsetTags();
}
