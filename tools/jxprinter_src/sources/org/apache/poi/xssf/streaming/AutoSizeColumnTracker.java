package org.apache.poi.xssf.streaming;

import androidx.collection.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.SheetUtil;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
class AutoSizeColumnTracker {
    private final int defaultCharWidth;
    private boolean trackAllColumns;
    private final DataFormatter dataFormatter = new DataFormatter();
    private final Map<Integer, ColumnWidthPair> maxColumnWidths = new HashMap();
    private final Set<Integer> untrackedColumns = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ColumnWidthPair {
        private double withSkipMergedCells;
        private double withUseMergedCells;

        public ColumnWidthPair() {
            this(-1.0d, -1.0d);
        }

        public double getMaxColumnWidth(boolean z6) {
            return z6 ? this.withUseMergedCells : this.withSkipMergedCells;
        }

        public void setMaxColumnWidths(double d, double d6) {
            this.withUseMergedCells = Math.max(this.withUseMergedCells, d6);
            this.withSkipMergedCells = Math.max(this.withSkipMergedCells, d);
        }

        public ColumnWidthPair(double d, double d6) {
            this.withSkipMergedCells = d;
            this.withUseMergedCells = d6;
        }
    }

    public AutoSizeColumnTracker(Sheet sheet) {
        this.defaultCharWidth = SheetUtil.getDefaultCharWidth(sheet.getWorkbook());
    }

    private boolean implicitlyTrackColumn(int i5) {
        if (this.untrackedColumns.contains(Integer.valueOf(i5))) {
            return false;
        }
        trackColumn(i5);
        return true;
    }

    private void implicitlyTrackColumnsInRow(Row row) {
        if (this.trackAllColumns) {
            Iterator<Cell> it = row.iterator();
            while (it.hasNext()) {
                implicitlyTrackColumn(it.next().getColumnIndex());
            }
        }
    }

    private void updateColumnWidth(Cell cell, ColumnWidthPair columnWidthPair) {
        columnWidthPair.setMaxColumnWidths(SheetUtil.getCellWidth(cell, this.defaultCharWidth, this.dataFormatter, false), SheetUtil.getCellWidth(cell, this.defaultCharWidth, this.dataFormatter, true));
    }

    public int getBestFitColumnWidth(int i5, boolean z6) {
        if (!this.maxColumnWidths.containsKey(Integer.valueOf(i5))) {
            if (!this.trackAllColumns) {
                throw new IllegalStateException(a.i(i5, "Cannot get best fit column width on untracked column ", ". Either explicitly track the column or track all columns."), new IllegalStateException("Column was never explicitly tracked and isAllColumnsTracked() is false (trackAllColumns() was never called or untrackAllColumns() was called after trackAllColumns() was called)."));
            }
            if (!implicitlyTrackColumn(i5)) {
                throw new IllegalStateException(a.i(i5, "Cannot get best fit column width on explicitly untracked column ", ". Either explicitly track the column or track all columns."), new IllegalStateException("Column was explicitly untracked after trackAllColumns() was called."));
            }
        }
        return Math.toIntExact(Math.round(this.maxColumnWidths.get(Integer.valueOf(i5)).getMaxColumnWidth(z6) * 256.0d));
    }

    public SortedSet<Integer> getTrackedColumns() {
        return Collections.unmodifiableSortedSet(new TreeSet(this.maxColumnWidths.keySet()));
    }

    public boolean isAllColumnsTracked() {
        return this.trackAllColumns;
    }

    public boolean isColumnTracked(int i5) {
        return (this.trackAllColumns && !this.untrackedColumns.contains(Integer.valueOf(i5))) || this.maxColumnWidths.containsKey(Integer.valueOf(i5));
    }

    public void trackAllColumns() {
        this.trackAllColumns = true;
        this.untrackedColumns.clear();
    }

    public boolean trackColumn(int i5) {
        this.untrackedColumns.remove(Integer.valueOf(i5));
        if (this.maxColumnWidths.containsKey(Integer.valueOf(i5))) {
            return false;
        }
        this.maxColumnWidths.put(Integer.valueOf(i5), new ColumnWidthPair());
        return true;
    }

    public void trackColumns(Collection<Integer> collection) {
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            trackColumn(it.next().intValue());
        }
    }

    public void untrackAllColumns() {
        this.trackAllColumns = false;
        this.maxColumnWidths.clear();
        this.untrackedColumns.clear();
    }

    public boolean untrackColumn(int i5) {
        this.untrackedColumns.add(Integer.valueOf(i5));
        return this.maxColumnWidths.remove(Integer.valueOf(i5)) != null;
    }

    public boolean untrackColumns(Collection<Integer> collection) {
        this.untrackedColumns.addAll(collection);
        Iterator<Integer> it = collection.iterator();
        while (true) {
            boolean z6 = false;
            while (it.hasNext()) {
                if (this.maxColumnWidths.remove(it.next()) != null || z6) {
                    z6 = true;
                }
            }
            return z6;
        }
    }

    public void updateColumnWidths(Row row) {
        implicitlyTrackColumnsInRow(row);
        if (this.maxColumnWidths.size() < row.getPhysicalNumberOfCells()) {
            for (Map.Entry<Integer, ColumnWidthPair> entry : this.maxColumnWidths.entrySet()) {
                Cell cell = row.getCell(entry.getKey().intValue());
                if (cell != null) {
                    updateColumnWidth(cell, entry.getValue());
                }
            }
            return;
        }
        for (Cell cell2 : row) {
            int columnIndex = cell2.getColumnIndex();
            if (this.maxColumnWidths.containsKey(Integer.valueOf(columnIndex))) {
                updateColumnWidth(cell2, this.maxColumnWidths.get(Integer.valueOf(columnIndex)));
            }
        }
    }
}
