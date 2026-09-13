package Y3;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f874a = 0;
    private static final ThreadLocal<DecimalFormat>[] precisionFormats;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i5 = 0; i5 < 4; i5++) {
            threadLocalArr[i5] = new ThreadLocal<>();
        }
        precisionFormats = threadLocalArr;
    }

    public static final String formatToExactDecimals(double d, int i5) {
        DecimalFormat decimalFormat;
        ThreadLocal<DecimalFormat>[] threadLocalArr = precisionFormats;
        if (i5 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i5];
            DecimalFormat decimalFormat2 = threadLocal.get();
            if (decimalFormat2 == null) {
                decimalFormat2 = new DecimalFormat("0");
                if (i5 > 0) {
                    decimalFormat2.setMinimumFractionDigits(i5);
                }
                decimalFormat2.setRoundingMode(RoundingMode.HALF_UP);
                threadLocal.set(decimalFormat2);
            }
            decimalFormat = decimalFormat2;
        } else {
            decimalFormat = new DecimalFormat("0");
            if (i5 > 0) {
                decimalFormat.setMinimumFractionDigits(i5);
            }
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        }
        String str = decimalFormat.format(d);
        E.e(str, "format(...)");
        return str;
    }
}
