package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.concurrent.locks.Lock;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0526v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0525u f3126a = new C0525u();

    @Nullable
    public static com.bumptech.glide.load.engine.O convert(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Drawable drawable, int i5, int i6) {
        Bitmap bitmapDrawToBitmap;
        Drawable current = drawable.getCurrent();
        boolean z6 = false;
        if (current instanceof BitmapDrawable) {
            bitmapDrawToBitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapDrawToBitmap = null;
        } else {
            bitmapDrawToBitmap = drawToBitmap(cVar, current, i5, i6);
            z6 = true;
        }
        if (!z6) {
            cVar = f3126a;
        }
        return C0510e.obtain(bitmapDrawToBitmap, cVar);
    }

    @Nullable
    private static Bitmap drawToBitmap(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Drawable drawable, int i5, int i6) {
        if (i5 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i6 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i5 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        Lock lock = T.d;
        lock.lock();
        Bitmap bitmap = cVar.get(i5, i6, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i5, i6);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmap;
        } finally {
            lock.unlock();
        }
    }
}
