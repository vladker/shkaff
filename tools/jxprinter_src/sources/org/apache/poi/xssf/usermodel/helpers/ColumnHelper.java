package org.apache.poi.xssf.usermodel.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.util.CTColComparator;
import org.apache.poi.xssf.util.NumericRanges;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCols;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ColumnHelper {
    private CTWorksheet worksheet;

    public ColumnHelper(CTWorksheet cTWorksheet) {
        this.worksheet = cTWorksheet;
        cleanColumns();
    }

    private CTCol cloneCol(CTCols cTCols, CTCol cTCol, long[] jArr) {
        CTCol cTColCloneCol = cloneCol(cTCols, cTCol);
        cTColCloneCol.setMin(jArr[0]);
        cTColCloneCol.setMax(jArr[1]);
        return cTColCloneCol;
    }

    private boolean columnExists1Based(CTCols cTCols, long j6) {
        for (CTCol cTCol : cTCols.getColArray()) {
            if (cTCol.getMin() == j6) {
                return true;
            }
        }
        return false;
    }

    private long[] getOverlap(CTCol cTCol, CTCol cTCol2) {
        return getOverlappingRange(cTCol, cTCol2);
    }

    private List<CTCol> getOverlappingCols(CTCol cTCol, TreeSet<CTCol> treeSet) {
        CTCol cTColLower = treeSet.lower(cTCol);
        TreeSet<CTCol> treeSetTailSet = treeSet;
        if (cTColLower != null) {
            treeSetTailSet = treeSet.tailSet(cTColLower, overlaps(cTColLower, cTCol));
        }
        ArrayList arrayList = new ArrayList();
        for (CTCol cTCol2 : treeSetTailSet) {
            if (!overlaps(cTCol, cTCol2)) {
                break;
            }
            arrayList.add(cTCol2);
        }
        return arrayList;
    }

    private long[] getOverlappingRange(CTCol cTCol, CTCol cTCol2) {
        return NumericRanges.getOverlappingRange(toRange(cTCol), toRange(cTCol2));
    }

    private CTCol insertCol(CTCols cTCols, long j6, long j7, CTCol[] cTColArr) {
        return insertCol(cTCols, j6, j7, cTColArr, false, null);
    }

    private boolean overlaps(CTCol cTCol, CTCol cTCol2) {
        return NumericRanges.getOverlappingType(toRange(cTCol), toRange(cTCol2)) != -1;
    }

    public static void sortColumns(CTCols cTCols) {
        CTCol[] colArray = cTCols.getColArray();
        Arrays.sort(colArray, CTColComparator.BY_MIN_MAX);
        cTCols.setColArray(colArray);
    }

    private long[] toRange(CTCol cTCol) {
        return new long[]{cTCol.getMin(), cTCol.getMax()};
    }

    public CTCols addCleanColIntoCols(CTCols cTCols, CTCol cTCol) {
        TreeSet<CTCol> treeSet = new TreeSet<>(CTColComparator.BY_MIN_MAX);
        treeSet.addAll(cTCols.getColList());
        addCleanColIntoCols(cTCols, cTCol, treeSet);
        cTCols.setColArray((CTCol[]) treeSet.toArray(new CTCol[0]));
        return cTCols;
    }

    public void cleanColumns() {
        TreeSet<CTCol> treeSet = new TreeSet<>(CTColComparator.BY_MIN_MAX);
        CTCols cTColsNewInstance = CTCols.Factory.newInstance();
        CTCols[] colsArray = this.worksheet.getColsArray();
        int i5 = 0;
        while (i5 < colsArray.length) {
            Iterator<CTCol> it = colsArray[i5].getColList().iterator();
            while (it.hasNext()) {
                addCleanColIntoCols(cTColsNewInstance, it.next(), treeSet);
            }
            i5++;
        }
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            this.worksheet.removeCols(i6);
        }
        cTColsNewInstance.setColArray((CTCol[]) treeSet.toArray(new CTCol[0]));
        this.worksheet.addNewCols();
        this.worksheet.setColsArray(0, cTColsNewInstance);
    }

    public boolean columnExists(CTCols cTCols, long j6) {
        return columnExists1Based(cTCols, j6 + 1);
    }

    public int getColDefaultStyle(long j6) {
        if (getColumn(j6, false) != null) {
            return (int) getColumn(j6, false).getStyle();
        }
        return -1;
    }

    public CTCol getColumn(long j6, boolean z6) {
        return getColumn1Based(j6 + 1, z6);
    }

    public CTCol getColumn1Based(long j6, boolean z6) {
        ColumnHelper columnHelper = this;
        CTCol cTCol = null;
        if (columnHelper.worksheet.sizeOfColsArray() == 0) {
            return null;
        }
        CTCols colsArray = columnHelper.worksheet.getColsArray(0);
        CTCol[] colArray = colsArray.getColArray();
        int length = colArray.length;
        int i5 = 0;
        while (i5 < length) {
            CTCol cTCol2 = colArray[i5];
            CTCol cTCol3 = cTCol;
            CTCol[] cTColArr = colArray;
            long min = cTCol2.getMin();
            long max = cTCol2.getMax();
            if (min <= j6 && max >= j6) {
                if (z6) {
                    if (min < j6) {
                        columnHelper.insertCol(colsArray, min, j6 - 1, new CTCol[]{cTCol2});
                    }
                    if (max > j6) {
                        insertCol(colsArray, j6 + 1, max, new CTCol[]{cTCol2});
                    }
                    cTCol2.setMin(j6);
                    cTCol2.setMax(j6);
                }
                return cTCol2;
            }
            i5++;
            columnHelper = this;
            colArray = cTColArr;
            cTCol = cTCol3;
        }
        return cTCol;
    }

    public int getIndexOfColumn(CTCols cTCols, CTCol cTCol) {
        if (cTCols != null && cTCol != null) {
            int i5 = 0;
            for (CTCol cTCol2 : cTCols.getColList()) {
                if (cTCol2.getMin() == cTCol.getMin() && cTCol2.getMax() == cTCol.getMax()) {
                    return i5;
                }
                i5++;
            }
        }
        return -1;
    }

    public CTCol getOrCreateColumn1Based(long j6, boolean z6) {
        CTCol column1Based = getColumn1Based(j6, z6);
        if (column1Based != null) {
            return column1Based;
        }
        CTCol cTColAddNewCol = this.worksheet.getColsArray(0).addNewCol();
        cTColAddNewCol.setMin(j6);
        cTColAddNewCol.setMax(j6);
        return cTColAddNewCol;
    }

    public void setColBestFit(long j6, boolean z6) {
        getOrCreateColumn1Based(j6 + 1, false).setBestFit(z6);
    }

    public void setColDefaultStyle(long j6, CellStyle cellStyle) {
        setColDefaultStyle(j6, cellStyle.getIndex());
    }

    public void setColHidden(long j6, boolean z6) {
        getOrCreateColumn1Based(j6 + 1, true).setHidden(z6);
    }

    public void setColWidth(long j6, double d) {
        getOrCreateColumn1Based(j6 + 1, true).setWidth(d);
    }

    public void setColumnAttributes(CTCol cTCol, CTCol cTCol2) {
        if (cTCol.isSetBestFit()) {
            cTCol2.setBestFit(cTCol.getBestFit());
        }
        if (cTCol.isSetCustomWidth()) {
            cTCol2.setCustomWidth(cTCol.getCustomWidth());
        }
        if (cTCol.isSetHidden()) {
            cTCol2.setHidden(cTCol.getHidden());
        }
        if (cTCol.isSetStyle()) {
            cTCol2.setStyle(cTCol.getStyle());
        }
        if (cTCol.isSetWidth()) {
            cTCol2.setWidth(cTCol.getWidth());
        }
        if (cTCol.isSetCollapsed()) {
            cTCol2.setCollapsed(cTCol.getCollapsed());
        }
        if (cTCol.isSetPhonetic()) {
            cTCol2.setPhonetic(cTCol.getPhonetic());
        }
        if (cTCol.isSetOutlineLevel()) {
            cTCol2.setOutlineLevel(cTCol.getOutlineLevel());
        }
    }

    public void setCustomWidth(long j6, boolean z6) {
        getOrCreateColumn1Based(j6 + 1, true).setCustomWidth(z6);
    }

    private boolean columnExists(CTCols cTCols, long j6, long j7) {
        for (CTCol cTCol : cTCols.getColList()) {
            if (cTCol.getMin() == j6 && cTCol.getMax() == j7) {
                return true;
            }
        }
        return false;
    }

    private CTCol insertCol(CTCols cTCols, long j6, long j7, CTCol[] cTColArr, boolean z6, CTCol cTCol) {
        if (!z6 && columnExists(cTCols, j6, j7)) {
            return null;
        }
        CTCol cTColInsertNewCol = cTCols.insertNewCol(0);
        cTColInsertNewCol.setMin(j6);
        cTColInsertNewCol.setMax(j7);
        for (CTCol cTCol2 : cTColArr) {
            setColumnAttributes(cTCol2, cTColInsertNewCol);
        }
        if (cTCol != null) {
            setColumnAttributes(cTCol, cTColInsertNewCol);
        }
        return cTColInsertNewCol;
    }

    public void setColDefaultStyle(long j6, int i5) {
        getOrCreateColumn1Based(j6 + 1, true).setStyle(i5);
    }

    public CTCol cloneCol(CTCols cTCols, CTCol cTCol) {
        CTCol cTColAddNewCol = cTCols.addNewCol();
        cTColAddNewCol.setMin(cTCol.getMin());
        cTColAddNewCol.setMax(cTCol.getMax());
        setColumnAttributes(cTCol, cTColAddNewCol);
        return cTColAddNewCol;
    }

    private void addCleanColIntoCols(CTCols cTCols, CTCol cTCol, TreeSet<CTCol> treeSet) {
        List<CTCol> overlappingCols = getOverlappingCols(cTCol, treeSet);
        if (overlappingCols.isEmpty()) {
            treeSet.add(cloneCol(cTCols, cTCol));
            return;
        }
        treeSet.removeAll(overlappingCols);
        for (CTCol cTCol2 : overlappingCols) {
            long[] overlap = getOverlap(cTCol, cTCol2);
            CTCol cTColCloneCol = cloneCol(cTCols, cTCol2, overlap);
            setColumnAttributes(cTCol, cTColCloneCol);
            treeSet.add(cTColCloneCol);
            CTCol cTCol3 = cTCol2.getMin() < cTCol.getMin() ? cTCol2 : cTCol;
            long[] jArr = {Math.min(cTCol2.getMin(), cTCol.getMin()), overlap[0] - 1};
            if (jArr[0] <= jArr[1]) {
                treeSet.add(cloneCol(cTCols, cTCol3, jArr));
            }
            CTCol cTCol4 = cTCol2.getMax() > cTCol.getMax() ? cTCol2 : cTCol;
            long[] jArr2 = {overlap[1] + 1, Math.max(cTCol2.getMax(), cTCol.getMax())};
            if (jArr2[0] <= jArr2[1]) {
                treeSet.add(cloneCol(cTCols, cTCol4, jArr2));
            }
        }
    }
}
