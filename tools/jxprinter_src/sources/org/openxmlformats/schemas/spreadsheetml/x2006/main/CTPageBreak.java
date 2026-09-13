package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTPageBreak extends XmlObject {
    public static final DocumentFactory<CTPageBreak> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageBreak> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagebreakeb4ftype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBreak addNewBrk();

    CTBreak getBrkArray(int i5);

    CTBreak[] getBrkArray();

    List<CTBreak> getBrkList();

    long getCount();

    long getManualBreakCount();

    CTBreak insertNewBrk(int i5);

    boolean isSetCount();

    boolean isSetManualBreakCount();

    void removeBrk(int i5);

    void setBrkArray(int i5, CTBreak cTBreak);

    void setBrkArray(CTBreak[] cTBreakArr);

    void setCount(long j6);

    void setManualBreakCount(long j6);

    int sizeOfBrkArray();

    void unsetCount();

    void unsetManualBreakCount();

    XmlUnsignedInt xgetCount();

    XmlUnsignedInt xgetManualBreakCount();

    void xsetCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetManualBreakCount(XmlUnsignedInt xmlUnsignedInt);
}
