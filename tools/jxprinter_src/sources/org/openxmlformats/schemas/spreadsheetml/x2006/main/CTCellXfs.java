package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCellXfs extends XmlObject {
    public static final DocumentFactory<CTCellXfs> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCellXfs> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcellxfs1322type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTXf addNewXf();

    long getCount();

    CTXf getXfArray(int i5);

    CTXf[] getXfArray();

    List<CTXf> getXfList();

    CTXf insertNewXf(int i5);

    boolean isSetCount();

    void removeXf(int i5);

    void setCount(long j6);

    void setXfArray(int i5, CTXf cTXf);

    void setXfArray(CTXf[] cTXfArr);

    int sizeOfXfArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
