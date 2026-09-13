package p071m3;

import io.reactivex.M;
import io.reactivex.N;
import io.reactivex.internal.schedulers.z;
import p043h3.a;
import p117u3.b;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class A extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6119a;
    public final N b;
    public final int c;

    public A(b bVar, N n6, int i5) {
        this.f6119a = bVar;
        this.b = n6;
        this.c = i5;
    }

    @Override // p117u3.b
    public final int a() {
        return this.f6119a.a();
    }

    public final void b(int i5, c[] cVarArr, c[] cVarArr2, M m6) {
        c cVar = cVarArr[i5];
        int i6 = this.c;
        p083o3.c cVar2 = new p083o3.c(i6);
        if (cVar instanceof a) {
            cVarArr2[i5] = new y((a) cVar, i6, cVar2, m6);
        } else {
            cVarArr2[i5] = new z(cVar, i6, cVar2, m6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length];
            N n6 = this.b;
            if (n6 instanceof z) {
                ((z) n6).createWorkers(length, new W1.a(this, false, cVarArr, cVarArr2));
            } else {
                for (int i5 = 0; i5 < length; i5++) {
                    b(i5, cVarArr, cVarArr2, n6.createWorker());
                }
            }
            this.f6119a.subscribe(cVarArr2);
        }
    }
}
