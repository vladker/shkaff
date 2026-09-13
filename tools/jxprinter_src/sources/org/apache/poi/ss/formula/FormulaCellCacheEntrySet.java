package org.apache.poi.ss.formula;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
final class FormulaCellCacheEntrySet {
    private static final FormulaCellCacheEntry[] EMPTY_ARRAY = new FormulaCellCacheEntry[0];
    private FormulaCellCacheEntry[] _arr = EMPTY_ARRAY;
    private int _size;

    private static boolean addInternal(CellCacheEntry[] cellCacheEntryArr, CellCacheEntry cellCacheEntry) {
        int iAbs = Math.abs(cellCacheEntry.hashCode() % cellCacheEntryArr.length);
        for (int i5 = iAbs; i5 < cellCacheEntryArr.length; i5++) {
            CellCacheEntry cellCacheEntry2 = cellCacheEntryArr[i5];
            if (cellCacheEntry2 == cellCacheEntry) {
                return false;
            }
            if (cellCacheEntry2 == null) {
                cellCacheEntryArr[i5] = cellCacheEntry;
                return true;
            }
        }
        for (int i6 = 0; i6 < iAbs; i6++) {
            CellCacheEntry cellCacheEntry3 = cellCacheEntryArr[i6];
            if (cellCacheEntry3 == cellCacheEntry) {
                return false;
            }
            if (cellCacheEntry3 == null) {
                cellCacheEntryArr[i6] = cellCacheEntry;
                return true;
            }
        }
        throw new IllegalStateException("No empty space found");
    }

    public void add(CellCacheEntry cellCacheEntry) {
        int i5 = this._size * 3;
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = this._arr;
        if (i5 >= formulaCellCacheEntryArr.length * 2) {
            FormulaCellCacheEntry[] formulaCellCacheEntryArr2 = new FormulaCellCacheEntry[androidx.collection.a.c(formulaCellCacheEntryArr.length, 3, 2, 4)];
            for (int i6 = 0; i6 < formulaCellCacheEntryArr.length; i6++) {
                FormulaCellCacheEntry formulaCellCacheEntry = this._arr[i6];
                if (formulaCellCacheEntry != null) {
                    addInternal(formulaCellCacheEntryArr2, formulaCellCacheEntry);
                }
            }
            this._arr = formulaCellCacheEntryArr2;
        }
        if (addInternal(this._arr, cellCacheEntry)) {
            this._size++;
        }
    }

    public boolean remove(CellCacheEntry cellCacheEntry) {
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = this._arr;
        if (this._size * 3 < formulaCellCacheEntryArr.length && formulaCellCacheEntryArr.length > 8) {
            FormulaCellCacheEntry[] formulaCellCacheEntryArr2 = new FormulaCellCacheEntry[formulaCellCacheEntryArr.length / 2];
            boolean z6 = false;
            for (int i5 = 0; i5 < formulaCellCacheEntryArr.length; i5++) {
                FormulaCellCacheEntry formulaCellCacheEntry = this._arr[i5];
                if (formulaCellCacheEntry != null) {
                    if (formulaCellCacheEntry == cellCacheEntry) {
                        this._size--;
                        z6 = true;
                    } else {
                        addInternal(formulaCellCacheEntryArr2, formulaCellCacheEntry);
                    }
                }
            }
            this._arr = formulaCellCacheEntryArr2;
            return z6;
        }
        int iAbs = Math.abs(cellCacheEntry.hashCode() % formulaCellCacheEntryArr.length);
        for (int i6 = iAbs; i6 < formulaCellCacheEntryArr.length; i6++) {
            if (formulaCellCacheEntryArr[i6] == cellCacheEntry) {
                formulaCellCacheEntryArr[i6] = null;
                this._size--;
                return true;
            }
        }
        for (int i7 = 0; i7 < iAbs; i7++) {
            if (formulaCellCacheEntryArr[i7] == cellCacheEntry) {
                formulaCellCacheEntryArr[i7] = null;
                this._size--;
                return true;
            }
        }
        return false;
    }

    public FormulaCellCacheEntry[] toArray() {
        int i5 = this._size;
        if (i5 < 1) {
            return EMPTY_ARRAY;
        }
        FormulaCellCacheEntry[] formulaCellCacheEntryArr = new FormulaCellCacheEntry[i5];
        int i6 = 0;
        for (FormulaCellCacheEntry formulaCellCacheEntry : this._arr) {
            if (formulaCellCacheEntry != null) {
                formulaCellCacheEntryArr[i6] = formulaCellCacheEntry;
                i6++;
            }
        }
        if (i6 == i5) {
            return formulaCellCacheEntryArr;
        }
        throw new IllegalStateException("size mismatch");
    }
}
