package O0;

import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends GridLayoutManager.SpanSizeLookup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f549a;
    public final /* synthetic */ GridLayoutManager b;
    public final /* synthetic */ GridLayoutManager.SpanSizeLookup c;

    public d(e eVar, GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        this.f549a = eVar;
        this.b = gridLayoutManager;
        this.c = spanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
    public final int getSpanSize(int i5) {
        e eVar = this.f549a;
        int itemViewType = eVar.getItemViewType(i5);
        if (itemViewType == 268435729 && eVar.getHeaderViewAsFlow()) {
            return 1;
        }
        if (itemViewType == 268436275 && eVar.getFooterViewAsFlow()) {
            return 1;
        }
        e.access$getMSpanSizeLookup$p(eVar);
        return eVar.isFixedViewType(itemViewType) ? this.b.getSpanCount() : this.c.getSpanSize(i5);
    }
}
