package com.appdev.standard.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.library.base.frame.FrameActivity;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class InvitationNotificationDialog extends Dialog implements Q.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q.d f2612a;
    public final p119v.b b;

    @BindView(4985)
    RelativeLayout containerDialog;

    @BindView(5836)
    RecyclerView rvInvitationNotification;

    public InvitationNotificationDialog(FrameActivity frameActivity) {
        super(frameActivity, p113u.h.Dialog);
        this.f2612a = null;
        this.b = null;
        setContentView(p113u.e.dialog_invitation_notification);
        ButterKnife.bind(this);
        setCanceledOnTouchOutside(false);
        Q.d dVar = new Q.d(frameActivity);
        this.f2612a = dVar;
        dVar.b = this;
        Context context = getContext();
        p119v.b bVar = new p119v.b(context, p113u.e.item_invitation_notification);
        bVar.f8750a = context;
        this.b = bVar;
        this.rvInvitationNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvInvitationNotification.setAdapter(bVar);
        bVar.setOnItemClickListener(new C0465s(this));
        dVar.a();
    }

    @Override // Q.c
    public final void getInviteRecordListFailed(int i5, String str) {
        dismiss();
    }

    @Override // Q.c
    public final void getInviteRecordListSuccess(List list) {
        if (list.size() > 0) {
            this.b.replaceAll(list);
        } else {
            dismiss();
        }
    }

    @OnClick({4985})
    public void onContainerClick() {
        dismiss();
    }
}
