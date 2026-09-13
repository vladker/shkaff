package org.apache.poi.xddf.usermodel.chart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface XDDFCategoryDataSource extends XDDFDataSource<String> {
    @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
    default int getColIndex() {
        return 0;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
    default boolean isLiteral() {
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
    default boolean isNumeric() {
        return false;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
    default boolean isReference() {
        return true;
    }
}
