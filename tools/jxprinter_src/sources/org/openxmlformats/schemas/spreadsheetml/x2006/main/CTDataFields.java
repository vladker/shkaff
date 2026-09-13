package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDataFields extends XmlObject {
    public static final DocumentFactory<CTDataFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDataFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdatafields52cctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDataField addNewDataField();

    long getCount();

    CTDataField getDataFieldArray(int i5);

    CTDataField[] getDataFieldArray();

    List<CTDataField> getDataFieldList();

    CTDataField insertNewDataField(int i5);

    boolean isSetCount();

    void removeDataField(int i5);

    void setCount(long j6);

    void setDataFieldArray(int i5, CTDataField cTDataField);

    void setDataFieldArray(CTDataField[] cTDataFieldArr);

    int sizeOfDataFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
