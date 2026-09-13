package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction;

        static {
            int[] iArr = new int[Direction.values().length];
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = iArr;
            try {
                iArr[Direction.RED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CreateBoxesResult {
        int resultCount;

        public CreateBoxesResult(int i5, int i6) {
            this.resultCount = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Direction {
        RED,
        GREEN,
        BLUE
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class MaximizeResult {
        int cutLocation;
        double maximum;

        public MaximizeResult(int i5, double d) {
            this.cutLocation = i5;
            this.maximum = d;
        }
    }

    public static int bottom(Box box, Direction direction, int[] iArr) {
        int i5;
        int i6;
        int i7 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i7 == 1) {
            i5 = (-iArr[getIndex(box.f3328r0, box.g1, box.b1)]) + iArr[getIndex(box.f3328r0, box.g1, box.f3326b0)] + iArr[getIndex(box.f3328r0, box.f3327g0, box.b1)];
            i6 = iArr[getIndex(box.f3328r0, box.f3327g0, box.f3326b0)];
        } else if (i7 == 2) {
            i5 = (-iArr[getIndex(box.f3329r1, box.f3327g0, box.b1)]) + iArr[getIndex(box.f3329r1, box.f3327g0, box.f3326b0)] + iArr[getIndex(box.f3328r0, box.f3327g0, box.b1)];
            i6 = iArr[getIndex(box.f3328r0, box.f3327g0, box.f3326b0)];
        } else {
            if (i7 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i5 = (-iArr[getIndex(box.f3329r1, box.g1, box.f3326b0)]) + iArr[getIndex(box.f3329r1, box.f3327g0, box.f3326b0)] + iArr[getIndex(box.f3328r0, box.g1, box.f3326b0)];
            i6 = iArr[getIndex(box.f3328r0, box.f3327g0, box.f3326b0)];
        }
        return i5 - i6;
    }

    public static int getIndex(int i5, int i6, int i7) {
        return (i5 << 10) + (i5 << 6) + i5 + (i6 << 5) + i6 + i7;
    }

    public static int top(Box box, Direction direction, int i5, int[] iArr) {
        int i6;
        int i7;
        int i8 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction.ordinal()];
        if (i8 == 1) {
            i6 = (iArr[getIndex(i5, box.g1, box.b1)] - iArr[getIndex(i5, box.g1, box.f3326b0)]) - iArr[getIndex(i5, box.f3327g0, box.b1)];
            i7 = iArr[getIndex(i5, box.f3327g0, box.f3326b0)];
        } else if (i8 == 2) {
            i6 = (iArr[getIndex(box.f3329r1, i5, box.b1)] - iArr[getIndex(box.f3329r1, i5, box.f3326b0)]) - iArr[getIndex(box.f3328r0, i5, box.b1)];
            i7 = iArr[getIndex(box.f3328r0, i5, box.f3326b0)];
        } else {
            if (i8 != 3) {
                throw new IllegalArgumentException("unexpected direction " + direction);
            }
            i6 = (iArr[getIndex(box.f3329r1, box.g1, i5)] - iArr[getIndex(box.f3329r1, box.f3327g0, i5)]) - iArr[getIndex(box.f3328r0, box.g1, i5)];
            i7 = iArr[getIndex(box.f3328r0, box.f3327g0, i5)];
        }
        return i6 + i7;
    }

    public static int volume(Box box, int[] iArr) {
        return ((((((iArr[getIndex(box.f3329r1, box.g1, box.b1)] - iArr[getIndex(box.f3329r1, box.g1, box.f3326b0)]) - iArr[getIndex(box.f3329r1, box.f3327g0, box.b1)]) + iArr[getIndex(box.f3329r1, box.f3327g0, box.f3326b0)]) - iArr[getIndex(box.f3328r0, box.g1, box.b1)]) + iArr[getIndex(box.f3328r0, box.g1, box.f3326b0)]) + iArr[getIndex(box.f3328r0, box.f3327g0, box.b1)]) - iArr[getIndex(box.f3328r0, box.f3327g0, box.f3326b0)];
    }

    public void constructHistogram(Map<Integer, Integer> map) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int iRedFromArgb = ColorUtils.redFromArgb(iIntValue);
            int iGreenFromArgb = ColorUtils.greenFromArgb(iIntValue);
            int iBlueFromArgb = ColorUtils.blueFromArgb(iIntValue);
            int index = getIndex((iRedFromArgb >> 3) + 1, (iGreenFromArgb >> 3) + 1, (iBlueFromArgb >> 3) + 1);
            int[] iArr = this.weights;
            iArr[index] = iArr[index] + iIntValue2;
            int[] iArr2 = this.momentsR;
            iArr2[index] = (iRedFromArgb * iIntValue2) + iArr2[index];
            int[] iArr3 = this.momentsG;
            iArr3[index] = (iGreenFromArgb * iIntValue2) + iArr3[index];
            int[] iArr4 = this.momentsB;
            iArr4[index] = (iBlueFromArgb * iIntValue2) + iArr4[index];
            double[] dArr = this.moments;
            int i5 = iBlueFromArgb * iBlueFromArgb;
            dArr[index] = dArr[index] + ((double) ((i5 + (iGreenFromArgb * iGreenFromArgb) + (iRedFromArgb * iRedFromArgb)) * iIntValue2));
        }
    }

    public CreateBoxesResult createBoxes(int i5) {
        int i6;
        this.cubes = new Box[i5];
        for (int i7 = 0; i7 < i5; i7++) {
            this.cubes[i7] = new Box(null);
        }
        double[] dArr = new double[i5];
        Box box = this.cubes[0];
        box.f3329r1 = 32;
        box.g1 = 32;
        box.b1 = 32;
        int i8 = 0;
        int i9 = 1;
        while (i9 < i5) {
            Box[] boxArr = this.cubes;
            if (cut(boxArr[i8], boxArr[i9]).booleanValue()) {
                Box box2 = this.cubes[i8];
                dArr[i8] = box2.vol > 1 ? variance(box2) : 0.0d;
                Box box3 = this.cubes[i9];
                dArr[i9] = box3.vol > 1 ? variance(box3) : 0.0d;
            } else {
                dArr[i8] = 0.0d;
                i9--;
            }
            double d = dArr[0];
            int i10 = 0;
            for (int i11 = 1; i11 <= i9; i11++) {
                double d6 = dArr[i11];
                if (d6 > d) {
                    i10 = i11;
                    d = d6;
                }
            }
            if (d <= 0.0d) {
                i6 = i9 + 1;
                return new CreateBoxesResult(i5, i6);
            }
            i9++;
            i8 = i10;
        }
        i6 = i5;
        return new CreateBoxesResult(i5, i6);
    }

    public void createMoments() {
        int i5 = 1;
        while (true) {
            int i6 = 33;
            if (i5 >= 33) {
                return;
            }
            int[] iArr = new int[33];
            int[] iArr2 = new int[33];
            int[] iArr3 = new int[33];
            int[] iArr4 = new int[33];
            double[] dArr = new double[33];
            int i7 = 1;
            while (i7 < i6) {
                int i8 = 0;
                int i9 = 0;
                double d = 0.0d;
                int i10 = 1;
                int i11 = 0;
                int i12 = 0;
                while (i10 < i6) {
                    int index = getIndex(i5, i7, i10);
                    i8 += this.weights[index];
                    i11 += this.momentsR[index];
                    i12 += this.momentsG[index];
                    i9 += this.momentsB[index];
                    d += this.moments[index];
                    iArr[i10] = iArr[i10] + i8;
                    iArr2[i10] = iArr2[i10] + i11;
                    iArr3[i10] = iArr3[i10] + i12;
                    iArr4[i10] = iArr4[i10] + i9;
                    dArr[i10] = dArr[i10] + d;
                    int index2 = getIndex(i5 - 1, i7, i10);
                    int i13 = i10;
                    int[] iArr5 = this.weights;
                    iArr5[index] = iArr5[index2] + iArr[i13];
                    int[] iArr6 = this.momentsR;
                    iArr6[index] = iArr6[index2] + iArr2[i13];
                    int[] iArr7 = this.momentsG;
                    iArr7[index] = iArr7[index2] + iArr3[i13];
                    int[] iArr8 = this.momentsB;
                    iArr8[index] = iArr8[index2] + iArr4[i13];
                    double[] dArr2 = this.moments;
                    dArr2[index] = dArr2[index2] + dArr[i13];
                    i10 = i13 + 1;
                    i6 = 33;
                }
                i7++;
                i6 = 33;
            }
            i5++;
        }
    }

    public List<Integer> createResult(int i5) {
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < i5; i6++) {
            Box box = this.cubes[i6];
            int iVolume = volume(box, this.weights);
            if (iVolume > 0) {
                int iVolume2 = volume(box, this.momentsR) / iVolume;
                int iVolume3 = volume(box, this.momentsG) / iVolume;
                arrayList.add(Integer.valueOf(((volume(box, this.momentsB) / iVolume) & 255) | ((iVolume2 & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((iVolume3 & 255) << 8)));
            }
        }
        return arrayList;
    }

    public Boolean cut(Box box, Box box2) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int iVolume4 = volume(box, this.weights);
        Direction direction = Direction.RED;
        MaximizeResult maximizeResultMaximize = maximize(box, direction, box.f3328r0 + 1, box.f3329r1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction2 = Direction.GREEN;
        MaximizeResult maximizeResultMaximize2 = maximize(box, direction2, box.f3327g0 + 1, box.g1, iVolume, iVolume2, iVolume3, iVolume4);
        Direction direction3 = Direction.BLUE;
        MaximizeResult maximizeResultMaximize3 = maximize(box, direction3, box.f3326b0 + 1, box.b1, iVolume, iVolume2, iVolume3, iVolume4);
        double d = maximizeResultMaximize.maximum;
        double d6 = maximizeResultMaximize2.maximum;
        double d7 = maximizeResultMaximize3.maximum;
        if (d < d6 || d < d7) {
            if (d6 >= d && d6 >= d7) {
                direction3 = direction2;
            }
        } else {
            if (maximizeResultMaximize.cutLocation < 0) {
                return Boolean.FALSE;
            }
            direction3 = direction;
        }
        box2.f3329r1 = box.f3329r1;
        box2.g1 = box.g1;
        box2.b1 = box.b1;
        int i5 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[direction3.ordinal()];
        if (i5 == 1) {
            int i6 = maximizeResultMaximize.cutLocation;
            box.f3329r1 = i6;
            box2.f3328r0 = i6;
            box2.f3327g0 = box.f3327g0;
            box2.f3326b0 = box.f3326b0;
        } else if (i5 == 2) {
            int i7 = maximizeResultMaximize2.cutLocation;
            box.g1 = i7;
            box2.f3328r0 = box.f3328r0;
            box2.f3327g0 = i7;
            box2.f3326b0 = box.f3326b0;
        } else if (i5 == 3) {
            int i8 = maximizeResultMaximize3.cutLocation;
            box.b1 = i8;
            box2.f3328r0 = box.f3328r0;
            box2.f3327g0 = box.f3327g0;
            box2.f3326b0 = i8;
        }
        box.vol = (box.b1 - box.f3326b0) * (box.g1 - box.f3327g0) * (box.f3329r1 - box.f3328r0);
        box2.vol = (box2.b1 - box2.f3326b0) * (box2.g1 - box2.f3327g0) * (box2.f3329r1 - box2.f3328r0);
        return Boolean.TRUE;
    }

    public MaximizeResult maximize(Box box, Direction direction, int i5, int i6, int i7, int i8, int i9, int i10) {
        QuantizerWu quantizerWu = this;
        Box box2 = box;
        int iBottom = bottom(box2, direction, quantizerWu.momentsR);
        int iBottom2 = bottom(box2, direction, quantizerWu.momentsG);
        int iBottom3 = bottom(box2, direction, quantizerWu.momentsB);
        int iBottom4 = bottom(box2, direction, quantizerWu.weights);
        int i11 = -1;
        double d = 0.0d;
        int i12 = i5;
        while (i12 < i6) {
            int pVar = top(box2, direction, i12, quantizerWu.momentsR) + iBottom;
            int pVar2 = top(box2, direction, i12, quantizerWu.momentsG) + iBottom2;
            int pVar3 = top(box2, direction, i12, quantizerWu.momentsB) + iBottom3;
            int pVar4 = top(box2, direction, i12, quantizerWu.weights) + iBottom4;
            if (pVar4 != 0) {
                double d6 = ((double) ((pVar3 * pVar3) + ((pVar2 * pVar2) + (pVar * pVar)))) / ((double) pVar4);
                int i13 = i7 - pVar;
                int i14 = i8 - pVar2;
                int i15 = i9 - pVar3;
                int i16 = i10 - pVar4;
                if (i16 != 0) {
                    double d7 = (((double) ((i15 * i15) + ((i14 * i14) + (i13 * i13)))) / ((double) i16)) + d6;
                    if (d7 > d) {
                        i11 = i12;
                        d = d7;
                    }
                }
            }
            i12++;
            quantizerWu = this;
            box2 = box;
        }
        return new MaximizeResult(i11, d);
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] iArr, int i5) {
        constructHistogram(new QuantizerMap().quantize(iArr, i5).colorToCount);
        createMoments();
        List<Integer> listCreateResult = createResult(createBoxes(i5).resultCount);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Integer num : listCreateResult) {
            num.intValue();
            linkedHashMap.put(num, 0);
        }
        return new QuantizerResult(linkedHashMap);
    }

    public double variance(Box box) {
        int iVolume = volume(box, this.momentsR);
        int iVolume2 = volume(box, this.momentsG);
        int iVolume3 = volume(box, this.momentsB);
        int i5 = iVolume3 * iVolume3;
        return (((((((this.moments[getIndex(box.f3329r1, box.g1, box.b1)] - this.moments[getIndex(box.f3329r1, box.g1, box.f3326b0)]) - this.moments[getIndex(box.f3329r1, box.f3327g0, box.b1)]) + this.moments[getIndex(box.f3329r1, box.f3327g0, box.f3326b0)]) - this.moments[getIndex(box.f3328r0, box.g1, box.b1)]) + this.moments[getIndex(box.f3328r0, box.g1, box.f3326b0)]) + this.moments[getIndex(box.f3328r0, box.f3327g0, box.b1)]) - this.moments[getIndex(box.f3328r0, box.f3327g0, box.f3326b0)]) - (((double) (i5 + ((iVolume2 * iVolume2) + (iVolume * iVolume)))) / ((double) volume(box, this.weights)));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Box {

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        int f3326b0;
        int b1;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        int f3327g0;
        int g1;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        int f3328r0;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        int f3329r1;
        int vol;

        private Box() {
            this.f3328r0 = 0;
            this.f3329r1 = 0;
            this.f3327g0 = 0;
            this.g1 = 0;
            this.f3326b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }

        public /* synthetic */ Box(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
