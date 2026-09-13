package g4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f4018a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ c[] f4019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ H3.a f4020g;

    static {
        c cVar = new c("CPU_ACQUIRED", 0);
        f4018a = cVar;
        c cVar2 = new c("BLOCKING", 1);
        b = cVar2;
        c cVar3 = new c("PARKING", 2);
        c = cVar3;
        c cVar4 = new c("DORMANT", 3);
        d = cVar4;
        c cVar5 = new c("TERMINATED", 4);
        e = cVar5;
        c[] cVarArr = {cVar, cVar2, cVar3, cVar4, cVar5};
        f4019f = cVarArr;
        f4020g = H3.b.enumEntries(cVarArr);
    }

    public static H3.a getEntries() {
        return f4020g;
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) f4019f.clone();
    }
}
