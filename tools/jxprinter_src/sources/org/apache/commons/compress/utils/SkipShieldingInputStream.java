package org.apache.commons.compress.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SkipShieldingInputStream extends FilterInputStream {
    private static final byte[] SKIP_BUFFER = new byte[8192];
    private static final int SKIP_BUFFER_SIZE = 8192;

    public SkipShieldingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) {
        if (j6 < 0) {
            return 0L;
        }
        return read(SKIP_BUFFER, 0, (int) Math.min(j6, PlaybackStateCompat.ACTION_PLAY_FROM_URI));
    }
}
