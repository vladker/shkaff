package p126w0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8801a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ a[] f8802f;

    static {
        a aVar = new a("LOCAL", 0);
        f8801a = aVar;
        a aVar2 = new a("REMOTE", 1);
        b = aVar2;
        a aVar3 = new a("DATA_DISK_CACHE", 2);
        c = aVar3;
        a aVar4 = new a("RESOURCE_DISK_CACHE", 3);
        d = aVar4;
        a aVar5 = new a("MEMORY_CACHE", 4);
        e = aVar5;
        f8802f = new a[]{aVar, aVar2, aVar3, aVar4, aVar5};
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f8802f.clone();
    }
}
