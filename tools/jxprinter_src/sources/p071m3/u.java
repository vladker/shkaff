package p071m3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p017c3.d;
import p027e3.c;
import p039g3.A;
import p094q3.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends AtomicReference implements InterfaceC0984q {
    private static final long serialVersionUID = -7954444275102466525L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f6159a;
    public final c b;
    public Object c;
    public boolean d;

    public u(v vVar, c cVar) {
        this.f6159a = vVar;
        this.b = cVar;
    }

    @Override // t5.c
    public final void onComplete() {
        int i5;
        if (this.d) {
            return;
        }
        this.d = true;
        Object objApply = this.c;
        v vVar = this.f6159a;
        AtomicReference atomicReference = vVar.e;
        if (objApply != null) {
            while (true) {
                w wVar = (w) atomicReference.get();
                if (wVar == null) {
                    w wVar2 = new w();
                    while (true) {
                        if (atomicReference.compareAndSet(null, wVar2)) {
                            wVar = wVar2;
                        } else if (atomicReference.get() != null) {
                        }
                    }
                }
                do {
                    i5 = wVar.get();
                    if (i5 >= 2) {
                        i5 = -1;
                        break;
                    }
                } while (!wVar.compareAndSet(i5, i5 + 1));
                if (i5 >= 0) {
                    if (i5 == 0) {
                        wVar.f6162a = objApply;
                    } else {
                        wVar.b = objApply;
                    }
                    if (wVar.c.incrementAndGet() == 2) {
                        while (!atomicReference.compareAndSet(wVar, null) && atomicReference.get() == wVar) {
                        }
                    } else {
                        wVar = null;
                    }
                    if (wVar == null) {
                        break;
                    }
                    try {
                        objApply = vVar.d.apply(wVar.f6162a, wVar.b);
                        A.b(objApply, "The reducer returned a null value");
                    } catch (Throwable th) {
                        d.throwIfFatal(th);
                        vVar.a(th);
                        return;
                    }
                } else {
                    while (!atomicReference.compareAndSet(wVar, null) && atomicReference.get() == wVar) {
                    }
                }
            }
        }
        if (vVar.f6160f.decrementAndGet() == 0) {
            w wVar3 = (w) atomicReference.get();
            atomicReference.lazySet(null);
            if (wVar3 != null) {
                vVar.e(wVar3.f6162a);
            } else {
                vVar.f7842a.onComplete();
            }
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            a.onError(th);
        } else {
            this.d = true;
            this.f6159a.a(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        Object obj2 = this.c;
        if (obj2 == null) {
            this.c = obj;
            return;
        }
        try {
            Object objApply = this.b.apply(obj2, obj);
            A.b(objApply, "The reducer returned a null value");
            this.c = objApply;
        } catch (Throwable th) {
            d.throwIfFatal(th);
            ((t5.d) get()).cancel();
            onError(th);
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        g.d(this, dVar, LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
