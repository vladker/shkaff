package org.apache.poi.common.usermodel.fonts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum FontGroup {
    LATIN,
    EAST_ASIAN,
    SYMBOL,
    COMPLEX_SCRIPT;

    private static NavigableMap<Integer, Range> UCS_RANGES;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FontGroupRange {
        private final FontGroup fontGroup;
        private int len = 0;

        public FontGroupRange(FontGroup fontGroup) {
            this.fontGroup = fontGroup;
        }

        public FontGroup getFontGroup() {
            return this.fontGroup;
        }

        public int getLength() {
            return this.len;
        }

        public void increaseLength(int i5) {
            this.len += i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Range {
        private final FontGroup fontGroup;
        private final int upper;

        public Range(int i5, FontGroup fontGroup) {
            this.upper = i5;
            this.fontGroup = fontGroup;
        }

        public FontGroup getFontGroup() {
            return this.fontGroup;
        }

        public int getUpper() {
            return this.upper;
        }
    }

    static {
        FontGroup fontGroup = LATIN;
        FontGroup fontGroup2 = EAST_ASIAN;
        FontGroup fontGroup3 = SYMBOL;
        FontGroup fontGroup4 = COMPLEX_SCRIPT;
        TreeMap treeMap = new TreeMap();
        UCS_RANGES = treeMap;
        treeMap.put(0, new Range(127, fontGroup));
        UCS_RANGES.put(128, new Range(166, fontGroup));
        UCS_RANGES.put(169, new Range(175, fontGroup));
        UCS_RANGES.put(178, new Range(179, fontGroup));
        UCS_RANGES.put(181, new Range(214, fontGroup));
        UCS_RANGES.put(216, new Range(246, fontGroup));
        UCS_RANGES.put(248, new Range(1423, fontGroup));
        UCS_RANGES.put(1424, new Range(1871, fontGroup4));
        UCS_RANGES.put(1920, new Range(1983, fontGroup4));
        UCS_RANGES.put(2304, new Range(4255, fontGroup4));
        UCS_RANGES.put(4256, new Range(4351, fontGroup));
        UCS_RANGES.put(4608, new Range(4991, fontGroup));
        UCS_RANGES.put(5024, new Range(6015, fontGroup));
        UCS_RANGES.put(7424, new Range(7551, fontGroup));
        UCS_RANGES.put(7680, new Range(8191, fontGroup));
        UCS_RANGES.put(6016, new Range(6319, fontGroup4));
        UCS_RANGES.put(8192, new Range(8203, fontGroup));
        UCS_RANGES.put(8204, new Range(8207, fontGroup4));
        UCS_RANGES.put(8208, new Range(8233, fontGroup));
        UCS_RANGES.put(8234, new Range(8239, fontGroup4));
        UCS_RANGES.put(8240, new Range(8262, fontGroup));
        UCS_RANGES.put(8266, new Range(9311, fontGroup));
        UCS_RANGES.put(9840, new Range(9841, fontGroup4));
        UCS_RANGES.put(10176, new Range(11263, fontGroup));
        UCS_RANGES.put(12441, new Range(12442, fontGroup2));
        UCS_RANGES.put(55349, new Range(55349, fontGroup));
        UCS_RANGES.put(61440, new Range(61695, fontGroup3));
        UCS_RANGES.put(64256, new Range(64279, fontGroup));
        UCS_RANGES.put(64285, new Range(64335, fontGroup4));
        UCS_RANGES.put(65104, new Range(65135, fontGroup));
    }

    public static FontGroup getFontGroupFirst(String str) {
        return (str == null || str.isEmpty()) ? LATIN : lookup(str.codePointAt(0));
    }

    public static List<FontGroupRange> getFontGroupRanges(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            FontGroupRange fontGroupRange = null;
            int i5 = 0;
            while (i5 < length) {
                int iCodePointAt = str.codePointAt(i5);
                int iCharCount = Character.charCount(iCodePointAt);
                FontGroup fontGroupLookup = (fontGroupRange == null || " \n\r".indexOf(iCodePointAt) <= -1) ? lookup(iCodePointAt) : fontGroupRange.fontGroup;
                if (fontGroupRange == null || fontGroupRange.fontGroup != fontGroupLookup) {
                    fontGroupRange = new FontGroupRange(fontGroupLookup);
                    arrayList.add(fontGroupRange);
                }
                fontGroupRange.increaseLength(iCharCount);
                i5 += iCharCount;
            }
        }
        return arrayList;
    }

    private static FontGroup lookup(int i5) {
        Map.Entry<Integer, Range> entryFloorEntry = UCS_RANGES.floorEntry(Integer.valueOf(i5));
        Range value = entryFloorEntry != null ? entryFloorEntry.getValue() : null;
        return (value == null || i5 > value.getUpper()) ? EAST_ASIAN : value.getFontGroup();
    }
}
