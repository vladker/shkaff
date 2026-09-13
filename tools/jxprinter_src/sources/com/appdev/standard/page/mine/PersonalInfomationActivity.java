package com.appdev.standard.page.mine;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.TextUtils;
import com.appdev.constant.DefaultRouteConstant;
import com.appdev.standard.api.AuthorityApi;
import com.appdev.standard.api.MineApi;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.dialog.InterfaceC0468v;
import com.appdev.standard.dialog.LogoffTipDialog;
import com.library.base.frame.MvpActivity;
import com.library.base.util.http.Http;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.internal.Y;
import p050j.w;
import p056k0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Route(path = DefaultRouteConstant.ACTIVITY_PERSONALINFOMATION)
public class PersonalInfomationActivity extends MvpActivity implements p014c0.a, p025e0.c, N.a, O.a {
    private static final String KEY_CURRENT_STORE = "current_store";
    private static final String KEY_HAS_UPDATE = "has_update";
    private static final String KEY_LAST_CHECK_TIME = "last_check_time";
    private static final String KEY_LATEST_VERSION = "latest_version";
    private static final long ONE_DAY_MILLIS = 86400000;
    private static final String PREF_UPDATE_CHECK = "update_check_prefs";
    private String avatarUrl;
    private Context context;

    @BindView(5430)
    LinearLayout llPersonalInformationEmail;

    @BindView(5431)
    LinearLayout llPersonalInformationPhone;

    @BindView(5197)
    ImageView mIvAvatar;

    @BindView(6082)
    TextView mTtvEmailAddress;

    @BindView(6176)
    TextView mTvNickname;

    @BindView(6182)
    TextView mTvPhoneNumber;

    @BindView(6274)
    TextView mTvTitle;

    @BindView(6042)
    TextView tvCacheSize;

    @BindView(6277)
    TextView tvVersion;
    private View updateRedDot;
    private p025e0.d editAvatarWorker = null;
    private p014c0.e uploadImageWorker = null;
    private N.c logoffWorker = null;
    private O.c logoutWorker = null;
    private i mediaPicker = new i();
    private boolean hasUpdateAvailable = false;
    private String latestVersion = "";
    private String currentStore = "";

