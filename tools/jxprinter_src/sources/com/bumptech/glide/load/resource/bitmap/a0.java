package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements b0 {
    @Override // com.bumptech.glide.load.resource.bitmap.b0
    public final void a(Object obj, MediaMetadataRetriever mediaMetadataRetriever) {
        mediaMetadataRetriever.setDataSource(new Z((ByteBuffer) obj));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.b0
    public void initializeExtractor(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
        mediaExtractor.setDataSource(new Z(byteBuffer));
    }
}
