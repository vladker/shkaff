package org.apache.poi.ss;

import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum SpreadsheetVersion {
    EXCEL97(65536, 256, 30, 3, 4000, 32767),
    EXCEL2007(1048576, 16384, 255, Integer.MAX_VALUE, 64000, 32767);

    private final int _maxCellStyles;
    private final int _maxColumns;
    private final int _maxCondFormats;
    private final int _maxFunctionArgs;
    private final int _maxRows;
    private final int _maxTextLength;

    SpreadsheetVersion(int i5, int i6, int i7, int i8, int i9, int i10) {
        this._maxRows = i5;
        this._maxColumns = i6;
        this._maxFunctionArgs = i7;
        this._maxCondFormats = i8;
        this._maxCellStyles = i9;
        this._maxTextLength = i10;
    }

    public int getLastColumnIndex() {
        return this._maxColumns - 1;
    }

    public String getLastColumnName() {
        return CellReference.convertNumToColString(getLastColumnIndex());
    }

    public int getLastRowIndex() {
        return this._maxRows - 1;
    }

    public int getMaxCellStyles() {
        return this._maxCellStyles;
    }

    public int getMaxColumns() {
        return this._maxColumns;
    }

    public int getMaxConditionalFormats() {
        return this._maxCondFormats;
    }

    public int getMaxFunctionArgs() {
        return this._maxFunctionArgs;
    }

    public int getMaxRows() {
        return this._maxRows;
    }

    public int getMaxTextLength() {
        return this._maxTextLength;
    }
}
