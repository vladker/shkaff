package R2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f604a;
    public final Matrix b;
    public final Matrix c;
    public final float[] d;
    public final o e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f605f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f607h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Q0.b f608i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f609j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f610k;

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f604a = new Matrix();
        this.b = new Matrix();
        this.c = new Matrix();
        this.d = new float[9];
        this.e = new o(null, 0);
        this.f605f = -1;
        this.f606g = -1;
        this.f609j = new Handler();
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public final void a() {
        float height;
        float f6;
        Bitmap bitmap = this.e.f611a;
        if (bitmap == null) {
            return;
        }
        Matrix imageViewMatrix = getImageViewMatrix();
        float f7 = 0.0f;
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        imageViewMatrix.mapRect(rectF);
        float fHeight = rectF.height();
        float fWidth = rectF.width();
        float height2 = getHeight();
        if (fHeight < height2) {
            height = ((height2 - fHeight) / 2.0f) - rectF.top;
        } else {
            float f8 = rectF.top;
            if (f8 > 0.0f) {
                height = -f8;
            } else {
                height = rectF.bottom < height2 ? getHeight() - rectF.bottom : 0.0f;
            }
        }
        float width = getWidth();
        if (fWidth >= width) {
            float f9 = rectF.left;
            if (f9 > 0.0f) {
                f7 = -f9;
            } else {
                f6 = rectF.right;
                if (f6 < width) {
                }
            }
            c(f7, height);
            setImageMatrix(getImageViewMatrix());
        }
        width = (width - fWidth) / 2.0f;
        f6 = rectF.left;
        f7 = width - f6;
        c(f7, height);
        setImageMatrix(getImageViewMatrix());
    }

    public final void b(o oVar, Matrix matrix, boolean z6) {
        float width = getWidth();
        float height = getHeight();
        float fB = oVar.b();
        float fA = oVar.a();
        matrix.reset();
        float fMin = Math.min(Math.min(width / fB, 3.0f), Math.min(height / fA, 3.0f));
        if (z6) {
            Matrix matrix2 = new Matrix();
            Bitmap bitmap = oVar.f611a;
            if (bitmap != null && oVar.b != 0) {
                matrix2.preTranslate(-(bitmap.getWidth() / 2), -(oVar.f611a.getHeight() / 2));
                matrix2.postRotate(oVar.b);
                matrix2.postTranslate(oVar.b() / 2, oVar.a() / 2);
            }
            matrix.postConcat(matrix2);
        }
        matrix.postScale(fMin, fMin);
        matrix.postTranslate((width - (fB * fMin)) / 2.0f, androidx.collection.a.b(fA, fMin, height, 2.0f));
    }

    public abstract void c(float f6, float f7);

    public final void d(int i5, Bitmap bitmap) {
        f fVar;
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        o oVar = this.e;
        Bitmap bitmap2 = oVar.f611a;
        oVar.f611a = bitmap;
        oVar.b = i5;
        if (bitmap2 == null || bitmap2 == bitmap || (fVar = this.f610k) == null) {
            return;
        }
        ((P2.a) fVar).getClass();
        bitmap2.recycle();
        System.gc();
    }

    public final void e(o oVar) {
        if (getWidth() <= 0) {
            this.f608i = new Q0.b(this, 2, oVar, false);
            return;
        }
        Bitmap bitmap = oVar.f611a;
        Matrix matrix = this.f604a;
        if (bitmap != null) {
            b(oVar, matrix, true);
            d(oVar.b, oVar.f611a);
        } else {
            matrix.reset();
            setImageBitmap(null);
        }
        this.b.reset();
        setImageMatrix(getImageViewMatrix());
        o oVar2 = this.e;
        this.f607h = oVar2.f611a == null ? 1.0f : Math.max(oVar2.b() / this.f605f, oVar2.a() / this.f606g) * 4.0f;
    }

    public abstract void f(float f6, float f7, float f8);

    public Matrix getImageViewMatrix() {
        Matrix matrix = this.f604a;
        Matrix matrix2 = this.c;
        matrix2.set(matrix);
        matrix2.postConcat(this.b);
        return matrix2;
    }

    public float getScale() {
        Matrix matrix = this.b;
        float[] fArr = this.d;
        matrix.getValues(fArr);
        return fArr[0];
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (i5 != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i5, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i5, KeyEvent keyEvent) {
        if (i5 != 4 || !keyEvent.isTracking() || keyEvent.isCanceled() || getScale() <= 1.0f) {
            return super.onKeyUp(i5, keyEvent);
        }
        f(1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
        return true;
    }

    @Override // android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        super.onLayout(z6, i5, i6, i7, i8);
        this.f605f = i7 - i5;
        this.f606g = i8 - i6;
        Q0.b bVar = this.f608i;
        if (bVar != null) {
            this.f608i = null;
            bVar.run();
        }
        o oVar = this.e;
        if (oVar.f611a != null) {
            b(oVar, this.f604a, true);
            setImageMatrix(getImageViewMatrix());
        }
    }

    @Override // android.widget.ImageView
    public abstract void setImageBitmap(Bitmap bitmap);
}
