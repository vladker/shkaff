package com.appdev.standard.page;

import E.e;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.dialog.SummaryTipDialog;
import com.appdev.standard.model.DictModel;
import com.appdev.standard.model.TextFontModel;
import com.library.base.frame.FrameApplication;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import java.util.List;
import p051j0.i;
import p113u.f;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_BOOT)
public class BootActivity extends MvpActivity implements E.c, J.a {
    private e bqIndustryDictWorker;

    @BindView(5205)
    ImageView ivBootContent;
    private J.b textFontWorker;
    private final int BOOT_INTERVAL = 3000;
    private long startTime = -1;

    private boolean isAgreeSummary() {
        return ((Boolean) Hawk.get("isAgreeSummary", Boolean.TRUE)).booleanValue();
    }

    private boolean isFirstStart() {
        boolean zBooleanValue = ((Boolean) Hawk.get("isFirstStart", Boolean.TRUE)).booleanValue();
        Hawk.put("isFirstStart", Boolean.FALSE);
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void redirection(boolean z6) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.startTime;
        if (jCurrentTimeMillis > 3000) {
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_MAIN).navigation();
            finishActivity();
        } else {
            new Handler(getMainLooper()).postDelayed(new Runnable() { // from class: com.appdev.standard.page.BootActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MAIN);
                    BootActivity.this.finishActivity();
                }
            }, 3000 - jCurrentTimeMillis);
        }
    }

    @Override // E.c
    public void getBqDictSuccess(List<DictModel> list) {
        Hawk.put("industry_dict_data", list);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        i.f5400a = getString(g.text_329);
        e eVar = new e(this);
        this.bqIndustryDictWorker = eVar;
        addPresenter(eVar);
        J.b bVar = new J.b(this);
        this.textFontWorker = bVar;
        addPresenter(bVar);
        String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        str.getClass();
        switch (str) {
            case "de":
                Http.addHeader("lang", "de");
                break;
            case "en":
                Http.addHeader("lang", "en_US");
                break;
            case "es":
                Http.addHeader("lang", "es");
                break;
            case "fr":
                Http.addHeader("lang", "fr");
                break;
            case "it":
                Http.addHeader("lang", "it");
                break;
            case "ja":
                Http.addHeader("lang", "ja");
                break;
            case "ko":
                Http.addHeader("lang", "ko");
                break;
            case "pt":
                Http.addHeader("lang", "pt");
                break;
            case "ru":
                Http.addHeader("lang", "ru");
                break;
            case "tr":
                Http.addHeader("lang", "tr");
                break;
            case "vi":
                Http.addHeader("lang", "vi");
                break;
            case "zh":
                Http.addHeader("lang", "zh_CN");
                break;
            case "zh_TW":
                Http.addHeader("lang", "zh_HK");
                break;
            default:
                Http.addHeader("lang", "en");
                break;
        }
        if (str.equals("zh") || str.equals("zh_TW")) {
            this.ivBootContent.setImageResource(f.standard_ic_common_logo_text_zh);
        } else {
            Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), f.standard_ic_common_logo_text_en);
            int width = bitmapDecodeResource.getWidth();
            int height = bitmapDecodeResource.getHeight();
            ViewGroup.LayoutParams layoutParams = this.ivBootContent.getLayoutParams();
            layoutParams.width = (int) (((double) width) * 1.35d);
            layoutParams.height = (int) (((double) height) * 1.35d);
            this.ivBootContent.setLayoutParams(layoutParams);
            this.ivBootContent.setImageBitmap(bitmapDecodeResource);
            this.ivBootContent.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.ivBootContent.setScaleX(1.35f);
            this.ivBootContent.setScaleY(1.35f);
        }
        this.bqIndustryDictWorker.a();
        this.textFontWorker.a();
        if (isAgreeSummary()) {
            SummaryTipDialog summaryTipDialog = new SummaryTipDialog(this);
            summaryTipDialog.f2631a = new p041h0.a() { // from class: com.appdev.standard.page.BootActivity.1
                @Override // p041h0.a
                public void onCancel() {
                    BootActivity.this.finishActivity();
                }

                @Override // p041h0.a
                public void onConfirm() {
                    Hawk.put("isAgreeSummary", Boolean.FALSE);
                    BootActivity.this.startTime = System.currentTimeMillis();
                    BootActivity.this.redirection(p042h2.e.f4031a.g());
                    MobSDK.submitPolicyGrantResult(true);
                    p116u2.a.initStat(BootActivity.this);
                }
            };
            summaryTipDialog.show();
        } else {
            this.startTime = System.currentTimeMillis();
            redirection(p042h2.e.f4031a.g());
            MobSDK.submitPolicyGrantResult(true);
            p116u2.a.initStat(this);
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        p042h2.d.b = this;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_boot;
    }

    @Override // J.a
    public void getAppFontLibSuccess(List<TextFontModel> list) {
    }

    @Override // J.a
    public void getAppFontLibFailed(int i5, String str) {
    }

    @Override // E.c
    public void getBqDictFailed(int i5, String str) {
    }
}
