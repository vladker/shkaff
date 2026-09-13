package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f6) {
            float f7 = f6 - 1.0f;
            return (f7 * f7 * f7 * f7 * f7) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i5 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = i5;
        this.mEdgeSize = i5;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f6, float f7, int i5, int i6) {
        float fAbs = Math.abs(f6);
        float fAbs2 = Math.abs(f7);
        if ((this.mInitialEdgesTouched[i5] & i6) == i6 && (this.mTrackingEdges & i6) != 0 && (this.mEdgeDragsLocked[i5] & i6) != i6 && (this.mEdgeDragsInProgress[i5] & i6) != i6) {
            int i7 = this.mTouchSlop;
            if (fAbs > i7 || fAbs2 > i7) {
                if (fAbs < fAbs2 * 0.5f && this.mCallback.onEdgeLock(i6)) {
                    int[] iArr = this.mEdgeDragsLocked;
                    iArr[i5] = iArr[i5] | i6;
                    return false;
                }
                if ((this.mEdgeDragsInProgress[i5] & i6) == 0 && fAbs > this.mTouchSlop) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f6, float f7) {
        if (view == null) {
            return false;
        }
        boolean z6 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z7 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (z6 && z7) {
            float f8 = (f7 * f7) + (f6 * f6);
            int i5 = this.mTouchSlop;
            return f8 > ((float) (i5 * i5));
        }
        if (z6) {
            return Math.abs(f6) > ((float) this.mTouchSlop);
        }
        return z7 && Math.abs(f7) > ((float) this.mTouchSlop);
    }

    private int clampMag(int i5, int i6, int i7) {
        int iAbs = Math.abs(i5);
        if (iAbs < i6) {
            return 0;
        }
        if (iAbs > i7) {
            return i5 > 0 ? i7 : -i7;
        }
        return i5;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    private int computeAxisDuration(int i5, int i6, int i7) {
        if (i5 == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f6 = width / 2;
        float fDistanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i5) / width)) * f6) + f6;
        int iAbs = Math.abs(i6);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i5) / i7) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(View view, int i5, int i6, int i7, int i8) {
        float f6;
        float f7;
        float f8;
        float f9;
        int iClampMag = clampMag(i7, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iClampMag2 = clampMag(i8, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int iAbs = Math.abs(i5);
        int iAbs2 = Math.abs(i6);
        int iAbs3 = Math.abs(iClampMag);
        int iAbs4 = Math.abs(iClampMag2);
        int i9 = iAbs3 + iAbs4;
        int i10 = iAbs + iAbs2;
        if (iClampMag != 0) {
            f6 = iAbs3;
            f7 = i9;
        } else {
            f6 = iAbs;
            f7 = i10;
        }
        float f10 = f6 / f7;
        if (iClampMag2 != 0) {
            f8 = iAbs4;
            f9 = i9;
        } else {
            f8 = iAbs2;
            f9 = i10;
        }
        return (int) ((computeAxisDuration(i6, iClampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f8 / f9)) + (computeAxisDuration(i5, iClampMag, this.mCallback.getViewHorizontalDragRange(view)) * f10));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private void dispatchViewReleased(float f6, float f7) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f6, f7);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f6) {
        return (float) Math.sin((f6 - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i5, int i6, int i7, int i8) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i7 != 0) {
            i5 = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i5, i7);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i5 - left);
        }
        int i9 = i5;
        if (i8 != 0) {
            i6 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i6, i8);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i6 - top);
        }
        int i10 = i6;
        if (i7 == 0 && i8 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i9, i10, i9 - left, i10 - top);
    }

    private void ensureMotionHistorySizeForId(int i5) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i5) {
            int i6 = i5 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i5, int i6, int i7, int i8) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i9 = i5 - left;
        int i10 = i6 - top;
        if (i9 == 0 && i10 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i9, i10, computeSettleDuration(this.mCapturedView, i9, i10, i7, i8));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i5, int i6) {
        int i7 = i5 < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i6 < this.mParentView.getTop() + this.mEdgeSize) {
            i7 |= 4;
        }
        if (i5 > this.mParentView.getRight() - this.mEdgeSize) {
            i7 |= 2;
        }
        return i6 > this.mParentView.getBottom() - this.mEdgeSize ? i7 | 8 : i7;
    }

    private boolean isValidPointerForActionMove(int i5) {
        if (isPointerDown(i5)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void reportNewEdgeDrags(float f6, float f7, int i5) {
        int i6;
        boolean zCheckNewEdgeDrag = checkNewEdgeDrag(f6, f7, i5, 1);
        ?? r6 = zCheckNewEdgeDrag;
        if (checkNewEdgeDrag(f7, f6, i5, 4)) {
            r6 = (zCheckNewEdgeDrag ? 1 : 0) | 4;
        }
        ?? r7 = r6;
        if (checkNewEdgeDrag(f6, f7, i5, 2)) {
            r7 = (r6 == true ? 1 : 0) | 2;
        }
        ?? r8 = r7;
        if (checkNewEdgeDrag(f7, f6, i5, 8)) {
            i6 = (r7 == true ? 1 : 0) | 8;
        }
        if (r8 == 0) {
            r8 = i6;
            return;
        }
        r8 = i6;
        int[] iArr = this.mEdgeDragsInProgress;
        iArr[i5] = (iArr[i5] | r8) == true ? 1 : 0;
        this.mCallback.onEdgeDragStarted(r8, i5);
    }

    private void saveInitialMotion(float f6, float f7, int i5) {
        ensureMotionHistorySizeForId(i5);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i5] = f6;
        fArr[i5] = f6;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i5] = f7;
        fArr2[i5] = f7;
        this.mInitialEdgesTouched[i5] = getEdgesTouched((int) f6, (int) f7);
        this.mPointersDown |= 1 << i5;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i5 = 0; i5 < pointerCount; i5++) {
            int pointerId = motionEvent.getPointerId(i5);
            if (isValidPointerForActionMove(pointerId)) {
                float x6 = motionEvent.getX(i5);
                float y6 = motionEvent.getY(i5);
                this.mLastMotionX[pointerId] = x6;
                this.mLastMotionY[pointerId] = y6;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@NonNull View view, boolean z6, int i5, int i6, int i7, int i8) {
        int i9;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i10 = i7 + scrollX;
                if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && (i9 = i8 + scrollY) >= childAt.getTop() && i9 < childAt.getBottom() && canScroll(childAt, true, i5, i6, i10 - childAt.getLeft(), i9 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z6) {
            return view.canScrollHorizontally(-i5) || view.canScrollVertically(-i6);
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i5) {
        if (view.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
        }
        this.mCapturedView = view;
        this.mActivePointerId = i5;
        this.mCallback.onViewCaptured(view, i5);
        setDragState(1);
    }

    public boolean continueSettling(boolean z6) {
        if (this.mDragState == 2) {
            boolean zComputeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z6) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    @Nullable
    public View findTopChildUnder(int i5, int i6) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i5, int i6, int i7, int i8) {
        if (!this.mReleaseInProgress) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i5, i7, i6, i8);
        setDragState(2);
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i5, int i6) {
        return isViewUnder(this.mCapturedView, i5, i6);
    }

    public boolean isEdgeTouched(int i5) {
        int length = this.mInitialEdgesTouched.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (isEdgeTouched(i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i5) {
        return ((1 << i5) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i5, int i6) {
        return view != null && i5 >= view.getLeft() && i5 < view.getRight() && i6 >= view.getTop() && i6 < view.getBottom();
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i6 = 0;
        if (actionMasked == 0) {
            float x6 = motionEvent.getX();
            float y6 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewFindTopChildUnder = findTopChildUnder((int) x6, (int) y6);
            saveInitialMotion(x6, y6, pointerId);
            tryCaptureViewForDrag(viewFindTopChildUnder, pointerId);
            int i7 = this.mInitialEdgesTouched[pointerId];
            int i8 = this.mTrackingEdges;
            if ((i7 & i8) != 0) {
                this.mCallback.onEdgeTouched(i7 & i8, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x7 = motionEvent.getX(iFindPointerIndex);
                    float y7 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i9 = this.mActivePointerId;
                    int i10 = (int) (x7 - fArr[i9]);
                    int i11 = (int) (y7 - this.mLastMotionY[i9]);
                    dragTo(this.mCapturedView.getLeft() + i10, this.mCapturedView.getTop() + i11, i10, i11);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i6 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i6);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x8 = motionEvent.getX(i6);
                    float y8 = motionEvent.getY(i6);
                    float f6 = x8 - this.mInitialMotionX[pointerId2];
                    float f7 = y8 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f6, f7, pointerId2);
                    if (this.mDragState != 1) {
                        View viewFindTopChildUnder2 = findTopChildUnder((int) x8, (int) y8);
                        if (checkTouchSlop(viewFindTopChildUnder2, f6, f7) && tryCaptureViewForDrag(viewFindTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x9 = motionEvent.getX(actionIndex);
            float y9 = motionEvent.getY(actionIndex);
            saveInitialMotion(x9, y9, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x9, (int) y9)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x9, (int) y9), pointerId3);
                int i12 = this.mInitialEdgesTouched[pointerId3];
                int i13 = this.mTrackingEdges;
                if ((i12 & i13) != 0) {
                    this.mCallback.onEdgeTouched(i12 & i13, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i6 >= pointerCount2) {
                    i5 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i6);
                if (pointerId5 != this.mActivePointerId) {
                    View viewFindTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                    View view = this.mCapturedView;
                    if (viewFindTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i5 = this.mActivePointerId;
                        break;
                    }
                }
                i6++;
            }
            if (i5 == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setDragState(int i5) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i5) {
            this.mDragState = i5;
            this.mCallback.onViewDragStateChanged(i5);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i5) {
        this.mEdgeSize = i5;
    }

    public void setEdgeTrackingEnabled(int i5) {
        this.mTrackingEdges = i5;
    }

    public void setMinVelocity(float f6) {
        this.mMinVelocity = f6;
    }

    public boolean settleCapturedViewAt(int i5, int i6) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i5, i6, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:63:0x0101  */
    public boolean shouldInterceptTouchEvent(@NonNull MotionEvent motionEvent) {
        View viewFindTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x6 = motionEvent.getX();
            float y6 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            saveInitialMotion(x6, y6, pointerId);
            View viewFindTopChildUnder2 = findTopChildUnder((int) x6, (int) y6);
            if (viewFindTopChildUnder2 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(viewFindTopChildUnder2, pointerId);
            }
            int i5 = this.mInitialEdgesTouched[pointerId];
            int i6 = this.mTrackingEdges;
            if ((i5 & i6) != 0) {
                this.mCallback.onEdgeTouched(i5 & i6, pointerId);
            }
        } else if (actionMasked == 1) {
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x7 = motionEvent.getX(actionIndex);
                float y7 = motionEvent.getY(actionIndex);
                saveInitialMotion(x7, y7, pointerId2);
                int i7 = this.mDragState;
                if (i7 == 0) {
                    int i8 = this.mInitialEdgesTouched[pointerId2];
                    int i9 = this.mTrackingEdges;
                    if ((i8 & i9) != 0) {
                        this.mCallback.onEdgeTouched(i8 & i9, pointerId2);
                    }
                } else if (i7 == 2 && (viewFindTopChildUnder = findTopChildUnder((int) x7, (int) y7)) == this.mCapturedView) {
                    tryCaptureViewForDrag(viewFindTopChildUnder, pointerId2);
                }
            } else if (actionMasked == 6) {
                clearMotionHistory(motionEvent.getPointerId(actionIndex));
            }
        } else if (this.mInitialMotionX != null && this.mInitialMotionY != null) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i10 = 0; i10 < pointerCount; i10++) {
                int pointerId3 = motionEvent.getPointerId(i10);
                if (isValidPointerForActionMove(pointerId3)) {
                    float x8 = motionEvent.getX(i10);
                    float y8 = motionEvent.getY(i10);
                    float f6 = x8 - this.mInitialMotionX[pointerId3];
                    float f7 = y8 - this.mInitialMotionY[pointerId3];
                    View viewFindTopChildUnder3 = findTopChildUnder((int) x8, (int) y8);
                    boolean z6 = viewFindTopChildUnder3 != null && checkTouchSlop(viewFindTopChildUnder3, f6, f7);
                    if (!z6) {
                        reportNewEdgeDrags(f6, f7, pointerId3);
                        if (this.mDragState != 1) {
                            break;
                        }
                    } else {
                        int left = viewFindTopChildUnder3.getLeft();
                        int i11 = (int) f6;
                        int iClampViewPositionHorizontal = this.mCallback.clampViewPositionHorizontal(viewFindTopChildUnder3, left + i11, i11);
                        int top = viewFindTopChildUnder3.getTop();
                        int i12 = (int) f7;
                        int iClampViewPositionVertical = this.mCallback.clampViewPositionVertical(viewFindTopChildUnder3, top + i12, i12);
                        int viewHorizontalDragRange = this.mCallback.getViewHorizontalDragRange(viewFindTopChildUnder3);
                        int viewVerticalDragRange = this.mCallback.getViewVerticalDragRange(viewFindTopChildUnder3);
                        if ((viewHorizontalDragRange == 0 || (viewHorizontalDragRange > 0 && iClampViewPositionHorizontal == left)) && (viewVerticalDragRange == 0 || (viewVerticalDragRange > 0 && iClampViewPositionVertical == top))) {
                            break;
                        }
                        reportNewEdgeDrags(f6, f7, pointerId3);
                        if (this.mDragState != 1 || (z6 && tryCaptureViewForDrag(viewFindTopChildUnder3, pointerId3))) {
                            break;
                        }
                    }
                }
            }
            saveLastMotion(motionEvent);
        }
        return this.mDragState == 1;
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i5, int i6) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean zForceSettleCapturedViewAt = forceSettleCapturedViewAt(i5, i6, 0, 0);
        if (!zForceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return zForceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i5) {
        if (view == this.mCapturedView && this.mActivePointerId == i5) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i5)) {
            return false;
        }
        this.mActivePointerId = i5;
        captureChildView(view, i5);
        return true;
    }

    private float clampMag(float f6, float f7, float f8) {
        float fAbs = Math.abs(f6);
        if (fAbs < f7) {
            return 0.0f;
        }
        if (fAbs > f8) {
            return f6 > 0.0f ? f8 : -f8;
        }
        return f6;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f6, @NonNull Callback callback) {
        ViewDragHelper viewDragHelperCreate = create(viewGroup, callback);
        viewDragHelperCreate.mTouchSlop = (int) ((1.0f / f6) * viewDragHelperCreate.mTouchSlop);
        return viewDragHelperCreate;
    }

    public boolean isEdgeTouched(int i5, int i6) {
        return isPointerDown(i6) && (i5 & this.mInitialEdgesTouched[i6]) != 0;
    }

    public boolean checkTouchSlop(int i5) {
        int length = this.mInitialMotionX.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (checkTouchSlop(i5, i6)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i5, int i6) {
        if (!isPointerDown(i6)) {
            return false;
        }
        boolean z6 = (i5 & 1) == 1;
        boolean z7 = (i5 & 2) == 2;
        float f6 = this.mLastMotionX[i6] - this.mInitialMotionX[i6];
        float f7 = this.mLastMotionY[i6] - this.mInitialMotionY[i6];
        if (z6 && z7) {
            float f8 = (f7 * f7) + (f6 * f6);
            int i7 = this.mTouchSlop;
            return f8 > ((float) (i7 * i7));
        }
        if (z6) {
            return Math.abs(f6) > ((float) this.mTouchSlop);
        }
        return z7 && Math.abs(f7) > ((float) this.mTouchSlop);
    }

    private void clearMotionHistory(int i5) {
        if (this.mInitialMotionX == null || !isPointerDown(i5)) {
            return;
        }
        this.mInitialMotionX[i5] = 0.0f;
        this.mInitialMotionY[i5] = 0.0f;
        this.mLastMotionX[i5] = 0.0f;
        this.mLastMotionY[i5] = 0.0f;
        this.mInitialEdgesTouched[i5] = 0;
        this.mEdgeDragsInProgress[i5] = 0;
        this.mEdgeDragsLocked[i5] = 0;
        this.mPointersDown = (~(1 << i5)) & this.mPointersDown;
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i5, int i6) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i5, int i6) {
            return 0;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public boolean onEdgeLock(int i5) {
            return false;
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i5);

        public int getOrderedChildIndex(int i5) {
            return i5;
        }

        public void onViewDragStateChanged(int i5) {
        }

        public void onEdgeDragStarted(int i5, int i6) {
        }

        public void onEdgeTouched(int i5, int i6) {
        }

        public void onViewCaptured(@NonNull View view, int i5) {
        }

        public void onViewReleased(@NonNull View view, float f6, float f7) {
        }

        public void onViewPositionChanged(@NonNull View view, int i5, int i6, @Px int i7, @Px int i8) {
        }
    }
}
