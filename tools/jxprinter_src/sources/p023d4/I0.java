package p023d4;

import E3.g;
import G3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0603l f3805a;
    public Object b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C0603l d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I0(C0603l c0603l, g gVar) {
        super(gVar);
        this.d = c0603l;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
