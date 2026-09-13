package com.appdev.standard.page.document;

import H.e;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.DocumentApi;
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
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.opencv.videoio.Videoio;
import p050j.w;
import p113u.d;
import p113u.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PublishLabelFragment extends f implements H.c, H.a {

    @BindView(4871)
    AutoNullDisplayView audvFragmentCollectLabel;
    private H.b publishLabelDeleteWorker;
    private e publishLabelWorker;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5826)
    RecyclerView rvFragmentCollectLabel;

    @BindView(5927)
    SmartRefreshLayout srlFragmentCollectLabel;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private int deletePosition = -1;

    /* JADX INFO: renamed from: com.appdev.standard.page.document.PublishLabelFragment$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass1 extends com.library.base.util.recyclerview.f {
        public AnonymousClass1(Context context, int i5) {
            super(context, i5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$convert$0(com.library.base.util.recyclerview.a aVar, final CollectLabelModel collectLabelModel, View view) {
            PublishLabelFragment.this.deletePosition = aVar.getAdapterPosition();
            DefaultTipDialog defaultTipDialog = new DefaultTipDialog(PublishLabelFragment.this.getContext());
            defaultTipDialog.e(null);
            defaultTipDialog.c(PublishLabelFragment.this.getString(g.text_244));
            defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.document.PublishLabelFragment.1.1
                @Override // com.library.base.frame.d
                public void onConfirm() {
                    w.e();
                    H.b bVar = PublishLabelFragment.this.publishLabelDeleteWorker;
                    String biaoqianTemplateId = collectLabelModel.getBiaoqianTemplateId();
                    bVar.getClass();
                    HashMap map = new HashMap();
                    map.put("biaoqianTemplateId", biaoqianTemplateId);
                    bVar.d.deletePublishLabel(map).b(new A.c(bVar, 7));
                }

                @Override // com.library.base.frame.d
                public void onCancel() {
                }
            };
            defaultTipDialog.show();
        }

        @Override // com.library.base.util.recyclerview.b
        public void convert(final com.library.base.util.recyclerview.a aVar, final CollectLabelModel collectLabelModel) {
            aVar.b(d.tv_document_publish_label_title, collectLabelModel.getTitle());
            aVar.b(d.tv_document_publish_label_collect_number, collectLabelModel.getCollectNumber());
            aVar.b(d.tv_document_publish_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(collectLabelModel.getWidth()), Integer.valueOf(collectLabelModel.getHeight())));
            aVar.b(d.tv_document_publish_label_create_time, h.a(collectLabelModel.getCreateTime(), "yyyy.MM.dd"));
            p047i2.a.b(collectLabelModel.getCoverUrl(), (ImageView) aVar.a(d.iv_document_publish_label_img), p113u.f.ic_default_error_label_1);
            System.out.println("状态" + collectLabelModel.templateStatus());
            if (collectLabelModel.templateStatus() == 1) {
                aVar.c(d.iv_status, true);
                aVar.a(d.ll_collect).setVisibility(8);
            } else {
                aVar.c(d.iv_status, false);
                aVar.a(d.ll_collect).setVisibility(0);
            }
            ((ImageView) aVar.a(d.iv_delete)).setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.document.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f2696a.lambda$convert$0(aVar, collectLabelModel, view);
                }
            });
        }
    }

    @Override // H.a
    public void deletePublishLabelFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // H.a
    public void deletePublishLabelSuccess() {
        w.c();
        int i5 = this.deletePosition;
        if (i5 == -1 || i5 >= this.quickAdapter.getItemCount()) {
            return;
        }
        this.quickAdapter.remove(this.deletePosition);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        e eVar = new e(getContext());
        eVar.d = (DocumentApi) Http.createApi(DocumentApi.class);
        this.publishLabelWorker = eVar;
        addPresenter(eVar);
        H.b bVar = new H.b(getContext());
        bVar.d = (DocumentApi) Http.createApi(DocumentApi.class);
        this.publishLabelDeleteWorker = bVar;
        addPresenter(bVar);
        this.quickAdapter = new AnonymousClass1(getContext(), p113u.e.item_document_publish_label);
        this.rvFragmentCollectLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentCollectLabel.setAdapter(this.quickAdapter);
        this.audvFragmentCollectLabel.b(p113u.f.ic_publish_no_data);
        this.audvFragmentCollectLabel.setConnect(getString(g.text_284));
        this.audvFragmentCollectLabel.setButtonWhetherVisible(false);
        if (p042h2.e.f4031a.g()) {
            this.srlFragmentCollectLabel.h();
        } else {
            androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
        }
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentCollectLabel.s(new L2.f() { // from class: com.appdev.standard.page.document.PublishLabelFragment.2
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                PublishLabelFragment.this.isLoadMore = true;
                if (PublishLabelFragment.this.pageNum == PublishLabelFragment.this.totalPageNo) {
                    PublishLabelFragment.this.srlFragmentCollectLabel.r(true);
                    return;
                }
                PublishLabelFragment.this.pageNum++;
                e eVar = PublishLabelFragment.this.publishLabelWorker;
                eVar.d.publishLabel(PublishLabelFragment.this.pageNum, 10).b(new H.d(eVar));
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                PublishLabelFragment.this.isLoadMore = false;
                PublishLabelFragment.this.srlFragmentCollectLabel.r(false);
                PublishLabelFragment.this.pageNum = 1;
                e eVar = PublishLabelFragment.this.publishLabelWorker;
                eVar.d.publishLabel(PublishLabelFragment.this.pageNum, 10).b(new H.d(eVar));
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.document.PublishLabelFragment.3
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getTitle(), ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getWidth(), ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getBiaoqianTemplateId(), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data_template_config", templateConfigBean);
                bundle.putString("data_template_content", p052j2.c.e(templatePto.getViews()));
                bundle.putString("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                bundle.putInt("data_print_data_source", 2);
                bundle.putString("data_print_cover_url", ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getCoverUrl());
                bundle.putString("data_print_title", ((CollectLabelModel) PublishLabelFragment.this.quickAdapter.getData().get(i5)).getTitle());
                bundle.putString("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PRINTER_TEMPLATE_EDIT).with(bundle).navigation();
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_publish_label;
    }

    @Override // H.c
    public void publishLabelFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentCollectLabel.k();
        this.srlFragmentCollectLabel.i();
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // H.c
    public void publishLabelSuccess(List<CollectLabelModel> list, int i5) {
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

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
