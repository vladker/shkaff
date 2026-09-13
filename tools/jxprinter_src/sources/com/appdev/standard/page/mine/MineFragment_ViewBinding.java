package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MineFragment_ViewBinding implements Unbinder {
    private MineFragment target;
    private View view133e;
    private View view14b1;
    private View view1519;
    private View view151a;
    private View view151b;
    private View view151c;
    private View view151d;
    private View view151f;
    private View view1521;
    private View view17d0;
    private View view17d5;

    @UiThread
    public MineFragment_ViewBinding(final MineFragment mineFragment, View view) {
        this.target = mineFragment;
        mineFragment.mIvAvatar = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_avatar, "field 'mIvAvatar'", ImageView.class);
        mineFragment.mTvNickname = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_nickname, "field 'mTvNickname'", TextView.class);
        mineFragment.llFragmentMinePersonalInfo = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_fragment_mine_personal_info, "field 'llFragmentMinePersonalInfo'", LinearLayout.class);
        mineFragment.llFragmentMineNotLogin = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_fragment_mine_not_login, "field 'llFragmentMineNotLogin'", LinearLayout.class);
        mineFragment.tvFragmentMineVip = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_vip, "field 'tvFragmentMineVip'", TextView.class);
        int i5 = p113u.d.tv_fragment_mine_vip_false;
        View viewFindRequiredView = butterknife.internal.d.findRequiredView(view, i5, "field 'tvFragmentMineVipFalse' and method 'onOpenVIPClick'");
        mineFragment.tvFragmentMineVipFalse = (TextView) butterknife.internal.d.castView(viewFindRequiredView, i5, "field 'tvFragmentMineVipFalse'", TextView.class);
        this.view17d5 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.1
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onOpenVIPClick();
            }
        });
        mineFragment.tvFragmentMineEndTime = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_end_time, "field 'tvFragmentMineEndTime'", TextView.class);
        mineFragment.tvFragmentMineCloudSpace = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_cloud_space, "field 'tvFragmentMineCloudSpace'", TextView.class);
        mineFragment.tvFragmentMinePersonSpace = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_person_space, "field 'tvFragmentMinePersonSpace'", TextView.class);
        mineFragment.tvVersion = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_version, "field 'tvVersion'", TextView.class);
        int i6 = p113u.d.btn_invitation_notification;
        View viewFindRequiredView2 = butterknife.internal.d.findRequiredView(view, i6, "field 'btnInvitationNotification' and method 'onInvitationNotificationClick'");
        mineFragment.btnInvitationNotification = (TextView) butterknife.internal.d.castView(viewFindRequiredView2, i6, "field 'btnInvitationNotification'", TextView.class);
        this.view133e = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.2
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onInvitationNotificationClick();
            }
        });
        mineFragment.tvFragmentMineOrdinaryMember = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_fragment_mine_ordinary_member, "field 'tvFragmentMineOrdinaryMember'", TextView.class);
        View viewFindRequiredView3 = butterknife.internal.d.findRequiredView(view, p113u.d.iv_setting, "method 'onSettingClick'");
        this.view14b1 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.3
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onSettingClick();
            }
        });
        View viewFindRequiredView4 = butterknife.internal.d.findRequiredView(view, p113u.d.tv_fragment_mine_go_login, "method 'onGoLoginClick'");
        this.view17d0 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.4
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onGoLoginClick();
            }
        });
        View viewFindRequiredView5 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_language, "method 'onLanguageClick'");
        this.view151c = viewFindRequiredView5;
        viewFindRequiredView5.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.5
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onLanguageClick();
            }
        });
        View viewFindRequiredView6 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_member_center, "method 'onVipCenterClick'");
        this.view151d = viewFindRequiredView6;
        viewFindRequiredView6.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.6
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onVipCenterClick();
            }
        });
        View viewFindRequiredView7 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_cloud_space, "method 'onCloudSpaceClick'");
        this.view1519 = viewFindRequiredView7;
        viewFindRequiredView7.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.7
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onCloudSpaceClick();
            }
        });
        View viewFindRequiredView8 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_help, "method 'onHelpClick'");
        this.view151b = viewFindRequiredView8;
        viewFindRequiredView8.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.8
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onHelpClick();
            }
        });
        View viewFindRequiredView9 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_feedback, "method 'onFeedBackClick'");
        this.view151a = viewFindRequiredView9;
        viewFindRequiredView9.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.9
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onFeedBackClick();
            }
        });
        View viewFindRequiredView10 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_xieyi, "method 'onXieyiClick'");
        this.view1521 = viewFindRequiredView10;
        viewFindRequiredView10.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.10
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onXieyiClick();
            }
        });
        View viewFindRequiredView11 = butterknife.internal.d.findRequiredView(view, p113u.d.ll_fragment_mine_person_space, "method 'onMinePersonSpaceClick'");
        this.view151f = viewFindRequiredView11;
        viewFindRequiredView11.setOnClickListener(new butterknife.internal.b() { // from class: com.appdev.standard.page.mine.MineFragment_ViewBinding.11
            @Override // butterknife.internal.b
            public void doClick(View view2) {
                mineFragment.onMinePersonSpaceClick();
            }
        });
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MineFragment mineFragment = this.target;
        if (mineFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        mineFragment.mIvAvatar = null;
        mineFragment.mTvNickname = null;
        mineFragment.llFragmentMinePersonalInfo = null;
        mineFragment.llFragmentMineNotLogin = null;
        mineFragment.tvFragmentMineVip = null;
        mineFragment.tvFragmentMineVipFalse = null;
        mineFragment.tvFragmentMineEndTime = null;
        mineFragment.tvFragmentMineCloudSpace = null;
        mineFragment.tvFragmentMinePersonSpace = null;
        mineFragment.tvVersion = null;
        mineFragment.btnInvitationNotification = null;
        mineFragment.tvFragmentMineOrdinaryMember = null;
        this.view17d5.setOnClickListener(null);
        this.view17d5 = null;
        this.view133e.setOnClickListener(null);
        this.view133e = null;
        this.view14b1.setOnClickListener(null);
        this.view14b1 = null;
        this.view17d0.setOnClickListener(null);
        this.view17d0 = null;
        this.view151c.setOnClickListener(null);
        this.view151c = null;
        this.view151d.setOnClickListener(null);
        this.view151d = null;
        this.view1519.setOnClickListener(null);
        this.view1519 = null;
        this.view151b.setOnClickListener(null);
        this.view151b = null;
        this.view151a.setOnClickListener(null);
        this.view151a = null;
        this.view1521.setOnClickListener(null);
        this.view1521 = null;
        this.view151f.setOnClickListener(null);
        this.view151f = null;
    }
}
