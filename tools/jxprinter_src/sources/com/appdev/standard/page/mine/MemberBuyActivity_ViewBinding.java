package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MemberBuyActivity_ViewBinding implements Unbinder {
    private MemberBuyActivity target;

    @UiThread
    public MemberBuyActivity_ViewBinding(MemberBuyActivity memberBuyActivity) {
        this(memberBuyActivity, memberBuyActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MemberBuyActivity memberBuyActivity = this.target;
        if (memberBuyActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        memberBuyActivity.tvTitle = null;
        memberBuyActivity.tvItemMemberBuyMemberName = null;
        memberBuyActivity.tvItemMemberBuyMemberSupportersNumber = null;
        memberBuyActivity.tvMemberBuyMemberCloudTagsNumber = null;
        memberBuyActivity.tvMemberBuyMemberPrice = null;
        memberBuyActivity.qswMemberBuyCount = null;
        memberBuyActivity.llMemberBuyWechat = null;
        memberBuyActivity.llMemberBuyAlipay = null;
        memberBuyActivity.tvMemberBuyPrice = null;
        memberBuyActivity.tvMemberBuyMemberPersonTagsNumber = null;
        memberBuyActivity.tvDiscountRate = null;
        memberBuyActivity.llPayType = null;
        memberBuyActivity.llBuyCount = null;
        memberBuyActivity.ivPayAgreement = null;
        memberBuyActivity.tvPayAgreement = null;
    }

    @UiThread
    public MemberBuyActivity_ViewBinding(MemberBuyActivity memberBuyActivity, View view) {
        this.target = memberBuyActivity;
        memberBuyActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        memberBuyActivity.tvItemMemberBuyMemberName = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_member_name, "field 'tvItemMemberBuyMemberName'", TextView.class);
        memberBuyActivity.tvItemMemberBuyMemberSupportersNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_member_supporters_number, "field 'tvItemMemberBuyMemberSupportersNumber'", TextView.class);
        memberBuyActivity.tvMemberBuyMemberCloudTagsNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_member_cloud_tags_number, "field 'tvMemberBuyMemberCloudTagsNumber'", TextView.class);
        memberBuyActivity.tvMemberBuyMemberPrice = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_member_price, "field 'tvMemberBuyMemberPrice'", TextView.class);
        memberBuyActivity.qswMemberBuyCount = (QuantitySelectorWidget) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.qsw_member_buy_count, "field 'qswMemberBuyCount'", QuantitySelectorWidget.class);
        memberBuyActivity.llMemberBuyWechat = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_member_buy_wechat, "field 'llMemberBuyWechat'", LinearLayout.class);
        memberBuyActivity.llMemberBuyAlipay = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_member_buy_alipay, "field 'llMemberBuyAlipay'", LinearLayout.class);
        memberBuyActivity.tvMemberBuyPrice = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_price, "field 'tvMemberBuyPrice'", TextView.class);
        memberBuyActivity.tvMemberBuyMemberPersonTagsNumber = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_member_buy_member_person_tags_number, "field 'tvMemberBuyMemberPersonTagsNumber'", TextView.class);
        memberBuyActivity.tvDiscountRate = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_discount_rate, "field 'tvDiscountRate'", TextView.class);
        memberBuyActivity.llPayType = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_pay_type, "field 'llPayType'", LinearLayout.class);
        memberBuyActivity.llBuyCount = (LinearLayout) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.ll_buy_count, "field 'llBuyCount'", LinearLayout.class);
        memberBuyActivity.ivPayAgreement = (ImageView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.iv_pay_agreement, "field 'ivPayAgreement'", ImageView.class);
        memberBuyActivity.tvPayAgreement = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_pay_agreement, "field 'tvPayAgreement'", TextView.class);
    }
}
