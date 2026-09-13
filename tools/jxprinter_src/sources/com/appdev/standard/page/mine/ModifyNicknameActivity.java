package com.appdev.standard.page.mine;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.MineApi;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import java.util.HashMap;
import kotlin.jvm.internal.Y;
import p050j.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_MODIFYNICKNAME)
public class ModifyNicknameActivity extends MvpActivity implements p025e0.e {
    private p025e0.f editNickNameWorker = null;

    @BindView(5063)
    EditText mEtNickname;

    @BindView(6274)
    TextView mTvTitle;

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mTvTitle.setText(getString(p113u.g.text_227));
        this.mEtNickname.setText(p042h2.e.f4031a.e().f3961a);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        p025e0.f fVar = new p025e0.f(this);
        fVar.d = null;
        fVar.d = (MineApi) Http.createApi(MineApi.class);
        this.editNickNameWorker = fVar;
        addPresenter(fVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_modify_nickname;
    }

    public void onSaveClick(View view) {
        w.e();
        p025e0.f fVar = this.editNickNameWorker;
        String strF = androidx.exifinterface.media.a.f(this.mEtNickname);
        if (Y.f(strF)) {
            Object obj = fVar.b;
            if (obj != null) {
                ((p025e0.e) obj).updateUserInfoFailed(1, fVar.getString(p113u.g.Nicknames_cannot_be_empty));
                return;
            }
            return;
        }
        fVar.getClass();
        HashMap map = new HashMap();
        map.put("nickName", strF);
        fVar.d.updateNickname(map).b(new p009b0.b(fVar, strF, 1));
    }

    @Override // p025e0.e
    public void updateUserInfoFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p025e0.e
    public void updateUserInfoSuccess() {
        w.c();
        p042h2.d.show(p113u.g.modify_successfully);
        finish();
    }
}
