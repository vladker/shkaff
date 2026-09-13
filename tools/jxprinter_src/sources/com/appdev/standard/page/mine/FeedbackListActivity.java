package com.appdev.standard.page.mine;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.model.FeedbackDetailModel;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Y;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_FEEDBACK_LIST)
public class FeedbackListActivity extends MvpActivity implements I.a {
    private Context context;
    private I.b feedbackListWorker;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5823)
    RecyclerView rvFeedbackList;

    @BindView(6274)
    TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void bindImgRecycler(RecyclerView recyclerView, String str) {
        com.library.base.util.recyclerview.f fVar = new com.library.base.util.recyclerview.f(this.context, p113u.e.item_feedback_img) { // from class: com.appdev.standard.page.mine.FeedbackListActivity.2
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, String str2) {
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_feedback_img);
                aVar.a(p113u.d.iv_item_feedback_delete).setVisibility(8);
                p047i2.a.loadPicture(str2, imageView, true, 2, 1, null, -1);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(this.context, 3));
        recyclerView.setAdapter(fVar);
        if (Y.f(str)) {
            recyclerView.setVisibility(8);
            return;
        }
        recyclerView.setVisibility(0);
        for (String str2 : str.replace("，", ",").split(",")) {
            if (!Y.f(str2)) {
                fVar.add(str2);
            }
        }
        if (fVar.getData().isEmpty()) {
            recyclerView.setVisibility(8);
        } else {
            fVar.setOnItemClickListener(new AnonymousClass3(fVar));
        }
    }

    @Override // I.a
    public void feedBackListFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // I.a
    public void feedBackListSuccess(List<FeedbackDetailModel> list) {
        w.c();
        this.quickAdapter.replaceAll(list);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.context = this;
        this.tvTitle.setText(getString(p113u.g.text_19));
        I.b bVar = new I.b(this);
        bVar.d = (MineApi) Http.createApi(MineApi.class);
        this.feedbackListWorker = bVar;
        addPresenter(bVar);
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_feedback_detail) { // from class: com.appdev.standard.page.mine.FeedbackListActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, FeedbackDetailModel feedbackDetailModel) {
                aVar.b(p113u.d.tv_item_feedback_detail_name_time, feedbackDetailModel.getNickName() + "  " + feedbackDetailModel.getCreateTime());
                aVar.b(p113u.d.tv_item_feedback_detail_content, feedbackDetailModel.getFeedbackContent());
                FeedbackListActivity.this.bindImgRecycler((RecyclerView) aVar.a(p113u.d.rv_item_feedback_detail_img), feedbackDetailModel.getImgUrls());
                TextView textView = (TextView) aVar.a(p113u.d.tv_item_feedback_detail_reply);
                RecyclerView recyclerView = (RecyclerView) aVar.a(p113u.d.rv_item_feedback_detail_reply_img);
                if (Y.f(feedbackDetailModel.getReplyContent())) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(FeedbackListActivity.this.getString(p113u.g.feedback_reply_prefix, feedbackDetailModel.getReplyContent()));
                }
                if (Y.f(feedbackDetailModel.getReplyUrls())) {
                    recyclerView.setVisibility(8);
                } else {
                    recyclerView.setVisibility(0);
                    FeedbackListActivity.this.bindImgRecycler(recyclerView, feedbackDetailModel.getReplyUrls());
                }
            }
        };
        this.rvFeedbackList.setLayoutManager(new LinearLayoutManager(this));
        this.rvFeedbackList.setAdapter(this.quickAdapter);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        w.e();
        I.b bVar = this.feedbackListWorker;
        bVar.d.feedBackList().b(new A.c(bVar, 8));
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_feedback_list;
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.mine.FeedbackListActivity$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass3 implements com.library.base.util.recyclerview.e {
        final /* synthetic */ com.library.base.util.recyclerview.f val$imgQuickAdapter;

        public AnonymousClass3(com.library.base.util.recyclerview.f fVar) {
            this.val$imgQuickAdapter = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String[] lambda$onItemClick$0(int i5) {
            return new String[i5];
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemClick(View view, int i5) {
            DisplayPhotoActivity.open(FeedbackListActivity.this.context, (String[]) Arrays.stream((String[]) this.val$imgQuickAdapter.getData().toArray(new String[0])).filter(new b()).toArray(new c(1)), i5 + 1);
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemLongClick(View view, int i5) {
        }
    }
}
