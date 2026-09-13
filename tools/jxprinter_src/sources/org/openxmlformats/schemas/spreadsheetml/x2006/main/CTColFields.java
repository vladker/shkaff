package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTColFields extends XmlObject {
    public static final DocumentFactory<CTColFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolfields9ab8type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTField addNewField();

    long getCount();

    CTField getFieldArray(int i5);

    CTField[] getFieldArray();

    List<CTField> getFieldList();

    CTField insertNewField(int i5);

    boolean isSetCount();

    void removeField(int i5);

    void setCount(long j6);

    void setFieldArray(int i5, CTField cTField);

    void setFieldArray(CTField[] cTFieldArr);

    int sizeOfFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
