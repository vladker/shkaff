package com.appdev.standard.page;

import A3.AbstractC0157z;
import I0.h;
import S4.k;
import T.e;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MainApi;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.pto.AppPrintDataAddBody;
import com.appdev.standard.api.pto.EditRecordNamePto;
import com.appdev.standard.api.pto.GooglePayPto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.I;
import com.appdev.standard.dialog.ShareLabelDialog;
import com.appdev.standard.model.MineLabelModel;
import com.appdev.standard.model.SharedViewModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.document.DocumentFragment;
import com.appdev.standard.page.index.IndexFragment;
import com.appdev.standard.page.mine.MineFragment;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.appdev.standard.page.scene.SceneFragment;
import com.appdev.standard.widget.BottomTabWidget;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Y;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.videoio.Videoio;
import p050j.w;
import p051j0.f;
import p056k0.i;
import p102s.G;
import p113u.g;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;
import p137y.s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MAIN)
public class MainActivity extends MvpActivity implements p003a0.a, T.d, T.a, p020d0.c {
    private p003a0.c bqSharedWorker;
    private ClipboardManager clipboardManager;
    private Context context;

    @BindView(5107)
    FrameLayout flTemplatePageView;

    @BindView(4939)
    BottomTabWidget mBtwIndex;

    @BindView(5099)
    FrameLayout mFlIndex;
    private Fragment[] fragments = null;
    private long lastTimePressed = -1;
    private long latestConnectSuccessTime = -1;
    private e printPersonalBiaoqianWorker = null;
    private T.c printDataAddWorker = null;
    private p020d0.e editRecordNameWorker = null;
    public i mediaPicker = new i();

    /* JADX INFO: renamed from: com.appdev.standard.page.MainActivity$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ s val$event;

        /* JADX INFO: renamed from: com.appdev.standard.page.MainActivity$3$3, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class RunnableC00443 implements Runnable {
            final /* synthetic */ TemplateConfigBean val$templateConfig;
            final /* synthetic */ String val$templateContent;

