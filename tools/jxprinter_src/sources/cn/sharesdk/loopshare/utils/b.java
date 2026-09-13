package cn.sharesdk.loopshare.utils;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f2325a;
    private Intent b;
    private boolean c;

    public b(Activity activity, Intent intent, boolean z6) {
        this.f2325a = activity;
        this.b = intent;
        this.c = z6;
    }

    public Activity a() {
        return this.f2325a;
    }

    public Intent b() {
        return this.b;
    }

    public boolean c() {
        return this.c;
    }
}
