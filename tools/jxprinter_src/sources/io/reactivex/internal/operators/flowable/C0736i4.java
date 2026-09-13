package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.i4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0736i4 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0736i4(AbstractC0979l abstractC0979l, int i5, int i6) {
        super(abstractC0979l);
        this.c = i6;
        this.d = i5;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0730h4(cVar, this.d));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new C0813v4(cVar, this.d));
                break;
        }
    }
}
