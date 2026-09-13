package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPivotCacheRecords extends XmlObject {
    public static final DocumentFactory<CTPivotCacheRecords> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPivotCacheRecords> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpivotcacherecords5be1type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTRecord addNewR();

    long getCount();

    CTExtensionList getExtLst();

    CTRecord getRArray(int i5);

    CTRecord[] getRArray();

    List<CTRecord> getRList();

    CTRecord insertNewR(int i5);

    boolean isSetCount();

    boolean isSetExtLst();

    void removeR(int i5);

    void setCount(long j6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRArray(int i5, CTRecord cTRecord);

    void setRArray(CTRecord[] cTRecordArr);

    int sizeOfRArray();

    void unsetCount();

    void unsetExtLst();

    XmlUnsignedInt xgetCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);
}
