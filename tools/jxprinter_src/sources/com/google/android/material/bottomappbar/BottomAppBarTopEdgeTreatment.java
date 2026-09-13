package com.google.android.material.bottomappbar;

import A3.AbstractC0157z;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f6, float f7, float f8) {
        this.fabMargin = f6;
        this.roundedCornerRadius = f7;
        setCradleVerticalOffset(f8);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f6, float f7, float f8, @NonNull ShapePath shapePath) {
        float f9;
        float f10;
        float f11 = this.fabDiameter;
        if (f11 == 0.0f) {
            shapePath.lineTo(f6, 0.0f);
            return;
        }
        float f12 = ((this.fabMargin * 2.0f) + f11) / 2.0f;
        float f13 = f8 * this.roundedCornerRadius;
        float f14 = f7 + this.horizontalOffset;
        float fA = AbstractC0157z.a(1.0f, f8, f12, this.cradleVerticalOffset * f8);
        if (fA / f12 >= 1.0f) {
            shapePath.lineTo(f6, 0.0f);
            return;
        }
        float f15 = this.fabCornerSize;
        float f16 = f15 * f8;
        boolean z6 = f15 == -1.0f || Math.abs((f15 * 2.0f) - f11) < 0.1f;
        if (z6) {
            f9 = fA;
            f10 = 0.0f;
        } else {
            f10 = ROUNDED_CORNER_FAB_OFFSET;
            f9 = 0.0f;
        }
        float f17 = f12 + f13;
        float f18 = f9 + f13;
        float fSqrt = (float) Math.sqrt((f17 * f17) - (f18 * f18));
        float f19 = f14 - fSqrt;
        float f20 = f14 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f18));
        float f21 = (90.0f - degrees) + f10;
        shapePath.lineTo(f19, 0.0f);
        float f22 = f19 - f13;
        float f23 = f19 + f13;
        float f24 = f13 * 2.0f;
        shapePath.addArc(f22, 0.0f, f23, f24, 270.0f, degrees);
        if (z6) {
            shapePath.addArc(f14 - f12, (-f12) - f9, f14 + f12, f12 - f9, 180.0f - f21, (f21 * 2.0f) - 180.0f);
        } else {
            float f25 = this.fabMargin;
            float f26 = f16 * 2.0f;
            float f27 = f25 + f26;
            float f28 = f14 - f12;
            shapePath.addArc(f28, -(f16 + f25), f27 + f28, f25 + f16, 180.0f - f21, ((f21 * 2.0f) - 180.0f) / 2.0f);
            float f29 = f14 + f12;
            float f30 = this.fabMargin;
            shapePath.lineTo(f29 - ((f30 / 2.0f) + f16), f30 + f16);
            float f31 = this.fabMargin;
            shapePath.addArc(f29 - (f26 + f31), -(f16 + f31), f29, f31 + f16, 90.0f, f21 - 90.0f);
        }
        shapePath.addArc(f20 - f13, 0.0f, f20 + f13, f24, 270.0f - degrees, degrees);
        shapePath.lineTo(f6, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f6) {
        if (f6 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f6;
    }

    public void setFabCornerSize(float f6) {
        this.fabCornerSize = f6;
    }

    public void setFabCradleMargin(float f6) {
        this.fabMargin = f6;
    }

    public void setFabCradleRoundedCornerRadius(float f6) {
        this.roundedCornerRadius = f6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f6) {
        this.fabDiameter = f6;
    }

    public void setHorizontalOffset(float f6) {
        this.horizontalOffset = f6;
    }
}
