package org.jsoup.nodes;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f7477a;
    public static final n b;
    public static final n c;
    public static final /* synthetic */ n[] d;

    static {
        n nVar = new n("ascii", 0);
        f7477a = nVar;
        n nVar2 = new n("utf", 1);
        b = nVar2;
        n nVar3 = new n("fallback", 2);
        c = nVar3;
        d = new n[]{nVar, nVar2, nVar3};
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) d.clone();
    }
}
