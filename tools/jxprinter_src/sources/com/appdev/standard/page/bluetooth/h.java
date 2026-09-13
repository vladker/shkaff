package com.appdev.standard.page.bluetooth;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.appdev.standard.page.index.IndexFragment;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2686a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ h(Object obj, Object obj2, int i5) {
        this.f2686a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2686a) {
            case 0:
                PrintSetting.lambda$handleLogic$0((LinearLayout) this.b, (ImageView) this.c, view);
                break;
            case 1:
                ((IndexFragment) this.b).lambda$getAppBannerSuccess$4((List) this.c, view);
                break;
            default:
                ((Snackbar) this.b).lambda$setAction$0((View.OnClickListener) this.c, view);
                break;
        }
    }
}
