package com.appdev.standard.page.mine;

import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.api.pto.FeedbackPto;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Y;
import p050j.w;
import p056k0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_FEEDBACK)
public class FeedbackActivity extends MvpActivity implements I.c, p014c0.a {
    private Context context;

    @BindView(5053)
    EditText etFeedbackFeedbackContactWay;

    @BindView(5054)
    EditText etFeedbackFeedbackContent;

    @BindView(5218)
    ImageView ivFeedbackAdvise;

    @BindView(5219)
    ImageView ivFeedbackBug;

    @BindView(5220)
    ImageView ivFeedbackFunction;

    @BindView(5221)
    ImageView ivFeedbackOther;
    private com.library.base.util.recyclerview.f quickAdapter;

    @BindView(5822)
    RecyclerView rvFeedbackFeedbackImg;

    @BindView(6085)
    TextView tvFeedbackAddImgCount;

    @BindView(6086)
    TextView tvFeedbackFeedbackContentCount;

    @BindView(6274)
    TextView tvTitle;
    private p014c0.e uploadImageWorker = null;
    private I.d feedbackWorker = null;
    private i mediaPicker = new i();
    private String feedbackType = "1";
    private int imgCount = 3;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.context = this;
        this.tvTitle.setText(p113u.g.feedback);
        I.d dVar = new I.d(this);
        dVar.d = (MineApi) Http.createApi(MineApi.class);
        this.feedbackWorker = dVar;
        addPresenter(dVar);
        p014c0.e eVar = new p014c0.e(this);
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
        this.mediaPicker.attachToActivity(this);
        this.quickAdapter = new com.library.base.util.recyclerview.f(this, p113u.e.item_feedback_img) { // from class: com.appdev.standard.page.mine.FeedbackActivity.1
            @Override // com.library.base.util.recyclerview.b
            public void convert(com.library.base.util.recyclerview.a aVar, String str) {
                final String str2;
                ImageView imageView = (ImageView) aVar.a(p113u.d.iv_item_feedback_img);
                ImageView imageView2 = (ImageView) aVar.a(p113u.d.iv_item_feedback_delete);
                if (str == null) {
                    if (FeedbackActivity.this.quickAdapter.getItemCount() != 4) {
                        imageView.setImageResource(p113u.f.ic_item_feedback_add);
                        imageView2.setVisibility(8);
                    }
                    str2 = str;
                } else {
                    str2 = str;
                    p047i2.a.loadPicture(str2, imageView, true, 2, 1, null, -1);
                    imageView2.setVisibility(0);
                }
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.appdev.standard.page.mine.FeedbackActivity.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        FeedbackActivity.this.quickAdapter.getData().remove(str2);
                        FeedbackActivity.this.quickAdapter.notifyDataSetChanged();
                        if (FeedbackActivity.this.quickAdapter.getData().contains(null)) {
                            return;
                        }
                        FeedbackActivity.this.quickAdapter.add(null);
                    }
                });
            }
        };
        this.rvFeedbackFeedbackImg.setLayoutManager(new GridLayoutManager(this, 3));
        this.rvFeedbackFeedbackImg.setAdapter(this.quickAdapter);
        this.quickAdapter.add(null);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initListener() {
        super.initListener();
        this.quickAdapter.setOnItemClickListener(new AnonymousClass2());
        this.etFeedbackFeedbackContent.addTextChangedListener(new TextWatcher() { // from class: com.appdev.standard.page.mine.FeedbackActivity.3
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
                FeedbackActivity.this.tvFeedbackFeedbackContentCount.setText(charSequence.length() + "/150");
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
            }
        });
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_feedback;
    }

    public void onFeedbackAdviseClick(View view) {
        this.ivFeedbackAdvise.setImageResource(p113u.f.ic_common_radio_button_check);
        ImageView imageView = this.ivFeedbackBug;
        int i5 = p113u.f.ic_common_radio_button_check_not;
        imageView.setImageResource(i5);
        this.ivFeedbackFunction.setImageResource(i5);
        this.ivFeedbackOther.setImageResource(i5);
        this.feedbackType = "1";
    }

    public void onFeedbackBugClick(View view) {
        ImageView imageView = this.ivFeedbackAdvise;
        int i5 = p113u.f.ic_common_radio_button_check_not;
        imageView.setImageResource(i5);
        this.ivFeedbackBug.setImageResource(p113u.f.ic_common_radio_button_check);
        this.ivFeedbackFunction.setImageResource(i5);
        this.ivFeedbackOther.setImageResource(i5);
        this.feedbackType = ExifInterface.GPS_MEASUREMENT_2D;
    }

    public void onFeedbackConfirmClick(View view) {
        w.e();
        Iterator<Object> it = this.quickAdapter.getData().iterator();
        String strO = "";
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!Y.f(str)) {
                strO = androidx.collection.a.o(strO, str, ",");
            }
        }
        I.d dVar = this.feedbackWorker;
        String string = this.etFeedbackFeedbackContactWay.getText().toString();
        String string2 = this.etFeedbackFeedbackContent.getText().toString();
        String str2 = this.feedbackType;
        if (Y.f(string)) {
            Object obj = dVar.b;
            if (obj != null) {
                ((I.c) obj).submitFeedbackFailed(1, dVar.getString(p113u.g.hint_14));
                return;
            }
            return;
        }
        if (Y.f(str2)) {
            Object obj2 = dVar.b;
            if (obj2 != null) {
                ((I.c) obj2).submitFeedbackFailed(1, dVar.getString(p113u.g.The_feedback_type_cannot_be_empty));
                return;
            }
            return;
        }
        if (!Y.f(string2)) {
            dVar.d.submitFeedback(new FeedbackPto(string, string2, str2, strO)).b(new A.c(dVar, 9));
            return;
        }
        Object obj3 = dVar.b;
        if (obj3 != null) {
            ((I.c) obj3).submitFeedbackFailed(1, dVar.getString(p113u.g.The_feedback_content_cannot_be_empty));
        }
    }

    public void onFeedbackFunctionClick(View view) {
        ImageView imageView = this.ivFeedbackAdvise;
        int i5 = p113u.f.ic_common_radio_button_check_not;
        imageView.setImageResource(i5);
        this.ivFeedbackBug.setImageResource(i5);
        this.ivFeedbackFunction.setImageResource(p113u.f.ic_common_radio_button_check);
        this.ivFeedbackOther.setImageResource(i5);
        this.feedbackType = ExifInterface.GPS_MEASUREMENT_3D;
    }

    public void onFeedbackOtherClick(View view) {
        ImageView imageView = this.ivFeedbackAdvise;
        int i5 = p113u.f.ic_common_radio_button_check_not;
        imageView.setImageResource(i5);
        this.ivFeedbackBug.setImageResource(i5);
        this.ivFeedbackFunction.setImageResource(i5);
        this.ivFeedbackOther.setImageResource(p113u.f.ic_common_radio_button_check);
        this.feedbackType = "4";
    }

    public void onMyFeedbackClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_FEEDBACK_LIST);
    }

    @Override // I.c
    public void submitFeedbackFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // I.c
    public void submitFeedbackSuccess() {
        w.c();
        p042h2.d.show(p113u.g.Feedback_success);
        finish();
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        this.quickAdapter.getData().remove((Object) null);
        if (this.quickAdapter.getItemCount() == 3) {
            p042h2.d.show(p113u.g.toast_36);
            return;
        }
        this.quickAdapter.getData().add(str);
        if (this.quickAdapter.getItemCount() < 3) {
            this.quickAdapter.add(null);
            this.tvFeedbackAddImgCount.setText(String.format("%d/3", Integer.valueOf(this.quickAdapter.getItemCount() - 1)));
        } else {
            this.tvFeedbackAddImgCount.setText(String.format("%d/3", Integer.valueOf(this.quickAdapter.getItemCount())));
            this.quickAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: renamed from: com.appdev.standard.page.mine.FeedbackActivity$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass2 implements com.library.base.util.recyclerview.e {
        public AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onItemClick$0(Uri uri) {
            if (uri != null) {
                FeedbackActivity.this.uploadImageWorker.a(uri.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String[] lambda$onItemClick$1(int i5) {
            return new String[i5];
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemClick(View view, int i5) {
            if (FeedbackActivity.this.quickAdapter.getItem(i5) == null) {
                FeedbackActivity.this.mediaPicker.pick(new a(this, 0));
            } else {
                DisplayPhotoActivity.open(FeedbackActivity.this.context, (String[]) Arrays.stream((String[]) FeedbackActivity.this.quickAdapter.getData().toArray(new String[FeedbackActivity.this.quickAdapter.getItemCount()])).filter(new b()).toArray(new c(0)), i5 + 1);
            }
        }

        @Override // com.library.base.util.recyclerview.e
        public void onItemLongClick(View view, int i5) {
        }
    }
}
