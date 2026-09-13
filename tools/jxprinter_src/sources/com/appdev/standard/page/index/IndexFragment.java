package com.appdev.standard.page.index;

import A3.AbstractC0157z;
import S4.k;
import android.bluetooth.BluetoothAdapter;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bertsir.zbar.Qr.ScanResult;
import cn.bertsir.zbar.QrManager;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MainApi;
import com.appdev.standard.api.pto.EditRecordNamePto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.C0450c;
import com.appdev.standard.dialog.C0451d;
import com.appdev.standard.dialog.DefaultEdittextDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.G;
import com.appdev.standard.dialog.InterfaceC0455h;
import com.appdev.standard.dialog.OpenBluetoothDialog;
import com.appdev.standard.dialog.OpenBluetoothFailedDialog;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.appdev.standard.dialog.ShareDialog;
import com.appdev.standard.model.AppBannerModel;
import com.appdev.standard.model.SharedViewModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.model.UsageRecordModel;
import com.appdev.standard.page.auth.PcLoginConfirmActivity;
import com.appdev.standard.page.bluetooth.PrinterStateFrament;
import com.appdev.standard.widget.MallBannerView;
import com.bumptech.glide.z;
import com.google.common.net.HttpHeaders;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.util.http.CallBack;
import com.library.base.util.http.Http;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.apache.poi.ss.usermodel.DateUtil;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.videoio.Videoio;
import p020d0.g;
import p037g0.h;
import p037g0.j;
import p050j.w;
import p056k0.i;
import p056k0.r;
import p134x2.K0;
import p134x2.P0;
import p137y.s;
import p137y.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class IndexFragment extends com.library.base.frame.f implements B.a, h, p020d0.f, p020d0.c, p020d0.a {
    private p037g0.c activateDeviceWorker;
    private B.b appBannerWorker;

    @BindView(4943)
    MallBannerView bvFragmentIndexBanner;
    private List<AppBannerModel> cachedBannerModels;
    private p020d0.b deleteUsageRecordWorker;
    private String detectedStoreName;
    private p020d0.e editRecordNameWorker;
    private LinearLayout indicatorContainer;

    @BindView(5227)
    ImageView ivHomeLogo;

    @BindView(5226)
    ImageView ivVip;

    @BindView(5388)
    LinearLayout llFragmentIndex;
    private C0451d mCustomPopWindow;
    private i pickMedia;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5827)
    RecyclerView rvFragmentIndexPrintHistory;
    private j scanQrVipWorker;
    private g usageRecordWorker;
    private ViewPager2 viewPager;

    /* JADX INFO: renamed from: com.appdev.standard.page.index.IndexFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(com.library.base.util.recyclerview.a aVar, final UsageRecordModel usageRecordModel) {
            aVar.b(p113u.d.tv_item_index_fragment_label_title, usageRecordModel.getTitle());
            aVar.b(p113u.d.tv_item_index_fragment_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(usageRecordModel.getWidth()), Integer.valueOf(usageRecordModel.getHeight())));
            aVar.b(p113u.d.tv_item_index_fragment_label_print_time, String.format(IndexFragment.this.getString(p113u.g.text_273), com.bumptech.glide.h.a(usageRecordModel.getUpdateTime(), "yyyy.MM.dd HH:mm")));
            p047i2.a.b(usageRecordModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_item_index_fragment_label_img), p113u.f.ic_default_error_label_1);
            ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_index_fragment_label_print);
            ((ImageView) aVar.a(p113u.d.iv_item_index_fragment_label_more)).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.index.IndexFragment.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    View viewInflate = LayoutInflater.from(IndexFragment.this.getContext()).inflate(p113u.e.pop_index_fragment_label, (ViewGroup) null);
                    IndexFragment.this.handleLogic(viewInflate, usageRecordModel);
                    IndexFragment indexFragment = IndexFragment.this;
                    C0450c c0450c = new C0450c(indexFragment.getContext());
                    c0450c.f2639a.e = viewInflate;
                    c0450c.b(-2);
                    C0451d c0451d = c0450c.f2639a;
                    c0451d.d = true;
                    c0451d.f2643h = true;
                    C0451d c0451dA = c0450c.a();
                    c0451dA.b(IndexFragment.this.llFragmentIndex);
                    indexFragment.mCustomPopWindow = c0451dA;
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.index.IndexFragment.1.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IndexFragment.this.getFrameActivity().needBlueToothPermission(new PermissionTipDialog(IndexFragment.this.getFrameActivity(), IndexFragment.this.getFrameActivity().getString(p113u.g.bluetooth_permission2)), new p026e2.a() { // from class: com.appdev.standard.page.index.IndexFragment.1.2.1
                        @Override // p026e2.a
                        public void onRequestPermissionFail() {
                            IndexFragment.this.getContext();
                            p051j0.a.l();
                        }

                        @Override // p026e2.a
                        public void onRequestPermissionSuccess() {
                            IndexFragment.this.getContext();
                            p051j0.a.m();
                            K0 printer = p051j0.f.getPrinter();
                            if (printer == null || !printer.b()) {
                                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TemplatePto usageRecordTemplate = IndexFragment.this.parseUsageRecordTemplate(usageRecordModel);
                            if (usageRecordTemplate == null) {
                                return;
                            }
                            TemplatePaperPto paper = usageRecordTemplate.getPaper();
                            TemplateConfigBean templateConfigBean = new TemplateConfigBean(usageRecordModel.getTitle(), usageRecordModel.getWidth(), usageRecordModel.getHeight(), paper.getColumns(), paper.getColumnMargin(), usageRecordModel.getBiaoqianPersonalId(), paper.getBackground(), paper.getBorderUrl(), paper.getPaperType(), paper.getRotate());
                            S4.d dVarB = S4.d.b();
                            List<Object> views = usageRecordTemplate.getViews();
                            String coverUrl = usageRecordModel.getCoverUrl();
                            String title = usageRecordModel.getTitle();
                            usageRecordModel.getBiaoqianPersonalId();
                            dVarB.f(new s(templateConfigBean, views, coverUrl, title, usageRecordModel.getUsageRecordId()));
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.index.IndexFragment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ UsageRecordModel val$item;

        public AnonymousClass3(UsageRecordModel usageRecordModel) {
            this.val$item = usageRecordModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IndexFragment.this.mCustomPopWindow.a();
            ShareDialog shareDialog = new ShareDialog(IndexFragment.this.getContext());
            shareDialog.f2629a = new G() { // from class: com.appdev.standard.page.index.IndexFragment.3.1
                @Override // com.appdev.standard.dialog.G
                public void onSelect(String str) {
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    final String string = IndexFragment.this.getString(p113u.g.share_content_format, anonymousClass3.val$item.getTitle(), Integer.valueOf(AnonymousClass3.this.val$item.getWidth()), Integer.valueOf(AnonymousClass3.this.val$item.getHeight()), AnonymousClass3.this.val$item.getBiaoqianPersonalId());
                    if ("WeChat".equals(str)) {
                        if (IndexFragment.this.getActivity().getPackageManager().getLaunchIntentForPackage("com.tencent.mm") == null) {
                            p042h2.d.show(p113u.g.toast_6);
                            return;
                        }
                        OnekeyShare onekeyShare = new OnekeyShare();
                        onekeyShare.setPlatform(Wechat.NAME);
                        onekeyShare.setText(string);
                        onekeyShare.setCallback(new PlatformActionListener() { // from class: com.appdev.standard.page.index.IndexFragment.3.1.1
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
                            ((ClipboardManager) IndexFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                            p042h2.d.show(p113u.g.toast_23);
                            return;
                        }
                        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(IndexFragment.this.getContext());
                        defaultTipDialog.e(IndexFragment.this.getString(p113u.g.text_124));
                        defaultTipDialog.b(IndexFragment.this.getString(p113u.g.confirm));
                        defaultTipDialog.c(IndexFragment.this.getString(p113u.g.text_321));
                        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.3.1.2
                            @Override // com.library.base.frame.d
                            public void onConfirm() {
                                Hawk.put("clipboard_permissions_yunBiao", Boolean.TRUE);
                                ((ClipboardManager) IndexFragment.this.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
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

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class FunctionPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private final List<Integer> layouts;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class PageOneViewHolder extends RecyclerView.ViewHolder {
            public PageOneViewHolder(View view) {
                super(view);
                final int i5 = 0;
                view.findViewById(p113u.d.ll_fragment_index_create_label).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i5) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i6 = 1;
                view.findViewById(p113u.d.ll_fragment_index_photo_print).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i6) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i7 = 2;
                view.findViewById(p113u.d.ll_fragment_index_industry_label).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i7) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i8 = 3;
                view.findViewById(p113u.d.ll_fragment_index_tools).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i8) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i9 = 4;
                view.findViewById(p113u.d.ll_fragment_index_pdf_print).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i9) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i10 = 5;
                view.findViewById(p113u.d.ll_fragment_index_quick_print).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i10) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i11 = 6;
                view.findViewById(p113u.d.ll_fragment_index_ticket_template).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i11) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
                final int i12 = 7;
                view.findViewById(p113u.d.ll_fragment_index_web_printing).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.e
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageOneViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i12) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            case 2:
                                this.b.lambda$new$2(view2);
                                break;
                            case 3:
                                this.b.lambda$new$3(view2);
                                break;
                            case 4:
                                this.b.lambda$new$4(view2);
                                break;
                            case 5:
                                this.b.lambda$new$5(view2);
                                break;
                            case 6:
                                this.b.lambda$new$6(view2);
                                break;
                            default:
                                this.b.lambda$new$7(view2);
                                break;
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$0(View view) {
                IndexFragment.this.onCreateLabelClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$1(View view) {
                IndexFragment.this.onPhotoPrintClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$2(View view) {
                IndexFragment.this.onIndustryLabelClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$3(View view) {
                IndexFragment.this.onToolsClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$4(View view) {
                IndexFragment.this.onPDFPrintClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$5(View view) {
                IndexFragment.this.onQuickPrintClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$6(View view) {
                IndexFragment.this.onTicketTemplateClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$7(View view) {
                IndexFragment.this.onWebPrintClick(view);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public class PageTwoViewHolder extends RecyclerView.ViewHolder {
            public PageTwoViewHolder(View view) {
                super(view);
                final int i5 = 0;
                view.findViewById(p113u.d.ll_fragment_index_banner_printing).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.f
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageTwoViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i5) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            default:
                                this.b.lambda$new$2(view2);
                                break;
                        }
                    }
                });
                final int i6 = 1;
                view.findViewById(p113u.d.ll_fragment_index_scanning).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.f
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageTwoViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i6) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            default:
                                this.b.lambda$new$2(view2);
                                break;
                        }
                    }
                });
                final int i7 = 2;
                view.findViewById(p113u.d.ll_fragment_index_orc_new).setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.f
                    public final /* synthetic */ IndexFragment.FunctionPagerAdapter.PageTwoViewHolder b;

                    {
                        this.b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        switch (i7) {
                            case 0:
                                this.b.lambda$new$0(view2);
                                break;
                            case 1:
                                this.b.lambda$new$1(view2);
                                break;
                            default:
                                this.b.lambda$new$2(view2);
                                break;
                        }
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$0(View view) {
                IndexFragment.this.onBannerPrintClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$1(View view) {
                IndexFragment.this.onScanPrintClick(view);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$new$2(View view) {
                IndexFragment.this.onORCNewLabelClick(view);
            }
        }

        public /* synthetic */ FunctionPagerAdapter(IndexFragment indexFragment, int i5) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.layouts.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i5) {
            return this.layouts.get(i5).intValue();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i5) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
            int i6 = p113u.e.page_one;
            return i5 == i6 ? new PageOneViewHolder(layoutInflaterFrom.inflate(i6, viewGroup, false)) : new PageTwoViewHolder(layoutInflaterFrom.inflate(p113u.e.page_two, viewGroup, false));
        }

        private FunctionPagerAdapter() {
            this.layouts = Arrays.asList(Integer.valueOf(p113u.e.page_one), Integer.valueOf(p113u.e.page_two));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activateVip() {
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            p042h2.d.a("打印机未连接");
            return;
        }
        final String strG = p051j0.a.g(p0H);
        if (Y.f(strG) || "000000000000000000000000".equals(strG)) {
            throw new IllegalStateException(AbstractC0157z.n("无效的设备ID: ", strG));
        }
        this.activateDeviceWorker.b = new p037g0.a() { // from class: com.appdev.standard.page.index.IndexFragment.13
            @Override // p037g0.a
            public void activateDeviceFailed(int i5, String str) {
                p042h2.d.a("激活请求失败: " + str);
            }

            @Override // p037g0.a
            public void activateDeviceSuccess(int i5) {
                Hawk.put(AbstractC0157z.s(new StringBuilder(), strG, "_activateResult"), Integer.valueOf(i5));
                p042h2.d.show(p113u.g.toast_34);
                IndexFragment.this.updateVipIconVisibility(i5 == 3);
            }
        };
        this.activateDeviceWorker.a(p0H.getDeviceName(), strG, p0H.getFactoryName(), true);
    }

    private void addRedDotToImageView(ImageView imageView, int i5, int i6) {
        if (imageView == null || imageView.getDrawable() == null) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        int iApplyDimension = (int) TypedValue.applyDimension(1, i5, getResources().getDisplayMetrics());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i6);
        gradientDrawable.setBounds(0, 0, iApplyDimension, iApplyDimension);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, gradientDrawable});
        int i7 = iApplyDimension / 2;
        layerDrawable.setLayerInset(1, drawable.getIntrinsicWidth() - i7, 0, 0, drawable.getIntrinsicHeight() - i7);
        imageView.setImageDrawable(layerDrawable);
    }

    private void getHistoryLabel() {
        g gVar = this.usageRecordWorker;
        gVar.d.usageRecordList().b(new p020d0.d(gVar, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLogic(View view, final UsageRecordModel usageRecordModel) {
        ImageView imageView = (ImageView) view.findViewById(p113u.d.iv_pop_index_fragment_label_img);
        final TextView textView = (TextView) view.findViewById(p113u.d.tv_pop_index_fragment_label_title);
        TextView textView2 = (TextView) view.findViewById(p113u.d.tv_pop_index_fragment_label_specification);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_share);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_rename);
        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(p113u.d.ll_pop_index_fragment_label_delete);
        p047i2.a.a(imageView, usageRecordModel.getCoverUrl());
        textView.setText(usageRecordModel.getTitle());
        textView2.setText(String.format("%d*%d (W*H)", Integer.valueOf(usageRecordModel.getWidth()), Integer.valueOf(usageRecordModel.getHeight())));
        linearLayout.setOnClickListener(new AnonymousClass3(usageRecordModel));
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.index.IndexFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IndexFragment.this.mCustomPopWindow.a();
                DefaultEdittextDialog defaultEdittextDialog = new DefaultEdittextDialog(IndexFragment.this.getContext());
                defaultEdittextDialog.e(IndexFragment.this.getString(p113u.g.text_242));
                defaultEdittextDialog.d(IndexFragment.this.getResources().getString(p113u.g.hint_8));
                defaultEdittextDialog.f2607a = new InterfaceC0455h() { // from class: com.appdev.standard.page.index.IndexFragment.4.1
                    @Override // com.appdev.standard.dialog.InterfaceC0455h
                    public void onConfirm(String str) {
                        if (Y.f(str)) {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            usageRecordModel.setTitle(IndexFragment.this.getString(p113u.g.text_400));
                        } else {
                            usageRecordModel.setTitle(str);
                        }
                        AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                        textView.setText(usageRecordModel.getTitle());
                        IndexFragment.this.quickAdapter.notifyDataSetChanged();
                        EditRecordNamePto editRecordNamePto = new EditRecordNamePto(usageRecordModel.getUsageRecordId(), usageRecordModel.getTitle());
                        w.e();
                        IndexFragment.this.editRecordNameWorker.a(editRecordNamePto);
                    }

                    @Override // com.appdev.standard.dialog.InterfaceC0455h
                    public void onCancel() {
                    }
                };
                defaultEdittextDialog.show();
            }
        });
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.index.IndexFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                IndexFragment.this.mCustomPopWindow.a();
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(IndexFragment.this.getContext());
                defaultTipDialog.e(IndexFragment.this.getString(p113u.g.text_124));
                defaultTipDialog.c(IndexFragment.this.getString(p113u.g.text_247));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.5.1
                    @Override // com.library.base.frame.d
                    public void onConfirm() {
                        p020d0.b bVar = IndexFragment.this.deleteUsageRecordWorker;
                        String usageRecordId = usageRecordModel.getUsageRecordId();
                        if (Y.f(usageRecordId)) {
                            Object obj = bVar.b;
                            if (obj != null) {
                                ((p020d0.a) obj).deleteUsageRecordFailed(1, "删除ID不能为空");
                            }
                        } else {
                            bVar.getClass();
                        }
                        HashMap map = new HashMap();
                        map.put("usageRecordId", usageRecordId);
                        bVar.d.deleteUsageRecord(map).b(new A.c(bVar, 29));
                    }

                    @Override // com.library.base.frame.d
                    public void onCancel() {
                    }
                };
                defaultTipDialog.show();
            }
        });
    }

    private boolean hasVipToActivate() {
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            p051j0.a.c("VIP_DEBUG", "打印机信息为空");
            return false;
        }
        String strG = p051j0.a.g(p0H);
        if (Y.f(strG) || "000000000000000000000000".equals(strG)) {
            p051j0.a.c("VIP_DEBUG", "无效的设备UID");
            return false;
        }
        Integer num = (Integer) Hawk.get(androidx.collection.a.n(strG, "_activateResult"), -1);
        boolean z6 = num.intValue() == 3;
        p051j0.a.c("VIP_DEBUG", "检查VIP状态: activateResult=" + num + ", 显示VIP图标: " + z6);
        return z6;
    }

    private boolean isSameData(List<AppBannerModel> list, List<AppBannerModel> list2) {
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            AppBannerModel appBannerModel = list.get(i5);
            AppBannerModel appBannerModel2 = list2.get(i5);
            if (!appBannerModel.getImgUrl().equals(appBannerModel2.getImgUrl()) || !appBannerModel.getLinkUrl().equals(appBannerModel2.getLinkUrl()) || appBannerModel.getType() != appBannerModel2.getType()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAppBannerSuccess$4(List list, View view) {
        AppBannerModel appBannerModel = (AppBannerModel) list.get(0);
        if (appBannerModel.getType() == 2) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(appBannerModel.getLinkUrl())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onPhotoPrintClick$5(Uri uri) {
        if (uri != null) {
            try {
                HashMap map = new HashMap();
                map.put("image", uri.toString());
                FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("pic_printer").arguments(map).requestCode(0).build());
            } catch (Exception e) {
                p051j0.a.e("IndexFragment", "onActivityResult: ", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onResume$3() {
        List<AppBannerModel> list = this.cachedBannerModels;
        if (list == null || list.isEmpty()) {
            B.b bVar = this.appBannerWorker;
            bVar.d.getAppBanner(String.valueOf(3)).b(new A.c(bVar, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        if (this.bvFragmentIndexBanner != null) {
            getAppBannerSuccess(this.cachedBannerModels);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$1(Integer num) {
        if (num.intValue() == 0 && isAdded()) {
            resetViewPagerToFirstPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetViewPagerToFirstPage$2() {
        this.viewPager.setCurrentItem(0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdatePopup$6(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
        if (TextUtils.isEmpty(this.detectedStoreName)) {
            p125w.f.h(requireContext(), "google");
        } else {
            p125w.f.h(requireContext(), this.detectedStoreName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showUpdatePopup$7(AlertDialog alertDialog, View view) {
        requireContext().getSharedPreferences("update_prefs", 0).edit().putLong("last_ignore_time", System.currentTimeMillis()).apply();
        alertDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showWebUpdateDialog$8(DialogInterface dialogInterface, int i5) {
        p125w.f.i(requireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TemplatePto parseUsageRecordTemplate(UsageRecordModel usageRecordModel) {
        if (usageRecordModel == null || Y.f(usageRecordModel.getContent())) {
            p051j0.a.d("IndexFragment", "Usage record template content is empty");
            p042h2.d.a("标签数据异常，无法打开");
            return null;
        }
        try {
            TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, usageRecordModel.getContent());
            if (templatePto != null && templatePto.getPaper() != null && templatePto.getViews() != null) {
                return templatePto;
            }
            p051j0.a.d("IndexFragment", "Usage record template content is incomplete, usageRecordId=" + usageRecordModel.getUsageRecordId());
            p042h2.d.a("标签数据异常，无法打开");
            return null;
        } catch (RuntimeException e) {
            p051j0.a.e("IndexFragment", "Failed to parse usage record template, usageRecordId=" + usageRecordModel.getUsageRecordId(), e);
            p042h2.d.a("标签数据异常，无法打开");
            return null;
        }
    }

    private boolean shouldShowUpdateDialog() {
        long j6 = requireContext().getSharedPreferences("update_prefs", 0).getLong("last_ignore_time", 0L);
        return j6 == 0 || System.currentTimeMillis() - j6 > DateUtil.DAY_MILLISECONDS;
    }

    private void showUpdateDialog() {
        p125w.f.checkUpdate(requireContext(), new p125w.d() { // from class: com.appdev.standard.page.index.IndexFragment.16
            public void onCheckError(String str) {
                Toast.makeText(IndexFragment.this.getContext(), str, 0).show();
            }

            @Override // p125w.d
            public void onNoStoreInstalled() {
                IndexFragment.this.showWebUpdateDialog();
            }

            @Override // p125w.d
            public void onStoreDetected(String str) {
                IndexFragment.this.detectedStoreName = str;
                p051j0.a.c("Update", "当前应用商店: " + str);
            }

            @Override // p125w.d
            public void onUpdateAvailable(String str, String str2) {
                IndexFragment.this.showUpdatePopup(str, str2);
            }

            @Override // p125w.d
            public void onNoUpdateAvailable() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdatePopup(String str, String str2) {
        if (getContext() == null) {
            return;
        }
        View viewInflate = LayoutInflater.from(getContext()).inflate(p113u.e.dialog_update, (ViewGroup) null);
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewInflate).setCancelable(false).create();
        TextView textView = (TextView) viewInflate.findViewById(p113u.d.tv_version);
        TextView textView2 = (TextView) viewInflate.findViewById(p113u.d.btn_update);
        TextView textView3 = (TextView) viewInflate.findViewById(p113u.d.tv_ignore);
        textView.setText(getString("google".equalsIgnoreCase(this.detectedStoreName) ? p113u.g.new_version_found_no_v : p113u.g.new_version_found, str2));
        System.out.println("版本号：" + str2);
        final int i5 = 0;
        textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.d
            public final /* synthetic */ IndexFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        this.b.lambda$showUpdatePopup$6(alertDialogCreate, view);
                        break;
                    default:
                        this.b.lambda$showUpdatePopup$7(alertDialogCreate, view);
                        break;
                }
            }
        });
        final int i6 = 1;
        textView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.index.d
            public final /* synthetic */ IndexFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        this.b.lambda$showUpdatePopup$6(alertDialogCreate, view);
                        break;
                    default:
                        this.b.lambda$showUpdatePopup$7(alertDialogCreate, view);
                        break;
                }
            }
        });
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialogCreate.show();
    }

    private void showVipActivateDialog() {
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e(getString(p113u.g.text_124));
        defaultTipDialog.c(getString(p113u.g.text_506));
        defaultTipDialog.a(getString(p113u.g.text_507));
        defaultTipDialog.b(getString(p113u.g.text_508));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.12
            @Override // com.library.base.frame.d
            public void onConfirm() {
                IndexFragment.this.activateVip();
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showWebUpdateDialog() {
        new AlertDialog.Builder(requireContext()).setTitle(p113u.g.update_title).setMessage(p113u.g.web_update_tip).setPositiveButton(p113u.g.go_to_web, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.index.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                this.f2698a.lambda$showWebUpdateDialog$8(dialogInterface, i5);
            }
        }).setNegativeButton(p113u.g.cancel, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateIndicators(LinearLayout linearLayout, int i5) {
        for (int i6 = 0; i6 < linearLayout.getChildCount(); i6++) {
            ImageView imageView = (ImageView) linearLayout.getChildAt(i6);
            if (i6 == i5) {
                imageView.setImageDrawable(getResources().getDrawable(p113u.c.indicator_selected_bg));
            } else {
                imageView.setImageDrawable(getResources().getDrawable(p113u.c.indicator_bg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateVipIconVisibility(boolean z6) {
        ImageView imageView = (ImageView) getView().findViewById(p113u.d.iv_fragment_vip);
        if (imageView == null) {
            p051j0.a.d("VIP_DEBUG", "未找到iv_fragment_vip视图");
        } else {
            imageView.setVisibility(z6 ? 0 : 8);
            p051j0.a.c("VIP_DEBUG", "设置VIP图标可见性: ".concat(z6 ? "VISIBLE" : "GONE"));
        }
    }

    @Override // p020d0.a
    public void deleteUsageRecordFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p020d0.a
    public void deleteUsageRecordSuccess() {
        w.c();
        getHistoryLabel();
    }

    @Override // p020d0.c
    public void editRecordNameFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p020d0.c
    public void editRecordNameSuccess() {
        w.c();
        getHistoryLabel();
    }

    @Override // B.a
    public void getAppBannerFailed(int i5, String str) {
        p042h2.d.a(str);
    }

    @Override // B.a
    public void getAppBannerSuccess(final List<AppBannerModel> list) {
        if (isSameData(this.cachedBannerModels, list)) {
            return;
        }
        this.cachedBannerModels = new ArrayList(list);
        ViewGroup viewGroup = (ViewGroup) this.bvFragmentIndexBanner.getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this.bvFragmentIndexBanner);
        if (list.size() > 1) {
            this.bvFragmentIndexBanner.setVisibility(0);
            View viewFindViewById = viewGroup.findViewById(p113u.d.single_image_container);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            this.bvFragmentIndexBanner.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() { // from class: com.appdev.standard.page.index.IndexFragment.7
                @Override // com.zhouwei.mzbanner.MZBannerView.BannerPageClickListener
                public void onPageClick(View view, int i5) {
                    AppBannerModel appBannerModel = (AppBannerModel) list.get(i5);
                    if (appBannerModel.getType() != 2 || Y.f(appBannerModel.getLinkUrl())) {
                        return;
                    }
                    String linkUrl = appBannerModel.getLinkUrl();
                    if (!linkUrl.startsWith("http://") && !linkUrl.startsWith("https://")) {
                        linkUrl = "https://".concat(linkUrl);
                    }
                    try {
                        IndexFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(linkUrl)));
                    } catch (ActivityNotFoundException e) {
                        p051j0.a.e("StorageUtil", "Banner click ActivityNotFoundException, linkUrl=" + linkUrl, e);
                    } catch (Exception e6) {
                        p051j0.a.e("StorageUtil", "Banner click exception, linkUrl=" + linkUrl, e6);
                    }
                }
            });
            MallBannerView mallBannerView = this.bvFragmentIndexBanner;
            if (mallBannerView != null) {
                mallBannerView.setPages(list, new MZHolderCreator<p074n0.a>() { // from class: com.appdev.standard.page.index.IndexFragment.8
                    @Override // com.zhouwei.mzbanner.holder.MZHolderCreator
                    public p074n0.a createViewHolder() {
                        return new p074n0.a(0, p113u.f.ic_default_error_banner);
                    }
                });
                this.bvFragmentIndexBanner.start();
                return;
            }
            return;
        }
        this.bvFragmentIndexBanner.setVisibility(8);
        int i5 = p113u.d.single_image_container;
        ImageView imageView = (ImageView) viewGroup.findViewById(i5);
        if (imageView == null) {
            imageView = new ImageView(getContext());
            imageView.setId(i5);
            ViewGroup.LayoutParams layoutParams = this.bvFragmentIndexBanner.getLayoutParams();
            imageView.setLayoutParams(new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewGroup.addView(imageView, iIndexOfChild);
        }
        if (list.isEmpty()) {
            imageView.setImageResource(p113u.f.ic_default_error_banner);
            return;
        }
        z zVarLoad = com.bumptech.glide.c.with(getContext()).load(list.get(0).getImgUrl());
        int i6 = p113u.f.ic_default_error_banner;
        ((z) ((z) ((z) zVarLoad.placeholder(i6)).error(i6)).centerCrop()).into(imageView);
        imageView.setOnClickListener(new com.appdev.standard.page.bluetooth.h(this, list, 1));
    }

    @Override // p020d0.f
    public void getUsageRecordListFailed(int i5, String str) {
        if (CallBack.TYPE_LOGIN_NOT.equals(String.valueOf(i5))) {
            return;
        }
        p042h2.d.a(str);
    }

    @Override // p020d0.f
    public void getUsageRecordListSuccess(List<UsageRecordModel> list) {
        this.quickAdapter.replaceAll(list);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        B.b bVar = new B.b(getActivity());
        bVar.d = (MainApi) Http.createApi(MainApi.class);
        this.appBannerWorker = bVar;
        addPresenter(bVar);
        j jVar = new j(getActivity());
        this.scanQrVipWorker = jVar;
        addPresenter(jVar);
        g gVar = new g(getActivity());
        this.usageRecordWorker = gVar;
        addPresenter(gVar);
        p020d0.e eVar = new p020d0.e(getActivity());
        this.editRecordNameWorker = eVar;
        addPresenter(eVar);
        p020d0.b bVar2 = new p020d0.b(getActivity());
        bVar2.d = (MainApi) Http.createApi(MainApi.class);
        this.deleteUsageRecordWorker = bVar2;
        addPresenter(bVar2);
        p037g0.c cVar = new p037g0.c(getActivity());
        this.activateDeviceWorker = cVar;
        addPresenter(cVar);
        addRedDotToImageView(this.ivVip, 20, SupportMenu.CATEGORY_MASK);
        registerEventBus();
        if (shouldShowUpdateDialog()) {
            showUpdateDialog();
        }
        String currentLanguage = getFrameActivity().getCurrentLanguage();
        if (currentLanguage.equals("zh") || currentLanguage.equals("zh_TW")) {
            this.ivHomeLogo.setImageResource(p113u.f.ic_common_home_logo);
        } else {
            this.ivHomeLogo.setImageResource(p113u.f.ic_common_home_logo_en);
        }
        this.quickAdapter = new AnonymousClass1(getContext(), p113u.e.item_index_fragment_history_label);
        this.rvFragmentIndexPrintHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentIndexPrintHistory.setAdapter(this.quickAdapter);
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.index.IndexFragment.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                UsageRecordModel usageRecordModel = (UsageRecordModel) IndexFragment.this.quickAdapter.getData().get(i5);
                TemplatePto usageRecordTemplate = IndexFragment.this.parseUsageRecordTemplate(usageRecordModel);
                if (usageRecordTemplate == null) {
                    return;
                }
                TemplatePaperPto paper = usageRecordTemplate.getPaper();
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(usageRecordModel.getTitle(), usageRecordModel.getWidth(), usageRecordModel.getHeight(), paper.getColumns(), paper.getColumnMargin(), usageRecordModel.getBiaoqianPersonalId(), paper.getBackground(), paper.getBorderUrl(), paper.getPaperType(), paper.getRotate());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data_template_config", templateConfigBean);
                bundle.putString("data_template_content", p052j2.c.e(usageRecordTemplate.getViews()));
                bundle.putString("personLabelId", ((UsageRecordModel) IndexFragment.this.quickAdapter.getData().get(i5)).getBiaoqianPersonalId());
                bundle.putInt("data_print_data_source", 3);
                bundle.putString("data_print_cover_url", usageRecordModel.getCoverUrl());
                bundle.putString("data_print_title", usageRecordModel.getTitle());
                bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        getChildFragmentManager().beginTransaction().replace(p113u.d.fl_printer_state, new PrinterStateFrament()).commit();
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_index;
    }

    public void onBannerPrintClick(View view) {
        if (!p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("banner_print").arguments(new HashMap()).requestCode(0).build());
    }

    public void onCreateLabelClick(View view) {
        if (!p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("create_label").arguments(new HashMap()).requestCode(0).build());
    }

    public void onIndustryLabelClick(View view) {
        if (p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MATERIAL_LIBRARY);
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    public void onORCNewLabelClick(View view) {
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        if (hVar.h()) {
            FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("create_label_by_ocr").arguments(new HashMap()).requestCode(0).build());
        } else {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
            defaultTipDialog.e("");
            defaultTipDialog.c(getString(p113u.g.text_248));
            defaultTipDialog.b(getString(p113u.g.text_256));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.11
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }
    }

    public void onPDFPrintClick(View view) {
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        if (hVar.h()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_PDF_FILE_LIST);
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_248));
        defaultTipDialog.b(getString(p113u.g.text_256));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.9
            @Override // com.library.base.frame.d
            public void onConfirm() {
                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    public void onPhotoPrintClick(View view) {
        if (p042h2.e.f4031a.g()) {
            this.pickMedia.pick(new F4.e(9));
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    @OnClick({5806})
    public void onPrinterClick(View view) {
        if (p042h2.e.f4031a.g()) {
            getFrameActivity().needBlueToothPermission(new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_258)), new p026e2.a() { // from class: com.appdev.standard.page.index.IndexFragment.15
                @Override // p026e2.a
                public void onRequestPermissionFail() {
                    IndexFragment.this.getContext();
                    p051j0.a.l();
                }

                @Override // p026e2.a
                public void onRequestPermissionSuccess() {
                    IndexFragment.this.getContext();
                    p051j0.a.m();
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter == null) {
                        p042h2.d.show(p113u.g.toast_33);
                    } else {
                        if (defaultAdapter.isEnabled()) {
                            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
                            return;
                        }
                        OpenBluetoothDialog openBluetoothDialog = new OpenBluetoothDialog(IndexFragment.this.getContext());
                        openBluetoothDialog.f2622a = new com.appdev.standard.dialog.z() { // from class: com.appdev.standard.page.index.IndexFragment.15.1
                            @Override // com.appdev.standard.dialog.z
                            public void onCancel() {
                                new OpenBluetoothFailedDialog(IndexFragment.this.getContext()).show();
                            }

                            @Override // com.appdev.standard.dialog.z
                            public void onConfirm() {
                                IndexFragment.this.getFrameActivity().openBluetooth(new com.library.base.frame.b() { // from class: com.appdev.standard.page.index.IndexFragment.15.1.1
                                    @Override // com.library.base.frame.b
                                    public void openBluetoothSuccess() {
                                        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
                                    }
                                });
                            }
                        };
                        openBluetoothDialog.show();
                    }
                }
            });
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    public void onQuickPrintClick(View view) {
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        if (hVar.h()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_QUICK_PRINTING);
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(getContext());
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_248));
        defaultTipDialog.b(getString(p113u.g.text_256));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.index.IndexFragment.10
            @Override // com.library.base.frame.d
            public void onConfirm() {
                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (getView() != null) {
            getView().postDelayed(new a(this, 2), 300L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.cachedBannerModels != null) {
            bundle.putParcelableArrayList("cachedBannerModels", new ArrayList<>(this.cachedBannerModels));
        }
    }

    @OnClick({5224})
    public void onScanClick(View view) {
        if (p042h2.e.f4031a.g()) {
            getFrameActivity().needCameraPermission(new PermissionTipDialog(getFrameActivity(), getString(p113u.g.text_257)), new p026e2.a() { // from class: com.appdev.standard.page.index.IndexFragment.14
                @Override // p026e2.a
                public void onRequestPermissionFail() {
                    p042h2.d.show(p113u.g.toast_3);
                }

                @Override // p026e2.a
                public void onRequestPermissionSuccess() {
                    QrManager.getInstance().init(r.a(IndexFragment.this.getContext())).startScan(IndexFragment.this.getFrameActivity(), new QrManager.OnScanResultCallback() { // from class: com.appdev.standard.page.index.IndexFragment.14.1
                        @Override // cn.bertsir.zbar.QrManager.OnScanResultCallback
                        public void onScanSuccess(ScanResult scanResult) {
                            if (!p042h2.e.f4031a.g()) {
                                p042h2.d.show(p113u.g.toast_32);
                                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
                                return;
                            }
                            if (Y.f(scanResult.getContent())) {
                                p042h2.d.show(p113u.g.toast_26);
                                return;
                            }
                            String content = scanResult.getContent();
                            if (content.startsWith("soleId")) {
                                PcLoginConfirmActivity.start(IndexFragment.this.getFrameActivity(), content);
                                return;
                            }
                            HashMap map = new HashMap();
                            map.put("qrcode", content);
                            w.e();
                            j jVar = IndexFragment.this.scanQrVipWorker;
                            jVar.d.scanQRCode(map).b(new p037g0.i(jVar));
                        }
                    });
                }
            });
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    public void onScanPrintClick(View view) {
        if (!p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("scan_image_list").arguments(new HashMap()).requestCode(0).build());
    }

    public void onTicketTemplateClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CREATE_RECEIPT);
    }

    public void onToolsClick(View view) {
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("tool_box").arguments(new HashMap()).requestCode(0).build());
    }

    @Override // com.library.base.frame.f, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        int i5 = 0;
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("cachedBannerModels");
            if (serializable instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) serializable;
                if (!arrayList.isEmpty() && (arrayList.get(0) instanceof AppBannerModel)) {
                    this.cachedBannerModels = arrayList;
                    getView().post(new a(this, 1));
                }
            }
        }
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(p113u.d.viewPager);
        this.viewPager = viewPager2;
        viewPager2.setAdapter(new FunctionPagerAdapter(this, i5));
        final LinearLayout linearLayout = (LinearLayout) view.findViewById(p113u.d.indicator_container);
        int itemCount = this.viewPager.getAdapter() != null ? this.viewPager.getAdapter().getItemCount() : 0;
        linearLayout.removeAllViews();
        for (int i6 = 0; i6 < itemCount; i6++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(p113u.b.indicator_width), getResources().getDimensionPixelSize(p113u.b.indicator_height));
            layoutParams.setMargins(20, 0, 20, 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(getResources().getDrawable(p113u.c.indicator_bg));
            linearLayout.addView(imageView);
        }
        this.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.appdev.standard.page.index.IndexFragment.6
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i7) {
                super.onPageSelected(i7);
                IndexFragment.this.updateIndicators(linearLayout, i7);
            }
        });
        i iVar = new i();
        this.pickMedia = iVar;
        iVar.attachToActivity(this);
        ((SharedViewModel) new ViewModelProvider(requireActivity()).get(SharedViewModel.class)).getCurrentTab().observe(getViewLifecycleOwner(), new Observer() { // from class: com.appdev.standard.page.index.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f2699a.lambda$onViewCreated$1((Integer) obj);
            }
        });
    }

    @k(threadMode = ThreadMode.MAIN)
    public void onVipActivationEvent(u uVar) {
        P0 p0H = p051j0.a.h();
        if (p0H == null) {
            p051j0.a.c("VIP_DEBUG", "打印机信息为空");
            return;
        }
        int i5 = uVar.f9027a;
        p051j0.a.c("VIP_DEBUG", "接收到VIP激活事件，activateResult: " + i5);
        String strG = p051j0.a.g(p0H);
        if (!Y.f(strG) && !"000000000000000000000000".equals(strG)) {
            Hawk.put(androidx.collection.a.n(strG, "_activateResult"), Integer.valueOf(i5));
        }
        updateVipIconVisibility(i5 == 3);
    }

    @OnClick({5226})
    public void onVipClick(View view) {
        if (hasVipToActivate()) {
            showVipActivateDialog();
        }
    }

    public void onWebPrintClick(View view) {
        if (!p042h2.e.f4031a.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("web_print").arguments(new HashMap()).requestCode(0).build());
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.bvFragmentIndexBanner.setWHRatio(0.4348249f);
        this.bvFragmentIndexBanner.setDelayedTime(8000);
        List<AppBannerModel> list = this.cachedBannerModels;
        if (list == null || list.isEmpty()) {
            B.b bVar = this.appBannerWorker;
            bVar.d.getAppBanner(String.valueOf(3)).b(new A.c(bVar, 2));
        } else {
            getAppBannerSuccess(this.cachedBannerModels);
        }
        getHistoryLabel();
        p051j0.a.c("VIP_DEBUG", "刷新UI，设置VIP图标初始状态");
        updateVipIconVisibility(hasVipToActivate());
    }

    public void resetViewPagerToFirstPage() {
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            return;
        }
        this.viewPager.post(new a(this, 0));
    }

    @Override // p037g0.h
    public void scanQRCodeFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // p037g0.h
    public void scanQRCodeSuccess() {
        w.c();
        p042h2.d.show(p113u.g.toast_34);
    }
}
