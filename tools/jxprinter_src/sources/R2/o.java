package R2;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f611a;
    public int b;

    public o(Bitmap bitmap, int i5) {
        this.f611a = bitmap;
        this.b = i5 % 360;
    }

    public final int a() {
        Bitmap bitmap = this.f611a;
        if (bitmap == null) {
            return 0;
        }
        return (this.b / 90) % 2 != 0 ? bitmap.getWidth() : bitmap.getHeight();
    }

    public final int b() {
        Bitmap bitmap = this.f611a;
        if (bitmap == null) {
            return 0;
        }
        return (this.b / 90) % 2 != 0 ? bitmap.getHeight() : bitmap.getWidth();
    }
}
