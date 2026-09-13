package org.apache.poi.xssf.usermodel;

import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.CommentsTable;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements POIXMLRelation.PackagePartConstructor, POIXMLRelation.NoArgConstructor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7342a;

    public /* synthetic */ a(int i5) {
        this.f7342a = i5;
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.NoArgConstructor
    public POIXMLDocumentPart init() {
        switch (this.f7342a) {
            case 3:
                return new SharedStringsTable();
            case 4:
                return new CommentsTable();
            case 5:
            case 7:
            case 9:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 19:
            case 23:
            case 24:
            case 26:
            default:
                return new MapInfo();
            case 6:
                return new XSSFVBAPart();
            case 8:
                return new ThemesTable();
            case 12:
                return new CalculationChain();
            case 14:
                return new ExternalLinksTable();
            case 16:
                return new XSSFPivotTable();
            case 18:
                return new XSSFPivotCacheDefinition();
            case 20:
                return new XSSFChart();
            case 21:
                return new XSSFPivotCacheRecords();
            case 22:
                return new StylesTable();
            case 25:
                return new XSSFDrawing();
            case 27:
                return new XSSFVMLDrawing();
        }
    }

    @Override // org.apache.poi.ooxml.POIXMLRelation.PackagePartConstructor
    public POIXMLDocumentPart init(PackagePart packagePart) {
        switch (this.f7342a) {
            case 0:
                return new XSSFSheet(packagePart);
            case 1:
                return new XSSFPictureData(packagePart);
            case 2:
                return new XSSFChartSheet(packagePart);
            case 3:
            case 4:
            case 6:
            case 8:
            case 12:
            case 14:
            case 16:
            case 18:
            case 20:
            case 21:
            case 22:
            case 25:
            default:
                return new XSSFChart(packagePart);
            case 5:
                return new CommentsTable(packagePart);
            case 7:
                return new XSSFVBAPart(packagePart);
            case 9:
                return new XSSFVMLDrawing(packagePart);
            case 10:
                return new SharedStringsTable(packagePart);
            case 11:
                return new ThemesTable(packagePart);
            case 13:
                return new CalculationChain(packagePart);
            case 15:
                return new ExternalLinksTable(packagePart);
            case 17:
                return new XSSFPivotTable(packagePart);
            case 19:
                return new XSSFPivotCacheDefinition(packagePart);
            case 23:
                return new XSSFPivotCacheRecords(packagePart);
            case 24:
                return new StylesTable(packagePart);
            case 26:
                return new XSSFDrawing(packagePart);
        }
    }
}
