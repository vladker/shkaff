package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeStyleFragment_ViewBinding implements Unbinder {
    private AttributeTimeStyleFragment target;
    private View view15ad;
    private View view15ae;
    private View view15af;
    private View view15b0;

    @UiThread
    public AttributeTimeStyleFragment_ViewBinding(final AttributeTimeStyleFragment attributeTimeStyleFragment, View view) {
        this.target = attributeTimeStyleFragment;
        attributeTimeStyleFragment.lpwTextSize = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_text_size, "field 'lpwTextSize'", LineProgressWidget.class);
        int i5 = p113u.d.lpw_text_style_bold;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'ivTimeStyleBold' and method 'onBoldClick'");
        attributeTimeStyleFragment.ivTimeStyleBold = (ImageView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'ivTimeStyleBold'", ImageView.class);
        this.view15ad = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeStyleFragment.onBoldClick(view2);
            }
        });
        int i6 = p113u.d.lpw_text_style_italic;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'ivTimeStyleItalic' and method 'onItalicClick'");
        attributeTimeStyleFragment.ivTimeStyleItalic = (ImageView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'ivTimeStyleItalic'", ImageView.class);
        this.view15ae = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeStyleFragment.onItalicClick(view2);
            }
        });
        int i7 = p113u.d.lpw_text_style_underline;
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, i7, "field 'ivTimeStyleUnderline' and method 'onUnderlineClick'");
        attributeTimeStyleFragment.ivTimeStyleUnderline = (ImageView) butterknife.internal.d.castView(viewFindRequiredView3, i7, "field 'ivTimeStyleUnderline'", ImageView.class);
        this.view15b0 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeStyleFragment.onUnderlineClick(view2);
            }
        });
        int i8 = p113u.d.lpw_text_style_strikethrough;
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, i8, "field 'ivTimeStyleStrikethrough' and method 'onStrikethroughClick'");
        attributeTimeStyleFragment.ivTimeStyleStrikethrough = (ImageView) butterknife.internal.d.castView(viewFindRequiredView4, i8, "field 'ivTimeStyleStrikethrough'", ImageView.class);
        this.view15af = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.printerlabel.AttributeTimeStyleFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                attributeTimeStyleFragment.onStrikethroughClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTimeStyleFragment attributeTimeStyleFragment = this.target;
        if (attributeTimeStyleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTimeStyleFragment.lpwTextSize = null;
        attributeTimeStyleFragment.ivTimeStyleBold = null;
        attributeTimeStyleFragment.ivTimeStyleItalic = null;
        attributeTimeStyleFragment.ivTimeStyleUnderline = null;
        attributeTimeStyleFragment.ivTimeStyleStrikethrough = null;
        this.view15ad.setOnClickListener(null);
        this.view15ad = null;
        this.view15ae.setOnClickListener(null);
        this.view15ae = null;
        this.view15b0.setOnClickListener(null);
        this.view15b0 = null;
        this.view15af.setOnClickListener(null);
        this.view15af = null;
    }
}
