package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfDMatch extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 5;

    public MatOfDMatch() {
    }

    public static MatOfDMatch fromNativeAddr(long j6) {
        return new MatOfDMatch(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(5, 4));
        }
    }

    public void fromArray(DMatch... dMatchArr) {
        if (dMatchArr == null || dMatchArr.length == 0) {
            return;
        }
        int length = dMatchArr.length;
        alloc(length);
        float[] fArr = new float[length * 4];
        for (int i5 = 0; i5 < length; i5++) {
            DMatch dMatch = dMatchArr[i5];
            int i6 = i5 * 4;
            fArr[i6] = dMatch.queryIdx;
            fArr[i6 + 1] = dMatch.trainIdx;
            fArr[i6 + 2] = dMatch.imgIdx;
            fArr[i6 + 3] = dMatch.distance;
        }
        put(0, 0, fArr);
    }

    public void fromList(List<DMatch> list) {
        fromArray((DMatch[]) list.toArray(new DMatch[0]));
    }

    public DMatch[] toArray() {
        int i5 = (int) total();
        DMatch[] dMatchArr = new DMatch[i5];
        if (i5 != 0) {
            float[] fArr = new float[i5 * 4];
            get(0, 0, fArr);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i6 * 4;
                dMatchArr[i6] = new DMatch((int) fArr[i7], (int) fArr[i7 + 1], (int) fArr[i7 + 2], fArr[i7 + 3]);
            }
        }
        return dMatchArr;
    }

    public List<DMatch> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfDMatch(long j6) {
        super(j6);
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException("Incompatible Mat: " + toString());
    }

    public MatOfDMatch(Mat mat) {
        super(mat, Range.all());
        if (empty() || checkVector(4, 5) >= 0) {
            return;
        }
        throw new IllegalArgumentException("Incompatible Mat: " + toString());
    }

    public MatOfDMatch(DMatch... dMatchArr) {
        fromArray(dMatchArr);
    }
}
