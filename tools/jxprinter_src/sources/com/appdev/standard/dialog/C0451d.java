package com.appdev.standard.dialog;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: com.appdev.standard.dialog.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class C0451d implements PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2640a;
    public int b;
    public int c;
    public boolean d;
    public View e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PopupWindow f2641f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Window f2642g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2643h;

    public final void a() {
        Window window = this.f2642g;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.f2642g.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.f2641f;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.f2641f.dismiss();
    }

    public final void b(View view) {
        PopupWindow popupWindow = this.f2641f;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, 80, 0, 0);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        a();
    }

    @RequiresApi(api = 19)
    public C0451d showAsDropDown(View view, int i5, int i6, int i7) {
        PopupWindow popupWindow = this.f2641f;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view, i5, i6, i7);
        }
        return this;
    }
}
