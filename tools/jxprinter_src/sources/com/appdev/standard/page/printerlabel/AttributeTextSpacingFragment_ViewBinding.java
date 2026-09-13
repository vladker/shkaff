package com.appdev.standard.page.printerlabel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeTextSpacingFragment_ViewBinding implements Unbinder {
    private AttributeTextSpacingFragment target;

    @UiThread
    public AttributeTextSpacingFragment_ViewBinding(AttributeTextSpacingFragment attributeTextSpacingFragment, View view) {
        this.target = attributeTextSpacingFragment;
        attributeTextSpacingFragment.lpwTextWordSpace = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_text_word_space, "field 'lpwTextWordSpace'", LineProgressWidget.class);
        attributeTextSpacingFragment.lpwTextLinesSpace = (LineProgressWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.lpw_text_lines_space, "field 'lpwTextLinesSpace'", LineProgressWidget.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeTextSpacingFragment attributeTextSpacingFragment = this.target;
        if (attributeTextSpacingFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeTextSpacingFragment.lpwTextWordSpace = null;
        attributeTextSpacingFragment.lpwTextLinesSpace = null;
    }
}
