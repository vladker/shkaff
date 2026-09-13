package com.soundcloud.android.crop;

import L1.n;
import R2.e;
import R2.f;
import R2.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CropImageView extends g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f3767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public e f3768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public CropImageActivity f3769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f3771p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3772q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3773r;

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3767l = new ArrayList();
    }

    @Override // R2.g
    public final void c(float f6, float f7) {
        this.b.postTranslate(f6, f7);
        ArrayList arrayList = this.f3767l;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            e eVar = (e) obj;
            eVar.c.postTranslate(f6, f7);
            eVar.b = eVar.a();
        }
    }

    @Override // R2.g
    public final void f(float f6, float f7, float f8) {
        float f9 = this.f607h;
        if (f6 > f9) {
            f6 = f9;
        }
        float scale = f6 / getScale();
        this.b.postScale(scale, scale, f7, f8);
        setImageMatrix(getImageViewMatrix());
        a();
        ArrayList arrayList = this.f3767l;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            e eVar = (e) obj;
            eVar.c.set(getUnrotatedMatrix());
            eVar.b = eVar.a();
        }
    }

    public final void g(e eVar) {
        Rect rect = eVar.b;
        float fMax = Math.max(1.0f, getScale() * Math.min((getWidth() / rect.width()) * 0.6f, (getHeight() / rect.height()) * 0.6f));
        if (Math.abs(fMax - getScale()) / fMax > 0.1d) {
            float[] fArr = {eVar.f590a.centerX(), eVar.f590a.centerY()};
            getUnrotatedMatrix().mapPoints(fArr);
            this.f609j.post(new n(this, System.currentTimeMillis(), getScale(), (fMax - getScale()) / 300.0f, fArr[0], fArr[1]));
        }
        Rect rect2 = eVar.b;
        int iMax = Math.max(0, getLeft() - rect2.left);
        int iMin = Math.min(0, getRight() - rect2.right);
        int iMax2 = Math.max(0, getTop() - rect2.top);
        int iMin2 = Math.min(0, getBottom() - rect2.bottom);
        if (iMax == 0) {
            iMax = iMin;
        }
        if (iMax2 == 0) {
            iMax2 = iMin2;
        }
        if (iMax == 0 && iMax2 == 0) {
            return;
        }
        c(iMax, iMax2);
        setImageMatrix(getImageViewMatrix());
    }

    public Matrix getUnrotatedMatrix() {
        Matrix matrix = new Matrix();
        b(this.e, matrix, false);
        matrix.postConcat(this.b);
        return matrix;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f3767l;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((e) obj).b(canvas);
        }
    }

    @Override // R2.g, android.view.View
    public final void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        super.onLayout(z6, i5, i6, i7, i8);
        if (this.e.f611a != null) {
            ArrayList arrayList = this.f3767l;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                e eVar = (e) obj;
                eVar.c.set(getUnrotatedMatrix());
                eVar.b = eVar.a();
                if (eVar.f603r) {
                    g(eVar);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z6 = false;
        if (this.f3769n.isSaving()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ArrayList arrayList = this.f3767l;
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                e eVar = (e) obj;
                float x6 = motionEvent.getX();
                float y6 = motionEvent.getY();
                Rect rectA = eVar.a();
                boolean z7 = (y6 < ((float) rectA.top) - 20.0f || y6 >= ((float) rectA.bottom) + 20.0f) ? z6 : true;
                float f6 = rectA.left;
                boolean z8 = x6 >= f6 - 20.0f && x6 < ((float) rectA.right) + 20.0f;
                int i6 = (Math.abs(f6 - x6) >= 20.0f || !z7) ? 1 : 3;
                if (Math.abs(rectA.right - x6) < 20.0f && z7) {
                    i6 |= 4;
                }
                if (Math.abs(rectA.top - y6) < 20.0f && z8) {
                    i6 |= 8;
                }
                if (Math.abs(rectA.bottom - y6) < 20.0f && z8) {
                    i6 |= 16;
                }
                if (i6 == 1 && rectA.contains((int) x6, (int) y6)) {
                    i6 = 32;
                }
                if (i6 != 1) {
                    this.f3772q = i6;
                    this.f3768m = eVar;
                    this.f3770o = motionEvent.getX();
                    this.f3771p = motionEvent.getY();
                    this.f3773r = motionEvent.getPointerId(motionEvent.getActionIndex());
                    e eVar2 = this.f3768m;
                    int i7 = i6 == 32 ? 2 : 3;
                    if (i7 == eVar2.f597l) {
                        break;
                    }
                    eVar2.f597l = i7;
                    eVar2.f593h.invalidate();
                    return true;
                }
                z6 = false;
            }
        } else {
            if (action == 1) {
                e eVar3 = this.f3768m;
                if (eVar3 != null) {
                    g(eVar3);
                    e eVar4 = this.f3768m;
                    if (1 != eVar4.f597l) {
                        eVar4.f597l = 1;
                        eVar4.f593h.invalidate();
                    }
                }
                this.f3768m = null;
                a();
                return true;
            }
            if (action == 2) {
                if (this.f3768m != null && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.f3773r) {
                    e eVar5 = this.f3768m;
                    int i8 = this.f3772q;
                    float x7 = motionEvent.getX() - this.f3770o;
                    float y7 = motionEvent.getY() - this.f3771p;
                    View view = eVar5.f593h;
                    Rect rectA2 = eVar5.a();
                    if (i8 == 32) {
                        float fWidth = (eVar5.f590a.width() / rectA2.width()) * x7;
                        float fHeight = (eVar5.f590a.height() / rectA2.height()) * y7;
                        Rect rect = new Rect(eVar5.b);
                        eVar5.f590a.offset(fWidth, fHeight);
                        RectF rectF = eVar5.f590a;
                        rectF.offset(Math.max(0.0f, eVar5.d.left - rectF.left), Math.max(0.0f, eVar5.d.top - eVar5.f590a.top));
                        RectF rectF2 = eVar5.f590a;
                        rectF2.offset(Math.min(0.0f, eVar5.d.right - rectF2.right), Math.min(0.0f, eVar5.d.bottom - eVar5.f590a.bottom));
                        Rect rectA3 = eVar5.a();
                        eVar5.b = rectA3;
                        rect.union(rectA3);
                        int i9 = -((int) eVar5.f601p);
                        rect.inset(i9, i9);
                        view.invalidate(rect);
                    } else {
                        if ((i8 & 6) == 0) {
                            x7 = 0.0f;
                        }
                        if ((i8 & 24) == 0) {
                            y7 = 0.0f;
                        }
                        float fWidth2 = (eVar5.f590a.width() / rectA2.width()) * x7;
                        float fHeight2 = (eVar5.f590a.height() / rectA2.height()) * y7;
                        float fWidth3 = ((i8 & 2) != 0 ? -1 : 1) * fWidth2;
                        float fHeight3 = ((i8 & 8) == 0 ? 1 : -1) * fHeight2;
                        if (eVar5.f599n) {
                            if (fWidth3 != 0.0f) {
                                fHeight3 = fWidth3 / eVar5.f600o;
                            } else if (fHeight3 != 0.0f) {
                                fWidth3 = fHeight3 * eVar5.f600o;
                            }
                        }
                        RectF rectF3 = new RectF(eVar5.f590a);
                        if (fWidth3 > 0.0f) {
                            if ((fWidth3 * 2.0f) + rectF3.width() > eVar5.d.width()) {
                                fWidth3 = (eVar5.d.width() - rectF3.width()) / 2.0f;
                                if (eVar5.f599n) {
                                    fHeight3 = fWidth3 / eVar5.f600o;
                                }
                            }
                        }
                        if (fHeight3 > 0.0f) {
                            if ((fHeight3 * 2.0f) + rectF3.height() > eVar5.d.height()) {
                                fHeight3 = (eVar5.d.height() - rectF3.height()) / 2.0f;
                                if (eVar5.f599n) {
                                    fWidth3 = fHeight3 * eVar5.f600o;
                                }
                            }
                        }
                        rectF3.inset(-fWidth3, -fHeight3);
                        if (rectF3.width() < 25.0f) {
                            rectF3.inset((-(25.0f - rectF3.width())) / 2.0f, 0.0f);
                        }
                        float f7 = eVar5.f599n ? 25.0f / eVar5.f600o : 25.0f;
                        if (rectF3.height() < f7) {
                            rectF3.inset(0.0f, (-(f7 - rectF3.height())) / 2.0f);
                        }
                        float f8 = rectF3.left;
                        RectF rectF4 = eVar5.d;
                        float f9 = rectF4.left;
                        if (f8 < f9) {
                            rectF3.offset(f9 - f8, 0.0f);
                        } else {
                            float f10 = rectF3.right;
                            float f11 = rectF4.right;
                            if (f10 > f11) {
                                rectF3.offset(-(f10 - f11), 0.0f);
                            }
                        }
                        float f12 = rectF3.top;
                        RectF rectF5 = eVar5.d;
                        float f13 = rectF5.top;
                        if (f12 < f13) {
                            rectF3.offset(0.0f, f13 - f12);
                        } else {
                            float f14 = rectF3.bottom;
                            float f15 = rectF5.bottom;
                            if (f14 > f15) {
                                rectF3.offset(0.0f, -(f14 - f15));
                            }
                        }
                        eVar5.f590a.set(rectF3);
                        eVar5.b = eVar5.a();
                        view.invalidate();
                    }
                    this.f3770o = motionEvent.getX();
                    this.f3771p = motionEvent.getY();
                }
                if (getScale() == 1.0f) {
                    a();
                    return true;
                }
            }
        }
        return true;
    }

    @Override // R2.g, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        d(0, bitmap);
    }

    public void setRecycler(f fVar) {
        this.f610k = fVar;
    }
}
