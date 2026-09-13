package com.appdev.standard.page.printerlabel;

import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class y implements p056k0.s, OnFailureListener, p056k0.j, ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2822a;

    public /* synthetic */ y(int i5) {
        this.f2822a = i5;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ElementAllFragment.lambda$onViewCreated$0((ActivityResult) obj);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        switch (this.f2822a) {
            case 1:
                AttributeBarcodeDataFragment.lambda$onViewCreated$2(exc);
                break;
            case 2:
                AttributeQrcodeDataFragment.lambda$onViewCreated$2(exc);
                break;
            case 3:
                AttributeTableDataFragment.lambda$onViewCreated$1(exc);
                break;
            default:
                AttributeTextDataFragment.lambda$onViewCreated$2(exc);
                break;
        }
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        switch (this.f2822a) {
            case 5:
                ElementAllFragment.lambda$selectPicture$2(uri);
                break;
            default:
                PhotoPrintActivity.lambda$onLocalPicClick$0(uri);
                break;
        }
    }

    @Override // p056k0.s
    public void onResult(ActivityResult activityResult) {
        ElementAllFragment.AnonymousClass6.lambda$onRequestPermissionSuccess$1(activityResult);
    }
}
