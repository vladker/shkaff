package com.appdev.standard.page.scene;

import S4.k;
import X.i;
import X.j;
import X.m;
import X.n;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MainApi;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.api.pto.UpdateBqClouldPto;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultEdittextDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.G;
import com.appdev.standard.dialog.InterfaceC0455h;
import com.appdev.standard.dialog.ShareDialog;
import com.appdev.standard.model.CloudSpaceCloudLabelModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.google.common.net.HttpHeaders;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.videoio.Videoio;
import p050j.w;
import p137y.o;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CloudSpaceCloudLabelFragment extends com.library.base.frame.f implements X.f, m, i {

    @BindView(4870)
    AutoNullDisplayView audvFragmentCloudSpaceCloudLabel;

    @BindView(5103)
    FrameLayout flRoot;
    private C0451d mCustomPopWindow;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5824)
    RecyclerView rvFragmentCloudSpaceCloudLabel;

    @BindView(5925)
    SmartRefreshLayout srlFragmentCloudSpaceCloudLabel;
    private boolean isManageMode = false;
    private X.h cloudSpaceCloudLabelWorker = null;
    private j deleteCloudSpaceCloudLabelWorker = null;
    private n editCloudLabelNameWorker = null;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;

    /* JADX INFO: renamed from: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ CloudSpaceCloudLabelModel val$item;

        public AnonymousClass4(CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel) {
            this.val$item = cloudSpaceCloudLabelModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CloudSpaceCloudLabelFragment.this.mCustomPopWindow.a();
            ShareDialog shareDialog = new ShareDialog(CloudSpaceCloudLabelFragment.this.getContext());
            shareDialog.f2629a = new G() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.4.1
                @Override // com.appdev.standard.dialog.G
                public void onSelect(String str) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    final String string = CloudSpaceCloudLabelFragment.this.getString(p113u.g.share_cloud_content_format, anonymousClass4.val$item.getTitle(), Integer.valueOf(AnonymousClass4.this.val$item.getWidth()), Integer.valueOf(AnonymousClass4.this.val$item.getHeight()), AnonymousClass4.this.val$item.getBiaoqianCloudId());
                    if ("WeChat".equals(str)) {
                        if (CloudSpaceCloudLabelFragment.this.getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm") == null) {
                            p042h2.d.show(p113u.g.toast_6);
                            return;
                        }
                        OnekeyShare onekeyShare = new OnekeyShare();
                        onekeyShare.setPlatform(Wechat.NAME);
                        onekeyShare.setText(string);
                        onekeyShare.setCallback(new PlatformActionListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.4.1.1
                            @Override // cn.sharesdk.framework.PlatformActionListener
                            public void onCancel(Platform platform, int i5) {
                            }

                            @Override // cn.sharesdk.framework.PlatformActionListener
                            public void onComplete(Platform platform, int i5, HashMap<String, Object> map) {
                            }

                            @Override // cn.sharesdk.framework.PlatformActionListener
                            public void onError(Platform platform, int i5, Throwable th) {
                            }
                        });
                        onekeyShare.show(MobSDK.getContext());
                        return;
                    }
                    if (HttpHeaders.LINK.equals(str)) {
                        if (((Boolean) Hawk.get("clipboard_permissions_yunBiao", Boolean.FALSE)).booleanValue()) {
                            ((ClipboardManager) CloudSpaceCloudLabelFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                            p042h2.d.show(p113u.g.toast_23);
                            return;
                        }
                        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(CloudSpaceCloudLabelFragment.this.getContext());
                        defaultTipDialog.e(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_124));
                        defaultTipDialog.b(CloudSpaceCloudLabelFragment.this.getString(p113u.g.confirm));
                        defaultTipDialog.c(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_321));
                        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.4.1.2
                            @Override // com.library.base.frame.d
                            public void onConfirm() {
                                Hawk.put("clipboard_permissions_yunBiao", Boolean.TRUE);
                                ((ClipboardManager) CloudSpaceCloudLabelFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                                p042h2.d.show(p113u.g.toast_23);
                            }

                            @Override // com.library.base.frame.d
                            public void onCancel() {
                            }
                        };
                        defaultTipDialog.show();
                    }
                }

                @Override // com.appdev.standard.dialog.G
                public void onCancel() {
                }
            };
            shareDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogic(View view, final CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel) {
        ImageView imageView = (ImageView) view.findViewById(p113u.d.iv_pop_index_fragment_label_img);
        final TextView textView = (TextView) view.findViewById(p113u.d.tv_pop_index_fragment_label_title);
        TextView textView2 = (TextView) view.findViewById(p113u.d.tv_pop_index_fragment_label_specification);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_share);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_rename);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_delete);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(p113u.d.ll_all_delete);
        p047i2.a.a(imageView, cloudSpaceCloudLabelModel.getCoverUrl());
        textView.setText(cloudSpaceCloudLabelModel.getTitle());
        textView2.setText(String.format("%d*%d (W*H)", Integer.valueOf(cloudSpaceCloudLabelModel.getWidth()), Integer.valueOf(cloudSpaceCloudLabelModel.getHeight())));
        linearLayout.setOnClickListener(new AnonymousClass4(cloudSpaceCloudLabelModel));
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                CloudSpaceCloudLabelFragment.this.mCustomPopWindow.a();
                DefaultEdittextDialog defaultEdittextDialog = new DefaultEdittextDialog(CloudSpaceCloudLabelFragment.this.getContext());
                defaultEdittextDialog.e(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_242));
                defaultEdittextDialog.d(CloudSpaceCloudLabelFragment.this.getResources().getString(p113u.g.hint_8));
                defaultEdittextDialog.f2607a = new InterfaceC0455h() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.5.1
                    @Override // com.appdev.standard.dialog.InterfaceC0455h
                    public void onConfirm(String str) {
                        if (Y.f(str)) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            cloudSpaceCloudLabelModel.setTitle(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_400));
                        } else {
                            cloudSpaceCloudLabelModel.setTitle(str);
                        }
                        AnonymousClass5 anonymousClass6 = AnonymousClass5.this;
                        textView.setText(cloudSpaceCloudLabelModel.getTitle());
                        CloudSpaceCloudLabelFragment.this.quickAdapter.notifyDataSetChanged();
                        w.e();
                        n nVar = CloudSpaceCloudLabelFragment.this.editCloudLabelNameWorker;
                        String biaoqianCloudId = cloudSpaceCloudLabelModel.getBiaoqianCloudId();
                        String title = cloudSpaceCloudLabelModel.getTitle();
                        nVar.getClass();
                        nVar.d.updateBqClould(new UpdateBqClouldPto(biaoqianCloudId, title)).b(new A.c(nVar, 28));
                    }

                    @Override // com.appdev.standard.dialog.InterfaceC0455h
                    public void onCancel() {
                    }
                };
                defaultEdittextDialog.show();
            }
        });
        S4.h hVar = p042h2.e.f4031a;
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        hVar.b = aVar;
        if (aVar == null || aVar.f3967k != 1) {
            linearLayout4.setVisibility(8);
        } else {
            linearLayout4.setVisibility(0);
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    CloudSpaceCloudLabelFragment.this.mCustomPopWindow.a();
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(CloudSpaceCloudLabelFragment.this.getContext());
                    defaultTipDialog.e(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_124));
                    defaultTipDialog.c(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_247));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.6.1
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(cloudSpaceCloudLabelModel.getBiaoqianCloudId());
                            w.e();
                            CloudSpaceCloudLabelFragment.this.deleteCloudSpaceCloudLabelWorker.a(arrayList);
                        }

                        @Override // com.library.base.frame.d
                        public void onCancel() {
                        }
                    };
                    defaultTipDialog.show();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$setAllItemsSelected$0(boolean z6) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((CloudSpaceCloudLabelModel) it.next()).setSelect(z6);
        }
        this.quickAdapter.notifyDataSetChanged();
        S4.d.b().f(new p137y.c());
    }

    @Override // X.f
    public void cloudSpaceCloudLabelListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentCloudSpaceCloudLabel.k();
        this.srlFragmentCloudSpaceCloudLabel.i();
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // X.f
    public void cloudSpaceCloudLabelListSuccess(List<CloudSpaceCloudLabelModel> list, int i5) {
        Iterator<CloudSpaceCloudLabelModel> it = list.iterator();
        while (it.hasNext()) {
            it.next().setSelect(false);
        }
        S4.d.b().f(new p137y.c());
        this.srlFragmentCloudSpaceCloudLabel.k();
        this.srlFragmentCloudSpaceCloudLabel.i();
        setAllItemsSelected(false);
        S4.d.b().f(new p137y.c());
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
    }

    @Override // X.i
    public void deleteCloudSpaceFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.i
    public void deleteCloudSpaceSuccess() {
        w.c();
        p042h2.d.show(p113u.g.toast_39);
        this.srlFragmentCloudSpaceCloudLabel.h();
        S4.d.b().f(new p137y.e());
        setAllItemsSelected(false);
        S4.d.b().f(new p137y.c());
    }

    @Override // X.m
    public void editCloudLabelNameFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // X.m
    public void editCloudLabelNameSuccess() {
        w.c();
        p042h2.d.show(p113u.g.toast_68);
    }

    public void executeDelete(List<String> list) {
        w.e();
        this.deleteCloudSpaceCloudLabelWorker.a(list);
    }

    public List<String> getSelectedCloudLabelIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel = (CloudSpaceCloudLabelModel) it.next();
            if (cloudSpaceCloudLabelModel.isSelect()) {
                arrayList.add(cloudSpaceCloudLabelModel.getBiaoqianCloudId());
            }
        }
        return arrayList;
    }

    public List<CloudSpaceCloudLabelModel> getSelectedCloudLabels() {
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

    @Override // com.library.base.frame.e
    public void initComponent() {
        X.h hVar = new X.h(getContext());
        this.cloudSpaceCloudLabelWorker = hVar;
        addPresenter(hVar);
        n nVar = new n(getContext());
        nVar.d = (MainApi) Http.createApi(MainApi.class);
        this.editCloudLabelNameWorker = nVar;
        addPresenter(nVar);
        j jVar = new j(getContext());
        this.deleteCloudSpaceCloudLabelWorker = jVar;
        addPresenter(jVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_cloud_space_cloud_label) { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel) {
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_title, cloudSpaceCloudLabelModel.getTitle());
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(cloudSpaceCloudLabelModel.getWidth()), Integer.valueOf(cloudSpaceCloudLabelModel.getHeight())));
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_cloud_space_cloud_label_update_by);
                textView.setText(String.format(CloudSpaceCloudLabelFragment.this.getString(p113u.g.text_280), cloudSpaceCloudLabelModel.getUpdateBy()));
                if (Y.f(cloudSpaceCloudLabelModel.getUpdateBy())) {
                    textView.setVisibility(4);
                }
                aVar.b(p113u.d.tv_item_fragment_cloud_space_cloud_label_create_time, "创建时间：" + com.bumptech.glide.h.a(cloudSpaceCloudLabelModel.getCreateTime(), "yyyy.MM.dd"));
                p047i2.a.b(cloudSpaceCloudLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_item_fragment_cloud_space_cloud_label_img), p113u.f.ic_default_error_label_1);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_label_more);
                final ImageView imageView2 = (ImageView) aVar.a(p113u.d.iv_item_fragment_cloud_space_cloud_label_check);
                imageView.setVisibility(CloudSpaceCloudLabelFragment.this.isManageMode ? 8 : 0);
                imageView2.setVisibility(CloudSpaceCloudLabelFragment.this.isManageMode ? 0 : 8);
                imageView2.setImageResource(cloudSpaceCloudLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        View viewInflate = LayoutInflater.from(CloudSpaceCloudLabelFragment.this.getContext()).inflate(p113u.e.pop_index_fragment_label, (ViewGroup) null);
                        CloudSpaceCloudLabelFragment.this.handleLogic(viewInflate, cloudSpaceCloudLabelModel);
                        CloudSpaceCloudLabelFragment cloudSpaceCloudLabelFragment = CloudSpaceCloudLabelFragment.this;
                        C0450c c0450c = new C0450c(cloudSpaceCloudLabelFragment.getContext());
                        c0450c.f2639a.e = viewInflate;
                        c0450c.b(-2);
                        C0451d c0451d = c0450c.f2639a;
                        c0451d.d = true;
                        c0451d.f2643h = true;
                        C0451d c0451dA = c0450c.a();
                        c0451dA.b(CloudSpaceCloudLabelFragment.this.flRoot);
                        cloudSpaceCloudLabelFragment.mCustomPopWindow = c0451dA;
                    }
                });
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        CloudSpaceCloudLabelModel cloudSpaceCloudLabelModel2 = cloudSpaceCloudLabelModel;
                        cloudSpaceCloudLabelModel2.setSelect(!cloudSpaceCloudLabelModel2.isSelect());
                        imageView2.setImageResource(cloudSpaceCloudLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                        notifyDataSetChanged();
                        S4.d.b().f(new p137y.c());
                    }
                });
            }
        };
        this.rvFragmentCloudSpaceCloudLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentCloudSpaceCloudLabel.setAdapter(this.quickAdapter);
        this.audvFragmentCloudSpaceCloudLabel.b(p113u.f.ic_label_no_data);
        this.audvFragmentCloudSpaceCloudLabel.setConnect(getString(p113u.g.text_282));
        this.audvFragmentCloudSpaceCloudLabel.setButtonWhetherVisible(false);
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentCloudSpaceCloudLabel.s(new L2.f() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                CloudSpaceCloudLabelFragment.this.isLoadMore = true;
                if (CloudSpaceCloudLabelFragment.this.pageNum == CloudSpaceCloudLabelFragment.this.totalPageNo) {
                    CloudSpaceCloudLabelFragment.this.srlFragmentCloudSpaceCloudLabel.r(true);
                    return;
                }
                CloudSpaceCloudLabelFragment.this.pageNum++;
                CloudSpaceCloudLabelFragment.this.cloudSpaceCloudLabelWorker.a(CloudSpaceCloudLabelFragment.this.pageNum);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                CloudSpaceCloudLabelFragment.this.isLoadMore = false;
                CloudSpaceCloudLabelFragment.this.srlFragmentCloudSpaceCloudLabel.r(false);
                CloudSpaceCloudLabelFragment.this.pageNum = 1;
                CloudSpaceCloudLabelFragment.this.cloudSpaceCloudLabelWorker.a(CloudSpaceCloudLabelFragment.this.pageNum);
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.CloudSpaceCloudLabelFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getTitle(), ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getWidth(), ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), null, templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data_template_config", templateConfigBean);
                bundle.putString("data_template_content", p052j2.c.e(templatePto.getViews()));
                bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                bundle.putInt("data_print_data_source", 4);
                bundle.putString("data_print_cover_url", ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getCoverUrl());
                bundle.putString("data_print_title", ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getTitle());
                bundle.putString("cloudLabelId", ((CloudSpaceCloudLabelModel) CloudSpaceCloudLabelFragment.this.quickAdapter.getData().get(i5)).getBiaoqianCloudId());
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    public boolean isAllSelected() {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (!((CloudSpaceCloudLabelModel) it.next()).isSelect()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_cloud_space_cloud_label;
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (S4.d.b().e(this)) {
            S4.d.b().m(this);
        }
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onManageModeEvent(o oVar) {
        setManageMode(oVar.f9018a);
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
        this.srlFragmentCloudSpaceCloudLabel.h();
    }

    public void setAllItemsSelected(boolean z6) {
        new Handler(Looper.getMainLooper()).post(new a(0, this, z6));
    }

    public void setManageMode(boolean z6) {
        this.isManageMode = z6;
        com.library.base.util.recyclerview.f fVar = this.quickAdapter;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }
}
