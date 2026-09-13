package org.apache.poi.poifs.nio;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DataSource {
    public abstract void close();

    public abstract void copyTo(OutputStream outputStream);

    public abstract ByteBuffer read(int i5, long j6);

    public abstract long size();

    public abstract void write(ByteBuffer byteBuffer, long j6);
}
