package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class T {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paint f3097a = new Paint(6);
    public static final Paint b = new Paint(7);
    public static final Paint c;
    public static final Lock d;

    static {
        d = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079")).contains(Build.MODEL) ? new ReentrantLock() : new S();
        Paint paint = new Paint(7);
        c = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    private static void applyMatrix(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f3097a);
            canvas.setBitmap(null);
        } finally {
            lock.unlock();
        }
    }

    public static Bitmap centerCrop(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        float width;
        float height;
        if (bitmap.getWidth() == i5 && bitmap.getHeight() == i6) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i6 > bitmap.getHeight() * i5) {
            width = i6 / bitmap.getHeight();
            width2 = (i5 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i5 / bitmap.getWidth();
            height = (i6 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmap2 = cVar.get(i5, i6, getNonNullConfig(bitmap));
        bitmap2.setHasAlpha(bitmap.hasAlpha());
        applyMatrix(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap centerInside(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        if (bitmap.getWidth() > i5 || bitmap.getHeight() > i6) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return fitCenter(cVar, bitmap, i5, i6);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static Bitmap circleCrop(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        int iMin = Math.min(i5, i6);
        float f6 = iMin;
        float f7 = f6 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f6 / width, f6 / height);
        float f8 = width * fMax;
        float f9 = fMax * height;
        float f10 = (f6 - f8) / 2.0f;
        float f11 = (f6 - f9) / 2.0f;
        RectF rectF = new RectF(f10, f11, f8 + f10, f9 + f11);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(cVar, bitmap);
        Bitmap bitmap2 = cVar.get(iMin, iMin, getAlphaSafeConfig(bitmap));
        bitmap2.setHasAlpha(true);
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawCircle(f7, f7, f7, b);
            canvas.drawBitmap(alphaSafeBitmap, (Rect) null, rectF, c);
            canvas.setBitmap(null);
            lock.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                cVar.b(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public static Bitmap fitCenter(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6) {
        if (bitmap.getWidth() != i5 || bitmap.getHeight() != i6) {
            float fMin = Math.min(i5 / bitmap.getWidth(), i6 / bitmap.getHeight());
            int iRound = Math.round(bitmap.getWidth() * fMin);
            int iRound2 = Math.round(bitmap.getHeight() * fMin);
            if (bitmap.getWidth() != iRound || bitmap.getHeight() != iRound2) {
                Bitmap bitmap2 = cVar.get((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), getNonNullConfig(bitmap));
                bitmap2.setHasAlpha(bitmap.hasAlpha());
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i5 + "x" + i6);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + bitmap2.getWidth() + "x" + bitmap2.getHeight());
                    StringBuilder sb = new StringBuilder("minPct:   ");
                    sb.append(fMin);
                    Log.v("TransformationUtils", sb.toString());
                }
                Matrix matrix = new Matrix();
                matrix.setScale(fMin, fMin);
                applyMatrix(bitmap, bitmap2, matrix);
                return bitmap2;
            }
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
        } else if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
        return bitmap;
    }

    private static Bitmap getAlphaSafeBitmap(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap) {
        Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        if (alphaSafeConfig.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmap2 = cVar.get(bitmap.getWidth(), bitmap.getHeight(), alphaSafeConfig);
        new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmap2;
    }

    @NonNull
    private static Bitmap.Config getAlphaSafeConfig(@NonNull Bitmap bitmap) {
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        return config.equals(bitmap.getConfig()) ? config : Bitmap.Config.ARGB_8888;
    }

    @NonNull
    private static Bitmap.Config getNonNullConfig(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    public static void initializeMatrixForRotation(int i5, Matrix matrix) {
        switch (i5) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static Bitmap rotateImage(@NonNull Bitmap bitmap, int i5) {
        Bitmap bitmap2;
        if (i5 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i5);
            bitmap2 = bitmap;
            try {
                return Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                if (!Log.isLoggable("TransformationUtils", 6)) {
                    return bitmap2;
                }
                Log.e("TransformationUtils", "Exception when trying to orient image", exc);
                return bitmap2;
            }
        } catch (Exception e6) {
            e = e6;
            bitmap2 = bitmap;
        }
    }

    public static Bitmap rotateImageExif(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5) {
        switch (i5) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                Matrix matrix = new Matrix();
                initializeMatrixForRotation(i5, matrix);
                RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
                matrix.mapRect(rectF);
                Bitmap bitmap2 = cVar.get(Math.round(rectF.width()), Math.round(rectF.height()), getNonNullConfig(bitmap));
                matrix.postTranslate(-rectF.left, -rectF.top);
                bitmap2.setHasAlpha(bitmap.hasAlpha());
                applyMatrix(bitmap, bitmap2, matrix);
                return bitmap2;
            default:
                return bitmap;
        }
    }

    @Deprecated
    public static Bitmap roundedCorners(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5, int i6, int i7) {
        return roundedCorners(cVar, bitmap, i7);
    }

    public static Bitmap roundedCorners(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, int i5) {
        L0.q.checkArgument(i5 > 0, "roundingRadius must be greater than 0.");
        return roundedCorners(cVar, bitmap, new J0.f(i5));
    }

    public static Bitmap roundedCorners(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, float f6, float f7, float f8, float f9) {
        return roundedCorners(cVar, bitmap, new P(f6, f7, f8, f9));
    }

    private static Bitmap roundedCorners(@NonNull com.bumptech.glide.load.engine.bitmap_recycle.c cVar, @NonNull Bitmap bitmap, Q q6) {
        Bitmap.Config alphaSafeConfig = getAlphaSafeConfig(bitmap);
        Bitmap alphaSafeBitmap = getAlphaSafeBitmap(cVar, bitmap);
        Bitmap bitmap2 = cVar.get(alphaSafeBitmap.getWidth(), alphaSafeBitmap.getHeight(), alphaSafeConfig);
        bitmap2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(alphaSafeBitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight());
        Lock lock = d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            q6.a(canvas, paint, rectF);
            canvas.setBitmap(null);
            lock.unlock();
            if (!alphaSafeBitmap.equals(bitmap)) {
                cVar.b(alphaSafeBitmap);
            }
            return bitmap2;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }
}
