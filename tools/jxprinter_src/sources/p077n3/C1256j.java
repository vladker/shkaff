package p077n3;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.InterfaceC0984q;
import io.reactivex.O;
import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicReference;
import p011b3.c;
import p048i3.t;
import p094q3.g;
import t5.d;

/* JADX INFO: renamed from: n3.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1256j extends AtomicReference implements InterfaceC0984q, c {
    private static final long serialVersionUID = -8565274649390031272L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6298a;
    public final O b;
    public boolean c;
    public d d;

    public C1256j(O o6, S s6) {
        this.f6298a = s6;
        this.b = o6;
    }

    @Override // p011b3.c
    public final void dispose() {
        this.d.cancel();
        p033f3.d.a(this);
    }

    @Override // p011b3.c
    public final boolean e() {
        return p033f3.d.b((c) get());
    }

    @Override // t5.c
    public final void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        this.b.subscribe(new t(this, this.f6298a, 0));
    }

    @Override // t5.c
    public final void onError(Throwable th) {
        if (this.c) {
            a.onError(th);
        } else {
            this.c = true;
            this.f6298a.onError(th);
        }
    }

    @Override // t5.c
    public final void onNext(Object obj) {
        this.d.cancel();
        onComplete();
    }

    @Override // io.reactivex.InterfaceC0984q, t5.c
    public final void onSubscribe(d dVar) {
        if (g.g(this.d, dVar)) {
            this.d = dVar;
            this.f6298a.onSubscribe(this);
            dVar.request(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }
}
