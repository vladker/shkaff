package p147z3;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: z3.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC1936p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC1936p f9133a;
    public static final /* synthetic */ EnumC1936p[] b;
    public static final /* synthetic */ a c;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC1936p EF0;

    static {
        EnumC1936p enumC1936p = new EnumC1936p("SYNCHRONIZED", 0);
        EnumC1936p enumC1936p2 = new EnumC1936p("PUBLICATION", 1);
        f9133a = enumC1936p2;
        EnumC1936p[] enumC1936pArr = {enumC1936p, enumC1936p2, new EnumC1936p("NONE", 2)};
        b = enumC1936pArr;
        c = b.enumEntries(enumC1936pArr);
    }

    public static a getEntries() {
        return c;
    }

    public static EnumC1936p valueOf(String str) {
        return (EnumC1936p) Enum.valueOf(EnumC1936p.class, str);
    }

    public static EnumC1936p[] values() {
        return (EnumC1936p[]) b.clone();
    }
}
