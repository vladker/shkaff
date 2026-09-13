package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTBorders extends XmlObject {
    public static final DocumentFactory<CTBorders> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBorders> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctborders0d66type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBorder addNewBorder();

    CTBorder getBorderArray(int i5);

    CTBorder[] getBorderArray();

    List<CTBorder> getBorderList();

    long getCount();

    CTBorder insertNewBorder(int i5);

    boolean isSetCount();

    void removeBorder(int i5);

    void setBorderArray(int i5, CTBorder cTBorder);

    void setBorderArray(CTBorder[] cTBorderArr);

    void setCount(long j6);

    int sizeOfBorderArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
