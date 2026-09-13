package O0;

import A3.T;
import S0.i;
import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.E;
import p147z3.B;
import p147z3.C1937q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends RecyclerView.Adapter implements g, S0.a {
    public static final b Companion = new b();
    public static final int EMPTY_VIEW = 268436821;
    public static final int FOOTER_VIEW = 268436275;
    public static final int HEADER_VIEW = 268435729;
    public static final int LOAD_MORE_VIEW = 268436002;
    private P0.b adapterAnimation;
    private boolean animationEnable;
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> childLongClickViewIds;
    private Context context;
    private List<Object> data;
    private boolean footerViewAsFlow;
    private boolean footerWithEmptyEnable;
    private boolean headerViewAsFlow;
    private boolean headerWithEmptyEnable;
    private boolean isAnimationFirstOnly;
    private boolean isUseEmpty;
    private final int layoutResId;
    private Q0.e mDiffHelper;
    private U0.a mDraggableModule;
    private FrameLayout mEmptyLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mHeaderLayout;
    private int mLastPosition;
    private U0.c mLoadMoreModule;
    private S0.e mOnItemChildClickListener;
    private S0.f mOnItemChildLongClickListener;
    private S0.g mOnItemClickListener;
    private i mOnItemLongClickListener;
    private RecyclerView mRecyclerView;
    private S0.c mSpanSizeLookup;
    private U0.d mUpFetchModule;
    public WeakReference<RecyclerView> weakRecyclerView;

    public e(@LayoutRes int i5) {
        this(i5, null);
    }

    public static final /* synthetic */ FrameLayout access$getMEmptyLayout$p(e eVar) {
        FrameLayout frameLayout = eVar.mEmptyLayout;
        if (frameLayout != null) {
            return frameLayout;
        }
        E.m("mEmptyLayout");
        throw null;
    }

    public static final /* synthetic */ LinearLayout access$getMFooterLayout$p(e eVar) {
        LinearLayout linearLayout = eVar.mFooterLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        E.m("mFooterLayout");
        throw null;
    }

    public static final /* synthetic */ LinearLayout access$getMHeaderLayout$p(e eVar) {
        LinearLayout linearLayout = eVar.mHeaderLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        E.m("mHeaderLayout");
        throw null;
    }

    public static final /* synthetic */ S0.c access$getMSpanSizeLookup$p(e eVar) {
        eVar.getClass();
        return null;
    }

    public static /* synthetic */ int addFooterView$default(e eVar, View view, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i7 & 2) != 0) {
            i5 = -1;
        }
        if ((i7 & 4) != 0) {
            i6 = 1;
        }
        return eVar.addFooterView(view, i5, i6);
    }

    public static /* synthetic */ int addHeaderView$default(e eVar, View view, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        }
        if ((i7 & 2) != 0) {
            i5 = -1;
        }
        if ((i7 & 4) != 0) {
            i6 = 1;
        }
        return eVar.addHeaderView(view, i5, i6);
    }

    public static /* synthetic */ int setFooterView$default(e eVar, View view, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
        }
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = 1;
        }
        return eVar.setFooterView(view, i5, i6);
    }

    public static /* synthetic */ int setHeaderView$default(e eVar, View view, int i5, int i6, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        }
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = 1;
        }
        return eVar.setHeaderView(view, i5, i6);
    }

    public final void addChildClickViewIds(@IdRes int... viewIds) {
        E.g(viewIds, "viewIds");
        for (int i5 : viewIds) {
            this.childClickViewIds.add(Integer.valueOf(i5));
        }
    }

    public final void addChildLongClickViewIds(@IdRes int... viewIds) {
        E.g(viewIds, "viewIds");
        for (int i5 : viewIds) {
            this.childLongClickViewIds.add(Integer.valueOf(i5));
        }
    }

    public void addData(@IntRange(from = 0) int i5, Object obj) {
        this.data.add(i5, obj);
        notifyItemInserted(getHeaderLayoutCount() + i5);
        compatibilityDataSizeChanged(1);
    }

    @Override // O0.g
    public U0.a addDraggableModule(e baseQuickAdapter) {
        E.g(baseQuickAdapter, "baseQuickAdapter");
        return f.addDraggableModule(this, baseQuickAdapter);
    }

    public final int addFooterView(View view) {
        return addFooterView$default(this, view, 0, 0, 6, null);
    }

    public final int addHeaderView(View view) {
        return addHeaderView$default(this, view, 0, 0, 6, null);
    }

    @Override // O0.g
    public U0.c addLoadMoreModule(e baseQuickAdapter) {
        E.g(baseQuickAdapter, "baseQuickAdapter");
        return f.addLoadMoreModule(this, baseQuickAdapter);
    }

    @Override // O0.g
    public U0.d addUpFetchModule(e baseQuickAdapter) {
        E.g(baseQuickAdapter, "baseQuickAdapter");
        return f.addUpFetchModule(this, baseQuickAdapter);
    }

    public void bindViewClickListener(BaseViewHolder viewHolder, int i5) {
        E.g(viewHolder, "viewHolder");
        if (this.mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new c(this, viewHolder, 0));
        }
        if (this.mOnItemChildClickListener != null) {
            for (Integer id : getChildClickViewIds()) {
                View view = viewHolder.itemView;
                E.b(id, "id");
                View viewFindViewById = view.findViewById(id.intValue());
                if (viewFindViewById != null) {
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new c(this, viewHolder, 1));
                }
            }
        }
    }

    public final void compatibilityDataSizeChanged(int i5) {
        if (this.data.size() == i5) {
            notifyDataSetChanged();
        }
    }

    public abstract void convert(BaseViewHolder baseViewHolder, Object obj);

    public void convert(BaseViewHolder holder, Object obj, List<? extends Object> payloads) {
        E.g(holder, "holder");
        E.g(payloads, "payloads");
    }

    public BaseViewHolder createBaseViewHolder(ViewGroup parent, @LayoutRes int i5) {
        E.g(parent, "parent");
        return createBaseViewHolder(V0.a.getItemView(parent, i5));
    }

    public final P0.b getAdapterAnimation() {
        return this.adapterAnimation;
    }

    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    public final LinkedHashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public final LinkedHashSet<Integer> getChildLongClickViewIds() {
        return this.childLongClickViewIds;
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        E.m("context");
        throw null;
    }

    public final List<Object> getData() {
        return this.data;
    }

    public int getDefItemCount() {
        return this.data.size();
    }

    public int getDefItemViewType(int i5) {
        return super.getItemViewType(i5);
    }

    public final Q0.e getDiffHelper() {
        return getDiffer();
    }

    public final Q0.e getDiffer() {
        Q0.e eVar = this.mDiffHelper;
        if (eVar == null) {
            throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!");
        }
        if (eVar != null) {
            return eVar;
        }
        E.k();
        throw null;
    }

    public final U0.a getDraggableModule() {
        U0.a aVar = this.mDraggableModule;
        if (aVar == null) {
            throw new IllegalStateException("Please first implements DraggableModule");
        }
        if (aVar != null) {
            return aVar;
        }
        E.k();
        throw null;
    }

    public final FrameLayout getEmptyLayout() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout == null) {
            return null;
        }
        if (frameLayout != null) {
            return frameLayout;
        }
        E.m("mEmptyLayout");
        throw null;
    }

    public final LinearLayout getFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            return null;
        }
        if (linearLayout != null) {
            return linearLayout;
        }
        E.m("mFooterLayout");
        throw null;
    }

    public final int getFooterLayoutCount() {
        return hasFooterLayout() ? 1 : 0;
    }

    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final int getFooterViewPosition() {
        if (!hasEmptyView()) {
            return this.data.size() + getHeaderLayoutCount();
        }
        int i5 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 2 : 1;
        if (this.footerWithEmptyEnable) {
            return i5;
        }
        return -1;
    }

    public final boolean getFooterWithEmptyEnable() {
        return this.footerWithEmptyEnable;
    }

    public final LinearLayout getHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            return null;
        }
        if (linearLayout != null) {
            return linearLayout;
        }
        E.m("mHeaderLayout");
        throw null;
    }

    public final int getHeaderLayoutCount() {
        return hasHeaderLayout() ? 1 : 0;
    }

    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public final int getHeaderViewPosition() {
        return (!hasEmptyView() || this.headerWithEmptyEnable) ? 0 : -1;
    }

    public final boolean getHeaderWithEmptyEnable() {
        return this.headerWithEmptyEnable;
    }

    public Object getItem(@IntRange(from = 0) int i5) {
        return this.data.get(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!hasEmptyView()) {
            return getFooterLayoutCount() + getDefItemCount() + getHeaderLayoutCount();
        }
        int i5 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 2 : 1;
        return (this.footerWithEmptyEnable && hasFooterLayout()) ? i5 + 1 : i5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i5) {
        return i5;
    }

    public Object getItemOrNull(@IntRange(from = 0) int i5) {
        return T.getOrNull(this.data, i5);
    }

    public int getItemPosition(Object obj) {
        if (obj == null || this.data.isEmpty()) {
            return -1;
        }
        return this.data.indexOf(obj);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (hasEmptyView()) {
            boolean z6 = this.headerWithEmptyEnable && hasHeaderLayout();
            if (i5 == 0) {
                return z6 ? HEADER_VIEW : EMPTY_VIEW;
            }
            if (i5 != 1) {
                return i5 != 2 ? EMPTY_VIEW : FOOTER_VIEW;
            }
            return z6 ? EMPTY_VIEW : FOOTER_VIEW;
        }
        boolean zHasHeaderLayout = hasHeaderLayout();
        if (zHasHeaderLayout && i5 == 0) {
            return HEADER_VIEW;
        }
        if (zHasHeaderLayout) {
            i5--;
        }
        int size = this.data.size();
        if (i5 < size) {
            return getDefItemViewType(i5);
        }
        return i5 - size < hasFooterLayout() ? FOOTER_VIEW : LOAD_MORE_VIEW;
    }

    public final U0.c getLoadMoreModule() {
        U0.c cVar = this.mLoadMoreModule;
        if (cVar == null) {
            throw new IllegalStateException("Please first implements LoadMoreModule");
        }
        if (cVar != null) {
            return cVar;
        }
        E.k();
        throw null;
    }

    public final U0.c getMLoadMoreModule$com_github_CymChad_brvah() {
        return this.mLoadMoreModule;
    }

    public final RecyclerView getMRecyclerView$com_github_CymChad_brvah() {
        return this.mRecyclerView;
    }

    public final S0.e getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final S0.f getOnItemChildLongClickListener() {
        return null;
    }

    public final S0.g getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final i getOnItemLongClickListener() {
        return null;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()");
        }
        if (recyclerView != null) {
            return recyclerView;
        }
        E.k();
        throw null;
    }

    public final U0.d getUpFetchModule() {
        U0.d dVar = this.mUpFetchModule;
        if (dVar == null) {
            throw new IllegalStateException("Please first implements UpFetchModule");
        }
        if (dVar != null) {
            return dVar;
        }
        E.k();
        throw null;
    }

    public final View getViewByPosition(int i5, @IdRes int i6) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i5)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i6);
    }

    public final WeakReference<RecyclerView> getWeakRecyclerView() {
        WeakReference<RecyclerView> weakReference = this.weakRecyclerView;
        if (weakReference != null) {
            return weakReference;
        }
        E.m("weakRecyclerView");
        throw null;
    }

    public final boolean hasEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                E.m("mEmptyLayout");
                throw null;
            }
            if (frameLayout.getChildCount() != 0 && this.isUseEmpty) {
                return this.data.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final boolean hasFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout != null) {
            return linearLayout.getChildCount() > 0;
        }
        E.m("mFooterLayout");
        throw null;
    }

    public final boolean hasHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout != null) {
            return linearLayout.getChildCount() > 0;
        }
        E.m("mHeaderLayout");
        throw null;
    }

    public final boolean isAnimationFirstOnly() {
        return this.isAnimationFirstOnly;
    }

    public boolean isFixedViewType(int i5) {
        return i5 == 268436821 || i5 == 268435729 || i5 == 268436275 || i5 == 268436002;
    }

    public final boolean isUseEmpty() {
        return this.isUseEmpty;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        E.g(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.weakRecyclerView = new WeakReference<>(recyclerView);
        this.mRecyclerView = recyclerView;
        Context context = recyclerView.getContext();
        E.b(context, "recyclerView.context");
        this.context = context;
        U0.a aVar = this.mDraggableModule;
        if (aVar != null) {
            aVar.attachToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new d(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int i5) {
        E.g(parent, "parent");
        return createBaseViewHolder(parent, this.layoutResId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        E.g(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public void onItemViewHolderCreated(BaseViewHolder viewHolder, int i5) {
        E.g(viewHolder, "viewHolder");
    }

    public void remove(@IntRange(from = 0) int i5) {
        removeAt(i5);
    }

    public final void removeAllFooterView() {
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                E.m("mFooterLayout");
                throw null;
            }
            linearLayout.removeAllViews();
            int footerViewPosition = getFooterViewPosition();
            if (footerViewPosition != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public final void removeAllHeaderView() {
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                E.m("mHeaderLayout");
                throw null;
            }
            linearLayout.removeAllViews();
            int headerViewPosition = getHeaderViewPosition();
            if (headerViewPosition != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void removeAt(@IntRange(from = 0) int i5) {
        if (i5 >= this.data.size()) {
            return;
        }
        this.data.remove(i5);
        int headerLayoutCount = getHeaderLayoutCount() + i5;
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.data.size() - headerLayoutCount);
    }

    public final void removeEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            } else {
                E.m("mEmptyLayout");
                throw null;
            }
        }
    }

    public final void removeFooterView(View footer) {
        int footerViewPosition;
        E.g(footer, "footer");
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                E.m("mFooterLayout");
                throw null;
            }
            linearLayout.removeView(footer);
            LinearLayout linearLayout2 = this.mFooterLayout;
            if (linearLayout2 == null) {
                E.m("mFooterLayout");
                throw null;
            }
            if (linearLayout2.getChildCount() != 0 || (footerViewPosition = getFooterViewPosition()) == -1) {
                return;
            }
            notifyItemRemoved(footerViewPosition);
        }
    }

    public final void removeHeaderView(View header) {
        int headerViewPosition;
        E.g(header, "header");
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                E.m("mHeaderLayout");
                throw null;
            }
            linearLayout.removeView(header);
            LinearLayout linearLayout2 = this.mHeaderLayout;
            if (linearLayout2 == null) {
                E.m("mHeaderLayout");
                throw null;
            }
            if (linearLayout2.getChildCount() != 0 || (headerViewPosition = getHeaderViewPosition()) == -1) {
                return;
            }
            notifyItemRemoved(headerViewPosition);
        }
    }

    public void replaceData(Collection<Object> newData) {
        E.g(newData, "newData");
        setList(newData);
    }

    public final void setAdapterAnimation(P0.b bVar) {
        this.animationEnable = true;
        this.adapterAnimation = bVar;
    }

    public final void setAnimationEnable(boolean z6) {
        this.animationEnable = z6;
    }

    public final void setAnimationFirstOnly(boolean z6) {
        this.isAnimationFirstOnly = z6;
    }

    public final void setAnimationWithDefault(a animationType) {
        P0.b aVar;
        E.g(animationType, "animationType");
        int iOrdinal = animationType.ordinal();
        if (iOrdinal == 0) {
            aVar = new P0.a(0);
        } else if (iOrdinal == 1) {
            aVar = new P0.c(0);
        } else if (iOrdinal == 2) {
            aVar = new P0.d();
        } else if (iOrdinal == 3) {
            aVar = new P0.e();
        } else {
            if (iOrdinal != 4) {
                throw new C1937q();
            }
            aVar = new P0.f();
        }
        setAdapterAnimation(aVar);
    }

    public void setData(@IntRange(from = 0) int i5, Object obj) {
        if (i5 >= this.data.size()) {
            return;
        }
        this.data.set(i5, obj);
        notifyItemChanged(getHeaderLayoutCount() + i5);
    }

    public final void setData$com_github_CymChad_brvah(List<Object> list) {
        E.g(list, "<set-?>");
        this.data = list;
    }

    public final void setDiffCallback(DiffUtil.ItemCallback<Object> diffCallback) {
        E.g(diffCallback, "diffCallback");
        setDiffConfig(new Q0.f.a(diffCallback).build());
    }

    public final void setDiffConfig(Q0.f config) {
        E.g(config, "config");
        this.mDiffHelper = new Q0.e(this, config);
    }

    public void setDiffNewData(List<Object> list) {
        if (hasEmptyView()) {
            setNewInstance(list);
            return;
        }
        Q0.e eVar = this.mDiffHelper;
        if (eVar != null) {
            eVar.submitList(list, null);
        }
    }

    public final void setEmptyView(View emptyView) {
        boolean z6;
        E.g(emptyView, "emptyView");
        int itemCount = getItemCount();
        if (this.mEmptyLayout == null) {
            FrameLayout frameLayout = new FrameLayout(emptyView.getContext());
            this.mEmptyLayout = frameLayout;
            ViewGroup.LayoutParams layoutParams = emptyView.getLayoutParams();
            frameLayout.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z6 = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = emptyView.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout2 = this.mEmptyLayout;
                if (frameLayout2 == null) {
                    E.m("mEmptyLayout");
                    throw null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout2.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 == null) {
                    E.m("mEmptyLayout");
                    throw null;
                }
                frameLayout3.setLayoutParams(layoutParams3);
            }
            z6 = false;
        }
        FrameLayout frameLayout4 = this.mEmptyLayout;
        if (frameLayout4 == null) {
            E.m("mEmptyLayout");
            throw null;
        }
        frameLayout4.removeAllViews();
        FrameLayout frameLayout5 = this.mEmptyLayout;
        if (frameLayout5 == null) {
            E.m("mEmptyLayout");
            throw null;
        }
        frameLayout5.addView(emptyView);
        this.isUseEmpty = true;
        if (z6 && hasEmptyView()) {
            int i5 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 1 : 0;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i5);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public final int setFooterView(View view) {
        return setFooterView$default(this, view, 0, 0, 6, null);
    }

    public final void setFooterViewAsFlow(boolean z6) {
        this.footerViewAsFlow = z6;
    }

    public final void setFooterWithEmptyEnable(boolean z6) {
        this.footerWithEmptyEnable = z6;
    }

    public void setFullSpan(RecyclerView.ViewHolder holder) {
        E.g(holder, "holder");
        View view = holder.itemView;
        E.b(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public final int setHeaderView(View view) {
        return setHeaderView$default(this, view, 0, 0, 6, null);
    }

    public final void setHeaderViewAsFlow(boolean z6) {
        this.headerViewAsFlow = z6;
    }

    public final void setHeaderWithEmptyEnable(boolean z6) {
        this.headerWithEmptyEnable = z6;
    }

    public void setList(Collection<Object> collection) {
        List<Object> list = this.data;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.data.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.data.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.data.clear();
            this.data.addAll(arrayList);
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
        U0.c cVar = this.mLoadMoreModule;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void setMLoadMoreModule$com_github_CymChad_brvah(U0.c cVar) {
        this.mLoadMoreModule = cVar;
    }

    public final void setMRecyclerView$com_github_CymChad_brvah(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setNewData(List<Object> list) {
        setNewInstance(list);
    }

    public void setNewInstance(List<Object> list) {
        if (list == this.data) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        this.mLastPosition = -1;
        notifyDataSetChanged();
        U0.c cVar = this.mLoadMoreModule;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void setOnItemChildClick(View v6, int i5) {
        E.g(v6, "v");
        S0.e eVar = this.mOnItemChildClickListener;
        if (eVar != null) {
            eVar.onItemChildClick(this, v6, i5);
        }
    }

    @Override // S0.a
    public void setOnItemChildClickListener(S0.e eVar) {
        this.mOnItemChildClickListener = eVar;
    }

    public boolean setOnItemChildLongClick(View v6, int i5) {
        E.g(v6, "v");
        return false;
    }

    public void setOnItemClick(View v6, int i5) {
        E.g(v6, "v");
        S0.g gVar = this.mOnItemClickListener;
        if (gVar != null) {
            gVar.onItemClick(this, v6, i5);
        }
    }

    @Override // S0.a
    public void setOnItemClickListener(S0.g gVar) {
        this.mOnItemClickListener = gVar;
    }

    public boolean setOnItemLongClick(View v6, int i5) {
        E.g(v6, "v");
        return false;
    }

    public final void setRecyclerView(RecyclerView value) {
        E.g(value, "value");
        this.mRecyclerView = value;
    }

    public final void setUseEmpty(boolean z6) {
        this.isUseEmpty = z6;
    }

    public final void setWeakRecyclerView(WeakReference<RecyclerView> weakReference) {
        E.g(weakReference, "<set-?>");
        this.weakRecyclerView = weakReference;
    }

    public void startAnim(Animator anim, int i5) {
        E.g(anim, "anim");
        anim.start();
    }

    public e(@LayoutRes int i5, List<Object> list) {
        this.layoutResId = i5;
        this.data = list == null ? new ArrayList<>() : list;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }

    public final int addFooterView(View view, int i5) {
        return addFooterView$default(this, view, i5, 0, 4, null);
    }

    public final int addHeaderView(View view, int i5) {
        return addHeaderView$default(this, view, i5, 0, 4, null);
    }

    public BaseViewHolder createBaseViewHolder(View view) {
        BaseViewHolder baseViewHolder;
        BaseViewHolder baseViewHolder2;
        Class cls;
        E.g(view, "view");
        BaseViewHolder baseViewHolder3 = null;
        Class cls2 = null;
        for (Class<?> superclass = getClass(); cls2 == null && superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Type genericSuperclass = superclass.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    E.b(actualTypeArguments, "type.actualTypeArguments");
                    int length = actualTypeArguments.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 < length) {
                            Type type = actualTypeArguments[i5];
                            if (!(type instanceof Class)) {
                                if (type instanceof ParameterizedType) {
                                    Type rawType = ((ParameterizedType) type).getRawType();
                                    E.b(rawType, "temp.rawType");
                                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                                        cls = (Class) rawType;
                                        cls2 = cls;
                                    }
                                } else {
                                    continue;
                                }
                                i5++;
                            } else if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                                cls = (Class) type;
                                cls2 = cls;
                            } else {
                                i5++;
                            }
                        } else {
                            cls2 = null;
                        }
                    }
                } else {
                    cls2 = null;
                }
            } catch (TypeNotPresentException e) {
                e.printStackTrace();
            } catch (GenericSignatureFormatError e6) {
                e6.printStackTrace();
            } catch (MalformedParameterizedTypeException e7) {
                e7.printStackTrace();
            }
        }
        if (cls2 == null) {
            baseViewHolder = new BaseViewHolder(view);
        } else {
            try {
                if (!cls2.isMemberClass() || Modifier.isStatic(cls2.getModifiers())) {
                    Constructor declaredConstructor = cls2.getDeclaredConstructor(View.class);
                    E.b(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                    declaredConstructor.setAccessible(true);
                    Object objNewInstance = declaredConstructor.newInstance(view);
                    if (objNewInstance == null) {
                        throw new B("null cannot be cast to non-null type VH");
                    }
                    baseViewHolder2 = (BaseViewHolder) objNewInstance;
                } else {
                    Constructor declaredConstructor2 = cls2.getDeclaredConstructor(getClass(), View.class);
                    E.b(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
                    declaredConstructor2.setAccessible(true);
                    Object objNewInstance2 = declaredConstructor2.newInstance(this, view);
                    if (objNewInstance2 == null) {
                        throw new B("null cannot be cast to non-null type VH");
                    }
                    baseViewHolder2 = (BaseViewHolder) objNewInstance2;
                }
                baseViewHolder3 = baseViewHolder2;
            } catch (IllegalAccessException e8) {
                e8.printStackTrace();
            } catch (InstantiationException e9) {
                e9.printStackTrace();
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
            baseViewHolder = baseViewHolder3;
        }
        return baseViewHolder != null ? baseViewHolder : new BaseViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5, List list) {
        onBindViewHolder((BaseViewHolder) viewHolder, i5, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i5) {
        E.g(parent, "parent");
        switch (i5) {
            case HEADER_VIEW /* 268435729 */:
                LinearLayout linearLayout = this.mHeaderLayout;
                if (linearLayout == null) {
                    E.m("mHeaderLayout");
                    throw null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.mHeaderLayout;
                    if (linearLayout2 == null) {
                        E.m("mHeaderLayout");
                        throw null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.mHeaderLayout;
                if (linearLayout3 != null) {
                    return createBaseViewHolder(linearLayout3);
                }
                E.m("mHeaderLayout");
                throw null;
            case LOAD_MORE_VIEW /* 268436002 */:
                U0.c cVar = this.mLoadMoreModule;
                if (cVar == null) {
                    E.k();
                    throw null;
                }
                BaseViewHolder baseViewHolderCreateBaseViewHolder = createBaseViewHolder(cVar.getLoadMoreView().getRootView(parent));
                U0.c cVar2 = this.mLoadMoreModule;
                if (cVar2 != null) {
                    cVar2.setupViewHolder$com_github_CymChad_brvah(baseViewHolderCreateBaseViewHolder);
                    return baseViewHolderCreateBaseViewHolder;
                }
                E.k();
                throw null;
            case FOOTER_VIEW /* 268436275 */:
                LinearLayout linearLayout4 = this.mFooterLayout;
                if (linearLayout4 == null) {
                    E.m("mFooterLayout");
                    throw null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.mFooterLayout;
                    if (linearLayout5 == null) {
                        E.m("mFooterLayout");
                        throw null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.mFooterLayout;
                if (linearLayout6 != null) {
                    return createBaseViewHolder(linearLayout6);
                }
                E.m("mFooterLayout");
                throw null;
            case EMPTY_VIEW /* 268436821 */:
                FrameLayout frameLayout = this.mEmptyLayout;
                if (frameLayout == null) {
                    E.m("mEmptyLayout");
                    throw null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.mEmptyLayout;
                    if (frameLayout2 == null) {
                        E.m("mEmptyLayout");
                        throw null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 != null) {
                    return createBaseViewHolder(frameLayout3);
                }
                E.m("mEmptyLayout");
                throw null;
            default:
                BaseViewHolder baseViewHolderOnCreateDefViewHolder = onCreateDefViewHolder(parent, i5);
                bindViewClickListener(baseViewHolderOnCreateDefViewHolder, i5);
                U0.a aVar = this.mDraggableModule;
                if (aVar != null) {
                    aVar.initView$com_github_CymChad_brvah(baseViewHolderOnCreateDefViewHolder);
                }
                onItemViewHolderCreated(baseViewHolderOnCreateDefViewHolder, i5);
                return baseViewHolderOnCreateDefViewHolder;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        E.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (isFixedViewType(holder.getItemViewType())) {
            setFullSpan(holder);
            return;
        }
        if (this.animationEnable) {
            if (!this.isAnimationFirstOnly || holder.getLayoutPosition() > this.mLastPosition) {
                P0.b aVar = this.adapterAnimation;
                if (aVar == null) {
                    aVar = new P0.a(0);
                }
                View view = holder.itemView;
                E.b(view, "holder.itemView");
                for (Animator animator : aVar.animators(view)) {
                    startAnim(animator, holder.getLayoutPosition());
                }
                this.mLastPosition = holder.getLayoutPosition();
            }
        }
    }

    public void remove(Object obj) {
        int iIndexOf = this.data.indexOf(obj);
        if (iIndexOf == -1) {
            return;
        }
        removeAt(iIndexOf);
    }

    public final int setFooterView(View view, int i5) {
        return setFooterView$default(this, view, i5, 0, 4, null);
    }

    public final int setHeaderView(View view, int i5) {
        return setHeaderView$default(this, view, i5, 0, 4, null);
    }

    public final int addFooterView(View view, int i5, int i6) {
        int footerViewPosition;
        RecyclerView.LayoutParams layoutParams;
        E.g(view, "view");
        if (this.mFooterLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout;
            linearLayout.setOrientation(i6);
            LinearLayout linearLayout2 = this.mFooterLayout;
            if (linearLayout2 == null) {
                E.m("mFooterLayout");
                throw null;
            }
            if (i6 == 1) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout2.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout3 = this.mFooterLayout;
        if (linearLayout3 != null) {
            int childCount = linearLayout3.getChildCount();
            if (i5 < 0 || i5 > childCount) {
                i5 = childCount;
            }
            LinearLayout linearLayout4 = this.mFooterLayout;
            if (linearLayout4 != null) {
                linearLayout4.addView(view, i5);
                LinearLayout linearLayout5 = this.mFooterLayout;
                if (linearLayout5 == null) {
                    E.m("mFooterLayout");
                    throw null;
                }
                if (linearLayout5.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
                    notifyItemInserted(footerViewPosition);
                }
                return i5;
            }
            E.m("mFooterLayout");
            throw null;
        }
        E.m("mFooterLayout");
        throw null;
    }

    public final int addHeaderView(View view, int i5, int i6) {
        int headerViewPosition;
        RecyclerView.LayoutParams layoutParams;
        E.g(view, "view");
        if (this.mHeaderLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout;
            linearLayout.setOrientation(i6);
            LinearLayout linearLayout2 = this.mHeaderLayout;
            if (linearLayout2 == null) {
                E.m("mHeaderLayout");
                throw null;
            }
            if (i6 == 1) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout2.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout3 = this.mHeaderLayout;
        if (linearLayout3 != null) {
            int childCount = linearLayout3.getChildCount();
            if (i5 < 0 || i5 > childCount) {
                i5 = childCount;
            }
            LinearLayout linearLayout4 = this.mHeaderLayout;
            if (linearLayout4 != null) {
                linearLayout4.addView(view, i5);
                LinearLayout linearLayout5 = this.mHeaderLayout;
                if (linearLayout5 == null) {
                    E.m("mHeaderLayout");
                    throw null;
                }
                if (linearLayout5.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
                    notifyItemInserted(headerViewPosition);
                }
                return i5;
            }
            E.m("mHeaderLayout");
            throw null;
        }
        E.m("mHeaderLayout");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder holder, int i5) {
        E.g(holder, "holder");
        switch (holder.getItemViewType()) {
            case HEADER_VIEW /* 268435729 */:
            case FOOTER_VIEW /* 268436275 */:
            case EMPTY_VIEW /* 268436821 */:
                break;
            case LOAD_MORE_VIEW /* 268436002 */:
                U0.c cVar = this.mLoadMoreModule;
                if (cVar != null) {
                    cVar.getLoadMoreView().convert(holder, i5, cVar.getLoadMoreStatus());
                }
                break;
            default:
                convert(holder, getItem(i5 - getHeaderLayoutCount()));
                break;
        }
    }

    public final int setFooterView(View view, int i5, int i6) {
        E.g(view, "view");
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                E.m("mFooterLayout");
                throw null;
            }
            if (linearLayout.getChildCount() > i5) {
                LinearLayout linearLayout2 = this.mFooterLayout;
                if (linearLayout2 != null) {
                    linearLayout2.removeViewAt(i5);
                    LinearLayout linearLayout3 = this.mFooterLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(view, i5);
                        return i5;
                    }
                    E.m("mFooterLayout");
                    throw null;
                }
                E.m("mFooterLayout");
                throw null;
            }
        }
        return addFooterView(view, i5, i6);
    }

    public final int setHeaderView(View view, int i5, int i6) {
        E.g(view, "view");
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                E.m("mHeaderLayout");
                throw null;
            }
            if (linearLayout.getChildCount() > i5) {
                LinearLayout linearLayout2 = this.mHeaderLayout;
                if (linearLayout2 != null) {
                    linearLayout2.removeViewAt(i5);
                    LinearLayout linearLayout3 = this.mHeaderLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(view, i5);
                        return i5;
                    }
                    E.m("mHeaderLayout");
                    throw null;
                }
                E.m("mHeaderLayout");
                throw null;
            }
        }
        return addHeaderView(view, i5, i6);
    }

    public void addData(@NonNull Object obj) {
        this.data.add(obj);
        notifyItemInserted(getHeaderLayoutCount() + this.data.size());
        compatibilityDataSizeChanged(1);
    }

    public void setDiffNewData(@NonNull DiffUtil.DiffResult diffResult, List<Object> list) {
        E.g(diffResult, "diffResult");
        E.g(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            diffResult.dispatchUpdatesTo(new Q0.g(this));
            this.data = list;
        }
    }

    public void addData(@IntRange(from = 0) int i5, Collection<Object> newData) {
        E.g(newData, "newData");
        this.data.addAll(i5, newData);
        notifyItemRangeInserted(getHeaderLayoutCount() + i5, newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    public void onBindViewHolder(BaseViewHolder holder, int i5, List<Object> payloads) {
        E.g(holder, "holder");
        E.g(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i5);
        }
        switch (holder.getItemViewType()) {
            case HEADER_VIEW /* 268435729 */:
            case FOOTER_VIEW /* 268436275 */:
            case EMPTY_VIEW /* 268436821 */:
                break;
            case LOAD_MORE_VIEW /* 268436002 */:
                U0.c cVar = this.mLoadMoreModule;
                if (cVar != null) {
                    cVar.getLoadMoreView().convert(holder, i5, cVar.getLoadMoreStatus());
                }
                break;
            default:
                convert(holder, getItem(i5 - getHeaderLayoutCount()), payloads);
                break;
        }
    }

    public void addData(@NonNull Collection<Object> newData) {
        E.g(newData, "newData");
        this.data.addAll(newData);
        notifyItemRangeInserted(getHeaderLayoutCount() + (this.data.size() - newData.size()), newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    public static /* synthetic */ void weakRecyclerView$annotations() {
    }

    @Override // S0.a
    public void setGridSpanSizeLookup(S0.c cVar) {
    }

    @Override // S0.a
    public void setOnItemChildLongClickListener(S0.f fVar) {
    }

    @Override // S0.a
    public void setOnItemLongClickListener(i iVar) {
    }

    public final void setEmptyView(int i5) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(i5, (ViewGroup) recyclerView, false);
            E.b(view, "view");
            setEmptyView(view);
        }
    }
}
