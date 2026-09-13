package com.appdev.standard.page.document;

import G.d;
import S4.k;
import U.e;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.DocumentApi;
import com.appdev.standard.api.ReceiptApi;
import com.appdev.standard.api.dto.AppDeleteReceiptBodyV2;
import com.appdev.standard.api.dto.DelMyDocBodyV2;
import com.appdev.standard.api.pto.TemplateElementPto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultEdittextDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.G;
import com.appdev.standard.dialog.InterfaceC0455h;
import com.appdev.standard.dialog.ShareDialog;
import com.appdev.standard.model.ElementAttributeBean;
import com.appdev.standard.model.MineLabelModel;
import com.appdev.standard.model.ReceiptModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.google.common.net.HttpHeaders;
import com.library.base.frame.f;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.Http;
import com.library.base.util.http.JsonResult;
import com.library.base.widget.AutoNullDisplayView;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.videoio.Videoio;
import p050j.w;
import p113u.g;
import p134x2.K0;
import p137y.o;
import p137y.s;
import p137y.t;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MineLabelFragment extends f implements d, G.a, p020d0.c, p009b0.a, U.c {

    @BindView(4873)
    AutoNullDisplayView audvFragmentMineLabel;
    private e deleteReceiptWorker;
    private p020d0.e editRecordNameWorker;

    @BindView(5056)
    EditText etSearch;
    private C0451d mCustomPopWindow;
    private G.c mineLabelDeleteWorker;
    private G.f mineLabelWorker;
    private p009b0.c publishTemplateWorker;
    private com.library.base.util.recyclerview.f quickAdapter;
    private ReceiptApi receiptApi;

    @BindView(5831)
    RecyclerView rvFragmentMineLabel;

    @BindView(5929)
    SmartRefreshLayout srlFragmentMineLabel;

    @BindView(6097)
    TextView tvSearch;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private boolean mIsCheckingLogin = false;
    private boolean mHasShownLogin = false;
    private boolean isManageMode = false;
    private int deletePosition = -1;
    private String currentKeyword = "";

    /* JADX INFO: renamed from: com.appdev.standard.page.document.MineLabelFragment$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements View.OnClickListener {
        final /* synthetic */ MineLabelModel val$item;

        public AnonymousClass4(MineLabelModel mineLabelModel) {
            this.val$item = mineLabelModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MineLabelFragment.this.mCustomPopWindow.a();
            ShareDialog shareDialog = new ShareDialog(MineLabelFragment.this.getContext());
            shareDialog.f2629a = new G() { // from class: com.appdev.standard.page.document.MineLabelFragment.4.1
                @Override // com.appdev.standard.dialog.G
                public void onSelect(String str) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    final String string = MineLabelFragment.this.getString(g.share_content_format, anonymousClass4.val$item.getTitle(), Integer.valueOf(AnonymousClass4.this.val$item.getWidth()), Integer.valueOf(AnonymousClass4.this.val$item.getHeight()), String.valueOf(AnonymousClass4.this.val$item.getId()));
                    if ("WeChat".equals(str)) {
                        if (MineLabelFragment.this.getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm") == null) {
                            p042h2.d.show(g.toast_6);
                            return;
                        }
                        OnekeyShare onekeyShare = new OnekeyShare();
                        onekeyShare.setPlatform(Wechat.NAME);
                        onekeyShare.setText(string);
                        onekeyShare.setCallback(new PlatformActionListener() { // from class: com.appdev.standard.page.document.MineLabelFragment.4.1.1
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
                            ((ClipboardManager) MineLabelFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                            p042h2.d.show(g.toast_23);
                            return;
                        }
                        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(MineLabelFragment.this.getContext());
                        defaultTipDialog.e(MineLabelFragment.this.getString(g.text_124));
                        defaultTipDialog.b(MineLabelFragment.this.getString(g.confirm));
                        defaultTipDialog.c(MineLabelFragment.this.getString(g.text_321));
                        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.MineLabelFragment.4.1.2
                            @Override // com.library.base.frame.d
                            public void onConfirm() {
                                Hawk.put("clipboard_permissions_yunBiao", Boolean.TRUE);
                                ((ClipboardManager) MineLabelFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                                p042h2.d.show(g.toast_23);
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

    /* JADX INFO: renamed from: com.appdev.standard.page.document.MineLabelFragment$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass5 implements View.OnClickListener {
        final /* synthetic */ MineLabelModel val$item;

        public AnonymousClass5(MineLabelModel mineLabelModel) {
            this.val$item = mineLabelModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MineLabelFragment.this.mCustomPopWindow.a();
            DefaultEdittextDialog defaultEdittextDialog = new DefaultEdittextDialog(MineLabelFragment.this.getContext());
            defaultEdittextDialog.e(MineLabelFragment.this.getString(g.text_242));
            defaultEdittextDialog.d(MineLabelFragment.this.getResources().getString(g.hint_8));
            defaultEdittextDialog.c(this.val$item.getTitle());
            defaultEdittextDialog.f2607a = new InterfaceC0455h() { // from class: com.appdev.standard.page.document.MineLabelFragment.5.1
                @Override // com.appdev.standard.dialog.InterfaceC0455h
                public void onConfirm(String str) {
                    if (Y.f(str)) {
                        AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                        anonymousClass5.val$item.setTitle(MineLabelFragment.this.getString(g.text_400));
                    } else {
                        AnonymousClass5.this.val$item.setTitle(str);
                    }
                    MineLabelFragment.this.quickAdapter.notifyDataSetChanged();
                    w.e();
                    if (AnonymousClass5.this.val$item.getType() != 1) {
                        ReceiptModel receiptModel = new ReceiptModel();
                        receiptModel.setReceiptId(String.valueOf(AnonymousClass5.this.val$item.getId()));
                        receiptModel.setTitle(AnonymousClass5.this.val$item.getTitle());
                        receiptModel.setContent(AnonymousClass5.this.val$item.getContent());
                        receiptModel.setCoverUrl(AnonymousClass5.this.val$item.getCoverUrl());
                        receiptModel.setWidth(AnonymousClass5.this.val$item.getWidth());
                        MineLabelFragment.this.receiptApi.addOrEditReceipt(receiptModel).b(new CallBack<JsonResult>() { // from class: com.appdev.standard.page.document.MineLabelFragment.5.1.1
                            @Override // com.library.base.util.http.CallBack
                            public void fail(int i5, String str2) {
                                w.c();
                                p042h2.d.a(str2);
                            }

                            @Override // com.library.base.util.http.CallBack
                            public void success(JsonResult jsonResult) {
                                w.c();
                                MineLabelFragment.this.srlFragmentMineLabel.h();
                            }
                        });
                        return;
                    }
                    TemplateElementPto templateElementPto = new TemplateElementPto();
                    templateElementPto.setTemplateId(String.valueOf(AnonymousClass5.this.val$item.getId()));
                    templateElementPto.setCoverUrl(AnonymousClass5.this.val$item.getCoverUrl());
                    templateElementPto.setHeight(AnonymousClass5.this.val$item.getHeight());
                    templateElementPto.setWidth(AnonymousClass5.this.val$item.getWidth());
                    templateElementPto.setTemplateType(ExifInterface.GPS_MEASUREMENT_3D);
                    templateElementPto.setTitle(AnonymousClass5.this.val$item.getTitle());
                    templateElementPto.setContent(AnonymousClass5.this.val$item.getContent());
                    MineLabelFragment.this.publishTemplateWorker.a(templateElementPto, ExifInterface.GPS_MEASUREMENT_3D);
                }

                @Override // com.appdev.standard.dialog.InterfaceC0455h
                public void onCancel() {
                }
            };
            defaultEdittextDialog.show();
        }
    }

    private void checkLoginStatus() {
        if (p042h2.e.f4031a.g()) {
            this.srlFragmentMineLabel.h();
            return;
        }
        this.mIsCheckingLogin = true;
        this.mHasShownLogin = true;
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation(getActivity(), new NavigationCallback() { // from class: com.appdev.standard.page.document.MineLabelFragment.1
            @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
            public void onArrival(Postcard postcard) {
                MineLabelFragment.this.mIsCheckingLogin = false;
            }

            @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
            public void onInterrupt(Postcard postcard) {
                MineLabelFragment.this.mIsCheckingLogin = false;
            }

            @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
            public void onLost(Postcard postcard) {
                MineLabelFragment.this.mIsCheckingLogin = false;
            }

            @Override // com.alibaba.android.arouter.facade.callback.NavigationCallback
            public void onFound(Postcard postcard) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogic(View view, final MineLabelModel mineLabelModel) {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.ll_pop_document_fragment_mine_label_print);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(p113u.d.ll_pop_document_fragment_mine_label_share);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(p113u.d.ll_pop_document_fragment_mine_label_rename);
        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(p113u.d.ll_pop_document_fragment_mine_label_delete);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.MineLabelFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MineLabelFragment.this.mCustomPopWindow.a();
                boolean z6 = mineLabelModel.getType() == 1 && MineLabelFragment.this.templateContainsTable(mineLabelModel.getContent());
                if (!p042h2.e.f4031a.h() && z6) {
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(MineLabelFragment.this.getContext());
                    defaultTipDialog.e("");
                    defaultTipDialog.c(MineLabelFragment.this.getString(g.text_249));
                    defaultTipDialog.a(MineLabelFragment.this.getString(g.text_254));
                    defaultTipDialog.b(MineLabelFragment.this.getString(g.text_255));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.MineLabelFragment.3.1
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                        }

                        @Override // com.library.base.frame.d
                        public void onCancel() {
                        }
                    };
                    defaultTipDialog.show();
                    return;
                }
                w.e();
                K0 printer = p051j0.f.getPrinter();
                if (printer == null || !printer.b()) {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
                    return;
                }
                if (mineLabelModel.getType() == 1) {
                    TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, mineLabelModel.getContent());
                    TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                    TemplateConfigBean templateConfigBean = new TemplateConfigBean(mineLabelModel.getTitle(), mineLabelModel.getWidth(), mineLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), String.valueOf(mineLabelModel.getId()), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                    S4.d dVarB = S4.d.b();
                    List<Object> views = templatePto.getViews();
                    String coverUrl = mineLabelModel.getCoverUrl();
                    String title = mineLabelModel.getTitle();
                    mineLabelModel.getId();
                    dVarB.f(new s(templateConfigBean, views, coverUrl, title, null));
                    return;
                }
                S4.d dVarB2 = S4.d.b();
                String coverUrl2 = mineLabelModel.getCoverUrl();
                String coverUrl3 = mineLabelModel.getCoverUrl();
                String title2 = mineLabelModel.getTitle();
                mineLabelModel.getId();
                s sVar = new s();
                sVar.f9022a = null;
                sVar.c = null;
                sVar.e = coverUrl2;
                sVar.b = 1;
                sVar.d = 2;
                sVar.f9023f = 3;
                sVar.f9024g = coverUrl3;
                sVar.f9025h = title2;
                sVar.f9026i = null;
                dVarB2.f(sVar);
            }
        });
        linearLayout2.setOnClickListener(new AnonymousClass4(mineLabelModel));
        linearLayout3.setOnClickListener(new AnonymousClass5(mineLabelModel));
        linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.MineLabelFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MineLabelFragment.this.mCustomPopWindow.a();
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(MineLabelFragment.this.getContext());
                defaultTipDialog.e(null);
                defaultTipDialog.c(MineLabelFragment.this.getString(g.text_244));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.MineLabelFragment.6.1
                    @Override // com.library.base.frame.d
                    public void onConfirm() {
                        w.e();
                        MineLabelFragment mineLabelFragment = MineLabelFragment.this;
                        mineLabelFragment.deletePosition = mineLabelFragment.quickAdapter.getData().indexOf(mineLabelModel);
                        if (mineLabelModel.getType() == 1) {
                            G.c cVar = MineLabelFragment.this.mineLabelDeleteWorker;
                            String strValueOf = String.valueOf(mineLabelModel.getId());
                            cVar.getClass();
                            DelMyDocBodyV2 delMyDocBodyV2 = new DelMyDocBodyV2();
                            delMyDocBodyV2.setBiaoqianPersonalIds(Arrays.asList(Long.valueOf(strValueOf)));
                            cVar.d.deleteMineLabel(delMyDocBodyV2).b(new G.b(cVar, 0));
                        } else {
                            MineLabelFragment.this.deleteReceiptWorker.a(String.valueOf(mineLabelModel.getId()));
                        }
                        System.out.println("要删除的id：" + mineLabelModel.getId());
                        System.out.println("要删除的类型" + mineLabelModel.getType());
                    }

                    @Override // com.library.base.frame.d
                    public void onCancel() {
                    }
                };
                defaultTipDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initListener$0(View view) {
        this.currentKeyword = androidx.exifinterface.media.a.f(this.etSearch);
        this.srlFragmentMineLabel.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean templateContainsTable(String str) {
        try {
            TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, str);
            if (templatePto != null && templatePto.getViews() != null) {
                Iterator<Object> it = templatePto.getViews().iterator();
                while (it.hasNext()) {
                    ElementAttributeBean elementAttributeBean = (ElementAttributeBean) p052j2.c.d(it.next(), ElementAttributeBean.class);
                    if (elementAttributeBean != null && elementAttributeBean.getElementType() == 9) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Exception e) {
            p051j0.a.d("MineLabelFragment", "templateContainsTable parse fail: " + e.getMessage());
        }
    }

    @Override // G.a
    public void deleteMineLabelFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // G.a
    public void deleteMineLabelSuccess() {
        w.c();
        p042h2.d.show(g.toast_39);
        this.srlFragmentMineLabel.h();
        setAllItemsSelected(false);
        S4.d.b().f(new p137y.c());
    }

    @Override // U.c
    public void deleteReceiptFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // U.c
    public void deleteReceiptSuccess() {
        w.c();
        p042h2.d.show(g.toast_39);
        this.srlFragmentMineLabel.h();
        setAllItemsSelected(false);
        S4.d.b().f(new p137y.c());
    }

    @Override // p020d0.c
    public void editRecordNameFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p020d0.c
    public void editRecordNameSuccess() {
        w.c();
        this.srlFragmentMineLabel.h();
    }

    public void executeDelete(List<String> list) {
        w.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            MineLabelModel mineLabelModel = (MineLabelModel) it.next();
            if (mineLabelModel.isSelect()) {
                if (mineLabelModel.getType() == 1) {
                    arrayList.add(String.valueOf(mineLabelModel.getId()));
                } else {
                    arrayList2.add(String.valueOf(mineLabelModel.getId()));
                }
            }
        }
        int i5 = 0;
        if (!arrayList.isEmpty()) {
            G.c cVar = this.mineLabelDeleteWorker;
            cVar.getClass();
            DelMyDocBodyV2 delMyDocBodyV2 = new DelMyDocBodyV2();
            ArrayList arrayList3 = new ArrayList();
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList.get(i6);
                i6++;
                arrayList3.add(Long.valueOf((String) obj));
            }
            delMyDocBodyV2.setBiaoqianPersonalIds(arrayList3);
            cVar.d.deleteMineLabel(delMyDocBodyV2).b(new G.b(cVar, 1));
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        e eVar = this.deleteReceiptWorker;
        eVar.getClass();
        AppDeleteReceiptBodyV2 appDeleteReceiptBodyV2 = new AppDeleteReceiptBodyV2();
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList2.size();
        while (i5 < size2) {
            Object obj2 = arrayList2.get(i5);
            i5++;
            arrayList4.add(Long.valueOf((String) obj2));
        }
        appDeleteReceiptBodyV2.setReceiptIds(arrayList4);
        eVar.d.deleteReceipt(appDeleteReceiptBodyV2).b(new U.d(eVar, 1));
    }

    public List<String> getSelectedLabelIds() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            MineLabelModel mineLabelModel = (MineLabelModel) it.next();
            if (mineLabelModel.isSelect()) {
                arrayList.add(String.valueOf(mineLabelModel.getId()));
            }
        }
        return arrayList;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        S4.d.b().j(this);
        G.f fVar = new G.f(getContext());
        this.mineLabelWorker = fVar;
        addPresenter(fVar);
        G.c cVar = new G.c(getContext());
        cVar.d = (DocumentApi) Http.createApi(DocumentApi.class);
        this.mineLabelDeleteWorker = cVar;
        addPresenter(cVar);
        p020d0.e eVar = new p020d0.e(getContext());
        this.editRecordNameWorker = eVar;
        addPresenter(eVar);
        p009b0.c cVar2 = new p009b0.c(getContext());
        this.publishTemplateWorker = cVar2;
        addPresenter(cVar2);
        e eVar2 = new e(getContext());
        this.deleteReceiptWorker = eVar2;
        addPresenter(eVar2);
        this.receiptApi = (ReceiptApi) Http.createApi(ReceiptApi.class);
        this.audvFragmentMineLabel.b(p113u.f.ic_label_no_data);
        this.audvFragmentMineLabel.setConnect(getString(g.text_282));
        this.audvFragmentMineLabel.setButtonWhetherVisible(false);
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_document_mine_label) { // from class: com.appdev.standard.page.document.MineLabelFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final MineLabelModel mineLabelModel) {
                aVar.b(p113u.d.tv_document_mine_label_title, mineLabelModel.getTitle());
                aVar.b(p113u.d.tv_document_mine_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(mineLabelModel.getWidth()), Integer.valueOf(mineLabelModel.getHeight())));
                aVar.b(p113u.d.tv_document_mine_label_create_time, mineLabelModel.getCreateTime());
                p047i2.a.b(mineLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_document_mine_label_img), p113u.f.ic_default_error_label_1);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_document_mine_label_type_bk);
                TextView textView = (TextView) aVar.a(p113u.d.tv_document_mine_label_type);
                if (mineLabelModel.getType() == 1) {
                    imageView.setImageResource(p113u.f.ic_label_type_bk);
                    textView.setText(g.text_459);
                } else {
                    imageView.setImageResource(p113u.f.ic_text_type_bk);
                    textView.setText(g.text_94);
                }
                ImageView imageView2 = (ImageView) aVar.a(p113u.d.iv_item_document_mine_label_more);
                final ImageView imageView3 = (ImageView) aVar.a(p113u.d.iv_item_document_mine_label_check);
                imageView2.setVisibility(MineLabelFragment.this.isManageMode ? 8 : 0);
                imageView3.setVisibility(MineLabelFragment.this.isManageMode ? 0 : 8);
                imageView3.setImageResource(mineLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.MineLabelFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        View viewInflate = LayoutInflater.from(MineLabelFragment.this.getContext()).inflate(p113u.e.pop_document_fragment_mine_label, (ViewGroup) null);
                        MineLabelFragment.this.handleLogic(viewInflate, mineLabelModel);
                        MineLabelFragment mineLabelFragment = MineLabelFragment.this;
                        C0450c c0450c = new C0450c(mineLabelFragment.getContext());
                        c0450c.f2639a.e = viewInflate;
                        c0450c.b(-2);
                        C0451d c0451d = c0450c.f2639a;
                        c0451d.d = true;
                        c0451d.f2643h = true;
                        C0451d c0451dA = c0450c.a();
                        c0451dA.b(MineLabelFragment.this.srlFragmentMineLabel);
                        mineLabelFragment.mCustomPopWindow = c0451dA;
                    }
                });
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.MineLabelFragment.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MineLabelModel mineLabelModel2 = mineLabelModel;
                        mineLabelModel2.setSelect(!mineLabelModel2.isSelect());
                        imageView3.setImageResource(mineLabelModel.isSelect() ? p113u.f.ic_common_check_select : p113u.f.ic_common_check_select_not);
                        notifyDataSetChanged();
                        S4.d.b().f(new p137y.c());
                    }
                });
            }
        };
        this.rvFragmentMineLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentMineLabel.setAdapter(this.quickAdapter);
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.tvSearch.setOnClickListener(new a(this, 0));
        this.srlFragmentMineLabel.s(new L2.f() { // from class: com.appdev.standard.page.document.MineLabelFragment.7
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                MineLabelFragment.this.isLoadMore = true;
                if (MineLabelFragment.this.pageNum == MineLabelFragment.this.totalPageNo) {
                    MineLabelFragment.this.srlFragmentMineLabel.r(true);
                    return;
                }
                MineLabelFragment.this.pageNum++;
                MineLabelFragment.this.mineLabelWorker.a(MineLabelFragment.this.currentKeyword, MineLabelFragment.this.pageNum, null, null);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                MineLabelFragment.this.isLoadMore = false;
                MineLabelFragment.this.srlFragmentMineLabel.r(false);
                MineLabelFragment.this.pageNum = 1;
                MineLabelFragment.this.mineLabelWorker.a(MineLabelFragment.this.currentKeyword, MineLabelFragment.this.pageNum, null, null);
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.MineLabelFragment.8
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                if (MineLabelFragment.this.isManageMode) {
                    return;
                }
                MineLabelModel mineLabelModel = (MineLabelModel) MineLabelFragment.this.quickAdapter.getData().get(i5);
                if (mineLabelModel.getType() != 1) {
                    ReceiptModel receiptModel = new ReceiptModel();
                    receiptModel.setWidth(mineLabelModel.getWidth());
                    receiptModel.setCoverUrl(mineLabelModel.getCoverUrl());
                    receiptModel.setTitle(mineLabelModel.getTitle());
                    receiptModel.setContent(mineLabelModel.getContent());
                    receiptModel.setReceiptId(String.valueOf(mineLabelModel.getId()));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ReceiptModel", receiptModel);
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_RECEIPT_EDIT).with(bundle).navigation();
                    return;
                }
                try {
                    TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, mineLabelModel.getContent());
                    TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                    TemplateConfigBean templateConfigBean = new TemplateConfigBean(mineLabelModel.getTitle(), mineLabelModel.getWidth(), mineLabelModel.getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), String.valueOf(mineLabelModel.getId()), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                    Bundle bundle2 = new Bundle();
                    bundle2.putSerializable("data_template_config", templateConfigBean);
                    bundle2.putString("data_template_content", p052j2.c.e(templatePto.getViews()));
                    bundle2.putString("personLabelId", String.valueOf(mineLabelModel.getId()));
                    bundle2.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                    bundle2.putInt("data_print_data_source", 3);
                    bundle2.putString("data_print_cover_url", mineLabelModel.getCoverUrl());
                    bundle2.putString("data_print_title", mineLabelModel.getTitle());
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle2).navigation();
                } catch (Exception unused) {
                    p042h2.d.show(g.toast_28);
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    public boolean isAllSelected() {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            if (!((MineLabelModel) it.next()).isSelect()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_mine_label;
    }

    @Override // G.d
    public void mineLabelFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentMineLabel.k();
        this.srlFragmentMineLabel.i();
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // G.d
    public void mineLabelSuccess(List<MineLabelModel> list, int i5) {
        this.srlFragmentMineLabel.k();
        this.srlFragmentMineLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((MineLabelModel) it.next()).setSelect(false);
        }
        S4.d.b().f(new p137y.c());
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z6) {
        super.onHiddenChanged(z6);
        if (z6 || this.mHasShownLogin) {
            return;
        }
        checkLoginStatus();
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onManageModeEvent(o oVar) {
        this.isManageMode = oVar.f9018a;
        com.library.base.util.recyclerview.f fVar = this.quickAdapter;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mIsCheckingLogin || this.mHasShownLogin) {
            return;
        }
        checkLoginStatus();
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onUpDataMineLabelListEvent(t tVar) {
        this.srlFragmentMineLabel.h();
    }

    @Override // p009b0.a
    public void publishTemplateFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p009b0.a
    public void publishTemplateSuccess(String str) {
        w.c();
        this.srlFragmentMineLabel.h();
    }

    public void resetLoginCheck() {
        this.mIsCheckingLogin = false;
        this.mHasShownLogin = false;
    }

    public void setAllItemsSelected(boolean z6) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ((MineLabelModel) it.next()).setSelect(z6);
        }
        this.quickAdapter.notifyDataSetChanged();
        S4.d.b().f(new p137y.c());
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
