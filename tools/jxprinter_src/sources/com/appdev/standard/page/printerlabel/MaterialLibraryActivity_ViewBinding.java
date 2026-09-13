package com.appdev.standard.page.printerlabel;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class MaterialLibraryActivity_ViewBinding implements Unbinder {
    private MaterialLibraryActivity target;

    @UiThread
    public MaterialLibraryActivity_ViewBinding(MaterialLibraryActivity materialLibraryActivity) {
        this(materialLibraryActivity, materialLibraryActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        MaterialLibraryActivity materialLibraryActivity = this.target;
        if (materialLibraryActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        materialLibraryActivity.tvTitle = null;
        materialLibraryActivity.rvType = null;
        materialLibraryActivity.rvData = null;
    }

    @UiThread
    public MaterialLibraryActivity_ViewBinding(MaterialLibraryActivity materialLibraryActivity, View view) {
        this.target = materialLibraryActivity;
        materialLibraryActivity.tvTitle = (TextView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.tv_title, "field 'tvTitle'", TextView.class);
        materialLibraryActivity.rvType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_type, "field 'rvType'", RecyclerView.class);
        materialLibraryActivity.rvData = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_data, "field 'rvData'", RecyclerView.class);
    }
}
