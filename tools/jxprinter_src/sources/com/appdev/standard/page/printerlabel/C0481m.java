package com.appdev.standard.page.printerlabel;

import android.net.Uri;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.text.Text;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0481m implements ActivityResultCallback, OnSuccessListener, p056k0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2736a;
    public final /* synthetic */ AttributeTextDataFragment b;

    public /* synthetic */ C0481m(AttributeTextDataFragment attributeTextDataFragment, int i5) {
        this.f2736a = i5;
        this.b = attributeTextDataFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f2736a) {
            case 0:
                this.b.lambda$onViewCreated$3((ActivityResult) obj);
                break;
            default:
                this.b.lambda$onViewCreated$5((ActivityResult) obj);
                break;
        }
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        this.b.lambda$selectPicture$7(uri);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        this.b.lambda$onViewCreated$1((Text) obj);
    }
}
