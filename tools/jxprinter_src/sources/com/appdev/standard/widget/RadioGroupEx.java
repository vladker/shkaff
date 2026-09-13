package com.appdev.standard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class RadioGroupEx extends RadioGroup {
    public RadioGroupEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iMax = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (i9 % 2 != 0 || i9 == 0) {
                iMax = Math.max(iMax, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            } else {
                paddingLeft = getPaddingLeft();
                paddingTop += iMax;
                iMax = getChildAt(i9).getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            int i10 = marginLayoutParams.leftMargin + paddingLeft;
            int i11 = marginLayoutParams.topMargin + paddingTop;
            childAt.layout(i10, i11, childAt.getMeasuredWidth() + i10, childAt.getMeasuredHeight() + i11);
            paddingLeft += childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        int size = View.MeasureSpec.getSize(i5);
        int mode = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i6);
        measureChildren(i5, i6);
        int childCount = getChildCount();
        int iMax = 0;
        int i8 = 0;
        int iMax2 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            if (i10 % 2 != 0 || i10 == 0) {
                i9 += measuredWidth;
                iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i7 = iMax;
            } else {
                int iMax3 = Math.max(i9, iMax);
                i8 += iMax2;
                iMax2 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                Log.v("RadioGroupEx", "maxHeight:" + i8 + "---maxWidth:" + iMax3);
                i7 = iMax3;
                i9 = measuredWidth;
            }
            if (i10 == childCount - 1) {
                i8 += iMax2;
                iMax = Math.max(i9, iMax);
            } else {
                iMax = i7;
            }
        }
        int paddingRight = getPaddingRight() + getPaddingLeft() + iMax;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + i8;
        if (mode != 1073741824) {
            size = paddingRight;
        }
        if (mode2 != 1073741824) {
            size2 = paddingBottom;
        }
        setMeasuredDimension(size, size2);
    }
}
