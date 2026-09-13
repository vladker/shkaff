package p071m3;

import io.reactivex.AbstractC0979l;
import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends AbstractC0979l {
    public final b b;
    public final int c;
    public final boolean d;

    public q(b bVar, int i5, boolean z6) {
        this.b = bVar;
        this.c = i5;
        this.d = z6;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(c cVar) {
        boolean z6 = this.d;
        int i5 = this.c;
        b bVar = this.b;
        o pVar = z6 ? new p(cVar, bVar.a(), i5) : new n(cVar, bVar.a(), i5);
        cVar.onSubscribe(pVar);
        bVar.subscribe(pVar.b);
    }
}
