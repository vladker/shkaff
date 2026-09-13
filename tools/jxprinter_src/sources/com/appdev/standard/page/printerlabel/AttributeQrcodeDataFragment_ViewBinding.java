package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeQrcodeDataFragment_ViewBinding implements Unbinder {
    private AttributeQrcodeDataFragment target;
    private View view14de;
    private View view14e1;
    private View view14e4;
    private View view1788;
    private View view1789;
    private View view178a;
    private View view178b;
    private View view17a6;
    private View view17a7;
    private View view17a8;
    private View view17a9;
    private View view17aa;
    private View view17ab;
    private View view17c4;
    private View view17c8;
    private View view17de;

    @UiThread
    public AttributeQrcodeDataFragment_ViewBinding(final AttributeQrcodeDataFragment attributeQrcodeDataFragment, View view) {
        this.target = attributeQrcodeDataFragment;
        int i5 = p113u.d.tv_fixed_data;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvFixedData' and method 'onFixedDataClick'");
        attributeQrcodeDataFragment.tvFixedData = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvFixedData'", TextView.class);
        this.view17c8 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onFixedDataClick();
            }
        });
        attributeQrcodeDataFragment.rlFixedContent = (RelativeLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rl_attribute_barcode_fixed_content, "field 'rlFixedContent'", RelativeLayout.class);
        int i6 = p113u.d.tv_attribute_barcode_fixed_content;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'tvFixedContent' and method 'onFixedContentClick'");
        attributeQrcodeDataFragment.tvFixedContent = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'tvFixedContent'", TextView.class);
        this.view1788 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onFixedContentClick();
            }
        });
        int i7 = p113u.d.tv_incremental_data;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'tvIncrementalData' and method 'onIncrementalDataClick'");
        attributeQrcodeDataFragment.tvIncrementalData = (TextView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'tvIncrementalData'", TextView.class);
        this.view17de = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onIncrementalDataClick();
            }
        });
        attributeQrcodeDataFragment.llIncrementalContent = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_attribute_barcode_incremental_content, "field 'llIncrementalContent'", LinearLayout.class);
        int i8 = p113u.d.tv_attribute_barcode_incremental_content;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'tvIncrementalContent' and method 'onIncrementalContentClick'");
        attributeQrcodeDataFragment.tvIncrementalContent = (TextView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'tvIncrementalContent'", TextView.class);
        this.view1789 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onIncrementalContentClick();
            }
        });
        int i9 = p113u.d.tv_attribute_barcode_prefix;
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, i9, "field 'tvPrefix' and method 'onPrefixClick'");
        attributeQrcodeDataFragment.tvPrefix = (TextView) butterknife.internal.d.castView(viewFindRequiredView5, i9, "field 'tvPrefix'", TextView.class);
        this.view178a = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onPrefixClick();
            }
        });
        int i10 = p113u.d.tv_attribute_barcode_suffix;
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, i10, "field 'tvSuffix' and method 'onSuffixClick'");
        attributeQrcodeDataFragment.tvSuffix = (TextView) butterknife.internal.d.castView(viewFindRequiredView6, i10, "field 'tvSuffix'", TextView.class);
        this.view178b = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onSuffixClick();
            }
        });
        attributeQrcodeDataFragment.qswInterval = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_attribute_barcode_interval, "field 'qswInterval'", QuantitySelectorWidget.class);
        int i11 = p113u.d.tv_excel_data;
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, i11, "field 'tvExcelData' and method 'onExcelDataClick'");
        attributeQrcodeDataFragment.tvExcelData = (TextView) butterknife.internal.d.castView(viewFindRequiredView7, i11, "field 'tvExcelData'", TextView.class);
        this.view17c4 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onExcelDataClick();
            }
        });
        attributeQrcodeDataFragment.flExcelContent = (FrameLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_attribute_qrcode_excel_content, "field 'flExcelContent'", FrameLayout.class);
        int i12 = p113u.d.tv_date_dynamic_time;
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, i12, "field 'tvDateDynamicTime' and method 'onDateDynamicTimeClick'");
        attributeQrcodeDataFragment.tvDateDynamicTime = (TextView) butterknife.internal.d.castView(viewFindRequiredView8, i12, "field 'tvDateDynamicTime'", TextView.class);
        this.view17a8 = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateDynamicTimeClick();
            }
        });
        int i13 = p113u.d.tv_date_fixed_time;
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, i13, "field 'tvDateFixedTime' and method 'onDateFixedTimeClick'");
        attributeQrcodeDataFragment.tvDateFixedTime = (TextView) butterknife.internal.d.castView(viewFindRequiredView9, i13, "field 'tvDateFixedTime'", TextView.class);
        this.view17a9 = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateFixedTimeClick();
            }
        });
        int i14 = p113u.d.tv_date_data;
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, i14, "field 'tvDateData' and method 'onDateDataClick'");
        attributeQrcodeDataFragment.tvDateData = (TextView) butterknife.internal.d.castView(viewFindRequiredView10, i14, "field 'tvDateData'", TextView.class);
        this.view17a7 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateDataClick();
            }
        });
        attributeQrcodeDataFragment.llDateContent = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_attribute_barcode_date_content, "field 'llDateContent'", LinearLayout.class);
        int i15 = p113u.d.tv_date_format;
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, i15, "field 'tvDateFormat' and method 'onDateFormatClick'");
        attributeQrcodeDataFragment.tvDateFormat = (TextView) butterknife.internal.d.castView(viewFindRequiredView11, i15, "field 'tvDateFormat'", TextView.class);
        this.view17aa = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateFormatClick();
            }
        });
        int i16 = p113u.d.tv_date_content;
        View viewFindRequiredView12 = butterknife.internal.d.findRequiredView(view, i16, "field 'tvDateContent' and method 'onDateContentClick'");
        attributeQrcodeDataFragment.tvDateContent = (TextView) butterknife.internal.d.castView(viewFindRequiredView12, i16, "field 'tvDateContent'", TextView.class);
        this.view17a6 = viewFindRequiredView12;
        viewFindRequiredView12.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.12
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateContentClick();
            }
        });
        int i17 = p113u.d.tv_date_setting_time_offset;
        View viewFindRequiredView13 = butterknife.internal.d.findRequiredView(view, i17, "field 'tvDateSettingTimeOffset' and method 'onDateSettingTimeOffsetClick'");
        attributeQrcodeDataFragment.tvDateSettingTimeOffset = (TextView) butterknife.internal.d.castView(viewFindRequiredView13, i17, "field 'tvDateSettingTimeOffset'", TextView.class);
        this.view17ab = viewFindRequiredView13;
        viewFindRequiredView13.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.13
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onDateSettingTimeOffsetClick();
            }
        });
        View viewFindRequiredView14 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_attribute_barcode_fixed_scan, "method 'onFixedScanClick'");
        this.view14e1 = viewFindRequiredView14;
        viewFindRequiredView14.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.14
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onFixedScanClick();
            }
        });
        View viewFindRequiredView15 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_attribute_text_ocr, "method 'onOCRClick'");
        this.view14e4 = viewFindRequiredView15;
        viewFindRequiredView15.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.15
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onOCRClick(view2);
            }
        });
        View viewFindRequiredView16 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_attribute_asr, "method 'onASRClick'");
        this.view14de = viewFindRequiredView16;
        viewFindRequiredView16.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeDataFragment_ViewBinding.16
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeDataFragment.onASRClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeQrcodeDataFragment attributeQrcodeDataFragment = this.target;
        if (attributeQrcodeDataFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeQrcodeDataFragment.tvFixedData = null;
        attributeQrcodeDataFragment.rlFixedContent = null;
        attributeQrcodeDataFragment.tvFixedContent = null;
        attributeQrcodeDataFragment.tvIncrementalData = null;
        attributeQrcodeDataFragment.llIncrementalContent = null;
        attributeQrcodeDataFragment.tvIncrementalContent = null;
        attributeQrcodeDataFragment.tvPrefix = null;
        attributeQrcodeDataFragment.tvSuffix = null;
        attributeQrcodeDataFragment.qswInterval = null;
        attributeQrcodeDataFragment.tvExcelData = null;
        attributeQrcodeDataFragment.flExcelContent = null;
        attributeQrcodeDataFragment.tvDateDynamicTime = null;
        attributeQrcodeDataFragment.tvDateFixedTime = null;
        attributeQrcodeDataFragment.tvDateData = null;
        attributeQrcodeDataFragment.llDateContent = null;
        attributeQrcodeDataFragment.tvDateFormat = null;
        attributeQrcodeDataFragment.tvDateContent = null;
        attributeQrcodeDataFragment.tvDateSettingTimeOffset = null;
        this.view17c8.setOnClickListener(null);
        this.view17c8 = null;
        this.view1788.setOnClickListener(null);
        this.view1788 = null;
        this.view17de.setOnClickListener(null);
        this.view17de = null;
        this.view1789.setOnClickListener(null);
        this.view1789 = null;
        this.view178a.setOnClickListener(null);
        this.view178a = null;
        this.view178b.setOnClickListener(null);
        this.view178b = null;
        this.view17c4.setOnClickListener(null);
        this.view17c4 = null;
        this.view17a8.setOnClickListener(null);
        this.view17a8 = null;
        this.view17a9.setOnClickListener(null);
        this.view17a9 = null;
        this.view17a7.setOnClickListener(null);
        this.view17a7 = null;
        this.view17aa.setOnClickListener(null);
        this.view17aa = null;
        this.view17a6.setOnClickListener(null);
        this.view17a6 = null;
        this.view17ab.setOnClickListener(null);
        this.view17ab = null;
        this.view14e1.setOnClickListener(null);
        this.view14e1 = null;
        this.view14e4.setOnClickListener(null);
        this.view14e4 = null;
        this.view14de.setOnClickListener(null);
        this.view14de = null;
    }
}
