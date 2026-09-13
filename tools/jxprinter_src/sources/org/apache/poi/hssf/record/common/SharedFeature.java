package org.apache.poi.hssf.record.common;

import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface SharedFeature extends GenericRecord {
    SharedFeature copy();

    int getDataSize();

    void serialize(LittleEndianOutput littleEndianOutput);

    String toString();
}
