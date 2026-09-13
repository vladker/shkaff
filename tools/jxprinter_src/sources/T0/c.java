package T0;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    @Override // T0.a
    public View getLoadComplete(BaseViewHolder holder) {
        E.g(holder, "holder");
        return holder.getView(N0.a.load_more_load_complete_view);
    }

    @Override // T0.a
    public View getLoadEndView(BaseViewHolder holder) {
        E.g(holder, "holder");
        return holder.getView(N0.a.load_more_load_end_view);
    }

    @Override // T0.a
    public View getLoadFailView(BaseViewHolder holder) {
        E.g(holder, "holder");
        return holder.getView(N0.a.load_more_load_fail_view);
    }

    @Override // T0.a
    public View getLoadingView(BaseViewHolder holder) {
        E.g(holder, "holder");
        return holder.getView(N0.a.load_more_loading_view);
    }

    @Override // T0.a
    public View getRootView(ViewGroup parent) {
        E.g(parent, "parent");
        return V0.a.getItemView(parent, N0.b.brvah_quick_view_load_more);
    }
}
