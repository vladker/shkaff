package com.appdev.standard.page.auth;

import M.b;
import M.g;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.BindView;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.google.GooglePlus;
import cn.sharesdk.twitter.Twitter;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.AuthorityApi;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.pto.ActivateDevicePto;
import com.appdev.standard.api.pto.LoginPto;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.dialog.SummaryTipDialog;
import com.appdev.standard.model.TextFontModel;
import com.appdev.standard.page.BootActivity;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.FrameApplication;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import p025e0.i;
import p025e0.k;
import p037g0.c;
import p037g0.d;
import p050j.w;
import p056k0.o;
import p113u.e;
import p113u.f;
import p134x2.E;
import p134x2.P0;
import p137y.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_LOGIN)
public class LoginActivity extends MvpActivity implements b, i, J.a {
    c activateDeviceWorker;

    @BindView(5894)
    ImageButton btnShowPassword;

    @BindView(5061)
    EditText etLoginPassword;

    @BindView(5062)
    EditText etLoginUsername;
    d getVipWorker;

    @BindView(5257)
    ImageView ivLoginAgreement;

    @BindView(5258)
    ImageView ivLoginLanguage;

    @BindView(5337)
    LinearLayout llAbroad;

    @BindView(5371)
    LinearLayout llDomestic;

    @BindView(5415)
    LinearLayout llLoginIndex;
    private J.b textFontWorker;

    @BindView(6159)
    TextView tvLoginAgreement;
    private k userInfoWorker;
    private g loginWorker = null;
    private boolean isPasswordVisible = false;
    private boolean isDeviceLogin = false;
    private boolean isAgreement = false;
    private boolean isDestroy = false;
    private String appType = null;

    private void activateVip() {
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            loginFinish();
            return;
        }
        String strG = p051j0.a.g(p0H);
        if (Y.f(strG) || "000000000000000000000000".equals(strG)) {
            loginFinish();
            return;
        }
        this.activateDeviceWorker.b = new p037g0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.11
            @Override // p037g0.a
            public void activateDeviceFailed(int i5, String str) {
                p042h2.d.a(p113u.g.text_522 + str);
                LoginActivity.this.loginFinish();
            }

