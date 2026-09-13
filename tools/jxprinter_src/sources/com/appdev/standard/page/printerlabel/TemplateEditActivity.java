package com.appdev.standard.page.printerlabel;

import android.R;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.wechat.friends.Wechat;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.pto.TemplateElementPto;
import com.appdev.standard.api.pto.TemplateModulePto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.ContentEditDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.DialogC0464q;
import com.appdev.standard.dialog.InterfaceC0453f;
import com.appdev.standard.dialog.SaveTipsDialog;
import com.appdev.standard.dialog.ShareDialog;
import com.appdev.standard.model.ElementAttributeBarCodeBean;
import com.appdev.standard.model.ElementAttributeLineBean;
import com.appdev.standard.model.ElementAttributePictureBean;
import com.appdev.standard.model.ElementAttributeQrCodeBean;
import com.appdev.standard.model.ElementAttributeShapeBean;
import com.appdev.standard.model.ElementAttributeTableBean;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.model.ElementAttributeTimeBean;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.widget.BaseControlView;
import com.appdev.standard.page.printerlabel.widget.DrawingBoardView;
import com.appdev.standard.page.printerlabel.widget.ImageTextBtnWidget;
import com.appdev.standard.page.printerlabel.widget.LineProgressWidget;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelBarCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelLineView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelPictureView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelQrCodeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelShapeView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTextView;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTimeView;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.idlefish.flutterboost.containers.FlutterActivityLaunchConfigs;
import com.library.base.frame.MvpActivity;
import com.mob.MobSDK;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.apache.commons.compress.compressors.bzip2.BZip2Constants;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;
import p134x2.K0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT)
public class TemplateEditActivity extends MvpActivity implements p009b0.a, p014c0.a {
    private String cloudLabelId;
    private Context context;
    private com.appdev.standard.util.fileDownload.h downloadCenterListener;

    @BindView(5106)
    FrameLayout flTemplateEdit;
    private DialogC0464q fontDownloadProgressDialog;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @BindView(5134)
    HorizontalScrollView hsvElementToolbar;

    @BindView(5156)
    ImageTextBtnWidget itbControlElementBicolor;

    @BindView(5157)
    ImageTextBtnWidget itbControlElementDarkMode;

    @BindView(5158)
    ImageTextBtnWidget itbControlElementLock;

    @BindView(5159)
    ImageTextBtnWidget itbControlElementMove;

    @BindView(5160)
    ImageTextBtnWidget itbControlElementRestore;

    @BindView(5161)
    ImageTextBtnWidget itbControlElementRevoke;

    @BindView(5162)
    ImageTextBtnWidget itbControlElementSelect;

    @BindView(5163)
    ImageTextBtnWidget itbToolbarElementAmplify;

    @BindView(5164)
    ImageTextBtnWidget itbToolbarElementCopy;

    @BindView(5165)
    ImageTextBtnWidget itbToolbarElementDelete;

    @BindView(5166)
    ImageTextBtnWidget itbToolbarElementReduce;

    @BindView(5167)
    ImageTextBtnWidget itbToolbarElementRotate;

    @BindView(5480)
    LinearLayout llPushIndustryTemplates;

    @BindView(4889)
    TemplatePageView mTemplatePageView;

    @BindView(5643)
    DrawingBoardView nsvTemplateEdit;
    private String personLabelId;
    private p009b0.c publishTemplateWorker;

    @BindView(5807)
    RelativeLayout rlScaleDialog;

    @BindView(5808)
    RelativeLayout rlTemplateEditDialog;

    @BindView(5862)
    LineProgressWidget scaleProgressWidget;

    @BindView(6258)
    TextView tvScale;

    @BindView(6272)
    TextView tvTemplateEditLabelName;

    @BindView(6273)
    TextView tvTemplateEditLabelSpecifications;
    private p014c0.e uploadImageWorker;

    @BindView(6305)
    View viewToolbarDivider;

