package org.apache.poi.xddf.usermodel.chart;

import java.lang.Number;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface XDDFNumericalDataSource<T extends Number> extends XDDFDataSource<T> {
    @Override // org.apache.poi.xddf.usermodel.chart.XDDFDataSource
    default boolean isLiteral() {
        return false;
    }

    void setFormatCode(String str);
}
