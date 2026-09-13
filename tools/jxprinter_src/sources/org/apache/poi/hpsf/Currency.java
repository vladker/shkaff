package org.apache.poi.hpsf;

import java.io.IOException;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class Currency {
    private static final int SIZE = 8;
    private final byte[] _value = new byte[8];

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) throws IOException {
        littleEndianByteArrayInputStream.readFully(this._value);
    }
}
