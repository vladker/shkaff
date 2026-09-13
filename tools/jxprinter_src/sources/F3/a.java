package F3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f265a;
    public static final a b;
    public static final a c;
    public static final /* synthetic */ a[] d;
    public static final /* synthetic */ H3.a e;

    static {
        a aVar = new a("COROUTINE_SUSPENDED", 0);
        f265a = aVar;
        a aVar2 = new a("UNDECIDED", 1);
        b = aVar2;
        a aVar3 = new a("RESUMED", 2);
        c = aVar3;
        a[] aVarArr = {aVar, aVar2, aVar3};
        d = aVarArr;
        e = H3.b.enumEntries(aVarArr);
    }

    public static H3.a getEntries() {
        return e;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) d.clone();
    }
}
