package p058k2;

import L1.l;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.collection.a;
import com.library.base.view.photoview.PhotoView;
import java.lang.ref.WeakReference;
import p064l2.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements b, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final boolean f5479y = Log.isLoggable("PhotoViewAttacher", 3);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AccelerateDecelerateInterpolator f5480z = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference f5483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GestureDetector f5484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f5485i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j f5491o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View.OnLongClickListener f5492p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f5493q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f5494r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f5495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f5496t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public f f5497u;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f5499w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5481a = 200;
    public float b = 1.0f;
    public float c = 1.75f;
    public float d = 3.0f;
    public boolean e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5482f = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f5486j = new Matrix();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f5487k = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f5488l = new Matrix();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RectF f5489m = new RectF();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float[] f5490n = new float[9];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5498v = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ImageView.ScaleType f5500x = ImageView.ScaleType.FIT_CENTER;

    public k(PhotoView photoView) {
        this.f5483g = new WeakReference(photoView);
        photoView.setDrawingCacheEnabled(true);
        photoView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = photoView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (photoView.isInEditMode()) {
            return;
        }
        b bVar = new b(photoView.getContext());
        bVar.f5784a = this;
        this.f5485i = bVar;
        GestureDetector gestureDetector = new GestureDetector(photoView.getContext(), new c(this));
        this.f5484h = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new l(1, this));
        this.f5499w = true;
        o();
    }

    public static void d(float f6, float f7, float f8) {
        if (f6 >= f7) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f7 >= f8) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    public static int i(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public static int j(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public final void a() {
        f fVar = this.f5497u;
        if (fVar != null) {
            if (f5479y) {
                Log.d("PhotoViewAttacher", "Cancel Fling");
            }
            fVar.f5478a.f6118a.forceFinished(true);
            this.f5497u = null;
        }
    }

    public final void b() {
        if (c()) {
            m(g());
        }
    }

    public final boolean c() {
        RectF rectFF;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        ImageView imageViewH = h();
        if (imageViewH == null || (rectFF = f(g())) == null) {
            return false;
        }
        float fHeight = rectFF.height();
        float fWidth = rectFF.width();
        float fI = i(imageViewH);
        float f12 = 0.0f;
        if (fHeight <= fI) {
            int i5 = d.f5475a[this.f5500x.ordinal()];
            if (i5 != 2) {
                if (i5 != 3) {
                    fI = (fI - fHeight) / 2.0f;
                    f7 = rectFF.top;
                } else {
                    fI -= fHeight;
                    f7 = rectFF.top;
                }
            } else {
                f6 = rectFF.top;
                f8 = -f6;
            }
        } else {
            f6 = rectFF.top;
            if (f6 > 0.0f) {
                f8 = -f6;
            } else {
                f7 = rectFF.bottom;
                f8 = f7 < fI ? fI - f7 : 0.0f;
            }
        }
        float fJ = j(imageViewH);
        if (fWidth <= fJ) {
            int i6 = d.f5475a[this.f5500x.ordinal()];
            if (i6 != 2) {
                if (i6 != 3) {
                    f10 = (fJ - fWidth) / 2.0f;
                    f11 = rectFF.left;
                } else {
                    f10 = fJ - fWidth;
                    f11 = rectFF.left;
                }
                f9 = f10 - f11;
            } else {
                f9 = -rectFF.left;
            }
            f12 = f9;
            this.f5498v = 2;
        } else {
            float f13 = rectFF.left;
            if (f13 > 0.0f) {
                this.f5498v = 0;
                f12 = -f13;
            } else {
                float f14 = rectFF.right;
                if (f14 < fJ) {
                    f12 = fJ - f14;
                    this.f5498v = 1;
                } else {
                    this.f5498v = -1;
                }
            }
        }
        this.f5488l.postTranslate(f12, f8);
        return true;
    }

    public final void e() {
        WeakReference weakReference = this.f5483g;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            a();
        }
        GestureDetector gestureDetector = this.f5484h;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.f5491o = null;
        this.f5483g = null;
    }

    public final RectF f(Matrix matrix) {
        Drawable drawable;
        ImageView imageViewH = h();
        if (imageViewH == null || (drawable = imageViewH.getDrawable()) == null) {
            return null;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.f5489m;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        matrix.mapRect(rectF);
        return rectF;
    }

    public final Matrix g() {
        Matrix matrix = this.f5486j;
        Matrix matrix2 = this.f5487k;
        matrix2.set(matrix);
        matrix2.postConcat(this.f5488l);
        return matrix2;
    }

    @Override // p058k2.b
    @Deprecated
    public float getMaxScale() {
        return this.d;
    }

    @Override // p058k2.b
    @Deprecated
    public float getMidScale() {
        return this.c;
    }

    @Override // p058k2.b
    @Deprecated
    public float getMinScale() {
        return this.b;
    }

    public final ImageView h() {
        WeakReference weakReference = this.f5483g;
        ImageView imageView = weakReference != null ? (ImageView) weakReference.get() : null;
        if (imageView == null) {
            e();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public final float k() {
        Matrix matrix = this.f5488l;
        float[] fArr = this.f5490n;
        matrix.getValues(fArr);
        float fPow = (float) Math.pow(fArr[0], 2.0d);
        matrix.getValues(fArr);
        return (float) Math.sqrt(fPow + ((float) Math.pow(fArr[3], 2.0d)));
    }

    public final void l(float f6, float f7, float f8) {
        if (f5479y) {
            Log.d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8)));
        }
        if (k() < this.d || f6 < 1.0f) {
            this.f5488l.postScale(f6, f6, f7, f8);
            b();
        }
    }

    public final void m(Matrix matrix) {
        ImageView imageViewH = h();
        if (imageViewH != null) {
            ImageView imageViewH2 = h();
            if (imageViewH2 != null && !(imageViewH2 instanceof b) && !ImageView.ScaleType.MATRIX.equals(imageViewH2.getScaleType())) {
                throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
            }
            imageViewH.setImageMatrix(matrix);
        }
    }

    public final void n(float f6, float f7, float f8, boolean z6) {
        ImageView imageViewH = h();
        if (imageViewH != null) {
            if (f6 < this.b || f6 > this.d) {
                Log.i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
            } else if (z6) {
                imageViewH.post(new e(this, k(), f6, f7, f8));
            } else {
                this.f5488l.setScale(f6, f6, f7, f8);
                b();
            }
        }
    }

    public final void o() {
        ImageView imageViewH = h();
        if (imageViewH != null) {
            if (!this.f5499w) {
                this.f5488l.reset();
                m(g());
                c();
            } else {
                if (!(imageViewH instanceof b)) {
                    ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
                    if (!scaleType.equals(imageViewH.getScaleType())) {
                        imageViewH.setScaleType(scaleType);
                    }
                }
                p(imageViewH.getDrawable());
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ImageView imageViewH = h();
        if (imageViewH != null) {
            if (!this.f5499w) {
                p(imageViewH.getDrawable());
                return;
            }
            int top = imageViewH.getTop();
            int right = imageViewH.getRight();
            int bottom = imageViewH.getBottom();
            int left = imageViewH.getLeft();
            if (top == this.f5493q && bottom == this.f5495s && left == this.f5496t && right == this.f5494r) {
                return;
            }
            p(imageViewH.getDrawable());
            this.f5493q = top;
            this.f5494r = right;
            this.f5495s = bottom;
            this.f5496t = left;
        }
    }

    /* JADX WARN: Code duplicated, block: B:128:0x02df  */
    /* JADX WARN: Code duplicated, block: B:131:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:132:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:134:0x0304  */
    /* JADX WARN: Code duplicated, block: B:135:0x0308  */
    /* JADX WARN: Code duplicated, block: B:141:0x0329  */
    /* JADX WARN: Code duplicated, block: B:146:0x0334  */
    /* JADX WARN: Code duplicated, block: B:150:0x033d  */
    /* JADX WARN: Code duplicated, block: B:152:0x0344  */
    /* JADX WARN: Code duplicated, block: B:26:0x006e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0085  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:61:0x0108  */
    /* JADX WARN: Code duplicated, block: B:63:0x011a  */
    /* JADX WARN: Code duplicated, block: B:64:0x011c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0123  */
    /* JADX WARN: Code duplicated, block: B:71:0x0130  */
    /* JADX WARN: Code duplicated, block: B:73:0x0134  */
    /* JADX WARN: Code duplicated, block: B:91:0x0186 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0188  */
    /* JADX WARN: Code duplicated, block: B:95:0x0194  */
    /* JADX WARN: Code duplicated, block: B:97:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a6  */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x006e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:28:0x0085, please report this as an issue */
    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        ImageView imageView;
        boolean z6;
        b bVar;
        ScaleGestureDetector scaleGestureDetector;
        boolean zIsInProgress;
        boolean z7;
        int action;
        int action2;
        boolean z8;
        boolean z9;
        VelocityTracker velocityTrackerObtain;
        boolean z10;
        boolean z11;
        boolean z12;
        VelocityTracker velocityTracker;
        int iRound;
        int i5;
        int iRound2;
        int i6;
        float fA;
        float fB;
        float f6;
        float f7;
        k kVar;
        b bVar2;
        VelocityTracker velocityTracker2;
        ViewParent parent;
        boolean z13;
        VelocityTracker velocityTracker3;
        MotionEvent motionEvent2 = motionEvent;
        if (!this.f5499w || (imageView = (ImageView) view) == null || imageView.getDrawable() == null) {
            return false;
        }
        ViewParent parent2 = view.getParent();
        int action3 = motionEvent2.getAction();
        boolean z14 = true;
        if (action3 != 0) {
            if ((action3 == 1 || action3 == 3) && k() < this.b) {
                c();
                RectF rectFF = f(g());
                if (rectFF != null) {
                    view.post(new e(this, k(), this.b, rectFF.centerX(), rectFF.centerY()));
                    z6 = true;
                }
            }
            bVar = this.f5485i;
            if (bVar != null) {
                scaleGestureDetector = bVar.f5789j;
                zIsInProgress = scaleGestureDetector.isInProgress();
                z7 = bVar.f5786g;
                bVar.f5789j.onTouchEvent(motionEvent2);
                action = motionEvent2.getAction() & 255;
                if (action != 0) {
                    if (action != 1 || action == 3) {
                        bVar.f5787h = -1;
                    } else if (action == 6) {
                        int iA = a.a(motionEvent2.getAction());
                        if (motionEvent2.getPointerId(iA) == bVar.f5787h) {
                            int i7 = iA != 0 ? 0 : 1;
                            bVar.f5787h = motionEvent2.getPointerId(i7);
                            bVar.b = motionEvent2.getX(i7);
                            bVar.c = motionEvent2.getY(i7);
                        }
                    }
                } else {
                    bVar.f5787h = motionEvent2.getPointerId(0);
                }
                int i8 = bVar.f5787h;
                bVar.f5788i = motionEvent2.findPointerIndex(i8 != -1 ? i8 : 0);
                action2 = motionEvent2.getAction();
                if (action2 != 0) {
                    scaleGestureDetector = scaleGestureDetector;
                    z8 = zIsInProgress;
                    z7 = z7;
                    z14 = true;
                    z9 = false;
                    velocityTrackerObtain = VelocityTracker.obtain();
                    bVar.f5785f = velocityTrackerObtain;
                    if (velocityTrackerObtain != null) {
                        velocityTrackerObtain.addMovement(motionEvent2);
                    } else {
                        Log.i("CupcakeGestureDetector", "Velocity tracker is null");
                    }
                    bVar.b = bVar.a(motionEvent2);
                    bVar.c = bVar.b(motionEvent2);
                    bVar.f5786g = false;
                } else if (action2 != 1) {
                    z9 = false;
                    if (bVar.f5786g || bVar.f5785f == null) {
                        z8 = zIsInProgress;
                        z7 = z7;
                        z14 = true;
                    } else {
                        bVar.b = bVar.a(motionEvent2);
                        bVar.c = bVar.b(motionEvent2);
                        bVar.f5785f.addMovement(motionEvent2);
                        bVar.f5785f.computeCurrentVelocity(1000);
                        float xVelocity = bVar.f5785f.getXVelocity();
                        float yVelocity = bVar.f5785f.getYVelocity();
                        if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= bVar.e) {
                            k kVar2 = bVar.f5784a;
                            float f8 = bVar.b;
                            float f9 = bVar.c;
                            float f10 = -xVelocity;
                            float f11 = -yVelocity;
                            boolean z15 = f5479y;
                            if (z15) {
                                kVar2.getClass();
                                Log.d("PhotoViewAttacher", "onFling. sX: " + f8 + " sY: " + f9 + " Vx: " + f10 + " Vy: " + f11);
                            }
                            ImageView imageViewH = kVar2.h();
                            f fVar = new f(kVar2, imageViewH.getContext());
                            kVar2.f5497u = fVar;
                            int iJ = j(imageViewH);
                            int i9 = i(imageViewH);
                            int i10 = (int) f10;
                            int i11 = (int) f11;
                            k kVar3 = fVar.d;
                            kVar3.c();
                            RectF rectFF2 = kVar3.f(kVar3.g());
                            if (rectFF2 == null) {
                                z8 = zIsInProgress;
                                z7 = z7;
                            } else {
                                int iRound3 = Math.round(-rectFF2.left);
                                float f12 = iJ;
                                if (f12 < rectFF2.width()) {
                                    iRound = Math.round(rectFF2.width() - f12);
                                    i5 = 0;
                                } else {
                                    iRound = iRound3;
                                    i5 = iRound;
                                }
                                z8 = zIsInProgress;
                                int iRound4 = Math.round(-rectFF2.top);
                                float f13 = i9;
                                if (f13 < rectFF2.height()) {
                                    iRound2 = Math.round(rectFF2.height() - f13);
                                    i6 = 0;
                                } else {
                                    iRound2 = iRound4;
                                    i6 = iRound2;
                                }
                                fVar.b = iRound3;
                                fVar.c = iRound4;
                                if (z15) {
                                    StringBuilder sbS = a.s("fling. StartX:", iRound3, iRound4, " StartY:", " MaxX:");
                                    sbS.append(iRound);
                                    sbS.append(" MaxY:");
                                    sbS.append(iRound2);
                                    Log.d("PhotoViewAttacher", sbS.toString());
                                }
                                if (iRound3 != iRound || iRound4 != iRound2) {
                                    fVar.f5478a.f6118a.fling(iRound3, iRound4, i10, i11, i5, iRound, i6, iRound2, 0, 0);
                                }
                            }
                            imageViewH.post(kVar2.f5497u);
                        } else {
                            z8 = zIsInProgress;
                            z7 = z7;
                            z14 = true;
                        }
                    }
                    velocityTracker = bVar.f5785f;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        bVar.f5785f = null;
                    }
                } else if (action2 != 2) {
                    if (action2 == 3 && (velocityTracker3 = bVar.f5785f) != null) {
                        velocityTracker3.recycle();
                        bVar.f5785f = null;
                    }
                    scaleGestureDetector = scaleGestureDetector;
                    z8 = zIsInProgress;
                    z7 = z7;
                    z14 = true;
                    z9 = false;
                } else {
                    fA = bVar.a(motionEvent2);
                    fB = bVar.b(motionEvent2);
                    f6 = fA - bVar.b;
                    f7 = fB - bVar.c;
                    z9 = false;
                    if (!bVar.f5786g) {
                        if (Math.sqrt((f7 * f7) + (f6 * f6)) >= bVar.d) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        bVar.f5786g = z13;
                    }
                    if (bVar.f5786g) {
                        kVar = bVar.f5784a;
                        bVar2 = kVar.f5485i;
                        if (!bVar2.f5789j.isInProgress()) {
                            if (f5479y) {
                                Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f6), Float.valueOf(f7)));
                            }
                            ImageView imageViewH2 = kVar.h();
                            kVar.f5488l.postTranslate(f6, f7);
                            kVar.b();
                            parent = imageViewH2.getParent();
                            if (!kVar.e && !bVar2.f5789j.isInProgress() && !kVar.f5482f) {
                                int i12 = kVar.f5498v;
                                if ((i12 == 2 || ((i12 == 0 && f6 >= 1.0f) || (i12 == 1 && f6 <= -1.0f))) && parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(false);
                                }
                            } else if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                        bVar.b = fA;
                        bVar.c = fB;
                        velocityTracker2 = bVar.f5785f;
                        if (velocityTracker2 != null) {
                            motionEvent2 = motionEvent;
                            velocityTracker2.addMovement(motionEvent2);
                        } else {
                            motionEvent2 = motionEvent;
                        }
                    } else {
                        motionEvent2 = motionEvent;
                    }
                    scaleGestureDetector = scaleGestureDetector;
                    z8 = zIsInProgress;
                    z7 = z7;
                    z14 = true;
                }
                if (!z8 || scaleGestureDetector.isInProgress()) {
                    z10 = z9;
                } else {
                    z10 = z14;
                }
                if (!z7 || bVar.f5786g) {
                    z11 = z9;
                } else {
                    z11 = z14;
                }
                if (z10 || !z11) {
                    z12 = z9;
                } else {
                    z12 = z14;
                }
                this.f5482f = z12;
                z6 = z14;
            } else {
                z14 = true;
            }
            GestureDetector gestureDetector = this.f5484h;
            return (gestureDetector == null && gestureDetector.onTouchEvent(motionEvent2)) ? z14 : z6;
        }
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(true);
        } else {
            Log.i("PhotoViewAttacher", "onTouch getParent() returned null");
        }
        a();
        z6 = false;
        bVar = this.f5485i;
        if (bVar != null) {
            scaleGestureDetector = bVar.f5789j;
            zIsInProgress = scaleGestureDetector.isInProgress();
            z7 = bVar.f5786g;
            bVar.f5789j.onTouchEvent(motionEvent2);
            action = motionEvent2.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    bVar.f5787h = -1;
                } else {
                    bVar.f5787h = -1;
                }
            } else {
                bVar.f5787h = motionEvent2.getPointerId(0);
            }
            int i13 = bVar.f5787h;
            bVar.f5788i = motionEvent2.findPointerIndex(i13 != -1 ? i13 : 0);
            action2 = motionEvent2.getAction();
            if (action2 != 0) {
                scaleGestureDetector = scaleGestureDetector;
                z8 = zIsInProgress;
                z7 = z7;
                z14 = true;
                z9 = false;
                velocityTrackerObtain = VelocityTracker.obtain();
                bVar.f5785f = velocityTrackerObtain;
                if (velocityTrackerObtain != null) {
                    velocityTrackerObtain.addMovement(motionEvent2);
                } else {
                    Log.i("CupcakeGestureDetector", "Velocity tracker is null");
                }
                bVar.b = bVar.a(motionEvent2);
                bVar.c = bVar.b(motionEvent2);
                bVar.f5786g = false;
            } else if (action2 != 1) {
                z9 = false;
                if (bVar.f5786g) {
                    z8 = zIsInProgress;
                    z7 = z7;
                    z14 = true;
                } else {
                    z8 = zIsInProgress;
                    z7 = z7;
                    z14 = true;
                }
                velocityTracker = bVar.f5785f;
                if (velocityTracker != null) {
                    velocityTracker.recycle();
                    bVar.f5785f = null;
                }
            } else if (action2 != 2) {
                if (action2 == 3) {
                    velocityTracker3.recycle();
                    bVar.f5785f = null;
                }
                scaleGestureDetector = scaleGestureDetector;
                z8 = zIsInProgress;
                z7 = z7;
                z14 = true;
                z9 = false;
            } else {
                fA = bVar.a(motionEvent2);
                fB = bVar.b(motionEvent2);
                f6 = fA - bVar.b;
                f7 = fB - bVar.c;
                z9 = false;
                if (!bVar.f5786g) {
                    if (Math.sqrt((f7 * f7) + (f6 * f6)) >= bVar.d) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.f5786g = z13;
                }
                if (bVar.f5786g) {
                    kVar = bVar.f5784a;
                    bVar2 = kVar.f5485i;
                    if (!bVar2.f5789j.isInProgress()) {
                        if (f5479y) {
                            Log.d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f6), Float.valueOf(f7)));
                        }
                        ImageView imageViewH3 = kVar.h();
                        kVar.f5488l.postTranslate(f6, f7);
                        kVar.b();
                        parent = imageViewH3.getParent();
                        if (!kVar.e) {
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        } else if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    bVar.b = fA;
                    bVar.c = fB;
                    velocityTracker2 = bVar.f5785f;
                    if (velocityTracker2 != null) {
                        motionEvent2 = motionEvent;
                        velocityTracker2.addMovement(motionEvent2);
                    } else {
                        motionEvent2 = motionEvent;
                    }
                } else {
                    motionEvent2 = motionEvent;
                }
                scaleGestureDetector = scaleGestureDetector;
                z8 = zIsInProgress;
                z7 = z7;
                z14 = true;
            }
            if (z8) {
                z10 = z9;
            } else {
                z10 = z9;
            }
            if (z7) {
                z11 = z9;
            } else {
                z11 = z9;
            }
            if (z10) {
                z12 = z9;
            } else {
                z12 = z9;
            }
            this.f5482f = z12;
            z6 = z14;
        } else {
            z14 = true;
        }
        GestureDetector gestureDetector2 = this.f5484h;
        if (gestureDetector2 == null) {
        }
    }

    public final void p(Drawable drawable) {
        ImageView imageViewH = h();
        if (imageViewH == null || drawable == null) {
            return;
        }
        float fJ = j(imageViewH);
        float fI = i(imageViewH);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Matrix matrix = this.f5486j;
        matrix.reset();
        float f6 = intrinsicWidth;
        float f7 = fJ / f6;
        float f8 = intrinsicHeight;
        float f9 = fI / f8;
        ImageView.ScaleType scaleType = this.f5500x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            matrix.postTranslate((fJ - f6) / 2.0f, (fI - f8) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f7, f9);
            matrix.postScale(fMax, fMax);
            matrix.postTranslate((fJ - (f6 * fMax)) / 2.0f, a.b(f8, fMax, fI, 2.0f));
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f7, f9));
            matrix.postScale(fMin, fMin);
            matrix.postTranslate((fJ - (f6 * fMin)) / 2.0f, a.b(f8, fMin, fI, 2.0f));
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f6, f8);
            RectF rectF2 = new RectF(0.0f, 0.0f, fJ, fI);
            int i5 = d.f5475a[this.f5500x.ordinal()];
            if (i5 == 2) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i5 == 3) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i5 == 4) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i5 == 5) {
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        this.f5488l.reset();
        m(g());
        c();
    }

    @Override // p058k2.b
    @Deprecated
    public void setMaxScale(float f6) {
        d(this.b, this.c, f6);
        this.d = f6;
    }

    @Override // p058k2.b
    @Deprecated
    public void setMidScale(float f6) {
        d(this.b, f6, this.d);
        this.c = f6;
    }

    @Override // p058k2.b
    @Deprecated
    public void setMinScale(float f6) {
        d(f6, this.c, this.d);
        this.b = f6;
    }
}
