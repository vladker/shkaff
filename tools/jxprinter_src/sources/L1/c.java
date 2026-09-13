package L1;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.view.MotionEventCompat;
import com.github.chrisbanes.photoview.PhotoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f413a = -1;
    public int b = 0;
    public final ScaleGestureDetector c;
    public VelocityTracker d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f416h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f417i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p075n1.a f418j;

    public c(Context context, p075n1.a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f417i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f416h = viewConfiguration.getScaledTouchSlop();
        this.f418j = aVar;
        this.c = new ScaleGestureDetector(context, new b(this));
    }

    public final void a(MotionEvent motionEvent) {
        float x6;
        float y6;
        float x7;
        float y7;
        int iRound;
        int i5;
        int iRound2;
        int i6;
        float x8;
        float y8;
        int i7;
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            p075n1.a aVar = this.f418j;
            if (action == 1) {
                this.f413a = -1;
                if (this.e && this.d != null) {
                    try {
                        x7 = motionEvent.getX(this.b);
                    } catch (Exception unused) {
                        x7 = motionEvent.getX();
                    }
                    this.f414f = x7;
                    try {
                        y7 = motionEvent.getY(this.b);
                    } catch (Exception unused2) {
                        y7 = motionEvent.getY();
                    }
                    this.f415g = y7;
                    this.d.addMovement(motionEvent);
                    this.d.computeCurrentVelocity(1000);
                    float xVelocity = this.d.getXVelocity();
                    float yVelocity = this.d.getYVelocity();
                    if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f417i) {
                        p pVar = (p) aVar.b;
                        PhotoView photoView = pVar.f429h;
                        o oVar = new o(pVar, photoView.getContext());
                        pVar.f439r = oVar;
                        int width = (photoView.getWidth() - photoView.getPaddingLeft()) - photoView.getPaddingRight();
                        int height = (photoView.getHeight() - photoView.getPaddingTop()) - photoView.getPaddingBottom();
                        int i8 = (int) (-xVelocity);
                        int i9 = (int) (-yVelocity);
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
                        if (rectF != null) {
                            int iRound3 = Math.round(-rectF.left);
                            float f6 = width;
                            if (f6 < rectF.width()) {
                                iRound = Math.round(rectF.width() - f6);
                                i5 = 0;
                            } else {
                                iRound = iRound3;
                                i5 = iRound;
                            }
                            int iRound4 = Math.round(-rectF.top);
                            float f7 = height;
                            if (f7 < rectF.height()) {
                                iRound2 = Math.round(rectF.height() - f7);
                                i6 = 0;
                            } else {
                                iRound2 = iRound4;
                                i6 = iRound2;
                            }
                            oVar.b = iRound3;
                            oVar.c = iRound4;
                            if (iRound3 != iRound || iRound4 != iRound2) {
                                oVar.f425a.fling(iRound3, iRound4, i8, i9, i5, iRound, i6, iRound2, 0, 0);
                            }
                        }
                        photoView.post(pVar.f439r);
                    }
                }
                VelocityTracker velocityTracker = this.d;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    this.d = null;
                }
            } else if (action == 2) {
                try {
                    x8 = motionEvent.getX(this.b);
                } catch (Exception unused3) {
                    x8 = motionEvent.getX();
                }
                try {
                    y8 = motionEvent.getY(this.b);
                } catch (Exception unused4) {
                    y8 = motionEvent.getY();
                }
                float f8 = x8 - this.f414f;
                float f9 = y8 - this.f415g;
                if (!this.e) {
                    this.e = Math.sqrt((double) ((f9 * f9) + (f8 * f8))) >= ((double) this.f416h);
                }
                if (this.e) {
                    p pVar2 = (p) aVar.b;
                    c cVar = pVar2.f431j;
                    if (!cVar.c.isInProgress()) {
                        pVar2.f434m.postTranslate(f8, f9);
                        pVar2.a();
                        ViewParent parent = pVar2.f429h.getParent();
                        if (pVar2.f427f && !cVar.c.isInProgress() && !pVar2.f428g) {
                            int i10 = pVar2.f440s;
                            if ((i10 == 2 || ((i10 == 0 && f8 >= 1.0f) || ((i10 == 1 && f8 <= -1.0f) || (((i7 = pVar2.f441t) == 0 && f9 >= 1.0f) || (i7 == 1 && f9 <= -1.0f))))) && parent != null) {
                                parent.requestDisallowInterceptTouchEvent(false);
                            }
                        } else if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    this.f414f = x8;
                    this.f415g = y8;
                    VelocityTracker velocityTracker2 = this.d;
                    if (velocityTracker2 != null) {
                        velocityTracker2.addMovement(motionEvent);
                    }
                }
            } else if (action == 3) {
                this.f413a = -1;
                VelocityTracker velocityTracker3 = this.d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.d = null;
                }
            } else if (action == 6) {
                int action2 = (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                if (motionEvent.getPointerId(action2) == this.f413a) {
                    int i11 = action2 != 0 ? 0 : 1;
                    this.f413a = motionEvent.getPointerId(i11);
                    this.f414f = motionEvent.getX(i11);
                    this.f415g = motionEvent.getY(i11);
                }
            }
        } else {
            this.f413a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.d = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            try {
                x6 = motionEvent.getX(this.b);
            } catch (Exception unused5) {
                x6 = motionEvent.getX();
            }
            this.f414f = x6;
            try {
                y6 = motionEvent.getY(this.b);
            } catch (Exception unused6) {
                y6 = motionEvent.getY();
            }
            this.f415g = y6;
            this.e = false;
        }
        int i12 = this.f413a;
        this.b = motionEvent.findPointerIndex(i12 != -1 ? i12 : 0);
    }
}
