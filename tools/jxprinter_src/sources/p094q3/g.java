package p094q3;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p039g3.A;
import p122v2.a;
import t5.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f7849a;
    public static final /* synthetic */ g[] b;

    static {
        g gVar = new g("CANCELLED", 0);
        f7849a = gVar;
        b = new g[]{gVar};
    }

    public static boolean a(AtomicReference atomicReference) {
        d dVar;
        d dVar2 = (d) atomicReference.get();
        g gVar = f7849a;
        if (dVar2 == gVar || (dVar = (d) atomicReference.getAndSet(gVar)) == gVar) {
            return false;
        }
        if (dVar == null) {
            return true;
        }
        dVar.cancel();
        return true;
    }

    public static void b(AtomicReference atomicReference, AtomicLong atomicLong, long j6) {
        d dVar = (d) atomicReference.get();
        if (dVar != null) {
            dVar.request(j6);
            return;
        }
        if (f(j6)) {
            a.a(atomicLong, j6);
            d dVar2 = (d) atomicReference.get();
            if (dVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    dVar2.request(andSet);
                }
            }
        }
    }

    public static void c(AtomicReference atomicReference, AtomicLong atomicLong, d dVar) {
        if (e(atomicReference, dVar)) {
            long andSet = atomicLong.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
        }
    }

    public static void d(AtomicReference atomicReference, d dVar, long j6) {
        if (e(atomicReference, dVar)) {
            dVar.request(j6);
        }
    }

    public static boolean e(AtomicReference atomicReference, d dVar) {
        A.b(dVar, "s is null");
        while (!atomicReference.compareAndSet(null, dVar)) {
            if (atomicReference.get() != null) {
                dVar.cancel();
                if (atomicReference.get() == f7849a) {
                    return false;
                }
                io.reactivex.plugins.a.onError(new p017c3.g("Subscription already set!"));
                return false;
            }
        }
        return true;
    }

    public static boolean f(long j6) {
        if (j6 > 0) {
            return true;
        }
        io.reactivex.plugins.a.onError(new IllegalArgumentException(androidx.collection.a.j(j6, "n > 0 required but it was ")));
        return false;
    }

    public static boolean g(d dVar, d dVar2) {
        if (dVar2 == null) {
            io.reactivex.plugins.a.onError(new NullPointerException("next is null"));
            return false;
        }
        if (dVar == null) {
            return true;
        }
        dVar2.cancel();
        io.reactivex.plugins.a.onError(new p017c3.g("Subscription already set!"));
        return false;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) b.clone();
    }

    @Override // t5.d
    public final void cancel() {
    }

    @Override // t5.d
    public final void request(long j6) {
    }
}
