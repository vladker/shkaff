package org.apache.poi.ddf;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BLIP_EMF' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherRecordTypes {
    private static final /* synthetic */ EscherRecordTypes[] $VALUES;
    public static final EscherRecordTypes ALIGN_RULE;
    public static final EscherRecordTypes ANCHOR;
    public static final EscherRecordTypes ARC_RULE;
    public static final EscherRecordTypes BLIP_DIB;
    public static final EscherRecordTypes BLIP_EMF;
    public static final EscherRecordTypes BLIP_END;
    public static final EscherRecordTypes BLIP_JPEG;
    public static final EscherRecordTypes BLIP_PICT;
    public static final EscherRecordTypes BLIP_PNG;
    public static final EscherRecordTypes BLIP_START;
    public static final EscherRecordTypes BLIP_TIFF;
    public static final EscherRecordTypes BLIP_WMF;
    public static final EscherRecordTypes BSE;
    public static final EscherRecordTypes BSTORE_CONTAINER;
    public static final EscherRecordTypes CALLOUT_RULE;
    public static final EscherRecordTypes CHILD_ANCHOR;
    public static final EscherRecordTypes CLIENT_ANCHOR;
    public static final EscherRecordTypes CLIENT_DATA;
    public static final EscherRecordTypes CLIENT_RULE;
    public static final EscherRecordTypes CLIENT_TEXTBOX;
    public static final EscherRecordTypes CLSID;
    public static final EscherRecordTypes COLOR_MRU;
    public static final EscherRecordTypes COLOR_SCHEME;
    public static final EscherRecordTypes CONNECTOR_RULE;
    public static final EscherRecordTypes DELETED_PSPL;
    public static final EscherRecordTypes DG;
    public static final EscherRecordTypes DGG;
    public static final EscherRecordTypes DGG_CONTAINER;
    public static final EscherRecordTypes DG_CONTAINER;
    private static final Map<Short, EscherRecordTypes> LOOKUP;
    public static final EscherRecordTypes OLE_OBJECT;
    public static final EscherRecordTypes OPT;
    public static final EscherRecordTypes REGROUP_ITEMS;
    public static final EscherRecordTypes SELECTION;
    public static final EscherRecordTypes SOLVER_CONTAINER;
    public static final EscherRecordTypes SP;
    public static final EscherRecordTypes SPGR;
    public static final EscherRecordTypes SPGR_CONTAINER;
    public static final EscherRecordTypes SPLIT_MENU_COLORS;
    public static final EscherRecordTypes SP_CONTAINER;
    public static final EscherRecordTypes TEXTBOX;
    public static final EscherRecordTypes UNKNOWN;
    public static final EscherRecordTypes USER_DEFINED;
    public final Supplier<? extends EscherRecord> constructor;
    public final String description;
    public final String recordName;
    public final short typeID;

    static {
        EscherRecordTypes escherRecordTypes = new EscherRecordTypes("DGG_CONTAINER", 0, 61440, "DggContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        DGG_CONTAINER = escherRecordTypes;
        EscherRecordTypes escherRecordTypes2 = new EscherRecordTypes("BSTORE_CONTAINER", 1, 61441, "BStoreContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        BSTORE_CONTAINER = escherRecordTypes2;
        EscherRecordTypes escherRecordTypes3 = new EscherRecordTypes("DG_CONTAINER", 2, 61442, "DgContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        DG_CONTAINER = escherRecordTypes3;
        EscherRecordTypes escherRecordTypes4 = new EscherRecordTypes("SPGR_CONTAINER", 3, 61443, "SpgrContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        SPGR_CONTAINER = escherRecordTypes4;
        EscherRecordTypes escherRecordTypes5 = new EscherRecordTypes("SP_CONTAINER", 4, 61444, "SpContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        SP_CONTAINER = escherRecordTypes5;
        EscherRecordTypes escherRecordTypes6 = new EscherRecordTypes("SOLVER_CONTAINER", 5, 61445, "SolverContainer", null, new androidx.emoji2.text.flatbuffer.a(4));
        SOLVER_CONTAINER = escherRecordTypes6;
        EscherRecordTypes escherRecordTypes7 = new EscherRecordTypes("DGG", 6, 61446, "Dgg", "MsofbtDgg", new androidx.emoji2.text.flatbuffer.a(8));
        DGG = escherRecordTypes7;
        EscherRecordTypes escherRecordTypes8 = new EscherRecordTypes("BSE", 7, 61447, "BSE", "MsofbtBSE", new androidx.emoji2.text.flatbuffer.a(9));
        BSE = escherRecordTypes8;
        EscherRecordTypes escherRecordTypes9 = new EscherRecordTypes("DG", 8, 61448, "Dg", "MsofbtDg", new androidx.emoji2.text.flatbuffer.a(10));
        DG = escherRecordTypes9;
        EscherRecordTypes escherRecordTypes10 = new EscherRecordTypes("SPGR", 9, 61449, "Spgr", "MsofbtSpgr", new androidx.emoji2.text.flatbuffer.a(11));
        SPGR = escherRecordTypes10;
        EscherRecordTypes escherRecordTypes11 = new EscherRecordTypes("SP", 10, 61450, "Sp", "MsofbtSp", new androidx.emoji2.text.flatbuffer.a(7));
        SP = escherRecordTypes11;
        EscherRecordTypes escherRecordTypes12 = new EscherRecordTypes("OPT", 11, 61451, "Opt", "msofbtOPT", new androidx.emoji2.text.flatbuffer.a(12));
        OPT = escherRecordTypes12;
        EscherRecordTypes escherRecordTypes13 = new EscherRecordTypes("TEXTBOX", 12, 61452, null, null, new androidx.emoji2.text.flatbuffer.a(13));
        TEXTBOX = escherRecordTypes13;
        EscherRecordTypes escherRecordTypes14 = new EscherRecordTypes("CLIENT_TEXTBOX", 13, 61453, "ClientTextbox", "msofbtClientTextbox", new androidx.emoji2.text.flatbuffer.a(13));
        CLIENT_TEXTBOX = escherRecordTypes14;
        EscherRecordTypes escherRecordTypes15 = new EscherRecordTypes("ANCHOR", 14, 61454, null, null, null);
        ANCHOR = escherRecordTypes15;
        EscherRecordTypes escherRecordTypes16 = new EscherRecordTypes("CHILD_ANCHOR", 15, 61455, "ChildAnchor", "MsofbtChildAnchor", new androidx.emoji2.text.flatbuffer.a(14));
        CHILD_ANCHOR = escherRecordTypes16;
        EscherRecordTypes escherRecordTypes17 = new EscherRecordTypes("CLIENT_ANCHOR", 16, 61456, "ClientAnchor", "MsofbtClientAnchor", new androidx.emoji2.text.flatbuffer.a(15));
        CLIENT_ANCHOR = escherRecordTypes17;
        EscherRecordTypes escherRecordTypes18 = new EscherRecordTypes("CLIENT_DATA", 17, 61457, "ClientData", "MsofbtClientData", new androidx.emoji2.text.flatbuffer.a(16));
        CLIENT_DATA = escherRecordTypes18;
        EscherRecordTypes escherRecordTypes19 = new EscherRecordTypes("CONNECTOR_RULE", 18, 61458, null, null, null);
        CONNECTOR_RULE = escherRecordTypes19;
        EscherRecordTypes escherRecordTypes20 = new EscherRecordTypes("ALIGN_RULE", 19, 61459, null, null, null);
        ALIGN_RULE = escherRecordTypes20;
        EscherRecordTypes escherRecordTypes21 = new EscherRecordTypes("ARC_RULE", 20, 61460, null, null, null);
        ARC_RULE = escherRecordTypes21;
        EscherRecordTypes escherRecordTypes22 = new EscherRecordTypes("CLIENT_RULE", 21, 61461, null, null, null);
        CLIENT_RULE = escherRecordTypes22;
        EscherRecordTypes escherRecordTypes23 = new EscherRecordTypes("CLSID", 22, 61462, null, null, null);
        CLSID = escherRecordTypes23;
        EscherRecordTypes escherRecordTypes24 = new EscherRecordTypes("CALLOUT_RULE", 23, 61463, null, null, null);
        CALLOUT_RULE = escherRecordTypes24;
        EscherRecordTypes escherRecordTypes25 = new EscherRecordTypes("BLIP_START", 24, 61464, "Blip", "msofbtBlip", null);
        BLIP_START = escherRecordTypes25;
        int i5 = 17;
        EscherRecordTypes escherRecordTypes26 = new EscherRecordTypes("BLIP_EMF", 25, 61466, "BlipEmf", null, new androidx.emoji2.text.flatbuffer.a(i5));
        BLIP_EMF = escherRecordTypes26;
        EscherRecordTypes escherRecordTypes27 = new EscherRecordTypes("BLIP_WMF", 26, 61467, "BlipWmf", null, new androidx.emoji2.text.flatbuffer.a(i5));
        BLIP_WMF = escherRecordTypes27;
        EscherRecordTypes escherRecordTypes28 = new EscherRecordTypes("BLIP_PICT", 27, 61468, "BlipPict", null, new androidx.emoji2.text.flatbuffer.a(i5));
        BLIP_PICT = escherRecordTypes28;
        int i6 = 18;
        EscherRecordTypes escherRecordTypes29 = new EscherRecordTypes("BLIP_JPEG", 28, 61469, "BlipJpeg", null, new androidx.emoji2.text.flatbuffer.a(i6));
        BLIP_JPEG = escherRecordTypes29;
        EscherRecordTypes escherRecordTypes30 = new EscherRecordTypes("BLIP_PNG", 29, 61470, "BlipPng", null, new androidx.emoji2.text.flatbuffer.a(i6));
        BLIP_PNG = escherRecordTypes30;
        EscherRecordTypes escherRecordTypes31 = new EscherRecordTypes("BLIP_DIB", 30, 61471, "BlipDib", null, new androidx.emoji2.text.flatbuffer.a(i6));
        BLIP_DIB = escherRecordTypes31;
        EscherRecordTypes escherRecordTypes32 = new EscherRecordTypes("BLIP_TIFF", 31, 61481, "BlipTiff", null, new androidx.emoji2.text.flatbuffer.a(i6));
        BLIP_TIFF = escherRecordTypes32;
        EscherRecordTypes escherRecordTypes33 = new EscherRecordTypes("BLIP_END", 32, 61719, "Blip", "msofbtBlip", null);
        BLIP_END = escherRecordTypes33;
        EscherRecordTypes escherRecordTypes34 = new EscherRecordTypes("REGROUP_ITEMS", 33, 61720, null, null, null);
        REGROUP_ITEMS = escherRecordTypes34;
        EscherRecordTypes escherRecordTypes35 = new EscherRecordTypes("SELECTION", 34, 61721, null, null, null);
        SELECTION = escherRecordTypes35;
        EscherRecordTypes escherRecordTypes36 = new EscherRecordTypes("COLOR_MRU", 35, 61722, null, null, null);
        COLOR_MRU = escherRecordTypes36;
        EscherRecordTypes escherRecordTypes37 = new EscherRecordTypes("DELETED_PSPL", 36, 61725, null, null, null);
        DELETED_PSPL = escherRecordTypes37;
        EscherRecordTypes escherRecordTypes38 = new EscherRecordTypes("SPLIT_MENU_COLORS", 37, 61726, "SplitMenuColors", "MsofbtSplitMenuColors", new androidx.emoji2.text.flatbuffer.a(19));
        SPLIT_MENU_COLORS = escherRecordTypes38;
        EscherRecordTypes escherRecordTypes39 = new EscherRecordTypes("OLE_OBJECT", 38, 61727, null, null, null);
        OLE_OBJECT = escherRecordTypes39;
        EscherRecordTypes escherRecordTypes40 = new EscherRecordTypes("COLOR_SCHEME", 39, 61728, null, null, null);
        COLOR_SCHEME = escherRecordTypes40;
        EscherRecordTypes escherRecordTypes41 = new EscherRecordTypes("USER_DEFINED", 40, 61730, "TertiaryOpt", null, new androidx.emoji2.text.flatbuffer.a(20));
        USER_DEFINED = escherRecordTypes41;
        EscherRecordTypes escherRecordTypes42 = new EscherRecordTypes("UNKNOWN", 41, 65535, EnvironmentCompat.MEDIA_UNKNOWN, EnvironmentCompat.MEDIA_UNKNOWN, new androidx.emoji2.text.flatbuffer.a(6));
        UNKNOWN = escherRecordTypes42;
        $VALUES = new EscherRecordTypes[]{escherRecordTypes, escherRecordTypes2, escherRecordTypes3, escherRecordTypes4, escherRecordTypes5, escherRecordTypes6, escherRecordTypes7, escherRecordTypes8, escherRecordTypes9, escherRecordTypes10, escherRecordTypes11, escherRecordTypes12, escherRecordTypes13, escherRecordTypes14, escherRecordTypes15, escherRecordTypes16, escherRecordTypes17, escherRecordTypes18, escherRecordTypes19, escherRecordTypes20, escherRecordTypes21, escherRecordTypes22, escherRecordTypes23, escherRecordTypes24, escherRecordTypes25, escherRecordTypes26, escherRecordTypes27, escherRecordTypes28, escherRecordTypes29, escherRecordTypes30, escherRecordTypes31, escherRecordTypes32, escherRecordTypes33, escherRecordTypes34, escherRecordTypes35, escherRecordTypes36, escherRecordTypes37, escherRecordTypes38, escherRecordTypes39, escherRecordTypes40, escherRecordTypes41, escherRecordTypes42};
        LOOKUP = (Map) Stream.of((Object[]) values()).collect(Collectors.toMap(new com.google.android.material.color.utilities.g(13), Function.identity()));
    }

    private EscherRecordTypes(String str, int i5, int i6, String str2, String str3, Supplier supplier) {
        super(str, i5);
        this.typeID = (short) i6;
        this.recordName = str2;
        this.description = str3;
        this.constructor = supplier;
    }

    public static EscherRecordTypes forTypeID(int i5) {
        if (i5 == 61482) {
            return BLIP_JPEG;
        }
        EscherRecordTypes escherRecordTypes = LOOKUP.get(Short.valueOf((short) i5));
        return escherRecordTypes != null ? escherRecordTypes : UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Short getTypeId() {
        return Short.valueOf(this.typeID);
    }

    public static EscherRecordTypes valueOf(String str) {
        return (EscherRecordTypes) Enum.valueOf(EscherRecordTypes.class, str);
    }

    public static EscherRecordTypes[] values() {
        return (EscherRecordTypes[]) $VALUES.clone();
    }
}
