package p061l;

import androidx.collection.a;
import p067m.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f5764a;
    public final a b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f5765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f5766g = new k(3);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5768i;

    public e(a aVar, String str, String str2, String[] strArr) {
        if (aVar.f5757p == null) {
            aVar.f5757p = this;
        } else {
            aVar.f5758q.f5764a = this;
        }
        aVar.f5758q = this;
        this.b = aVar;
        this.c = aVar.d(str);
        this.d = aVar.d(str2);
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.e = length;
        this.f5765f = new int[length];
        for (int i5 = 0; i5 < this.e; i5++) {
            this.f5765f[i5] = aVar.b(strArr[i5]).f5759a;
        }
    }

    public final void a(int i5, String str, String str2, String str3) {
        a aVar = this.b;
        b bVar = aVar.f5749h;
        bVar.a(9, str, str2, str3);
        b bVarA = aVar.a(bVar);
        if (bVarA == null) {
            int i6 = aVar.b(str).f5759a;
            int i7 = aVar.c(str2, str3).f5759a;
            k kVar = aVar.c;
            kVar.f(9, i6);
            kVar.j(i7);
            int i8 = aVar.b;
            aVar.b = i8 + 1;
            bVarA = new b(i8, bVar);
            aVar.e(bVarA);
        }
        this.f5766g.f(i5, bVarA.f5759a);
    }

    public final void b(int i5) {
        this.f5766g.g(i5);
    }

    public final void c(int i5, int i6) {
        this.f5766g.e(i5, i6);
    }

    public final void d(int i5, c cVar) {
        int i6 = cVar.f5763a & 2;
        k kVar = this.f5766g;
        if (i6 != 0 && cVar.b - kVar.f6115a < -32768) {
            throw new UnsupportedOperationException();
        }
        kVar.g(i5);
        int i7 = kVar.f6115a;
        int i8 = i7 - 1;
        if ((cVar.f5763a & 2) != 0) {
            kVar.j(cVar.b - i8);
            return;
        }
        if (((int[]) cVar.d) == null) {
            cVar.d = new int[6];
        }
        int i9 = cVar.c;
        int[] iArr = (int[]) cVar.d;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            cVar.d = iArr2;
        }
        int[] iArr3 = (int[]) cVar.d;
        int i10 = cVar.c;
        int i11 = i10 + 1;
        cVar.c = i11;
        iArr3[i10] = i8;
        cVar.c = i10 + 2;
        iArr3[i11] = i7;
        kVar.j(-1);
    }

    public final void e(c cVar) {
        k kVar = this.f5766g;
        int i5 = kVar.f6115a;
        byte[] bArr = (byte[]) kVar.b;
        cVar.f5763a |= 2;
        cVar.b = i5;
        int i6 = 0;
        while (i6 < cVar.c) {
            int[] iArr = (int[]) cVar.d;
            int i7 = i6 + 1;
            int i8 = iArr[i6];
            i6 += 2;
            int i9 = iArr[i7];
            int i10 = i5 - i8;
            bArr[i9] = (byte) (i10 >>> 8);
            bArr[i9 + 1] = (byte) i10;
        }
    }

    public final void f(Object obj) {
        b bVarB;
        a aVar = this.b;
        k kVar = aVar.c;
        b bVar = aVar.f5747f;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            bVar.b = 3;
            bVar.c = iIntValue;
            bVar.f5761g = Integer.MAX_VALUE & (3 + iIntValue);
            bVarB = aVar.a(bVar);
            if (bVarB == null) {
                kVar.g(3);
                kVar.i(iIntValue);
                int i5 = aVar.b;
                aVar.b = i5 + 1;
                bVarB = new b(i5, bVar);
                aVar.e(bVarB);
            }
        } else if (obj instanceof String) {
            String str = (String) obj;
            b bVar2 = aVar.f5748g;
            bVar2.a(8, str, null, null);
            b bVarA = aVar.a(bVar2);
            if (bVarA == null) {
                kVar.f(8, aVar.d(str));
                int i6 = aVar.b;
                aVar.b = i6 + 1;
                bVarB = new b(i6, bVar2);
                aVar.e(bVarB);
            } else {
                bVarB = bVarA;
            }
        } else {
            if (!(obj instanceof f)) {
                throw new IllegalArgumentException(a.l(obj, "value "));
            }
            f fVar = (f) obj;
            int i7 = fVar.d;
            int i8 = fVar.c;
            char[] cArr = fVar.b;
            bVarB = aVar.b(fVar.f5777a == 10 ? new String(cArr, i8, i7) : new String(cArr, i8, i7));
        }
        int i9 = bVarB.f5759a;
        int i10 = bVarB.b;
        k kVar2 = this.f5766g;
        if (i10 == 5 || i10 == 6) {
            kVar2.f(20, i9);
        } else if (i9 >= 256) {
            kVar2.f(19, i9);
        } else {
            kVar2.e(18, i9);
        }
    }

    public final void g(int i5, String str, String str2, String str3) {
        int i6;
        int i7 = 1;
        boolean z6 = i5 == 185;
        a aVar = this.b;
        b bVar = aVar.f5749h;
        int i8 = z6 ? 11 : 10;
        bVar.a(i8, str, str2, str3);
        b bVarA = aVar.a(bVar);
        if (bVarA == null) {
            int i9 = aVar.b(str).f5759a;
            int i10 = aVar.c(str2, str3).f5759a;
            k kVar = aVar.c;
            kVar.f(i8, i9);
            kVar.j(i10);
            int i11 = aVar.b;
            aVar.b = i11 + 1;
            bVarA = new b(i11, bVar);
            aVar.e(bVarA);
        }
        int i12 = bVarA.f5759a;
        int i13 = bVarA.c;
        k kVar2 = this.f5766g;
        if (!z6) {
            kVar2.f(i5, i12);
            return;
        }
        if (i13 == 0) {
            int i14 = 1;
            int i15 = 1;
            while (true) {
                i6 = i14 + 1;
                char cCharAt = str3.charAt(i14);
                if (cCharAt == ')') {
                    break;
                }
                if (cCharAt == 'L') {
                    while (true) {
                        i14 = i6 + 1;
                        if (str3.charAt(i6) == ';') {
                            break;
                        } else {
                            i6 = i14;
                        }
                    }
                    i15++;
                } else {
                    i15 = (cCharAt == 'D' || cCharAt == 'J') ? i15 + 2 : i15 + 1;
                    i14 = i6;
                }
            }
            char cCharAt2 = str3.charAt(i6);
            int i16 = i15 << 2;
            if (cCharAt2 == 'V') {
                i7 = 0;
            } else if (cCharAt2 == 'D' || cCharAt2 == 'J') {
                i7 = 2;
            }
            i13 = i16 | i7;
            bVarA.c = i13;
        }
        kVar2.f(185, i12);
        kVar2.e(i13 >> 2, 0);
    }

    public final void h(int i5, String str) {
        this.f5766g.f(i5, this.b.b(str).f5759a);
    }

    public final void i(int i5, int i6) {
        k kVar = this.f5766g;
        if (i6 < 4 && i5 != 169) {
            kVar.g((i5 < 54 ? ((i5 - 21) << 2) + 26 : ((i5 - 54) << 2) + 59) + i6);
        } else if (i6 < 256) {
            kVar.e(i5, i6);
        } else {
            kVar.g(196);
            kVar.f(i5, i6);
        }
    }
}
