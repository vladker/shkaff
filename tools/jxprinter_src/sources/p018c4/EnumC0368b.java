package p018c4;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: c4.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0368b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0368b f1135a;
    public static final EnumC0368b b;
    public static final EnumC0368b c;
    public static final /* synthetic */ EnumC0368b[] d;
    public static final /* synthetic */ a e;

    static {
        EnumC0368b enumC0368b = new EnumC0368b("SUSPEND", 0);
        f1135a = enumC0368b;
        EnumC0368b enumC0368b2 = new EnumC0368b("DROP_OLDEST", 1);
        b = enumC0368b2;
        EnumC0368b enumC0368b3 = new EnumC0368b("DROP_LATEST", 2);
        c = enumC0368b3;
        EnumC0368b[] enumC0368bArr = {enumC0368b, enumC0368b2, enumC0368b3};
        d = enumC0368bArr;
        e = b.enumEntries(enumC0368bArr);
    }

    public static a getEntries() {
        return e;
    }

    public static EnumC0368b valueOf(String str) {
        return (EnumC0368b) Enum.valueOf(EnumC0368b.class, str);
    }

    public static EnumC0368b[] values() {
        return (EnumC0368b[]) d.clone();
    }
}