            @Override // p037g0.a
            public void activateDeviceSuccess(int i5) {
                p051j0.a.c("VIP激活", "激活流程完成，结果码: " + i5);
                S4.d.b().f(new u(i5));
                LoginActivity.this.loginFinish();
            }
        };
        this.activateDeviceWorker.a(p0H.getDeviceName(), strG, p0H.getFactoryName(), false);
    }

    private void handleLogic(View view) {
        boolean z6;
        RadioButton radioButton = (RadioButton) view.findViewById(p113u.d.pop_language_select_zh);
        RadioButton radioButton2 = (RadioButton) view.findViewById(p113u.d.pop_language_select_en);
        RadioButton radioButton3 = (RadioButton) view.findViewById(p113u.d.pop_language_select_zh_TW);
        RadioButton radioButton4 = (RadioButton) view.findViewById(p113u.d.pop_language_select_fr);
        RadioButton radioButton5 = (RadioButton) view.findViewById(p113u.d.pop_language_select_ja);
        RadioButton radioButton6 = (RadioButton) view.findViewById(p113u.d.pop_language_select_de);
        RadioButton radioButton7 = (RadioButton) view.findViewById(p113u.d.pop_language_select_ko);
        RadioButton radioButton8 = (RadioButton) view.findViewById(p113u.d.pop_language_select_ru);
        RadioButton radioButton9 = (RadioButton) view.findViewById(p113u.d.pop_language_select_pt);
        RadioButton radioButton10 = (RadioButton) view.findViewById(p113u.d.pop_language_select_es);
        RadioButton radioButton11 = (RadioButton) view.findViewById(p113u.d.pop_language_select_vi);
        RadioButton radioButton12 = (RadioButton) view.findViewById(p113u.d.pop_language_select_it);
        RadioButton radioButton13 = (RadioButton) view.findViewById(p113u.d.pop_language_select_tr);
        String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        if (str.equals("zh")) {
            radioButton.setChecked(true);
            z6 = false;
        } else {
            z6 = false;
            radioButton.setChecked(false);
        }
        radioButton3.setChecked(z6);
        radioButton2.setChecked(z6);
        radioButton4.setChecked(z6);
        radioButton5.setChecked(z6);
        radioButton6.setChecked(z6);
        radioButton7.setChecked(z6);
        radioButton8.setChecked(z6);
        radioButton9.setChecked(z6);
        radioButton10.setChecked(z6);
        radioButton11.setChecked(z6);
        radioButton12.setChecked(z6);
        radioButton13.setChecked(z6);
        switch (str) {
            case "zh-rTW":
            case "zh_TW":
                radioButton3.setChecked(true);
                break;
            case "de":
                radioButton6.setChecked(true);
                break;
            case "en":
                radioButton2.setChecked(true);
                break;
            case "es":
                radioButton10.setChecked(true);
                break;
            case "fr":
                radioButton4.setChecked(true);
                break;
            case "it":
                radioButton12.setChecked(true);
                break;
            case "ja":
                radioButton5.setChecked(true);
                break;
            case "ko":
                radioButton7.setChecked(true);
                break;
            case "pt":
                radioButton9.setChecked(true);
                break;
            case "ru":
                radioButton8.setChecked(true);
                break;
            case "tr":
                radioButton13.setChecked(true);
                break;
            case "vi":
                radioButton11.setChecked(true);
                break;
        }
        final int i5 = 0;
        radioButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i5) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i6 = 7;
        radioButton3.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i6) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i7 = 8;
        radioButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i7) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i8 = 9;
        radioButton4.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i8) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i9 = 10;
        radioButton5.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i9) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i10 = 11;
        radioButton6.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i10) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i11 = 12;
        radioButton7.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i11) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i12 = 1;
        radioButton8.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i12) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i13 = 2;
        radioButton9.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i13) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i14 = 3;
        radioButton10.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i14) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i15 = 4;
        radioButton11.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i15) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i16 = 5;
        radioButton12.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i16) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
        final int i17 = 6;
        radioButton13.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.auth.a
            public final /* synthetic */ LoginActivity b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i17) {
                    case 0:
                        this.b.lambda$handleLogic$0(view2);
                        break;
                    case 1:
                        this.b.lambda$handleLogic$7(view2);
                        break;
                    case 2:
                        this.b.lambda$handleLogic$8(view2);
                        break;
                    case 3:
                        this.b.lambda$handleLogic$9(view2);
                        break;
                    case 4:
                        this.b.lambda$handleLogic$10(view2);
                        break;
                    case 5:
                        this.b.lambda$handleLogic$11(view2);
                        break;
                    case 6:
                        this.b.lambda$handleLogic$12(view2);
                        break;
                    case 7:
                        this.b.lambda$handleLogic$1(view2);
                        break;
                    case 8:
                        this.b.lambda$handleLogic$2(view2);
                        break;
                    case 9:
                        this.b.lambda$handleLogic$3(view2);
                        break;
                    case 10:
                        this.b.lambda$handleLogic$4(view2);
                        break;
                    case 11:
                        this.b.lambda$handleLogic$5(view2);
                        break;
                    default:
                        this.b.lambda$handleLogic$6(view2);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$0(View view) {
        Hawk.put("current_language", "zh");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$1(View view) {
        Hawk.put("current_language", "zh_TW");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$10(View view) {
        Hawk.put("current_language", "vi");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$11(View view) {
        Hawk.put("current_language", "it");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$12(View view) {
        Hawk.put("current_language", "tr");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$2(View view) {
        Hawk.put("current_language", "en");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$3(View view) {
        Hawk.put("current_language", "fr");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$4(View view) {
        Hawk.put("current_language", "ja");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$5(View view) {
        Hawk.put("current_language", "de");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$6(View view) {
        Hawk.put("current_language", "ko");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$7(View view) {
        Hawk.put("current_language", "ru");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$8(View view) {
        Hawk.put("current_language", "pt");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLogic$9(View view) {
        Hawk.put("current_language", "es");
        V1.b.h().getClass();
        V1.b.f();
        gotoActivity(BootActivity.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginFinish() {
        w.c();
        this.textFontWorker.a();
        this.userInfoWorker.a();
        V1.b.h().getClass();
        V1.b.f();
        Hawk.put("last_login_username", this.etLoginUsername.getText().toString().trim());
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_MAIN).navigation();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        registerEventBus();
        super.initComponent();
        String str = (String) Hawk.get("appType");
        this.appType = str;
        if (str.equals("sanduOverseas")) {
            this.llDomestic.setVisibility(8);
            this.llAbroad.setVisibility(0);
        } else {
            this.llDomestic.setVisibility(0);
            this.llAbroad.setVisibility(8);
        }
        EditText editText = this.etLoginUsername;
        editText.setText((CharSequence) Hawk.get("last_login_username", editText.getText().toString().trim()));
        if (((String) Hawk.get("current_language", FrameApplication.defaultLang)).equals("zh")) {
            this.ivLoginLanguage.setImageResource(f.standard_ic_common_setting_language_zh);
        } else {
            this.ivLoginLanguage.setImageResource(f.standard_ic_common_setting_language_en);
        }
        o oVar = new o() { // from class: com.appdev.standard.page.auth.LoginActivity.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                LoginActivity.this.onAgreementClick(null);
            }
        };
        o oVar2 = new o() { // from class: com.appdev.standard.page.auth.LoginActivity.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 1).navigation();
            }
        };
        o oVar3 = new o() { // from class: com.appdev.standard.page.auth.LoginActivity.3
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 2).navigation();
            }
        };
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#FF9B7C"));
        String string = getString(p113u.g.text_30);
        String string2 = getString(p113u.g.summary_content_2_2);
        String string3 = getString(p113u.g.summary_content_2_3);
        String string4 = getString(p113u.g.summary_content_2_4);
        String string5 = getString(p113u.g.text_32);
        String str2 = string + string2 + string3 + string4 + string5;
        SpannableString spannableString = new SpannableString(str2);
        int iIndexOf = str2.indexOf(string);
        int length = string.length() + iIndexOf;
        int iIndexOf2 = str2.indexOf(string3);
        int length2 = string3.length() + iIndexOf2;
        int iIndexOf3 = str2.indexOf(string5);
        int length3 = string5.length() + iIndexOf3;
        int iIndexOf4 = str2.indexOf(string2);
        int length4 = string2.length() + iIndexOf4;
        int iIndexOf5 = str2.indexOf(string4);
        int length5 = string4.length() + iIndexOf5;
        spannableString.setSpan(oVar, iIndexOf, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf, length, 33);
        spannableString.setSpan(oVar2, iIndexOf4, length4, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf4, length4, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf2, length2, 33);
        spannableString.setSpan(oVar3, iIndexOf5, length5, 33);
        spannableString.setSpan(foregroundColorSpan, iIndexOf5, length5, 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), iIndexOf3, length3, 33);
        this.tvLoginAgreement.setText(spannableString);
        this.tvLoginAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvLoginAgreement.setHighlightColor(0);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        g gVar = new g(this);
        gVar.d = null;
        gVar.d = (AuthorityApi) Http.createApi(AuthorityApi.class);
        this.loginWorker = gVar;
        addPresenter(gVar);
        k kVar = new k(this);
        this.userInfoWorker = kVar;
        addPresenter(kVar);
        J.b bVar = new J.b(this);
        this.textFontWorker = bVar;
        addPresenter(bVar);
        d dVar = new d(this);
        dVar.d = (MineApi) Http.createApi(MineApi.class);
        this.getVipWorker = dVar;
        this.activateDeviceWorker = new c(this);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_login;
    }

    @Override // M.b
    public void loginFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // M.b
    public void loginSuccess() {
        if (this.isDeviceLogin) {
            activateVip();
        } else {
            loginFinish();
        }
    }

    public void onAgreementClick(View view) {
        boolean z6 = this.isAgreement;
        this.isAgreement = !z6;
        if (z6) {
            this.ivLoginAgreement.setImageResource(f.standard_ic_common_radio_select_not);
        } else {
            this.ivLoginAgreement.setImageResource(f.standard_ic_common_radio_select);
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.isDestroy = true;
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onDeviceEvent(p137y.i iVar) {
        if (this.isDeviceLogin && iVar.f9014a == 6) {
            onMachineLogin(null);
        }
    }

    public void onFacebookLoginClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.10
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        w.e();
        this.isDeviceLogin = false;
        g gVar = this.loginWorker;
        if (!this.isAgreement) {
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
                return;
            }
            return;
        }
        gVar.getClass();
        Platform platform = ShareSDK.getPlatform(Facebook.NAME);
        platform.removeAccount(true);
        platform.setPlatformActionListener(new M.f(gVar, 1));
        platform.showUser(null);
    }

    public void onForgetPasswordClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_RESETPASSWORD);
    }

    public void onGoogleLoginClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.8
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        w.e();
        this.isDeviceLogin = false;
        g gVar = this.loginWorker;
        if (this.isAgreement) {
            gVar.getClass();
            Platform platform = ShareSDK.getPlatform(GooglePlus.NAME);
            platform.isClientValid(new M.e(gVar, platform, 1));
        } else {
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
            }
        }
    }

    public void onLoginClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.4
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        w.e();
        this.isDeviceLogin = false;
        g gVar = this.loginWorker;
        String strF = androidx.exifinterface.media.a.f(this.etLoginUsername);
        String strF2 = androidx.exifinterface.media.a.f(this.etLoginPassword);
        boolean z6 = this.isAgreement;
        if (Y.f(strF)) {
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginFailed(1, gVar.getString(p113u.g.Please_enter_your_account_number));
                return;
            }
            return;
        }
        if (Y.f(strF2)) {
            Object obj2 = gVar.b;
            if (obj2 != null) {
                ((b) obj2).loginFailed(1, gVar.getString(p113u.g.Please_enter_your_password));
                return;
            }
            return;
        }
        if (z6) {
            gVar.getClass();
            gVar.d.doLogin(new LoginPto(strF, p051j0.i.b(strF2))).b(new M.c(gVar, strF));
        } else {
            Object obj3 = gVar.b;
            if (obj3 != null) {
                ((b) obj3).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
            }
        }
    }

    public void onMachineLogin(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.5
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        if (!E.n()) {
            needBlueToothPermission(new PermissionTipDialog(this, getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.auth.LoginActivity.6
                @Override // p026e2.a
                public void onRequestPermissionFail() {
                    p051j0.a.l();
                }

                @Override // p026e2.a
                public void onRequestPermissionSuccess() {
                    p051j0.a.m();
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isDeviceLogin", true);
                    LoginActivity.this.isDeviceLogin = true;
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).with(bundle).navigation();
                }
            });
            return;
        }
        w.e();
        this.isDeviceLogin = true;
        g gVar = this.loginWorker;
        if (!this.isAgreement) {
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
                return;
            }
            return;
        }
        gVar.getClass();
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            return;
        }
        gVar.d.fastLoginQR(new ActivateDevicePto(p0H.getDeviceName(), p0H.getUid(), p0H.getFactoryName())).b(new A.c(gVar, 16));
    }

    public void onRegisterClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_REGISTER);
    }

    public void onSettingClick(View view) {
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("language").arguments(new HashMap()).requestCode(0).build());
    }

    public void onShowPassword(View view) {
        if (this.isPasswordVisible) {
            this.etLoginPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(f.ic_show_passwd);
        } else {
            this.etLoginPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(f.ic_hide_passwd);
        }
        this.isPasswordVisible = !this.isPasswordVisible;
        EditText editText = this.etLoginPassword;
        editText.setSelection(editText.getText().length());
    }

    public void onTwitterLoginClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.9
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        w.e();
        this.isDeviceLogin = false;
        g gVar = this.loginWorker;
        if (this.isAgreement) {
            gVar.getClass();
            Platform platform = ShareSDK.getPlatform(Twitter.NAME);
            platform.setPlatformActionListener(new M.f(gVar, 0));
            platform.showUser(null);
            return;
        }
        Object obj = gVar.b;
        if (obj != null) {
            ((b) obj).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
        }
    }

    public void onWechatLoginClick(View view) {
        if (!this.isAgreement) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.auth.LoginActivity.7
                @Override // p041h0.a
                public void onConfirm() {
                    LoginActivity.this.onAgreementClick(null);
                }

                @Override // p041h0.a
                public void onCancel() {
                }
            };
            summaryTipDialog.show();
            return;
        }
        w.e();
        this.isDeviceLogin = false;
        g gVar = this.loginWorker;
        if (!this.isAgreement) {
            Object obj = gVar.b;
            if (obj != null) {
                ((b) obj).loginFailed(1, gVar.getString(p113u.g.error_is_select_agreement));
                return;
            }
            return;
        }
        gVar.getClass();
        Platform platform = ShareSDK.getPlatform(Wechat.NAME);
        if (platform != null) {
            platform.removeAccount(true);
            platform.isClientValid(new M.e(gVar, platform, 0));
        } else {
            Object obj2 = gVar.b;
            if (obj2 != null) {
                ((b) obj2).loginFailed(2, gVar.getString(p113u.g.no_wechat_app));
            }
        }
    }

    @Override // M.b
    public void userNotExist(String str) {
        w.c();
        Bundle bundle = new Bundle();
        bundle.putString("account", str);
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_REGISTER).with(bundle).navigation();
        p042h2.d.a(getString(p113u.g.Please_register_first));
    }

    @Override // p025e0.i
    public void getUserInfoSuccess() {
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
    }

    @Override // p025e0.i
    public void getUserInfoFailed(int i5, String str) {
    }
}
