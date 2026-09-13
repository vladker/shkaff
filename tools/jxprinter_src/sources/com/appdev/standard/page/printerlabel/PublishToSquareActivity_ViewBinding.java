package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PublishToSquareActivity_ViewBinding implements Unbinder {
    private PublishToSquareActivity target;

    @UiThread
    public PublishToSquareActivity_ViewBinding(PublishToSquareActivity publishToSquareActivity) {
        this(publishToSquareActivity, publishToSquareActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PublishToSquareActivity publishToSquareActivity = this.target;
        if (publishToSquareActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        publishToSquareActivity.tvTitle = null;
        publishToSquareActivity.etPublishToSquareDescribe = null;
        publishToSquareActivity.tvPublishToSquareType = null;
    }

    @UiThread
    public PublishToSquareActivity_ViewBinding(PublishToSquareActivity publishToSquareActivity, View view) {
        this.target = publishToSquareActivity;
        publishToSquareActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        publishToSquareActivity.etPublishToSquareDescribe = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_publish_to_square_describe, "field 'etPublishToSquareDescribe'", EditText.class);
        publishToSquareActivity.tvPublishToSquareType = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_publish_to_square_type, "field 'tvPublishToSquareType'", TextView.class);
    }
}
