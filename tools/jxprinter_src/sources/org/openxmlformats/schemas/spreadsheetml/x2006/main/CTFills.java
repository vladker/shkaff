package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFills extends XmlObject {
    public static final DocumentFactory<CTFills> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFills> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctfills2c6ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTFill addNewFill();

    long getCount();

    CTFill getFillArray(int i5);

    CTFill[] getFillArray();

    List<CTFill> getFillList();

    CTFill insertNewFill(int i5);

    boolean isSetCount();

    void removeFill(int i5);

    void setCount(long j6);

    void setFillArray(int i5, CTFill cTFill);

    void setFillArray(CTFill[] cTFillArr);

    int sizeOfFillArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
