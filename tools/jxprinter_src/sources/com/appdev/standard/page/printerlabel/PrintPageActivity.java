package com.appdev.standard.page.printerlabel;

import A3.AbstractC0157z;
import android.R;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.pto.AppPrintDataAddBody;
import com.appdev.standard.api.pto.EditRecordNamePto;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.model.UsageRecordModel;
import com.appdev.standard.page.bluetooth.CurrentPrinterFragment;
import com.appdev.standard.page.bluetooth.PrintSetting;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import kotlin.jvm.internal.Y;
import kotlinx.serialization.json.internal.AbstractC1127c;
import okhttp3.Q;
import org.apache.poi.openxml4j.opc.ContentTypes;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PRINT_PAGE)
public class PrintPageActivity extends MvpActivity implements T.d, T.a, p014c0.a, p020d0.c, p020d0.f {
    private static final long CLICK_DELAY = 1000;
    private Context context;

    @BindView(5267)
    ImageView ivPicPrintMirror;

    @BindView(5268)
    ImageView ivPicPrintNoMirror;
    private S.a logWorker;
    private PrintSetting mCustomPopWindow;
    private P0 printInfo;

    @BindView(5744)
    RadioButton rbPicturePrintMirror;

    @BindView(5745)
    RadioButton rbPicturePrintNoMirror;

    @BindView(5781)
    RadioButton rbPrintPageDirection0;

    @BindView(5782)
    RadioButton rbPrintPageDirection180;

    @BindView(5783)
    RadioButton rbPrintPageDirection90;
    private float scale;

    @BindView(5913)
    QuantitySelectorWidget sqlPrintPageCount;

    @BindView(6012)
    TemplatePageView tpvPrintPageView;

    @BindView(6246)
    TextView tvPrintPagePrint;

    @BindView(6272)
    TextView tvTemplateEditLabelName;

