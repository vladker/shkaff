package com.appdev.standard.page.printerlabel.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.appdev.standard.model.ElementAttributeBarCodeBean;
import com.appdev.standard.model.ElementAttributeBean;
import com.appdev.standard.model.ElementAttributeTableBean;
import com.appdev.standard.model.ElementAttributeTableChildBean;
import com.appdev.standard.model.ElementAttributeTextBean;
import com.appdev.standard.model.ElementAttributeTimeBean;
import com.appdev.standard.model.PrintTaskElementModel;
import com.appdev.standard.model.PrintTaskModel;
import com.appdev.standard.model.ReceiptBarcodeDataModel;
import com.appdev.standard.model.ReceiptDateDataModel;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptQrCodeDataModel;
import com.appdev.standard.model.ReceiptTextDataModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.appdev.standard.page.printerlabel.widget.TemplatePageView;
import com.orhanobut.hawk.Hawk;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p134x2.C1849c;
import p134x2.G;
import p134x2.P0;
import p134x2.Y;
import p134x2.a1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class DataCreateUtil {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CreateBitmapEventListener {
        void onComplete(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface StreamPrintListener {
        void onComplete(boolean z6, int i5);

        void onError(int i5, String str);

        boolean onPageGenerated(int i5, int i6, byte[] bArr);
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b)));
        }
        return sb.toString().trim();
    }

    private static Bitmap convertWhiteToTransparent(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        for (int i5 = 0; i5 < height; i5++) {
            if (iArr[i5] == -1) {
                iArr[i5] = 0;
            }
        }
        bitmapCreateBitmap.setPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmapCreateBitmap;
    }

    public static void create(final P0 p1, final TemplatePageView templatePageView, final TemplateConfigBean templateConfigBean, final int i5, final boolean z6, final int i6, final CreateBitmapEventListener createBitmapEventListener) {
        if (p1 == null) {
            createBitmapEventListener.onComplete(new byte[0]);
            return;
        }
        if (i6 > 1) {
            Iterator<String> it = templatePageView.getAllExcelUrls().iterator();
            while (it.hasNext()) {
                if (p056k0.g.downloadToCache(it.next()).a()) {
                    p042h2.d.show(p113u.g.text_488);
                    createBitmapEventListener.onComplete(new byte[0]);
                    return;
                }
            }
        }
        Looper.prepare();
        final Handler handler = new Handler(Looper.myLooper());
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.d
            @Override // java.lang.Runnable
            public final void run() {
                DataCreateUtil.lambda$create$13(p1, templatePageView, i5, z6, i6, handler, templateConfigBean, createBitmapEventListener);
            }
        });
        Looper.loop();
    }

    public static void createAndPrintByPage(final P0 p1, final TemplatePageView templatePageView, final TemplateConfigBean templateConfigBean, final int i5, final boolean z6, final int i6, final StreamPrintListener streamPrintListener) {
        if (p1 == null) {
            streamPrintListener.onError(-1, "打印机信息为空");
            streamPrintListener.onComplete(false, 0);
            return;
        }
        if (i6 > 1) {
            Iterator<String> it = templatePageView.getAllExcelUrls().iterator();
            while (it.hasNext()) {
                if (p056k0.g.downloadToCache(it.next()).a()) {
                    streamPrintListener.onError(-1, "Excel文件下载失败");
                    streamPrintListener.onComplete(false, 0);
                    return;
                }
            }
        }
        Looper.prepare();
        final Looper looperMyLooper = Looper.myLooper();
        final Handler handler = new Handler(looperMyLooper);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.g
            @Override // java.lang.Runnable
            public final void run() {
                DataCreateUtil.lambda$createAndPrintByPage$0(p1, templatePageView, templateConfigBean, i5, z6, i6, streamPrintListener, handler, looperMyLooper);
            }
        });
        Looper.loop();
    }

    public static synchronized boolean downloadFont(List<String> list) {
        for (String str : list) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final int[] iArr = {-1};
            FontDataManager.getInstance().getFontLocalFile(str, String.valueOf(new Random().nextInt()), new com.appdev.standard.util.fileDownload.h() { // from class: com.appdev.standard.page.printerlabel.util.DataCreateUtil.1
                @Override // com.appdev.standard.util.fileDownload.h
                public void onError(String str2, Throwable th) {
                    iArr[0] = -1;
                    countDownLatch.countDown();
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onExists() {
                    super.onExists();
                    iArr[0] = 1;
                    countDownLatch.countDown();
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onStartShowLoading() {
                    super.onStartShowLoading();
                }

                @Override // com.appdev.standard.util.fileDownload.h
                public void onSuccess(String str2) {
                    iArr[0] = 1;
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(120L, TimeUnit.SECONDS);
                p051j0.a.d("DataCreateUtil", "字体=" + str + "完毕");
                if (iArr[0] == -1) {
                    return false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static Bitmap extractBlackContent(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        for (int i5 = 0; i5 < bitmap.getHeight(); i5++) {
            for (int i6 = 0; i6 < bitmap.getWidth(); i6++) {
                int pixel = bitmap.getPixel(i6, i5);
                int iRed = Color.red(pixel);
                int iGreen = Color.green(pixel);
                int iBlue = Color.blue(pixel);
                double d = iRed;
                double d6 = iGreen;
                bitmapCreateBitmap.setPixel(i6, i5, (((d > (d6 * 1.5d) ? 1 : (d == (d6 * 1.5d) ? 0 : -1)) > 0 && (d > (((double) iBlue) * 1.5d) ? 1 : (d == (((double) iBlue) * 1.5d) ? 0 : -1)) > 0) || (((double) iBlue) * 0.0722d) + ((d6 * 0.7152d) + (d * 0.2126d)) >= ((double) 160)) ? -1 : ViewCompat.MEASURED_STATE_MASK);
            }
        }
        return bitmapCreateBitmap;
    }

    private static Bitmap extractRedContent(Bitmap bitmap) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        for (int i5 = 0; i5 < bitmap.getHeight(); i5++) {
            for (int i6 = 0; i6 < bitmap.getWidth(); i6++) {
                int pixel = bitmap.getPixel(i6, i5);
                int iRed = Color.red(pixel);
                int iGreen = Color.green(pixel);
                int iBlue = Color.blue(pixel);
                bitmapCreateBitmap.setPixel(i6, i5, (iRed < 200 || iGreen > 80 || iBlue > 80 || iRed - iGreen < 120 || iRed - iBlue < 120) ? -1 : SupportMenu.CATEGORY_MASK);
            }
        }
        return bitmapCreateBitmap;
    }

    public static List<String> getFontList(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        getFontList(arrayList, list);
        return arrayList;
    }

    private static byte[] getTscColorCommand(int i5) {
        String strI = androidx.collection.a.i(i5, "COLOR ", "\n");
        try {
            return strI.getBytes("GBK");
        } catch (UnsupportedEncodingException unused) {
            return strI.getBytes();
        }
    }

    public static boolean isReceiptSame(List<ReceiptElementModel> list) {
        for (ReceiptElementModel receiptElementModel : list) {
            if (receiptElementModel.getItemType() == 5) {
                if (((ReceiptTextDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptTextDataModel.class)).getInputDataType() == 1) {
                    return false;
                }
            } else if (receiptElementModel.getItemType() == 7) {
                if (((ReceiptBarcodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptBarcodeDataModel.class)).getInputDataType() == 1) {
                    return false;
                }
            } else if (receiptElementModel.getItemType() == 8) {
                if (((ReceiptQrCodeDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptQrCodeDataModel.class)).getInputDataType() == 1) {
                    return false;
                }
            } else if (receiptElementModel.getItemType() == 11 && ((ReceiptDateDataModel) p052j2.c.d(receiptElementModel.getData(), ReceiptDateDataModel.class)).getTimeType() == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$10(Handler handler, TemplateConfigBean templateConfigBean, boolean z6, CreateBitmapEventListener createBitmapEventListener, Bitmap[] bitmapArr) {
        handler.post(new c(bitmapArr, templateConfigBean, z6, createBitmapEventListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$11(TemplateConfigBean templateConfigBean, int i5, Bitmap[] bitmapArr, boolean z6, boolean z7, CreateBitmapEventListener createBitmapEventListener) {
        byte[] bArrByteMerger;
        byte[] bArr = new byte[0];
        byte[] bArrByteMerger2 = new byte[0];
        int iMax = Math.max(templateConfigBean.getColumns(), 1);
        if (i5 == 0 || i5 == 180) {
            bArrByteMerger = Y.byteMerger(bArr, a1.sizeBymm((templateConfigBean.getWidth() * iMax) + (iMax > 1 ? (iMax - 1) * templateConfigBean.getSpacing() : 0), templateConfigBean.getHeight()));
        } else {
            bArrByteMerger = Y.byteMerger(bArr, a1.sizeBymm((templateConfigBean.getHeight() * iMax) + (iMax > 1 ? (iMax - 1) * templateConfigBean.getSpacing() : 0), templateConfigBean.getWidth()));
        }
        byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArrByteMerger, a1.cls()), a1.direction(0));
        int i6 = 0;
        for (Bitmap bitmap : bitmapArr) {
            int iMax2 = i6 % Math.max(templateConfigBean.getColumns(), 1);
            if (iMax2 == 0) {
                bArrByteMerger2 = new byte[0];
            }
            if (z6) {
                Bitmap bitmapExtractBlackContent = extractBlackContent(bitmap);
                Bitmap bitmapExtractRedContent = extractRedContent(bitmap);
                byte[] bArrByteMerger4 = Y.byteMerger(bArrByteMerger2, getTscColorCommand(0));
                byte[] bArrByteMerger5 = Y.byteMerger(z7 ? Y.byteMerger(bArrByteMerger4, a1.bitmapByZLib(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, bitmapExtractBlackContent, 128)) : Y.byteMerger(bArrByteMerger4, a1.bitmap(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, 0, bitmapExtractBlackContent, 128)), getTscColorCommand(1));
                bArrByteMerger2 = z7 ? Y.byteMerger(bArrByteMerger5, a1.bitmapByZLib(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, bitmapExtractRedContent, 128)) : Y.byteMerger(bArrByteMerger5, a1.bitmap(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, 0, bitmapExtractRedContent, 128));
            } else if (z7) {
                bArrByteMerger2 = Y.byteMerger(bArrByteMerger2, a1.bitmapByZLib(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, bitmap, 128));
            } else {
                bArrByteMerger2 = Y.byteMerger(bArrByteMerger2, a1.bitmap(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + (bitmap.getWidth() * iMax2), 0, 0, bitmap, 128));
            }
            if (Math.max(templateConfigBean.getColumns(), 1) == 1) {
                bArrByteMerger2 = Y.byteMerger(bArrByteMerger2, a1.print(1));
                bArrByteMerger3 = Y.byteMerger(bArrByteMerger3, bArrByteMerger2);
            } else if (i6 == bitmapArr.length - 1 || (iMax2 != 0 && iMax2 == Math.max(templateConfigBean.getColumns(), 1) - 1)) {
                bArrByteMerger2 = Y.byteMerger(bArrByteMerger2, a1.print(1));
                bArrByteMerger3 = Y.byteMerger(bArrByteMerger3, bArrByteMerger2);
            }
            i6++;
        }
        p051j0.a.c("PRINTER_CMD", "指令长度: " + bArrByteMerger3.length + " 字节");
        StringBuilder sb = new StringBuilder("指令头: ");
        sb.append(bytesToHex(Arrays.copyOfRange(bArrByteMerger3, 0, Math.min(16, bArrByteMerger3.length))));
        p051j0.a.c("PRINTER_CMD", sb.toString());
        p051j0.a.c("PRINTER_CMD", "指令 (Base64): " + Base64.encodeToString(bArrByteMerger3, 2));
        createBitmapEventListener.onComplete(bArrByteMerger3);
        Looper.myLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$12(Handler handler, final TemplateConfigBean templateConfigBean, final int i5, final boolean z6, final boolean z7, final CreateBitmapEventListener createBitmapEventListener, final Bitmap[] bitmapArr) {
        handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.h
            @Override // java.lang.Runnable
            public final void run() {
                DataCreateUtil.lambda$create$11(templateConfigBean, i5, bitmapArr, z6, z7, createBitmapEventListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$create$13(P0 p1, TemplatePageView templatePageView, final int i5, boolean z6, int i6, final Handler handler, final TemplateConfigBean templateConfigBean, final CreateBitmapEventListener createBitmapEventListener) {
        final boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
        final boolean z7 = p1.f8873p == 1;
        if ("01".equals(p1.getCmdMode())) {
            templatePageView.drawLabel2PrintBitmap(i5, z6, i6, new TemplatePageView.DrawLabel2PrintBitmapEventListener() { // from class: com.appdev.standard.page.printerlabel.util.k
                @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.DrawLabel2PrintBitmapEventListener
                public final void onComplete(Bitmap[] bitmapArr) {
                    DataCreateUtil.lambda$create$10(handler, templateConfigBean, zBooleanValue, createBitmapEventListener, bitmapArr);
                }
            });
        } else {
            templatePageView.drawLabel2PrintBitmap(i5, z6, i6, new TemplatePageView.DrawLabel2PrintBitmapEventListener() { // from class: com.appdev.standard.page.printerlabel.util.l
                @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.DrawLabel2PrintBitmapEventListener
                public final void onComplete(Bitmap[] bitmapArr) {
                    DataCreateUtil.lambda$create$12(handler, templateConfigBean, i5, z7, zBooleanValue, createBitmapEventListener, bitmapArr);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$create$9(Bitmap[] bitmapArr, TemplateConfigBean templateConfigBean, boolean z6, CreateBitmapEventListener createBitmapEventListener) {
        byte[] bArrByteMerger = new byte[0];
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (Bitmap bitmap : bitmapArr) {
            arrayList.add(bitmap);
            if (Math.max(templateConfigBean.getColumns(), 1) == 1) {
                byte[] bArrByteMerger2 = Y.byteMerger(Y.byteMerger(bArrByteMerger, G.start()), G.centerAligned());
                bArrByteMerger = Y.byteMerger(z6 ? Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendDataByZLib(bitmap)) : Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendData(bitmap)), G.end());
                arrayList.clear();
            } else if (i5 == bitmapArr.length - 1 || arrayList.size() == Math.max(templateConfigBean.getColumns(), 1)) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((Math.max(templateConfigBean.getColumns(), 1) - 1) * C1849c.mm2px(templateConfigBean.getSpacing())) + (Math.max(templateConfigBean.getColumns(), 1) * bitmap.getWidth()), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                canvas.drawColor(-1);
                byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArrByteMerger, G.start()), G.centerAligned());
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    canvas.drawBitmap((Bitmap) arrayList.get(i6), (C1849c.mm2px(templateConfigBean.getSpacing()) * i6) + (((Bitmap) arrayList.get(i6)).getWidth() * i6), 0.0f, new Paint());
                }
                bArrByteMerger = Y.byteMerger(z6 ? Y.byteMerger(bArrByteMerger3, G.rasterBmpToSendDataByZLib(bitmapCreateBitmap)) : Y.byteMerger(bArrByteMerger3, G.rasterBmpToSendData(bitmapCreateBitmap)), G.end());
                arrayList.clear();
            }
            i5++;
        }
        createBitmapEventListener.onComplete(bArrByteMerger);
        Looper.myLooper().quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lambda$createAndPrintByPage$0(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, boolean z6, int i6, StreamPrintListener streamPrintListener, Handler handler, Looper looper) {
        boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
        boolean z7 = p1.f8873p == 1;
        if ("01".equals(p1.getCmdMode())) {
            processESCPageByPage(p1, templatePageView, templateConfigBean, i5, z6, i6, zBooleanValue, 0, streamPrintListener, handler, looper);
        } else {
            processTSCPageByPage(p1, templatePageView, templateConfigBean, i5, z6, i6, zBooleanValue, z7, 0, streamPrintListener, handler, looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processESCPageByPage$1(StreamPrintListener streamPrintListener, int i5, Looper looper) {
        streamPrintListener.onComplete(true, i5);
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processESCPageByPage$2(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, boolean z6, int i6, boolean z7, int i7, StreamPrintListener streamPrintListener, Handler handler, Looper looper) {
        processESCPageByPage(p1, templatePageView, templateConfigBean, i5, z6, i6, z7, i7 + 1, streamPrintListener, handler, looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processESCPageByPage$3(Bitmap[] bitmapArr, final StreamPrintListener streamPrintListener, final int i5, final Looper looper, final TemplateConfigBean templateConfigBean, final boolean z6, final int i6, final P0 p1, final TemplatePageView templatePageView, final int i7, final boolean z7, final Handler handler) {
        byte[] bArrByteMerger;
        if (bitmapArr != null) {
            try {
                if (bitmapArr.length != 0) {
                    Bitmap bitmap = bitmapArr[0];
                    byte[] bArr = new byte[0];
                    if (Math.max(templateConfigBean.getColumns(), 1) == 1) {
                        byte[] bArrByteMerger2 = Y.byteMerger(Y.byteMerger(bArr, G.start()), G.centerAligned());
                        bArrByteMerger = Y.byteMerger(z6 ? Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendDataByZLib(bitmap)) : Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendData(bitmap)), G.end());
                    } else {
                        byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArr, G.start()), G.centerAligned());
                        bArrByteMerger = Y.byteMerger(z6 ? Y.byteMerger(bArrByteMerger3, G.rasterBmpToSendDataByZLib(bitmap)) : Y.byteMerger(bArrByteMerger3, G.rasterBmpToSendData(bitmap)), G.end());
                    }
                    bitmap.recycle();
                    boolean zOnPageGenerated = streamPrintListener.onPageGenerated(i5, i6, bArrByteMerger);
                    if (zOnPageGenerated && i5 + 1 < i6) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                DataCreateUtil.lambda$processESCPageByPage$2(p1, templatePageView, templateConfigBean, i7, z7, i6, z6, i5, streamPrintListener, handler, looper);
                            }
                        });
                        return;
                    } else {
                        streamPrintListener.onComplete(zOnPageGenerated, i5 + 1);
                        looper.quit();
                        return;
                    }
                }
            } catch (Exception e) {
                streamPrintListener.onError(i5, e.getMessage());
                streamPrintListener.onComplete(false, i5);
                looper.quit();
                return;
            }
        }
        streamPrintListener.onError(i5, "生成Bitmap失败");
        streamPrintListener.onComplete(false, i5);
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processESCPageByPage$4(final Handler handler, final StreamPrintListener streamPrintListener, final int i5, final Looper looper, final TemplateConfigBean templateConfigBean, final boolean z6, final int i6, final P0 p1, final TemplatePageView templatePageView, final int i7, final boolean z7, final Bitmap[] bitmapArr) {
        handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.f
            @Override // java.lang.Runnable
            public final void run() {
                boolean z8 = z7;
                Handler handler2 = handler;
                DataCreateUtil.lambda$processESCPageByPage$3(bitmapArr, streamPrintListener, i5, looper, templateConfigBean, z6, i6, p1, templatePageView, i7, z8, handler2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processTSCPageByPage$5(StreamPrintListener streamPrintListener, int i5, Looper looper) {
        streamPrintListener.onComplete(true, i5);
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processTSCPageByPage$6(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, boolean z6, int i6, boolean z7, boolean z8, int i7, StreamPrintListener streamPrintListener, Handler handler, Looper looper) {
        processTSCPageByPage(p1, templatePageView, templateConfigBean, i5, z6, i6, z7, z8, i7 + 1, streamPrintListener, handler, looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processTSCPageByPage$7(Bitmap[] bitmapArr, final StreamPrintListener streamPrintListener, final int i5, final Looper looper, final TemplateConfigBean templateConfigBean, final int i6, final boolean z6, final boolean z7, final int i7, final P0 p1, final TemplatePageView templatePageView, final boolean z8, final Handler handler) {
        byte[] bArrByteMerger;
        int spacing;
        byte[] bArrByteMerger2;
        int spacing2;
        if (bitmapArr != null) {
            try {
                if (bitmapArr.length != 0) {
                    Bitmap bitmap = bitmapArr[0];
                    byte[] bArrByteMerger3 = new byte[0];
                    byte[] bArr = new byte[0];
                    if (i5 == 0) {
                        int iMax = Math.max(templateConfigBean.getColumns(), 1);
                        if (i6 == 0 || i6 == 180) {
                            int width = templateConfigBean.getWidth() * iMax;
                            if (iMax > 1) {
                                spacing = (iMax - 1) * templateConfigBean.getSpacing();
                            } else {
                                spacing = 0;
                            }
                            bArrByteMerger2 = Y.byteMerger(bArrByteMerger3, a1.sizeBymm(width + spacing, templateConfigBean.getHeight()));
                        } else {
                            int height = templateConfigBean.getHeight() * iMax;
                            if (iMax > 1) {
                                spacing2 = (iMax - 1) * templateConfigBean.getSpacing();
                            } else {
                                spacing2 = 0;
                            }
                            bArrByteMerger2 = Y.byteMerger(bArrByteMerger3, a1.sizeBymm(height + spacing2, templateConfigBean.getWidth()));
                        }
                        bArrByteMerger3 = Y.byteMerger(Y.byteMerger(bArrByteMerger2, a1.cls()), a1.direction(0));
                    }
                    if (z6) {
                        Bitmap bitmapExtractBlackContent = extractBlackContent(bitmap);
                        Bitmap bitmapExtractRedContent = extractRedContent(bitmap);
                        byte[] bArrByteMerger4 = Y.byteMerger(bArr, getTscColorCommand(0));
                        byte[] bArrByteMerger5 = Y.byteMerger(z7 ? Y.byteMerger(bArrByteMerger4, a1.bitmapByZLib(0, 0, bitmapExtractBlackContent, 128)) : Y.byteMerger(bArrByteMerger4, a1.bitmap(0, 0, 0, bitmapExtractBlackContent, 128)), getTscColorCommand(1));
                        bArrByteMerger = z7 ? Y.byteMerger(bArrByteMerger5, a1.bitmapByZLib(0, 0, bitmapExtractRedContent, 128)) : Y.byteMerger(bArrByteMerger5, a1.bitmap(0, 0, 0, bitmapExtractRedContent, 128));
                        bitmapExtractBlackContent.recycle();
                        bitmapExtractRedContent.recycle();
                    } else {
                        bArrByteMerger = z7 ? Y.byteMerger(bArr, a1.bitmapByZLib(0, 0, bitmap, 128)) : Y.byteMerger(bArr, a1.bitmap(0, 0, 0, bitmap, 128));
                    }
                    byte[] bArrByteMerger6 = Y.byteMerger(bArrByteMerger3, Y.byteMerger(bArrByteMerger, a1.print(1)));
                    bitmap.recycle();
                    boolean zOnPageGenerated = streamPrintListener.onPageGenerated(i5, i7, bArrByteMerger6);
                    if (zOnPageGenerated && i5 + 1 < i7) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.a
                            @Override // java.lang.Runnable
                            public final void run() {
                                DataCreateUtil.lambda$processTSCPageByPage$6(p1, templatePageView, templateConfigBean, i6, z8, i7, z7, z6, i5, streamPrintListener, handler, looper);
                            }
                        });
                        return;
                    } else {
                        streamPrintListener.onComplete(zOnPageGenerated, i5 + 1);
                        looper.quit();
                        return;
                    }
                }
            } catch (Exception e) {
                streamPrintListener.onError(i5, e.getMessage());
                streamPrintListener.onComplete(false, i5);
                looper.quit();
                return;
            }
        }
        streamPrintListener.onError(i5, "生成Bitmap失败");
        streamPrintListener.onComplete(false, i5);
        looper.quit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$processTSCPageByPage$8(final Handler handler, final StreamPrintListener streamPrintListener, final int i5, final Looper looper, final TemplateConfigBean templateConfigBean, final int i6, final boolean z6, final boolean z7, final int i7, final P0 p1, final TemplatePageView templatePageView, final boolean z8, final Bitmap[] bitmapArr) {
        handler.post(new Runnable() { // from class: com.appdev.standard.page.printerlabel.util.b
            @Override // java.lang.Runnable
            public final void run() {
                boolean z9 = z8;
                Handler handler2 = handler;
                DataCreateUtil.lambda$processTSCPageByPage$7(bitmapArr, streamPrintListener, i5, looper, templateConfigBean, i6, z6, z7, i7, p1, templatePageView, z9, handler2);
            }
        });
    }

    private static void processESCPageByPage(final P0 p1, final TemplatePageView templatePageView, final TemplateConfigBean templateConfigBean, final int i5, final boolean z6, final int i6, final boolean z7, final int i7, final StreamPrintListener streamPrintListener, final Handler handler, final Looper looper) {
        if (i7 >= i6) {
            handler.post(new i(streamPrintListener, i6, looper, 0));
        } else {
            templatePageView.drawLabel2PrintBitmap(i5, z6, 1, i7, new TemplatePageView.DrawLabel2PrintBitmapEventListener() { // from class: com.appdev.standard.page.printerlabel.util.j
                @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.DrawLabel2PrintBitmapEventListener
                public final void onComplete(Bitmap[] bitmapArr) {
                    DataCreateUtil.lambda$processESCPageByPage$4(handler, streamPrintListener, i7, looper, templateConfigBean, z7, i6, p1, templatePageView, i5, z6, bitmapArr);
                }
            });
        }
    }

    private static void processTSCPageByPage(final P0 p1, final TemplatePageView templatePageView, final TemplateConfigBean templateConfigBean, final int i5, final boolean z6, final int i6, final boolean z7, final boolean z8, final int i7, final StreamPrintListener streamPrintListener, final Handler handler, final Looper looper) {
        if (i7 >= i6) {
            handler.post(new i(streamPrintListener, i6, looper, 1));
        } else {
            templatePageView.drawLabel2PrintBitmap(i5, z6, 1, i7, new TemplatePageView.DrawLabel2PrintBitmapEventListener() { // from class: com.appdev.standard.page.printerlabel.util.m
                @Override // com.appdev.standard.page.printerlabel.widget.TemplatePageView.DrawLabel2PrintBitmapEventListener
                public final void onComplete(Bitmap[] bitmapArr) {
                    DataCreateUtil.lambda$processTSCPageByPage$8(handler, streamPrintListener, i7, looper, templateConfigBean, i5, z8, z7, i6, p1, templatePageView, z6, bitmapArr);
                }
            });
        }
    }

    public static void getFontList(List<String> list, List<Object> list2) {
        for (Object obj : list2) {
            try {
                ElementAttributeBean elementAttributeBean = (ElementAttributeBean) p052j2.c.d(obj, ElementAttributeBean.class);
                if (elementAttributeBean.getElementType() == 5) {
                    ElementAttributeTextBean elementAttributeTextBean = (ElementAttributeTextBean) p052j2.c.d(obj, ElementAttributeTextBean.class);
                    if (Integer.parseInt(elementAttributeTextBean.getFontType()) > 0 && !list.contains(elementAttributeTextBean.getFontType())) {
                        list.add(elementAttributeTextBean.getFontType());
                    }
                } else if (elementAttributeBean.getElementType() == 7) {
                    ElementAttributeBarCodeBean elementAttributeBarCodeBean = (ElementAttributeBarCodeBean) p052j2.c.d(obj, ElementAttributeBarCodeBean.class);
                    if (Integer.parseInt(elementAttributeBarCodeBean.getFontType()) > 0 && !list.contains(elementAttributeBarCodeBean.getFontType())) {
                        list.add(elementAttributeBarCodeBean.getFontType());
                    }
                } else if (elementAttributeBean.getElementType() == 10) {
                    ElementAttributeTimeBean elementAttributeTimeBean = (ElementAttributeTimeBean) p052j2.c.d(obj, ElementAttributeTimeBean.class);
                    if (Integer.parseInt(elementAttributeTimeBean.getFontId()) > 0 && !list.contains(elementAttributeTimeBean.getFontId())) {
                        list.add(elementAttributeTimeBean.getFontId());
                    }
                } else if (elementAttributeBean.getElementType() == 9) {
                    Iterator<List> it = ((ElementAttributeTableBean) p052j2.c.d(obj, ElementAttributeTableBean.class)).getTableData().iterator();
                    while (it.hasNext()) {
                        Iterator it2 = it.next().iterator();
                        while (it2.hasNext()) {
                            ElementAttributeTableChildBean elementAttributeTableChildBean = (ElementAttributeTableChildBean) p052j2.c.d(it2.next(), ElementAttributeTableChildBean.class);
                            if (Integer.parseInt(elementAttributeTableChildBean.getFontId()) > 0 && !list.contains(elementAttributeTableChildBean.getFontId())) {
                                list.add(elementAttributeTableChildBean.getFontId());
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] create(P0 p1, TemplatePageView templatePageView, TemplateConfigBean templateConfigBean, int i5, float f6, int i6) {
        byte[] bArrByteMerger;
        int i7;
        int i8;
        byte[] bArrByteMerger2;
        byte[] bArrByteMerger3;
        int i9 = 0;
        byte[] bArrByteMerger4 = new byte[0];
        if (p1 != null) {
            boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
            int i10 = -1;
            int i11 = 1;
            if ("01".equals(p1.getCmdMode())) {
                List<PrintTaskModel> listDrawLabel2BitmapList = templatePageView.drawLabel2BitmapList(i5, templateConfigBean.getHeight(), templateConfigBean.getWidth(), i6);
                ArrayList arrayList = new ArrayList();
                for (PrintTaskModel printTaskModel : listDrawLabel2BitmapList) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (C1849c.mm2pxWithScale(printTaskModel.getLabelWidth()) / f6), (int) (C1849c.mm2pxWithScale(printTaskModel.getLabelHeight()) / f6), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    canvas.drawColor(-1);
                    for (PrintTaskElementModel printTaskElementModel : printTaskModel.getPrintTaskElementModels()) {
                        canvas.drawBitmap(convertWhiteToTransparent(printTaskElementModel.getBitmap()), printTaskElementModel.getLeftMargin(), printTaskElementModel.getTopMargin(), new Paint());
                    }
                    arrayList.add(bitmapCreateBitmap);
                    if (Math.max(templateConfigBean.getColumns(), 1) == 1) {
                        byte[] bArrByteMerger5 = Y.byteMerger(Y.byteMerger(bArrByteMerger4, G.start()), G.centerAligned());
                        if (zBooleanValue) {
                            bArrByteMerger2 = Y.byteMerger(bArrByteMerger5, G.rasterBmpToSendDataByZLib(bitmapCreateBitmap));
                        } else {
                            bArrByteMerger2 = Y.byteMerger(bArrByteMerger5, G.rasterBmpToSendData(bitmapCreateBitmap));
                        }
                        bArrByteMerger4 = Y.byteMerger(bArrByteMerger2, G.end());
                        arrayList.clear();
                    } else if (listDrawLabel2BitmapList.lastIndexOf(printTaskModel) == listDrawLabel2BitmapList.size() - 1 || arrayList.size() == Math.max(templateConfigBean.getColumns(), 1)) {
                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(((Math.max(templateConfigBean.getColumns(), 1) - 1) * C1849c.mm2px(templateConfigBean.getSpacing())) + (Math.max(templateConfigBean.getColumns(), 1) * ((int) (C1849c.mm2pxWithScale(printTaskModel.getLabelWidth()) / f6))), (int) (C1849c.mm2pxWithScale(printTaskModel.getLabelHeight()) / f6), Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                        canvas2.drawColor(-1);
                        byte[] bArrByteMerger6 = Y.byteMerger(Y.byteMerger(bArrByteMerger4, G.start()), G.centerAligned());
                        for (int i12 = 0; i12 < arrayList.size(); i12++) {
                            canvas2.drawBitmap((Bitmap) arrayList.get(i12), (C1849c.mm2px(templateConfigBean.getSpacing()) * i12) + (((Bitmap) arrayList.get(i12)).getWidth() * i12), 0.0f, new Paint());
                        }
                        if (zBooleanValue) {
                            bArrByteMerger3 = Y.byteMerger(bArrByteMerger6, G.rasterBmpToSendDataByZLib(bitmapCreateBitmap2));
                        } else {
                            bArrByteMerger3 = Y.byteMerger(bArrByteMerger6, G.rasterBmpToSendData(bitmapCreateBitmap2));
                        }
                        bArrByteMerger4 = Y.byteMerger(bArrByteMerger3, G.end());
                        arrayList.clear();
                    }
                }
                return bArrByteMerger4;
            }
            if ("02".equals(p1.getCmdMode())) {
                List<PrintTaskModel> listDrawLabel2BitmapList2 = templatePageView.drawLabel2BitmapList(i5, templateConfigBean.getHeight(), templateConfigBean.getWidth(), i6);
                byte[] bArrByteMerger7 = new byte[0];
                int iMax = Math.max(templateConfigBean.getColumns(), 1);
                if (i5 != 0 && i5 != 180) {
                    bArrByteMerger = Y.byteMerger(bArrByteMerger4, a1.sizeBymm((templateConfigBean.getHeight() * iMax) + (iMax > 1 ? (iMax - 1) * templateConfigBean.getSpacing() : 0), templateConfigBean.getWidth()));
                } else {
                    bArrByteMerger = Y.byteMerger(bArrByteMerger4, a1.sizeBymm((templateConfigBean.getWidth() * iMax) + (iMax > 1 ? (iMax - 1) * templateConfigBean.getSpacing() : 0), templateConfigBean.getHeight()));
                }
                byte[] bArrByteMerger8 = Y.byteMerger(Y.byteMerger(bArrByteMerger, a1.cls()), a1.direction(0));
                for (PrintTaskModel printTaskModel2 : listDrawLabel2BitmapList2) {
                    int iLastIndexOf = listDrawLabel2BitmapList2.lastIndexOf(printTaskModel2);
                    int iMax2 = iLastIndexOf % Math.max(templateConfigBean.getColumns(), i11);
                    if (iMax2 == 0) {
                        bArrByteMerger7 = new byte[i9];
                    }
                    if (printTaskModel2.getPrintTaskElementModels().size() > 0) {
                        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap((int) (C1849c.mm2pxWithScale(printTaskModel2.getLabelWidth()) / f6), (int) (C1849c.mm2pxWithScale(printTaskModel2.getLabelHeight()) / f6), Bitmap.Config.ARGB_8888);
                        Canvas canvas3 = new Canvas(bitmapCreateBitmap3);
                        canvas3.drawColor(i10);
                        for (PrintTaskElementModel printTaskElementModel2 : printTaskModel2.getPrintTaskElementModels()) {
                            canvas3.drawBitmap(convertWhiteToTransparent(printTaskElementModel2.getBitmap()), printTaskElementModel2.getLeftMargin(), printTaskElementModel2.getTopMargin(), new Paint());
                        }
                        if (zBooleanValue) {
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.bitmapByZLib(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + C1849c.mm2px(printTaskModel2.getLabelWidth() * iMax2), 0, bitmapCreateBitmap3, 128));
                        } else {
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.bitmap(C1849c.mm2px(templateConfigBean.getSpacing() * iMax2) + C1849c.mm2px(printTaskModel2.getLabelWidth() * iMax2), 0, 0, bitmapCreateBitmap3, 128));
                        }
                        i7 = -1;
                        i8 = 0;
                    } else {
                        Bitmap bitmapCreateBitmap4 = Bitmap.createBitmap((int) (C1849c.mm2pxWithScale(printTaskModel2.getLabelWidth()) / f6), (int) (C1849c.mm2pxWithScale(printTaskModel2.getLabelHeight()) / f6), Bitmap.Config.ARGB_8888);
                        i7 = -1;
                        new Canvas(bitmapCreateBitmap4).drawColor(-1);
                        if (zBooleanValue) {
                            i8 = 0;
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.bitmapByZLib(C1849c.mm2px(printTaskModel2.getLabelWidth() * iMax2), 0, bitmapCreateBitmap4, 128));
                        } else {
                            i8 = 0;
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.bitmap(C1849c.mm2px(printTaskModel2.getLabelWidth() * iMax2), 0, 0, bitmapCreateBitmap4, 128));
                        }
                    }
                    if (Math.max(templateConfigBean.getColumns(), 1) == 1) {
                        if (printTaskModel2.isSame()) {
                            return Y.byteMerger(bArrByteMerger8, Y.byteMerger(bArrByteMerger7, a1.print(printTaskModel2.getPrintCount())));
                        }
                        bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.print(1));
                        bArrByteMerger8 = Y.byteMerger(bArrByteMerger8, bArrByteMerger7);
                    } else if (printTaskModel2.isSame()) {
                        if (listDrawLabel2BitmapList2.size() % Math.max(templateConfigBean.getColumns(), 1) == 0 && iMax2 == Math.max(templateConfigBean.getColumns(), 1) - 1) {
                            return Y.byteMerger(bArrByteMerger8, Y.byteMerger(bArrByteMerger7, a1.print(listDrawLabel2BitmapList2.size() / Math.max(templateConfigBean.getColumns(), 1))));
                        }
                        int size = listDrawLabel2BitmapList2.size() / Math.max(templateConfigBean.getColumns(), 1);
                        if (iLastIndexOf == (Math.max(templateConfigBean.getColumns(), 1) * size) - 1) {
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.print(size));
                            bArrByteMerger8 = Y.byteMerger(bArrByteMerger8, bArrByteMerger7);
                        } else if (iLastIndexOf == listDrawLabel2BitmapList2.size() - 1) {
                            bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.print(1));
                            bArrByteMerger8 = Y.byteMerger(bArrByteMerger8, bArrByteMerger7);
                        }
                    } else if (iLastIndexOf == listDrawLabel2BitmapList2.size() - 1 || (iLastIndexOf != 0 && iMax2 == Math.max(templateConfigBean.getColumns(), 1) - 1)) {
                        bArrByteMerger7 = Y.byteMerger(bArrByteMerger7, a1.print(1));
                        bArrByteMerger8 = Y.byteMerger(bArrByteMerger8, bArrByteMerger7);
                    }
                    int i13 = i7;
                    i11 = 1;
                    i10 = i13;
                    i9 = i8;
                }
                return bArrByteMerger8;
            }
        }
        return bArrByteMerger4;
    }
}