    @BindView(6306)
    View viewToolbarDividerBottom;
    private final String TAG = getClass().getName();
    private float currentScale = 1.0f;
    private com.library.base.frame.f baseFragment = null;
    private TemplateConfigBean templateConfig = null;
    private String templateContent = null;
    private boolean dialogIsShow = false;
    List<BaseControlView> baseControlViewList = new ArrayList();
    private int dataSource = 6;
    private String printShareLink = null;
    private String printCoverUrl = null;
    private String printTitle = null;
    private int rotate = 0;
    private float baseX = 0.0f;
    private float baseY = 0.0f;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.TemplateEditActivity$33, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass33 implements com.appdev.standard.dialog.C {
        public AnonymousClass33() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSave$0() {
            TemplateEditActivity.this.uploadCover(ExifInterface.GPS_MEASUREMENT_3D);
        }

        @Override // com.appdev.standard.dialog.C
        public void onExit() {
            TemplateEditActivity.this.finish();
        }

        @Override // com.appdev.standard.dialog.C
        public void onSave() {
            if (TemplateEditActivity.this.haveTableElement()) {
                S4.h hVar = p042h2.e.f4031a;
                if (hVar.g() && !hVar.h()) {
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(TemplateEditActivity.this.context);
                    defaultTipDialog.e("");
                    defaultTipDialog.c(TemplateEditActivity.this.getString(p113u.g.text_249));
                    defaultTipDialog.a(TemplateEditActivity.this.getString(p113u.g.text_254));
                    defaultTipDialog.b(TemplateEditActivity.this.getString(p113u.g.text_255));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.33.1
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
            }
            TemplateEditActivity.this.uploadImageOfLabel(new H(this, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface UploadImageEvent {
        void uploadSuccess(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface UploadImagesEvent {
        void uploadSuccess();
    }

    private void changeFragmentView(List<BaseControlView> list, boolean z6) {
        if (list == null || list.size() == 0) {
            this.baseFragment = new ElementAllFragment();
        } else {
            this.baseFragment = new ElementAttributeFragment(list, this.mTemplatePageView);
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        this.fragmentTransaction = fragmentTransactionBeginTransaction;
        fragmentTransactionBeginTransaction.replace(p113u.d.fl_template_edit, this.baseFragment, String.valueOf(System.currentTimeMillis()));
        this.fragmentTransaction.commit();
    }

    private List<UploadFile> getUploadFiles() {
        ArrayList arrayList = new ArrayList();
        if (this.templateConfig.getPrinterLabelBgUrl() != null && !this.templateConfig.getPrinterLabelBgUrl().startsWith("http://") && !this.templateConfig.getPrinterLabelBgUrl().startsWith("https://")) {
            arrayList.add(new UploadFile(this.templateConfig.getPrinterLabelBgUrl(), "bg"));
        }
        if (this.templateConfig.getPrinterLabelBorderUrl() != null && !this.templateConfig.getPrinterLabelBorderUrl().startsWith("http://") && !this.templateConfig.getPrinterLabelBorderUrl().startsWith("https://")) {
            arrayList.add(new UploadFile(this.templateConfig.getPrinterLabelBorderUrl(), "border"));
        }
        for (int i5 = 0; i5 < this.mTemplatePageView.getChildCount(); i5++) {
            View childAt = this.mTemplatePageView.getChildAt(i5);
            if (childAt != null && (childAt instanceof BaseControlView)) {
                BaseControlView baseControlView = (BaseControlView) childAt;
                if (baseControlView.elementType() == 6) {
                    PrinterLabelPictureView printerLabelPictureView = (PrinterLabelPictureView) baseControlView;
                    if (printerLabelPictureView.isUploadFile()) {
                        arrayList.add(new UploadFile(printerLabelPictureView.getContent(), "view", printerLabelPictureView));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean haveTableElement() {
        boolean z6 = false;
        for (int i5 = 0; i5 < this.mTemplatePageView.getChildCount(); i5++) {
            View childAt = this.mTemplatePageView.getChildAt(i5);
            if (childAt != null && (childAt instanceof BaseControlView) && ((BaseControlView) childAt).elementType() == 9) {
                z6 = true;
            }
        }
        return z6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$0(LineProgressWidget lineProgressWidget, float f6) {
        lineProgressWidget.setPosition(f6);
        this.tvScale.setText(String.format("%.1fX", Float.valueOf(f6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initComponent$1(DrawingBoardView drawingBoardView, float f6) {
        drawingBoardView.setScale(f6);
        this.tvScale.setText(String.format("%.1fX", Float.valueOf(f6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBicolorClick$2(ImageView imageView, ImageView imageView2, final BaseControlView baseControlView, View view) {
        imageView.setVisibility(0);
        imageView2.setVisibility(4);
        baseControlView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.22
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = baseControlView.getJson();
                int iElementType = baseControlView.elementType();
                if (iElementType == 1) {
                    ElementAttributeLineBean elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                    elementAttributeLineBean.setColorType(0);
                    baseControlView.recoverFromJson(elementAttributeLineBean.ObjectToJson());
                    ElementAttributeTableBean elementAttributeTableBean = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                    elementAttributeTableBean.setColorType(0);
                    baseControlView.recoverFromJson(elementAttributeTableBean.ObjectToJson());
                } else {
                    if (iElementType != 2) {
                        if (iElementType == 5) {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                            elementAttributeTextBean.setColorType(0);
                            baseControlView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            return;
                        }
                        switch (iElementType) {
                            case 7:
                                ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                                elementAttributeBarCodeBean.setColorType(0);
                                baseControlView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                break;
                            case 8:
                                ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                                elementAttributeQrCodeBean.setColorType(0);
                                baseControlView.recoverFromJson(elementAttributeQrCodeBean.ObjectToJson());
                                break;
                            case 9:
                                ElementAttributeTableBean elementAttributeTableBean2 = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                                elementAttributeTableBean2.setColorType(0);
                                baseControlView.recoverFromJson(elementAttributeTableBean2.ObjectToJson());
                            case 10:
                                ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                                elementAttributeTimeBean.setColorType(0);
                                baseControlView.recoverFromJson(elementAttributeTimeBean.ObjectToJson());
                                break;
                        }
                        return;
                    }
                    ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                    elementAttributeShapeBean.setColorType(0);
                    baseControlView.recoverFromJson(elementAttributeShapeBean.ObjectToJson());
                    ElementAttributeLineBean elementAttributeLineBean2 = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                    elementAttributeLineBean2.setColorType(0);
                    baseControlView.recoverFromJson(elementAttributeLineBean2.ObjectToJson());
                    ElementAttributeTableBean elementAttributeTableBean3 = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                    elementAttributeTableBean3.setColorType(0);
                    baseControlView.recoverFromJson(elementAttributeTableBean3.ObjectToJson());
                }
                ElementAttributeTimeBean elementAttributeTimeBean2 = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                elementAttributeTimeBean2.setColorType(0);
                baseControlView.recoverFromJson(elementAttributeTimeBean2.ObjectToJson());
            }
        });
        p051j0.a.c("ColorSelect", "Black selected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBicolorClick$3(ImageView imageView, ImageView imageView2, final BaseControlView baseControlView, View view) {
        imageView.setVisibility(0);
        imageView2.setVisibility(4);
        baseControlView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.23
            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
            public void run() {
                JSONObject json = baseControlView.getJson();
                int iElementType = baseControlView.elementType();
                if (iElementType == 1) {
                    ElementAttributeLineBean elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                    elementAttributeLineBean.setColorType(1);
                    baseControlView.recoverFromJson(elementAttributeLineBean.ObjectToJson());
                    ElementAttributeTableBean elementAttributeTableBean = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                    elementAttributeTableBean.setColorType(1);
                    baseControlView.recoverFromJson(elementAttributeTableBean.ObjectToJson());
                } else {
                    if (iElementType != 2) {
                        if (iElementType == 5) {
                            ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
                            elementAttributeTextBean.setColorType(1);
                            baseControlView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                            return;
                        }
                        switch (iElementType) {
                            case 7:
                                ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                                elementAttributeBarCodeBean.setColorType(1);
                                baseControlView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                break;
                            case 8:
                                ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString());
                                elementAttributeQrCodeBean.setColorType(1);
                                baseControlView.recoverFromJson(elementAttributeQrCodeBean.ObjectToJson());
                                break;
                            case 9:
                                ElementAttributeTableBean elementAttributeTableBean2 = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                                elementAttributeTableBean2.setColorType(1);
                                baseControlView.recoverFromJson(elementAttributeTableBean2.ObjectToJson());
                            case 10:
                                ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                                elementAttributeTimeBean.setColorType(1);
                                baseControlView.recoverFromJson(elementAttributeTimeBean.ObjectToJson());
                                break;
                        }
                        return;
                    }
                    ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString());
                    elementAttributeShapeBean.setColorType(1);
                    baseControlView.recoverFromJson(elementAttributeShapeBean.ObjectToJson());
                    ElementAttributeLineBean elementAttributeLineBean2 = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString());
                    elementAttributeLineBean2.setColorType(1);
                    baseControlView.recoverFromJson(elementAttributeLineBean2.ObjectToJson());
                    ElementAttributeTableBean elementAttributeTableBean3 = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString());
                    elementAttributeTableBean3.setColorType(1);
                    baseControlView.recoverFromJson(elementAttributeTableBean3.ObjectToJson());
                }
                ElementAttributeTimeBean elementAttributeTimeBean2 = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString());
                elementAttributeTimeBean2.setColorType(1);
                baseControlView.recoverFromJson(elementAttributeTimeBean2.ObjectToJson());
            }
        });
        p051j0.a.c("ColorSelect", "Red selected");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onLabelShareClick$8() {
        uploadCover(ExifInterface.GPS_MEASUREMENT_3D);
        final String string = getString(p113u.g.share_content_format, this.templateConfig.getName(), Integer.valueOf(this.templateConfig.getWidth()), Integer.valueOf(this.templateConfig.getHeight()), this.personLabelId);
        ShareDialog shareDialog = new ShareDialog(this.context);
        shareDialog.f2629a = new com.appdev.standard.dialog.G() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.31
            @Override // com.appdev.standard.dialog.G
            public void onSelect(String str) {
                if ("WeChat".equals(str)) {
                    if (TemplateEditActivity.this.getPackageManager().getLaunchIntentForPackage("com.tencent.mm") == null) {
                        p042h2.d.show(p113u.g.toast_6);
                        return;
                    }
                    OnekeyShare onekeyShare = new OnekeyShare();
                    onekeyShare.setPlatform(Wechat.NAME);
                    onekeyShare.setText(string);
                    onekeyShare.setCallback(new PlatformActionListener() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.31.1
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
                        ((ClipboardManager) TemplateEditActivity.this.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
                        p042h2.d.show(p113u.g.toast_23);
                        return;
                    }
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(TemplateEditActivity.this.context);
                    defaultTipDialog.e(TemplateEditActivity.this.getString(p113u.g.text_124));
                    defaultTipDialog.b(TemplateEditActivity.this.getString(p113u.g.confirm));
                    defaultTipDialog.c(TemplateEditActivity.this.getString(p113u.g.text_321));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.31.2
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            Hawk.put("clipboard_permissions_yunBiao", Boolean.TRUE);
                            ((ClipboardManager) TemplateEditActivity.this.context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", string));
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

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPublishIndustryTemplateClick$9() {
        uploadCover("1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPublishSquareClick$7() {
        uploadCover(ExifInterface.GPS_MEASUREMENT_2D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveToCloudLabelClick$6() {
        uploadCover("4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSaveToPersonalSpaceClick$5() {
        uploadCover(ExifInterface.GPS_MEASUREMENT_3D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTemplateEditSaveClick$10() {
        uploadCover(ExifInterface.GPS_MEASUREMENT_3D);
    }

    private void saveLabelTip() {
        SaveTipsDialog saveTipsDialog = new SaveTipsDialog(this);
        saveTipsDialog.f2627a = new AnonymousClass33();
        saveTipsDialog.show();
    }

    private void takePersistableUriPermission(Uri uri) {
        try {
            getContentResolver().takePersistableUriPermission(uri, 1);
        } catch (SecurityException unused) {
            p051j0.a.d("Permission", "Failed to get permission for URI: " + uri);
        }
    }

    private void updateControlButton(List<BaseControlView> list) {
        if (list == null || list.size() == 0) {
            this.hsvElementToolbar.setVisibility(8);
            this.viewToolbarDivider.setVisibility(8);
            this.viewToolbarDividerBottom.setVisibility(8);
            this.itbToolbarElementDelete.setCanClick(false);
            this.itbToolbarElementCopy.setCanClick(false);
            this.itbToolbarElementAmplify.setCanClick(false);
            this.itbToolbarElementReduce.setCanClick(false);
            this.itbControlElementLock.setCanClick(false);
            this.itbToolbarElementRotate.setCanClick(false);
            this.itbControlElementBicolor.setCanClick(false);
            this.itbControlElementDarkMode.setCanClick(false);
            return;
        }
        if (list.size() != 1) {
            this.hsvElementToolbar.setVisibility(0);
            this.viewToolbarDivider.setVisibility(0);
            this.viewToolbarDividerBottom.setVisibility(0);
            this.itbToolbarElementDelete.setCanClick(true);
            this.itbToolbarElementCopy.setCanClick(false);
            this.itbToolbarElementAmplify.setCanClick(false);
            this.itbToolbarElementReduce.setCanClick(false);
            this.itbControlElementLock.setCanClick(false);
            this.itbToolbarElementRotate.setCanClick(false);
            this.itbControlElementBicolor.setCanClick(false);
            this.itbControlElementDarkMode.setCanClick(false);
            return;
        }
        this.hsvElementToolbar.setVisibility(0);
        this.viewToolbarDivider.setVisibility(0);
        this.viewToolbarDividerBottom.setVisibility(0);
        this.itbToolbarElementDelete.setCanClick(true);
        this.itbToolbarElementCopy.setCanClick(true);
        if (list.get(0) instanceof PrinterLabelTextView) {
            PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) list.get(0);
            if (printerLabelTextView.getFontSize() >= 400.0f) {
                this.itbToolbarElementAmplify.setCanClick(false);
            } else {
                this.itbToolbarElementAmplify.setCanClick(true);
            }
            if (printerLabelTextView.getFontSize() <= 3.0f) {
                this.itbToolbarElementReduce.setCanClick(false);
            } else {
                this.itbToolbarElementReduce.setCanClick(true);
            }
        } else {
            this.itbToolbarElementAmplify.setCanClick(true);
            this.itbToolbarElementReduce.setCanClick(true);
        }
        this.itbControlElementLock.setCanClick(true);
        this.itbToolbarElementRotate.setCanClick(true);
        this.itbControlElementBicolor.setCanClick(true);
        this.itbControlElementDarkMode.setCanClick(true);
        if (!(list.get(0) instanceof PrinterLabelTextView)) {
            this.itbControlElementDarkMode.setIconState(false);
            return;
        }
        try {
            this.itbControlElementDarkMode.setIconState(((ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, list.get(0).getJson().toString())).isDarkMode());
        } catch (Exception e) {
            e.printStackTrace();
            this.itbControlElementDarkMode.setIconState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadCover(String str) {
        if (this.mTemplatePageView.getChildCount() <= 1) {
            p042h2.d.show(p113u.g.toast_53);
            return;
        }
        okhttp3.D dDrawLabel2FormData = this.mTemplatePageView.drawLabel2FormData(false);
        p050j.w.e();
        System.out.println(dDrawLabel2FormData);
        p014c0.e eVar = this.uploadImageWorker;
        eVar.d.uploadImage(dDrawLabel2FormData).b(new p014c0.d(eVar, str));
    }

    private void uploadImage(String str, final UploadImageEvent uploadImageEvent) {
        if (str == null || str.isEmpty()) {
            uploadImageEvent.uploadSuccess(null);
            return;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            uploadImageEvent.uploadSuccess(str);
            return;
        }
        p014c0.e eVar = new p014c0.e(this);
        eVar.b = new p014c0.a() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.35
            @Override // p014c0.a
            public void uploadImageFailed(int i5, String str2) {
                p050j.w.c();
                p042h2.d.a(str2);
            }

            @Override // p014c0.a
            public void uploadImageSuccess(String str2, String str3) {
                uploadImageEvent.uploadSuccess(str2);
            }
        };
        eVar.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadImageOfLabel(final UploadImagesEvent uploadImagesEvent) {
        List<UploadFile> uploadFiles = getUploadFiles();
        if (uploadFiles.size() == 0) {
            uploadImagesEvent.uploadSuccess();
            return;
        }
        final int[] iArr = {uploadFiles.size()};
        for (final UploadFile uploadFile : uploadFiles) {
            uploadImage(uploadFile.url, new UploadImageEvent() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.34
                @Override // com.appdev.standard.page.printerlabel.TemplateEditActivity.UploadImageEvent
                public void uploadSuccess(String str) {
                    if ("bg".equals(uploadFile.type)) {
                        TemplateEditActivity.this.templateConfig.setPrinterLabelBgUrl(str);
                    } else if ("border".equals(uploadFile.type)) {
                        TemplateEditActivity.this.templateConfig.setPrinterLabelBorderUrl(str);
                    } else if ("view".equals(uploadFile.type)) {
                        uploadFile.view.updateContentToUrl(str);
                    }
                    int[] iArr2 = iArr;
                    int i5 = iArr2[0] - 1;
                    iArr2[0] = i5;
                    if (i5 == 0) {
                        uploadImagesEvent.uploadSuccess();
                    }
                }
            });
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        registerEventBus();
        super.initComponent();
        this.context = this;
        p014c0.e eVar = new p014c0.e(this);
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
        p009b0.c cVar = new p009b0.c(this);
        this.publishTemplateWorker = cVar;
        addPresenter(cVar);
        TemplateConfigBean templateConfigBean = this.templateConfig;
        if (templateConfigBean != null) {
            this.mTemplatePageView.setLabelSize(templateConfigBean.getWidth(), this.templateConfig.getHeight());
            this.mTemplatePageView.setPrinterLabelBgUrl(this.templateConfig.getPrinterLabelBgUrl());
            this.mTemplatePageView.setPrinterLabelBgBorderUrl(this.templateConfig.getPrinterLabelBorderUrl());
            this.mTemplatePageView.setPaperType(this.templateConfig.getPaperType());
            if (!Y.f(this.templateContent)) {
                this.mTemplatePageView.setWantCreateElementsByString(this.templateContent);
            }
        }
        S4.h hVar = p042h2.e.f4031a;
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        hVar.b = aVar;
        if (aVar != null && aVar.f3968l == 1) {
            this.llPushIndustryTemplates.setVisibility(0);
        } else {
            this.llPushIndustryTemplates.setVisibility(8);
        }
        p050j.w.e();
        this.mTemplatePageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                TemplateEditActivity.this.mTemplatePageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                p051j0.a.d(TemplateEditActivity.this.TAG, "模板渲染开始");
                TemplateEditActivity.this.mTemplatePageView.load();
                p050j.w.c();
                p051j0.a.d(TemplateEditActivity.this.TAG, "模板渲染完成");
                TemplateEditActivity.this.mTemplatePageView.resetAddViewLocalIndex();
            }
        });
        changeFragmentView(this.baseControlViewList);
        updateControlButton(this.baseControlViewList);
        this.downloadCenterListener = new com.appdev.standard.util.fileDownload.h() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.2
            @Override // com.appdev.standard.util.fileDownload.h
            public void onDeleted(String str) {
                super.onDeleted(str);
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onError(String str, Throwable th) {
                TemplateEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        TemplateEditActivity.this.fontDownloadProgressDialog.dismiss();
                        p042h2.d.show(p113u.g.toast_52);
                    }
                });
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onProgress(String str, long j6, long j7, boolean z6) {
                super.onProgress(str, j6, j7, z6);
                int i5 = (int) ((j6 / j7) * 100.0f);
                p051j0.a.d(TemplateEditActivity.this.TAG, "progress: " + i5);
                TemplateEditActivity.this.fontDownloadProgressDialog.a(i5);
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onStart(com.appdev.standard.util.fileDownload.a aVar2) {
                super.onStart(aVar2);
                TemplateEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TemplateEditActivity.this.fontDownloadProgressDialog = new DialogC0464q(TemplateEditActivity.this);
                        ProgressBar progressBar = TemplateEditActivity.this.fontDownloadProgressDialog.f2653a;
                        if (progressBar != null) {
                            progressBar.setMax(100);
                        }
                        TemplateEditActivity.this.fontDownloadProgressDialog.a(0);
                        TemplateEditActivity.this.fontDownloadProgressDialog.show();
                    }
                });
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onSuccess(String str) {
                TemplateEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        TemplateEditActivity.this.fontDownloadProgressDialog.dismiss();
                        p042h2.d.show(p113u.g.toast_51);
                    }
                });
            }
        };
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.setSystemBarsAppearance(8, 8);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(9472);
        }
        com.appdev.standard.util.fileDownload.g gVarB = com.appdev.standard.util.fileDownload.g.b();
        gVarB.b.add(this.downloadCenterListener);
        DrawingBoardView drawingBoardView = this.nsvTemplateEdit;
        drawingBoardView.setScale(1.0f);
        LineProgressWidget lineProgressWidget = (LineProgressWidget) findViewById(p113u.d.scale_text_size);
        lineProgressWidget.setBigValue(3.0f);
        lineProgressWidget.setSmallValue(0.5f);
        lineProgressWidget.setStepSize(0.1f);
        lineProgressWidget.setPosition(1.0f);
        this.tvScale.setText(String.format("%.1fX", Float.valueOf(1.0f)));
        drawingBoardView.setOnScaleChangeListener(new o(this, lineProgressWidget));
        lineProgressWidget.setOnProgressChangeListener(new o(this, drawingBoardView));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    @SuppressLint({"ClickableViewAccessibility"})
    public void initListener() {
        super.initListener();
        this.itbControlElementMove.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.3
            private float lastRawY;
            private boolean isMoving = false;
            private final int MIN_HEIGHT = 20;
            private final int MAX_HEIGHT = 2000;

            private boolean isInButtonArea(View view, MotionEvent motionEvent) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int i5 = iArr[0];
                if (rawX >= i5 && rawX <= view.getWidth() + i5) {
                    int i6 = iArr[1];
                    if (rawY >= i6 && rawY <= view.getHeight() + i6) {
                        return true;
                    }
                }
                return false;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                FrameLayout frameLayout = (FrameLayout) TemplateEditActivity.this.findViewById(p113u.d.fl_template_edit);
                int action = motionEvent.getAction();
                if (action == 0) {
                    if (!isInButtonArea(view, motionEvent)) {
                        return false;
                    }
                    this.lastRawY = motionEvent.getRawY();
                    this.isMoving = true;
                    return true;
                }
                if (action != 1) {
                    if (action == 2) {
                        if (!this.isMoving) {
                            return false;
                        }
                        float rawY = motionEvent.getRawY();
                        int iMax = Math.max(20, Math.min(2000, frameLayout.getHeight() - ((int) (rawY - this.lastRawY))));
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
                        layoutParams.height = iMax;
                        frameLayout.setLayoutParams(layoutParams);
                        this.lastRawY = rawY;
                        return true;
                    }
                    if (action != 3) {
                        return false;
                    }
                }
                this.isMoving = false;
                return true;
            }
        });
        this.mTemplatePageView.setOnForwardBackwardStatusListener(new TemplatePageView.OnForwardBackwardStatusListener() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.4
            @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.OnForwardBackwardStatusListener
            public void onStatus(boolean z6, boolean z7) {
                TemplateEditActivity.this.itbControlElementRevoke.setCanClick(z7);
                TemplateEditActivity.this.itbControlElementRestore.setCanClick(z6);
            }
        });
        this.nsvTemplateEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                System.out.println("setOnTouchListener    onTouch action:" + (motionEvent.getAction() & 255));
                int action = motionEvent.getAction();
                if (action == 0) {
                    TemplateEditActivity.this.baseX = motionEvent.getRawX();
                    TemplateEditActivity.this.baseY = motionEvent.getRawY();
                    return false;
                }
                if (action != 1 || Math.abs(motionEvent.getRawX() - TemplateEditActivity.this.baseX) >= 5.0f || Math.abs(motionEvent.getRawY() - TemplateEditActivity.this.baseY) >= 5.0f) {
                    return false;
                }
                System.out.println("setOnTouchListener    ACTION_UP     true");
                TemplateEditActivity templateEditActivity = TemplateEditActivity.this;
                templateEditActivity.baseControlViewList = templateEditActivity.mTemplatePageView.hasSelectedElement();
                Iterator<BaseControlView> it = TemplateEditActivity.this.baseControlViewList.iterator();
                while (it.hasNext()) {
                    it.next().deselect();
                }
                TemplateEditActivity.this.mTemplatePageView.hideDotLine();
                S4.d.b().f(new p137y.g());
                return false;
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_template_edit;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        HashMap map;
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1 && i6 == -1 && (map = (HashMap) intent.getSerializableExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY)) != null && map.containsKey("createLabelName")) {
            String str = (String) map.get("createLabelName");
            String str2 = (String) map.get("createLabelWidth");
            String str3 = (String) map.get("createLabelHeight");
            String str4 = (String) map.get("createLabelColumns");
            String str5 = (String) map.get("createLabelSpacing");
            Integer num = (Integer) map.get("createLabelPaperType");
            String str6 = (String) map.get("borderImagePath");
            String str7 = (String) map.get("backgroundImagePath");
            Integer num2 = (Integer) map.get("rotate");
            this.templateConfig.setName(str);
            try {
                this.templateConfig.setWidth(Integer.parseInt(str2));
            } catch (Exception e) {
                p051j0.a.d(this.TAG, "Failed to parse width: " + e.getMessage());
            }
            try {
                this.templateConfig.setHeight(Integer.parseInt(str3));
            } catch (Exception e6) {
                p051j0.a.d(this.TAG, "Failed to parse height: " + e6.getMessage());
            }
            try {
                this.templateConfig.setColumns(Integer.parseInt(str4));
            } catch (Exception e7) {
                p051j0.a.d(this.TAG, "Failed to parse columns: " + e7.getMessage());
            }
            try {
                this.templateConfig.setSpacing(Integer.parseInt(str5));
            } catch (Exception e8) {
                p051j0.a.d(this.TAG, "Failed to parse spacing: " + e8.getMessage());
            }
            this.templateConfig.setPaperType(num.intValue());
            this.templateConfig.setPrinterLabelBorderUrl(str6);
            this.templateConfig.setPrinterLabelBgUrl(str7);
            this.templateConfig.setRotate(num2.intValue());
            this.mTemplatePageView.updateBgView(this.templateConfig.getPrinterLabelBgUrl(), this.templateConfig.getPrinterLabelBorderUrl(), this.templateConfig.getPaperType());
            if (Y.f(str2) || Y.f(str3)) {
                return;
            }
            this.tvTemplateEditLabelName.setText(this.templateConfig.getName());
            this.tvTemplateEditLabelSpecifications.setText(String.format("%d*%dmm", Integer.valueOf(this.templateConfig.getWidth()), Integer.valueOf(this.templateConfig.getHeight())));
            this.mTemplatePageView.changeLabelSize(Integer.parseInt(str2), Integer.parseInt(str3));
        }
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onAddElementEvent(p137y.a aVar) {
        int i5 = aVar.f9010a;
        Object obj = aVar.b;
        if (i5 == 1) {
            this.mTemplatePageView.addElementView(new PrinterLabelLineView(this.mTemplatePageView), true);
            return;
        }
        if (i5 == 2) {
            this.mTemplatePageView.addElementView(new PrinterLabelShapeView(this.mTemplatePageView), true);
            return;
        }
        switch (i5) {
            case 5:
                this.mTemplatePageView.addElementView((obj == null || !(obj instanceof String)) ? new PrinterLabelTextView(this.mTemplatePageView) : new PrinterLabelTextView(this.mTemplatePageView, (String) obj), true);
                break;
            case 6:
                PrinterLabelPictureView printerLabelPictureView = new PrinterLabelPictureView(this.mTemplatePageView);
                if (obj != null && (obj instanceof JSONObject)) {
                    try {
                        JSONObject jSONObject = (JSONObject) obj;
                        printerLabelPictureView.setUploadContent(jSONObject.getString("path"));
                        printerLabelPictureView.setPicType(jSONObject.getInt("type"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                this.mTemplatePageView.addElementView(printerLabelPictureView, true);
                break;
            case 7:
                this.mTemplatePageView.addElementView(new PrinterLabelBarCodeView(this.mTemplatePageView), true);
                break;
            case 8:
                this.mTemplatePageView.addElementView(new PrinterLabelQrCodeView(this.mTemplatePageView), true);
                break;
            case 9:
                this.mTemplatePageView.addElementView(new PrinterLabelTableView(this.mTemplatePageView), true);
                break;
            case 10:
                this.mTemplatePageView.addElementView(new PrinterLabelTimeView(this.mTemplatePageView), true);
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    @OnClick({5163})
    public void onAmplifyClick(View view) {
        BaseControlView.TemplateEditTask templateEditTask;
        BaseControlView.TemplateEditTask templateEditTask2;
        if (this.itbToolbarElementAmplify.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            if (listHasSelectedElement.size() == 1) {
                BaseControlView baseControlView = this.baseControlViewList.get(0);
                int iElementType = baseControlView.elementType();
                if (iElementType == 1) {
                    final PrinterLabelLineView printerLabelLineView = (PrinterLabelLineView) baseControlView;
                    templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.11
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            ElementAttributeLineBean elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, printerLabelLineView.getJson().toString());
                            elementAttributeLineBean.setWidth((float) (((double) elementAttributeLineBean.getWidth()) * 1.1d));
                            printerLabelLineView.recoverFromJson(elementAttributeLineBean.ObjectToJson());
                        }
                    };
                } else {
                    if (iElementType != 2) {
                        switch (iElementType) {
                            case 5:
                                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.6
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                                        elementAttributeTextBean.setTextSize(elementAttributeTextBean.getTextSize() + 1.0f <= 400.0f ? elementAttributeTextBean.getTextSize() + 1.0f : 400.0f);
                                        printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 6:
                                final PrinterLabelPictureView printerLabelPictureView = (PrinterLabelPictureView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.10
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributePictureBean elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, printerLabelPictureView.getJson().toString());
                                        elementAttributePictureBean.setWidth((float) (((double) elementAttributePictureBean.getWidth()) * 1.1d));
                                        elementAttributePictureBean.setHeight((float) (((double) elementAttributePictureBean.getHeight()) * 1.1d));
                                        printerLabelPictureView.recoverFromJson(elementAttributePictureBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 7:
                                final PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.7
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, printerLabelBarCodeView.getJson().toString());
                                        elementAttributeBarCodeBean.setWidth((float) (((double) elementAttributeBarCodeBean.getWidth()) * 1.1d));
                                        elementAttributeBarCodeBean.setHeight((float) (((double) elementAttributeBarCodeBean.getHeight()) * 1.1d));
                                        printerLabelBarCodeView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 8:
                                final PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.8
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, printerLabelQrCodeView.getJson().toString());
                                        elementAttributeQrCodeBean.setWidth((float) (((double) elementAttributeQrCodeBean.getWidth()) * 1.1d));
                                        elementAttributeQrCodeBean.setHeight((float) (((double) elementAttributeQrCodeBean.getHeight()) * 1.1d));
                                        printerLabelQrCodeView.recoverFromJson(elementAttributeQrCodeBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 9:
                                final PrinterLabelTableView printerLabelTableView = (PrinterLabelTableView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.12
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTableBean elementAttributeTableBean = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, printerLabelTableView.getJson().toString());
                                        List<List> listB = p052j2.c.b(elementAttributeTableBean.getTableData(), List.class);
                                        for (int i5 = 0; i5 < listB.size(); i5++) {
                                            List<ElementAttributeTableChildBean> listB2 = p052j2.c.b(listB.get(i5), ElementAttributeTableChildBean.class);
                                            for (ElementAttributeTableChildBean elementAttributeTableChildBean : listB2) {
                                                elementAttributeTableChildBean.setColumnsWidth((float) (((double) elementAttributeTableChildBean.getColumnsWidth()) * 1.1d));
                                                elementAttributeTableChildBean.setRowsHeight((float) (((double) elementAttributeTableChildBean.getRowsHeight()) * 1.1d));
                                            }
                                            listB.set(i5, listB2);
                                        }
                                        elementAttributeTableBean.setTableData(listB);
                                        printerLabelTableView.recoverFromJson(elementAttributeTableBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 10:
                                final PrinterLabelTimeView printerLabelTimeView = (PrinterLabelTimeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.13
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, printerLabelTimeView.getJson().toString());
                                        elementAttributeTimeBean.setFontSize(elementAttributeTimeBean.getFontSize() + 1.0f <= 100.0f ? elementAttributeTimeBean.getFontSize() + 1.0f : 100.0f);
                                        printerLabelTimeView.recoverFromJson(elementAttributeTimeBean.ObjectToJson());
                                    }
                                };
                                break;
                            default:
                                templateEditTask2 = null;
                                break;
                        }
                        if (templateEditTask2 != null) {
                            baseControlView.runWithTemplateEdit(templateEditTask2);
                        }
                    }
                    final PrinterLabelShapeView printerLabelShapeView = (PrinterLabelShapeView) baseControlView;
                    templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.9
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, printerLabelShapeView.getJson().toString());
                            elementAttributeShapeBean.setWidth((float) (((double) elementAttributeShapeBean.getWidth()) * 1.1d));
                            elementAttributeShapeBean.setHeight((float) (((double) elementAttributeShapeBean.getHeight()) * 1.1d));
                            printerLabelShapeView.recoverFromJson(elementAttributeShapeBean.ObjectToJson());
                        }
                    };
                }
                templateEditTask2 = templateEditTask;
                if (templateEditTask2 != null) {
                    baseControlView.runWithTemplateEdit(templateEditTask2);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        if (this.mTemplatePageView.isHasEditTemplate()) {
            saveLabelTip();
        } else {
            finish();
        }
    }

    @OnClick({5156})
    public void onBicolorClick(View view) {
        if (this.itbControlElementBicolor.isCanClick()) {
            View viewInflate = LayoutInflater.from(this).inflate(p113u.e.dialog_bicolor, (ViewGroup) null);
            PopupWindow popupWindow = new PopupWindow(viewInflate, -1, -2, true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
            popupWindow.setElevation(4.0f);
            popupWindow.setAnimationStyle(R.style.Animation.Dialog);
            popupWindow.setFocusable(true);
            popupWindow.setOutsideTouchable(true);
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            if (listHasSelectedElement.size() != 1) {
                return;
            }
            final BaseControlView baseControlView = listHasSelectedElement.get(0);
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(p113u.d.black_selector);
            FrameLayout frameLayout2 = (FrameLayout) viewInflate.findViewById(p113u.d.red_selector);
            final ImageView imageView = (ImageView) viewInflate.findViewById(p113u.d.black_ring);
            final ImageView imageView2 = (ImageView) viewInflate.findViewById(p113u.d.red_ring);
            imageView.setVisibility(4);
            imageView2.setVisibility(4);
            try {
                JSONObject json = baseControlView.getJson();
                int iElementType = baseControlView.elementType();
                if (iElementType != 1) {
                    if (iElementType != 2) {
                        if (iElementType != 5) {
                            switch (iElementType) {
                                case 7:
                                    if (((ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString())).getColorType() != 1) {
                                        imageView.setVisibility(0);
                                    } else {
                                        imageView2.setVisibility(0);
                                    }
                                    break;
                                case 8:
                                    if (((ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, json.toString())).getColorType() != 1) {
                                        imageView.setVisibility(0);
                                    } else {
                                        imageView2.setVisibility(0);
                                    }
                                    break;
                                case 9:
                                    if (((ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, json.toString())).getColorType() != 1) {
                                        imageView.setVisibility(0);
                                    } else {
                                        imageView2.setVisibility(0);
                                    }
                                    break;
                                case 10:
                                    if (((ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, json.toString())).getColorType() != 1) {
                                        imageView.setVisibility(0);
                                    } else {
                                        imageView2.setVisibility(0);
                                    }
                                    break;
                                default:
                                    imageView.setVisibility(0);
                                    break;
                            }
                        } else if (((ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString())).getColorType() == 1) {
                            imageView2.setVisibility(0);
                        } else {
                            imageView.setVisibility(0);
                        }
                    } else if (((ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, json.toString())).getColorType() == 1) {
                        imageView2.setVisibility(0);
                    } else {
                        imageView.setVisibility(0);
                    }
                } else if (((ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, json.toString())).getColorType() == 1) {
                    imageView2.setVisibility(0);
                } else {
                    imageView.setVisibility(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                imageView.setVisibility(0);
            }
            final int i5 = 0;
            frameLayout.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.printerlabel.N
                public final /* synthetic */ TemplateEditActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i5) {
                        case 0:
                            this.b.lambda$onBicolorClick$2(imageView, imageView2, baseControlView, view2);
                            break;
                        default:
                            this.b.lambda$onBicolorClick$3(imageView, imageView2, baseControlView, view2);
                            break;
                    }
                }
            });
            final int i6 = 1;
            frameLayout2.setOnClickListener(new View.OnClickListener(this) { // from class: com.appdev.standard.page.printerlabel.N
                public final /* synthetic */ TemplateEditActivity b;

                {
                    this.b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    switch (i6) {
                        case 0:
                            this.b.lambda$onBicolorClick$2(imageView2, imageView, baseControlView, view2);
                            break;
                        default:
                            this.b.lambda$onBicolorClick$3(imageView2, imageView, baseControlView, view2);
                            break;
                    }
                }
            });
            viewInflate.measure(0, 0);
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            popupWindow.showAtLocation(view, 0, 0, iArr[1] - viewInflate.getMeasuredHeight());
            viewInflate.findViewById(p113u.d.popup_container).setOnClickListener(new v(popupWindow, 1));
        }
    }

    @OnClick({5207})
    public void onControlMiss(View view) {
        FrameLayout frameLayout = this.flTemplateEdit;
        frameLayout.setVisibility(frameLayout.getVisibility() == 0 ? 8 : 0);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onControlViewEditEvent(p137y.f fVar) {
        updateControlButton(this.baseControlViewList);
    }

    @OnClick({5164})
    public void onCopyClick(View view) {
        if (this.itbToolbarElementCopy.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            if (listHasSelectedElement.size() == 1) {
                this.mTemplatePageView.copySelectedElement(this.baseControlViewList.get(0));
            }
        }
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String stringExtra;
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("background_uri")) != null) {
            takePersistableUriPermission(Uri.parse(stringExtra));
        }
        super.onCreate(null);
        if (getIntent() == null || getIntent().getExtras() == null) {
            return;
        }
        this.rotate = getIntent().getIntExtra("rotate", 0);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onCurrentEditViewEvent(p137y.g gVar) {
        List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
        this.baseControlViewList = listHasSelectedElement;
        changeFragmentView(listHasSelectedElement);
        updateControlButton(this.baseControlViewList);
    }

    public void onDarkModeClick(View view) {
        if (this.itbControlElementDarkMode.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            if (listHasSelectedElement.size() != 1) {
                return;
            }
            final BaseControlView baseControlView = listHasSelectedElement.get(0);
            if (baseControlView.elementType() != 5) {
                return;
            }
            try {
                final boolean z6 = !((ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, baseControlView.getJson().toString())).isDarkMode();
                baseControlView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.24
                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                    public void run() {
                        ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, baseControlView.getJson().toString());
                        elementAttributeTextBean.setDarkMode(z6);
                        baseControlView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                        S4.d.b().f(new p137y.g());
                    }
                });
                p051j0.a.c("DarkMode", "Dark mode toggled to: " + z6);
            } catch (Exception e) {
                e.printStackTrace();
                p051j0.a.d("DarkMode", "Error toggling dark mode: " + e.getMessage());
            }
        }
    }

    @OnClick({5165})
    public void onDeleteClick(View view) {
        if (this.itbToolbarElementDelete.isCanClick()) {
            this.mTemplatePageView.deleteSelectedElement();
            changeFragmentView(null);
            updateControlButton(null);
        }
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onDeleteElementEvent(p137y.h hVar) {
        if (hVar.f9013a) {
            changeFragmentView(null);
            updateControlButton(null);
        } else {
            this.mTemplatePageView.deleteSelectedElement();
            changeFragmentView(null);
            updateControlButton(null);
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.downloadCenterListener != null) {
            com.appdev.standard.util.fileDownload.g gVarB = com.appdev.standard.util.fileDownload.g.b();
            gVarB.b.remove(this.downloadCenterListener);
        }
        super.onDestroy();
    }

    public void onDialogClick(View view) {
        boolean z6 = this.dialogIsShow;
        this.dialogIsShow = !z6;
        if (z6) {
            this.rlTemplateEditDialog.setVisibility(8);
        } else {
            this.rlTemplateEditDialog.setVisibility(0);
        }
    }

    public void onDialogOutsizeClick(View view) {
        this.dialogIsShow = false;
        this.rlTemplateEditDialog.setVisibility(8);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x006b  */
    /* JADX WARN: Code duplicated, block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @S4.k(threadMode = ThreadMode.MAIN)
    public void onEditContentEvent(final p137y.l lVar) {
        final ElementAttributeTextBean elementAttributeTextBean;
        final ElementAttributeBarCodeBean elementAttributeBarCodeBean;
        final ElementAttributeTableChildBean elementAttributeTableChildBean;
        BaseControlView baseControlView = lVar.f9017a;
        BaseControlView baseControlView2 = lVar.f9017a;
        boolean z6 = true;
        ContentEditDialog contentEditDialog = baseControlView instanceof PrinterLabelBarCodeView ? new ContentEditDialog(this, 1) : new ContentEditDialog(this, 3);
        JSONObject json = baseControlView2.getJson();
        if (!(baseControlView2 instanceof PrinterLabelTextView)) {
            if (baseControlView2 instanceof PrinterLabelBarCodeView) {
                ElementAttributeBarCodeBean elementAttributeBarCodeBean2 = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, json.toString());
                contentEditDialog.a(elementAttributeBarCodeBean2.getContent());
                elementAttributeBarCodeBean = elementAttributeBarCodeBean2;
                elementAttributeTextBean = null;
                elementAttributeTableChildBean = 0;
            } else if (baseControlView2 instanceof PrinterLabelTableView) {
                ElementAttributeTableChildBean selectedChildBean = ((PrinterLabelTableView) baseControlView2).getSelectedChildBean();
                contentEditDialog.a(selectedChildBean.getContent());
                elementAttributeTableChildBean = selectedChildBean;
                elementAttributeTextBean = null;
                elementAttributeBarCodeBean = null;
            } else {
                z6 = false;
                elementAttributeTextBean = null;
                elementAttributeBarCodeBean = null;
            }
            if (z6) {
                contentEditDialog.show();
                contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25
                    @Override // com.appdev.standard.dialog.InterfaceC0453f
                    public void setNewContent(final String str) {
                        BaseControlView baseControlView3 = lVar.f9017a;
                        if ((baseControlView3 instanceof PrinterLabelTextView) && elementAttributeTextBean != null) {
                            final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView3;
                            printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.1
                                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                public void run() {
                                    elementAttributeTextBean.setContent(str);
                                    printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                                    S4.d.b().f(new p137y.g());
                                }
                            });
                        } else if ((baseControlView3 instanceof PrinterLabelBarCodeView) && elementAttributeBarCodeBean != null) {
                            final PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView3;
                            printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.2
                                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                public void run() {
                                    elementAttributeBarCodeBean.setContent(str);
                                    printerLabelBarCodeView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                    S4.d.b().f(new p137y.g());
                                }
                            });
                        } else {
                            if (!(baseControlView3 instanceof PrinterLabelTableView) || elementAttributeTableChildBean == null) {
                                return;
                            }
                            final PrinterLabelTableView printerLabelTableView = (PrinterLabelTableView) baseControlView3;
                            printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.3
                                @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                public void run() {
                                    elementAttributeTableChildBean.setContent(str);
                                    PrinterLabelTableView printerLabelTableView2 = printerLabelTableView;
                                    printerLabelTableView2.recoverFromJson(printerLabelTableView2.getJson());
                                    S4.d.b().f(new p137y.g());
                                }
                            });
                        }
                    }
                };
            }
        }
        ElementAttributeTextBean elementAttributeTextBean2 = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, json.toString());
        contentEditDialog.a(elementAttributeTextBean2.getContent());
        elementAttributeTextBean = elementAttributeTextBean2;
        elementAttributeBarCodeBean = null;
        elementAttributeTableChildBean = elementAttributeBarCodeBean;
        if (z6) {
            contentEditDialog.show();
            contentEditDialog.b = new InterfaceC0453f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25
                @Override // com.appdev.standard.dialog.InterfaceC0453f
                public void setNewContent(final String str) {
                    BaseControlView baseControlView3 = lVar.f9017a;
                    if ((baseControlView3 instanceof PrinterLabelTextView) && elementAttributeTextBean != null) {
                        final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView3;
                        printerLabelTextView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.1
                            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                            public void run() {
                                elementAttributeTextBean.setContent(str);
                                printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                                S4.d.b().f(new p137y.g());
                            }
                        });
                    } else if ((baseControlView3 instanceof PrinterLabelBarCodeView) && elementAttributeBarCodeBean != null) {
                        final PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView3;
                        printerLabelBarCodeView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.2
                            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                            public void run() {
                                elementAttributeBarCodeBean.setContent(str);
                                printerLabelBarCodeView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                S4.d.b().f(new p137y.g());
                            }
                        });
                    } else {
                        if (!(baseControlView3 instanceof PrinterLabelTableView) || elementAttributeTableChildBean == null) {
                            return;
                        }
                        final PrinterLabelTableView printerLabelTableView = (PrinterLabelTableView) baseControlView3;
                        printerLabelTableView.runWithTemplateEdit(new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.25.3
                            @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                            public void run() {
                                elementAttributeTableChildBean.setContent(str);
                                PrinterLabelTableView printerLabelTableView2 = printerLabelTableView;
                                printerLabelTableView2.recoverFromJson(printerLabelTableView2.getJson());
                                S4.d.b().f(new p137y.g());
                            }
                        });
                    }
                }
            };
        }
    }

    @OnClick({5155})
    public void onElementClick(View view) {
        changeFragmentView(null);
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onImportExcelEvent(p137y.q qVar) {
        this.mTemplatePageView.resetAddViewLocalIndex();
        List<HashMap> list = qVar.c;
        Boolean bool = qVar.d;
        int layoutHeight = 0;
        for (HashMap map : list) {
            String strO = (String) map.get("data");
            String str = (String) map.get("header");
            String str2 = (String) map.get("importType");
            Integer num = (Integer) map.get(FirebaseAnalytics.Param.INDEX);
            if (bool.booleanValue()) {
                strO = androidx.collection.a.o(str, ParameterizedMessage.ERROR_MSG_SEPARATOR, strO);
            }
            String str3 = strO;
            if (str2.equals("text")) {
                PrinterLabelTextView printerLabelTextView = new PrinterLabelTextView(this.mTemplatePageView, str3, qVar.b, qVar.f9020a, num.intValue(), bool.booleanValue());
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) printerLabelTextView.getLayoutParams();
                layoutParams.leftMargin = this.mTemplatePageView.getStartX();
                layoutParams.topMargin = this.mTemplatePageView.getStartY() + layoutHeight;
                layoutHeight += printerLabelTextView.getLayoutHeight();
                this.mTemplatePageView.addElementView(printerLabelTextView, false);
            } else if (str2.equals("qrcode")) {
                PrinterLabelQrCodeView printerLabelQrCodeView = new PrinterLabelQrCodeView(this.mTemplatePageView, str3, (String) map.get("codec"), qVar.b, qVar.f9020a, num.intValue(), bool.booleanValue());
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) printerLabelQrCodeView.getLayoutParams();
                layoutParams2.leftMargin = this.mTemplatePageView.getStartX();
                layoutParams2.topMargin = this.mTemplatePageView.getStartY() + layoutHeight;
                layoutHeight += printerLabelQrCodeView.getLayoutHeight();
                this.mTemplatePageView.addElementView(printerLabelQrCodeView, false);
            } else if (str2.equals(OptionalModuleUtils.BARCODE)) {
                PrinterLabelBarCodeView printerLabelBarCodeView = new PrinterLabelBarCodeView(this.mTemplatePageView, str3, (String) map.get("codec"), qVar.b, qVar.f9020a, num.intValue(), bool.booleanValue());
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) printerLabelBarCodeView.getLayoutParams();
                layoutParams3.leftMargin = this.mTemplatePageView.getStartX();
                layoutParams3.topMargin = this.mTemplatePageView.getStartY() + layoutHeight;
                layoutHeight += printerLabelBarCodeView.getLayoutHeight();
                this.mTemplatePageView.addElementView(printerLabelBarCodeView, false);
            }
        }
    }

    public void onLabelShareClick(View view) {
        S4.h hVar = p042h2.e.f4031a;
        if (!hVar.g()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
            return;
        }
        p032f2.a aVarE = hVar.e();
        if (haveTableElement() && !hVar.h()) {
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
            defaultTipDialog.e("");
            defaultTipDialog.c(getString(p113u.g.text_249));
            defaultTipDialog.a(getString(p113u.g.text_254));
            defaultTipDialog.b(getString(p113u.g.text_255));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.29
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
        if (aVarE == null || Integer.valueOf(aVarE.f3966j).intValue() > Integer.valueOf(aVarE.f3965i).intValue()) {
            uploadImageOfLabel(new M(this, 5));
            this.rlTemplateEditDialog.setVisibility(8);
            return;
        }
        DefaultTipDialog defaultTipDialog2 = new DefaultTipDialog(this.context);
        defaultTipDialog2.e("");
        defaultTipDialog2.c(getString(p113u.g.text_473));
        defaultTipDialog2.a(getString(p113u.g.cancel));
        defaultTipDialog2.b(getString(p113u.g.text_256));
        defaultTipDialog2.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.30
            @Override // com.library.base.frame.d
            public void onConfirm() {
                androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MEMBER_CENTER);
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog2.show();
    }

    @OnClick({5158})
    public void onLockClick(View view) {
        if (this.itbControlElementLock.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            if (listHasSelectedElement.size() == 1) {
                BaseControlView baseControlView = this.baseControlViewList.get(0);
                boolean zIsLockLocation = baseControlView.isLockLocation();
                baseControlView.setLockLocation(!zIsLockLocation);
                if (zIsLockLocation) {
                    this.itbControlElementLock.setItbIcon(p113u.f.ic_template_element_lock_true);
                    this.itbControlElementLock.setItbContent(getString(p113u.g.lock));
                } else {
                    this.itbControlElementLock.setItbIcon(p113u.f.ic_template_element_lock_false);
                    this.itbControlElementLock.setItbContent(getString(p113u.g.unlock));
                }
            }
        }
    }

    public void onPublishIndustryTemplateClick(View view) {
        if (haveTableElement()) {
            S4.h hVar = p042h2.e.f4031a;
            if (hVar.g() && !hVar.h()) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_249));
                defaultTipDialog.a(getString(p113u.g.text_254));
                defaultTipDialog.b(getString(p113u.g.text_255));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.32
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
        }
        uploadImageOfLabel(new M(this, 1));
        this.rlTemplateEditDialog.setVisibility(8);
    }

    public void onPublishSquareClick(View view) {
        if (haveTableElement()) {
            S4.h hVar = p042h2.e.f4031a;
            if (hVar.g() && !hVar.h()) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_249));
                defaultTipDialog.a(getString(p113u.g.text_254));
                defaultTipDialog.b(getString(p113u.g.text_255));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.28
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
        }
        uploadImageOfLabel(new M(this, 4));
        this.rlTemplateEditDialog.setVisibility(8);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    @OnClick({5166})
    public void onReduceClick(View view) {
        BaseControlView.TemplateEditTask templateEditTask;
        BaseControlView.TemplateEditTask templateEditTask2;
        if (this.itbToolbarElementReduce.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            if (listHasSelectedElement.size() == 1) {
                BaseControlView baseControlView = this.baseControlViewList.get(0);
                int iElementType = baseControlView.elementType();
                if (iElementType == 1) {
                    final PrinterLabelLineView printerLabelLineView = (PrinterLabelLineView) baseControlView;
                    templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.19
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            ElementAttributeLineBean elementAttributeLineBean = (ElementAttributeLineBean) p052j2.c.c(ElementAttributeLineBean.class, printerLabelLineView.getJson().toString());
                            elementAttributeLineBean.setWidth((float) (((double) elementAttributeLineBean.getWidth()) * 0.9d));
                            printerLabelLineView.recoverFromJson(elementAttributeLineBean.ObjectToJson());
                        }
                    };
                } else {
                    if (iElementType != 2) {
                        switch (iElementType) {
                            case 5:
                                final PrinterLabelTextView printerLabelTextView = (PrinterLabelTextView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.14
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.c(ElementAttributeTextBean.class, printerLabelTextView.getJson().toString());
                                        elementAttributeTextBean.setTextSize(elementAttributeTextBean.getTextSize() - 1.0f >= 3.0f ? elementAttributeTextBean.getTextSize() - 1.0f : 3.0f);
                                        printerLabelTextView.recoverFromJson(elementAttributeTextBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 6:
                                final PrinterLabelPictureView printerLabelPictureView = (PrinterLabelPictureView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.18
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributePictureBean elementAttributePictureBean = (ElementAttributePictureBean) p052j2.c.c(ElementAttributePictureBean.class, printerLabelPictureView.getJson().toString());
                                        elementAttributePictureBean.setWidth((float) (((double) elementAttributePictureBean.getWidth()) * 0.9d));
                                        elementAttributePictureBean.setHeight((float) (((double) elementAttributePictureBean.getHeight()) * 0.9d));
                                        printerLabelPictureView.recoverFromJson(elementAttributePictureBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 7:
                                final PrinterLabelBarCodeView printerLabelBarCodeView = (PrinterLabelBarCodeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.15
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.c(ElementAttributeBarCodeBean.class, printerLabelBarCodeView.getJson().toString());
                                        elementAttributeBarCodeBean.setWidth((float) (((double) elementAttributeBarCodeBean.getWidth()) * 0.9d));
                                        elementAttributeBarCodeBean.setHeight((float) (((double) elementAttributeBarCodeBean.getHeight()) * 0.9d));
                                        printerLabelBarCodeView.recoverFromJson(elementAttributeBarCodeBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 8:
                                final PrinterLabelQrCodeView printerLabelQrCodeView = (PrinterLabelQrCodeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.16
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeQrCodeBean elementAttributeQrCodeBean = (ElementAttributeQrCodeBean) p052j2.c.c(ElementAttributeQrCodeBean.class, printerLabelQrCodeView.getJson().toString());
                                        elementAttributeQrCodeBean.setWidth((float) (((double) elementAttributeQrCodeBean.getWidth()) * 0.9d));
                                        elementAttributeQrCodeBean.setHeight((float) (((double) elementAttributeQrCodeBean.getHeight()) * 0.9d));
                                        printerLabelQrCodeView.recoverFromJson(elementAttributeQrCodeBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 9:
                                final PrinterLabelTableView printerLabelTableView = (PrinterLabelTableView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.20
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTableBean elementAttributeTableBean = (ElementAttributeTableBean) p052j2.c.c(ElementAttributeTableBean.class, printerLabelTableView.getJson().toString());
                                        List<List> listB = p052j2.c.b(elementAttributeTableBean.getTableData(), List.class);
                                        for (int i5 = 0; i5 < listB.size(); i5++) {
                                            List<ElementAttributeTableChildBean> listB2 = p052j2.c.b(listB.get(i5), ElementAttributeTableChildBean.class);
                                            for (ElementAttributeTableChildBean elementAttributeTableChildBean : listB2) {
                                                elementAttributeTableChildBean.setColumnsWidth((float) (((double) elementAttributeTableChildBean.getColumnsWidth()) * 0.9d));
                                                elementAttributeTableChildBean.setRowsHeight((float) (((double) elementAttributeTableChildBean.getRowsHeight()) * 0.9d));
                                            }
                                            listB.set(i5, listB2);
                                        }
                                        elementAttributeTableBean.setTableData(listB);
                                        printerLabelTableView.recoverFromJson(elementAttributeTableBean.ObjectToJson());
                                    }
                                };
                                break;
                            case 10:
                                final PrinterLabelTimeView printerLabelTimeView = (PrinterLabelTimeView) baseControlView;
                                templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.21
                                    @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                                    public void run() {
                                        ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.c(ElementAttributeTimeBean.class, printerLabelTimeView.getJson().toString());
                                        elementAttributeTimeBean.setFontSize(elementAttributeTimeBean.getFontSize() - 1.0f >= 3.0f ? elementAttributeTimeBean.getFontSize() - 1.0f : 3.0f);
                                        printerLabelTimeView.recoverFromJson(elementAttributeTimeBean.ObjectToJson());
                                    }
                                };
                                break;
                            default:
                                templateEditTask2 = null;
                                break;
                        }
                        if (templateEditTask2 != null) {
                            baseControlView.runWithTemplateEdit(templateEditTask2);
                        }
                    }
                    final PrinterLabelShapeView printerLabelShapeView = (PrinterLabelShapeView) baseControlView;
                    templateEditTask = new BaseControlView.TemplateEditTask() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.17
                        @Override // com.appdev.standard.page.printerlabel.widget.BaseControlView.TemplateEditTask
                        public void run() {
                            ElementAttributeShapeBean elementAttributeShapeBean = (ElementAttributeShapeBean) p052j2.c.c(ElementAttributeShapeBean.class, printerLabelShapeView.getJson().toString());
                            elementAttributeShapeBean.setWidth((float) (((double) elementAttributeShapeBean.getWidth()) * 0.9d));
                            elementAttributeShapeBean.setHeight((float) (((double) elementAttributeShapeBean.getHeight()) * 0.9d));
                            printerLabelShapeView.recoverFromJson(elementAttributeShapeBean.ObjectToJson());
                        }
                    };
                }
                templateEditTask2 = templateEditTask;
                if (templateEditTask2 != null) {
                    baseControlView.runWithTemplateEdit(templateEditTask2);
                }
            }
        }
    }

    @OnClick({5160})
    public void onRestoreClick(View view) {
        if (this.itbControlElementRestore.isCanClick()) {
            this.mTemplatePageView.goForward();
        }
    }

    @Override // com.library.base.frame.FrameActivity
    public void onReturnClick(View view) {
        if (this.mTemplatePageView.isHasEditTemplate()) {
            saveLabelTip();
        } else {
            finish();
        }
    }

    @OnClick({5161})
    public void onRevokeClick(View view) {
        if (this.itbControlElementRevoke.isCanClick()) {
            this.mTemplatePageView.goBack();
        }
    }

    @OnClick({5167})
    public void onRotateClick(View view) {
        if (this.itbToolbarElementRotate.isCanClick()) {
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            if (listHasSelectedElement.size() == 1) {
                BaseControlView baseControlView = this.baseControlViewList.get(0);
                baseControlView.setRotationAngle((baseControlView.getRotationAngle() + 90) % 360);
            }
        }
    }

    public void onSaveToCloudLabelClick(View view) {
        if (p042h2.e.f4031a.h()) {
            uploadImageOfLabel(new M(this, 2));
            this.rlTemplateEditDialog.setVisibility(8);
            return;
        }
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
        defaultTipDialog.e("");
        defaultTipDialog.c(getString(p113u.g.text_246));
        defaultTipDialog.a(getString(p113u.g.text_254));
        defaultTipDialog.b(getString(p113u.g.text_255));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.27
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

    public void onSaveToPersonalSpaceClick(View view) {
        if (haveTableElement()) {
            S4.h hVar = p042h2.e.f4031a;
            if (hVar.g() && !hVar.h()) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_249));
                defaultTipDialog.a(getString(p113u.g.text_254));
                defaultTipDialog.b(getString(p113u.g.text_255));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.26
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
        }
        uploadImageOfLabel(new M(this, 0));
        this.rlTemplateEditDialog.setVisibility(8);
    }

    @OnClick({6258})
    public void onScaleClick(View view) {
        this.nsvTemplateEdit.setScale(1.0f);
        this.nsvTemplateEdit.moveToDefaultPosition();
    }

    @OnClick({5162})
    public void onSelectClick(View view) {
        if (this.mTemplatePageView.isMultipleMode()) {
            this.itbControlElementSelect.setCanClick(true);
            this.mTemplatePageView.setMultipleMode(false);
            this.itbControlElementSelect.setContent(getString(p113u.g.text_300));
            List<BaseControlView> listHasSelectedElement = this.mTemplatePageView.hasSelectedElement();
            this.baseControlViewList = listHasSelectedElement;
            Iterator<BaseControlView> it = listHasSelectedElement.iterator();
            while (it.hasNext()) {
                it.next().deselect();
            }
        } else {
            this.itbControlElementSelect.setCanClick(false);
            this.mTemplatePageView.setMultipleMode(true);
            this.itbControlElementSelect.setContent(getString(p113u.g.text_301));
        }
        S4.d.b().f(new p137y.g());
    }

    public void onTemplateEditPrintClick(View view) {
        System.out.println("mTemplatePageView.getChildCount():    " + this.mTemplatePageView.getChildCount());
        if (haveTableElement()) {
            S4.h hVar = p042h2.e.f4031a;
            if (hVar.g() && !hVar.h()) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_249));
                defaultTipDialog.a(getString(p113u.g.text_254));
                defaultTipDialog.b(getString(p113u.g.text_255));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.37
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
        }
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
            return;
        }
        if (this.mTemplatePageView.getChildCount() > 1) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data_template_config", this.templateConfig);
            bundle.putString("data_template_content", p052j2.c.e(this.mTemplatePageView.getPrinterData()));
            bundle.putInt("data_print_data_source", this.dataSource);
            bundle.putString("data_print_share_link", this.printShareLink);
            bundle.putString("data_print_cover_url", Y.f(this.printCoverUrl) ? "" : this.printCoverUrl);
            bundle.putString("data_print_title", Y.f(this.printTitle) ? this.templateConfig.getName() : this.printTitle);
            bundle.putString("personLabelId", this.personLabelId);
            bundle.putInt("rotate", this.templateConfig.getRotate());
            p051j0.a.c(this.TAG, "旋转方向" + this.templateConfig.getRotate());
            ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINT_PAGE).with(bundle).navigation();
        }
    }

    public void onTemplateEditSaveClick(View view) {
        if (haveTableElement()) {
            S4.h hVar = p042h2.e.f4031a;
            if (hVar.g() && !hVar.h()) {
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this.context);
                defaultTipDialog.e("");
                defaultTipDialog.c(getString(p113u.g.text_249));
                defaultTipDialog.a(getString(p113u.g.text_254));
                defaultTipDialog.b(getString(p113u.g.text_255));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.printerlabel.TemplateEditActivity.36
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
        }
        uploadImageOfLabel(new M(this, 3));
    }

    public void onTemplateEditSettingClick(View view) {
        HashMap map = new HashMap();
        map.put("createLabelName", this.templateConfig.getName());
        map.put("createLabelWidth", String.valueOf(this.templateConfig.getWidth()));
        map.put("createLabelHeight", String.valueOf(this.templateConfig.getHeight()));
        map.put("createLabelColumns", String.valueOf(this.templateConfig.getColumns()));
        map.put("createLabelSpacing", String.valueOf(this.templateConfig.getSpacing()));
        map.put("createLabelPaperType", String.valueOf(this.templateConfig.getPaperType()));
        map.put("createLabelBorderUrl", this.templateConfig.getPrinterLabelBorderUrl());
        map.put("createLabelBgUrl", this.templateConfig.getPrinterLabelBgUrl());
        map.put("rotate", Integer.valueOf(this.templateConfig.getRotate()));
        FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("edit_label").arguments(map).requestCode(1).build());
    }

    @S4.k(threadMode = ThreadMode.MAIN)
    public void onTestEvent(p137y.n nVar) {
        changeFragmentView(null);
    }

    @Override // p009b0.a
    public void publishTemplateFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // p009b0.a
    public void publishTemplateSuccess(String str) {
        p050j.w.c();
        str.getClass();
        switch (str) {
            case "1":
                this.mTemplatePageView.saveEditTemplate();
                p042h2.d.show(p113u.g.toast_57);
                break;
            case "2":
                this.mTemplatePageView.saveEditTemplate();
                p042h2.d.show(p113u.g.toast_56);
                break;
            case "3":
                this.mTemplatePageView.saveEditTemplate();
                p042h2.d.show(p113u.g.toast_54);
                S4.d.b().f(new p137y.t());
                break;
            case "4":
                this.mTemplatePageView.saveEditTemplate();
                p042h2.d.show(p113u.g.toast_55);
                break;
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        TemplateConfigBean templateConfigBean = (TemplateConfigBean) bundle.getSerializable("data_template_config");
        this.templateConfig = templateConfigBean;
        if (templateConfigBean == null) {
            this.templateConfig = new TemplateConfigBean("label", 60, 30, 1, 0);
        } else {
            this.tvTemplateEditLabelName.setText(templateConfigBean.getName());
            this.tvTemplateEditLabelSpecifications.setText(String.format("%d*%dmm", Integer.valueOf(this.templateConfig.getWidth()), Integer.valueOf(this.templateConfig.getHeight())));
        }
        this.personLabelId = bundle.getString("personLabelId", String.valueOf(System.currentTimeMillis()) + String.format("%06d", Integer.valueOf(new Random().nextInt(900000) + BZip2Constants.BASEBLOCKSIZE)));
        this.cloudLabelId = bundle.getString("cloudLabelId", String.valueOf(System.currentTimeMillis()) + String.format("%06d", Integer.valueOf(new Random().nextInt(900000) + BZip2Constants.BASEBLOCKSIZE)));
        this.dataSource = bundle.getInt("data_print_data_source", 6);
        this.printShareLink = bundle.getString("data_print_share_link");
        this.printCoverUrl = bundle.getString("data_print_cover_url");
        this.printTitle = bundle.getString("data_print_title");
        this.templateContent = bundle.getString("data_template_content", null);
    }

    public void updateCloudBiaoQianFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    public void updateCloudBiaoQianSuccess() {
        p050j.w.c();
        p042h2.d.show(p113u.g.toast_58);
        this.mTemplatePageView.saveEditTemplate();
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        p050j.w.c();
        TemplatePto templatePto = new TemplatePto();
        str2.getClass();
        switch (str2) {
            case "1":
                TemplateElementPto templateElementPto = new TemplateElementPto();
                templateElementPto.setCoverUrl(str);
                templateElementPto.setHeight(this.templateConfig.getHeight());
                templateElementPto.setWidth(this.templateConfig.getWidth());
                templateElementPto.setTemplateType("1");
                templateElementPto.setTitle(this.templateConfig.getName());
                templatePto.setModule(new TemplateModulePto());
                templatePto.setViews(this.mTemplatePageView.getElementDataList());
                templatePto.setPaper(new TemplatePaperPto(this.templateConfig.getWidth(), this.templateConfig.getHeight(), this.templateConfig.getPrinterLabelBgUrl(), this.templateConfig.getColumns(), this.templateConfig.getSpacing(), this.templateConfig.getPrinterLabelBorderUrl(), this.templateConfig.getPaperType(), this.templateConfig.getRotate()));
                templateElementPto.setContent(templatePto.toJson());
                Bundle bundle = new Bundle();
                bundle.putSerializable("TemplateElementPto", templateElementPto);
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PUBLISH_TO_INDUSTRY).with(bundle).navigation();
                break;
            case "2":
                TemplateElementPto templateElementPto2 = new TemplateElementPto();
                templateElementPto2.setCoverUrl(str);
                templateElementPto2.setHeight(this.templateConfig.getHeight());
                templateElementPto2.setWidth(this.templateConfig.getWidth());
                templateElementPto2.setTemplateType(ExifInterface.GPS_MEASUREMENT_2D);
                templateElementPto2.setTitle(this.templateConfig.getName());
                templatePto.setModule(new TemplateModulePto());
                templatePto.setViews(this.mTemplatePageView.getElementDataList());
                templatePto.setPaper(new TemplatePaperPto(this.templateConfig.getWidth(), this.templateConfig.getHeight(), this.templateConfig.getPrinterLabelBgUrl(), this.templateConfig.getColumns(), this.templateConfig.getSpacing(), this.templateConfig.getPrinterLabelBorderUrl(), this.templateConfig.getPaperType(), this.templateConfig.getRotate()));
                templateElementPto2.setContent(templatePto.toJson());
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("TemplateElementPto", templateElementPto2);
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PUBLISH_TO_SQUARE).with(bundle2).navigation();
                break;
            case "3":
                TemplateElementPto templateElementPto3 = new TemplateElementPto();
                templateElementPto3.setTemplateId(this.personLabelId);
                templateElementPto3.setCoverUrl(str);
                templateElementPto3.setHeight(this.templateConfig.getHeight());
                templateElementPto3.setWidth(this.templateConfig.getWidth());
                templateElementPto3.setTemplateType(ExifInterface.GPS_MEASUREMENT_3D);
                templateElementPto3.setTitle(this.templateConfig.getName());
                templatePto.setModule(new TemplateModulePto());
                templatePto.setViews(this.mTemplatePageView.getElementDataList());
                templatePto.setPaper(new TemplatePaperPto(this.templateConfig.getWidth(), this.templateConfig.getHeight(), this.templateConfig.getPrinterLabelBgUrl(), this.templateConfig.getColumns(), this.templateConfig.getSpacing(), this.templateConfig.getPrinterLabelBorderUrl(), this.templateConfig.getPaperType(), this.templateConfig.getRotate()));
                templateElementPto3.setContent(templatePto.toJson());
                p050j.w.e();
                this.publishTemplateWorker.a(templateElementPto3, ExifInterface.GPS_MEASUREMENT_3D);
                break;
            case "4":
                TemplateElementPto templateElementPto4 = new TemplateElementPto();
                templateElementPto4.setTemplateId(this.cloudLabelId);
                templateElementPto4.setCoverUrl(str);
                templateElementPto4.setHeight(this.templateConfig.getHeight());
                templateElementPto4.setWidth(this.templateConfig.getWidth());
                templateElementPto4.setTemplateType("4");
                templateElementPto4.setTitle(this.templateConfig.getName());
                templatePto.setModule(new TemplateModulePto());
                templatePto.setViews(this.mTemplatePageView.getElementDataList());
                templatePto.setPaper(new TemplatePaperPto(this.templateConfig.getWidth(), this.templateConfig.getHeight(), this.templateConfig.getPrinterLabelBgUrl(), this.templateConfig.getColumns(), this.templateConfig.getSpacing(), this.templateConfig.getPrinterLabelBorderUrl(), this.templateConfig.getPaperType(), this.templateConfig.getRotate()));
                templateElementPto4.setContent(templatePto.toJson());
                p050j.w.e();
                this.publishTemplateWorker.a(templateElementPto4, "4");
                break;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class UploadFile {
        public String type;
        public String url;
        public PrinterLabelPictureView view;

        public UploadFile(String str, String str2) {
            this.url = str;
            this.type = str2;
        }

        public UploadFile(String str, String str2, PrinterLabelPictureView printerLabelPictureView) {
            this.url = str;
            this.type = str2;
            this.view = printerLabelPictureView;
        }
    }

    private void changeFragmentView(List<BaseControlView> list) {
        if (list != null && list.size() != 0) {
            this.baseFragment = new ElementAttributeFragment(list, this.mTemplatePageView);
        } else {
            this.baseFragment = new ElementAllFragment();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        this.fragmentTransaction = fragmentTransactionBeginTransaction;
        fragmentTransactionBeginTransaction.replace(p113u.d.fl_template_edit, this.baseFragment, String.valueOf(System.currentTimeMillis()));
        this.fragmentTransaction.commit();
    }
}
