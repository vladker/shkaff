package S1;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f624f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f625g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double[][] f626a;
    public Object[] b;
    public int c;
    public double d;
    public final int e;

    public g() {
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, 2, 0);
        this.f626a = dArr;
        this.b = new Object[dArr.length];
        this.c = 0;
        this.d = 1.0d;
        this.e = 2;
    }

    public final void a(double[] dArr, Object obj) {
        if (dArr == null) {
            throw new IllegalArgumentException("Point cannot be null.");
        }
        if (dArr.length < this.e) {
            throw new IllegalArgumentException("p.length >= dimension required");
        }
        int i5 = this.c;
        if (i5 == 0) {
            obj = f624f;
        }
        int i6 = i5 + 1;
        double[][] dArr2 = this.f626a;
        if (dArr2.length < i6) {
            int length = dArr2.length * 2;
            if (length >= i6) {
                i6 = length;
            }
            double[][] dArr3 = new double[i6][];
            for (int i7 = 0; i7 < this.c; i7++) {
                dArr3[i7] = this.f626a[i7];
            }
            Object[] objArr = new Object[i6];
            for (int i8 = 0; i8 < this.c; i8++) {
                objArr[i8] = this.b[i8];
            }
            this.f626a = dArr3;
            this.b = objArr;
        }
        double[][] dArr4 = this.f626a;
        int i9 = this.c;
        dArr4[i9] = dArr;
        this.b[i9] = obj;
        this.c = i9 + 1;
    }
}
