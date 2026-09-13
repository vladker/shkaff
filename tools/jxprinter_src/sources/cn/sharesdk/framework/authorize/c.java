package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SSOAuthorizeActivity f2182a;
    protected int b;
    protected SSOListener c;

    public c(SSOAuthorizeActivity sSOAuthorizeActivity) {
        this.f2182a = sSOAuthorizeActivity;
        this.c = sSOAuthorizeActivity.getHelper().getSSOListener();
    }

    public abstract void a();

    public void a(int i5, int i6, Intent intent) {
    }

    public void a(Intent intent) {
    }

    public void a(int i5) {
        this.b = i5;
    }
}
