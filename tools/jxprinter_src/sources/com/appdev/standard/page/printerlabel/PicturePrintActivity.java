package com.appdev.standard.page.printerlabel;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.page.bluetooth.CurrentPrinterFragment;
import com.appdev.standard.page.bluetooth.PrintSetting;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Y;
import org.apache.xmlbeans.impl.common.NameUtil;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;
import p134x2.a1;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PICTURE_PRINT)
public class PicturePrintActivity extends MvpActivity {
    private Context context;
    private boolean isInitSize;

    @Autowired(name = "rotate")
    boolean isRotate;

    @BindView(5267)
    ImageView ivMirror;

    @BindView(5268)
    ImageView ivNoMirror;
    private PrintMode lastNonAutoMode;

    @BindView(5482)
    LinearLayout llRange;

    @BindView(5495)
    LinearLayout llRotate;
    private S.a logWorker;
    private PrintSetting mCustomPopWindow;
    private p056k0.i mediaPicker;
    private p056k0.l modelDownloadListener;
    private com.appdev.standard.dialog.y modelDownloadProgressDialog;

    @Autowired(name = "path")
    String path;
    private p056k0.q pictureUtil;
    private P0 printInfo;
    private PrintMode printMode;

    @BindView(5728)
    QuantitySelectorWidget qswPdfPrintPrintHeight;

    @BindView(5730)
    QuantitySelectorWidget qswPdfPrintPrintWidth;

    @BindView(5731)
    QuantitySelectorWidget qswPicturePrintPrintCount;

    @BindView(5732)
    QuantitySelectorWidget qswPicturePrintPrintEnd;

