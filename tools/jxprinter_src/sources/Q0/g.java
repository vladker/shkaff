package Q0;

import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements ListUpdateCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O0.e f573a;

    public g(O0.e mAdapter) {
        E.g(mAdapter, "mAdapter");
        this.f573a = mAdapter;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void onChanged(int i5, int i6, Object obj) {
        O0.e eVar = this.f573a;
        eVar.notifyItemRangeChanged(eVar.getHeaderLayoutCount() + i5, i6, obj);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int i5, int i6) {
        O0.e eVar = this.f573a;
        eVar.notifyItemRangeInserted(eVar.getHeaderLayoutCount() + i5, i6);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(int i5, int i6) {
        O0.e eVar = this.f573a;
        eVar.notifyItemMoved(eVar.getHeaderLayoutCount() + i5, eVar.getHeaderLayoutCount() + i6);
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int i5, int i6) {
        O0.e eVar = this.f573a;
        eVar.getMLoadMoreModule$com_github_CymChad_brvah();
        eVar.notifyItemRangeRemoved(eVar.getHeaderLayoutCount() + i5, i6);
    }
}
