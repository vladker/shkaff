package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeDataFragment_ViewBinding implements Unbinder {
    private AttributeTimeDataFragment target;
    private View view17a6;
    private View view17a8;
    private View view17a9;
    private View view17aa;
    private View view17ab;

    @UiThread
    public AttributeTimeDataFragment_ViewBinding(final AttributeTimeDataFragment attributeTimeDataFragment, View view) {
        this.target = attributeTimeDataFragment;
        int i5 = p113u.d.tv_date_dynamic_time;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvDateDynamicTime' and method 'onDateDynamicTimeClick'");
        attributeTimeDataFragment.tvDateDynamicTime = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvDateDynamicTime'", TextView.class);
        this.view17a8 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeDataFragment.onDateDynamicTimeClick();
            }
        });
        int i6 = p113u.d.tv_date_fixed_time;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvDateFixedTime' and method 'onDateFixedTimeClick'");
        attributeTimeDataFragment.tvDateFixedTime = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvDateFixedTime'", TextView.class);
        this.view17a9 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeDataFragment.onDateFixedTimeClick();
            }
        });
        int i7 = p113u.d.tv_date_format;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvDateFormat' and method 'onDateFormatClick'");
        attributeTimeDataFragment.tvDateFormat = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvDateFormat'", TextView.class);
        this.view17aa = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeDataFragment.onDateFormatClick();
            }
        });
        int i8 = p113u.d.tv_date_content;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvDateContent' and method 'onDateContentClick'");
        attributeTimeDataFragment.tvDateContent = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvDateContent'", TextView.class);
        this.view17a6 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeDataFragment.onDateContentClick();
            }
        });
        int i9 = p113u.d.tv_date_setting_time_offset;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'tvDateSettingTimeOffset' and method 'onDateSettingTimeOffsetClick'");
        attributeTimeDataFragment.tvDateSettingTimeOffset = (TextView) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'tvDateSettingTimeOffset'", TextView.class);
        this.view17ab = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeDataFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeDataFragment.onDateSettingTimeOffsetClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTimeDataFragment attributeTimeDataFragment = this.target;
        if (attributeTimeDataFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTimeDataFragment.tvDateDynamicTime = null;
        attributeTimeDataFragment.tvDateFixedTime = null;
        attributeTimeDataFragment.tvDateFormat = null;
        attributeTimeDataFragment.tvDateContent = null;
        attributeTimeDataFragment.tvDateSettingTimeOffset = null;
        this.view17a8.setOnClickListener(null);
        this.view17a8 = null;
        this.view17a9.setOnClickListener(null);
        this.view17a9 = null;
        this.view17aa.setOnClickListener(null);
        this.view17aa = null;
        this.view17a6.setOnClickListener(null);
        this.view17a6 = null;
        this.view17ab.setOnClickListener(null);
        this.view17ab = null;
    }
}
