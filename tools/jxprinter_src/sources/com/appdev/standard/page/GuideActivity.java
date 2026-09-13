package com.appdev.standard.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.library.base.frame.MvpActivity;
import com.library.base.widget.EllipseGuideLayout;
import java.util.ArrayList;
import p113u.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_GUIDE)
public class GuideActivity extends MvpActivity {
    private p119v.a guideAdapter = null;
    private ViewPager.OnPageChangeListener guidePageChangeListener = null;

    @BindView(4936)
    Button mBtnStart;

    @BindView(5037)
    EllipseGuideLayout mEglGuide;

    @BindView(5125)
    ViewPager mGuideViewPager;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mEglGuide.init(this.guideAdapter.f8749a.size(), p113u.b.px18dp);
        this.mGuideViewPager.setAdapter(this.guideAdapter);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        p119v.a aVar = new p119v.a();
        Integer[] numArr = {Integer.valueOf(p113u.c.page1), Integer.valueOf(p113u.c.page2), Integer.valueOf(p113u.c.page3)};
        aVar.f8749a = new ArrayList();
        for (int i5 = 0; i5 < 3; i5++) {
            Integer num = numArr[i5];
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            p047i2.a.loadDrawableRes(num.intValue(), imageView);
            aVar.f8749a.add(imageView);
        }
        this.guideAdapter = aVar;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.appdev.standard.page.GuideActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i5) {
                EllipseGuideLayout ellipseGuideLayout = GuideActivity.this.mEglGuide;
                if (i5 < 0) {
                    ellipseGuideLayout.getClass();
                } else if (i5 <= ellipseGuideLayout.f3609a.size() - 1) {
                    ArrayList arrayList = ellipseGuideLayout.f3609a;
                    int size = arrayList.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj = arrayList.get(i6);
                        i6++;
                        ((View) obj).setBackgroundResource(Y1.b.bg_unselected_ellipse);
                    }
                    ((View) ellipseGuideLayout.f3609a.get(i5)).setBackgroundResource(Y1.b.bg_selected_ellipse);
                }
                if (i5 == GuideActivity.this.guideAdapter.f8749a.size() - 1) {
                    GuideActivity.this.mBtnStart.setVisibility(0);
                } else {
                    GuideActivity.this.mBtnStart.setVisibility(8);
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i5) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i5, float f6, int i6) {
            }
        };
        this.guidePageChangeListener = onPageChangeListener;
        this.mGuideViewPager.addOnPageChangeListener(onPageChangeListener);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_guide;
    }

    public void onStartBtnClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }
}
