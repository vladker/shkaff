package p023d4;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f3867a;
    public static final e2 b;
    public static final e2 c;
    public static final /* synthetic */ e2[] d;
    public static final /* synthetic */ a e;

    static {
        e2 e2Var = new e2("START", 0);
        f3867a = e2Var;
        e2 e2Var2 = new e2("STOP", 1);
        b = e2Var2;
        e2 e2Var3 = new e2("STOP_AND_RESET_REPLAY_CACHE", 2);
        c = e2Var3;
        e2[] e2VarArr = {e2Var, e2Var2, e2Var3};
        d = e2VarArr;
        e = b.enumEntries(e2VarArr);
    }

    public static a getEntries() {
        return e;
    }

    public static e2 valueOf(String str) {
        return (e2) Enum.valueOf(e2.class, str);
    }

    public static e2[] values() {
        return (e2[]) d.clone();
    }
}
