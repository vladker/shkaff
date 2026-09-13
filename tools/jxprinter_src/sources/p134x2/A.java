package p134x2;

import F3.i;
import G3.d;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8843a;
    public /* synthetic */ Object b;
    public int c;

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.b = obj;
        this.c |= Integer.MIN_VALUE;
        Object objM1096initJxDeviceStategIAlus = E.m1096initJxDeviceStategIAlus(false, this);
        return objM1096initJxDeviceStategIAlus == i.getCOROUTINE_SUSPENDED() ? objM1096initJxDeviceStategIAlus : u.a(objM1096initJxDeviceStategIAlus);
    }
}
