package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.CodecPolicy;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Base16InputStream extends BaseNCodecInputStream {
    public Base16InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public Base16InputStream(InputStream inputStream, boolean z6) {
        this(inputStream, z6, false);
    }

    public Base16InputStream(InputStream inputStream, boolean z6, boolean z7) {
        this(inputStream, z6, z7, CodecPolicy.LENIENT);
    }

    public Base16InputStream(InputStream inputStream, boolean z6, boolean z7, CodecPolicy codecPolicy) {
        super(inputStream, new Base16(z7, codecPolicy), z6);
    }
}
