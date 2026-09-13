package p077n3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.NoSuchElementException;
import p011b3.c;
import p094q3.g;
import t5.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C implements InterfaceC0984q, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6262a;
    public d b;
    public Object c;
    public boolean d;
    public volatile boolean e;

    public C(S s6) {
        this.f6262a = s6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.e = true;
        this.b.cancel();
    }

    @Override // p011b3.c
    public final boolean e() {
        return this.e;
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.d) {
            return;
        }
        this.d = true;
        Object obj = this.c;
        this.c = null;
        S s6 = this.f6262a;
        if (obj == null) {
            s6.onError(new NoSuchElementException("The source Publisher is empty"));
        } else {
            s6.onSuccess(obj);
        }
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.d) {
            a.onError(th);
            return;
        }
        this.d = true;
        this.c = null;
        this.f6262a.onError(th);
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        if (this.d) {
            return;
        }
        if (this.c == null) {
            this.c = obj;
            return;
        }
        this.b.cancel();
        this.d = true;
        this.c = null;
        this.f6262a.onError(new IndexOutOfBoundsException("Too many elements in the Publisher"));
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.b, dVar)) {
            this.b = dVar;
            this.f6262a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
