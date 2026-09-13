package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import xyz.doikki.videoplayer.player.VideoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class VideoViewActivity_ViewBinding implements Unbinder {
    private VideoViewActivity target;

    @UiThread
    public VideoViewActivity_ViewBinding(VideoViewActivity videoViewActivity) {
        this(videoViewActivity, videoViewActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        VideoViewActivity videoViewActivity = this.target;
        if (videoViewActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        videoViewActivity.tvTitle = null;
        videoViewActivity.vvMain = null;
    }

    @UiThread
    public VideoViewActivity_ViewBinding(VideoViewActivity videoViewActivity, View view) {
        this.target = videoViewActivity;
        videoViewActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        videoViewActivity.vvMain = (VideoView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.vv_main, "field 'vvMain'", VideoView.class);
    }
}
