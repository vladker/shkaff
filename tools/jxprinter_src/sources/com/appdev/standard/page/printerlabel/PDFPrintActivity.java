package com.appdev.standard.page.printerlabel;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.DocumentApi;
import com.appdev.standard.api.dto.ConvertDto;
import com.appdev.standard.page.bluetooth.CurrentPrinterFragment;
import com.appdev.standard.page.bluetooth.PrintSetting;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.xmlbeans.impl.common.NameUtil;
import p134x2.C1849c;
import p134x2.K0;
import p134x2.P0;
import p134x2.Y;
import p134x2.a1;
import p147z3.Q;
import retrofit2.r0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PDF_PRINT)
public class PDFPrintActivity extends MvpActivity {
    private Context context;
    private List<String> documentBitmapList;
    private String fileAbsolutePath;
    private String fileName;
    private boolean isInitSize;
    private PrintMode lastNonAutoMode;
    private S.a logWorker;
    private PrintSetting mCustomPopWindow;
    private int maxDotLineHeight;
    private int maxDotLineWidth;
    private p056k0.l modelDownloadListener;
    private com.appdev.standard.dialog.y modelDownloadProgressDialog;
    private p056k0.q pictureUtil;
    private P0 printInfo;
    private PrintMode printMode;

    @BindView(5726)
    QuantitySelectorWidget qswPdfPrintPrintCount;

    @BindView(5727)
    QuantitySelectorWidget qswPdfPrintPrintEnd;

    @BindView(5728)
    QuantitySelectorWidget qswPdfPrintPrintHeight;

    @BindView(5729)
    QuantitySelectorWidget qswPdfPrintPrintStart;

