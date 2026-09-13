package U0;

import S0.h;
import S0.j;
import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Collections;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class a implements S0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final O0.e f704a;
    public ItemTouchHelper itemTouchHelper;
    public R0.a itemTouchHelperCallback;
    private h mOnItemDragListener;
    private j mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;

    public a(O0.e baseQuickAdapter) {
        E.g(baseQuickAdapter, "baseQuickAdapter");
        this.f704a = baseQuickAdapter;
        R0.a aVar = new R0.a();
        aVar.b = 0.1f;
        aVar.c = 0.7f;
        aVar.d = 15;
        aVar.e = 32;
        aVar.f584a = this;
        this.itemTouchHelperCallback = aVar;
        this.itemTouchHelper = new ItemTouchHelper(aVar);
    }

    public final boolean a(int i5) {
        return i5 >= 0 && i5 < this.f704a.getData().size();
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        E.g(recyclerView, "recyclerView");
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(recyclerView);
        } else {
            E.m("itemTouchHelper");
            throw null;
        }
    }

    public final ItemTouchHelper getItemTouchHelper() {
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null) {
            return itemTouchHelper;
        }
        E.m("itemTouchHelper");
        throw null;
    }

    public final R0.a getItemTouchHelperCallback() {
        R0.a aVar = this.itemTouchHelperCallback;
        if (aVar != null) {
            return aVar;
        }
        E.m("itemTouchHelperCallback");
        throw null;
    }

    public final h getMOnItemDragListener() {
        return null;
    }

    public final j getMOnItemSwipeListener() {
        return null;
    }

    public final View.OnLongClickListener getMOnToggleViewLongClickListener() {
        return this.mOnToggleViewLongClickListener;
    }

    public final View.OnTouchListener getMOnToggleViewTouchListener() {
        return this.mOnToggleViewTouchListener;
    }

    public final int getViewHolderPosition(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
        return viewHolder.getAdapterPosition() - this.f704a.getHeaderLayoutCount();
    }

    public final void initView$com_github_CymChad_brvah(BaseViewHolder holder) {
        E.g(holder, "holder");
    }

    public void onItemDragEnd(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
    }

    public void onItemDragMoving(RecyclerView.ViewHolder source, RecyclerView.ViewHolder target) {
        E.g(source, "source");
        E.g(target, "target");
        int viewHolderPosition = getViewHolderPosition(source);
        int viewHolderPosition2 = getViewHolderPosition(target);
        if (a(viewHolderPosition) && a(viewHolderPosition2)) {
            O0.e eVar = this.f704a;
            if (viewHolderPosition >= viewHolderPosition2) {
                int i5 = viewHolderPosition2 + 1;
                if (viewHolderPosition >= i5) {
                    while (true) {
                        Collections.swap(eVar.getData(), viewHolderPosition, viewHolderPosition - 1);
                        if (viewHolderPosition == i5) {
                            break;
                        } else {
                            viewHolderPosition--;
                        }
                    }
                }
            } else {
                while (viewHolderPosition < viewHolderPosition2) {
                    int i6 = viewHolderPosition + 1;
                    Collections.swap(eVar.getData(), viewHolderPosition, i6);
                    viewHolderPosition = i6;
                }
            }
            eVar.notifyItemMoved(source.getAdapterPosition(), target.getAdapterPosition());
        }
    }

    public void onItemDragStart(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
    }

    public void onItemSwipeClear(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
    }

    public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
    }

    public void onItemSwiped(RecyclerView.ViewHolder viewHolder) {
        E.g(viewHolder, "viewHolder");
        int viewHolderPosition = getViewHolderPosition(viewHolder);
        if (a(viewHolderPosition)) {
            O0.e eVar = this.f704a;
            eVar.getData().remove(viewHolderPosition);
            eVar.notifyItemRemoved(viewHolder.getAdapterPosition());
        }
    }

    public final void setItemTouchHelper(ItemTouchHelper itemTouchHelper) {
        E.g(itemTouchHelper, "<set-?>");
        this.itemTouchHelper = itemTouchHelper;
    }

    public final void setItemTouchHelperCallback(R0.a aVar) {
        E.g(aVar, "<set-?>");
        this.itemTouchHelperCallback = aVar;
    }

    public final void setMOnToggleViewLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnToggleViewLongClickListener = onLongClickListener;
    }

    public final void setMOnToggleViewTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnToggleViewTouchListener = onTouchListener;
    }

    public final void setMOnItemDragListener(h hVar) {
    }

    public final void setMOnItemSwipeListener(j jVar) {
    }

    @Override // S0.b
    public void setOnItemDragListener(h hVar) {
    }

    @Override // S0.b
    public void setOnItemSwipeListener(j jVar) {
    }

    public void onItemSwiping(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f6, float f7, boolean z6) {
    }
}
