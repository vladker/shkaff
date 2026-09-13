package p071m3;

import io.reactivex.internal.operators.flowable.C0727h1;
import io.reactivex.internal.operators.flowable.C0733i1;
import p027e3.o;
import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6135a;
    public final o b;
    public final boolean c;
    public final int d;
    public final int e;

    public h(b bVar, o oVar, boolean z6, int i5, int i6) {
        this.f6135a = bVar;
        this.b = oVar;
        this.c = z6;
        this.d = i5;
        this.e = i6;
    }

    @Override // p117u3.b
    public final int a() {
        return this.f6135a.a();
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length];
            for (int i5 = 0; i5 < length; i5++) {
                c cVar = cVarArr[i5];
                int i6 = C0733i1.f4668g;
                cVarArr2[i5] = new C0727h1(this.d, this.e, this.b, cVar, this.c);
            }
            this.f6135a.subscribe(cVarArr2);
        }
    }
}
