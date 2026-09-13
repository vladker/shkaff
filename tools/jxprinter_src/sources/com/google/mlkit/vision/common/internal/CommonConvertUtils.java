package com.google.mlkit.vision.common.internal;

import A3.AbstractC0157z;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.Image;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_vision_common.zzms;
import com.google.android.gms.internal.mlkit_vision_common.zzmu;
import com.google.android.gms.internal.mlkit_vision_common.zzmw;
import com.google.android.odml.image.BitmapExtractor;
import com.google.android.odml.image.ByteBufferExtractor;
import com.google.android.odml.image.ImageProperties;
import com.google.android.odml.image.MediaImageExtractor;
import com.google.android.odml.image.MlImage;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public class CommonConvertUtils {
    @Nullable
    @KeepForSdk
    public static InputImage convertMlImagetoInputImage(@NonNull MlImage mlImage) {
        InputImage inputImageFromBitmap;
        Integer numValueOf;
        ImageProperties imageProperties = mlImage.getContainedImageProperties().get(0);
        int storageType = imageProperties.getStorageType();
        if (storageType != 1) {
            inputImageFromBitmap = null;
            if (storageType == 2) {
                ByteBuffer byteBufferExtract = ByteBufferExtractor.extract(mlImage);
                int imageFormat = imageProperties.getImageFormat();
                if (imageFormat != 4) {
                    numValueOf = imageFormat != 5 ? null : Integer.valueOf(InputImage.IMAGE_FORMAT_YV12);
                } else {
                    numValueOf = 17;
                }
                if (numValueOf != null) {
                    zza(numValueOf.intValue(), 3, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), byteBufferExtract.limit(), mlImage.getRotation());
                    inputImageFromBitmap = InputImage.fromByteBuffer(byteBufferExtract, mlImage.getWidth(), mlImage.getHeight(), mlImage.getRotation(), numValueOf.intValue());
                }
            } else if (storageType == 3) {
                Image imageExtract = MediaImageExtractor.extract(mlImage);
                zza(imageExtract.getFormat(), 5, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), imageExtract.getFormat() == 256 ? imageExtract.getPlanes()[0].getBuffer().limit() : (imageExtract.getPlanes()[0].getBuffer().limit() * 3) / 2, mlImage.getRotation());
                inputImageFromBitmap = InputImage.fromMediaImage(imageExtract, mlImage.getRotation());
            }
        } else {
            Bitmap bitmapExtract = BitmapExtractor.extract(mlImage);
            zza(-1, 1, SystemClock.elapsedRealtime(), mlImage.getHeight(), mlImage.getWidth(), bitmapExtract.getAllocationByteCount(), mlImage.getRotation());
            inputImageFromBitmap = InputImage.fromBitmap(bitmapExtract, mlImage.getRotation());
        }
        if (inputImageFromBitmap != null) {
            zzmw.zza();
        }
        return inputImageFromBitmap;
    }

    @KeepForSdk
    public static int convertToAndroidImageFormat(@InputImage.ImageFormat int i5) {
        int i6 = 17;
        if (i5 != 17) {
            i6 = 35;
            if (i5 != 35) {
                i6 = InputImage.IMAGE_FORMAT_YV12;
                if (i5 != 842094169) {
                    return 0;
                }
            }
        }
        return i6;
    }

    @KeepForSdk
    public static int convertToMVRotation(int i5) {
        if (i5 == 0) {
            return 0;
        }
        if (i5 == 90) {
            return 1;
        }
        if (i5 == 180) {
            return 2;
        }
        if (i5 == 270) {
            return 3;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid rotation: "));
    }

    @KeepForSdk
    public static void transformPointArray(@NonNull Point[] pointArr, @NonNull Matrix matrix) {
        int length = pointArr.length;
        float[] fArr = new float[length + length];
        for (int i5 = 0; i5 < pointArr.length; i5++) {
            Point point = pointArr[i5];
            int i6 = i5 + i5;
            fArr[i6] = point.x;
            fArr[i6 + 1] = point.y;
        }
        matrix.mapPoints(fArr);
        for (int i7 = 0; i7 < pointArr.length; i7++) {
            int i8 = i7 + i7;
            pointArr[i7].set((int) fArr[i8], (int) fArr[i8 + 1]);
        }
    }

    @KeepForSdk
    public static void transformPointF(@NonNull PointF pointF, @NonNull Matrix matrix) {
        float[] fArr = {pointF.x, pointF.y};
        matrix.mapPoints(fArr);
        pointF.set(fArr[0], fArr[1]);
    }

    @KeepForSdk
    public static void transformPointList(@NonNull List<PointF> list, @NonNull Matrix matrix) {
        int size = list.size();
        float[] fArr = new float[size + size];
        for (int i5 = 0; i5 < list.size(); i5++) {
            int i6 = i5 + i5;
            fArr[i6] = list.get(i5).x;
            fArr[i6 + 1] = list.get(i5).y;
        }
        matrix.mapPoints(fArr);
        for (int i7 = 0; i7 < list.size(); i7++) {
            int i8 = i7 + i7;
            list.get(i7).set(fArr[i8], fArr[i8 + 1]);
        }
    }

    @KeepForSdk
    public static void transformRect(@NonNull Rect rect, @NonNull Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    private static void zza(int i5, int i6, long j6, int i7, int i8, int i9, int i10) {
        zzmu.zzb(zzms.zzb("vision-common"), i5, i6, j6, i7, i8, i9, i10);
    }
}
