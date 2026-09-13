package p061l;

import S1.f;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;
import p067m.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5746a;
    public int b = 1;
    public final k c = new k(3);
    public b[] d = new b[256];
    public int e = (int) (((double) 256) * 0.75d);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f5747f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f5748g = new b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f5749h = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f5753l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f5754m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f5755n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f5756o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f5757p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f5758q;

    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    public final b a(b bVar) {
        b[] bVarArr = this.d;
        for (b bVar2 = bVarArr[bVar.f5761g % bVarArr.length]; bVar2 != null; bVar2 = bVar2.f5762h) {
            int i5 = bVar2.b;
            int i6 = bVar.b;
            if (i5 == i6) {
                boolean zEquals = true;
                if (i6 == 1) {
                    zEquals = bVar2.d.equals(bVar.d);
                } else if (i6 != 15) {
                    if (i6 != 12) {
                        if (i6 != 13) {
                            switch (i6) {
                                case 3:
                                case 4:
                                    if (bVar2.c != bVar.c) {
                                        zEquals = false;
                                    }
                                    break;
                                case 5:
                                case 6:
                                    break;
                                case 7:
                                case 8:
                                    zEquals = bVar2.d.equals(bVar.d);
                                    break;
                                default:
                                    if (!bVar2.d.equals(bVar.d) || !bVar2.e.equals(bVar.e) || !bVar2.f5760f.equals(bVar.f5760f)) {
                                        zEquals = false;
                                    }
                                    break;
                            }
                        } else {
                            zEquals = bVar2.d.equals(bVar.d);
                        }
                    } else if (!bVar2.d.equals(bVar.d) || !bVar2.e.equals(bVar.e)) {
                        zEquals = false;
                    }
                }
                if (zEquals) {
                    return bVar2;
                }
            }
        }
        return bVar2;
    }

    public final b b(String str) {
        b bVar = this.f5748g;
        bVar.a(7, str, null, null);
        b bVarA = a(bVar);
        if (bVarA != null) {
            return bVarA;
        }
        this.c.f(7, d(str));
        int i5 = this.b;
        this.b = i5 + 1;
        b bVar2 = new b(i5, bVar);
        e(bVar2);
        return bVar2;
    }

    public final b c(String str, String str2) {
        b bVar = this.f5748g;
        bVar.a(12, str, str2, null);
        b bVarA = a(bVar);
        if (bVarA != null) {
            return bVarA;
        }
        int iD = d(str);
        int iD2 = d(str2);
        k kVar = this.c;
        kVar.f(12, iD);
        kVar.j(iD2);
        int i5 = this.b;
        this.b = i5 + 1;
        b bVar2 = new b(i5, bVar);
        e(bVar2);
        return bVar2;
    }

    public final int d(String str) {
        b bVar = this.f5747f;
        bVar.a(1, str, null, null);
        b bVarA = a(bVar);
        if (bVarA == null) {
            k kVar = this.c;
            kVar.g(1);
            int length = str.length();
            int i5 = kVar.f6115a;
            int i6 = i5 + 2;
            if (i6 + length > ((byte[]) kVar.b).length) {
                kVar.b(length + 2);
            }
            byte[] bArr = (byte[]) kVar.b;
            bArr[i5] = (byte) (length >>> 8);
            bArr[i5 + 1] = (byte) length;
            int i7 = 0;
            while (i7 < length) {
                char cCharAt = str.charAt(i7);
                if (cCharAt < 1 || cCharAt > 127) {
                    throw new UnsupportedOperationException();
                }
                bArr[i6] = (byte) cCharAt;
                i7++;
                i6++;
            }
            kVar.f6115a = i6;
            int i8 = this.b;
            this.b = i8 + 1;
            bVarA = new b(i8, bVar);
            e(bVarA);
        }
        return bVarA.f5759a;
    }

    public final void e(b bVar) {
        if (this.b > this.e) {
            int length = this.d.length;
            int i5 = (length * 2) + 1;
            b[] bVarArr = new b[i5];
            for (int i6 = length - 1; i6 >= 0; i6--) {
                b bVar2 = this.d[i6];
                while (bVar2 != null) {
                    int i7 = bVar2.f5761g % i5;
                    b bVar3 = bVar2.f5762h;
                    bVar2.f5762h = bVarArr[i7];
                    bVarArr[i7] = bVar2;
                    bVar2 = bVar3;
                }
            }
            this.d = bVarArr;
            this.e = (int) (((double) i5) * 0.75d);
        }
        int i8 = bVar.f5761g;
        b[] bVarArr2 = this.d;
        int length2 = i8 % bVarArr2.length;
        bVar.f5762h = bVarArr2[length2];
        bVarArr2[length2] = bVar;
    }

    public final byte[] f() {
        int i5;
        int i6 = (this.f5753l * 2) + 24;
        int i7 = 0;
        for (f fVar = this.f5755n; fVar != null; fVar = (f) fVar.c) {
            i7++;
            i6 += 8;
        }
        int i8 = 0;
        for (e eVar = this.f5757p; eVar != null; eVar = eVar.f5764a) {
            i8++;
            int i9 = eVar.e;
            a aVar = eVar.b;
            k kVar = eVar.f5766g;
            if (kVar.f6115a > 0) {
                aVar.d(AttributeLayout.ATTRIBUTE_CODE);
                i5 = kVar.f6115a + 26;
            } else {
                i5 = 8;
            }
            if (i9 > 0) {
                aVar.d(AttributeLayout.ATTRIBUTE_EXCEPTIONS);
                i5 += (i9 * 2) + 8;
            }
            i6 += i5;
        }
        k kVar2 = this.c;
        int i10 = i6 + kVar2.f6115a;
        k kVar3 = new k();
        kVar3.b = new byte[i10];
        kVar3.i(-889275714);
        kVar3.i(this.f5746a);
        kVar3.j(this.b);
        kVar3.h((byte[]) kVar2.b, kVar2.f6115a);
        kVar3.j(this.f5750i & (-393217));
        kVar3.j(this.f5751j);
        kVar3.j(this.f5752k);
        kVar3.j(this.f5753l);
        for (int i11 = 0; i11 < this.f5753l; i11++) {
            kVar3.j(this.f5754m[i11]);
        }
        kVar3.j(i7);
        for (f fVar2 = this.f5755n; fVar2 != null; fVar2 = (f) fVar2.c) {
            kVar3.j(1);
            kVar3.j(fVar2.f623a);
            kVar3.j(fVar2.b);
            kVar3.j(0);
        }
        kVar3.j(i8);
        for (e eVar2 = this.f5757p; eVar2 != null; eVar2 = eVar2.f5764a) {
            a aVar2 = eVar2.b;
            int i12 = eVar2.e;
            kVar3.j(1);
            kVar3.j(eVar2.c);
            kVar3.j(eVar2.d);
            k kVar4 = eVar2.f5766g;
            int i13 = kVar4.f6115a > 0 ? 1 : 0;
            if (i12 > 0) {
                i13++;
            }
            kVar3.j(i13);
            int i14 = kVar4.f6115a;
            if (i14 > 0) {
                kVar3.j(aVar2.d(AttributeLayout.ATTRIBUTE_CODE));
                kVar3.i(i14 + 12);
                kVar3.j(eVar2.f5767h);
                kVar3.j(eVar2.f5768i);
                kVar3.i(kVar4.f6115a);
                kVar3.h((byte[]) kVar4.b, kVar4.f6115a);
                kVar3.j(0);
                kVar3.j(0);
            }
            if (i12 > 0) {
                kVar3.j(aVar2.d(AttributeLayout.ATTRIBUTE_EXCEPTIONS));
                kVar3.i((i12 * 2) + 2);
                kVar3.j(i12);
                for (int i15 = 0; i15 < i12; i15++) {
                    kVar3.j(eVar2.f5765f[i15]);
                }
            }
        }
        kVar3.j(0);
        return (byte[]) kVar3.b;
    }

    public final void g(String str, String str2, String[] strArr) {
        this.f5746a = 49;
        this.f5750i = 33;
        this.f5751j = b(str).f5759a;
        this.f5752k = str2 == null ? 0 : b(str2).f5759a;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.f5753l = length;
        this.f5754m = new int[length];
        for (int i5 = 0; i5 < this.f5753l; i5++) {
            this.f5754m[i5] = b(strArr[i5]).f5759a;
        }
    }
}
