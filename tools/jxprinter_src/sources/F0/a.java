package F0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.O;
import java.io.ByteArrayOutputStream;
import p126w0.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap.CompressFormat f237a;
    public final int b;

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i5) {
        this.f237a = compressFormat;
        this.b = i5;
    }

    @Override // F0.e
    @Nullable
    public O transcode(@NonNull O o6, @NonNull v vVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) o6.get()).compress(this.f237a, this.b, byteArrayOutputStream);
        o6.recycle();
        return new C0.c(byteArrayOutputStream.toByteArray());
    }
}
