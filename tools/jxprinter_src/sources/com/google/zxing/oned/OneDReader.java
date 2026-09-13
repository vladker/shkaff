package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OneDReader implements Reader {
    private Result doDecode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2;
        int i5;
        Map<DecodeHintType, ?> map3 = map;
        int width = binaryBitmap.getWidth();
        int height = binaryBitmap.getHeight();
        BitArray bitArray = new BitArray(width);
        int i6 = height >> 1;
        int i7 = 1;
        boolean z6 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, height >> (z6 ? 8 : 5));
        int i8 = z6 ? height : 15;
        int i9 = 0;
        while (i9 < i8) {
            int i10 = i9 + 1;
            int i11 = i10 / 2;
            if ((i9 & 1) != 0) {
                i11 = -i11;
            }
            int i12 = (i11 * iMax) + i6;
            if (i12 < 0 || i12 >= height) {
                break;
            }
            try {
                bitArray = binaryBitmap.getBlackRow(i12, bitArray);
                int i13 = 0;
                while (i13 < 2) {
                    if (i13 == i7) {
                        bitArray.reverse();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        Result resultDecodeRow = decodeRow(i12, bitArray, map3);
                        if (i13 == i7) {
                            try {
                                resultDecodeRow.putMetadata(ResultMetadataType.ORIENTATION, 180);
                                ResultPoint[] resultPoints = resultDecodeRow.getResultPoints();
                                if (resultPoints != null) {
                                    i5 = i7;
                                    float f6 = width;
                                    try {
                                        map2 = map3;
                                        try {
                                            try {
                                                resultPoints[0] = new ResultPoint((f6 - resultPoints[0].getX()) - 1.0f, resultPoints[0].getY());
                                                resultPoints[i5] = new ResultPoint((f6 - resultPoints[i5].getX()) - 1.0f, resultPoints[i5].getY());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i13++;
                                                map3 = map2;
                                                i7 = i5;
                                                width = width;
                                            }
                                        } catch (ReaderException unused2) {
                                            i13++;
                                            map3 = map2;
                                            i7 = i5;
                                            width = width;
                                        }
                                    } catch (ReaderException unused3) {
                                        map2 = map3;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                map2 = map3;
                                i5 = i7;
                            }
                        }
                        return resultDecodeRow;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i5 = i7;
                    }
                }
            } catch (NotFoundException unused6) {
            }
            i9 = i10;
            i7 = i7;
            width = width;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static float patternMatchVariance(int[] iArr, int[] iArr2, float f6) {
        int length = iArr.length;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            i5 += iArr[i7];
            i6 += iArr2[i7];
        }
        if (i5 < i6) {
            return Float.POSITIVE_INFINITY;
        }
        float f7 = i5;
        float f8 = f7 / i6;
        float f9 = f6 * f8;
        float f10 = 0.0f;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = iArr[i8];
            float f11 = iArr2[i8] * f8;
            float f12 = i9;
            float f13 = f12 > f11 ? f12 - f11 : f11 - f12;
            if (f13 > f9) {
                return Float.POSITIVE_INFINITY;
            }
            f10 += f13;
        }
        return f10 / f7;
    }

    public static void recordPattern(BitArray bitArray, int i5, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i6 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int size = bitArray.getSize();
        if (i5 >= size) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z6 = !bitArray.get(i5);
        while (i5 < size) {
            if (!(bitArray.get(i5) ^ z6)) {
                i6++;
                if (i6 == length) {
                    break;
                }
                iArr[i6] = 1;
                z6 = !z6;
            } else {
                iArr[i6] = iArr[i6] + 1;
            }
            i5++;
        }
        if (i6 != length) {
            if (i6 != length - 1 || i5 != size) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void recordPatternInReverse(BitArray bitArray, int i5, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean z6 = bitArray.get(i5);
        while (i5 > 0 && length >= 0) {
            i5--;
            if (bitArray.get(i5) != z6) {
                length--;
                z6 = !z6;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        recordPattern(bitArray, i5 + 1, iArr);
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    public abstract Result decodeRow(int i5, BitArray bitArray, Map<DecodeHintType, ?> map);

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return doDecode(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !binaryBitmap.isRotateSupported()) {
                throw e;
            }
            BinaryBitmap binaryBitmapRotateCounterClockwise = binaryBitmap.rotateCounterClockwise();
            Result resultDoDecode = doDecode(binaryBitmapRotateCounterClockwise, map);
            Map<ResultMetadataType, Object> resultMetadata = resultDoDecode.getResultMetadata();
            int iIntValue = 270;
            if (resultMetadata != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (resultMetadata.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) resultMetadata.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            resultDoDecode.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            ResultPoint[] resultPoints = resultDoDecode.getResultPoints();
            if (resultPoints != null) {
                int height = binaryBitmapRotateCounterClockwise.getHeight();
                for (int i5 = 0; i5 < resultPoints.length; i5++) {
                    resultPoints[i5] = new ResultPoint((height - resultPoints[i5].getY()) - 1.0f, resultPoints[i5].getX());
                }
            }
            return resultDoDecode;
        }
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }
}
