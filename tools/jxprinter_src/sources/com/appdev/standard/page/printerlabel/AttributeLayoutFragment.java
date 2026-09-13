package com.appdev.standard.page.printerlabel;

import android.view.View;
import butterknife.OnClick;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeLayoutFragment extends com.library.base.frame.f {
    private TemplatePageView pageView;

    public AttributeLayoutFragment(TemplatePageView templatePageView) {
        this.pageView = templatePageView;
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_attribute_layout;
    }

    @OnClick({5176})
    public void onLayoutBottomClick(View view) {
        this.pageView.bottomAlignedSelected();
    }

    @OnClick({5177})
    public void onLayoutCenterHorizontalClick(View view) {
        this.pageView.horizontalCenterSelected();
    }

    @OnClick({5178})
    public void onLayoutCenterVerticalClick(View view) {
        this.pageView.verticalCenterSelected();
    }

    @OnClick({5179})
    public void onLayoutHorizontalIsometric(View view) {
        this.pageView.horizontalIsometricSelected();
    }

    @OnClick({5180})
    public void onLayoutLeftClick(View view) {
        this.pageView.leftAlignedSelected();
    }

    @OnClick({5181})
    public void onLayoutRightClick(View view) {
        this.pageView.rightAlignedSelected();
    }

    @OnClick({5182})
    public void onLayoutSelectAll(View view) {
        this.pageView.selectAll();
    }

    @OnClick({5183})
    public void onLayoutToBottomClick(View view) {
        Iterator<BaseControlView> it = this.pageView.hasSelectedElement().iterator();
        while (it.hasNext()) {
            it.next().directionTranslation("向下");
        }
    }

    @OnClick({5184})
    public void onLayoutToLeftClick(View view) {
        Iterator<BaseControlView> it = this.pageView.hasSelectedElement().iterator();
        while (it.hasNext()) {
            it.next().directionTranslation("向左");
        }
    }

    @OnClick({5185})
    public void onLayoutToRightClick(View view) {
        Iterator<BaseControlView> it = this.pageView.hasSelectedElement().iterator();
        while (it.hasNext()) {
            it.next().directionTranslation("向右");
        }
    }

    @OnClick({5186})
    public void onLayoutToTopClick(View view) {
        Iterator<BaseControlView> it = this.pageView.hasSelectedElement().iterator();
        while (it.hasNext()) {
            it.next().directionTranslation("向上");
        }
    }

    @OnClick({5187})
    public void onLayoutTopClick(View view) {
        this.pageView.topAlignedSelected();
    }

    @OnClick({5188})
    public void onLayoutVerticalIsometric(View view) {
        this.pageView.verticalIsometricSelected();
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
