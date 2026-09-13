package com.appdev.standard.page.auth;

import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.github.barteksc.pdfviewer.PDFView;
import com.library.base.frame.MvpActivity;
import p113u.e;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_AGREEMENT)
public class AgreementActivity extends MvpActivity {

    @BindView(5686)
    PDFView mPdfView;

    @BindView(6274)
    TextView tvTitle;

    @Autowired(name = "type")
    int type;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        int intExtra = getIntent().getIntExtra("type", getIntent().getIntExtra("agreement_type", 1));
        String currentLanguage = getCurrentLanguage();
        if (intExtra == 1) {
            this.tvTitle.setText(getString(g.user_agreement));
            if ("en".equals(currentLanguage)) {
                this.mPdfView.k("UserAgreement-en.pdf").a();
                return;
            } else {
                this.mPdfView.k("UserAgreement.pdf").a();
                return;
            }
        }
        if (intExtra == 2) {
            this.tvTitle.setText(getString(g.privacy_agreement));
            if ("en".equals(currentLanguage)) {
                this.mPdfView.k("PrivacyAgreement-en.pdf").a();
                return;
            } else {
                this.mPdfView.k("PrivacyAgreement.pdf").a();
                return;
            }
        }
        if (intExtra == 3) {
            this.tvTitle.setText(getString(g.text_510));
            this.mPdfView.k("en".equals(currentLanguage) ? "VipAgreement-en.pdf" : "VipAgreement.pdf").a();
        } else if (intExtra == 4) {
            this.tvTitle.setText(g.text_527);
            this.mPdfView.k("zh".equals(currentLanguage) ? "NetworkGuide.pdf" : "NetworkGuide-en.pdf").a();
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_agreement;
    }
}
