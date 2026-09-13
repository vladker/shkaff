package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base16OutputStream extends BaseNCodecOutputStream {
    public Base16OutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public Base16OutputStream(OutputStream outputStream, boolean z6) {
        this(outputStream, z6, false);
    }

    public Base16OutputStream(OutputStream outputStream, boolean z6, boolean z7) {
        this(outputStream, z6, z7, CodecPolicy.LENIENT);
    }

    public Base16OutputStream(OutputStream outputStream, boolean z6, boolean z7, CodecPolicy codecPolicy) {
        super(outputStream, new Base16(z7, codecPolicy), z6);
    }
}
