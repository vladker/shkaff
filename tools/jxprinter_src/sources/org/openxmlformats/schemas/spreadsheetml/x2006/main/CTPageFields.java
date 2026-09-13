package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPageFields extends XmlObject {
    public static final DocumentFactory<CTPageFields> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageFields> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagefields1db1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTPageField addNewPageField();

    long getCount();

    CTPageField getPageFieldArray(int i5);

    CTPageField[] getPageFieldArray();

    List<CTPageField> getPageFieldList();

    CTPageField insertNewPageField(int i5);

    boolean isSetCount();

    void removePageField(int i5);

    void setCount(long j6);

    void setPageFieldArray(int i5, CTPageField cTPageField);

    void setPageFieldArray(CTPageField[] cTPageFieldArr);

    int sizeOfPageFieldArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
