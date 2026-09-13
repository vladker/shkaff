package org.apache.poi.common.usermodel;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface GenericRecord {
    default List<? extends GenericRecord> getGenericChildren() {
        return null;
    }

    Map<String, Supplier<?>> getGenericProperties();

    default Enum<?> getGenericRecordType() {
        return null;
    }
}
