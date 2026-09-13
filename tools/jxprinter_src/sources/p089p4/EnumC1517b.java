package p089p4;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: p4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC1517b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1517b f7756a;
    public static final EnumC1517b b;
    public static final /* synthetic */ EnumC1517b[] c;
    public static final /* synthetic */ a d;

    static {
        EnumC1517b enumC1517b = new EnumC1517b("WHITESPACE_SEPARATED", 0);
        f7756a = enumC1517b;
        EnumC1517b enumC1517b2 = new EnumC1517b("ARRAY_WRAPPED", 1);
        b = enumC1517b2;
        EnumC1517b[] enumC1517bArr = {enumC1517b, enumC1517b2, new EnumC1517b("AUTO_DETECT", 2)};
        c = enumC1517bArr;
        d = b.enumEntries(enumC1517bArr);
    }

    public static a getEntries() {
        return d;
    }

    public static EnumC1517b valueOf(String str) {
        return (EnumC1517b) Enum.valueOf(EnumC1517b.class, str);
    }

    public static EnumC1517b[] values() {
        return (EnumC1517b[]) c.clone();
    }
}
