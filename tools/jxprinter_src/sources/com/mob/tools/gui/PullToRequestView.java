package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes3.dex */
public class PullToRequestView extends RelativeLayout {
    private static final int FAULT_TOLERANCE_RANGE = 10;
    private static final long MIN_REF_TIME = 1000;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    public PullToRequestView(Context context) {
        super(context);
        init();
    }

    private boolean canPullDown() {
        return !this.pullingDownLock && this.adapter.isPullDownReady() && this.state == 0;
    }

    private boolean canPullUp() {
        return !this.pullingUpLock && this.adapter.isPullUpReady() && this.state == 0;
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        return MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), 3, motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    private void init() {
        this.stopAct = new Runnable() { // from class: com.mob.tools.gui.PullToRequestView.1
            @Override // java.lang.Runnable
            public void run() {
                PullToRequestView.this.reversePulling();
            }
        };
    }

    private void performRequestNext() {
        this.pullTime = System.currentTimeMillis();
        this.state = -1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRequestNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reversePulling() {
        this.top = 0;
        scrollTo(0, 0);
        this.state = 0;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onReversed();
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    /* JADX WARN: Code duplicated, block: B:70:0x012a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0130  */
    /* JADX WARN: Code duplicated, block: B:74:0x013a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0145  */
    /* JADX WARN: Code duplicated, block: B:78:0x014a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0155  */
    /* JADX WARN: Code duplicated, block: B:82:0x0160 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0162  */
    /* JADX WARN: Code duplicated, block: B:85:0x0169  */
    /* JADX WARN: Code duplicated, block: B:87:0x016d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0171  */
    /* JADX WARN: Code duplicated, block: B:90:0x0177  */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i5;
        int i6;
        int i7;
        int i8;
        PullToRequestAdatper pullToRequestAdatper;
        PullToRequestAdatper pullToRequestAdatper2;
        PullToRequestAdatper pullToRequestAdatper3;
        int i9;
        int i10;
        int i11;
        int i12;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downY = motionEvent.getY();
        } else if (action == 1) {
            i5 = this.state;
            if (i5 != -1) {
                int i13 = -this.footerHeight;
                this.top = i13;
                scrollTo(0, -i13);
            } else if (i5 != 0) {
                i6 = this.top;
                i7 = this.headerHeight;
                if (i6 > i7) {
                    this.top = i7;
                    scrollTo(0, -i7);
                    pullToRequestAdatper3 = this.adapter;
                    if (pullToRequestAdatper3 != null) {
                        pullToRequestAdatper3.onPullDown(100);
                    }
                    performFresh();
                    motionEvent = getCancelEvent(motionEvent);
                } else {
                    i8 = this.footerHeight;
                    if (i6 < (-i8)) {
                        int i14 = -i8;
                        this.top = i14;
                        scrollTo(0, -i14);
                        pullToRequestAdatper2 = this.adapter;
                        if (pullToRequestAdatper2 != null) {
                            pullToRequestAdatper2.onPullUp(100);
                        }
                        performRequestNext();
                        motionEvent = getCancelEvent(motionEvent);
                    } else if (i6 != 0) {
                        scrollTo(0, 0);
                        pullToRequestAdatper = this.adapter;
                        if (pullToRequestAdatper != null) {
                            if (this.top > 0) {
                                pullToRequestAdatper.onPullDown(0);
                            } else {
                                pullToRequestAdatper.onPullUp(0);
                            }
                        }
                        this.top = 0;
                    }
                }
            } else if (i5 == 1) {
                int i15 = this.headerHeight;
                this.top = i15;
                scrollTo(0, -i15);
            }
        } else if (action == 2) {
            float y6 = motionEvent.getY();
            int i16 = this.state;
            if (i16 == -1) {
                int i17 = (int) (((y6 - this.downY) / 2.0f) + this.top);
                this.top = i17;
                if (i17 > 0) {
                    this.top = 0;
                }
                scrollTo(0, -this.top);
                motionEvent = getCancelEvent(motionEvent);
            } else if (i16 != 1) {
                int i18 = this.top;
                if (i18 > 0) {
                    int i19 = (int) (((y6 - this.downY) / 2.0f) + i18);
                    this.top = i19;
                    if (i19 < 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    PullToRequestAdatper pullToRequestAdatper4 = this.adapter;
                    if (pullToRequestAdatper4 != null && (i12 = this.headerHeight) != 0) {
                        pullToRequestAdatper4.onPullDown((this.top * 100) / i12);
                    }
                    motionEvent = getCancelEvent(motionEvent);
                } else if (i18 < 0) {
                    int i20 = (int) (((y6 - this.downY) / 2.0f) + i18);
                    this.top = i20;
                    if (i20 > 0) {
                        this.top = 0;
                    }
                    scrollTo(0, -this.top);
                    PullToRequestAdatper pullToRequestAdatper5 = this.adapter;
                    if (pullToRequestAdatper5 != null && (i11 = this.footerHeight) != 0) {
                        pullToRequestAdatper5.onPullUp(((-this.top) * 100) / i11);
                    }
                    motionEvent = getCancelEvent(motionEvent);
                } else {
                    float f6 = this.downY;
                    if (y6 - f6 > 10.0f) {
                        if (canPullDown()) {
                            int i21 = (int) (((y6 - this.downY) / 2.0f) + this.top);
                            this.top = i21;
                            scrollTo(0, -i21);
                            PullToRequestAdatper pullToRequestAdatper6 = this.adapter;
                            if (pullToRequestAdatper6 != null && (i10 = this.headerHeight) != 0) {
                                pullToRequestAdatper6.onPullUp(((-this.top) * 100) / i10);
                            }
                            motionEvent = getCancelEvent(motionEvent);
                        }
                    } else if (f6 - y6 > 10.0f && canPullUp()) {
                        int i22 = (int) (((y6 - this.downY) / 2.0f) + this.top);
                        this.top = i22;
                        scrollTo(0, -i22);
                        PullToRequestAdatper pullToRequestAdatper7 = this.adapter;
                        if (pullToRequestAdatper7 != null && (i9 = this.footerHeight) != 0) {
                            pullToRequestAdatper7.onPullUp(((-this.top) * 100) / i9);
                        }
                        motionEvent = getCancelEvent(motionEvent);
                    }
                }
            } else {
                int i23 = (int) (((y6 - this.downY) / 2.0f) + this.top);
                this.top = i23;
                if (i23 < 0) {
                    this.top = 0;
                }
                scrollTo(0, -this.top);
                motionEvent = getCancelEvent(motionEvent);
            }
            this.downY = y6;
        } else if (action == 3) {
            i5 = this.state;
            if (i5 != -1) {
                int i110 = -this.footerHeight;
                this.top = i110;
                scrollTo(0, -i110);
            } else if (i5 != 0) {
                i6 = this.top;
                i7 = this.headerHeight;
                if (i6 > i7) {
                    this.top = i7;
                    scrollTo(0, -i7);
                    pullToRequestAdatper3 = this.adapter;
                    if (pullToRequestAdatper3 != null) {
                        pullToRequestAdatper3.onPullDown(100);
                    }
                    performFresh();
                    motionEvent = getCancelEvent(motionEvent);
                } else {
                    i8 = this.footerHeight;
                    if (i6 < (-i8)) {
                        int i111 = -i8;
                        this.top = i111;
                        scrollTo(0, -i111);
                        pullToRequestAdatper2 = this.adapter;
                        if (pullToRequestAdatper2 != null) {
                            pullToRequestAdatper2.onPullUp(100);
                        }
                        performRequestNext();
                        motionEvent = getCancelEvent(motionEvent);
                    } else if (i6 != 0) {
                        scrollTo(0, 0);
                        pullToRequestAdatper = this.adapter;
                        if (pullToRequestAdatper != null) {
                            if (this.top > 0) {
                                pullToRequestAdatper.onPullDown(0);
                            } else {
                                pullToRequestAdatper.onPullUp(0);
                            }
                        }
                        this.top = 0;
                    }
                }
            } else if (i5 == 1) {
                int i112 = this.headerHeight;
                this.top = i112;
                scrollTo(0, -i112);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void performFresh() {
        this.pullTime = System.currentTimeMillis();
        this.state = 1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRefresh();
        }
    }

    public void performPullingDown(boolean z6) {
        int i5 = this.headerHeight;
        this.top = i5;
        scrollTo(0, -i5);
        if (z6) {
            performFresh();
        }
    }

    public void performPullingUp(boolean z6) {
        int i5 = -this.footerHeight;
        this.top = i5;
        scrollTo(0, -i5);
        if (z6) {
            performRequestNext();
        }
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        this.adapter = pullToRequestAdatper;
        removeAllViews();
        this.bodyView = (View) pullToRequestAdatper.getBodyView();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(9);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.bodyView, layoutParams);
        View headerView = pullToRequestAdatper.getHeaderView();
        this.headerView = headerView;
        headerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.headerView.measure(0, 0);
        this.headerHeight = this.headerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.topMargin = -this.headerHeight;
        addView(this.headerView, layoutParams2);
        View footerView = pullToRequestAdatper.getFooterView();
        this.footerView = footerView;
        footerView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.footerView.measure(0, 0);
        this.footerHeight = this.footerView.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, this.headerHeight);
        layoutParams3.addRule(9);
        layoutParams3.addRule(11);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = -this.headerHeight;
        addView(this.footerView, layoutParams3);
    }

    public void stopPulling() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.pullTime;
        if (jCurrentTimeMillis < MIN_REF_TIME) {
            postDelayed(this.stopAct, MIN_REF_TIME - jCurrentTimeMillis);
        } else {
            post(this.stopAct);
        }
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        init();
    }
}
