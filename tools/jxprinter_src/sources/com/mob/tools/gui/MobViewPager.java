package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes3.dex */
public class MobViewPager extends ViewGroup {
    private static final int DECELERATION = 10;
    private static final int SNAP_VELOCITY = 500;
    private static final int TOUCH_STATE_REST = 0;
    private static final int TOUCH_STATE_SCROLLING = 1;
    private ViewPagerAdapter adapter;
    private View currentPage;
    private int currentScreen;
    private int flingVelocity;
    private float lastMotionX;
    private float lastMotionY;
    private int maximumVelocity;
    private View nextPage;
    private int pageWidth;
    private View previousPage;
    private int screenCount;
    private Scroller scroller;
    private boolean skipScreen;
    private int touchSlop;
    private int touchState;
    private VelocityTracker velocityTracker;

    public MobViewPager(Context context) {
        this(context, null);
    }

    private void adjustScroller() {
        this.skipScreen = true;
        if (this.currentPage != null) {
            View focusedChild = getFocusedChild();
            View view = this.currentPage;
            if (focusedChild == view) {
                view.clearFocus();
            }
        }
        int width = (getWidth() * this.currentScreen) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            this.scroller.startScroll(getScrollX(), 0, width, 0, 0);
        }
        invalidate();
    }

    private void handleInterceptMove(MotionEvent motionEvent) {
        float x6 = motionEvent.getX();
        float y6 = motionEvent.getY();
        int iAbs = (int) Math.abs(x6 - this.lastMotionX);
        if (((int) Math.abs(y6 - this.lastMotionY)) >= iAbs || iAbs <= this.touchSlop) {
            return;
        }
        this.touchState = 1;
        this.lastMotionX = x6;
    }

    private void handleScrollMove(MotionEvent motionEvent) {
        int right;
        if (this.adapter == null) {
            return;
        }
        float x6 = motionEvent.getX();
        int i5 = (int) (this.lastMotionX - x6);
        this.lastMotionX = x6;
        if (i5 < 0) {
            if (getScrollX() > 0) {
                scrollBy(Math.max(-getScrollX(), i5), 0);
            }
        } else {
            if (i5 <= 0 || getChildCount() == 0 || (right = (getChildAt(getChildCount() - 1).getRight() - getScrollX()) - getWidth()) <= 0) {
                return;
            }
            scrollBy(Math.min(right, i5), 0);
        }
    }

    private void init(Context context) {
        this.scroller = new Scroller(context, new Interpolator() { // from class: com.mob.tools.gui.MobViewPager.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f6) {
                return (2.0f - f6) * f6;
            }
        });
        this.touchState = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void onScreenChange(int i5) {
        if (this.adapter != null) {
            if (this.skipScreen && Math.abs(i5 - this.currentScreen) > 2) {
                removeAllViews();
                int i6 = this.currentScreen;
                if (i6 > 0) {
                    View view = this.adapter.getView(i6 - 1, this.previousPage, this);
                    this.previousPage = view;
                    addView(view);
                }
                View view2 = this.adapter.getView(this.currentScreen, this.currentPage, this);
                this.currentPage = view2;
                addView(view2);
                int i7 = this.currentScreen;
                if (i7 < this.screenCount - 1) {
                    View view3 = this.adapter.getView(i7 + 1, this.nextPage, this);
                    this.nextPage = view3;
                    addView(view3);
                }
            } else if (this.currentScreen > i5) {
                for (int i8 = 0; i8 < this.currentScreen - i5; i8++) {
                    int i9 = i5 + i8;
                    int i10 = i9 + 1;
                    View view4 = this.previousPage;
                    this.previousPage = this.currentPage;
                    this.currentPage = this.nextPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(0);
                    }
                    if (i10 < this.screenCount - 1) {
                        View view5 = this.adapter.getView(i9 + 2, view4, this);
                        this.nextPage = view5;
                        addView(view5);
                    } else {
                        this.nextPage = view4;
                    }
                }
            } else {
                for (int i11 = 0; i11 < i5 - this.currentScreen; i11++) {
                    int i12 = i5 - i11;
                    int i13 = i12 - 1;
                    View view6 = this.nextPage;
                    this.nextPage = this.currentPage;
                    this.currentPage = this.previousPage;
                    if (getChildCount() >= 3) {
                        removeViewAt(2);
                    }
                    if (i13 > 0) {
                        View view7 = this.adapter.getView(i12 - 2, view6, this);
                        this.previousPage = view7;
                        addView(view7, 0);
                    } else {
                        this.previousPage = view6;
                    }
                }
            }
            this.adapter.onScreenChange(this.currentScreen, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[PHI: r8
  0x0052: PHI (r8v4 int) = (r8v3 int), (r8v5 int) binds: [B:10:0x0024, B:15:0x004f] A[DONT_GENERATE, DONT_INLINE]] */
    public void scrollToScreenOnUIThread(int i5, boolean z6) {
        int i6;
        this.skipScreen = z6;
        if (this.currentPage != null) {
            View focusedChild = getFocusedChild();
            View view = this.currentPage;
            if (focusedChild == view) {
                view.clearFocus();
            }
        }
        int width = (getWidth() * i5) - getScrollX();
        this.scroller.abortAnimation();
        if (width != 0) {
            int iSqrt = 0;
            if (z6) {
                i6 = iSqrt;
            } else {
                int iAbs = Math.abs(width) / 2;
                int i7 = this.flingVelocity;
                if (i7 != 0) {
                    int iAbs2 = Math.abs(i7);
                    iSqrt = (int) (((((double) iAbs2) - Math.sqrt((iAbs2 * iAbs2) - (Math.abs(width) * 20))) * 1000.0d) / 10.0d);
                }
                if (iSqrt == 0 || iSqrt > iAbs) {
                    i6 = iAbs;
                } else {
                    i6 = iSqrt;
                }
            }
            this.scroller.startScroll(getScrollX(), 0, width, 0, i6);
        }
        invalidate();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        if (this.scroller.computeScrollOffset()) {
            scrollTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            postInvalidate();
        } else {
            int i5 = this.currentScreen;
            int currX = this.scroller.getCurrX();
            int width = getWidth();
            int i6 = currX / width;
            if (currX % width > width / 2) {
                i6++;
            }
            int iMax = Math.max(0, Math.min(i6, this.screenCount - 1));
            this.currentScreen = iMax;
            if (i5 != iMax) {
                onScreenChange(i5);
            }
        }
        if (this.adapter != null) {
            this.adapter.onScreenChanging(getScrollX() / getWidth());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        if (this.currentScreen > 0) {
            drawChild(canvas, this.previousPage, drawingTime);
        }
        drawChild(canvas, this.currentPage, drawingTime);
        if (this.currentScreen < this.screenCount - 1) {
            drawChild(canvas, this.nextPage, drawingTime);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i5) {
        int i6;
        if (this.adapter == null) {
            return super.dispatchUnhandledMove(view, i5);
        }
        if (i5 == 17) {
            int i7 = this.currentScreen;
            if (i7 > 0) {
                scrollToScreenOnUIThread(i7 - 1, false);
                return true;
            }
        } else if (i5 == 66 && (i6 = this.currentScreen) < this.screenCount - 1) {
            scrollToScreenOnUIThread(i6 + 1, false);
            return true;
        }
        return super.dispatchUnhandledMove(view, i5);
    }

    public int getCurrentScreen() {
        return this.currentScreen;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x002f  */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 2 && this.touchState != 0) {
            return true;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (action == 0) {
            float x6 = motionEvent.getX();
            float y6 = motionEvent.getY();
            this.lastMotionX = x6;
            this.lastMotionY = y6;
            this.touchState = !this.scroller.isFinished() ? 1 : 0;
        } else if (action == 1) {
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
            this.touchState = 0;
        } else if (action == 2) {
            handleInterceptMove(motionEvent);
        } else if (action == 3) {
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
            this.touchState = 0;
        }
        return this.touchState != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int i9 = i7 - i5;
        int i10 = i8 - i6;
        int i11 = this.currentScreen;
        int i12 = i11 * i9;
        if (i11 > 0) {
            this.previousPage.layout(i12 - i9, 0, i12, i10);
        }
        int i13 = i12 + i9;
        this.currentPage.layout(i12, 0, i13, i10);
        if (this.currentScreen < this.screenCount - 1) {
            this.nextPage.layout(i13, 0, i9 + i13, i10);
        }
        if (this.pageWidth != getWidth()) {
            int i14 = this.pageWidth;
            this.pageWidth = getWidth();
            if (i14 != 0) {
                adjustScroller();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.adapter == null || this.screenCount <= 0) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            getChildAt(i7).measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i5;
        int i6;
        if (this.adapter == null) {
            return false;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        float x6 = motionEvent.getX();
        if (action != 0) {
            if (action == 1) {
                if (this.touchState == 1) {
                    this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
                    int xVelocity = (int) this.velocityTracker.getXVelocity();
                    this.flingVelocity = xVelocity;
                    if (xVelocity > 500 && (i6 = this.currentScreen) > 0) {
                        scrollToScreenOnUIThread(i6 - 1, false);
                    } else if (xVelocity >= -500 || (i5 = this.currentScreen) >= this.screenCount - 1) {
                        int width = getWidth();
                        scrollToScreenOnUIThread(((width / 2) + getScrollX()) / width, false);
                    } else {
                        scrollToScreenOnUIThread(i5 + 1, false);
                    }
                    VelocityTracker velocityTracker = this.velocityTracker;
                    if (velocityTracker != null) {
                        velocityTracker.recycle();
                        this.velocityTracker = null;
                    }
                }
                this.touchState = 0;
            } else if (action != 2) {
                if (action == 3) {
                    this.touchState = 0;
                }
            } else if (this.touchState == 1) {
                handleScrollMove(motionEvent);
            } else if (onInterceptTouchEvent(motionEvent) && this.touchState == 1) {
                handleScrollMove(motionEvent);
            }
        } else if (this.touchState != 0) {
            if (!this.scroller.isFinished()) {
                this.scroller.abortAnimation();
            }
            this.lastMotionX = x6;
        }
        return true;
    }

    public void scrollLeft(boolean z6) {
        int i5 = this.currentScreen;
        if (i5 > 0) {
            scrollToScreen(i5 - 1, z6);
        }
    }

    public void scrollRight(boolean z6) {
        int i5 = this.currentScreen;
        if (i5 < this.screenCount - 1) {
            scrollToScreen(i5 + 1, z6);
        }
    }

    public void scrollToScreen(final int i5, final boolean z6) {
        post(new Runnable() { // from class: com.mob.tools.gui.MobViewPager.2
            @Override // java.lang.Runnable
            public void run() {
                MobViewPager.this.scrollToScreenOnUIThread(i5, z6);
            }
        });
    }

    public void setAdapter(ViewPagerAdapter viewPagerAdapter) {
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 != null) {
            viewPagerAdapter2.setMobViewPager(null);
        }
        this.adapter = viewPagerAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.setMobViewPager(this);
        }
        if (viewPagerAdapter == null) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        int count = viewPagerAdapter.getCount();
        this.screenCount = count;
        if (count <= 0) {
            this.currentScreen = 0;
            removeAllViews();
            return;
        }
        if (count <= this.currentScreen) {
            scrollToScreenOnUIThread(count - 1, true);
            return;
        }
        removeAllViews();
        int i5 = this.currentScreen;
        if (i5 > 0) {
            View view = viewPagerAdapter.getView(i5 - 1, this.previousPage, this);
            this.previousPage = view;
            addView(view);
        }
        View view2 = viewPagerAdapter.getView(this.currentScreen, this.currentPage, this);
        this.currentPage = view2;
        addView(view2);
        int i6 = this.currentScreen;
        if (i6 < this.screenCount - 1) {
            View view3 = viewPagerAdapter.getView(i6 + 1, this.nextPage, this);
            this.nextPage = view3;
            addView(view3);
        }
    }

    public MobViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Deprecated
    public void scrollToScreen(int i5, boolean z6, boolean z7) {
        scrollToScreen(i5, z6);
    }

    public MobViewPager(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init(context);
    }
}
