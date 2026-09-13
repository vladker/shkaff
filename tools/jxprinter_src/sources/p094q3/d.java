package p094q3;

import p043h3.g;
import t5.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f7843a;
    public static final /* synthetic */ d[] b;

    static {
        d dVar = new d("INSTANCE", 0);
        f7843a = dVar;
        b = new d[]{dVar};
    }

    public static void a(c cVar) {
        cVar.onSubscribe(f7843a);
        cVar.onComplete();
    }

    public static void e(Throwable th, c cVar) {
        cVar.onSubscribe(f7843a);
        cVar.onError(th);
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) b.clone();
    }

    @Override // p043h3.f
    public final int c(int i5) {
        return 2;
    }

    @Override // p043h3.j
    public final boolean isEmpty() {
        return true;
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public Object poll() {
        return null;
    }

    @Override // t5.d
    public final void request(long j6) {
        g.f(j6);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "EmptySubscription";
    }

    @Override // p043h3.g, p043h3.f, p043h3.j
    public final boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // t5.d
    public final void cancel() {
    }

    @Override // p043h3.j
    public final void clear() {
    }
}