    @BindView(5733)
    QuantitySelectorWidget qswPicturePrintPrintStart;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5742)
    RadioButton rbPicturePrintAuto;

    @BindView(5743)
    RadioButton rbPicturePrintImageText;

    @BindView(5744)
    RadioButton rbPicturePrintMirror;

    @BindView(5745)
    RadioButton rbPicturePrintNoMirror;

    @BindView(5746)
    RadioButton rbPicturePrintRotate0;

    @BindView(5747)
    RadioButton rbPicturePrintRotate90;

    @BindView(5748)
    RadioButton rbPicturePrintScaleTypeCenterInside;

    @BindView(5749)
    RadioButton rbPicturePrintScaleTypeFitXY;

    @BindView(5750)
    RadioButton rbPicturePrintText;

    @BindView(5848)
    RecyclerView rvPicturePrintData;

    @BindView(6274)
    TextView tvTitle;
    private List<Bitmap> bitmapList = new ArrayList();
    private boolean waitingForModelDownload = false;
    private boolean pendingPrintAfterModelDownload = false;
    private final Object previewLock = new Object();
    private final Map<String, List<Bitmap>> previewCache = new HashMap();
    private int previewGenerationToken = 0;
    private String activePreviewKey = "";
    private String appliedPreviewKey = "";
    private String generatingPreviewKey = "";
    private boolean printAfterPreviewReady = false;
    private String pendingPrintPreviewKey = "";
    private int width = -1;
    private int height = -1;
    private ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
    private int rotate = 0;
    private boolean isMirror = false;
    private int printCount = 1;
    private int printStart = 1;
    private int printEnd = 1;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PicturePrintActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$convert$0(com.library.base.util.recyclerview.a aVar, Bitmap bitmap, View view) {
            String strSaveBitmapToTempFile;
            if (aVar.getAdapterPosition() == -1 || bitmap == null || (strSaveBitmapToTempFile = PicturePrintActivity.this.saveBitmapToTempFile(bitmap)) == null) {
                return;
            }
            ARouter.getInstance().build("/printer/imagePreview").withString("image_path", strSaveBitmapToTempFile).navigation();
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(final com.library.base.util.recyclerview.a aVar, final Bitmap bitmap) {
            ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_picture_print_img);
            ImageView imageView2 = (ImageView) aVar.a(p113u.d.iv_item_picture_print_img_add);
            ImageView imageView3 = (ImageView) aVar.a(p113u.d.iv_item_picture_print_img_delete);
            if (bitmap != null) {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                imageView3.setVisibility(8);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setAdjustViewBounds(true);
                float width = bitmap.getWidth() / bitmap.getHeight();
                int height = PicturePrintActivity.this.rvPicturePrintData.getHeight();
                int i5 = (int) (height * width);
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = i5;
                layoutParams.height = height;
                imageView.setLayoutParams(layoutParams);
                ((com.bumptech.glide.z) ((com.bumptech.glide.z) ((com.bumptech.glide.z) com.bumptech.glide.c.with(this.context).load(bitmap).fitCenter()).override(Integer.MIN_VALUE, Integer.MIN_VALUE)).dontTransform()).into(imageView);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int width2 = (PicturePrintActivity.this.rvPicturePrintData.getWidth() - i5) / 2;
                marginLayoutParams.leftMargin = width2;
                marginLayoutParams.rightMargin = width2;
                imageView.setLayoutParams(marginLayoutParams);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f2714a.lambda$convert$0(aVar, bitmap, view);
                    }
                });
            } else {
                imageView2.setVisibility(8);
                imageView.setVisibility(0);
                if (Y.f(PicturePrintActivity.this.path)) {
                    imageView3.setVisibility(0);
                } else {
                    imageView3.setVisibility(8);
                }
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                ((com.bumptech.glide.z) ((com.bumptech.glide.z) ((com.bumptech.glide.z) com.bumptech.glide.c.with(this.context).load(bitmap).fitCenter()).override(Integer.MIN_VALUE, Integer.MIN_VALUE)).dontTransform()).into(imageView);
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PicturePrintActivity.this.onAddImageClick(view);
                }
            });
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.1.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int iIndexOf = PicturePrintActivity.this.quickAdapter.getData().indexOf(bitmap);
                    PicturePrintActivity.this.quickAdapter.remove(iIndexOf);
                    PicturePrintActivity.this.bitmapList.remove(iIndexOf);
                    PicturePrintActivity.this.invalidatePreviewCache();
                    PicturePrintActivity picturePrintActivity = PicturePrintActivity.this;
                    picturePrintActivity.qswPicturePrintPrintEnd.setOffsetValue(picturePrintActivity.bitmapList.size() == 0 ? 1 : PicturePrintActivity.this.bitmapList.size());
                    PicturePrintActivity picturePrintActivity2 = PicturePrintActivity.this;
                    picturePrintActivity2.qswPicturePrintPrintEnd.setOffsetBigValue(picturePrintActivity2.bitmapList.size());
                    PicturePrintActivity.this.qswPicturePrintPrintStart.setOffsetValue(1);
                    PicturePrintActivity picturePrintActivity3 = PicturePrintActivity.this;
                    picturePrintActivity3.qswPicturePrintPrintStart.setOffsetBigValue(picturePrintActivity3.bitmapList.size());
                    PicturePrintActivity.this.printStart = 1;
                    PicturePrintActivity picturePrintActivity4 = PicturePrintActivity.this;
                    picturePrintActivity4.printEnd = picturePrintActivity4.bitmapList.size() != 0 ? PicturePrintActivity.this.bitmapList.size() : 1;
                    if (((com.library.base.util.recyclerview.b) AnonymousClass1.this).data.size() != 10) {
                        PicturePrintActivity.this.quickAdapter.add(null);
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PicturePrintActivity$13, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass13 implements Runnable {
        final /* synthetic */ List val$data;

        public AnonymousClass13(List list) {
            this.val$data = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(Integer num, int i5) {
            com.appdev.standard.dialog.E.b((num.intValue() * 100) / i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Q lambda$run$1(int i5, Integer num, Integer num2) {
            PicturePrintActivity.this.runOnUiThread(new C(num2, i5, 2));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2(Integer num, int i5) {
            com.appdev.standard.dialog.E.b((num.intValue() * 100) / i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Q lambda$run$3(int i5, Integer num, Integer num2) {
            PicturePrintActivity.this.runOnUiThread(new C(num2, i5, 3));
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$data.size() != 0) {
                boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
                if (PicturePrintActivity.this.printInfo != null && "01".equals(PicturePrintActivity.this.printInfo.getCmdMode())) {
                    byte[] bArrByteMerger = new byte[0];
                    for (int i5 = 0; i5 < PicturePrintActivity.this.printCount; i5++) {
                        for (Bitmap bitmap : this.val$data) {
                            byte[] bArrByteMerger2 = p134x2.Y.byteMerger(p134x2.Y.byteMerger(bArrByteMerger, p134x2.G.start()), p134x2.G.centerAligned());
                            bArrByteMerger = p134x2.Y.byteMerger(zBooleanValue ? p134x2.Y.byteMerger(bArrByteMerger2, p134x2.G.rasterBmpToSendDataByZLib(bitmap)) : p134x2.Y.byteMerger(bArrByteMerger2, p134x2.G.rasterBmpToSendData(bitmap)), p134x2.G.end());
                        }
                    }
                    final int length = bArrByteMerger.length;
                    K0 printer = p051j0.f.getPrinter();
                    if (printer == null) {
                        PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.appdev.standard.dialog.E.a();
                            }
                        });
                        return;
                    }
                    final int i6 = 0;
                    if (printer.sendSync(bArrByteMerger, new O3.p(this) { // from class: com.appdev.standard.page.printerlabel.F
                        public final /* synthetic */ PicturePrintActivity.AnonymousClass13 b;

                        {
                            this.b = this;
                        }

                        @Override // O3.p
                        public final Object invoke(Object obj, Object obj2) {
                            Integer num = (Integer) obj;
                            Integer num2 = (Integer) obj2;
                            switch (i6) {
                                case 0:
                                    return this.b.lambda$run$1(length, num, num2);
                                default:
                                    return this.b.lambda$run$3(length, num, num2);
                            }
                        }
                    }).b()) {
                        PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.13.2
                            @Override // java.lang.Runnable
                            public void run() {
                                p042h2.d.show(p113u.g.toast_2);
                                com.appdev.standard.dialog.E.a();
                                PicturePrintActivity.this.logWorker.a(PicturePrintActivity.this.printCount, PicturePrintActivity.this.getString(p113u.g.text_419), PicturePrintActivity.this.printInfo.getDeviceName());
                            }
                        });
                        return;
                    } else {
                        PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.13.3
                            @Override // java.lang.Runnable
                            public void run() {
                                com.appdev.standard.dialog.E.a();
                            }
                        });
                        return;
                    }
                }
                if (PicturePrintActivity.this.printInfo == null || !"02".equals(PicturePrintActivity.this.printInfo.getCmdMode())) {
                    return;
                }
                byte[] bArrByteMerger3 = p134x2.Y.byteMerger(p134x2.Y.byteMerger(p134x2.Y.byteMerger(new byte[0], a1.sizeBymm(PicturePrintActivity.this.width, PicturePrintActivity.this.height)), a1.cls()), a1.direction(0));
                for (int i7 = 0; i7 < PicturePrintActivity.this.printCount; i7++) {
                    for (Bitmap bitmap2 : this.val$data) {
                        bArrByteMerger3 = p134x2.Y.byteMerger(zBooleanValue ? p134x2.Y.byteMerger(bArrByteMerger3, a1.bitmapByZLib(0, 0, bitmap2, 128)) : p134x2.Y.byteMerger(bArrByteMerger3, a1.bitmap(0, 0, 0, bitmap2, 128)), a1.print(1));
                    }
                }
                final int length2 = bArrByteMerger3.length;
                K0 printer2 = p051j0.f.getPrinter();
                if (printer2 == null) {
                    PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.13.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.appdev.standard.dialog.E.a();
                        }
                    });
                    return;
                }
                final int i8 = 1;
                if (printer2.sendSync(bArrByteMerger3, new O3.p(this) { // from class: com.appdev.standard.page.printerlabel.F
                    public final /* synthetic */ PicturePrintActivity.AnonymousClass13 b;

                    {
                        this.b = this;
                    }

                    @Override // O3.p
                    public final Object invoke(Object obj, Object obj2) {
                        Integer num = (Integer) obj;
                        Integer num2 = (Integer) obj2;
                        switch (i8) {
                            case 0:
                                return this.b.lambda$run$1(length2, num, num2);
                            default:
                                return this.b.lambda$run$3(length2, num, num2);
                        }
                    }
                }).b()) {
                    PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.13.5
                        @Override // java.lang.Runnable
                        public void run() {
                            p042h2.d.show(p113u.g.toast_2);
                            com.appdev.standard.dialog.E.a();
                            PicturePrintActivity.this.logWorker.a(PicturePrintActivity.this.printCount, PicturePrintActivity.this.getString(p113u.g.text_419), PicturePrintActivity.this.printInfo.getDeviceName());
                        }
                    });
                } else {
                    PicturePrintActivity.this.runOnUiThread(new G(0));
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PicturePrintActivity$16, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass16 implements p056k0.l {
        public AnonymousClass16() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onState$0(p056k0.m mVar, int i5, String str) {
            PicturePrintActivity.this.handleModelDownloadState(mVar, i5, str);
        }

        @Override // p056k0.l
        public void onState(p056k0.m mVar, int i5, String str) {
            PicturePrintActivity.this.runOnUiThread(new D(this, mVar, i5, str, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PreviewResult {
        final List<Bitmap> bitmaps;
        final boolean toastSkipped;

        public PreviewResult(List<Bitmap> list, boolean z6) {
            this.bitmaps = list;
            this.toastSkipped = z6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PrintMode {
        TEXT,
        IMAGE_TEXT,
        AUTO
    }

    public PicturePrintActivity() {
        PrintMode printMode = PrintMode.IMAGE_TEXT;
        this.printMode = printMode;
        this.lastNonAutoMode = printMode;
        this.isInitSize = false;
        this.mediaPicker = new p056k0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SendPictureData(List<Bitmap> list) {
        com.appdev.standard.dialog.E.c();
        com.appdev.standard.dialog.E.b(0);
        runOnNewThread(new AnonymousClass13(list));
    }

    private void adjustPrintModeButtons() {
        if (!isAutoPrintModeAvailable()) {
            this.rbPicturePrintAuto.setChecked(false);
            this.rbPicturePrintAuto.setEnabled(false);
            this.rbPicturePrintAuto.setVisibility(8);
            resizePrintModeButton(this.rbPicturePrintText, 84, 0);
            resizePrintModeButton(this.rbPicturePrintImageText, 84, 12);
            if (this.printMode == PrintMode.AUTO) {
                this.printMode = this.lastNonAutoMode;
            }
        }
        String str = (String) Hawk.get("current_language", "");
        if (str.equals("zh") || str.equals("zh_TW")) {
            return;
        }
        this.rbPicturePrintText.setTextSize(2, 11.0f);
        this.rbPicturePrintAuto.setTextSize(2, 11.0f);
        this.rbPicturePrintImageText.setTextSize(2, 11.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyPicturePreview(String str, List<Bitmap> list, boolean z6) {
        synchronized (this.previewLock) {
            try {
                if (str.equals(this.activePreviewKey)) {
                    this.appliedPreviewKey = str;
                    boolean z7 = false;
                    if (this.printAfterPreviewReady && str.equals(this.pendingPrintPreviewKey)) {
                        this.printAfterPreviewReady = false;
                        this.pendingPrintPreviewKey = "";
                        z7 = true;
                    }
                    this.quickAdapter.replaceAll(list);
                    if (z7) {
                        continuePicturePrintConfirm();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Bitmap autoProcessImage(Bitmap bitmap) {
        p050j.j jVarA = p056k0.k.a(this.context, bitmap);
        if (jVarA.c) {
            return (Bitmap) jVarA.d;
        }
        p051j0.a.c(this.TAG, "AI model processing failed, fallback to IMAGE_TEXT mode: " + jVarA.b);
        this.pictureUtil.getClass();
        return p056k0.q.d(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PreviewResult buildPicturePreview(List<Bitmap> list, PrintMode printMode, int i5, int i6, ImageView.ScaleType scaleType, int i7, boolean z6) {
        Bitmap bitmapD;
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (Bitmap bitmap : list) {
            if (bitmap != null) {
                try {
                    Bitmap bitmapHandleImageTransform = handleImageTransform(bitmap, i5, i6, scaleType, i7, z6);
                    if (printMode == PrintMode.TEXT) {
                        this.pictureUtil.getClass();
                        bitmapD = p056k0.q.b(bitmapHandleImageTransform);
                    } else if (printMode == PrintMode.AUTO) {
                        bitmapD = autoProcessImage(bitmapHandleImageTransform);
                    } else {
                        this.pictureUtil.getClass();
                        bitmapD = p056k0.q.d(bitmapHandleImageTransform);
                    }
                    arrayList.add(bitmapD);
                } catch (Exception e) {
                    p051j0.a.e(this.TAG, "showImgData", e);
                    z7 = true;
                }
            }
        }
        return new PreviewResult(arrayList, z7);
    }

    private String buildPicturePreviewKey(PrintMode printMode, PrintMode printMode2, int i5, int i6, ImageView.ScaleType scaleType, int i7, boolean z6) {
        List<Bitmap> list = this.bitmapList;
        StringBuilder sbB = p050j.w.b(printMode, printMode2, i5, i6, scaleType, i7);
        sbB.append("|mirror=");
        sbB.append(z6);
        sbB.append("|src=");
        for (Bitmap bitmap : list) {
            if (bitmap == null) {
                sbB.append("null;");
            } else {
                sbB.append(System.identityHashCode(bitmap));
                sbB.append(NameUtil.COLON);
                sbB.append(bitmap.getWidth());
                sbB.append('x');
                sbB.append(bitmap.getHeight());
                sbB.append(';');
            }
        }
        return sbB.toString();
    }

    private void continuePicturePrintConfirm() {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
            return;
        }
        if (this.width == -1 || this.height == -1) {
            p042h2.d.show(p113u.g.please_enter_width_and_height);
            return;
        }
        if (this.printStart > this.printEnd) {
            p042h2.d.show(p113u.g.toast_42);
            return;
        }
        if (this.quickAdapter.getData().size() == 1 && this.quickAdapter.getData().get(0) == null) {
            p042h2.d.show(p113u.g.toast_43);
            return;
        }
        final List<Object> listSubList = this.quickAdapter.getData().subList(this.printStart - 1, this.printEnd);
        P0 p0H = p051j0.a.h();
        this.printInfo = p0H;
        if (p0H != null) {
            SendPictureData(listSubList);
        } else {
            p042h2.d.show(p113u.g.toast_44);
            new Thread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    PicturePrintActivity.this.printInfo = p051j0.f.read_print_info();
                    PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PicturePrintActivity.this.printInfo != null) {
                                AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                PicturePrintActivity.this.SendPictureData(listSubList);
                            }
                        }
                    });
                }
            }).start();
        }
    }

    private int dpToPx(int i5) {
        return (int) ((i5 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private PrintMode getEffectivePreviewMode(PrintMode printMode, boolean z6) {
        if (printMode != PrintMode.AUTO || p056k0.n.c(this.context)) {
            return printMode;
        }
        if (z6) {
            return PrintMode.IMAGE_TEXT;
        }
        return null;
    }

    private Bitmap handleImageTransform(Bitmap bitmap, int i5, int i6, ImageView.ScaleType scaleType, int i7, boolean z6) {
        if (i7 != 0 || z6) {
            Matrix matrix = new Matrix();
            if (i7 == 90) {
                matrix.postRotate(90.0f);
            }
            if (z6) {
                matrix.postScale(-1.0f, 1.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            }
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return scaleType == ImageView.ScaleType.CENTER_INSIDE ? this.pictureUtil.scaleBitmapByEqualRatio(bitmap, C1849c.mm2px(i5), C1849c.mm2px(i6)) : this.pictureUtil.scaleBitmapByTile(bitmap, C1849c.mm2px(i5), C1849c.mm2px(i6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleModelDownloadState(p056k0.m mVar, int i5, String str) {
        if (this.waitingForModelDownload && isActivityAlive()) {
            if (p056k0.m.b.equals(mVar)) {
                com.appdev.standard.dialog.y yVar = this.modelDownloadProgressDialog;
                if (yVar != null) {
                    yVar.a(i5);
                    return;
                }
                return;
            }
            p056k0.m mVar2 = p056k0.m.c;
            if (mVar2.equals(mVar)) {
                boolean z6 = this.pendingPrintAfterModelDownload && mVar2.equals(mVar);
                stopWaitingForModelDownload(false);
                p042h2.d.show(p113u.g.toast_model_download_ok);
                switchToAutoMode();
                if (z6) {
                    requestPreviewGeneration(true);
                    return;
                }
                return;
            }
            if (p056k0.m.d.equals(mVar)) {
                stopWaitingForModelDownload(false);
                p042h2.d.show(p113u.g.toast_model_download_fail);
                p051j0.a.d(this.TAG, "Model download failed: " + str);
                revertPrintMode();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidatePreviewCache() {
        synchronized (this.previewLock) {
            this.previewGenerationToken++;
            this.activePreviewKey = "";
            this.appliedPreviewKey = "";
            this.generatingPreviewKey = "";
            this.printAfterPreviewReady = false;
            this.pendingPrintPreviewKey = "";
            this.previewCache.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActivityAlive() {
        return (isFinishing() || isDestroyed()) ? false : true;
    }

    private boolean isAppliedPreviewReadyForCurrentPrintMode() {
        PrintMode effectivePreviewMode;
        boolean zEquals;
        boolean z6 = true;
        boolean z7 = this.printMode == PrintMode.AUTO;
        boolean zC = p056k0.n.c(this.context);
        if ((z7 && !zC) || (effectivePreviewMode = getEffectivePreviewMode(this.printMode, false)) == null) {
            return false;
        }
        int offsetValue = this.qswPdfPrintPrintWidth.getOffsetValue();
        int offsetValue2 = this.qswPdfPrintPrintHeight.getOffsetValue();
        String strBuildPicturePreviewKey = buildPicturePreviewKey(this.printMode, effectivePreviewMode, offsetValue <= 0 ? 1 : offsetValue, offsetValue2 <= 0 ? 1 : offsetValue2, this.scaleType, this.rotate, this.isMirror);
        synchronized (this.previewLock) {
            this.activePreviewKey = strBuildPicturePreviewKey;
            String str = this.appliedPreviewKey;
            boolean zContainsKey = this.previewCache.containsKey(strBuildPicturePreviewKey);
            if (strBuildPicturePreviewKey == null) {
                zEquals = str == null;
            } else {
                zEquals = strBuildPicturePreviewKey.equals(str);
            }
            if (!zEquals || !zContainsKey) {
                z6 = false;
            }
        }
        return z6;
    }

    private boolean isAutoPrintModeAvailable() {
        String property = System.getProperty("os.arch", "");
        return property != null && (property.contains("aarch64") || property.contains("arm64")) && Process.is64Bit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAddImageClick$0(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            Matrix matrix = new Matrix();
            int attributeInt = new ExifInterface(inputStreamOpenInputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                matrix.postRotate(180.0f);
            } else if (attributeInt == 6) {
                matrix.postRotate(90.0f);
            } else if (attributeInt == 8) {
                matrix.postRotate(270.0f);
            }
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            this.bitmapList.add(this.pictureUtil.scaleBitmapByEqualRatio(Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true), this.rvPicturePrintData.getWidth(), this.rvPicturePrintData.getHeight()));
        } catch (Exception e) {
            p051j0.a.e(this.TAG, "onAddImageClick", e);
            p042h2.d.show(p113u.g.toast_picture_print_skip);
        }
        this.qswPicturePrintPrintEnd.setOffsetValue(this.bitmapList.size());
        this.qswPicturePrintPrintEnd.setOffsetBigValue(this.bitmapList.size());
        this.qswPicturePrintPrintStart.setOffsetValue(1);
        this.qswPicturePrintPrintStart.setOffsetBigValue(this.bitmapList.size());
        this.printStart = 1;
        this.printEnd = this.bitmapList.size();
        invalidatePreviewCache();
        showImgData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startModelDownloadWithProgress$1(DialogInterface dialogInterface) {
        stopWaitingForModelDownload(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAddImageClick(View view) {
        this.mediaPicker.pick(new H(this, 4));
    }

    private void requestPreviewGeneration(final boolean z6) {
        List<Bitmap> list;
        if (this.bitmapList.isEmpty()) {
            return;
        }
        if (z6) {
            boolean z7 = this.printMode == PrintMode.AUTO;
            boolean zC = p056k0.n.c(this.context);
            if (z7 && !zC) {
                showModelDownloadRequiredForPrint();
                return;
            }
        }
        if (!this.isInitSize) {
            P0 p1 = this.printInfo;
            if (p1 != null) {
                final int i5 = p1.d;
                Bitmap bitmap = this.bitmapList.get(0);
                final int height = (int) ((bitmap.getHeight() / bitmap.getWidth()) * i5);
                runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PicturePrintActivity.this.qswPdfPrintPrintWidth.setOffsetValue((int) C1849c.px2mm(i5));
                        PicturePrintActivity.this.qswPdfPrintPrintHeight.setOffsetValue((int) C1849c.px2mm(height));
                    }
                });
            }
            this.isInitSize = true;
        }
        int offsetValue = this.qswPdfPrintPrintWidth.getOffsetValue();
        int offsetValue2 = this.qswPdfPrintPrintHeight.getOffsetValue();
        final int i6 = offsetValue <= 0 ? 1 : offsetValue;
        final int i7 = offsetValue2 <= 0 ? 1 : offsetValue2;
        this.width = i6;
        this.height = i7;
        PrintMode printMode = this.printMode;
        final PrintMode effectivePreviewMode = getEffectivePreviewMode(printMode, !z6);
        if (effectivePreviewMode == null) {
            return;
        }
        final String strBuildPicturePreviewKey = buildPicturePreviewKey(printMode, effectivePreviewMode, i6, i7, this.scaleType, this.rotate, this.isMirror);
        synchronized (this.previewLock) {
            try {
                this.activePreviewKey = strBuildPicturePreviewKey;
                if (z6) {
                    this.printAfterPreviewReady = true;
                    this.pendingPrintPreviewKey = strBuildPicturePreviewKey;
                }
                list = this.previewCache.get(strBuildPicturePreviewKey);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list != null) {
            applyPicturePreview(strBuildPicturePreviewKey, list, z6);
            p050j.w.c();
            return;
        }
        synchronized (this.previewLock) {
            try {
                if (strBuildPicturePreviewKey.equals(this.generatingPreviewKey)) {
                    return;
                }
                final int i8 = this.previewGenerationToken + 1;
                this.previewGenerationToken = i8;
                this.generatingPreviewKey = strBuildPicturePreviewKey;
                final ArrayList arrayList = new ArrayList(this.bitmapList);
                final ImageView.ScaleType scaleType = this.scaleType;
                final int i9 = this.rotate;
                final boolean z8 = this.isMirror;
                p050j.w.e();
                runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.4
                    @Override // java.lang.Runnable
                    public void run() {
                        final PreviewResult previewResultBuildPicturePreview = PicturePrintActivity.this.buildPicturePreview(arrayList, effectivePreviewMode, i6, i7, scaleType, i9, z8);
                        synchronized (PicturePrintActivity.this.previewLock) {
                            try {
                                PicturePrintActivity.this.previewCache.put(strBuildPicturePreviewKey, previewResultBuildPicturePreview.bitmaps);
                                if (strBuildPicturePreviewKey.equals(PicturePrintActivity.this.generatingPreviewKey)) {
                                    PicturePrintActivity.this.generatingPreviewKey = "";
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z9;
                                boolean zEquals;
                                if (!PicturePrintActivity.this.isActivityAlive()) {
                                    p050j.w.c();
                                    return;
                                }
                                synchronized (PicturePrintActivity.this.previewLock) {
                                    try {
                                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                        int i10 = i8;
                                        int i11 = PicturePrintActivity.this.previewGenerationToken;
                                        AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                                        String str = strBuildPicturePreviewKey;
                                        String str2 = PicturePrintActivity.this.activePreviewKey;
                                        z9 = false;
                                        if (i10 == i11) {
                                            if (str == null) {
                                                zEquals = str2 == null;
                                            } else {
                                                zEquals = str.equals(str2);
                                            }
                                            if (zEquals) {
                                                z9 = true;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        throw th3;
                                    }
                                }
                                if (z9 && previewResultBuildPicturePreview.toastSkipped) {
                                    p042h2.d.show(p113u.g.toast_picture_print_skip);
                                }
                                if (z9) {
                                    AnonymousClass4 anonymousClass6 = AnonymousClass4.this;
                                    PicturePrintActivity.this.applyPicturePreview(strBuildPicturePreviewKey, previewResultBuildPicturePreview.bitmaps, z6);
                                    p050j.w.c();
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void resizePrintModeButton(RadioButton radioButton, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) radioButton.getLayoutParams();
        marginLayoutParams.width = dpToPx(i5);
        marginLayoutParams.leftMargin = dpToPx(i6);
        radioButton.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void revertPrintMode() {
        if (this.lastNonAutoMode == PrintMode.TEXT) {
            onPicturePrintTextModeClick(null);
        } else {
            onPicturePrintImageTextModeClick(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String saveBitmapToTempFile(Bitmap bitmap) {
        try {
            File fileCreateTempFile = File.createTempFile("preview_", ".jpg", getCacheDir());
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
                return fileCreateTempFile.getAbsolutePath();
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            p051j0.a.e(this.TAG, "saveBitmapToTempFile error", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showImgData() {
        requestPreviewGeneration(false);
    }

    private void showModelDownloadRequiredForPrint() {
        new AlertDialog.Builder(this).setTitle(p113u.g.dlg_model_download_title).setMessage(p113u.g.dlg_model_download_msg).setNegativeButton(p113u.g.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(p113u.g.download, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                PicturePrintActivity.this.startModelDownloadWithProgress(true);
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startModelDownloadWithProgress(boolean z6) {
        stopWaitingForModelDownload(false);
        this.waitingForModelDownload = true;
        this.pendingPrintAfterModelDownload = z6;
        com.appdev.standard.dialog.y yVar = new com.appdev.standard.dialog.y(this);
        this.modelDownloadProgressDialog = yVar;
        ProgressBar progressBar = yVar.f2659a;
        if (progressBar != null) {
            progressBar.setMax(100);
        }
        this.modelDownloadProgressDialog.setCancelable(true);
        this.modelDownloadProgressDialog.setOnCancelListener(new A(this, 1));
        this.modelDownloadProgressDialog.show();
        this.modelDownloadListener = new AnonymousClass16();
        p056k0.n.a(this.context, false);
        p056k0.l lVar = this.modelDownloadListener;
        if (lVar == null) {
            return;
        }
        p056k0.n.f5470f.add(lVar);
        lVar.onState((p056k0.m) p056k0.n.e.get(), p056k0.n.c, p056k0.n.d);
    }

    private void stopWaitingForModelDownload(boolean z6) {
        this.waitingForModelDownload = false;
        this.pendingPrintAfterModelDownload = false;
        p056k0.l lVar = this.modelDownloadListener;
        if (lVar != null) {
            p056k0.n.f5470f.remove(lVar);
            this.modelDownloadListener = null;
        }
        com.appdev.standard.dialog.y yVar = this.modelDownloadProgressDialog;
        if (yVar != null && yVar.isShowing()) {
            this.modelDownloadProgressDialog.dismiss();
        }
        this.modelDownloadProgressDialog = null;
        if (z6) {
            revertPrintMode();
        }
    }

    private void switchToAutoMode() {
        this.rbPicturePrintText.setChecked(false);
        this.rbPicturePrintImageText.setChecked(false);
        this.rbPicturePrintAuto.setChecked(true);
        RadioButton radioButton = this.rbPicturePrintText;
        int i5 = p113u.c.bg_ffffff_rad_10_stroke_999999;
        radioButton.setBackgroundResource(i5);
        this.rbPicturePrintImageText.setBackgroundResource(i5);
        this.rbPicturePrintAuto.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        RadioButton radioButton2 = this.rbPicturePrintText;
        Resources resources = getResources();
        int i6 = p113u.a.color_999999;
        radioButton2.setTextColor(resources.getColor(i6));
        this.rbPicturePrintImageText.setTextColor(getResources().getColor(i6));
        this.rbPicturePrintAuto.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.printMode = PrintMode.AUTO;
        showImgData();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mediaPicker.attachToActivity(this);
        ARouter.getInstance().inject(this);
        String str = this.path;
        if (str == null || !str.startsWith("banner_printing::")) {
            this.rbPicturePrintImageText.setChecked(true);
            this.rbPicturePrintText.setChecked(false);
            this.rbPicturePrintImageText.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
            this.rbPicturePrintText.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
            this.rbPicturePrintImageText.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
            this.rbPicturePrintText.setTextColor(getResources().getColor(p113u.a.color_999999));
        } else {
            this.path = this.path.replace("banner_printing::", "");
            this.printMode = PrintMode.TEXT;
            this.rbPicturePrintText.setChecked(true);
            this.rbPicturePrintImageText.setChecked(false);
            this.rbPicturePrintText.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
            this.rbPicturePrintImageText.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
            this.rbPicturePrintText.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
            this.rbPicturePrintImageText.setTextColor(getResources().getColor(p113u.a.color_999999));
        }
        this.context = this;
        if (Y.f(this.path)) {
            this.tvTitle.setText(p113u.g.text_419);
        }
        this.pictureUtil = new p056k0.q();
        this.quickAdapter = new AnonymousClass1(this, p113u.e.item_picture_print);
        this.rvPicturePrintData.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.rvPicturePrintData.setNestedScrollingEnabled(true);
        this.rvPicturePrintData.setAdapter(this.quickAdapter);
        this.quickAdapter.add(null);
        if (Y.f(this.path)) {
            this.llRange.setVisibility(0);
        } else {
            this.llRange.setVisibility(8);
            this.rvPicturePrintData.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    PicturePrintActivity.this.rvPicturePrintData.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PicturePrintActivity.this.bitmapList.clear();
                    Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(PicturePrintActivity.this.path);
                    if (bitmapDecodeFile == null) {
                        p042h2.d.show(p113u.g.toast_10);
                        return;
                    }
                    PicturePrintActivity.this.bitmapList.add(bitmapDecodeFile);
                    PicturePrintActivity.this.invalidatePreviewCache();
                    PicturePrintActivity picturePrintActivity = PicturePrintActivity.this;
                    picturePrintActivity.qswPicturePrintPrintEnd.setOffsetValue(picturePrintActivity.bitmapList.size());
                    PicturePrintActivity picturePrintActivity2 = PicturePrintActivity.this;
                    picturePrintActivity2.qswPicturePrintPrintEnd.setOffsetBigValue(picturePrintActivity2.bitmapList.size());
                    PicturePrintActivity.this.qswPicturePrintPrintStart.setOffsetValue(1);
                    PicturePrintActivity picturePrintActivity3 = PicturePrintActivity.this;
                    picturePrintActivity3.qswPicturePrintPrintStart.setOffsetBigValue(picturePrintActivity3.bitmapList.size());
                    PicturePrintActivity.this.printStart = 1;
                    PicturePrintActivity picturePrintActivity4 = PicturePrintActivity.this;
                    picturePrintActivity4.printEnd = picturePrintActivity4.bitmapList.size();
                    PicturePrintActivity.this.showImgData();
                }
            });
        }
        getSupportFragmentManager().beginTransaction().replace(p113u.d.fl_current_printer, new CurrentPrinterFragment()).commit();
        this.logWorker = new S.a(this);
        adjustPrintModeButtons();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.qswPicturePrintPrintCount.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.5
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PicturePrintActivity.this.printCount = i5;
            }
        });
        this.qswPicturePrintPrintStart.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.6
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                if (i5 <= PicturePrintActivity.this.quickAdapter.getItemCount() - 1) {
                    PicturePrintActivity.this.printStart = i5;
                } else {
                    PicturePrintActivity picturePrintActivity = PicturePrintActivity.this;
                    picturePrintActivity.qswPicturePrintPrintStart.setOffsetValue(picturePrintActivity.printStart);
                }
            }
        });
        this.qswPicturePrintPrintEnd.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.7
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                if (i5 <= PicturePrintActivity.this.quickAdapter.getItemCount() - 1) {
                    PicturePrintActivity.this.printEnd = i5;
                } else {
                    PicturePrintActivity picturePrintActivity = PicturePrintActivity.this;
                    picturePrintActivity.qswPicturePrintPrintEnd.setOffsetValue(picturePrintActivity.printEnd);
                }
            }
        });
        this.qswPdfPrintPrintWidth.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.8
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PicturePrintActivity.this.showImgData();
            }
        });
        this.qswPdfPrintPrintHeight.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.9
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PicturePrintActivity.this.showImgData();
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_picture_print;
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        stopWaitingForModelDownload(false);
        super.onDestroy();
    }

    public void onPicturePrintAutoModeClick(View view) {
        if (isAutoPrintModeAvailable()) {
            if (p056k0.n.c(this.context)) {
                PrintMode printMode = this.printMode;
                if (printMode != PrintMode.AUTO) {
                    this.lastNonAutoMode = printMode;
                }
                switchToAutoMode();
                return;
            }
            PrintMode printMode2 = this.printMode;
            if (printMode2 != PrintMode.AUTO) {
                this.lastNonAutoMode = printMode2;
            }
            switchToAutoMode();
            new AlertDialog.Builder(this).setTitle(p113u.g.dlg_model_download_title).setMessage(p113u.g.dlg_model_download_msg).setNegativeButton(p113u.g.cancel, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    PicturePrintActivity.this.revertPrintMode();
                }
            }).setPositiveButton(p113u.g.download, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.14
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    PicturePrintActivity.this.startModelDownloadWithProgress(false);
                }
            }).setCancelable(false).show();
        }
    }

    public void onPicturePrintConfirmClick(View view) {
        if (isAppliedPreviewReadyForCurrentPrintMode()) {
            continuePicturePrintConfirm();
        } else {
            requestPreviewGeneration(true);
        }
    }

    public void onPicturePrintImageTextModeClick(View view) {
        this.rbPicturePrintText.setChecked(false);
        this.rbPicturePrintImageText.setChecked(true);
        this.rbPicturePrintAuto.setChecked(false);
        RadioButton radioButton = this.rbPicturePrintText;
        int i5 = p113u.c.bg_ffffff_rad_10_stroke_999999;
        radioButton.setBackgroundResource(i5);
        this.rbPicturePrintImageText.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintAuto.setBackgroundResource(i5);
        RadioButton radioButton2 = this.rbPicturePrintText;
        Resources resources = getResources();
        int i6 = p113u.a.color_999999;
        radioButton2.setTextColor(resources.getColor(i6));
        this.rbPicturePrintImageText.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintAuto.setTextColor(getResources().getColor(i6));
        PrintMode printMode = PrintMode.IMAGE_TEXT;
        this.printMode = printMode;
        this.lastNonAutoMode = printMode;
        showImgData();
    }

    public void onPicturePrintMirrorClick(View view) {
        this.rbPicturePrintNoMirror.setChecked(false);
        this.rbPicturePrintMirror.setChecked(true);
        this.rbPicturePrintNoMirror.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintMirror.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintNoMirror.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rbPicturePrintMirror.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.ivMirror.setImageResource(p113u.f.ic_pic_print_mirror_select);
        this.ivNoMirror.setImageResource(p113u.f.ic_pic_print_no_mirror_unselect);
        this.isMirror = true;
        showImgData();
    }

    public void onPicturePrintNoMirrorClick(View view) {
        this.rbPicturePrintNoMirror.setChecked(true);
        this.rbPicturePrintMirror.setChecked(false);
        this.rbPicturePrintNoMirror.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintMirror.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintNoMirror.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintMirror.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.ivMirror.setImageResource(p113u.f.ic_pic_print_mirror);
        this.ivNoMirror.setImageResource(p113u.f.ic_pic_print_no_mirror);
        this.isMirror = false;
        showImgData();
    }

    public void onPicturePrintRotate0Click(View view) {
        this.rbPicturePrintRotate0.setChecked(true);
        this.rbPicturePrintRotate90.setChecked(false);
        this.rbPicturePrintRotate0.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintRotate90.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintRotate0.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintRotate90.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rotate = 0;
        showImgData();
    }

    public void onPicturePrintRotate90Click(View view) {
        this.rbPicturePrintRotate0.setChecked(false);
        this.rbPicturePrintRotate90.setChecked(true);
        this.rbPicturePrintRotate0.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintRotate90.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintRotate0.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rbPicturePrintRotate90.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rotate = 90;
        showImgData();
    }

    public void onPicturePrintScaleTypeCenterInsideClick(View view) {
        this.rbPicturePrintScaleTypeFitXY.setChecked(false);
        this.rbPicturePrintScaleTypeCenterInside.setChecked(true);
        this.rbPicturePrintScaleTypeFitXY.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintScaleTypeCenterInside.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintScaleTypeFitXY.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rbPicturePrintScaleTypeCenterInside.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        showImgData();
    }

    public void onPicturePrintScaleTypeFitXYClick(View view) {
        this.rbPicturePrintScaleTypeFitXY.setChecked(true);
        this.rbPicturePrintScaleTypeCenterInside.setChecked(false);
        this.rbPicturePrintScaleTypeFitXY.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintScaleTypeCenterInside.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintScaleTypeFitXY.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintScaleTypeCenterInside.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.scaleType = ImageView.ScaleType.FIT_XY;
        showImgData();
    }

    public void onPicturePrintTextModeClick(View view) {
        this.rbPicturePrintText.setChecked(true);
        this.rbPicturePrintImageText.setChecked(false);
        this.rbPicturePrintAuto.setChecked(false);
        this.rbPicturePrintText.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        RadioButton radioButton = this.rbPicturePrintImageText;
        int i5 = p113u.c.bg_ffffff_rad_10_stroke_999999;
        radioButton.setBackgroundResource(i5);
        this.rbPicturePrintAuto.setBackgroundResource(i5);
        this.rbPicturePrintText.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        RadioButton radioButton2 = this.rbPicturePrintImageText;
        Resources resources = getResources();
        int i6 = p113u.a.color_999999;
        radioButton2.setTextColor(resources.getColor(i6));
        this.rbPicturePrintAuto.setTextColor(getResources().getColor(i6));
        PrintMode printMode = PrintMode.TEXT;
        this.printMode = printMode;
        this.lastNonAutoMode = printMode;
        showImgData();
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.printInfo = p051j0.a.h();
        K0 printer = p051j0.f.getPrinter();
        if (this.printInfo == null && printer != null && printer.b()) {
            p050j.w.f(getResources().getString(p113u.g.toast_44));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.12
                @Override // java.lang.Runnable
                public void run() {
                    PicturePrintActivity.this.printInfo = p051j0.f.read_print_info();
                    PicturePrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.12.1
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
        PrintSetting printSetting = new PrintSetting(new PrintSetting.OnSettingListener() { // from class: com.appdev.standard.page.printerlabel.PicturePrintActivity.17
            @Override // com.appdev.standard.page.bluetooth.PrintSetting.OnSettingListener
            public void onSetting(P0 p1) {
            }
        });
        this.mCustomPopWindow = printSetting;
        printSetting.showSetting(this, getWindow().getDecorView().findViewById(R.id.content));
    }
}
