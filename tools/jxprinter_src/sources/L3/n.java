package L3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f451a;
    public static final n b;
    public static final /* synthetic */ n[] c;
    public static final /* synthetic */ H3.a d;

    static {
        n nVar = new n("TOP_DOWN", 0);
        f451a = nVar;
        n nVar2 = new n("BOTTOM_UP", 1);
        b = nVar2;
        n[] nVarArr = {nVar, nVar2};
        c = nVarArr;
        d = H3.b.enumEntries(nVarArr);
    }

    public static H3.a getEntries() {
        return d;
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) c.clone();
    }
}
