package com.zhouwei.mzbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CustomViewPager extends ViewPager {
    private ArrayList<Integer> childCenterXAbs;
    private SparseArray<Integer> childIndex;

    public CustomViewPager(Context context) {
        super(context);
        this.childCenterXAbs = new ArrayList<>();
        this.childIndex = new SparseArray<>();
        init();
    }

    private int getViewCenterX(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return (view.getWidth() / 2) + iArr[0];
    }

    private void init() {
        setClipToPadding(false);
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public int getChildDrawingOrder(int i5, int i6) {
        if (i6 == 0 || this.childIndex.size() != i5) {
            this.childCenterXAbs.clear();
            this.childIndex.clear();
            int viewCenterX = getViewCenterX(this);
            for (int i7 = 0; i7 < i5; i7++) {
                int iAbs = Math.abs(viewCenterX - getViewCenterX(getChildAt(i7)));
                if (this.childIndex.get(iAbs) != null) {
                    iAbs++;
                }
                this.childCenterXAbs.add(Integer.valueOf(iAbs));
                this.childIndex.append(iAbs, Integer.valueOf(i7));
            }
            Collections.sort(this.childCenterXAbs);
        }
        return this.childIndex.get(this.childCenterXAbs.get((i5 - 1) - i6).intValue()).intValue();
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.childCenterXAbs = new ArrayList<>();
        this.childIndex = new SparseArray<>();
        init();
    }
}
