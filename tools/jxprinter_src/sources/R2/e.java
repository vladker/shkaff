package R2;

import A3.AbstractC0157z;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.TypedValue;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.soundcloud.android.crop.CropImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f590a;
    public Rect b;
    public Matrix c;
    public RectF d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f593h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f594i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f595j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f596k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f598m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f599n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f600o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f601p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f602q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f603r;
    public final Paint e = new Paint();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f591f = new Paint();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f592g = new Paint();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f597l = 1;

    public e(CropImageView cropImageView) {
        this.f598m = 1;
        this.f593h = cropImageView;
        Context context = cropImageView.getContext();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(j.cropImageStyle, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(typedValue.resourceId, n.CropImageView);
        try {
            this.f594i = typedArrayObtainStyledAttributes.getBoolean(n.CropImageView_showThirds, false);
            this.f595j = typedArrayObtainStyledAttributes.getBoolean(n.CropImageView_showCircle, false);
            this.f596k = typedArrayObtainStyledAttributes.getColor(n.CropImageView_highlightColor, -13388315);
            int[] iArr = new int[3];
            System.arraycopy(p050j.n.f5389a, 0, iArr, 0, 3);
            this.f598m = iArr[typedArrayObtainStyledAttributes.getInt(n.CropImageView_showHandles, 0)];
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @SuppressLint({"NewApi"})
    private boolean isClipPathSupported(Canvas canvas) {
        return true;
    }

    public final Rect a() {
        RectF rectF = this.f590a;
        RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.c.mapRect(rectF2);
        return new Rect(Math.round(rectF2.left), Math.round(rectF2.top), Math.round(rectF2.right), Math.round(rectF2.bottom));
    }

    public final void b(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Path path = new Path();
        float f6 = this.f602q;
        Paint paint = this.f591f;
        paint.setStrokeWidth(f6);
        if (!this.f603r) {
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(this.b, paint);
            return;
        }
        Rect rect = new Rect();
        this.f593h.getDrawingRect(rect);
        path.addRect(new RectF(this.b), Path.Direction.CW);
        paint.setColor(this.f596k);
        boolean zIsClipPathSupported = isClipPathSupported(canvas);
        Paint paint2 = this.e;
        if (zIsClipPathSupported) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, paint2);
            canvas2 = canvas;
        } else {
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), this.b.top, paint2);
            canvas2 = canvas;
            canvas.drawRect(0.0f, this.b.bottom, canvas2.getWidth(), canvas2.getHeight(), paint2);
            Rect rect2 = this.b;
            canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom, paint2);
            Rect rect3 = this.b;
            canvas.drawRect(rect3.right, rect3.top, canvas2.getWidth(), this.b.bottom, paint2);
        }
        canvas2.restore();
        canvas2.drawPath(path, paint);
        if (this.f594i) {
            paint.setStrokeWidth(1.0f);
            Rect rect4 = this.b;
            int i5 = rect4.right;
            int i6 = rect4.left;
            float f7 = (i5 - i6) / 3;
            int i7 = rect4.bottom;
            int i8 = rect4.top;
            float f8 = (i7 - i8) / 3;
            float f9 = i6 + f7;
            canvas2.drawLine(f9, i8, f9, i7, paint);
            Rect rect5 = this.b;
            float f10 = rect5.left + (f7 * 2.0f);
            canvas2.drawLine(f10, rect5.top, f10, rect5.bottom, paint);
            Rect rect6 = this.b;
            float f11 = rect6.left;
            float f12 = rect6.top + f8;
            canvas2.drawLine(f11, f12, rect6.right, f12, paint);
            Rect rect7 = this.b;
            float f13 = rect7.left;
            float f14 = rect7.top + (f8 * 2.0f);
            canvas2.drawLine(f13, f14, rect7.right, f14, paint);
        }
        if (this.f595j) {
            paint.setStrokeWidth(1.0f);
            canvas2.drawOval(new RectF(this.b), paint);
        }
        int i9 = this.f598m;
        if (i9 == 2 || (i9 == 1 && this.f597l == 3)) {
            Rect rect8 = this.b;
            int i10 = rect8.left;
            int iB = AbstractC0157z.b(rect8.right, i10, 2, i10);
            int i11 = rect8.top;
            int iB2 = AbstractC0157z.b(rect8.bottom, i11, 2, i11);
            float f15 = i10;
            float f16 = iB2;
            float f17 = this.f601p;
            Paint paint3 = this.f592g;
            canvas2.drawCircle(f15, f16, f17, paint3);
            float f18 = iB;
            canvas2.drawCircle(f18, this.b.top, this.f601p, paint3);
            canvas2.drawCircle(this.b.right, f16, this.f601p, paint3);
            canvas2.drawCircle(f18, this.b.bottom, this.f601p, paint3);
        }
    }
}
