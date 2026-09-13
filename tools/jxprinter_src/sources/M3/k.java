package M3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ k[] f476a;
    public static final /* synthetic */ H3.a b;

    /* JADX INFO: Fake field, exist only in values array */
    k EF5;

    static {
        k[] kVarArr = {new k("SKIP_SUBTREE", 0), new k("TERMINATE", 1)};
        f476a = kVarArr;
        b = H3.b.enumEntries(kVarArr);
    }

    public static H3.a getEntries() {
        return b;
    }

    public static k valueOf(String str) {
        return (k) Enum.valueOf(k.class, str);
    }

    public static k[] values() {
        return (k[]) f476a.clone();
    }
}
