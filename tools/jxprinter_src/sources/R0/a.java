package R0;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public U0.a f584a;
    public float b;
    public float c;
    public int d;
    public int e;

    private boolean isViewCreateByAdapter(@NonNull RecyclerView.ViewHolder viewHolder) {
        int itemViewType = viewHolder.getItemViewType();
        return itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        U0.a aVar = this.f584a;
        super.clearView(recyclerView, viewHolder);
        if (isViewCreateByAdapter(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        int i5 = N0.a.BaseQuickAdapter_dragging_support;
        if (view.getTag(i5) != null && ((Boolean) viewHolder.itemView.getTag(i5)).booleanValue()) {
            if (aVar != null) {
                aVar.onItemDragEnd(viewHolder);
            }
            viewHolder.itemView.setTag(i5, Boolean.FALSE);
        }
        View view2 = viewHolder.itemView;
        int i6 = N0.a.BaseQuickAdapter_swiping_support;
        if (view2.getTag(i6) == null || !((Boolean) viewHolder.itemView.getTag(i6)).booleanValue()) {
            return;
        }
        if (aVar != null) {
            aVar.onItemSwipeClear(viewHolder);
        }
        viewHolder.itemView.setTag(i6, Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.b;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return isViewCreateByAdapter(viewHolder) ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        U0.a aVar = this.f584a;
        if (aVar != null) {
            aVar.getClass();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        U0.a aVar = this.f584a;
        if (aVar != null) {
            aVar.getClass();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float f6, float f7, int i5, boolean z6) {
        super.onChildDrawOver(canvas, recyclerView, viewHolder, f6, f7, i5, z6);
        if (i5 != 1 || isViewCreateByAdapter(viewHolder)) {
            return;
        }
        View view = viewHolder.itemView;
        canvas.save();
        if (f6 > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f6, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f6, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f6, view.getTop());
        }
        U0.a aVar = this.f584a;
        if (aVar != null) {
            aVar.onItemSwiping(canvas, viewHolder, f6, f7, z6);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder2) {
        return viewHolder.getItemViewType() == viewHolder2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onMoved(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, int i5, @NonNull RecyclerView.ViewHolder viewHolder2, int i6, int i7, int i8) {
        super.onMoved(recyclerView, viewHolder, i5, viewHolder2, i6, i7, i8);
        U0.a aVar = this.f584a;
        if (aVar != null) {
            aVar.onItemDragMoving(viewHolder, viewHolder2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i5) {
        U0.a aVar = this.f584a;
        if (i5 == 2 && !isViewCreateByAdapter(viewHolder)) {
            if (aVar != null) {
                aVar.onItemDragStart(viewHolder);
            }
            viewHolder.itemView.setTag(N0.a.BaseQuickAdapter_dragging_support, Boolean.TRUE);
        } else if (i5 == 1 && !isViewCreateByAdapter(viewHolder)) {
            if (aVar != null) {
                aVar.onItemSwipeStart(viewHolder);
            }
            viewHolder.itemView.setTag(N0.a.BaseQuickAdapter_swiping_support, Boolean.TRUE);
        }
        super.onSelectedChanged(viewHolder, i5);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i5) {
        U0.a aVar;
        if (isViewCreateByAdapter(viewHolder) || (aVar = this.f584a) == null) {
            return;
        }
        aVar.onItemSwiped(viewHolder);
    }
}
