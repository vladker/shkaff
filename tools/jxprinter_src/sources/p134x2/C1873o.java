package p134x2;

import E3.g;
import G3.d;

/* JADX INFO: renamed from: x2.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1873o extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f8924a;
    public Object b;
    public boolean c;
    public /* synthetic */ Object d;
    public final /* synthetic */ E e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8925f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1873o(E e, g gVar) {
        super(gVar);
        this.e = e;
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f8925f |= Integer.MIN_VALUE;
        return this.e.connectBluetoothDevice(null, false, this);
    }
}
