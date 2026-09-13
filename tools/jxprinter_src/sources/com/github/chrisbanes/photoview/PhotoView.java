package com.github.chrisbanes.photoview;

import L1.e;
import L1.f;
import L1.g;
import L1.h;
import L1.i;
import L1.j;
import L1.p;
import L1.q;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import p002a.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PhotoView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f3294a;
    public ImageView.ScaleType b;

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f3294a = new p(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public p getAttacher() {
        return this.f3294a;
    }

    public RectF getDisplayRect() {
        p pVar = this.f3294a;
        pVar.b();
        Matrix matrixC = pVar.c();
        RectF rectF = pVar.f435n;
        Drawable drawable = pVar.f429h.getDrawable();
        if (drawable == null) {
            return null;
        }
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrixC.mapRect(rectF);
        return rectF;
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.f3294a.f433l;
    }

    public float getMaximumScale() {
        return this.f3294a.e;
    }

    public float getMediumScale() {
        return this.f3294a.d;
    }

    public float getMinimumScale() {
        return this.f3294a.c;
    }

    public float getScale() {
        return this.f3294a.d();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f3294a.f443v;
    }

    public void setAllowParentInterceptOnEdge(boolean z6) {
        this.f3294a.f427f = z6;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i5, int i6, int i7, int i8) {
        boolean frame = super.setFrame(i5, i6, i7, i8);
        if (frame) {
            this.f3294a.f();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        p pVar = this.f3294a;
        if (pVar != null) {
            pVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i5) {
        super.setImageResource(i5);
        p pVar = this.f3294a;
        if (pVar != null) {
            pVar.f();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        p pVar = this.f3294a;
        if (pVar != null) {
            pVar.f();
        }
    }

    public void setMaximumScale(float f6) {
        p pVar = this.f3294a;
        d.a(pVar.c, pVar.d, f6);
        pVar.e = f6;
    }

    public void setMediumScale(float f6) {
        p pVar = this.f3294a;
        d.a(pVar.c, f6, pVar.e);
        pVar.d = f6;
    }

    public void setMinimumScale(float f6) {
        p pVar = this.f3294a;
        d.a(f6, pVar.d, pVar.e);
        pVar.c = f6;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f3294a.f437p = onClickListener;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f3294a.f430i.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3294a.f438q = onLongClickListener;
    }

    public void setOnMatrixChangeListener(L1.d dVar) {
        this.f3294a.getClass();
    }

    public void setOnOutsidePhotoTapListener(e eVar) {
        this.f3294a.getClass();
    }

    public void setOnPhotoTapListener(f fVar) {
        this.f3294a.getClass();
    }

    public void setOnScaleChangeListener(g gVar) {
        this.f3294a.getClass();
    }

    public void setOnSingleFlingListener(h hVar) {
        this.f3294a.getClass();
    }

    public void setOnViewDragListener(i iVar) {
        this.f3294a.getClass();
    }

    public void setOnViewTapListener(j jVar) {
        this.f3294a.getClass();
    }

    public void setRotationBy(float f6) {
        p pVar = this.f3294a;
        pVar.f434m.postRotate(f6 % 360.0f);
        pVar.a();
    }

    public void setRotationTo(float f6) {
        p pVar = this.f3294a;
        pVar.f434m.setRotate(f6 % 360.0f);
        pVar.a();
    }

    public void setScale(float f6) {
        p pVar = this.f3294a;
        PhotoView photoView = pVar.f429h;
        pVar.e(f6, photoView.getRight() / 2, photoView.getBottom() / 2, false);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        p pVar = this.f3294a;
        if (pVar == null) {
            this.b = scaleType;
            return;
        }
        pVar.getClass();
        if (scaleType == null) {
            return;
        }
        if (q.f445a[scaleType.ordinal()] == 1) {
            throw new IllegalStateException("Matrix scale type is not supported");
        }
        if (scaleType != pVar.f443v) {
            pVar.f443v = scaleType;
            pVar.f();
        }
    }

    public void setZoomTransitionDuration(int i5) {
        this.f3294a.b = i5;
    }

    public void setZoomable(boolean z6) {
        p pVar = this.f3294a;
        pVar.f442u = z6;
        pVar.f();
    }
}
