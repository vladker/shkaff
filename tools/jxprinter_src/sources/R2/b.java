package R2;

import android.graphics.Bitmap;
import com.soundcloud.android.crop.CropImageActivity;
import com.soundcloud.android.crop.CropImageView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f588a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ CropImageActivity c;

    public /* synthetic */ b(CropImageActivity cropImageActivity, Bitmap bitmap, int i5) {
        this.f588a = i5;
        this.c = cropImageActivity;
        this.b = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f588a) {
            case 0:
                this.c.saveOutput(this.b);
                break;
            default:
                CropImageView cropImageView = this.c.imageView;
                cropImageView.getClass();
                cropImageView.e(new o(null, 0));
                this.b.recycle();
                break;
        }
    }
}
