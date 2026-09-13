package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    private static final int MAX_DEPTH = 4;
    private static final int MIN_DIMENSION_TO_RECUR = 100;
    private final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i5, int i6, int i7) {
        int i8;
        if (i7 > 4) {
            return;
        }
        try {
            Result resultDecode = this.delegate.decode(binaryBitmap, map);
            Iterator<Result> it = list.iterator();
            do {
                if (!it.hasNext()) {
                    list.add(translateResultPoints(resultDecode, i5, i6));
                    break;
                }
            } while (!it.next().getText().equals(resultDecode.getText()));
            ResultPoint[] resultPoints = resultDecode.getResultPoints();
            if (resultPoints == null || resultPoints.length == 0) {
                return;
            }
            int width = binaryBitmap.getWidth();
            int height = binaryBitmap.getHeight();
            float f6 = width;
            float f7 = height;
            float f8 = 0.0f;
            float f9 = 0.0f;
            for (ResultPoint resultPoint : resultPoints) {
                if (resultPoint != null) {
                    float x6 = resultPoint.getX();
                    float y6 = resultPoint.getY();
                    if (x6 < f6) {
                        f6 = x6;
                    }
                    if (y6 < f7) {
                        f7 = y6;
                    }
                    if (x6 > f8) {
                        f8 = x6;
                    }
                    if (y6 > f9) {
                        f9 = y6;
                    }
                }
            }
            if (f6 > 100.0f) {
                i8 = 0;
                doDecodeMultiple(binaryBitmap.crop(0, 0, (int) f6, height), map, list, i5, i6, i7 + 1);
            } else {
                i8 = 0;
            }
            if (f7 > 100.0f) {
                doDecodeMultiple(binaryBitmap.crop(i8, i8, width, (int) f7), map, list, i5, i6, i7 + 1);
            }
            if (f8 < width - 100) {
                int i9 = (int) f8;
                doDecodeMultiple(binaryBitmap.crop(i9, 0, width - i9, height), map, list, i5 + i9, i6, i7 + 1);
            }
            if (f9 < height - 100) {
                int i10 = (int) f9;
                doDecodeMultiple(binaryBitmap.crop(0, i10, width, height - i10), map, list, i5, i6 + i10, i7 + 1);
            }
        } catch (ReaderException unused) {
        }
    }

    private static Result translateResultPoints(Result result, int i5, int i6) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i7 = 0; i7 < resultPoints.length; i7++) {
            ResultPoint resultPoint = resultPoints[i7];
            if (resultPoint != null) {
                resultPointArr[i7] = new ResultPoint(resultPoint.getX() + i5, resultPoint.getY() + i6);
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) {
        return decodeMultiple(binaryBitmap, null);
    }

    @Override // com.google.zxing.multi.MultipleBarcodeReader
    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (arrayList.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
    }
}
