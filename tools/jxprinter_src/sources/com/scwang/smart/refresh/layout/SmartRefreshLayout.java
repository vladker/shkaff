package com.scwang.smart.refresh.layout;

import H2.g;
import H2.h;
import H2.i;
import H2.j;
import H2.k;
import I2.d;
import I2.f;
import L2.a;
import L2.b;
import L2.c;
import L2.e;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import io.reactivex.internal.operators.observable.C0953x2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements f, NestedScrollingParent {

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static a f3686l1;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static b f3687m1;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static c f3688n1;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final ViewGroup.MarginLayoutParams f3689o1 = new ViewGroup.MarginLayoutParams(-1, -1);

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int[] f3690A;

    /* JADX INFO: renamed from: A0, reason: collision with root package name */
    public e f3691A0;

    /* JADX INFO: renamed from: B0, reason: collision with root package name */
    public L2.f f3692B0;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final boolean f3693C;

    /* JADX INFO: renamed from: C0, reason: collision with root package name */
    public int f3694C0;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f3695D;

    /* JADX INFO: renamed from: D0, reason: collision with root package name */
    public boolean f3696D0;

    /* JADX INFO: renamed from: E0, reason: collision with root package name */
    public final int[] f3697E0;

    /* JADX INFO: renamed from: F0, reason: collision with root package name */
    public final NestedScrollingChildHelper f3698F0;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final boolean f3699G;

    /* JADX INFO: renamed from: G0, reason: collision with root package name */
    public final NestedScrollingParentHelper f3700G0;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final boolean f3701H;

    /* JADX INFO: renamed from: H0, reason: collision with root package name */
    public int f3702H0;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f3703I;

    /* JADX INFO: renamed from: I0, reason: collision with root package name */
    public J2.a f3704I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f3705J;

    /* JADX INFO: renamed from: J0, reason: collision with root package name */
    public int f3706J0;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final boolean f3707K;

    /* JADX INFO: renamed from: K0, reason: collision with root package name */
    public J2.a f3708K0;

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public final int f3709L0;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final boolean f3710M;

    /* JADX INFO: renamed from: M0, reason: collision with root package name */
    public final int f3711M0;

    /* JADX INFO: renamed from: N0, reason: collision with root package name */
    public float f3712N0;

    /* JADX INFO: renamed from: O0, reason: collision with root package name */
    public float f3713O0;

    /* JADX INFO: renamed from: P0, reason: collision with root package name */
    public float f3714P0;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public final boolean f3715Q;

    /* JADX INFO: renamed from: Q0, reason: collision with root package name */
    public float f3716Q0;

    /* JADX INFO: renamed from: R0, reason: collision with root package name */
    public final float f3717R0;

    /* JADX INFO: renamed from: S0, reason: collision with root package name */
    public d f3718S0;

    /* JADX INFO: renamed from: T0, reason: collision with root package name */
    public I2.c f3719T0;

    /* JADX INFO: renamed from: U0, reason: collision with root package name */
    public O2.a f3720U0;

    /* JADX INFO: renamed from: V0, reason: collision with root package name */
    public Paint f3721V0;

    /* JADX INFO: renamed from: W0, reason: collision with root package name */
    public final Handler f3722W0;

    /* JADX INFO: renamed from: X0, reason: collision with root package name */
    public final k f3723X0;

    /* JADX INFO: renamed from: Y0, reason: collision with root package name */
    public J2.b f3724Y0;

    /* JADX INFO: renamed from: Z0, reason: collision with root package name */
    public J2.b f3725Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3726a;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public long f3727a1;
    public int b;
    public int b1;
    public int c;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f3728c1;
    public int d;
    public boolean d1;
    public final int e;
    public boolean e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3729f;
    public boolean f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f3730g;
    public boolean g1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3731h;
    public boolean h1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3732i;
    public MotionEvent i1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3733j;
    public Runnable j1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3734k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final boolean f3735k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public ValueAnimator f3736k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3737l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public char f3738m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3739n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f3740n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3741o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final boolean f3742o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f3743p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f3744p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3745q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final boolean f3746q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3747r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final boolean f3748r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3749s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f3750s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3751t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final boolean f3752t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f3753u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final boolean f3754u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f3755v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public boolean f3756v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3757w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f3758w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Scroller f3759x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public boolean f3760x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final VelocityTracker f3761y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public boolean f3762y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Interpolator f3763z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f3764z0;

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 300;
        this.f3729f = 300;
        this.f3737l = 0.5f;
        this.f3738m = 'n';
        this.f3745q = -1;
        this.f3747r = -1;
        this.f3749s = -1;
        this.f3751t = -1;
        this.f3693C = true;
        this.f3695D = false;
        this.f3699G = true;
        this.f3701H = true;
        this.f3703I = true;
        this.f3705J = true;
        this.f3707K = false;
        this.f3710M = true;
        this.f3715Q = true;
        this.f3735k0 = false;
        this.f3740n0 = true;
        this.f3742o0 = false;
        this.f3744p0 = true;
        this.f3746q0 = true;
        this.f3748r0 = true;
        this.f3750s0 = true;
        this.f3752t0 = false;
        this.f3754u0 = false;
        this.f3756v0 = false;
        this.f3758w0 = false;
        this.f3760x0 = false;
        this.f3762y0 = false;
        this.f3764z0 = false;
        this.f3697E0 = new int[2];
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.f3698F0 = nestedScrollingChildHelper;
        this.f3700G0 = new NestedScrollingParentHelper(this);
        J2.a aVar = J2.a.c;
        this.f3704I0 = aVar;
        this.f3708K0 = aVar;
        this.f3712N0 = 2.5f;
        this.f3713O0 = 2.5f;
        this.f3714P0 = 1.0f;
        this.f3716Q0 = 1.0f;
        this.f3717R0 = 0.16666667f;
        this.f3723X0 = new k(this);
        J2.b bVar = J2.b.None;
        this.f3724Y0 = bVar;
        this.f3725Z0 = bVar;
        this.f3727a1 = 0L;
        this.b1 = 0;
        this.f3728c1 = 0;
        this.g1 = false;
        this.h1 = false;
        this.i1 = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3722W0 = new Handler(Looper.getMainLooper());
        this.f3759x = new Scroller(context);
        this.f3761y = VelocityTracker.obtain();
        this.f3730g = context.getResources().getDisplayMetrics().heightPixels;
        this.f3763z = new N2.b();
        this.f3726a = viewConfiguration.getScaledTouchSlop();
        this.f3753u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3755v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3706J0 = N2.b.a(60.0f);
        this.f3702H0 = N2.b.a(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K2.c.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(K2.c.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(K2.c.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        c cVar = f3688n1;
        if (cVar != null) {
            ((p131x.a) cVar).initialize(context, this);
        }
        this.f3737l = typedArrayObtainStyledAttributes.getFloat(K2.c.SmartRefreshLayout_srlDragRate, this.f3737l);
        this.f3712N0 = typedArrayObtainStyledAttributes.getFloat(K2.c.SmartRefreshLayout_srlHeaderMaxDragRate, this.f3712N0);
        this.f3713O0 = typedArrayObtainStyledAttributes.getFloat(K2.c.SmartRefreshLayout_srlFooterMaxDragRate, this.f3713O0);
        this.f3714P0 = typedArrayObtainStyledAttributes.getFloat(K2.c.SmartRefreshLayout_srlHeaderTriggerRate, this.f3714P0);
        this.f3716Q0 = typedArrayObtainStyledAttributes.getFloat(K2.c.SmartRefreshLayout_srlFooterTriggerRate, this.f3716Q0);
        this.f3693C = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableRefresh, true);
        this.f3729f = typedArrayObtainStyledAttributes.getInt(K2.c.SmartRefreshLayout_srlReboundDuration, 300);
        int i5 = K2.c.SmartRefreshLayout_srlEnableLoadMore;
        this.f3695D = typedArrayObtainStyledAttributes.getBoolean(i5, this.f3695D);
        int i6 = K2.c.SmartRefreshLayout_srlHeaderHeight;
        this.f3702H0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i6, this.f3702H0);
        int i7 = K2.c.SmartRefreshLayout_srlFooterHeight;
        this.f3706J0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i7, this.f3706J0);
        this.f3709L0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(K2.c.SmartRefreshLayout_srlHeaderInsetStart, this.f3709L0);
        this.f3711M0 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(K2.c.SmartRefreshLayout_srlFooterInsetStart, this.f3711M0);
        this.f3752t0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlDisableContentWhenRefresh, false);
        this.f3754u0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlDisableContentWhenLoading, false);
        int i8 = K2.c.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.f3703I = typedArrayObtainStyledAttributes.getBoolean(i8, this.f3703I);
        int i9 = K2.c.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.f3705J = typedArrayObtainStyledAttributes.getBoolean(i9, this.f3705J);
        this.f3710M = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnablePreviewInEditMode, true);
        this.f3740n0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableAutoLoadMore, this.f3740n0);
        this.f3715Q = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableOverScrollBounce, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnablePureScrollMode, false);
        this.f3742o0 = z6;
        this.f3744p0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, true);
        this.f3746q0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, true);
        this.f3748r0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, true);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, false);
        this.f3707K = z7;
        this.f3707K = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z7);
        this.f3699G = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, true);
        this.f3701H = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, true);
        this.f3735k0 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableOverScrollDrag, false);
        this.f3745q = typedArrayObtainStyledAttributes.getResourceId(K2.c.SmartRefreshLayout_srlFixedHeaderViewId, this.f3745q);
        this.f3747r = typedArrayObtainStyledAttributes.getResourceId(K2.c.SmartRefreshLayout_srlFixedFooterViewId, this.f3747r);
        this.f3749s = typedArrayObtainStyledAttributes.getResourceId(K2.c.SmartRefreshLayout_srlHeaderTranslationViewId, this.f3749s);
        this.f3751t = typedArrayObtainStyledAttributes.getResourceId(K2.c.SmartRefreshLayout_srlFooterTranslationViewId, this.f3751t);
        boolean z8 = typedArrayObtainStyledAttributes.getBoolean(K2.c.SmartRefreshLayout_srlEnableNestedScrolling, this.f3750s0);
        this.f3750s0 = z8;
        nestedScrollingChildHelper.setNestedScrollingEnabled(z8);
        this.f3760x0 = this.f3760x0 || typedArrayObtainStyledAttributes.hasValue(i5);
        this.f3762y0 = this.f3762y0 || typedArrayObtainStyledAttributes.hasValue(i8);
        this.f3764z0 = this.f3764z0 || typedArrayObtainStyledAttributes.hasValue(i9);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i6);
        J2.a aVar2 = J2.a.f352f;
        this.f3704I0 = zHasValue ? aVar2 : this.f3704I0;
        this.f3708K0 = typedArrayObtainStyledAttributes.hasValue(i7) ? aVar2 : this.f3708K0;
        int color = typedArrayObtainStyledAttributes.getColor(K2.c.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(K2.c.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.f3690A = new int[]{color2, color};
            } else {
                this.f3690A = new int[]{color2};
            }
        } else if (color != 0) {
            this.f3690A = new int[]{0, color};
        }
        if (z6 && !this.f3760x0 && !this.f3695D) {
            this.f3695D = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void setDefaultRefreshFooterCreator(@NonNull a aVar) {
        f3686l1 = aVar;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull b bVar) {
        f3687m1 = bVar;
    }

    public static void setDefaultRefreshInitializer(@NonNull c cVar) {
        f3688n1 = cVar;
    }

    @Override // android.view.View
    public final void computeScroll() {
        J2.b bVar;
        Scroller scroller = this.f3759x;
        scroller.getCurrY();
        if (scroller.computeScrollOffset()) {
            int finalY = scroller.getFinalY();
            boolean z6 = this.f3735k0;
            if ((finalY >= 0 || !((this.f3693C || z6) && this.f3720U0.b())) && (finalY <= 0 || !((this.f3695D || z6) && this.f3720U0.a()))) {
                this.h1 = true;
                invalidate();
                return;
            }
            if (this.h1) {
                float currVelocity = finalY > 0 ? -scroller.getCurrVelocity() : scroller.getCurrVelocity();
                if (this.f3736k1 == null) {
                    if (currVelocity > 0.0f && ((bVar = this.f3724Y0) == J2.b.Refreshing || bVar == J2.b.TwoLevel)) {
                        this.j1 = new h(currVelocity, this.f3702H0, this);
                    } else if (currVelocity < 0.0f && (this.f3724Y0 == J2.b.Loading || ((this.f3707K && this.f3756v0 && this.f3758w0 && n(this.f3695D)) || (this.f3740n0 && !this.f3756v0 && n(this.f3695D) && this.f3724Y0 != J2.b.Refreshing)))) {
                        this.j1 = new h(currVelocity, -this.f3706J0, this);
                    } else if (this.b == 0 && this.f3715Q) {
                        this.j1 = new h(currVelocity, 0, this);
                    }
                }
            }
            scroller.forceFinished(true);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0111  */
    /* JADX WARN: Code duplicated, block: B:122:0x0167  */
    /* JADX WARN: Code duplicated, block: B:131:0x0185  */
    /* JADX WARN: Code duplicated, block: B:133:0x0189  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:149:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:160:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:161:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:176:0x0206  */
    /* JADX WARN: Code duplicated, block: B:179:0x0237  */
    /* JADX WARN: Code duplicated, block: B:185:0x0245 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:191:0x025f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:192:0x0261 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:201:0x0283 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:202:0x0285  */
    /* JADX WARN: Code duplicated, block: B:207:0x028f  */
    /* JADX WARN: Code duplicated, block: B:211:0x0299  */
    /* JADX WARN: Code duplicated, block: B:215:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:222:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:225:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:228:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:232:0x0305  */
    /* JADX WARN: Code duplicated, block: B:234:0x032a  */
    /* JADX WARN: Code duplicated, block: B:236:0x033b  */
    /* JADX WARN: Code duplicated, block: B:240:0x0344  */
    /* JADX WARN: Code duplicated, block: B:242:0x036a  */
    /* JADX WARN: Code duplicated, block: B:245:0x0376  */
    /* JADX WARN: Code duplicated, block: B:247:0x037c  */
    /* JADX WARN: Code duplicated, block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00da  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:95:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x010d A[DONT_INVERT] */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00dc, code lost:
    
        if (r5.b != false) goto L250;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r27) {
        /*
            Method dump skipped, instruction units count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smart.refresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j6) {
        Paint paint;
        Paint paint2;
        O2.a aVar = this.f3720U0;
        View view2 = aVar != null ? aVar.getView() : null;
        d dVar = this.f3718S0;
        J2.c cVar = J2.c.e;
        J2.c cVar2 = J2.c.d;
        boolean z6 = this.f3710M;
        if (dVar != null && dVar.getView() == view) {
            if (!n(this.f3693C)) {
                return true;
            }
            if (!z6 && isInEditMode()) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getPaddingTop() + view2.getTop() + this.b, view.getTop());
                int i5 = this.b1;
                if (i5 != 0 && (paint2 = this.f3721V0) != null) {
                    paint2.setColor(i5);
                    if (this.f3718S0.getSpinnerStyle().c) {
                        iMax = view.getBottom();
                    } else if (this.f3718S0.getSpinnerStyle() == cVar2) {
                        iMax = view.getBottom() + this.b;
                    }
                    int i6 = iMax;
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), i6, this.f3721V0);
                    iMax = i6;
                }
                if ((this.f3699G && this.f3718S0.getSpinnerStyle() == cVar) || this.f3718S0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j6);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        I2.c cVar3 = this.f3719T0;
        if (cVar3 != null && cVar3.getView() == view) {
            if (!n(this.f3695D)) {
                return true;
            }
            if (!z6 && isInEditMode()) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.b, view.getBottom());
                int i7 = this.f3728c1;
                if (i7 != 0 && (paint = this.f3721V0) != null) {
                    paint.setColor(i7);
                    if (this.f3719T0.getSpinnerStyle().c) {
                        iMin = view.getTop();
                    } else if (this.f3719T0.getSpinnerStyle() == cVar2) {
                        iMin = view.getTop() + this.b;
                    }
                    int i8 = iMin;
                    canvas.drawRect(0.0f, i8, getWidth(), view.getBottom(), this.f3721V0);
                    iMin = i8;
                }
                if ((this.f3701H && this.f3719T0.getSpinnerStyle() == cVar) || this.f3719T0.getSpinnerStyle().c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j6);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j6);
    }

    public final ValueAnimator g(int i5, int i6, Interpolator interpolator, int i7) {
        if (this.b == i5) {
            return null;
        }
        ValueAnimator valueAnimator = this.f3736k1;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            this.f3736k1.cancel();
            this.f3736k1 = null;
        }
        this.j1 = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.b, i5);
        this.f3736k1 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i7);
        this.f3736k1.setInterpolator(interpolator);
        this.f3736k1.addListener(new C5.e(this, 1));
        this.f3736k1.addUpdateListener(new H2.b(this, 0));
        this.f3736k1.setStartDelay(i6);
        this.f3736k1.start();
        return this.f3736k1;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        j jVar = new j(context, attributeSet);
        jVar.f302a = 0;
        jVar.b = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K2.c.SmartRefreshLayout_Layout);
        jVar.f302a = typedArrayObtainStyledAttributes.getColor(K2.c.SmartRefreshLayout_Layout_layout_srlBackgroundColor, 0);
        int i5 = K2.c.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            jVar.b = J2.c.f379h[typedArrayObtainStyledAttributes.getInt(i5, 0)];
        }
        typedArrayObtainStyledAttributes.recycle();
        return jVar;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.f3700G0.getNestedScrollAxes();
    }

    @Override // I2.f
    @Nullable
    public I2.c getRefreshFooter() {
        I2.c cVar = this.f3719T0;
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    @Override // I2.f
    @Nullable
    public d getRefreshHeader() {
        d dVar = this.f3718S0;
        if (dVar != null) {
            return dVar;
        }
        return null;
    }

    @Override // I2.f
    @NonNull
    public J2.b getState() {
        return this.f3724Y0;
    }

    public final void h() {
        int i5 = this.f1 ? 0 : 400;
        float f6 = (this.f3712N0 + this.f3714P0) / 2.0f;
        if (this.f3724Y0 == J2.b.None && n(this.f3693C)) {
            g gVar = new g(f6, this.f3729f, this);
            setViceState(J2.b.Refreshing);
            if (i5 > 0) {
                this.f3722W0.postDelayed(gVar, i5);
            } else {
                gVar.run();
            }
        }
    }

    public final void i() {
        j(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f3727a1))), 300) << 16, false);
    }

    public boolean isEnableTranslationContent(boolean z6, @Nullable I2.a aVar) {
        return z6 || this.f3742o0 || aVar == null || aVar.getSpinnerStyle() == J2.c.e;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        if (this.f3750s0) {
            return this.f3735k0 || this.f3693C || this.f3695D;
        }
        return false;
    }

    public final void j(int i5, boolean z6) {
        int i6 = i5 >> 16;
        int i7 = (i5 << 16) >> 16;
        H2.f fVar = new H2.f(i6, this, z6);
        if (i7 > 0) {
            this.f3722W0.postDelayed(fVar, i7);
        } else {
            fVar.run();
        }
    }

    public final SmartRefreshLayout k() {
        l(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f3727a1))), 300) << 16, true, Boolean.FALSE);
        return this;
    }

    public final void l(int i5, boolean z6, Boolean bool) {
        int i6 = i5 >> 16;
        int i7 = (i5 << 16) >> 16;
        H2.d dVar = new H2.d(this, i6, bool, z6);
        if (i7 > 0) {
            this.f3722W0.postDelayed(dVar, i7);
        } else {
            dVar.run();
        }
    }

    public final boolean m(int i5) {
        if (i5 == 0) {
            if (this.f3736k1 != null) {
                J2.b bVar = this.f3724Y0;
                if (bVar.f375f || bVar == J2.b.TwoLevelReleased || bVar == J2.b.RefreshReleased || bVar == J2.b.LoadReleased) {
                    return true;
                }
                J2.b bVar2 = J2.b.PullDownCanceled;
                k kVar = this.f3723X0;
                if (bVar == bVar2) {
                    kVar.setState(J2.b.PullDownToRefresh);
                } else if (bVar == J2.b.PullUpCanceled) {
                    kVar.setState(J2.b.PullUpToLoad);
                }
                this.f3736k1.setDuration(0L);
                this.f3736k1.cancel();
                this.f3736k1 = null;
            }
            this.j1 = null;
        }
        return this.f3736k1 != null;
    }

    public final boolean n(boolean z6) {
        return z6 && !this.f3742o0;
    }

    public final void o(float f6) {
        J2.b bVar;
        float f7 = (!this.f3696D0 || this.f3748r0 || f6 >= 0.0f || this.f3720U0.a()) ? f6 : 0.0f;
        int i5 = this.f3730g;
        if (f7 > i5 * 5 && getTag() == null) {
            int i6 = K2.a.srl_tag;
            if (getTag(i6) == null) {
                float f8 = i5;
                if (this.f3734k < f8 / 6.0f && this.f3733j < f8 / 16.0f) {
                    Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
                    setTag(i6, "你这么死拉，臣妾做不到啊！");
                }
            }
        }
        J2.b bVar2 = this.f3724Y0;
        J2.b bVar3 = J2.b.TwoLevel;
        k kVar = this.f3723X0;
        if (bVar2 == bVar3 && f7 > 0.0f) {
            kVar.b(Math.min((int) f7, getMeasuredHeight()), true);
        } else if (bVar2 == J2.b.Refreshing && f7 >= 0.0f) {
            float f9 = this.f3702H0;
            if (f7 < f9) {
                kVar.b((int) f7, true);
            } else {
                float f10 = this.f3712N0;
                if (f10 < 10.0f) {
                    f10 *= f9;
                }
                double d = f10 - f9;
                int iMax = Math.max((i5 * 4) / 3, getHeight());
                int i7 = this.f3702H0;
                double d6 = iMax - i7;
                double dMax = Math.max(0.0f, (f7 - i7) * this.f3737l);
                double d7 = -dMax;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                kVar.b(((int) Math.min((1.0d - Math.pow(100.0d, d7 / d6)) * d, dMax)) + this.f3702H0, true);
            }
        } else if (f7 < 0.0f && (bVar2 == J2.b.Loading || ((this.f3707K && this.f3756v0 && this.f3758w0 && n(this.f3695D)) || (this.f3740n0 && !this.f3756v0 && n(this.f3695D))))) {
            int i8 = this.f3706J0;
            if (f7 > (-i8)) {
                kVar.b((int) f7, true);
            } else {
                float f11 = this.f3713O0;
                if (f11 < 10.0f) {
                    f11 *= i8;
                }
                double d8 = f11 - i8;
                int iMax2 = Math.max((i5 * 4) / 3, getHeight());
                int i9 = this.f3706J0;
                double d9 = iMax2 - i9;
                double d10 = -Math.min(0.0f, (i9 + f7) * this.f3737l);
                double d11 = -d10;
                if (d9 == 0.0d) {
                    d9 = 1.0d;
                }
                kVar.b(((int) (-Math.min((1.0d - Math.pow(100.0d, d11 / d9)) * d8, d10))) - this.f3706J0, true);
            }
        } else if (f7 >= 0.0f) {
            float f12 = this.f3712N0;
            double d12 = f12 < 10.0f ? this.f3702H0 * f12 : f12;
            double dMax2 = Math.max(i5 / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.f3737l * f7);
            double d13 = -dMax3;
            if (dMax2 == 0.0d) {
                dMax2 = 1.0d;
            }
            kVar.b((int) Math.min((1.0d - Math.pow(100.0d, d13 / dMax2)) * d12, dMax3), true);
        } else {
            float f13 = this.f3713O0;
            double d14 = f13 < 10.0f ? this.f3706J0 * f13 : f13;
            double dMax4 = Math.max(i5 / 2, getHeight());
            double d15 = -Math.min(0.0f, this.f3737l * f7);
            double d16 = -d15;
            if (dMax4 == 0.0d) {
                dMax4 = 1.0d;
            }
            kVar.b((int) (-Math.min((1.0d - Math.pow(100.0d, d16 / dMax4)) * d14, d15)), true);
        }
        if (!this.f3740n0 || this.f3756v0 || !n(this.f3695D) || f7 >= 0.0f || (bVar = this.f3724Y0) == J2.b.Refreshing || bVar == J2.b.Loading || bVar == J2.b.LoadFinish) {
            return;
        }
        if (this.f3754u0) {
            this.j1 = null;
            kVar.a(-this.f3706J0);
        }
        setStateDirectLoading(false);
        this.f3722W0.postDelayed(new H2.c(this, 0), this.f3729f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        I2.c cVar;
        b bVar;
        super.onAttachedToWindow();
        boolean z6 = true;
        this.f1 = true;
        if (!isInEditMode()) {
            if (this.f3718S0 == null && (bVar = f3687m1) != null) {
                setRefreshHeader(((C0953x2) bVar).createRefreshHeader(getContext(), this));
            }
            if (this.f3719T0 == null) {
                a aVar = f3686l1;
                if (aVar != null) {
                    setRefreshFooter(((C0953x2) aVar).createRefreshFooter(getContext(), this));
                }
            } else {
                if (!this.f3695D && this.f3760x0) {
                    z6 = false;
                }
                this.f3695D = z6;
            }
            if (this.f3720U0 == null) {
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    d dVar = this.f3718S0;
                    if ((dVar == null || childAt != dVar.getView()) && ((cVar = this.f3719T0) == null || childAt != cVar.getView())) {
                        this.f3720U0 = new O2.a(childAt);
                    }
                }
            }
            if (this.f3720U0 == null) {
                int iA = N2.b.a(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(K2.b.srl_content_empty);
                super.addView(textView, 0, new j(-1, -1));
                O2.a aVar2 = new O2.a(textView);
                this.f3720U0 = aVar2;
                aVar2.getView().setPadding(iA, iA, iA, iA);
            }
            View viewFindViewById = findViewById(this.f3745q);
            View viewFindViewById2 = findViewById(this.f3747r);
            this.f3720U0.f555i.getClass();
            O2.a aVar3 = this.f3720U0;
            aVar3.f555i.f470a = this.f3748r0;
            aVar3.f(this.f3723X0, viewFindViewById, viewFindViewById2);
            if (this.b != 0) {
                p(J2.b.None);
                O2.a aVar4 = this.f3720U0;
                this.b = 0;
                aVar4.d(0, this.f3749s, this.f3751t);
            }
        }
        int[] iArr = this.f3690A;
        if (iArr != null) {
            d dVar2 = this.f3718S0;
            if (dVar2 != null) {
                dVar2.setPrimaryColors(iArr);
            }
            I2.c cVar2 = this.f3719T0;
            if (cVar2 != null) {
                cVar2.setPrimaryColors(this.f3690A);
            }
        }
        O2.a aVar5 = this.f3720U0;
        if (aVar5 != null) {
            super.bringChildToFront(aVar5.getView());
        }
        d dVar3 = this.f3718S0;
        if (dVar3 != null && dVar3.getSpinnerStyle().b) {
            super.bringChildToFront(this.f3718S0.getView());
        }
        I2.c cVar3 = this.f3719T0;
        if (cVar3 == null || !cVar3.getSpinnerStyle().b) {
            return;
        }
        super.bringChildToFront(this.f3719T0.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1 = false;
        this.f3760x0 = true;
        this.j1 = null;
        ValueAnimator valueAnimator = this.f3736k1;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f3736k1.removeAllUpdateListeners();
            this.f3736k1.setDuration(0L);
            this.f3736k1.cancel();
            this.f3736k1 = null;
        }
        d dVar = this.f3718S0;
        if (dVar != null && this.f3724Y0 == J2.b.Refreshing) {
            dVar.onFinish(this, false);
        }
        I2.c cVar = this.f3719T0;
        if (cVar != null && this.f3724Y0 == J2.b.Loading) {
            cVar.onFinish(this, false);
        }
        if (this.b != 0) {
            this.f3723X0.b(0, true);
        }
        J2.b bVar = this.f3724Y0;
        J2.b bVar2 = J2.b.None;
        if (bVar != bVar2) {
            p(bVar2);
        }
        Handler handler = this.f3722W0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.g1 = false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onFinishInflate() {
        int i5;
        int i6;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i7 = -1;
        int i8 = 0;
        char c = 0;
        while (true) {
            if (i8 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i8);
            if (N2.b.b(childAt) && (c < 2 || i8 == 1)) {
                i7 = i8;
                c = 2;
            } else if (!(childAt instanceof I2.a) && c < 1) {
                c = i8 > 0 ? (char) 1 : (char) 0;
                i7 = i8;
            }
            i8++;
        }
        if (i7 >= 0) {
            this.f3720U0 = new O2.a(super.getChildAt(i7));
            if (i7 == 1) {
                i6 = childCount != 3 ? -1 : 2;
                i5 = 0;
            } else if (childCount == 2) {
                i5 = -1;
                i6 = 1;
            } else {
                i5 = -1;
                i6 = -1;
            }
        } else {
            i5 = -1;
            i6 = -1;
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt2 = super.getChildAt(i9);
            if (i9 == i5 || (i9 != i6 && i5 == -1 && this.f3718S0 == null && (childAt2 instanceof d))) {
                this.f3718S0 = childAt2 instanceof d ? (d) childAt2 : new O2.c(childAt2);
            } else if (i9 == i6 || (i6 == -1 && (childAt2 instanceof I2.c))) {
                this.f3695D = this.f3695D || !this.f3760x0;
                this.f3719T0 = childAt2 instanceof I2.c ? (I2.c) childAt2 : new O2.b(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = super.getChildAt(i9);
            if (childAt.getVisibility() != 8 && !"GONE".equals(childAt.getTag(K2.a.srl_tag))) {
                O2.a aVar = this.f3720U0;
                boolean z7 = this.f3693C;
                ViewGroup.MarginLayoutParams marginLayoutParams = f3689o1;
                boolean z8 = this.f3710M;
                if (aVar != null && aVar.getView() == childAt) {
                    boolean z9 = isInEditMode() && z8 && n(z7) && this.f3718S0 != null;
                    View view = this.f3720U0.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : marginLayoutParams;
                    int i10 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i11 = marginLayoutParams2.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i10;
                    int measuredHeight = view.getMeasuredHeight() + i11;
                    if (z9 && isEnableTranslationContent(this.f3703I, this.f3718S0)) {
                        int i12 = this.f3702H0;
                        i11 += i12;
                        measuredHeight += i12;
                    }
                    view.layout(i10, i11, measuredWidth, measuredHeight);
                }
                d dVar = this.f3718S0;
                J2.c cVar = J2.c.d;
                if (dVar != null && dVar.getView() == childAt) {
                    boolean z10 = isInEditMode() && z8 && n(z7);
                    View view2 = this.f3718S0.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : marginLayoutParams;
                    int i13 = marginLayoutParams3.leftMargin;
                    int i14 = marginLayoutParams3.topMargin + this.f3709L0;
                    int measuredWidth2 = view2.getMeasuredWidth() + i13;
                    int measuredHeight2 = view2.getMeasuredHeight() + i14;
                    if (!z10 && this.f3718S0.getSpinnerStyle() == cVar) {
                        int i15 = this.f3702H0;
                        i14 -= i15;
                        measuredHeight2 -= i15;
                    }
                    view2.layout(i13, i14, measuredWidth2, measuredHeight2);
                }
                I2.c cVar2 = this.f3719T0;
                if (cVar2 != null && cVar2.getView() == childAt) {
                    boolean z11 = isInEditMode() && z8 && n(this.f3695D);
                    View view3 = this.f3719T0.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                    }
                    J2.c spinnerStyle = this.f3719T0.getSpinnerStyle();
                    int i16 = marginLayoutParams.leftMargin;
                    int measuredHeight3 = getMeasuredHeight() + marginLayoutParams.topMargin;
                    int i17 = this.f3711M0;
                    int measuredHeight4 = measuredHeight3 - i17;
                    if (this.f3756v0 && this.f3758w0 && this.f3707K && this.f3720U0 != null && this.f3719T0.getSpinnerStyle() == cVar && n(this.f3695D)) {
                        View view4 = this.f3720U0.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight4 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == J2.c.f378g) {
                        measuredHeight4 = marginLayoutParams.topMargin - i17;
                    } else {
                        if (z11 || spinnerStyle == J2.c.f377f || spinnerStyle == J2.c.e) {
                            iMax = this.f3706J0;
                        } else if (spinnerStyle.c && this.b < 0) {
                            iMax = Math.max(n(this.f3695D) ? -this.b : 0, 0);
                        }
                        measuredHeight4 -= iMax;
                    }
                    view3.layout(i16, measuredHeight4, view3.getMeasuredWidth() + i16, view3.getMeasuredHeight() + measuredHeight4);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0227  */
    /* JADX WARN: Code duplicated, block: B:120:0x025a  */
    /* JADX WARN: Code duplicated, block: B:123:0x0273  */
    /* JADX WARN: Code duplicated, block: B:125:0x0279  */
    /* JADX WARN: Code duplicated, block: B:127:0x027f  */
    /* JADX WARN: Code duplicated, block: B:133:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:137:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:175:0x035b A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Override // android.view.View
    public final void onMeasure(int i5, int i6) {
        boolean z6;
        int i7;
        int i8;
        int i9;
        int i10;
        J2.a[] aVarArr;
        int measuredWidth;
        int measuredHeight;
        I2.c cVar;
        int i11;
        int i12;
        int i13;
        O2.a aVar;
        int iMax;
        J2.a aVar2;
        boolean z7;
        float f6;
        int i14;
        int size;
        boolean z8 = isInEditMode() && this.f3710M;
        int childCount = super.getChildCount();
        int i15 = 0;
        int measuredWidth2 = 0;
        int measuredHeight2 = 0;
        while (i15 < childCount) {
            View childAt = super.getChildAt(i15);
            if (childAt.getVisibility() == 8 || "GONE".equals(childAt.getTag(K2.a.srl_tag))) {
                z6 = z8;
                i7 = childCount;
                i8 = i15;
                measuredWidth2 = measuredWidth2;
                measuredHeight2 = measuredHeight2;
            } else {
                d dVar = this.f3718S0;
                J2.a[] aVarArr2 = J2.a.f354h;
                k kVar = this.f3723X0;
                J2.a aVar3 = J2.a.d;
                J2.a aVar4 = J2.a.e;
                boolean z9 = this.f3693C;
                ViewGroup.MarginLayoutParams marginLayoutParams = f3689o1;
                J2.c cVar2 = J2.c.f378g;
                if (dVar == null || dVar.getView() != childAt) {
                    z6 = z8;
                    i7 = childCount;
                    i8 = i15;
                    i9 = measuredWidth2;
                    i10 = measuredHeight2;
                    aVarArr = aVarArr2;
                } else {
                    View view = this.f3718S0.getView();
                    z6 = z8;
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    i7 = childCount;
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : marginLayoutParams;
                    i8 = i15;
                    i9 = measuredWidth2;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams.width);
                    int iMax2 = this.f3702H0;
                    J2.a aVar5 = this.f3704I0;
                    i10 = measuredHeight2;
                    aVarArr = aVarArr2;
                    if (aVar5.f355a < 6) {
                        int i16 = layoutParams.height;
                        if (i16 > 0) {
                            int i17 = i16 + marginLayoutParams2.bottomMargin + marginLayoutParams2.topMargin;
                            if (aVar5.a(aVar4)) {
                                this.f3702H0 = layoutParams.height + marginLayoutParams2.bottomMargin + marginLayoutParams2.topMargin;
                                this.f3704I0 = aVar4;
                            }
                            iMax2 = i17;
                        } else if (i16 == -2 && (this.f3718S0.getSpinnerStyle() != cVar2 || !this.f3704I0.b)) {
                            int iMax3 = Math.max((View.MeasureSpec.getSize(i6) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax3, Integer.MIN_VALUE));
                            int measuredHeight3 = view.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax3 && this.f3704I0.a(aVar3)) {
                                    this.f3702H0 = measuredHeight3 + marginLayoutParams2.bottomMargin + marginLayoutParams2.topMargin;
                                    this.f3704I0 = aVar3;
                                }
                                iMax2 = -1;
                            }
                        }
                    }
                    if (this.f3718S0.getSpinnerStyle() == cVar2) {
                        size = View.MeasureSpec.getSize(i6);
                        i14 = 0;
                    } else {
                        if (!this.f3718S0.getSpinnerStyle().c || z6) {
                            i14 = 0;
                        } else {
                            i14 = 0;
                            iMax2 = Math.max(0, n(z9) ? this.b : 0);
                        }
                        size = iMax2;
                    }
                    if (size != -1) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((size - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i14), 1073741824));
                    }
                    J2.a aVar6 = this.f3704I0;
                    boolean z10 = aVar6.b;
                    if (!z10) {
                        float f7 = this.f3712N0;
                        if (f7 < 10.0f) {
                            f7 *= this.f3702H0;
                        }
                        if (!z10) {
                            aVar6 = aVarArr[aVar6.f355a + 1];
                        }
                        this.f3704I0 = aVar6;
                        this.f3718S0.onInitialized(kVar, this.f3702H0, (int) f7);
                    }
                    if (z6 && n(z9)) {
                        measuredWidth = view.getMeasuredWidth() + i9;
                        measuredHeight = view.getMeasuredHeight() + i10;
                    }
                    cVar = this.f3719T0;
                    if (cVar == null && cVar.getView() == childAt) {
                        View view2 = this.f3719T0.getView();
                        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : marginLayoutParams;
                        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i5, marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams2.width);
                        int i18 = this.f3706J0;
                        i11 = measuredWidth;
                        J2.a aVar7 = this.f3708K0;
                        i12 = measuredHeight;
                        if (aVar7.f355a >= 6) {
                            iMax = i18;
                        } else {
                            int i19 = layoutParams2.height;
                            if (i19 > 0) {
                                iMax = i19 + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                                if (aVar7.a(aVar4)) {
                                    this.f3706J0 = layoutParams2.height + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                                    this.f3708K0 = aVar4;
                                }
                            } else if (i19 != -2 || (this.f3719T0.getSpinnerStyle() == cVar2 && this.f3708K0.b)) {
                                iMax = i18;
                            } else {
                                int iMax4 = Math.max((View.MeasureSpec.getSize(i6) - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin, 0);
                                view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                                int measuredHeight4 = view2.getMeasuredHeight();
                                if (measuredHeight4 > 0) {
                                    if (measuredHeight4 != iMax4 && this.f3708K0.a(aVar3)) {
                                        this.f3706J0 = measuredHeight4 + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
                                        this.f3708K0 = aVar3;
                                    }
                                    iMax = -1;
                                } else {
                                    iMax = i18;
                                }
                            }
                        }
                        if (this.f3719T0.getSpinnerStyle() == cVar2) {
                            iMax = View.MeasureSpec.getSize(i6);
                        } else {
                            if (this.f3719T0.getSpinnerStyle().c && !z6) {
                                i13 = 0;
                                iMax = Math.max(0, n(this.f3695D) ? -this.b : 0);
                            }
                            if (iMax != -1) {
                                view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin, i13), 1073741824));
                            }
                            aVar2 = this.f3708K0;
                            z7 = aVar2.b;
                            if (!z7) {
                                f6 = this.f3713O0;
                                if (f6 < 10.0f) {
                                    f6 *= this.f3706J0;
                                }
                                if (!z7) {
                                    aVar2 = aVarArr[aVar2.f355a + 1];
                                }
                                this.f3708K0 = aVar2;
                                this.f3719T0.onInitialized(kVar, this.f3706J0, (int) f6);
                            }
                            if (!z6 && n(this.f3695D)) {
                                int measuredWidth3 = view2.getMeasuredWidth() + i11;
                                measuredHeight2 = view2.getMeasuredHeight() + i12;
                                measuredWidth2 = measuredWidth3;
                            }
                            aVar = this.f3720U0;
                            if (aVar == null && aVar.getView() == childAt) {
                                View view3 = this.f3720U0.getView();
                                ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                                if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                                }
                                ViewGroup.MarginLayoutParams marginLayoutParams4 = marginLayoutParams;
                                view3.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + marginLayoutParams4.leftMargin + marginLayoutParams4.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + marginLayoutParams4.topMargin + marginLayoutParams4.bottomMargin + ((!z6 || ((this.f3718S0 == null || !n(z9) || !isEnableTranslationContent(this.f3703I, this.f3718S0)) ? i13 : 1) == 0) ? i13 : this.f3702H0) + ((!z6 || ((this.f3719T0 == null || !n(this.f3695D) || !isEnableTranslationContent(this.f3705J, this.f3719T0)) ? i13 : 1) == 0) ? i13 : this.f3706J0), layoutParams3.height));
                                measuredWidth2 += view3.getMeasuredWidth() + marginLayoutParams4.leftMargin + marginLayoutParams4.rightMargin;
                                measuredHeight2 += view3.getMeasuredHeight() + marginLayoutParams4.topMargin + marginLayoutParams4.bottomMargin;
                            }
                        }
                        i13 = 0;
                        if (iMax != -1) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams3.bottomMargin) - marginLayoutParams3.topMargin, i13), 1073741824));
                        }
                        aVar2 = this.f3708K0;
                        z7 = aVar2.b;
                        if (!z7) {
                            f6 = this.f3713O0;
                            if (f6 < 10.0f) {
                                f6 *= this.f3706J0;
                            }
                            if (!z7) {
                                aVar2 = aVarArr[aVar2.f355a + 1];
                            }
                            this.f3708K0 = aVar2;
                            this.f3719T0.onInitialized(kVar, this.f3706J0, (int) f6);
                        }
                        if (!z6) {
                        }
                        aVar = this.f3720U0;
                        if (aVar == null) {
                        }
                    } else {
                        i11 = measuredWidth;
                        i12 = measuredHeight;
                        i13 = 0;
                    }
                    measuredWidth2 = i11;
                    measuredHeight2 = i12;
                    aVar = this.f3720U0;
                    if (aVar == null) {
                    }
                }
                measuredWidth = i9;
                measuredHeight = i10;
                cVar = this.f3719T0;
                if (cVar == null) {
                    i11 = measuredWidth;
                    i12 = measuredHeight;
                    i13 = 0;
                    measuredWidth2 = i11;
                    measuredHeight2 = i12;
                } else {
                    i11 = measuredWidth;
                    i12 = measuredHeight;
                    i13 = 0;
                    measuredWidth2 = i11;
                    measuredHeight2 = i12;
                }
                aVar = this.f3720U0;
                if (aVar == null) {
                }
            }
            i15 = i8 + 1;
            z8 = z6;
            childCount = i7;
        }
        super.setMeasuredDimension(View.resolveSize(Math.max(getPaddingRight() + getPaddingLeft() + measuredWidth2, super.getSuggestedMinimumWidth()), i5), View.resolveSize(Math.max(getPaddingBottom() + getPaddingTop() + measuredHeight2, super.getSuggestedMinimumHeight()), i6));
        this.f3733j = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f6, float f7, boolean z6) {
        return this.f3698F0.dispatchNestedFling(f6, f7, z6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f6, float f7) {
        return (this.g1 && f7 > 0.0f) || t(-f7) || this.f3698F0.dispatchNestedPreFling(f6, f7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i5, int i6, @NonNull int[] iArr) {
        int i7 = this.f3694C0;
        int i8 = 0;
        if (i6 * i7 > 0) {
            if (Math.abs(i6) > Math.abs(this.f3694C0)) {
                int i9 = this.f3694C0;
                this.f3694C0 = 0;
                i8 = i9;
            } else {
                this.f3694C0 -= i6;
                i8 = i6;
            }
            o(this.f3694C0);
        } else if (i6 > 0 && this.g1) {
            int i10 = i7 - i6;
            this.f3694C0 = i10;
            o(i10);
            i8 = i6;
        }
        this.f3698F0.dispatchNestedPreScroll(i5, i6 - i8, iArr, null);
        iArr[1] = iArr[1] + i8;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i5, int i6, int i7, int i8) {
        ViewParent parent;
        boolean zDispatchNestedScroll = this.f3698F0.dispatchNestedScroll(i5, i6, i7, i8, this.f3697E0);
        int i9 = i8 + this.f3697E0[1];
        boolean z6 = this.f3735k0;
        if ((i9 < 0 && (this.f3693C || z6)) || (i9 > 0 && (this.f3695D || z6))) {
            J2.b bVar = this.f3725Z0;
            if (bVar == J2.b.None || bVar.e) {
                this.f3723X0.setState(i9 > 0 ? J2.b.PullUpToLoad : J2.b.PullDownToRefresh);
                if (!zDispatchNestedScroll && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
            int i10 = this.f3694C0 - i9;
            this.f3694C0 = i10;
            o(i10);
        }
        if (!this.g1 || i6 >= 0) {
            return;
        }
        this.g1 = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i5) {
        this.f3700G0.onNestedScrollAccepted(view, view2, i5);
        this.f3698F0.startNestedScroll(i5 & 2);
        this.f3694C0 = this.b;
        this.f3696D0 = true;
        m(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i5) {
        if (isEnabled() && isNestedScrollingEnabled() && (i5 & 2) != 0) {
            return this.f3735k0 || this.f3693C || this.f3695D;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.f3700G0.onStopNestedScroll(view);
        this.f3696D0 = false;
        this.f3694C0 = 0;
        q();
        this.f3698F0.stopNestedScroll();
    }

    public final void p(J2.b bVar) {
        J2.b bVar2 = this.f3724Y0;
        if (bVar2 == bVar) {
            if (this.f3725Z0 != bVar2) {
                this.f3725Z0 = bVar2;
                return;
            }
            return;
        }
        this.f3724Y0 = bVar;
        this.f3725Z0 = bVar;
        d dVar = this.f3718S0;
        I2.c cVar = this.f3719T0;
        if (dVar != null) {
            dVar.onStateChanged(this, bVar2, bVar);
        }
        if (cVar != null) {
            cVar.onStateChanged(this, bVar2, bVar);
        }
        if (bVar == J2.b.LoadFinish) {
            this.g1 = false;
        }
    }

    public final void q() {
        J2.b bVar = this.f3724Y0;
        J2.b bVar2 = J2.b.TwoLevel;
        k kVar = this.f3723X0;
        if (bVar == bVar2) {
            if (this.f3757w > -1000 && this.b > getHeight() / 2) {
                ValueAnimator valueAnimatorA = kVar.a(getHeight());
                if (valueAnimatorA != null) {
                    valueAnimatorA.setDuration(this.e);
                    return;
                }
                return;
            }
            if (this.f3739n) {
                SmartRefreshLayout smartRefreshLayout = kVar.f303a;
                if (smartRefreshLayout.f3724Y0 == bVar2) {
                    smartRefreshLayout.f3723X0.setState(J2.b.TwoLevelFinish);
                    if (smartRefreshLayout.b != 0) {
                        kVar.a(0).setDuration(smartRefreshLayout.e);
                        return;
                    } else {
                        kVar.b(0, false);
                        smartRefreshLayout.p(J2.b.None);
                        return;
                    }
                }
                return;
            }
            return;
        }
        J2.b bVar3 = J2.b.Loading;
        if (bVar == bVar3 || (this.f3707K && this.f3756v0 && this.f3758w0 && this.b < 0 && n(this.f3695D))) {
            int i5 = this.b;
            int i6 = -this.f3706J0;
            if (i5 < i6) {
                kVar.a(i6);
                return;
            } else {
                if (i5 > 0) {
                    kVar.a(0);
                    return;
                }
                return;
            }
        }
        J2.b bVar4 = this.f3724Y0;
        J2.b bVar5 = J2.b.Refreshing;
        if (bVar4 == bVar5) {
            int i7 = this.b;
            int i8 = this.f3702H0;
            if (i7 > i8) {
                kVar.a(i8);
                return;
            } else {
                if (i7 < 0) {
                    kVar.a(0);
                    return;
                }
                return;
            }
        }
        if (bVar4 == J2.b.PullDownToRefresh) {
            kVar.setState(J2.b.PullDownCanceled);
            return;
        }
        if (bVar4 == J2.b.PullUpToLoad) {
            kVar.setState(J2.b.PullUpCanceled);
            return;
        }
        if (bVar4 == J2.b.ReleaseToRefresh) {
            kVar.setState(bVar5);
            return;
        }
        if (bVar4 == J2.b.ReleaseToLoad) {
            kVar.setState(bVar3);
            return;
        }
        if (bVar4 == J2.b.ReleaseToTwoLevel) {
            kVar.setState(J2.b.TwoLevelReleased);
            return;
        }
        if (bVar4 == J2.b.RefreshReleased) {
            if (this.f3736k1 == null) {
                kVar.a(this.f3702H0);
            }
        } else if (bVar4 == J2.b.LoadReleased) {
            if (this.f3736k1 == null) {
                kVar.a(-this.f3706J0);
            }
        } else {
            if (bVar4 == J2.b.LoadFinish || this.b == 0) {
                return;
            }
            kVar.a(0);
        }
    }

    public final void r(boolean z6) {
        J2.b bVar = this.f3724Y0;
        if (bVar == J2.b.Refreshing && z6) {
            l(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f3727a1))), 300) << 16, true, Boolean.TRUE);
            return;
        }
        if (bVar == J2.b.Loading && z6) {
            j(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.f3727a1))), 300) << 16, true);
            return;
        }
        if (this.f3756v0 != z6) {
            this.f3756v0 = z6;
            I2.c cVar = this.f3719T0;
            if (cVar != null) {
                if (!cVar.setNoMoreData(z6)) {
                    this.f3758w0 = false;
                    new RuntimeException("Footer:" + this.f3719T0 + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                    return;
                }
                this.f3758w0 = true;
                if (this.f3756v0 && this.f3707K && this.b > 0 && this.f3719T0.getSpinnerStyle() == J2.c.d && n(this.f3695D) && isEnableTranslationContent(this.f3693C, this.f3718S0)) {
                    this.f3719T0.getView().setTranslationY(this.b);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z6) {
        if (ViewCompat.isNestedScrollingEnabled(this.f3720U0.getScrollableView())) {
            this.f3743p = z6;
            super.requestDisallowInterceptTouchEvent(z6);
        }
    }

    public final void s(L2.f fVar) {
        this.f3691A0 = fVar;
        this.f3692B0 = fVar;
        this.f3695D = this.f3695D || !this.f3760x0;
    }

    @Override // I2.f
    public final f setDragRate(float f6) {
        this.f3737l = f6;
        return this;
    }

    @Override // I2.f
    public final f setFixedFooterViewId(int i5) {
        this.f3747r = i5;
        return this;
    }

    @Override // I2.f
    public final f setFixedHeaderViewId(int i5) {
        this.f3745q = i5;
        return this;
    }

    @Override // I2.f
    public final f setFooterMaxDragRate(float f6) {
        this.f3713O0 = f6;
        I2.c cVar = this.f3719T0;
        if (cVar == null || !this.f1) {
            this.f3708K0 = this.f3708K0.b();
            return this;
        }
        if (f6 < 10.0f) {
            f6 *= this.f3706J0;
        }
        cVar.onInitialized(this.f3723X0, this.f3706J0, (int) f6);
        return this;
    }

    @Override // I2.f
    public final f setFooterTranslationViewId(int i5) {
        this.f3751t = i5;
        return this;
    }

    @Override // I2.f
    public final f setFooterTriggerRate(float f6) {
        this.f3716Q0 = f6;
        return this;
    }

    @Override // I2.f
    public final f setHeaderMaxDragRate(float f6) {
        this.f3712N0 = f6;
        d dVar = this.f3718S0;
        if (dVar == null || !this.f1) {
            this.f3704I0 = this.f3704I0.b();
            return this;
        }
        if (f6 < 10.0f) {
            f6 *= this.f3702H0;
        }
        dVar.onInitialized(this.f3723X0, this.f3702H0, (int) f6);
        return this;
    }

    @Override // I2.f
    public final f setHeaderTranslationViewId(int i5) {
        this.f3749s = i5;
        return this;
    }

    @Override // I2.f
    public final f setHeaderTriggerRate(float f6) {
        this.f3714P0 = f6;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z6) {
        this.f3750s0 = z6;
        this.f3698F0.setNestedScrollingEnabled(z6);
    }

    @Override // I2.f
    public f setPrimaryColors(@ColorInt int... iArr) {
        d dVar = this.f3718S0;
        if (dVar != null) {
            dVar.setPrimaryColors(iArr);
        }
        I2.c cVar = this.f3719T0;
        if (cVar != null) {
            cVar.setPrimaryColors(iArr);
        }
        this.f3690A = iArr;
        return this;
    }

    @Override // I2.f
    public f setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i5 = 0; i5 < iArr.length; i5++) {
            iArr2[i5] = ContextCompat.getColor(getContext(), iArr[i5]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // I2.f
    public f setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.f3763z = interpolator;
        return this;
    }

    @Override // I2.f
    public f setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, 0, 0);
    }

    @Override // I2.f
    public f setRefreshFooter(@NonNull I2.c cVar) {
        return setRefreshFooter(cVar, 0, 0);
    }

    @Override // I2.f
    public f setRefreshHeader(@NonNull d dVar) {
        return setRefreshHeader(dVar, 0, 0);
    }

    public void setStateDirectLoading(boolean z6) {
        J2.b bVar = this.f3724Y0;
        J2.b bVar2 = J2.b.Loading;
        if (bVar != bVar2) {
            this.f3727a1 = System.currentTimeMillis();
            this.g1 = true;
            p(bVar2);
            L2.f fVar = this.f3692B0;
            if (fVar == null) {
                j(2000, false);
            } else if (z6) {
                fVar.onLoadMore(this);
            }
            I2.c cVar = this.f3719T0;
            if (cVar != null) {
                float f6 = this.f3713O0;
                if (f6 < 10.0f) {
                    f6 *= this.f3706J0;
                }
                cVar.onStartAnimator(this, this.f3706J0, (int) f6);
            }
        }
    }

    public void setStateLoading(boolean z6) {
        H2.a aVar = new H2.a(0, this, z6);
        p(J2.b.LoadReleased);
        ValueAnimator valueAnimatorA = this.f3723X0.a(-this.f3706J0);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(aVar);
        }
        I2.c cVar = this.f3719T0;
        if (cVar != null) {
            float f6 = this.f3713O0;
            if (f6 < 10.0f) {
                f6 *= this.f3706J0;
            }
            cVar.onReleased(this, this.f3706J0, (int) f6);
        }
        if (valueAnimatorA == null) {
            aVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z6) {
        H2.a aVar = new H2.a(1, this, z6);
        p(J2.b.RefreshReleased);
        ValueAnimator valueAnimatorA = this.f3723X0.a(this.f3702H0);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(aVar);
        }
        d dVar = this.f3718S0;
        if (dVar != null) {
            float f6 = this.f3712N0;
            if (f6 < 10.0f) {
                f6 *= this.f3702H0;
            }
            dVar.onReleased(this, this.f3702H0, (int) f6);
        }
        if (valueAnimatorA == null) {
            aVar.onAnimationEnd(null);
        }
    }

    public void setViceState(J2.b bVar) {
        J2.b bVar2 = this.f3724Y0;
        if (bVar2.d && bVar2.f374a != bVar.f374a) {
            p(J2.b.None);
        }
        if (this.f3725Z0 != bVar) {
            this.f3725Z0 = bVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x003f  */
    public final boolean t(float f6) {
        J2.b bVar;
        if (f6 == 0.0f) {
            f6 = this.f3757w;
        }
        int i5 = 0;
        if (Math.abs(f6) > this.f3753u) {
            int i6 = this.b;
            if (i6 * f6 < 0.0f) {
                J2.b bVar2 = this.f3724Y0;
                J2.b bVar3 = J2.b.Refreshing;
                if (bVar2 == bVar3 || bVar2 == J2.b.Loading || (i6 < 0 && this.f3756v0)) {
                    i iVar = new i(this, f6);
                    J2.b bVar4 = this.f3724Y0;
                    if (bVar4.f375f) {
                        iVar = null;
                    } else {
                        if (this.b != 0) {
                            boolean z6 = bVar4.e;
                            boolean z7 = this.f3707K;
                            if ((!z6 && (!this.f3756v0 || !z7 || !this.f3758w0 || !n(this.f3695D))) || (((this.f3724Y0 == J2.b.Loading || (this.f3756v0 && z7 && this.f3758w0 && n(this.f3695D))) && this.b < (-this.f3706J0)) || (this.f3724Y0 == bVar3 && this.b > this.f3702H0))) {
                                int i7 = this.b;
                                float fPow = iVar.b;
                                int i8 = i7;
                                while (true) {
                                    if (i7 * i8 > 0) {
                                        i5++;
                                        fPow = (float) (Math.pow(0.98f, (i5 * 10) / 10.0f) * ((double) fPow));
                                        float f7 = ((10 * 1.0f) / 1000.0f) * fPow;
                                        if (Math.abs(f7) < 1.0f) {
                                            J2.b bVar5 = this.f3724Y0;
                                            if (!bVar5.e || ((bVar5 == (bVar = J2.b.Refreshing) && i8 > this.f3702H0) || (bVar5 != bVar && i8 < (-this.f3706J0)))) {
                                                iVar = null;
                                            }
                                        } else {
                                            i8 = (int) (i8 + f7);
                                        }
                                    }
                                }
                            }
                        }
                        iVar.c = AnimationUtils.currentAnimationTimeMillis();
                        this.f3722W0.postDelayed(iVar, 10);
                    }
                    this.j1 = iVar;
                    return true;
                }
                if (bVar2.f376g) {
                    return true;
                }
            }
            boolean z8 = this.f3735k0;
            boolean z9 = this.f3715Q;
            if ((f6 < 0.0f && ((z9 && (this.f3695D || z8)) || ((this.f3724Y0 == J2.b.Loading && i6 >= 0) || (this.f3740n0 && n(this.f3695D))))) || (f6 > 0.0f && ((z9 && this.f3693C) || z8 || (this.f3724Y0 == J2.b.Refreshing && this.b <= 0)))) {
                this.h1 = false;
                Scroller scroller = this.f3759x;
                scroller.fling(0, 0, 0, (int) (-f6), 0, 0, -2147483647, Integer.MAX_VALUE);
                scroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    @Override // I2.f
    public f setRefreshContent(@NonNull View view, int i5, int i6) {
        O2.a aVar = this.f3720U0;
        if (aVar != null) {
            super.removeView(aVar.getView());
        }
        if (i5 == 0) {
            i5 = -1;
        }
        if (i6 == 0) {
            i6 = -1;
        }
        j jVar = new j(i5, i6);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof j) {
            jVar = (j) layoutParams;
        }
        super.addView(view, getChildCount(), jVar);
        this.f3720U0 = new O2.a(view);
        if (this.f1) {
            View viewFindViewById = findViewById(this.f3745q);
            View viewFindViewById2 = findViewById(this.f3747r);
            this.f3720U0.f555i.getClass();
            O2.a aVar2 = this.f3720U0;
            aVar2.f555i.f470a = this.f3748r0;
            aVar2.f(this.f3723X0, viewFindViewById, viewFindViewById2);
        }
        d dVar = this.f3718S0;
        if (dVar != null && dVar.getSpinnerStyle().b) {
            super.bringChildToFront(this.f3718S0.getView());
        }
        I2.c cVar = this.f3719T0;
        if (cVar != null && cVar.getSpinnerStyle().b) {
            super.bringChildToFront(this.f3719T0.getView());
        }
        return this;
    }

    @Override // I2.f
    public f setRefreshFooter(@NonNull I2.c cVar, int i5, int i6) {
        I2.c cVar2;
        I2.c cVar3 = this.f3719T0;
        if (cVar3 != null) {
            super.removeView(cVar3.getView());
        }
        this.f3719T0 = cVar;
        this.g1 = false;
        this.f3728c1 = 0;
        this.f3758w0 = false;
        this.e1 = false;
        this.f3708K0 = J2.a.c;
        this.f3695D = !this.f3760x0 || this.f3695D;
        if (i5 == 0) {
            i5 = -1;
        }
        if (i6 == 0) {
            i6 = -2;
        }
        j jVar = new j(i5, i6);
        ViewGroup.LayoutParams layoutParams = cVar.getView().getLayoutParams();
        if (layoutParams instanceof j) {
            jVar = (j) layoutParams;
        }
        if (this.f3719T0.getSpinnerStyle().b) {
            super.addView(this.f3719T0.getView(), getChildCount(), jVar);
        } else {
            super.addView(this.f3719T0.getView(), 0, jVar);
        }
        int[] iArr = this.f3690A;
        if (iArr != null && (cVar2 = this.f3719T0) != null) {
            cVar2.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // I2.f
    public f setRefreshHeader(@NonNull d dVar, int i5, int i6) {
        d dVar2;
        d dVar3 = this.f3718S0;
        if (dVar3 != null) {
            super.removeView(dVar3.getView());
        }
        this.f3718S0 = dVar;
        this.b1 = 0;
        this.d1 = false;
        this.f3704I0 = J2.a.c;
        if (i5 == 0) {
            i5 = -1;
        }
        if (i6 == 0) {
            i6 = -2;
        }
        j jVar = new j(i5, i6);
        ViewGroup.LayoutParams layoutParams = dVar.getView().getLayoutParams();
        if (layoutParams instanceof j) {
            jVar = (j) layoutParams;
        }
        if (this.f3718S0.getSpinnerStyle().b) {
            super.addView(this.f3718S0.getView(), getChildCount(), jVar);
        } else {
            super.addView(this.f3718S0.getView(), 0, jVar);
        }
        int[] iArr = this.f3690A;
        if (iArr != null && (dVar2 = this.f3718S0) != null) {
            dVar2.setPrimaryColors(iArr);
        }
        return this;
    }

    @Override // I2.f
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }
}
