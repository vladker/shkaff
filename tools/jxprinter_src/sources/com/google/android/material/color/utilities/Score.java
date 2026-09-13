package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double d) {
            this.hct = hct;
            this.score = d;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5) {
        return score(map, i5, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5, int i6) {
        return score(map, i5, i6, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i5, int i6, boolean z6) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d = 0.0d;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Hct hctFromInt = Hct.fromInt(entry.getKey().intValue());
            arrayList.add(hctFromInt);
            int iFloor = (int) Math.floor(hctFromInt.getHue());
            int iIntValue = entry.getValue().intValue();
            iArr[iFloor] = iArr[iFloor] + iIntValue;
            d += (double) iIntValue;
        }
        double[] dArr = new double[360];
        int i7 = 0;
        for (int i8 = 0; i8 < 360; i8++) {
            double d6 = ((double) iArr[i8]) / d;
            for (int i9 = i8 - 14; i9 < i8 + 16; i9++) {
                int iSanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i9);
                dArr[iSanitizeDegreesInt] = dArr[iSanitizeDegreesInt] + d6;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj2 = arrayList.get(i10);
            i10++;
            Hct hct = (Hct) obj2;
            double d7 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z6 || (hct.getChroma() >= CUTOFF_CHROMA && d7 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : 0.3d)) + (d7 * 100.0d * WEIGHT_PROPORTION)));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i11 = 90; i11 >= 15; i11--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i12 = 0;
            while (i12 < size2) {
                Object obj3 = arrayList2.get(i12);
                i12++;
                Hct hct2 = ((ScoredHCT) obj3).hct;
                int size3 = arrayList3.size();
                int i13 = 0;
                do {
                    if (i13 >= size3) {
                        arrayList3.add(hct2);
                        break;
                    }
                    obj = arrayList3.get(i13);
                    i13++;
                } while (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) obj).getHue()) >= i11);
                if (arrayList3.size() >= i5) {
                    break;
                }
            }
            if (arrayList3.size() >= i5) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i6));
            return arrayList4;
        }
        int size4 = arrayList3.size();
        while (i7 < size4) {
            Object obj4 = arrayList3.get(i7);
            i7++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).toInt()));
        }
        return arrayList4;
    }
}
