package com.contrarywind.view;

import L1.k;
import X0.a;
import Y0.b;
import Z0.c;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class WheelView extends View {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String[] f3212w0 = {TarConstants.VERSION_POSIX, "01", "02", "03", "04", "05", "06", "07", "08", "09"};

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public float f3213A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public float f3214C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public float f3215D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public float f3216G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f3217H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public int f3218I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f3219J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public int f3220K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public int f3221M;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public int f3222Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f3223a;
    public final Context b;
    public final b c;
    public final GestureDetector d;
    public a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScheduledExecutorService f3226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ScheduledFuture f3227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f3228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f3229k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f3230k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Paint f3231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public W0.a f3232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3233n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f3234n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3235o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f3236o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3237p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f3238p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3239q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f3240q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3241r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public int f3242r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f3243s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3244s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Typeface f3245t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3246t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f3247u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final float f3248u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3249v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3250v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3254z;

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3224f = false;
        this.f3225g = true;
        this.f3226h = Executors.newSingleThreadScheduledExecutor();
        this.f3245t = Typeface.MONOSPACE;
        this.f3253y = 1.6f;
        this.f3220K = 11;
        this.f3234n0 = 0;
        this.f3236o0 = 0.0f;
        this.f3238p0 = 0L;
        this.f3242r0 = 17;
        this.f3244s0 = 0;
        this.f3246t0 = 0;
        this.f3250v0 = false;
        this.f3235o = getResources().getDimensionPixelSize(Z0.a.pickerview_textsize);
        float f6 = getResources().getDisplayMetrics().density;
        if (f6 < 1.0f) {
            this.f3248u0 = 2.4f;
        } else if (1.0f <= f6 && f6 < 2.0f) {
            this.f3248u0 = 4.0f;
        } else if (2.0f <= f6 && f6 < 3.0f) {
            this.f3248u0 = 6.0f;
        } else if (f6 >= 3.0f) {
            this.f3248u0 = f6 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z0.b.pickerview, 0, 0);
            this.f3242r0 = typedArrayObtainStyledAttributes.getInt(Z0.b.pickerview_wheelview_gravity, 17);
            this.f3247u = typedArrayObtainStyledAttributes.getColor(Z0.b.pickerview_wheelview_textColorOut, -5723992);
            this.f3249v = typedArrayObtainStyledAttributes.getColor(Z0.b.pickerview_wheelview_textColorCenter, -14013910);
            this.f3251w = typedArrayObtainStyledAttributes.getColor(Z0.b.pickerview_wheelview_dividerColor, -2763307);
            this.f3252x = typedArrayObtainStyledAttributes.getDimensionPixelSize(Z0.b.pickerview_wheelview_dividerWidth, 2);
            this.f3235o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(Z0.b.pickerview_wheelview_textSize, this.f3235o);
            this.f3253y = typedArrayObtainStyledAttributes.getFloat(Z0.b.pickerview_wheelview_lineSpacingMultiplier, this.f3253y);
            typedArrayObtainStyledAttributes.recycle();
        }
        float f7 = this.f3253y;
        if (f7 < 1.0f) {
            this.f3253y = 1.0f;
        } else if (f7 > 4.0f) {
            this.f3253y = 4.0f;
        }
        this.b = context;
        this.c = new b(this);
        GestureDetector gestureDetector = new GestureDetector(context, new k(this));
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f3254z = true;
        this.f3216G = 0.0f;
        this.f3217H = -1;
        Paint paint = new Paint();
        this.f3228j = paint;
        paint.setColor(this.f3247u);
        this.f3228j.setAntiAlias(true);
        this.f3228j.setTypeface(this.f3245t);
        this.f3228j.setTextSize(this.f3235o);
        Paint paint2 = new Paint();
        this.f3229k = paint2;
        paint2.setColor(this.f3249v);
        this.f3229k.setAntiAlias(true);
        this.f3229k.setTextScaleX(1.1f);
        this.f3229k.setTypeface(this.f3245t);
        this.f3229k.setTextSize(this.f3235o);
        Paint paint3 = new Paint();
        this.f3231l = paint3;
        paint3.setColor(this.f3251w);
        this.f3231l.setAntiAlias(true);
        setLayerType(1, null);
    }

    public static String b(Object obj) {
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof Integer)) {
            return obj.toString();
        }
        int iIntValue = ((Integer) obj).intValue();
        return (iIntValue < 0 || iIntValue >= 10) ? String.valueOf(iIntValue) : f3212w0[iIntValue];
    }

    public final void a() {
        ScheduledFuture scheduledFuture = this.f3227i;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.f3227i.cancel(true);
        this.f3227i = null;
    }

    public final int c(int i5) {
        if (i5 < 0) {
            return c(this.f3232m.h() + i5);
        }
        return i5 > this.f3232m.h() + (-1) ? c(i5 - this.f3232m.h()) : i5;
    }

    public final void d() {
        if (this.f3232m == null) {
            return;
        }
        Rect rect = new Rect();
        for (int i5 = 0; i5 < this.f3232m.h(); i5++) {
            String strB = b(this.f3232m.getItem(i5));
            this.f3229k.getTextBounds(strB, 0, strB.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f3237p) {
                this.f3237p = iWidth;
            }
        }
        this.f3229k.getTextBounds("星期", 0, 2, rect);
        int iHeight = rect.height() + 2;
        this.f3239q = iHeight;
        float f6 = this.f3253y * iHeight;
        this.f3243s = f6;
        int i6 = (int) (f6 * (this.f3220K - 1));
        this.f3221M = (int) (((double) (i6 * 2)) / 3.141592653589793d);
        this.f3230k0 = (int) (((double) i6) / 3.141592653589793d);
        this.f3222Q = View.MeasureSpec.getSize(this.f3240q0);
        float f7 = this.f3221M;
        float f8 = this.f3243s;
        this.f3213A = (f7 - f8) / 2.0f;
        float f9 = (f7 + f8) / 2.0f;
        this.f3214C = f9;
        this.f3215D = (f9 - ((f8 - this.f3239q) / 2.0f)) - this.f3248u0;
        if (this.f3217H == -1) {
            if (this.f3254z) {
                this.f3217H = (this.f3232m.h() + 1) / 2;
            } else {
                this.f3217H = 0;
            }
        }
        this.f3219J = this.f3217H;
    }

    public final void e(float f6, float f7) {
        int i5;
        int i6 = this.f3241r;
        if (i6 > 0) {
            i5 = 1;
        } else {
            i5 = i6 < 0 ? -1 : 0;
        }
        this.f3228j.setTextSkewX(i5 * (f7 <= 0.0f ? 1 : -1) * 0.5f * f6);
        this.f3228j.setAlpha(this.f3250v0 ? (int) (((90.0f - Math.abs(f7)) / 90.0f) * 255.0f) : 255);
    }

    public final void f(int i5) {
        a();
        if (i5 == 2 || i5 == 3) {
            float f6 = this.f3216G;
            float f7 = this.f3243s;
            int i6 = (int) (((f6 % f7) + f7) % f7);
            this.f3234n0 = i6;
            float f8 = i6;
            if (f8 > f7 / 2.0f) {
                this.f3234n0 = (int) (f7 - f8);
            } else {
                this.f3234n0 = -i6;
            }
        }
        this.f3227i = this.f3226h.scheduleWithFixedDelay(new Y0.c(this, this.f3234n0), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final W0.a getAdapter() {
        return this.f3232m;
    }

    public final int getCurrentItem() {
        int i5;
        W0.a aVar = this.f3232m;
        if (aVar == null) {
            return 0;
        }
        return (!this.f3254z || ((i5 = this.f3218I) >= 0 && i5 < aVar.h())) ? Math.max(0, Math.min(this.f3218I, this.f3232m.h() - 1)) : Math.max(0, Math.min(Math.abs(Math.abs(this.f3218I) - this.f3232m.h()), this.f3232m.h() - 1));
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.c;
    }

    public int getInitPosition() {
        return this.f3217H;
    }

    public float getItemHeight() {
        return this.f3243s;
    }

    public int getItemsCount() {
        W0.a aVar = this.f3232m;
        if (aVar != null) {
            return aVar.h();
        }
        return 0;
    }

    public float getTotalScrollY() {
        return this.f3216G;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f6;
        boolean z6;
        Canvas canvas2;
        float f7;
        int i5;
        int i6;
        float f8;
        int i7;
        boolean z7;
        int i8;
        String str;
        String str2;
        int iCeil;
        if (this.f3232m == null) {
            return;
        }
        int i9 = 0;
        int iMin = Math.min(Math.max(0, this.f3217H), this.f3232m.h() - 1);
        this.f3217H = iMin;
        try {
            this.f3219J = iMin + (((int) (this.f3216G / this.f3243s)) % this.f3232m.h());
            while (true) {
                int i10 = this.f3220K;
                if (i5 >= i10) {
                    return;
                }
                int i11 = this.f3219J - ((i10 / 2) - i5);
                Object item = this.f3254z ? this.f3232m.getItem(c(i11)) : (i11 >= 0 && i11 <= this.f3232m.h() + (-1)) ? this.f3232m.getItem(i11) : "";
                canvas2.save();
                double d = ((this.f3243s * i5) - f6) / this.f3230k0;
                float f9 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f9 > 90.0f || f9 < -90.0f) {
                    i6 = i5;
                    f8 = f7;
                    i7 = i9;
                    z7 = z6;
                    canvas2.restore();
                } else {
                    String strB = (this.f3225g || TextUtils.isEmpty(this.f3233n) || TextUtils.isEmpty(b(item))) ? b(item) : b(item) + this.f3233n;
                    float fPow = (float) Math.pow(Math.abs(f9) / 90.0f, 2.2d);
                    Rect rect = new Rect();
                    this.f3229k.getTextBounds(strB, i9, strB.length(), rect);
                    int i12 = this.f3235o;
                    for (int iWidth = rect.width(); iWidth > this.f3222Q; iWidth = rect.width()) {
                        i12--;
                        this.f3229k.setTextSize(i12);
                        this.f3229k.getTextBounds(strB, i9, strB.length(), rect);
                    }
                    this.f3228j.setTextSize(i12);
                    Rect rect2 = new Rect();
                    this.f3229k.getTextBounds(strB, i9, strB.length(), rect2);
                    int i13 = this.f3242r0;
                    if (i13 != 3) {
                        if (i13 == 5) {
                            this.f3244s0 = (this.f3222Q - rect2.width()) - ((int) f7);
                        } else if (i13 == 17) {
                            if (this.f3224f || (str2 = this.f3233n) == null || str2.equals("") || !this.f3225g) {
                                this.f3244s0 = (int) (((double) (this.f3222Q - rect2.width())) * 0.5d);
                            } else {
                                this.f3244s0 = (int) (((double) (this.f3222Q - rect2.width())) * 0.25d);
                            }
                        }
                        i8 = 0;
                    } else {
                        i8 = 0;
                        this.f3244s0 = 0;
                    }
                    Rect rect3 = new Rect();
                    this.f3228j.getTextBounds(strB, i8, strB.length(), rect3);
                    int i14 = this.f3242r0;
                    if (i14 == 3) {
                        this.f3246t0 = 0;
                    } else if (i14 == 5) {
                        this.f3246t0 = (this.f3222Q - rect3.width()) - ((int) f7);
                    } else if (i14 == 17) {
                        if (this.f3224f || (str = this.f3233n) == null || str.equals("") || !this.f3225g) {
                            this.f3246t0 = (int) (((double) (this.f3222Q - rect3.width())) * 0.5d);
                        } else {
                            this.f3246t0 = (int) (((double) (this.f3222Q - rect3.width())) * 0.25d);
                        }
                    }
                    i6 = i5;
                    f8 = f7;
                    float fCos = (float) ((((double) this.f3230k0) - (Math.cos(d) * ((double) this.f3230k0))) - ((Math.sin(d) * ((double) this.f3239q)) / 2.0d));
                    canvas2.translate(0.0f, fCos);
                    float f10 = this.f3213A;
                    if (fCos > f10 || this.f3239q + fCos < f10) {
                        float f11 = this.f3214C;
                        if (fCos > f11 || this.f3239q + fCos < f11) {
                            z7 = false;
                            if (fCos >= f10) {
                                float f12 = this.f3239q;
                                if (fCos + f12 <= f11) {
                                    canvas2.drawText(strB, this.f3244s0, f12 - f8, this.f3229k);
                                    this.f3218I = this.f3219J - ((this.f3220K / 2) - i6);
                                }
                            }
                            canvas2.save();
                            i7 = 0;
                            canvas2.clipRect(0, 0, this.f3222Q, (int) this.f3243s);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            e(fPow, f9);
                            canvas2.drawText(strB, (this.f3241r * fPow) + this.f3246t0, this.f3239q, this.f3228j);
                            canvas2.restore();
                        } else {
                            canvas2.save();
                            canvas2.clipRect(0.0f, 0.0f, this.f3222Q, this.f3214C - fCos);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                            canvas2.drawText(strB, this.f3244s0, this.f3239q - f8, this.f3229k);
                            canvas2.restore();
                            canvas2.save();
                            z7 = false;
                            canvas2.clipRect(0.0f, this.f3214C - fCos, this.f3222Q, (int) this.f3243s);
                            canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                            e(fPow, f9);
                            canvas2.drawText(strB, this.f3246t0, this.f3239q, this.f3228j);
                            canvas2.restore();
                        }
                        i7 = 0;
                    } else {
                        canvas2.save();
                        canvas2.clipRect(0.0f, 0.0f, this.f3222Q, this.f3213A - fCos);
                        canvas2.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        e(fPow, f9);
                        canvas2.drawText(strB, this.f3246t0, this.f3239q, this.f3228j);
                        canvas2.restore();
                        canvas2.save();
                        canvas2.clipRect(0.0f, this.f3213A - fCos, this.f3222Q, (int) this.f3243s);
                        canvas2.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas2.drawText(strB, this.f3244s0, this.f3239q - f8, this.f3229k);
                        canvas2.restore();
                        i7 = 0;
                        z7 = false;
                    }
                    canvas2.restore();
                    this.f3229k.setTextSize(this.f3235o);
                }
                i5 = i6 + 1;
                i9 = i7;
                z6 = z7;
                f7 = f8;
            }
        } catch (ArithmeticException unused) {
            Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
        }
        if (this.f3254z) {
            if (this.f3219J < 0) {
                this.f3219J = this.f3232m.h() + this.f3219J;
            }
            if (this.f3219J > this.f3232m.h() - 1) {
                this.f3219J -= this.f3232m.h();
            }
        } else {
            if (this.f3219J < 0) {
                this.f3219J = 0;
            }
            if (this.f3219J > this.f3232m.h() - 1) {
                this.f3219J = this.f3232m.h() - 1;
            }
        }
        f6 = this.f3216G % this.f3243s;
        c cVar = this.f3223a;
        z6 = false;
        if (cVar == c.b) {
            float f13 = (TextUtils.isEmpty(this.f3233n) ? (this.f3222Q - this.f3237p) / 2 : (this.f3222Q - this.f3237p) / 4) - 12;
            float f14 = f13 <= 0.0f ? 10.0f : f13;
            float f15 = this.f3222Q - f14;
            float f16 = this.f3213A;
            canvas2 = canvas;
            canvas2.drawLine(f14, f16, f15, f16, this.f3231l);
            float f17 = this.f3214C;
            canvas2.drawLine(f14, f17, f15, f17, this.f3231l);
        } else if (cVar == c.c) {
            this.f3231l.setStyle(Paint.Style.STROKE);
            this.f3231l.setStrokeWidth(this.f3252x);
            float f18 = (TextUtils.isEmpty(this.f3233n) ? (this.f3222Q - this.f3237p) / 2.0f : (this.f3222Q - this.f3237p) / 4.0f) - 12.0f;
            float f19 = f18 > 0.0f ? f18 : 10.0f;
            canvas.drawCircle(this.f3222Q / 2.0f, this.f3221M / 2.0f, Math.max((this.f3222Q - f19) - f19, this.f3243s) / 1.8f, this.f3231l);
            canvas2 = canvas;
        } else {
            float f20 = this.f3213A;
            canvas.drawLine(0.0f, f20, this.f3222Q, f20, this.f3231l);
            float f21 = this.f3214C;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, f21, this.f3222Q, f21, this.f3231l);
        }
        boolean zIsEmpty = TextUtils.isEmpty(this.f3233n);
        f7 = this.f3248u0;
        if (!zIsEmpty && this.f3225g) {
            int i15 = this.f3222Q;
            String str3 = this.f3233n;
            if (str3 == null || str3.length() <= 0) {
                iCeil = 0;
            } else {
                int length = str3.length();
                float[] fArr = new float[length];
                this.f3229k.getTextWidths(str3, fArr);
                iCeil = 0;
                for (int i16 = 0; i16 < length; i16++) {
                    iCeil += (int) Math.ceil(fArr[i16]);
                }
            }
            canvas2.drawText(this.f3233n, (i15 - iCeil) - f7, this.f3215D, this.f3229k);
        }
        i5 = 0;
    }

    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        this.f3240q0 = i5;
        d();
        setMeasuredDimension(this.f3222Q, this.f3221M);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.d.onTouchEvent(motionEvent);
        float f6 = (-this.f3217H) * this.f3243s;
        float fH = ((this.f3232m.h() - 1) - this.f3217H) * this.f3243s;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3238p0 = System.currentTimeMillis();
            a();
            this.f3236o0 = motionEvent.getRawY();
        } else if (action == 2) {
            float rawY = this.f3236o0 - motionEvent.getRawY();
            this.f3236o0 = motionEvent.getRawY();
            float f7 = this.f3216G + rawY;
            this.f3216G = f7;
            if (!this.f3254z) {
                float f8 = this.f3243s * 0.25f;
                if ((f7 - f8 < f6 && rawY < 0.0f) || (f8 + f7 > fH && rawY > 0.0f)) {
                    this.f3216G = f7 - rawY;
                    return true;
                }
            }
        } else if (!zOnTouchEvent) {
            float y6 = motionEvent.getY();
            float f9 = this.f3230k0;
            double dAcos = Math.acos((f9 - y6) / f9) * ((double) this.f3230k0);
            float f10 = this.f3243s;
            this.f3234n0 = (int) (((((int) ((dAcos + ((double) (f10 / 2.0f))) / ((double) f10))) - (this.f3220K / 2)) * f10) - (((this.f3216G % f10) + f10) % f10));
            if (System.currentTimeMillis() - this.f3238p0 > 120) {
                f(3);
            } else {
                f(1);
            }
        }
        if (motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public final void setAdapter(W0.a aVar) {
        this.f3232m = aVar;
        d();
        invalidate();
    }

    public void setAlphaGradient(boolean z6) {
        this.f3250v0 = z6;
    }

    public final void setCurrentItem(int i5) {
        this.f3218I = i5;
        this.f3217H = i5;
        this.f3216G = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z6) {
        this.f3254z = z6;
    }

    public void setDividerColor(int i5) {
        this.f3251w = i5;
        this.f3231l.setColor(i5);
    }

    public void setDividerType(c cVar) {
        this.f3223a = cVar;
    }

    public void setDividerWidth(int i5) {
        this.f3252x = i5;
        this.f3231l.setStrokeWidth(i5);
    }

    public void setGravity(int i5) {
        this.f3242r0 = i5;
    }

    public void setIsOptions(boolean z6) {
        this.f3224f = z6;
    }

    public void setItemsVisibleCount(int i5) {
        if (i5 % 2 == 0) {
            i5++;
        }
        this.f3220K = i5 + 2;
    }

    public void setLabel(String str) {
        this.f3233n = str;
    }

    public void setLineSpacingMultiplier(float f6) {
        if (f6 != 0.0f) {
            this.f3253y = f6;
            if (f6 < 1.0f) {
                this.f3253y = 1.0f;
            } else if (f6 > 4.0f) {
                this.f3253y = 4.0f;
            }
        }
    }

    public final void setOnItemSelectedListener(a aVar) {
        this.e = aVar;
    }

    public void setTextColorCenter(int i5) {
        this.f3249v = i5;
        this.f3229k.setColor(i5);
    }

    public void setTextColorOut(int i5) {
        this.f3247u = i5;
        this.f3228j.setColor(i5);
    }

    public final void setTextSize(float f6) {
        if (f6 > 0.0f) {
            int i5 = (int) (this.b.getResources().getDisplayMetrics().density * f6);
            this.f3235o = i5;
            this.f3228j.setTextSize(i5);
            this.f3229k.setTextSize(this.f3235o);
        }
    }

    public void setTextXOffset(int i5) {
        this.f3241r = i5;
        if (i5 != 0) {
            this.f3229k.setTextScaleX(1.0f);
        }
    }

    public void setTotalScrollY(float f6) {
        this.f3216G = f6;
    }

    public final void setTypeface(Typeface typeface) {
        this.f3245t = typeface;
        this.f3228j.setTypeface(typeface);
        this.f3229k.setTypeface(this.f3245t);
    }
}
