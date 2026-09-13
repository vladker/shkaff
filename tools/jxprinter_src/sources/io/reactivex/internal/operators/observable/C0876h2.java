package io.reactivex.internal.operators.observable;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0876h2 extends AbstractC0838a {
    public final /* synthetic */ int b;
    public final long c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0876h2(io.reactivex.G g6, long j6, int i5) {
        super(g6);
        this.b = i5;
        this.c = j6;
    }

    @Override // io.reactivex.B
    public final void b(io.reactivex.I i5) {
        switch (this.b) {
            case 0:
                p033f3.h hVar = new p033f3.h();
                i5.onSubscribe(hVar);
                long j6 = this.c;
                long j7 = LocationRequestCompat.PASSIVE_INTERVAL;
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    j7 = j6 - 1;
                }
                new C0871g2(i5, j7, hVar, this.f5141a).a();
                break;
            case 1:
                this.f5141a.subscribe(new Y(i5, this.c));
                break;
            default:
                this.f5141a.subscribe(new C0852c3(i5, this.c));
                break;
        }
    }
}
