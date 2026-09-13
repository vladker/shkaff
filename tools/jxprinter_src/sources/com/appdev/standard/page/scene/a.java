package com.appdev.standard.page.scene;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2828a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ a(int i5, Object obj, boolean z6) {
        this.f2828a = i5;
        this.c = obj;
        this.b = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2828a) {
            case 0:
                ((CloudSpaceCloudLabelFragment) this.c).lambda$setAllItemsSelected$0(this.b);
                break;
            default:
                ViewUtils.showKeyboard((View) this.c, this.b);
                break;
        }
    }
}
