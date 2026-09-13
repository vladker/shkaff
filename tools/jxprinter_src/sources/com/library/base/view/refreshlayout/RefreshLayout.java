package com.library.base.view.refreshlayout;

import Y1.g;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import p076n2.h;
import p076n2.i;
import p076n2.j;
import p076n2.k;
import p076n2.l;
import p076n2.m;
import p076n2.n;
import p076n2.o;
import p076n2.p;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class RefreshLayout extends ViewGroup {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final int[] f3571J = {R.attr.enabled};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final a f3572A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public boolean f3573C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public float f3574D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public float f3575G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final b f3576H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final c f3577I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f3578a;
    public p b;
    public boolean c;
    public boolean d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3585l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3586m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final DecelerateInterpolator f3587n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p076n2.a f3588o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3589p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3590q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3591r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final i f3592s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public j f3593t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public k f3594u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public l f3595v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public l f3596w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float f3597x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3598y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3599z;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            int[] iArr = RefreshLayout.f3571J;
            RefreshLayout refreshLayout = RefreshLayout.this;
            refreshLayout.getClass();
            float f7 = refreshLayout.f3597x;
            int iAbs = n.f6258a[refreshLayout.b.ordinal()] != 1 ? (int) (f7 - Math.abs(refreshLayout.f3591r)) : refreshLayout.getMeasuredHeight() - ((int) f7);
            int i5 = refreshLayout.f3590q;
            refreshLayout.e((i5 + ((int) ((iAbs - i5) * f6))) - refreshLayout.f3588o.getTop());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public final void applyTransformation(float f6, Transformation transformation) {
            RefreshLayout refreshLayout = RefreshLayout.this;
            int i5 = refreshLayout.f3590q;
            refreshLayout.e((i5 + ((int) ((refreshLayout.f3591r - i5) * f6))) - refreshLayout.f3588o.getTop());
        }
    }

    public RefreshLayout(Context context, AttributeSet attributeSet) {
        p pVar;
        super(context, attributeSet);
        this.d = false;
        this.f3579f = -1.0f;
        this.f3582i = false;
        this.f3586m = -1;
        this.f3589p = -1;
        this.f3572A = new a();
        this.f3576H = new b();
        this.f3577I = new c();
        this.e = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3580g = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f3587n = new DecelerateInterpolator(2.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3571J);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.RefreshLayout);
        int i5 = typedArrayObtainStyledAttributes2.getInt(g.RefreshLayout_direction, 0);
        p[] pVarArrValues = p.values();
        int length = pVarArrValues.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                pVar = p.BOTH;
                break;
            }
            pVar = pVarArrValues[i6];
            if (pVar.f6259a == i5) {
                break;
            } else {
                i6++;
            }
        }
        if (pVar != p.BOTH) {
            this.b = pVar;
            this.c = false;
        } else {
            this.b = p.TOP;
            this.c = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i7 = (int) (displayMetrics.density * 40.0f);
        this.f3598y = i7;
        this.f3599z = i7;
        p076n2.a aVar = new p076n2.a(getContext());
        float f6 = aVar.getContext().getResources().getDisplayMetrics().density;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(aVar, f6 * 4.0f);
        shapeDrawable.getPaint().setColor(-328966);
        aVar.setBackgroundDrawable(shapeDrawable);
        this.f3588o = aVar;
        i iVar = new i(getContext(), this);
        this.f3592s = iVar;
        iVar.b.f6243w = -328966;
        this.f3588o.setImageDrawable(iVar);
        this.f3588o.setVisibility(8);
        addView(this.f3588o);
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.f3597x = displayMetrics.density * 64.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimationProgress(float f6) {
        ViewCompat.setScaleX(this.f3588o, f6);
        ViewCompat.setScaleY(this.f3588o, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setColorViewAlpha(int i5) {
        this.f3588o.getBackground().setAlpha(i5);
        this.f3592s.b.f6241u = i5;
    }

    private void setRawDirection(p pVar) {
        if (this.b == pVar) {
            return;
        }
        this.b = pVar;
        if (n.f6258a[pVar.ordinal()] != 1) {
            int i5 = -this.f3588o.getMeasuredHeight();
            this.f3591r = i5;
            this.f3581h = i5;
        } else {
            int measuredHeight = getMeasuredHeight();
            this.f3591r = measuredHeight;
            this.f3581h = measuredHeight;
        }
    }

    public final void c() {
        if (this.f3578a == null) {
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                View childAt = getChildAt(i5);
                if (!childAt.equals(this.f3588o)) {
                    this.f3578a = childAt;
                    break;
                }
            }
        }
        if (this.f3579f != -1.0f || getParent() == null || ((View) getParent()).getHeight() <= 0) {
            return;
        }
        this.f3579f = (int) Math.min(((View) getParent()).getHeight() * 0.6f, getResources().getDisplayMetrics().density * 50.0f);
    }

    public final void d(boolean z6, boolean z7) {
        if (this.d != z6) {
            c();
            this.d = z6;
            a aVar = this.f3572A;
            if (!z6) {
                k kVar = new k(this);
                this.f3594u = kVar;
                kVar.setDuration(100L);
                p076n2.a aVar2 = this.f3588o;
                aVar2.f6218a = aVar;
                aVar2.clearAnimation();
                this.f3588o.startAnimation(this.f3594u);
                return;
            }
            this.f3590q = this.f3581h;
            b bVar = this.f3576H;
            bVar.reset();
            bVar.setDuration(200L);
            bVar.setInterpolator(this.f3587n);
            if (aVar != null) {
                this.f3588o.f6218a = aVar;
            }
            this.f3588o.clearAnimation();
            this.f3588o.startAnimation(bVar);
        }
    }

    public final void e(int i5) {
        this.f3588o.bringToFront();
        this.f3588o.offsetTopAndBottom(i5);
        this.f3581h = this.f3588o.getTop();
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i5, int i6) {
        int i7 = this.f3589p;
        if (i7 < 0) {
            return i6;
        }
        if (i6 == i5 - 1) {
            return i7;
        }
        return i6 >= i7 ? i6 + 1 : i6;
    }

    public p getDirection() {
        return this.c ? p.BOTH : this.b;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003b  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7  */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int i5 = this.e;
        if (action != 0) {
            if (action == 1) {
                this.f3573C = false;
            } else if (action != 2) {
                if (action == 3) {
                    this.f3573C = false;
                }
            } else if (!this.f3573C) {
                float y6 = motionEvent.getY();
                float fAbs = Math.abs(motionEvent.getX() - this.f3575G);
                float fAbs2 = Math.abs(y6 - this.f3574D);
                if (fAbs > i5 && fAbs > fAbs2) {
                    this.f3573C = true;
                    return false;
                }
            }
            return false;
        }
        this.f3574D = motionEvent.getY();
        this.f3575G = motionEvent.getX();
        this.f3573C = false;
        c();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int[] iArr = n.f6258a;
        if (iArr[this.b.ordinal()] == 1 ? !(!isEnabled() || ((!this.c && ViewCompat.canScrollVertically(this.f3578a, 1)) || this.d)) : !(!isEnabled() || ((!this.c && ViewCompat.canScrollVertically(this.f3578a, -1)) || this.d))) {
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    this.f3585l = false;
                    this.f3586m = -1;
                } else if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        this.f3585l = false;
                        this.f3586m = -1;
                    } else if (actionMasked == 6) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f3586m) {
                            this.f3586m = MotionEventCompat.getPointerId(motionEvent, actionIndex != 0 ? 0 : 1);
                        }
                    }
                }
                return this.f3585l;
            }
            e(this.f3591r - this.f3588o.getTop());
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f3586m = pointerId;
            this.f3585l = false;
            int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, pointerId);
            float y7 = iFindPointerIndex < 0 ? -1.0f : MotionEventCompat.getY(motionEvent, iFindPointerIndex);
            if (y7 != -1.0f) {
                this.f3584k = y7;
            }
            int i6 = this.f3586m;
            if (i6 != -1) {
                int iFindPointerIndex2 = MotionEventCompat.findPointerIndex(motionEvent, i6);
                float y8 = iFindPointerIndex2 < 0 ? -1.0f : MotionEventCompat.getY(motionEvent, iFindPointerIndex2);
                if (y8 != -1.0f) {
                    if (this.c) {
                        float f6 = this.f3584k;
                        if (y8 > f6) {
                            setRawDirection(p.TOP);
                        } else if (y8 < f6) {
                            setRawDirection(p.BOTTOM);
                        }
                        if ((this.b == p.BOTTOM && ViewCompat.canScrollVertically(this.f3578a, 1)) || (this.b == p.TOP && ViewCompat.canScrollVertically(this.f3578a, -1))) {
                            this.f3584k = y8;
                            return false;
                        }
                    }
                    float f7 = i5;
                    if ((iArr[this.b.ordinal()] != 1 ? y8 - this.f3584k : this.f3584k - y8) > f7 && !this.f3585l) {
                        if (iArr[this.b.ordinal()] != 1) {
                            this.f3583j = this.f3584k + f7;
                        } else {
                            this.f3583j = this.f3584k - f7;
                        }
                        this.f3585l = true;
                        this.f3592s.b.f6241u = 76;
                    }
                    return this.f3585l;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f3578a == null) {
            c();
        }
        View view = this.f3578a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.f3588o.getMeasuredWidth();
        int measuredHeight2 = this.f3588o.getMeasuredHeight();
        int i9 = measuredWidth / 2;
        int i10 = measuredWidth2 / 2;
        int i11 = this.f3581h;
        this.f3588o.layout(i9 - i10, i11, i9 + i10, measuredHeight2 + i11);
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f3578a == null) {
            c();
        }
        View view = this.f3578a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.f3588o.measure(View.MeasureSpec.makeMeasureSpec(this.f3598y, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f3599z, 1073741824));
        if (!this.f3582i) {
            this.f3582i = true;
            if (n.f6258a[this.b.ordinal()] != 1) {
                int i7 = -this.f3588o.getMeasuredHeight();
                this.f3591r = i7;
                this.f3581h = i7;
            } else {
                int measuredHeight = getMeasuredHeight();
                this.f3591r = measuredHeight;
                this.f3581h = measuredHeight;
            }
        }
        this.f3589p = -1;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            if (getChildAt(i8) == this.f3588o) {
                this.f3589p = i8;
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:90:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:93:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:96:0x0201  */
    /* JADX WARN: Code duplicated, block: B:97:0x0205  */
    /* JADX WARN: Code duplicated, block: B:99:0x0241  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        float y6;
        float f6;
        h hVar;
        l lVar;
        l lVar2;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int[] iArr = n.f6258a;
        if (iArr[this.b.ordinal()] == 1 ? !(!isEnabled() || ViewCompat.canScrollVertically(this.f3578a, 1) || this.d) : !(!isEnabled() || ViewCompat.canScrollVertically(this.f3578a, -1) || this.d)) {
            if (actionMasked == 0) {
                this.f3586m = MotionEventCompat.getPointerId(motionEvent, 0);
                this.f3585l = false;
                return true;
            }
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            this.f3586m = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                            return true;
                        }
                        if (actionMasked == 6) {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.f3586m) {
                                this.f3586m = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
                                return true;
                            }
                        }
                    }
                    i5 = this.f3586m;
                    if (i5 != -1) {
                        y6 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i5));
                        if (iArr[this.b.ordinal()] != 1) {
                            f6 = (y6 - this.f3583j) * 0.5f;
                        } else {
                            f6 = (this.f3583j - y6) * 0.5f;
                        }
                        this.f3585l = false;
                        if (f6 > this.f3579f) {
                            d(true, true);
                        } else {
                            this.d = false;
                            h hVar2 = this.f3592s.b;
                            hVar2.e = 0.0f;
                            hVar2.a();
                            hVar2.f6226f = 0.0f;
                            hVar2.a();
                            m mVar = new m(this);
                            this.f3590q = this.f3581h;
                            c cVar = this.f3577I;
                            cVar.reset();
                            cVar.setDuration(200L);
                            cVar.setInterpolator(this.f3587n);
                            p076n2.a aVar = this.f3588o;
                            aVar.f6218a = mVar;
                            aVar.clearAnimation();
                            this.f3588o.startAnimation(cVar);
                            hVar = this.f3592s.b;
                            if (hVar.f6235o) {
                                hVar.f6235o = false;
                                hVar.a();
                            }
                        }
                        this.f3586m = -1;
                        return false;
                    }
                } else {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f3586m);
                    if (iFindPointerIndex >= 0) {
                        float y7 = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                        float f7 = iArr[this.b.ordinal()] != 1 ? (y7 - this.f3583j) * 0.5f : (this.f3583j - y7) * 0.5f;
                        if (this.f3585l) {
                            h hVar3 = this.f3592s.b;
                            if (!hVar3.f6235o) {
                                hVar3.f6235o = true;
                                hVar3.a();
                            }
                            float f8 = f7 / this.f3579f;
                            if (f8 >= 0.0f) {
                                float fMin = Math.min(1.0f, Math.abs(f8));
                                float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
                                float fAbs = Math.abs(f7) - this.f3579f;
                                float f9 = this.f3597x;
                                double dMax = Math.max(0.0f, Math.min(fAbs, f9 * 2.0f) / f9) / 4.0f;
                                float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
                                float f10 = f9 * fPow * 2.0f;
                                int i6 = this.b == p.TOP ? this.f3591r + ((int) ((f9 * fMin) + f10)) : this.f3591r - ((int) ((f9 * fMin) + f10));
                                if (this.f3588o.getVisibility() != 0) {
                                    this.f3588o.setVisibility(0);
                                }
                                ViewCompat.setScaleX(this.f3588o, 1.0f);
                                ViewCompat.setScaleY(this.f3588o, 1.0f);
                                if (f7 < this.f3579f) {
                                    if (this.f3592s.b.f6241u > 76 && ((lVar2 = this.f3595v) == null || !lVar2.hasStarted() || lVar2.hasEnded())) {
                                        l lVar3 = new l(this, this.f3592s.b.f6241u, 76);
                                        lVar3.setDuration(300L);
                                        p076n2.a aVar2 = this.f3588o;
                                        aVar2.f6218a = null;
                                        aVar2.clearAnimation();
                                        this.f3588o.startAnimation(lVar3);
                                        this.f3595v = lVar3;
                                    }
                                    float fMin2 = Math.min(0.8f, fMax * 0.8f);
                                    h hVar4 = this.f3592s.b;
                                    hVar4.e = 0.0f;
                                    hVar4.a();
                                    hVar4.f6226f = fMin2;
                                    hVar4.a();
                                    float fMin3 = Math.min(1.0f, fMax);
                                    h hVar5 = this.f3592s.b;
                                    if (fMin3 != hVar5.f6237q) {
                                        hVar5.f6237q = fMin3;
                                        hVar5.a();
                                    }
                                } else if (this.f3592s.b.f6241u < 255 && ((lVar = this.f3596w) == null || !lVar.hasStarted() || lVar.hasEnded())) {
                                    l lVar4 = new l(this, this.f3592s.b.f6241u, 255);
                                    lVar4.setDuration(300L);
                                    p076n2.a aVar3 = this.f3588o;
                                    aVar3.f6218a = null;
                                    aVar3.clearAnimation();
                                    this.f3588o.startAnimation(lVar4);
                                    this.f3596w = lVar4;
                                }
                                h hVar6 = this.f3592s.b;
                                hVar6.f6227g = ((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f;
                                hVar6.a();
                                e(i6 - this.f3581h);
                            }
                        }
                    }
                }
                return true;
            }
            i5 = this.f3586m;
            if (i5 != -1) {
                y6 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i5));
                if (iArr[this.b.ordinal()] != 1) {
                    f6 = (y6 - this.f3583j) * 0.5f;
                } else {
                    f6 = (this.f3583j - y6) * 0.5f;
                }
                this.f3585l = false;
                if (f6 > this.f3579f) {
                    d(true, true);
                } else {
                    this.d = false;
                    h hVar7 = this.f3592s.b;
                    hVar7.e = 0.0f;
                    hVar7.a();
                    hVar7.f6226f = 0.0f;
                    hVar7.a();
                    m mVar2 = new m(this);
                    this.f3590q = this.f3581h;
                    c cVar2 = this.f3577I;
                    cVar2.reset();
                    cVar2.setDuration(200L);
                    cVar2.setInterpolator(this.f3587n);
                    p076n2.a aVar4 = this.f3588o;
                    aVar4.f6218a = mVar2;
                    aVar4.clearAnimation();
                    this.f3588o.startAnimation(cVar2);
                    hVar = this.f3592s.b;
                    if (hVar.f6235o) {
                        hVar.f6235o = false;
                        hVar.a();
                    }
                }
                this.f3586m = -1;
                return false;
            }
        }
        return false;
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        c();
        h hVar = this.f3592s.b;
        hVar.setColors(iArr);
        hVar.f6231k = 0;
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = resources.getColor(iArr[i5]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDirection(p pVar) {
        if (pVar == p.BOTH) {
            this.c = true;
        } else {
            this.c = false;
            this.b = pVar;
        }
        if (n.f6258a[this.b.ordinal()] != 1) {
            int i5 = -this.f3588o.getMeasuredHeight();
            this.f3591r = i5;
            this.f3581h = i5;
        } else {
            int measuredHeight = getMeasuredHeight();
            this.f3591r = measuredHeight;
            this.f3581h = measuredHeight;
        }
    }

    public void setDistanceToTriggerSync(int i5) {
        this.f3579f = i5;
    }

    public void setProgressBackgroundColor(int i5) {
        this.f3588o.setBackgroundColor(i5);
        this.f3592s.b.f6243w = getResources().getColor(i5);
    }

    public void setRefreshing(boolean z6) {
        if (!z6 || this.d == z6) {
            d(z6, false);
            return;
        }
        this.d = z6;
        int i5 = n.f6258a[this.b.ordinal()];
        float f6 = this.f3597x;
        e((i5 != 1 ? (int) (f6 - Math.abs(this.f3591r)) : getMeasuredHeight() - ((int) f6)) - this.f3581h);
        this.f3588o.setVisibility(0);
        this.f3592s.b.f6241u = 255;
        j jVar = new j(this);
        this.f3593t = jVar;
        jVar.setDuration(this.f3580g);
        a aVar = this.f3572A;
        if (aVar != null) {
            this.f3588o.f6218a = aVar;
        }
        this.f3588o.clearAnimation();
        this.f3588o.startAnimation(this.f3593t);
    }

    public void setSize(int i5) {
        if (i5 == 0 || i5 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i5 == 0) {
                int i6 = (int) (displayMetrics.density * 56.0f);
                this.f3598y = i6;
                this.f3599z = i6;
            } else {
                int i7 = (int) (displayMetrics.density * 40.0f);
                this.f3598y = i7;
                this.f3599z = i7;
            }
            this.f3588o.setImageDrawable(null);
            this.f3592s.updateSizes(i5);
            this.f3588o.setImageDrawable(this.f3592s);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        if (i5 == 4 || i5 == 8) {
            setRefreshing(false);
        }
        super.setVisibility(i5);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            RefreshLayout refreshLayout = RefreshLayout.this;
            if (refreshLayout.d) {
                i iVar = refreshLayout.f3592s;
                iVar.b.f6241u = 255;
                iVar.start();
            } else {
                refreshLayout.f3592s.stop();
                refreshLayout.f3588o.setVisibility(8);
                refreshLayout.setColorViewAlpha(255);
                refreshLayout.e(refreshLayout.f3591r - refreshLayout.f3581h);
            }
            refreshLayout.f3581h = refreshLayout.f3588o.getTop();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
    }

    public void setOnRefreshListener(o oVar) {
    }
}
