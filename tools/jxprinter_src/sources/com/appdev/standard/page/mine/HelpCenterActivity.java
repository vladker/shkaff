package com.appdev.standard.page.mine;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.model.HelpCenterModel;
import com.library.base.frame.BaseActivity;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.library.base.widget.AutoNullDisplayView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_HELP_CENTER)
public class HelpCenterActivity extends MvpActivity implements K.a {

    @BindView(4876)
    AutoNullDisplayView audvHelpCenter;
    private Context context;

    @BindView(5060)
    EditText etHelpCenterSearchContent;
    private K.c helpCenterWorker;

    @BindView(6161)
    TextView mTvManual;

    @BindView(6278)
    TextView mTvVideos;

    @BindView(6291)
    View mVBottomLine;

    @BindView(6293)
    View mVManualLine;

    @BindView(6294)
    View mVVideosLine;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5835)
    RecyclerView rvHelpCenter;

    @BindView(5932)
    SmartRefreshLayout srlHelpCenter;

    @BindView(6274)
    TextView tvTitle;
    private final int TYPE_VIDEOS = 1;
    private final int TYPE_MANUAL = 2;
    private int pageNum = 1;
    private int type = 1;

    /* JADX INFO: Access modifiers changed from: private */
    public void addVideosData() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_330), "v_1.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_331), "v_2.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_332), "v_3.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_333), "v_4.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_334), "v_5.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_335), "v_6.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_336), "v_7.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_337), "v_8.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_338), "v_9.mp4"));
        arrayList.add(new HelpCenterModel(1, getString(p113u.g.text_339), "v_10.mp4"));
        this.quickAdapter.replaceAll(arrayList);
        this.srlHelpCenter.r(true);
    }

    private void selectTab(int i5) {
        this.type = i5;
        int color = getResources().getColor(p113u.a.color_333333);
        int color2 = getResources().getColor(p113u.a.color_FDD300);
        this.mTvVideos.setTextColor(color);
        this.mTvManual.setTextColor(color);
        this.mVVideosLine.setVisibility(4);
        this.mVManualLine.setVisibility(4);
        if (i5 == 1) {
            this.mTvVideos.setTextColor(color2);
            this.mVVideosLine.setVisibility(0);
            addVideosData();
        } else if (i5 == 2) {
            this.mTvManual.setTextColor(color2);
            this.mVManualLine.setVisibility(0);
            this.quickAdapter.clear();
            this.srlHelpCenter.h();
        }
    }

    @Override // K.a
    public void getHelpCenterListFailed(int i5, String str) {
        this.srlHelpCenter.k();
        this.srlHelpCenter.i();
        w.c();
        p042h2.d.a(str);
    }

    @Override // K.a
    public void getHelpCenterListSuccess(List<HelpCenterModel> list, int i5, int i6) {
        w.c();
        this.srlHelpCenter.k();
        this.srlHelpCenter.i();
        this.pageNum = i5;
        for (HelpCenterModel helpCenterModel : list) {
            if (helpCenterModel.getArticleType() == 1) {
                helpCenterModel.setType(2);
            } else if (helpCenterModel.getArticleType() == 2) {
                helpCenterModel.setType(3);
            }
        }
        if (i5 == 1) {
            this.quickAdapter.replaceAll(list);
        } else {
            this.quickAdapter.addAll(list);
        }
        if (i5 == i6) {
            this.srlHelpCenter.r(true);
        } else {
            this.srlHelpCenter.r(false);
        }
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.tvTitle.setText(getString(p113u.g.text_231));
        this.context = this;
        K.c cVar = new K.c(this);
        cVar.d = (MineApi) Http.createApi(MineApi.class);
        this.helpCenterWorker = cVar;
        addPresenter(cVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_help_center) { // from class: com.appdev.standard.page.mine.HelpCenterActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, HelpCenterModel helpCenterModel) {
                aVar.b(p113u.d.tv_help_center_title, helpCenterModel.getTitle());
            }
        };
        this.rvHelpCenter.setLayoutManager(new LinearLayoutManager(this));
        this.rvHelpCenter.setAdapter(this.quickAdapter);
        this.audvHelpCenter.b(p113u.f.ic_label_no_data);
        this.audvHelpCenter.setConnect(getString(p113u.g.text_282));
        this.audvHelpCenter.setButtonWhetherVisible(false);
        selectTab(1);
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.appdev.standard.page.mine.HelpCenterActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                HelpCenterActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int width = HelpCenterActivity.this.mVBottomLine.getWidth();
                int width2 = HelpCenterActivity.this.mTvVideos.getWidth();
                int width3 = HelpCenterActivity.this.mTvManual.getWidth();
                int i5 = ((width - width2) - width3) / 4;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) HelpCenterActivity.this.mTvVideos.getLayoutParams();
                layoutParams.leftMargin = i5;
                HelpCenterActivity.this.mTvVideos.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) HelpCenterActivity.this.mTvManual.getLayoutParams();
                layoutParams2.rightMargin = i5;
                HelpCenterActivity.this.mTvManual.setLayoutParams(layoutParams2);
                String str = ((BaseActivity) HelpCenterActivity.this).TAG;
                StringBuilder sbS = androidx.collection.a.s("allWidth=", width, width2, ",width1=", ",width2=");
                sbS.append(width3);
                p051j0.a.d(str, sbS.toString());
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.srlHelpCenter.s(new L2.f() { // from class: com.appdev.standard.page.mine.HelpCenterActivity.3
            @Override // L2.f, L2.d
            public void onLoadMore(@NonNull I2.f fVar) {
                if (HelpCenterActivity.this.type == 1) {
                    HelpCenterActivity.this.addVideosData();
                } else if (HelpCenterActivity.this.type == 2) {
                    HelpCenterActivity.this.helpCenterWorker.a(HelpCenterActivity.this.pageNum + 1, HelpCenterActivity.this.etHelpCenterSearchContent.getText().toString().trim());
                }
            }

            @Override // L2.f, L2.e
            public void onRefresh(@NonNull I2.f fVar) {
                if (HelpCenterActivity.this.type == 1) {
                    HelpCenterActivity.this.addVideosData();
                } else if (HelpCenterActivity.this.type == 2) {
                    HelpCenterActivity.this.helpCenterWorker.a(1, HelpCenterActivity.this.etHelpCenterSearchContent.getText().toString().trim());
                }
            }
        });
        this.quickAdapter.setOnItemClickListener(new com.library.base.util.recyclerview.e() { // from class: com.appdev.standard.page.mine.HelpCenterActivity.4
            @Override // com.library.base.util.recyclerview.e
            public void onItemClick(View view, int i5) {
                HelpCenterModel helpCenterModel = (HelpCenterModel) HelpCenterActivity.this.quickAdapter.getItem(i5);
                if (helpCenterModel.getType() == 1) {
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_VIDEO_VIEW).withString("fileName", helpCenterModel.getContent()).withString("title", helpCenterModel.getTitle()).navigation();
                } else if (helpCenterModel.getType() == 2) {
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_PDF_VIEW).withString("url", helpCenterModel.getPdfUrl()).withString("title", HelpCenterActivity.this.getString(p113u.g.fragment_mine_5)).navigation();
                } else if (helpCenterModel.getType() == 3) {
                    ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_ARTICLE_VIEW).withString("url", helpCenterModel.getContent()).withString("title", HelpCenterActivity.this.getString(p113u.g.fragment_mine_5)).navigation();
                }
            }

            @Override // com.library.base.util.recyclerview.e
            public void onItemLongClick(View view, int i5) {
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_help_center;
    }

    public void onSearchClick(View view) {
        this.srlHelpCenter.h();
    }

    @OnClick({6278, 6161})
    public void onTabClick(View view) {
        int id = view.getId();
        if (id == p113u.d.tv_videos) {
            selectTab(1);
        } else if (id == p113u.d.tv_manual) {
            selectTab(2);
        }
    }
}
