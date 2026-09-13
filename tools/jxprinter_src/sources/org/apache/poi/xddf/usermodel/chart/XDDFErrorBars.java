package org.apache.poi.xddf.usermodel.chart;

import org.apache.poi.util.Internal;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrBars;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XDDFErrorBars {
    private CTErrBars bars;

    public XDDFErrorBars() {
        this(CTErrBars.Factory.newInstance());
    }

    private CTNumData retrieveCache(CTNumDataSource cTNumDataSource, String str) {
        if (!cTNumDataSource.isSetNumRef()) {
            return cTNumDataSource.getNumLit();
        }
        CTNumRef numRef = cTNumDataSource.getNumRef();
        numRef.setF(str);
        return numRef.getNumCache();
    }

    public ErrorBarType getErrorBarType() {
        if (this.bars.getErrBarType() == null) {
            return null;
        }
        return ErrorBarType.valueOf(this.bars.getErrBarType().getVal());
    }

    public ErrorDirection getErrorDirection() {
        if (this.bars.isSetErrDir()) {
            return ErrorDirection.valueOf(this.bars.getErrDir().getVal());
        }
        return null;
    }

    public ErrorValueType getErrorValueType() {
        if (this.bars.getErrValType() == null) {
            return null;
        }
        return ErrorValueType.valueOf(this.bars.getErrValType().getVal());
    }

    public XDDFChartExtensionList getExtensionList() {
        if (this.bars.isSetExtLst()) {
            return new XDDFChartExtensionList(this.bars.getExtLst());
        }
        return null;
    }

    public XDDFNumericalDataSource<Double> getMinus() {
        if (this.bars.isSetMinus()) {
            return XDDFDataSourcesFactory.fromDataSource(this.bars.getMinus());
        }
        return null;
    }

    public Boolean getNoEndCap() {
        if (this.bars.isSetVal()) {
            return Boolean.valueOf(this.bars.getNoEndCap().getVal());
        }
        return null;
    }

    public XDDFNumericalDataSource<Double> getPlus() {
        if (this.bars.isSetPlus()) {
            return XDDFDataSourcesFactory.fromDataSource(this.bars.getPlus());
        }
        return null;
    }

    public XDDFShapeProperties getShapeProperties() {
        if (this.bars.isSetSpPr()) {
            return new XDDFShapeProperties(this.bars.getSpPr());
        }
        return null;
    }

    public Double getValue() {
        if (this.bars.isSetVal()) {
            return Double.valueOf(this.bars.getVal().getVal());
        }
        return null;
    }

    @Internal
    public XmlObject getXmlObject() {
        return this.bars;
    }

    public void setErrorBarType(ErrorBarType errorBarType) {
        this.bars.getErrBarType().setVal(errorBarType.underlying);
    }

    public void setErrorDirection(ErrorDirection errorDirection) {
        if (errorDirection == null) {
            if (this.bars.isSetErrDir()) {
                this.bars.unsetErrDir();
            }
        } else if (this.bars.isSetErrDir()) {
            this.bars.getErrDir().setVal(errorDirection.underlying);
        } else {
            this.bars.addNewErrDir().setVal(errorDirection.underlying);
        }
    }

    public void setErrorValueType(ErrorValueType errorValueType) {
        this.bars.getErrValType().setVal(errorValueType.underlying);
    }

    public void setExtensionList(XDDFChartExtensionList xDDFChartExtensionList) {
        if (xDDFChartExtensionList != null) {
            this.bars.setExtLst(xDDFChartExtensionList.getXmlObject());
        } else if (this.bars.isSetExtLst()) {
            this.bars.unsetExtLst();
        }
    }

    public void setMinus(XDDFNumericalDataSource<Double> xDDFNumericalDataSource) {
        if (xDDFNumericalDataSource == null) {
            if (this.bars.isSetMinus()) {
                this.bars.unsetMinus();
            }
        } else {
            if (this.bars.isSetMinus()) {
                xDDFNumericalDataSource.fillNumericalCache(retrieveCache(this.bars.getMinus(), xDDFNumericalDataSource.getDataRangeReference()));
                return;
            }
            CTNumDataSource cTNumDataSourceAddNewMinus = this.bars.addNewMinus();
            cTNumDataSourceAddNewMinus.addNewNumLit();
            xDDFNumericalDataSource.fillNumericalCache(retrieveCache(cTNumDataSourceAddNewMinus, xDDFNumericalDataSource.getDataRangeReference()));
        }
    }

    public void setNoEndCap(Boolean bool) {
        if (bool == null) {
            if (this.bars.isSetNoEndCap()) {
                this.bars.unsetNoEndCap();
            }
        } else if (this.bars.isSetNoEndCap()) {
            this.bars.getNoEndCap().setVal(bool.booleanValue());
        } else {
            this.bars.addNewNoEndCap().setVal(bool.booleanValue());
        }
    }

    public void setPlus(XDDFNumericalDataSource<Double> xDDFNumericalDataSource) {
        if (xDDFNumericalDataSource == null) {
            if (this.bars.isSetPlus()) {
                this.bars.unsetPlus();
            }
        } else {
            if (this.bars.isSetPlus()) {
                xDDFNumericalDataSource.fillNumericalCache(retrieveCache(this.bars.getPlus(), xDDFNumericalDataSource.getDataRangeReference()));
                return;
            }
            CTNumDataSource cTNumDataSourceAddNewPlus = this.bars.addNewPlus();
            cTNumDataSourceAddNewPlus.addNewNumLit();
            xDDFNumericalDataSource.fillNumericalCache(retrieveCache(cTNumDataSourceAddNewPlus, xDDFNumericalDataSource.getDataRangeReference()));
        }
    }

    public void setShapeProperties(XDDFShapeProperties xDDFShapeProperties) {
        if (xDDFShapeProperties == null) {
            if (this.bars.isSetSpPr()) {
                this.bars.unsetSpPr();
            }
        } else if (this.bars.isSetSpPr()) {
            this.bars.setSpPr(xDDFShapeProperties.getXmlObject());
        } else {
            this.bars.addNewSpPr().set(xDDFShapeProperties.getXmlObject());
        }
    }

    public void setValue(Double d) {
        if (d == null) {
            if (this.bars.isSetVal()) {
                this.bars.unsetVal();
            }
        } else if (this.bars.isSetVal()) {
            this.bars.getVal().setVal(d.doubleValue());
        } else {
            this.bars.addNewVal().setVal(d.doubleValue());
        }
    }

    @Internal
    public XDDFErrorBars(CTErrBars cTErrBars) {
        this.bars = cTErrBars;
    }
}
