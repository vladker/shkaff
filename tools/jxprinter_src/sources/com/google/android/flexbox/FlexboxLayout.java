package com.google.android.flexbox;

import A3.AbstractC0157z;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;

    @Nullable
    private Drawable mDividerDrawableHorizontal;

    @Nullable
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private boolean allFlexLinesAreDummyBefore(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (this.mFlexLines.get(i6).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean allViewsAreGoneBefore(int i5, int i6) {
        for (int i7 = 1; i7 <= i6; i7++) {
            View reorderedChildAt = getReorderedChildAt(i5 - i7);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void drawDividersHorizontal(Canvas canvas, boolean z6, boolean z7) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            FlexLine flexLine = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < flexLine.mItemCount; i6++) {
                int i7 = flexLine.mFirstIndex + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        drawVerticalDivider(canvas, z6 ? reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (i6 == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        drawVerticalDivider(canvas, z6 ? (reorderedChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerVerticalWidth : reorderedChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, flexLine.mTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                drawHorizontalDivider(canvas, paddingLeft, z7 ? flexLine.mBottom : flexLine.mTop - this.mDividerHorizontalHeight, iMax);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerHorizontal & 4) > 0) {
                drawHorizontalDivider(canvas, paddingLeft, z7 ? flexLine.mTop - this.mDividerHorizontalHeight : flexLine.mBottom, iMax);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean z6, boolean z7) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i5 = 0; i5 < size; i5++) {
            FlexLine flexLine = this.mFlexLines.get(i5);
            for (int i6 = 0; i6 < flexLine.mItemCount; i6++) {
                int i7 = flexLine.mFirstIndex + i6;
                View reorderedChildAt = getReorderedChildAt(i7);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i7, i6)) {
                        drawHorizontalDivider(canvas, flexLine.mLeft, z7 ? reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight, flexLine.mCrossSize);
                    }
                    if (i6 == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        drawHorizontalDivider(canvas, flexLine.mLeft, z7 ? (reorderedChildAt.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.mDividerHorizontalHeight : reorderedChildAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i5)) {
                drawVerticalDivider(canvas, z6 ? flexLine.mRight : flexLine.mLeft - this.mDividerVerticalWidth, paddingTop, iMax);
            }
            if (hasEndDividerAfterFlexLine(i5) && (this.mShowDividerVertical & 4) > 0) {
                drawVerticalDivider(canvas, z6 ? flexLine.mLeft - this.mDividerVerticalWidth : flexLine.mRight, paddingTop, iMax);
            }
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int i5, int i6, int i7) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i5, i6, i7 + i5, this.mDividerHorizontalHeight + i6);
        this.mDividerDrawableHorizontal.draw(canvas);
    }

    private void drawVerticalDivider(Canvas canvas, int i5, int i6, int i7) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i5, i6, this.mDividerVerticalWidth + i5, i7 + i6);
        this.mDividerDrawableVertical.draw(canvas);
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int i5, int i6) {
        if (allViewsAreGoneBefore(i5, i6)) {
            if (isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerVertical & 1) != 0;
            }
            return (this.mShowDividerHorizontal & 1) != 0;
        }
        if (isMainAxisDirectionHorizontal()) {
            return (this.mShowDividerVertical & 2) != 0;
        }
        return (this.mShowDividerHorizontal & 2) != 0;
    }

    private boolean hasDividerBeforeFlexLine(int i5) {
        if (i5 >= 0 && i5 < this.mFlexLines.size()) {
            if (allFlexLinesAreDummyBefore(i5)) {
                if (isMainAxisDirectionHorizontal()) {
                    return (this.mShowDividerHorizontal & 1) != 0;
                }
                return (this.mShowDividerVertical & 1) != 0;
            }
            if (isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerHorizontal & 2) != 0;
            }
            if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean hasEndDividerAfterFlexLine(int i5) {
        if (i5 >= 0 && i5 < this.mFlexLines.size()) {
            for (int i6 = i5 + 1; i6 < this.mFlexLines.size(); i6++) {
                if (this.mFlexLines.get(i6).getItemCountNotGone() > 0) {
                    return false;
                }
            }
            if (isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerHorizontal & 4) != 0;
            }
            if ((this.mShowDividerVertical & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:49:0x0108  */
    /* JADX WARN: Code duplicated, block: B:51:0x0112  */
    /* JADX WARN: Code duplicated, block: B:57:0x0126  */
    /* JADX WARN: Code duplicated, block: B:60:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x012e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0156  */
    /* JADX WARN: Code duplicated, block: B:64:0x017a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0188  */
    /* JADX WARN: Code duplicated, block: B:67:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f2  */
    private void layoutHorizontal(boolean z6, int i5, int i6, int i7, int i8) {
        float measuredWidth;
        float f6;
        float f7;
        float fMax;
        int i9;
        int i10;
        View reorderedChildAt;
        boolean z7;
        int i11;
        int i12;
        float f8;
        float f9;
        int i13;
        float f10;
        int i14;
        View view;
        FlexLine flexLine;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i15 = i7 - i5;
        int paddingBottom = (i8 - i6) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.mFlexLines.size();
        for (int i16 = 0; i16 < size; i16++) {
            FlexLine flexLine2 = this.mFlexLines.get(i16);
            if (hasDividerBeforeFlexLine(i16)) {
                int i17 = this.mDividerHorizontalHeight;
                paddingBottom -= i17;
                paddingTop += i17;
            }
            int i18 = paddingBottom;
            int i19 = this.mJustifyContent;
            char c = 4;
            int i20 = 2;
            boolean z8 = true;
            if (i19 == 0) {
                measuredWidth = paddingLeft;
                f6 = i15 - paddingRight;
            } else if (i19 != 1) {
                if (i19 == 2) {
                    int i21 = flexLine2.mMainSize;
                    measuredWidth = paddingLeft + ((i15 - i21) / 2.0f);
                    f6 = (i15 - paddingRight) - ((i15 - i21) / 2.0f);
                } else if (i19 == 3) {
                    measuredWidth = paddingLeft;
                    int itemCountNotGone = flexLine2.getItemCountNotGone();
                    f7 = (i15 - flexLine2.mMainSize) / (itemCountNotGone != 1 ? itemCountNotGone - 1 : 1.0f);
                    f6 = i15 - paddingRight;
                } else if (i19 == 4) {
                    int itemCountNotGone2 = flexLine2.getItemCountNotGone();
                    float f11 = itemCountNotGone2 != 0 ? (i15 - flexLine2.mMainSize) / itemCountNotGone2 : 0.0f;
                    float f12 = f11 / 2.0f;
                    measuredWidth = paddingLeft + f12;
                    float f13 = (i15 - paddingRight) - f12;
                    f7 = f11;
                    f6 = f13;
                } else {
                    if (i19 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                    }
                    int itemCountNotGone3 = flexLine2.getItemCountNotGone();
                    f7 = itemCountNotGone3 != 0 ? (i15 - flexLine2.mMainSize) / (itemCountNotGone3 + 1) : 0.0f;
                    measuredWidth = paddingLeft + f7;
                    f6 = (i15 - paddingRight) - f7;
                }
                fMax = Math.max(f7, 0.0f);
                i9 = 0;
                while (i9 < flexLine2.mItemCount) {
                    i10 = flexLine2.mFirstIndex + i9;
                    reorderedChildAt = getReorderedChildAt(i10);
                    char c6 = c;
                    if (reorderedChildAt != null) {
                        z7 = z8;
                        if (reorderedChildAt.getVisibility() == 8) {
                            z7 = z7;
                        } else {
                            LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                            f8 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                            f9 = f6 - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            if (hasDividerBeforeChildAtAlongMainAxis(i10, i9)) {
                                int i22 = this.mDividerVerticalWidth;
                                float f14 = i22;
                                f8 += f14;
                                f9 -= f14;
                                i13 = i22;
                            } else {
                                i13 = 0;
                            }
                            f10 = f9;
                            if (i9 == flexLine2.mItemCount - 1 || (this.mShowDividerVertical & 4) <= 0) {
                                i14 = 0;
                            } else {
                                i14 = this.mDividerVerticalWidth;
                            }
                            if (this.mFlexWrap == i20) {
                                if (z6) {
                                    i12 = i20;
                                    view = reorderedChildAt;
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - reorderedChildAt.getMeasuredWidth(), i18 - reorderedChildAt.getMeasuredHeight(), Math.round(f10), i18);
                                } else {
                                    view = reorderedChildAt;
                                    i12 = i20;
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f8), i18 - view.getMeasuredHeight(), view.getMeasuredWidth() + Math.round(f8), i18);
                                }
                                i11 = i18;
                            } else {
                                i9 = i9;
                                view = reorderedChildAt;
                                z7 = z7;
                                i12 = i20;
                                i11 = i18;
                                if (z6) {
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - view.getMeasuredWidth(), paddingTop, Math.round(f10), view.getMeasuredHeight() + paddingTop);
                                } else {
                                    int i23 = paddingTop;
                                    this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f8), i23, view.getMeasuredWidth() + Math.round(f8), view.getMeasuredHeight() + i23);
                                    paddingTop = i23;
                                }
                            }
                            measuredWidth = f8 + view.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                            float measuredWidth2 = f10 - ((view.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                            if (z6) {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(view, i14, 0, i13, 0);
                            } else {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(view, i13, 0, i14, 0);
                            }
                            flexLine2 = flexLine;
                            f6 = measuredWidth2;
                        }
                        i9++;
                        c = c6;
                        i20 = i12;
                        z8 = z7;
                        i18 = i11;
                    } else {
                        z7 = z8;
                    }
                    i12 = i20;
                    i9 = i9;
                    i11 = i18;
                    i9++;
                    c = c6;
                    i20 = i12;
                    z8 = z7;
                    i18 = i11;
                }
                int i24 = flexLine2.mCrossSize;
                paddingTop += i24;
                paddingBottom = i18 - i24;
            } else {
                int i25 = flexLine2.mMainSize;
                f6 = i25 - paddingLeft;
                measuredWidth = (i15 - i25) + paddingRight;
            }
            f7 = 0.0f;
            fMax = Math.max(f7, 0.0f);
            i9 = 0;
            while (i9 < flexLine2.mItemCount) {
                i10 = flexLine2.mFirstIndex + i9;
                reorderedChildAt = getReorderedChildAt(i10);
                char c7 = c;
                if (reorderedChildAt != null) {
                    z7 = z8;
                    if (reorderedChildAt.getVisibility() == 8) {
                        z7 = z7;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f8 = measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        f9 = f6 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        if (hasDividerBeforeChildAtAlongMainAxis(i10, i9)) {
                            int i26 = this.mDividerVerticalWidth;
                            float f15 = i26;
                            f8 += f15;
                            f9 -= f15;
                            i13 = i26;
                        } else {
                            i13 = 0;
                        }
                        f10 = f9;
                        if (i9 == flexLine2.mItemCount - 1) {
                            i14 = 0;
                        } else {
                            i14 = 0;
                        }
                        if (this.mFlexWrap == i20) {
                            if (z6) {
                                i12 = i20;
                                view = reorderedChildAt;
                                this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - reorderedChildAt.getMeasuredWidth(), i18 - reorderedChildAt.getMeasuredHeight(), Math.round(f10), i18);
                            } else {
                                view = reorderedChildAt;
                                i12 = i20;
                                this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f8), i18 - view.getMeasuredHeight(), view.getMeasuredWidth() + Math.round(f8), i18);
                            }
                            i11 = i18;
                        } else {
                            i9 = i9;
                            view = reorderedChildAt;
                            z7 = z7;
                            i12 = i20;
                            i11 = i18;
                            if (z6) {
                                this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - view.getMeasuredWidth(), paddingTop, Math.round(f10), view.getMeasuredHeight() + paddingTop);
                            } else {
                                int i27 = paddingTop;
                                this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f8), i27, view.getMeasuredWidth() + Math.round(f8), view.getMeasuredHeight() + i27);
                                paddingTop = i27;
                            }
                        }
                        measuredWidth = f8 + view.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        float measuredWidth3 = f10 - ((view.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin);
                        if (z6) {
                            flexLine = flexLine2;
                            flexLine.updatePositionFromView(view, i14, 0, i13, 0);
                        } else {
                            flexLine = flexLine2;
                            flexLine.updatePositionFromView(view, i13, 0, i14, 0);
                        }
                        flexLine2 = flexLine;
                        f6 = measuredWidth3;
                    }
                    i9++;
                    c = c7;
                    i20 = i12;
                    z8 = z7;
                    i18 = i11;
                } else {
                    z7 = z8;
                }
                i12 = i20;
                i9 = i9;
                i11 = i18;
                i9++;
                c = c7;
                i20 = i12;
                z8 = z7;
                i18 = i11;
            }
            int i28 = flexLine2.mCrossSize;
            paddingTop += i28;
            paddingBottom = i18 - i28;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:48:0x0106  */
    /* JADX WARN: Code duplicated, block: B:50:0x010e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0120  */
    /* JADX WARN: Code duplicated, block: B:58:0x0124 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:61:0x014a  */
    /* JADX WARN: Code duplicated, block: B:62:0x0169  */
    /* JADX WARN: Code duplicated, block: B:64:0x0171  */
    /* JADX WARN: Code duplicated, block: B:65:0x018d  */
    /* JADX WARN: Code duplicated, block: B:68:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x01dc  */
    private void layoutVertical(boolean z6, boolean z7, int i5, int i6, int i7, int i8) {
        float measuredHeight;
        float f6;
        float f7;
        float fMax;
        int i9;
        int i10;
        int i11;
        View reorderedChildAt;
        char c;
        int i12;
        int i13;
        float f8;
        float f9;
        int i14;
        float f10;
        int i15;
        FlexLine flexLine;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i16 = i8 - i6;
        int i17 = (i7 - i5) - paddingRight;
        int size = this.mFlexLines.size();
        for (int i18 = 0; i18 < size; i18++) {
            FlexLine flexLine2 = this.mFlexLines.get(i18);
            if (hasDividerBeforeFlexLine(i18)) {
                int i19 = this.mDividerVerticalWidth;
                paddingLeft += i19;
                i17 -= i19;
            }
            int i20 = i17;
            int i21 = this.mJustifyContent;
            char c6 = 4;
            int i22 = 1;
            if (i21 == 0) {
                measuredHeight = paddingTop;
                f6 = i16 - paddingBottom;
            } else if (i21 != 1) {
                if (i21 == 2) {
                    int i23 = flexLine2.mMainSize;
                    measuredHeight = paddingTop + ((i16 - i23) / 2.0f);
                    f6 = (i16 - paddingBottom) - ((i16 - i23) / 2.0f);
                } else if (i21 == 3) {
                    measuredHeight = paddingTop;
                    int itemCountNotGone = flexLine2.getItemCountNotGone();
                    f7 = (i16 - flexLine2.mMainSize) / (itemCountNotGone != 1 ? itemCountNotGone - 1 : 1.0f);
                    f6 = i16 - paddingBottom;
                } else if (i21 == 4) {
                    int itemCountNotGone2 = flexLine2.getItemCountNotGone();
                    f7 = itemCountNotGone2 != 0 ? (i16 - flexLine2.mMainSize) / itemCountNotGone2 : 0.0f;
                    float f11 = f7 / 2.0f;
                    measuredHeight = paddingTop + f11;
                    f6 = (i16 - paddingBottom) - f11;
                } else {
                    if (i21 != 5) {
                        throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                    }
                    int itemCountNotGone3 = flexLine2.getItemCountNotGone();
                    f7 = itemCountNotGone3 != 0 ? (i16 - flexLine2.mMainSize) / (itemCountNotGone3 + 1) : 0.0f;
                    measuredHeight = paddingTop + f7;
                    f6 = (i16 - paddingBottom) - f7;
                }
                fMax = Math.max(f7, 0.0f);
                i9 = 0;
                while (i9 < flexLine2.mItemCount) {
                    i10 = flexLine2.mFirstIndex + i9;
                    i11 = i22;
                    reorderedChildAt = getReorderedChildAt(i10);
                    if (reorderedChildAt != null) {
                        c = c6;
                        if (reorderedChildAt.getVisibility() == 8) {
                            LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                            f8 = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            f9 = f6 - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (hasDividerBeforeChildAtAlongMainAxis(i10, i9)) {
                                i14 = this.mDividerHorizontalHeight;
                                float f12 = i14;
                                f8 += f12;
                                f9 -= f12;
                            } else {
                                i14 = 0;
                            }
                            f10 = f9;
                            if (i9 == flexLine2.mItemCount - i11 || (this.mShowDividerHorizontal & 4) <= 0) {
                                i15 = 0;
                            } else {
                                i15 = this.mDividerHorizontalHeight;
                            }
                            if (z6) {
                                if (z7) {
                                    i13 = i9;
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i20 - reorderedChildAt.getMeasuredWidth(), Math.round(f10) - reorderedChildAt.getMeasuredHeight(), i20, Math.round(f10));
                                } else {
                                    i13 = i9;
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i20 - reorderedChildAt.getMeasuredWidth(), Math.round(f8), i20, reorderedChildAt.getMeasuredHeight() + Math.round(f8));
                                }
                                i12 = i20;
                            } else {
                                i13 = i9;
                                i11 = i11;
                                i12 = i20;
                                if (z7) {
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, paddingLeft, Math.round(f10) - reorderedChildAt.getMeasuredHeight(), reorderedChildAt.getMeasuredWidth() + paddingLeft, Math.round(f10));
                                } else {
                                    int i24 = paddingLeft;
                                    this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, i24, Math.round(f8), reorderedChildAt.getMeasuredWidth() + i24, reorderedChildAt.getMeasuredHeight() + Math.round(f8));
                                    paddingLeft = i24;
                                }
                            }
                            measuredHeight = f8 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            float measuredHeight2 = f10 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin);
                            if (z7) {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(reorderedChildAt, 0, i15, 0, i14);
                            } else {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(reorderedChildAt, 0, i14, 0, i15);
                            }
                            flexLine2 = flexLine;
                            f6 = measuredHeight2;
                        }
                        i9 = i13 + 1;
                        c6 = c;
                        i22 = i11;
                        i20 = i12;
                    } else {
                        c = c6;
                    }
                    i13 = i9;
                    i11 = i11;
                    i12 = i20;
                    i9 = i13 + 1;
                    c6 = c;
                    i22 = i11;
                    i20 = i12;
                }
                int i25 = flexLine2.mCrossSize;
                paddingLeft += i25;
                i17 = i20 - i25;
            } else {
                int i26 = flexLine2.mMainSize;
                f6 = i26 - paddingTop;
                measuredHeight = (i16 - i26) + paddingBottom;
            }
            f7 = 0.0f;
            fMax = Math.max(f7, 0.0f);
            i9 = 0;
            while (i9 < flexLine2.mItemCount) {
                i10 = flexLine2.mFirstIndex + i9;
                i11 = i22;
                reorderedChildAt = getReorderedChildAt(i10);
                if (reorderedChildAt != null) {
                    c = c6;
                    if (reorderedChildAt.getVisibility() == 8) {
                        LayoutParams layoutParams2 = (LayoutParams) reorderedChildAt.getLayoutParams();
                        f8 = measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        f9 = f6 - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        if (hasDividerBeforeChildAtAlongMainAxis(i10, i9)) {
                            i14 = this.mDividerHorizontalHeight;
                            float f13 = i14;
                            f8 += f13;
                            f9 -= f13;
                        } else {
                            i14 = 0;
                        }
                        f10 = f9;
                        if (i9 == flexLine2.mItemCount - i11) {
                            i15 = 0;
                        } else {
                            i15 = 0;
                        }
                        if (z6) {
                            if (z7) {
                                i13 = i9;
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i20 - reorderedChildAt.getMeasuredWidth(), Math.round(f10) - reorderedChildAt.getMeasuredHeight(), i20, Math.round(f10));
                            } else {
                                i13 = i9;
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i20 - reorderedChildAt.getMeasuredWidth(), Math.round(f8), i20, reorderedChildAt.getMeasuredHeight() + Math.round(f8));
                            }
                            i12 = i20;
                        } else {
                            i13 = i9;
                            i11 = i11;
                            i12 = i20;
                            if (z7) {
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, paddingLeft, Math.round(f10) - reorderedChildAt.getMeasuredHeight(), reorderedChildAt.getMeasuredWidth() + paddingLeft, Math.round(f10));
                            } else {
                                int i27 = paddingLeft;
                                this.mFlexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, i27, Math.round(f8), reorderedChildAt.getMeasuredWidth() + i27, reorderedChildAt.getMeasuredHeight() + Math.round(f8));
                                paddingLeft = i27;
                            }
                        }
                        measuredHeight = f8 + reorderedChildAt.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        float measuredHeight3 = f10 - ((reorderedChildAt.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin);
                        if (z7) {
                            flexLine = flexLine2;
                            flexLine.updatePositionFromView(reorderedChildAt, 0, i15, 0, i14);
                        } else {
                            flexLine = flexLine2;
                            flexLine.updatePositionFromView(reorderedChildAt, 0, i14, 0, i15);
                        }
                        flexLine2 = flexLine;
                        f6 = measuredHeight3;
                    }
                    i9 = i13 + 1;
                    c6 = c;
                    i22 = i11;
                    i20 = i12;
                } else {
                    c = c6;
                }
                i13 = i9;
                i11 = i11;
                i12 = i20;
                i9 = i13 + 1;
                c6 = c;
                i22 = i11;
                i20 = i12;
            }
            int i28 = flexLine2.mCrossSize;
            paddingLeft += i28;
            i17 = i20 - i28;
        }
    }

    private void measureHorizontal(int i5, int i6) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, i5, i6);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i5, i6);
        if (this.mAlignItems == 3) {
            for (FlexLine flexLine : this.mFlexLines) {
                int iMax = Integer.MIN_VALUE;
                for (int i7 = 0; i7 < flexLine.mItemCount; i7++) {
                    View reorderedChildAt = getReorderedChildAt(flexLine.mFirstIndex + i7);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        iMax = this.mFlexWrap != 2 ? Math.max(iMax, reorderedChildAt.getMeasuredHeight() + Math.max(flexLine.mMaxBaseline - reorderedChildAt.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, reorderedChildAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max(reorderedChildAt.getBaseline() + (flexLine.mMaxBaseline - reorderedChildAt.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                flexLine.mCrossSize = iMax;
            }
        }
        this.mFlexboxHelper.determineCrossSize(i5, i6, getPaddingBottom() + getPaddingTop());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i5, i6, this.mFlexLinesResult.mChildState);
    }

    private void measureVertical(int i5, int i6) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, i5, i6);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(i5, i6);
        this.mFlexboxHelper.determineCrossSize(i5, i6, getPaddingRight() + getPaddingLeft());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, i5, i6, this.mFlexLinesResult.mChildState);
    }

    private void setMeasuredDimensionForFlex(int i5, int i6, int i7, int i8) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i7);
        int size2 = View.MeasureSpec.getSize(i7);
        if (i5 == 0 || i5 == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i5 != 2 && i5 != 3) {
                throw new IllegalArgumentException(AbstractC0157z.k(i5, "Invalid flex direction: "));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i8 = View.combineMeasuredStates(i8, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i6, i8);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i6, i8);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException(AbstractC0157z.k(mode, "Unknown width mode is set: "));
            }
            if (size < largestMainSize) {
                i8 = View.combineMeasuredStates(i8, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i6, i8);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i8 = View.combineMeasuredStates(i8, 256);
            } else {
                size2 = paddingBottom;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i7, i8);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i7, i8);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException(AbstractC0157z.k(mode2, "Unknown height mode is set: "));
            }
            if (size2 < paddingBottom) {
                i8 = View.combineMeasuredStates(i8, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i7, i8);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(view, i5, layoutParams, this.mOrderCache);
        super.addView(view, i5, layoutParams);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.mAlignContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int i5, int i6, int i7) {
        return ViewGroup.getChildMeasureSpec(i5, i6, i7);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int i5, int i6, int i7) {
        return ViewGroup.getChildMeasureSpec(i5, i6, i7);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int i5, int i6) {
        int i7;
        int i8;
        if (isMainAxisDirectionHorizontal()) {
            i7 = hasDividerBeforeChildAtAlongMainAxis(i5, i6) ? this.mDividerVerticalWidth : 0;
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i7;
            }
            i8 = this.mDividerVerticalWidth;
        } else {
            i7 = hasDividerBeforeChildAtAlongMainAxis(i5, i6) ? this.mDividerHorizontalHeight : 0;
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i7;
            }
            i8 = this.mDividerHorizontalHeight;
        }
        return i7 + i8;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int i5) {
        return getChildAt(i5);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        Iterator<FlexLine> it = this.mFlexLines.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mMainSize);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    public View getReorderedChildAt(int i5) {
        if (i5 < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (i5 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i5]);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int i5) {
        return getReorderedChildAt(i5);
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            FlexLine flexLine = this.mFlexLines.get(i6);
            if (hasDividerBeforeFlexLine(i6)) {
                i5 += isMainAxisDirectionHorizontal() ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            if (hasEndDividerAfterFlexLine(i6)) {
                i5 += isMainAxisDirectionHorizontal() ? this.mDividerHorizontalHeight : this.mDividerVerticalWidth;
            }
            i5 += flexLine.mCrossSize;
        }
        return i5;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i5 = this.mFlexDirection;
        return i5 == 0 || i5 == 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical == null && this.mDividerDrawableHorizontal == null) {
            return;
        }
        if (this.mShowDividerHorizontal == 0 && this.mShowDividerVertical == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i5 = this.mFlexDirection;
        if (i5 == 0) {
            drawDividersHorizontal(canvas, layoutDirection == 1, this.mFlexWrap == 2);
            return;
        }
        if (i5 == 1) {
            drawDividersHorizontal(canvas, layoutDirection != 1, this.mFlexWrap == 2);
            return;
        }
        if (i5 == 2) {
            boolean z6 = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z6 = !z6;
            }
            drawDividersVertical(canvas, z6, false);
            return;
        }
        if (i5 != 3) {
            return;
        }
        boolean z7 = layoutDirection == 1;
        if (this.mFlexWrap == 2) {
            z7 = !z7;
        }
        drawDividersVertical(canvas, z7, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        boolean z7;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i9 = this.mFlexDirection;
        if (i9 == 0) {
            layoutHorizontal(layoutDirection == 1, i5, i6, i7, i8);
            return;
        }
        if (i9 == 1) {
            layoutHorizontal(layoutDirection != 1, i5, i6, i7, i8);
            return;
        }
        if (i9 == 2) {
            z7 = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z7 = !z7;
            }
            layoutVertical(z7, false, i5, i6, i7, i8);
            return;
        }
        if (i9 != 3) {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
        z7 = layoutDirection == 1;
        if (this.mFlexWrap == 2) {
            z7 = !z7;
        }
        layoutVertical(z7, true, i5, i6, i7, i8);
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        int i7 = this.mFlexDirection;
        if (i7 == 0 || i7 == 1) {
            measureHorizontal(i5, i6);
        } else if (i7 == 2 || i7 == 3) {
            measureVertical(i5, i6);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int i5, int i6, FlexLine flexLine) {
        if (hasDividerBeforeChildAtAlongMainAxis(i5, i6)) {
            if (isMainAxisDirectionHorizontal()) {
                int i7 = flexLine.mMainSize;
                int i8 = this.mDividerVerticalWidth;
                flexLine.mMainSize = i7 + i8;
                flexLine.mDividerLengthInMainSize += i8;
                return;
            }
            int i9 = flexLine.mMainSize;
            int i10 = this.mDividerHorizontalHeight;
            flexLine.mMainSize = i9 + i10;
            flexLine.mDividerLengthInMainSize += i10;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                int i5 = flexLine.mMainSize;
                int i6 = this.mDividerVerticalWidth;
                flexLine.mMainSize = i5 + i6;
                flexLine.mDividerLengthInMainSize += i6;
                return;
            }
            return;
        }
        if ((this.mShowDividerHorizontal & 4) > 0) {
            int i7 = flexLine.mMainSize;
            int i8 = this.mDividerHorizontalHeight;
            flexLine.mMainSize = i7 + i8;
            flexLine.mDividerLengthInMainSize += i8;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int i5) {
        if (this.mAlignContent != i5) {
            this.mAlignContent = i5;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int i5) {
        if (this.mAlignItems != i5) {
            this.mAlignItems = i5;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.mDividerDrawableHorizontal) {
            return;
        }
        this.mDividerDrawableHorizontal = drawable;
        if (drawable != null) {
            this.mDividerHorizontalHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerHorizontalHeight = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.mDividerDrawableVertical) {
            return;
        }
        this.mDividerDrawableVertical = drawable;
        if (drawable != null) {
            this.mDividerVerticalWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerVerticalWidth = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int i5) {
        if (this.mFlexDirection != i5) {
            this.mFlexDirection = i5;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.mFlexLines = list;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int i5) {
        if (this.mFlexWrap != i5) {
            this.mFlexWrap = i5;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int i5) {
        if (this.mJustifyContent != i5) {
            this.mJustifyContent = i5;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int i5) {
        if (this.mMaxLine != i5) {
            this.mMaxLine = i5;
            requestLayout();
        }
    }

    public void setShowDivider(int i5) {
        setShowDividerVertical(i5);
        setShowDividerHorizontal(i5);
    }

    public void setShowDividerHorizontal(int i5) {
        if (i5 != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = i5;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i5) {
        if (i5 != this.mShowDividerVertical) {
            this.mShowDividerVertical = i5;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i5, 0);
        this.mFlexDirection = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i6 != 0) {
            this.mShowDividerVertical = i6;
            this.mShowDividerHorizontal = i6;
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i7 != 0) {
            this.mShowDividerVertical = i7;
        }
        int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i8 != 0) {
            this.mShowDividerHorizontal = i8;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i5) {
                return new LayoutParams[i5];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.mOrder = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = typedArrayObtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i5) {
            this.mAlignSelf = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f6) {
            this.mFlexBasisPercent = f6;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f6) {
            this.mFlexGrow = f6;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f6) {
            this.mFlexShrink = f6;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i5) {
            ((ViewGroup.MarginLayoutParams) this).height = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i5) {
            this.mMaxHeight = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i5) {
            this.mMaxWidth = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i5) {
            this.mMinHeight = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i5) {
            this.mMinWidth = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i5) {
            this.mOrder = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i5) {
            ((ViewGroup.MarginLayoutParams) this).width = i5;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z6) {
            this.mWrapBefore = z6;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int i5, int i6) {
            super(new ViewGroup.LayoutParams(i5, i6));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int i5, View view) {
    }
}
