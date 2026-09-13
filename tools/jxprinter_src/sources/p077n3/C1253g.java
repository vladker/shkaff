package p077n3;

import io.reactivex.N;
import io.reactivex.O;
import io.reactivex.S;
import java.util.concurrent.TimeUnit;
import p033f3.h;

/* JADX INFO: renamed from: n3.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1253g extends O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O f6295a;
    public final long b;
    public final TimeUnit c;
    public final N d;
    public final boolean e;

    public C1253g(O o6, long j6, TimeUnit timeUnit, N n6, boolean z6) {
        this.f6295a = o6;
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
        this.e = z6;
    }

    @Override // io.reactivex.O
    public final void subscribeActual(S s6) {
        h hVar = new h();
        s6.onSubscribe(hVar);
        this.f6295a.subscribe(new C1252f(this, hVar, s6));
    }
}
