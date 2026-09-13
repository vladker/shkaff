package com.appdev.standard.page.receipt;

import U.b;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.ReceiptApi;
import com.appdev.standard.dialog.C;
import com.appdev.standard.dialog.DefaultEdittextDialog;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.DialogC0464q;
import com.appdev.standard.dialog.InterfaceC0455h;
import com.appdev.standard.dialog.SaveTipsDialog;
import com.appdev.standard.model.ReceiptBarcodeDataModel;
import com.appdev.standard.model.ReceiptDateDataModel;
import com.appdev.standard.model.ReceiptElementModel;
import com.appdev.standard.model.ReceiptLineDataModel;
import com.appdev.standard.model.ReceiptModel;
import com.appdev.standard.model.ReceiptPictureDataModel;
import com.appdev.standard.model.ReceiptQrCodeDataModel;
import com.appdev.standard.model.ReceiptTableChildDataModel;
import com.appdev.standard.model.ReceiptTableDataModel;
import com.appdev.standard.model.ReceiptTextDataModel;
import com.appdev.standard.page.receipt.operate.ReceiptBarcodeOperate;
import com.appdev.standard.page.receipt.operate.ReceiptDateOperate;
import com.appdev.standard.page.receipt.operate.ReceiptLineOperate;
import com.appdev.standard.page.receipt.operate.ReceiptPictureOperate;
import com.appdev.standard.page.receipt.operate.ReceiptQrcodeOperate;
import com.appdev.standard.page.receipt.operate.ReceiptTableOperate;
import com.appdev.standard.page.receipt.operate.ReceiptTextOperate;
import com.appdev.standard.util.fileDownload.h;
import com.bumptech.glide.f;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Y;
import okhttp3.B;
import okhttp3.D;
import okhttp3.Q;
import org.opencv.videoio.Videoio;
import p014c0.a;
import p014c0.d;
import p014c0.e;
import p025e0.i;
import p025e0.k;
import p050j.w;
import p052j2.c;
import p056k0.q;
import p113u.g;
import p119v.j;
import p134x2.C1849c;
import p134x2.K0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_RECEIPT_EDIT)
public class ReceiptEditActivity extends MvpActivity implements a, U.a, i {
    private Context context;
    private h downloadCenterListener;
    private DialogC0464q fontDownloadProgressDialog;

    @BindView(5209)
    ImageView ivDelete;

    @BindView(5483)
    LinearLayout llReceiptEdit;

    @BindView(5642)
    NestedScrollView nsvReceiptEdit;
    private j quickAdapter;
    private String receiptId;
    private ReceiptModel receiptModel;
    private ReceiptTextOperate receiptTextOperate;
    private String receiptTitle;

    @BindView(5850)
    RecyclerView rvReceiptEditData;

    @BindView(6274)
    TextView tvTitle;
    private k userInfoWorker;
    private e uploadImageWorker = null;
    private b addOrEditReceiptWorker = null;
    private p056k0.i mediaPicker = new p056k0.i();
    private boolean haveChange = false;
    private int receiptWidth = 58;
    private float scaleValue = 1.0f;
    private int selectPosition = -1;
    private float baseX = 0.0f;
    private float baseY = 0.0f;
    private final int REQUEST_EDIT_RECEIPT = 1;

