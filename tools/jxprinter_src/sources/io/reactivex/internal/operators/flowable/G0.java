package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class G0 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final long d;
    public final TimeUnit e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final io.reactivex.N f4251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f4252g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G0(int i5, long j6, AbstractC0979l abstractC0979l, io.reactivex.N n6, TimeUnit timeUnit, boolean z6) {
        super(abstractC0979l);
        this.c = i5;
        this.d = j6;
        this.e = timeUnit;
        this.f4251f = n6;
        this.f4252g = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                t5.c cVar2 = this.f4252g ? cVar : new p135x3.c(cVar);
                this.b.subscribe((InterfaceC0984q) new F0(cVar2, this.d, this.e, this.f4251f.createWorker(), this.f4252g));
                break;
            case 1:
                p135x3.c cVar3 = new p135x3.c(cVar);
                boolean z6 = this.f4252g;
                AbstractC0979l abstractC0979l = this.b;
                if (!z6) {
                    abstractC0979l.subscribe((InterfaceC0984q) new U3(cVar3, this.d, this.e, this.f4251f));
                } else {
                    abstractC0979l.subscribe((InterfaceC0984q) new T3(cVar3, this.d, this.e, this.f4251f));
                }
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new C4(cVar, this.d, this.e, this.f4251f.createWorker(), this.f4252g));
                break;
        }
    }
}
