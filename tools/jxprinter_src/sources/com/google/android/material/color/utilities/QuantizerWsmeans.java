package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i5) {
        char c;
        double[] dArr;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr2 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            c = 1;
            if (i6 >= iArr.length) {
                break;
            }
            int i8 = iArr[i6];
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i8));
            if (num == null) {
                dArr2[i7] = pointProviderLab.fromInt(i8);
                iArr3[i7] = i8;
                i7++;
                linkedHashMap.put(Integer.valueOf(i8), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i8), Integer.valueOf(num.intValue() + 1));
            }
            i6++;
        }
        int[] iArr4 = new int[i7];
        for (int i9 = 0; i9 < i7; i9++) {
            iArr4[i9] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i9]))).intValue();
        }
        int iMin = Math.min(i5, i7);
        if (iArr2.length != 0) {
            iMin = Math.min(iMin, iArr2.length);
        }
        double[][] dArr3 = new double[iMin][];
        int i10 = 0;
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            dArr3[i11] = pointProviderLab.fromInt(iArr2[i11]);
            i10++;
        }
        int i12 = iMin - i10;
        if (i12 > 0) {
            for (int i13 = 0; i13 < i12; i13++) {
            }
        }
        int[] iArr5 = new int[i7];
        for (int i14 = 0; i14 < i7; i14++) {
            iArr5[i14] = random.nextInt(iMin);
        }
        int[][] iArr6 = new int[iMin][];
        for (int i15 = 0; i15 < iMin; i15++) {
            iArr6[i15] = new int[iMin];
        }
        Distance[][] distanceArr = new Distance[iMin][];
        for (int i16 = 0; i16 < iMin; i16++) {
            distanceArr[i16] = new Distance[iMin];
            for (int i17 = 0; i17 < iMin; i17++) {
                distanceArr[i16][i17] = new Distance();
            }
        }
        int[] iArr7 = new int[iMin];
        int i18 = 0;
        while (i18 < 10) {
            int i19 = 0;
            while (i19 < iMin) {
                int i20 = i19 + 1;
                int i21 = i20;
                while (i21 < iMin) {
                    int[] iArr8 = iArr4;
                    double dDistance = pointProviderLab.distance(dArr3[i19], dArr3[i21]);
                    Distance distance = distanceArr[i21][i19];
                    distance.distance = dDistance;
                    distance.index = i19;
                    Distance distance2 = distanceArr[i19][i21];
                    distance2.distance = dDistance;
                    distance2.index = i21;
                    i21++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                    c = c;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                char c6 = c;
                Arrays.sort(distanceArr[i19]);
                for (int i22 = 0; i22 < iMin; i22++) {
                    iArr6[i19][i22] = distanceArr[i19][i22].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i19 = i20;
                c = c6;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            char c7 = c;
            int i23 = 0;
            int i24 = 0;
            while (i23 < i7) {
                double[] dArr4 = dArr2[i23];
                int i25 = iArr12[i23];
                double dDistance2 = pointProviderLab.distance(dArr4, dArr3[i25]);
                int i26 = i23;
                double d = dDistance2;
                int i27 = -1;
                int i28 = 0;
                while (i28 < iMin) {
                    int i29 = i24;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i25][i28].distance < 4.0d * dDistance2) {
                        double dDistance3 = pointProviderLab.distance(dArr4, dArr3[i28]);
                        if (dDistance3 < d) {
                            d = dDistance3;
                            i27 = i28;
                        }
                    }
                    i28++;
                    iArr6 = iArr13;
                    i24 = i29;
                }
                int i30 = i24;
                int[][] iArr14 = iArr6;
                if (i27 == -1 || Math.abs(Math.sqrt(d) - Math.sqrt(dDistance2)) <= 3.0d) {
                    i24 = i30;
                } else {
                    i24 = i30 + 1;
                    iArr12[i26] = i27;
                }
                i23 = i26 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i24 == 0 && i18 != 0) {
                break;
            }
            double[] dArr5 = new double[iMin];
            double[] dArr6 = new double[iMin];
            double[] dArr7 = new double[iMin];
            boolean z6 = false;
            Arrays.fill(iArr7, 0);
            int i31 = 0;
            while (i31 < i7) {
                int i32 = iArr12[i31];
                double[] dArr8 = dArr2[i31];
                boolean z7 = z6;
                int i33 = iArr11[i31];
                iArr7[i32] = iArr7[i32] + i33;
                double d6 = i33;
                dArr5[i32] = (dArr8[z7 ? 1 : 0] * d6) + dArr5[i32];
                dArr6[i32] = (dArr8[c7] * d6) + dArr6[i32];
                dArr7[i32] = (dArr8[2] * d6) + dArr7[i32];
                i31++;
                z6 = false;
            }
            int i34 = 0;
            while (i34 < iMin) {
                int i35 = iArr7[i34];
                if (i35 == 0) {
                    dArr3[i34] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                } else {
                    double d7 = dArr5[i34];
                    dArr = dArr6;
                    double d8 = i35;
                    double d9 = d7 / d8;
                    double d10 = dArr[i34] / d8;
                    double d11 = dArr7[i34] / d8;
                    double[] dArr9 = dArr3[i34];
                    dArr9[0] = d9;
                    dArr9[c7] = d10;
                    dArr9[2] = d11;
                }
                i34++;
                dArr5 = dArr5;
                dArr6 = dArr;
            }
            i18++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            c = c7;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i36 = 0; i36 < iMin; i36++) {
            int i37 = iArr7[i36];
            if (i37 != 0) {
                int i38 = pointProviderLab.toInt(dArr3[i36]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i38))) {
                    linkedHashMap2.put(Integer.valueOf(i38), Integer.valueOf(i37));
                }
            }
        }
        return linkedHashMap2;
    }
}
