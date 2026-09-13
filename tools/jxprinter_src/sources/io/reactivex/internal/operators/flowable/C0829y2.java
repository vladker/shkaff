package io.reactivex.internal.operators.flowable;

import androidx.core.location.LocationRequestCompat;
import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.y2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0829y2 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final long d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0829y2(AbstractC0979l abstractC0979l, long j6, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = j6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0823x2(cVar, this.d));
                break;
            case 1:
                p094q3.f fVar = new p094q3.f(false);
                cVar.onSubscribe(fVar);
                long j6 = this.d;
                long j7 = LocationRequestCompat.PASSIVE_INTERVAL;
                if (j6 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    j7 = j6 - 1;
                }
                new C0794s3(cVar, j7, fVar, this.b).a();
                break;
            case 2:
                this.b.subscribe((InterfaceC0984q) new C0724g4(cVar, this.d));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new C0807u4(cVar, this.d));
                break;
        }
    }
}
