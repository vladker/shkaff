package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: renamed from: x2.g0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1858g0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8901a;
    public final /* synthetic */ K0 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1858g0(K0 k6, g gVar) {
        super(gVar);
        this.b = k6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.f8901a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objM1100getPrinterStateIoAF18A = this.b.m1100getPrinterStateIoAF18A(this);
        return objM1100getPrinterStateIoAF18A == i.getCOROUTINE_SUSPENDED() ? objM1100getPrinterStateIoAF18A : u.a(objM1100getPrinterStateIoAF18A);
    }
}
