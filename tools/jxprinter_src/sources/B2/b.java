package B2;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends a implements Animatable, ValueAnimator.AnimatorUpdateListener {
    public final ValueAnimator e;
    public int b = 0;
    public int c = 0;
    public int d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f89f = new Path();

    public b() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(30, 3600);
        this.e = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(10000L);
        valueAnimatorOfInt.setInterpolator(null);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f6 = iWidth;
        float fMax = Math.max(1.0f, f6 / 22.0f);
        int i5 = this.b;
        Path path = this.f89f;
        if (i5 != iWidth || this.c != iHeight) {
            path.reset();
            float f7 = f6 - fMax;
            float f8 = iHeight / 2.0f;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(f7, f8, fMax, direction);
            float f9 = f6 - (5.0f * fMax);
            path.addRect(f9, f8 - fMax, f7, f8 + fMax, direction);
            path.addCircle(f9, f8, fMax, direction);
            this.b = iWidth;
            this.c = iHeight;
        }
        canvas.save();
        float f10 = f6 / 2.0f;
        float f11 = iHeight / 2.0f;
        canvas.rotate(this.d, f10, f11);
        for (int i6 = 0; i6 < 12; i6++) {
            Paint paint = this.f88a;
            paint.setAlpha((i6 + 5) * 17);
            canvas.rotate(30.0f, f10, f11);
            canvas.drawPath(path, paint);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator.isRunning()) {
            return;
        }
        valueAnimator.addUpdateListener(this);
        valueAnimator.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator.isRunning()) {
            valueAnimator.removeAllListeners();
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.cancel();
        }
    }
}
