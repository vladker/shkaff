package V3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f762a;
    public static final u b;
    public static final u c;
    public static final /* synthetic */ u[] d;
    public static final /* synthetic */ H3.a e;

    static {
        u uVar = new u("INVARIANT", 0);
        f762a = uVar;
        u uVar2 = new u("IN", 1);
        b = uVar2;
        u uVar3 = new u("OUT", 2);
        c = uVar3;
        u[] uVarArr = {uVar, uVar2, uVar3};
        d = uVarArr;
        e = H3.b.enumEntries(uVarArr);
    }

    public static H3.a getEntries() {
        return e;
    }

    public static u valueOf(String str) {
        return (u) Enum.valueOf(u.class, str);
    }

    public static u[] values() {
        return (u[]) d.clone();
    }
}
