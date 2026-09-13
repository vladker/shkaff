package com.appdev.standard.dialog;

import android.view.View;
import com.appdev.standard.api.dto.InviteRecordDto;

/* JADX INFO: renamed from: com.appdev.standard.dialog.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0465s implements com.library.base.util.recyclerview.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InvitationNotificationDialog f2655a;

    public C0465s(InvitationNotificationDialog invitationNotificationDialog) {
        this.f2655a = invitationNotificationDialog;
    }

    @Override // com.library.base.util.recyclerview.e
    public final void onItemClick(View view, int i5) {
        InvitationNotificationDialog invitationNotificationDialog = this.f2655a;
        InviteRecordDto.DataBean dataBean = (InviteRecordDto.DataBean) invitationNotificationDialog.b.getItem(i5);
        InvitationNotificationTipDialog invitationNotificationTipDialog = new InvitationNotificationTipDialog(invitationNotificationDialog.getContext());
        invitationNotificationTipDialog.c = dataBean;
        invitationNotificationTipDialog.mTvDialogContent.setText(String.format(invitationNotificationTipDialog.b.getString(p113u.g.text_113), dataBean.getInviteUserName()));
        invitationNotificationTipDialog.show();
        invitationNotificationTipDialog.setOnDismissListener(new r(this));
    }

    @Override // com.library.base.util.recyclerview.e
    public final void onItemLongClick(View view, int i5) {
    }
}
