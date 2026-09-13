package com.library.base.view.photoview;

import L1.l;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import p058k2.b;
import p058k2.d;
import p058k2.g;
import p058k2.h;
import p058k2.i;
import p058k2.j;
import p058k2.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PhotoView extends ImageView implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f3570a;
    public ImageView.ScaleType b;

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        k kVar = this.f3570a;
        if (kVar == null || kVar.h() == null) {
            this.f3570a = new k(this);
        }
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
    }

    public Matrix getDisplayMatrix() {
        k kVar = this.f3570a;
        kVar.getClass();
        return new Matrix(kVar.g());
    }

    public RectF getDisplayRect() {
        k kVar = this.f3570a;
        kVar.c();
        return kVar.f(kVar.g());
    }

    public b getIPhotoViewImplementation() {
        return this.f3570a;
    }

    @Override // p058k2.b
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.f3570a.d;
    }

    public float getMediumScale() {
        return this.f3570a.c;
    }

    @Override // p058k2.b
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // p058k2.b
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.f3570a.b;
    }

    public h getOnPhotoTapListener() {
        this.f3570a.getClass();
        return null;
    }

    public j getOnViewTapListener() {
        return this.f3570a.f5491o;
    }

    public float getScale() {
        return this.f3570a.k();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.f3570a.f5500x;
    }

    public Bitmap getVisibleRectangleBitmap() {
        ImageView imageViewH = this.f3570a.h();
        if (imageViewH == null) {
            return null;
        }
        return imageViewH.getDrawingCache();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        k kVar = this.f3570a;
        if (kVar == null || kVar.h() == null) {
            this.f3570a = new k(this);
        }
        ImageView.ScaleType scaleType = this.b;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.b = null;
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        this.f3570a.e();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z6) {
        this.f3570a.e = z6;
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        k kVar = this.f3570a;
        if (kVar != null) {
            kVar.o();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        super.setImageResource(i5);
        k kVar = this.f3570a;
        if (kVar != null) {
            kVar.o();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        k kVar = this.f3570a;
        if (kVar != null) {
            kVar.o();
        }
    }

    @Override // p058k2.b
    @Deprecated
    public void setMaxScale(float f6) {
        setMaximumScale(f6);
    }

    public void setMaximumScale(float f6) {
        k kVar = this.f3570a;
        k.d(kVar.b, kVar.c, f6);
        kVar.d = f6;
    }

    public void setMediumScale(float f6) {
        k kVar = this.f3570a;
        k.d(kVar.b, f6, kVar.d);
        kVar.c = f6;
    }

    @Override // p058k2.b
    @Deprecated
    public void setMidScale(float f6) {
        setMediumScale(f6);
    }

    @Override // p058k2.b
    @Deprecated
    public void setMinScale(float f6) {
        setMinimumScale(f6);
    }

    public void setMinimumScale(float f6) {
        k kVar = this.f3570a;
        k.d(f6, kVar.c, kVar.d);
        kVar.b = f6;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        k kVar = this.f3570a;
        GestureDetector gestureDetector = kVar.f5484h;
        if (onDoubleTapListener != null) {
            gestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            gestureDetector.setOnDoubleTapListener(new l(1, kVar));
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f3570a.f5492p = onLongClickListener;
    }

    public void setOnMatrixChangeListener(g gVar) {
        this.f3570a.getClass();
    }

    public void setOnPhotoTapListener(h hVar) {
        this.f3570a.getClass();
    }

    public void setOnScaleChangeListener(i iVar) {
        this.f3570a.getClass();
    }

    public void setOnViewTapListener(j jVar) {
        this.f3570a.f5491o = jVar;
    }

    public void setPhotoViewRotation(float f6) {
        k kVar = this.f3570a;
        kVar.f5488l.setRotate(f6 % 360.0f);
        kVar.b();
    }

    public void setRotationBy(float f6) {
        k kVar = this.f3570a;
        kVar.f5488l.postRotate(f6 % 360.0f);
        kVar.b();
    }

    public void setRotationTo(float f6) {
        k kVar = this.f3570a;
        kVar.f5488l.setRotate(f6 % 360.0f);
        kVar.b();
    }

    public void setScale(float f6) {
        k kVar = this.f3570a;
        ImageView imageViewH = kVar.h();
        if (imageViewH != null) {
            kVar.n(f6, imageViewH.getRight() / 2, imageViewH.getBottom() / 2, false);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        k kVar = this.f3570a;
        if (kVar == null) {
            this.b = scaleType;
            return;
        }
        kVar.getClass();
        if (scaleType == null) {
            return;
        }
        if (d.f5475a[scaleType.ordinal()] == 1) {
            throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
        }
        if (scaleType != kVar.f5500x) {
            kVar.f5500x = scaleType;
            kVar.o();
        }
    }

    public void setZoomTransitionDuration(int i5) {
        k kVar = this.f3570a;
        kVar.getClass();
        if (i5 < 0) {
            i5 = 200;
        }
        kVar.f5481a = i5;
    }

    public void setZoomable(boolean z6) {
        k kVar = this.f3570a;
        kVar.f5499w = z6;
        kVar.o();
    }
}
