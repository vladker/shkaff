package org.apache.poi.util;

import java.util.function.Function;
import org.apache.poi.ooxml.util.POIXMLUnits;
import org.apache.poi.xddf.usermodel.XDDFCustomGeometry2D;
import org.apache.poi.xddf.usermodel.XDDFGradientStop;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFPresetGeometry2D;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.text.TextAlignment;
import org.apache.poi.xddf.usermodel.text.XDDFParagraphProperties;
import org.apache.poi.xddf.usermodel.text.XDDFTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTLegendEntry;
import org.openxmlformats.schemas.drawingml.x2006.main.CTConnectionSite;
import org.openxmlformats.schemas.drawingml.x2006.main.CTDashStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPolarAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextTabStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTXYAdjustHandle;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate32;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class k implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7254a;

    public /* synthetic */ k(int i5) {
        this.f7254a = i5;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f7254a) {
            case 0:
                return ((LocaleID) obj).getLanguageTag();
            case 1:
                return Integer.valueOf(((LocaleID) obj).getLcid());
            case 2:
                return XDDFCustomGeometry2D.lambda$getAdjustValues$2((CTGeomGuide) obj);
            case 3:
                return XDDFCustomGeometry2D.lambda$getPolarAdjustHandles$0((CTPolarAdjustHandle) obj);
            case 4:
                return XDDFCustomGeometry2D.lambda$getXYAdjustHandles$1((CTXYAdjustHandle) obj);
            case 5:
                return XDDFCustomGeometry2D.lambda$getPaths$5((CTPath2D) obj);
            case 6:
                return XDDFCustomGeometry2D.lambda$getConnectionSites$3((CTConnectionSite) obj);
            case 7:
                return XDDFCustomGeometry2D.lambda$getGuides$4((CTGeomGuide) obj);
            case 8:
                return new XDDFGradientStop((CTGradientStop) obj);
            case 9:
                return XDDFLineProperties.lambda$getDashStops$0((CTDashStop) obj);
            case 10:
                return XDDFPresetGeometry2D.lambda$getAdjustValues$0((CTGeomGuide) obj);
            case 11:
                return XDDFChartLegend.lambda$getEntries$0((CTLegendEntry) obj);
            case 12:
                return XDDFParagraphProperties.lambda$getTabStops$0((CTTextTabStop) obj);
            case 13:
                return Long.valueOf(POIXMLUnits.parseLength((STCoordinate32) obj));
            case 14:
                return Double.valueOf(Units.toPoints(((Long) obj).longValue()));
            case 15:
                return Integer.valueOf(((CTTextParagraphProperties) obj).getMarL());
            case 16:
                return Double.valueOf(Units.toPoints(((Integer) obj).intValue()));
            case 17:
                return XDDFTextParagraph.lambda$getBulletColor$1((CTTextParagraphProperties) obj);
            case 18:
                return Boolean.valueOf(((CTTextParagraphProperties) obj).getHangingPunct());
            case 19:
                return XDDFTextParagraph.lambda$getBulletSize$5((CTTextParagraphProperties) obj);
            case 20:
                return Integer.valueOf(((CTTextParagraphProperties) obj).getMarR());
            case 21:
                return Boolean.valueOf(((CTTextParagraphProperties) obj).getEaLnBrk());
            case 22:
                return Integer.valueOf(((CTTextParagraphProperties) obj).getIndent());
            case 23:
                return XDDFTextParagraph.lambda$getBulletFont$3((CTTextParagraphProperties) obj);
            case 24:
                return ((CTTextParagraphProperties) obj).getAlgn();
            case 25:
                return TextAlignment.valueOf((STTextAlignType.Enum) obj);
            case 26:
                return ((CTTextParagraphProperties) obj).getLnSpc();
            case 27:
                return XDDFTextParagraph.lambda$getBulletStyle$7((CTTextParagraphProperties) obj);
            case 28:
                return Boolean.valueOf(((CTTextParagraphProperties) obj).getRtl());
            default:
                return Boolean.valueOf(((CTTextParagraphProperties) obj).getLatinLnBrk());
        }
    }
}
