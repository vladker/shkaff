package p126w0;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.bitmap_recycle.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface g {
    int getOrientation(@NonNull InputStream inputStream, @NonNull a aVar);

    int getOrientation(@NonNull ByteBuffer byteBuffer, @NonNull a aVar);

    @NonNull
    ImageHeaderParser$ImageType getType(@NonNull InputStream inputStream);

    @NonNull
    ImageHeaderParser$ImageType getType(@NonNull ByteBuffer byteBuffer);
}
