package p134x2;

import E3.g;
import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: renamed from: x2.k0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1866k0 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f8911a;
    public final /* synthetic */ K0 b;
    public int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1866k0(K0 k6, g gVar) {
        super(gVar);
        this.b = k6;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f8911a = obj;
        this.c |= Integer.MIN_VALUE;
        Object objM1102printESCBitmapyxL6bBk = this.b.m1102printESCBitmapyxL6bBk(null, false, 0, null, this);
        return objM1102printESCBitmapyxL6bBk == i.getCOROUTINE_SUSPENDED() ? objM1102printESCBitmapyxL6bBk : u.a(objM1102printESCBitmapyxL6bBk);
    }
}
