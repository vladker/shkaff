package L1;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.github.chrisbanes.photoview.PhotoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements GestureDetector.OnDoubleTapListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f420a;
    public final View.OnTouchListener b;

    public /* synthetic */ l(int i5, View.OnTouchListener onTouchListener) {
        this.f420a = i5;
        this.b = onTouchListener;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[Catch: ArrayIndexOutOfBoundsException -> 0x003b, TRY_LEAVE, TryCatch #1 {ArrayIndexOutOfBoundsException -> 0x003b, blocks: (B:8:0x000e, B:10:0x0024, B:13:0x002c, B:15:0x0032, B:16:0x0036), top: B:36:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:28:0x0066 A[Catch: ArrayIndexOutOfBoundsException -> 0x006b, TRY_LEAVE, TryCatch #0 {ArrayIndexOutOfBoundsException -> 0x006b, blocks: (B:20:0x0042, B:22:0x0054, B:25:0x005c, B:27:0x0062, B:28:0x0066), top: B:33:0x0042 }] */
    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        switch (this.f420a) {
            case 0:
                p pVar = (p) this.b;
                try {
                    float fD = pVar.d();
                    float x6 = motionEvent.getX();
                    float y6 = motionEvent.getY();
                    float f6 = pVar.d;
                    if (fD < f6) {
                        pVar.e(f6, x6, y6, true);
                    } else if (fD >= f6) {
                        float f7 = pVar.e;
                        if (fD < f7) {
                            pVar.e(f7, x6, y6, true);
                        } else {
                            pVar.e(pVar.c, x6, y6, true);
                        }
                    } else {
                        pVar.e(pVar.c, x6, y6, true);
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                return true;
            default:
                p058k2.k kVar = (p058k2.k) this.b;
                if (kVar == null) {
                    return false;
                }
                try {
                    float fK = kVar.k();
                    float x7 = motionEvent.getX();
                    float y7 = motionEvent.getY();
                    p058k2.k kVar2 = (p058k2.k) this.b;
                    float f8 = kVar2.c;
                    if (fK < f8) {
                        kVar2.n(f8, x7, y7, true);
                    } else if (fK >= f8) {
                        float f9 = kVar2.d;
                        if (fK < f9) {
                            kVar2.n(f9, x7, y7, true);
                        } else {
                            kVar2.n(kVar2.b, x7, y7, true);
                        }
                    } else {
                        kVar2.n(kVar2.b, x7, y7, true);
                    }
                    break;
                } catch (ArrayIndexOutOfBoundsException unused2) {
                }
                return true;
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        switch (this.f420a) {
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        switch (this.f420a) {
            case 0:
                p pVar = (p) this.b;
                PhotoView photoView = pVar.f429h;
                View.OnClickListener onClickListener = pVar.f437p;
                if (onClickListener != null) {
                    onClickListener.onClick(photoView);
                }
                pVar.b();
                Matrix matrixC = pVar.c();
                RectF rectF = pVar.f435n;
                Drawable drawable = photoView.getDrawable();
                if (drawable != null) {
                    rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    matrixC.mapRect(rectF);
                } else {
                    rectF = null;
                }
                float x6 = motionEvent.getX();
                float y6 = motionEvent.getY();
                if (rectF == null || !rectF.contains(x6, y6)) {
                    return false;
                }
                rectF.width();
                rectF.height();
                return true;
            default:
                p058k2.k kVar = (p058k2.k) this.b;
                if (kVar == null) {
                    return false;
                }
                ImageView imageViewH = kVar.h();
                ((p058k2.k) this.b).getClass();
                p058k2.j jVar = ((p058k2.k) this.b).f5491o;
                if (jVar == null) {
                    return false;
                }
                jVar.onViewTap(imageViewH, motionEvent.getX(), motionEvent.getY());
                return false;
        }
    }
}
