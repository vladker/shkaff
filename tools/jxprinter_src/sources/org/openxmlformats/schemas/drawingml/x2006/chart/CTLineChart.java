package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLineChart extends XmlObject {
    public static final DocumentFactory<CTLineChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLineChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlinechart249ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTChartLines addNewDropLines();

    CTExtensionList addNewExtLst();

    CTGrouping addNewGrouping();

    CTChartLines addNewHiLowLines();

    CTBoolean addNewMarker();

    CTLineSer addNewSer();

    CTBoolean addNewSmooth();

    CTUpDownBars addNewUpDownBars();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTChartLines getDropLines();

    CTExtensionList getExtLst();

    CTGrouping getGrouping();

    CTChartLines getHiLowLines();

    CTBoolean getMarker();

    CTLineSer getSerArray(int i5);

    CTLineSer[] getSerArray();

    List<CTLineSer> getSerList();

    CTBoolean getSmooth();

    CTUpDownBars getUpDownBars();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i5);

    CTLineSer insertNewSer(int i5);

    boolean isSetDLbls();

    boolean isSetDropLines();

    boolean isSetExtLst();

    boolean isSetHiLowLines();

    boolean isSetMarker();

    boolean isSetSmooth();

    boolean isSetUpDownBars();

    boolean isSetVaryColors();

    void removeAxId(int i5);

    void removeSer(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setDropLines(CTChartLines cTChartLines);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGrouping(CTGrouping cTGrouping);

    void setHiLowLines(CTChartLines cTChartLines);

    void setMarker(CTBoolean cTBoolean);

    void setSerArray(int i5, CTLineSer cTLineSer);

    void setSerArray(CTLineSer[] cTLineSerArr);

    void setSmooth(CTBoolean cTBoolean);

    void setUpDownBars(CTUpDownBars cTUpDownBars);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetDropLines();

    void unsetExtLst();

    void unsetHiLowLines();

    void unsetMarker();

    void unsetSmooth();

    void unsetUpDownBars();

    void unsetVaryColors();
}
