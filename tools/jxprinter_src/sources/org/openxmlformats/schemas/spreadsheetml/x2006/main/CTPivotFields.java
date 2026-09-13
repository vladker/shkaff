package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotFields extends XmlObject {
    public static final DocumentFactory<CTPivotFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotfields12batype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPivotField addNewPivotField();

    long getCount();

    CTPivotField getPivotFieldArray(int i5);

    CTPivotField[] getPivotFieldArray();

    List<CTPivotField> getPivotFieldList();

    CTPivotField insertNewPivotField(int i5);

    boolean isSetCount();

    void removePivotField(int i5);

    void setCount(long j6);

    void setPivotFieldArray(int i5, CTPivotField cTPivotField);

    void setPivotFieldArray(CTPivotField[] cTPivotFieldArr);

    int sizeOfPivotFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
