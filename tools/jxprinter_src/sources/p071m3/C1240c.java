package p071m3;

import io.reactivex.internal.operators.flowable.C0814w;
import p027e3.o;
import p117u3.b;
import t5.c;

/* JADX INFO: renamed from: m3.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1240c extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6128a;
    public final o b;
    public final int c;
    public final int d;

    public C1240c(b bVar, o oVar, int i5, int i6) {
        this.f6128a = bVar;
        this.b = oVar;
        this.c = i5;
        if (i6 == 0) {
            throw new NullPointerException("errorMode");
        }
        this.d = i6;
    }

    @Override // p117u3.b
    public final int a() {
        return this.f6128a.a();
    }

    @Override // p117u3.b
    public final void subscribe(c[] cVarArr) {
        if (validate(cVarArr)) {
            int length = cVarArr.length;
            c[] cVarArr2 = new c[length];
            for (int i5 = 0; i5 < length; i5++) {
                cVarArr2[i5] = C0814w.g(cVarArr[i5], this.b, this.c, this.d);
            }
            this.f6128a.subscribe(cVarArr2);
        }
    }
}
