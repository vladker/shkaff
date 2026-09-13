package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTSst extends XmlObject {
    public static final DocumentFactory<CTSst> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSst> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsst44f3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTRst addNewSi();

    long getCount();

    CTExtensionList getExtLst();

    CTRst getSiArray(int i5);

    CTRst[] getSiArray();

    List<CTRst> getSiList();

    long getUniqueCount();

    CTRst insertNewSi(int i5);

    boolean isSetCount();

    boolean isSetExtLst();

    boolean isSetUniqueCount();

    void removeSi(int i5);

    void setCount(long j6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSiArray(int i5, CTRst cTRst);

    void setSiArray(CTRst[] cTRstArr);

    void setUniqueCount(long j6);

    int sizeOfSiArray();

    void unsetCount();

    void unsetExtLst();

    void unsetUniqueCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetUniqueCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetUniqueCount(XmlUnsignedInt xmlUnsignedInt);
}