            public RunnableC00443(TemplateConfigBean templateConfigBean, String str) {
                this.val$templateConfig = templateConfigBean;
                this.val$templateContent = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                final TemplatePageView templatePageView = (TemplatePageView) LayoutInflater.from(MainActivity.this.context).inflate(p113u.e.main_template_page_view, (ViewGroup) null);
                MainActivity.this.flTemplatePageView.addView(templatePageView);
                TemplateConfigBean templateConfigBean = this.val$templateConfig;
                if (templateConfigBean != null) {
                    templatePageView.setLabelSize(templateConfigBean.getWidth(), this.val$templateConfig.getHeight());
                    templatePageView.setPrinterLabelBgUrl(this.val$templateConfig.getPrinterLabelBgUrl());
                    templatePageView.setPrinterLabelBgBorderUrl(this.val$templateConfig.getPrinterLabelBorderUrl());
                    templatePageView.setPaperType(this.val$templateConfig.getPaperType());
                    if (!Y.f(this.val$templateContent)) {
                        templatePageView.setWantCreateElementsByString(this.val$templateContent);
                    }
                }
                templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.MainActivity.3.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        templatePageView.load();
                        templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.MainActivity.3.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (!templatePageView.isRenderingCompleted()) {
                                    p051j0.a.d(((BaseActivity) MainActivity.this).TAG, "渲染未完成");
                                    templatePageView.postDelayed(this, 1000L);
                                    return;
                                }
                                p051j0.a.d(((BaseActivity) MainActivity.this).TAG, "渲染完成");
                                w.f(MainActivity.this.getString(g.text_263));
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                MainActivity.this.startPrintLabel(anonymousClass3.val$event, templatePageView);
                            }
                        }, 1000L);
                    }
                }, 1000L);
            }
        }

        public AnonymousClass3(s sVar) {
            this.val$event = sVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            s sVar = this.val$event;
            if (sVar.d != 1) {
                MainActivity.this.startPrintLabel(sVar, null);
                return;
            }
            TemplateConfigBean templateConfigBean = sVar.f9022a;
            String strE = p052j2.c.e(sVar.c);
            List<String> fontList = DataCreateUtil.getFontList(this.val$event.c);
            p051j0.a.d(((BaseActivity) MainActivity.this).TAG, "字体列表=" + Arrays.toString(fontList.toArray()));
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.MainActivity.3.1
                @Override // java.lang.Runnable
                public void run() {
                    w.f(MainActivity.this.getString(g.text_263));
                }
            });
            if (DataCreateUtil.downloadFont(fontList)) {
                MainActivity.this.runOnUiThread(new RunnableC00443(templateConfigBean, strE));
            } else {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.MainActivity.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        w.c();
                        p042h2.d.show(g.toast_12);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.MainActivity$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ String val$coverUrl;
        final /* synthetic */ int val$dataSource;
        final /* synthetic */ int val$direction;
        final /* synthetic */ s val$event;
        final /* synthetic */ int val$printCount;
        final /* synthetic */ P0 val$printInfo;
        final /* synthetic */ String val$shareLink;
        final /* synthetic */ TemplateConfigBean val$templateConfig;
        final /* synthetic */ TemplatePageView val$templatePageView;
        final /* synthetic */ String val$title;

        public AnonymousClass4(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, int i6, s sVar, String str, String str2, int i7, String str3) {
            this.val$printInfo = p1;
            this.val$templatePageView = templatePageView;
            this.val$templateConfig = templateConfigBean;
            this.val$direction = i5;
            this.val$printCount = i6;
            this.val$event = sVar;
            this.val$title = str;
            this.val$coverUrl = str2;
            this.val$dataSource = i7;
            this.val$shareLink = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            w.c();
            p042h2.d.show(g.toast_5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$run$1(s sVar, String str, TemplateConfigBean templateConfigBean, String str2, int i5, int i6, String str3) {
            w.c();
            p042h2.d.show(g.toast_2);
            String str4 = sVar.f9026i;
            if (!Y.f(str4) && !AbstractC1127c.NULL.equals(str4)) {
                MainActivity.this.editRecordNameWorker.a(new EditRecordNamePto(str4, str));
            } else if (templateConfigBean != null && !Y.f(templateConfigBean.getTemplateId())) {
                MainActivity.this.printPersonalBiaoqianWorker.a(templateConfigBean.getTemplateId());
            }
            T.c cVar = MainActivity.this.printDataAddWorker;
            int height = templateConfigBean.getHeight();
            int paperType = ((p051j0.a.h() == null || Y.f(p051j0.a.h().getPaperType())) ? templateConfigBean.getPaperType() : Integer.parseInt(p051j0.a.h().getPaperType())) + 1;
            if (Y.f(str)) {
                str = templateConfigBean.getName();
            }
            cVar.d.printDataAdd(new AppPrintDataAddBody(str2, i5, height, paperType, i6, str3, str, templateConfigBean.getWidth())).b(new T.b(cVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2() {
            w.c();
            p042h2.d.show(g.toast_5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$3(final s sVar, final String str, final TemplateConfigBean templateConfigBean, final String str2, final int i5, final int i6, final String str3, byte[] bArr) {
            if (bArr.length == 0) {
                w.c();
                p042h2.d.show(g.toast_7);
                return;
            }
            K0 printer = f.getPrinter();
            if (printer == null) {
                MainActivity.this.runOnUiThread(new a(0));
            } else if (printer.sendSync(bArr, null).b()) {
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2675a.lambda$run$1(sVar, str, templateConfigBean, str2, i5, i6, str3);
                    }
                });
            } else {
                MainActivity.this.runOnUiThread(new a(1));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            P0 p1 = this.val$printInfo;
            TemplatePageView templatePageView = this.val$templatePageView;
            final TemplateConfigBean templateConfigBean = this.val$templateConfig;
            int i5 = this.val$direction;
            final int i6 = this.val$printCount;
            final s sVar = this.val$event;
            final String str = this.val$title;
            final String str2 = this.val$coverUrl;
            final int i7 = this.val$dataSource;
            final String str3 = this.val$shareLink;
            DataCreateUtil.create(p1, templatePageView, templateConfigBean, i5, false, i6, new DataCreateUtil.CreateBitmapEventListener() { // from class: com.appdev.standard.page.c
                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.CreateBitmapEventListener
                public final void onComplete(byte[] bArr) {
                    this.f2687a.lambda$run$3(sVar, str, templateConfigBean, str2, i7, i6, str3, bArr);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.MainActivity$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ String val$coverUrl;
        final /* synthetic */ int val$dataSource;
        final /* synthetic */ s val$event;
        final /* synthetic */ int val$printCount;
        final /* synthetic */ P0 val$printInfo;
        final /* synthetic */ String val$shareLink;
        final /* synthetic */ String val$title;

        public AnonymousClass5(s sVar, P0 p1, int i5, String str, int i6, String str2, String str3) {
            this.val$event = sVar;
            this.val$printInfo = p1;
            this.val$printCount = i5;
            this.val$coverUrl = str;
            this.val$dataSource = i6;
            this.val$shareLink = str2;
            this.val$title = str3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            w.c();
            p042h2.d.show(g.toast_5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$run$1(String str, int i5, Bitmap bitmap, int i6, String str2, String str3) {
            w.c();
            p042h2.d.show(g.toast_2);
            T.c cVar = MainActivity.this.printDataAddWorker;
            cVar.d.printDataAdd(new AppPrintDataAddBody(str, i5, bitmap.getHeight(), ((p051j0.a.h() == null || Y.f(p051j0.a.h().getPaperType())) ? 0 : Integer.parseInt(p051j0.a.h().getPaperType())) + 1, i6, str2, str3, bitmap.getWidth())).b(new T.b(cVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2() {
            w.c();
            p042h2.d.show(g.toast_5);
        }

        @Override // java.lang.Runnable
        public void run() {
            final Bitmap bitmapFromUrl = MainActivity.this.getBitmapFromUrl(this.val$event.e);
            if (bitmapFromUrl == null) {
                w.c();
                p042h2.d.show(g.toast_7);
                return;
            }
            boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
            K0 printer = f.getPrinter();
            if (printer == null) {
                MainActivity.this.runOnUiThread(new a(2));
                return;
            }
            if (!(this.val$printInfo.getCmdMode().equals("01") ? printer.printESCBitmapSync(bitmapFromUrl, zBooleanValue, this.val$printCount, null) : printer.printTSCBitmapSync(bitmapFromUrl, zBooleanValue, this.val$printCount, this.val$printInfo.getSpeedLev(), this.val$printInfo.e, null)).b()) {
                MainActivity.this.runOnUiThread(new a(3));
                return;
            }
            MainActivity mainActivity = MainActivity.this;
            final String str = this.val$coverUrl;
            final int i5 = this.val$dataSource;
            final int i6 = this.val$printCount;
            final String str2 = this.val$shareLink;
            final String str3 = this.val$title;
            mainActivity.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2691a.lambda$run$1(str, i5, bitmapFromUrl, i6, str2, str3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmapFromUrl(String str) {
        try {
            return (Bitmap) ((h) com.bumptech.glide.c.with(this.context).asBitmap().load(str).submit()).get();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(SharedViewModel sharedViewModel, int i5) {
        sharedViewModel.setCurrentTab(i5);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : this.fragments) {
            if (fragment != null && fragment.isAdded()) {
                fragmentTransactionBeginTransaction.hide(fragment);
            }
        }
        Fragment fragment2 = this.fragments[i5];
        if (fragment2.isAdded()) {
            fragmentTransactionBeginTransaction.show(fragment2);
        } else {
            fragmentTransactionBeginTransaction.add(p113u.d.fl_index, fragment2, fragment2.getClass().getName());
        }
        fragmentTransactionBeginTransaction.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPrintLabel(s sVar, TemplatePageView templatePageView) {
        int i5 = sVar.b;
        P0 p0H = p051j0.a.h();
        int i6 = sVar.f9023f;
        String str = sVar.f9024g;
        String str2 = sVar.f9025h;
        if (sVar.d != 1) {
            if (p0H == null || !("01".equals(p0H.getCmdMode()) || "02".equals(p0H.getCmdMode()))) {
                w.c();
                p042h2.d.show(g.toast_13);
                return;
            } else {
                w.f(getString(g.text_263));
                runOnNewThread(new AnonymousClass5(sVar, p0H, i5, str, i6, null, str2));
                return;
            }
        }
        TemplateConfigBean templateConfigBean = sVar.f9022a;
        C1849c.getScale();
        if (p0H == null || !("01".equals(p0H.getCmdMode()) || "02".equals(p0H.getCmdMode()))) {
            w.c();
            p042h2.d.show(g.toast_13);
        } else {
            w.f(getString(g.text_263));
            runOnNewThread(new AnonymousClass4(p0H, templatePageView, templateConfigBean, 0, i5, sVar, str2, str, i6, null));
        }
    }

    @Override // p003a0.a
    public void getBqSharedSuccess(final MineLabelModel mineLabelModel) {
        this.clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
        ShareLabelDialog shareLabelDialog = new ShareLabelDialog(this);
        shareLabelDialog.a(mineLabelModel.getCoverUrl());
        shareLabelDialog.f2630a = new I() { // from class: com.appdev.standard.page.MainActivity.2
            @Override // com.appdev.standard.dialog.I
            public void onEdit() {
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, mineLabelModel.getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(mineLabelModel.getTitle(), mineLabelModel.getWidth(), mineLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), String.valueOf(mineLabelModel.getId()), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data_template_config", templateConfigBean);
                bundle.putString("data_template_content", p052j2.c.e(templatePto.getViews()));
                bundle.putInt("data_print_data_source", 5);
                bundle.putString("data_print_cover_url", mineLabelModel.getCoverUrl());
                bundle.putString("data_print_title", mineLabelModel.getTitle());
                bundle.putString("data_print_share_link", String.valueOf(mineLabelModel.getId()));
                bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
            }
        };
        shareLabelDialog.show();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        registerEventBus();
        super.initComponent();
        this.mediaPicker.attachToActivity(this);
        this.context = this;
        e eVar = new e(this);
        this.printPersonalBiaoqianWorker = eVar;
        addPresenter(eVar);
        T.c cVar = new T.c(this);
        this.printDataAddWorker = cVar;
        addPresenter(cVar);
        p020d0.e eVar2 = new p020d0.e(this);
        this.editRecordNameWorker = eVar2;
        addPresenter(eVar2);
        p003a0.c cVar2 = new p003a0.c(this);
        cVar2.d = (MainApi) Http.createApi(MainApi.class);
        this.bqSharedWorker = cVar2;
        addPresenter(cVar2);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsAppearance(8, 8);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9472);
        }
        G.Companion.init(this);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        this.fragments = new Fragment[]{new IndexFragment(), new DocumentFragment(), new SceneFragment(), new MineFragment()};
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.mBtwIndex.setOnTabClickListener(new F4.f(this, (SharedViewModel) new ViewModelProvider(this).get(SharedViewModel.class), 5));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_main;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        G.Companion.onActivityResult(i5, i6, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (System.currentTimeMillis() - this.lastTimePressed < 1000) {
            finish();
        } else {
            this.lastTimePressed = System.currentTimeMillis();
            p042h2.d.a(getString(g.Click_again_to_exit_the_application));
        }
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(null);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onPrintLabelEvent(s sVar) {
        w.f(getString(g.text_263));
        this.flTemplatePageView.removeAllViews();
        runOnNewThread(new AnonymousClass3(sVar));
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (((String) Hawk.get("appType", "")).equals("sanduOverseas")) {
            if (Y.f5691a) {
                p051j0.a.d("GooglePaymentRecovery", "正在处理中，跳过");
            } else {
                String str = (String) Hawk.get("PENDING_GOOGLE_ORDER_ID", "");
                String str2 = (String) Hawk.get("PENDING_PURCHASE_TOKEN", "");
                StringBuilder sbY = AbstractC0157z.y("检查未完成订单 - OrderId: ", str, ", hasToken: ");
                sbY.append(!str2.isEmpty());
                p051j0.a.d("GooglePaymentRecovery", sbY.toString());
                if (str.isEmpty() || str2.isEmpty()) {
                    p051j0.a.d("GooglePaymentRecovery", "没有未完成的订单");
                } else {
                    p051j0.a.d("GooglePaymentRecovery", "发现未完成的Google支付订单，自动上报到服务器");
                    Y.f5691a = true;
                    MineApi mineApi = (MineApi) Http.createApi(MineApi.class);
                    p051j0.a.d("GooglePaymentRecovery", "提交验证 - orderId: " + str + ", purchaseToken: " + str2);
                    mineApi.googlePay(new GooglePayPto(str, str2, getPackageName())).b(new p062l0.f());
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.appdev.standard.page.MainActivity.1
            @Override // java.lang.Runnable
            public void run() {
                byte b;
                String str3;
                if (MainActivity.this.clipboardManager == null) {
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.clipboardManager = (ClipboardManager) mainActivity.getSystemService("clipboard");
                }
                ClipData primaryClip = MainActivity.this.clipboardManager.getPrimaryClip();
                if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                    p051j0.a.k(((BaseActivity) MainActivity.this).TAG, "剪切板无内容或获取失败");
                    return;
                }
                int i5 = 0;
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                if (itemAt == null || itemAt.getText() == null) {
                    return;
                }
                String string = itemAt.getText().toString();
                p051j0.a.c(((BaseActivity) MainActivity.this).TAG, "剪切板内容: " + string);
                Pattern patternCompile = Pattern.compile("\\*\\[(.*?)]\\*");
                HashMap<String, String[]> map = new HashMap<String, String[]>() { // from class: com.appdev.standard.page.MainActivity.1.1
                    {
                        put("zh", new String[]{"云口令", "口令"});
                        put("en", new String[]{"Cloud Password", "Password"});
                        put("fr", new String[]{"Mot de passe cloud", "Mot de passe"});
                        put("zh_TW", new String[]{"雲口令", "口令"});
                        put("ja", new String[]{"クラウドパスワード", "パスワード"});
                        put("de", new String[]{"Cloud-Passwort", "Passwort"});
                        put("ko", new String[]{"클라우드 비밀번호", "비밀번호"});
                        put("ru", new String[]{"Облачный пароль", "Пароль"});
                        put("pt", new String[]{"Senha cloud", "Senha"});
                        put("es", new String[]{"Contraseña cloud", "Contraseña"});
                        put("vi", new String[]{"Mật khẩu đám mây", "Mật khẩu"});
                        put("it", new String[]{"Password cloud", "Password"});
                        put("tr", new String[]{"Bulut şifre", "Şifre"});
                    }
                };
                String string2 = Locale.getDefault().toString();
                p051j0.a.c(((BaseActivity) MainActivity.this).TAG, "当前语言: " + string2);
                String[] strArr = map.containsKey(string2) ? map.get(string2) : map.get("en");
                while (true) {
                    b = -1;
                    str3 = null;
                    try {
                        if (i5 >= strArr.length) {
                            break;
                        }
                        if (string.startsWith(strArr[i5])) {
                            Matcher matcher = patternCompile.matcher(string);
                            if (matcher.find()) {
                                String strGroup = matcher.group(1);
                                byte b6 = i5 == 0 ? (byte) 1 : (byte) 2;
                                p051j0.a.k(((BaseActivity) MainActivity.this).TAG, "提取到" + strArr[i5] + "类型的内容，ID为：" + strGroup);
                                str3 = strGroup;
                                b = b6;
                                break;
                            }
                        }
                        i5++;
                    } catch (Exception e) {
                        p051j0.a.e(((BaseActivity) MainActivity.this).TAG, "解析剪切板内容时出错", e);
                    }
                }
                if (b == 1) {
                    p003a0.c cVar = MainActivity.this.bqSharedWorker;
                    cVar.d.getBqCloudShared(str3).b(new p003a0.b(cVar, 1));
                } else if (b != 2) {
                    p051j0.a.k(((BaseActivity) MainActivity.this).TAG, "剪切板内容不符合任何口令格式");
                } else {
                    p003a0.c cVar2 = MainActivity.this.bqSharedWorker;
                    cVar2.d.getBqShared(str3).b(new p003a0.b(cVar2, 0));
                }
            }
        }, 2000L);
    }

    @Override // T.a
    public void printDataAddFailed(int i5, String str) {
        p051j0.a.d(this.TAG, "printDataAddFailed code=" + i5 + ", msg=" + str);
    }

    public void switchToCloudSpace() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY, "CloudSpace");
        this.fragments[2].setArguments(bundle);
        this.mBtwIndex.a(2);
    }

    public void switchToFragment(int i5) {
        if (i5 < this.fragments.length - 1) {
            this.mBtwIndex.a(i5);
        }
    }

    public void switchToIndustryLabel() {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY, "IndustryLabel");
        this.fragments[2].setArguments(bundle);
        this.mBtwIndex.a(2);
    }

    public void switchToMinePersonSpace() {
        ((DocumentFragment) this.fragments[1]).switchToMinePersonSpace();
        this.mBtwIndex.a(1);
    }

    @Override // p020d0.c
    public void editRecordNameSuccess() {
    }

    @Override // T.d
    public void printPersonalBiaoqianSuccess() {
    }

    @Override // T.a
    public void printDataAddSuccess(boolean z6) {
    }

    @Override // p020d0.c
    public void editRecordNameFailed(int i5, String str) {
    }

    @Override // p003a0.a
    public void getBqSharedFailed(int i5, String str) {
    }

    @Override // T.d
    public void printPersonalBiaoqianFailed(int i5, String str) {
    }
}
