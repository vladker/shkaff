package com.appdev.standard.page.printerlabel;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.text.Text;

/* JADX INFO: renamed from: com.appdev.standard.page.printerlabel.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0469a implements OnSuccessListener, ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2724a;
    public final /* synthetic */ AttributeBarcodeDataFragment b;

    public /* synthetic */ C0469a(AttributeBarcodeDataFragment attributeBarcodeDataFragment, int i5) {
        this.f2724a = i5;
        this.b = attributeBarcodeDataFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        switch (this.f2724a) {
            case 1:
                this.b.lambda$onViewCreated$3((ActivityResult) obj);
                break;
            default:
                this.b.lambda$onViewCreated$5((ActivityResult) obj);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        this.b.lambda$onViewCreated$1((Text) obj);
    }
}
