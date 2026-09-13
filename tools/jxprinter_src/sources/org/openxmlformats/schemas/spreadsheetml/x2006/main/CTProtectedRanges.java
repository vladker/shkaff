package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTProtectedRanges extends XmlObject {
    public static final DocumentFactory<CTProtectedRanges> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTProtectedRanges> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctprotectedranges7e83type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTProtectedRange addNewProtectedRange();

    CTProtectedRange getProtectedRangeArray(int i5);

    CTProtectedRange[] getProtectedRangeArray();

    List<CTProtectedRange> getProtectedRangeList();

    CTProtectedRange insertNewProtectedRange(int i5);

    void removeProtectedRange(int i5);

    void setProtectedRangeArray(int i5, CTProtectedRange cTProtectedRange);

    void setProtectedRangeArray(CTProtectedRange[] cTProtectedRangeArr);

    int sizeOfProtectedRangeArray();
}