    /* JADX INFO: renamed from: com.appdev.standard.page.receipt.ReceiptEditActivity$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass7 implements Runnable {
        public AnonymousClass7() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ReceiptEditActivity.this.selectPosition = -1;
            Iterator<Object> it = ReceiptEditActivity.this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                ((ReceiptElementModel) it.next()).setSelectState(false);
            }
            ReceiptEditActivity.this.haveChange = false;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            ReceiptEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.7.1
                @Override // java.lang.Runnable
                public void run() {
                    ReceiptEditActivity.this.rvReceiptEditData.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.7.1.1
                        @Override // android.view.View.OnLayoutChangeListener
                        public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                            if (ReceiptEditActivity.this.rvReceiptEditData.getAdapter() == null || ReceiptEditActivity.this.rvReceiptEditData.getChildCount() <= 0) {
                                return;
                            }
                            p051j0.a.d(((BaseActivity) ReceiptEditActivity.this).TAG, "rvReceiptEditData 渲染完毕");
                            countDownLatch.countDown();
                            ReceiptEditActivity.this.rvReceiptEditData.removeOnLayoutChangeListener(this);
                        }
                    });
                    ReceiptEditActivity.this.quickAdapter.f8758g = 0;
                    ReceiptEditActivity.this.quickAdapter.notifyDataSetChanged();
                }
            });
            try {
                countDownLatch.await();
                Bitmap receiptBitmap = ReceiptEditActivity.this.getReceiptBitmap();
                if (receiptBitmap == null) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                receiptBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                D dCreateFormData = D.createFormData(Constants.FILE, "image.jpg", Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), byteArrayOutputStream.toByteArray()));
                e eVar = ReceiptEditActivity.this.uploadImageWorker;
                eVar.d.uploadImage(dCreateFormData).b(new d(eVar, "coverImg"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void changeLabelWidth() {
        try {
            w.e();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f6 = displayMetrics.widthPixels;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rvReceiptEditData.getLayoutParams();
            this.scaleValue = ((f6 - layoutParams.leftMargin) - layoutParams.rightMargin) / C1849c.mm2px(this.receiptWidth);
            System.out.println("scaleValue:   " + this.scaleValue);
            C1849c.setScale(this.scaleValue);
            ArrayList arrayList = new ArrayList();
            Iterator<Object> it = this.quickAdapter.getData().iterator();
            while (it.hasNext()) {
                ReceiptElementModel receiptElementModel = (ReceiptElementModel) it.next();
                int itemType = receiptElementModel.getItemType();
                if (itemType == 1) {
                    ReceiptLineDataModel receiptLineDataModel = (ReceiptLineDataModel) c.d(receiptElementModel.getData(), ReceiptLineDataModel.class);
                    receiptLineDataModel.setW(this.receiptWidth - 10);
                    receiptElementModel.setData(c.e(receiptLineDataModel));
                } else if (itemType != 11) {
                    switch (itemType) {
                        case 5:
                            ReceiptTextDataModel receiptTextDataModel = (ReceiptTextDataModel) c.d(receiptElementModel.getData(), ReceiptTextDataModel.class);
                            receiptTextDataModel.setW(this.receiptWidth - 10);
                            receiptElementModel.setData(c.e(receiptTextDataModel));
                            break;
                        case 6:
                            ReceiptPictureDataModel receiptPictureDataModel = (ReceiptPictureDataModel) c.d(receiptElementModel.getData(), ReceiptPictureDataModel.class);
                            receiptPictureDataModel.setW((float) (((double) this.receiptWidth) * 0.4d));
                            receiptPictureDataModel.setH((float) (((double) this.receiptWidth) * 0.4d));
                            receiptElementModel.setData(c.e(receiptPictureDataModel));
                            break;
                        case 7:
                            ReceiptBarcodeDataModel receiptBarcodeDataModel = (ReceiptBarcodeDataModel) c.d(receiptElementModel.getData(), ReceiptBarcodeDataModel.class);
                            receiptBarcodeDataModel.setW((float) (((double) this.receiptWidth) * 0.5d));
                            receiptBarcodeDataModel.setH((float) (((double) this.receiptWidth) * 0.25d));
                            receiptElementModel.setData(c.e(receiptBarcodeDataModel));
                            break;
                        case 8:
                            ReceiptQrCodeDataModel receiptQrCodeDataModel = (ReceiptQrCodeDataModel) c.d(receiptElementModel.getData(), ReceiptQrCodeDataModel.class);
                            receiptQrCodeDataModel.setW((float) (((double) this.receiptWidth) * 0.4d));
                            receiptQrCodeDataModel.setH((float) (((double) this.receiptWidth) * 0.4d));
                            receiptElementModel.setData(c.e(receiptQrCodeDataModel));
                            break;
                        case 9:
                            ReceiptTableDataModel receiptTableDataModel = (ReceiptTableDataModel) c.d(receiptElementModel.getData(), ReceiptTableDataModel.class);
                            List<List> listB = c.b(receiptTableDataModel.getTableData(), List.class);
                            for (int i5 = 0; i5 < listB.size(); i5++) {
                                List listB2 = c.b(listB.get(i5), ReceiptTableChildDataModel.class);
                                for (int i6 = 0; i6 < listB2.size(); i6++) {
                                    ((ReceiptTableChildDataModel) listB2.get(i6)).setColumnsWidth((this.receiptWidth - 10) / listB2.size());
                                }
                                listB.set(i5, listB2);
                            }
                            receiptTableDataModel.setTableData(listB);
                            receiptElementModel.setData(c.e(receiptTableDataModel));
                            break;
                    }
                } else {
                    ReceiptDateDataModel receiptDateDataModel = (ReceiptDateDataModel) c.d(receiptElementModel.getData(), ReceiptDateDataModel.class);
                    receiptDateDataModel.setW(this.receiptWidth - 10);
                    receiptElementModel.setData(c.e(receiptDateDataModel));
                }
                arrayList.add(receiptElementModel);
            }
            this.quickAdapter.replaceAll(arrayList);
            w.c();
        } catch (Throwable th) {
            throw th;
        }
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
            p042h2.d.show(g.toast_receipt_generate_failed);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onReceiptEditMaterialAddClick$0(Uri uri) {
        String strC;
        Q qCreate;
        if (uri == null) {
            return;
        }
        w.e();
        e eVar = this.uploadImageWorker;
        String string = uri.toString();
        Context context = eVar.c;
        if (Y.f(string)) {
            Object obj = eVar.b;
            if (obj != null) {
                ((a) obj).uploadImageFailed(1, eVar.getString(g.The_image_path_cannot_be_empty));
                return;
            }
            return;
        }
        if (string.startsWith("content://")) {
            try {
                Uri uri2 = Uri.parse(string);
                byte[] bArrK = p051j0.i.k(context, uri2);
                strC = p051j0.i.c(context, uri2);
                qCreate = Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), bArrK);
            } catch (Exception unused) {
                Object obj2 = eVar.b;
                if (obj2 != null) {
                    ((a) obj2).uploadImageFailed(2, eVar.getString(g.Failed_to_upload_picture_please_try_again));
                    return;
                }
                return;
            }
        } else {
            File file = new File(string);
            Q qCreate2 = Q.create(B.parse(ShareTarget.ENCODING_TYPE_MULTIPART), file);
            String name = file.getName();
            qCreate = qCreate2;
            strC = name;
        }
        eVar.d.uploadImage(D.createFormData(Constants.FILE, strC, qCreate)).b(new p014c0.c(eVar));
    }

    private void saveDialog() {
        SaveTipsDialog saveTipsDialog = new SaveTipsDialog(this);
        saveTipsDialog.a(getString(g.text_262));
        saveTipsDialog.f2627a = new C() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.9
            @Override // com.appdev.standard.dialog.C
            public void onExit() {
                ReceiptEditActivity.this.finish();
            }

            @Override // com.appdev.standard.dialog.C
            public void onSave() {
                if (ReceiptEditActivity.this.quickAdapter.getItemCount() == 0) {
                    p042h2.d.show(g.toast_64);
                    return;
                }
                S4.h hVar = p042h2.e.f4031a;
                p032f2.a aVarE = hVar.e();
                if (hVar.g() && !hVar.h()) {
                    DefaultTipDialog defaultTipDialog = new DefaultTipDialog(ReceiptEditActivity.this.context);
                    defaultTipDialog.e("");
                    defaultTipDialog.c(ReceiptEditActivity.this.getString(g.text_250));
                    defaultTipDialog.a(ReceiptEditActivity.this.getString(g.text_254));
                    defaultTipDialog.b(ReceiptEditActivity.this.getString(g.text_255));
                    defaultTipDialog.f2608a = new f() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.9.1
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
                    ReceiptEditActivity.this.showSaveNameDialog();
                    return;
                }
                DefaultTipDialog defaultTipDialog2 = new DefaultTipDialog(ReceiptEditActivity.this.context);
                defaultTipDialog2.e("");
                defaultTipDialog2.c(ReceiptEditActivity.this.getString(g.text_473));
                defaultTipDialog2.a(ReceiptEditActivity.this.getString(g.cancel));
                defaultTipDialog2.b(ReceiptEditActivity.this.getString(g.text_256));
                defaultTipDialog2.f2608a = new f() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.9.2
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
        };
        saveTipsDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveReceipt() {
        w.e();
        runOnNewThread(new AnonymousClass7());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSaveNameDialog() {
        DefaultEdittextDialog defaultEdittextDialog = new DefaultEdittextDialog(this);
        defaultEdittextDialog.e(getString(g.text_242));
        defaultEdittextDialog.c(this.receiptTitle);
        defaultEdittextDialog.f2607a = new InterfaceC0455h() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.8
            @Override // com.appdev.standard.dialog.InterfaceC0455h
            public void onConfirm(String str) {
                if (!Y.f(str)) {
                    ReceiptEditActivity.this.receiptTitle = str;
                }
                ReceiptEditActivity.this.saveReceipt();
            }

            @Override // com.appdev.standard.dialog.InterfaceC0455h
            public void onCancel() {
            }
        };
        defaultEdittextDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateQuickAdapterUi(int i5) {
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        while (it.hasNext()) {
            ReceiptElementModel receiptElementModel = (ReceiptElementModel) it.next();
            if (receiptElementModel.isSelectState()) {
                receiptElementModel.setSelectState(false);
            }
        }
        this.quickAdapter.notifyDataSetChanged();
        if (i5 == -1) {
            this.ivDelete.setImageResource(p113u.f.ic_template_edit_delete_false);
        } else if (i5 < this.quickAdapter.getItemCount()) {
            this.ivDelete.setImageResource(p113u.f.ic_common_delete);
            ((ReceiptElementModel) this.quickAdapter.getItem(i5)).setSelectState(true);
            this.quickAdapter.notifyItemChanged(i5);
        }
    }

    @Override // U.a
    public void addOrEditReceiptFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // U.a
    public void addOrEditReceiptSuccess() {
        w.c();
        p042h2.d.show(g.toast_66);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mediaPicker.attachToActivity(this);
        this.tvTitle.setText(getString(g.text_241));
        this.context = this;
        e eVar = new e(this);
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
        b bVar = new b(this);
        bVar.d = (ReceiptApi) Http.createApi(ReceiptApi.class);
        this.addOrEditReceiptWorker = bVar;
        addPresenter(bVar);
        k kVar = new k(this);
        this.userInfoWorker = kVar;
        addPresenter(kVar);
        Hawk.delete("ReceiptEditActivityBitmap");
        this.userInfoWorker.a();
        this.downloadCenterListener = new h() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.1
            @Override // com.appdev.standard.util.fileDownload.h
            public void onDeleted(String str) {
                super.onDeleted(str);
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onError(String str, Throwable th) {
                ReceiptEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ReceiptEditActivity.this.fontDownloadProgressDialog.dismiss();
                        p042h2.d.show(g.toast_52);
                    }
                });
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onProgress(String str, long j6, long j7, boolean z6) {
                super.onProgress(str, j6, j7, z6);
                int i5 = (int) ((j6 / j7) * 100.0f);
                p051j0.a.d(((BaseActivity) ReceiptEditActivity.this).TAG, "progress: " + i5);
                ReceiptEditActivity.this.fontDownloadProgressDialog.a(i5);
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onStart(com.appdev.standard.util.fileDownload.a aVar) {
                super.onStart(aVar);
                ReceiptEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ReceiptEditActivity.this.fontDownloadProgressDialog = new DialogC0464q(ReceiptEditActivity.this);
                        ProgressBar progressBar = ReceiptEditActivity.this.fontDownloadProgressDialog.f2653a;
                        if (progressBar != null) {
                            progressBar.setMax(100);
                        }
                        ReceiptEditActivity.this.fontDownloadProgressDialog.a(0);
                        ReceiptEditActivity.this.fontDownloadProgressDialog.show();
                    }
                });
            }

            @Override // com.appdev.standard.util.fileDownload.h
            public void onSuccess(String str) {
                ReceiptEditActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ReceiptEditActivity.this.fontDownloadProgressDialog.dismiss();
                        p042h2.d.show(g.toast_51);
                    }
                });
            }
        };
        com.appdev.standard.util.fileDownload.g gVarB = com.appdev.standard.util.fileDownload.g.b();
        gVarB.b.add(this.downloadCenterListener);
        j jVar = new j(this, p113u.e.item_receipt_edit_element);
        jVar.f8756a = null;
        jVar.b = new HashSet();
        jVar.c = false;
        jVar.d = 0;
        jVar.e = 0;
        jVar.f8757f = true;
        jVar.f8758g = 0;
        jVar.f8756a = new HashMap();
        this.quickAdapter = jVar;
        this.rvReceiptEditData.setLayoutManager(new LinearLayoutManager(this));
        this.rvReceiptEditData.setAdapter(this.quickAdapter);
        new ItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.2
            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
                ReceiptEditActivity.this.haveChange = true;
                int adapterPosition = viewHolder.getAdapterPosition();
                int adapterPosition2 = viewHolder2.getAdapterPosition();
                if (adapterPosition < adapterPosition2) {
                    int i5 = adapterPosition;
                    while (i5 < adapterPosition2) {
                        int i6 = i5 + 1;
                        Collections.swap(ReceiptEditActivity.this.quickAdapter.getData(), i5, i6);
                        i5 = i6;
                    }
                } else {
                    for (int i7 = adapterPosition; i7 > adapterPosition2; i7--) {
                        Collections.swap(ReceiptEditActivity.this.quickAdapter.getData(), i7, i7 - 1);
                    }
                }
                ReceiptEditActivity.this.quickAdapter.notifyItemMoved(adapterPosition, adapterPosition2);
                return true;
            }

            @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i5) {
            }
        }).attachToRecyclerView(this.rvReceiptEditData);
        this.quickAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.3
            private int lastItemCount = -1;

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                int i5 = this.lastItemCount;
                if (i5 == -1) {
                    this.lastItemCount = ReceiptEditActivity.this.quickAdapter.getItemCount();
                    return;
                }
                if (i5 < ReceiptEditActivity.this.quickAdapter.getItemCount()) {
                    ReceiptEditActivity.this.nsvReceiptEdit.postDelayed(new Runnable() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ReceiptEditActivity.this.nsvReceiptEdit.fullScroll(130);
                        }
                    }, 500L);
                }
                this.lastItemCount = ReceiptEditActivity.this.quickAdapter.getItemCount();
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        ReceiptModel receiptModel = this.receiptModel;
        if (receiptModel != null) {
            this.quickAdapter.replaceAll(c.a(ReceiptElementModel.class, receiptModel.getContent()));
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.4
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                ReceiptElementModel receiptElementModel = (ReceiptElementModel) ReceiptEditActivity.this.quickAdapter.getItem(i5);
                if (ReceiptEditActivity.this.selectPosition != i5) {
                    ReceiptEditActivity.this.selectPosition = i5;
                    ReceiptEditActivity.this.updateQuickAdapterUi(i5);
                    return;
                }
                ReceiptEditActivity.this.haveChange = true;
                int itemType = receiptElementModel.getItemType();
                if (itemType == 1) {
                    new ReceiptLineOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter).show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                    return;
                }
                if (itemType == 11) {
                    new ReceiptDateOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter).show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                    return;
                }
                switch (itemType) {
                    case 5:
                        ReceiptEditActivity receiptEditActivity = ReceiptEditActivity.this;
                        receiptEditActivity.receiptTextOperate = new ReceiptTextOperate(receiptEditActivity.context, ReceiptEditActivity.this.quickAdapter);
                        ReceiptEditActivity.this.receiptTextOperate.show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                        break;
                    case 6:
                        new ReceiptPictureOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter).show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                        break;
                    case 7:
                        new ReceiptBarcodeOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter).show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                        break;
                    case 8:
                        new ReceiptQrcodeOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter).show(receiptElementModel, ReceiptEditActivity.this.llReceiptEdit);
                        break;
                    case 9:
                        ReceiptTableOperate receiptTableOperate = new ReceiptTableOperate(ReceiptEditActivity.this.context, ReceiptEditActivity.this.quickAdapter);
                        ReceiptEditActivity receiptEditActivity2 = ReceiptEditActivity.this;
                        receiptTableOperate.show(receiptElementModel, receiptEditActivity2.llReceiptEdit, receiptEditActivity2.quickAdapter.d, ReceiptEditActivity.this.quickAdapter.e, ReceiptEditActivity.this.receiptWidth);
                        break;
                    default:
                        ReceiptEditActivity.this.haveChange = false;
                        break;
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        this.nsvReceiptEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                int action = motionEvent.getAction();
                if (action == 0) {
                    ReceiptEditActivity.this.baseX = motionEvent.getRawX();
                    ReceiptEditActivity.this.baseY = motionEvent.getRawY();
                    return false;
                }
                if (action != 1 || Math.abs(motionEvent.getRawX() - ReceiptEditActivity.this.baseX) >= 5.0f || Math.abs(motionEvent.getRawY() - ReceiptEditActivity.this.baseY) >= 5.0f) {
                    return false;
                }
                ReceiptEditActivity.this.selectPosition = -1;
                ReceiptEditActivity.this.updateQuickAdapterUi(-1);
                return false;
            }
        });
        this.rvReceiptEditData.setOnTouchListener(new View.OnTouchListener() { // from class: com.appdev.standard.page.receipt.ReceiptEditActivity.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                int action = motionEvent.getAction();
                if (action == 0) {
                    ReceiptEditActivity.this.baseX = motionEvent.getRawX();
                    ReceiptEditActivity.this.baseY = motionEvent.getRawY();
                    return false;
                }
                if (action != 1 || Math.abs(motionEvent.getRawX() - ReceiptEditActivity.this.baseX) >= 5.0f || Math.abs(motionEvent.getRawY() - ReceiptEditActivity.this.baseY) >= 5.0f) {
                    return false;
                }
                ReceiptEditActivity.this.selectPosition = -1;
                ReceiptEditActivity.this.updateQuickAdapterUi(-1);
                return false;
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_receipt_edit;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1 && i6 == -1) {
            String stringExtra = intent.getStringExtra("receiptWidth");
            p051j0.a.k(this.TAG, "receiptWidth=" + stringExtra);
            this.receiptWidth = Integer.valueOf(stringExtra).intValue();
            changeLabelWidth();
        }
        ReceiptTextOperate receiptTextOperate = this.receiptTextOperate;
        if (receiptTextOperate != null) {
            receiptTextOperate.handleActivityResult(i5, i6, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.haveChange) {
            saveDialog();
        } else {
            finish();
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

    public void onReceiptEditBarcodeAddClick(View view) {
        this.haveChange = true;
        ReceiptBarcodeDataModel receiptBarcodeDataModel = new ReceiptBarcodeDataModel();
        receiptBarcodeDataModel.setW((float) (((double) this.receiptWidth) * 0.5d));
        receiptBarcodeDataModel.setH((float) (((double) this.receiptWidth) * 0.25d));
        receiptBarcodeDataModel.setContent("12345678");
        receiptBarcodeDataModel.setEncodeRef("CODE_128");
        this.quickAdapter.add(new ReceiptElementModel(7, c.e(receiptBarcodeDataModel)));
    }

    public void onReceiptEditDateAddClick(View view) {
        this.haveChange = true;
        ReceiptDateDataModel receiptDateDataModel = new ReceiptDateDataModel();
        receiptDateDataModel.setW(this.receiptWidth - 10);
        receiptDateDataModel.setContent(String.valueOf(System.currentTimeMillis()));
        receiptDateDataModel.setFontSize(30);
        receiptDateDataModel.setDateFormat("yyyy-MM-dd");
        receiptDateDataModel.setTimeFormat(p051j0.i.f5400a);
        receiptDateDataModel.setAligment(1);
        this.quickAdapter.add(new ReceiptElementModel(11, c.e(receiptDateDataModel)));
    }

    public void onReceiptEditDeleteClick(View view) {
        int i5 = this.selectPosition;
        if (i5 == -1) {
            p042h2.d.show(g.toast_65);
            return;
        }
        this.haveChange = true;
        if (i5 < this.quickAdapter.getItemCount()) {
            this.quickAdapter.remove(this.selectPosition);
        }
        this.ivDelete.setImageResource(p113u.f.ic_template_edit_delete_false);
        this.selectPosition = -1;
    }

    public void onReceiptEditLineAddClick(View view) {
        this.haveChange = true;
        ReceiptLineDataModel receiptLineDataModel = new ReceiptLineDataModel();
        receiptLineDataModel.setW(this.receiptWidth - 10);
        receiptLineDataModel.setLineStyleIndex(1);
        this.quickAdapter.add(new ReceiptElementModel(1, c.e(receiptLineDataModel)));
    }

    public void onReceiptEditMaterialAddClick(View view) {
        this.mediaPicker.pick(new Y2.a(this, 4));
    }

    public void onReceiptEditPrintClick(View view) {
        if (this.quickAdapter.getItemCount() == 0) {
            p042h2.d.show(g.toast_64);
            return;
        }
        K0 printer = p051j0.f.getPrinter();
        if (printer == null || !printer.b()) {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CONNECT_PRINT_DEVICES);
            return;
        }
        List<Object> data = this.quickAdapter.getData();
        Iterator<Object> it = data.iterator();
        while (it.hasNext()) {
            ((ReceiptElementModel) it.next()).setSelectState(false);
        }
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_RECEIPT_PRINT_PAGE).withString("ReceiptPrintPageActivityData", c.e(data)).withInt("ReceiptPrintPageActivityReceiptWidth", this.receiptWidth).navigation();
    }

    public void onReceiptEditQrcodeAddClick(View view) {
        this.haveChange = true;
        ReceiptQrCodeDataModel receiptQrCodeDataModel = new ReceiptQrCodeDataModel();
        receiptQrCodeDataModel.setW((float) (((double) this.receiptWidth) * 0.4d));
        receiptQrCodeDataModel.setH((float) (((double) this.receiptWidth) * 0.4d));
        receiptQrCodeDataModel.setContent("12345678");
        receiptQrCodeDataModel.setEncodeRef("QR_CODE");
        this.quickAdapter.add(new ReceiptElementModel(8, c.e(receiptQrCodeDataModel)));
    }

    public void onReceiptEditSaveClick(View view) {
        if (this.quickAdapter.getItemCount() != 0) {
            showSaveNameDialog();
        } else {
            p042h2.d.show(g.toast_64);
        }
    }

    public void onReceiptEditSettingClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("receiptWidth", String.valueOf(this.receiptWidth));
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_EDIT_RECEIPT).with(bundle).navigation(this, 1);
    }

    public void onReceiptEditTableAddClick(View view) {
        this.haveChange = true;
        ReceiptTableDataModel receiptTableDataModel = new ReceiptTableDataModel();
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < receiptTableDataModel.getRowsNum(); i5++) {
            ArrayList arrayList2 = new ArrayList();
            for (int i6 = 0; i6 < receiptTableDataModel.getColumnsNum(); i6++) {
                arrayList2.add(new ReceiptTableChildDataModel(10.0f, (this.receiptWidth - 10) / receiptTableDataModel.getColumnsNum()));
            }
            arrayList.add(arrayList2);
        }
        receiptTableDataModel.setTableData(arrayList);
        this.quickAdapter.add(new ReceiptElementModel(9, c.e(receiptTableDataModel)));
    }

    public void onReceiptEditTextAddClick(View view) {
        this.haveChange = true;
        ReceiptTextDataModel receiptTextDataModel = new ReceiptTextDataModel();
        receiptTextDataModel.setW(this.receiptWidth - 10);
        receiptTextDataModel.setContent(getString(g.hint_20));
        receiptTextDataModel.setFontSize(30);
        receiptTextDataModel.setAligment(1);
        this.quickAdapter.add(new ReceiptElementModel(5, c.e(receiptTextDataModel)));
    }

    @Override // com.library.base.frame.FrameActivity
    public void onReturnClick(View view) {
        if (this.haveChange) {
            saveDialog();
        } else {
            finish();
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        ReceiptModel receiptModel = (ReceiptModel) bundle.getSerializable("ReceiptModel");
        this.receiptModel = receiptModel;
        if (receiptModel == null || Y.f(receiptModel.getReceiptId())) {
            this.receiptId = String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100);
        } else {
            this.receiptId = this.receiptModel.getReceiptId();
        }
        ReceiptModel receiptModel2 = this.receiptModel;
        if (receiptModel2 == null) {
            this.receiptWidth = Integer.valueOf(bundle.getString("receiptWidth", "58")).intValue();
            this.receiptTitle = getString(g.text_400);
        } else {
            this.receiptWidth = receiptModel2.getWidth();
            this.receiptTitle = !Y.f(this.receiptModel.getTitle()) ? this.receiptModel.getTitle() : getString(g.text_400);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f6 = displayMetrics.widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rvReceiptEditData.getLayoutParams();
        this.scaleValue = ((f6 - layoutParams.leftMargin) - layoutParams.rightMargin) / C1849c.text_print_mm2px(this.receiptWidth);
        System.out.println("scaleValue:   " + this.scaleValue);
        C1849c.setScale(this.scaleValue);
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        str2.getClass();
        if (str2.equals("coverImg")) {
            ReceiptModel receiptModel = new ReceiptModel();
            receiptModel.setWidth(this.receiptWidth);
            receiptModel.setReceiptId(this.receiptId);
            receiptModel.setCoverUrl(str);
            receiptModel.setTitle(this.receiptTitle);
            receiptModel.setContent(c.e(this.quickAdapter.getData()));
            b bVar = this.addOrEditReceiptWorker;
            bVar.d.addOrEditReceipt(receiptModel).b(new A.c(bVar, 22));
            return;
        }
        if (str2.equals("Picture")) {
            w.c();
            ReceiptPictureDataModel receiptPictureDataModel = new ReceiptPictureDataModel();
            receiptPictureDataModel.setContent(str);
            receiptPictureDataModel.setW((float) (((double) this.receiptWidth) * 0.4d));
            receiptPictureDataModel.setH((float) (((double) this.receiptWidth) * 0.4d));
            this.quickAdapter.add(new ReceiptElementModel(6, c.e(receiptPictureDataModel)));
        }
    }

    @Override // p025e0.i
    public void getUserInfoSuccess() {
    }

    @Override // p025e0.i
    public void getUserInfoFailed(int i5, String str) {
    }
}
