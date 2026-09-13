package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3313a;
    public final /* synthetic */ View b;

    public /* synthetic */ a(View view, int i5) {
        this.f3313a = i5;
        this.b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3313a) {
            case 0:
                this.b.requestLayout();
                break;
            default:
                ViewUtils.requestFocusAndShowKeyboard(this.b, false);
                break;
        }
    }
}
