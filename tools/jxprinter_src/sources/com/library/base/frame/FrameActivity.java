package com.library.base.frame;

import android.os.Bundle;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FrameActivity extends BaseActivity {
    private boolean isRegister = false;

    @Override // com.library.base.frame.BaseActivity
    public void initComponent() {
        if (this.isRegister) {
            S4.d.b().j(this);
        }
    }

    @Override // com.library.base.frame.BaseActivity
    public int layoutId() {
        return 0;
    }

    @Override // com.library.base.frame.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.isRegister) {
            S4.d.b().m(this);
        }
    }

    public void onReturnClick(View view) {
        finish();
    }

    public void registerEventBus() {
        this.isRegister = true;
    }

    @Override // com.library.base.frame.BaseActivity
    public void activityConfigure() {
    }

    @Override // com.library.base.frame.BaseActivity
    public void initData() {
    }

    @Override // com.library.base.frame.BaseActivity
    public void initListener() {
    }

    public void onTopBarConfirmClick(View view) {
    }

    @Override // com.library.base.frame.BaseActivity
    public void receiveDataFromPreActivity(Bundle bundle) {
    }
}
