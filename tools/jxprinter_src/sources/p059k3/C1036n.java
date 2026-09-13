package p059k3;

import io.reactivex.InterfaceC0987u;
import io.reactivex.InterfaceC0988v;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.geometry.VectorFormat;
import p011b3.c;
import p027e3.f;
import p033f3.b;
import p033f3.d;

/* JADX INFO: renamed from: k3.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1036n extends AtomicReference implements InterfaceC0987u, c {
    private static final long serialVersionUID = -2467358622224974244L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0988v f5570a;

    public C1036n(InterfaceC0988v interfaceC0988v) {
        this.f5570a = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return d.b((c) get());
    }

    @Override // io.reactivex.InterfaceC0987u
    public final void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        a.onError(th);
    }

    @Override // io.reactivex.InterfaceC0987u
    public final void onSuccess(Object obj) {
        c cVar;
        Object obj2 = get();
        d dVar = d.f3969a;
        if (obj2 == dVar || (cVar = (c) getAndSet(dVar)) == dVar) {
            return;
        }
        InterfaceC0988v interfaceC0988v = this.f5570a;
        try {
            if (obj == null) {
                interfaceC0988v.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                interfaceC0988v.onSuccess(obj);
            }
            if (cVar != null) {
                cVar.dispose();
            }
        } catch (Throwable th) {
            if (cVar != null) {
                cVar.dispose();
            }
            throw th;
        }
    }

    @Override // io.reactivex.InterfaceC0987u
    public final void setCancellable(f fVar) {
        d.d(this, new b(null));
    }

    @Override // io.reactivex.InterfaceC0987u
    public final void setDisposable(c cVar) {
        d.d(this, cVar);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        return androidx.exifinterface.media.a.A(C1036n.class.getSimpleName(), VectorFormat.DEFAULT_PREFIX, super.toString(), VectorFormat.DEFAULT_SUFFIX);
    }

    @Override // io.reactivex.InterfaceC0987u
    public final boolean tryOnError(Throwable th) {
        c cVar;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        Object obj = get();
        d dVar = d.f3969a;
        if (obj == dVar || (cVar = (c) getAndSet(dVar)) == dVar) {
            return false;
        }
        try {
            this.f5570a.onError(th);
        } finally {
            if (cVar != null) {
                cVar.dispose();
            }
        }
    }
}
