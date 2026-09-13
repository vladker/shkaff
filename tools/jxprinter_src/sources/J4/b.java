package J4;

import java.util.function.BiConsumer;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestCaseImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestsDocumentImpl;
import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
import org.apache.xmlbeans.impl.xb.xmlconfig.impl.ExtensionconfigImpl;
import org.apache.xmlbeans.impl.xb.xsdownload.DownloadedSchemaEntry;
import org.apache.xmlbeans.impl.xb.xsdownload.impl.DownloadedSchemasDocumentImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.KeybaseImpl;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.UnionDocumentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTBarSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTCustSplitImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTDoughnutChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTLegendImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTLineSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTNumDataImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPie3DChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPieChartImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTPieSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTRadarSerImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.impl.CTStrDataImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectStyleItem;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTLineProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCol;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTConnectionSiteListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTDashStopListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTEffectStyleListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTGeomGuideListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTGradientStopListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTLineStyleListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTOfficeArtExtensionListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DCubicBezierToImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DListImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableGridImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableRowImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.impl.CTTableStyleListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class b implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382a;
    public final /* synthetic */ XmlComplexContentImpl b;

    public /* synthetic */ b(XmlComplexContentImpl xmlComplexContentImpl, int i5) {
        this.f382a = i5;
        this.b = xmlComplexContentImpl;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        switch (this.f382a) {
            case 0:
                ((TestCaseImpl.FilesImpl) this.b).setFileArray(((Integer) obj).intValue(), (FileDesc) obj2);
                break;
            case 1:
                ((TestsDocumentImpl.TestsImpl) this.b).setTestArray(((Integer) obj).intValue(), (TestCase) obj2);
                break;
            case 2:
                ((ExtensionconfigImpl) this.b).setInterfaceArray(((Integer) obj).intValue(), (Extensionconfig.Interface) obj2);
                break;
            case 3:
                ((DownloadedSchemasDocumentImpl.DownloadedSchemasImpl) this.b).setEntryArray(((Integer) obj).intValue(), (DownloadedSchemaEntry) obj2);
                break;
            case 4:
                ((KeybaseImpl) this.b).setFieldArray(((Integer) obj).intValue(), (FieldDocument.Field) obj2);
                break;
            case 5:
                ((UnionDocumentImpl.UnionImpl) this.b).setSimpleTypeArray(((Integer) obj).intValue(), (LocalSimpleType) obj2);
                break;
            case 6:
                ((CTBarSerImpl) this.b).setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                break;
            case 7:
                ((CTCustSplitImpl) this.b).setSecondPiePtArray(((Integer) obj).intValue(), (CTUnsignedInt) obj2);
                break;
            case 8:
                ((CTDoughnutChartImpl) this.b).setSerArray(((Integer) obj).intValue(), (CTPieSer) obj2);
                break;
            case 9:
                ((CTLegendImpl) this.b).setLegendEntryArray(((Integer) obj).intValue(), (CTLegendEntry) obj2);
                break;
            case 10:
                ((CTLineSerImpl) this.b).setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                break;
            case 11:
                ((CTNumDataImpl) this.b).setPtArray(((Integer) obj).intValue(), (CTNumVal) obj2);
                break;
            case 12:
                ((CTPie3DChartImpl) this.b).setSerArray(((Integer) obj).intValue(), (CTPieSer) obj2);
                break;
            case 13:
                ((CTPieChartImpl) this.b).setSerArray(((Integer) obj).intValue(), (CTPieSer) obj2);
                break;
            case 14:
                ((CTPieSerImpl) this.b).setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                break;
            case 15:
                ((CTRadarSerImpl) this.b).setDPtArray(((Integer) obj).intValue(), (CTDPt) obj2);
                break;
            case 16:
                ((CTStrDataImpl) this.b).setPtArray(((Integer) obj).intValue(), (CTStrVal) obj2);
                break;
            case 17:
                ((CTConnectionSiteListImpl) this.b).setCxnArray(((Integer) obj).intValue(), (CTConnectionSite) obj2);
                break;
            case 18:
                ((CTDashStopListImpl) this.b).setDsArray(((Integer) obj).intValue(), (CTDashStop) obj2);
                break;
            case 19:
                ((CTEffectStyleListImpl) this.b).setEffectStyleArray(((Integer) obj).intValue(), (CTEffectStyleItem) obj2);
                break;
            case 20:
                ((CTGeomGuideListImpl) this.b).setGdArray(((Integer) obj).intValue(), (CTGeomGuide) obj2);
                break;
            case 21:
                ((CTGradientStopListImpl) this.b).setGsArray(((Integer) obj).intValue(), (CTGradientStop) obj2);
                break;
            case 22:
                ((CTLineStyleListImpl) this.b).setLnArray(((Integer) obj).intValue(), (CTLineProperties) obj2);
                break;
            case 23:
                ((CTOfficeArtExtensionListImpl) this.b).setExtArray(((Integer) obj).intValue(), (CTOfficeArtExtension) obj2);
                break;
            case 24:
                ((CTPath2DCubicBezierToImpl) this.b).setPtArray(((Integer) obj).intValue(), (CTAdjPoint2D) obj2);
                break;
            case 25:
                ((CTPath2DListImpl) this.b).setPathArray(((Integer) obj).intValue(), (CTPath2D) obj2);
                break;
            case 26:
                ((CTTableGridImpl) this.b).setGridColArray(((Integer) obj).intValue(), (CTTableCol) obj2);
                break;
            case 27:
                ((CTTableImpl) this.b).setTrArray(((Integer) obj).intValue(), (CTTableRow) obj2);
                break;
            case 28:
                ((CTTableRowImpl) this.b).setTcArray(((Integer) obj).intValue(), (CTTableCell) obj2);
                break;
            default:
                ((CTTableStyleListImpl) this.b).setTblStyleArray(((Integer) obj).intValue(), (CTTableStyle) obj2);
                break;
        }
    }
}
