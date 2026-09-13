package com.appdev.standard.page.printerlabel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import com.library.base.view.photoview.PhotoView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MaterialLibraryPageActivity_ViewBinding implements Unbinder {
    private MaterialLibraryPageActivity target;

    @UiThread
    public MaterialLibraryPageActivity_ViewBinding(MaterialLibraryPageActivity materialLibraryPageActivity) {
        this(materialLibraryPageActivity, materialLibraryPageActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MaterialLibraryPageActivity materialLibraryPageActivity = this.target;
        if (materialLibraryPageActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        materialLibraryPageActivity.pvMain = null;
    }

    @UiThread
    public MaterialLibraryPageActivity_ViewBinding(MaterialLibraryPageActivity materialLibraryPageActivity, View view) {
        this.target = materialLibraryPageActivity;
        materialLibraryPageActivity.pvMain = (PhotoView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.pv_main, "field 'pvMain'", PhotoView.class);
    }
}
