package com.appdev.standard.page.printerlabel.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DrawingBoardView extends RelativeLayout {
    private int baseScaleHeight;
    private int baseScaleWidth;
    private int boardInitHeight;
    private int boardInitWidth;
    private BaseControlView curElement;
    private float curScale;
    private boolean disallowIntercept;
    private GestureDetector gestureDetector;
    private PrinterLabelRuleView hRule;
    private boolean hasScaled;
    long latestScaled;
    private float maxScale;
    private float minScale;
    private int ruleHeight;
    private OnScaleChangeListener scaleChangeListener;
    private ScaleGestureDetector scaleGestureDetector;
    private ImageView scaleView;
    private int scaleViewBaseHeight;
    private int scaleViewBaseWidth;
    private Scroller scroller;
    private float startX;
    private float startY;
    private TemplatePageView templateView;
    private PrinterLabelRuleView vRule;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnScaleChangeListener {
        void onScaleChanged(float f6);
    }

    public DrawingBoardView(Context context) {
        super(context);
        this.startX = 60.0f;
        this.startY = 60.0f;
        this.hRule = null;
        this.vRule = null;
        this.templateView = null;
        this.ruleHeight = 50;
        this.hasScaled = false;
        this.curScale = 1.0f;
        this.minScale = 0.5f;
        this.maxScale = 3.0f;
        this.baseScaleWidth = 0;
        this.baseScaleHeight = 0;
        this.boardInitWidth = -1;
        this.boardInitHeight = -1;
        this.scaleView = null;
        this.scaleViewBaseWidth = 0;
        this.scaleViewBaseHeight = 0;
        this.latestScaled = System.currentTimeMillis();
        this.disallowIntercept = false;
        this.curElement = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyScaleChanged() {
        OnScaleChangeListener onScaleChangeListener = this.scaleChangeListener;
        if (onScaleChangeListener != null) {
            onScaleChangeListener.onScaleChanged(this.curScale);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean performScaling(float f6) {
        if (this.templateView == null) {
            p051j0.a.d("DrawingBoardView", "templateView is null");
            return false;
        }
        this.hasScaled = true;
        p051j0.a.k("DrawingBoardView", "performScaling scaleFactor:" + f6);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.templateView.getLayoutParams();
        if (this.baseScaleWidth <= 0 || this.baseScaleHeight <= 0) {
            this.baseScaleWidth = layoutParams.width;
            this.baseScaleHeight = layoutParams.height;
            p051j0.a.k("DrawingBoardView", "Initialized baseScaleWidth:" + this.baseScaleWidth + ", baseScaleHeight:" + this.baseScaleHeight);
        }
        float f7 = this.curScale;
        float f8 = f6 * f7;
        if (f8 < 0.5f && f7 != 0.5f) {
            f8 = 0.5f;
        }
        if (f8 > 3.0f && f7 != 3.0f) {
            f8 = 3.0f;
        }
        if (f8 < this.minScale || f8 > this.maxScale) {
            p051j0.a.k("DrawingBoardView", "Scale out of bounds: " + f8);
            return false;
        }
        this.curScale = f8;
        int i5 = (int) (this.baseScaleWidth * f8);
        this.templateView.scaleTo(i5, (this.templateView.getLabelHeightMM() * i5) / this.templateView.getLabelWidthMM());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void upateRule() {
        TemplatePageView templatePageView = this.templateView;
        if (templatePageView != null) {
            float bgWidth = templatePageView.getBgWidth() / this.templateView.getLabelWidthMM();
            this.hRule.updateRule((-(this.startX - 60.0f)) / bgWidth, bgWidth);
            float bgHeight = this.templateView.getBgHeight() / this.templateView.getLabelHeightMM();
            this.vRule.updateRule((-(this.startY - 60.0f)) / bgHeight, bgHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRule(int i5, int i6) {
        TemplatePageView templatePageView = this.templateView;
        if (templatePageView != null) {
            float labelWidthMM = i5 / templatePageView.getLabelWidthMM();
            this.hRule.updateRule((-(this.startX - 60.0f)) / labelWidthMM, labelWidthMM);
            this.hRule.bringToFront();
            float labelHeightMM = i6 / this.templateView.getLabelHeightMM();
            this.vRule.updateRule((-(this.startY - 60.0f)) / labelHeightMM, labelHeightMM);
            this.vRule.bringToFront();
        }
    }

    public void addRule() {
        setClipChildren(false);
        PrinterLabelRuleView printerLabelRuleView = this.hRule;
        if (printerLabelRuleView != null) {
            removeView(printerLabelRuleView);
            this.hRule = null;
        }
        PrinterLabelRuleView printerLabelRuleView2 = this.vRule;
        if (printerLabelRuleView2 != null) {
            removeView(printerLabelRuleView2);
            this.vRule = null;
        }
        PrinterLabelRuleView printerLabelRuleView3 = new PrinterLabelRuleView(getContext(), 0, 0, -1, this.ruleHeight, 0.0f, 10, 1);
        this.hRule = printerLabelRuleView3;
        printerLabelRuleView3.setStartMargin(this.ruleHeight + 10);
        addView(this.hRule);
        this.hRule.bringToFront();
        Context context = getContext();
        int i5 = this.ruleHeight;
        PrinterLabelRuleView printerLabelRuleView4 = new PrinterLabelRuleView(context, 0, i5, i5, -1, 0.0f, 10, 2);
        this.vRule = printerLabelRuleView4;
        printerLabelRuleView4.setStartMargin(10);
        addView(this.vRule);
        this.hRule.bringToFront();
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.scroller;
        if (scroller == null || !scroller.computeScrollOffset()) {
            return;
        }
        this.startX = this.scroller.getCurrX();
        this.startY = this.scroller.getCurrY();
        layoutTemplateView(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        BaseControlView baseControlViewTestHitElement;
        if (this.templateView == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (motionEvent.getPointerCount() > 1 || System.currentTimeMillis() - this.latestScaled < 100) {
            this.disallowIntercept = false;
            this.curElement = null;
            return super.dispatchTouchEvent(motionEvent);
        }
        int i5 = action & 255;
        if (i5 == 0) {
            this.hasScaled = false;
            this.disallowIntercept = false;
            this.curElement = null;
            p051j0.a.k("DrawingBoardView", "requestDisallowInterceptTouchEvent disallowIntercept:false");
        }
        if (i5 == 0 && (baseControlViewTestHitElement = this.templateView.testHitElement(i5, (int) (motionEvent.getX() - this.startX), (int) (motionEvent.getY() - this.startY))) != null) {
            this.curElement = baseControlViewTestHitElement;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) baseControlViewTestHitElement.getLayoutParams();
            float x6 = motionEvent.getX();
            float y6 = motionEvent.getY();
            motionEvent.setLocation((x6 - this.startX) - marginLayoutParams.leftMargin, (y6 - this.startY) - marginLayoutParams.topMargin);
            baseControlViewTestHitElement.dispatchTouchEvent(motionEvent);
            motionEvent.setLocation(x6, y6);
            return true;
        }
        BaseControlView baseControlView = this.curElement;
        if (baseControlView == null || !this.disallowIntercept) {
            this.curElement = null;
            return super.dispatchTouchEvent(motionEvent);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) baseControlView.getLayoutParams();
        float x7 = motionEvent.getX();
        float y7 = motionEvent.getY();
        motionEvent.setLocation((x7 - this.startX) - marginLayoutParams2.leftMargin, (y7 - this.startY) - marginLayoutParams2.topMargin);
        this.curElement.dispatchTouchEvent(motionEvent);
        motionEvent.setLocation(x7, y7);
        return true;
    }

    public void layoutTemplateView(float f6) {
        TemplatePageView templatePageView = this.templateView;
        if (templatePageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) templatePageView.getLayoutParams();
            int i5 = layoutParams.width;
            if (i5 * f6 >= 300.0f || layoutParams.height * f6 >= 300.0f) {
                TemplatePageView templatePageView2 = this.templateView;
                templatePageView2.move((int) this.startX, (int) this.startY, (int) (i5 * f6), (int) (((i5 * f6) * templatePageView2.getLabelHeightMM()) / this.templateView.getLabelWidthMM()));
            }
        }
    }

    public void moveToDefaultPosition() {
        if (this.boardInitWidth <= 0 || this.boardInitHeight <= 0) {
            this.boardInitWidth = getWidth() - 60;
            this.boardInitHeight = getHeight() - 60;
        }
        float labelWidthMM = this.templateView.getLabelWidthMM() / this.templateView.getLabelHeightMM();
        int i5 = this.boardInitWidth;
        int i6 = this.boardInitHeight;
        if (labelWidthMM >= i5 / i6) {
            this.startX = 60.0f;
            this.startY = 60.0f;
            this.templateView.move((int) 60.0f, (int) 60.0f);
        } else {
            float fB = AbstractC0157z.b(i5, (int) (i6 * labelWidthMM), 2, 60);
            this.startX = fB;
            this.startY = 60.0f;
            this.templateView.move((int) fB, (int) 60.0f);
        }
    }

    public void moveToDefaultRect() {
        if (this.boardInitWidth <= 0 || this.boardInitHeight <= 0) {
            this.boardInitWidth = getWidth() - 60;
            this.boardInitHeight = getHeight() - 60;
        }
        float labelWidthMM = this.templateView.getLabelWidthMM() / this.templateView.getLabelHeightMM();
        int i5 = this.boardInitWidth;
        int i6 = this.boardInitHeight;
        if (labelWidthMM < i5 / i6) {
            int i7 = (int) (i6 * labelWidthMM);
            float fB = AbstractC0157z.b(i5, i7, 2, 60);
            this.startX = fB;
            this.templateView.move((int) fB, (int) this.startY, i7, i6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.appdev.standard.page.printerlabel.widget.DrawingBoardView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
                if (DrawingBoardView.this.hasScaled) {
                    return true;
                }
                DrawingBoardView.this.startX -= f6;
                DrawingBoardView.this.startY -= f7;
                if (DrawingBoardView.this.templateView != null) {
                    DrawingBoardView.this.templateView.move((int) DrawingBoardView.this.startX, (int) DrawingBoardView.this.startY);
                }
                DrawingBoardView.this.upateRule();
                return true;
            }
        });
        this.scroller = new Scroller(getContext());
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.appdev.standard.page.printerlabel.widget.DrawingBoardView.2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                p051j0.a.k("DrawingBoardView", "onScale scaleFactor:" + scaleFactor);
                return DrawingBoardView.this.performScaling(scaleFactor);
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                p051j0.a.k("DrawingBoardView", "onScaleBegin");
                if (DrawingBoardView.this.templateView == null) {
                    return true;
                }
                DrawingBoardView.this.templateView.updateRealSize();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                p051j0.a.k("DrawingBoardView", "onScaleEnd");
                DrawingBoardView.this.notifyScaleChanged();
            }
        });
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if (childAt instanceof TemplatePageView) {
                TemplatePageView templatePageView = (TemplatePageView) childAt;
                this.templateView = templatePageView;
                templatePageView.setEventListener(new TemplatePageView.TemplatePageViewEvent() { // from class: com.appdev.standard.page.printerlabel.widget.DrawingBoardView.3
                    @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.TemplatePageViewEvent
                    public void onLabelSizeChanged(int i6, int i7) {
                        DrawingBoardView.this.upateRule();
                    }

                    @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.TemplatePageViewEvent
                    public void onLoadComplete() {
                        DrawingBoardView.this.addRule();
                        DrawingBoardView.this.upateRule();
                        DrawingBoardView.this.moveToDefaultRect();
                    }

                    @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.TemplatePageViewEvent
                    public void onViewSizeChanged(int i6, int i7) {
                        DrawingBoardView.this.updateRule(i6, i7);
                    }
                });
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.templateView.getLayoutParams();
                layoutParams.leftMargin = (int) this.startX;
                layoutParams.topMargin = (int) this.startY;
                layoutParams.rightMargin = 10;
                this.templateView.setLayoutParams(layoutParams);
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.gestureDetector == null || this.templateView == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gestureDetector == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() <= 1 && System.currentTimeMillis() - this.latestScaled >= 100) {
            this.gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
        this.latestScaled = System.currentTimeMillis();
        this.scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z6) {
        super.requestDisallowInterceptTouchEvent(z6);
        this.disallowIntercept = true;
        p051j0.a.k("DrawingBoardView", "requestDisallowInterceptTouchEvent disallowIntercept:" + z6);
    }

    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.scaleChangeListener = onScaleChangeListener;
    }

    public void setScale(float f6) {
        if (f6 <= 0.0f) {
            p051j0.a.d("DrawingBoardView", "Invalid scale value: " + f6);
        } else {
            TemplatePageView templatePageView = this.templateView;
            if (templatePageView != null) {
                templatePageView.updateRealSize();
            }
            if (performScaling(f6 / this.curScale)) {
                notifyScaleChanged();
            }
        }
    }

    public DrawingBoardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startX = 60.0f;
        this.startY = 60.0f;
        this.hRule = null;
        this.vRule = null;
        this.templateView = null;
        this.ruleHeight = 50;
        this.hasScaled = false;
        this.curScale = 1.0f;
        this.minScale = 0.5f;
        this.maxScale = 3.0f;
        this.baseScaleWidth = 0;
        this.baseScaleHeight = 0;
        this.boardInitWidth = -1;
        this.boardInitHeight = -1;
        this.scaleView = null;
        this.scaleViewBaseWidth = 0;
        this.scaleViewBaseHeight = 0;
        this.latestScaled = System.currentTimeMillis();
        this.disallowIntercept = false;
        this.curElement = null;
    }

    public DrawingBoardView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.startX = 60.0f;
        this.startY = 60.0f;
        this.hRule = null;
        this.vRule = null;
        this.templateView = null;
        this.ruleHeight = 50;
        this.hasScaled = false;
        this.curScale = 1.0f;
        this.minScale = 0.5f;
        this.maxScale = 3.0f;
        this.baseScaleWidth = 0;
        this.baseScaleHeight = 0;
        this.boardInitWidth = -1;
        this.boardInitHeight = -1;
        this.scaleView = null;
        this.scaleViewBaseWidth = 0;
        this.scaleViewBaseHeight = 0;
        this.latestScaled = System.currentTimeMillis();
        this.disallowIntercept = false;
        this.curElement = null;
    }

    public DrawingBoardView(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.startX = 60.0f;
        this.startY = 60.0f;
        this.hRule = null;
        this.vRule = null;
        this.templateView = null;
        this.ruleHeight = 50;
        this.hasScaled = false;
        this.curScale = 1.0f;
        this.minScale = 0.5f;
        this.maxScale = 3.0f;
        this.baseScaleWidth = 0;
        this.baseScaleHeight = 0;
        this.boardInitWidth = -1;
        this.boardInitHeight = -1;
        this.scaleView = null;
        this.scaleViewBaseWidth = 0;
        this.scaleViewBaseHeight = 0;
        this.latestScaled = System.currentTimeMillis();
        this.disallowIntercept = false;
        this.curElement = null;
    }
}
