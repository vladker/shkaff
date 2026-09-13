package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.DrawingBoardView;
import com.appdev.standard.page.printerlabel.widget.ImageTextBtnWidget;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class TemplateEditActivity_ViewBinding implements Unbinder {
    private TemplateEditActivity target;
    private View view1423;
    private View view1424;
    private View view1426;
    private View view1428;
    private View view1429;
    private View view142a;
    private View view142b;
    private View view142c;
    private View view142d;
    private View view142e;
    private View view142f;
    private View view1457;
    private View view1872;

    @UiThread
    public TemplateEditActivity_ViewBinding(TemplateEditActivity templateEditActivity) {
        this(templateEditActivity, templateEditActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        TemplateEditActivity templateEditActivity = this.target;
        if (templateEditActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        templateEditActivity.mTemplatePageView = null;
        templateEditActivity.flTemplateEdit = null;
        templateEditActivity.itbControlElementSelect = null;
        templateEditActivity.itbControlElementRevoke = null;
        templateEditActivity.itbControlElementRestore = null;
        templateEditActivity.itbControlElementLock = null;
        templateEditActivity.itbControlElementBicolor = null;
        templateEditActivity.itbControlElementDarkMode = null;
        templateEditActivity.viewToolbarDivider = null;
        templateEditActivity.hsvElementToolbar = null;
        templateEditActivity.viewToolbarDividerBottom = null;
        templateEditActivity.itbToolbarElementDelete = null;
        templateEditActivity.itbToolbarElementAmplify = null;
        templateEditActivity.itbToolbarElementReduce = null;
        templateEditActivity.itbToolbarElementCopy = null;
        templateEditActivity.itbToolbarElementRotate = null;
        templateEditActivity.rlTemplateEditDialog = null;
        templateEditActivity.tvTemplateEditLabelName = null;
        templateEditActivity.tvTemplateEditLabelSpecifications = null;
        templateEditActivity.nsvTemplateEdit = null;
        templateEditActivity.llPushIndustryTemplates = null;
        templateEditActivity.tvScale = null;
        templateEditActivity.rlScaleDialog = null;
        templateEditActivity.scaleProgressWidget = null;
        templateEditActivity.itbControlElementMove = null;
        this.view142a.setOnClickListener(null);
        this.view142a = null;
        this.view1429.setOnClickListener(null);
        this.view1429 = null;
        this.view1428.setOnClickListener(null);
        this.view1428 = null;
        this.view1426.setOnClickListener(null);
        this.view1426 = null;
        this.view1424.setOnClickListener(null);
        this.view1424 = null;
        this.view142d.setOnClickListener(null);
        this.view142d = null;
        this.view142b.setOnClickListener(null);
        this.view142b = null;
        this.view142e.setOnClickListener(null);
        this.view142e = null;
        this.view142c.setOnClickListener(null);
        this.view142c = null;
        this.view142f.setOnClickListener(null);
        this.view142f = null;
        this.view1872.setOnClickListener(null);
        this.view1872 = null;
        this.view1423.setOnClickListener(null);
        this.view1423 = null;
        this.view1457.setOnClickListener(null);
        this.view1457 = null;
    }

    @UiThread
    public TemplateEditActivity_ViewBinding(final TemplateEditActivity templateEditActivity, View view) {
        this.target = templateEditActivity;
        templateEditActivity.mTemplatePageView = (TemplatePageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.base_template_page_view, "field 'mTemplatePageView'", TemplatePageView.class);
        templateEditActivity.flTemplateEdit = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.fl_template_edit, "field 'flTemplateEdit'", FrameLayout.class);
        int i5 = p113u.d.itb_control_element_select;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'itbControlElementSelect' and method 'onSelectClick'");
        templateEditActivity.itbControlElementSelect = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'itbControlElementSelect'", ImageTextBtnWidget.class);
        this.view142a = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onSelectClick(view2);
            }
        });
        int i6 = p113u.d.itb_control_element_revoke;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'itbControlElementRevoke' and method 'onRevokeClick'");
        templateEditActivity.itbControlElementRevoke = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'itbControlElementRevoke'", ImageTextBtnWidget.class);
        this.view1429 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onRevokeClick(view2);
            }
        });
        int i7 = p113u.d.itb_control_element_restore;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'itbControlElementRestore' and method 'onRestoreClick'");
        templateEditActivity.itbControlElementRestore = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'itbControlElementRestore'", ImageTextBtnWidget.class);
        this.view1428 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onRestoreClick(view2);
            }
        });
        int i8 = p113u.d.itb_control_element_lock;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'itbControlElementLock' and method 'onLockClick'");
        templateEditActivity.itbControlElementLock = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'itbControlElementLock'", ImageTextBtnWidget.class);
        this.view1426 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onLockClick(view2);
            }
        });
        int i9 = p113u.d.itb_control_element_bicolor;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'itbControlElementBicolor' and method 'onBicolorClick'");
        templateEditActivity.itbControlElementBicolor = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'itbControlElementBicolor'", ImageTextBtnWidget.class);
        this.view1424 = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onBicolorClick(view2);
            }
        });
        templateEditActivity.itbControlElementDarkMode = (ImageTextBtnWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.itb_control_element_dark_mode, "field 'itbControlElementDarkMode'", ImageTextBtnWidget.class);
        templateEditActivity.viewToolbarDivider = butterknife.internal.d.findRequiredView(view, p113u.d.view_toolbar_divider, "field 'viewToolbarDivider'");
        templateEditActivity.hsvElementToolbar = (HorizontalScrollView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.hsv_element_toolbar, "field 'hsvElementToolbar'", HorizontalScrollView.class);
        templateEditActivity.viewToolbarDividerBottom = butterknife.internal.d.findRequiredView(view, p113u.d.view_toolbar_divider_bottom, "field 'viewToolbarDividerBottom'");
        int i10 = p113u.d.itb_toolbar_element_delete;
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, i10, "field 'itbToolbarElementDelete' and method 'onDeleteClick'");
        templateEditActivity.itbToolbarElementDelete = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView6, i10, "field 'itbToolbarElementDelete'", ImageTextBtnWidget.class);
        this.view142d = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onDeleteClick(view2);
            }
        });
        int i11 = p113u.d.itb_toolbar_element_amplify;
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, i11, "field 'itbToolbarElementAmplify' and method 'onAmplifyClick'");
        templateEditActivity.itbToolbarElementAmplify = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView7, i11, "field 'itbToolbarElementAmplify'", ImageTextBtnWidget.class);
        this.view142b = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onAmplifyClick(view2);
            }
        });
        int i12 = p113u.d.itb_toolbar_element_reduce;
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, i12, "field 'itbToolbarElementReduce' and method 'onReduceClick'");
        templateEditActivity.itbToolbarElementReduce = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView8, i12, "field 'itbToolbarElementReduce'", ImageTextBtnWidget.class);
        this.view142e = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onReduceClick(view2);
            }
        });
        int i13 = p113u.d.itb_toolbar_element_copy;
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, i13, "field 'itbToolbarElementCopy' and method 'onCopyClick'");
        templateEditActivity.itbToolbarElementCopy = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView9, i13, "field 'itbToolbarElementCopy'", ImageTextBtnWidget.class);
        this.view142c = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onCopyClick(view2);
            }
        });
        int i14 = p113u.d.itb_toolbar_element_rotate;
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, i14, "field 'itbToolbarElementRotate' and method 'onRotateClick'");
        templateEditActivity.itbToolbarElementRotate = (ImageTextBtnWidget) butterknife.internal.d.castView(viewFindRequiredView10, i14, "field 'itbToolbarElementRotate'", ImageTextBtnWidget.class);
        this.view142f = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onRotateClick(view2);
            }
        });
        templateEditActivity.rlTemplateEditDialog = (RelativeLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rl_template_edit_dialog, "field 'rlTemplateEditDialog'", RelativeLayout.class);
        templateEditActivity.tvTemplateEditLabelName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_template_edit_label_name, "field 'tvTemplateEditLabelName'", TextView.class);
        templateEditActivity.tvTemplateEditLabelSpecifications = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_template_edit_label_specifications, "field 'tvTemplateEditLabelSpecifications'", TextView.class);
        templateEditActivity.nsvTemplateEdit = (DrawingBoardView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.nsv_template_edit, "field 'nsvTemplateEdit'", DrawingBoardView.class);
        templateEditActivity.llPushIndustryTemplates = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_push_industry_templates, "field 'llPushIndustryTemplates'", LinearLayout.class);
        int i15 = p113u.d.tv_scale;
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, i15, "field 'tvScale' and method 'onScaleClick'");
        templateEditActivity.tvScale = (TextView) butterknife.internal.d.castView(viewFindRequiredView11, i15, "field 'tvScale'", TextView.class);
        this.view1872 = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onScaleClick(view2);
            }
        });
        templateEditActivity.rlScaleDialog = (RelativeLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rl_scale_dialog, "field 'rlScaleDialog'", RelativeLayout.class);
        templateEditActivity.scaleProgressWidget = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.scale_text_size, "field 'scaleProgressWidget'", LineProgressWidget.class);
        templateEditActivity.itbControlElementMove = (ImageTextBtnWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.itb_control_element_move, "field 'itbControlElementMove'", ImageTextBtnWidget.class);
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, p113u.d.itb_control_element, "method 'onElementClick'");
        this.view1423 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onElementClick(view2);
            }
        });
        View viewFindRequiredView13 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_control_miss, "method 'onControlMiss'");
        this.view1457 = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity_ViewBinding.13
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                templateEditActivity.onControlMiss(view2);
            }
        });
    }
}
