package p030f;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3952a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Intent c;
    public final /* synthetic */ Postcard d;
    public final /* synthetic */ NavigationCallback e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f3953f;

    public a(c cVar, int i5, Context context, Intent intent, Postcard postcard, NavigationCallback navigationCallback) {
        this.f3953f = cVar;
        this.f3952a = i5;
        this.b = context;
        this.c = intent;
        this.d = postcard;
        this.e = navigationCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3953f.getClass();
        int i5 = this.f3952a;
        Context context = this.b;
        Intent intent = this.c;
        Postcard postcard = this.d;
        if (i5 < 0) {
            ContextCompat.startActivity(context, intent, postcard.getOptionsBundle());
        } else if (context instanceof Activity) {
            ActivityCompat.startActivityForResult((Activity) context, intent, i5, postcard.getOptionsBundle());
        } else {
            c.f3955a.warning("ARouter::", "Must use [navigation(activity, ...)] to support [startActivityForResult]");
        }
        if (-1 != postcard.getEnterAnim() && -1 != postcard.getExitAnim() && (context instanceof Activity)) {
            ((Activity) context).overridePendingTransition(postcard.getEnterAnim(), postcard.getExitAnim());
        }
        NavigationCallback navigationCallback = this.e;
        if (navigationCallback != null) {
            navigationCallback.onArrival(postcard);
        }
    }
}
