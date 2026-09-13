package p089p4;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: p4.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC1516a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1516a f7755a;
    public static final EnumC1516a b;
    public static final /* synthetic */ EnumC1516a[] c;
    public static final /* synthetic */ a d;

    static {
        EnumC1516a enumC1516a = new EnumC1516a("NONE", 0);
        f7755a = enumC1516a;
        EnumC1516a enumC1516a2 = new EnumC1516a("ALL_JSON_OBJECTS", 1);
        EnumC1516a enumC1516a3 = new EnumC1516a("POLYMORPHIC", 2);
        b = enumC1516a3;
        EnumC1516a[] enumC1516aArr = {enumC1516a, enumC1516a2, enumC1516a3};
        c = enumC1516aArr;
        d = b.enumEntries(enumC1516aArr);
    }

    public static a getEntries() {
        return d;
    }

    public static EnumC1516a valueOf(String str) {
        return (EnumC1516a) Enum.valueOf(EnumC1516a.class, str);
    }

    public static EnumC1516a[] values() {
        return (EnumC1516a[]) c.clone();
    }
}
