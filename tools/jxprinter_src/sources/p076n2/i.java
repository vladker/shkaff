package p076n2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.library.base.view.refreshlayout.RefreshLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends Drawable implements Animatable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LinearInterpolator f6244k = new LinearInterpolator();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final g f6245l = new g(0);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final g f6246m = new g(1);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AccelerateDecelerateInterpolator f6247n = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6248a;
    public final h b;
    public float c;
    public final Resources d;
    public final RefreshLayout e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f6249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f6251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f6252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f6253j;

    public i(Context context, RefreshLayout refreshLayout) {
        int[] iArr = {ViewCompat.MEASURED_STATE_MASK};
        this.f6248a = new ArrayList();
        f fVar = new f(this);
        this.e = refreshLayout;
        this.d = context.getResources();
        h hVar = new h(fVar);
        this.b = hVar;
        hVar.setColors(iArr);
        updateSizes(1);
        b bVar = new b(this, hVar);
        bVar.setInterpolator(f6247n);
        bVar.setDuration(666L);
        bVar.setAnimationListener(new c(this, hVar));
        d dVar = new d(this, hVar);
        dVar.setRepeatCount(-1);
        dVar.setRepeatMode(1);
        dVar.setInterpolator(f6244k);
        dVar.setDuration(1333L);
        dVar.setAnimationListener(new e(this, hVar));
        this.f6253j = bVar;
        this.f6249f = dVar;
    }

    public final void a(double d, double d6, double d7, double d8, float f6, float f7) {
        float f8 = this.d.getDisplayMetrics().density;
        double d9 = f8;
        this.f6251h = d * d9;
        this.f6252i = d6 * d9;
        float f9 = ((float) d8) * f8;
        h hVar = this.b;
        hVar.f6228h = f9;
        hVar.b.setStrokeWidth(f9);
        hVar.a();
        hVar.f6238r = d7 * d9;
        hVar.f6231k = 0;
        hVar.f6239s = (int) (f6 * f8);
        hVar.f6240t = (int) (f7 * f8);
        float fMin = Math.min((int) this.f6251h, (int) this.f6252i);
        double d10 = hVar.f6238r;
        hVar.f6229i = (d10 <= 0.0d || fMin < 0.0f) ? (float) Math.ceil(hVar.f6228h / 2.0f) : (float) (((double) (fMin / 2.0f)) - d10);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iSave = canvas.save();
        canvas.rotate(this.c, bounds.exactCenterX(), bounds.exactCenterY());
        h hVar = this.b;
        Paint paint = hVar.f6242v;
        RectF rectF = hVar.f6225a;
        rectF.set(bounds);
        float f6 = hVar.f6229i;
        rectF.inset(f6, f6);
        float f7 = hVar.e;
        float f8 = hVar.f6227g;
        float f9 = (f7 + f8) * 360.0f;
        float f10 = ((hVar.f6226f + f8) * 360.0f) - f9;
        Paint paint2 = hVar.b;
        paint2.setColor(hVar.f6230j[hVar.f6231k]);
        canvas.drawArc(rectF, f9, f10, false, paint2);
        Paint paint3 = hVar.c;
        if (hVar.f6235o) {
            Path path = hVar.f6236p;
            if (path == null) {
                Path path2 = new Path();
                hVar.f6236p = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float f11 = (((int) hVar.f6229i) / 2) * hVar.f6237q;
            float fCos = (float) ((Math.cos(0.0d) * hVar.f6238r) + ((double) bounds.exactCenterX()));
            float fSin = (float) ((Math.sin(0.0d) * hVar.f6238r) + ((double) bounds.exactCenterY()));
            hVar.f6236p.moveTo(0.0f, 0.0f);
            hVar.f6236p.lineTo(hVar.f6239s * hVar.f6237q, 0.0f);
            Path path3 = hVar.f6236p;
            float f12 = hVar.f6239s;
            float f13 = hVar.f6237q;
            path3.lineTo((f12 * f13) / 2.0f, hVar.f6240t * f13);
            hVar.f6236p.offset(fCos - f11, fSin);
            hVar.f6236p.close();
            paint3.setColor(hVar.f6230j[hVar.f6231k]);
            canvas.rotate((f9 + f10) - 5.0f, bounds.exactCenterX(), bounds.exactCenterY());
            canvas.drawPath(hVar.f6236p, paint3);
        }
        if (hVar.f6241u < 255) {
            paint.setColor(hVar.f6243w);
            paint.setAlpha(255 - hVar.f6241u);
            canvas.drawCircle(bounds.exactCenterX(), bounds.exactCenterY(), bounds.width() / 2, paint);
        }
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.b.f6241u;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f6252i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return (int) this.f6251h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        ArrayList arrayList = this.f6248a;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Animation animation = (Animation) arrayList.get(i5);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i5) {
        this.b.f6241u = i5;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        h hVar = this.b;
        hVar.b.setColorFilter(colorFilter);
        hVar.a();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f6249f.reset();
        h hVar = this.b;
        float f6 = hVar.e;
        hVar.f6232l = f6;
        float f7 = hVar.f6226f;
        hVar.f6233m = f7;
        hVar.f6234n = hVar.f6227g;
        RefreshLayout refreshLayout = this.e;
        if (f7 != f6) {
            refreshLayout.startAnimation(this.f6253j);
            return;
        }
        hVar.f6231k = 0;
        hVar.f6232l = 0.0f;
        hVar.f6233m = 0.0f;
        hVar.f6234n = 0.0f;
        hVar.e = 0.0f;
        hVar.a();
        hVar.f6226f = 0.0f;
        hVar.a();
        hVar.f6227g = 0.0f;
        hVar.a();
        refreshLayout.startAnimation(this.f6249f);
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.e.clearAnimation();
        this.c = 0.0f;
        invalidateSelf();
        h hVar = this.b;
        if (hVar.f6235o) {
            hVar.f6235o = false;
            hVar.a();
        }
        hVar.f6231k = 0;
        hVar.f6232l = 0.0f;
        hVar.f6233m = 0.0f;
        hVar.f6234n = 0.0f;
        hVar.e = 0.0f;
        hVar.a();
        hVar.f6226f = 0.0f;
        hVar.a();
        hVar.f6227g = 0.0f;
        hVar.a();
    }

    public void updateSizes(int i5) {
        if (i5 == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }
}
