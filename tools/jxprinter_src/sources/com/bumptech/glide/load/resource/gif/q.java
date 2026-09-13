package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.engine.O;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import p126w0.v;
import p126w0.x;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3160a;
    public final c b;
    public final com.bumptech.glide.load.engine.bitmap_recycle.a c;

    public q(List list, c cVar, com.bumptech.glide.load.engine.bitmap_recycle.a aVar) {
        this.f3160a = list;
        this.b = cVar;
        this.c = aVar;
    }

    @Override // p126w0.x
    public O decode(@NonNull InputStream inputStream, int i5, int i6, @NonNull v vVar) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i7 = inputStream.read(bArr);
                if (i7 == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i7);
            }
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            byteArray = null;
        }
        if (byteArray == null) {
            return null;
        }
        return this.b.decode((Object) ByteBuffer.wrap(byteArray), i5, i6, vVar);
    }

    @Override // p126w0.x
    public boolean handles(@NonNull InputStream inputStream, @NonNull v vVar) {
        return !((Boolean) vVar.get(p.b)).booleanValue() && p126w0.p.getType((List<p126w0.g>) this.f3160a, inputStream, this.c) == ImageHeaderParser$ImageType.GIF;
    }
}
