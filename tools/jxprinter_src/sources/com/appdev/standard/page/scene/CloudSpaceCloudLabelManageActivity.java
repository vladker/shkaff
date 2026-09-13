package com.appdev.standard.page.scene;

import X.i;
import X.j;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.CloudHeaderModel;
import com.appdev.standard.model.CloudSpaceCloudLabelModel;
import com.appdev.standard.model.PrintLabelModel;
import com.appdev.standard.model.PrintTaskBean;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.widget.AutoNullDisplayView;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import kotlin.jvm.internal.Y;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p050j.w;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CLOUD_SPACE_CLOUD_LABEL_MANAGE)
public class CloudSpaceCloudLabelManageActivity extends MvpActivity implements X.f, X.d, i {

    @BindView(4868)
    AutoNullDisplayView audvCloudSpaceCloudLabelManageCloudLabel;
    private X.e cloudHeaderWorker;
    private X.h cloudSpaceCloudLabelWorker;
    private Context context;
    private DefaultTipDialog defaultTipDialog;
    private j deleteCloudSpaceCloudLabelWorker;

    @BindView(5107)
    FrameLayout flTemplatePageView;

    @BindView(5206)
    ImageView ivCloudSpaceCloudLabelManageSelect;

    @BindView(5360)
    LinearLayout llCloudSpaceCloudLabelManageRootView;

    @BindView(5416)
    LinearLayout llManageDelete;

