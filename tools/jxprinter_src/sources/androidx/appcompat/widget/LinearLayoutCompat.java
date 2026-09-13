package androidx.appcompat.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DividerMode {
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(int i5, int i6, float f6) {
            super(i5, i6, f6);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    private void forceUniformHeight(int i5, int i6) {
        int i7;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i9 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    i7 = i6;
                    measureChildWithMargins(virtualChildAt, i7, 0, iMakeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i9;
                } else {
                    i7 = i6;
                }
            } else {
                i7 = i6;
            }
            i8++;
            i6 = i7;
        }
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    private void forceUniformWidth(int i5, int i6) {
        int i7;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View virtualChildAt = getVirtualChildAt(i8);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i9 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    i7 = i6;
                    measureChildWithMargins(virtualChildAt, iMakeMeasureSpec, 0, i7, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i9;
                } else {
                    i7 = i6;
                }
            } else {
                i7 = i6;
            }
            i8++;
            i6 = i7;
        }
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i5;
        int virtualChildCount = getVirtualChildCount();
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View virtualChildAt = getVirtualChildAt(i6);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i6)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, zIsLayoutRtl ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (zIsLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i5 = this.mDividerWidth;
                    right = left - i5;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zIsLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.mDividerWidth;
                right = left - i5;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i5)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i5, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i5);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(i5, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i5, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i5;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.mBaselineAlignedChildIndex;
        if (childCount <= i6) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i6);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int iB = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i5 = this.mGravity & 112) != 48) {
            if (i5 == 16) {
                iB = AbstractC0157z.b(((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom(), this.mTotalLength, 2, iB);
            } else if (i5 == 80) {
                iB = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return iB + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i5) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @GravityInt
    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int i5) {
        return getChildAt(i5);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i5) {
        if (i5 == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i5 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) != 0) {
            for (int i6 = i5 - 1; i6 >= 0; i6--) {
                if (getChildAt(i6).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:32:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:47:0x0100  */
    /* JADX WARN: Code duplicated, block: B:48:0x0105  */
    public void layoutHorizontal(int i5, int i6, int i7, int i8) {
        int iB;
        int i9;
        int i10;
        char c;
        int i11;
        int childrenSkipCount;
        int baseline;
        int i12;
        int i13;
        int iB2;
        int measuredHeight;
        int i14;
        boolean zIsLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i15 = i8 - i6;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        boolean z6 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i16, ViewCompat.getLayoutDirection(this));
        int i18 = 2;
        char c6 = 1;
        if (absoluteGravity != 1) {
            iB = absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i7) - i5) - this.mTotalLength;
        } else {
            iB = AbstractC0157z.b(i7 - i5, this.mTotalLength, 2, getPaddingLeft());
        }
        if (zIsLayoutRtl) {
            i9 = virtualChildCount - 1;
            i10 = -1;
        } else {
            i9 = 0;
            i10 = 1;
        }
        int i19 = 0;
        while (i19 < virtualChildCount) {
            int i20 = (i10 * i19) + i9;
            int i21 = i19;
            View virtualChildAt = getVirtualChildAt(i20);
            if (virtualChildAt == null) {
                iB = measureNullChild(i20) + iB;
                childrenSkipCount = i21;
                i11 = paddingBottom;
                c = c6;
            } else {
                c = c6;
                int i22 = i18;
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight2 = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i23 = iB;
                    if (z6) {
                        i11 = paddingBottom;
                        baseline = ((LinearLayout.LayoutParams) layoutParams).height != -1 ? virtualChildAt.getBaseline() : -1;
                        i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i12 < 0) {
                            i12 = i17;
                        }
                        i13 = i12 & 112;
                        if (i13 != 16) {
                            if (i13 != 48) {
                                iB2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                                if (baseline != -1) {
                                    iB2 = (iArr[c] - baseline) + iB2;
                                }
                            } else if (i13 != 80) {
                                iB2 = paddingTop;
                            } else {
                                iB2 = (i11 - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                if (baseline != -1) {
                                    measuredHeight = iArr2[i22] - (virtualChildAt.getMeasuredHeight() - baseline);
                                }
                            }
                            if (hasDividerBeforeChildAt(i20)) {
                                i14 = i23 + this.mDividerWidth;
                            } else {
                                i14 = i23;
                            }
                            int i24 = i14 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                            setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i24, iB2, measuredWidth, measuredHeight2);
                            iB = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i24;
                            childrenSkipCount = getChildrenSkipCount(virtualChildAt, i20) + i21;
                        } else {
                            iB2 = AbstractC0157z.b(paddingBottom2, measuredHeight2, i22, paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                            measuredHeight = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                        iB2 -= measuredHeight;
                        if (hasDividerBeforeChildAt(i20)) {
                            i14 = i23 + this.mDividerWidth;
                        } else {
                            i14 = i23;
                        }
                        int i25 = i14 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i25, iB2, measuredWidth, measuredHeight2);
                        iB = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i25;
                        childrenSkipCount = getChildrenSkipCount(virtualChildAt, i20) + i21;
                    } else {
                        i11 = paddingBottom;
                    }
                    i12 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i12 < 0) {
                        i12 = i17;
                    }
                    i13 = i12 & 112;
                    if (i13 != 16) {
                        if (i13 != 48) {
                            iB2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                            if (baseline != -1) {
                                iB2 = (iArr[c] - baseline) + iB2;
                            }
                        } else if (i13 != 80) {
                            iB2 = paddingTop;
                        } else {
                            iB2 = (i11 - measuredHeight2) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight = iArr2[i22] - (virtualChildAt.getMeasuredHeight() - baseline);
                            }
                        }
                        if (hasDividerBeforeChildAt(i20)) {
                            i14 = i23 + this.mDividerWidth;
                        } else {
                            i14 = i23;
                        }
                        int i26 = i14 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i26, iB2, measuredWidth, measuredHeight2);
                        iB = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i26;
                        childrenSkipCount = getChildrenSkipCount(virtualChildAt, i20) + i21;
                    } else {
                        iB2 = AbstractC0157z.b(paddingBottom2, measuredHeight2, i22, paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        measuredHeight = ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    iB2 -= measuredHeight;
                    if (hasDividerBeforeChildAt(i20)) {
                        i14 = i23 + this.mDividerWidth;
                    } else {
                        i14 = i23;
                    }
                    int i27 = i14 + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    setChildFrame(virtualChildAt, getLocationOffset(virtualChildAt) + i27, iB2, measuredWidth, measuredHeight2);
                    iB = getNextLocationOffset(virtualChildAt) + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + i27;
                    childrenSkipCount = getChildrenSkipCount(virtualChildAt, i20) + i21;
                } else {
                    i11 = paddingBottom;
                    childrenSkipCount = i21;
                }
            }
            i19 = childrenSkipCount + 1;
            c6 = c;
            paddingBottom = i11;
            virtualChildCount = virtualChildCount;
            i18 = 2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    public void layoutVertical(int i5, int i6, int i7, int i8) {
        int iB;
        int iB2;
        int i9;
        int i10;
        int paddingLeft = getPaddingLeft();
        int i11 = i7 - i5;
        int paddingRight = i11 - getPaddingRight();
        int paddingRight2 = (i11 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.mGravity;
        int i13 = i12 & 112;
        int i14 = i12 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i13 != 16) {
            iB = i13 != 80 ? getPaddingTop() : ((getPaddingTop() + i8) - i6) - this.mTotalLength;
        } else {
            iB = AbstractC0157z.b(i8 - i6, this.mTotalLength, 2, getPaddingTop());
        }
        int childrenSkipCount = 0;
        while (childrenSkipCount < virtualChildCount) {
            int nextLocationOffset = iB;
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                iB = measureNullChild(childrenSkipCount) + nextLocationOffset;
            } else {
                if (virtualChildAt.getVisibility() != 8) {
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    int measuredHeight = virtualChildAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    int i15 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i15 < 0) {
                        i15 = i14;
                    }
                    int absoluteGravity = GravityCompat.getAbsoluteGravity(i15, ViewCompat.getLayoutDirection(this)) & 7;
                    if (absoluteGravity != 1) {
                        if (absoluteGravity != 5) {
                            i10 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        } else {
                            iB2 = paddingRight - measuredWidth;
                            i9 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        }
                        if (hasDividerBeforeChildAt(childrenSkipCount)) {
                            nextLocationOffset += this.mDividerHeight;
                        }
                        int i16 = ((LinearLayout.LayoutParams) layoutParams).topMargin + nextLocationOffset;
                        setChildFrame(virtualChildAt, i10, getLocationOffset(virtualChildAt) + i16, measuredWidth, measuredHeight);
                        nextLocationOffset = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i16;
                        childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                    } else {
                        iB2 = AbstractC0157z.b(paddingRight2, measuredWidth, 2, paddingLeft) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        i9 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i10 = iB2 - i9;
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        nextLocationOffset += this.mDividerHeight;
                    }
                    int i17 = ((LinearLayout.LayoutParams) layoutParams).topMargin + nextLocationOffset;
                    setChildFrame(virtualChildAt, i10, getLocationOffset(virtualChildAt) + i17, measuredWidth, measuredHeight);
                    nextLocationOffset = getNextLocationOffset(virtualChildAt) + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i17;
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                }
                iB = nextLocationOffset;
            }
            childrenSkipCount++;
        }
    }

    public void measureChildBeforeLayout(View view, int i5, int i6, int i7, int i8, int i9) {
        measureChildWithMargins(view, i6, i7, i8, i9);
    }

    /* JADX WARN: Code duplicated, block: B:203:0x0463  */
    public void measureHorizontal(int i5, int i6) {
        int i7;
        int i8;
        float f6;
        int i9;
        int i10;
        int i11;
        int i12;
        int iMax;
        int i13;
        int baseline;
        int i14;
        int i15;
        byte b;
        int i16;
        int i17;
        int i18;
        boolean z6;
        View view;
        boolean z7;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.mBaselineAligned;
        boolean z9 = this.mUseLargestChild;
        int i19 = 1073741824;
        boolean z10 = mode == 1073741824;
        boolean z11 = z9;
        int childrenSkipCount = 0;
        int i20 = 0;
        int iMax2 = 0;
        boolean z12 = false;
        int iCombineMeasuredStates = 0;
        boolean z13 = false;
        boolean z14 = true;
        float f7 = 0.0f;
        int iMax3 = 0;
        int iMax4 = 0;
        while (true) {
            i7 = i20;
            if (childrenSkipCount >= virtualChildCount) {
                break;
            }
            boolean z15 = z8;
            View virtualChildAt = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount) + this.mTotalLength;
            } else {
                if (virtualChildAt.getVisibility() == 8) {
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt, childrenSkipCount);
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        this.mTotalLength += this.mDividerWidth;
                    }
                    LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                    float f8 = ((LinearLayout.LayoutParams) layoutParams).weight;
                    float f9 = f7 + f8;
                    if (mode == i19 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f8 > 0.0f) {
                        if (z10) {
                            this.mTotalLength = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                        } else {
                            int i21 = this.mTotalLength;
                            this.mTotalLength = Math.max(i21, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i21 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z15) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            virtualChildAt.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        } else {
                            z12 = true;
                        }
                        i17 = i7;
                        i18 = 1073741824;
                        z6 = z11;
                        view = virtualChildAt;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f8 <= 0.0f) {
                            b = -2;
                            i16 = Integer.MIN_VALUE;
                        } else {
                            b = -2;
                            ((LinearLayout.LayoutParams) layoutParams).width = -2;
                            i16 = 0;
                        }
                        virtualChildCount = virtualChildCount;
                        mode = mode;
                        iArr = iArr;
                        i17 = i7;
                        i18 = 1073741824;
                        z6 = z11;
                        iArr2 = iArr2;
                        int i22 = i16;
                        measureChildBeforeLayout(virtualChildAt, childrenSkipCount, i5, f9 == 0.0f ? this.mTotalLength : 0, i6, 0);
                        view = virtualChildAt;
                        if (i22 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams).width = i22;
                        }
                        int measuredWidth = view.getMeasuredWidth();
                        if (z10) {
                            this.mTotalLength = getNextLocationOffset(view) + ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + this.mTotalLength;
                        } else {
                            int i23 = this.mTotalLength;
                            this.mTotalLength = Math.max(i23, getNextLocationOffset(view) + i23 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                        }
                        if (z6) {
                            iMax2 = Math.max(measuredWidth, iMax2);
                        }
                    }
                    if (mode2 == i18 || ((LinearLayout.LayoutParams) layoutParams).height != -1) {
                        z7 = false;
                    } else {
                        z7 = true;
                        z13 = true;
                    }
                    int i24 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    int measuredHeight = view.getMeasuredHeight() + i24;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z15 && (baseline2 = view.getBaseline()) != -1) {
                        int i25 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i25 < 0) {
                            i25 = this.mGravity;
                        }
                        int i26 = (((i25 & 112) >> 4) & (-2)) >> 1;
                        iArr[i26] = Math.max(iArr[i26], baseline2);
                        iArr2[i26] = Math.max(iArr2[i26], measuredHeight - baseline2);
                    }
                    int iMax5 = Math.max(i17, measuredHeight);
                    z14 = z14 && ((LinearLayout.LayoutParams) layoutParams).height == -1;
                    if (((LinearLayout.LayoutParams) layoutParams).weight > 0.0f) {
                        if (!z7) {
                            i24 = measuredHeight;
                        }
                        iMax4 = Math.max(iMax4, i24);
                    } else {
                        if (z7 == 0) {
                            i24 = measuredHeight;
                        }
                        iMax3 = Math.max(iMax3, i24);
                    }
                    childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                    i20 = iMax5;
                    f7 = f9;
                }
                childrenSkipCount++;
                z11 = z6;
                iArr2 = iArr2;
                z8 = z15;
                mode = mode;
                iArr = iArr;
                virtualChildCount = virtualChildCount;
                i19 = 1073741824;
            }
            virtualChildCount = virtualChildCount;
            mode = mode;
            iArr = iArr;
            iArr2 = iArr2;
            i20 = i7;
            z6 = z11;
            childrenSkipCount++;
            z11 = z6;
            iArr2 = iArr2;
            z8 = z15;
            mode = mode;
            iArr = iArr;
            virtualChildCount = virtualChildCount;
            i19 = 1073741824;
        }
        boolean z16 = z8;
        int i27 = virtualChildCount;
        int i28 = mode;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i29 = iCombineMeasuredStates;
        boolean z17 = z11;
        if (this.mTotalLength > 0) {
            i8 = i27;
            if (hasDividerBeforeChildAt(i8)) {
                this.mTotalLength += this.mDividerWidth;
            }
        } else {
            i8 = i27;
        }
        int i30 = iArr3[1];
        int iMax6 = (i30 == -1 && iArr3[0] == -1 && iArr3[2] == -1 && iArr3[3] == -1) ? i7 : Math.max(i7, Math.max(iArr4[3], Math.max(iArr4[0], Math.max(iArr4[1], iArr4[2]))) + Math.max(iArr3[3], Math.max(iArr3[0], Math.max(i30, iArr3[2]))));
        if (z17) {
            i9 = i28;
            if (i9 == Integer.MIN_VALUE || i9 == 0) {
                this.mTotalLength = 0;
                int childrenSkipCount2 = 0;
                while (childrenSkipCount2 < i8) {
                    View virtualChildAt2 = getVirtualChildAt(childrenSkipCount2);
                    if (virtualChildAt2 == null) {
                        this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
                    } else {
                        if (virtualChildAt2.getVisibility() == 8) {
                            childrenSkipCount2 += getChildrenSkipCount(virtualChildAt2, childrenSkipCount2);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            if (z10) {
                                this.mTotalLength = getNextLocationOffset(virtualChildAt2) + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + this.mTotalLength;
                            } else {
                                f7 = f7;
                                int i31 = this.mTotalLength;
                                this.mTotalLength = Math.max(i31, getNextLocationOffset(virtualChildAt2) + i31 + iMax2 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin);
                            }
                        }
                        childrenSkipCount2++;
                        f7 = f7;
                        iMax6 = iMax6;
                    }
                    childrenSkipCount2++;
                    f7 = f7;
                    iMax6 = iMax6;
                }
            }
            f6 = f7;
        } else {
            f6 = f7;
            i9 = i28;
        }
        int iMax7 = iMax6;
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
        this.mTotalLength = paddingRight;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i5, 0);
        int i32 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
        if (z12 || (i32 != 0 && f6 > 0.0f)) {
            float f10 = this.mWeightSum;
            if (f10 > 0.0f) {
                f6 = f10;
            }
            iArr3[3] = -1;
            iArr3[2] = -1;
            iArr3[1] = -1;
            iArr3[0] = -1;
            iArr4[3] = -1;
            iArr4[2] = -1;
            iArr4[1] = -1;
            iArr4[0] = -1;
            this.mTotalLength = 0;
            int iCombineMeasuredStates2 = i29;
            int iMax8 = -1;
            int i33 = 0;
            while (i33 < i8) {
                View virtualChildAt3 = getVirtualChildAt(i33);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    iResolveSizeAndState = iResolveSizeAndState;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f11 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f11 > 0.0f) {
                        int i34 = (int) ((i32 * f11) / f6);
                        f6 -= f11;
                        i32 -= i34;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingBottom() + getPaddingTop() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i15 = 1073741824;
                            if (i9 == 1073741824) {
                                if (i34 <= 0) {
                                    i34 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i34, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                        } else {
                            i15 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i34;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i15), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                    }
                    if (z10) {
                        this.mTotalLength = getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + this.mTotalLength;
                    } else {
                        int i35 = this.mTotalLength;
                        this.mTotalLength = Math.max(i35, getNextLocationOffset(virtualChildAt3) + virtualChildAt3.getMeasuredWidth() + i35 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin);
                    }
                    boolean z18 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i36 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i36;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z18) {
                        i36 = measuredHeight2;
                    }
                    int iMax9 = Math.max(iMax3, i36);
                    if (z14) {
                        i13 = -1;
                        boolean z19 = ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                        if (z16 && (baseline = virtualChildAt3.getBaseline()) != i13) {
                            i14 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                            if (i14 < 0) {
                                i14 = this.mGravity;
                            }
                            int i37 = (((i14 & 112) >> 4) & (-2)) >> 1;
                            iArr3[i37] = Math.max(iArr3[i37], baseline);
                            iArr4[i37] = Math.max(iArr4[i37], measuredHeight2 - baseline);
                        }
                        iMax3 = iMax9;
                        z14 = z19;
                    } else {
                        i13 = -1;
                    }
                    if (z16) {
                        i14 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i14 < 0) {
                            i14 = this.mGravity;
                        }
                        int i38 = (((i14 & 112) >> 4) & (-2)) >> 1;
                        iArr3[i38] = Math.max(iArr3[i38], baseline);
                        iArr4[i38] = Math.max(iArr4[i38], measuredHeight2 - baseline);
                    }
                    iMax3 = iMax9;
                    z14 = z19;
                }
                i33++;
                iResolveSizeAndState = iResolveSizeAndState;
            }
            i10 = iResolveSizeAndState;
            i11 = ViewCompat.MEASURED_STATE_MASK;
            this.mTotalLength = getPaddingRight() + getPaddingLeft() + this.mTotalLength;
            int i39 = iArr3[1];
            iMax7 = (i39 == -1 && iArr3[0] == -1 && iArr3[2] == -1 && iArr3[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr4[3], Math.max(iArr4[0], Math.max(iArr4[1], iArr4[2]))) + Math.max(iArr3[3], Math.max(iArr3[0], Math.max(i39, iArr3[2]))));
            i12 = iCombineMeasuredStates2;
            iMax = iMax3;
        } else {
            iMax = Math.max(iMax3, iMax4);
            if (z17 && i9 != 1073741824) {
                for (int i40 = 0; i40 < i8; i40++) {
                    View virtualChildAt4 = getVirtualChildAt(i40);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i10 = iResolveSizeAndState;
            i12 = i29;
            i11 = ViewCompat.MEASURED_STATE_MASK;
        }
        if (z14 || mode2 == 1073741824) {
            iMax = iMax7;
        }
        setMeasuredDimension(i10 | (i12 & i11), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + iMax, getSuggestedMinimumHeight()), i6, i12 << 16));
        if (z13) {
            forceUniformHeight(i8, i5);
        }
    }

    public int measureNullChild(int i5) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0156 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x0159  */
    /* JADX WARN: Code duplicated, block: B:68:0x0160 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x0163  */
    public void measureVertical(int i5, int i6) {
        int i7;
        int iMax;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View view;
        boolean z6;
        int iMax2;
        boolean z7;
        int iMax3;
        int i17;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int i18 = this.mBaselineAlignedChildIndex;
        boolean z8 = this.mUseLargestChild;
        int childrenSkipCount = 0;
        int i19 = 0;
        int iMax4 = 0;
        int i20 = 0;
        int i21 = 0;
        int iMax5 = 0;
        boolean z9 = false;
        boolean z10 = false;
        float f6 = 0.0f;
        boolean z11 = true;
        while (true) {
            int i22 = 8;
            if (childrenSkipCount >= virtualChildCount) {
                float f7 = f6;
                int i23 = i19;
                int i24 = virtualChildCount;
                int i25 = mode2;
                boolean z12 = z8;
                int i26 = iMax4;
                int iMax6 = i20;
                int iCombineMeasuredStates = i21;
                if (this.mTotalLength > 0) {
                    i7 = i24;
                    if (hasDividerBeforeChildAt(i7)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i7 = i24;
                }
                int i27 = i25;
                if (z12 && (i27 == Integer.MIN_VALUE || i27 == 0)) {
                    this.mTotalLength = 0;
                    int childrenSkipCount2 = 0;
                    while (childrenSkipCount2 < i7) {
                        View virtualChildAt = getVirtualChildAt(childrenSkipCount2);
                        if (virtualChildAt == null) {
                            this.mTotalLength = measureNullChild(childrenSkipCount2) + this.mTotalLength;
                        } else if (virtualChildAt.getVisibility() == i22) {
                            childrenSkipCount2 += getChildrenSkipCount(virtualChildAt, childrenSkipCount2);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i28 = this.mTotalLength;
                            this.mTotalLength = Math.max(i28, getNextLocationOffset(virtualChildAt) + i28 + i26 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin);
                        }
                        childrenSkipCount2++;
                        i22 = 8;
                    }
                }
                int paddingBottom = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                this.mTotalLength = paddingBottom;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i6, 0);
                int i29 = (16777215 & iResolveSizeAndState) - this.mTotalLength;
                if (z9 || (i29 != 0 && f7 > 0.0f)) {
                    float f8 = this.mWeightSum;
                    if (f8 <= 0.0f) {
                        f8 = f7;
                    }
                    this.mTotalLength = 0;
                    float f9 = f8;
                    int i30 = i29;
                    int i31 = 0;
                    while (i31 < i7) {
                        View virtualChildAt2 = getVirtualChildAt(i31);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i27 = i27;
                            i31 = i31;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f10 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f10 > 0.0f) {
                                int i32 = (int) ((i30 * f10) / f9);
                                f9 -= f10;
                                i30 -= i32;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingRight() + getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i9 = 1073741824;
                                    if (i27 == 1073741824) {
                                        virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i32 > 0 ? i32 : 0, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                } else {
                                    i9 = 1073741824;
                                }
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i32;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i9));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, virtualChildAt2.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                            } else {
                                i27 = i27;
                            }
                            int i33 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i33;
                            iMax6 = Math.max(iMax6, measuredWidth);
                            if (mode != 1073741824) {
                                i8 = -1;
                                if (((LinearLayout.LayoutParams) layoutParams2).width == -1) {
                                    measuredWidth = i33;
                                }
                            } else {
                                i8 = -1;
                            }
                            int iMax7 = Math.max(iMax5, measuredWidth);
                            boolean z13 = z11 && ((LinearLayout.LayoutParams) layoutParams2).width == i8;
                            int i34 = this.mTotalLength;
                            this.mTotalLength = Math.max(i34, getNextLocationOffset(virtualChildAt2) + virtualChildAt2.getMeasuredHeight() + i34 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin);
                            iMax5 = iMax7;
                            z11 = z13;
                        }
                        i31++;
                        i27 = i27;
                    }
                    this.mTotalLength = getPaddingBottom() + getPaddingTop() + this.mTotalLength;
                    iMax = iMax5;
                } else {
                    iMax = Math.max(iMax5, i23);
                    if (z12 && i27 != 1073741824) {
                        for (int i35 = 0; i35 < i7; i35++) {
                            View virtualChildAt3 = getVirtualChildAt(i35);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i26, 1073741824));
                            }
                        }
                    }
                }
                if (!z11 && mode != 1073741824) {
                    iMax6 = iMax;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + iMax6, getSuggestedMinimumWidth()), i5, iCombineMeasuredStates), iResolveSizeAndState);
                if (z10) {
                    forceUniformWidth(i7, i6);
                    return;
                }
                return;
            }
            float f11 = f6;
            View virtualChildAt4 = getVirtualChildAt(childrenSkipCount);
            if (virtualChildAt4 == null) {
                this.mTotalLength = measureNullChild(childrenSkipCount) + this.mTotalLength;
            } else {
                if (virtualChildAt4.getVisibility() == 8) {
                    childrenSkipCount += getChildrenSkipCount(virtualChildAt4, childrenSkipCount);
                } else {
                    if (hasDividerBeforeChildAt(childrenSkipCount)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f12 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    float f13 = f11 + f12;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f12 > 0.0f) {
                        int i36 = this.mTotalLength;
                        this.mTotalLength = Math.max(i36, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i36 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        iMax2 = i19;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        z9 = true;
                        i16 = i20;
                        i15 = i21;
                        z6 = z8;
                    } else {
                        if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || f12 <= 0.0f) {
                            i10 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i10 = 0;
                        }
                        if (f13 == 0.0f) {
                            int i37 = i21;
                            i12 = this.mTotalLength;
                            i11 = i37;
                        } else {
                            i11 = i21;
                            i12 = 0;
                        }
                        int i38 = iMax4;
                        i13 = virtualChildCount;
                        i14 = mode2;
                        i15 = i11;
                        i16 = i20;
                        view = virtualChildAt4;
                        z6 = z8;
                        iMax2 = i19;
                        measureChildBeforeLayout(view, childrenSkipCount, i5, 0, i6, i12);
                        if (i10 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i10;
                        }
                        int measuredHeight2 = view.getMeasuredHeight();
                        int i39 = this.mTotalLength;
                        this.mTotalLength = Math.max(i39, getNextLocationOffset(view) + i39 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        iMax4 = z6 ? Math.max(measuredHeight2, i38) : i38;
                    }
                    if (i18 >= 0 && i18 == childrenSkipCount + 1) {
                        view = virtualChildAt4;
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (childrenSkipCount < i18 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z7 = false;
                    } else {
                        z7 = true;
                        z10 = true;
                    }
                    int i40 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i40;
                    iMax3 = Math.max(i16, measuredWidth2);
                    int i41 = iMax4;
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i15, view.getMeasuredState());
                    if (z11) {
                        i17 = iCombineMeasuredStates2;
                        z11 = ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                        if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                            if (!z7) {
                                i40 = measuredWidth2;
                            }
                            iMax2 = Math.max(iMax2, i40);
                        } else {
                            if (!z7) {
                                i40 = measuredWidth2;
                            }
                            iMax5 = Math.max(iMax5, i40);
                        }
                        childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                        f6 = f13;
                        iMax4 = i41;
                        i21 = i17;
                    } else {
                        i17 = iCombineMeasuredStates2;
                    }
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z7) {
                            i40 = measuredWidth2;
                        }
                        iMax2 = Math.max(iMax2, i40);
                    } else {
                        if (!z7) {
                            i40 = measuredWidth2;
                        }
                        iMax5 = Math.max(iMax5, i40);
                    }
                    childrenSkipCount += getChildrenSkipCount(view, childrenSkipCount);
                    f6 = f13;
                    iMax4 = i41;
                    i21 = i17;
                }
                childrenSkipCount++;
                i20 = iMax3;
                i19 = iMax2;
                z8 = z6;
                mode2 = i14;
                virtualChildCount = i13;
            }
            iMax2 = i19;
            i13 = virtualChildCount;
            i14 = mode2;
            z6 = z8;
            f6 = f11;
            iMax3 = i20;
            childrenSkipCount++;
            i20 = iMax3;
            i19 = iMax2;
            z8 = z6;
            mode2 = i14;
            virtualChildCount = i13;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        if (this.mOrientation == 1) {
            layoutVertical(i5, i6, i7, i8);
        } else {
            layoutHorizontal(i5, i6, i7, i8);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        if (this.mOrientation == 1) {
            measureVertical(i5, i6);
        } else {
            measureHorizontal(i5, i6);
        }
    }

    public void setBaselineAligned(boolean z6) {
        this.mBaselineAligned = z6;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 >= 0 && i5 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i5;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i5) {
        this.mDividerPadding = i5;
    }

    public void setGravity(@GravityInt int i5) {
        if (this.mGravity != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= GravityCompat.START;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.mGravity = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i7 = this.mGravity;
        if ((8388615 & i7) != i6) {
            this.mGravity = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z6) {
        this.mUseLargestChild = z6;
    }

    public void setOrientation(int i5) {
        if (this.mOrientation != i5) {
            this.mOrientation = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.mGravity;
        if ((i7 & 112) != i6) {
            this.mGravity = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f6) {
        this.mWeightSum = Math.max(0.0f, f6);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i5 = this.mOrientation;
        if (i5 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i5 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R.styleable.LinearLayoutCompat;
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, tintTypedArrayObtainStyledAttributes.getWrappedTypeArray(), i5, 0);
        int i6 = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i6 >= 0) {
            setOrientation(i6);
        }
        int i7 = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i7 >= 0) {
            setGravity(i7);
        }
        boolean z6 = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z6) {
            setBaselineAligned(z6);
        }
        this.mWeightSum = tintTypedArrayObtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = tintTypedArrayObtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(tintTypedArrayObtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = tintTypedArrayObtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        tintTypedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
