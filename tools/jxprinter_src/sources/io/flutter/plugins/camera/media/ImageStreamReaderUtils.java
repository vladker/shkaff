package io.flutter.plugins.camera.media;

import android.media.Image;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageStreamReaderUtils {
    private static boolean areUVPlanesNV21(@NonNull Image.Plane[] planeArr, int i5, int i6) {
        int i7 = i5 * i6;
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        boolean z6 = buffer2.remaining() == ((i7 * 2) / 4) - 2 && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        return z6;
    }

    private static void unpackPlane(@NonNull Image.Plane plane, int i5, int i6, byte[] bArr, int i7, int i8) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int rowStride = ((plane.getRowStride() + buffer.limit()) - 1) / plane.getRowStride();
        if (rowStride == 0) {
            return;
        }
        int i9 = i5 / (i6 / rowStride);
        int rowStride2 = 0;
        for (int i10 = 0; i10 < rowStride; i10++) {
            int pixelStride = rowStride2;
            for (int i11 = 0; i11 < i9; i11++) {
                bArr[i7] = buffer.get(pixelStride);
                i7 += i8;
                pixelStride += plane.getPixelStride();
            }
            rowStride2 += plane.getRowStride();
        }
    }

    @NonNull
    public ByteBuffer yuv420ThreePlanesToNV21(@NonNull Image.Plane[] planeArr, int i5, int i6) {
        int i7 = i5 * i6;
        byte[] bArr = new byte[((i7 / 4) * 2) + i7];
        if (areUVPlanesNV21(planeArr, i5, i6)) {
            planeArr[0].getBuffer().get(bArr, 0, i7);
            ByteBuffer buffer = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i7, 1);
            buffer.get(bArr, i7 + 1, ((i7 * 2) / 4) - 1);
        } else {
            unpackPlane(planeArr[0], i5, i6, bArr, 0, 1);
            unpackPlane(planeArr[1], i5, i6, bArr, i7 + 1, 2);
            unpackPlane(planeArr[2], i5, i6, bArr, i7, 2);
        }
        return ByteBuffer.wrap(bArr);
    }
}