    /* JADX INFO: renamed from: com.appdev.standard.page.mine.PersonalInfomationActivity$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class AnonymousClass4 implements p125w.d {
        public AnonymousClass4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCheckError$3() {
            TextView textView = (TextView) PersonalInfomationActivity.this.findViewById(p113u.d.tv_app_update);
            if (textView != null) {
                textView.setText(p113u.g.text_532);
                PersonalInfomationActivity.this.hideUpdateRedDot();
            }
            p042h2.d.show(p113u.g.Check_update_failed_please_try_again_later);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNoStoreInstalled$2() {
            TextView textView = (TextView) PersonalInfomationActivity.this.findViewById(p113u.d.tv_app_update);
            if (textView != null) {
                textView.setText(p113u.g.text_532);
                PersonalInfomationActivity.this.hideUpdateRedDot();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onNoUpdateAvailable$1() {
            TextView textView = (TextView) PersonalInfomationActivity.this.findViewById(p113u.d.tv_app_update);
            if (textView != null) {
                textView.setText(p113u.g.text_532);
                PersonalInfomationActivity.this.hideUpdateRedDot();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onUpdateAvailable$0() {
            TextView textView = (TextView) PersonalInfomationActivity.this.findViewById(p113u.d.tv_app_update);
            if (textView != null) {
                textView.setText(p113u.g.text_517);
                PersonalInfomationActivity.this.showUpdateRedDot();
            }
        }

        public void onCheckError(String str) {
            PersonalInfomationActivity.this.hasUpdateAvailable = false;
            Hawk.put(PersonalInfomationActivity.KEY_LAST_CHECK_TIME, Long.valueOf(System.currentTimeMillis()));
            PersonalInfomationActivity.this.runOnUiThread(new h(this, 0));
        }

        @Override // p125w.d
        public void onNoStoreInstalled() {
            PersonalInfomationActivity.this.hasUpdateAvailable = false;
            Hawk.put(PersonalInfomationActivity.KEY_LAST_CHECK_TIME, Long.valueOf(System.currentTimeMillis()));
            Hawk.put(PersonalInfomationActivity.KEY_HAS_UPDATE, Boolean.FALSE);
            Hawk.put(PersonalInfomationActivity.KEY_LATEST_VERSION, "");
            PersonalInfomationActivity.this.runOnUiThread(new h(this, 1));
        }

        @Override // p125w.d
        public void onNoUpdateAvailable() {
            PersonalInfomationActivity.this.hasUpdateAvailable = false;
            Hawk.put(PersonalInfomationActivity.KEY_LAST_CHECK_TIME, Long.valueOf(System.currentTimeMillis()));
            Hawk.put(PersonalInfomationActivity.KEY_HAS_UPDATE, Boolean.FALSE);
            Hawk.put(PersonalInfomationActivity.KEY_LATEST_VERSION, "");
            PersonalInfomationActivity.this.runOnUiThread(new h(this, 3));
        }

        @Override // p125w.d
        public void onStoreDetected(String str) {
            PersonalInfomationActivity.this.currentStore = str;
            Hawk.put(PersonalInfomationActivity.KEY_CURRENT_STORE, str);
        }

        @Override // p125w.d
        public void onUpdateAvailable(String str, String str2) {
            PersonalInfomationActivity.this.hasUpdateAvailable = true;
            PersonalInfomationActivity.this.latestVersion = str2;
            Hawk.put(PersonalInfomationActivity.KEY_LAST_CHECK_TIME, Long.valueOf(System.currentTimeMillis()));
            Hawk.put(PersonalInfomationActivity.KEY_HAS_UPDATE, Boolean.TRUE);
            Hawk.put(PersonalInfomationActivity.KEY_LATEST_VERSION, str2);
            PersonalInfomationActivity.this.runOnUiThread(new h(this, 2));
        }
    }

    private void checkAppUpdate() {
        long jLongValue = ((Long) Hawk.get(KEY_LAST_CHECK_TIME, 0L)).longValue();
        boolean zBooleanValue = ((Boolean) Hawk.get(KEY_HAS_UPDATE, Boolean.FALSE)).booleanValue();
        String str = (String) Hawk.get(KEY_LATEST_VERSION, "");
        String str2 = (String) Hawk.get(KEY_CURRENT_STORE, "");
        if (System.currentTimeMillis() - jLongValue >= 86400000) {
            p125w.f.checkUpdate(this, new AnonymousClass4());
            return;
        }
        this.hasUpdateAvailable = zBooleanValue;
        this.latestVersion = str;
        this.currentStore = str2;
        runOnUiThread(new g(this, 1));
    }

    public static void deleteFilesInDirectory(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                deleteFilesInDirectory(file2);
                file2.delete();
            } else {
                file2.delete();
            }
        }
    }

    private int dpToPx(int i5) {
        return Math.round(i5 * getResources().getDisplayMetrics().density);
    }

    public static long getDirectorySize(File file) {
        File[] fileArrListFiles;
        long directorySize = 0;
        if (file != null && file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                directorySize = (file2.isDirectory() ? getDirectorySize(file2) : file2.length()) + directorySize;
            }
        }
        return directorySize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideUpdateRedDot() {
        View view = this.updateRedDot;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkAppUpdate$1() {
        TextView textView = (TextView) findViewById(p113u.d.tv_app_update);
        if (textView != null) {
            if (this.hasUpdateAvailable) {
                textView.setText(p113u.g.text_517);
            } else {
                textView.setText(p113u.g.text_532);
            }
            if (this.hasUpdateAvailable) {
                showUpdateRedDot();
            } else {
                hideUpdateRedDot();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onModifyAvatarClick$0(Uri uri) {
        if (uri == null) {
            return;
        }
        w.e();
        this.uploadImageWorker.a(uri.toString());
    }

    private void refreshUserInfo() {
        S4.h hVar = p042h2.e.f4031a;
        if (hVar.g()) {
            p032f2.a aVarE = hVar.e();
            this.mTvNickname.setText(aVarE.f3961a);
            String str = aVarE.d;
            if (str.contains("@")) {
                this.llPersonalInformationPhone.setVisibility(8);
                this.llPersonalInformationEmail.setVisibility(0);
                this.mTtvEmailAddress.setText(str);
            } else {
                this.llPersonalInformationPhone.setVisibility(0);
                this.llPersonalInformationEmail.setVisibility(8);
                if (Y.f(str) || str.length() <= 7 || str.length() >= 15) {
                    this.mTvPhoneNumber.setText(getString(p113u.g.unbind_phone_number));
                } else {
                    this.mTvPhoneNumber.setText(str.substring(0, 3) + "****" + str.substring(7));
                }
            }
            p047i2.a.loadCirclePicture(aVarE.b, this.mIvAvatar, p113u.f.ic_default_avatar);
        }
    }

    private void showLatestVersionDialog(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(p113u.e.dialog_latest_version, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(p113u.d.confirm_version_button);
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(viewInflate).create();
        textView.setOnClickListener(new f(alertDialogCreate, 1));
        alertDialogCreate.show();
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUpdateRedDot() {
        if (this.updateRedDot == null) {
            View view = new View(this);
            this.updateRedDot = view;
            view.setBackgroundResource(p113u.c.red_dot);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dpToPx(6), dpToPx(6));
            layoutParams.setMargins(dpToPx(4), 0, 0, 0);
            this.updateRedDot.setLayoutParams(layoutParams);
            LinearLayout linearLayout = (LinearLayout) findViewById(p113u.d.ll_update_status);
            if (linearLayout != null) {
                linearLayout.addView(this.updateRedDot, 1);
            }
        }
        this.updateRedDot.setVisibility(0);
    }

    @Override // com.library.base.frame.MvpActivity, com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initComponent() {
        p025e0.d dVar = new p025e0.d(this);
        dVar.d = null;
        dVar.d = (MineApi) Http.createApi(MineApi.class);
        this.editAvatarWorker = dVar;
        addPresenter(dVar);
        p014c0.e eVar = new p014c0.e(this);
        this.uploadImageWorker = eVar;
        addPresenter(eVar);
        O.c cVar = new O.c(this);
        cVar.d = null;
        cVar.d = (AuthorityApi) Http.createApi(AuthorityApi.class);
        this.logoutWorker = cVar;
        addPresenter(cVar);
        N.c cVar2 = new N.c(this);
        cVar2.d = null;
        cVar2.d = (AuthorityApi) Http.createApi(AuthorityApi.class);
        this.logoffWorker = cVar2;
        addPresenter(cVar2);
        super.initComponent();
        this.mediaPicker.attachToActivity(this);
        this.mTvTitle.setText(getString(p113u.g.personal_information));
        if (p051j0.a.f5394a != 9) {
            this.tvVersion.setText(String.format(getString(p113u.g.text_279), "T1.1.8.102"));
        } else {
            this.tvVersion.setText(String.format(getString(p113u.g.text_279), "1.1.8.102"));
        }
        refreshCacheSize();
        checkAppUpdate();
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public void initData() {
        super.initData();
        this.context = this;
    }

    @Override // com.library.base.frame.FrameActivity, com.library.base.frame.BaseActivity
    public int layoutId() {
        return p113u.e.activity_personal_infomation;
    }

    @Override // N.a
    public void logoffFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // N.a
    public void logoffSuccess() {
        w.c();
        p042h2.e.f4031a.i();
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
        finishActivity();
    }

    @Override // O.a
    public void logoutFailed(int i5, String str) {
        w.c();
        p042h2.e.f4031a.i();
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
        finishActivity();
    }

    @Override // O.a
    public void logoutSuccess() {
        w.c();
        p042h2.e.f4031a.i();
        ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_LOGIN).navigation();
        finishActivity();
    }

    public void onAppUpdate(View view) {
        if (!this.hasUpdateAvailable) {
            showLatestVersionDialog(this.context);
        } else if (TextUtils.isEmpty(this.currentStore)) {
            p125w.f.i(this);
        } else {
            p125w.f.h(this, this.currentStore);
        }
    }

    public void onChangePassword(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CHANGEPASSWORD);
    }

    public void onClearCache(View view) {
        DefaultTipDialog defaultTipDialog = new DefaultTipDialog(this);
        defaultTipDialog.e(getString(p113u.g.text_470));
        defaultTipDialog.c(getString(p113u.g.text_471));
        defaultTipDialog.f2608a = new com.bumptech.glide.f() { // from class: com.appdev.standard.page.mine.PersonalInfomationActivity.3
            @Override // com.library.base.frame.d
            public void onConfirm() {
                w.e();
                PersonalInfomationActivity.this.runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.mine.PersonalInfomationActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Hawk.delete("verified_printer");
                        PersonalInfomationActivity.deleteFilesInDirectory(PersonalInfomationActivity.this.getExternalCacheDir());
                        PersonalInfomationActivity.deleteFilesInDirectory(PersonalInfomationActivity.this.getCacheDir());
                        PersonalInfomationActivity.this.refreshCacheSize();
                        w.c();
                    }
                });
            }

            @Override // com.library.base.frame.d
            public void onCancel() {
            }
        };
        defaultTipDialog.show();
    }

    public void onLogOffClick(View view) {
        LogoffTipDialog logoffTipDialog = new LogoffTipDialog(this);
        logoffTipDialog.f2617a = new InterfaceC0468v() { // from class: com.appdev.standard.page.mine.PersonalInfomationActivity.2
            @Override // com.appdev.standard.dialog.InterfaceC0468v
            public void onConfirm() {
                w.e();
                N.c cVar = PersonalInfomationActivity.this.logoffWorker;
                cVar.d.logOff().b(new N.b(cVar));
            }

            @Override // com.appdev.standard.dialog.InterfaceC0468v
            public void onCancel() {
            }
        };
        logoffTipDialog.show();
    }

    public void onLogOutClick(View view) {
        w.e();
        O.c cVar = this.logoutWorker;
        cVar.d.logOut().b(new O.b(cVar));
    }

    public void onModifyAvatarClick(View view) {
        this.mediaPicker.pick(new a(this, 1));
    }

    public void onModifyEmailClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CHANGE_USERNAME_EMAIL);
    }

    public void onModifyNickNameClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_MODIFYNICKNAME);
    }

    public void onModifyUsernameClick(View view) {
        androidx.exifinterface.media.a.x(DefaultRouteConstant.ACTIVITY_CHANGE_USERNAME_PHONE);
    }

    @Override // com.library.base.frame.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        refreshUserInfo();
    }

    public void refreshCacheSize() {
        runOnNewThread(new Runnable() { // from class: com.appdev.standard.page.mine.PersonalInfomationActivity.1
            @Override // java.lang.Runnable
            public void run() {
                long directorySize = PersonalInfomationActivity.getDirectorySize(PersonalInfomationActivity.this.getCacheDir()) + PersonalInfomationActivity.getDirectorySize(PersonalInfomationActivity.this.getExternalCacheDir());
                final String str = directorySize < 1073741824 ? String.format("%.2fMB", Double.valueOf((directorySize / 1024.0d) / 1024.0d)) : String.format("%.2fGB", Double.valueOf(((directorySize / 1024.0d) / 1024.0d) / 1024.0d));
                PersonalInfomationActivity.this.runOnUiThread(new Runnable() { // from class: com.appdev.standard.page.mine.PersonalInfomationActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PersonalInfomationActivity.this.tvCacheSize.setText(str);
                    }
                });
            }
        });
    }

    @Override // p025e0.c
    public void updateAvatarFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p025e0.c
    public void updateAvatarSuccess() {
        w.c();
        p042h2.d.show(p113u.g.modify_successfully);
        S4.h hVar = p042h2.e.f4031a;
        String str = this.avatarUrl;
        p032f2.a aVar = (p032f2.a) Hawk.get("user_util_user_data", null);
        hVar.b = aVar;
        if (aVar != null) {
            aVar.b = str;
            Hawk.put("user_util_user_data", aVar);
        }
        refreshUserInfo();
    }

    @Override // p014c0.a
    public void uploadImageFailed(int i5, String str) {
        w.c();
        p042h2.d.a(str);
    }

    @Override // p014c0.a
    public void uploadImageSuccess(String str, String str2) {
        this.avatarUrl = str;
        p025e0.d dVar = this.editAvatarWorker;
        dVar.getClass();
        HashMap map = new HashMap();
        map.put("avatar", str);
        dVar.d.updateAvatar(map).b(new p020d0.d(dVar, 3));
    }
}
