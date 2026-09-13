package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.util.Internal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface XDDFDataSource<T> {
    @Internal
    default void fillNumericalCache(CTNumData cTNumData) {
        String formatCode = getFormatCode();
        if (formatCode != null) {
            cTNumData.setFormatCode(formatCode);
        } else if (cTNumData.isSetFormatCode()) {
            cTNumData.unsetFormatCode();
        }
        cTNumData.setPtArray(null);
        int pointCount = getPointCount();
        int i5 = 0;
        for (int i6 = 0; i6 < pointCount; i6++) {
            T pointAt = getPointAt(i6);
            if (pointAt != null) {
                CTNumVal cTNumValAddNewPt = cTNumData.addNewPt();
                cTNumValAddNewPt.setIdx(i6);
                cTNumValAddNewPt.setV(pointAt.toString());
                i5++;
            }
        }
        if (i5 == 0) {
            if (cTNumData.isSetPtCount()) {
                cTNumData.unsetPtCount();
            }
        } else if (cTNumData.isSetPtCount()) {
            cTNumData.getPtCount().setVal(pointCount);
        } else {
            cTNumData.addNewPtCount().setVal(pointCount);
        }
    }

    @Internal
    default void fillStringCache(CTStrData cTStrData) {
        cTStrData.setPtArray(null);
        int pointCount = getPointCount();
        int i5 = 0;
        for (int i6 = 0; i6 < pointCount; i6++) {
            T pointAt = getPointAt(i6);
            if (pointAt != null) {
                CTStrVal cTStrValAddNewPt = cTStrData.addNewPt();
                cTStrValAddNewPt.setIdx(i6);
                cTStrValAddNewPt.setV(pointAt.toString());
                i5++;
            }
        }
        if (i5 == 0) {
            if (cTStrData.isSetPtCount()) {
                cTStrData.unsetPtCount();
            }
        } else if (cTStrData.isSetPtCount()) {
            cTStrData.getPtCount().setVal(pointCount);
        } else {
            cTStrData.addNewPtCount().setVal(pointCount);
        }
    }

    int getColIndex();

    String getDataRangeReference();

    String getFormatCode();

    default String getFormula() {
        return getDataRangeReference();
    }

    T getPointAt(int i5);

    int getPointCount();

    boolean isCellRange();

    boolean isLiteral();

    boolean isNumeric();

    boolean isReference();
}
