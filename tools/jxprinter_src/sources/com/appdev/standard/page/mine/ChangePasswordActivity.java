package com.appdev.standard.page.mine;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
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
import p051j0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_CHANGEPASSWORD)
public class ChangePasswordActivity extends MvpActivity implements C.a {

    @BindView(5892)
    ImageButton btnShowConfirmPassword;

    @BindView(5893)
    ImageButton btnShowNewPassword;

    @BindView(5894)
    ImageButton btnShowPassword;

    @BindView(5064)
    EditText mEtOldPassword;

    @BindView(5065)
    EditText mEtPassword;

    @BindView(5066)
    EditText mEtPasswordAgain;

    @BindView(6274)
    TextView mTvTitle;
    boolean showPassword = false;
    boolean showConfirmPassword = false;
    boolean showNewPassword = false;
    private C.b changePasswordWorker = null;

    @Override // C.a
    public void changePasswordFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // C.a
    public void changePasswordSuccess() {
        w.c();
        p042h2.d.show(p113u.g.Password_changed_successfully);
        finish();
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        super.initComponent();
        this.mTvTitle.setText(p113u.g.change_password);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        C.b bVar = new C.b(this);
        bVar.d = null;
        bVar.d = (MineApi) Http.createApi(MineApi.class);
        this.changePasswordWorker = bVar;
        addPresenter(bVar);
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_change_password;
    }

    public void onForgetPasswordClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_RESETPASSWORD);
    }

    public void onSaveClick(View view) {
        Object obj;
        w.e();
        C.b bVar = this.changePasswordWorker;
        String strF = androidx.exifinterface.media.a.f(this.mEtOldPassword);
        String strF2 = androidx.exifinterface.media.a.f(this.mEtPassword);
        String strF3 = androidx.exifinterface.media.a.f(this.mEtPasswordAgain);
        if (Y.f(strF)) {
            Object obj2 = bVar.b;
            if (obj2 != null) {
                ((C.a) obj2).changePasswordFailed(1, bVar.getString(p113u.g.Old_passwords_cannot_be_empty));
                return;
            }
            return;
        }
        if (Y.f(strF2)) {
            Object obj3 = bVar.b;
            if (obj3 != null) {
                ((C.a) obj3).changePasswordFailed(1, bVar.getString(p113u.g.The_new_password_cannot_be_empty));
                return;
            }
            return;
        }
        bVar.getClass();
        if (!strF2.equals(strF3) && (obj = bVar.b) != null) {
            ((C.a) obj).changePasswordFailed(1, bVar.getString(p113u.g.Two_different_passwords));
        }
        HashMap map = new HashMap();
        if (!Y.f(strF)) {
            map.put("oldPassword", i.b(strF));
        }
        map.put("newPassword", i.b(strF2));
        bVar.d.updatePassword(map).b(new A.c(bVar, 3));
    }

    public void onShowConfirmPassword(View view) {
        if (this.showConfirmPassword) {
            this.mEtPasswordAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowConfirmPassword.setImageResource(p113u.f.ic_show_passwd);
        } else {
            this.mEtPasswordAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowConfirmPassword.setImageResource(p113u.f.ic_hide_passwd);
        }
        this.showConfirmPassword = !this.showConfirmPassword;
        EditText editText = this.mEtPasswordAgain;
        editText.setSelection(editText.getText().length());
    }

    public void onShowNewPassword(View view) {
        if (this.showNewPassword) {
            this.mEtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowNewPassword.setImageResource(p113u.f.ic_show_passwd);
        } else {
            this.mEtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowNewPassword.setImageResource(p113u.f.ic_hide_passwd);
        }
        this.showNewPassword = !this.showNewPassword;
        EditText editText = this.mEtPassword;
        editText.setSelection(editText.getText().length());
    }

    public void onShowPassword(View view) {
        if (this.showPassword) {
            this.mEtOldPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(p113u.f.ic_show_passwd);
        } else {
            this.mEtOldPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.btnShowPassword.setImageResource(p113u.f.ic_hide_passwd);
        }
        this.showPassword = !this.showPassword;
        EditText editText = this.mEtOldPassword;
        editText.setSelection(editText.getText().length());
    }
}
