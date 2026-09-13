package org.apache.poi.ddf;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface EscherSerializationListener {
    void afterRecordSerialize(int i5, short s6, int i6, EscherRecord escherRecord);

    void beforeRecordSerialize(int i5, short s6, EscherRecord escherRecord);
}
