package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface FormulaParsingWorkbook {
    Name createName();

    Ptg get3DReferencePtg(AreaReference areaReference, SheetIdentifier sheetIdentifier);

    Ptg get3DReferencePtg(CellReference cellReference, SheetIdentifier sheetIdentifier);

    int getExternalSheetIndex(String str);

    int getExternalSheetIndex(String str, String str2);

    EvaluationName getName(String str, int i5);

    Ptg getNameXPtg(String str, SheetIdentifier sheetIdentifier);

    SpreadsheetVersion getSpreadsheetVersion();

    Table getTable(String str);
}
