package p044h4;

import E3.g;
import G3.d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f4036a;
    public /* synthetic */ Object b;
    public final /* synthetic */ m c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, g gVar) {
        super(gVar);
        this.c = mVar;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m.b;
        return this.c.c(this);
    }
}
