package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.ss.util.CellUtil;
import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class STTLTimeNodeSyncType$Enum extends StringEnumAbstractBase {
    static final int INT_CAN_SLIP = 1;
    static final int INT_LOCKED = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTLTimeNodeSyncType$Enum[]{new STTLTimeNodeSyncType$Enum("canSlip", 1), new STTLTimeNodeSyncType$Enum(CellUtil.LOCKED, 2)});

    private STTLTimeNodeSyncType$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STTLTimeNodeSyncType$Enum forInt(int i5) {
        return (STTLTimeNodeSyncType$Enum) table.forInt(i5);
    }

    public static STTLTimeNodeSyncType$Enum forString(String str) {
        return (STTLTimeNodeSyncType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
