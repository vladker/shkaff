package io.reactivex.internal.operators.flowable;

import io.reactivex.AbstractC0979l;
import io.reactivex.InterfaceC0984q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class O1 extends AbstractC0683a {
    public final p027e3.o c;
    public final p027e3.o d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f4392f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p027e3.o f4393g;

    public O1(AbstractC0979l abstractC0979l, p027e3.o oVar, p027e3.o oVar2, int i5, boolean z6, p027e3.o oVar3) {
        super(abstractC0979l);
        this.c = oVar;
        this.d = oVar2;
        this.e = i5;
        this.f4392f = z6;
        this.f4393g = oVar3;
    }

    @Override // io.reactivex.AbstractC0979l
    public final void b(t5.c cVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        Map concurrentHashMap;
        p027e3.o oVar = this.f4393g;
        try {
            if (oVar == null) {
                concurrentHashMap = new ConcurrentHashMap();
                concurrentLinkedQueue = null;
            } else {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                concurrentHashMap = (Map) oVar.apply(new K1(concurrentLinkedQueue));
            }
            Map map = concurrentHashMap;
            ConcurrentLinkedQueue concurrentLinkedQueue2 = concurrentLinkedQueue;
            this.b.subscribe((InterfaceC0984q) new L1(cVar, this.c, this.d, this.e, this.f4392f, map, concurrentLinkedQueue2));
        } catch (Exception e) {
            p017c3.d.throwIfFatal(e);
            cVar.onSubscribe(p100r3.e.f7960a);
            cVar.onError(e);
        }
    }
}
