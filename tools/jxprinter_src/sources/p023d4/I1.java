package p023d4;

import E3.g;
import G3.d;
import kotlin.jvm.internal.T;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class I1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public H1 f3806a;
    public T b;
    public /* synthetic */ Object c;
    public final /* synthetic */ H1 d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I1(H1 h1, g gVar) {
        super(gVar);
        this.d = h1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.emit(null, this);
    }
}
