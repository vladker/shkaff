package com.library.base.util.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {
    protected static final String TAG = "b";
    protected final Context context;
    protected final int layoutResId;
    protected boolean displayIndeterminateProgress = false;
    private e mOnItemClickListener = null;
    protected final List<Object> data = new ArrayList();

    public b(Context context, int i5) {
        this.context = context;
        this.layoutResId = i5;
    }

    public void add(Object obj) {
        this.data.add(obj);
        notifyDataSetChanged();
    }

    public void addAll(List<Object> list) {
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.data.clear();
        notifyDataSetChanged();
    }

    public abstract void convert(a aVar, Object obj);

    public List<Object> getData() {
        return this.data;
    }

    public Object getItem(int i5) {
        if (i5 >= this.data.size()) {
            return null;
        }
        return this.data.get(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar = this.mOnItemClickListener;
        if (eVar != null) {
            eVar.onItemClick(view, ((Integer) view.getTag()).intValue());
        }
    }

    public void onItemMove(int i5, int i6) {
        Collections.swap(this.data, i5, i6);
        notifyItemMoved(i5, i6);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        e eVar = this.mOnItemClickListener;
        if (eVar == null) {
            return true;
        }
        eVar.onItemLongClick(view, ((Integer) view.getTag()).intValue());
        return true;
    }

    public void remove(int i5) {
        this.data.remove(i5);
        notifyDataSetChanged();
    }

    public void replaceAll(List<Object> list) {
        this.data.clear();
        this.data.addAll(list);
        notifyDataSetChanged();
    }

    public void set(int i5, Object obj) {
        this.data.set(i5, obj);
        notifyItemChanged(i5);
    }

    public void setOnItemClickListener(e eVar) {
        this.mOnItemClickListener = eVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i5) {
        aVar.itemView.setTag(Integer.valueOf(i5));
        aVar.itemView.setOnClickListener(this);
        aVar.itemView.setOnLongClickListener(this);
        convert(aVar, getItem(i5));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i5) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(this.layoutResId, viewGroup, false));
    }
}
