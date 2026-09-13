package com.appdev.standard.page.auth;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import com.library.base.frame.MvpActivity;
import java.util.HashMap;
import kotlin.jvm.internal.Y;
import p037g0.h;
import p037g0.i;
import p037g0.j;
import p042h2.d;
import p042h2.e;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PcLoginConfirmActivity extends MvpActivity implements h {
    public static final String EXTRA_QRCODE_CONTENT = "extra_qrcode_content";

    @BindView(4928)
    Button btnCancel;

    @BindView(4929)
    Button btnConfirm;
    private String qrcodeContent;
    private j scanQrVipWorker;

    public static void start(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) PcLoginConfirmActivity.class);
        intent.putExtra(EXTRA_QRCODE_CONTENT, str);
        context.startActivity(intent);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.qrcodeContent = getIntent().getStringExtra(EXTRA_QRCODE_CONTENT);
        this.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.auth.PcLoginConfirmActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!e.f4031a.g()) {
                    PcLoginConfirmActivity.this.finish();
                    return;
                }
                if (Y.f(PcLoginConfirmActivity.this.qrcodeContent)) {
                    PcLoginConfirmActivity.this.finish();
                    return;
                }
                HashMap map = new HashMap();
                map.put("qrcode", PcLoginConfirmActivity.this.qrcodeContent);
                w.e();
                j jVar = PcLoginConfirmActivity.this.scanQrVipWorker;
                jVar.d.scanQRCode(map).b(new i(jVar));
            }
        });
        this.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.auth.PcLoginConfirmActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PcLoginConfirmActivity.this.finish();
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        j jVar = new j(this);
        this.scanQrVipWorker = jVar;
        addPresenter(jVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_pc_login_confirm;
    }

    @Override // p037g0.h
    public void scanQRCodeFailed(int i5, String str) {
        w.c();
        if (!Y.f(str)) {
            d.a(str);
        }
        finish();
    }

    @Override // p037g0.h
    public void scanQRCodeSuccess() {
        w.c();
        finish();
    }
}
