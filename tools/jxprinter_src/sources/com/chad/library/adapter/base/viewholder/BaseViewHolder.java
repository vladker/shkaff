package com.chad.library.adapter.base.viewholder;

import A3.AbstractC0157z;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.Keep;
import androidx.annotation.StringRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@Keep
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private final SparseArray<View> views;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewHolder(View view) {
        super(view);
        E.g(view, "view");
        this.views = new SparseArray<>();
    }

    public <T extends View> T findView(int i5) {
        return (T) this.itemView.findViewById(i5);
    }

    public <B extends ViewDataBinding> B getBinding() {
        return (B) DataBindingUtil.getBinding(this.itemView);
    }

    public <T extends View> T getView(@IdRes int i5) {
        T t6 = (T) getViewOrNull(i5);
        if (t6 != null) {
            return t6;
        }
        throw new IllegalStateException(AbstractC0157z.k(i5, "No view found with id ").toString());
    }

    public <T extends View> T getViewOrNull(@IdRes int i5) {
        T t6;
        T t7 = (T) this.views.get(i5);
        if (t7 == null && (t6 = (T) this.itemView.findViewById(i5)) != null) {
            this.views.put(i5, t6);
            return t6;
        }
        if (t7 == null) {
            return null;
        }
        return t7;
    }

    public BaseViewHolder setBackgroundColor(@IdRes int i5, @ColorInt int i6) {
        getView(i5).setBackgroundColor(i6);
        return this;
    }

    public BaseViewHolder setBackgroundResource(@IdRes int i5, @DrawableRes int i6) {
        getView(i5).setBackgroundResource(i6);
        return this;
    }

    public BaseViewHolder setEnabled(@IdRes int i5, boolean z6) {
        getView(i5).setEnabled(z6);
        return this;
    }

    public BaseViewHolder setGone(@IdRes int i5, boolean z6) {
        getView(i5).setVisibility(z6 ? 8 : 0);
        return this;
    }

    public BaseViewHolder setImageBitmap(@IdRes int i5, Bitmap bitmap) {
        ((ImageView) getView(i5)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(@IdRes int i5, Drawable drawable) {
        ((ImageView) getView(i5)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(@IdRes int i5, @DrawableRes int i6) {
        ((ImageView) getView(i5)).setImageResource(i6);
        return this;
    }

    public BaseViewHolder setText(@IdRes int i5, CharSequence charSequence) {
        ((TextView) getView(i5)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(@IdRes int i5, @ColorInt int i6) {
        ((TextView) getView(i5)).setTextColor(i6);
        return this;
    }

    public BaseViewHolder setTextColorRes(@IdRes int i5, @ColorRes int i6) {
        TextView textView = (TextView) getView(i5);
        View itemView = this.itemView;
        E.b(itemView, "itemView");
        textView.setTextColor(itemView.getResources().getColor(i6));
        return this;
    }

    public BaseViewHolder setVisible(@IdRes int i5, boolean z6) {
        getView(i5).setVisibility(z6 ? 0 : 4);
        return this;
    }

    public BaseViewHolder setText(@IdRes int i5, @StringRes int i6) {
        ((TextView) getView(i5)).setText(i6);
        return this;
    }
}
