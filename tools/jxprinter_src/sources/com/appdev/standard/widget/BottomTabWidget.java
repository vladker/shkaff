package com.appdev.standard.widget;

import C5.c;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.appdev.standard.model.SharedViewModel;
import com.appdev.standard.page.MainActivity;
import p074n0.b;
import p113u.d;
import p113u.f;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class BottomTabWidget extends LinearLayout {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f2849k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2850a;
    public final a[] b;
    public final int c;
    public final int d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f2851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f2852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LinearLayout f2853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f2854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f2855j;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2856a;
        public final int b;
        public final int c;

        public a(@StringRes BottomTabWidget bottomTabWidget, int i5, int i6, int i7) {
            this.f2856a = i5;
            this.b = i6;
            this.c = i7;
        }

        public void setTitle(@StringRes int i5) {
            this.f2856a = i5;
        }
    }

    public BottomTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        this.f2850a = getClass().getName();
        this.b = new a[]{new a(this, g.index_tab_main_home, f.ic_main_home_select_not, f.ic_main_home_select), new a(this, g.index_tab_main_document, f.ic_main_document_select_not, f.ic_main_document_select), new a(this, g.index_tab_main_scene, f.ic_main_scene_select_not, f.ic_main_scene_select), new a(this, g.index_tab_main_mine, f.ic_main_mine_select_not, f.ic_main_mine_select)};
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f2851f = -1;
        this.f2852g = -1;
        this.f2853h = null;
        this.f2854i = null;
        this.f2855j = new c(this, 3);
        setOrientation(0);
        this.d = getResources().getColor(p113u.a.color_FFAE00);
        this.c = getResources().getColor(p113u.a.color_999999);
        this.e = getResources().getDimensionPixelSize(p113u.b.px46dp);
        this.f2851f = 12;
        this.f2852g = getResources().getDimensionPixelSize(p113u.b.px10dp);
        int i5 = 0;
        while (true) {
            a[] aVarArr = this.b;
            if (i5 > aVarArr.length - 1) {
                return;
            }
            a aVar = aVarArr[i5];
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(81);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            int i6 = this.f2852g;
            layoutParams.bottomMargin = i6;
            layoutParams.topMargin = i6;
            if (i5 != 1) {
                layoutParams.gravity = 80;
            }
            linearLayout.setLayoutParams(layoutParams);
            ImageView imageView = new ImageView(linearLayout.getContext());
            int i7 = this.e;
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i7, i7);
            imageView.setImageResource(aVar.b);
            imageView.setLayoutParams(layoutParams2);
            imageView.setId(d.tab_icon);
            linearLayout.addView(imageView);
            TextView textView = new TextView(linearLayout.getContext());
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            textView.setText(aVar.f2856a);
            textView.setLayoutParams(layoutParams3);
            textView.setId(d.tab_title);
            textView.setTextColor(this.c);
            textView.setTextSize(1, this.f2851f);
            linearLayout.addView(textView);
            linearLayout.setTag(d.tab_postion, Integer.valueOf(i5));
            linearLayout.setOnClickListener(this.f2855j);
            addView(linearLayout);
            i5++;
        }
    }

    public final void a(int i5) {
        try {
            b((LinearLayout) getChildAt(i5));
        } catch (Exception e) {
            p051j0.a.d(this.f2850a, e.getMessage());
        }
    }

    public final void b(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = this.f2853h;
        a[] aVarArr = this.b;
        if (linearLayout2 != null) {
            ((ImageView) this.f2853h.findViewById(d.tab_icon)).setImageResource(aVarArr[((Integer) linearLayout2.getTag(d.tab_postion)).intValue()].b);
            ((TextView) this.f2853h.findViewById(d.tab_title)).setTextColor(this.c);
        }
        int iIntValue = ((Integer) linearLayout.getTag(d.tab_postion)).intValue();
        ((ImageView) linearLayout.findViewById(d.tab_icon)).setImageResource(aVarArr[iIntValue].c);
        ((TextView) linearLayout.findViewById(d.tab_title)).setTextColor(this.d);
        b bVar = this.f2854i;
        if (bVar != null) {
            F4.f fVar = (F4.f) bVar;
            ((MainActivity) fVar.b).lambda$initListener$0((SharedViewModel) fVar.c, iIntValue);
        }
        this.f2853h = linearLayout;
    }

    public void setOnTabClickListener(b bVar) {
        this.f2854i = bVar;
        try {
            b((LinearLayout) getChildAt(0));
        } catch (Exception e) {
            p051j0.a.d(this.f2850a, e.getMessage());
        }
    }
}