    @BindView(5511)
    LinearLayout llView;
    private C0451d mCustomPopWindow;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5817)
    RecyclerView rvCloudSpaceCloudLabelManageCloudLabel;

    @BindView(5923)
    SmartRefreshLayout srlCloudSpaceCloudLabelManageCloudLabel;

    @BindView(6045)
    TextView tvCloudSpaceCloudLabelManageNumber;

    @BindView(6046)
    TextView tvCloudSpaceCloudLabelManageSelect;

    @BindView(6047)
    TextView tvCloudSpaceCloudLabelManageTeamNumber;

    @BindView(6274)
    TextView tvTitle;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private Queue<PrintTaskBean> printTasks = null;
    private com.library.base.util.recyclerview.f printLabelModelQuickAdapter = null;

    /* JADX INFO: renamed from: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity$8, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass8 implements Runnable {
        final /* synthetic */ PrintTaskBean val$printTask;

        public AnonymousClass8(PrintTaskBean printTaskBean) {
            this.val$printTask = printTaskBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            final TemplateConfigBean templateConfig = this.val$printTask.getTemplateConfig();
            String strE = p052j2.c.e(this.val$printTask.getTemplatePto().getViews());
            final TemplatePageView templatePageView = (TemplatePageView) LayoutInflater.from(CloudSpaceCloudLabelManageActivity.this.context).inflate(p113u.e.main_template_page_view, (ViewGroup) null);
            CloudSpaceCloudLabelManageActivity.this.flTemplatePageView.addView(templatePageView);
            if (templateConfig != null) {
                templatePageView.setLabelSize(templateConfig.getWidth(), templateConfig.getHeight());
                templatePageView.setPrinterLabelBgUrl(templateConfig.getPrinterLabelBgUrl());
                if (!Y.f(strE)) {
                    templatePageView.setWantCreateElementsByString(strE);
                }
            }
            templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.8.1
                @Override // java.lang.Runnable
                public void run() {
                    templatePageView.load();
                    templatePageView.postDelayed(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.8.1.1
                        @Override // java.lang.Runnable
                        public void run() throws Throwable {
                            if (!templatePageView.isRenderingCompleted()) {
                                p051j0.a.d(((BaseActivity) CloudSpaceCloudLabelManageActivity.this).TAG, "渲染未完成");
                                templatePageView.postDelayed(this, 1000L);
                                return;
                            }
                            p051j0.a.d(((BaseActivity) CloudSpaceCloudLabelManageActivity.this).TAG, "渲染完成");
                            w.f(CloudSpaceCloudLabelManageActivity.this.getString(p113u.g.text_263));
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            CloudSpaceCloudLabelManageActivity.this.startPrintLabel(templateConfig, anonymousClass8.val$printTask.getPageCount(), templatePageView);
                        }
                    }, 1000L);
                }
            }, 1000L);
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity$9, reason: invalid class name */
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
        public static /* synthetic */ void lambda$run$1() {
            w.c();
            p042h2.d.show(p113u.g.toast_63);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2() {
            PrintTaskBean printTaskBean = (PrintTaskBean) CloudSpaceCloudLabelManageActivity.this.printTasks.poll();
            if (printTaskBean != null) {
                CloudSpaceCloudLabelManageActivity.this.preShowLabel(printTaskBean);
            } else {
                w.c();
                p042h2.d.show(p113u.g.toast_62);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$3() {
            w.c();
            p042h2.d.show(p113u.g.toast_63);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$4(byte[] bArr) {
            if (bArr.length == 0) {
                CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new c(0));
                return;
            }
            K0 printer = p051j0.f.getPrinter();
            if (printer == null) {
                CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new c(1));
            } else if (printer.sendSync(bArr, null).b()) {
                CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new f(this, 4));
            } else {
                CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new c(2));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DataCreateUtil.create(this.val$printInfo, this.val$templatePageView, this.val$templateConfig, this.val$direction, false, this.val$printCount, new DataCreateUtil.CreateBitmapEventListener() { // from class: com.appdev.standard.page.scene.b
                @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.CreateBitmapEventListener
                public final void onComplete(byte[] bArr) {
                    this.f2829a.lambda$run$4(bArr);
                }
            });
        }
    }

    private List<CloudSpaceCloudLabelModel> getSelectBiaoQianCloudIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel = (CloudSpaceCloudLabelModel) it.next();
            if (cloudSpaceCloudLabelModel.isSelect()) {
                arrayList.add(cloudSpaceCloudLabelModel);
            }
        }
        return arrayList;
    }

    private void handleLogic(View view) {
        TextView textView = (TextView) view.findViewById(p113u.d.tv_pop_batch_print_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(p113u.d.rv_pop_batch_print_data);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.ll_pop_batch_print_dismiss);
        TextView textView2 = (TextView) view.findViewById(p113u.d.tv_pop_batch_print_print);
        this.printLabelModelQuickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_pop_batch_print_data) { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.4
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final PrintLabelModel printLabelModel) {
                aVar.b(p113u.d.tv_item_pop_batch_print_data_title, printLabelModel.getTitle());
                aVar.b(p113u.d.tv_item_pop_batch_print_data_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(printLabelModel.getWidth()), Integer.valueOf(printLabelModel.getHeight())));
                p047i2.a.a((ImageView) aVar.a(p113u.d.iv_item_pop_batch_print_data_img), printLabelModel.getCoverUrl());
                QuantitySelectorWidget quantitySelectorWidget = (QuantitySelectorWidget) aVar.a(p113u.d.qsw_item_pop_batch_print_data_number_of_print);
                quantitySelectorWidget.setOffsetValue(printLabelModel.getNumberOfPrint());
                quantitySelectorWidget.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.4.1
                    @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
                    public void onValue(int i5) {
                        printLabelModel.setNumberOfPrint(i5);
                    }
                });
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.printLabelModelQuickAdapter);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CloudSpaceCloudLabelManageActivity.this.mCustomPopWindow != null) {
                    CloudSpaceCloudLabelManageActivity.this.mCustomPopWindow.a();
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CloudSpaceCloudLabelManageActivity.this.startBatchPrint();
            }
        });
        List<CloudSpaceCloudLabelModel> selectBiaoQianCloudIds = getSelectBiaoQianCloudIds();
        Iterator<CloudSpaceCloudLabelModel> it = selectBiaoQianCloudIds.iterator();
        while (it.hasNext()) {
            PrintLabelModel printLabelModel = (PrintLabelModel) p052j2.c.d(it.next(), PrintLabelModel.class);
            if (printLabelModel != null) {
                this.printLabelModelQuickAdapter.add(printLabelModel);
            }
        }
        textView.setText(String.format(getString(p113u.g.text_281), Integer.valueOf(selectBiaoQianCloudIds.size())));
        textView2.setText(String.format(getString(p113u.g.text_7), Integer.valueOf(selectBiaoQianCloudIds.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAllSelect() {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (!((CloudSpaceCloudLabelModel) it.next()).isSelect()) {
                this.ivCloudSpaceCloudLabelManageSelect.setImageResource(p113u.f.ic_common_check_select_not);
                return false;
            }
        }
        this.ivCloudSpaceCloudLabelManageSelect.setImageResource(p113u.f.ic_common_check_select);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void preShowLabel(PrintTaskBean printTaskBean) {
        runOnUiThread(new AnonymousClass8(printTaskBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectCount() {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (((CloudSpaceCloudLabelModel) it.next()).isSelect()) {
                i5++;
            }
        }
        this.tvTitle.setText(i5 == 0 ? getString(p113u.g.text_2) : String.format(getString(p113u.g.text_281), Integer.valueOf(i5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBatchPrint() {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        } else {
            w.f(getString(p113u.g.text_263));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    CloudSpaceCloudLabelManageActivity.this.printTasks = new LinkedList();
                    Iterator<Object> it = CloudSpaceCloudLabelManageActivity.this.printLabelModelQuickAdapter.getData().iterator();
                    while (it.hasNext()) {
                        PrintLabelModel printLabelModel = (PrintLabelModel) it.next();
                        TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, printLabelModel.getContent());
                        TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                        CloudSpaceCloudLabelManageActivity.this.printTasks.add(new PrintTaskBean(templatePto, new TemplateConfigBean(printLabelModel.getTitle(), printLabelModel.getWidth(), printLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), "0", templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate()), printLabelModel.getNumberOfPrint()));
                        DataCreateUtil.getFontList(arrayList, templatePto.getViews());
                    }
                    p051j0.a.d(((BaseActivity) CloudSpaceCloudLabelManageActivity.this).TAG, "字体列表=" + Arrays.toString(arrayList.toArray()));
                    CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            w.f(CloudSpaceCloudLabelManageActivity.this.getString(p113u.g.text_263));
                        }
                    });
                    if (!DataCreateUtil.downloadFont(arrayList)) {
                        CloudSpaceCloudLabelManageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.7.2
                            @Override // java.lang.Runnable
                            public void run() {
                                w.c();
                                p042h2.d.show(p113u.g.toast_12);
                            }
                        });
                        return;
                    }
                    PrintTaskBean printTaskBean = (PrintTaskBean) CloudSpaceCloudLabelManageActivity.this.printTasks.poll();
                    if (printTaskBean != null) {
                        CloudSpaceCloudLabelManageActivity.this.preShowLabel(printTaskBean);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    public synchronized void startPrintLabel(TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) throws Throwable {
        Throwable th;
        try {
            try {
                P0 p0H = p051j0.a.h();
                C1849c.getScale();
                if (p0H == null) {
                    w.c();
                    p042h2.d.show(p113u.g.toast_13);
                } else {
                    if (!"01".equals(p0H.getCmdMode())) {
                        try {
                            if (!"02".equals(p0H.getCmdMode())) {
                                w.c();
                                p042h2.d.show(p113u.g.toast_13);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    }
                    w.f(getString(p113u.g.text_263));
                    runOnNewThread(new AnonymousClass9(p0H, templatePageView, templateConfigBean, 0, i5));
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

    @Override // X.d
    public void cloudHeaderFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // X.d
    public void cloudHeaderSuccess(CloudHeaderModel cloudHeaderModel) {
        w.c();
        this.tvCloudSpaceCloudLabelManageNumber.setText(cloudHeaderModel.getUsedCloudTagsNumber() + PackagingURIHelper.FORWARD_SLASH_STRING + cloudHeaderModel.getCloudTagsNumber());
        this.tvCloudSpaceCloudLabelManageTeamNumber.setText(cloudHeaderModel.getMemberNumNow() + PackagingURIHelper.FORWARD_SLASH_STRING + cloudHeaderModel.getMemberNumber());
    }

    @Override // X.f
    public void cloudSpaceCloudLabelListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlCloudSpaceCloudLabelManageCloudLabel.k();
        this.srlCloudSpaceCloudLabelManageCloudLabel.i();
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // X.f
    public void cloudSpaceCloudLabelListSuccess(List<CloudSpaceCloudLabelModel> list, int i5) {
        this.srlCloudSpaceCloudLabelManageCloudLabel.k();
        this.srlCloudSpaceCloudLabelManageCloudLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
        isAllSelect();
        selectCount();
    }

    @Override // X.i
    public void deleteCloudSpaceFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // X.i
    public void deleteCloudSpaceSuccess() {
        w.c();
        this.cloudHeaderWorker.a();
        this.srlCloudSpaceCloudLabelManageCloudLabel.h();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        X.h hVar = new X.h(this);
        this.cloudSpaceCloudLabelWorker = hVar;
        addPresenter(hVar);
        X.e eVar = new X.e(this);
        this.cloudHeaderWorker = eVar;
        addPresenter(eVar);
        j jVar = new j(this);
        this.deleteCloudSpaceCloudLabelWorker = jVar;
        addPresenter(jVar);
        this.context = this;
        w.e();
        this.cloudHeaderWorker.a();
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_activity_cloud_space_cloud_label) { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel) {
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_title, cloudSpaceCloudLabelModel.getTitle());
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(cloudSpaceCloudLabelModel.getWidth()), Integer.valueOf(cloudSpaceCloudLabelModel.getHeight())));
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_cloud_space_cloud_label_update_by);
                textView.setText(String.format(CloudSpaceCloudLabelManageActivity.this.getString(p113u.g.text_280), cloudSpaceCloudLabelModel.getUpdateBy()));
                if (Y.f(cloudSpaceCloudLabelModel.getUpdateBy())) {
                    textView.setVisibility(4);
                }
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_create_time, "创建时间：" + com.bumptech.glide.h.a(cloudSpaceCloudLabelModel.getCreateTime(), "yyyy.MM.dd"));
                p047i2.a.a((ImageView) aVar.a(p113u.d.iv_item_fragment_cloud_space_cloud_label_img), cloudSpaceCloudLabelModel.getCoverUrl());
                final ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_fragment_cloud_space_cloud_label_check);
                imageView.setImageResource(cloudSpaceCloudLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel2 = cloudSpaceCloudLabelModel;
                        cloudSpaceCloudLabelModel2.setSelect(!cloudSpaceCloudLabelModel2.isSelect());
                        imageView.setImageResource(cloudSpaceCloudLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                        notifyDataSetChanged();
                        CloudSpaceCloudLabelManageActivity.this.isAllSelect();
                        CloudSpaceCloudLabelManageActivity.this.selectCount();
                    }
                });
            }
        };
        this.rvCloudSpaceCloudLabelManageCloudLabel.setLayoutManager(new LinearLayoutManager(this));
        this.rvCloudSpaceCloudLabelManageCloudLabel.setAdapter(this.quickAdapter);
        this.audvCloudSpaceCloudLabelManageCloudLabel.b(p113u.f.ic_label_no_data);
        this.audvCloudSpaceCloudLabelManageCloudLabel.setConnect(getString(p113u.g.text_282));
        this.audvCloudSpaceCloudLabelManageCloudLabel.setButtonWhetherVisible(false);
        this.srlCloudSpaceCloudLabelManageCloudLabel.h();
        S4.h hVar2 = p042h2.e.f4031a;
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        hVar2.b = aVar;
        if (aVar != null && aVar.f3967k == 1) {
            this.llManageDelete.setVisibility(0);
        } else {
            this.llManageDelete.setVisibility(4);
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.srlCloudSpaceCloudLabelManageCloudLabel.s(new L2.f() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                CloudSpaceCloudLabelManageActivity.this.isLoadMore = true;
                if (CloudSpaceCloudLabelManageActivity.this.pageNum == CloudSpaceCloudLabelManageActivity.this.totalPageNo) {
                    CloudSpaceCloudLabelManageActivity.this.srlCloudSpaceCloudLabelManageCloudLabel.r(true);
                    return;
                }
                CloudSpaceCloudLabelManageActivity.this.pageNum++;
                CloudSpaceCloudLabelManageActivity.this.cloudSpaceCloudLabelWorker.a(CloudSpaceCloudLabelManageActivity.this.pageNum);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                CloudSpaceCloudLabelManageActivity.this.isLoadMore = false;
                CloudSpaceCloudLabelManageActivity.this.srlCloudSpaceCloudLabelManageCloudLabel.r(false);
                CloudSpaceCloudLabelManageActivity.this.pageNum = 1;
                CloudSpaceCloudLabelManageActivity.this.cloudSpaceCloudLabelWorker.a(CloudSpaceCloudLabelManageActivity.this.pageNum);
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_cloud_space_cloud_label_manage;
    }

    public void onCloudLabelManageDeleteClick(View view) {
        List<CloudSpaceCloudLabelModel> selectBiaoQianCloudIds = getSelectBiaoQianCloudIds();
        final ArrayList arrayList = new ArrayList();
        Iterator<CloudSpaceCloudLabelModel> it = selectBiaoQianCloudIds.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getBiaoqianCloudId());
        }
        if (arrayList.size() != 0) {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
            this.defaultTipDialog = defaultTipDialog;
            defaultTipDialog.e("");
            defaultTipDialog.c(String.format(getString(p113u.g.text_251), Integer.valueOf(arrayList.size())));
            this.defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelManageActivity.3
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    w.e();
                    CloudSpaceCloudLabelManageActivity.this.deleteCloudSpaceCloudLabelWorker.a(arrayList);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            this.defaultTipDialog.show();
        }
    }

    public void onCloudLabelManagePrinterClick(View view) {
        if (getSelectBiaoQianCloudIds().size() != 0) {
            View viewInflate = LayoutInflater.from(this).inflate(p113u.e.pop_batch_print, (ViewGroup) null);
            handleLogic(viewInflate);
            C0450c c0450c = new C0450c(this);
            c0450c.f2639a.e = viewInflate;
            c0450c.b(p035f5.b.d(380.0f));
            C0451d c0451d = c0450c.f2639a;
            c0451d.d = true;
            c0451d.f2643h = true;
            C0451d c0451dA = c0450c.a();
            c0451dA.b(this.srlCloudSpaceCloudLabelManageCloudLabel);
            this.mCustomPopWindow = c0451dA;
        }
    }

    public void onCloudLabelManageSelectClick(View view) {
        if (isAllSelect()) {
            Iterator<Object> it = this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                ((CloudSpaceCloudLabelModel) it.next()).setSelect(false);
            }
        } else {
            Iterator<Object> it2 = this.quickAdapter.getData().iterator();
            while (it2.hasNext()) {
                ((CloudSpaceCloudLabelModel) it2.next()).setSelect(true);
            }
        }
        this.quickAdapter.notifyDataSetChanged();
        isAllSelect();
        selectCount();
    }
}
