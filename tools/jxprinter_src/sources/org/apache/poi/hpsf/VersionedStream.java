package org.apache.poi.hpsf;

import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class VersionedStream {
    private final GUID _versionGuid = new GUID();
    private final IndirectPropertyName _streamName = new IndirectPropertyName();

    public void read(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this._versionGuid.read(littleEndianByteArrayInputStream);
        this._streamName.read(littleEndianByteArrayInputStream);
    }
}
