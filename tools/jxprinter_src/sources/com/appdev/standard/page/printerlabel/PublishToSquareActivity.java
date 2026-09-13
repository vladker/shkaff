package com.appdev.standard.page.printerlabel;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.pto.TemplateElementPto;
import com.appdev.standard.model.DictModel;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PUBLISH_TO_SQUARE)
public class PublishToSquareActivity extends MvpActivity implements E.c, p009b0.a {
    private E.e bqIndustryDictWorker;
    private List<DictModel> dictModels;
    private List<String> dictStringList;

    @BindView(5068)
    EditText etPublishToSquareDescribe;
    private p009b0.c publishTemplateWorker;
    private DictModel selectDictModel;
    private TemplateElementPto templateElementPto;

    @BindView(6251)
    TextView tvPublishToSquareType;

    @BindView(6274)
    TextView tvTitle;

    @Override // E.c
    public void getBqDictFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // E.c
    public void getBqDictSuccess(List<DictModel> list) {
        p050j.w.c();
        this.dictModels = list;
        this.dictStringList = new ArrayList();
        Iterator<DictModel> it = list.iterator();
        while (it.hasNext()) {
            this.dictStringList.add(it.next().getDictLabel());
        }
        Hawk.put("industry_dict_data", list);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_239));
        E.e eVar = new E.e(this);
        this.bqIndustryDictWorker = eVar;
        addPresenter(eVar);
        p009b0.c cVar = new p009b0.c(this);
        this.publishTemplateWorker = cVar;
        addPresenter(cVar);
        List<DictModel> list = (List) Hawk.get("industry_dict_data", null);
        this.dictModels = list;
        if (list == null) {
            p050j.w.e();
            this.bqIndustryDictWorker.a();
            return;
        }
        this.dictStringList = new ArrayList();
        Iterator<DictModel> it = this.dictModels.iterator();
        while (it.hasNext()) {
            this.dictStringList.add(it.next().getDictLabel());
        }
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_publish_to_square;
    }

    public void onPublishToSquareClick(View view) {
        if (this.etPublishToSquareDescribe.getText().toString().trim().length() == 0) {
            p042h2.d.show(p113u.g.toast_50);
            return;
        }
        DictModel dictModel = this.selectDictModel;
        if (dictModel == null) {
            p042h2.d.show(p113u.g.toast_47);
            return;
        }
        this.templateElementPto.setTemplateIndustry(dictModel.getDictValue());
        this.templateElementPto.setDescription(this.etPublishToSquareDescribe.getText().toString());
        p050j.w.e();
        this.publishTemplateWorker.a(this.templateElementPto, "");
    }

    public void onPublishToSquareTypeClick(View view) {
        if (this.dictModels == null) {
            p042h2.d.show(p113u.g.toast_45);
            p050j.w.e();
            this.bqIndustryDictWorker.a();
            return;
        }
        p097r0.a aVar = new p097r0.a(this, new p109t0.a() { // from class: com.appdev.standard.page.printerlabel.PublishToSquareActivity.1
            @Override // p109t0.a
            public void onOptionsSelect(int i5, int i6, int i7, View view2) {
                PublishToSquareActivity publishToSquareActivity = PublishToSquareActivity.this;
                publishToSquareActivity.tvPublishToSquareType.setText(((DictModel) publishToSquareActivity.dictModels.get(i5)).getDictLabel());
                PublishToSquareActivity publishToSquareActivity2 = PublishToSquareActivity.this;
                publishToSquareActivity2.selectDictModel = (DictModel) publishToSquareActivity2.dictModels.get(i5);
            }
        });
        aVar.f7931a.f8190k = getString(p113u.g.text_288);
        aVar.f7931a.f8188i = getString(p113u.g.confirm);
        String string = getResources().getString(p113u.g.cancel);
        p103s0.a aVar2 = aVar.f7931a;
        aVar2.f8189j = string;
        aVar2.f8192m = 14;
        aVar2.f8191l = 14;
        p114u0.d dVarA = aVar.a();
        dVarA.f(this.dictStringList);
        dVarA.h();
    }

    @Override // p009b0.a
    public void publishTemplateFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // p009b0.a
    public void publishTemplateSuccess(String str) {
        p050j.w.c();
        p042h2.d.show(p113u.g.toast_49);
        finish();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
        super.receiveDataFromPreActivity(bundle);
        TemplateElementPto templateElementPto = (TemplateElementPto) bundle.getSerializable("TemplateElementPto");
        this.templateElementPto = templateElementPto;
        if (templateElementPto == null) {
            finish();
        }
    }
}
