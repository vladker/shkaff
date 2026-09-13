package p071m3;

import io.reactivex.internal.operators.flowable.J0;
import p027e3.o;
import p027e3.q;
import p043h3.a;
import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6132a;
    public final b b;
    public final Object c;

    public /* synthetic */ f(b bVar, Object obj, int i5) {
        this.f6132a = i5;
        this.b = bVar;
        this.c = obj;
    }

    @Override // p117u3.b
    public final int a() {
        switch (this.f6132a) {
            case 0:
                break;
        }
        return this.b.a();
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        switch (this.f6132a) {
            case 0:
                q qVar = (q) this.c;
                if (validate(cVarArr)) {
                    int length = cVarArr.length;
                    c[] cVarArr2 = new c[length];
                    for (int i5 = 0; i5 < length; i5++) {
                        c cVar = cVarArr[i5];
                        if (cVar instanceof a) {
                            cVarArr2[i5] = new e((a) cVar, qVar, 0);
                        } else {
                            cVarArr2[i5] = new e(cVar, qVar, 1);
                        }
                    }
                    this.b.subscribe(cVarArr2);
                    break;
                }
                break;
            default:
                o oVar = (o) this.c;
                if (validate(cVarArr)) {
                    int length2 = cVarArr.length;
                    c[] cVarArr3 = new c[length2];
                    for (int i6 = 0; i6 < length2; i6++) {
                        c cVar2 = cVarArr[i6];
                        if (cVar2 instanceof a) {
                            cVarArr3[i6] = new r((a) cVar2, oVar);
                        } else {
                            cVarArr3[i6] = new J0(cVar2, oVar, 1);
                        }
                    }
                    this.b.subscribe(cVarArr3);
                    break;
                }
                break;
        }
    }
}
