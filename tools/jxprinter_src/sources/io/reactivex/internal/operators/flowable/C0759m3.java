package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;

/* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.m3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0759m3 extends AbstractC0683a {
    public final /* synthetic */ int c;
    public final p027e3.c d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0759m3(AbstractC0979l abstractC0979l, p027e3.c cVar, int i5) {
        super(abstractC0979l);
        this.c = i5;
        this.d = cVar;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        switch (this.c) {
            case 0:
                this.b.subscribe((InterfaceC0984q) new C0753l3(cVar, this.d));
                break;
            default:
                this.b.subscribe((InterfaceC0984q) new W3(cVar, this.d));
                break;
        }
    }
}
