package io.reactivex;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: io.reactivex.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class EnumC0675b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0675b f4175a;
    public static final /* synthetic */ EnumC0675b[] b;

    /* JADX INFO: Fake field, exist only in values array */
    EnumC0675b EF0;

    static {
        EnumC0675b enumC0675b = new EnumC0675b("MISSING", 0);
        EnumC0675b enumC0675b2 = new EnumC0675b("ERROR", 1);
        EnumC0675b enumC0675b3 = new EnumC0675b("BUFFER", 2);
        EnumC0675b enumC0675b4 = new EnumC0675b("DROP", 3);
        EnumC0675b enumC0675b5 = new EnumC0675b("LATEST", 4);
        f4175a = enumC0675b5;
        b = new EnumC0675b[]{enumC0675b, enumC0675b2, enumC0675b3, enumC0675b4, enumC0675b5};
    }

    public static EnumC0675b valueOf(String str) {
        return (EnumC0675b) Enum.valueOf(EnumC0675b.class, str);
    }

    public static EnumC0675b[] values() {
        return (EnumC0675b[]) b.clone();
    }
}
