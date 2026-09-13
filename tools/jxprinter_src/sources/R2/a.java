package R2;

import android.view.View;
import com.soundcloud.android.crop.CropImageActivity;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f587a;
    public final /* synthetic */ CropImageActivity b;

    public /* synthetic */ a(CropImageActivity cropImageActivity, int i5) {
        this.f587a = i5;
        this.b = cropImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        switch (this.f587a) {
            case 0:
                CropImageActivity cropImageActivity = this.b;
                cropImageActivity.setResult(0);
                cropImageActivity.finish();
                break;
            default:
                this.b.onSaveClicked();
                break;
        }
    }
}
