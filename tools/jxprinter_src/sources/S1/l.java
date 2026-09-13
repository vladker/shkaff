package S1;

import A3.AbstractC0157z;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f633a;
    public double[] b;

    public l() {
        this.f633a = 0;
        this.b = new double[2];
    }

    public final void a(double d) {
        int i5 = this.f633a;
        if (i5 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.l(")", this.f633a, AbstractC0157z.t(i5, "required: (index >= 0 && index <= size) but: (index = ", ", size = ")));
        }
        int i6 = i5 + 1;
        double[] dArr = this.b;
        if (dArr.length < i6) {
            int length = dArr.length * 2;
            if (length >= i6) {
                i6 = length;
            }
            double[] dArr2 = new double[i6];
            for (int i7 = 0; i7 < this.f633a; i7++) {
                dArr2[i7] = this.b[i7];
            }
            this.b = dArr2;
        }
        for (int i8 = this.f633a; i8 > i5; i8--) {
            double[] dArr3 = this.b;
            dArr3[i8] = dArr3[i8 - 1];
        }
        this.b[i5] = d;
        this.f633a++;
    }

    public final double b(int i5) {
        if (i5 >= 0 && i5 < this.f633a) {
            return this.b[i5];
        }
        throw new IllegalArgumentException(AbstractC0157z.l(")", this.f633a, AbstractC0157z.t(i5, "required: (index >= 0 && index < size) but: (index = ", ", size = ")));
    }

    public l(double[] dArr, int i5) {
        this.f633a = 0;
        this.b = null;
        if (i5 >= 0 && i5 <= dArr.length) {
            this.b = dArr;
            this.f633a = i5;
            return;
        }
        throw new IllegalArgumentException("size >= 0 && size <= value.length required");
    }
}
