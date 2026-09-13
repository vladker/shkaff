package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0984q;
import io.reactivex.InterfaceC0988v;
import java.util.Collection;
import p059k3.C1043u;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.t2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0799t2 implements InterfaceC0984q, p011b3.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4777a = 1;
    public t5.d b;
    public final Object c;
    public Object d;

    public C0799t2(InterfaceC0988v interfaceC0988v) {
        this.c = interfaceC0988v;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f4777a) {
            case 0:
                this.b.cancel();
                this.b = p094q3.g.f7849a;
                break;
            case 1:
                this.b.cancel();
                this.b = p094q3.g.f7849a;
                break;
            default:
                this.b.cancel();
                this.b = p094q3.g.f7849a;
                p033f3.d.a((C1043u) this.c);
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f4777a) {
            case 0:
                return this.b == p094q3.g.f7849a;
            case 1:
                return this.b == p094q3.g.f7849a;
            default:
                return p033f3.d.b((p011b3.c) ((C1043u) this.c).get());
        }
    }

    @Override // t5.c
    public final void onComplete() {
        switch (this.f4777a) {
            case 0:
                InterfaceC0988v interfaceC0988v = (InterfaceC0988v) this.c;
                this.b = p094q3.g.f7849a;
                Object obj = this.d;
                if (obj == null) {
                    interfaceC0988v.onComplete();
                } else {
                    this.d = null;
                    interfaceC0988v.onSuccess(obj);
                }
                break;
            case 1:
                this.b = p094q3.g.f7849a;
                ((io.reactivex.S) this.c).onSuccess((Collection) this.d);
                break;
            default:
                t5.d dVar = this.b;
                p094q3.g gVar = p094q3.g.f7849a;
                if (dVar != gVar) {
                    this.b = gVar;
                    io.reactivex.y yVar = (io.reactivex.y) this.d;
                    this.d = null;
                    ((AbstractC0985s) yVar).subscribe((C1043u) this.c);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        switch (this.f4777a) {
            case 0:
                this.b = p094q3.g.f7849a;
                this.d = null;
                ((InterfaceC0988v) this.c).onError(th);
                break;
            case 1:
                this.d = null;
                this.b = p094q3.g.f7849a;
                ((io.reactivex.S) this.c).onError(th);
                break;
            default:
                t5.d dVar = this.b;
                p094q3.g gVar = p094q3.g.f7849a;
                if (dVar == gVar) {
                    io.reactivex.plugins.a.onError(th);
                } else {
                    this.b = gVar;
                    ((C1043u) this.c).f5582a.onError(th);
                }
                break;
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        switch (this.f4777a) {
            case 0:
                this.d = obj;
                break;
            case 1:
                ((Collection) this.d).add(obj);
                break;
            default:
                t5.d dVar = this.b;
                p094q3.g gVar = p094q3.g.f7849a;
                if (dVar != gVar) {
                    dVar.cancel();
                    this.b = gVar;
                    io.reactivex.y yVar = (io.reactivex.y) this.d;
                    this.d = null;
                    ((AbstractC0985s) yVar).subscribe((C1043u) this.c);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(t5.d dVar) {
        switch (this.f4777a) {
            case 0:
                if (p094q3.g.g(this.b, dVar)) {
                    this.b = dVar;
                    ((InterfaceC0988v) this.c).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            case 1:
                if (p094q3.g.g(this.b, dVar)) {
                    this.b = dVar;
                    ((io.reactivex.S) this.c).onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
            default:
                if (p094q3.g.g(this.b, dVar)) {
                    this.b = dVar;
                    ((C1043u) this.c).f5582a.onSubscribe(this);
                    dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
                }
                break;
        }
    }

    public C0799t2(InterfaceC0988v interfaceC0988v, io.reactivex.y yVar) {
        this.c = new C1043u(interfaceC0988v);
        this.d = yVar;
    }

    public C0799t2(io.reactivex.S s6, Collection collection) {
        this.c = s6;
        this.d = collection;
    }
}
