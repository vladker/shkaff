package I0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f330a;
    public static final l b;
    public static final l c;
    public static final l d;
    public static final l e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final l f331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ l[] f332g;

    static {
        l lVar = new l("PENDING", 0);
        f330a = lVar;
        l lVar2 = new l("RUNNING", 1);
        b = lVar2;
        l lVar3 = new l("WAITING_FOR_SIZE", 2);
        c = lVar3;
        l lVar4 = new l("COMPLETE", 3);
        d = lVar4;
        l lVar5 = new l("FAILED", 4);
        e = lVar5;
        l lVar6 = new l("CLEARED", 5);
        f331f = lVar6;
        f332g = new l[]{lVar, lVar2, lVar3, lVar4, lVar5, lVar6};
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) f332g.clone();
    }
}
