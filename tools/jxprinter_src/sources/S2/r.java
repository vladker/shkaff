package S2;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import kotlin.jvm.internal.T;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p007a4.AbstractC0265b1;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.InterfaceC0304u;
import p007a4.M;
import p018c4.B;
import p018c4.D0;
import p023d4.C0603l;
import p023d4.InterfaceC0612o;
import p134x2.K0;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f648a;
    public int b;
    public /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, Object obj2, E3.g gVar, int i5) {
        super(2, gVar);
        this.f648a = i5;
        this.d = obj;
        this.e = obj2;
    }

    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f648a) {
            case 0:
                return new r((String) this.c, (ContentResolver) this.d, (O3.l) this.e, gVar, 0);
            case 1:
                r rVar = new r((D0) this.d, this.e, gVar, 1);
                rVar.c = obj;
                return rVar;
            case 2:
                r rVar2 = new r((InterfaceC0612o) this.d, (InterfaceC0304u) this.e, gVar, 2);
                rVar2.c = obj;
                return rVar2;
            case 3:
                return new r((byte[]) this.d, (O3.l) this.e, (String) this.c, gVar);
            default:
                return new r((String) this.c, (String) this.d, (O3.l) this.e, gVar, 4);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        M m6 = (M) obj;
        E3.g gVar = (E3.g) obj2;
        switch (this.f648a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return ((r) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:20:0x004e  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM1361constructorimpl;
        Object objM1107sendData0E7RQCE;
        Object objM1111setWifiNamegIAlus;
        K0 printer;
        Object objM1112setWifiPasswordgIAlus;
        switch (this.f648a) {
            case 0:
                O3.l lVar = (O3.l) this.e;
                Object coroutine_suspended = F3.i.getCOROUTINE_SUSPENDED();
                int i5 = this.b;
                E3.g gVar = null;
                try {
                    if (i5 == 0) {
                        p147z3.v.throwOnFailure(obj);
                        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = ((ContentResolver) this.d).openFileDescriptor(Uri.parse((String) this.c), "r");
                        Long lBoxLong = parcelFileDescriptorOpenFileDescriptor != null ? G3.b.boxLong(parcelFileDescriptorOpenFileDescriptor.getStatSize()) : null;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        AbstractC0265b1 main = C0276f0.getMain();
                        q qVar = new q(lVar, lBoxLong, gVar, 0);
                        this.b = 1;
                        if (AbstractC0272e.withContext(main, qVar, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i5 != 1 && i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p147z3.v.throwOnFailure(obj);
                    }
                } catch (Exception e) {
                    AbstractC0265b1 main2 = C0276f0.getMain();
                    q qVar2 = new q(lVar, e, gVar, 1);
                    this.b = 2;
                    if (AbstractC0272e.withContext(main2, qVar2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Q.INSTANCE;
            case 1:
                Object coroutine_suspended2 = F3.i.getCOROUTINE_SUSPENDED();
                int i6 = this.b;
                try {
                    if (i6 == 0) {
                        p147z3.v.throwOnFailure(obj);
                        D0 d1 = (D0) this.d;
                        Object obj2 = this.e;
                        this.b = 1;
                        if (d1.send(obj2, this) == coroutine_suspended2) {
                            return coroutine_suspended2;
                        }
                    } else {
                        if (i6 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p147z3.v.throwOnFailure(obj);
                    }
                    objM1361constructorimpl = p147z3.u.m1361constructorimpl(Q.INSTANCE);
                    break;
                } catch (Throwable th) {
                    objM1361constructorimpl = p147z3.u.m1361constructorimpl(p147z3.v.createFailure(th));
                }
                return B.b(!(objM1361constructorimpl instanceof z3.u.a) ? B.Companion.m1010successJP2dKIU(Q.INSTANCE) : B.Companion.m1008closedJP2dKIU(p147z3.u.m1362exceptionOrNullimpl(objM1361constructorimpl)));
            case 2:
                InterfaceC0304u interfaceC0304u = (InterfaceC0304u) this.e;
                Object coroutine_suspended3 = F3.i.getCOROUTINE_SUSPENDED();
                int i7 = this.b;
                try {
                    if (i7 == 0) {
                        p147z3.v.throwOnFailure(obj);
                        M m6 = (M) this.c;
                        T t6 = new T();
                        InterfaceC0612o interfaceC0612o = (InterfaceC0612o) this.d;
                        C0603l c0603l = new C0603l(t6, m6, interfaceC0304u);
                        this.b = 1;
                        if (interfaceC0612o.collect(c0603l, this) == coroutine_suspended3) {
                            return coroutine_suspended3;
                        }
                    } else {
                        if (i7 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p147z3.v.throwOnFailure(obj);
                    }
                    return Q.INSTANCE;
                } catch (Throwable th2) {
                    interfaceC0304u.completeExceptionally(th2);
                    throw th2;
                }
            case 3:
                Object coroutine_suspended4 = F3.i.getCOROUTINE_SUSPENDED();
                int i8 = this.b;
                if (i8 == 0) {
                    p147z3.v.throwOnFailure(obj);
                    K0 printer2 = p051j0.f.getPrinter();
                    if (printer2 != null) {
                        byte[] bArr = (byte[]) this.d;
                        E3.c cVar = new E3.c(bArr, (String) this.c, 1);
                        this.b = 1;
                        objM1107sendData0E7RQCE = printer2.m1107sendData0E7RQCE(bArr, cVar, this);
                        if (objM1107sendData0E7RQCE == coroutine_suspended4) {
                            return coroutine_suspended4;
                        }
                    }
                    O3.l lVar2 = (O3.l) this.e;
                    Q q6 = Q.INSTANCE;
                    AbstractC1125a.q(q6, lVar2);
                    return q6;
                }
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p147z3.v.throwOnFailure(obj);
                objM1107sendData0E7RQCE = ((p147z3.u) obj).b();
                p147z3.u.a(objM1107sendData0E7RQCE);
                O3.l lVar3 = (O3.l) this.e;
                Q q7 = Q.INSTANCE;
                AbstractC1125a.q(q7, lVar3);
                return q7;
            default:
                Object coroutine_suspended5 = F3.i.getCOROUTINE_SUSPENDED();
                int i9 = this.b;
                if (i9 != 0) {
                    if (i9 == 1) {
                        p147z3.v.throwOnFailure(obj);
                        objM1111setWifiNamegIAlus = ((p147z3.u) obj).b();
                    } else {
                        if (i9 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        p147z3.v.throwOnFailure(obj);
                        objM1112setWifiPasswordgIAlus = ((p147z3.u) obj).b();
                    }
                    p147z3.u.a(objM1112setWifiPasswordgIAlus);
                    O3.l lVar4 = (O3.l) this.e;
                    Q q8 = Q.INSTANCE;
                    AbstractC1125a.q(q8, lVar4);
                    return q8;
                }
                p147z3.v.throwOnFailure(obj);
                K0 printer3 = p051j0.f.getPrinter();
                if (printer3 != null) {
                    String str = (String) this.c;
                    this.b = 1;
                    objM1111setWifiNamegIAlus = printer3.m1111setWifiNamegIAlus(str, this);
                    if (objM1111setWifiNamegIAlus == coroutine_suspended5) {
                        return coroutine_suspended5;
                    }
                } else {
                    printer = p051j0.f.getPrinter();
                    if (printer != null) {
                        String str2 = (String) this.d;
                        this.b = 2;
                        objM1112setWifiPasswordgIAlus = printer.m1112setWifiPasswordgIAlus(str2, this);
                        if (objM1112setWifiPasswordgIAlus == coroutine_suspended5) {
                            return coroutine_suspended5;
                        }
                        p147z3.u.a(objM1112setWifiPasswordgIAlus);
                    }
                }
                O3.l lVar5 = (O3.l) this.e;
                Q q9 = Q.INSTANCE;
                AbstractC1125a.q(q9, lVar5);
                return q9;
                p147z3.u.a(objM1111setWifiNamegIAlus);
                printer = p051j0.f.getPrinter();
                if (printer != null) {
                    String str3 = (String) this.d;
                    this.b = 2;
                    objM1112setWifiPasswordgIAlus = printer.m1112setWifiPasswordgIAlus(str3, this);
                    if (objM1112setWifiPasswordgIAlus == coroutine_suspended5) {
                        return coroutine_suspended5;
                    }
                    p147z3.u.a(objM1112setWifiPasswordgIAlus);
                }
                O3.l lVar6 = (O3.l) this.e;
                Q q10 = Q.INSTANCE;
                AbstractC1125a.q(q10, lVar6);
                return q10;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(String str, Object obj, O3.l lVar, E3.g gVar, int i5) {
        super(2, gVar);
        this.f648a = i5;
        this.c = str;
        this.d = obj;
        this.e = lVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(byte[] bArr, O3.l lVar, String str, E3.g gVar) {
        super(2, gVar);
        this.f648a = 3;
        this.d = bArr;
        this.e = lVar;
        this.c = str;
    }
}
