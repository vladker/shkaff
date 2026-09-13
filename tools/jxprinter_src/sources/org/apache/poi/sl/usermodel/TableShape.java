package org.apache.poi.sl.usermodel;

import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface TableShape<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends Shape<S, P>, PlaceableShape<S, P> {
    TableCell<S, P> getCell(int i5, int i6);

    double getColumnWidth(int i5);

    int getNumberOfColumns();

    int getNumberOfRows();

    double getRowHeight(int i5);

    void setColumnWidth(int i5, double d);

    void setRowHeight(int i5, double d);
}
