package com.google.android.flexbox;

import A3.AbstractC0157z;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;

    @Nullable
    int[] mIndexToFlexLine;

    @Nullable
    long[] mMeasureSpecCache;

    @Nullable
    private long[] mMeasuredSizeCache;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        @NonNull
        public String toString() {
            StringBuilder sb = new StringBuilder("Order{order=");
            sb.append(this.order);
            sb.append(", index=");
            return AbstractC0157z.p(sb, this.index, '}');
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull Order order) {
            int i5 = this.order;
            int i6 = order.order;
            return i5 != i6 ? i5 - i6 : this.index - order.index;
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    private void addFlexLine(List<FlexLine> list, FlexLine flexLine, int i5, int i6) {
        flexLine.mSumCrossSizeBefore = i6;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = i5;
        list.add(flexLine);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    private void checkSizeConstraints(View view, int i5) {
        boolean z6;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z7 = true;
        if (measuredWidth >= flexItem.getMinWidth()) {
            if (measuredWidth > flexItem.getMaxWidth()) {
                measuredWidth = flexItem.getMaxWidth();
            } else {
                z6 = false;
            }
            if (measuredHeight < flexItem.getMinHeight()) {
                measuredHeight = flexItem.getMinHeight();
            } else if (measuredHeight > flexItem.getMaxHeight()) {
                measuredHeight = flexItem.getMaxHeight();
            } else {
                z7 = z6;
            }
            if (z7) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                updateMeasureCache(i5, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.mFlexContainer.updateViewCache(i5, view);
            }
        }
        measuredWidth = flexItem.getMinWidth();
        z6 = true;
        if (measuredHeight < flexItem.getMinHeight()) {
            measuredHeight = flexItem.getMinHeight();
        } else if (measuredHeight > flexItem.getMaxHeight()) {
            measuredHeight = flexItem.getMaxHeight();
        } else {
            z7 = z6;
        }
        if (z7) {
            int iMakeMeasureSpec3 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            int iMakeMeasureSpec4 = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
            view.measure(iMakeMeasureSpec3, iMakeMeasureSpec4);
            updateMeasureCache(i5, iMakeMeasureSpec3, iMakeMeasureSpec4, view);
            this.mFlexContainer.updateViewCache(i5, view);
        }
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> list, int i5, int i6) {
        int i7 = (i5 - i6) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.mCrossSize = i7;
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            if (i8 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i8));
            if (i8 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<Order> createOrders(int i5) {
        ArrayList arrayList = new ArrayList(i5);
        for (int i6 = 0; i6 < i5; i6++) {
            FlexItem flexItem = (FlexItem) this.mFlexContainer.getFlexItemAt(i6).getLayoutParams();
            Order order = new Order();
            order.order = flexItem.getOrder();
            order.index = i6;
            arrayList.add(order);
        }
        return arrayList;
    }

    private void ensureChildrenFrozen(int i5) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            this.mChildrenFrozen = new boolean[Math.max(i5, 10)];
        } else if (zArr.length < i5) {
            this.mChildrenFrozen = new boolean[Math.max(zArr.length * 2, i5)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void expandFlexItems(int i5, int i6, FlexLine flexLine, int i7, int i8, boolean z6) {
        int i9;
        float f6;
        float f7;
        int iMax;
        double d;
        double d6;
        float f8 = flexLine.mTotalFlexGrow;
        float f9 = 0.0f;
        if (f8 <= 0.0f || i7 < (i9 = flexLine.mMainSize)) {
            return;
        }
        float f10 = (i7 - i9) / f8;
        flexLine.mMainSize = i8 + flexLine.mDividerLengthInMainSize;
        if (!z6) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z7 = false;
        int i11 = 0;
        float f11 = 0.0f;
        while (i10 < flexLine.mItemCount) {
            int i12 = flexLine.mFirstIndex + i10;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i12);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f6 = f9;
                f7 = f10;
                z7 = z7;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f6 = f9;
                if (flexDirection == 0 || flexDirection == 1) {
                    f7 = f10;
                    boolean z8 = z7;
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i12]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i12]);
                    }
                    if (this.mChildrenFrozen[i12] || flexItem.getFlexGrow() <= f6) {
                        z7 = z8;
                    } else {
                        float flexGrow = (flexItem.getFlexGrow() * f7) + measuredWidth;
                        if (i10 == flexLine.mItemCount - 1) {
                            flexGrow += f11;
                            f11 = f6;
                        }
                        int iRound = Math.round(flexGrow);
                        if (iRound > flexItem.getMaxWidth()) {
                            iRound = flexItem.getMaxWidth();
                            this.mChildrenFrozen[i12] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z7 = true;
                        } else {
                            float f12 = (flexGrow - iRound) + f11;
                            double d7 = f12;
                            if (d7 > 1.0d) {
                                iRound++;
                                d = d7 - 1.0d;
                            } else {
                                if (d7 < -1.0d) {
                                    iRound--;
                                    d = d7 + 1.0d;
                                }
                                f11 = f12;
                                z7 = z8;
                            }
                            f12 = (float) d;
                            f11 = f12;
                            z7 = z8;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i6, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i12, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i12, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i11, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + flexLine.mMainSize;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i12]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    f7 = f10;
                    boolean z9 = z7;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i12]);
                    }
                    if (this.mChildrenFrozen[i12] || flexItem.getFlexGrow() <= f6) {
                        z7 = z9;
                    } else {
                        float flexGrow2 = (flexItem.getFlexGrow() * f7) + measuredHeight3;
                        if (i10 == flexLine.mItemCount - 1) {
                            flexGrow2 += f11;
                            f11 = f6;
                        }
                        int iRound2 = Math.round(flexGrow2);
                        if (iRound2 > flexItem.getMaxHeight()) {
                            iRound2 = flexItem.getMaxHeight();
                            this.mChildrenFrozen[i12] = true;
                            flexLine.mTotalFlexGrow -= flexItem.getFlexGrow();
                            z7 = true;
                        } else {
                            float f13 = (flexGrow2 - iRound2) + f11;
                            double d8 = f13;
                            if (d8 > 1.0d) {
                                iRound2++;
                                d6 = d8 - 1.0d;
                            } else {
                                if (d8 < -1.0d) {
                                    iRound2--;
                                    d6 = d8 + 1.0d;
                                }
                                f11 = f13;
                                z7 = z9;
                            }
                            f13 = (float) d6;
                            f11 = f13;
                            z7 = z9;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i5, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i12, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i12, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i11, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + flexLine.mMainSize;
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i11 = iMax;
            }
            i10++;
            f10 = f7;
            f9 = f6;
        }
        if (!z7 || i9 == flexLine.mMainSize) {
            return;
        }
        expandFlexItems(i5, i6, flexLine, i7, i8, true);
    }

    private int getChildHeightMeasureSpecInternal(int i5, FlexItem flexItem, int i6) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(i5, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i6, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    private int getChildWidthMeasureSpecInternal(int i5, FlexItem flexItem, int i6) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(i5, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i6, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getMarginBottom() : flexItem.getMarginRight();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getMarginRight() : flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getMarginTop() : flexItem.getMarginLeft();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getMarginLeft() : flexItem.getMarginTop();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getHeight() : flexItem.getWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean z6) {
        return z6 ? flexItem.getWidth() : flexItem.getHeight();
    }

    private int getPaddingEndCross(boolean z6) {
        return z6 ? this.mFlexContainer.getPaddingBottom() : this.mFlexContainer.getPaddingEnd();
    }

    private int getPaddingEndMain(boolean z6) {
        return z6 ? this.mFlexContainer.getPaddingEnd() : this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean z6) {
        return z6 ? this.mFlexContainer.getPaddingTop() : this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingStartMain(boolean z6) {
        return z6 ? this.mFlexContainer.getPaddingStart() : this.mFlexContainer.getPaddingTop();
    }

    private int getViewMeasuredSizeCross(View view, boolean z6) {
        return z6 ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    private int getViewMeasuredSizeMain(View view, boolean z6) {
        return z6 ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    private boolean isLastFlexItem(int i5, int i6, FlexLine flexLine) {
        return i5 == i6 - 1 && flexLine.getItemCountNotGone() != 0;
    }

    private boolean isWrapRequired(View view, int i5, int i6, int i7, int i8, FlexItem flexItem, int i9, int i10, int i11) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i5 == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= i11 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.mFlexContainer.getDecorationLengthMainAxis(view, i9, i10);
        if (decorationLengthMainAxis > 0) {
            i8 += decorationLengthMainAxis;
        }
        return i6 < i7 + i8;
    }

    private void shrinkFlexItems(int i5, int i6, FlexLine flexLine, int i7, int i8, boolean z6) {
        float f6;
        float f7;
        int iMax;
        int minWidth;
        int i9 = flexLine.mMainSize;
        float f8 = flexLine.mTotalFlexShrink;
        float f9 = 0.0f;
        if (f8 <= 0.0f || i7 > i9) {
            return;
        }
        float f10 = (i9 - i7) / f8;
        flexLine.mMainSize = i8 + flexLine.mDividerLengthInMainSize;
        if (!z6) {
            flexLine.mCrossSize = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z7 = false;
        int i11 = 0;
        float f11 = 0.0f;
        while (i10 < flexLine.mItemCount) {
            int i12 = flexLine.mFirstIndex + i10;
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i12);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                f6 = f9;
                f7 = f10;
            } else {
                FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.mFlexContainer.getFlexDirection();
                f6 = f9;
                if (flexDirection == 0 || flexDirection == 1) {
                    int measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr = this.mMeasuredSizeCache;
                    if (jArr != null) {
                        measuredWidth = extractLowerInt(jArr[i12]);
                    }
                    int measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr2 = this.mMeasuredSizeCache;
                    f7 = f10;
                    if (jArr2 != null) {
                        measuredHeight = extractHigherInt(jArr2[i12]);
                    }
                    if (!this.mChildrenFrozen[i12] && flexItem.getFlexShrink() > f6) {
                        float flexShrink = measuredWidth - (f7 * flexItem.getFlexShrink());
                        if (i10 == flexLine.mItemCount - 1) {
                            flexShrink += f11;
                            f11 = f6;
                        }
                        int iRound = Math.round(flexShrink);
                        if (iRound < flexItem.getMinWidth()) {
                            minWidth = flexItem.getMinWidth();
                            this.mChildrenFrozen[i12] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z7 = true;
                        } else {
                            float f12 = (flexShrink - iRound) + f11;
                            double d = f12;
                            if (d > 1.0d) {
                                minWidth = iRound + 1;
                                f12 -= 1.0f;
                            } else if (d < -1.0d) {
                                minWidth = iRound - 1;
                                f12 += 1.0f;
                            } else {
                                minWidth = iRound;
                            }
                            f11 = f12;
                        }
                        int childHeightMeasureSpecInternal = getChildHeightMeasureSpecInternal(i6, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(minWidth, 1073741824);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec, childHeightMeasureSpecInternal);
                        int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i12, iMakeMeasureSpec, childHeightMeasureSpecInternal, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i12, reorderedFlexItemAt);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i11, measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + flexLine.mMainSize;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        measuredHeight3 = extractHigherInt(jArr3[i12]);
                    }
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        measuredWidth3 = extractLowerInt(jArr4[i12]);
                    }
                    if (!this.mChildrenFrozen[i12] && flexItem.getFlexShrink() > f6) {
                        float flexShrink2 = measuredHeight3 - (flexItem.getFlexShrink() * f10);
                        if (i10 == flexLine.mItemCount - 1) {
                            flexShrink2 += f11;
                            f11 = f6;
                        }
                        int iRound2 = Math.round(flexShrink2);
                        if (iRound2 < flexItem.getMinHeight()) {
                            iRound2 = flexItem.getMinHeight();
                            this.mChildrenFrozen[i12] = true;
                            flexLine.mTotalFlexShrink -= flexItem.getFlexShrink();
                            z7 = true;
                        } else {
                            float f13 = (flexShrink2 - iRound2) + f11;
                            double d6 = f13;
                            if (d6 > 1.0d) {
                                iRound2++;
                                f13 -= 1.0f;
                            } else if (d6 < -1.0d) {
                                iRound2--;
                                f13 += 1.0f;
                            }
                            f11 = f13;
                        }
                        int childWidthMeasureSpecInternal = getChildWidthMeasureSpecInternal(i5, flexItem, flexLine.mSumCrossSizeBefore);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        reorderedFlexItemAt.measure(childWidthMeasureSpecInternal, iMakeMeasureSpec2);
                        int measuredWidth4 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                        updateMeasureCache(i12, childWidthMeasureSpecInternal, iMakeMeasureSpec2, reorderedFlexItemAt);
                        this.mFlexContainer.updateViewCache(i12, reorderedFlexItemAt);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i11, measuredWidth3 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mMainSize = measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + flexLine.mMainSize;
                    f7 = f10;
                }
                flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                i11 = iMax;
            }
            i10++;
            f10 = f7;
            f9 = f6;
        }
        if (!z7 || i9 == flexLine.mMainSize) {
            return;
        }
        shrinkFlexItems(i5, i6, flexLine, i7, i8, true);
    }

    private int[] sortOrdersIntoReorderedIndices(int i5, List<Order> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i5];
        int i6 = 0;
        for (Order order : list) {
            int i7 = order.index;
            iArr[i6] = i7;
            sparseIntArray.append(i7, order.order);
            i6++;
        }
        return iArr;
    }

    private void stretchViewHorizontally(View view, int i5, int i6) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i5 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? extractHigherInt(jArr[i6]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        updateMeasureCache(i6, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.mFlexContainer.updateViewCache(i6, view);
    }

    private void stretchViewVertically(View view, int i5, int i6) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i5 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? extractLowerInt(jArr[i6]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        updateMeasureCache(i6, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.mFlexContainer.updateViewCache(i6, view);
    }

    private void updateMeasureCache(int i5, int i6, int i7, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[i5] = makeCombinedLong(i6, i7);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[i5] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void calculateFlexLines(FlexLinesResult flexLinesResult, int i5, int i6, int i7, int i8, int i9, @Nullable List<FlexLine> list) {
        int i10;
        boolean z6;
        int i11;
        int i12;
        int i13;
        int childWidthMeasureSpec;
        int i14;
        int i15;
        int i16;
        FlexLine flexLine;
        int i17;
        int i18;
        boolean z7;
        int i19;
        int i20;
        int i21 = i5;
        boolean zIsMainAxisDirectionHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i21);
        int size = View.MeasureSpec.getSize(i21);
        List<FlexLine> arrayList = list == null ? new ArrayList() : list;
        flexLinesResult.mFlexLines = arrayList;
        boolean z8 = i9 == -1;
        int paddingStartMain = getPaddingStartMain(zIsMainAxisDirectionHorizontal);
        int paddingEndMain = getPaddingEndMain(zIsMainAxisDirectionHorizontal);
        int paddingStartCross = getPaddingStartCross(zIsMainAxisDirectionHorizontal);
        int paddingEndCross = getPaddingEndCross(zIsMainAxisDirectionHorizontal);
        FlexLine flexLine2 = new FlexLine();
        int i22 = i8;
        flexLine2.mFirstIndex = i22;
        int i23 = paddingStartMain + paddingEndMain;
        flexLine2.mMainSize = i23;
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        boolean z9 = z8;
        FlexLine flexLine3 = flexLine2;
        int i24 = Integer.MIN_VALUE;
        int i25 = 0;
        int iCombineMeasuredStates = 0;
        int i26 = 0;
        while (i22 < flexItemCount) {
            View reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i22);
            if (reorderedFlexItemAt == null) {
                if (isLastFlexItem(i22, flexItemCount, flexLine3)) {
                    addFlexLine(arrayList, flexLine3, i22, i25);
                }
                i11 = i23;
                z6 = true;
            } else {
                z6 = true;
                i11 = i23;
                if (reorderedFlexItemAt.getVisibility() == 8) {
                    flexLine3.mGoneItemCount++;
                    flexLine3.mItemCount++;
                    if (isLastFlexItem(i22, flexItemCount, flexLine3)) {
                        addFlexLine(arrayList, flexLine3, i22, i25);
                    }
                } else {
                    if (reorderedFlexItemAt instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) reorderedFlexItemAt);
                    }
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    int i27 = flexItemCount;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine3.mIndicesAlignSelfStretch.add(Integer.valueOf(i22));
                    }
                    int flexItemSizeMain = getFlexItemSizeMain(flexItem, zIsMainAxisDirectionHorizontal);
                    if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                        flexItemSizeMain = Math.round(size * flexItem.getFlexBasisPercent());
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        childWidthMeasureSpec = this.mFlexContainer.getChildWidthMeasureSpec(i21, i11 + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), flexItemSizeMain);
                        i12 = i25;
                        int childHeightMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i6, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + i25, getFlexItemSizeCross(flexItem, true));
                        reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                        updateMeasureCache(i22, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                        i13 = 0;
                    } else {
                        i12 = i25;
                        i13 = 0;
                        int childWidthMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i6, paddingStartCross + paddingEndCross + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + i12, getFlexItemSizeCross(flexItem, false));
                        int childHeightMeasureSpec2 = this.mFlexContainer.getChildHeightMeasureSpec(i21, i11 + getFlexItemMarginStartMain(flexItem, false) + getFlexItemMarginEndMain(flexItem, false), flexItemSizeMain);
                        reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                        updateMeasureCache(i22, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                        childWidthMeasureSpec = childHeightMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(i22, reorderedFlexItemAt);
                    checkSizeConstraints(reorderedFlexItemAt, i22);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                    int i28 = i13;
                    i14 = i22;
                    int i29 = childWidthMeasureSpec;
                    FlexLine flexLine4 = flexLine3;
                    int i30 = i26;
                    i15 = i11;
                    i16 = i12;
                    boolean z10 = zIsMainAxisDirectionHorizontal;
                    size = size;
                    if (isWrapRequired(reorderedFlexItemAt, mode, size, flexLine3.mMainSize, getViewMeasuredSizeMain(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + getFlexItemMarginStartMain(flexItem, zIsMainAxisDirectionHorizontal) + getFlexItemMarginEndMain(flexItem, zIsMainAxisDirectionHorizontal), flexItem, i14, i30, arrayList.size())) {
                        if (flexLine4.getItemCountNotGone() > 0) {
                            addFlexLine(arrayList, flexLine4, i14 > 0 ? i14 - 1 : i28, i16);
                            i20 = i16 + flexLine4.mCrossSize;
                        } else {
                            i20 = i16;
                        }
                        if (z10) {
                            if (flexItem.getHeight() == -1) {
                                FlexContainer flexContainer = this.mFlexContainer;
                                reorderedFlexItemAt.measure(i29, flexContainer.getChildHeightMeasureSpec(i6, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i20, flexItem.getHeight()));
                                checkSizeConstraints(reorderedFlexItemAt, i14);
                            }
                        } else if (flexItem.getWidth() == -1) {
                            FlexContainer flexContainer2 = this.mFlexContainer;
                            reorderedFlexItemAt.measure(flexContainer2.getChildWidthMeasureSpec(i6, flexContainer2.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i20, flexItem.getWidth()), i29);
                            checkSizeConstraints(reorderedFlexItemAt, i14);
                        }
                        FlexLine flexLine5 = new FlexLine();
                        flexLine5.mItemCount = 1;
                        flexLine5.mMainSize = i15;
                        flexLine5.mFirstIndex = i14;
                        i16 = i20;
                        i17 = i28;
                        flexLine = flexLine5;
                        i18 = Integer.MIN_VALUE;
                    } else {
                        flexLine = flexLine4;
                        flexLine.mItemCount++;
                        i17 = i30 + 1;
                        i18 = i24;
                    }
                    flexLine.mAnyItemsHaveFlexGrow = (flexLine.mAnyItemsHaveFlexGrow ? 1 : 0) | (flexItem.getFlexGrow() != 0.0f ? 1 : i28);
                    flexLine.mAnyItemsHaveFlexShrink = (flexLine.mAnyItemsHaveFlexShrink ? 1 : 0) | (flexItem.getFlexShrink() != 0.0f ? 1 : i28);
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i14] = arrayList.size();
                    }
                    z7 = z10;
                    flexLine.mMainSize = getViewMeasuredSizeMain(reorderedFlexItemAt, z7) + getFlexItemMarginStartMain(flexItem, z7) + getFlexItemMarginEndMain(flexItem, z7) + flexLine.mMainSize;
                    flexLine.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(reorderedFlexItemAt, i14, i17, flexLine);
                    int iMax = Math.max(i18, getViewMeasuredSizeCross(reorderedFlexItemAt, z7) + getFlexItemMarginStartCross(flexItem, z7) + getFlexItemMarginEndCross(flexItem, z7) + this.mFlexContainer.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    flexLine.mCrossSize = Math.max(flexLine.mCrossSize, iMax);
                    if (z7) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, reorderedFlexItemAt.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine.mMaxBaseline = Math.max(flexLine.mMaxBaseline, (reorderedFlexItemAt.getMeasuredHeight() - reorderedFlexItemAt.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    i19 = i27;
                    if (isLastFlexItem(i14, i19, flexLine)) {
                        addFlexLine(arrayList, flexLine, i14, i16);
                        i16 += flexLine.mCrossSize;
                    }
                    if (i9 != -1 && arrayList.size() > 0) {
                        if (((FlexLine) AbstractC0157z.f(1, arrayList)).mLastIndex >= i9 && i14 >= i9 && !z9) {
                            i16 = -flexLine.getCrossSize();
                            z9 = true;
                        }
                    }
                    if (i16 > i7 && z9) {
                        i10 = iCombineMeasuredStates;
                        flexLinesResult.mChildState = i10;
                    } else {
                        i24 = iMax;
                        i26 = i17;
                    }
                }
                int i31 = i14 + 1;
                zIsMainAxisDirectionHorizontal = z7;
                flexLine3 = flexLine;
                i23 = i15;
                i25 = i16;
                i21 = i5;
                flexItemCount = i19;
                i22 = i31;
                mode = mode;
            }
            i14 = i22;
            mode = mode;
            i19 = flexItemCount;
            i16 = i25;
            z7 = zIsMainAxisDirectionHorizontal;
            i15 = i11;
            flexLine = flexLine3;
            int i32 = i14 + 1;
            zIsMainAxisDirectionHorizontal = z7;
            flexLine3 = flexLine;
            i23 = i15;
            i25 = i16;
            i21 = i5;
            flexItemCount = i19;
            i22 = i32;
            mode = mode;
        }
        i10 = iCombineMeasuredStates;
        flexLinesResult.mChildState = i10;
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i5, int i6) {
        calculateFlexLines(flexLinesResult, i5, i6, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i5, int i6, int i7, int i8, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i5, i6, i7, 0, i8, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i5, int i6) {
        calculateFlexLines(flexLinesResult, i6, i5, Integer.MAX_VALUE, 0, -1, null);
    }

    public void calculateVerticalFlexLinesToIndex(FlexLinesResult flexLinesResult, int i5, int i6, int i7, int i8, List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i6, i5, i7, 0, i8, list);
    }

    public void clearFlexLines(List<FlexLine> list, int i5) {
        int i6 = this.mIndexToFlexLine[i5];
        if (i6 == -1) {
            i6 = 0;
        }
        if (list.size() > i6) {
            list.subList(i6, list.size()).clear();
        }
        int[] iArr = this.mIndexToFlexLine;
        int length = iArr.length - 1;
        if (i5 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i5, length, -1);
        }
        long[] jArr = this.mMeasureSpecCache;
        int length2 = jArr.length - 1;
        if (i5 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i5, length2, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] createReorderedIndices(View view, int i5, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        List<Order> listCreateOrders = createOrders(flexItemCount);
        Order order = new Order();
        if (view == null || !(layoutParams instanceof FlexItem)) {
            order.order = 1;
        } else {
            order.order = ((FlexItem) layoutParams).getOrder();
        }
        if (i5 == -1 || i5 == flexItemCount || i5 >= this.mFlexContainer.getFlexItemCount()) {
            order.index = flexItemCount;
        } else {
            order.index = i5;
            while (i5 < flexItemCount) {
                listCreateOrders.get(i5).index++;
                i5++;
            }
        }
        listCreateOrders.add(order);
        return sortOrdersIntoReorderedIndices(flexItemCount + 1, listCreateOrders, sparseIntArray);
    }

    public void determineCrossSize(int i5, int i6, int i7) {
        int mode;
        int size;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i6);
            int size2 = View.MeasureSpec.getSize(i6);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(AbstractC0157z.k(flexDirection, "Invalid flex direction: "));
            }
            mode = View.MeasureSpec.getMode(i5);
            size = View.MeasureSpec.getSize(i5);
        }
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.mFlexContainer.getSumOfCrossSize() + i7;
            int i8 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).mCrossSize = size - i7;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    int i9 = size - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.mCrossSize = i9;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f6 = 0.0f;
                    while (i8 < size4) {
                        arrayList.add(flexLinesInternal.get(i8));
                        if (i8 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i8 == flexLinesInternal.size() - 2) {
                                flexLine2.mCrossSize = Math.round(f6 + size3);
                                f6 = 0.0f;
                            } else {
                                flexLine2.mCrossSize = Math.round(size3);
                            }
                            int i10 = flexLine2.mCrossSize;
                            float f7 = (size3 - i10) + f6;
                            if (f7 > 1.0f) {
                                flexLine2.mCrossSize = i10 + 1;
                                f7 -= 1.0f;
                            } else if (f7 < -1.0f) {
                                flexLine2.mCrossSize = i10 - 1;
                                f7 += 1.0f;
                            }
                            f6 = f7;
                            arrayList.add(flexLine2);
                        }
                        i8++;
                    }
                    this.mFlexContainer.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.mCrossSize = size5;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.mFlexContainer.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f8 = 0.0f;
                    while (i8 < size7) {
                        FlexLine flexLine5 = flexLinesInternal.get(i8);
                        float f9 = flexLine5.mCrossSize + size6;
                        if (i8 == flexLinesInternal.size() - 1) {
                            f9 += f8;
                            f8 = 0.0f;
                        }
                        int iRound = Math.round(f9);
                        float f10 = (f9 - iRound) + f8;
                        if (f10 > 1.0f) {
                            iRound++;
                            f10 -= 1.0f;
                        } else if (f10 < -1.0f) {
                            iRound--;
                            f10 += 1.0f;
                        }
                        f8 = f10;
                        flexLine5.mCrossSize = iRound;
                        i8++;
                    }
                }
            }
        }
    }

    public void determineMainSize(int i5, int i6) {
        determineMainSize(i5, i6, 0);
    }

    public void ensureIndexToFlexLine(int i5) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            this.mIndexToFlexLine = new int[Math.max(i5, 10)];
        } else if (iArr.length < i5) {
            this.mIndexToFlexLine = Arrays.copyOf(this.mIndexToFlexLine, Math.max(iArr.length * 2, i5));
        }
    }

    public void ensureMeasureSpecCache(int i5) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            this.mMeasureSpecCache = new long[Math.max(i5, 10)];
        } else if (jArr.length < i5) {
            this.mMeasureSpecCache = Arrays.copyOf(this.mMeasureSpecCache, Math.max(jArr.length * 2, i5));
        }
    }

    public void ensureMeasuredSizeCache(int i5) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            this.mMeasuredSizeCache = new long[Math.max(i5, 10)];
        } else if (jArr.length < i5) {
            this.mMeasuredSizeCache = Arrays.copyOf(this.mMeasuredSizeCache, Math.max(jArr.length * 2, i5));
        }
    }

    public int extractHigherInt(long j6) {
        return (int) (j6 >> 32);
    }

    public int extractLowerInt(long j6) {
        return (int) j6;
    }

    public boolean isOrderChangedFromLastMeasurement(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i5 = 0; i5 < flexItemCount; i5++) {
            View flexItemAt = this.mFlexContainer.getFlexItemAt(i5);
            if (flexItemAt != null && ((FlexItem) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i5)) {
                return true;
            }
        }
        return false;
    }

    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int i5, int i6, int i7, int i8) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i9 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i10 = i6 + i9;
                    view.layout(i5, (i10 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i7, i10 - flexItem.getMarginBottom());
                    return;
                } else {
                    view.layout(i5, view.getMeasuredHeight() + (i6 - i9) + flexItem.getMarginTop(), i7, view.getMeasuredHeight() + (i8 - i9) + flexItem.getMarginTop());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i9 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int i11 = i6 + measuredHeight;
                    view.layout(i5, i11, i7, view.getMeasuredHeight() + i11);
                    return;
                } else {
                    int i12 = i6 - measuredHeight;
                    view.layout(i5, i12, i7, view.getMeasuredHeight() + i12);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.mFlexContainer.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i5, i6 + iMax, i7, i8 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (flexLine.mMaxBaseline - view.getMeasuredHeight()), flexItem.getMarginBottom());
                    view.layout(i5, i6 - iMax2, i7, i8 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(i5, i6 + flexItem.getMarginTop(), i7, i8 + flexItem.getMarginTop());
        } else {
            view.layout(i5, i6 - flexItem.getMarginBottom(), i7, i8 - flexItem.getMarginBottom());
        }
    }

    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean z6, int i5, int i6, int i7, int i8) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i9 = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z6) {
                    view.layout(((i5 + i9) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i6, ((i7 + i9) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i8);
                    return;
                }
                view.layout(view.getMeasuredWidth() + (i5 - i9) + flexItem.getMarginLeft(), i6, view.getMeasuredWidth() + (i7 - i9) + flexItem.getMarginLeft(), i8);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int marginStart = ((MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + (i9 - view.getMeasuredWidth())) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z6) {
                    view.layout(i5 - marginStart, i6, i7 - marginStart, i8);
                    return;
                } else {
                    view.layout(i5 + marginStart, i6, i7 + marginStart, i8);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z6) {
            view.layout(i5 - flexItem.getMarginRight(), i6, i7 - flexItem.getMarginRight(), i8);
        } else {
            view.layout(i5 + flexItem.getMarginLeft(), i6, i7 + flexItem.getMarginLeft(), i8);
        }
    }

    @VisibleForTesting
    public long makeCombinedLong(int i5, int i6) {
        return (((long) i5) & 4294967295L) | (((long) i6) << 32);
    }

    public void stretchViews() {
        stretchViews(0);
    }

    public void calculateHorizontalFlexLines(FlexLinesResult flexLinesResult, int i5, int i6, int i7, int i8, @Nullable List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i5, i6, i7, i8, -1, list);
    }

    public void calculateVerticalFlexLines(FlexLinesResult flexLinesResult, int i5, int i6, int i7, int i8, @Nullable List<FlexLine> list) {
        calculateFlexLines(flexLinesResult, i6, i5, i7, i8, -1, list);
    }

    public void determineMainSize(int i5, int i6, int i7) {
        int size;
        int paddingLeft;
        int paddingRight;
        int i8;
        int i9;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (i7 >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int flexDirection2 = this.mFlexContainer.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i5);
            size = View.MeasureSpec.getSize(i5);
            int largestMainSize = this.mFlexContainer.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.mFlexContainer.getPaddingLeft();
            paddingRight = this.mFlexContainer.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(AbstractC0157z.k(flexDirection, "Invalid flex direction: "));
            }
            int mode2 = View.MeasureSpec.getMode(i6);
            size = View.MeasureSpec.getSize(i6);
            if (mode2 != 1073741824) {
                size = this.mFlexContainer.getLargestMainSize();
            }
            paddingLeft = this.mFlexContainer.getPaddingTop();
            paddingRight = this.mFlexContainer.getPaddingBottom();
        }
        int i10 = paddingLeft + paddingRight;
        int i11 = size;
        int[] iArr = this.mIndexToFlexLine;
        int i12 = iArr != null ? iArr[i7] : 0;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        while (i12 < size2) {
            FlexLine flexLine = flexLinesInternal.get(i12);
            int i13 = flexLine.mMainSize;
            if (i13 >= i11 || !flexLine.mAnyItemsHaveFlexGrow) {
                i8 = i5;
                i9 = i6;
                if (i13 > i11 && flexLine.mAnyItemsHaveFlexShrink) {
                    shrinkFlexItems(i8, i9, flexLine, i11, i10, false);
                }
            } else {
                i8 = i5;
                i9 = i6;
                expandFlexItems(i8, i9, flexLine, i11, i10, false);
            }
            i12++;
            i5 = i8;
            i6 = i9;
        }
    }

    public void stretchViews(int i5) {
        View reorderedFlexItemAt;
        if (i5 >= this.mFlexContainer.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.mFlexContainer.getFlexDirection();
        if (this.mFlexContainer.getAlignItems() != 4) {
            for (FlexLine flexLine : this.mFlexContainer.getFlexLinesInternal()) {
                for (Integer num : flexLine.mIndicesAlignSelfStretch) {
                    View reorderedFlexItemAt2 = this.mFlexContainer.getReorderedFlexItemAt(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        stretchViewVertically(reorderedFlexItemAt2, flexLine.mCrossSize, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(AbstractC0157z.k(flexDirection, "Invalid flex direction: "));
                        }
                        stretchViewHorizontally(reorderedFlexItemAt2, flexLine.mCrossSize, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.mIndexToFlexLine;
        List<FlexLine> flexLinesInternal = this.mFlexContainer.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i6 = iArr != null ? iArr[i5] : 0; i6 < size; i6++) {
            FlexLine flexLine2 = flexLinesInternal.get(i6);
            int i7 = flexLine2.mItemCount;
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = flexLine2.mFirstIndex + i8;
                if (i8 < this.mFlexContainer.getFlexItemCount() && (reorderedFlexItemAt = this.mFlexContainer.getReorderedFlexItemAt(i9)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) reorderedFlexItemAt.getLayoutParams();
                    if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            stretchViewVertically(reorderedFlexItemAt, flexLine2.mCrossSize, i9);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(AbstractC0157z.k(flexDirection, "Invalid flex direction: "));
                            }
                            stretchViewHorizontally(reorderedFlexItemAt, flexLine2.mCrossSize, i9);
                        }
                    }
                }
            }
        }
    }

    public int[] createReorderedIndices(SparseIntArray sparseIntArray) {
        int flexItemCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(flexItemCount, createOrders(flexItemCount), sparseIntArray);
    }
}
