package D1;

import android.util.SparseBooleanArray;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Object f181s = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P2.d f182a;
    public final PdfiumCore b;
    public final int c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Size f184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Size f185h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f188k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f189l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f190m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final K1.b f194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f195r;
    public final ArrayList d = new ArrayList();
    public final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseBooleanArray f183f = new SparseBooleanArray();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Q2.a f186i = new Q2.a(0.0f, 0.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Q2.a f187j = new Q2.a(0.0f, 0.0f);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList f191n = new ArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f192o = new ArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f193p = 0.0f;

    public m(PdfiumCore pdfiumCore, P2.d dVar, K1.b bVar, Size size, boolean z6, int i5, boolean z7, boolean z8) {
        this.c = 0;
        this.f184g = new Size(0, 0);
        this.f185h = new Size(0, 0);
        this.b = pdfiumCore;
        this.f182a = dVar;
        this.f194q = bVar;
        this.f188k = z6;
        this.f189l = i5;
        this.f190m = z7;
        this.f195r = z8;
        this.c = pdfiumCore.c(dVar);
        for (int i6 = 0; i6 < this.c; i6++) {
            Size sizeE = pdfiumCore.e(this.f182a, a(i6));
            if (sizeE.f3766a > this.f184g.f3766a) {
                this.f184g = sizeE;
            }
            if (sizeE.b > this.f185h.b) {
                this.f185h = sizeE;
            }
            this.d.add(sizeE);
        }
        i(size);
    }

    public final int a(int i5) {
        if (i5 < 0 || i5 >= this.c) {
            return -1;
        }
        return i5;
    }

    public final Q2.a b() {
        return this.f188k ? this.f187j : this.f186i;
    }

    public final int c(float f6, float f7) {
        int i5 = 0;
        for (int i6 = 0; i6 < this.c; i6++) {
            if ((((Float) this.f191n.get(i6)).floatValue() * f7) - (((this.f190m ? ((Float) this.f192o.get(i6)).floatValue() : this.f189l) * f7) / 2.0f) >= f6) {
                break;
            }
            i5++;
        }
        int i7 = i5 - 1;
        if (i7 >= 0) {
            return i7;
        }
        return 0;
    }

    public final float d(int i5, float f6) {
        Q2.a aVarF = f(i5);
        return (this.f188k ? aVarF.b : aVarF.f575a) * f6;
    }

    public final float e(int i5, float f6) {
        if (a(i5) < 0) {
            return 0.0f;
        }
        return ((Float) this.f191n.get(i5)).floatValue() * f6;
    }

    public final Q2.a f(int i5) {
        return a(i5) < 0 ? new Q2.a(0.0f, 0.0f) : (Q2.a) this.e.get(i5);
    }

    public final Q2.a g(int i5, float f6) {
        Q2.a aVarF = f(i5);
        return new Q2.a(aVarF.f575a * f6, aVarF.b * f6);
    }

    public final float h(int i5, float f6) {
        float f7;
        float f8;
        Q2.a aVarF = f(i5);
        if (this.f188k) {
            f7 = b().f575a;
            f8 = aVarF.f575a;
        } else {
            f7 = b().b;
            f8 = aVarF.b;
        }
        return ((f7 - f8) * f6) / 2.0f;
    }

    public final void i(Size size) {
        float fFloatValue;
        float f6;
        float f7;
        Q2.a aVar;
        int i5;
        ArrayList arrayList = this.e;
        arrayList.clear();
        K1.d dVar = new K1.d(this.f194q, this.f184g, this.f185h, size, this.f195r);
        this.f187j = dVar.c;
        this.f186i = dVar.d;
        ArrayList arrayList2 = this.d;
        int size2 = arrayList2.size();
        int i6 = 0;
        while (true) {
            fFloatValue = 0.0f;
            if (i6 >= size2) {
                break;
            }
            Object obj = arrayList2.get(i6);
            i6++;
            Size size3 = (Size) obj;
            int i7 = size3.f3766a;
            if (i7 <= 0 || (i5 = size3.b) <= 0) {
                aVar = new Q2.a(0.0f, 0.0f);
            } else {
                Size size4 = dVar.b;
                boolean z6 = dVar.f391g;
                float f8 = z6 ? size4.f3766a : i7 * dVar.e;
                float f9 = z6 ? size4.b : i5 * dVar.f390f;
                int i8 = K1.c.f388a[dVar.f389a.ordinal()];
                aVar = i8 != 1 ? i8 != 2 ? K1.d.c(size3, f8) : K1.d.a(size3, f8, f9) : K1.d.b(size3, f9);
            }
            arrayList.add(aVar);
        }
        int i9 = this.f189l;
        boolean z7 = this.f188k;
        ArrayList arrayList3 = this.f192o;
        boolean z8 = this.f190m;
        if (z8) {
            arrayList3.clear();
            for (int i10 = 0; i10 < this.c; i10++) {
                Q2.a aVar2 = (Q2.a) arrayList.get(i10);
                if (z7) {
                    f6 = size.b;
                    f7 = aVar2.b;
                } else {
                    f6 = size.f3766a;
                    f7 = aVar2.f575a;
                }
                float fMax = Math.max(0.0f, f6 - f7);
                if (i10 < this.c - 1) {
                    fMax += i9;
                }
                arrayList3.add(Float.valueOf(fMax));
            }
        }
        float fFloatValue2 = 0.0f;
        for (int i11 = 0; i11 < this.c; i11++) {
            Q2.a aVar3 = (Q2.a) arrayList.get(i11);
            fFloatValue2 += z7 ? aVar3.b : aVar3.f575a;
            if (z8) {
                fFloatValue2 = ((Float) arrayList3.get(i11)).floatValue() + fFloatValue2;
            } else if (i11 < this.c - 1) {
                fFloatValue2 += i9;
            }
        }
        this.f193p = fFloatValue2;
        ArrayList arrayList4 = this.f191n;
        arrayList4.clear();
        for (int i12 = 0; i12 < this.c; i12++) {
            Q2.a aVar4 = (Q2.a) arrayList.get(i12);
            float f10 = z7 ? aVar4.b : aVar4.f575a;
            if (z8) {
                float fFloatValue3 = (((Float) arrayList3.get(i12)).floatValue() / 2.0f) + fFloatValue;
                if (i12 == 0) {
                    fFloatValue3 -= i9 / 2.0f;
                } else if (i12 == this.c - 1) {
                    fFloatValue3 += i9 / 2.0f;
                }
                arrayList4.add(Float.valueOf(fFloatValue3));
                fFloatValue = (((Float) arrayList3.get(i12)).floatValue() / 2.0f) + f10 + fFloatValue3;
            } else {
                arrayList4.add(Float.valueOf(fFloatValue));
                fFloatValue = f10 + i9 + fFloatValue;
            }
        }
    }

    public boolean openPage(int i5) {
        int iA = a(i5);
        if (iA < 0) {
            return false;
        }
        synchronized (f181s) {
            try {
                if (this.f183f.indexOfKey(iA) >= 0) {
                    return false;
                }
                try {
                    this.b.h(this.f182a, iA);
                    this.f183f.put(iA, true);
                    return true;
                } catch (Exception e) {
                    this.f183f.put(iA, false);
                    throw new E1.a(e, i5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
