package J4;

import java.util.function.Consumer;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
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
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f383a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ c(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f383a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f383a) {
            case 0:
                ((TestCaseImpl.FilesImpl) this.b).removeFile(((Integer) obj).intValue());
                break;
            case 1:
                ((TestsDocumentImpl.TestsImpl) this.b).removeTest(((Integer) obj).intValue());
                break;
            case 2:
                ((ExtensionconfigImpl) this.b).removeInterface(((Integer) obj).intValue());
                break;
            case 3:
                ((DownloadedSchemaEntryImpl) this.b).removeSchemaLocation(((Integer) obj).intValue());
                break;
            case 4:
                ((DownloadedSchemasDocumentImpl.DownloadedSchemasImpl) this.b).removeEntry(((Integer) obj).intValue());
                break;
            case 5:
                ((KeybaseImpl) this.b).removeField(((Integer) obj).intValue());
                break;
            case 6:
                ((UnionDocumentImpl.UnionImpl) this.b).removeSimpleType(((Integer) obj).intValue());
                break;
            case 7:
                ((CTCustSplitImpl) this.b).removeSecondPiePt(((Integer) obj).intValue());
                break;
            case 8:
                ((CTDLblsImpl) this.b).removeDLbl(((Integer) obj).intValue());
                break;
            case 9:
                ((CTDoughnutChartImpl) this.b).removeSer(((Integer) obj).intValue());
                break;
            case 10:
                ((CTExtensionListImpl) this.b).removeExt(((Integer) obj).intValue());
                break;
            case 11:
                ((CTLegendImpl) this.b).removeLegendEntry(((Integer) obj).intValue());
                break;
            case 12:
                ((CTNumDataImpl) this.b).removePt(((Integer) obj).intValue());
                break;
            case 13:
                ((CTPie3DChartImpl) this.b).removeSer(((Integer) obj).intValue());
                break;
            case 14:
                ((CTPieChartImpl) this.b).removeSer(((Integer) obj).intValue());
                break;
            case 15:
                ((CTPieSerImpl) this.b).removeDPt(((Integer) obj).intValue());
                break;
            case 16:
                ((CTRadarSerImpl) this.b).removeDPt(((Integer) obj).intValue());
                break;
            case 17:
                ((CTStrDataImpl) this.b).removePt(((Integer) obj).intValue());
                break;
            case 18:
                ((CTConnectionSiteListImpl) this.b).removeCxn(((Integer) obj).intValue());
                break;
            case 19:
                ((CTDashStopListImpl) this.b).removeDs(((Integer) obj).intValue());
                break;
            case 20:
                ((CTEffectStyleListImpl) this.b).removeEffectStyle(((Integer) obj).intValue());
                break;
            case 21:
                ((CTFontCollectionImpl) this.b).removeFont(((Integer) obj).intValue());
                break;
            case 22:
                ((CTGeomGuideListImpl) this.b).removeGd(((Integer) obj).intValue());
                break;
            case 23:
                ((CTGradientStopListImpl) this.b).removeGs(((Integer) obj).intValue());
                break;
            case 24:
                ((CTLineStyleListImpl) this.b).removeLn(((Integer) obj).intValue());
                break;
            case 25:
                ((CTOfficeArtExtensionListImpl) this.b).removeExt(((Integer) obj).intValue());
                break;
            case 26:
                ((CTPath2DCubicBezierToImpl) this.b).removePt(((Integer) obj).intValue());
                break;
            case 27:
                ((CTPath2DListImpl) this.b).removePath(((Integer) obj).intValue());
                break;
            case 28:
                ((CTTableGridImpl) this.b).removeGridCol(((Integer) obj).intValue());
                break;
            default:
                ((CTTableImpl) this.b).removeTr(((Integer) obj).intValue());
                break;
        }
    }
}
