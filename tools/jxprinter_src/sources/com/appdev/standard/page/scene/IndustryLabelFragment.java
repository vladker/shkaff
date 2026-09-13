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
import com.appdev.standard.model.CommonSelectModel;
import com.appdev.standard.model.DictModel;
import com.appdev.standard.model.IndustryLabelModel;
import com.appdev.standard.model.TemplateConfigBean;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostRouteOptions;
import com.library.base.frame.FrameApplication;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.orhanobut.hawk.Hawk;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Y;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.opencv.videoio.Videoio;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class IndustryLabelFragment extends com.library.base.frame.f implements Y.a, E.c, D.a {
    private com.library.base.util.recyclerview.f adapter;

    @BindView(4872)
    AutoNullDisplayView audvFragmentIndustryLabel;
    private E.e bqIndustryDictWorker;

    @BindView(5055)
    EditText etFragmentIndustryLabelSearch;
    private Y.c industryLabelListWorker;
    private IndustryLabelModel industryLabelModel;
    private D.b labelCollectUpdateWorker;

    @BindView(5828)
    RecyclerView rvFragmentIndustryLabel;

    @BindView(5829)
    RecyclerView rvFragmentIndustryLabelSpecifications;

    @BindView(5830)
    RecyclerView rvFragmentIndustryLabelType;
    private com.library.base.util.recyclerview.f specificationsAdapter;

    @BindView(5928)
    SmartRefreshLayout srlFragmentIndustryLabel;
    private com.library.base.util.recyclerview.f typeAdapter;
    private int pageNum = 1;
    private int totalPageNo = 1;
    private boolean isLoadMore = false;
    private boolean needRefreshOnResume = false;
    private String specifications = null;
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
        if (this.industryLabelModel != null) {
            int iIndexOf = this.adapter.getData().indexOf(this.industryLabelModel);
            if (iIndexOf != -1) {
                ((IndustryLabelModel) this.adapter.getData().get(iIndexOf)).setCollect("0".equals(((IndustryLabelModel) this.adapter.getData().get(iIndexOf)).getCollect()) ? "1" : "0");
                this.adapter.notifyDataSetChanged();
            }
            this.industryLabelModel = null;
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
        list.add(0, new DictModel(getString(p113u.g.text_297), "0", false));
        this.typeAdapter.replaceAll(list);
        if (this.typeAdapter.getData().size() != 0) {
            ((DictModel) this.typeAdapter.getData().get(0)).setSelect(true);
            this.templateIndustry = ((DictModel) this.typeAdapter.getData().get(0)).getDictValue();
            this.industryLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentIndustryLabelSearch), Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], this.templateIndustry);
        }
    }

    @Override // Y.a
    public void industryLabelListFailed(int i5, String str) {
        int i6 = this.pageNum;
        if (i6 > 1) {
            this.pageNum = i6 - 1;
        }
        this.srlFragmentIndustryLabel.k();
        this.srlFragmentIndustryLabel.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // Y.a
    public void industryLabelListSuccess(List<IndustryLabelModel> list, int i5) {
        this.srlFragmentIndustryLabel.k();
        this.srlFragmentIndustryLabel.i();
        this.totalPageNo = (int) Math.ceil(((double) i5) / 10.0d);
        w.c();
        if (this.isLoadMore) {
            this.adapter.addAll(list);
        } else {
            this.adapter.replaceAll(list);
        }
    }

    @Override // com.library.base.frame.e
    public void initComponent() {
        D.b bVar = new D.b(getContext());
        this.labelCollectUpdateWorker = bVar;
        addPresenter(bVar);
        Y.c cVar = new Y.c(getContext());
        cVar.d = (SceneApi) Http.createApi(SceneApi.class);
        this.industryLabelListWorker = cVar;
        addPresenter(cVar);
        E.e eVar = new E.e(getContext());
        this.bqIndustryDictWorker = eVar;
        addPresenter(eVar);
        w.e();
        this.bqIndustryDictWorker.a();
        this.specificationsAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_industry_label_specifications) { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, CommonSelectModel commonSelectModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_industry_label_specifications);
                textView.setText(commonSelectModel.getKey());
                if (commonSelectModel.isSelect()) {
                    textView.setTextColor(IndustryLabelFragment.this.getResources().getColor(p113u.a.white));
                    textView.setBackgroundResource(p113u.c.bg_ffae00_rad_5);
                } else {
                    textView.setTextColor(IndustryLabelFragment.this.getResources().getColor(p113u.a.color_999999));
                    textView.setBackgroundResource(p113u.c.bg_f8f8f8_rad_5_stroke_dddddd);
                }
            }
        };
        this.rvFragmentIndustryLabelSpecifications.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.rvFragmentIndustryLabelSpecifications.setAdapter(this.specificationsAdapter);
        final String str = (String) Hawk.get("current_language", FrameApplication.defaultLang);
        this.typeAdapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_industry_label_type) { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, DictModel dictModel) {
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_fragment_industry_label_type);
                textView.setText(dictModel.getDictLabel());
                if (str.equals("en")) {
                    textView.setGravity(2);
                }
                if (dictModel.isSelect()) {
                    textView.setTextColor(IndustryLabelFragment.this.getResources().getColor(p113u.a.white));
                    textView.setBackgroundResource(p113u.c.bg_ffae00_rad_10);
                } else {
                    textView.setTextColor(IndustryLabelFragment.this.getResources().getColor(p113u.a.color_FFAE00));
                    textView.setBackground(null);
                }
            }
        };
        this.rvFragmentIndustryLabelType.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentIndustryLabelType.setAdapter(this.typeAdapter);
        this.adapter = new com.library.base.util.recyclerview.f(getContext(), p113u.e.item_fragment_industry_label) { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.3
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, final IndustryLabelModel industryLabelModel) {
                aVar.b(p113u.d.tv_item_fragment_industry_label_title, industryLabelModel.getTemplateDescription());
                aVar.b(p113u.d.tv_item_fragment_industry_label_specifications, String.format("%d*%dmm(W*H)", Integer.valueOf(industryLabelModel.getWidth()), Integer.valueOf(industryLabelModel.getHeight())));
                aVar.b(p113u.d.tv_item_fragment_industry_label_create_time, com.bumptech.glide.h.a(industryLabelModel.getReleaseTime(), "yyyy.MM.dd"));
                p047i2.a.b(industryLabelModel.getCoverUrl(), (ImageView) aVar.a(p113u.d.iv_item_fragment_industry_label_img), p113u.f.ic_default_error_label_2);
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_fragment_industry_label_collect);
                if ("0".equals(industryLabelModel.getCollect())) {
                    imageView.setImageResource(p113u.f.ic_common_collect_not);
                } else {
                    imageView.setImageResource(p113u.f.ic_common_collect);
                }
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        IndustryLabelFragment.this.industryLabelModel = industryLabelModel;
                        w.e();
                        D.b bVar2 = IndustryLabelFragment.this.labelCollectUpdateWorker;
                        bVar2.d.collectUpdate(new CollectUpdatePto(industryLabelModel.getBiaoqianTemplateId(), industryLabelModel.getCollect())).b(new A.c(bVar2, 4));
                    }
                });
            }
        };
        this.rvFragmentIndustryLabel.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvFragmentIndustryLabel.setAdapter(this.adapter);
        this.audvFragmentIndustryLabel.b(p113u.f.ic_label_no_data);
        this.audvFragmentIndustryLabel.setConnect(getString(p113u.g.text_282));
        this.audvFragmentIndustryLabel.setButtonWhetherVisible(false);
        this.specificationsAdapter.add(new CommonSelectModel(getString(p113u.g.text_198), "0-0", true));
        this.specificationsAdapter.add(new CommonSelectModel("1-30", "1-30", false));
        this.specificationsAdapter.add(new CommonSelectModel("30-50", "30-50", false));
        this.specificationsAdapter.add(new CommonSelectModel("50-80", "50-80", false));
        this.specificationsAdapter.add(new CommonSelectModel("80-110", "80-110", false));
    }

    @Override // com.library.base.frame.f, com.library.base.frame.e
    public void initListener() {
        this.srlFragmentIndustryLabel.s(new L2.f() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.4
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                IndustryLabelFragment.this.isLoadMore = true;
                if (IndustryLabelFragment.this.pageNum == IndustryLabelFragment.this.totalPageNo) {
                    IndustryLabelFragment.this.srlFragmentIndustryLabel.r(true);
                    return;
                }
                IndustryLabelFragment.this.pageNum++;
                IndustryLabelFragment.this.industryLabelListWorker.a(IndustryLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(IndustryLabelFragment.this.etFragmentIndustryLabelSearch), Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], IndustryLabelFragment.this.templateIndustry);
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                IndustryLabelFragment.this.isLoadMore = false;
                IndustryLabelFragment.this.srlFragmentIndustryLabel.r(false);
                IndustryLabelFragment.this.pageNum = 1;
                IndustryLabelFragment.this.industryLabelListWorker.a(IndustryLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(IndustryLabelFragment.this.etFragmentIndustryLabelSearch), Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], IndustryLabelFragment.this.templateIndustry);
            }
        });
        this.specificationsAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.5
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = IndustryLabelFragment.this.specificationsAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((CommonSelectModel) it.next()).setSelect(false);
                }
                ((CommonSelectModel) IndustryLabelFragment.this.specificationsAdapter.getData().get(i5)).setSelect(true);
                IndustryLabelFragment.this.specificationsAdapter.notifyDataSetChanged();
                IndustryLabelFragment industryLabelFragment = IndustryLabelFragment.this;
                industryLabelFragment.specifications = ((CommonSelectModel) industryLabelFragment.specificationsAdapter.getData().get(i5)).getValue();
                IndustryLabelFragment.this.isLoadMore = false;
                IndustryLabelFragment.this.srlFragmentIndustryLabel.r(false);
                IndustryLabelFragment.this.pageNum = 1;
                IndustryLabelFragment.this.industryLabelListWorker.a(IndustryLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(IndustryLabelFragment.this.etFragmentIndustryLabelSearch), Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], IndustryLabelFragment.this.templateIndustry);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        this.typeAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.6
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Iterator<Object> it = IndustryLabelFragment.this.typeAdapter.getData().iterator();
                while (it.hasNext()) {
                    ((DictModel) it.next()).setSelect(false);
                }
                ((DictModel) IndustryLabelFragment.this.typeAdapter.getData().get(i5)).setSelect(true);
                IndustryLabelFragment.this.typeAdapter.notifyDataSetChanged();
                IndustryLabelFragment industryLabelFragment = IndustryLabelFragment.this;
                industryLabelFragment.templateIndustry = ((DictModel) industryLabelFragment.typeAdapter.getData().get(i5)).getDictValue();
                IndustryLabelFragment.this.isLoadMore = false;
                IndustryLabelFragment.this.srlFragmentIndustryLabel.r(false);
                IndustryLabelFragment.this.pageNum = 1;
                IndustryLabelFragment.this.industryLabelListWorker.a(IndustryLabelFragment.this.pageNum, androidx.exifinterface.media.a.f(IndustryLabelFragment.this.etFragmentIndustryLabelSearch), Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(IndustryLabelFragment.this.specifications) ? null : IndustryLabelFragment.this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], IndustryLabelFragment.this.templateIndustry);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
        this.adapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.scene.IndustryLabelFragment.7
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                TemplatePto templatePto = (TemplatePto) p052j2.c.c(TemplatePto.class, ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getContent());
                TemplatePaperPto templatePaperPto = (TemplatePaperPto) p052j2.c.d(templatePto.getPaper(), TemplatePaperPto.class);
                TemplateConfigBean templateConfigBean = new TemplateConfigBean(((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getTitle(), ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getWidth(), ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getHeight(), templatePaperPto.getColumns(), templatePaperPto.getColumnMargin(), ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getBiaoqianTemplateId(), templatePaperPto.getBackground(), templatePaperPto.getBorderUrl(), templatePaperPto.getPaperType(), templatePaperPto.getRotate());
                p051j0.a.c("TemplateInfo", "Title: " + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getTitle());
                p051j0.a.c("TemplateInfo", "Width: " + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getWidth());
                p051j0.a.c("TemplateInfo", "Height: " + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getHeight());
                p051j0.a.c("TemplateInfo", "BiaoqianTemplateId: " + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getBiaoqianTemplateId());
                p051j0.a.c("TemplateInfo", "Columns: " + templatePaperPto.getColumns());
                p051j0.a.c("TemplateInfo", "ColumnMargin: " + templatePaperPto.getColumnMargin());
                p051j0.a.c("TemplateInfo", "Background: " + templatePaperPto.getBackground());
                p051j0.a.c("TemplateInfo", "BorderUrl: " + templatePaperPto.getBorderUrl());
                p051j0.a.c("TemplateInfo", "PaperType: " + templatePaperPto.getPaperType());
                p051j0.a.c("TemplateInfo", "CollectNumber: " + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getCollectNumber());
                p051j0.a.c("TemplateInfo", "TemplateIndustry: ".concat(String.valueOf(IndustryLabelFragment.this.templateIndustry)));
                String strE = p052j2.c.e(templatePto.getViews());
                p051j0.a.c("TemplateInfo", "Views: " + strE);
                HashMap map = new HashMap();
                map.put("data_template_config", p052j2.c.e(templateConfigBean));
                map.put("data_template_content", strE);
                map.put("personLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                map.put("cloudLabelId", String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100) + System.currentTimeMillis() + String.valueOf(new Random().nextInt(Videoio.CAP_PVAPI) + 100));
                map.put("columns", String.valueOf(templatePaperPto.getColumns()));
                map.put("columnMargin", String.valueOf(templatePaperPto.getColumnMargin()));
                map.put("printerLabelBgUrl", templatePaperPto.getBackground());
                map.put("printerLabelBorderUrl", templatePaperPto.getBorderUrl());
                map.put("templateId", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getBiaoqianTemplateId());
                map.put("paperType", String.valueOf(templatePaperPto.getPaperType()));
                map.put("templateIndustry", String.valueOf(IndustryLabelFragment.this.templateIndustry));
                map.put("platform", String.valueOf(IndustryLabelFragment.this.platform));
                map.put("rotate", String.valueOf(templatePaperPto.getRotate()));
                String strA = com.bumptech.glide.h.a(((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getReleaseTime(), "yyyy.MM.dd");
                map.put("labelUrl", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getCoverUrl());
                map.put("labelName", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getTemplateDescription());
                map.put("labelDate", strA);
                map.put("labelSize", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getWidth() + ProxyConfig.MATCH_ALL_SCHEMES + ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getHeight());
                map.put("collectNumber", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getCollectNumber());
                map.put("collect", ((IndustryLabelModel) IndustryLabelFragment.this.adapter.getData().get(i5)).getCollect());
                p051j0.a.c("Args", "Args: " + map.toString());
                FlutterBoostRouteOptions flutterBoostRouteOptionsBuild = new FlutterBoostRouteOptions.Builder().pageName("industr_templates_details_reviews").arguments(map).requestCode(0).build();
                IndustryLabelFragment.this.needRefreshOnResume = true;
                FlutterBoost.instance().open(flutterBoostRouteOptionsBuild);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.e
    public int layoutId() {
        return p113u.e.fragment_industry_label;
    }

    @OnClick({6093})
    public void onIndustryLabelSearchClick() {
        this.isLoadMore = false;
        this.srlFragmentIndustryLabel.r(false);
        this.pageNum = 1;
        this.industryLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentIndustryLabelSearch), Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], this.templateIndustry);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com.library.base.util.recyclerview.f fVar;
        super.onResume();
        S4.d.b().f(new p137y.d("行业模板"));
        if (!this.needRefreshOnResume || (fVar = this.adapter) == null || fVar.getData().size() <= 0) {
            return;
        }
        this.isLoadMore = false;
        this.srlFragmentIndustryLabel.r(false);
        this.pageNum = 1;
        this.industryLabelListWorker.a(this.pageNum, androidx.exifinterface.media.a.f(this.etFragmentIndustryLabelSearch), Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[1], Y.f(this.specifications) ? null : this.specifications.split(ProcessIdUtil.DEFAULT_PROCESSID)[0], this.templateIndustry);
        this.needRefreshOnResume = false;
    }

    @Override // com.library.base.frame.e
    public void refreshUI() {
    }
}
