package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ServerAgreementActivity_ViewBinding implements Unbinder {
    private ServerAgreementActivity target;

    @UiThread
    public ServerAgreementActivity_ViewBinding(ServerAgreementActivity serverAgreementActivity) {
        this(serverAgreementActivity, serverAgreementActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        ServerAgreementActivity serverAgreementActivity = this.target;
        if (serverAgreementActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        serverAgreementActivity.tvTitle = null;
    }

    @UiThread
    public ServerAgreementActivity_ViewBinding(ServerAgreementActivity serverAgreementActivity, View view) {
        this.target = serverAgreementActivity;
        serverAgreementActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
    }
}
