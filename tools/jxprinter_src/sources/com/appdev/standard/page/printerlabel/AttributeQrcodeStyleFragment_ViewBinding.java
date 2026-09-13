package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeQrcodeStyleFragment_ViewBinding implements Unbinder {
    private AttributeQrcodeStyleFragment target;
    private View view1569;

    @UiThread
    public AttributeQrcodeStyleFragment_ViewBinding(final AttributeQrcodeStyleFragment attributeQrcodeStyleFragment, View view) {
        this.target = attributeQrcodeStyleFragment;
        attributeQrcodeStyleFragment.tvFormat = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_qrcode_style_format, "field 'tvFormat'", TextView.class);
        attributeQrcodeStyleFragment.ivMore = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_qrcode_style_format_more, "field 'ivMore'", ImageView.class);
        int i5 = p113u.d.ll_qrcode_style_format;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'llFormat' and method 'onFormatClick'");
        attributeQrcodeStyleFragment.llFormat = (LinearLayout) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'llFormat'", LinearLayout.class);
        this.view1569 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeQrcodeStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeQrcodeStyleFragment.onFormatClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeQrcodeStyleFragment attributeQrcodeStyleFragment = this.target;
        if (attributeQrcodeStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeQrcodeStyleFragment.tvFormat = null;
        attributeQrcodeStyleFragment.ivMore = null;
        attributeQrcodeStyleFragment.llFormat = null;
        this.view1569.setOnClickListener(null);
        this.view1569 = null;
    }
}
