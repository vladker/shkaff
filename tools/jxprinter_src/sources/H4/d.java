package H4;

import java.util.function.Supplier;
import org.apache.poi.hssf.record.cf.ColorGradientThreshold;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestCaseImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestsDocumentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ExtensionconfigImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemaEntryImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemasDocumentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.KeybaseImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.UnionDocumentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTCustSplitImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTDLblsImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTDoughnutChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTExtensionListImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTLegendImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTNumDataImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPie3DChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPieChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPieSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTRadarSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTStrDataImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTConnectionSiteListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDashStopListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectStyleListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTFontCollectionImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTGeomGuideListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTGradientStopListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTLineStyleListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTOfficeArtExtensionListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DCubicBezierToImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableGridImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class d implements Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f307a;
    public final /* synthetic */ Object b;

    public /* synthetic */ d(Object obj, int i5) {
        this.f307a = i5;
        this.b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f307a) {
            case 0:
                return Double.valueOf(((ColorGradientThreshold) this.b).getPosition());
            case 1:
                return Integer.valueOf(((TestCaseImpl.FilesImpl) this.b).sizeOfFileArray());
            case 2:
                return Integer.valueOf(((TestsDocumentImpl.TestsImpl) this.b).sizeOfTestArray());
            case 3:
                return Integer.valueOf(((ExtensionconfigImpl) this.b).sizeOfInterfaceArray());
            case 4:
                return Integer.valueOf(((DownloadedSchemaEntryImpl) this.b).sizeOfSchemaLocationArray());
            case 5:
                return Integer.valueOf(((DownloadedSchemasDocumentImpl.DownloadedSchemasImpl) this.b).sizeOfEntryArray());
            case 6:
                return Integer.valueOf(((KeybaseImpl) this.b).sizeOfFieldArray());
            case 7:
                return Integer.valueOf(((UnionDocumentImpl.UnionImpl) this.b).sizeOfSimpleTypeArray());
            case 8:
                return Integer.valueOf(((CTCustSplitImpl) this.b).sizeOfSecondPiePtArray());
            case 9:
                return Integer.valueOf(((CTDLblsImpl) this.b).sizeOfDLblArray());
            case 10:
                return Integer.valueOf(((CTDoughnutChartImpl) this.b).sizeOfSerArray());
            case 11:
                return Integer.valueOf(((CTExtensionListImpl) this.b).sizeOfExtArray());
            case 12:
                return Integer.valueOf(((CTLegendImpl) this.b).sizeOfLegendEntryArray());
            case 13:
                return Integer.valueOf(((CTNumDataImpl) this.b).sizeOfPtArray());
            case 14:
                return Integer.valueOf(((CTPie3DChartImpl) this.b).sizeOfSerArray());
            case 15:
                return Integer.valueOf(((CTPieChartImpl) this.b).sizeOfSerArray());
            case 16:
                return Integer.valueOf(((CTPieSerImpl) this.b).sizeOfDPtArray());
            case 17:
                return Integer.valueOf(((CTRadarSerImpl) this.b).sizeOfDPtArray());
            case 18:
                return Integer.valueOf(((CTStrDataImpl) this.b).sizeOfPtArray());
            case 19:
                return Integer.valueOf(((CTConnectionSiteListImpl) this.b).sizeOfCxnArray());
            case 20:
                return Integer.valueOf(((CTDashStopListImpl) this.b).sizeOfDsArray());
            case 21:
                return Integer.valueOf(((CTEffectStyleListImpl) this.b).sizeOfEffectStyleArray());
            case 22:
                return Integer.valueOf(((CTFontCollectionImpl) this.b).sizeOfFontArray());
            case 23:
                return Integer.valueOf(((CTGeomGuideListImpl) this.b).sizeOfGdArray());
            case 24:
                return Integer.valueOf(((CTGradientStopListImpl) this.b).sizeOfGsArray());
            case 25:
                return Integer.valueOf(((CTLineStyleListImpl) this.b).sizeOfLnArray());
            case 26:
                return Integer.valueOf(((CTOfficeArtExtensionListImpl) this.b).sizeOfExtArray());
            case 27:
                return Integer.valueOf(((CTPath2DCubicBezierToImpl) this.b).sizeOfPtArray());
            case 28:
                return Integer.valueOf(((CTPath2DListImpl) this.b).sizeOfPathArray());
            default:
                return Integer.valueOf(((CTTableGridImpl) this.b).sizeOfGridColArray());
        }
    }
}
