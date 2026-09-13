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
public class CreateLabelActivity_ViewBinding implements Unbinder {
    private CreateLabelActivity target;

    @UiThread
    public CreateLabelActivity_ViewBinding(CreateLabelActivity createLabelActivity) {
        this(createLabelActivity, createLabelActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        CreateLabelActivity createLabelActivity = this.target;
        if (createLabelActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        createLabelActivity.tvTitle = null;
        createLabelActivity.etCreateLabelName = null;
        createLabelActivity.etCreateLabelWidth = null;
        createLabelActivity.etCreateLabelHeight = null;
        createLabelActivity.etCreateLabelColumns = null;
        createLabelActivity.etCreateLabelSpacing = null;
        createLabelActivity.llCreateLabelMoreSettingDetails = null;
        createLabelActivity.tvCreateLabelContent = null;
        createLabelActivity.ivCreateLabelIcon = null;
    }

    @UiThread
    public CreateLabelActivity_ViewBinding(CreateLabelActivity createLabelActivity, View view) {
        this.target = createLabelActivity;
        createLabelActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        createLabelActivity.etCreateLabelName = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_name, "field 'etCreateLabelName'", EditText.class);
        createLabelActivity.etCreateLabelWidth = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_width, "field 'etCreateLabelWidth'", EditText.class);
        createLabelActivity.etCreateLabelHeight = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_height, "field 'etCreateLabelHeight'", EditText.class);
        createLabelActivity.etCreateLabelColumns = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_columns, "field 'etCreateLabelColumns'", EditText.class);
        createLabelActivity.etCreateLabelSpacing = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_create_label_spacing, "field 'etCreateLabelSpacing'", EditText.class);
        createLabelActivity.llCreateLabelMoreSettingDetails = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_create_label_more_setting_details, "field 'llCreateLabelMoreSettingDetails'", LinearLayout.class);
        createLabelActivity.tvCreateLabelContent = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_create_label_content, "field 'tvCreateLabelContent'", TextView.class);
        createLabelActivity.ivCreateLabelIcon = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_create_label_icon, "field 'ivCreateLabelIcon'", ImageView.class);
    }
}
