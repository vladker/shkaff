package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FeedbackActivity_ViewBinding implements Unbinder {
    private FeedbackActivity target;

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity) {
        this(feedbackActivity, feedbackActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackActivity feedbackActivity = this.target;
        if (feedbackActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        feedbackActivity.tvTitle = null;
        feedbackActivity.ivFeedbackAdvise = null;
        feedbackActivity.ivFeedbackBug = null;
        feedbackActivity.ivFeedbackFunction = null;
        feedbackActivity.ivFeedbackOther = null;
        feedbackActivity.etFeedbackFeedbackContent = null;
        feedbackActivity.tvFeedbackFeedbackContentCount = null;
        feedbackActivity.rvFeedbackFeedbackImg = null;
        feedbackActivity.etFeedbackFeedbackContactWay = null;
        feedbackActivity.tvFeedbackAddImgCount = null;
    }

    @UiThread
    public FeedbackActivity_ViewBinding(FeedbackActivity feedbackActivity, View view) {
        this.target = feedbackActivity;
        feedbackActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        feedbackActivity.ivFeedbackAdvise = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_feedback_advise, "field 'ivFeedbackAdvise'", ImageView.class);
        feedbackActivity.ivFeedbackBug = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_feedback_bug, "field 'ivFeedbackBug'", ImageView.class);
        feedbackActivity.ivFeedbackFunction = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_feedback_function, "field 'ivFeedbackFunction'", ImageView.class);
        feedbackActivity.ivFeedbackOther = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_feedback_other, "field 'ivFeedbackOther'", ImageView.class);
        feedbackActivity.etFeedbackFeedbackContent = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_feedback_feedback_content, "field 'etFeedbackFeedbackContent'", EditText.class);
        feedbackActivity.tvFeedbackFeedbackContentCount = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_feedback_feedback_content_count, "field 'tvFeedbackFeedbackContentCount'", TextView.class);
        feedbackActivity.rvFeedbackFeedbackImg = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_feedback_feedback_img, "field 'rvFeedbackFeedbackImg'", RecyclerView.class);
        feedbackActivity.etFeedbackFeedbackContactWay = (EditText) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.et_feedback_feedback_contact_way, "field 'etFeedbackFeedbackContactWay'", EditText.class);
        feedbackActivity.tvFeedbackAddImgCount = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_feedback_add_img_count, "field 'tvFeedbackAddImgCount'", TextView.class);
    }
}
