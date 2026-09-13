package p002a;

import java.util.concurrent.Callable;
import p027e3.o;
import p039g3.A;
import p094q3.e;
import p100r3.d;
import t5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f904a = false;
    public static long b = 3000;
    public static long c = 30000;
    public static int d = 3;
    public static volatile boolean e = true;

    public static void a(d dVar, p011b3.c cVar) {
        if (dVar.getCount() == 0) {
            return;
        }
        try {
            dVar.await();
        } catch (InterruptedException e6) {
            cVar.dispose();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e6);
        }
    }

    public static int b(float f6) {
        return ((int) (((double) f6) + 16384.0d)) - 16384;
    }

    public static boolean c(o oVar, b bVar, t5.c cVar) {
        p094q3.d dVar = p094q3.d.f7843a;
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) bVar).call();
            if (objCall == null) {
                cVar.onSubscribe(dVar);
                cVar.onComplete();
                return true;
            }
            try {
                Object objApply = oVar.apply(objCall);
                A.b(objApply, "The mapper returned a null Publisher");
                b bVar2 = (b) objApply;
                if (!(bVar2 instanceof Callable)) {
                    bVar2.subscribe(cVar);
                    return true;
                }
                try {
                    Object objCall2 = ((Callable) bVar2).call();
                    if (objCall2 != null) {
                        cVar.onSubscribe(new e(objCall2, cVar));
                        return true;
                    }
                    cVar.onSubscribe(dVar);
                    cVar.onComplete();
                    return true;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    cVar.onSubscribe(dVar);
                    cVar.onError(th);
                    return true;
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                cVar.onSubscribe(dVar);
                cVar.onError(th2);
                return true;
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            cVar.onSubscribe(dVar);
            cVar.onError(th3);
            return true;
        }
    }
}
