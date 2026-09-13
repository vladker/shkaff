package kotlinx.coroutines.flow.internal;

import p023d4.InterfaceC0612o;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1119h extends G3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C1120i f5708a;
    public InterfaceC0612o b;
    public /* synthetic */ Object c;
    public final /* synthetic */ C1120i d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1119h(C1120i c1120i, E3.g gVar) {
        super(gVar);
        this.d = c1120i;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.c = obj;
        this.e |= Integer.MIN_VALUE;
        return this.d.a(null, this);
    }
}
