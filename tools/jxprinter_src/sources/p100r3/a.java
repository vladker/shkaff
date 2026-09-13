package p100r3;

import V1.b;
import p027e3.d;
import p039g3.A;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f7957a;
    public Object[] b;
    public int c;

    public a() {
        Object[] objArr = new Object[5];
        this.f7957a = objArr;
        this.b = objArr;
    }

    public final boolean a(c cVar) {
        Object[] objArr;
        Object[] objArr2 = this.f7957a;
        while (true) {
            if (objArr2 == null) {
                return false;
            }
            for (int i5 = 0; i5 < 4 && (objArr = objArr2[i5]) != null; i5++) {
                if (n.b(objArr, cVar)) {
                    return true;
                }
            }
            objArr2 = objArr2[4];
        }
    }

    public final void b(Object obj) {
        int i5 = this.c;
        if (i5 == 4) {
            Object[] objArr = new Object[5];
            this.b[4] = objArr;
            this.b = objArr;
            i5 = 0;
        }
        this.b[i5] = obj;
        this.c = i5 + 1;
    }

    public <S> void forEachWhile(S s6, d dVar) {
        Object[] objArr = this.f7957a;
        while (true) {
            for (int i5 = 0; i5 < 4; i5++) {
                Object[] objArr2 = objArr[i5];
                if (objArr2 == null) {
                    return;
                }
                ((b) dVar).getClass();
                if (A.a(s6, objArr2)) {
                    return;
                }
            }
            objArr = objArr[4];
        }
    }
}
