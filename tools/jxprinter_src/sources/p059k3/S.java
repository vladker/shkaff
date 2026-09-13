package p059k3;

import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0988v;
import java.util.concurrent.Callable;
import p027e3.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class S extends AbstractC1010a {
    public final o b;
    public final o c;
    public final Callable d;

    public S(AbstractC0985s abstractC0985s, o oVar, o oVar2, Callable callable) {
        super(abstractC0985s);
        this.b = oVar;
        this.c = oVar2;
        this.d = callable;
    }

    @Override // io.reactivex.AbstractC0985s
    public final void a(InterfaceC0988v interfaceC0988v) {
        ((AbstractC0985s) this.f5536a).subscribe(new Q(interfaceC0988v, this.b, this.c, this.d));
    }
}
