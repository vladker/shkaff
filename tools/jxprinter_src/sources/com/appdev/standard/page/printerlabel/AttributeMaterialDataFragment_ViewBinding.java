package com.appdev.standard.page.printerlabel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AttributeMaterialDataFragment_ViewBinding implements Unbinder {
    private AttributeMaterialDataFragment target;

    @UiThread
    public AttributeMaterialDataFragment_ViewBinding(AttributeMaterialDataFragment attributeMaterialDataFragment, View view) {
        this.target = attributeMaterialDataFragment;
        attributeMaterialDataFragment.rvMaterialType = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_material_type, "field 'rvMaterialType'", RecyclerView.class);
        attributeMaterialDataFragment.rvMaterialContent = (RecyclerView) butterknife.internal.d.findRequiredViewAsType(view, p113u.d.rv_material_content, "field 'rvMaterialContent'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        AttributeMaterialDataFragment attributeMaterialDataFragment = this.target;
        if (attributeMaterialDataFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attributeMaterialDataFragment.rvMaterialType = null;
        attributeMaterialDataFragment.rvMaterialContent = null;
    }
}
