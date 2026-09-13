package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class STTLTimeNodeMasterRelation$Enum extends StringEnumAbstractBase {
    static final int INT_LAST_CLICK = 2;
    static final int INT_NEXT_CLICK = 3;
    static final int INT_SAME_CLICK = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STTLTimeNodeMasterRelation$Enum[]{new STTLTimeNodeMasterRelation$Enum("sameClick", 1), new STTLTimeNodeMasterRelation$Enum("lastClick", 2), new STTLTimeNodeMasterRelation$Enum("nextClick", 3)});

    private STTLTimeNodeMasterRelation$Enum(String str, int i5) {
        super(str, i5);
    }

    public static STTLTimeNodeMasterRelation$Enum forInt(int i5) {
        return (STTLTimeNodeMasterRelation$Enum) table.forInt(i5);
    }

    public static STTLTimeNodeMasterRelation$Enum forString(String str) {
        return (STTLTimeNodeMasterRelation$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
