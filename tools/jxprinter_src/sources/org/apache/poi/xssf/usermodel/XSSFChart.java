package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import java.io.OutputStream;
import javax.xml.namespace.QName;
import org.apache.poi.ooxml.POIXMLFactory;
import org.apache.poi.ooxml.POIXMLRelation;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChartSpace;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPageMargins;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPrintSettings;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTitle;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTTx;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class XSSFChart extends XDDFChart {
    private XSSFGraphicFrame frame;

    public XSSFChart() {
        createChart();
    }

    private void createChart() {
        getCTPlotArea().addNewLayout();
        getCTChart().addNewPlotVisOnly().setVal(true);
        CTPrintSettings cTPrintSettingsAddNewPrintSettings = this.chartSpace.addNewPrintSettings();
        cTPrintSettingsAddNewPrintSettings.addNewHeaderFooter();
        CTPageMargins cTPageMarginsAddNewPageMargins = cTPrintSettingsAddNewPrintSettings.addNewPageMargins();
        cTPageMarginsAddNewPageMargins.setB(0.75d);
        cTPageMarginsAddNewPageMargins.setL(0.7d);
        cTPageMarginsAddNewPageMargins.setR(0.7d);
        cTPageMarginsAddNewPageMargins.setT(0.75d);
        cTPageMarginsAddNewPageMargins.setHeader(0.3d);
        cTPageMarginsAddNewPageMargins.setFooter(0.3d);
        cTPrintSettingsAddNewPrintSettings.addNewPageSetup();
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart, org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        XmlOptions xmlOptions = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        xmlOptions.setSaveSyntheticDocumentElement(new QName(CTChartSpace.type.getName().getNamespaceURI(), "chartSpace", "c"));
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            this.chartSpace.save(outputStream, xmlOptions);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLFactory getChartFactory() {
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartRelation() {
        return null;
    }

    @Override // org.apache.poi.xddf.usermodel.chart.XDDFChart
    public POIXMLRelation getChartWorkbookRelation() {
        return null;
    }

    public XSSFGraphicFrame getGraphicFrame() {
        return this.frame;
    }

    public String getTitleFormula() {
        if (!getCTChart().isSetTitle()) {
            return null;
        }
        CTTitle title = getCTChart().getTitle();
        if (!title.isSetTx()) {
            return null;
        }
        CTTx tx = title.getTx();
        if (tx.isSetStrRef()) {
            return tx.getStrRef().getF();
        }
        return null;
    }

    public XSSFRichTextString getTitleText() {
        if (!getCTChart().isSetTitle()) {
            return null;
        }
        CTTitle title = getCTChart().getTitle();
        StringBuilder sb = new StringBuilder(64);
        for (XmlObject xmlObject : title.selectPath("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//a:t")) {
            NodeList childNodes = xmlObject.getDomNode().getChildNodes();
            int length = childNodes.getLength();
            for (int i5 = 0; i5 < length; i5++) {
                Node nodeItem = childNodes.item(i5);
                if (nodeItem instanceof Text) {
                    sb.append(nodeItem.getNodeValue());
                }
            }
        }
        return new XSSFRichTextString(sb.toString());
    }

    public void setGraphicFrame(XSSFGraphicFrame xSSFGraphicFrame) {
        this.frame = xSSFGraphicFrame;
    }

    public void setTitleFormula(String str) {
        CTTitle title = getCTChart().isSetTitle() ? getCTChart().getTitle() : getCTChart().addNewTitle();
        CTTx tx = title.isSetTx() ? title.getTx() : title.addNewTx();
        if (tx.isSetRich()) {
            tx.unsetRich();
        }
        (tx.isSetStrRef() ? tx.getStrRef() : tx.addNewStrRef()).setF(str);
    }

    public XSSFChart(PackagePart packagePart) {
        super(packagePart);
    }
}
