package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f6, float f7, float f8, float f9) {
        return f7 > f9 ? new PointF(f8, f7) : new PointF(f6, f9);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f6, float f7, float f8, float f9) {
        Path path = new Path();
        path.moveTo(f6, f7);
        PointF controlPoint = getControlPoint(f6, f7, f8, f9);
        path.quadTo(controlPoint.x, controlPoint.y, f8, f9);
        return path;
    }
}
