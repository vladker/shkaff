package L3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f455a;
    public static final /* synthetic */ x[] b;
    public static final /* synthetic */ H3.a c;

    /* JADX INFO: Fake field, exist only in values array */
    x EF0;

    static {
        x xVar = new x("SKIP", 0);
        x xVar2 = new x("TERMINATE", 1);
        f455a = xVar2;
        x[] xVarArr = {xVar, xVar2};
        b = xVarArr;
        c = H3.b.enumEntries(xVarArr);
    }

    public static H3.a getEntries() {
        return c;
    }

    public static x valueOf(String str) {
        return (x) Enum.valueOf(x.class, str);
    }

    public static x[] values() {
        return (x[]) b.clone();
    }
}
