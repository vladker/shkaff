package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class EditLabelActivity_ViewBinding implements Unbinder {
    private EditLabelActivity target;

    @UiThread
    public EditLabelActivity_ViewBinding(EditLabelActivity editLabelActivity) {
        this(editLabelActivity, editLabelActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        EditLabelActivity editLabelActivity = this.target;
        if (editLabelActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        editLabelActivity.tvTitle = null;
        editLabelActivity.etCreateLabelName = null;
        editLabelActivity.etCreateLabelWidth = null;
        editLabelActivity.etCreateLabelHeight = null;
        editLabelActivity.etCreateLabelColumns = null;
        editLabelActivity.etCreateLabelSpacing = null;
        editLabelActivity.llCreateLabelMoreSettingDetails = null;
        editLabelActivity.tvCreateLabelContent = null;
        editLabelActivity.ivCreateLabelIcon = null;
    }

    @UiThread
    public EditLabelActivity_ViewBinding(EditLabelActivity editLabelActivity, View view) {
        this.target = editLabelActivity;
        editLabelActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        editLabelActivity.etCreateLabelName = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_name, "field 'etCreateLabelName'", EditText.class);
        editLabelActivity.etCreateLabelWidth = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_width, "field 'etCreateLabelWidth'", EditText.class);
        editLabelActivity.etCreateLabelHeight = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_height, "field 'etCreateLabelHeight'", EditText.class);
        editLabelActivity.etCreateLabelColumns = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_columns, "field 'etCreateLabelColumns'", EditText.class);
        editLabelActivity.etCreateLabelSpacing = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_spacing, "field 'etCreateLabelSpacing'", EditText.class);
        editLabelActivity.llCreateLabelMoreSettingDetails = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_create_label_more_setting_details, "field 'llCreateLabelMoreSettingDetails'", LinearLayout.class);
        editLabelActivity.tvCreateLabelContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_create_label_content, "field 'tvCreateLabelContent'", TextView.class);
        editLabelActivity.ivCreateLabelIcon = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_create_label_icon, "field 'ivCreateLabelIcon'", ImageView.class);
    }
}
