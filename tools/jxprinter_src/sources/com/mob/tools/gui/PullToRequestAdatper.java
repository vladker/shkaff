package com.mob.tools.gui;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PullToRequestAdatper {
    private Context context;
    private PullToRequestView parent;

    public PullToRequestAdatper(PullToRequestView pullToRequestView) {
        this.context = pullToRequestView.getContext();
        this.parent = pullToRequestView;
    }

    public abstract Scrollable getBodyView();

    public Context getContext() {
        return this.context;
    }

    public abstract View getFooterView();

    public abstract View getHeaderView();

    public PullToRequestView getParent() {
        return this.parent;
    }

    public abstract boolean isPullDownReady();

    public abstract boolean isPullUpReady();

    public void notifyDataSetChanged() {
        this.parent.stopPulling();
    }

    public void onRefresh() {
    }

    public void onRequestNext() {
    }

    public void onReversed() {
    }

    public void onPullDown(int i5) {
    }

    public void onPullUp(int i5) {
    }
}
