package com.appdev.standard.page.printerlabel;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.PrinterLabelApi;
import com.appdev.standard.model.MaterialLibraryTypeModel;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MATERIAL_LIBRARY)
public class MaterialLibraryActivity extends MvpActivity implements P.a {
    private p119v.e materialLibraryImageAdapter;
    private P.c materialLibraryWorker = null;

    @BindView(5819)
    RecyclerView rvData;

    @BindView(5855)
    RecyclerView rvType;

    @BindView(6274)
    TextView tvTitle;
    private p119v.g typeAdapter;

    @Override // P.a
    public void getMaterialLibraryDataFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // P.a
    public void getMaterialLibraryDataSuccess(List<String> list) {
        p050j.w.c();
        p119v.e eVar = this.materialLibraryImageAdapter;
        eVar.f8752a.clear();
        eVar.notifyDataSetChanged();
        p119v.e eVar2 = this.materialLibraryImageAdapter;
        eVar2.f8752a.addAll(list);
        eVar2.notifyDataSetChanged();
    }

    public void getMaterialLibraryTypeFailed(int i5, String str) {
        p050j.w.c();
        p042h2.d.a(str);
    }

    @Override // P.a
    public void getMaterialLibraryTypeSuccess(List<MaterialLibraryTypeModel> list) {
        p050j.w.c();
        this.typeAdapter.clear();
        this.typeAdapter.addAll(list);
        if (list == null || list.size() <= 0) {
            return;
        }
        P.c cVar = this.materialLibraryWorker;
        cVar.d.getBiaoqianImg(list.get(0).getMaterialTypeId()).b(new P.b(cVar));
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        P.c cVar = new P.c(this);
        cVar.d = null;
        cVar.d = (PrinterLabelApi) Http.createApi(PrinterLabelApi.class);
        this.materialLibraryWorker = cVar;
        addPresenter(cVar);
        this.tvTitle.setText(p113u.g.text_420);
        p119v.g gVar = new p119v.g(this, p113u.e.item_material_library_type);
        gVar.f8753a = null;
        gVar.setOnItemClickListener(new S4.h(gVar, 17));
        this.typeAdapter = gVar;
        this.rvType.setLayoutManager(new LinearLayoutManager(this));
        this.rvType.setAdapter(this.typeAdapter);
        this.rvData.setHasFixedSize(true);
        p119v.e eVar = new p119v.e();
        this.materialLibraryImageAdapter = eVar;
        this.rvData.setAdapter(eVar);
        this.rvData.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        p050j.w.e();
        P.c cVar2 = this.materialLibraryWorker;
        cVar2.d.getBiaoqianImgType().b(new A.c(cVar2, 17));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.typeAdapter.f8753a = new p119v.f() { // from class: com.appdev.standard.page.printerlabel.MaterialLibraryActivity.1
            @Override // p119v.f
            public void onSelect(long j6) {
                P.c cVar = MaterialLibraryActivity.this.materialLibraryWorker;
                cVar.d.getBiaoqianImg(j6).b(new P.b(cVar));
            }
        };
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_material_library;
    }
}
