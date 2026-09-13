package org.apache.poi.ss.formula;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class PlainCellCache {
    private Map<Loc, PlainValueCellCacheEntry> _plainValueEntriesByLoc = new HashMap();

    public void clear() {
        this._plainValueEntriesByLoc.clear();
    }

    public PlainValueCellCacheEntry get(Loc loc) {
        return this._plainValueEntriesByLoc.get(loc);
    }

    public void put(Loc loc, PlainValueCellCacheEntry plainValueCellCacheEntry) {
        this._plainValueEntriesByLoc.put(loc, plainValueCellCacheEntry);
    }

    public void remove(Loc loc) {
        this._plainValueEntriesByLoc.remove(loc);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Loc {
        private final long _bookSheetColumn;
        private final int _rowIndex;

        public Loc(int i5, int i6, int i7, int i8) {
            this._bookSheetColumn = toBookSheetColumn(i5, i6, i8);
            this._rowIndex = i7;
        }

        public static long toBookSheetColumn(int i5, int i6, int i7) {
            return ((((long) i5) & 65535) << 48) + ((((long) i6) & 65535) << 32) + (((long) i7) & 65535);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Loc)) {
                return false;
            }
            Loc loc = (Loc) obj;
            return this._bookSheetColumn == loc._bookSheetColumn && this._rowIndex == loc._rowIndex;
        }

        public int getBookIndex() {
            return (int) ((this._bookSheetColumn >> 48) & 65535);
        }

        public int getColumnIndex() {
            return (int) (this._bookSheetColumn & 65535);
        }

        public int getRowIndex() {
            return this._rowIndex;
        }

        public int getSheetIndex() {
            return (int) ((this._bookSheetColumn >> 32) & 65535);
        }

        public int hashCode() {
            long j6 = this._bookSheetColumn;
            return (this._rowIndex * 17) + ((int) (j6 ^ (j6 >>> 32)));
        }

        public Loc(long j6, int i5) {
            this._bookSheetColumn = j6;
            this._rowIndex = i5;
        }
    }
}
