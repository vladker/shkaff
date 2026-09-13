package org.apache.poi.hssf.record;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.util.IntMapper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class SSTDeserializer {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SSTDeserializer.class);
    private IntMapper<UnicodeString> strings;

    public SSTDeserializer(IntMapper<UnicodeString> intMapper) {
        this.strings = intMapper;
    }

    public static void addToStringTable(IntMapper<UnicodeString> intMapper, UnicodeString unicodeString) {
        intMapper.add(unicodeString);
    }

    public void manufactureStrings(int i5, RecordInputStream recordInputStream) {
        UnicodeString unicodeString;
        for (int i6 = 0; i6 < i5; i6++) {
            if (recordInputStream.available() != 0 || recordInputStream.hasNextRecord()) {
                unicodeString = new UnicodeString(recordInputStream);
            } else {
                LOG.atError().log("Ran out of data before creating all the strings! String at index {}", Unbox.box(i6));
                unicodeString = new UnicodeString("");
            }
            addToStringTable(this.strings, unicodeString);
        }
    }
}
