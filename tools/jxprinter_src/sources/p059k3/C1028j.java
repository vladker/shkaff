package p059k3;

import io.reactivex.InterfaceC0988v;
import io.reactivex.S;
import java.util.NoSuchElementException;
import p011b3.c;
import p033f3.d;
import p039g3.A;

/* JADX INFO: renamed from: k3.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1028j implements InterfaceC0988v, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5563a;
    public final S b;
    public final Object c;
    public c d;

    public /* synthetic */ C1028j(S s6, Object obj, int i5) {
        this.f5563a = i5;
        this.b = s6;
        this.c = obj;
    }

    @Override // p011b3.c
    public final void dispose() {
        switch (this.f5563a) {
            case 0:
                this.d.dispose();
                this.d = d.f3969a;
                break;
            default:
                this.d.dispose();
                this.d = d.f3969a;
                break;
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        switch (this.f5563a) {
            case 0:
                break;
        }
        return this.d.e();
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onComplete() {
        switch (this.f5563a) {
            case 0:
                this.d = d.f3969a;
                this.b.onSuccess(Boolean.FALSE);
                break;
            default:
                this.d = d.f3969a;
                S s6 = this.b;
                Object obj = this.c;
                if (obj == null) {
                    s6.onError(new NoSuchElementException("The MaybeSource is empty"));
                } else {
                    s6.onSuccess(obj);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onError(Throwable th) {
        switch (this.f5563a) {
            case 0:
                this.d = d.f3969a;
                this.b.onError(th);
                break;
            default:
                this.d = d.f3969a;
                this.b.onError(th);
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSubscribe(c cVar) {
        switch (this.f5563a) {
            case 0:
                if (d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
            default:
                if (d.g(this.d, cVar)) {
                    this.d = cVar;
                    this.b.onSubscribe(this);
                }
                break;
        }
    }

    @Override // io.reactivex.InterfaceC0988v
    public final void onSuccess(Object obj) {
        switch (this.f5563a) {
            case 0:
                this.d = d.f3969a;
                this.b.onSuccess(Boolean.valueOf(A.a(obj, this.c)));
                break;
            default:
                this.d = d.f3969a;
                this.b.onSuccess(obj);
                break;
        }
    }
}
