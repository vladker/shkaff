package p056k0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f5468a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final /* synthetic */ m[] e;

    static {
        m mVar = new m("IDLE", 0);
        f5468a = mVar;
        m mVar2 = new m("DOWNLOADING", 1);
        b = mVar2;
        m mVar3 = new m("READY", 2);
        c = mVar3;
        m mVar4 = new m("FAILED", 3);
        d = mVar4;
        e = new m[]{mVar, mVar2, mVar3, mVar4};
    }

    public static m valueOf(String str) {
        return (m) Enum.valueOf(m.class, str);
    }

    public static m[] values() {
        return (m[]) e.clone();
    }
}
