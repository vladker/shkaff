package com.appdev.standard.page.scene;

import S4.k;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.android.arouter.launcher.ARouter;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Y;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.greenrobot.eventbus.ThreadMode;
import p050j.w;
import p134x2.K0;
import p134x2.P0;
import p137y.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceFragment extends com.library.base.frame.f implements X.d {
    private X.e cloudHeaderWorker;
    private Fragment currentFragment;

    @BindView(5107)
    FrameLayout flTemplatePageView;

    @BindView(5206)
    ImageView ivCloudSpaceCloudLabelManageSelect;

    @BindView(5386)
    LinearLayout llFragmentCloudSpaceCloudLabel;

    @BindView(5387)
    LinearLayout llFragmentCloudSpaceTeam;

    @BindView(5400)
    LinearLayout llFragmentLayoutBottomActionBar;
    private C0451d mCustomPopWindow;
    private String memberType;
    private com.library.base.util.recyclerview.f printLabelModelQuickAdapter;
    private Queue<PrintTaskBean> printTasks;

    @BindView(6089)
    TextView tvFragmentCloudSpaceCloudLabelContent;

    @BindView(6090)
    TextView tvFragmentCloudSpaceCloudLabelNumber;

    @BindView(6091)
    TextView tvFragmentCloudSpaceTeamContent;

    @BindView(6092)
    TextView tvFragmentCloudSpaceTeamNumber;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Fragment[] fragments = null;
    private boolean isFirstShow = true;
    private boolean isManageMode = false;

    private boolean checkCurrentFragmentSelection() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof CloudSpaceCloudLabelFragment) {
            return ((CloudSpaceCloudLabelFragment) fragment).isAllSelected();
        }
        return false;
    }

    private byte[] generatePrintData(P0 p1, TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) {
        try {
            byte[][] bArr = new byte[1][];
            CountDownLatch countDownLatch = new CountDownLatch(1);
            DataCreateUtil.create(p1, templatePageView, templateConfigBean, 0, false, i5, new F4.f(bArr, countDownLatch, 6));
            countDownLatch.await(10L, TimeUnit.SECONDS);
            return bArr[0];
        } catch (Exception e) {
            S4.d dVar = S4.d.f672q;
            p051j0.a.d("EventBus", "生成打印数据异常: " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$generatePrintData$13(byte[][] bArr, CountDownLatch countDownLatch, byte[] bArr2) {
        bArr[0] = bArr2;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(View view) {
        setAllSelection(!checkCurrentFragmentSelection());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preShowLabel$6(final TemplatePageView templatePageView, final Handler handler, final TemplateConfigBean templateConfigBean, final PrintTaskBean printTaskBean) {
        templatePageView.load();
        handler.postDelayed(new Runnable() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.5
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (!templatePageView.isRenderingCompleted()) {
                    handler.postDelayed(this, 500L);
                    return;
                }
                S4.d dVar = S4.d.f672q;
                p051j0.a.d("EventBus", "渲染完成，开始打印");
                CloudSpaceFragment.this.startPrintLabel(templateConfigBean, printTaskBean.getPageCount(), templatePageView);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preShowLabel$7(PrintTaskBean printTaskBean) {
        this.flTemplatePageView.removeAllViews();
        TemplateConfigBean templateConfig = printTaskBean.getTemplateConfig();
        String strE = p052j2.c.e(printTaskBean.getTemplatePto().getViews());
        TemplatePageView templatePageView = (TemplatePageView) LayoutInflater.from(requireContext()).inflate(p113u.e.main_template_page_view, (ViewGroup) null);
        this.flTemplatePageView.addView(templatePageView);
        if (templateConfig != null) {
            templatePageView.setLabelSize(templateConfig.getWidth(), templateConfig.getHeight());
            templatePageView.setPrinterLabelBgUrl(templateConfig.getPrinterLabelBgUrl());
            if (!Y.f(strE)) {
                templatePageView.setWantCreateElementsByString(strE);
            }
        }
        templatePageView.postDelayed(new d(this, templatePageView, new Handler(Looper.getMainLooper()), templateConfig, printTaskBean, 0), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startBatchPrint$1() {
        w.f(getString(p113u.g.text_263));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startBatchPrint$2() {
        w.c();
        p042h2.d.show(p113u.g.toast_12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$startBatchPrint$4() {
        w.c();
        p042h2.d.a("打印初始化失败");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startBatchPrint$5() {
        int i5 = 3;
        try {
            ArrayList arrayList = new ArrayList();
            this.printTasks = new LinkedList();
            Iterator<Object> it = this.printLabelModelQuickAdapter.getData().iterator();
            while (it.hasNext()) {
                PrintLabelModel printLabelModel = (PrintLabelModel) it.next();
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, printLabelModel.getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                this.printTasks.add(new PrintTaskBean(templatePto, new TemplateConfigBean(printLabelModel.getTitle(), printLabelModel.getWidth(), printLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), "0", templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate()), printLabelModel.getNumberOfPrint()));
                DataCreateUtil.getFontList(arrayList, templatePto.getViews());
            }
            new Handler(Looper.getMainLooper()).post(new f(this, i5));
            if (!DataCreateUtil.downloadFont(arrayList)) {
                new Handler(Looper.getMainLooper()).post(new c(4));
                return;
            }
            PrintTaskBean printTaskBeanPoll = this.printTasks.poll();
            if (printTaskBeanPoll != null) {
                new Handler(Looper.getMainLooper()).post(new e(this, printTaskBeanPoll, 2));
            }
        } catch (Exception e) {
            S4.d dVar = S4.d.f672q;
            p051j0.a.d("EventBus", "批量打印初始化异常: " + e.getMessage());
            new Handler(Looper.getMainLooper()).post(new c(i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPrintLabel$10() {
        w.c();
        p042h2.d.show(p113u.g.toast_62);
        C0451d c0451d = this.mCustomPopWindow;
        if (c0451d != null) {
            c0451d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPrintLabel$11(Exception exc) {
        w.c();
        if (exc.getMessage() == null || !exc.getMessage().contains("打印机连接已断开")) {
            p042h2.d.a("打印失败: " + exc.getMessage());
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        }
        this.printTasks.clear();
        C0451d c0451d = this.mCustomPopWindow;
        if (c0451d != null) {
            c0451d.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPrintLabel$12(P0 p1, TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) {
        try {
            byte[] bArrGeneratePrintData = generatePrintData(p1, templateConfigBean, i5, templatePageView);
            if (bArrGeneratePrintData == null || bArrGeneratePrintData.length == 0) {
                throw new Exception("生成打印数据失败");
            }
            K0 printer = p051j0.f.getPrinter();
            if (printer == null || !printer.b()) {
                throw new Exception("打印机连接已断开");
            }
            if (!printer.sendSync(bArrGeneratePrintData, null).b()) {
                throw new Exception("打印指令发送失败");
            }
            S4.d dVar = S4.d.f672q;
            p051j0.a.d("EventBus", "打印成功，处理下一个任务");
            PrintTaskBean printTaskBeanPoll = this.printTasks.poll();
            if (printTaskBeanPoll != null) {
                new Handler(Looper.getMainLooper()).post(new e(this, printTaskBeanPoll, 1));
            } else {
                new Handler(Looper.getMainLooper()).post(new f(this, 2));
            }
        } catch (Exception e) {
            S4.d dVar2 = S4.d.f672q;
            p051j0.a.d("EventBus", "打印失败: " + e.getMessage());
            new Handler(Looper.getMainLooper()).post(new W2.b(this, e, 14));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startPrintLabel$8() {
        w.f(getString(p113u.g.text_263));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: preShowLabel, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public synchronized void lambda$startPrintLabel$9(PrintTaskBean printTaskBean) {
        S4.d dVar = S4.d.f672q;
        p051j0.a.d("EventBus", "准备预渲染标签：" + p052j2.c.e(printTaskBean));
        new Handler(Looper.getMainLooper()).post(new e(this, printTaskBean, 0));
    }

    private void refreshAllSelectUI() {
        this.ivCloudSpaceCloudLabelManageSelect.setImageResource(checkCurrentFragmentSelection() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
    }

    private void setAllSelection(boolean z6) {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof CloudSpaceCloudLabelFragment) {
            ((CloudSpaceCloudLabelFragment) fragment).setAllItemsSelected(z6);
        }
    }

    private void showPrintConfigDialog(View view, List<CloudSpaceCloudLabelModel> list) {
        TextView textView = (TextView) view.findViewById(p113u.d.tv_pop_batch_print_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(p113u.d.rv_pop_batch_print_data);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.ll_pop_batch_print_dismiss);
        TextView textView2 = (TextView) view.findViewById(p113u.d.tv_pop_batch_print_print);
        C0450c c0450c = new C0450c(requireContext());
        c0450c.f2639a.e = view;
        c0450c.b(p035f5.b.d(380.0f));
        C0451d c0451d = c0450c.f2639a;
        c0451d.d = true;
        c0451d.f2643h = true;
        C0451d c0451dA = c0450c.a();
        this.mCustomPopWindow = c0451dA;
        c0451dA.b(this.llFragmentLayoutBottomActionBar);
        this.printLabelModelQuickAdapter = new com.library.base.util.recyclerview.f(requireContext(), p113u.e.item_pop_batch_print_data) { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final PrintLabelModel printLabelModel) {
                aVar.b(p113u.d.tv_item_pop_batch_print_data_title, printLabelModel.getTitle());
                aVar.b(p113u.d.tv_item_pop_batch_print_data_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(printLabelModel.getWidth()), Integer.valueOf(printLabelModel.getHeight())));
                p047i2.a.a((ImageView) aVar.a(p113u.d.iv_item_pop_batch_print_data_img), printLabelModel.getCoverUrl());
                QuantitySelectorWidget quantitySelectorWidget = (QuantitySelectorWidget) aVar.a(p113u.d.qsw_item_pop_batch_print_data_number_of_print);
                if (printLabelModel.getNumberOfPrint() < 1) {
                    printLabelModel.setNumberOfPrint(1);
                }
                quantitySelectorWidget.setOffsetValue(printLabelModel.getNumberOfPrint());
                quantitySelectorWidget.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.2.1
                    @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
                    public void onValue(int i5) {
                        printLabelModel.setNumberOfPrint(i5);
                    }
                });
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.printLabelModelQuickAdapter);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (CloudSpaceFragment.this.mCustomPopWindow != null) {
                    CloudSpaceFragment.this.mCustomPopWindow.a();
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CloudSpaceFragment.this.startBatchPrint();
            }
        });
        Iterator<CloudSpaceCloudLabelModel> it = list.iterator();
        while (it.hasNext()) {
            PrintLabelModel printLabelModel = (PrintLabelModel) p052j2.c.d(it.next(), PrintLabelModel.class);
            if (printLabelModel != null) {
                this.printLabelModelQuickAdapter.add(printLabelModel);
            }
        }
        textView.setText(String.format(getString(p113u.g.text_281), Integer.valueOf(list.size())));
        textView2.setText(String.format(getString(p113u.g.text_7), Integer.valueOf(list.size())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startBatchPrint() {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        } else {
            new Thread(new f(this, 1)).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void startPrintLabel(TemplateConfigBean templateConfigBean, int i5, TemplatePageView templatePageView) throws Throwable {
        try {
            try {
                S4.d dVar = S4.d.f672q;
                p051j0.a.d("EventBus", "进入打印逻辑");
                P0 p0H = p051j0.a.h();
                K0 printer = p051j0.f.getPrinter();
                if (printer == null || !printer.b()) {
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES).navigation();
                } else {
                    new Handler(Looper.getMainLooper()).post(new f(this, 0));
                    new Thread(new g(this, p0H, templateConfigBean, i5, templatePageView)).start();
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    private void updateCloudLabelUI() {
        LinearLayout linearLayout = this.llFragmentCloudSpaceCloudLabel;
        if (linearLayout != null) {
            linearLayout.setEnabled(!this.isManageMode);
        }
    }

    private void updateTeamContentVisibility() {
        TextView textView = this.tvFragmentCloudSpaceTeamContent;
        if (textView != null) {
            textView.setVisibility(this.isManageMode ? 8 : 0);
        }
        TextView textView2 = this.tvFragmentCloudSpaceTeamNumber;
        if (textView2 != null) {
            textView2.setVisibility(this.isManageMode ? 8 : 0);
        }
        LinearLayout linearLayout = this.llFragmentLayoutBottomActionBar;
        if (linearLayout != null) {
            linearLayout.setVisibility(this.isManageMode ? 0 : 8);
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
        this.tvFragmentCloudSpaceCloudLabelNumber.setText(cloudHeaderModel.getUsedCloudTagsNumber() + PackagingURIHelper.FORWARD_SLASH_STRING + cloudHeaderModel.getCloudTagsNumber());
        this.tvFragmentCloudSpaceTeamNumber.setText(cloudHeaderModel.getMemberNumNow() + PackagingURIHelper.FORWARD_SLASH_STRING + cloudHeaderModel.getMemberNumber());
        this.memberType = cloudHeaderModel.getMemberType();
        if (this.isFirstShow) {
            onCloudSpaceCloudLabelClick();
            this.isFirstShow = false;
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        registerEventBus();
        X.e eVar = new X.e(getContext());
        this.cloudHeaderWorker = eVar;
        addPresenter(eVar);
        this.fragments = new Fragment[]{new CloudSpaceCloudLabelFragment(), new CloudSpaceMemberFragment()};
        w.e();
        this.cloudHeaderWorker.a();
        this.ivCloudSpaceCloudLabelManageSelect.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f2837a.lambda$initComponent$0(view);
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_cloud_space;
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onCheckAllSelectEvent(p137y.c cVar) {
        refreshAllSelectUI();
    }

    @OnClick({4921})
    public void onCloudLabelManageDeleteClick() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof CloudSpaceCloudLabelFragment) {
            final CloudSpaceCloudLabelFragment cloudSpaceCloudLabelFragment = (CloudSpaceCloudLabelFragment) fragment;
            final List<String> selectedCloudLabelIds = cloudSpaceCloudLabelFragment.getSelectedCloudLabelIds();
            if (selectedCloudLabelIds.isEmpty()) {
                p042h2.d.a("请选择要删除的标签");
                return;
            }
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
            defaultTipDialog.e("确认删除");
            defaultTipDialog.c("确定删除选中的" + selectedCloudLabelIds.size() + "个标签吗？");
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.CloudSpaceFragment.1
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    cloudSpaceCloudLabelFragment.executeDelete(selectedCloudLabelIds);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }
    }

    @OnClick({4931})
    public void onCloudLabelManagePrinterClick() {
        Fragment fragment = this.currentFragment;
        if (fragment instanceof CloudSpaceCloudLabelFragment) {
            List<CloudSpaceCloudLabelModel> selectedCloudLabels = ((CloudSpaceCloudLabelFragment) fragment).getSelectedCloudLabels();
            if (selectedCloudLabels.isEmpty()) {
                p042h2.d.a("请选择要打印的标签");
            } else {
                showPrintConfigDialog(LayoutInflater.from(requireContext()).inflate(p113u.e.pop_batch_print, (ViewGroup) null), selectedCloudLabels);
            }
        }
    }

    @OnClick({5386})
    public void onCloudSpaceCloudLabelClick() {
        TextView textView = this.tvFragmentCloudSpaceCloudLabelContent;
        Resources resources = getResources();
        int i5 = p113u.a.white;
        textView.setTextColor(resources.getColor(i5));
        this.tvFragmentCloudSpaceCloudLabelNumber.setTextColor(getResources().getColor(i5));
        this.llFragmentCloudSpaceCloudLabel.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        TextView textView2 = this.tvFragmentCloudSpaceTeamContent;
        Resources resources2 = getResources();
        int i6 = p113u.a.color_FFAE00;
        textView2.setTextColor(resources2.getColor(i6));
        this.tvFragmentCloudSpaceTeamNumber.setTextColor(getResources().getColor(i6));
        this.llFragmentCloudSpaceTeam.setBackground(null);
        S4.d.b().f(new p137y.d("云标签"));
        try {
            this.currentFragment = this.fragments[0];
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            int i7 = p113u.d.rl_fragment_cloud_space_view;
            Fragment fragment = this.currentFragment;
            fragmentTransactionBeginTransaction.replace(i7, fragment, fragment.getClass().getName());
            fragmentTransactionBeginTransaction.commit();
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d("DocumentFragment", "数据越界");
        }
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onCloudSpaceHeaderEvent(p137y.e eVar) {
        w.e();
        this.cloudHeaderWorker.a();
    }

    @OnClick({5387})
    public void onCloudSpaceTeamClick() {
        if (this.isManageMode) {
            return;
        }
        if (this.memberType == null) {
            p042h2.d.show(p113u.g.toast_69);
            w.e();
            this.cloudHeaderWorker.a();
            return;
        }
        TextView textView = this.tvFragmentCloudSpaceCloudLabelContent;
        Resources resources = getResources();
        int i5 = p113u.a.color_FFAE00;
        textView.setTextColor(resources.getColor(i5));
        this.tvFragmentCloudSpaceCloudLabelNumber.setTextColor(getResources().getColor(i5));
        this.llFragmentCloudSpaceCloudLabel.setBackground(null);
        TextView textView2 = this.tvFragmentCloudSpaceTeamContent;
        Resources resources2 = getResources();
        int i6 = p113u.a.white;
        textView2.setTextColor(resources2.getColor(i6));
        this.tvFragmentCloudSpaceTeamNumber.setTextColor(getResources().getColor(i6));
        this.llFragmentCloudSpaceTeam.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        if (!Y.f(this.memberType) && "1".equals(this.memberType)) {
            S4.d.b().f(new p137y.d("团队成员_管理员"));
        } else if (!Y.f(this.memberType) && ExifInterface.GPS_MEASUREMENT_2D.equals(this.memberType)) {
            S4.d.b().f(new p137y.d("团队成员_成员"));
        }
        try {
            this.currentFragment = this.fragments[1];
            Bundle bundle = new Bundle();
            bundle.putString("memberType", this.memberType);
            this.currentFragment.setArguments(bundle);
            FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
            int i7 = p113u.d.rl_fragment_cloud_space_view;
            Fragment fragment = this.currentFragment;
            fragmentTransactionBeginTransaction.replace(i7, fragment, fragment.getClass().getName());
            fragmentTransactionBeginTransaction.commit();
        } catch (ArrayIndexOutOfBoundsException unused) {
            p051j0.a.d("DocumentFragment", "数据越界");
        }
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (S4.d.b().e(this)) {
            S4.d.b().m(this);
        }
        ExecutorService executorService = this.executorService;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        this.executorService.shutdownNow();
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onManageModeEvent(o oVar) {
        this.isManageMode = oVar.f9018a;
        updateTeamContentVisibility();
        updateCloudLabelUI();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        S4.d.b().f(new p137y.d("云标签"));
    }

    @Override // com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (S4.d.b().e(this)) {
            return;
        }
        S4.d.b().j(this);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
