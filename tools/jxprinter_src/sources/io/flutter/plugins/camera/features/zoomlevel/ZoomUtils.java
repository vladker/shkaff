package io.flutter.plugins.camera.features.zoomlevel;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class ZoomUtils {
    public static Float computeZoomRatio(float f6, float f7, float f8) {
        return Float.valueOf(MathUtils.clamp(f6, f7, f8));
    }

    public static Rect computeZoomRect(float f6, @NonNull Rect rect, float f7, float f8) {
        float fFloatValue = computeZoomRatio(f6, f7, f8).floatValue();
        int iWidth = rect.width() / 2;
        int iHeight = rect.height() / 2;
        int iWidth2 = (int) ((rect.width() * 0.5f) / fFloatValue);
        int iHeight2 = (int) ((rect.height() * 0.5f) / fFloatValue);
        return new Rect(iWidth - iWidth2, iHeight - iHeight2, iWidth + iWidth2, iHeight + iHeight2);
    }
}
