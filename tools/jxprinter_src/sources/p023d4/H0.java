package p023d4;

import E3.g;
import F3.i;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.T;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H0 implements InterfaceC0615p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3802a;
    public final /* synthetic */ int b;
    public final /* synthetic */ InterfaceC0615p c;
    public final /* synthetic */ Serializable d;

    public /* synthetic */ H0(Serializable serializable, int i5, InterfaceC0615p interfaceC0615p, int i6) {
        this.f3802a = i6;
        this.d = serializable;
        this.b = i5;
        this.c = interfaceC0615p;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0082  */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    @Override // p023d4.InterfaceC0615p
    public final Object emit(Object obj, g gVar) throws Throwable {
        G0 g1;
        C0640x1 c0640x1;
        H0 h1;
        switch (this.f3802a) {
            case 0:
                if (gVar instanceof G0) {
                    g1 = (G0) gVar;
                    int i5 = g1.c;
                    if ((i5 & Integer.MIN_VALUE) != 0) {
                        g1.c = i5 - Integer.MIN_VALUE;
                    } else {
                        g1 = new G0(this, gVar);
                    }
                } else {
                    g1 = new G0(this, gVar);
                }
                Object obj2 = g1.f3799a;
                Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
                int i6 = g1.c;
                if (i6 == 0) {
                    v.throwOnFailure(obj2);
                    Q q6 = (Q) this.d;
                    int i7 = q6.f5687a;
                    if (i7 >= this.b) {
                        g1.c = 1;
                        if (this.c.emit(obj, g1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        q6.f5687a = i7 + 1;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v.throwOnFailure(obj2);
                }
                return p147z3.Q.INSTANCE;
            default:
                T t6 = (T) this.d;
                if (gVar instanceof C0640x1) {
                    c0640x1 = (C0640x1) gVar;
                    int i8 = c0640x1.d;
                    if ((i8 & Integer.MIN_VALUE) != 0) {
                        c0640x1.d = i8 - Integer.MIN_VALUE;
                    } else {
                        c0640x1 = new C0640x1(this, gVar);
                    }
                } else {
                    c0640x1 = new C0640x1(this, gVar);
                }
                Object obj3 = c0640x1.b;
                Object coroutine_suspended2 = i.getCOROUTINE_SUSPENDED();
                int i9 = c0640x1.d;
                if (i9 == 0) {
                    v.throwOnFailure(obj3);
                    ArrayList arrayList = (ArrayList) t6.f5689a;
                    int i10 = this.b;
                    if (arrayList == null) {
                        arrayList = new ArrayList(i10);
                        t6.f5689a = arrayList;
                    }
                    arrayList.add(obj);
                    if (arrayList.size() == i10) {
                        c0640x1.f3926a = this;
                        c0640x1.d = 1;
                        if (this.c.emit(arrayList, c0640x1) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                        h1 = this;
                    }
                    return p147z3.Q.INSTANCE;
                }
                if (i9 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h1 = c0640x1.f3926a;
                v.throwOnFailure(obj3);
                ((T) h1.d).f5689a = null;
                return p147z3.Q.INSTANCE;
        }
    }
}
