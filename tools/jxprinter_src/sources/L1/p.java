package L1;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements View.OnTouchListener, View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PhotoView f429h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final GestureDetector f430i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f431j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnClickListener f437p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f438q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public o f439r;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final p075n1.a f444w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccelerateDecelerateInterpolator f426a = new AccelerateDecelerateInterpolator();
    public int b = 200;
    public float c = 1.0f;
    public float d = 1.75f;
    public float e = 3.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f427f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f428g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f432k = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f433l = new Matrix();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f434m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f435n = new RectF();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f436o = new float[9];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f440s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f441t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f442u = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ImageView.ScaleType f443v = ImageView.ScaleType.FIT_CENTER;

    public p(PhotoView photoView) {
        p075n1.a aVar = new p075n1.a(this, 3);
        this.f444w = aVar;
        this.f429h = photoView;
        photoView.setOnTouchListener(this);
        photoView.addOnLayoutChangeListener(this);
        if (photoView.isInEditMode()) {
            return;
        }
        this.f431j = new c(photoView.getContext(), aVar);
        GestureDetector gestureDetector = new GestureDetector(photoView.getContext(), new k(this));
        this.f430i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new l(0, this));
    }

    public final void a() {
        if (b()) {
            this.f429h.setImageMatrix(c());
        }
    }

    public final boolean b() {
        RectF rectF;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Matrix matrixC = c();
        PhotoView photoView = this.f429h;
        Drawable drawable = photoView.getDrawable();
        float f11 = 0.0f;
        if (drawable != null) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            rectF = this.f435n;
            rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
            matrixC.mapRect(rectF);
        } else {
            rectF = null;
        }
        if (rectF == null) {
            return false;
        }
        float fHeight = rectF.height();
        float fWidth = rectF.width();
        float height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        if (fHeight <= height) {
            int i5 = m.f421a[this.f443v.ordinal()];
            if (i5 != 2) {
                if (i5 != 3) {
                    f9 = (height - fHeight) / 2.0f;
                    f10 = rectF.top;
                } else {
                    f9 = height - fHeight;
                    f10 = rectF.top;
                }
                f6 = f9 - f10;
            } else {
                f6 = -rectF.top;
            }
            this.f441t = 2;
        } else {
            float f12 = rectF.top;
            if (f12 > 0.0f) {
                this.f441t = 0;
                f6 = -f12;
            } else {
                float f13 = rectF.bottom;
                if (f13 < height) {
                    this.f441t = 1;
                    f6 = height - f13;
                } else {
                    this.f441t = -1;
                    f6 = 0.0f;
                }
            }
        }
        float width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        if (fWidth <= width) {
            int i6 = m.f421a[this.f443v.ordinal()];
            if (i6 != 2) {
                if (i6 != 3) {
                    f7 = (width - fWidth) / 2.0f;
                    f8 = rectF.left;
                } else {
                    f7 = width - fWidth;
                    f8 = rectF.left;
                }
                f11 = f7 - f8;
            } else {
                f11 = -rectF.left;
            }
            this.f440s = 2;
        } else {
            float f14 = rectF.left;
            if (f14 > 0.0f) {
                this.f440s = 0;
                f11 = -f14;
            } else {
                float f15 = rectF.right;
                if (f15 < width) {
                    f11 = width - f15;
                    this.f440s = 1;
                } else {
                    this.f440s = -1;
                }
            }
        }
        this.f434m.postTranslate(f11, f6);
        return true;
    }

    public final Matrix c() {
        Matrix matrix = this.f432k;
        Matrix matrix2 = this.f433l;
        matrix2.set(matrix);
        matrix2.postConcat(this.f434m);
        return matrix2;
    }

    public final float d() {
        Matrix matrix = this.f434m;
        float[] fArr = this.f436o;
        matrix.getValues(fArr);
        float fPow = (float) Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(fPow + ((float) Math.pow(fArr[3], 2.0d)));
    }

    public final void e(float f6, float f7, float f8, boolean z6) {
        if (f6 < this.c || f6 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z6) {
            this.f429h.post(new n(this, d(), f6, f7, f8));
        } else {
            this.f434m.setScale(f6, f6, f7, f8);
            a();
        }
    }

    public final void f() {
        boolean z6 = this.f442u;
        PhotoView photoView = this.f429h;
        if (z6) {
            g(photoView.getDrawable());
            return;
        }
        Matrix matrix = this.f434m;
        matrix.reset();
        matrix.postRotate(0.0f);
        a();
        photoView.setImageMatrix(c());
        b();
    }

    public final void g(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        PhotoView photoView = this.f429h;
        float width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
        float height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Matrix matrix = this.f432k;
        matrix.reset();
        float f6 = intrinsicWidth;
        float f7 = width / f6;
        float f8 = intrinsicHeight;
        float f9 = height / f8;
        ImageView.ScaleType scaleType = this.f443v;
        if (scaleType == ImageView.ScaleType.CENTER) {
            matrix.postTranslate((width - f6) / 2.0f, (height - f8) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f7, f9);
            matrix.postScale(fMax, fMax);
            matrix.postTranslate((width - (f6 * fMax)) / 2.0f, androidx.collection.a.b(f8, fMax, height, 2.0f));
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f7, f9));
            matrix.postScale(fMin, fMin);
            matrix.postTranslate((width - (f6 * fMin)) / 2.0f, androidx.collection.a.b(f8, fMin, height, 2.0f));
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f6, f8);
            RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
            if (((int) 0.0f) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f8, f6);
            }
            int i5 = m.f421a[this.f443v.ordinal()];
            if (i5 == 1) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i5 == 2) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i5 == 3) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i5 == 4) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        Matrix matrix2 = this.f434m;
        matrix2.reset();
        matrix2.postRotate(0.0f);
        a();
        photoView.setImageMatrix(c());
        b();
    }

    @Deprecated
    public boolean isZoomEnabled() {
        return this.f442u;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        if (i5 == i9 && i6 == i10 && i7 == i11 && i8 == i12) {
            return;
        }
        g(this.f429h.getDrawable());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e5  */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z6;
        c cVar;
        GestureDetector gestureDetector;
        ScaleGestureDetector scaleGestureDetector;
        boolean zIsInProgress;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10 = false;
        if (!this.f442u || ((ImageView) view).getDrawable() == null) {
            return false;
        }
        int action = motionEvent.getAction();
        RectF rectF = null;
        if (action != 0) {
            if (action == 1 || action == 3) {
                float fD = d();
                float f6 = this.c;
                PhotoView photoView = this.f429h;
                RectF rectF2 = this.f435n;
                if (fD < f6) {
                    b();
                    Matrix matrixC = c();
                    Drawable drawable = photoView.getDrawable();
                    if (drawable != null) {
                        rectF2.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        matrixC.mapRect(rectF2);
                        rectF = rectF2;
                    }
                    if (rectF != null) {
                        RectF rectF3 = rectF;
                        view.post(new n(this, d(), this.c, rectF3.centerX(), rectF3.centerY()));
                        z6 = true;
                    }
                } else if (d() > this.e) {
                    b();
                    Matrix matrixC2 = c();
                    Drawable drawable2 = photoView.getDrawable();
                    if (drawable2 != null) {
                        rectF2.set(0.0f, 0.0f, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                        matrixC2.mapRect(rectF2);
                        rectF = rectF2;
                    }
                    if (rectF != null) {
                        RectF rectF4 = rectF;
                        view.post(new n(this, d(), this.e, rectF4.centerX(), rectF4.centerY()));
                        z6 = true;
                    }
                }
            }
            cVar = this.f431j;
            if (cVar != null) {
                scaleGestureDetector = cVar.c;
                zIsInProgress = scaleGestureDetector.isInProgress();
                z7 = cVar.e;
                try {
                    scaleGestureDetector.onTouchEvent(motionEvent);
                    cVar.a(motionEvent);
                } catch (IllegalArgumentException unused) {
                }
                if (!zIsInProgress || scaleGestureDetector.isInProgress()) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                if (!z7 || cVar.e) {
                    z9 = false;
                } else {
                    z9 = true;
                }
                if (z8 && z9) {
                    z10 = true;
                }
                this.f428g = z10;
                z6 = true;
            }
            gestureDetector = this.f430i;
            if (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
            return z6;
        }
        ViewParent parent = view.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        o oVar = this.f439r;
        if (oVar != null) {
            oVar.f425a.forceFinished(true);
            this.f439r = null;
        }
        z6 = false;
        cVar = this.f431j;
        if (cVar != null) {
            scaleGestureDetector = cVar.c;
            zIsInProgress = scaleGestureDetector.isInProgress();
            z7 = cVar.e;
            scaleGestureDetector.onTouchEvent(motionEvent);
            cVar.a(motionEvent);
            if (zIsInProgress) {
                z8 = false;
            } else {
                z8 = false;
            }
            if (z7) {
                z9 = false;
            } else {
                z9 = false;
            }
            if (z8) {
                z10 = true;
            }
            this.f428g = z10;
            z6 = true;
        }
        gestureDetector = this.f430i;
        if (gestureDetector == null) {
        }
        return z6;
    }
}
