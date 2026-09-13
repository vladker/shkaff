package com.gzwx.image;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class GzwxImage {
    public static final GzwxImage INSTANCE = new GzwxImage();

    static {
        System.loadLibrary("gzwx_image_android");
    }

    public final native Bitmap asyncPhotoRegionBinarize(Bitmap bitmap, String str, float f6);

    public final native Bitmap asyncPhotoTextBackgroundBinarize(Bitmap bitmap, String str, float f6);

    public final native Bitmap asyncTextMaskBinarize(Bitmap bitmap);

    public final native Bitmap floyedSteinbergBinarize(Bitmap bitmap);

    public final native Bitmap imageBinarize(Bitmap bitmap);

    public final native Bitmap jarvisDithering(Bitmap bitmap);
}
