package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextFontFragment_ViewBinding implements Unbinder {
    private AttributeTextFontFragment target;

    @UiThread
    public AttributeTextFontFragment_ViewBinding(AttributeTextFontFragment attributeTextFontFragment, View view) {
        this.target = attributeTextFontFragment;
        attributeTextFontFragment.rvAttributeTextFont = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_attribute_text_font, "field 'rvAttributeTextFont'", RecyclerView.class);
        attributeTextFontFragment.tvImportFont = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_import_font, "field 'tvImportFont'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTextFontFragment attributeTextFontFragment = this.target;
        if (attributeTextFontFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTextFontFragment.rvAttributeTextFont = null;
        attributeTextFontFragment.tvImportFont = null;
    }
}
