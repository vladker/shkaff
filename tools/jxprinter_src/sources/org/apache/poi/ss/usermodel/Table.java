package org.apache.poi.ss.usermodel;

import java.util.regex.Pattern;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface Table {
    public static final Pattern isStructuredReference = Pattern.compile("[a-zA-Z_\\\\][a-zA-Z0-9._]*\\[.*\\]");

    default boolean contains(Cell cell) {
        if (cell == null) {
            return false;
        }
        return contains(new CellReference(cell.getSheet().getSheetName(), cell.getRowIndex(), cell.getColumnIndex(), true, true));
    }

    boolean contains(CellReference cellReference);

    int findColumnIndex(String str);

    int getEndColIndex();

    int getEndRowIndex();

    int getHeaderRowCount();

    String getName();

    String getSheetName();

    int getStartColIndex();

    int getStartRowIndex();

    TableStyleInfo getStyle();

    String getStyleName();

    int getTotalsRowCount();

    boolean isHasTotalsRow();
}
