package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTScatterSer extends XmlObject {
    public static final DocumentFactory<CTScatterSer> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTScatterSer> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctscatterser2f7atype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDLbls addNewDLbls();

    CTDPt addNewDPt();

    CTErrBars addNewErrBars();

    CTExtensionList addNewExtLst();

    CTUnsignedInt addNewIdx();

    CTMarker addNewMarker();

    CTUnsignedInt addNewOrder();

    CTBoolean addNewSmooth();

    CTShapeProperties addNewSpPr();

    CTTrendline addNewTrendline();

    CTSerTx addNewTx();

    CTAxDataSource addNewXVal();

    CTNumDataSource addNewYVal();

    CTDLbls getDLbls();

    CTDPt getDPtArray(int i5);

    CTDPt[] getDPtArray();

    List<CTDPt> getDPtList();

    CTErrBars getErrBarsArray(int i5);

    CTErrBars[] getErrBarsArray();

    List<CTErrBars> getErrBarsList();

    CTExtensionList getExtLst();

    CTUnsignedInt getIdx();

    CTMarker getMarker();

    CTUnsignedInt getOrder();

    CTBoolean getSmooth();

    CTShapeProperties getSpPr();

    CTTrendline getTrendlineArray(int i5);

    CTTrendline[] getTrendlineArray();

    List<CTTrendline> getTrendlineList();

    CTSerTx getTx();

    CTAxDataSource getXVal();

    CTNumDataSource getYVal();

    CTDPt insertNewDPt(int i5);

    CTErrBars insertNewErrBars(int i5);

    CTTrendline insertNewTrendline(int i5);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetMarker();

    boolean isSetSmooth();

    boolean isSetSpPr();

    boolean isSetTx();

    boolean isSetXVal();

    boolean isSetYVal();

    void removeDPt(int i5);

    void removeErrBars(int i5);

    void removeTrendline(int i5);

    void setDLbls(CTDLbls cTDLbls);

    void setDPtArray(int i5, CTDPt cTDPt);

    void setDPtArray(CTDPt[] cTDPtArr);

    void setErrBarsArray(int i5, CTErrBars cTErrBars);

    void setErrBarsArray(CTErrBars[] cTErrBarsArr);

    void setExtLst(CTExtensionList cTExtensionList);

    void setIdx(CTUnsignedInt cTUnsignedInt);

    void setMarker(CTMarker cTMarker);

    void setOrder(CTUnsignedInt cTUnsignedInt);

    void setSmooth(CTBoolean cTBoolean);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setTrendlineArray(int i5, CTTrendline cTTrendline);

    void setTrendlineArray(CTTrendline[] cTTrendlineArr);

    void setTx(CTSerTx cTSerTx);

    void setXVal(CTAxDataSource cTAxDataSource);

    void setYVal(CTNumDataSource cTNumDataSource);

    int sizeOfDPtArray();

    int sizeOfErrBarsArray();

    int sizeOfTrendlineArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetMarker();

    void unsetSmooth();

    void unsetSpPr();

    void unsetTx();

    void unsetXVal();

    void unsetYVal();
}
