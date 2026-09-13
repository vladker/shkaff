package U0;

import S0.k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class c implements S0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f706a;
    public final O0.e b;
    private T0.b loadMoreStatus;
    private T0.a loadMoreView;

    public c(O0.e baseQuickAdapter) {
        E.g(baseQuickAdapter, "baseQuickAdapter");
        this.b = baseQuickAdapter;
        this.loadMoreStatus = T0.b.f700a;
        this.loadMoreView = e.getDefLoadMoreView();
        this.f706a = true;
    }

    public final void a() {
        RecyclerView mRecyclerView$com_github_CymChad_brvah;
        RecyclerView.LayoutManager layoutManager;
        if (this.f706a || (mRecyclerView$com_github_CymChad_brvah = this.b.getMRecyclerView$com_github_CymChad_brvah()) == null || (layoutManager = mRecyclerView$com_github_CymChad_brvah.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            mRecyclerView$com_github_CymChad_brvah.postDelayed(new b(this, layoutManager, 0), 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            mRecyclerView$com_github_CymChad_brvah.postDelayed(new b(this, layoutManager, 1), 50L);
        }
    }

    public final void b() {
        int footerLayoutCount;
        T0.b bVar = this.loadMoreStatus;
        T0.b bVar2 = T0.b.b;
        if (bVar == bVar2) {
            return;
        }
        this.loadMoreStatus = bVar2;
        O0.e eVar = this.b;
        if (eVar.hasEmptyView()) {
            footerLayoutCount = -1;
        } else {
            footerLayoutCount = eVar.getFooterLayoutCount() + eVar.getData().size() + eVar.getHeaderLayoutCount();
        }
        eVar.notifyItemChanged(footerLayoutCount);
        this.loadMoreStatus = bVar2;
        RecyclerView mRecyclerView$com_github_CymChad_brvah = eVar.getMRecyclerView$com_github_CymChad_brvah();
        if (mRecyclerView$com_github_CymChad_brvah != null) {
            mRecyclerView$com_github_CymChad_brvah.post(new H2.c(this, 4));
        }
    }

    public final T0.b getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    public final T0.a getLoadMoreView() {
        return this.loadMoreView;
    }

    public final void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public final void setLoadMoreView(T0.a aVar) {
        E.g(aVar, "<set-?>");
        this.loadMoreView = aVar;
    }

    public final void setupViewHolder$com_github_CymChad_brvah(BaseViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new C5.c(this, 2));
    }

    public final void loadMoreEnd(boolean z6) {
    }

    @Override // S0.d
    public void setOnLoadMoreListener(k kVar) {
    }
}
