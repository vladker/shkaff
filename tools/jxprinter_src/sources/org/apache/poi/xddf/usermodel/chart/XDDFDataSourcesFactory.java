package org.apache.poi.xddf.usermodel.chart;

import A3.AbstractC0157z;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFDataSourcesFactory {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class AbstractCellRangeDataSource<T> implements XDDFDataSource<T> {
        private final CellRangeAddress cellRangeAddress;
        private final XSSFFormulaEvaluator evaluator;
        private final int numOfCells;
        private final XSSFSheet sheet;

        public AbstractCellRangeDataSource(XSSFSheet xSSFSheet, CellRangeAddress cellRangeAddress) {
            this.sheet = xSSFSheet;
            CellRangeAddress cellRangeAddressCopy = cellRangeAddress.copy();
            this.cellRangeAddress = cellRangeAddressCopy;
            this.numOfCells = cellRangeAddressCopy.getNumberOfCells();
            this.evaluator = xSSFSheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
        }

        public CellValue getCellValueAt(int i5) {
            if (i5 < 0 || i5 >= this.numOfCells) {
                StringBuilder sb = new StringBuilder("Index must be between 0 and ");
                sb.append(this.numOfCells - 1);
                sb.append(" (inclusive), given: ");
                sb.append(i5);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            int firstRow = this.cellRangeAddress.getFirstRow();
            int firstColumn = this.cellRangeAddress.getFirstColumn();
            int lastColumn = (this.cellRangeAddress.getLastColumn() - firstColumn) + 1;
            int i6 = (i5 / lastColumn) + firstRow;
            int i7 = (i5 % lastColumn) + firstColumn;
            XSSFRow row = this.sheet.getRow(i6);
            if (row == null) {
                return null;
            }
            return this.evaluator.evaluate(row.getCell(i7));
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public int getColIndex() {
            return this.cellRangeAddress.getFirstColumn();
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getDataRangeReference() {
            return this.cellRangeAddress.formatAsString(this.sheet.getSheetName(), true);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public int getPointCount() {
            return this.numOfCells;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isCellRange() {
            return true;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isReference() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LiteralNumericalArrayDataSource<T extends Number> extends NumericalArrayDataSource<T> {
        public LiteralNumericalArrayDataSource(T[] tArr) {
            super(tArr, null, 0);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isLiteral() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LiteralStringArrayDataSource extends StringArrayDataSource {
        public LiteralStringArrayDataSource(String[] strArr) {
            super(strArr, null, 0);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isLiteral() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NumericalArrayDataSource<T extends Number> extends AbstractArrayDataSource<T> implements XDDFNumericalDataSource<T> {
        private String formatCode;

        public NumericalArrayDataSource(T[] tArr, String str) {
            super(tArr, str);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getFormatCode() {
            return this.formatCode;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource
        public void setFormatCode(String str) {
            this.formatCode = str;
        }

        public NumericalArrayDataSource(T[] tArr, String str, int i5) {
            super(tArr, str, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NumericalCellRangeDataSource extends AbstractCellRangeDataSource<Double> implements XDDFNumericalDataSource<Double> {
        private String formatCode;

        public NumericalCellRangeDataSource(XSSFSheet xSSFSheet, CellRangeAddress cellRangeAddress) {
            super(xSSFSheet, cellRangeAddress);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getFormatCode() {
            return this.formatCode;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isNumeric() {
            return true;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource
        public void setFormatCode(String str) {
            this.formatCode = str;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public Double getPointAt(int i5) {
            CellValue cellValueAt = getCellValueAt(i5);
            if (cellValueAt == null || cellValueAt.getCellType() != CellType.NUMERIC) {
                return null;
            }
            return Double.valueOf(cellValueAt.getNumberValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringArrayDataSource extends AbstractArrayDataSource<String> implements XDDFCategoryDataSource {
        public StringArrayDataSource(String[] strArr, String str) {
            super(strArr, str);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getFormatCode() {
            return null;
        }

        public StringArrayDataSource(String[] strArr, String str, int i5) {
            super(strArr, str, i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StringCellRangeDataSource extends AbstractCellRangeDataSource<String> implements XDDFCategoryDataSource {
        public StringCellRangeDataSource(XSSFSheet xSSFSheet, CellRangeAddress cellRangeAddress) {
            super(xSSFSheet, cellRangeAddress);
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getFormatCode() {
            return null;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isNumeric() {
            return false;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getPointAt(int i5) {
            CellValue cellValueAt = getCellValueAt(i5);
            if (cellValueAt == null || cellValueAt.getCellType() != CellType.STRING) {
                return null;
            }
            return cellValueAt.getStringValue();
        }
    }

    private XDDFDataSourcesFactory() {
    }

    public static <T extends Number> XDDFNumericalDataSource<T> fromArray(T[] tArr) {
        return new LiteralNumericalArrayDataSource(tArr);
    }

    public static XDDFCategoryDataSource fromDataSource(CTAxDataSource cTAxDataSource) {
        if (cTAxDataSource == null) {
            return null;
        }
        if (cTAxDataSource.getNumRef() != null && cTAxDataSource.getNumRef().getNumCache() != null) {
            return new XDDFCategoryDataSource() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.1
                private final CTNumData category;
                private final String formatCode;

                {
                    CTNumData cTNumData = (CTNumData) this.val$categoryDS.getNumRef().getNumCache().copy();
                    this.category = cTNumData;
                    this.formatCode = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return this.val$categoryDS.getNumRef().getF();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return this.formatCode;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.category.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isNumeric() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getPointAt(int i5) {
                    if (this.category.sizeOfPtArray() > i5) {
                        return this.category.getPtArray(i5).getV();
                    }
                    StringBuilder sbT = AbstractC0157z.t(i5, "Cannot access 0-based index ", " in point-array with ");
                    sbT.append(this.category.sizeOfPtArray());
                    sbT.append(" items");
                    throw new IllegalArgumentException(sbT.toString());
                }
            };
        }
        if (cTAxDataSource.getStrRef() != null && cTAxDataSource.getStrRef().getStrCache() != null) {
            return new XDDFCategoryDataSource() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.2
                private final CTStrData category;

                {
                    this.category = (CTStrData) this.val$categoryDS.getStrRef().getStrCache().copy();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return this.val$categoryDS.getStrRef().getF();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.category.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getPointAt(int i5) {
                    return this.category.getPtArray(i5).getV();
                }
            };
        }
        if (cTAxDataSource.getNumLit() != null) {
            return new XDDFCategoryDataSource() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.3
                private final CTNumData category;
                private final String formatCode;

                {
                    CTNumData cTNumData = (CTNumData) this.val$categoryDS.getNumLit().copy();
                    this.category = cTNumData;
                    this.formatCode = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return this.formatCode;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.category.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isLiteral() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isNumeric() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isReference() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getPointAt(int i5) {
                    return this.category.getPtArray(i5).getV();
                }
            };
        }
        if (cTAxDataSource.getStrLit() != null) {
            return new XDDFCategoryDataSource() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.4
                private final CTStrData category;

                {
                    this.category = (CTStrData) this.val$categoryDS.getStrLit().copy();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.category.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isLiteral() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFCategoryDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isReference() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getPointAt(int i5) {
                    return this.category.getPtArray(i5).getV();
                }
            };
        }
        return null;
    }

    public static XDDFNumericalDataSource<Double> fromNumericCellRange(XSSFSheet xSSFSheet, CellRangeAddress cellRangeAddress) {
        return new NumericalCellRangeDataSource(xSSFSheet, cellRangeAddress);
    }

    public static XDDFCategoryDataSource fromStringCellRange(XSSFSheet xSSFSheet, CellRangeAddress cellRangeAddress) {
        return new StringCellRangeDataSource(xSSFSheet, cellRangeAddress);
    }

    public static XDDFCategoryDataSource fromArray(String[] strArr) {
        return new LiteralStringArrayDataSource(strArr);
    }

    public static <T extends Number> XDDFNumericalDataSource<T> fromArray(T[] tArr, String str) {
        return new NumericalArrayDataSource(tArr, str);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class AbstractArrayDataSource<T> implements XDDFDataSource<T> {
        private int col;
        private final String dataRange;
        private final T[] elements;

        public AbstractArrayDataSource(T[] tArr, String str) {
            this.col = 0;
            this.elements = (T[]) ((Object[]) tArr.clone());
            this.dataRange = str;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public int getColIndex() {
            return this.col;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public String getDataRangeReference() {
            String str = this.dataRange;
            if (str != null) {
                return str;
            }
            throw new UnsupportedOperationException("Literal data source can not be expressed by reference.");
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public T getPointAt(int i5) {
            return this.elements[i5];
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public int getPointCount() {
            return this.elements.length;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isCellRange() {
            return false;
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isNumeric() {
            return Number.class.isAssignableFrom(this.elements.getClass().getComponentType());
        }

        @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
        public boolean isReference() {
            return this.dataRange != null;
        }

        public AbstractArrayDataSource(T[] tArr, String str, int i5) {
            this.col = 0;
            this.elements = (T[]) ((Object[]) tArr.clone());
            this.dataRange = str;
            this.col = i5;
        }
    }

    public static XDDFCategoryDataSource fromArray(String[] strArr, String str) {
        return new StringArrayDataSource(strArr, str);
    }

    public static <T extends Number> XDDFNumericalDataSource<T> fromArray(T[] tArr, String str, int i5) {
        return new NumericalArrayDataSource(tArr, str, i5);
    }

    public static XDDFCategoryDataSource fromArray(String[] strArr, String str, int i5) {
        return new StringArrayDataSource(strArr, str, i5);
    }

    public static XDDFNumericalDataSource<Double> fromDataSource(CTNumDataSource cTNumDataSource) {
        if (cTNumDataSource == null) {
            return null;
        }
        if (cTNumDataSource.getNumRef() != null && cTNumDataSource.getNumRef().getNumCache() != null) {
            return new XDDFNumericalDataSource<Double>() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.5
                private String formatCode;
                private final CTNumData values;

                {
                    CTNumData cTNumData = (CTNumData) this.val$valuesDS.getNumRef().getNumCache().copy();
                    this.values = cTNumData;
                    this.formatCode = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getColIndex() {
                    return 0;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return this.val$valuesDS.getNumRef().getF();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return this.formatCode;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.values.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isNumeric() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isReference() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource
                public void setFormatCode(String str) {
                    this.formatCode = str;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public Double getPointAt(int i5) {
                    return Double.valueOf(this.values.getPtArray(i5).getV());
                }
            };
        }
        if (cTNumDataSource.getNumLit() != null) {
            return new XDDFNumericalDataSource<Double>() { // from class: org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory.6
                private String formatCode;
                private final CTNumData values;

                {
                    CTNumData cTNumData = (CTNumData) this.val$valuesDS.getNumLit().copy();
                    this.values = cTNumData;
                    this.formatCode = cTNumData.isSetFormatCode() ? cTNumData.getFormatCode() : null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getColIndex() {
                    return 0;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getDataRangeReference() {
                    return null;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public String getFormatCode() {
                    return this.formatCode;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public int getPointCount() {
                    return (int) this.values.getPtCount().getVal();
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isCellRange() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource, org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isLiteral() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isNumeric() {
                    return true;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public boolean isReference() {
                    return false;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource
                public void setFormatCode(String str) {
                    this.formatCode = str;
                }

                @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
                public Double getPointAt(int i5) {
                    return Double.valueOf(this.values.getPtArray(i5).getV());
                }
            };
        }
        return null;
    }
}
