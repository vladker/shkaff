package com.appdev.standard.page.mine;

import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.dto.InviteRecordDto;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.InvitationNotificationDialog;
import com.appdev.standard.page.MainActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p025e0.i;
import p025e0.k;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MineFragment extends com.library.base.frame.f implements i, Q.c {

    @BindView(4926)
    TextView btnInvitationNotification;

    @BindView(5406)
    LinearLayout llFragmentMineNotLogin;

    @BindView(5408)
    LinearLayout llFragmentMinePersonalInfo;

    @BindView(5197)
    ImageView mIvAvatar;

    @BindView(6176)
    TextView mTvNickname;

    @BindView(6094)
    TextView tvFragmentMineCloudSpace;

    @BindView(6095)
    TextView tvFragmentMineEndTime;

    @BindView(6098)
    TextView tvFragmentMineOrdinaryMember;

    @BindView(6099)
    TextView tvFragmentMinePersonSpace;

    @BindView(6100)
    TextView tvFragmentMineVip;

    @BindView(6101)
    TextView tvFragmentMineVipFalse;

    @BindView(6277)
    TextView tvVersion;
    private k userInfoWorker = null;
    private Q.d inviteRecordListWorker = null;

    @Override // Q.c
    public void getInviteRecordListFailed(int i5, String str) {
        this.btnInvitationNotification.setVisibility(4);
    }

    @Override // Q.c
    public void getInviteRecordListSuccess(List<InviteRecordDto.DataBean> list) {
        if (list.size() > 0) {
            this.btnInvitationNotification.setVisibility(0);
        } else {
            this.btnInvitationNotification.setVisibility(4);
        }
    }

    @Override // p025e0.i
    public void getUserInfoFailed(int i5, String str) {
        w.c();
        if (p042h2.e.f4031a.g()) {
            return;
        }
        this.llFragmentMinePersonalInfo.setVisibility(8);
        this.llFragmentMineNotLogin.setVisibility(0);
        this.tvFragmentMineCloudSpace.setText("");
    }

    @Override // p025e0.i
    public void getUserInfoSuccess() {
        w.c();
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            this.llFragmentMinePersonalInfo.setVisibility(8);
            this.llFragmentMineNotLogin.setVisibility(0);
            this.tvFragmentMineCloudSpace.setText("");
            return;
        }
        this.llFragmentMinePersonalInfo.setVisibility(0);
        this.llFragmentMineNotLogin.setVisibility(8);
        p032f2.a aVarE = hVar.e();
        this.mTvNickname.setText(aVarE.f3961a);
        p047i2.a.loadCirclePicture(aVarE.b, this.mIvAvatar, p113u.f.ic_default_avatar);
        if (hVar.h()) {
            this.tvFragmentMineOrdinaryMember.setVisibility(8);
            this.tvFragmentMineVipFalse.setVisibility(8);
            this.tvFragmentMineEndTime.setVisibility(0);
            this.tvFragmentMineVip.setVisibility(0);
            this.tvFragmentMineVip.setText(aVarE.e);
            this.tvFragmentMineEndTime.setText(String.format(getString(p113u.g.text_278), aVarE.f3964h));
            this.tvFragmentMineCloudSpace.setText(aVarE.f3963g + PackagingURIHelper.FORWARD_SLASH_STRING + aVarE.f3962f);
        } else {
            this.tvFragmentMineOrdinaryMember.setVisibility(0);
            this.tvFragmentMineVipFalse.setVisibility(0);
            this.tvFragmentMineEndTime.setVisibility(8);
            this.tvFragmentMineVip.setVisibility(8);
            this.tvFragmentMineCloudSpace.setText("0");
        }
        this.tvFragmentMinePersonSpace.setText(aVarE.f3965i + PackagingURIHelper.FORWARD_SLASH_STRING + aVarE.f3966j);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        k kVar = new k(getContext());
        this.userInfoWorker = kVar;
        addPresenter(kVar);
        Q.d dVar = new Q.d(getContext());
        this.inviteRecordListWorker = dVar;
        addPresenter(dVar);
        if (p051j0.a.f5394a != 9) {
            this.tvVersion.setText("T1.1.8.102");
        } else {
            this.tvVersion.setText("1.1.8.102");
        }
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_mine;
    }

    @OnClick({5401})
    public void onCloudSpaceClick() {
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        if (hVar.h()) {
            ((MainActivity) getFrameActivity()).switchToCloudSpace();
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getFrameActivity());
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_246));
        defaultTipDialog.a(getString(p113u.g.text_254));
        defaultTipDialog.b(getString(p113u.g.text_255));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.mine.MineFragment.1
            @Override // com.library.base.frame.d
            public void onConfirm() {
                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    @OnClick({5402})
    public void onFeedBackClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_FEEDBACK);
    }

    @OnClick({6096})
    public void onGoLoginClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @OnClick({5403})
    public void onHelpClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_HELP_CENTER);
    }

    @OnClick({4926})
    public void onInvitationNotificationClick() {
        InvitationNotificationDialog invitationNotificationDialog = new InvitationNotificationDialog(getFrameActivity());
        invitationNotificationDialog.show();
        invitationNotificationDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.appdev.standard.page.mine.MineFragment.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MineFragment.this.inviteRecordListWorker.a();
                MineFragment.this.userInfoWorker.a();
            }
        });
    }

    @OnClick({5404})
    public void onLanguageClick() {
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("language").arguments(new HashMap()).requestCode(0).build());
    }

    @OnClick({5407})
    public void onMinePersonSpaceClick() {
        ((MainActivity) getFrameActivity()).switchToMinePersonSpace();
    }

    @OnClick({6101})
    public void onOpenVIPClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            this.llFragmentMinePersonalInfo.setVisibility(8);
            this.llFragmentMineNotLogin.setVisibility(0);
            this.tvFragmentMineCloudSpace.setText("");
            return;
        }
        this.llFragmentMinePersonalInfo.setVisibility(0);
        this.llFragmentMineNotLogin.setVisibility(8);
        p032f2.a aVarE = hVar.e();
        this.mTvNickname.setText(aVarE.f3961a);
        p047i2.a.loadCirclePicture(aVarE.b, this.mIvAvatar, p113u.f.ic_default_avatar);
        if (hVar.h()) {
            this.tvFragmentMineOrdinaryMember.setVisibility(8);
            this.tvFragmentMineVipFalse.setVisibility(8);
            this.tvFragmentMineEndTime.setVisibility(0);
            this.tvFragmentMineVip.setVisibility(0);
            this.tvFragmentMineVip.setText(aVarE.e);
            this.tvFragmentMineEndTime.setText(String.format(getString(p113u.g.text_278), aVarE.f3964h));
            this.tvFragmentMineCloudSpace.setText(aVarE.f3963g + PackagingURIHelper.FORWARD_SLASH_STRING + aVarE.f3962f);
        } else {
            this.tvFragmentMineOrdinaryMember.setVisibility(0);
            this.tvFragmentMineVipFalse.setVisibility(0);
            this.tvFragmentMineEndTime.setVisibility(8);
            this.tvFragmentMineVip.setVisibility(8);
            this.tvFragmentMineCloudSpace.setText("0");
        }
        this.tvFragmentMinePersonSpace.setText(aVarE.f3965i + PackagingURIHelper.FORWARD_SLASH_STRING + aVarE.f3966j);
        this.userInfoWorker.a();
    }

    @OnClick({5297})
    public void onSettingClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_PERSONALINFOMATION);
    }

    @OnClick({5405})
    public void onVipCenterClick() {
        if (p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    @OnClick({5409})
    public void onXieyiClick() {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_SERVER_AGREEMENT);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.inviteRecordListWorker.a();
    }
}
