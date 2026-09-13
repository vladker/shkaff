package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f6, float f7, @ColorInt int i5, @Px int i6, @Px int i7) {
        float f8 = f7 >= f6 ? f7 - f6 : (f7 + 1.0f) - f6;
        float f9 = f6 % 1.0f;
        if (this.totalTrackLengthFraction < 1.0f) {
            float f10 = f9 + f8;
            if (f10 > 1.0f) {
                drawArc(canvas, paint, f9, 1.0f, i5, i6, 0);
                drawArc(canvas, paint, 1.0f, f10, i5, 0, i7);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        if (f9 == 0.0f && f8 >= 0.99f) {
            f8 += (((degrees * 2.0f) / 360.0f) * (f8 - 0.99f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
        }
        float fLerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f9);
        float fLerp2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f8);
        float degrees2 = (float) Math.toDegrees(i6 / this.adjustedRadius);
        float degrees3 = ((fLerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i7 / this.adjustedRadius));
        float f11 = (fLerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i5);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f12 = degrees * 2.0f;
        if (degrees3 < f12) {
            float f13 = degrees3 / f12;
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, (degrees * f13) + f11, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, f13);
            return;
        }
        float f14 = this.adjustedRadius;
        RectF rectF = new RectF(-f14, -f14, f14, f14);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f15 = f11 + degrees;
        canvas.drawArc(rectF, f15, degrees3 - f12, false, paint);
        if (this.useStrokeCap || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, f15, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (f11 + degrees3) - degrees, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f6, float f7, float f8) {
        drawRoundedBlock(canvas, paint, f6, f7, f8, 1.0f);
    }

    private int getSize() {
        S s6 = this.spec;
        return (((CircularProgressIndicatorSpec) s6).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s6).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6, boolean z6, boolean z7) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        S s6 = this.spec;
        float f7 = (((CircularProgressIndicatorSpec) s6).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s6).indicatorInset;
        canvas.translate((f7 * fWidth) + rect.left, (f7 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f8 = -f7;
        canvas.clipRect(f8, f8, f7, f7);
        S s7 = this.spec;
        this.useStrokeCap = ((CircularProgressIndicatorSpec) s7).trackThickness / 2 <= ((CircularProgressIndicatorSpec) s7).trackCornerRadius;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s7).trackThickness * f6;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s7).trackThickness / 2, ((CircularProgressIndicatorSpec) s7).trackCornerRadius) * f6;
        S s8 = this.spec;
        float f9 = (((CircularProgressIndicatorSpec) s8).indicatorSize - ((CircularProgressIndicatorSpec) s8).trackThickness) / 2.0f;
        this.adjustedRadius = f9;
        if (z6 || z7) {
            if ((z6 && ((CircularProgressIndicatorSpec) s8).showAnimationBehavior == 2) || (z7 && ((CircularProgressIndicatorSpec) s8).hideAnimationBehavior == 1)) {
                this.adjustedRadius = (((1.0f - f6) * ((CircularProgressIndicatorSpec) s8).trackThickness) / 2.0f) + f9;
            } else if ((z6 && ((CircularProgressIndicatorSpec) s8).showAnimationBehavior == 1) || (z7 && ((CircularProgressIndicatorSpec) s8).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f9 - (((1.0f - f6) * ((CircularProgressIndicatorSpec) s8).trackThickness) / 2.0f);
            }
        }
        if (z7 && ((CircularProgressIndicatorSpec) s8).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f6;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i5) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i5);
        float f6 = activeIndicator.startFraction;
        float f7 = activeIndicator.endFraction;
        int i6 = activeIndicator.gapSize;
        drawArc(canvas, paint, f6, f7, iCompositeARGBWithAlpha, i6, i6);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f6, float f7, @ColorInt int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6, int i7) {
        drawArc(canvas, paint, f6, f7, MaterialColors.compositeARGBWithAlpha(i5, i6), i7, i7);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f6, float f7, float f8, float f9) {
        float fMin = (int) Math.min(f8, this.displayedTrackThickness);
        float f10 = f7 / 2.0f;
        float fMin2 = Math.min(f10, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f7) / 2.0f, fMin / 2.0f, f10);
        canvas.save();
        double d = f6;
        canvas.translate((float) (Math.cos(Math.toRadians(d)) * ((double) this.adjustedRadius)), (float) (Math.sin(Math.toRadians(d)) * ((double) this.adjustedRadius)));
        canvas.rotate(f6);
        canvas.scale(f9, f9);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i5, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i6) {
    }
}
