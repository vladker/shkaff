package org.apache.poi.xddf.usermodel.chart;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.util.Internal;
import org.apache.poi.util.Removal;
import org.apache.poi.xddf.usermodel.XDDFFillProperties;
import org.apache.poi.xddf.usermodel.XDDFLineProperties;
import org.apache.poi.xddf.usermodel.XDDFShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDPt;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrRef;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTUnsignedInt;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class XDDFChartData {
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) XDDFChartData.class);
    private XDDFCategoryAxis categoryAxis;
    protected XDDFChart parent;
    protected List<Series> series = new ArrayList();
    private List<XDDFValueAxis> valueAxes;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class Series {
        protected XDDFDataSource<?> categoryData;
        protected XDDFNumericalDataSource<? extends Number> valuesData;

        public Series(XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
            replaceData(xDDFDataSource, xDDFNumericalDataSource);
        }

        private CTNumData retrieveNumCache(CTAxDataSource cTAxDataSource, XDDFDataSource<?> xDDFDataSource) {
            if (!xDDFDataSource.isReference()) {
                CTNumData numLit = cTAxDataSource.isSetNumLit() ? cTAxDataSource.getNumLit() : cTAxDataSource.addNewNumLit();
                if (cTAxDataSource.isSetNumRef()) {
                    cTAxDataSource.unsetNumRef();
                }
                return numLit;
            }
            CTNumRef numRef = cTAxDataSource.isSetNumRef() ? cTAxDataSource.getNumRef() : cTAxDataSource.addNewNumRef();
            CTNumData numCache = numRef.isSetNumCache() ? numRef.getNumCache() : numRef.addNewNumCache();
            numRef.setF(xDDFDataSource.getDataRangeReference());
            if (cTAxDataSource.isSetNumLit()) {
                cTAxDataSource.unsetNumLit();
            }
            return numCache;
        }

        private CTStrData retrieveStrCache(CTAxDataSource cTAxDataSource, XDDFDataSource<?> xDDFDataSource) {
            if (!xDDFDataSource.isReference()) {
                CTStrData strLit = cTAxDataSource.isSetStrLit() ? cTAxDataSource.getStrLit() : cTAxDataSource.addNewStrLit();
                if (cTAxDataSource.isSetStrRef()) {
                    cTAxDataSource.unsetStrRef();
                }
                return strLit;
            }
            CTStrRef strRef = cTAxDataSource.isSetStrRef() ? cTAxDataSource.getStrRef() : cTAxDataSource.addNewStrRef();
            CTStrData strCache = strRef.isSetStrCache() ? strRef.getStrCache() : strRef.addNewStrCache();
            strRef.setF(xDDFDataSource.getDataRangeReference());
            if (cTAxDataSource.isSetStrLit()) {
                cTAxDataSource.unsetStrLit();
            }
            return strCache;
        }

        public void clearDataPoint(long j6) {
            List<CTDPt> dPtList = getDPtList();
            for (int i5 = 0; i5 < dPtList.size(); i5++) {
                if (dPtList.get(i5).getIdx().getVal() == j6) {
                    dPtList.remove(i5);
                    return;
                }
            }
        }

        public abstract CTAxDataSource getAxDS();

        public XDDFDataSource<?> getCategoryData() {
            return this.categoryData;
        }

        public abstract List<CTDPt> getDPtList();

        public XDDFDataPoint getDataPoint(long j6) {
            List<CTDPt> dPtList = getDPtList();
            for (int i5 = 0; i5 < dPtList.size(); i5++) {
                if (dPtList.get(i5).getIdx().getVal() == j6) {
                    return new XDDFDataPoint(dPtList.get(i5));
                }
                if (dPtList.get(i5).getIdx().getVal() > j6) {
                    dPtList.add(i5, CTDPt.Factory.newInstance());
                    CTDPt cTDPt = dPtList.get(i5);
                    cTDPt.addNewIdx().setVal(j6);
                    return new XDDFDataPoint(cTDPt);
                }
            }
            dPtList.add(CTDPt.Factory.newInstance());
            CTDPt cTDPt2 = dPtList.get(dPtList.size() - 1);
            cTDPt2.addNewIdx().setVal(j6);
            return new XDDFDataPoint(cTDPt2);
        }

        public abstract CTNumDataSource getNumDS();

        public abstract CTSerTx getSeriesText();

        public abstract XDDFShapeProperties getShapeProperties();

        public XDDFNumericalDataSource<? extends Number> getValuesData() {
            return this.valuesData;
        }

        public void plot() {
            XDDFDataSource<?> xDDFDataSource = this.categoryData;
            if (xDDFDataSource != null) {
                if (xDDFDataSource.isNumeric()) {
                    this.categoryData.fillNumericalCache(retrieveNumCache(getAxDS(), this.categoryData));
                } else {
                    this.categoryData.fillStringCache(retrieveStrCache(getAxDS(), this.categoryData));
                }
            }
            if (this.valuesData != null) {
                this.valuesData.fillNumericalCache(retrieveNumCache(getNumDS(), this.valuesData));
            }
        }

        public void replaceData(XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource) {
            int pointCount;
            if (this.categoryData != null && xDDFNumericalDataSource != null && (pointCount = xDDFDataSource.getPointCount()) != xDDFNumericalDataSource.getPointCount()) {
                Logger logger = XDDFChartData.LOGGER;
                StringBuilder sbT = AbstractC0157z.t(pointCount, "Category and values must have the same point count, but had ", " categories and ");
                sbT.append(xDDFNumericalDataSource.getPointCount());
                sbT.append(" values.");
                logger.warn(sbT.toString());
            }
            this.categoryData = xDDFDataSource;
            this.valuesData = xDDFNumericalDataSource;
        }

        public void setFillProperties(XDDFFillProperties xDDFFillProperties) {
            XDDFShapeProperties shapeProperties = getShapeProperties();
            if (shapeProperties == null) {
                shapeProperties = new XDDFShapeProperties();
            }
            shapeProperties.setFillProperties(xDDFFillProperties);
            setShapeProperties(shapeProperties);
        }

        public abstract void setIndex(long j6);

        public void setLineProperties(XDDFLineProperties xDDFLineProperties) {
            XDDFShapeProperties shapeProperties = getShapeProperties();
            if (shapeProperties == null) {
                shapeProperties = new XDDFShapeProperties();
            }
            shapeProperties.setLineProperties(xDDFLineProperties);
            setShapeProperties(shapeProperties);
        }

        public abstract void setOrder(long j6);

        public abstract void setShapeProperties(XDDFShapeProperties xDDFShapeProperties);

        public abstract void setShowLeaderLines(boolean z6);

        public void setTitle(String str) {
            setTitle(str, null);
        }

        public void setTitle(String str, CellReference cellReference) {
            if (cellReference == null) {
                getSeriesText().setV(str);
                return;
            }
            CTStrRef strRef = getSeriesText().isSetStrRef() ? getSeriesText().getStrRef() : getSeriesText().addNewStrRef();
            strRef.setF(cellReference.formatAsString());
            if (str != null) {
                CTStrData strCache = strRef.isSetStrCache() ? strRef.getStrCache() : strRef.addNewStrCache();
                if (strCache.sizeOfPtArray() < 1) {
                    strCache.addNewPtCount().setVal(1L);
                    strCache.addNewPt().setIdx(0L);
                }
                strCache.getPtArray(0).setV(str);
            }
        }

        public CTNumData retrieveNumCache(CTNumDataSource cTNumDataSource, XDDFDataSource<?> xDDFDataSource) {
            CTNumData cTNumDataAddNewNumLit;
            CTNumRef cTNumRefAddNewNumRef;
            CTNumData cTNumDataAddNewNumCache;
            if (xDDFDataSource.isReference()) {
                if (cTNumDataSource.isSetNumRef()) {
                    cTNumRefAddNewNumRef = cTNumDataSource.getNumRef();
                } else {
                    cTNumRefAddNewNumRef = cTNumDataSource.addNewNumRef();
                }
                if (cTNumRefAddNewNumRef.isSetNumCache()) {
                    cTNumDataAddNewNumCache = cTNumRefAddNewNumRef.getNumCache();
                } else {
                    cTNumDataAddNewNumCache = cTNumRefAddNewNumRef.addNewNumCache();
                }
                cTNumRefAddNewNumRef.setF(xDDFDataSource.getDataRangeReference());
                if (cTNumDataSource.isSetNumLit()) {
                    cTNumDataSource.unsetNumLit();
                }
                return cTNumDataAddNewNumCache;
            }
            if (cTNumDataSource.isSetNumLit()) {
                cTNumDataAddNewNumLit = cTNumDataSource.getNumLit();
            } else {
                cTNumDataAddNewNumLit = cTNumDataSource.addNewNumLit();
            }
            if (cTNumDataSource.isSetNumRef()) {
                cTNumDataSource.unsetNumRef();
            }
            return cTNumDataAddNewNumLit;
        }
    }

    public XDDFChartData(XDDFChart xDDFChart) {
        this.parent = xDDFChart;
    }

    public abstract Series addSeries(XDDFDataSource<?> xDDFDataSource, XDDFNumericalDataSource<? extends Number> xDDFNumericalDataSource);

    public void defineAxes(CTUnsignedInt[] cTUnsignedIntArr, Map<Long, XDDFChartAxis> map, Map<Long, XDDFValueAxis> map2) {
        ArrayList arrayList = new ArrayList(cTUnsignedIntArr.length);
        for (CTUnsignedInt cTUnsignedInt : cTUnsignedIntArr) {
            Long lValueOf = Long.valueOf(cTUnsignedInt.getVal());
            XDDFChartAxis xDDFChartAxis = map.get(lValueOf);
            if (xDDFChartAxis == null) {
                XDDFValueAxis xDDFValueAxis = map2.get(lValueOf);
                if (xDDFValueAxis != null) {
                    arrayList.add(xDDFValueAxis);
                }
            } else if (xDDFChartAxis instanceof XDDFCategoryAxis) {
                this.categoryAxis = (XDDFCategoryAxis) xDDFChartAxis;
            }
        }
        this.valueAxes = Collections.unmodifiableList(arrayList);
    }

    public XDDFCategoryAxis getCategoryAxis() {
        return this.categoryAxis;
    }

    @Removal(version = "5.3")
    @Deprecated
    public List<Series> getSeries() {
        return Collections.unmodifiableList(this.series);
    }

    public final int getSeriesCount() {
        return this.series.size();
    }

    public List<XDDFValueAxis> getValueAxes() {
        return this.valueAxes;
    }

    @Internal
    public abstract void removeCTSeries(int i5);

    public final void removeSeries(int i5) {
        if (i5 < 0 || this.series.size() <= i5) {
            Locale locale = Locale.ROOT;
            throw new IllegalArgumentException(a.i(i5, "removeSeries(", "): illegal index"));
        }
        this.series.remove(i5);
        removeCTSeries(i5);
    }

    public abstract void setVaryColors(Boolean bool);

    public final Series getSeries(int i5) {
        return this.series.get(i5);
    }
}
