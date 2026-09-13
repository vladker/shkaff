package V3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ v[] f763a;
    public static final /* synthetic */ H3.a b;

    /* JADX INFO: Fake field, exist only in values array */
    v EF5;

    static {
        v[] vVarArr = {new v("PUBLIC", 0), new v("PROTECTED", 1), new v("INTERNAL", 2), new v("PRIVATE", 3)};
        f763a = vVarArr;
        b = H3.b.enumEntries(vVarArr);
    }

    public static H3.a getEntries() {
        return b;
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) f763a.clone();
    }
}
