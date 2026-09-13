package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PullToRequestListAdapter extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableListView listView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    public PullToRequestListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
        ScrollableListView scrollableListViewOnNewListView = onNewListView(getContext());
        this.listView = scrollableListViewOnNewListView;
        scrollableListViewOnNewListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.mob.tools.gui.PullToRequestListAdapter.1
            private int firstVisibleItem;
            private int visibleItemCount;

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i5, int i6, int i7) {
                this.firstVisibleItem = i5;
                this.visibleItemCount = i6;
                View childAt = absListView.getChildAt(i6 - 1);
                PullToRequestListAdapter.this.pullUpReady = i5 + i6 == i7 && childAt != null && childAt.getBottom() <= absListView.getBottom();
                PullToRequestListAdapter pullToRequestListAdapter = PullToRequestListAdapter.this;
                pullToRequestListAdapter.onScroll(pullToRequestListAdapter.listView, i5, i6, i7);
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i5) {
                PullToRequestListAdapter.this.fling = i5 == 2;
                if (i5 == 0) {
                    if (PullToRequestListAdapter.this.osListener != null) {
                        PullToRequestListAdapter.this.osListener.onListStopScrolling(this.firstVisibleItem, this.visibleItemCount);
                    } else if (PullToRequestListAdapter.this.adapter != null) {
                        PullToRequestListAdapter.this.adapter.notifyDataSetChanged();
                    }
                }
            }
        });
        PullToRequestBaseAdapter pullToRequestBaseAdapter = new PullToRequestBaseAdapter(this);
        this.adapter = pullToRequestBaseAdapter;
        this.listView.setAdapter((ListAdapter) pullToRequestBaseAdapter);
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public Scrollable getBodyView() {
        return this.listView;
    }

    public ListView getListView() {
        return this.listView;
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public boolean isFling() {
        return this.fling;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullDownReady() {
        return this.listView.isReadyToPull();
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    @Override // com.mob.tools.gui.PullToRequestAdatper
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    public ScrollableListView onNewListView(Context context) {
        return new ScrollableListView(context);
    }

    public void setDivider(Drawable drawable) {
        this.listView.setDivider(drawable);
    }

    public void setDividerHeight(int i5) {
        this.listView.setDividerHeight(i5);
    }

    @Override // com.mob.tools.gui.PullToRequestBaseListAdapter
    public void onScroll(Scrollable scrollable, int i5, int i6, int i7) {
    }
}
