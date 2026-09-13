package M3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f483a;
    public static final p b;
    public static final p c;
    public static final /* synthetic */ p[] d;
    public static final /* synthetic */ H3.a e;

    static {
        p pVar = new p("INCLUDE_DIRECTORIES", 0);
        f483a = pVar;
        p pVar2 = new p("BREADTH_FIRST", 1);
        b = pVar2;
        p pVar3 = new p("FOLLOW_LINKS", 2);
        c = pVar3;
        p[] pVarArr = {pVar, pVar2, pVar3};
        d = pVarArr;
        e = H3.b.enumEntries(pVarArr);
    }

    public static H3.a getEntries() {
        return e;
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) d.clone();
    }
}
