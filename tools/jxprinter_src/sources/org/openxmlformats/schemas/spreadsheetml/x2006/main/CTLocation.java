package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTLocation extends XmlObject {
    public static final DocumentFactory<CTLocation> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLocation> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlocationc23etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    long getColPageCount();

    long getFirstDataCol();

    long getFirstDataRow();

    long getFirstHeaderRow();

    String getRef();

    long getRowPageCount();

    boolean isSetColPageCount();

    boolean isSetRowPageCount();

    void setColPageCount(long j6);

    void setFirstDataCol(long j6);

    void setFirstDataRow(long j6);

    void setFirstHeaderRow(long j6);

    void setRef(String str);

    void setRowPageCount(long j6);

    void unsetColPageCount();

    void unsetRowPageCount();

    XmlUnsignedInt xgetColPageCount();

    XmlUnsignedInt xgetFirstDataCol();

    XmlUnsignedInt xgetFirstDataRow();

    XmlUnsignedInt xgetFirstHeaderRow();

    STRef xgetRef();

    XmlUnsignedInt xgetRowPageCount();

    void xsetColPageCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstDataCol(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstDataRow(XmlUnsignedInt xmlUnsignedInt);

    void xsetFirstHeaderRow(XmlUnsignedInt xmlUnsignedInt);

    void xsetRef(STRef sTRef);

    void xsetRowPageCount(XmlUnsignedInt xmlUnsignedInt);
}
