package com.appdev.standard.page.mine;

import android.net.Uri;
import p056k0.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2703a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f2703a = i5;
        this.b = obj;
    }

    @Override // p056k0.j
    public final void onImagePicked(Uri uri) {
        switch (this.f2703a) {
            case 0:
                ((FeedbackActivity.AnonymousClass2) this.b).lambda$onItemClick$0(uri);
                break;
            default:
                ((PersonalInfomationActivity) this.b).lambda$onModifyAvatarClick$0(uri);
                break;
        }
    }
}
