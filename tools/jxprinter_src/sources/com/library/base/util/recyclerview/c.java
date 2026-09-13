package com.library.base.util.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3565a;

    public c(int i5) {
        this.f3565a = i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        state.getItemCount();
        if (recyclerView.getChildAdapterPosition(view) == ((LinearLayoutManager) recyclerView.getLayoutManager()).getItemCount() - 1) {
            rect.set(0, 0, 0, this.f3565a);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }
}
