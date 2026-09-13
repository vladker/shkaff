package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.model.LanguageModel;
import com.appdev.standard.page.BootActivity;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_LANGUAGE_MANAGEMENT)
public class LanguageManagementActivity extends MvpActivity {
    private p119v.c languageManagementListAdapter = null;

    @BindView(5839)
    RecyclerView mRvLanguageManagement;

    @BindView(6274)
    TextView mTvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mTvTitle.setText(getString(p113u.g.language_management));
        this.languageManagementListAdapter = new p119v.c(this, p113u.e.item_language_management);
        this.mRvLanguageManagement.setLayoutManager(new LinearLayoutManager(this));
        this.mRvLanguageManagement.addItemDecoration(new com.library.base.util.recyclerview.d(getResources().getColor(p113u.a.transparent), dip2px(10.0f)));
        this.mRvLanguageManagement.setAdapter(this.languageManagementListAdapter);
        this.languageManagementListAdapter.replaceAll(LanguageModel.getLanguages());
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.languageManagementListAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.mine.LanguageManagementActivity.1
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                Hawk.put("current_language", ((LanguageModel) LanguageManagementActivity.this.languageManagementListAdapter.getItem(i5)).getCode());
                V1.b.h().getClass();
                V1.b.f();
                LanguageManagementActivity.this.gotoActivity(BootActivity.class, null);
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_language_management;
    }
}
