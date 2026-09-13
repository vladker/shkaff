package org.apache.poi.xwpf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XWPFChart extends XDDFChart {
    public static final int DEFAULT_HEIGHT = 500000;
    public static final int DEFAULT_WIDTH = 500000;
    private Long checksum;
    private CTInline ctInline;

    public XWPFChart() {
    }

    public void attach(String str, XWPFRun xWPFRun) {
        CTInline cTInlineAddChart = xWPFRun.addChart(str);
        this.ctInline = cTInlineAddChart;
        cTInlineAddChart.addNewExtent();
        setChartBoundingBox(500000L, 500000L);
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public long getChartBottomMargin(long j6) {
        return this.ctInline.getDistB();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return XWPFFactory.getInstance();
    }

    public long getChartHeight() {
        return this.ctInline.getExtent().getCy();
    }

    public long getChartLeftMargin(long j6) {
        return this.ctInline.getDistL();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartRelation() {
        return XWPFRelation.CHART;
    }

    public long getChartRightMargin(long j6) {
        return this.ctInline.getDistR();
    }

    public long getChartTopMargin(long j6) {
        return this.ctInline.getDistT();
    }

    public long getChartWidth() {
        return this.ctInline.getExtent().getCx();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return XWPFRelation.WORKBOOK;
    }

    public Long getChecksum() {
        if (this.checksum == null) {
            try {
                InputStream inputStream = getPackagePart().getInputStream();
                try {
                    this.checksum = Long.valueOf(IOUtils.calculateChecksum(inputStream));
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException e) {
                throw new POIXMLException(e);
            }
        }
        return this.checksum;
    }

    public int hashCode() {
        return getChecksum().hashCode();
    }

    public void setChartBottomMargin(long j6) {
        this.ctInline.setDistB(j6);
    }

    public void setChartBoundingBox(long j6, long j7) {
        setChartWidth(j6);
        setChartHeight(j7);
    }

    public void setChartHeight(long j6) {
        this.ctInline.getExtent().setCy(j6);
    }

    public void setChartLeftMargin(long j6) {
        this.ctInline.setDistL(j6);
    }

    public void setChartMargin(long j6, long j7, long j8, long j9) {
        setChartBottomMargin(j8);
        setChartRightMargin(j7);
        setChartLeftMargin(j9);
        setChartRightMargin(j7);
    }

    public void setChartRightMargin(long j6) {
        this.ctInline.setDistR(j6);
    }

    public void setChartTopMargin(long j6) {
        this.ctInline.setDistT(j6);
    }

    public void setChartWidth(long j6) {
        this.ctInline.getExtent().setCx(j6);
    }

    public XWPFChart(PackagePart packagePart) {
        super(packagePart);
    }
}
