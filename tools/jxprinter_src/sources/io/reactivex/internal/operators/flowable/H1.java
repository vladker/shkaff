package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H1 extends AbstractC0979l {
    public final /* synthetic */ int b;
    public final t5.b c;

    public /* synthetic */ H1(t5.b bVar, int i5) {
        this.b = i5;
        this.c = bVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.b) {
            case 0:
                this.c.subscribe(cVar);
                break;
            default:
                this.c.subscribe(new C0807u4(cVar, 1L));
                break;
        }
    }
}
