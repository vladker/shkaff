package p071m3;

import java.util.concurrent.Callable;
import p017c3.d;
import p027e3.g;
import p027e3.o;
import p027e3.q;
import p039g3.A;
import p043h3.a;
import p117u3.b;
import t5.c;

/* JADX INFO: renamed from: m3.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1239b extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6127a;
    public final b b;
    public final Object c;
    public final Object d;

    public /* synthetic */ C1239b(b bVar, Object obj, Object obj2, int i5) {
        this.f6127a = i5;
        this.b = bVar;
        this.c = obj;
        this.d = obj2;
    }

    @Override // p117u3.b
    public final int a() {
        switch (this.f6127a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        return this.b.a();
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        switch (this.f6127a) {
            case 0:
                if (validate(cVarArr)) {
                    int length = cVarArr.length;
                    c[] cVarArr2 = new c[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        try {
                            Object objCall = ((Callable) this.c).call();
                            A.b(objCall, "The initialSupplier returned a null value");
                            cVarArr2[i5] = new C1238a(cVarArr[i5], objCall, (p027e3.b) this.d);
                        } catch (Throwable th) {
                            d.throwIfFatal(th);
                            for (c cVar : cVarArr) {
                                p094q3.d.e(th, cVar);
                            }
                            return;
                        }
                    }
                    this.b.subscribe(cVarArr2);
                    break;
                }
                break;
            case 1:
                p027e3.c cVar2 = (p027e3.c) this.d;
                g gVar = (g) this.c;
                if (validate(cVarArr)) {
                    int length2 = cVarArr.length;
                    c[] cVarArr3 = new c[length2];
                    for (int i6 = 0; i6 < length2; i6++) {
                        c cVar3 = cVarArr[i6];
                        if (cVar3 instanceof a) {
                            cVarArr3[i6] = new d(0, cVar2, gVar, (a) cVar3);
                        } else {
                            cVarArr3[i6] = new d(1, cVar2, gVar, cVar3);
                        }
                    }
                    this.b.subscribe(cVarArr3);
                    break;
                }
                break;
            case 2:
                p027e3.c cVar4 = (p027e3.c) this.d;
                q qVar = (q) this.c;
                if (validate(cVarArr)) {
                    int length3 = cVarArr.length;
                    c[] cVarArr4 = new c[length3];
                    for (int i7 = 0; i7 < length3; i7++) {
                        c cVar5 = cVarArr[i7];
                        if (cVar5 instanceof a) {
                            cVarArr4[i7] = new g((a) cVar5, qVar, cVar4, 0);
                        } else {
                            cVarArr4[i7] = new g(cVar5, qVar, cVar4, 1);
                        }
                    }
                    this.b.subscribe(cVarArr4);
                    break;
                }
                break;
            case 3:
                p027e3.c cVar6 = (p027e3.c) this.d;
                o oVar = (o) this.c;
                if (validate(cVarArr)) {
                    int length4 = cVarArr.length;
                    c[] cVarArr5 = new c[length4];
                    for (int i8 = 0; i8 < length4; i8++) {
                        c cVar7 = cVarArr[i8];
                        if (cVar7 instanceof a) {
                            cVarArr5[i8] = new d(2, cVar6, oVar, (a) cVar7);
                        } else {
                            cVarArr5[i8] = new d(3, cVar6, oVar, cVar7);
                        }
                    }
                    this.b.subscribe(cVarArr5);
                    break;
                }
                break;
            default:
                if (validate(cVarArr)) {
                    int length5 = cVarArr.length;
                    c[] cVarArr6 = new c[length5];
                    for (int i9 = 0; i9 < length5; i9++) {
                        try {
                            Object objCall2 = ((Callable) this.c).call();
                            A.b(objCall2, "The initialSupplier returned a null value");
                            cVarArr6[i9] = new t(cVarArr[i9], objCall2, (p027e3.c) this.d);
                        } catch (Throwable th2) {
                            d.throwIfFatal(th2);
                            for (c cVar8 : cVarArr) {
                                p094q3.d.e(th2, cVar8);
                            }
                            return;
                        }
                    }
                    this.b.subscribe(cVarArr6);
                    break;
                }
                break;
        }
    }
}
