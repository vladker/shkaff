package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTimeFontFragment_ViewBinding implements Unbinder {
    private AttributeTimeFontFragment target;

    @UiThread
    public AttributeTimeFontFragment_ViewBinding(AttributeTimeFontFragment attributeTimeFontFragment, View view) {
        this.target = attributeTimeFontFragment;
        attributeTimeFontFragment.rvAttributeTextFont = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_attribute_text_font, "field 'rvAttributeTextFont'", RecyclerView.class);
        attributeTimeFontFragment.tvImportFont = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_import_font, "field 'tvImportFont'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTimeFontFragment attributeTimeFontFragment = this.target;
        if (attributeTimeFontFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTimeFontFragment.rvAttributeTextFont = null;
        attributeTimeFontFragment.tvImportFont = null;
    }
}
