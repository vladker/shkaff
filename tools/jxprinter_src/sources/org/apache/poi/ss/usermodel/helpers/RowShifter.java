package org.apache.poi.ss.usermodel.helpers;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class RowShifter extends BaseRowColShifter {
    protected final Sheet sheet;

    public RowShifter(Sheet sheet) {
        this.sheet = sheet;
    }

    private boolean removalNeeded(CellRangeAddress cellRangeAddress, int i5, int i6, int i7) {
        CellRangeAddress cellRangeAddress2;
        int i8 = (i6 - i5) + 1;
        if (i7 > 0) {
            int i9 = i6 + 1;
            int i10 = i6 + i7;
            cellRangeAddress2 = new CellRangeAddress(Math.max(i9, i10 - i8), i10, 0, 0);
        } else {
            int i11 = i7 + i5;
            cellRangeAddress2 = new CellRangeAddress(i11, Math.min(i5 - 1, i8 + i11), 0, 0);
        }
        return cellRangeAddress.intersects(cellRangeAddress2);
    }

    public static void validateShiftLeftParameters(int i5, int i6, int i7) {
        validateShiftParameters(i5, i6, i7);
        if (i5 - i7 >= 0) {
            return;
        }
        throw new IllegalStateException("Column index less than zero: " + (i5 + i7));
    }

    public static void validateShiftParameters(int i5, int i6, int i7) {
        if (i7 < 0) {
            throw new IllegalArgumentException(AbstractC0157z.k(i7, "Shifting step may not be negative, but had "));
        }
        if (i5 > i6) {
            throw new IllegalArgumentException(String.format(LocaleUtil.getUserLocale(), "Incorrect shifting range : %d-%d", Integer.valueOf(i5), Integer.valueOf(i6)));
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
                boolean z7 = mergedRegion.getFirstRow() >= i5 || mergedRegion.getLastRow() >= i5;
                if (mergedRegion.getFirstRow() > i6 && mergedRegion.getLastRow() > i6) {
                    z6 = false;
                }
                if (z7 && z6 && !mergedRegion.containsRow(i5 - 1) && !mergedRegion.containsRow(i6 + 1)) {
                    mergedRegion.setFirstRow(mergedRegion.getFirstRow() + i7);
                    mergedRegion.setLastRow(mergedRegion.getLastRow() + i7);
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
