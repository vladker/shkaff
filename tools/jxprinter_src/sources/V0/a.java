package V0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static final View getItemView(ViewGroup getItemView, @LayoutRes int i5) {
        E.g(getItemView, "$this$getItemView");
        View viewInflate = LayoutInflater.from(getItemView.getContext()).inflate(i5, getItemView, false);
        E.b(viewInflate, "LayoutInflater.from(this…layoutResId, this, false)");
        return viewInflate;
    }
}
