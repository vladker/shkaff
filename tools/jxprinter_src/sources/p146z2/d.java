package p146z2;

import H3.a;
import H3.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9115a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final /* synthetic */ d[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a f9116f;

    static {
        d dVar = new d("None", 0);
        f9115a = dVar;
        d dVar2 = new d("Success", 1);
        b = dVar2;
        d dVar3 = new d("Failed", 2);
        c = dVar3;
        d dVar4 = new d("Deny", 3);
        d = dVar4;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4};
        e = dVarArr;
        f9116f = b.enumEntries(dVarArr);
    }

    public static a getEntries() {
        return f9116f;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) e.clone();
    }
}
