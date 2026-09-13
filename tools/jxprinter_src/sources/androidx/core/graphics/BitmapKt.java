package androidx.core.graphics;

import O3.l;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i5;
        int width = bitmap.getWidth();
        int i6 = point.x;
        return i6 >= 0 && i6 < width && (i5 = point.y) >= 0 && i5 < bitmap.getHeight();
    }

    public static final Bitmap createBitmap(int i5, int i6, Bitmap.Config config) {
        return Bitmap.createBitmap(i5, i6, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i5, int i6, Bitmap.Config config, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i5, i6, config);
    }

    public static final int get(Bitmap bitmap, int i5, int i6) {
        return bitmap.getPixel(i5, i6);
    }

    public static final Bitmap scale(Bitmap bitmap, int i5, int i6, boolean z6) {
        return Bitmap.createScaledBitmap(bitmap, i5, i6, z6);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i5, int i6, boolean z6, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            z6 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i5, i6, z6);
    }

    public static final void set(Bitmap bitmap, int i5, int i6, @ColorInt int i7) {
        bitmap.setPixel(i5, i6, i7);
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f6 = pointF.x;
        if (f6 < 0.0f || f6 >= bitmap.getWidth()) {
            return false;
        }
        float f7 = pointF.y;
        return f7 >= 0.0f && f7 < ((float) bitmap.getHeight());
    }

    @RequiresApi(26)
    public static final Bitmap createBitmap(int i5, int i6, Bitmap.Config config, boolean z6, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i5, i6, config, z6, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i5, int i6, Bitmap.Config config, boolean z6, ColorSpace colorSpace, int i7, Object obj) {
        if ((i7 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i7 & 8) != 0) {
            z6 = true;
        }
        if ((i7 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i5, i6, config, z6, colorSpace);
    }
}
