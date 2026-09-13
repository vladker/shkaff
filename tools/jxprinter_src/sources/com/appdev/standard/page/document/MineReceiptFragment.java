package com.appdev.standard.page.document;

import U.e;
import U.h;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.ReceiptApi;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.ReceiptModel;
import com.library.base.frame.f;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.jvm.internal.Y;
import p042h2.d;
import p050j.w;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MineReceiptFragment extends f implements U.f, U.c {

    @BindView(4874)
    AutoNullDisplayView audvFragmentMineReceipt;
    private ReceiptModel deleteReceiptModel;
    private e deleteReceiptWorker;
    private com.library.base.util.recyclerview.f quickAdapter;
    private h receiptListWorker;

    @BindView(5832)
    RecyclerView rvFragmentMineReceipt;

    @BindView(5930)
    SmartRefreshLayout srlFragmentMineReceipt;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private int deletePosition = -1;

    @Override // U.c
    public void deleteReceiptFailed(int i5, String str) {
        w.c();
        d.a(str);
    }

    @Override // U.c
    public void deleteReceiptSuccess() {
        w.c();
        d.show(g.toast_31);
        this.quickAdapter.getData().remove(this.deleteReceiptModel);
        this.quickAdapter.notifyDataSetChanged();
        this.deleteReceiptModel = null;
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        h hVar = new h(getContext());
        hVar.d = (ReceiptApi) Http.createApi(ReceiptApi.class);
        this.receiptListWorker = hVar;
        addPresenter(hVar);
        e eVar = new e(getContext());
        this.deleteReceiptWorker = eVar;
        addPresenter(eVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_document_mine_receipt) { // from class: com.appdev.standard.page.document.MineReceiptFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, ReceiptModel receiptModel) {
                p047i2.a.b(receiptModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.item_document_mine_receipt_cover_url), p113u.f.ic_default_error_label_1);
            }
        };
        this.rvFragmentMineReceipt.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.rvFragmentMineReceipt.setAdapter(this.quickAdapter);
        this.audvFragmentMineReceipt.b(p113u.f.ic_publish_no_data);
        this.audvFragmentMineReceipt.setConnect(getString(g.text_284));
        this.audvFragmentMineReceipt.setButtonWhetherVisible(false);
        if (p042h2.e.f4031a.g()) {
            this.srlFragmentMineReceipt.h();
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentMineReceipt.s(new L2.f() { // from class: com.appdev.standard.page.document.MineReceiptFragment.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                MineReceiptFragment.this.isLoadMore = true;
                if (MineReceiptFragment.this.pageNum == MineReceiptFragment.this.totalPageNo) {
                    MineReceiptFragment.this.srlFragmentMineReceipt.r(true);
                    return;
                }
                MineReceiptFragment.this.pageNum++;
                h hVar = MineReceiptFragment.this.receiptListWorker;
                hVar.d.receiptList(MineReceiptFragment.this.pageNum, 10).b(new U.g(hVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                MineReceiptFragment.this.isLoadMore = false;
                MineReceiptFragment.this.srlFragmentMineReceipt.r(false);
                MineReceiptFragment.this.pageNum = 1;
                h hVar = MineReceiptFragment.this.receiptListWorker;
                hVar.d.receiptList(MineReceiptFragment.this.pageNum, 10).b(new U.g(hVar));
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.MineReceiptFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                ReceiptModel receiptModel = (ReceiptModel) MineReceiptFragment.this.quickAdapter.getItem(i5);
                Bundle bundle = new Bundle();
                bundle.putSerializable("ReceiptModel", receiptModel);
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_RECEIPT_EDIT).with(bundle).navigation();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, final int i5) {
                final DefaultTipDialog defaultTipDialog = new DefaultTipDialog(MineReceiptFragment.this.getContext());
                defaultTipDialog.e(null);
                defaultTipDialog.c(MineReceiptFragment.this.getString(g.text_244));
                defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.MineReceiptFragment.3.1
                    @Override // com.library.base.frame.d
                    public void onConfirm() {
                        defaultTipDialog.show();
                        MineReceiptFragment mineReceiptFragment = MineReceiptFragment.this;
                        mineReceiptFragment.deleteReceiptModel = (ReceiptModel) mineReceiptFragment.quickAdapter.getItem(i5);
                        if (MineReceiptFragment.this.deleteReceiptModel == null || Y.f(MineReceiptFragment.this.deleteReceiptModel.getReceiptId())) {
                            return;
                        }
                        w.e();
                        MineReceiptFragment.this.deleteReceiptWorker.a(MineReceiptFragment.this.deleteReceiptModel.getReceiptId());
                    }

                    @Override // com.library.base.frame.d
                    public void onCancel() {
                    }
                };
                defaultTipDialog.show();
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_mine_receipt;
    }

    @Override // U.f
    public void receiptListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentMineReceipt.k();
        this.srlFragmentMineReceipt.i();
        w.c();
        d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // U.f
    public void receiptListSuccess(List<ReceiptModel> list, int i5) {
        this.srlFragmentMineReceipt.k();
        this.srlFragmentMineReceipt.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
