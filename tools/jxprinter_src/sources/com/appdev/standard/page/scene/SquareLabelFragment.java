package com.appdev.standard.page.scene;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.webkit.ProxyConfig;
import butterknife.BindView;
import butterknife.OnClick;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.SceneApi;
import com.appdev.standard.api.pto.CollectUpdatePto;
import com.appdev.standard.api.pto.TemplatePaperPto;
import com.appdev.standard.api.pto.TemplatePto;
import com.appdev.standard.model.DictModel;
import com.appdev.standard.model.SquareLabelModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.opencv.videoio.Videoio;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SquareLabelFragment extends com.library.base.frame.f implements Z.a, E.c, D.a {
    private com.library.base.util.recyclerview.f adapter;

    @BindView(4875)
    AutoNullDisplayView audvFragmentSquareLabel;
    private E.e bqIndustryDictWorker;

    @BindView(5057)
    EditText etFragmentSquareLabelMaxWidth;

    @BindView(5058)
    EditText etFragmentSquareLabelMinWidth;

    @BindView(5059)
    EditText etFragmentSquareLabelSearch;
    private D.b labelCollectUpdateWorker;

    @BindView(5833)
    RecyclerView rvFragmentSquareLabel;

    @BindView(5834)
    RecyclerView rvFragmentSquareLabelType;
    private Z.c squareLabelListWorker;
    private SquareLabelModel squareLabelModel;

    @BindView(5931)
    SmartRefreshLayout srlFragmentSquareLabel;
    private com.library.base.util.recyclerview.f typeAdapter;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private boolean needRefreshOnResume = false;
    private String templateIndustry = null;
    private int platform = 1;

    @Override // D.a
    public void collectUpdateFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
        if (p042h2.e.f4031a.g()) {
            return;
        }
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_LOGIN);
    }

    @Override // D.a
    public void collectUpdateSuccess() {
        w.c();
        if (this.squareLabelModel != null) {
            int iIndexOf = this.adapter.getData().indexOf(this.squareLabelModel);
            if (iIndexOf != -1) {
                ((SquareLabelModel) this.adapter.getData().get(iIndexOf)).setCollect("0".equals(((SquareLabelModel) this.adapter.getData().get(iIndexOf)).getCollect()) ? "1" : "0");
                this.adapter.notifyDataSetChanged();
            }
            this.squareLabelModel = null;
        }
    }

    @Override // E.c
    public void getBqDictFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // E.c
    public void getBqDictSuccess(List<DictModel> list) {
        w.c();
        this.typeAdapter.clear();
        this.typeAdapter.add(new DictModel(getString(p113u.g.text_298), null, true));
        this.typeAdapter.addAll(list);
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        D.b bVar = new D.b(getContext());
        this.labelCollectUpdateWorker = bVar;
        addPresenter(bVar);
        Z.c cVar = new Z.c(getContext());
        cVar.d = (SceneApi) Http.createApi(SceneApi.class);
        this.squareLabelListWorker = cVar;
        addPresenter(cVar);
        E.e eVar = new E.e(getContext());
        this.bqIndustryDictWorker = eVar;
        addPresenter(eVar);
        w.e();
        E.e eVar2 = this.bqIndustryDictWorker;
        eVar2.d.getBqPlazaDict().b(new E.d(eVar2, 1));
        this.typeAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_square_label_type) { // from class: com.appdev.standard.page.scene.SquareLabelFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, DictModel dictModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_square_label_type);
                textView.setText(dictModel.getDictLabel());
                if (dictModel.isSelect()) {
                    textView.setTextColor(SquareLabelFragment.this.getResources().getColor(p113u.a.white));
                    textView.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView.setTextColor(SquareLabelFragment.this.getResources().getColor(p113u.a.color_FFAE00));
                    textView.setBackground(null);
                }
            }
        };
        this.rvFragmentSquareLabelType.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvFragmentSquareLabelType.setAdapter(this.typeAdapter);
        this.adapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_square_label) { // from class: com.appdev.standard.page.scene.SquareLabelFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final SquareLabelModel squareLabelModel) {
                aVar.b(p113u.d.tv_item_fragment_square_label_title, squareLabelModel.getTemplateDescription());
                p047i2.a.b(squareLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_item_fragment_square_label_img), p113u.f.ic_default_error_label_2);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_fragment_square_label_collect);
                if ("0".equals(squareLabelModel.getCollect())) {
                    imageView.setImageResource(p113u.f.ic_common_collect_not);
                } else {
                    imageView.setImageResource(p113u.f.ic_common_collect);
                }
                p047i2.a.loadPicture(squareLabelModel.getAvatar(), (ImageView) aVar.a(p113u.d.iv_item_fragment_square_label_avatar), true, 2, 2, null, -1);
                aVar.b(p113u.d.tv_item_fragment_square_label_nick_name, squareLabelModel.getNickName());
                aVar.b(p113u.d.tv_item_fragment_square_label_create_time, com.bumptech.glide.h.a(squareLabelModel.getReleaseTime(), "yyyy.MM.dd"));
                aVar.b(p113u.d.tv_item_fragment_square_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(squareLabelModel.getWidth()), Integer.valueOf(squareLabelModel.getHeight())));
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.SquareLabelFragment.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SquareLabelFragment.this.squareLabelModel = squareLabelModel;
                        w.e();
                        D.b bVar2 = SquareLabelFragment.this.labelCollectUpdateWorker;
                        bVar2.d.collectUpdate(new CollectUpdatePto(squareLabelModel.getBiaoqianTemplateId(), squareLabelModel.getCollect())).b(new A.c(bVar2, 4));
                    }
                });
            }
        };
        this.rvFragmentSquareLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentSquareLabel.setAdapter(this.adapter);
        this.audvFragmentSquareLabel.b(p113u.f.ic_label_no_data);
        this.audvFragmentSquareLabel.setConnect(getString(p113u.g.text_282));
        this.audvFragmentSquareLabel.setButtonWhetherVisible(false);
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentSquareLabel.s(new L2.f() { // from class: com.appdev.standard.page.scene.SquareLabelFragment.3
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                SquareLabelFragment.this.isLoadMore = true;
                if (SquareLabelFragment.this.pageNum == SquareLabelFragment.this.totalPageNo) {
                    SquareLabelFragment.this.srlFragmentSquareLabel.r(true);
                    return;
                }
                SquareLabelFragment.this.pageNum++;
                SquareLabelFragment.this.squareLabelListWorker.a(SquareLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(SquareLabelFragment.this.etFragmentSquareLabelSearch), SquareLabelFragment.this.etFragmentSquareLabelMaxWidth.getText().toString(), SquareLabelFragment.this.etFragmentSquareLabelMinWidth.getText().toString(), SquareLabelFragment.this.templateIndustry);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                SquareLabelFragment.this.isLoadMore = false;
                SquareLabelFragment.this.srlFragmentSquareLabel.r(false);
                SquareLabelFragment.this.pageNum = 1;
                SquareLabelFragment.this.squareLabelListWorker.a(SquareLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(SquareLabelFragment.this.etFragmentSquareLabelSearch), SquareLabelFragment.this.etFragmentSquareLabelMaxWidth.getText().toString(), SquareLabelFragment.this.etFragmentSquareLabelMinWidth.getText().toString(), SquareLabelFragment.this.templateIndustry);
            }
        });
        this.typeAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.SquareLabelFragment.4
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = SquareLabelFragment.this.typeAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((DictModel) it.next()).setSelect(false);
                }
                ((DictModel) SquareLabelFragment.this.typeAdapter.getData().get(i5)).setSelect(true);
                SquareLabelFragment.this.typeAdapter.notifyDataSetChanged();
                SquareLabelFragment squareLabelFragment = SquareLabelFragment.this;
                squareLabelFragment.templateIndustry = ((DictModel) squareLabelFragment.typeAdapter.getData().get(i5)).getDictValue();
                SquareLabelFragment.this.isLoadMore = false;
                SquareLabelFragment.this.srlFragmentSquareLabel.r(false);
                SquareLabelFragment.this.pageNum = 1;
                SquareLabelFragment.this.squareLabelListWorker.a(SquareLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(SquareLabelFragment.this.etFragmentSquareLabelSearch), SquareLabelFragment.this.etFragmentSquareLabelMaxWidth.getText().toString(), SquareLabelFragment.this.etFragmentSquareLabelMinWidth.getText().toString(), SquareLabelFragment.this.templateIndustry);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        this.adapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.SquareLabelFragment.5
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getTitle(), ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getWidth(), ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getBiaoqianTemplateId(), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                p051j0.a.c("TemplateInfo", "Title: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getTitle());
                p051j0.a.c("TemplateInfo", "Width: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getWidth());
                p051j0.a.c("TemplateInfo", "Height: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getHeight());
                p051j0.a.c("TemplateInfo", "BiaoqianTemplateId: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getBiaoqianTemplateId());
                p051j0.a.c("TemplateInfo", "Columns: " + templatePaperPto.getColumns());
                p051j0.a.c("TemplateInfo", "ColumnMargin: " + templatePaperPto.getColumnMargin());
                p051j0.a.c("TemplateInfo", "Background: " + templatePaperPto.getBackground());
                p051j0.a.c("TemplateInfo", "BorderUrl: " + templatePaperPto.getBorderUrl());
                p051j0.a.c("TemplateInfo", "PaperType: " + templatePaperPto.getPaperType());
                p051j0.a.c("TemplateInfo", "CollectNumber: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getCollectNumber());
                p051j0.a.c("TemplateInfo", "TemplateIndustry: ".concat(String.valueOf(SquareLabelFragment.this.templateIndustry)));
                p051j0.a.c("TemplateInfo", "Avatar: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getAvatar());
                p051j0.a.c("TemplateInfo", "NickName: " + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getNickName());
                String strE = p052j2.c.e(templatePto.getViews());
                p051j0.a.c("TemplateInfo", "广场Views: " + strE);
                HashMap map = new HashMap();
                map.put("data_template_config", p052j2.c.e(templateConfigBean));
                map.put("data_template_content", strE);
                map.put("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                map.put("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                map.put("columns", String.valueOf(templatePaperPto.getColumns()));
                map.put("columnMargin", String.valueOf(templatePaperPto.getColumnMargin()));
                map.put("printerLabelBgUrl", templatePaperPto.getBackground());
                map.put("printerLabelBorderUrl", templatePaperPto.getBorderUrl());
                map.put("templateId", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getBiaoqianTemplateId());
                map.put("paperType", String.valueOf(templatePaperPto.getPaperType()));
                map.put("templateIndustry", String.valueOf(SquareLabelFragment.this.templateIndustry));
                map.put("platform", String.valueOf(SquareLabelFragment.this.platform));
                map.put("rotate", String.valueOf(templatePaperPto.getRotate()));
                String strA = com.bumptech.glide.h.a(((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getReleaseTime(), "yyyy-MM-dd");
                map.put("labelUrl", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getCoverUrl());
                map.put("labelName", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getTemplateDescription());
                map.put("labelDate", strA);
                map.put("labelSize", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getWidth() + ProxyConfig.MATCH_ALL_SCHEMES + ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getHeight());
                map.put("collectNumber", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getCollectNumber());
                map.put("collect", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getCollect());
                map.put("avatar", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getAvatar());
                map.put("nickName", ((SquareLabelModel) androidx.exifinterface.media.a.d(SquareLabelFragment.this, i5)).getNickName());
                map.put("showUserInfo", Boolean.TRUE);
                p051j0.a.c("Args", "Args: " + map.toString());
                FlutterBoostRouteOptions flutterBoostRouteOptionsBuild = new FlutterBoostRouteOptions.Builder().pageName("industr_templates_details_reviews").arguments(map).requestCode(0).build();
                SquareLabelFragment.this.needRefreshOnResume = true;
                FlutterBoost.instance().open(flutterBoostRouteOptionsBuild);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_square_label;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com.library.base.util.recyclerview.f fVar;
        super.onResume();
        System.out.println("广场");
        S4.d.b().f(new p137y.d("广场"));
        if (!this.needRefreshOnResume || (fVar = this.adapter) == null || fVar.getData().size() <= 0) {
            return;
        }
        this.isLoadMore = false;
        this.srlFragmentSquareLabel.r(false);
        this.pageNum = 1;
        this.squareLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentSquareLabelSearch), this.etFragmentSquareLabelMaxWidth.getText().toString(), this.etFragmentSquareLabelMinWidth.getText().toString(), this.templateIndustry);
        this.needRefreshOnResume = false;
    }

    @OnClick({6103})
    public void onSquareLabelScreenhClick() {
        this.isLoadMore = false;
        this.srlFragmentSquareLabel.r(false);
        this.pageNum = 1;
        this.squareLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentSquareLabelSearch), this.etFragmentSquareLabelMaxWidth.getText().toString(), this.etFragmentSquareLabelMinWidth.getText().toString(), this.templateIndustry);
    }

    @OnClick({6104})
    public void onSquareLabelSearchClick() {
        this.isLoadMore = false;
        this.srlFragmentSquareLabel.r(false);
        this.pageNum = 1;
        this.squareLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentSquareLabelSearch), this.etFragmentSquareLabelMaxWidth.getText().toString(), this.etFragmentSquareLabelMinWidth.getText().toString(), this.templateIndustry);
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
        this.squareLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentSquareLabelSearch), this.etFragmentSquareLabelMaxWidth.getText().toString(), this.etFragmentSquareLabelMinWidth.getText().toString(), this.templateIndustry);
    }

    @Override // Z.a
    public void squareTemplateListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentSquareLabel.k();
        this.srlFragmentSquareLabel.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // Z.a
    public void squareTemplateListSuccess(List<SquareLabelModel> list, int i5) {
        this.srlFragmentSquareLabel.k();
        this.srlFragmentSquareLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.adapter.addAll(list);
        } else {
            this.adapter.replaceAll(list);
        }
    }
}
