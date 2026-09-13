package p126w0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.a;
import com.bumptech.glide.load.resource.bitmap.K;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class p {
    public static int getOrientation(@NonNull List<g> list, @Nullable ByteBuffer byteBuffer, @NonNull a aVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return getOrientationInternal(list, new k(byteBuffer, aVar));
    }

    private static int getOrientationInternal(@NonNull List<g> list, n nVar) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int orientationAndRewind = nVar.getOrientationAndRewind(list.get(i5));
            if (orientationAndRewind != -1) {
                return orientationAndRewind;
            }
        }
        return -1;
    }

    @NonNull
    public static ImageHeaderParser$ImageType getType(@NonNull List<g> list, @Nullable InputStream inputStream, @NonNull a aVar) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new K(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return getTypeInternal(list, new h(inputStream));
    }

    @NonNull
    private static ImageHeaderParser$ImageType getTypeInternal(@NonNull List<g> list, o oVar) {
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            ImageHeaderParser$ImageType typeAndRewind = oVar.getTypeAndRewind(list.get(i5));
            if (typeAndRewind != ImageHeaderParser$ImageType.UNKNOWN) {
                return typeAndRewind;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static int getOrientation(@NonNull List<g> list, @Nullable InputStream inputStream, @NonNull a aVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new K(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return getOrientationInternal(list, new l(inputStream, aVar));
    }

    @RequiresApi(21)
    public static int getOrientation(@NonNull List<g> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull a aVar) {
        return getOrientationInternal(list, new m(parcelFileDescriptorRewinder, aVar));
    }

    @NonNull
    public static ImageHeaderParser$ImageType getType(@NonNull List<g> list, @Nullable ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        return getTypeInternal(list, new i(byteBuffer));
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser$ImageType getType(@NonNull List<g> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull a aVar) {
        return getTypeInternal(list, new j(parcelFileDescriptorRewinder, aVar));
    }
}
