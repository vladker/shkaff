package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTDxfs extends XmlObject {
    public static final DocumentFactory<CTDxfs> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDxfs> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctdxfsb26atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDxf addNewDxf();

    long getCount();

    CTDxf getDxfArray(int i5);

    CTDxf[] getDxfArray();

    List<CTDxf> getDxfList();

    CTDxf insertNewDxf(int i5);

    boolean isSetCount();

    void removeDxf(int i5);

    void setCount(long j6);

    void setDxfArray(int i5, CTDxf cTDxf);

    void setDxfArray(CTDxf[] cTDxfArr);

    int sizeOfDxfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
