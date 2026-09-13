package com.appdev.standard.page.receipt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import p042h2.d;
import p050j.w;
import p051j0.a;
import p051j0.f;
import p052j2.c;
import p056k0.q;
import p113u.e;
import p113u.g;
import p119v.j;
import p134x2.C1849c;
import p134x2.G;
import p134x2.K0;
import p134x2.P0;
import p134x2.Y;
import p134x2.a1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_RECEIPT_PRINT_PAGE)
public class ReceiptPrintPageActivity extends MvpActivity {

    @Autowired(name = "ReceiptPrintPageActivityData")
    String dataStr;
    private int printCount = 1;
    private P0 printInfo;

    @BindView(5736)
    QuantitySelectorWidget qswReceiptPrintPagePrintCount;
    private j quickAdapter;

    @Autowired(name = "ReceiptPrintPageActivityReceiptWidth")
    int receiptWidth;

    @BindView(5850)
    RecyclerView rvReceiptEditData;

    @BindView(6274)
    TextView tvTitle;

    /* JADX INFO: renamed from: com.appdev.standard.page.receipt.ReceiptPrintPageActivity$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ OnSendListener val$sendListener;

        public AnonymousClass3(OnSendListener onSendListener) {
            this.val$sendListener = onSendListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArrByteMerger = new byte[0];
            boolean zBooleanValue = ((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue();
            for (final int i5 = 0; i5 < ReceiptPrintPageActivity.this.printCount; i5++) {
                final Bitmap[] bitmapArr = new Bitmap[1];
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                ReceiptPrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ReceiptPrintPageActivity.this.rvReceiptEditData.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.3.1.1
                            @Override // android.view.View.OnLayoutChangeListener
                            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                                if (ReceiptPrintPageActivity.this.rvReceiptEditData.getAdapter() == null || ReceiptPrintPageActivity.this.rvReceiptEditData.getChildCount() <= 0) {
                                    return;
                                }
                                a.d(((BaseActivity) ReceiptPrintPageActivity.this).TAG, "rvReceiptEditData 渲染完毕");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                bitmapArr[0] = ReceiptPrintPageActivity.this.getReceiptBitmap();
                                countDownLatch.countDown();
                                ReceiptPrintPageActivity.this.rvReceiptEditData.removeOnLayoutChangeListener(this);
                            }
                        });
                        ReceiptPrintPageActivity.this.quickAdapter.f8758g = i5;
                        ReceiptPrintPageActivity.this.quickAdapter.notifyDataSetChanged();
                    }
                });
                try {
                    countDownLatch.await();
                    Bitmap bitmap = bitmapArr[0];
                    if (bitmap == null) {
                        this.val$sendListener.onFailed();
                        return;
                    } else {
                        byte[] bArrByteMerger2 = Y.byteMerger(Y.byteMerger(bArrByteMerger, G.start()), G.centerAligned());
                        bArrByteMerger = Y.byteMerger(zBooleanValue ? Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendDataByZLib(bitmap)) : Y.byteMerger(bArrByteMerger2, G.rasterBmpToSendData(bitmap)), G.end());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            K0 printer = f.getPrinter();
            if (printer == null) {
                this.val$sendListener.onFailed();
            } else if (printer.sendSync(bArrByteMerger, null).b()) {
                this.val$sendListener.onComplete(null);
            } else {
                this.val$sendListener.onFailed();
            }
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.receipt.ReceiptPrintPageActivity$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ OnSendListener val$sendListener;

        public AnonymousClass4(OnSendListener onSendListener) {
            this.val$sendListener = onSendListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zIsReceiptSame = DataCreateUtil.isReceiptSame(ReceiptPrintPageActivity.this.quickAdapter.getData());
            byte[] bArrByteMerger = new byte[0];
            for (final int i5 = 0; i5 < ReceiptPrintPageActivity.this.printCount; i5++) {
                final Bitmap[] bitmapArr = new Bitmap[1];
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                ReceiptPrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ReceiptPrintPageActivity.this.rvReceiptEditData.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.4.1.1
                            @Override // android.view.View.OnLayoutChangeListener
                            public void onLayoutChange(View view, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
                                if (ReceiptPrintPageActivity.this.rvReceiptEditData.getAdapter() == null || ReceiptPrintPageActivity.this.rvReceiptEditData.getChildCount() <= 0) {
                                    return;
                                }
                                a.d(((BaseActivity) ReceiptPrintPageActivity.this).TAG, "rvReceiptEditData 渲染完毕");
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                bitmapArr[0] = ReceiptPrintPageActivity.this.getReceiptBitmap();
                                countDownLatch.countDown();
                                ReceiptPrintPageActivity.this.rvReceiptEditData.removeOnLayoutChangeListener(this);
                            }
                        });
                        ReceiptPrintPageActivity.this.quickAdapter.f8758g = i5;
                        ReceiptPrintPageActivity.this.quickAdapter.notifyDataSetChanged();
                    }
                });
                try {
                    countDownLatch.await();
                    if (zIsReceiptSame) {
                        Bitmap bitmap = bitmapArr[0];
                        if (bitmap == null) {
                            this.val$sendListener.onFailed();
                            return;
                        } else {
                            byte[] bArrByteMerger2 = Y.byteMerger(Y.byteMerger(Y.byteMerger(bArrByteMerger, a1.sizeBymm((int) C1849c.px2mm(bitmap.getWidth()), (int) C1849c.px2mm(bitmap.getHeight()))), a1.cls()), a1.direction(0));
                            bArrByteMerger = Y.byteMerger(((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue() ? Y.byteMerger(bArrByteMerger2, a1.bitmapByZLib(0, 0, bitmap, 128)) : Y.byteMerger(bArrByteMerger2, a1.bitmap(0, 0, 0, bitmap, 128)), a1.print(ReceiptPrintPageActivity.this.printCount));
                            break;
                        }
                    }
                    Bitmap bitmap2 = bitmapArr[0];
                    if (bitmap2 == null) {
                        this.val$sendListener.onFailed();
                        return;
                    } else {
                        byte[] bArrByteMerger3 = Y.byteMerger(Y.byteMerger(Y.byteMerger(bArrByteMerger, a1.sizeBymm((int) C1849c.px2mm(bitmap2.getWidth()), (int) C1849c.px2mm(bitmap2.getHeight()))), a1.cls()), a1.direction(0));
                        bArrByteMerger = Y.byteMerger(((Boolean) Hawk.get("isUseZip", Boolean.FALSE)).booleanValue() ? Y.byteMerger(bArrByteMerger3, a1.bitmapByZLib(0, 0, bitmap2, 128)) : Y.byteMerger(bArrByteMerger3, a1.bitmap(0, 0, 0, bitmap2, 128)), a1.print(1));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            K0 printer = f.getPrinter();
            if (printer == null) {
                this.val$sendListener.onFailed();
            } else if (printer.sendSync(bArrByteMerger, null).b()) {
                this.val$sendListener.onComplete(null);
            } else {
                this.val$sendListener.onFailed();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnSendListener {
        void onComplete(byte[] bArr);

        void onFailed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getReceiptBitmap() {
        int itemCount = ((LinearLayoutManager) this.rvReceiptEditData.getLayoutManager()).getItemCount() - 1;
        int width = this.rvReceiptEditData.getWidth();
        int height = 20;
        for (int i5 = 0; i5 <= itemCount; i5++) {
            height += this.rvReceiptEditData.getChildAt(i5).getHeight();
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(getResources().getColor(p113u.a.color_FFFFFF));
        for (int i6 = 0; i6 <= itemCount; i6++) {
            View childAt = this.rvReceiptEditData.getChildAt(i6);
            int left = childAt.getLeft();
            int top = childAt.getTop();
            canvas.save();
            canvas.translate(left, top);
            childAt.draw(canvas);
            canvas.restore();
        }
        try {
            return new q().scaleBitmapByEqualRatio(bitmapCreateBitmap, C1849c.text_print_mm2px(this.receiptWidth));
        } catch (Exception unused) {
            d.show(g.toast_receipt_generate_failed);
            return null;
        }
    }

    private void receiptPrintPagePrintWithESC(OnSendListener onSendListener) {
        w.e();
        runOnNewThread(new AnonymousClass3(onSendListener));
    }

    private void receiptPrintPagePrintWithTSC(OnSendListener onSendListener) {
        w.e();
        runOnNewThread(new AnonymousClass4(onSendListener));
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(g.text_241));
        List<Object> listA = c.a(ReceiptElementModel.class, this.dataStr);
        if (listA.size() <= 0) {
            d.show(g.toast_28);
            finishActivity();
            return;
        }
        j jVar = new j(this, e.item_receipt_edit_element);
        jVar.f8756a = null;
        jVar.b = new HashSet();
        jVar.c = false;
        jVar.d = 0;
        jVar.e = 0;
        jVar.f8758g = 0;
        jVar.f8757f = false;
        jVar.f8756a = new HashMap();
        this.quickAdapter = jVar;
        this.rvReceiptEditData.setLayoutManager(new LinearLayoutManager(this));
        this.rvReceiptEditData.setAdapter(this.quickAdapter);
        this.quickAdapter.replaceAll(listA);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        P0 p0H = a.h();
        this.printInfo = p0H;
        if (p0H == null && f.getPrinter() != null && f.getPrinter().b()) {
            w.f(getResources().getString(g.toast_44));
            runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    ReceiptPrintPageActivity.this.printInfo = f.read_print_info();
                    ReceiptPrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                w.c();
                            } catch (NumberFormatException e) {
                                w.c();
                                d.show(g.toast_1);
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.qswReceiptPrintPagePrintCount.setOnValueChangeListener(new QuantitySelectorWidget.OnValueChangeListener() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.2
            @Override // com.appdev.standard.page.printerlabel.widget.QuantitySelectorWidget.OnValueChangeListener
            public void onValue(int i5) {
                ReceiptPrintPageActivity.this.printCount = i5;
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return e.activity_receipt_print_page;
    }

    public void onReceiptPrintPagePrintClick(View view) {
        P0 p0H = a.h();
        if (p0H == null) {
            d.show(g.toast_67);
            return;
        }
        OnSendListener onSendListener = new OnSendListener() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.5
            @Override // com.appdev.standard.page.receipt.ReceiptPrintPageActivity.OnSendListener
            public void onComplete(byte[] bArr) {
                ReceiptPrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.show(g.toast_2);
                        w.c();
                    }
                });
            }

            @Override // com.appdev.standard.page.receipt.ReceiptPrintPageActivity.OnSendListener
            public void onFailed() {
                ReceiptPrintPageActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptPrintPageActivity.5.2
                    @Override // java.lang.Runnable
                    public void run() {
                        w.c();
                    }
                });
            }
        };
        if ("01".equals(p0H.getCmdMode())) {
            receiptPrintPagePrintWithESC(onSendListener);
        } else if ("02".equals(p0H.getCmdMode())) {
            receiptPrintPagePrintWithTSC(onSendListener);
        }
    }
}
