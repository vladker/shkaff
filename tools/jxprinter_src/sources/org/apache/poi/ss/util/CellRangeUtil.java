package org.apache.poi.ss.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CellRangeUtil {
    public static final int ENCLOSES = 4;
    public static final int INSIDE = 3;
    public static final int NO_INTERSECTION = 1;
    public static final int OVERLAP = 2;

    private CellRangeUtil() {
    }

    public static boolean contains(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        return le(cellRangeAddress.getFirstRow(), cellRangeAddress2.getFirstRow()) && ge(cellRangeAddress.getLastRow(), cellRangeAddress2.getLastRow()) && le(cellRangeAddress.getFirstColumn(), cellRangeAddress2.getFirstColumn()) && ge(cellRangeAddress.getLastColumn(), cellRangeAddress2.getLastColumn());
    }

    public static CellRangeAddress createEnclosingCellRange(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        if (cellRangeAddress2 == null) {
            return cellRangeAddress.copy();
        }
        return new CellRangeAddress(lt(cellRangeAddress2.getFirstRow(), cellRangeAddress.getFirstRow()) ? cellRangeAddress2.getFirstRow() : cellRangeAddress.getFirstRow(), gt(cellRangeAddress2.getLastRow(), cellRangeAddress.getLastRow()) ? cellRangeAddress2.getLastRow() : cellRangeAddress.getLastRow(), lt(cellRangeAddress2.getFirstColumn(), cellRangeAddress.getFirstColumn()) ? cellRangeAddress2.getFirstColumn() : cellRangeAddress.getFirstColumn(), gt(cellRangeAddress2.getLastColumn(), cellRangeAddress.getLastColumn()) ? cellRangeAddress2.getLastColumn() : cellRangeAddress.getLastColumn());
    }

    private static boolean ge(int i5, int i6) {
        return !lt(i5, i6);
    }

    private static boolean gt(int i5, int i6) {
        return lt(i6, i5);
    }

    public static boolean hasExactSharedBorder(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow = cellRangeAddress2.getFirstRow();
        int lastRow = cellRangeAddress2.getLastRow();
        int firstColumn = cellRangeAddress2.getFirstColumn();
        int lastColumn = cellRangeAddress2.getLastColumn();
        if ((cellRangeAddress.getFirstRow() <= 0 || cellRangeAddress.getFirstRow() - 1 != lastRow) && (firstRow <= 0 || firstRow - 1 != cellRangeAddress.getLastRow())) {
            return ((cellRangeAddress.getFirstColumn() > 0 && cellRangeAddress.getFirstColumn() - 1 == lastColumn) || (firstColumn > 0 && cellRangeAddress.getLastColumn() == firstColumn - 1)) && cellRangeAddress.getFirstRow() == firstRow && cellRangeAddress.getLastRow() == lastRow;
        }
        return cellRangeAddress.getFirstColumn() == firstColumn && cellRangeAddress.getLastColumn() == lastColumn;
    }

    public static int intersect(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int firstRow = cellRangeAddress2.getFirstRow();
        int lastRow = cellRangeAddress2.getLastRow();
        int firstColumn = cellRangeAddress2.getFirstColumn();
        int lastColumn = cellRangeAddress2.getLastColumn();
        if (gt(cellRangeAddress.getFirstRow(), lastRow) || lt(cellRangeAddress.getLastRow(), firstRow) || gt(cellRangeAddress.getFirstColumn(), lastColumn) || lt(cellRangeAddress.getLastColumn(), firstColumn)) {
            return 1;
        }
        if (contains(cellRangeAddress, cellRangeAddress2)) {
            return 3;
        }
        return contains(cellRangeAddress2, cellRangeAddress) ? 4 : 2;
    }

    private static boolean le(int i5, int i6) {
        return i5 == i6 || lt(i5, i6);
    }

    private static boolean lt(int i5, int i6) {
        if (i5 == -1) {
            return false;
        }
        return i6 == -1 || i5 < i6;
    }

    public static CellRangeAddress[] mergeCellRanges(CellRangeAddress[] cellRangeAddressArr) {
        return cellRangeAddressArr.length < 1 ? new CellRangeAddress[0] : toArray(mergeCellRanges(toList(cellRangeAddressArr)));
    }

    private static CellRangeAddress[] mergeRanges(CellRangeAddress cellRangeAddress, CellRangeAddress cellRangeAddress2) {
        int iIntersect = intersect(cellRangeAddress, cellRangeAddress2);
        if (iIntersect == 1) {
            if (hasExactSharedBorder(cellRangeAddress, cellRangeAddress2)) {
                return new CellRangeAddress[]{createEnclosingCellRange(cellRangeAddress, cellRangeAddress2)};
            }
            return null;
        }
        if (iIntersect == 2) {
            return null;
        }
        if (iIntersect == 3) {
            return new CellRangeAddress[]{cellRangeAddress};
        }
        if (iIntersect == 4) {
            return new CellRangeAddress[]{cellRangeAddress2};
        }
        throw new RuntimeException(androidx.collection.a.i(iIntersect, "unexpected intersection result (", ")"));
    }

    private static CellRangeAddress[] toArray(List<CellRangeAddress> list) {
        CellRangeAddress[] cellRangeAddressArr = new CellRangeAddress[list.size()];
        list.toArray(cellRangeAddressArr);
        return cellRangeAddressArr;
    }

    private static List<CellRangeAddress> toList(CellRangeAddress[] cellRangeAddressArr) {
        ArrayList arrayList = new ArrayList(cellRangeAddressArr.length);
        Collections.addAll(arrayList, cellRangeAddressArr);
        return arrayList;
    }

    private static List<CellRangeAddress> mergeCellRanges(List<CellRangeAddress> list) {
        while (list.size() > 1) {
            int i5 = 0;
            boolean z6 = false;
            while (i5 < list.size()) {
                CellRangeAddress cellRangeAddress = list.get(i5);
                int i6 = i5 + 1;
                int i7 = i6;
                while (i7 < list.size()) {
                    CellRangeAddress[] cellRangeAddressArrMergeRanges = mergeRanges(cellRangeAddress, list.get(i7));
                    if (cellRangeAddressArrMergeRanges != null) {
                        CellRangeAddress cellRangeAddress2 = cellRangeAddressArrMergeRanges[0];
                        list.set(i5, cellRangeAddress2);
                        list.remove(i7);
                        i7--;
                        for (int i8 = 1; i8 < cellRangeAddressArrMergeRanges.length; i8++) {
                            i7++;
                            list.add(i7, cellRangeAddressArrMergeRanges[i8]);
                        }
                        cellRangeAddress = cellRangeAddress2;
                        z6 = true;
                    }
                    i7++;
                }
                i5 = i6;
            }
            if (!z6) {
                break;
            }
        }
        return list;
    }
}
