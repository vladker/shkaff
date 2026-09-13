package p033f3;

import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p017c3.g;
import p039g3.A;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3969a;
    public static final /* synthetic */ d[] b;

    static {
        d dVar = new d("DISPOSED", 0);
        f3969a = dVar;
        b = new d[]{dVar};
    }

    public static boolean a(AtomicReference atomicReference) {
        c cVar;
        c cVar2 = (c) atomicReference.get();
        d dVar = f3969a;
        if (cVar2 == dVar || (cVar = (c) atomicReference.getAndSet(dVar)) == dVar) {
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar.dispose();
        return true;
    }

    public static boolean b(c cVar) {
        return cVar == f3969a;
    }

    public static boolean c(AtomicReference atomicReference, c cVar) {
        while (true) {
            c cVar2 = (c) atomicReference.get();
            if (cVar2 != f3969a) {
                while (!atomicReference.compareAndSet(cVar2, cVar)) {
                    if (atomicReference.get() != cVar2) {
                    }
                }
                return true;
            }
            if (cVar == null) {
                return false;
            }
            cVar.dispose();
            return false;
        }
    }

    public static boolean d(AtomicReference atomicReference, c cVar) {
        while (true) {
            c cVar2 = (c) atomicReference.get();
            if (cVar2 == f3969a) {
                if (cVar == null) {
                    return false;
                }
                cVar.dispose();
                return false;
            }
            do {
                if (atomicReference.compareAndSet(cVar2, cVar)) {
                    if (cVar2 == null) {
                        return true;
                    }
                    cVar2.dispose();
                    return true;
                }
            } while (atomicReference.get() == cVar2);
        }
    }

    public static boolean f(AtomicReference atomicReference, c cVar) {
        A.b(cVar, "d is null");
        while (!atomicReference.compareAndSet(null, cVar)) {
            if (atomicReference.get() != null) {
                cVar.dispose();
                if (atomicReference.get() == f3969a) {
                    return false;
                }
                a.onError(new g("Disposable already set!"));
                return false;
            }
        }
        return true;
    }

    public static boolean g(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.onError(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.dispose();
        a.onError(new g("Disposable already set!"));
        return false;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) b.clone();
    }

    @Override // p011b3.c
    public final boolean e() {
        return true;
    }

    @Override // p011b3.c
    public final void dispose() {
    }
}
