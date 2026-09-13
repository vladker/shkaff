package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class PhotoPrintActivity_ViewBinding implements Unbinder {
    private PhotoPrintActivity target;

    @UiThread
    public PhotoPrintActivity_ViewBinding(PhotoPrintActivity photoPrintActivity) {
        this(photoPrintActivity, photoPrintActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        PhotoPrintActivity photoPrintActivity = this.target;
        if (photoPrintActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        photoPrintActivity.tvTitle = null;
    }

    @UiThread
    public PhotoPrintActivity_ViewBinding(PhotoPrintActivity photoPrintActivity, View view) {
        this.target = photoPrintActivity;
        photoPrintActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
    }
}
