package M3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f472a;
    public static final /* synthetic */ b[] b;
    public static final /* synthetic */ H3.a c;

    static {
        b bVar = new b("CONTINUE", 0);
        f472a = bVar;
        b[] bVarArr = {bVar, new b("SKIP_SUBTREE", 1), new b("TERMINATE", 2)};
        b = bVarArr;
        c = H3.b.enumEntries(bVarArr);
    }

    public static H3.a getEntries() {
        return c;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) b.clone();
    }
}
