package androidx.appcompat.widget;

import A3.AbstractC0157z;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(@Nullable Context context) {
        super(context);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0036  */
    private void forceUniformWidth(int i5, int i6) {
        int i7;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        int i8 = 0;
        while (i8 < i5) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i9 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    i7 = i6;
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i7, 0);
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

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    private boolean tryOnMeasure(int i5, int i6) {
        int iCombineMeasuredStates;
        int iResolveMinimumHeight;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i5);
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (view != null) {
            view.measure(i5, 0);
            paddingBottom += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i5, 0);
            iResolveMinimumHeight = resolveMinimumHeight(view2);
            measuredHeight = view2.getMeasuredHeight() - iResolveMinimumHeight;
            paddingBottom += iResolveMinimumHeight;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iResolveMinimumHeight = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i5, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingBottom), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingBottom += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i8 = size - paddingBottom;
        if (view2 != null) {
            int i9 = paddingBottom - iResolveMinimumHeight;
            int iMin = Math.min(i8, measuredHeight);
            if (iMin > 0) {
                i8 -= iMin;
                iResolveMinimumHeight += iMin;
            }
            view2.measure(i5, View.MeasureSpec.makeMeasureSpec(iResolveMinimumHeight, 1073741824));
            paddingBottom = i9 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i8 > 0) {
            view3.measure(i5, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i8, mode));
            paddingBottom = (paddingBottom - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt2 = getChildAt(i10);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + iMax, i5, iCombineMeasuredStates), View.resolveSizeAndState(paddingBottom, i6, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i6);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a9  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        int paddingTop;
        int iB;
        int i9;
        int i10;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = alertDialogLayout.getPaddingLeft();
        int i11 = i7 - i5;
        int paddingRight = i11 - alertDialogLayout.getPaddingRight();
        int paddingRight2 = (i11 - paddingLeft) - alertDialogLayout.getPaddingRight();
        int measuredHeight = alertDialogLayout.getMeasuredHeight();
        int childCount = alertDialogLayout.getChildCount();
        int gravity = alertDialogLayout.getGravity();
        int i12 = gravity & 112;
        int i13 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i12 != 16) {
            paddingTop = i12 != 80 ? alertDialogLayout.getPaddingTop() : ((alertDialogLayout.getPaddingTop() + i8) - i6) - measuredHeight;
        } else {
            paddingTop = (((i8 - i6) - measuredHeight) / 2) + alertDialogLayout.getPaddingTop();
        }
        Drawable dividerDrawable = alertDialogLayout.getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i14 = 0;
        while (i14 < childCount) {
            int i15 = paddingTop;
            View childAt = alertDialogLayout.getChildAt(i14);
            if (childAt == null || childAt.getVisibility() == 8) {
                paddingTop = i15;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i16 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i16 < 0) {
                    i16 = i13;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i16, ViewCompat.getLayoutDirection(alertDialogLayout)) & 7;
                if (absoluteGravity != 1) {
                    if (absoluteGravity != 5) {
                        i10 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    } else {
                        iB = paddingRight - measuredWidth;
                        i9 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    if (alertDialogLayout.hasDividerBeforeChildAt(i14)) {
                        i15 += intrinsicHeight;
                    }
                    int i17 = i15 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    alertDialogLayout.setChildFrame(childAt, i10, i17, measuredWidth, measuredHeight2);
                    paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i17;
                } else {
                    iB = AbstractC0157z.b(paddingRight2, measuredWidth, 2, paddingLeft) + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i9 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i10 = iB - i9;
                if (alertDialogLayout.hasDividerBeforeChildAt(i14)) {
                    i15 += intrinsicHeight;
                }
                int i18 = i15 + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                alertDialogLayout.setChildFrame(childAt, i10, i18, measuredWidth, measuredHeight2);
                paddingTop = measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + i18;
            }
            i14++;
            alertDialogLayout = this;
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i5, int i6) {
        if (tryOnMeasure(i5, i6)) {
            return;
        }
        super.onMeasure(i5, i6);
    }

    public AlertDialogLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
