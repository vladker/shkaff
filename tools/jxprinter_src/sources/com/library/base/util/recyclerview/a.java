package com.library.base.util.recyclerview;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f3564a;

    public a(View view) {
        super(view);
        this.f3564a = new SparseArray();
    }

    public final View a(int i5) {
        SparseArray sparseArray = this.f3564a;
        View view = (View) sparseArray.get(i5);
        if (view != null) {
            return view;
        }
        View viewFindViewById = this.itemView.findViewById(i5);
        sparseArray.put(i5, viewFindViewById);
        return viewFindViewById;
    }

    public final void b(int i5, String str) {
        TextView textView = (TextView) a(i5);
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else {
            textView.setText(str);
        }
    }

    public final void c(int i5, boolean z6) {
        a(i5).setVisibility(z6 ? 0 : 8);
    }

    @SuppressLint({"NewApi"})
    public a setAlpha(int i5, float f6) {
        a(i5).setAlpha(f6);
        return this;
    }

    public a setText(int i5, @StringRes int i6) {
        ((TextView) a(i5)).setText(i6);
        return this;
    }
}
