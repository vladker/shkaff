package D0;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.O;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p126w0.p;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f159a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a b;

    public d(List list, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f159a = list;
        this.b = aVar;
    }

    public O decode(@NonNull ImageDecoder.Source source, int i5, int i6, @NonNull v vVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new B0.c(i5, i6, vVar));
        if (B0.a.v(drawableDecodeDrawable)) {
            return new a(B0.a.i(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    public boolean handles(ByteBuffer byteBuffer) {
        ImageHeaderParser$ImageType type = p.getType(this.f159a, byteBuffer);
        if (type != ImageHeaderParser$ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && type == ImageHeaderParser$ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    public boolean handles(InputStream inputStream) {
        ImageHeaderParser$ImageType type = p.getType((List<p126w0.g>) this.f159a, inputStream, this.b);
        if (type != ImageHeaderParser$ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && type == ImageHeaderParser$ImageType.ANIMATED_AVIF;
        }
        return true;
    }
}
