package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class FeedbackListActivity_ViewBinding implements Unbinder {
    private FeedbackListActivity target;

    @UiThread
    public FeedbackListActivity_ViewBinding(FeedbackListActivity feedbackListActivity) {
        this(feedbackListActivity, feedbackListActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        FeedbackListActivity feedbackListActivity = this.target;
        if (feedbackListActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        feedbackListActivity.tvTitle = null;
        feedbackListActivity.rvFeedbackList = null;
    }

    @UiThread
    public FeedbackListActivity_ViewBinding(FeedbackListActivity feedbackListActivity, View view) {
        this.target = feedbackListActivity;
        feedbackListActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        feedbackListActivity.rvFeedbackList = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_feedback_list, "field 'rvFeedbackList'", RecyclerView.class);
    }
}
