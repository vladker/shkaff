package com.appdev.standard.page.document;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.DocumentApi;
import com.appdev.standard.api.pto.CollectUpdatePto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.model.CollectLabelModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.bumptech.glide.h;
import com.library.base.frame.f;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.opencv.videoio.Videoio;
import p042h2.e;
import p050j.w;
import p113u.d;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class CollectLabelFragment extends f implements F.a, D.a {

    @BindView(4871)
    AutoNullDisplayView audvFragmentCollectLabel;
    private F.c collectLabelWorker;
    private DefaultTipDialog defaultTipDialog;
    private CollectLabelModel deleteCollectLabelModel;
    private D.b labelCollectUpdateWorker;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5826)
    RecyclerView rvFragmentCollectLabel;

    @BindView(5927)
    SmartRefreshLayout srlFragmentCollectLabel;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;

    /* JADX INFO: renamed from: com.appdev.standard.page.document.CollectLabelFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(com.library.base.util.recyclerview.a aVar, final CollectLabelModel collectLabelModel) {
            aVar.b(d.tv_document_collect_label_title, collectLabelModel.getTitle());
            aVar.b(d.tv_document_collect_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(collectLabelModel.getWidth()), Integer.valueOf(collectLabelModel.getHeight())));
            aVar.b(d.tv_document_collect_label_create_time, h.a(collectLabelModel.getCreateTime(), "yyyy.MM.dd"));
            p047i2.a.b(Y.f(collectLabelModel.getCoverUrl()) ? "" : collectLabelModel.getCoverUrl(), (ImageView) aVar.a(d.iv_document_collect_label_img), p113u.f.ic_default_error_label_1);
            ((LinearLayout) aVar.a(d.ll_document_collect_label_collect)).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.CollectLabelFragment.1.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    CollectLabelFragment.this.defaultTipDialog = new DefaultTipDialog(CollectLabelFragment.this.getContext());
                    DefaultTipDialog defaultTipDialog = CollectLabelFragment.this.defaultTipDialog;
                    defaultTipDialog.e(null);
                    defaultTipDialog.c(CollectLabelFragment.this.getString(g.text_243));
                    defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.CollectLabelFragment.1.1.1
                        @Override // com.library.base.frame.d
                        public void onConfirm() {
                            ViewOnClickListenerC00491 viewOnClickListenerC00491 = ViewOnClickListenerC00491.this;
                            CollectLabelFragment.this.deleteCollectLabelModel = collectLabelModel;
                            w.e();
                            D.b bVar = CollectLabelFragment.this.labelCollectUpdateWorker;
                            bVar.d.collectUpdate(new CollectUpdatePto(collectLabelModel.getBiaoqianTemplateId(), "1")).b(new A.c(bVar, 4));
                        }

                        @Override // com.library.base.frame.d
                        public void onCancel() {
                        }
                    };
                    CollectLabelFragment.this.defaultTipDialog.show();
                }
            });
        }
    }

    @Override // F.a
    public void collectLabelFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentCollectLabel.k();
        this.srlFragmentCollectLabel.i();
        w.c();
        p042h2.d.a(str);
        if (e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // F.a
    public void collectLabelSuccess(List<CollectLabelModel> list, int i5) {
        this.srlFragmentCollectLabel.k();
        this.srlFragmentCollectLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.quickAdapter.addAll(list);
        } else {
            this.quickAdapter.replaceAll(list);
        }
    }

    @Override // D.a
    public void collectUpdateFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // D.a
    public void collectUpdateSuccess() {
        w.c();
        this.quickAdapter.getData().remove(this.deleteCollectLabelModel);
        this.quickAdapter.notifyDataSetChanged();
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        F.c cVar = new F.c(getContext());
        cVar.d = (DocumentApi) Http.createApi(DocumentApi.class);
        this.collectLabelWorker = cVar;
        addPresenter(cVar);
        D.b bVar = new D.b(getContext());
        this.labelCollectUpdateWorker = bVar;
        addPresenter(bVar);
        this.quickAdapter = new AnonymousClass1(getContext(), p113u.e.item_document_collect_label);
        this.rvFragmentCollectLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentCollectLabel.setAdapter(this.quickAdapter);
        this.audvFragmentCollectLabel.b(p113u.f.ic_label_no_data);
        this.audvFragmentCollectLabel.setConnect(getString(g.text_282));
        this.audvFragmentCollectLabel.setButtonWhetherVisible(false);
        if (e.f4031a.g()) {
            this.srlFragmentCollectLabel.h();
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentCollectLabel.s(new L2.f() { // from class: com.appdev.standard.page.document.CollectLabelFragment.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                CollectLabelFragment.this.isLoadMore = true;
                if (CollectLabelFragment.this.pageNum == CollectLabelFragment.this.totalPageNo) {
                    CollectLabelFragment.this.srlFragmentCollectLabel.r(true);
                    return;
                }
                CollectLabelFragment.this.pageNum++;
                F.c cVar = CollectLabelFragment.this.collectLabelWorker;
                cVar.d.collectLabel(CollectLabelFragment.this.pageNum, 10).b(new F.b(cVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                CollectLabelFragment.this.isLoadMore = false;
                CollectLabelFragment.this.srlFragmentCollectLabel.r(false);
                CollectLabelFragment.this.pageNum = 1;
                F.c cVar = CollectLabelFragment.this.collectLabelWorker;
                cVar.d.collectLabel(CollectLabelFragment.this.pageNum, 10).b(new F.b(cVar));
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.CollectLabelFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                try {
                    TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getContent());
                    TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                    TemplateConfigBean templateConfigBean = new TemplateConfigBean(((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getTitle(), ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getWidth(), ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getBiaoqianTemplateId(), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("data_template_config", templateConfigBean);
                    bundle.putString("data_template_content", p052j2.c.e(templatePto.getViews()));
                    bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                    bundle.putInt("data_print_data_source", 1);
                    bundle.putString("data_print_cover_url", ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getCoverUrl());
                    bundle.putString("data_print_title", ((CollectLabelModel) CollectLabelFragment.this.quickAdapter.getData().get(i5)).getTitle());
                    bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_collect_label;
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