    @BindView(5730)
    QuantitySelectorWidget qswPdfPrintPrintWidth;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5742)
    RadioButton rbPicturePrintAuto;

    @BindView(5743)
    RadioButton rbPicturePrintImageText;

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
    private int rotate;

    @BindView(5846)
    RecyclerView rvPdfPrintData;
    private ImageView.ScaleType scaleType;

    @BindView(6179)
    TextView tvPdfPrintDataCount;

    @BindView(6274)
    TextView tvTitle;
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
    private int printCount = 1;
    private int printStart = 1;
    private int printEnd = 1;

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PDFPrintActivity$12, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass12 implements Runnable {
        final /* synthetic */ K0 val$printer;

        public AnonymousClass12(K0 k6) {
            this.val$printer = k6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(Integer num, int i5) {
            com.appdev.standard.dialog.E.b((num.intValue() * 100) / i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Q lambda$run$1(int i5, Integer num, Integer num2) {
            PDFPrintActivity.this.runOnUiThread(new C(num2, i5, 1));
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$2(Integer num, int i5) {
            com.appdev.standard.dialog.E.b((num.intValue() * 100) / i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Q lambda$run$3(int i5, Integer num, Integer num2) {
            PDFPrintActivity.this.runOnUiThread(new C(num2, i5, 0));
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArrByteMerger;
            List<Object> listSubList = PDFPrintActivity.this.quickAdapter.getData().subList(PDFPrintActivity.this.printStart - 1, Math.min(PDFPrintActivity.this.printEnd, PDFPrintActivity.this.quickAdapter.getData().size()));
            boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
            if (listSubList.size() != 0) {
                if (PDFPrintActivity.this.printInfo != null && "01".equals(PDFPrintActivity.this.printInfo.getCmdMode())) {
                    byte[] bArrByteMerger2 = new byte[0];
                    for (int i5 = 0; i5 < PDFPrintActivity.this.printCount; i5++) {
                        Iterator<Object> it = listSubList.iterator();
                        while (it.hasNext()) {
                            Bitmap bitmap = (Bitmap) it.next();
                            byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArrByteMerger2, p134x2.G.start()), p134x2.G.centerAligned());
                            bArrByteMerger2 = Y.byteMerger(zBooleanValue ? Y.byteMerger(bArrByteMerger3, p134x2.G.rasterBmpToSendDataByZLib(bitmap)) : Y.byteMerger(bArrByteMerger3, p134x2.G.rasterBmpToSendData(bitmap)), p134x2.G.end());
                        }
                    }
                    final int length = bArrByteMerger2.length;
                    final int i6 = 0;
                    if (this.val$printer.sendSync(bArrByteMerger2, new O3.p(this) { // from class: com.appdev.standard.page.printerlabel.B
                        public final /* synthetic */ PDFPrintActivity.AnonymousClass12 b;

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
                        PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                p042h2.d.show(p113u.g.toast_2);
                                com.appdev.standard.dialog.E.a();
                                PDFPrintActivity.this.logWorker.a(PDFPrintActivity.this.printCount, PDFPrintActivity.this.getString(p113u.g.text_183), PDFPrintActivity.this.printInfo.getDeviceName());
                            }
                        });
                        return;
                    } else {
                        PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.12.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.appdev.standard.dialog.E.a();
                            }
                        });
                        return;
                    }
                }
                if (PDFPrintActivity.this.printInfo == null || !"02".equals(PDFPrintActivity.this.printInfo.getCmdMode())) {
                    return;
                }
                byte[] bArrByteMerger4 = Y.byteMerger(Y.byteMerger(Y.byteMerger(new byte[0], a1.sizeBymm((int) C1849c.px2mm(((Bitmap) listSubList.get(0)).getWidth()), (int) C1849c.px2mm(((Bitmap) listSubList.get(0)).getHeight()))), a1.cls()), a1.direction(0));
                if (listSubList.size() == 1) {
                    Bitmap bitmap2 = (Bitmap) listSubList.get(0);
                    bArrByteMerger = Y.byteMerger(zBooleanValue ? Y.byteMerger(bArrByteMerger4, a1.bitmapByZLib(0, 0, bitmap2, 128)) : Y.byteMerger(bArrByteMerger4, a1.bitmap(0, 0, 0, bitmap2, 128)), a1.print(PDFPrintActivity.this.printCount));
                } else {
                    for (int i7 = 0; i7 < PDFPrintActivity.this.printCount; i7++) {
                        Iterator<Object> it2 = listSubList.iterator();
                        while (it2.hasNext()) {
                            Bitmap bitmap3 = (Bitmap) it2.next();
                            bArrByteMerger4 = Y.byteMerger(zBooleanValue ? Y.byteMerger(bArrByteMerger4, a1.bitmapByZLib(0, 0, bitmap3, 128)) : Y.byteMerger(bArrByteMerger4, a1.bitmap(0, 0, 0, bitmap3, 128)), a1.print(1));
                        }
                    }
                    bArrByteMerger = bArrByteMerger4;
                }
                final int length2 = bArrByteMerger.length;
                final int i8 = 1;
                if (this.val$printer.sendSync(bArrByteMerger, new O3.p(this) { // from class: com.appdev.standard.page.printerlabel.B
                    public final /* synthetic */ PDFPrintActivity.AnonymousClass12 b;

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
                    PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            p042h2.d.show(p113u.g.toast_2);
                            com.appdev.standard.dialog.E.a();
                            PDFPrintActivity.this.logWorker.a(PDFPrintActivity.this.printCount, PDFPrintActivity.this.getString(p113u.g.text_183), PDFPrintActivity.this.printInfo.getDeviceName());
                        }
                    });
                } else {
                    PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.12.4
                        @Override // java.lang.Runnable
                        public void run() {
                            com.appdev.standard.dialog.E.a();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.PDFPrintActivity$17, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass17 implements p056k0.l {
        public AnonymousClass17() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onState$0(p056k0.m mVar, int i5, String str) {
            PDFPrintActivity.this.handleModelDownloadState(mVar, i5, str);
        }

        @Override // p056k0.l
        public void onState(p056k0.m mVar, int i5, String str) {
            PDFPrintActivity.this.runOnUiThread(new D(this, mVar, i5, str, 0));
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

    public PDFPrintActivity() {
        PrintMode printMode = PrintMode.TEXT;
        this.printMode = printMode;
        this.lastNonAutoMode = printMode;
        this.fileName = "";
        this.maxDotLineWidth = 840;
        this.maxDotLineHeight = 0;
        this.scaleType = ImageView.ScaleType.FIT_XY;
        this.rotate = 0;
        this.isInitSize = false;
    }

    private void adjustPrintModeButtons() {
        if (!isAutoPrintModeAvailable()) {
            this.rbPicturePrintAuto.setChecked(false);
            this.rbPicturePrintAuto.setEnabled(false);
            this.rbPicturePrintAuto.setVisibility(8);
            resizePrintModeButton(this.rbPicturePrintText, 84, 0);
            resizePrintModeButton(this.rbPicturePrintImageText, 84, 10);
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
    public void applyDocumentPreview(String str, List<Bitmap> list, boolean z6, boolean z7) {
        synchronized (this.previewLock) {
            try {
                if (str.equals(this.activePreviewKey)) {
                    this.appliedPreviewKey = str;
                    boolean z8 = false;
                    if (this.printAfterPreviewReady && str.equals(this.pendingPrintPreviewKey)) {
                        this.printAfterPreviewReady = false;
                        this.pendingPrintPreviewKey = "";
                        z8 = true;
                    }
                    this.tvTitle.setText(this.fileName);
                    this.quickAdapter.replaceAll(list);
                    this.tvPdfPrintDataCount.setText(String.format("1/%d", Integer.valueOf(list.size())));
                    if (z6) {
                        this.qswPdfPrintPrintEnd.setOffsetValue(list.size());
                        this.qswPdfPrintPrintEnd.setOffsetBigValue(list.size());
                        this.qswPdfPrintPrintStart.setOffsetValue(1);
                        this.qswPdfPrintPrintStart.setOffsetBigValue(list.size());
                        this.printStart = 1;
                        this.printEnd = list.size();
                    }
                    if (z8) {
                        continuePDFPrintConfirm();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private Bitmap autoProcessPdfImage(Bitmap bitmap) {
        p050j.j jVarA = p056k0.k.a(this.context, bitmap);
        if (jVarA.c) {
            return (Bitmap) jVarA.d;
        }
        p051j0.a.c(this.TAG, "AI model processing failed, fallback to TEXT mode: " + jVarA.b);
        this.pictureUtil.getClass();
        return p056k0.q.b(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PreviewResult buildDocumentPreview(List<String> list, PrintMode printMode, int i5, int i6, ImageView.ScaleType scaleType, int i7) {
        Bitmap bitmapScaleBitmapByTile;
        Bitmap bitmapB;
        ArrayList arrayList = new ArrayList();
        P0 p1 = this.printInfo;
        int iMin = p1 != null ? Math.min(p1.d, i5) : i5;
        Iterator<String> it = list.iterator();
        boolean z6 = false;
        while (it.hasNext()) {
            try {
                Bitmap bitmapC = com.bumptech.glide.g.c(iMin, i6, it.next());
                if (bitmapC != null) {
                    if (i7 == 90) {
                        try {
                            Matrix matrix = new Matrix();
                            matrix.postRotate(90.0f);
                            bitmapC = Bitmap.createBitmap(bitmapC, 0, 0, bitmapC.getWidth(), bitmapC.getHeight(), matrix, true);
                        } catch (Exception e) {
                            e = e;
                            p051j0.a.e(this.TAG, "showDocument", e);
                            z6 = true;
                        }
                    }
                    if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
                        try {
                            bitmapScaleBitmapByTile = this.pictureUtil.scaleBitmapByEqualRatio(bitmapC, iMin, i6);
                        } catch (Exception e6) {
                            e = e6;
                            p051j0.a.e(this.TAG, "showDocument", e);
                            z6 = true;
                        }
                    } else {
                        bitmapScaleBitmapByTile = this.pictureUtil.scaleBitmapByTile(bitmapC, iMin, i6);
                    }
                    if (printMode == PrintMode.AUTO) {
                        bitmapB = autoProcessPdfImage(bitmapScaleBitmapByTile);
                    } else if (printMode == PrintMode.IMAGE_TEXT) {
                        this.pictureUtil.getClass();
                        bitmapB = p056k0.q.d(bitmapScaleBitmapByTile);
                    } else {
                        this.pictureUtil.getClass();
                        bitmapB = p056k0.q.b(bitmapScaleBitmapByTile);
                    }
                    arrayList.add(bitmapB);
                }
            } catch (Exception e7) {
                e = e7;
            }
        }
        return new PreviewResult(arrayList, z6);
    }

    private String buildDocumentPreviewKey(PrintMode printMode, PrintMode printMode2, int i5, int i6, ImageView.ScaleType scaleType, int i7) {
        List<String> list = this.documentBitmapList;
        StringBuilder sbB = p050j.w.b(printMode, printMode2, i5, i6, scaleType, i7);
        sbB.append("|src=");
        for (String str : list) {
            File file = new File(str);
            sbB.append(str);
            sbB.append(NameUtil.COLON);
            long length = 0;
            sbB.append(file.exists() ? file.lastModified() : 0L);
            sbB.append(NameUtil.COLON);
            if (file.exists()) {
                length = file.length();
            }
            sbB.append(length);
            sbB.append(';');
        }
        return sbB.toString();
    }

    private void continuePDFPrintConfirm() {
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
        } else {
            if (this.printStart > this.printEnd) {
                p042h2.d.show(p113u.g.toast_42);
                return;
            }
            com.appdev.standard.dialog.E.c();
            com.appdev.standard.dialog.E.b(0);
            runOnNewThread(new AnonymousClass12(printer));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static String getFileExtension(String str) {
        int iLastIndexOf;
        return (str == null || str.isEmpty() || (iLastIndexOf = str.lastIndexOf(46)) <= 0 || iLastIndexOf >= str.length() + (-1)) ? "" : str.substring(iLastIndexOf + 1);
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
                    requestDocumentPreviewGeneration(false, true);
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

    private void invalidatePreviewCache() {
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
        int iMm2px = C1849c.mm2px(offsetValue);
        int iMm2px2 = C1849c.mm2px(offsetValue2);
        if (iMm2px <= 0) {
            iMm2px = 1;
        }
        int i5 = iMm2px2 <= 0 ? 1 : iMm2px2;
        P0 p1 = this.printInfo;
        if (p1 != null) {
            iMm2px = Math.min(p1.d, iMm2px);
        }
        String strBuildDocumentPreviewKey = buildDocumentPreviewKey(this.printMode, effectivePreviewMode, iMm2px, i5, this.scaleType, this.rotate);
        synchronized (this.previewLock) {
            this.activePreviewKey = strBuildDocumentPreviewKey;
            String str = this.appliedPreviewKey;
            boolean zContainsKey = this.previewCache.containsKey(strBuildDocumentPreviewKey);
            if (strBuildDocumentPreviewKey == null) {
                zEquals = str == null;
            } else {
                zEquals = strBuildDocumentPreviewKey.equals(str);
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
    public /* synthetic */ void lambda$startModelDownloadWithProgress$0(DialogInterface dialogInterface) {
        stopWaitingForModelDownload(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pdf2Image(String str, String str2) {
        System.out.println("filePath:     " + str);
        File file = new File(str);
        String strE = com.bumptech.glide.g.e(str);
        this.fileName = str2;
        renderPdf(ParcelFileDescriptor.open(file, 268435456), strE);
    }

    private void renderPdf(ParcelFileDescriptor parcelFileDescriptor, String str) {
        this.documentBitmapList = new ArrayList();
        invalidatePreviewCache();
        PdfRenderer pdfRenderer = new PdfRenderer(parcelFileDescriptor);
        int i5 = 0;
        while (i5 < pdfRenderer.getPageCount()) {
            int i6 = i5 + 1;
            String str2 = str + "_" + i6;
            String str3 = getExternalCacheDir() + PackagingURIHelper.FORWARD_SLASH_STRING + str2 + ".png";
            if (!new File(str3).exists()) {
                str3 = null;
            }
            if (str3 == null) {
                PdfRenderer.Page pageOpenPage = pdfRenderer.openPage(i5);
                float width = 3600 / pageOpenPage.getWidth();
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (pageOpenPage.getWidth() * width), (int) (pageOpenPage.getHeight() * width), Bitmap.Config.ARGB_8888);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(-1);
                canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
                pageOpenPage.render(bitmapCreateBitmap, null, null, 1);
                this.documentBitmapList.add(com.bumptech.glide.g.g(this, bitmapCreateBitmap, str2));
                bitmapCreateBitmap.recycle();
                pageOpenPage.close();
            } else {
                this.documentBitmapList.add(str3);
            }
            i5 = i6;
        }
        pdfRenderer.close();
    }

    private void requestDocumentPreviewGeneration(final boolean z6, final boolean z7) {
        List<Bitmap> list;
        P0 p1;
        List<String> list2 = this.documentBitmapList;
        if (list2 == null || list2.isEmpty()) {
            p050j.w.c();
            return;
        }
        if (z7) {
            boolean z8 = this.printMode == PrintMode.AUTO;
            boolean zC = p056k0.n.c(this.context);
            if (z8 && !zC) {
                showModelDownloadRequiredForPrint();
                return;
            }
        }
        int offsetValue = this.qswPdfPrintPrintWidth.getOffsetValue();
        int offsetValue2 = this.qswPdfPrintPrintHeight.getOffsetValue();
        final int iMm2px = C1849c.mm2px(offsetValue);
        final int iMm2px2 = C1849c.mm2px(offsetValue2);
        if (iMm2px <= 0) {
            iMm2px = 1;
        }
        if (iMm2px2 <= 0) {
            iMm2px2 = 1;
        }
        P0 p6 = this.printInfo;
        if (p6 != null) {
            iMm2px = Math.min(p6.d, iMm2px);
        }
        if (!this.isInitSize && (p1 = this.printInfo) != null) {
            iMm2px = p1.d;
            Iterator<String> it = this.documentBitmapList.iterator();
            while (it.hasNext()) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(it.next());
                if (bitmapDecodeFile != null) {
                    iMm2px2 = (int) ((bitmapDecodeFile.getHeight() / bitmapDecodeFile.getWidth()) * iMm2px);
                    runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.10
                        @Override // java.lang.Runnable
                        public void run() {
                            PDFPrintActivity.this.qswPdfPrintPrintWidth.setOffsetValue((int) C1849c.px2mm(iMm2px));
                            PDFPrintActivity.this.qswPdfPrintPrintHeight.setOffsetValue((int) C1849c.px2mm(iMm2px2));
                        }
                    });
                    break;
                }
            }
            this.isInitSize = true;
        }
        final int i5 = iMm2px;
        final int i6 = iMm2px2;
        PrintMode printMode = this.printMode;
        final PrintMode effectivePreviewMode = getEffectivePreviewMode(printMode, !z7);
        if (effectivePreviewMode == null) {
            return;
        }
        final ImageView.ScaleType scaleType = this.scaleType;
        final int i7 = this.rotate;
        final String strBuildDocumentPreviewKey = buildDocumentPreviewKey(printMode, effectivePreviewMode, i5, i6, scaleType, i7);
        synchronized (this.previewLock) {
            try {
                this.activePreviewKey = strBuildDocumentPreviewKey;
                if (z7) {
                    this.printAfterPreviewReady = true;
                    this.pendingPrintPreviewKey = strBuildDocumentPreviewKey;
                }
                list = this.previewCache.get(strBuildDocumentPreviewKey);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list != null) {
            applyDocumentPreview(strBuildDocumentPreviewKey, list, z6, z7);
            p050j.w.c();
            return;
        }
        synchronized (this.previewLock) {
            try {
                if (strBuildDocumentPreviewKey.equals(this.generatingPreviewKey)) {
                    return;
                }
                final int i8 = this.previewGenerationToken + 1;
                this.previewGenerationToken = i8;
                this.generatingPreviewKey = strBuildDocumentPreviewKey;
                final ArrayList arrayList = new ArrayList(this.documentBitmapList);
                p050j.w.e();
                runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.11
                    @Override // java.lang.Runnable
                    public void run() {
                        final PreviewResult previewResultBuildDocumentPreview = PDFPrintActivity.this.buildDocumentPreview(arrayList, effectivePreviewMode, i5, i6, scaleType, i7);
                        synchronized (PDFPrintActivity.this.previewLock) {
                            try {
                                PDFPrintActivity.this.previewCache.put(strBuildDocumentPreviewKey, previewResultBuildDocumentPreview.bitmaps);
                                if (strBuildDocumentPreviewKey.equals(PDFPrintActivity.this.generatingPreviewKey)) {
                                    PDFPrintActivity.this.generatingPreviewKey = "";
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z9;
                                boolean zEquals;
                                if (!PDFPrintActivity.this.isActivityAlive()) {
                                    p050j.w.c();
                                    return;
                                }
                                synchronized (PDFPrintActivity.this.previewLock) {
                                    try {
                                        AnonymousClass11 anonymousClass11 = AnonymousClass11.this;
                                        int i9 = i8;
                                        int i10 = PDFPrintActivity.this.previewGenerationToken;
                                        AnonymousClass11 anonymousClass12 = AnonymousClass11.this;
                                        String str = strBuildDocumentPreviewKey;
                                        String str2 = PDFPrintActivity.this.activePreviewKey;
                                        z9 = false;
                                        if (i9 == i10) {
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
                                if (z9 && previewResultBuildDocumentPreview.toastSkipped) {
                                    p042h2.d.show(p113u.g.toast_pdf_page_skipped);
                                }
                                if (z9) {
                                    AnonymousClass11 anonymousClass13 = AnonymousClass11.this;
                                    PDFPrintActivity.this.applyDocumentPreview(strBuildDocumentPreviewKey, previewResultBuildDocumentPreview.bitmaps, z6, z7);
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
        if (this.lastNonAutoMode == PrintMode.IMAGE_TEXT) {
            onPicturePrintImageTextModeClick(null);
        } else {
            onPicturePrintTextModeClick(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showDocument(boolean z6) {
        requestDocumentPreviewGeneration(z6, false);
    }

    private void showModelDownloadRequiredForPrint() {
        new AlertDialog.Builder(this).setTitle(p113u.g.dlg_model_download_title).setMessage(p113u.g.dlg_model_download_msg).setNegativeButton(p113u.g.cancel, (DialogInterface.OnClickListener) null).setPositiveButton(p113u.g.download, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i5) {
                PDFPrintActivity.this.startModelDownloadWithProgress(true);
            }
        }).setCancelable(false).show();
    }

    private void showPdfDocument(final String str) {
        p050j.w.f(getString(p113u.g.text_265));
        runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (PDFPrintActivity.this.isValidUri(str)) {
                        Uri uri = Uri.parse(str);
                        String strC = p051j0.i.c(PDFPrintActivity.this, uri);
                        if ("pdf".equals(PDFPrintActivity.getFileExtension(strC).toLowerCase())) {
                            PDFPrintActivity.this.pdf2Image(uri, strC);
                        } else {
                            PDFPrintActivity.this.word2Image(uri, strC);
                        }
                    } else {
                        String name = new File(str).getName();
                        if ("pdf".equals(PDFPrintActivity.getFileExtension(name).toLowerCase())) {
                            PDFPrintActivity.this.pdf2Image(str, name);
                        } else {
                            PDFPrintActivity.this.word2Image(str, name);
                        }
                    }
                    PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PDFPrintActivity.this.showDocument(true);
                        }
                    });
                } catch (Exception e) {
                    PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.9.2
                        @Override // java.lang.Runnable
                        public void run() {
                            p050j.w.c();
                            p042h2.d.show(p113u.g.toast_41);
                        }
                    });
                    e.printStackTrace();
                }
            }
        });
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
        this.modelDownloadProgressDialog.setOnCancelListener(new A(this, 0));
        this.modelDownloadProgressDialog.show();
        this.modelDownloadListener = new AnonymousClass17();
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
        showDocument(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void word2Image(Uri uri, String str) {
        this.documentBitmapList = new ArrayList();
        invalidatePreviewCache();
        String strD = com.bumptech.glide.g.d(this, uri);
        File externalCacheDir = getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = getCacheDir();
        }
        File file = new File(externalCacheDir, androidx.collection.a.n(strD, ".pdf"));
        if (file.exists()) {
            pdf2Image(file.getAbsolutePath(), str);
            return;
        }
        r0<ConvertDto> r0VarExecute = ((DocumentApi) Http.createApi(DocumentApi.class)).convert(okhttp3.D.createFormData(Constants.FILE, str, okhttp3.Q.create(okhttp3.B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), p051j0.i.k(this, uri))), okhttp3.Q.create(okhttp3.B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), "File description")).execute();
        if (r0VarExecute.body() == null || !r0VarExecute.body().isOk()) {
            return;
        }
        p050j.e eVar = (p050j.e) p050j.a.f(r0VarExecute.body().getData().getDocName());
        com.appdev.standard.util.fileDownload.m mVar = new com.appdev.standard.util.fileDownload.m();
        Object obj = eVar.f5380j.get("fileUrl");
        mVar.downloadFile(obj == null ? null : obj.toString(), file.getAbsolutePath());
        pdf2Image(file.getAbsolutePath(), str);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_183));
        this.context = this;
        this.pictureUtil = new p056k0.q();
        com.library.base.util.recyclerview.f fVar = new com.library.base.util.recyclerview.f(this, p113u.e.item_pdf_print_img) { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, Bitmap bitmap) {
                p047i2.a.loadBitmapFitCenter(bitmap, (ImageView) aVar.a(p113u.d.iv_item_pdf_print_img), -1);
            }
        };
        this.quickAdapter = fVar;
        fVar.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.2
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                HashMap map = new HashMap();
                map.put("images", PDFPrintActivity.this.documentBitmapList);
                map.put(FirebaseAnalytics.Param.INDEX, Integer.valueOf(i5 + 1));
                FlutterBoost.instance().open(new FlutterBoostRouteOptions.Builder().pageName("doc_edit").arguments(map).requestCode(0).build());
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 0, false);
        this.rvPdfPrintData.setLayoutManager(linearLayoutManager);
        this.rvPdfPrintData.setAdapter(this.quickAdapter);
        this.rvPdfPrintData.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.3
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i5, int i6) {
                super.onScrolled(recyclerView, i5, i6);
                PDFPrintActivity.this.tvPdfPrintDataCount.setText(String.format("%d/%d", Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition() + 1), Integer.valueOf(PDFPrintActivity.this.quickAdapter.getData().size())));
            }
        });
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
        this.qswPdfPrintPrintCount.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.4
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PDFPrintActivity.this.printCount = i5;
            }
        });
        this.qswPdfPrintPrintStart.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.5
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                if (i5 <= PDFPrintActivity.this.quickAdapter.getItemCount()) {
                    PDFPrintActivity.this.printStart = i5;
                } else {
                    PDFPrintActivity pDFPrintActivity = PDFPrintActivity.this;
                    pDFPrintActivity.qswPdfPrintPrintStart.setOffsetValue(pDFPrintActivity.printStart);
                }
            }
        });
        this.qswPdfPrintPrintEnd.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.6
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                if (i5 <= PDFPrintActivity.this.quickAdapter.getItemCount()) {
                    PDFPrintActivity.this.printEnd = i5;
                } else {
                    PDFPrintActivity pDFPrintActivity = PDFPrintActivity.this;
                    pDFPrintActivity.qswPdfPrintPrintEnd.setOffsetValue(pDFPrintActivity.printEnd);
                }
            }
        });
        this.qswPdfPrintPrintWidth.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.7
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PDFPrintActivity.this.showDocument(false);
            }
        });
        this.qswPdfPrintPrintHeight.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.8
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                PDFPrintActivity.this.showDocument(false);
            }
        });
    }

    public boolean isValidUri(String str) {
        try {
            Uri uri = Uri.parse(str);
            return (uri == null || uri.getScheme() == null) ? false : true;
        } catch (Exception unused) {
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_pdf_print;
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        stopWaitingForModelDownload(false);
        super.onDestroy();
    }

    public void onPDFPrintConfirmClick(View view) {
        if (isAppliedPreviewReadyForCurrentPrintMode()) {
            continuePDFPrintConfirm();
        } else {
            requestDocumentPreviewGeneration(false, true);
        }
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
            new AlertDialog.Builder(this).setTitle(p113u.g.dlg_model_download_title).setMessage(p113u.g.dlg_model_download_msg).setNegativeButton(p113u.g.cancel, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.16
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    PDFPrintActivity.this.revertPrintMode();
                }
            }).setPositiveButton(p113u.g.download, new DialogInterface.OnClickListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.15
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i5) {
                    PDFPrintActivity.this.startModelDownloadWithProgress(false);
                }
            }).setCancelable(false).show();
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
        showDocument(false);
    }

    public void onPicturePrintRotate0Click(View view) {
        this.rbPicturePrintRotate0.setChecked(true);
        this.rbPicturePrintRotate90.setChecked(false);
        this.rbPicturePrintRotate0.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintRotate90.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintRotate0.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintRotate90.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rotate = 0;
        showDocument(false);
    }

    public void onPicturePrintRotate90Click(View view) {
        this.rbPicturePrintRotate0.setChecked(false);
        this.rbPicturePrintRotate90.setChecked(true);
        this.rbPicturePrintRotate0.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintRotate90.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintRotate0.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rbPicturePrintRotate90.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rotate = 90;
        showDocument(false);
    }

    public void onPicturePrintScaleTypeCenterInsideClick(View view) {
        this.rbPicturePrintScaleTypeFitXY.setChecked(false);
        this.rbPicturePrintScaleTypeCenterInside.setChecked(true);
        this.rbPicturePrintScaleTypeFitXY.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintScaleTypeCenterInside.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintScaleTypeFitXY.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.rbPicturePrintScaleTypeCenterInside.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.scaleType = ImageView.ScaleType.CENTER_INSIDE;
        showDocument(false);
    }

    public void onPicturePrintScaleTypeFitXYClick(View view) {
        this.rbPicturePrintScaleTypeFitXY.setChecked(true);
        this.rbPicturePrintScaleTypeCenterInside.setChecked(false);
        this.rbPicturePrintScaleTypeFitXY.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
        this.rbPicturePrintScaleTypeCenterInside.setBackgroundResource(p113u.c.bg_ffffff_rad_10_stroke_999999);
        this.rbPicturePrintScaleTypeFitXY.setTextColor(getResources().getColor(p113u.a.color_FFFFFF));
        this.rbPicturePrintScaleTypeCenterInside.setTextColor(getResources().getColor(p113u.a.color_999999));
        this.scaleType = ImageView.ScaleType.FIT_XY;
        showDocument(false);
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
        showDocument(false);
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.printInfo = p051j0.a.h();
        K0 printer = p051j0.f.getPrinter();
        if (this.printInfo == null && printer != null && printer.b()) {
            p050j.w.f(getResources().getString(p113u.g.toast_44));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.14
                @Override // java.lang.Runnable
                public void run() {
                    PDFPrintActivity.this.printInfo = p051j0.f.read_print_info();
                    PDFPrintActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p050j.w.c();
                        }
                    });
                }
            });
        }
    }

    public void onSettingPrinterClick(View view) {
        PrintSetting printSetting = new PrintSetting(new PrintSetting.OnSettingListener() { // from class: com.appdev.standard.page.printerlabel.PDFPrintActivity.18
            @Override // com.appdev.standard.page.bluetooth.PrintSetting.OnSettingListener
            public void onSetting(P0 p1) {
            }
        });
        this.mCustomPopWindow = printSetting;
        printSetting.showSetting(this, getWindow().getDecorView().findViewById(R.id.content));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        String string = bundle.getString("fileAbsolutePath");
        this.fileAbsolutePath = string;
        if (string != null) {
            showPdfDocument(string);
        } else {
            p042h2.d.show(p113u.g.toast_40);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pdf2Image(Uri uri, String str) {
        String strD = com.bumptech.glide.g.d(this.context, uri);
        this.fileName = str;
        renderPdf(this.context.getContentResolver().openFileDescriptor(uri, "r"), strD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void word2Image(String str, String str2) {
        this.documentBitmapList = new ArrayList();
        invalidatePreviewCache();
        String strE = com.bumptech.glide.g.e(str);
        File externalCacheDir = getExternalCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = getCacheDir();
        }
        File file = new File(externalCacheDir, androidx.collection.a.n(strE, ".pdf"));
        if (file.exists()) {
            pdf2Image(file.getAbsolutePath(), str2);
            return;
        }
        r0<ConvertDto> r0VarExecute = ((DocumentApi) Http.createApi(DocumentApi.class)).convert(okhttp3.D.createFormData(Constants.FILE, str2, okhttp3.Q.create(okhttp3.B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), new File(str))), okhttp3.Q.create(okhttp3.B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), "File description")).execute();
        if (r0VarExecute.body() == null || !r0VarExecute.body().isOk()) {
            return;
        }
        p050j.e eVar = (p050j.e) p050j.a.f(r0VarExecute.body().getData().getDocName());
        com.appdev.standard.util.fileDownload.m mVar = new com.appdev.standard.util.fileDownload.m();
        Object obj = eVar.f5380j.get("fileUrl");
        mVar.downloadFile(obj == null ? null : obj.toString(), file.getAbsolutePath());
        pdf2Image(file.getAbsolutePath(), str2);
    }
}
