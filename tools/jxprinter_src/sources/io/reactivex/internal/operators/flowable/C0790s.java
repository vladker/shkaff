package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0790s extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final int c;
    public final t5.b d;
    public final Object e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f4761f;

    public C0790s(p022d3.a aVar, int i5, p027e3.g gVar) {
        this.b = 0;
        this.d = aVar;
        this.c = i5;
        this.e = gVar;
        this.f4761f = new AtomicInteger();
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                p022d3.a aVar = (p022d3.a) this.d;
                aVar.subscribe(cVar);
                if (((AtomicInteger) this.f4761f).incrementAndGet() == this.c) {
                    aVar.connect((p027e3.g) this.e);
                }
                break;
            default:
                Y3 y6 = new Y3(cVar, this.c, (p027e3.d) this.f4761f);
                cVar.onSubscribe(y6);
                t5.b bVar = (t5.b) this.e;
                this.d.subscribe(y6.d);
                bVar.subscribe(y6.e);
                break;
        }
    }

    public C0790s(t5.b bVar, t5.b bVar2, p027e3.d dVar, int i5) {
        this.b = 1;
        this.d = bVar;
        this.e = bVar2;
        this.f4761f = dVar;
        this.c = i5;
    }
}
