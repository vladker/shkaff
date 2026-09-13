package org.opencv.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class MatOfByte extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 0;

    public MatOfByte() {
    }

    public static MatOfByte fromNativeAddr(long j6) {
        return new MatOfByte(j6);
    }

    public void alloc(int i5) {
        if (i5 > 0) {
            super.create(i5, 1, CvType.makeType(0, 1));
        }
    }

    public void fromArray(byte... bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        alloc(bArr.length);
        put(0, 0, bArr);
    }

    public void fromList(List<Byte> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Byte[] bArr = (Byte[]) list.toArray(new Byte[0]);
        byte[] bArr2 = new byte[bArr.length];
        for (int i5 = 0; i5 < bArr.length; i5++) {
            bArr2[i5] = bArr[i5].byteValue();
        }
        fromArray(bArr2);
    }

    public byte[] toArray() {
        int iCheckVector = checkVector(1, 0);
        if (iCheckVector < 0) {
            throw new RuntimeException("Native Mat has unexpected type or size: " + toString());
        }
        byte[] bArr = new byte[iCheckVector];
        if (iCheckVector == 0) {
            return bArr;
        }
        get(0, 0, bArr);
        return bArr;
    }

    public List<Byte> toList() {
        byte[] array = toArray();
        Byte[] bArr = new Byte[array.length];
        for (int i5 = 0; i5 < array.length; i5++) {
            bArr[i5] = Byte.valueOf(array[i5]);
        }
        return Arrays.asList(bArr);
    }

    public MatOfByte(long j6) {
        super(j6);
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfByte(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public void fromArray(int i5, int i6, byte... bArr) {
        if (i5 >= 0) {
            bArr.getClass();
            if (i6 >= 0 && i6 + i5 <= bArr.length) {
                if (bArr.length == 0) {
                    return;
                }
                alloc(i6);
                put(0, 0, bArr, i5, i6);
                return;
            }
            throw new IllegalArgumentException("invalid 'length' parameter: " + Integer.toString(i6));
        }
        throw new IllegalArgumentException("offset < 0");
    }

    public MatOfByte(byte... bArr) {
        fromArray(bArr);
    }

    public MatOfByte(int i5, int i6, byte... bArr) {
        fromArray(i5, i6, bArr);
    }
}
