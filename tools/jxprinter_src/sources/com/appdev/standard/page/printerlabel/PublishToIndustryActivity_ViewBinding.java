package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PublishToIndustryActivity_ViewBinding implements Unbinder {
    private PublishToIndustryActivity target;

    @UiThread
    public PublishToIndustryActivity_ViewBinding(PublishToIndustryActivity publishToIndustryActivity) {
        this(publishToIndustryActivity, publishToIndustryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PublishToIndustryActivity publishToIndustryActivity = this.target;
        if (publishToIndustryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        publishToIndustryActivity.tvTitle = null;
        publishToIndustryActivity.etPublishToSquareIndustry = null;
        publishToIndustryActivity.tvPublishToIndustryType = null;
    }

    @UiThread
    public PublishToIndustryActivity_ViewBinding(PublishToIndustryActivity publishToIndustryActivity, View view) {
        this.target = publishToIndustryActivity;
        publishToIndustryActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        publishToIndustryActivity.etPublishToSquareIndustry = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_publish_to_square_industry, "field 'etPublishToSquareIndustry'", EditText.class);
        publishToIndustryActivity.tvPublishToIndustryType = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_publish_to_industry_type, "field 'tvPublishToIndustryType'", TextView.class);
    }
}
