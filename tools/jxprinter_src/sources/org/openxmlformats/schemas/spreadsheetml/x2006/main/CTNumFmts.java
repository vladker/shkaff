package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTNumFmts extends XmlObject {
    public static final DocumentFactory<CTNumFmts> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumFmts> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumfmtsb58btype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTNumFmt addNewNumFmt();

    long getCount();

    CTNumFmt getNumFmtArray(int i5);

    CTNumFmt[] getNumFmtArray();

    List<CTNumFmt> getNumFmtList();

    CTNumFmt insertNewNumFmt(int i5);

    boolean isSetCount();

    void removeNumFmt(int i5);

    void setCount(long j6);

    void setNumFmtArray(int i5, CTNumFmt cTNumFmt);

    void setNumFmtArray(CTNumFmt[] cTNumFmtArr);

    int sizeOfNumFmtArray();

    void unsetCount();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
