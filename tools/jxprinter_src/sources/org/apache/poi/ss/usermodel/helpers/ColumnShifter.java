package org.apache.poi.ss.usermodel.helpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ColumnShifter extends BaseRowColShifter {
    protected final Sheet sheet;

    public ColumnShifter(Sheet sheet) {
        this.sheet = sheet;
    }

    private boolean removalNeeded(CellRangeAddress cellRangeAddress, int i5, int i6, int i7) {
        CellRangeAddress cellRangeAddress2;
        int i8 = (i6 - i5) + 1;
        if (i7 > 0) {
            int i9 = i6 + 1;
            int i10 = i6 + i7;
            cellRangeAddress2 = new CellRangeAddress(0, 0, Math.max(i9, i10 - i8), i10);
        } else {
            int i11 = i7 + i5;
            cellRangeAddress2 = new CellRangeAddress(0, 0, i11, Math.min(i5 - 1, i8 + i11));
        }
        return cellRangeAddress.intersects(cellRangeAddress2);
    }

    public void shiftColumns(int i5, int i6, int i7) {
        if (i7 > 0) {
            for (Row row : this.sheet) {
                if (row != null) {
                    row.shiftCellsRight(i5, i6, i7);
                }
            }
            return;
        }
        if (i7 < 0) {
            for (Row row2 : this.sheet) {
                if (row2 != null) {
                    row2.shiftCellsLeft(i5, i6, -i7);
                }
            }
        }
    }

    @Override // org.apache.poi.ss.usermodel.helpers.BaseRowColShifter
    public List<CellRangeAddress> shiftMergedRegions(int i5, int i6, int i7) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int numMergedRegions = this.sheet.getNumMergedRegions();
        int i8 = 0;
        for (int i9 = 0; i9 < numMergedRegions; i9++) {
            CellRangeAddress mergedRegion = this.sheet.getMergedRegion(i9);
            if (removalNeeded(mergedRegion, i5, i6, i7)) {
                hashSet.add(Integer.valueOf(i9));
            } else {
                boolean z6 = true;
                boolean z7 = mergedRegion.getFirstColumn() >= i5 || mergedRegion.getLastColumn() >= i5;
                if (mergedRegion.getFirstColumn() > i6 && mergedRegion.getLastColumn() > i6) {
                    z6 = false;
                }
                if (z7 && z6 && !mergedRegion.containsColumn(i5 - 1) && !mergedRegion.containsColumn(i6 + 1)) {
                    mergedRegion.setFirstColumn(mergedRegion.getFirstColumn() + i7);
                    mergedRegion.setLastColumn(mergedRegion.getLastColumn() + i7);
                    arrayList.add(mergedRegion);
                    hashSet.add(Integer.valueOf(i9));
                }
            }
        }
        if (!hashSet.isEmpty()) {
            this.sheet.removeMergedRegions(hashSet);
        }
        int size = arrayList.size();
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            this.sheet.addMergedRegion((CellRangeAddress) obj);
        }
        return arrayList;
    }
}
