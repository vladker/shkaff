package org.apache.poi.ss.formula.ptg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface AreaI {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class OffsetArea implements AreaI {
        private final int _firstColumn;
        private final int _firstRow;
        private final int _lastColumn;
        private final int _lastRow;

        public OffsetArea(int i5, int i6, int i7, int i8, int i9, int i10) {
            this._firstRow = Math.min(i7, i8) + i5;
            this._lastRow = Math.max(i7, i8) + i5;
            this._firstColumn = Math.min(i9, i10) + i6;
            this._lastColumn = Math.max(i9, i10) + i6;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstColumn() {
            return this._firstColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getFirstRow() {
            return this._firstRow;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastColumn() {
            return this._lastColumn;
        }

        @Override // org.apache.poi.ss.formula.ptg.AreaI
        public int getLastRow() {
            return this._lastRow;
        }
    }

    int getFirstColumn();

    int getFirstRow();

    int getLastColumn();

    int getLastRow();
}
