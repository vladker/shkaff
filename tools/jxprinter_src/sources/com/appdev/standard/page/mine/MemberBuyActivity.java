package com.appdev.standard.page.mine;

import A3.AbstractC0157z;
import S4.k;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.billingclient.api.AbstractC0419l;
import com.android.billingclient.api.C0416j0;
import com.android.billingclient.api.C0418k0;
import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.C0436u;
import com.android.billingclient.api.C0441w0;
import com.android.billingclient.api.C0442x;
import com.android.billingclient.api.C0443x0;
import com.android.billingclient.api.H;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.dto.VipPayDto;
import com.appdev.standard.api.pto.GooglePayPto;
import com.appdev.standard.api.pto.VipPayPto;
import com.appdev.standard.dialog.MemberBuySuccessDialog;
import com.appdev.standard.dialog.x;
import com.appdev.standard.model.VipModel;
import com.appdev.standard.page.auth.AgreementActivity;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.greenrobot.eventbus.ThreadMode;
import p037g0.n;
import p037g0.o;
import p037g0.p;
import p050j.w;
import p134x2.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MEMBER_BUY)
public class MemberBuyActivity extends MvpActivity implements n {
    private static final String KEY_PENDING_GOOGLE_ORDER_ID = "PENDING_GOOGLE_ORDER_ID";
    private static final String KEY_PENDING_GOOGLE_PACKAGE_ID = "PENDING_GOOGLE_PACKAGE_ID";
    private static final String KEY_PENDING_PURCHASE_TOKEN = "PENDING_PURCHASE_TOKEN";
    private String appType;
    private Context context;

    @BindView(5263)
    ImageView ivPayAgreement;

    @BindView(5357)
    LinearLayout llBuyCount;

    @BindView(5421)
    LinearLayout llMemberBuyAlipay;

    @BindView(5422)
    LinearLayout llMemberBuyWechat;

    @BindView(5427)
    LinearLayout llPayType;
    private MemberBuySuccessDialog memberBuySuccessDialog;

    @BindView(5725)
    QuantitySelectorWidget qswMemberBuyCount;

    @BindView(6068)
    TextView tvDiscountRate;

    @BindView(6166)
    TextView tvItemMemberBuyMemberName;

    @BindView(6169)
    TextView tvItemMemberBuyMemberSupportersNumber;

    @BindView(6165)
    TextView tvMemberBuyMemberCloudTagsNumber;

    @BindView(6167)
    TextView tvMemberBuyMemberPersonTagsNumber;

    @BindView(6168)
    TextView tvMemberBuyMemberPrice;

    @BindView(6170)
    TextView tvMemberBuyPrice;

    @BindView(6178)
    TextView tvPayAgreement;

    @BindView(6274)
    TextView tvTitle;
    private VipModel vipModel;
    private boolean isAgreementChecked = false;
    private int buyCount = 1;
    private int payType = -1;
    private p vipPayWorker = null;
    private VipPayDto.DataBean.GooglePayBean googlePayBean = null;
    private String currentPurchaseToken = null;
    private int googlePayTryCount = 0;
    private p062l0.b billProxy = new p062l0.b();
    private GoogleBillingListenerImpl billingListenerImpl = new GoogleBillingListenerImpl(this, 0);

    /* JADX INFO: renamed from: com.appdev.standard.page.mine.MemberBuyActivity$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass5 implements x {
        public AnonymousClass5() {
        }

        @Override // com.appdev.standard.dialog.x
        public void onFinish() {
            MemberBuyActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class GoogleBillingListenerImpl implements p062l0.c {
        public /* synthetic */ GoogleBillingListenerImpl(MemberBuyActivity memberBuyActivity, int i5) {
            this();
        }

