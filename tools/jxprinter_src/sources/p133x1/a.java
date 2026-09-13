package p133x1;

import android.graphics.Bitmap;
import kotlin.jvm.internal.E;
import p145z1.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8841a;
    private final Bitmap bitmap;
    private final e flipOption;

    public a(Bitmap bitmap, int i5, e flipOption) {
        E.f(bitmap, "bitmap");
        E.f(flipOption, "flipOption");
        this.bitmap = bitmap;
        this.f8841a = i5;
        this.flipOption = flipOption;
    }

    public final Bitmap component1() {
        return this.bitmap;
    }

    public final e component3() {
        return this.flipOption;
    }

    public final a copy(Bitmap bitmap, int i5, e flipOption) {
        E.f(bitmap, "bitmap");
        E.f(flipOption, "flipOption");
        return new a(bitmap, i5, flipOption);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return E.a(this.bitmap, aVar.bitmap) && this.f8841a == aVar.f8841a && E.a(this.flipOption, aVar.flipOption);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final e getFlipOption() {
        return this.flipOption;
    }

    public final int hashCode() {
        return this.flipOption.hashCode() + ((Integer.hashCode(this.f8841a) + (this.bitmap.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "BitmapWrapper(bitmap=" + this.bitmap + ", degree=" + this.f8841a + ", flipOption=" + this.flipOption + ')';
    }
}
