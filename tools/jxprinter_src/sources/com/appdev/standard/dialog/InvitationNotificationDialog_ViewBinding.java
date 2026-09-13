package com.appdev.standard.dialog;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InvitationNotificationDialog_ViewBinding implements Unbinder {
    public InvitationNotificationDialog b;
    public View c;

    @UiThread
    public InvitationNotificationDialog_ViewBinding(InvitationNotificationDialog invitationNotificationDialog) {
        this(invitationNotificationDialog, invitationNotificationDialog.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        InvitationNotificationDialog invitationNotificationDialog = this.b;
        if (invitationNotificationDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.b = null;
        invitationNotificationDialog.rvInvitationNotification = null;
        invitationNotificationDialog.containerDialog = null;
        this.c.setOnClickListener(null);
        this.c = null;
    }

    @UiThread
    public InvitationNotificationDialog_ViewBinding(InvitationNotificationDialog invitationNotificationDialog, View view) {
        this.b = invitationNotificationDialog;
        invitationNotificationDialog.rvInvitationNotification = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_invitation_notification, "field 'rvInvitationNotification'", RecyclerView.class);
        int i5 = p113u.d.container_dialog;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'containerDialog' and method 'onContainerClick'");
        invitationNotificationDialog.containerDialog = (RelativeLayout) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'containerDialog'", RelativeLayout.class);
        this.c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new C0466t(invitationNotificationDialog, 0));
    }
}
