package org.apache.poi.ss.usermodel;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum TableStyleType {
    wholeTable { // from class: org.apache.poi.ss.usermodel.TableStyleType.1
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getStartColIndex(), table.getEndColIndex());
        }
    },
    pageFieldLabels,
    pageFieldValues,
    firstColumnStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.2
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            TableStyleInfo style = table.getStyle();
            if (!style.isShowColumnStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(TableStyleType.firstColumnStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(TableStyleType.secondColumnStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 != null ? Math.max(1, style3.getStripeSize()) : 1;
            int startColIndex = table.getStartColIndex();
            int i5 = startColIndex + iMax;
            short col = cellReference.getCol();
            while (startColIndex <= col) {
                int i6 = i5 - 1;
                if (col <= i6) {
                    return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), startColIndex, i6);
                }
                startColIndex = i5 + iMax2;
                i5 = startColIndex + iMax;
            }
            return null;
        }
    },
    secondColumnStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.3
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            int i5;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowColumnStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(TableStyleType.firstColumnStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(TableStyleType.secondColumnStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 == null ? 1 : Math.max(1, style3.getStripeSize());
            int startColIndex = table.getStartColIndex();
            int i6 = startColIndex + iMax;
            short col = cellReference.getCol();
            while (startColIndex <= col) {
                if (col >= i6 && col <= (i5 = (i6 + iMax2) - 1)) {
                    return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), i6, i5);
                }
                startColIndex = i6 + iMax2;
                i6 = startColIndex + iMax;
            }
            return null;
        }
    },
    firstRowStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.4
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            TableStyleInfo style = table.getStyle();
            if (!style.isShowRowStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(TableStyleType.firstRowStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(TableStyleType.secondRowStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 != null ? Math.max(1, style3.getStripeSize()) : 1;
            int headerRowCount = table.getHeaderRowCount() + table.getStartRowIndex();
            int i5 = headerRowCount + iMax;
            int row = cellReference.getRow();
            while (headerRowCount <= row) {
                int i6 = i5 - 1;
                if (row <= i6) {
                    return new CellRangeAddress(headerRowCount, i6, table.getStartColIndex(), table.getEndColIndex());
                }
                headerRowCount = i5 + iMax2;
                i5 = headerRowCount + iMax;
            }
            return null;
        }
    },
    secondRowStripe { // from class: org.apache.poi.ss.usermodel.TableStyleType.5
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            int i5;
            TableStyleInfo style = table.getStyle();
            if (!style.isShowRowStripes()) {
                return null;
            }
            DifferentialStyleProvider style2 = style.getStyle().getStyle(TableStyleType.firstRowStripe);
            DifferentialStyleProvider style3 = style.getStyle().getStyle(TableStyleType.secondRowStripe);
            int iMax = style2 == null ? 1 : Math.max(1, style2.getStripeSize());
            int iMax2 = style3 == null ? 1 : Math.max(1, style3.getStripeSize());
            int headerRowCount = table.getHeaderRowCount() + table.getStartRowIndex();
            int i6 = headerRowCount + iMax;
            int row = cellReference.getRow();
            while (headerRowCount <= row) {
                if (row >= i6 && row <= (i5 = (i6 + iMax2) - 1)) {
                    return new CellRangeAddress(i6, i5, table.getStartColIndex(), table.getEndColIndex());
                }
                headerRowCount = i6 + iMax2;
                i6 = headerRowCount + iMax;
            }
            return null;
        }
    },
    lastColumn { // from class: org.apache.poi.ss.usermodel.TableStyleType.6
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getStyle().isShowLastColumn()) {
                return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getEndColIndex(), table.getEndColIndex());
            }
            return null;
        }
    },
    firstColumn { // from class: org.apache.poi.ss.usermodel.TableStyleType.7
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getStyle().isShowFirstColumn()) {
                return new CellRangeAddress(table.getStartRowIndex(), table.getEndRowIndex(), table.getStartColIndex(), table.getStartColIndex());
            }
            return null;
        }
    },
    headerRow { // from class: org.apache.poi.ss.usermodel.TableStyleType.8
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), (table.getHeaderRowCount() + table.getStartRowIndex()) - 1, table.getStartColIndex(), table.getEndColIndex());
        }
    },
    totalRow { // from class: org.apache.poi.ss.usermodel.TableStyleType.9
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getStartColIndex(), table.getEndColIndex());
        }
    },
    firstHeaderCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.10
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), table.getStartRowIndex(), table.getStartColIndex(), table.getStartColIndex());
        }
    },
    lastHeaderCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.11
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getHeaderRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress(table.getStartRowIndex(), table.getStartRowIndex(), table.getEndColIndex(), table.getEndColIndex());
        }
    },
    firstTotalCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.12
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getStartColIndex(), table.getStartColIndex());
        }
    },
    lastTotalCell { // from class: org.apache.poi.ss.usermodel.TableStyleType.13
        @Override // org.apache.poi.ss.usermodel.TableStyleType
        public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
            if (table.getTotalsRowCount() < 1) {
                return null;
            }
            return new CellRangeAddress((table.getEndRowIndex() - table.getTotalsRowCount()) + 1, table.getEndRowIndex(), table.getEndColIndex(), table.getEndColIndex());
        }
    },
    firstSubtotalColumn,
    secondSubtotalColumn,
    thirdSubtotalColumn,
    blankRow,
    firstSubtotalRow,
    secondSubtotalRow,
    thirdSubtotalRow,
    firstColumnSubheading,
    secondColumnSubheading,
    thirdColumnSubheading,
    firstRowSubheading,
    secondRowSubheading,
    thirdRowSubheading;

    public CellRangeAddressBase appliesTo(Table table, Cell cell) {
        if (cell == null) {
            return null;
        }
        return appliesTo(table, new CellReference(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), true, true));
    }

    public CellRangeAddressBase getRange(Table table, CellReference cellReference) {
        return null;
    }

    public CellRangeAddressBase appliesTo(Table table, CellReference cellReference) {
        CellRangeAddressBase range;
        if (table == null || cellReference == null || !cellReference.getSheetName().equals(table.getSheetName()) || !table.contains(cellReference) || (range = getRange(table, cellReference)) == null || !range.isInRange(cellReference.getRow(), cellReference.getCol())) {
            return null;
        }
        return range;
    }

    public final CellRangeAddressBase getRange(Table table, Cell cell) {
        if (cell == null) {
            return null;
        }
        return getRange(table, new CellReference(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), true, true));
    }
}
