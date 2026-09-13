package p023d4;

import E3.g;
import G3.d;
import kotlin.jvm.internal.T;

/* JADX INFO: renamed from: d4.l1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C0605l1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f3887a;
    public /* synthetic */ Object b;
    public final /* synthetic */ C0608m1 c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0605l1(C0608m1 c0608m1, g gVar) {
        super(gVar);
        this.c = c0608m1;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.b = obj;
        this.d |= Integer.MIN_VALUE;
        return this.c.emit(null, this);
    }
}
