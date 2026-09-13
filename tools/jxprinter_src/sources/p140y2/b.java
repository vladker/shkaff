package p140y2;

import H3.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9032a;
    public static final b b;
    public static final b c;
    public static final /* synthetic */ b[] d;
    public static final /* synthetic */ a e;

    static {
        b bVar = new b("NONE", 0);
        f9032a = bVar;
        b bVar2 = new b("BONDED", 1);
        b = bVar2;
        b bVar3 = new b("CANCEL", 2);
        c = bVar3;
        b[] bVarArr = {bVar, bVar2, bVar3};
        d = bVarArr;
        e = H3.b.enumEntries(bVarArr);
    }

    public static a getEntries() {
        return e;
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) d.clone();
    }
}
