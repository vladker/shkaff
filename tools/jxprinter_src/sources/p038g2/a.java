package p038g2;

import android.content.Context;
import androidx.annotation.StringRes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3986a = getClass().getSimpleName();
    public Object b = null;
    public final Context c;

    public a(Context context) {
        this.c = context;
    }

    public String getString(@StringRes int i5) {
        Context context = this.c;
        return context == null ? "" : context.getResources().getString(i5);
    }
}
