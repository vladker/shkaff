package org.apache.poi.ss.usermodel;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Row extends Iterable<Cell> {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum MissingCellPolicy {
        RETURN_NULL_AND_BLANK,
        RETURN_BLANK_AS_NULL,
        CREATE_NULL_AS_BLANK
    }

    Iterator<Cell> cellIterator();

    Cell createCell(int i5);

    Cell createCell(int i5, CellType cellType);

    Cell getCell(int i5);

    Cell getCell(int i5, MissingCellPolicy missingCellPolicy);

    short getFirstCellNum();

    short getHeight();

    float getHeightInPoints();

    short getLastCellNum();

    int getOutlineLevel();

    int getPhysicalNumberOfCells();

    int getRowNum();

    CellStyle getRowStyle();

    Sheet getSheet();

    boolean getZeroHeight();

    boolean isFormatted();

    @Override // java.lang.Iterable
    default Iterator<Cell> iterator() {
        return cellIterator();
    }

    void removeCell(Cell cell);

    void setHeight(short s6);

    void setHeightInPoints(float f6);

    void setRowNum(int i5);

    void setRowStyle(CellStyle cellStyle);

    void setZeroHeight(boolean z6);

    void shiftCellsLeft(int i5, int i6, int i7);

    void shiftCellsRight(int i5, int i6, int i7);

    @Override // java.lang.Iterable
    default Spliterator<Cell> spliterator() {
        return Spliterators.spliterator(cellIterator(), getPhysicalNumberOfCells(), 0);
    }
}
