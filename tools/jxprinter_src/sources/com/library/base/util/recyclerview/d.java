package com.library.base.util.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class d extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3566a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Drawable f3568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3569h;

    public d(@ColorInt int i5, int i6) {
        this.f3566a = 18;
        this.d = 0;
        this.e = 0;
        this.f3567f = 0;
        this.f3568g = null;
        this.b = i5;
        this.c = i6;
        this.f3569h = 33;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z6 = recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1;
        boolean z7 = recyclerView.getChildAdapterPosition(view) == 0;
        int i5 = this.f3569h == 33 ? this.c : 0;
        int i6 = this.f3566a;
        int i7 = this.d;
        if (i6 != 18) {
            if (z7) {
                rect.set(i7 + i5, 0, i5, 0);
                return;
            } else if (z6) {
                rect.set(0, 0, i5, 0);
                return;
            } else {
                rect.set(0, 0, i5, 0);
                return;
            }
        }
        int i8 = this.f3567f;
        int i9 = this.e;
        if (z7) {
            rect.set(i9, i7 + i5, i8, i5);
        } else if (z6) {
            rect.set(i9, 0, i8, i5);
        } else {
            rect.set(i9, 0, i8, i5);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int i5 = this.f3566a;
        Drawable drawable = this.f3568g;
        int i6 = this.b;
        int i7 = this.f3569h;
        int i8 = this.c;
        int i9 = 0;
        if (i5 == 18) {
            int i10 = this.f3567f;
            int i11 = this.e;
            if (i7 == 33) {
                int paddingLeft = recyclerView.getPaddingLeft() + i11;
                int width = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - i10;
                int childCount = recyclerView.getChildCount();
                Paint paint = new Paint();
                paint.setColor(i6);
                while (i9 < childCount) {
                    View childAt = recyclerView.getChildAt(i9);
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                    if (i9 == 0) {
                        int top = childAt.getTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                        canvas.drawRect(paddingLeft, top - i8, width, top, paint);
                    }
                    int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    canvas.drawRect(paddingLeft, bottom, width, bottom + i8, paint);
                    i9++;
                }
                return;
            }
            if (i7 == 34) {
                int paddingLeft2 = recyclerView.getPaddingLeft() + i11;
                int width2 = (recyclerView.getWidth() - recyclerView.getPaddingRight()) - i10;
                int childCount2 = recyclerView.getChildCount();
                while (i9 < childCount2) {
                    View childAt2 = recyclerView.getChildAt(i9);
                    RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) childAt2.getLayoutParams();
                    if (i9 == 0) {
                        int top2 = childAt2.getTop() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        drawable.setBounds(paddingLeft2, top2 - drawable.getIntrinsicHeight(), width2, top2);
                        drawable.draw(canvas);
                    }
                    int bottom2 = childAt2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                    drawable.setBounds(paddingLeft2, bottom2, width2, bottom2 + i8);
                    drawable.draw(canvas);
                    i9++;
                }
                return;
            }
            return;
        }
        Canvas canvas2 = canvas;
        if (i7 != 33) {
            if (i7 == 34) {
                int paddingTop = recyclerView.getPaddingTop();
                int height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                int childCount3 = recyclerView.getChildCount();
                while (i9 < childCount3) {
                    View childAt3 = recyclerView.getChildAt(i9);
                    RecyclerView.LayoutParams layoutParams3 = (RecyclerView.LayoutParams) childAt3.getLayoutParams();
                    if (i9 == 0) {
                        int left = childAt3.getLeft() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin;
                        drawable.setBounds(left - drawable.getIntrinsicWidth(), paddingTop, left, height);
                        drawable.draw(canvas2);
                    }
                    int right = childAt3.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                    drawable.setBounds(right, paddingTop, drawable.getIntrinsicWidth() + right, height);
                    drawable.draw(canvas2);
                    i9++;
                }
                return;
            }
            return;
        }
        int paddingTop2 = recyclerView.getPaddingTop();
        int height2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
        int childCount4 = recyclerView.getChildCount();
        Paint paint2 = new Paint();
        paint2.setColor(i6);
        while (i9 < childCount4) {
            View childAt4 = recyclerView.getChildAt(i9);
            RecyclerView.LayoutParams layoutParams4 = (RecyclerView.LayoutParams) childAt4.getLayoutParams();
            if (i9 == 0) {
                int left2 = childAt4.getLeft() + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin;
                canvas2.drawRect(left2 - i8, paddingTop2, left2, height2, paint2);
            }
            int right2 = childAt4.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin;
            canvas.drawRect(right2, paddingTop2, right2 + i8, height2, paint2);
            i9++;
            canvas2 = canvas;
        }
    }

    public d(@ColorInt int i5, int i6, int i7, int i8) {
        this.f3566a = 18;
        this.f3568g = null;
        this.b = i5;
        this.c = i6;
        this.d = i7;
        this.e = i8;
        this.f3567f = i8;
        this.f3569h = 33;
    }

    public d(Context context, @DrawableRes int i5) {
        this.f3566a = 18;
        this.b = -1;
        this.c = -1;
        this.d = 0;
        this.e = 0;
        this.f3567f = 0;
        this.f3568g = null;
        this.f3569h = -1;
        this.f3568g = context.getResources().getDrawable(i5);
        this.f3569h = 34;
    }
}
