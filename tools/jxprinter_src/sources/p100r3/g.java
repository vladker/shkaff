package p100r3;

import androidx.collection.a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f7961a = new f("No further exceptions");

    public static boolean a(AtomicReference atomicReference, Throwable th) {
        while (true) {
            Throwable th2 = (Throwable) atomicReference.get();
            if (th2 == f7961a) {
                return false;
            }
            Throwable cVar = th2 == null ? th : new c(th2, th);
            while (!atomicReference.compareAndSet(th2, cVar)) {
                if (atomicReference.get() != th2) {
                }
            }
            return true;
        }
    }

    public static Throwable b(AtomicReference atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        f fVar = f7961a;
        return th != fVar ? (Throwable) atomicReference.getAndSet(fVar) : th;
    }

    public static String c(long j6, TimeUnit timeUnit) {
        StringBuilder sbT = a.t("The source did not signal an event for ", j6, " ");
        sbT.append(timeUnit.toString().toLowerCase());
        sbT.append(" and has been terminated.");
        return sbT.toString();
    }

    public static RuntimeException d(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th instanceof RuntimeException ? (RuntimeException) th : new RuntimeException(th);
    }

    public static <E extends Throwable> Exception throwIfThrowable(Throwable th) throws Throwable {
        if (th instanceof Exception) {
            return (Exception) th;
        }
        throw th;
    }
}
