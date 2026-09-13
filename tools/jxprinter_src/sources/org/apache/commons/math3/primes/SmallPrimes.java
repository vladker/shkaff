package org.apache.commons.math3.primes;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.PointerIconCompat;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.zxing.pdf417.PDF417Common;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.FastMath;
import org.apache.poi.util.CodePageUtil;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class SmallPrimes {
    public static final int[] PRIMES;
    public static final int PRIMES_LAST;

    static {
        int[] iArr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, Videoio.CAP_PROP_XI_GPO_SELECTOR, Videoio.CAP_PROP_XI_AEAG_LEVEL, 421, Videoio.CAP_PROP_XI_DECIMATION_SELECTOR, Videoio.CAP_PROP_XI_DECIMATION_HORIZONTAL, Videoio.CAP_PROP_XI_AEAG_ROI_OFFSET_X, 443, Videoio.CAP_PROP_XI_WB_KG, 457, Videoio.CAP_PROP_XI_OUTPUT_DATA_BIT_DEPTH, Videoio.CAP_PROP_XI_OUTPUT_DATA_PACKING, Videoio.CAP_PROP_XI_TARGET_TEMP, Videoio.CAP_PROP_XI_CC_MATRIX_00, Videoio.CAP_PROP_XI_CC_MATRIX_20, Videoio.CAP_PROP_XI_CC_MATRIX_30, Videoio.CAP_PROP_XI_ACQ_FRAME_BURST_COUNT, TypedValues.PositionType.TYPE_PERCENT_WIDTH, 509, Videoio.CAP_PROP_XI_DEVICE_MODEL_ID, 523, Videoio.CAP_PROP_XI_LUT_EN, Videoio.CAP_PROP_XI_IS_DEVICE_EXIST, 557, Videoio.CAP_PROP_XI_KNEEPOINT1, 569, Videoio.CAP_PROP_XI_HW_REVISION, 577, Videoio.CAP_PROP_XI_TEST_PATTERN_GENERATOR_SELECTOR, 593, 599, 601, TypedValues.MotionType.TYPE_PATHMOTION_ARC, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, TypedValues.TransitionType.TYPE_FROM, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, PDF417Common.NUMBER_OF_CODEWORDS, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, PointerIconCompat.TYPE_VERTICAL_TEXT, PointerIconCompat.TYPE_ALL_SCROLL, PointerIconCompat.TYPE_ZOOM_OUT, PointerIconCompat.TYPE_GRABBING, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, CodePageUtil.CP_UTF16_BE, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, CodePageUtil.CP_JOHAB, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749, 2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909, 2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083, 3089, 3109, 3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203, 3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259, 3271, 3299, 3301, 3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359, 3361, 3371, 3373, 3389, 3391, 3407, 3413, 3433, 3449, 3457, 3461, 3463, 3467, 3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547, 3557, 3559, 3571, 3581, 3583, 3593, 3607, 3613, 3617, 3623, 3631, 3637, 3643, 3659, 3671};
        PRIMES = iArr;
        PRIMES_LAST = iArr[iArr.length - 1];
    }

    private SmallPrimes() {
    }

    public static int boundedTrialDivision(int i5, int i6, List<Integer> list) {
        for (int i7 = PRIMES_LAST + 2; i7 <= i6; i7 += 6) {
            if (i5 % i7 == 0) {
                i5 /= i7;
                list.add(Integer.valueOf(i7));
                break;
            }
            int i8 = i7 + 4;
            if (i5 % i8 == 0) {
                i5 /= i8;
                list.add(Integer.valueOf(i8));
                break;
            }
        }
        if (i5 != 1) {
            list.add(Integer.valueOf(i5));
        }
        return i5;
    }

    public static boolean millerRabinPrimeTest(int i5) {
        int i6 = i5 - 1;
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i6);
        int i7 = i6 >> iNumberOfTrailingZeros;
        int i8 = i5 >= 2047 ? 2 : 1;
        if (i5 >= 1373653) {
            i8 = 3;
        }
        if (i5 >= 25326001) {
            i8 = 4;
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(i7);
        long j6 = i5;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(j6);
        for (int i9 = 0; i9 < i8; i9++) {
            int iIntValue = BigInteger.valueOf(PRIMES[i9]).modPow(bigIntegerValueOf, bigIntegerValueOf2).intValue();
            if (1 != iIntValue && iIntValue != i6) {
                for (int i10 = 1; i10 <= iNumberOfTrailingZeros - 1 && i6 != iIntValue; i10++) {
                    long j7 = iIntValue;
                    iIntValue = (int) ((j7 * j7) % j6);
                    if (1 == iIntValue) {
                        return false;
                    }
                }
                if (i6 != iIntValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int smallTrialDivision(int i5, List<Integer> list) {
        for (int i6 : PRIMES) {
            while (i5 % i6 == 0) {
                i5 /= i6;
                list.add(Integer.valueOf(i6));
            }
        }
        return i5;
    }

    public static List<Integer> trialDivision(int i5) {
        ArrayList arrayList = new ArrayList(32);
        int iSmallTrialDivision = smallTrialDivision(i5, arrayList);
        if (1 == iSmallTrialDivision) {
            return arrayList;
        }
        boundedTrialDivision(iSmallTrialDivision, (int) FastMath.sqrt(iSmallTrialDivision), arrayList);
        return arrayList;
    }
}
