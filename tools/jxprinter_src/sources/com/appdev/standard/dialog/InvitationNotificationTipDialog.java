package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.dto.InviteRecordDto;
import com.appdev.standard.api.pto.DisposeInviteRecordPto;
import com.library.base.util.http.Http;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InvitationNotificationTipDialog extends Dialog implements Q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q.b f2613a;
    public final Context b;
    public InviteRecordDto.DataBean c;

    @BindView(4919)
    TextView mBtnCancel;

    @BindView(4920)
    TextView mBtnConfirm;

    @BindView(6061)
    TextView mTvDialogContent;

    @BindView(6067)
    TextView mTvDialogTitle;

    public InvitationNotificationTipDialog(@NonNull Context context) {
        super(context, p113u.h.Dialog);
        this.f2613a = null;
        this.c = null;
        this.b = context;
        setContentView(p113u.e.dialog_invitation_notification_tips);
        ButterKnife.bind(this);
        Q.b bVar = new Q.b(context);
        bVar.d = null;
        bVar.d = (MineApi) Http.createApi(MineApi.class);
        this.f2613a = bVar;
        bVar.b = this;
    }

    @OnClick({4919, 4920})
    public void onBtnClick(View view) {
        int id = view.getId();
        int i5 = p113u.d.btn_cancel;
        Q.b bVar = this.f2613a;
        if (id == i5) {
            p050j.w.e();
            bVar.d.disposeInviteRecord(new DisposeInviteRecordPto(this.c.getInviteRecordId(), 2)).b(new A.c(bVar, 18));
        } else if (view.getId() == p113u.d.btn_confirm) {
            p050j.w.e();
            bVar.d.disposeInviteRecord(new DisposeInviteRecordPto(this.c.getInviteRecordId(), 1)).b(new A.c(bVar, 18));
        }
    }
}
