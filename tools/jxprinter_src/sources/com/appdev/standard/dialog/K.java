package com.appdev.standard.dialog;

import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.appdev.constant.DefaultRouteConstant;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class K extends p056k0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2615a;

    public /* synthetic */ K(int i5) {
        this.f2615a = i5;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f2615a) {
            case 0:
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 1).navigation();
                break;
            default:
                ARouter.getInstance().build(DefaultRouteConstant.ACTIVITY_AGREEMENT).withInt("type", 2).navigation();
                break;
        }
    }
}
