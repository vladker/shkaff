package com.github.barteksc.pdfviewer;

import D1.d;
import D1.f;
import D1.g;
import D1.h;
import D1.i;
import D1.j;
import D1.k;
import D1.l;
import D1.m;
import D1.p;
import D1.q;
import K1.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PDFView extends RelativeLayout {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public boolean f3257A;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public final PdfiumCore f3258C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public boolean f3259D;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final PaintFlagsDrawFilter f3260G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public int f3261H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public boolean f3262I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f3263J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final ArrayList f3264K;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f3265M;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public a f3266Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f3267a;
    public float b;
    public float c;
    public final f d;
    public final d e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f3268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public m f3269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f3274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public c f3275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f3276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HandlerThread f3277o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public q f3278p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l f3279q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p075n1.a f3280r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f3281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public K1.b f3282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3284v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3286x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3287y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3288z;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final J1.b f3289a;
        public final boolean b;
        public final boolean c;
        public final S4.h d;
        public final boolean e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final K1.b f3290f;

        public /* synthetic */ a(PDFView pDFView, J1.b bVar, int i5) {
            this(bVar);
        }

        public final void a() {
            PDFView pDFView = PDFView.this;
            if (!pDFView.f3265M) {
                pDFView.f3266Q = this;
                return;
            }
            pDFView.q();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.getClass();
            pDFView.f3280r.b = this.d;
            pDFView.setSwipeEnabled(this.b);
            pDFView.setNightMode(false);
            pDFView.f3287y = this.c;
            pDFView.setDefaultPage(0);
            pDFView.setSwipeVertical(true);
            pDFView.setScrollHandle(null);
            pDFView.f3259D = this.e;
            pDFView.setSpacing(0);
            pDFView.setAutoSpacing(false);
            pDFView.setPageFitPolicy(this.f3290f);
            pDFView.setFitEachPage(false);
            pDFView.setPageSnap(false);
            pDFView.setPageFling(false);
            if (!pDFView.f3274l) {
                throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
            }
            pDFView.f3274l = false;
            PdfiumCore pdfiumCore = pDFView.f3258C;
            g gVar = new g();
            gVar.d = this.f3289a;
            gVar.f168a = false;
            gVar.b = new WeakReference(pDFView);
            gVar.c = pdfiumCore;
            pDFView.f3276n = gVar;
            gVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }

        private a(J1.b bVar) {
            this.b = true;
            this.c = true;
            S4.h hVar = new S4.h(2, false);
            hVar.b = PDFView.this;
            this.d = hVar;
            this.e = true;
            this.f3290f = K1.b.WIDTH;
            this.f3289a = bVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum b {
        /* JADX INFO: Fake field, exist only in values array */
        NONE,
        /* JADX INFO: Fake field, exist only in values array */
        START,
        /* JADX INFO: Fake field, exist only in values array */
        END
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum c {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3267a = 1.0f;
        this.b = 1.75f;
        this.c = 3.0f;
        b[] bVarArr = b.f3292a;
        this.f3271i = 0.0f;
        this.f3272j = 0.0f;
        this.f3273k = 1.0f;
        this.f3274l = true;
        this.f3275m = c.DEFAULT;
        this.f3280r = new p075n1.a(2, false);
        this.f3282t = K1.b.WIDTH;
        this.f3283u = false;
        this.f3284v = 0;
        this.f3285w = true;
        this.f3286x = true;
        this.f3287y = true;
        this.f3288z = false;
        this.f3257A = true;
        this.f3259D = true;
        this.f3260G = new PaintFlagsDrawFilter(0, 3);
        this.f3261H = 0;
        this.f3262I = false;
        this.f3263J = true;
        this.f3264K = new ArrayList(10);
        this.f3265M = false;
        if (isInEditMode()) {
            return;
        }
        this.d = new f();
        d dVar = new d();
        dVar.d = false;
        dVar.e = false;
        dVar.f166a = this;
        dVar.c = new OverScroller(getContext());
        this.e = dVar;
        h hVar = new h();
        hVar.e = false;
        hVar.f170f = false;
        hVar.f171g = false;
        hVar.f169a = this;
        hVar.b = dVar;
        hVar.c = new GestureDetector(getContext(), hVar);
        hVar.d = new ScaleGestureDetector(getContext(), hVar);
        setOnTouchListener(hVar);
        this.f3268f = hVar;
        this.f3279q = new l(this);
        this.f3281s = new Paint();
        new Paint().setStyle(Paint.Style.STROKE);
        PdfiumCore pdfiumCore = new PdfiumCore();
        pdfiumCore.f3765a = context.getResources().getDisplayMetrics().densityDpi;
        Log.d("com.shockwave.pdfium.PdfiumCore", "Starting PdfiumAndroid 1.9.5-beta01");
        this.f3258C = pdfiumCore;
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSpacing(boolean z6) {
        this.f3262I = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i5) {
        this.f3284v = i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitEachPage(boolean z6) {
        this.f3283u = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(K1.b bVar) {
        this.f3282t = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i5) {
        this.f3261H = (int) TypedValue.applyDimension(1, i5, getContext().getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z6) {
        this.f3285w = z6;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i5) {
        m mVar = this.f3269g;
        if (mVar == null) {
            return true;
        }
        if (this.f3285w) {
            if (i5 < 0 && this.f3271i < 0.0f) {
                return true;
            }
            if (i5 > 0) {
                return (mVar.b().f575a * this.f3273k) + this.f3271i > ((float) getWidth());
            }
            return false;
        }
        if (i5 < 0 && this.f3271i < 0.0f) {
            return true;
        }
        if (i5 <= 0) {
            return false;
        }
        return (mVar.f193p * this.f3273k) + this.f3271i > ((float) getWidth());
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i5) {
        m mVar = this.f3269g;
        if (mVar == null) {
            return true;
        }
        if (!this.f3285w) {
            if (i5 < 0 && this.f3272j < 0.0f) {
                return true;
            }
            if (i5 > 0) {
                return (mVar.b().b * this.f3273k) + this.f3272j > ((float) getHeight());
            }
            return false;
        }
        if (i5 < 0 && this.f3272j < 0.0f) {
            return true;
        }
        if (i5 <= 0) {
            return false;
        }
        return (mVar.f193p * this.f3273k) + this.f3272j > ((float) getHeight());
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        d dVar = this.e;
        PDFView pDFView = dVar.f166a;
        OverScroller overScroller = dVar.c;
        if (overScroller.computeScrollOffset()) {
            pDFView.o(overScroller.getCurrX(), overScroller.getCurrY());
            pDFView.m();
        } else if (dVar.d) {
            dVar.d = false;
            pDFView.n();
            dVar.a();
            pDFView.p();
        }
    }

    public int getCurrentPage() {
        return this.f3270h;
    }

    public float getCurrentXOffset() {
        return this.f3271i;
    }

    public float getCurrentYOffset() {
        return this.f3272j;
    }

    public P2.c getDocumentMeta() {
        P2.d dVar;
        m mVar = this.f3269g;
        if (mVar == null || (dVar = mVar.f182a) == null) {
            return null;
        }
        return mVar.b.b(dVar);
    }

    public float getMaxZoom() {
        return this.c;
    }

    public float getMidZoom() {
        return this.b;
    }

    public float getMinZoom() {
        return this.f3267a;
    }

    public int getPageCount() {
        m mVar = this.f3269g;
        if (mVar == null) {
            return 0;
        }
        return mVar.c;
    }

    public K1.b getPageFitPolicy() {
        return this.f3282t;
    }

    public float getPositionOffset() {
        float f6;
        float f7;
        int width;
        if (this.f3285w) {
            f6 = -this.f3272j;
            f7 = this.f3269g.f193p * this.f3273k;
            width = getHeight();
        } else {
            f6 = -this.f3271i;
            f7 = this.f3269g.f193p * this.f3273k;
            width = getWidth();
        }
        float f8 = f6 / (f7 - width);
        if (f8 <= 0.0f) {
            return 0.0f;
        }
        if (f8 >= 1.0f) {
            return 1.0f;
        }
        return f8;
    }

    public I1.a getScrollHandle() {
        return null;
    }

    public int getSpacingPx() {
        return this.f3261H;
    }

    public List<P2.a> getTableOfContents() {
        m mVar = this.f3269g;
        if (mVar == null) {
            return Collections.EMPTY_LIST;
        }
        P2.d dVar = mVar.f182a;
        return dVar == null ? new ArrayList() : mVar.b.f(dVar);
    }

    public float getZoom() {
        return this.f3273k;
    }

    public final void h(Canvas canvas, H1.a aVar) {
        float fE;
        float fE2;
        RectF rectF = aVar.c;
        int i5 = aVar.f291a;
        Bitmap bitmap = aVar.b;
        if (bitmap.isRecycled()) {
            return;
        }
        Q2.a aVarF = this.f3269g.f(i5);
        if (this.f3285w) {
            fE2 = this.f3269g.e(i5, this.f3273k);
            fE = ((this.f3269g.b().f575a - aVarF.f575a) * this.f3273k) / 2.0f;
        } else {
            fE = this.f3269g.e(i5, this.f3273k);
            fE2 = ((this.f3269g.b().b - aVarF.b) * this.f3273k) / 2.0f;
        }
        canvas.translate(fE, fE2);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        float f6 = rectF.left;
        float f7 = aVarF.f575a;
        float f8 = aVarF.b;
        float f9 = f6 * f7;
        float f10 = this.f3273k;
        float f11 = f9 * f10;
        float f12 = rectF.top * f8 * f10;
        RectF rectF2 = new RectF((int) f11, (int) f12, (int) (f11 + (rectF.width() * aVarF.f575a * this.f3273k)), (int) (f12 + (rectF.height() * f8 * this.f3273k)));
        float f13 = this.f3271i + fE;
        float f14 = this.f3272j + fE2;
        if (rectF2.left + f13 >= getWidth() || f13 + rectF2.right <= 0.0f || rectF2.top + f14 >= getHeight() || f14 + rectF2.bottom <= 0.0f) {
            canvas.translate(-fE, -fE2);
        } else {
            canvas.drawBitmap(bitmap, rect, rectF2, this.f3281s);
            canvas.translate(-fE, -fE2);
        }
    }

    public final int i(float f6, float f7) {
        boolean z6 = this.f3285w;
        if (z6) {
            f6 = f7;
        }
        float height = z6 ? getHeight() : getWidth();
        if (f6 > -1.0f) {
            return 0;
        }
        m mVar = this.f3269g;
        float f8 = this.f3273k;
        return f6 < ((-(mVar.f193p * f8)) + height) + 1.0f ? mVar.c - 1 : mVar.c(-(f6 - (height / 2.0f)), f8);
    }

    public final e j(int i5) {
        if (!this.f3257A || i5 < 0) {
            return e.NONE;
        }
        float f6 = this.f3285w ? this.f3272j : this.f3271i;
        float f7 = -this.f3269g.e(i5, this.f3273k);
        int height = this.f3285w ? getHeight() : getWidth();
        float fD = this.f3269g.d(i5, this.f3273k);
        float f8 = height;
        if (f8 >= fD) {
            return e.CENTER;
        }
        if (f6 >= f7) {
            return e.START;
        }
        return f7 - fD > f6 - f8 ? e.END : e.NONE;
    }

    public final a k(String str) {
        return new a(this, new J1.a(str), 0);
    }

    public final void l(int i5) {
        m mVar = this.f3269g;
        if (mVar == null) {
            return;
        }
        int i6 = 0;
        if (i5 <= 0) {
            i5 = 0;
        } else {
            int i7 = mVar.c;
            if (i5 >= i7) {
                i5 = i7 - 1;
            }
        }
        float f6 = i5 == 0 ? 0.0f : -mVar.e(i5, this.f3273k);
        if (this.f3285w) {
            o(this.f3271i, f6);
        } else {
            o(f6, this.f3272j);
        }
        if (this.f3274l) {
            return;
        }
        m mVar2 = this.f3269g;
        if (i5 <= 0) {
            mVar2.getClass();
        } else {
            int i8 = mVar2.c;
            i6 = i5 >= i8 ? i8 - 1 : i5;
        }
        this.f3270h = i6;
        n();
        p075n1.a aVar = this.f3280r;
        int i9 = this.f3269g.c;
        aVar.getClass();
    }

    public final void m() {
        float f6;
        int width;
        if (this.f3269g.c == 0) {
            return;
        }
        if (this.f3285w) {
            f6 = this.f3272j;
            width = getHeight();
        } else {
            f6 = this.f3271i;
            width = getWidth();
        }
        int iC = this.f3269g.c(-(f6 - (width / 2.0f)), this.f3273k);
        if (iC < 0 || iC > this.f3269g.c - 1 || iC == getCurrentPage()) {
            n();
            return;
        }
        if (this.f3274l) {
            return;
        }
        m mVar = this.f3269g;
        if (iC <= 0) {
            mVar.getClass();
            iC = 0;
        } else {
            int i5 = mVar.c;
            if (iC >= i5) {
                iC = i5 - 1;
            }
        }
        this.f3270h = iC;
        n();
        p075n1.a aVar = this.f3280r;
        int i6 = this.f3269g.c;
        aVar.getClass();
    }

    public final void n() {
        q qVar;
        Iterator it;
        int i5;
        int i6;
        float f6;
        float f7;
        float fE;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        if (this.f3269g == null || (qVar = this.f3278p) == null) {
            return;
        }
        int i7 = 1;
        qVar.removeMessages(1);
        f fVar = this.d;
        synchronized (fVar.d) {
            fVar.f167a.addAll(fVar.b);
            fVar.b.clear();
        }
        l lVar = this.f3279q;
        lVar.b = 1;
        float currentXOffset = lVar.f175a.getCurrentXOffset();
        float f14 = 0.0f;
        if (currentXOffset > 0.0f) {
            currentXOffset = 0.0f;
        }
        lVar.c = -currentXOffset;
        float currentYOffset = lVar.f175a.getCurrentYOffset();
        if (currentYOffset > 0.0f) {
            currentYOffset = 0.0f;
        }
        lVar.d = -currentYOffset;
        float f15 = lVar.f180j;
        float f16 = -lVar.c;
        float f17 = f16 + f15;
        float width = (f16 - lVar.f175a.getWidth()) - f15;
        float f18 = -lVar.d;
        float f19 = f18 + f15;
        float height = (f18 - lVar.f175a.getHeight()) - f15;
        PDFView pDFView = lVar.f175a;
        if (f17 > 0.0f) {
            f17 = 0.0f;
        }
        float f20 = -f17;
        if (f19 > 0.0f) {
            f19 = 0.0f;
        }
        float f21 = -f19;
        if (width > 0.0f) {
            width = 0.0f;
        }
        float f22 = -width;
        if (height > 0.0f) {
            height = 0.0f;
        }
        float f23 = -height;
        boolean z6 = pDFView.f3285w;
        float f24 = z6 ? f21 : f20;
        float f25 = z6 ? f23 : f22;
        int iC = pDFView.f3269g.c(f24, pDFView.getZoom());
        int iC2 = pDFView.f3269g.c(f25, pDFView.getZoom());
        int i8 = (iC2 - iC) + 1;
        LinkedList linkedList = new LinkedList();
        int i9 = iC;
        while (i9 <= iC2) {
            float f26 = f14;
            k kVar = new k(lVar);
            kVar.f174a = i9;
            if (i9 != iC) {
                f6 = 256.0f;
                f7 = 1.0f;
                if (i9 == iC2) {
                    fE = pDFView.f3269g.e(i9, pDFView.getZoom());
                    if (pDFView.f3285w) {
                        f11 = fE;
                        fE = f20;
                    } else {
                        f11 = f21;
                    }
                    f9 = f22;
                    f8 = f11;
                } else {
                    fE = pDFView.f3269g.e(i9, pDFView.getZoom());
                    Q2.a aVarG = pDFView.f3269g.g(i9, pDFView.getZoom());
                    if (pDFView.f3285w) {
                        f10 = aVarG.b + fE;
                        f8 = fE;
                        f9 = f22;
                        fE = f20;
                    } else {
                        f8 = f21;
                        f9 = aVarG.f575a + fE;
                    }
                }
                f10 = f23;
            } else if (i8 == i7) {
                f9 = f22;
                fE = f20;
                f10 = f23;
                f8 = f21;
                f6 = 256.0f;
                f7 = 1.0f;
            } else {
                f6 = 256.0f;
                f7 = 1.0f;
                float fE2 = pDFView.f3269g.e(i9, pDFView.getZoom());
                Q2.a aVarG2 = pDFView.f3269g.g(i9, pDFView.getZoom());
                if (pDFView.f3285w) {
                    f13 = fE2 + aVarG2.b;
                    f12 = f22;
                } else {
                    f12 = fE2 + aVarG2.f575a;
                    f13 = f23;
                }
                f8 = f21;
                f9 = f12;
                f10 = f13;
                fE = f20;
            }
            i iVar = kVar.b;
            float f27 = fE;
            float f28 = f22;
            Q2.a aVarF = pDFView.f3269g.f(kVar.f174a);
            float f29 = f7 / aVarF.f575a;
            float zoom = ((f7 / aVarF.b) * f6) / pDFView.getZoom();
            float zoom2 = (f29 * f6) / pDFView.getZoom();
            float f30 = f20;
            iVar.f172a = ((int) (((double) (f7 / zoom)) + 16384.999999999996d)) - 16384;
            iVar.b = ((int) (((double) (f7 / zoom2)) + 16384.999999999996d)) - 16384;
            Q2.a aVarG3 = pDFView.f3269g.g(kVar.f174a, pDFView.getZoom());
            float f31 = aVarG3.b;
            i iVar2 = kVar.b;
            float f32 = f31 / iVar2.f172a;
            float f33 = aVarG3.f575a / iVar2.b;
            float fH = pDFView.f3269g.h(i9, pDFView.getZoom());
            if (pDFView.f3285w) {
                kVar.c.f173a = p002a.c.b(Math.abs(f8 - pDFView.f3269g.e(kVar.f174a, pDFView.getZoom())) / f32);
                j jVar = kVar.c;
                float f34 = f27 - fH;
                if (f34 < f26) {
                    f34 = f26;
                }
                jVar.b = p002a.c.b(f34 / f33);
                kVar.d.f173a = ((int) (((double) (Math.abs(f10 - pDFView.f3269g.e(kVar.f174a, pDFView.getZoom())) / f32)) + 16384.999999999996d)) - 16384;
                j jVar2 = kVar.d;
                float f35 = f9 - fH;
                if (f35 < f26) {
                    f35 = f26;
                }
                jVar2.b = p002a.c.b(f35 / f33);
            } else {
                kVar.c.b = p002a.c.b(Math.abs(f27 - pDFView.f3269g.e(kVar.f174a, pDFView.getZoom())) / f33);
                j jVar3 = kVar.c;
                float f36 = f8 - fH;
                if (f36 < f26) {
                    f36 = f26;
                }
                jVar3.f173a = p002a.c.b(f36 / f32);
                kVar.d.b = p002a.c.b(Math.abs(f9 - pDFView.f3269g.e(kVar.f174a, pDFView.getZoom())) / f33);
                j jVar4 = kVar.d;
                float f37 = f10 - fH;
                if (f37 < f26) {
                    f37 = f26;
                }
                jVar4.f173a = p002a.c.b(f37 / f32);
            }
            linkedList.add(kVar);
            i9++;
            i7 = 1;
            f14 = f26;
            f22 = f28;
            f20 = f30;
        }
        float f38 = f14;
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            int i10 = ((k) it2.next()).f174a;
            Q2.a aVarF2 = lVar.f175a.f3269g.f(i10);
            float f39 = aVarF2.f575a * 0.3f;
            float f40 = aVarF2.b * 0.3f;
            f fVar2 = lVar.f175a.d;
            RectF rectF = lVar.f179i;
            fVar2.getClass();
            H1.a aVar = new H1.a(i10, null, rectF, true, 0);
            synchronized (fVar2.c) {
                try {
                    ArrayList arrayList = fVar2.c;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            q qVar2 = lVar.f175a.f3278p;
                            RectF rectF2 = lVar.f179i;
                            qVar2.getClass();
                            qVar2.sendMessage(qVar2.obtainMessage(1, new p(qVar2, f39, f40, rectF2, i10, true, 0, false, false)));
                            break;
                        }
                        Object obj = arrayList.get(i11);
                        i11++;
                        if (((H1.a) obj).equals(aVar)) {
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        Iterator it3 = linkedList.iterator();
        int i12 = 0;
        while (it3.hasNext()) {
            k kVar2 = (k) it3.next();
            i iVar3 = kVar2.b;
            float f41 = 1.0f / iVar3.b;
            lVar.e = f41;
            float f42 = 1.0f / iVar3.f172a;
            lVar.f176f = f42;
            lVar.f177g = 256.0f / f41;
            lVar.f178h = 256.0f / f42;
            int i13 = kVar2.f174a;
            j jVar5 = kVar2.c;
            int i14 = jVar5.f173a;
            j jVar6 = kVar2.d;
            int i15 = jVar6.f173a;
            int i16 = jVar5.b;
            int i17 = jVar6.b;
            int i18 = 120 - i12;
            int i19 = 0;
            while (true) {
                if (i14 > i15) {
                    it = it3;
                    break;
                }
                int i20 = i16;
                while (i20 <= i17) {
                    float f43 = lVar.e;
                    float f44 = lVar.f176f;
                    PDFView pDFView2 = lVar.f175a;
                    float f45 = i20 * f43;
                    float f46 = i14 * f44;
                    it = it3;
                    float f47 = lVar.f177g;
                    float f48 = lVar.f178h;
                    if (f45 + f43 > 1.0f) {
                        f43 = 1.0f - f45;
                    }
                    if (f46 + f44 > 1.0f) {
                        f44 = 1.0f - f46;
                    }
                    float f49 = f47 * f43;
                    float f50 = f48 * f44;
                    RectF rectF3 = new RectF(f45, f46, f43 + f45, f44 + f46);
                    if (f49 <= f38 || f50 <= f38) {
                        i5 = i13;
                    } else {
                        if (pDFView2.d.b(rectF3, i13, lVar.b)) {
                            i5 = i13;
                            i6 = 1;
                        } else {
                            q qVar3 = pDFView2.f3278p;
                            int i21 = lVar.b;
                            qVar3.getClass();
                            i5 = i13;
                            i6 = 1;
                            qVar3.sendMessage(qVar3.obtainMessage(1, new p(qVar3, f49, f50, rectF3, i5, false, i21, false, false)));
                        }
                        lVar.b += i6;
                        i19++;
                    }
                    if (i19 >= i18) {
                        break;
                    }
                    i20++;
                    i13 = i5;
                    it3 = it;
                }
                i14++;
                i13 = i13;
            }
            i12 += i19;
            if (i12 >= 120) {
                break;
            } else {
                it3 = it;
            }
        }
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004c  */
    /* JADX WARN: Code duplicated, block: B:17:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0058  */
    /* JADX WARN: Code duplicated, block: B:20:0x005a  */
    /* JADX WARN: Code duplicated, block: B:22:0x0065  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e0  */
    public final void o(float f6, float f7) {
        float height;
        float f8;
        float f9;
        float width;
        float f10;
        float f11;
        if (this.f3285w) {
            float f12 = this.f3269g.b().f575a * this.f3273k;
            if (f12 < getWidth()) {
                width = getWidth() / 2;
                f12 /= 2.0f;
            } else {
                if (f6 > 0.0f) {
                    f6 = 0.0f;
                } else if (f6 + f12 < getWidth()) {
                    width = getWidth();
                }
                f10 = this.f3269g.f193p * this.f3273k;
                if (f10 < getHeight()) {
                    f7 = (getHeight() - f10) / 2.0f;
                } else if (f7 > 0.0f) {
                    f7 = 0.0f;
                } else if (f7 + f10 < getHeight()) {
                    f7 = (-f10) + getHeight();
                }
                f11 = this.f3272j;
                if (f7 < f11 && f7 > f11) {
                    b[] bVarArr = b.f3292a;
                } else {
                    b[] bVarArr2 = b.f3292a;
                }
            }
            f6 = width - f12;
            f10 = this.f3269g.f193p * this.f3273k;
            if (f10 < getHeight()) {
                f7 = (getHeight() - f10) / 2.0f;
            } else if (f7 > 0.0f) {
                f7 = 0.0f;
            } else if (f7 + f10 < getHeight()) {
                f7 = (-f10) + getHeight();
            }
            f11 = this.f3272j;
            if (f7 < f11) {
                b[] bVarArr3 = b.f3292a;
            } else {
                b[] bVarArr4 = b.f3292a;
            }
        } else {
            float f13 = this.f3269g.b().b * this.f3273k;
            if (f13 < getHeight()) {
                height = getHeight() / 2;
                f13 /= 2.0f;
            } else {
                if (f7 > 0.0f) {
                    f7 = 0.0f;
                } else if (f7 + f13 < getHeight()) {
                    height = getHeight();
                }
                f8 = this.f3269g.f193p * this.f3273k;
                if (f8 < getWidth()) {
                    f6 = (getWidth() - f8) / 2.0f;
                } else if (f6 > 0.0f) {
                    f6 = 0.0f;
                } else if (f6 + f8 < getWidth()) {
                    f6 = (-f8) + getWidth();
                }
                f9 = this.f3271i;
                if (f6 < f9 && f6 > f9) {
                    b[] bVarArr5 = b.f3292a;
                } else {
                    b[] bVarArr6 = b.f3292a;
                }
            }
            f7 = height - f13;
            f8 = this.f3269g.f193p * this.f3273k;
            if (f8 < getWidth()) {
                f6 = (getWidth() - f8) / 2.0f;
            } else if (f6 > 0.0f) {
                f6 = 0.0f;
            } else if (f6 + f8 < getWidth()) {
                f6 = (-f8) + getWidth();
            }
            f9 = this.f3271i;
            if (f6 < f9) {
                b[] bVarArr7 = b.f3292a;
            } else {
                b[] bVarArr8 = b.f3292a;
            }
        }
        this.f3271i = f6;
        this.f3272j = f7;
        getPositionOffset();
        p075n1.a aVar = this.f3280r;
        getCurrentPage();
        aVar.getClass();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3277o == null) {
            this.f3277o = new HandlerThread("PDF renderer");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        q();
        HandlerThread handlerThread = this.f3277o;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f3277o = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (isInEditMode()) {
            return;
        }
        if (this.f3259D) {
            canvas.setDrawFilter(this.f3260G);
        }
        Drawable background = getBackground();
        if (background == null) {
            canvas.drawColor(this.f3288z ? ViewCompat.MEASURED_STATE_MASK : -1);
        } else {
            background.draw(canvas);
        }
        if (!this.f3274l && this.f3275m == c.SHOWN) {
            float f6 = this.f3271i;
            float f7 = this.f3272j;
            canvas.translate(f6, f7);
            f fVar = this.d;
            synchronized (fVar.c) {
                arrayList = fVar.c;
            }
            int size = arrayList.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                h(canvas, (H1.a) obj);
            }
            f fVar2 = this.d;
            synchronized (fVar2.d) {
                arrayList2 = new ArrayList(fVar2.f167a);
                arrayList2.addAll(fVar2.b);
            }
            int size2 = arrayList2.size();
            int i7 = 0;
            while (i7 < size2) {
                Object obj2 = arrayList2.get(i7);
                i7++;
                h(canvas, (H1.a) obj2);
                this.f3280r.getClass();
            }
            ArrayList arrayList3 = this.f3264K;
            int size3 = arrayList3.size();
            while (i5 < size3) {
                Object obj3 = arrayList3.get(i5);
                i5++;
                ((Integer) obj3).getClass();
                this.f3280r.getClass();
            }
            this.f3264K.clear();
            this.f3280r.getClass();
            canvas.translate(-f6, -f7);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i5, int i6, int i7, int i8) {
        float f6;
        float f7;
        this.f3265M = true;
        a aVar = this.f3266Q;
        if (aVar != null) {
            aVar.a();
        }
        if (isInEditMode() || this.f3275m != c.SHOWN) {
            return;
        }
        float f8 = (i7 * 0.5f) + (-this.f3271i);
        float f9 = (i8 * 0.5f) + (-this.f3272j);
        if (this.f3285w) {
            f6 = f8 / this.f3269g.b().f575a;
            f7 = this.f3269g.f193p * this.f3273k;
        } else {
            m mVar = this.f3269g;
            f6 = f8 / (mVar.f193p * this.f3273k);
            f7 = mVar.b().b;
        }
        float f10 = f9 / f7;
        this.e.e();
        this.f3269g.i(new Size(i5, i6));
        if (this.f3285w) {
            this.f3271i = (i5 * 0.5f) + ((-f6) * this.f3269g.b().f575a);
            this.f3272j = (i6 * 0.5f) + (this.f3269g.f193p * this.f3273k * (-f10));
        } else {
            m mVar2 = this.f3269g;
            this.f3271i = (i5 * 0.5f) + (mVar2.f193p * this.f3273k * (-f6));
            this.f3272j = (i6 * 0.5f) + ((-f10) * mVar2.b().b);
        }
        o(this.f3271i, this.f3272j);
        m();
    }

    public final void p() {
        m mVar;
        int i5;
        e eVarJ;
        if (!this.f3257A || (mVar = this.f3269g) == null || mVar.c == 0 || (eVarJ = j((i5 = i(this.f3271i, this.f3272j)))) == e.NONE) {
            return;
        }
        float fR = r(i5, eVarJ);
        boolean z6 = this.f3285w;
        d dVar = this.e;
        if (z6) {
            dVar.c(this.f3272j, -fR);
        } else {
            dVar.b(this.f3271i, -fR);
        }
    }

    public final void q() {
        P2.d dVar;
        this.f3266Q = null;
        this.e.e();
        int i5 = 0;
        this.f3268f.f171g = false;
        q qVar = this.f3278p;
        if (qVar != null) {
            qVar.e = false;
            qVar.removeMessages(1);
        }
        g gVar = this.f3276n;
        if (gVar != null) {
            gVar.cancel(true);
        }
        f fVar = this.d;
        synchronized (fVar.d) {
            try {
                Iterator it = fVar.f167a.iterator();
                while (it.hasNext()) {
                    ((H1.a) it.next()).b.recycle();
                }
                fVar.f167a.clear();
                Iterator it2 = fVar.b.iterator();
                while (it2.hasNext()) {
                    ((H1.a) it2.next()).b.recycle();
                }
                fVar.b.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (fVar.c) {
            try {
                ArrayList arrayList = fVar.c;
                int size = arrayList.size();
                while (i5 < size) {
                    Object obj = arrayList.get(i5);
                    i5++;
                    ((H1.a) obj).b.recycle();
                }
                fVar.c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m mVar = this.f3269g;
        if (mVar != null) {
            PdfiumCore pdfiumCore = mVar.b;
            if (pdfiumCore != null && (dVar = mVar.f182a) != null) {
                pdfiumCore.a(dVar);
            }
            mVar.f182a = null;
            this.f3269g = null;
        }
        this.f3278p = null;
        this.f3272j = 0.0f;
        this.f3271i = 0.0f;
        this.f3273k = 1.0f;
        this.f3274l = true;
        this.f3280r = new p075n1.a(2, false);
        this.f3275m = c.DEFAULT;
    }

    public final float r(int i5, e eVar) {
        float fE = this.f3269g.e(i5, this.f3273k);
        float height = this.f3285w ? getHeight() : getWidth();
        float fD = this.f3269g.d(i5, this.f3273k);
        if (eVar == e.CENTER) {
            return (fD / 2.0f) + (fE - (height / 2.0f));
        }
        return eVar == e.END ? (fE - height) + fD : fE;
    }

    public final void s(PointF pointF, float f6) {
        float f7 = f6 / this.f3273k;
        this.f3273k = f6;
        float f8 = this.f3271i * f7;
        float f9 = this.f3272j * f7;
        float f10 = pointF.x;
        float f11 = pointF.y;
        o((f10 - (f10 * f7)) + f8, (f11 - (f7 * f11)) + f9);
    }

    public void setMaxZoom(float f6) {
        this.c = f6;
    }

    public void setMidZoom(float f6) {
        this.b = f6;
    }

    public void setMinZoom(float f6) {
        this.f3267a = f6;
    }

    public void setNightMode(boolean z6) {
        this.f3288z = z6;
        Paint paint = this.f3281s;
        if (z6) {
            paint.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
        } else {
            paint.setColorFilter(null);
        }
    }

    public void setPageFling(boolean z6) {
        this.f3263J = z6;
    }

    public void setPageSnap(boolean z6) {
        this.f3257A = z6;
    }

    public void setPositionOffset(float f6) {
        if (this.f3285w) {
            o(this.f3271i, ((-(this.f3269g.f193p * this.f3273k)) + getHeight()) * f6);
        } else {
            o(((-(this.f3269g.f193p * this.f3273k)) + getWidth()) * f6, this.f3272j);
        }
        m();
    }

    public void setSwipeEnabled(boolean z6) {
        this.f3286x = z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(I1.a aVar) {
    }
}
