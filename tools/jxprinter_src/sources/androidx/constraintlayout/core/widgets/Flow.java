package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i5;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i6;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i5 = this.mCount;
            for (int i6 = 0; i6 < i5 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i7 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i7 = 0;
                    }
                    this.mWidth = width + i7 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i8 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i8 = 0;
                    }
                    this.mHeight = widgetHeight2 + i8 + this.mHeight;
                    if (this.mBiggest == null || this.mBiggestDimension < widgetWidth) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.mBiggest == null || this.mBiggestDimension < widgetWidth2) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z6, int i5, boolean z7) {
            ConstraintWidget constraintWidget;
            int i6;
            char c;
            float f6;
            float f7;
            int i7 = this.mCount;
            for (int i8 = 0; i8 < i7 && this.mStartIndex + i8 < Flow.this.mDisplayedWidgetsCount; i8++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i8];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i7 == 0 || this.mBiggest == null) {
                return;
            }
            boolean z8 = z7 && i5 == 0;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = z6 ? (i7 - 1) - i11 : i11;
                if (this.mStartIndex + i12 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                ConstraintWidget constraintWidget3 = Flow.this.mDisplayedWidgets[this.mStartIndex + i12];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() == 0) {
                    if (i9 == -1) {
                        i9 = i11;
                    }
                    i10 = i11;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget5 = this.mBiggest;
                constraintWidget5.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i13 = this.mPaddingLeft;
                if (i5 > 0) {
                    i13 += Flow.this.mHorizontalGap;
                }
                if (z6) {
                    constraintWidget5.mRight.connect(this.mRight, i13);
                    if (z7) {
                        constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i5 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget5.mRight, 0);
                    }
                } else {
                    constraintWidget5.mLeft.connect(this.mLeft, i13);
                    if (z7) {
                        constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i5 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget5.mLeft, 0);
                    }
                }
                for (int i14 = 0; i14 < i7 && this.mStartIndex + i14 < Flow.this.mDisplayedWidgetsCount; i14++) {
                    ConstraintWidget constraintWidget6 = Flow.this.mDisplayedWidgets[this.mStartIndex + i14];
                    if (constraintWidget6 != null) {
                        if (i14 == 0) {
                            constraintWidget6.connect(constraintWidget6.mTop, this.mTop, this.mPaddingTop);
                            int i15 = Flow.this.mVerticalStyle;
                            float f8 = Flow.this.mVerticalBias;
                            if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                                i15 = Flow.this.mFirstVerticalStyle;
                                f8 = Flow.this.mFirstVerticalBias;
                            } else if (z7 && Flow.this.mLastVerticalStyle != -1) {
                                i15 = Flow.this.mLastVerticalStyle;
                                f8 = Flow.this.mLastVerticalBias;
                            }
                            constraintWidget6.setVerticalChainStyle(i15);
                            constraintWidget6.setVerticalBiasPercent(f8);
                        }
                        if (i14 == i7 - 1) {
                            constraintWidget6.connect(constraintWidget6.mBottom, this.mBottom, this.mPaddingBottom);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                            if (i14 == i9) {
                                constraintWidget6.mTop.setGoneMargin(this.mPaddingTop);
                            }
                            constraintWidget4.mBottom.connect(constraintWidget6.mTop, 0);
                            if (i14 == i10 + 1) {
                                constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                            }
                        }
                        if (constraintWidget6 != constraintWidget5) {
                            if (z6) {
                                int i16 = Flow.this.mHorizontalAlign;
                                if (i16 == 0) {
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                } else if (i16 == 1) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                } else if (i16 == 2) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                }
                            } else {
                                int i17 = Flow.this.mHorizontalAlign;
                                if (i17 == 0) {
                                    constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                } else if (i17 == 1) {
                                    constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                } else if (i17 == 2) {
                                    if (z8) {
                                        constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                                    } else {
                                        constraintWidget6.mLeft.connect(constraintWidget5.mLeft, 0);
                                        constraintWidget6.mRight.connect(constraintWidget5.mRight, 0);
                                    }
                                }
                            }
                        }
                        constraintWidget4 = constraintWidget6;
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.mBiggest;
            constraintWidget7.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i18 = this.mPaddingTop;
            if (i5 > 0) {
                i18 += Flow.this.mVerticalGap;
            }
            constraintWidget7.mTop.connect(this.mTop, i18);
            if (z7) {
                constraintWidget7.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i5 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget7.mTop, 0);
            }
            char c6 = 3;
            if (Flow.this.mVerticalAlign != 3 || constraintWidget7.hasBaseline()) {
                constraintWidget = constraintWidget7;
                break;
            }
            int i19 = 0;
            while (true) {
                if (i19 < i7) {
                    int i20 = z6 ? (i7 - 1) - i19 : i19;
                    if (this.mStartIndex + i20 < Flow.this.mDisplayedWidgetsCount) {
                        constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i20];
                        if (constraintWidget.hasBaseline()) {
                            break;
                        } else {
                            i19++;
                        }
                    }
                }
                constraintWidget = constraintWidget7;
                break;
            }
            int i21 = 0;
            while (i21 < i7) {
                int i22 = z6 ? (i7 - 1) - i21 : i21;
                if (this.mStartIndex + i22 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.mDisplayedWidgets[this.mStartIndex + i22];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c = c6;
                } else {
                    if (i21 == 0) {
                        i6 = 1;
                        constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                    } else {
                        i6 = 1;
                    }
                    if (i22 == 0) {
                        int i23 = Flow.this.mHorizontalStyle;
                        float f9 = Flow.this.mHorizontalBias;
                        if (z6) {
                            f9 = 1.0f - f9;
                        }
                        if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                            i23 = Flow.this.mFirstHorizontalStyle;
                            if (z6) {
                                f7 = Flow.this.mFirstHorizontalBias;
                                f6 = 1.0f - f7;
                            } else {
                                f6 = Flow.this.mFirstHorizontalBias;
                            }
                            f9 = f6;
                        } else if (z7 && Flow.this.mLastHorizontalStyle != -1) {
                            i23 = Flow.this.mLastHorizontalStyle;
                            if (z6) {
                                f7 = Flow.this.mLastHorizontalBias;
                                f6 = 1.0f - f7;
                            } else {
                                f6 = Flow.this.mLastHorizontalBias;
                            }
                            f9 = f6;
                        }
                        constraintWidget8.setHorizontalChainStyle(i23);
                        constraintWidget8.setHorizontalBiasPercent(f9);
                    }
                    if (i21 == i7 - 1) {
                        constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.mLeft.connect(constraintWidget4.mRight, Flow.this.mHorizontalGap);
                        if (i21 == i9) {
                            constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                        }
                        constraintWidget4.mRight.connect(constraintWidget8.mLeft, 0);
                        if (i21 == i10 + 1) {
                            constraintWidget4.mRight.setGoneMargin(this.mPaddingRight);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c = 3;
                        if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                            constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                        } else {
                            int i24 = Flow.this.mVerticalAlign;
                            if (i24 == 0) {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                            } else if (i24 == i6) {
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            } else if (z8) {
                                constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                                constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                            } else {
                                constraintWidget8.mTop.connect(constraintWidget7.mTop, 0);
                                constraintWidget8.mBottom.connect(constraintWidget7.mBottom, 0);
                            }
                        }
                    } else {
                        c = 3;
                    }
                }
                i21++;
                c6 = c;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i5) {
            int i6 = this.mNbMatchConstraintsWidgets;
            if (i6 == 0) {
                return;
            }
            int i7 = this.mCount;
            int i8 = i5 / i6;
            for (int i9 = 0; i9 < i7 && this.mStartIndex + i9 < Flow.this.mDisplayedWidgetsCount; i9++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i9];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i8, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i10 = i8;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i10);
                    i8 = i10;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i5) {
            this.mStartIndex = i5;
        }

        public void setup(int i5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6, int i7, int i8, int i9, int i10) {
            this.mOrientation = i5;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i6;
            this.mPaddingTop = i7;
            this.mPaddingRight = i8;
            this.mPaddingBottom = i9;
            this.mMax = i10;
        }
    }

    private void createAlignedConstraints(boolean z6) {
        ConstraintWidget constraintWidget;
        float f6;
        int i5;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i6 = 0; i6 < this.mDisplayedWidgetsCount; i6++) {
            this.mDisplayedWidgets[i6].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i7 = iArr[0];
        int i8 = iArr[1];
        float f7 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i9 = 0;
        while (i9 < i7) {
            if (z6) {
                i5 = (i7 - i9) - 1;
                f6 = 1.0f - this.mHorizontalBias;
            } else {
                f6 = f7;
                i5 = i9;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i5];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i9 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f6);
                }
                if (i9 == i7 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i9 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i9++;
            f7 = f6;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i10];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i10 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i10 == i8 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i10 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = (i12 * i7) + i11;
                if (this.mOrientation == 1) {
                    i13 = (i11 * i8) + i12;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i13 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i13]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i11];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i12];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetHeight(ConstraintWidget constraintWidget, int i5) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (constraintWidget.mMatchConstraintPercentHeight * i5);
                if (i7 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i7);
                }
                return i7;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i6 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetWidth(ConstraintWidget constraintWidget, int i5) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (constraintWidget.mMatchConstraintPercentWidth * i5);
                if (i7 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i7, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i7;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i6 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:106:0x010f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x0117 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:117:0x011d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0115 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:119:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0059 A[ADDED_TO_REGION, EDGE_INSN: B:122:0x0059->B:42:0x0059 BREAK  A[LOOP:1: B:44:0x005c->B:124:0x005c], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:132:0x00d3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060  */
    /* JADX WARN: Code duplicated, block: B:47:0x006a  */
    /* JADX WARN: Code duplicated, block: B:50:0x0078  */
    /* JADX WARN: Code duplicated, block: B:54:0x0080  */
    /* JADX WARN: Code duplicated, block: B:57:0x0088  */
    /* JADX WARN: Code duplicated, block: B:61:0x0090  */
    /* JADX WARN: Code duplicated, block: B:64:0x0097  */
    /* JADX WARN: Code duplicated, block: B:66:0x009a  */
    /* JADX WARN: Code duplicated, block: B:68:0x009f  */
    /* JADX WARN: Code duplicated, block: B:72:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:77:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:89:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:91:0x00e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:97:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:99:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:45:0x005e
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        Flow flow;
        int i9;
        ConstraintAnchor constraintAnchor;
        int i10;
        Flow flow2 = this;
        if (i5 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i11 = i7;
        WidgetsList widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
        flow2.mChainList.add(widgetsList);
        if (i6 == 0) {
            i8 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i5) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i13];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i11);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i14 = i8;
                boolean z6 = (i12 == i11 || (flow2.mHorizontalGap + i12) + widgetWidth > i11) && widgetsList.mBiggest != null;
                if (!z6 && i13 > 0 && (i10 = flow2.mMaxElementsWrap) > 0 && i13 % i10 == 0) {
                    z6 = true;
                }
                if (z6) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
                    widgetsList.setStartIndex(i13);
                    flow2.mChainList.add(widgetsList);
                } else {
                    if (i13 > 0) {
                        i12 = flow2.mHorizontalGap + widgetWidth + i12;
                    }
                    widgetsList.add(constraintWidget);
                    i13++;
                    i8 = i14;
                }
                i12 = widgetWidth;
                widgetsList.add(constraintWidget);
                i13++;
                i8 = i14;
            }
        } else {
            i8 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i5) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i16];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i11);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i17 = i8;
                boolean z7 = (i15 == i11 || (flow2.mVerticalGap + i15) + widgetHeight > i11) && widgetsList.mBiggest != null;
                if (!z7 && i16 > 0 && (i9 = flow2.mMaxElementsWrap) > 0 && i16 % i9 == 0) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
                    flow = flow2;
                    widgetsList.setStartIndex(i16);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i16 > 0) {
                        i15 = flow.mVerticalGap + widgetHeight + i15;
                    }
                    widgetsList.add(constraintWidget2);
                    i16++;
                    i11 = i7;
                    i8 = i17;
                    flow2 = flow;
                }
                i15 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i16++;
                i11 = i7;
                i8 = i17;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z8 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i8 > 0 && z8) {
            for (int i18 = 0; i18 < size; i18++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i18);
                if (i6 == 0) {
                    widgetsList2.measureMatchConstraints(i7 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i7 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int paddingBottom2 = paddingBottom;
        int i19 = 0;
        int paddingRight2 = paddingRight;
        int i20 = paddingTop;
        int i21 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i22 = 0;
        for (int i23 = 0; i23 < size; i23++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i23);
            if (i6 == 0) {
                if (i23 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i23 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                int i24 = i22;
                widgetsList3.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i21, i20, paddingRight2, paddingBottom2, i7);
                int iMax = Math.max(i19, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i24;
                if (i23 > 0) {
                    height += flow3.mVerticalGap;
                }
                i22 = height;
                i19 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i20 = 0;
            } else {
                int i25 = i19;
                int i26 = i22;
                if (i23 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i23 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i21, i20, paddingRight2, paddingBottom2, i7);
                int width = widgetsList3.getWidth() + i25;
                int iMax2 = Math.max(i26, widgetsList3.getHeight());
                if (i23 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i27 = width;
                i22 = iMax2;
                i19 = i27;
                i21 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i19;
        iArr[1] = i22;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        Flow flow;
        int i9;
        ConstraintAnchor constraintAnchor;
        int i10;
        Flow flow2 = this;
        if (i5 == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i11 = i7;
        WidgetsList widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
        flow2.mChainList.add(widgetsList);
        boolean z6 = true;
        if (i6 == 0) {
            int i12 = 0;
            i8 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i5) {
                i12++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i14];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i11);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i15 = i8;
                boolean z7 = (i13 == i11 || (flow2.mHorizontalGap + i13) + widgetWidth > i11) && widgetsList.mBiggest != null;
                if (!z7 && i14 > 0 && (i10 = flow2.mMaxElementsWrap) > 0 && i12 > i10) {
                    z7 = true;
                }
                if (z7) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
                    widgetsList.setStartIndex(i14);
                    flow2.mChainList.add(widgetsList);
                    i12 = 1;
                } else {
                    if (i14 > 0) {
                        i13 = flow2.mHorizontalGap + widgetWidth + i13;
                    }
                    widgetsList.add(constraintWidget);
                    i14++;
                    i8 = i15;
                }
                i13 = widgetWidth;
                widgetsList.add(constraintWidget);
                i14++;
                i8 = i15;
            }
        } else {
            int i16 = 0;
            i8 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i5) {
                i16++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i18];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i11);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i19 = i8;
                boolean z8 = (i17 == i11 || (flow2.mVerticalGap + i17) + widgetHeight > i11) && widgetsList.mBiggest != null;
                if (!z8 && i18 > 0 && (i9 = flow2.mMaxElementsWrap) > 0 && i16 > i9) {
                    z8 = true;
                }
                if (z8) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i11);
                    flow = flow2;
                    widgetsList.setStartIndex(i18);
                    flow.mChainList.add(widgetsList);
                    i16 = 1;
                } else {
                    flow = flow2;
                    if (i18 > 0) {
                        i17 = flow.mVerticalGap + widgetHeight + i17;
                    }
                    widgetsList.add(constraintWidget2);
                    i18++;
                    i11 = i7;
                    i8 = i19;
                    flow2 = flow;
                }
                i17 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i18++;
                i11 = i7;
                i8 = i19;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z9 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i8 > 0 && z9) {
            for (int i20 = 0; i20 < size; i20++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i20);
                if (i6 == 0) {
                    widgetsList2.measureMatchConstraints(i7 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i7 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int paddingBottom2 = paddingBottom;
        int i21 = 0;
        int i22 = 0;
        int paddingRight2 = paddingRight;
        int i23 = paddingTop;
        int i24 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i25 = 0;
        while (i22 < size) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i22);
            if (i6 == 0) {
                if (i22 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i22 + 1).mBiggest.mTop;
                    paddingBottom2 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    paddingBottom2 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                int i26 = i21;
                widgetsList3.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i24, i23, paddingRight2, paddingBottom2, i7);
                int iMax = Math.max(i25, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i26;
                if (i22 > 0) {
                    height += flow3.mVerticalGap;
                }
                i21 = height;
                i25 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i23 = 0;
            } else {
                int i27 = i21;
                int i28 = i25;
                if (i22 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i22 + 1).mBiggest.mLeft;
                    paddingRight2 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    paddingRight2 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i24, i23, paddingRight2, paddingBottom2, i7);
                int width = widgetsList3.getWidth() + i28;
                int iMax2 = Math.max(i27, widgetsList3.getHeight());
                if (i22 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i29 = width;
                i21 = iMax2;
                i25 = i29;
                i24 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i22++;
            z6 = z6;
        }
        iArr[0] = i25;
        iArr[z6 ? 1 : 0] = i21;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i5, int i6, int i7, int[] iArr) {
        WidgetsList widgetsList;
        if (i5 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, i7);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i7);
            widgetsList = widgetsList2;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            widgetsList.add(constraintWidgetArr[i8]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z6) {
        super.addToSolver(linearSystem, z6);
        boolean z7 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i5 = this.mWrapMode;
        if (i5 != 0) {
            if (i5 == 1) {
                int size = this.mChainList.size();
                int i6 = 0;
                while (i6 < size) {
                    this.mChainList.get(i6).createConstraints(z7, i6, i6 == size + (-1));
                    i6++;
                }
            } else if (i5 == 2) {
                createAlignedConstraints(z7);
            } else if (i5 == 3) {
                int size2 = this.mChainList.size();
                int i7 = 0;
                while (i7 < size2) {
                    this.mChainList.get(i7).createConstraints(z7, i7, i7 == size2 + (-1));
                    i7++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z7, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.copy(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i5, int i6, int i7, int i8) {
        int i9;
        ConstraintWidget[] constraintWidgetArr;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i10 = (i6 - paddingLeft) - paddingRight;
        int i11 = this.mOrientation;
        if (i11 == 1) {
            i10 = (i8 - paddingTop) - paddingBottom;
        }
        int i12 = i10;
        if (i11 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i9 = this.mWidgetsCount;
            if (i13 >= i9) {
                break;
            }
            if (this.mWidgets[i13].getVisibility() == 8) {
                i14++;
            }
            i13++;
        }
        if (i14 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i9 - i14];
            int i15 = 0;
            i9 = 0;
            while (i15 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i15];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr4[i9] = constraintWidget;
                    i9++;
                }
                i15++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i16 = i9;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i16;
        int i17 = this.mWrapMode;
        if (i17 == 0) {
            measureNoWrap(constraintWidgetArr, i16, this.mOrientation, i12, iArr);
        } else if (i17 == 1) {
            measureChainWrap(constraintWidgetArr, i16, this.mOrientation, i12, iArr);
        } else if (i17 == 2) {
            measureAligned(constraintWidgetArr, i16, this.mOrientation, i12, iArr);
        } else if (i17 == 3) {
            measureChainWrap_new(constraintWidgetArr, i16, this.mOrientation, i12, iArr);
        }
        int iMin = iArr[0] + paddingLeft + paddingRight;
        int iMin2 = iArr[1] + paddingTop + paddingBottom;
        if (i5 == 1073741824) {
            iMin = i6;
        } else if (i5 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i6);
        } else if (i5 != 0) {
            iMin = 0;
        }
        if (i7 == 1073741824) {
            iMin2 = i8;
        } else if (i7 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i8);
        } else if (i7 != 0) {
            iMin2 = 0;
        }
        setMeasure(iMin, iMin2);
        setWidth(iMin);
        setHeight(iMin2);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f6) {
        this.mFirstHorizontalBias = f6;
    }

    public void setFirstHorizontalStyle(int i5) {
        this.mFirstHorizontalStyle = i5;
    }

    public void setFirstVerticalBias(float f6) {
        this.mFirstVerticalBias = f6;
    }

    public void setFirstVerticalStyle(int i5) {
        this.mFirstVerticalStyle = i5;
    }

    public void setHorizontalAlign(int i5) {
        this.mHorizontalAlign = i5;
    }

    public void setHorizontalBias(float f6) {
        this.mHorizontalBias = f6;
    }

    public void setHorizontalGap(int i5) {
        this.mHorizontalGap = i5;
    }

    public void setHorizontalStyle(int i5) {
        this.mHorizontalStyle = i5;
    }

    public void setLastHorizontalBias(float f6) {
        this.mLastHorizontalBias = f6;
    }

    public void setLastHorizontalStyle(int i5) {
        this.mLastHorizontalStyle = i5;
    }

    public void setLastVerticalBias(float f6) {
        this.mLastVerticalBias = f6;
    }

    public void setLastVerticalStyle(int i5) {
        this.mLastVerticalStyle = i5;
    }

    public void setMaxElementsWrap(int i5) {
        this.mMaxElementsWrap = i5;
    }

    public void setOrientation(int i5) {
        this.mOrientation = i5;
    }

    public void setVerticalAlign(int i5) {
        this.mVerticalAlign = i5;
    }

    public void setVerticalBias(float f6) {
        this.mVerticalBias = f6;
    }

    public void setVerticalGap(int i5) {
        this.mVerticalGap = i5;
    }

    public void setVerticalStyle(int i5) {
        this.mVerticalStyle = i5;
    }

    public void setWrapMode(int i5) {
        this.mWrapMode = i5;
    }
}
