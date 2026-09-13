package com.android.billingclient.api;

import android.os.Build;
import io.reactivex.internal.operators.observable.L2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v1 {
    public static final boolean a(M3.l lVar) {
        for (M3.l parent = lVar.getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getKey() == null || lVar.getKey() == null) {
                try {
                    if (Files.isSameFile(parent.getPath(), lVar.getPath())) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (kotlin.jvm.internal.E.a(parent.getKey(), lVar.getKey())) {
                return true;
            }
        }
        return false;
    }

    public static final Object b(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            kotlin.jvm.internal.E.e(attributes, "readAttributes(...)");
            return attributes.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public static void f(io.reactivex.I i5, AtomicInteger atomicInteger, p100r3.c cVar) {
        if (atomicInteger.getAndIncrement() == 0) {
            cVar.getClass();
            Throwable thB = p100r3.g.b(cVar);
            if (thB != null) {
                i5.onError(thB);
            } else {
                i5.onComplete();
            }
        }
    }

    public static void g(t5.c cVar, AtomicInteger atomicInteger, p100r3.c cVar2) {
        if (atomicInteger.getAndIncrement() == 0) {
            cVar2.getClass();
            Throwable thB = p100r3.g.b(cVar2);
            if (thB != null) {
                cVar.onError(thB);
            } else {
                cVar.onComplete();
            }
        }
    }

    public static void h(io.reactivex.I i5, Throwable th, AtomicInteger atomicInteger, p100r3.c cVar) {
        cVar.getClass();
        if (!p100r3.g.a(cVar, th)) {
            io.reactivex.plugins.a.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            i5.onError(p100r3.g.b(cVar));
        }
    }

    public static void i(t5.c cVar, Throwable th, AtomicInteger atomicInteger, p100r3.c cVar2) {
        cVar2.getClass();
        if (!p100r3.g.a(cVar2, th)) {
            io.reactivex.plugins.a.onError(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            cVar.onError(p100r3.g.b(cVar2));
        }
    }

    public static void j(io.reactivex.I i5, Object obj, AtomicInteger atomicInteger, p100r3.c cVar) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            i5.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                cVar.getClass();
                Throwable thB = p100r3.g.b(cVar);
                if (thB != null) {
                    i5.onError(thB);
                } else {
                    i5.onComplete();
                }
            }
        }
    }

    public static void k(t5.c cVar, Object obj, AtomicInteger atomicInteger, p100r3.c cVar2) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                cVar2.getClass();
                Throwable thB = p100r3.g.b(cVar2);
                if (thB != null) {
                    cVar.onError(thB);
                } else {
                    cVar.onComplete();
                }
            }
        }
    }

    public static boolean l(p027e3.o oVar, io.reactivex.G g6, io.reactivex.I i5) {
        p011b3.c cVar = p033f3.e.f3970a;
        if (!(g6 instanceof Callable)) {
            return false;
        }
        try {
            Object objCall = ((Callable) g6).call();
            if (objCall == null) {
                i5.onSubscribe(cVar);
                i5.onComplete();
                return true;
            }
            try {
                Object objApply = oVar.apply(objCall);
                p039g3.A.b(objApply, "The mapper returned a null ObservableSource");
                io.reactivex.G g7 = (io.reactivex.G) objApply;
                if (!(g7 instanceof Callable)) {
                    g7.subscribe(i5);
                    return true;
                }
                try {
                    Object objCall2 = ((Callable) g7).call();
                    if (objCall2 == null) {
                        i5.onSubscribe(cVar);
                        i5.onComplete();
                        return true;
                    }
                    L2 l6 = new L2(i5, objCall2);
                    i5.onSubscribe(l6);
                    l6.run();
                    return true;
                } catch (Throwable th) {
                    p017c3.d.throwIfFatal(th);
                    i5.onSubscribe(cVar);
                    i5.onError(th);
                    return true;
                }
            } catch (Throwable th2) {
                p017c3.d.throwIfFatal(th2);
                i5.onSubscribe(cVar);
                i5.onError(th2);
                return true;
            }
        } catch (Throwable th3) {
            p017c3.d.throwIfFatal(th3);
            i5.onSubscribe(cVar);
            i5.onError(th3);
            return true;
        }
    }
}
