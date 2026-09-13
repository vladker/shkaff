package U0;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f705a;
    public final /* synthetic */ c b;
    public final /* synthetic */ RecyclerView.LayoutManager c;

    public /* synthetic */ b(c cVar, RecyclerView.LayoutManager layoutManager, int i5) {
        this.f705a = i5;
        this.b = cVar;
        this.c = layoutManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f705a) {
            case 0:
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.c;
                if (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.b.b.getItemCount()) {
                    linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                }
                break;
            default:
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) this.c;
                int spanCount = staggeredGridLayoutManager.getSpanCount();
                int[] iArr = new int[spanCount];
                staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
                if (spanCount != 0) {
                    int i5 = -1;
                    for (int i6 = 0; i6 < spanCount; i6++) {
                        int i7 = iArr[i6];
                        if (i7 > i5) {
                            i5 = i7;
                        }
                    }
                }
                this.b.b.getItemCount();
                break;
        }
    }
}
