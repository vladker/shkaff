package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import io.reactivex.N;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: k3.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1040q extends AbstractC1010a {
    public final long b;
    public final TimeUnit c;
    public final N d;

    public C1040q(AbstractC0985s abstractC0985s, long j6, TimeUnit timeUnit, N n6) {
        super(abstractC0985s);
        this.b = j6;
        this.c = timeUnit;
        this.d = n6;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        ((AbstractC0985s) this.f5536a).subscribe(new RunnableC1039p(interfaceC0988v, this.b, this.c, this.d));
    }
}
