package D1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.PDFView;
import com.shockwave.pdfium.PdfiumCore;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PDFView f169a;
    public d b;
    public GestureDetector c;
    public ScaleGestureDetector d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f171g;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        PDFView pDFView = this.f169a;
        d dVar = pDFView.e;
        if (!pDFView.f3287y) {
            return false;
        }
        if (pDFView.getZoom() < pDFView.getMidZoom()) {
            dVar.d(motionEvent.getX(), motionEvent.getY(), pDFView.f3273k, pDFView.getMidZoom());
            return true;
        }
        if (pDFView.getZoom() >= pDFView.getMaxZoom()) {
            dVar.d(pDFView.getWidth() / 2, pDFView.getHeight() / 2, pDFView.f3273k, pDFView.f3267a);
            return true;
        }
        dVar.d(motionEvent.getX(), motionEvent.getY(), pDFView.f3273k, pDFView.getMaxZoom());
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        d dVar = this.b;
        dVar.d = false;
        dVar.c.forceFinished(true);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:45:0x0135  */
    /* JADX WARN: Code duplicated, block: B:46:0x013d  */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (r8 < (r9 - r4.getHeight())) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        if (r8 < (r9 - r4.getWidth())) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        r12 = (int) r4.getCurrentXOffset();
        r13 = (int) r4.getCurrentYOffset();
        r5 = r4.f3269g;
        r6 = -r5.e(r4.getCurrentPage(), r4.getZoom());
        r8 = r6 - r5.d(r4.getCurrentPage(), r4.getZoom());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
    
        if (r4.f3285w == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
    
        r5 = -((r5.b().f575a * r4.f3273k) - r4.getWidth());
        r8 = r8 + r4.getHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
    
        r8 = r8 + r4.getWidth();
        r4 = -((r5.b().b * r4.f3273k) - r4.getHeight());
        r10 = r6;
        r6 = 0.0f;
        r5 = r8;
        r8 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00af, code lost:
    
        r3.e();
        r3.d = true;
        r3.c.fling(r12, r13, (int) r23, (int) r24, (int) r5, (int) r10, (int) r8, (int) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00c7, code lost:
    
        return true;
     */
    @Override // android.view.GestureDetector.OnGestureListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onFling(android.view.MotionEvent r21, android.view.MotionEvent r22, float r23, float r24) {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D1.h.onFling(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        this.f169a.f3280r.getClass();
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        PDFView pDFView = this.f169a;
        float zoom = pDFView.getZoom() * scaleFactor;
        float fMin = Math.min(1.0f, pDFView.getMinZoom());
        float fMin2 = Math.min(10.0f, pDFView.getMaxZoom());
        if (zoom < fMin) {
            scaleFactor = fMin / pDFView.getZoom();
        } else if (zoom > fMin2) {
            scaleFactor = fMin2 / pDFView.getZoom();
        }
        pDFView.s(new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()), pDFView.f3273k * scaleFactor);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f170f = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        PDFView pDFView = this.f169a;
        pDFView.n();
        pDFView.getScrollHandle();
        this.f170f = false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        this.e = true;
        PDFView pDFView = this.f169a;
        if (pDFView.f3273k != pDFView.f3267a || pDFView.f3286x) {
            pDFView.o(pDFView.f3271i + (-f6), pDFView.f3272j + (-f7));
        }
        if (this.f170f) {
            return true;
        }
        pDFView.m();
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        int iH;
        int iE;
        PDFView pDFView = this.f169a;
        pDFView.f3280r.getClass();
        float x6 = motionEvent.getX();
        float y6 = motionEvent.getY();
        m mVar = pDFView.f3269g;
        if (mVar == null) {
            pDFView.getScrollHandle();
        } else {
            PdfiumCore pdfiumCore = mVar.b;
            float f6 = x6 + (-pDFView.getCurrentXOffset());
            float f7 = y6 + (-pDFView.getCurrentYOffset());
            int iC = mVar.c(pDFView.f3285w ? f7 : f6, pDFView.getZoom());
            Q2.a aVarG = mVar.g(iC, pDFView.getZoom());
            if (pDFView.f3285w) {
                iE = (int) mVar.h(iC, pDFView.getZoom());
                iH = (int) mVar.e(iC, pDFView.getZoom());
            } else {
                iH = (int) mVar.h(iC, pDFView.getZoom());
                iE = (int) mVar.e(iC, pDFView.getZoom());
            }
            ArrayList arrayListD = pdfiumCore.d(mVar.f182a, mVar.a(iC));
            int size = arrayListD.size();
            int i5 = 0;
            while (i5 < size) {
                int i6 = i5 + 1;
                P2.b bVar = (P2.b) arrayListD.get(i5);
                int i7 = (int) aVarG.f575a;
                int i8 = (int) aVarG.b;
                RectF rectF = bVar.f564a;
                Q2.a aVar = aVarG;
                int iA = mVar.a(iC);
                int i9 = iC;
                P2.d dVar = mVar.f182a;
                m mVar2 = mVar;
                PdfiumCore pdfiumCore2 = pdfiumCore;
                ArrayList arrayList = arrayListD;
                int i10 = size;
                Point pointG = pdfiumCore2.g(dVar, iA, iE, iH, i7, i8, rectF.left, rectF.top);
                pdfiumCore = pdfiumCore2;
                Point pointG2 = pdfiumCore.g(dVar, iA, iE, iH, i7, i8, rectF.right, rectF.bottom);
                RectF rectF2 = new RectF(pointG.x, pointG.y, pointG2.x, pointG2.y);
                rectF2.sort();
                if (rectF2.contains(f6, f7)) {
                    S4.h hVar = (S4.h) pDFView.f3280r.b;
                    if (hVar != null) {
                        PDFView pDFView2 = (PDFView) hVar.b;
                        String str = bVar.c;
                        Integer num = bVar.b;
                        if (str != null && !str.isEmpty()) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                            Context context = pDFView2.getContext();
                            if (intent.resolveActivity(context.getPackageManager()) != null) {
                                context.startActivity(intent);
                            } else {
                                Log.w("h", "No activity found for URI: ".concat(str));
                            }
                        } else if (num != null) {
                            pDFView2.l(num.intValue());
                        }
                    }
                } else {
                    mVar = mVar2;
                    i5 = i6;
                    aVarG = aVar;
                    iC = i9;
                    arrayListD = arrayList;
                    size = i10;
                }
            }
            pDFView.getScrollHandle();
        }
        pDFView.performClick();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        PDFView pDFView = this.f169a;
        if (!this.f171g) {
            return false;
        }
        boolean z6 = this.c.onTouchEvent(motionEvent) || this.d.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.e) {
            this.e = false;
            pDFView.n();
            pDFView.getScrollHandle();
            d dVar = this.b;
            if (!dVar.d && !dVar.e) {
                pDFView.p();
            }
        }
        return z6;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }
}