    @BindView(6273)
    TextView tvTemplateEditLabelSpecifications;
    private boolean isMirrored = false;
    private TemplateConfigBean templateConfig = null;
    private String templateContent = null;
    private int direction = 0;
    private int printCount = 1;
    private int dataSource = 6;
    private String shareLink = null;
    private String printCoverUrl = null;
    private String printTitle = null;
    private T.e printPersonalBiaoqianWorker = null;
    private T.c printDataAddWorker = null;
    private p020d0.e editRecordNameWorker = null;
    private p020d0.g usageRecordWorker = null;
    private p014c0.e uploadImageWorker = null;
    private String biaoqianPersonalId = null;
    private String usageRecordId = null;
    private int pendingPrintCount = 0;
    private long lastClickTime = 0;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PrintPageActivity$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(byte[] bArr) {
            if (bArr.length == 0) {
                PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        p050j.w.c();
                        p042h2.d.show(p113u.g.toast_7);
                    }
                });
                return;
            }
            K0 printer = p051j0.f.getPrinter();
            if (printer == null || !printer.b()) {
                PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.5.4
                    @Override // java.lang.Runnable
                    public void run() {
                        p050j.w.c();
                        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
                    }
                });
            } else if (printer.sendSync(bArr, null).b()) {
                PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        p050j.w.c();
                        PrintPageActivity printPageActivity = PrintPageActivity.this;
                        printPageActivity.onPrintSuccess(printPageActivity.printCount);
                        p042h2.d.show(p113u.g.toast_2);
                    }
                });
            } else {
                PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.5.3
                    @Override // java.lang.Runnable
                    public void run() {
                        p050j.w.c();
                        p042h2.d.show(p113u.g.toast_5);
                    }
                });
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            P0 p1 = PrintPageActivity.this.printInfo;
            PrintPageActivity printPageActivity = PrintPageActivity.this;
            DataCreateUtil.create(p1, printPageActivity.tpvPrintPageView, printPageActivity.templateConfig, PrintPageActivity.this.direction, PrintPageActivity.this.isMirrored, PrintPageActivity.this.printCount, new H(this, 0));
        }
    }

    private void addPrintDataRecord(int i5) {
        if (this.templateConfig == null) {
            return;
        }
        Bitmap bitmapDrawLabel2Bitmap = this.tpvPrintPageView.drawLabel2Bitmap(false, this.direction, this.isMirrored);
        if (bitmapDrawLabel2Bitmap == null) {
            doPrintDataAdd("", i5);
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapDrawLabel2Bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        okhttp3.D dCreateFormData = okhttp3.D.createFormData(Constants.FILE, "cover_" + System.currentTimeMillis() + ".jpg", Q.create(okhttp3.B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), byteArrayOutputStream.toByteArray()));
        this.pendingPrintCount = i5;
        p014c0.e eVar = this.uploadImageWorker;
        eVar.d.uploadImage(dCreateFormData).b(new p014c0.d(eVar, ""));
    }

    private void doPrintDataAdd(String str, int i5) {
        T.c cVar = this.printDataAddWorker;
        cVar.d.printDataAdd(new AppPrintDataAddBody(str, this.dataSource, this.templateConfig.getHeight(), ((p051j0.a.h() == null || Y.f(p051j0.a.h().getPaperType())) ? this.templateConfig.getPaperType() : Integer.parseInt(p051j0.a.h().getPaperType())) + 1, i5, this.shareLink, getPrintTitle(), this.templateConfig.getWidth())).b(new T.b(cVar));
    }

    private String getPrintCoverUrl() {
        String str = this.printCoverUrl;
        return str == null ? "" : str;
    }

    private String getPrintTitle() {
        if (!Y.f(this.printTitle)) {
            return this.printTitle;
        }
        TemplateConfigBean templateConfigBean = this.templateConfig;
        return templateConfigBean != null ? templateConfigBean.getName() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrintSuccess(int i5) {
        if (!Y.f(this.usageRecordId) && !AbstractC1127c.NULL.equals(this.usageRecordId)) {
            this.editRecordNameWorker.a(new EditRecordNamePto(this.usageRecordId, getPrintTitle()));
        } else if (Y.f(this.biaoqianPersonalId) || AbstractC1127c.NULL.equals(this.biaoqianPersonalId)) {
            TemplateConfigBean templateConfigBean = this.templateConfig;
            if (templateConfigBean != null && !Y.f(templateConfigBean.getTemplateId())) {
                this.printPersonalBiaoqianWorker.a(this.templateConfig.getTemplateId());
            }
        } else {
            p020d0.g gVar = this.usageRecordWorker;
            gVar.d.usageRecordList().b(new p020d0.d(gVar, 1));
        }
        addPrintDataRecord(i5);
        P0 p1 = this.printInfo;
        this.logWorker.a(i5, getPrintTitle(), p1 != null ? p1.getDeviceName() : "");
        TemplateConfigBean templateConfigBean2 = this.templateConfig;
        if (templateConfigBean2 != null) {
            Hawk.put("quick_print_label_width", Integer.valueOf(templateConfigBean2.getWidth()));
            Hawk.put("quick_print_label_height", Integer.valueOf(this.templateConfig.getHeight()));
            S4.d dVarB = S4.d.b();
            int width = this.templateConfig.getWidth();
            int height = this.templateConfig.getHeight();
            p137y.r rVar = new p137y.r();
            rVar.f9021a = width;
            rVar.b = height;
            dVarB.h(rVar);
        }
    }

    private void printByBatch() {
        p050j.w.e();
        runOnNewThread(new AnonymousClass5());
    }

    private void printByPageStream() {
        p050j.w.f(getString(p113u.g.print_stream_generating_progress, 0, Integer.valueOf(this.printCount)));
        runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.6

            /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PrintPageActivity$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
            public class AnonymousClass1 implements DataCreateUtil.StreamPrintListener {
                private int successCount = 0;

                public AnonymousClass1() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onComplete$4(boolean z6, int i5) {
                    p050j.w.c();
                    if (!z6) {
                        p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_interrupted, Integer.valueOf(this.successCount)));
                    } else {
                        PrintPageActivity.this.onPrintSuccess(this.successCount);
                        p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_complete_success, Integer.valueOf(this.successCount), Integer.valueOf(i5)));
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onError$5(int i5, String str) {
                    p050j.w.c();
                    if (i5 >= 0) {
                        p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_page_error, Integer.valueOf(i5 + 1), str));
                    } else {
                        p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_generate_error, str));
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onPageGenerated$0(int i5) {
                    p050j.w.c();
                    p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_page_generate_failed, Integer.valueOf(i5 + 1)));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onPageGenerated$1(int i5, int i6) {
                    p050j.w.f(PrintPageActivity.this.getString(p113u.g.print_stream_generating_progress, Integer.valueOf(i5), Integer.valueOf(i6)));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$onPageGenerated$2(int i5) {
                    p050j.w.c();
                    p042h2.d.a(PrintPageActivity.this.getString(p113u.g.print_stream_page_send_failed, Integer.valueOf(i5 + 1)));
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static /* synthetic */ void lambda$onPageGenerated$3() {
                    p050j.w.c();
                    p042h2.d.show(p113u.g.toast_5);
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
                }

                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.StreamPrintListener
                public void onComplete(final boolean z6, final int i5) {
                    PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.I
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2718a.lambda$onComplete$4(z6, i5);
                        }
                    });
                }

                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.StreamPrintListener
                public void onError(final int i5, final String str) {
                    PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.J
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2719a.lambda$onError$5(i5, str);
                        }
                    });
                }

                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.StreamPrintListener
                public boolean onPageGenerated(final int i5, final int i6, byte[] bArr) {
                    if (bArr.length == 0) {
                        final int i7 = 0;
                        PrintPageActivity.this.runOnUiThread(new Runnable(this) { // from class: com.appdev.standard.page.printerlabel.K
                            public final /* synthetic */ PrintPageActivity.AnonymousClass6.AnonymousClass1 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i7) {
                                    case 0:
                                        this.b.lambda$onPageGenerated$0(i5);
                                        break;
                                    default:
                                        this.b.lambda$onPageGenerated$2(i5);
                                        break;
                                }
                            }
                        });
                        return false;
                    }
                    K0 printer = p051j0.f.getPrinter();
                    if (printer == null || !printer.b()) {
                        PrintPageActivity.this.runOnUiThread(new G(1));
                        return false;
                    }
                    if (!printer.sendSync(bArr, null).b()) {
                        final int i8 = 1;
                        PrintPageActivity.this.runOnUiThread(new Runnable(this) { // from class: com.appdev.standard.page.printerlabel.K
                            public final /* synthetic */ PrintPageActivity.AnonymousClass6.AnonymousClass1 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i8) {
                                    case 0:
                                        this.b.lambda$onPageGenerated$0(i5);
                                        break;
                                    default:
                                        this.b.lambda$onPageGenerated$2(i5);
                                        break;
                                }
                            }
                        });
                        return false;
                    }
                    final int i9 = this.successCount + 1;
                    this.successCount = i9;
                    PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.L
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f2721a.lambda$onPageGenerated$1(i9, i6);
                        }
                    });
                    return true;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                P0 p1 = PrintPageActivity.this.printInfo;
                PrintPageActivity printPageActivity = PrintPageActivity.this;
                DataCreateUtil.createAndPrintByPage(p1, printPageActivity.tpvPrintPageView, printPageActivity.templateConfig, PrintPageActivity.this.direction, PrintPageActivity.this.isMirrored, PrintPageActivity.this.printCount, new AnonymousClass1());
            }
        });
    }

    private void updateDirectionRadioButtons() {
        getResources().getColor(p113u.a.color_FFFFFF);
        getResources().getColor(p113u.a.color_999999);
        this.rbPrintPageDirection0.setBackgroundResource(this.direction == 0 ? p113u.c.bg_ffae00_rad_10 : p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPrintPageDirection90.setBackgroundResource(this.direction == 90 ? p113u.c.bg_ffae00_rad_10 : p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPrintPageDirection180.setBackgroundResource(this.direction == 180 ? p113u.c.bg_ffae00_rad_10 : p113u.c.bg_ffffff_rad_10_stroke_999999);
    }

    private void updateMirrorRadioButtons() {
        int color = getResources().getColor(p113u.a.color_FFFFFF);
        int color2 = getResources().getColor(p113u.a.color_999999);
        if (this.isMirrored) {
            this.rbPicturePrintMirror.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
            this.ivPicPrintMirror.setColorFilter(color);
            this.rbPicturePrintNoMirror.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
            this.ivPicPrintNoMirror.setColorFilter(color2);
            return;
        }
        this.rbPicturePrintNoMirror.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.ivPicPrintNoMirror.setColorFilter(color);
        this.rbPicturePrintMirror.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.ivPicPrintMirror.setColorFilter(color2);
    }

    @Override // p020d0.f
    public void getUsageRecordListSuccess(List<UsageRecordModel> list) {
        if (Y.f(this.biaoqianPersonalId) || AbstractC1127c.NULL.equals(this.biaoqianPersonalId)) {
            return;
        }
        for (UsageRecordModel usageRecordModel : list) {
            if (this.biaoqianPersonalId.equals(usageRecordModel.getBiaoqianPersonalId())) {
                this.editRecordNameWorker.a(new EditRecordNamePto(usageRecordModel.getUsageRecordId(), getPrintTitle()));
                return;
            }
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        T.e eVar = new T.e(this);
        this.printPersonalBiaoqianWorker = eVar;
        addPresenter(eVar);
        T.c cVar = new T.c(this);
        this.printDataAddWorker = cVar;
        addPresenter(cVar);
        p020d0.e eVar2 = new p020d0.e(this);
        this.editRecordNameWorker = eVar2;
        addPresenter(eVar2);
        p020d0.g gVar = new p020d0.g(this);
        this.usageRecordWorker = gVar;
        addPresenter(gVar);
        p014c0.e eVar3 = new p014c0.e(this);
        this.uploadImageWorker = eVar3;
        addPresenter(eVar3);
        this.context = this;
        this.scale = C1849c.getScale();
        TemplateConfigBean templateConfigBean = this.templateConfig;
        if (templateConfigBean != null) {
            this.tpvPrintPageView.setLabelSize(templateConfigBean.getWidth(), this.templateConfig.getHeight());
            this.tpvPrintPageView.setPaperType(this.templateConfig.getPaperType());
            this.tpvPrintPageView.setPrinterLabelBgUrl(this.templateConfig.getPrinterLabelBgUrl());
            this.tpvPrintPageView.setPrinterLabelBgBorderUrl(this.templateConfig.getPrinterLabelBorderUrl());
            if (!Y.f(this.templateContent)) {
                this.tpvPrintPageView.setWantCreateElementsByString(this.templateContent);
            }
        }
        p050j.w.e();
        this.tpvPrintPageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PrintPageActivity.this.tpvPrintPageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                p051j0.a.d(((BaseActivity) PrintPageActivity.this).TAG, "模板渲染开始");
                PrintPageActivity.this.tpvPrintPageView.load();
                p050j.w.c();
                p051j0.a.d(((BaseActivity) PrintPageActivity.this).TAG, "模板渲染完成");
            }
        });
        getSupportFragmentManager().beginTransaction().replace(p113u.d.fl_current_printer, new CurrentPrinterFragment()).commit();
        this.logWorker = new S.a(this);
        this.rbPicturePrintNoMirror.setSelected(true);
        updateMirrorRadioButtons();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.sqlPrintPageCount.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.3
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PrintPageActivity.this.printCount = i5;
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_print_page;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        C1849c.setScale(this.scale);
        super.onBackPressed();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        C1849c.setScale(this.scale);
        super.onDestroy();
    }

    public void onDirection0Click(View view) {
        this.direction = 0;
        updateDirectionRadioButtons();
        this.tpvPrintPageView.setRotation(this.direction);
    }

    public void onDirection180Click(View view) {
        this.direction = 180;
        updateDirectionRadioButtons();
        this.tpvPrintPageView.setRotation(this.direction);
    }

    public void onDirection90Click(View view) {
        this.direction = 90;
        updateDirectionRadioButtons();
        this.tpvPrintPageView.setRotation(this.direction);
    }

    public void onPicturePrintMirrorClick(View view) {
        this.isMirrored = true;
        updateMirrorRadioButtons();
        this.tpvPrintPageView.setScaleX(-1.0f);
    }

    public void onPicturePrintNoMirrorClick(View view) {
        this.isMirrored = false;
        updateMirrorRadioButtons();
        this.tpvPrintPageView.setScaleX(1.0f);
    }

    public void onPrintInfoClick(View view) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTime > CLICK_DELAY) {
            this.lastClickTime = jCurrentTimeMillis;
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        }
    }

    public void onPrintPageDownloadClick(View view) {
        if (Build.VERSION.SDK_INT <= 28) {
            needStoragePermission(new PermissionTipDialog(this, getString(p113u.g.text_499)), new p026e2.a() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.7
                @Override // p026e2.a
                public void onRequestPermissionFail() {
                    p042h2.d.show(p113u.g.toast_3);
                }

                @Override // p026e2.a
                public void onRequestPermissionSuccess() {
                    PrintPageActivity.this.saveToPhotos();
                }
            });
        } else {
            saveToPhotos();
        }
    }

    public void onPrintPagePrintClick(View view) {
        P0 p0H = p051j0.a.h();
        this.printInfo = p0H;
        if (p0H != null) {
            if ("01".equals(p0H.getCmdMode()) || "02".equals(this.printInfo.getCmdMode())) {
                K0 printer = p051j0.f.getPrinter();
                if (printer == null || !printer.b()) {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
                } else {
                    printByPageStream();
                }
            }
        }
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.printInfo = p051j0.a.h();
        K0 printer = p051j0.f.getPrinter();
        if (this.printInfo == null && printer != null && printer.b()) {
            p050j.w.f(getResources().getString(p113u.g.toast_44));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    PrintPageActivity.this.printInfo = p051j0.f.read_print_info();
                    PrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                p050j.w.c();
                            } catch (NumberFormatException e) {
                                p050j.w.c();
                                p042h2.d.show(p113u.g.toast_1);
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            });
        }
    }

    public void onSettingPrinterClick(View view) {
        PrintSetting printSetting = new PrintSetting(new PrintSetting.OnSettingListener() { // from class: com.appdev.standard.page.printerlabel.PrintPageActivity.4
            @Override // com.appdev.standard.page.bluetooth.PrintSetting.OnSettingListener
            public void onSetting(P0 p1) {
            }
        });
        this.mCustomPopWindow = printSetting;
        printSetting.showSetting(this, getWindow().getDecorView().findViewById(R.id.content));
    }

    @Override // T.a
    public void printDataAddFailed(int i5, String str) {
        p051j0.a.d(this.TAG, "printDataAddFailed code=" + i5 + ", msg=" + str);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        this.templateConfig = (TemplateConfigBean) bundle.getSerializable("data_template_config");
        if (bundle.containsKey("rotate")) {
            this.direction = bundle.getInt("rotate", 0);
        } else if (bundle.containsKey("rotationAngle")) {
            this.direction = bundle.getInt("rotationAngle", 0);
        } else {
            TemplateConfigBean templateConfigBean = this.templateConfig;
            if (templateConfigBean != null) {
                this.direction = templateConfigBean.getRotate();
            } else {
                this.direction = 0;
            }
        }
        TemplateConfigBean templateConfigBean2 = this.templateConfig;
        if (templateConfigBean2 == null) {
            this.templateConfig = new TemplateConfigBean("label", 60, 30, 1, 0);
        } else {
            this.tvTemplateEditLabelName.setText(templateConfigBean2.getName());
            this.tvTemplateEditLabelSpecifications.setText(String.format("%d*%dmm", Integer.valueOf(this.templateConfig.getWidth()), Integer.valueOf(this.templateConfig.getHeight())));
        }
        this.templateContent = bundle.getString("data_template_content", null);
        this.dataSource = bundle.getInt("data_print_data_source", 6);
        this.shareLink = bundle.getString("data_print_share_link");
        this.printCoverUrl = bundle.getString("data_print_cover_url");
        this.printTitle = bundle.getString("data_print_title");
        this.biaoqianPersonalId = bundle.getString("personLabelId");
        this.usageRecordId = bundle.getString("usageRecordId");
        updateDirectionRadioButtons();
        p051j0.a.c("最终跳转", "旋转方向" + this.direction);
        this.tpvPrintPageView.setRotation((float) this.direction);
    }

    public void saveToPhotos() {
        p050j.w.e();
        Bitmap bitmapDrawLabel2Bitmap = this.tpvPrintPageView.drawLabel2Bitmap(false, this.direction, this.isMirrored);
        if (bitmapDrawLabel2Bitmap == null) {
            p042h2.d.show(p113u.g.toast_9);
            p050j.w.c();
            return;
        }
        String strO = AbstractC0157z.o("JX_Label_Image_", String.valueOf(System.currentTimeMillis()), ".jpeg");
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", strO);
        contentValues.put("mime_type", ContentTypes.IMAGE_JPEG);
        contentValues.put("relative_path", Environment.DIRECTORY_PICTURES);
        Uri uriInsert = this.context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (uriInsert != null) {
            try {
                OutputStream outputStreamOpenOutputStream = this.context.getContentResolver().openOutputStream(uriInsert);
                try {
                    bitmapDrawLabel2Bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                    p042h2.d.show(p113u.g.toast_8);
                    p050j.w.c();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                    }
                } catch (Throwable th) {
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e) {
                e.printStackTrace();
                p042h2.d.show(p113u.g.toast_9);
                p050j.w.c();
            }
        }
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        doPrintDataAdd("", this.pendingPrintCount);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        doPrintDataAdd(str, this.pendingPrintCount);
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

    @Override // p020d0.f
    public void getUsageRecordListFailed(int i5, String str) {
    }

    @Override // T.d
    public void printPersonalBiaoqianFailed(int i5, String str) {
    }
}
