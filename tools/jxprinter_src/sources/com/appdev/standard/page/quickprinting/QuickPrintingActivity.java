package com.appdev.standard.page.quickprinting;

import G.d;
import G.f;
import G.g;
import G.i;
import I0.h;
import S4.k;
import T.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.DocumentApi;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.model.MineLabelModel;
import com.appdev.standard.model.PrintTaskBean;
import com.appdev.standard.model.QuickPrintMineLabelModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;
import p137y.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_QUICK_PRINTING)
public class QuickPrintingActivity extends MvpActivity implements d, T.d, g {

    @BindView(4878)
    AutoNullDisplayView audvMineLabel;

    @BindView(4879)
    AutoNullDisplayView audvMyDoc;
    private Context context;

    @BindView(5056)
    EditText etSearch;

    @BindView(5107)
    FrameLayout flTemplatePageView;

    @BindView(5301)
    ImageView ivShowMore;

    @BindView(5364)
    LinearLayout llDetails;

    @BindView(5410)
    LinearLayout llHasSelectLabel;

    @BindView(5500)
    LinearLayout llSelectLabelNum;

    @BindView(5512)
    LinearLayout llWarn;
    private f mineLabelWorker;
    private com.library.base.util.recyclerview.f myDocAdapter;
    private i myDocWorker;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5843)
    RecyclerView rvMineLabel;

    @BindView(5844)
    RecyclerView rvMyDoc;

    @BindView(5852)
    RecyclerView rvSelectLabel;
    private com.library.base.util.recyclerview.f selectAdapter;

    @BindView(5934)
    SmartRefreshLayout srlMineLabel;

    @BindView(5935)
    SmartRefreshLayout srlMyDoc;

    @BindView(6246)
    TextView tvPrintPagePrint;

    @BindView(6097)
    TextView tvSearch;

    @BindView(6259)
    TextView tvSelectLabelNum;

    @BindView(6261)
    TextView tvShowMore;

    @BindView(6274)
    TextView tvTitle;
    private String currentKeyword = "";
    private e printPersonalBiaoqianWorker = null;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private int myDocPageNum = 1;
    private int myDocTotalPageNo = 1;
    private boolean isLoadMore = false;
    private boolean isMyDocLoadMore = false;
    private boolean isShowMore = false;
    private Queue<PrintTaskBean> printTasks = null;
    private Integer currentLabelWidth = null;
    private Integer currentLabelHeight = null;

    /* JADX INFO: renamed from: com.appdev.standard.page.quickprinting.QuickPrintingActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(com.library.base.util.recyclerview.a aVar, final QuickPrintMineLabelModel quickPrintMineLabelModel) {
            aVar.b(p113u.d.tv_document_mine_label_title, quickPrintMineLabelModel.getTitle());
            aVar.b(p113u.d.tv_document_mine_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight())));
            aVar.b(p113u.d.tv_document_mine_label_create_time, quickPrintMineLabelModel.getCreateTime());
            p047i2.a.b(quickPrintMineLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_document_mine_label_img), p113u.f.ic_default_error_label_1);
            aVar.c(p113u.d.ll_operation, quickPrintMineLabelModel.getPrintCount() <= 0);
            int i5 = p113u.d.sql_print_page_count;
            aVar.c(i5, quickPrintMineLabelModel.getPrintCount() > 0);
            final QuantitySelectorWidget quantitySelectorWidget = (QuantitySelectorWidget) aVar.a(i5);
            quantitySelectorWidget.setOffsetValue(quickPrintMineLabelModel.getPrintCount());
            ImageView imageView = (ImageView) aVar.a(p113u.d.iv_document_mine_label_type_bk);
            TextView textView = (TextView) aVar.a(p113u.d.tv_document_mine_label_type);
            if (quickPrintMineLabelModel.getType() == 1) {
                imageView.setImageResource(p113u.f.ic_label_type_bk);
                textView.setText(p113u.g.text_459);
            } else {
                imageView.setImageResource(p113u.f.ic_text_type_bk);
                textView.setText(p113u.g.text_94);
            }
            aVar.a(p113u.d.iv_item_label_print).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QuickPrintingActivity quickPrintingActivity = QuickPrintingActivity.this;
                    QuickPrintingActivity quickPrintingActivity2 = QuickPrintingActivity.this;
                    quickPrintingActivity.needBlueToothPermission(new PermissionTipDialog(quickPrintingActivity2, quickPrintingActivity2.getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.1.1.1
                        @Override // p026e2.a
                        public void onRequestPermissionFail() {
                            QuickPrintingActivity quickPrintingActivity3 = QuickPrintingActivity.this;
                            p051j0.a.l();
                        }

                        @Override // p026e2.a
                        public void onRequestPermissionSuccess() {
                            QuickPrintingActivity quickPrintingActivity3 = QuickPrintingActivity.this;
                            p051j0.a.m();
                            ViewOnClickListenerC00781 viewOnClickListenerC00781 = ViewOnClickListenerC00781.this;
                            QuickPrintingActivity.this.printOneLabel(quickPrintMineLabelModel);
                        }
                    });
                }
            });
            aVar.a(p113u.d.iv_item_label_add).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.1.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QuickPrintMineLabelModel quickPrintMineLabelModel2 = quickPrintMineLabelModel;
                    quickPrintMineLabelModel2.setPrintCount(quickPrintMineLabelModel2.getPrintCount() + 1);
                    quantitySelectorWidget.setOffsetValue(quickPrintMineLabelModel.getPrintCount());
                    QuickPrintingActivity.this.quickAdapter.notifyDataSetChanged();
                    QuickPrintingActivity.this.refreshSelectLabel();
                }
            });
            quantitySelectorWidget.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.1.3
                @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
                public void onValue(int i6) {
                    quickPrintMineLabelModel.setPrintCount(i6);
                    if (i6 == 0) {
                        AnonymousClass1.this.notifyDataSetChanged();
                    }
                    QuickPrintingActivity.this.refreshSelectLabel();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.quickprinting.QuickPrintingActivity$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 extends com.library.base.util.recyclerview.f {
        public AnonymousClass3(Context context, int i5) {
            super(context, i5);
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(com.library.base.util.recyclerview.a aVar, final QuickPrintMineLabelModel quickPrintMineLabelModel) {
            aVar.b(p113u.d.tv_document_mine_label_title, quickPrintMineLabelModel.getTitle());
            aVar.b(p113u.d.tv_document_mine_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight())));
            aVar.b(p113u.d.tv_document_mine_label_create_time, quickPrintMineLabelModel.getCreateTime());
            p047i2.a.b(quickPrintMineLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_document_mine_label_img), p113u.f.ic_default_error_label_1);
            aVar.c(p113u.d.ll_operation, quickPrintMineLabelModel.getPrintCount() <= 0);
            int i5 = p113u.d.sql_print_page_count;
            aVar.c(i5, quickPrintMineLabelModel.getPrintCount() > 0);
            final QuantitySelectorWidget quantitySelectorWidget = (QuantitySelectorWidget) aVar.a(i5);
            quantitySelectorWidget.setOffsetValue(quickPrintMineLabelModel.getPrintCount());
            ImageView imageView = (ImageView) aVar.a(p113u.d.iv_document_mine_label_type_bk);
            TextView textView = (TextView) aVar.a(p113u.d.tv_document_mine_label_type);
            if (quickPrintMineLabelModel.getType() == 0 || quickPrintMineLabelModel.getType() == 1) {
                imageView.setImageResource(p113u.f.ic_label_type_bk);
                textView.setText(p113u.g.text_459);
            } else {
                imageView.setImageResource(p113u.f.ic_text_type_bk);
                textView.setText(p113u.g.text_94);
            }
            aVar.a(p113u.d.iv_item_label_print).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.3.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QuickPrintingActivity quickPrintingActivity = QuickPrintingActivity.this;
                    QuickPrintingActivity quickPrintingActivity2 = QuickPrintingActivity.this;
                    quickPrintingActivity.needBlueToothPermission(new PermissionTipDialog(quickPrintingActivity2, quickPrintingActivity2.getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.3.1.1
                        @Override // p026e2.a
                        public void onRequestPermissionFail() {
                            QuickPrintingActivity quickPrintingActivity3 = QuickPrintingActivity.this;
                            p051j0.a.l();
                        }

                        @Override // p026e2.a
                        public void onRequestPermissionSuccess() {
                            QuickPrintingActivity quickPrintingActivity3 = QuickPrintingActivity.this;
                            p051j0.a.m();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            QuickPrintingActivity.this.printOneLabel(quickPrintMineLabelModel);
                        }
                    });
                }
            });
            aVar.a(p113u.d.iv_item_label_add).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.3.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    QuickPrintMineLabelModel quickPrintMineLabelModel2 = quickPrintMineLabelModel;
                    quickPrintMineLabelModel2.setPrintCount(quickPrintMineLabelModel2.getPrintCount() + 1);
                    quantitySelectorWidget.setOffsetValue(quickPrintMineLabelModel.getPrintCount());
                    QuickPrintingActivity.this.myDocAdapter.notifyDataSetChanged();
                    QuickPrintingActivity.this.refreshSelectLabel();
                }
            });
            quantitySelectorWidget.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.3.3
                @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
                public void onValue(int i6) {
                    quickPrintMineLabelModel.setPrintCount(i6);
                    if (i6 == 0) {
                        AnonymousClass3.this.notifyDataSetChanged();
                    }
                    QuickPrintingActivity.this.refreshSelectLabel();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.quickprinting.QuickPrintingActivity$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ PrintTaskBean val$printTask;

        public AnonymousClass8(PrintTaskBean printTaskBean) {
            this.val$printTask = printTaskBean;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(PrintTaskBean printTaskBean) {
            Bitmap printBitmap = printTaskBean.getPrintBitmap();
            if (printBitmap != null) {
                QuickPrintingActivity.this.printTextBitmap(printBitmap, printTaskBean.getPageCount());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$printTask.getTaskType() != 1) {
                QuickPrintingActivity.this.runOnNewThread(new a(this.val$printTask, 0, this));
                return;
            }
            final TemplateConfigBean templateConfig = this.val$printTask.getTemplateConfig();
            String strE = p052j2.c.e(this.val$printTask.getTemplatePto().getViews());
            final TemplatePageView templatePageView = (TemplatePageView) LayoutInflater.from(QuickPrintingActivity.this.context).inflate(p113u.e.main_template_page_view, (ViewGroup) null);
            QuickPrintingActivity.this.flTemplatePageView.addView(templatePageView);
            if (templateConfig != null) {
                templatePageView.setLabelSize(templateConfig.getWidth(), templateConfig.getHeight());
                templatePageView.setPrinterLabelBgUrl(templateConfig.getPrinterLabelBgUrl());
                templatePageView.setPrinterLabelBgBorderUrl(templateConfig.getPrinterLabelBorderUrl());
                templatePageView.setPaperType(templateConfig.getPaperType());
                if (!Y.f(strE)) {
                    templatePageView.setWantCreateElementsByString(strE);
                }
            }
            templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.8.1
                @Override // java.lang.Runnable
                public void run() {
                    templatePageView.load();
                    templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.8.1.1
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            if (!templatePageView.isRenderingCompleted()) {
                                p051j0.a.d(((BaseActivity) QuickPrintingActivity.this).TAG, "渲染未完成");
                                templatePageView.postDelayed(this, 1000L);
                                return;
                            }
                            p051j0.a.d(((BaseActivity) QuickPrintingActivity.this).TAG, "渲染完成");
                            w.f(QuickPrintingActivity.this.getString(p113u.g.text_263));
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            QuickPrintingActivity.this.startPrintLabel(templateConfig, anonymousClass8.val$printTask.getPageCount(), templatePageView);
                        }
                    }, 1000L);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.quickprinting.QuickPrintingActivity$9, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass9 implements Runnable {
        final /* synthetic */ int val$direction;
        final /* synthetic */ int val$printCount;
        final /* synthetic */ P0 val$printInfo;
        final /* synthetic */ TemplateConfigBean val$templateConfig;
        final /* synthetic */ TemplatePageView val$templatePageView;

        public AnonymousClass9(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, int i6) {
            this.val$printInfo = p1;
            this.val$templatePageView = templatePageView;
            this.val$templateConfig = templateConfigBean;
            this.val$direction = i5;
            this.val$printCount = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            w.c();
            p042h2.d.show(p113u.g.toast_7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(TemplateConfigBean templateConfigBean) {
            QuickPrintingActivity.this.printPersonalBiaoqianWorker.a(templateConfigBean.getTemplateId());
            PrintTaskBean printTaskBean = (PrintTaskBean) QuickPrintingActivity.this.printTasks.poll();
            if (printTaskBean != null) {
                QuickPrintingActivity.this.preShowLabel(printTaskBean);
            } else {
                w.c();
                p042h2.d.show(p113u.g.toast_62);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2() {
            w.c();
            p042h2.d.show(p113u.g.toast_63);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$3() {
            w.c();
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$4(TemplateConfigBean templateConfigBean, byte[] bArr) {
            if (bArr.length == 0) {
                QuickPrintingActivity.this.runOnUiThread(new c(0));
                return;
            }
            K0 printer = p051j0.f.getPrinter();
            if (printer == null || !printer.b()) {
                QuickPrintingActivity.this.runOnUiThread(new c(2));
            } else if (printer.sendSync(bArr, null).b()) {
                QuickPrintingActivity.this.runOnUiThread(new a(templateConfigBean, 1, this));
            } else {
                QuickPrintingActivity.this.runOnUiThread(new c(1));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            P0 p1 = this.val$printInfo;
            TemplatePageView templatePageView = this.val$templatePageView;
            final TemplateConfigBean templateConfigBean = this.val$templateConfig;
            DataCreateUtil.create(p1, templatePageView, templateConfigBean, this.val$direction, false, this.val$printCount, new DataCreateUtil.CreateBitmapEventListener() { // from class: com.appdev.standard.page.quickprinting.b
                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.CreateBitmapEventListener
                public final void onComplete(byte[] bArr) {
                    this.f2825a.lambda$run$4(templateConfigBean, bArr);
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
    public /* synthetic */ void lambda$initComponent$0(View view) {
        this.currentKeyword = androidx.exifinterface.media.a.f(this.etSearch);
        this.srlMineLabel.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$printTextBitmap$1() {
        w.c();
        p042h2.d.show(p113u.g.toast_63);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$printTextBitmap$2() {
        PrintTaskBean printTaskBeanPoll = this.printTasks.poll();
        if (printTaskBeanPoll != null) {
            preShowLabel(printTaskBeanPoll);
        } else {
            w.c();
            p042h2.d.show(p113u.g.toast_62);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$printTextBitmap$3() {
        w.c();
        p042h2.d.show(p113u.g.toast_63);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void preShowLabel(PrintTaskBean printTaskBean) {
        runOnUiThread(new AnonymousClass8(printTaskBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void printOneLabel(final QuickPrintMineLabelModel quickPrintMineLabelModel) {
        K0 printer = p051j0.f.getPrinter();
        if (printer != null && printer.b()) {
            w.f(getString(p113u.g.text_263));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (quickPrintMineLabelModel.getType() != 1) {
                        Bitmap bitmapFromUrl = QuickPrintingActivity.this.getBitmapFromUrl(quickPrintMineLabelModel.getCoverUrl());
                        if (bitmapFromUrl == null) {
                            w.c();
                            p042h2.d.show(p113u.g.toast_13);
                            return;
                        } else {
                            PrintTaskBean printTaskBean = new PrintTaskBean(bitmapFromUrl, 1);
                            QuickPrintingActivity.this.printTasks = new LinkedList();
                            QuickPrintingActivity.this.preShowLabel(printTaskBean);
                            return;
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, quickPrintMineLabelModel.getContent());
                    TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                    PrintTaskBean printTaskBean2 = new PrintTaskBean(templatePto, new TemplateConfigBean(quickPrintMineLabelModel.getTitle(), quickPrintMineLabelModel.getWidth(), quickPrintMineLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), String.valueOf(quickPrintMineLabelModel.getId()), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate()), 1);
                    DataCreateUtil.getFontList(arrayList, templatePto.getViews());
                    p051j0.a.d(((BaseActivity) QuickPrintingActivity.this).TAG, "字体列表=" + Arrays.toString(arrayList.toArray()));
                    QuickPrintingActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.f(QuickPrintingActivity.this.getString(p113u.g.text_263));
                        }
                    });
                    if (!DataCreateUtil.downloadFont(arrayList)) {
                        QuickPrintingActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.7.2
                            @Override // java.lang.Runnable
                            public void run() {
                                w.c();
                                p042h2.d.show(p113u.g.toast_12);
                            }
                        });
                        return;
                    }
                    QuickPrintingActivity.this.printTasks = new LinkedList();
                    QuickPrintingActivity.this.preShowLabel(printTaskBean2);
                }
            });
            return;
        }
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void printTextBitmap(Bitmap bitmap, int i5) {
        P0 p0H = p051j0.a.h();
        if (p0H == null || !("01".equals(p0H.getCmdMode()) || "02".equals(p0H.getCmdMode()))) {
            w.c();
            p042h2.d.show(p113u.g.toast_13);
            return;
        }
        w.f(getString(p113u.g.text_263));
        boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
        K0 printer = p051j0.f.getPrinter();
        if (printer == null) {
            runOnUiThread(new c(3));
            return;
        }
        if ((p0H.getCmdMode().equals("01") ? printer.printESCBitmapSync(bitmap, zBooleanValue, i5, null) : printer.printTSCBitmapSync(bitmap, zBooleanValue, i5, p0H.getSpeedLev(), p0H.e, null)).b()) {
            runOnUiThread(new W2.c(this, 8));
        } else {
            runOnUiThread(new c(4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMineLabel() {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.selectAdapter.getData().iterator();
        String str = null;
        int printCount = 0;
        boolean z6 = false;
        while (it.hasNext()) {
            QuickPrintMineLabelModel quickPrintMineLabelModel = (QuickPrintMineLabelModel) it.next();
            if (quickPrintMineLabelModel.getPrintCount() > 0) {
                printCount += quickPrintMineLabelModel.getPrintCount();
                if (str == null) {
                    str = String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight()));
                } else if (!String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight())).equals(str)) {
                    z6 = true;
                }
                arrayList.add(quickPrintMineLabelModel);
                map.put(String.valueOf(quickPrintMineLabelModel.getId()), Integer.valueOf(quickPrintMineLabelModel.getPrintCount()));
            }
        }
        this.selectAdapter.replaceAll(arrayList);
        Iterator<Object> it2 = this.quickAdapter.getData().iterator();
        while (it2.hasNext()) {
            QuickPrintMineLabelModel quickPrintMineLabelModel2 = (QuickPrintMineLabelModel) it2.next();
            if (map.get(quickPrintMineLabelModel2.getId()) != null) {
                quickPrintMineLabelModel2.setPrintCount(((Integer) map.get(quickPrintMineLabelModel2.getId())).intValue());
            }
        }
        Iterator<Object> it3 = this.myDocAdapter.getData().iterator();
        while (it3.hasNext()) {
            QuickPrintMineLabelModel quickPrintMineLabelModel3 = (QuickPrintMineLabelModel) it3.next();
            if (map.get(quickPrintMineLabelModel3.getId()) != null) {
                quickPrintMineLabelModel3.setPrintCount(((Integer) map.get(quickPrintMineLabelModel3.getId())).intValue());
            }
        }
        this.llWarn.setVisibility(z6 ? 0 : 8);
        this.tvPrintPagePrint.setText(String.format(getString(p113u.g.text_7), Integer.valueOf(printCount)));
        this.quickAdapter.notifyDataSetChanged();
        this.myDocAdapter.notifyDataSetChanged();
        refreshShowMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSelectLabel() {
        this.selectAdapter.clear();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        String str = null;
        int printCount = 0;
        boolean z6 = false;
        while (it.hasNext()) {
            QuickPrintMineLabelModel quickPrintMineLabelModel = (QuickPrintMineLabelModel) it.next();
            if (quickPrintMineLabelModel.getPrintCount() > 0) {
                printCount += quickPrintMineLabelModel.getPrintCount();
                if (str == null) {
                    str = String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight()));
                } else if (!String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight())).equals(str)) {
                    z6 = true;
                }
                this.selectAdapter.add(quickPrintMineLabelModel);
            }
        }
        Iterator<Object> it2 = this.myDocAdapter.getData().iterator();
        while (it2.hasNext()) {
            QuickPrintMineLabelModel quickPrintMineLabelModel2 = (QuickPrintMineLabelModel) it2.next();
            if (quickPrintMineLabelModel2.getPrintCount() > 0) {
                int printCount2 = quickPrintMineLabelModel2.getPrintCount() + printCount;
                if (str == null) {
                    str = String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel2.getWidth()), Integer.valueOf(quickPrintMineLabelModel2.getHeight()));
                } else if (!String.format("%d*%d", Integer.valueOf(quickPrintMineLabelModel2.getWidth()), Integer.valueOf(quickPrintMineLabelModel2.getHeight())).equals(str)) {
                    z6 = true;
                }
                this.selectAdapter.add(quickPrintMineLabelModel2);
                printCount = printCount2;
            }
        }
        this.llWarn.setVisibility(z6 ? 0 : 8);
        this.tvPrintPagePrint.setText(String.format(getString(p113u.g.text_7), Integer.valueOf(printCount)));
        refreshShowMore();
    }

    private void refreshShowMore() {
        this.tvSelectLabelNum.setText(String.valueOf(this.selectAdapter.getData().size()));
        this.llHasSelectLabel.setVisibility(this.selectAdapter.getData().size() > 0 ? 0 : 8);
        if (this.isShowMore) {
            this.llDetails.setVisibility(0);
            this.llSelectLabelNum.setVisibility(4);
            this.tvShowMore.setText(getString(p113u.g.text_240));
            this.ivShowMore.setImageResource(p113u.f.icon_quick_printing_down);
            return;
        }
        this.llDetails.setVisibility(4);
        this.llSelectLabelNum.setVisibility(0);
        this.tvShowMore.setText(getString(p113u.g.text_93));
        this.ivShowMore.setImageResource(p113u.f.icon_quick_printing_up);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void startPrintLabel(TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) throws Throwable {
        Throwable th;
        int rotate;
        try {
            if (templateConfigBean != null) {
                try {
                    rotate = templateConfigBean.getRotate();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } else {
                rotate = 0;
            }
            int i6 = rotate;
            try {
                P0 p0H = p051j0.a.h();
                C1849c.getScale();
                if (p0H == null || !("01".equals(p0H.getCmdMode()) || "02".equals(p0H.getCmdMode()))) {
                    w.c();
                    p042h2.d.show(p113u.g.toast_13);
                } else {
                    K0 printer = p051j0.f.getPrinter();
                    if (printer == null || !printer.b()) {
                        w.c();
                        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
                    } else {
                        w.f(getString(p113u.g.text_263));
                        runOnNewThread(new AnonymousClass9(p0H, templatePageView, templateConfigBean, i6, i5));
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        S4.d.b().j(this);
        Integer num = (Integer) Hawk.get("quick_print_label_width", null);
        Integer num2 = (Integer) Hawk.get("quick_print_label_height", null);
        if (num != null && num2 != null) {
            this.currentLabelWidth = num;
            this.currentLabelHeight = num2;
        }
        this.tvSearch.setOnClickListener(new com.appdev.standard.page.document.a(this, 1));
        e eVar = new e(this);
        this.printPersonalBiaoqianWorker = eVar;
        addPresenter(eVar);
        f fVar = new f(this);
        this.mineLabelWorker = fVar;
        addPresenter(fVar);
        i iVar = new i(this);
        iVar.d = (DocumentApi) Http.createApi(DocumentApi.class);
        this.myDocWorker = iVar;
        addPresenter(iVar);
        this.context = this;
        this.tvTitle.setText(getString(p113u.g.text_184));
        AutoNullDisplayView autoNullDisplayView = this.audvMineLabel;
        int i5 = p113u.f.ic_label_no_data;
        autoNullDisplayView.b(i5);
        AutoNullDisplayView autoNullDisplayView2 = this.audvMineLabel;
        int i6 = p113u.g.text_282;
        autoNullDisplayView2.setConnect(getString(i6));
        this.audvMineLabel.setButtonWhetherVisible(false);
        this.audvMyDoc.b(i5);
        this.audvMyDoc.setConnect(getString(i6));
        this.audvMyDoc.setButtonWhetherVisible(false);
        int i7 = p113u.e.item_quick_printing_mine_label;
        this.quickAdapter = new AnonymousClass1(this, i7);
        int i8 = (int) 200.0f;
        this.rvMineLabel.addItemDecoration(new com.library.base.util.recyclerview.c(i8));
        this.rvMineLabel.setLayoutManager(new LinearLayoutManager(this));
        this.rvMineLabel.setAdapter(this.quickAdapter);
        this.selectAdapter = new com.library.base.util.recyclerview.f(this, i7) { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final QuickPrintMineLabelModel quickPrintMineLabelModel) {
                aVar.b(p113u.d.tv_document_mine_label_title, quickPrintMineLabelModel.getTitle());
                aVar.b(p113u.d.tv_document_mine_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(quickPrintMineLabelModel.getWidth()), Integer.valueOf(quickPrintMineLabelModel.getHeight())));
                aVar.b(p113u.d.tv_document_mine_label_create_time, quickPrintMineLabelModel.getCreateTime());
                p047i2.a.b(quickPrintMineLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_document_mine_label_img), p113u.f.ic_default_error_label_1);
                aVar.c(p113u.d.ll_operation, quickPrintMineLabelModel.getPrintCount() <= 0);
                int i9 = p113u.d.sql_print_page_count;
                aVar.c(i9, quickPrintMineLabelModel.getPrintCount() > 0);
                QuantitySelectorWidget quantitySelectorWidget = (QuantitySelectorWidget) aVar.a(i9);
                quantitySelectorWidget.setOffsetValue(quickPrintMineLabelModel.getPrintCount());
                quantitySelectorWidget.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
                    public void onValue(int i10) {
                        quickPrintMineLabelModel.setPrintCount(i10);
                        QuickPrintingActivity.this.refreshMineLabel();
                    }
                });
            }
        };
        this.rvSelectLabel.setLayoutManager(new LinearLayoutManager(this));
        this.rvSelectLabel.setAdapter(this.selectAdapter);
        this.myDocAdapter = new AnonymousClass3(this, i7);
        this.rvMyDoc.addItemDecoration(new com.library.base.util.recyclerview.c(i8));
        this.rvMyDoc.setLayoutManager(new LinearLayoutManager(this));
        this.rvMyDoc.setAdapter(this.myDocAdapter);
        refreshSelectLabel();
        this.srlMineLabel.h();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.srlMineLabel.s(new L2.f() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.4
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                QuickPrintingActivity.this.isLoadMore = true;
                if (QuickPrintingActivity.this.pageNum == QuickPrintingActivity.this.totalPageNo) {
                    QuickPrintingActivity.this.srlMineLabel.r(true);
                    return;
                }
                QuickPrintingActivity.this.pageNum++;
                QuickPrintingActivity.this.mineLabelWorker.a(QuickPrintingActivity.this.currentKeyword, QuickPrintingActivity.this.pageNum, QuickPrintingActivity.this.currentLabelWidth, QuickPrintingActivity.this.currentLabelHeight);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                QuickPrintingActivity.this.isLoadMore = false;
                QuickPrintingActivity.this.srlMineLabel.r(false);
                QuickPrintingActivity.this.pageNum = 1;
                QuickPrintingActivity.this.mineLabelWorker.a(QuickPrintingActivity.this.currentKeyword, QuickPrintingActivity.this.pageNum, QuickPrintingActivity.this.currentLabelWidth, QuickPrintingActivity.this.currentLabelHeight);
            }
        });
        this.srlMyDoc.s(new L2.f() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.5
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                QuickPrintingActivity.this.isMyDocLoadMore = true;
                if (QuickPrintingActivity.this.myDocPageNum == QuickPrintingActivity.this.myDocTotalPageNo) {
                    QuickPrintingActivity.this.srlMyDoc.r(true);
                    return;
                }
                QuickPrintingActivity.this.myDocPageNum++;
                i iVar = QuickPrintingActivity.this.myDocWorker;
                iVar.d.myDoc(QuickPrintingActivity.this.myDocPageNum, 10).b(new G.h(iVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                QuickPrintingActivity.this.isMyDocLoadMore = false;
                QuickPrintingActivity.this.srlMyDoc.r(false);
                QuickPrintingActivity.this.myDocPageNum = 1;
                i iVar = QuickPrintingActivity.this.myDocWorker;
                iVar.d.myDoc(QuickPrintingActivity.this.myDocPageNum, 10).b(new G.h(iVar));
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_quick_printing;
    }

    @Override // G.d
    public void mineLabelFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlMineLabel.k();
        this.srlMineLabel.i();
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // G.d
    public void mineLabelSuccess(List<MineLabelModel> list, int i5) {
        this.srlMineLabel.k();
        this.srlMineLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        ArrayList arrayList = new ArrayList();
        Iterator<MineLabelModel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((QuickPrintMineLabelModel) p052j2.c.d(it.next(), QuickPrintMineLabelModel.class));
        }
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(arrayList);
        } else {
            this.quickAdapter.replaceAll(arrayList);
            this.srlMyDoc.h();
        }
        refreshSelectLabel();
    }

    @Override // G.g
    public void myDocFailed(int i5, String str) {
        int i6 = this.myDocPageNum;
        if (i6 > 1) {
            this.myDocPageNum = i6 - 1;
        }
        this.srlMyDoc.k();
        this.srlMyDoc.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // G.g
    public void myDocSuccess(List<MineLabelModel> list, int i5) {
        this.srlMyDoc.k();
        this.srlMyDoc.i();
        this.myDocTotalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        ArrayList arrayList = new ArrayList();
        Iterator<MineLabelModel> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((QuickPrintMineLabelModel) p052j2.c.d(it.next(), QuickPrintMineLabelModel.class));
        }
        w.c();
        if (this.isMyDocLoadMore) {
            this.myDocAdapter.addAll(arrayList);
        } else {
            this.myDocAdapter.replaceAll(arrayList);
        }
        refreshSelectLabel();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        S4.d.b().m(this);
    }

    @k(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLabelSizeEvent(r rVar) {
        this.currentLabelWidth = Integer.valueOf(rVar.f9021a);
        this.currentLabelHeight = Integer.valueOf(rVar.b);
        this.isLoadMore = false;
        this.srlMineLabel.r(false);
        this.pageNum = 1;
        this.mineLabelWorker.a(this.currentKeyword, 1, this.currentLabelWidth, this.currentLabelHeight);
        S4.d dVarB = S4.d.b();
        synchronized (dVarB.c) {
            r.class.cast(dVarB.c.remove(r.class));
        }
    }

    public void onPrintClick(View view) {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        } else {
            w.f(getString(p113u.g.text_263));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    QuickPrintingActivity.this.printTasks = new LinkedList();
                    Iterator<Object> it = QuickPrintingActivity.this.selectAdapter.getData().iterator();
                    while (it.hasNext()) {
                        QuickPrintMineLabelModel quickPrintMineLabelModel = (QuickPrintMineLabelModel) it.next();
                        if (quickPrintMineLabelModel.getType() == 1) {
                            TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, quickPrintMineLabelModel.getContent());
                            TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                            QuickPrintingActivity.this.printTasks.add(new PrintTaskBean(templatePto, new TemplateConfigBean(quickPrintMineLabelModel.getTitle(), quickPrintMineLabelModel.getWidth(), quickPrintMineLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), String.valueOf(quickPrintMineLabelModel.getId()), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate()), quickPrintMineLabelModel.getPrintCount()));
                            DataCreateUtil.getFontList(arrayList, templatePto.getViews());
                        } else {
                            Bitmap bitmapFromUrl = QuickPrintingActivity.this.getBitmapFromUrl(quickPrintMineLabelModel.getCoverUrl());
                            if (bitmapFromUrl != null) {
                                QuickPrintingActivity.this.printTasks.add(new PrintTaskBean(bitmapFromUrl, quickPrintMineLabelModel.getPrintCount()));
                            }
                        }
                    }
                    p051j0.a.d(((BaseActivity) QuickPrintingActivity.this).TAG, "字体列表=" + Arrays.toString(arrayList.toArray()));
                    QuickPrintingActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.f(QuickPrintingActivity.this.getString(p113u.g.text_263));
                        }
                    });
                    if (!DataCreateUtil.downloadFont(arrayList)) {
                        QuickPrintingActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.quickprinting.QuickPrintingActivity.6.2
                            @Override // java.lang.Runnable
                            public void run() {
                                w.c();
                                p042h2.d.show(p113u.g.toast_12);
                            }
                        });
                        return;
                    }
                    PrintTaskBean printTaskBean = (PrintTaskBean) QuickPrintingActivity.this.printTasks.poll();
                    if (printTaskBean != null) {
                        QuickPrintingActivity.this.preShowLabel(printTaskBean);
                    }
                }
            });
        }
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.currentLabelWidth == null && this.currentLabelHeight == null) {
            return;
        }
        this.srlMineLabel.h();
    }

    public void onShowMoreClick(View view) {
        this.isShowMore = !this.isShowMore;
        refreshShowMore();
    }

    @Override // T.d
    public void printPersonalBiaoqianSuccess() {
    }

    @Override // T.d
    public void printPersonalBiaoqianFailed(int i5, String str) {
    }
}