        @Override // p062l0.c
        public void onConsumeFail(String str) {
            p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "消费失败: " + str);
            MemberBuyActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.GoogleBillingListenerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    w.c();
                    p042h2.d.a("Payment consumption failed, please try again");
                }
            });
        }

        @Override // p062l0.c
        public void onConsumeSus(String str) {
            p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "消费成功，purchaseToken: " + str);
            MemberBuyActivity.this.currentPurchaseToken = str;
            Hawk.put(MemberBuyActivity.KEY_PENDING_PURCHASE_TOKEN, str);
            MemberBuyActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.GoogleBillingListenerImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    w.e();
                }
            });
            MemberBuyActivity.this.submitGooglePayToServer(str);
        }

        @Override // p062l0.c
        public void onPendingPurchaseFound(C0431r0 c0431r0) {
            p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "发现未完成的购买，尝试恢复: " + c0431r0.getOrderId());
            if (((String) Hawk.get(MemberBuyActivity.KEY_PENDING_GOOGLE_ORDER_ID, "")).isEmpty()) {
                p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "本地没有订单信息，无法恢复");
            } else {
                MemberBuyActivity.this.billProxy.a(this, c0431r0);
            }
        }

        @Override // p062l0.c
        public void onProductDetailsFail() {
            p042h2.d.show(p113u.g.text_434);
        }

        @Override // p062l0.c
        public void onProductDetailsSus(List<C0418k0> list) {
            if (list == null || list.size() <= 0) {
                p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "没有查询到相关产品");
                return;
            }
            p062l0.b bVar = MemberBuyActivity.this.billProxy;
            MemberBuyActivity memberBuyActivity = MemberBuyActivity.this;
            C0418k0 c0418k0 = list.get(0);
            bVar.getClass();
            if (c0418k0 == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(C0436u.newBuilder().setProductDetails(c0418k0).build());
            if (p062l0.e.b().f5781a.launchBillingFlow(memberBuyActivity, C0442x.newBuilder().setProductDetailsParamsList(arrayList).build()).f2433a == 0) {
                p062l0.e.b().b = this;
            }
        }

        @Override // p062l0.c
        public void onPurchasesUpdated(H h6, List<C0431r0> list) {
            if (h6 == null || h6.f2433a != 0) {
                String str = ((BaseActivity) MemberBuyActivity.this).TAG;
                StringBuilder sb = new StringBuilder("购买失败，响应码: ");
                sb.append(h6 != null ? Integer.valueOf(h6.f2433a) : AbstractC1127c.NULL);
                p051j0.a.d(str, sb.toString());
                return;
            }
            if (list == null || list.isEmpty()) {
                p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "购买列表为空");
                return;
            }
            p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "购买成功，开始处理 " + list.size() + " 个购买项");
            for (C0431r0 c0431r0 : list) {
                String purchaseToken = c0431r0.getPurchaseToken();
                p051j0.a.d(((BaseActivity) MemberBuyActivity.this).TAG, "保存 purchaseToken: " + purchaseToken);
                Hawk.put(MemberBuyActivity.KEY_PENDING_PURCHASE_TOKEN, purchaseToken);
                MemberBuyActivity.this.billProxy.a(this, c0431r0);
            }
        }

        private GoogleBillingListenerImpl() {
        }
    }

    private void checkPendingGooglePayment() {
        String str = (String) Hawk.get(KEY_PENDING_GOOGLE_ORDER_ID, "");
        String str2 = (String) Hawk.get(KEY_PENDING_PURCHASE_TOKEN, "");
        String str3 = this.TAG;
        StringBuilder sbY = AbstractC0157z.y("检查未完成订单 - OrderId: ", str, ", hasToken: ");
        sbY.append(!str2.isEmpty());
        p051j0.a.d(str3, sbY.toString());
        if (!str.isEmpty() && !str2.isEmpty()) {
            p051j0.a.d(this.TAG, "发现未完成的Google支付订单: ".concat(str));
            runOnUiThread(new W2.b(this, str2, 13));
        } else if (str.isEmpty()) {
            p051j0.a.d(this.TAG, "没有未完成的订单");
        } else {
            p051j0.a.d(this.TAG, "有订单但缺少purchaseToken，等待BillingClient连接后查询Google Play");
            new Handler().postDelayed(new g(this, 0), 1000L);
        }
    }

    private void clearPendingGooglePayment() {
        Hawk.delete(KEY_PENDING_GOOGLE_ORDER_ID);
        Hawk.delete(KEY_PENDING_GOOGLE_PACKAGE_ID);
        Hawk.delete(KEY_PENDING_PURCHASE_TOKEN);
        this.googlePayTryCount = 0;
        p051j0.a.d(this.TAG, "清除本地Google支付信息");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPendingGooglePayment$1(String str, DialogInterface dialogInterface, int i5) {
        p051j0.a.d(this.TAG, "用户选择继续验证订单");
        w.e();
        submitGooglePayToServer(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPendingGooglePayment$2(DialogInterface dialogInterface, int i5) {
        p051j0.a.d(this.TAG, "用户选择取消订单");
        clearPendingGooglePayment();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPendingGooglePayment$3(final String str) {
        new AlertDialog.Builder(this).setTitle(getString(p113u.g.text_510)).setMessage(getString(p113u.g.text_512)).setPositiveButton(getString(p113u.g.text_513), new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.mine.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f2705a.lambda$checkPendingGooglePayment$1(str, dialogInterface, i5);
            }
        }).setNegativeButton(getString(p113u.g.text_514), new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.mine.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f2706a.lambda$checkPendingGooglePayment$2(dialogInterface, i5);
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPendingGooglePayment$4() {
        p062l0.e.b().d(this.billingListenerImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(View view) {
        boolean z6 = this.isAgreementChecked;
        this.isAgreementChecked = !z6;
        this.ivPayAgreement.setImageResource(!z6 ? p113u.f.standard_ic_common_radio_select : p113u.f.standard_ic_common_radio_select_not);
    }

    private void showPaymentFailed() {
        w.c();
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PAY_RESULT).withInt("payStatus", 2).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submitGooglePayToServer(String str) {
        String str2 = (String) Hawk.get(KEY_PENDING_GOOGLE_ORDER_ID, "");
        if (str2.isEmpty()) {
            p051j0.a.d(this.TAG, "订单号为空，无法提交验证");
            w.c();
        } else {
            p pVar = this.vipPayWorker;
            pVar.d.googlePay(new GooglePayPto(str2, str, getPackageName())).b(new o(pVar, 1));
        }
    }

    @Override // p037g0.n
    public void googlePayFailed(int i5, String str) {
        this.googlePayTryCount++;
        p051j0.a.d(this.TAG, "Google支付验证失败，重试次数: " + this.googlePayTryCount);
        if (this.googlePayTryCount > 3) {
            p051j0.a.d(this.TAG, "重试次数已用完，保留订单信息供后续恢复");
            showPaymentFailed();
            return;
        }
        String str2 = (String) Hawk.get(KEY_PENDING_GOOGLE_ORDER_ID, "");
        String str3 = (String) Hawk.get(KEY_PENDING_PURCHASE_TOKEN, "");
        if (str2.isEmpty() || str3.isEmpty()) {
            p051j0.a.d(this.TAG, "订单信息丢失，无法重试");
            showPaymentFailed();
        } else {
            p pVar = this.vipPayWorker;
            pVar.d.googlePay(new GooglePayPto(str2, str3, getPackageName())).b(new o(pVar, 1));
        }
    }

    @Override // p037g0.n
    public void googlePaySuccess() {
        w.c();
        clearPendingGooglePayment();
        MemberBuySuccessDialog memberBuySuccessDialog = new MemberBuySuccessDialog(this);
        this.memberBuySuccessDialog = memberBuySuccessDialog;
        memberBuySuccessDialog.f2619a = new x() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.4
            @Override // com.appdev.standard.dialog.x
            public void onFinish() {
                MemberBuyActivity.this.finish();
            }
        };
        this.memberBuySuccessDialog.show();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        String string;
        registerEventBus();
        super.initComponent();
        String str = (String) Hawk.get("appType");
        this.appType = str;
        int i5 = 0;
        if (str.equals("sanduOverseas")) {
            this.llPayType.setVisibility(8);
            this.llBuyCount.setVisibility(8);
            this.payType = 5;
            p062l0.e eVarB = p062l0.e.b();
            eVarB.d = 0;
            eVarB.f5781a = AbstractC0419l.newBuilder(getApplicationContext()).enablePendingPurchases(C0416j0.newBuilder().enableOneTimeProducts().build()).setListener(new p062l0.d(eVarB)).build();
            eVarB.e();
            checkPendingGooglePayment();
        } else {
            this.llPayType.setVisibility(0);
            this.llBuyCount.setVisibility(0);
            this.payType = -1;
        }
        this.context = this;
        p pVar = new p(this);
        pVar.d = (MineApi) Http.createApi(MineApi.class);
        this.vipPayWorker = pVar;
        addPresenter(pVar);
        this.tvTitle.setText(getString(p113u.g.text_232));
        this.tvItemMemberBuyMemberName.setText(this.vipModel.getMemberName());
        this.tvItemMemberBuyMemberSupportersNumber.setText(String.format(getString(p113u.g.text_274), this.vipModel.getSupportersNumber()));
        this.tvMemberBuyMemberCloudTagsNumber.setText(String.format(getString(p113u.g.text_275), this.vipModel.getCloudTagsNumber()));
        this.tvMemberBuyMemberPersonTagsNumber.setText(String.format(getString(p113u.g.text_276), this.vipModel.getPersonalTagsNumber()));
        String periodOfValidity = this.vipModel.getPeriodOfValidity();
        periodOfValidity.getClass();
        switch (periodOfValidity) {
            case "1":
                string = getString(p113u.g.text_313);
                break;
            case "2":
                string = getString(p113u.g.text_314);
                break;
            case "3":
                string = getString(p113u.g.text_315);
                break;
            case "4":
                string = getString(p113u.g.text_316);
                break;
            default:
                string = "";
                break;
        }
        if (this.appType.equals("sanduOverseas")) {
            this.tvMemberBuyMemberPrice.setText("$" + this.vipModel.getPrice() + PackagingURIHelper.FORWARD_SLASH_STRING + string);
        } else {
            this.tvMemberBuyMemberPrice.setText("￥" + this.vipModel.getPrice() + PackagingURIHelper.FORWARD_SLASH_STRING + string);
        }
        float fFloatValue = new BigDecimal(this.vipModel.getPrice()).multiply(new BigDecimal(this.buyCount)).floatValue();
        if (this.appType.equals("sanduOverseas")) {
            this.tvMemberBuyPrice.setText(String.format("$%.2f", Float.valueOf(fFloatValue)));
        } else {
            this.tvMemberBuyPrice.setText(String.format("￥%.2f", Float.valueOf(fFloatValue)));
        }
        try {
            if (Integer.parseInt(this.vipModel.getDiscountRate()) < 100) {
                this.tvDiscountRate.setText(String.format(getString(p113u.g.text_277), this.vipModel.getDiscountRate()));
                this.tvDiscountRate.setVisibility(0);
            } else {
                this.tvDiscountRate.setVisibility(8);
            }
        } catch (Exception unused) {
            this.tvDiscountRate.setVisibility(8);
        }
        String str2 = String.format(getString(p113u.g.text_509), new Object[0]);
        SpannableString spannableString = new SpannableString(str2);
        spannableString.setSpan(new ClickableSpan() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                Intent intent = new Intent(MemberBuyActivity.this, (Class<?>) AgreementActivity.class);
                intent.putExtra("agreement_type", 3);
                MemberBuyActivity.this.startActivity(intent);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(ContextCompat.getColor(MemberBuyActivity.this.context, p113u.a.color_FFAE00));
                textPaint.setUnderlineText(false);
                textPaint.bgColor = 0;
                textPaint.clearShadowLayer();
            }
        }, str2.indexOf("《"), str2.indexOf("》") + 1, 33);
        this.tvPayAgreement.setText(spannableString);
        this.tvPayAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        this.ivPayAgreement.setOnClickListener(new f(this, i5));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.qswMemberBuyCount.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.2
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                MemberBuyActivity.this.buyCount = i5;
                MemberBuyActivity.this.tvMemberBuyPrice.setText(String.format("¥%.2f", Float.valueOf(MemberBuyActivity.this.buyCount >= 2 ? new BigDecimal(MemberBuyActivity.this.vipModel.getPrice()).multiply(new BigDecimal(MemberBuyActivity.this.buyCount)).multiply(new BigDecimal(MemberBuyActivity.this.vipModel.getDiscountRate())).divide(new BigDecimal(100), 2, 1).floatValue() : new BigDecimal(MemberBuyActivity.this.vipModel.getPrice()).multiply(new BigDecimal(MemberBuyActivity.this.buyCount)).floatValue())));
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_member_buy;
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        p062l0.e eVarB = p062l0.e.b();
        AbstractC0419l abstractC0419l = eVarB.f5781a;
        if (abstractC0419l != null) {
            abstractC0419l.endConnection();
        }
        eVarB.e.removeCallbacksAndMessages(null);
        eVarB.d = 0;
        eVarB.c = null;
        p051j0.a.d("GoogleBillingManager", "结束连接，清除所有重连任务");
    }

    public void onExplainClick(View view) {
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_ARTICLE_VIEW).withString("url", this.vipModel.getVipExplain()).withString("title", getString(p113u.g.text_433)).navigation();
    }

    public void onMemberBuyAlipayClick(View view) {
        this.llMemberBuyWechat.setBackground(null);
        this.llMemberBuyAlipay.setBackgroundResource(p113u.c.bg_rad_10_stroke_ffae00);
        this.payType = 1;
    }

    public void onMemberBuyPayClick(View view) {
        if (!this.isAgreementChecked) {
            p042h2.d.a(getString(p113u.g.text_511));
            return;
        }
        if (!E.n()) {
            p042h2.d.show(p113u.g.text_505);
            return;
        }
        if (this.payType == -1) {
            p042h2.d.a(getString(p113u.g.text_317));
            return;
        }
        w.e();
        p pVar = this.vipPayWorker;
        String vipPackageId = this.vipModel.getVipPackageId();
        pVar.d.vipPay(new VipPayPto(this.vipModel.getDiscountRate(), this.buyCount, this.payType, this.vipModel.getPrice(), vipPackageId)).b(new o(pVar, 0));
    }

    public void onMemberBuyWechatClick(View view) {
        this.llMemberBuyWechat.setBackgroundResource(p113u.c.bg_rad_10_stroke_ffae00);
        this.llMemberBuyAlipay.setBackground(null);
        this.payType = 2;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onWechatPayEvent(p016c2.a aVar) {
        throw null;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        this.vipModel = (VipModel) bundle.getSerializable("VipModel");
    }

    @Override // p037g0.n
    public void vipPayFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p037g0.n
    public void vipPaySuccess(VipPayDto vipPayDto) {
        w.c();
        VipPayDto.DataBean data = vipPayDto.getData();
        if (data.getAliPay() != null && !Hawk.get("appType").equals("sanduOverseas")) {
            data.getAliPay().getAlipay();
            new Object() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.3
                public void onPayCallback(int i5, p128w2.a aVar) {
                    if (i5 != 1) {
                        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PAY_RESULT).withInt("payStatus", 2).navigation();
                        return;
                    }
                    MemberBuyActivity.this.memberBuySuccessDialog = new MemberBuySuccessDialog(MemberBuyActivity.this.context);
                    MemberBuyActivity.this.memberBuySuccessDialog.f2619a = new x() { // from class: com.appdev.standard.page.mine.MemberBuyActivity.3.1
                        @Override // com.appdev.standard.dialog.x
                        public void onFinish() {
                            MemberBuyActivity.this.finish();
                        }
                    };
                    MemberBuyActivity.this.memberBuySuccessDialog.show();
                }
            };
            return;
        }
        if (data.getWxPay() != null && !Hawk.get("appType").equals("sanduOverseas")) {
            VipPayDto.DataBean.WxPayBean wxPay = data.getWxPay();
            wxPay.getAppid();
            wxPay.getPartnerid();
            wxPay.getPrepayid();
            wxPay.getNoncestr();
            wxPay.getTimestamp();
            wxPay.getSign();
            return;
        }
        if (data.getGooglePay() != null) {
            VipPayDto.DataBean.GooglePayBean googlePay = data.getGooglePay();
            this.googlePayBean = googlePay;
            Hawk.put(KEY_PENDING_GOOGLE_ORDER_ID, googlePay.getOutTradeNo());
            Hawk.put(KEY_PENDING_GOOGLE_PACKAGE_ID, this.googlePayBean.getVipPackageId());
            p051j0.a.d(this.TAG, "保存Google订单信息: " + this.googlePayBean.getOutTradeNo());
            p062l0.b bVar = this.billProxy;
            GoogleBillingListenerImpl googleBillingListenerImpl = this.billingListenerImpl;
            String[] strArr = {this.googlePayBean.getVipPackageId()};
            bVar.getClass();
            if (p062l0.e.b().c()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(C0441w0.newBuilder().setProductId(strArr[0]).setProductType("inapp").build());
                p062l0.e.b().f5781a.queryProductDetailsAsync(C0443x0.newBuilder().setProductList(arrayList).build(), new p062l0.a(bVar, googleBillingListenerImpl));
            }
        }
    }
}
