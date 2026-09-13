package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTBarChart extends XmlObject {
    public static final DocumentFactory<CTBarChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTBarChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctbarchart4151type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTBarDir addNewBarDir();

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTGapAmount addNewGapWidth();

    CTBarGrouping addNewGrouping();

    CTOverlap addNewOverlap();

    CTBarSer addNewSer();

    CTChartLines addNewSerLines();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTBarDir getBarDir();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTGapAmount getGapWidth();

    CTBarGrouping getGrouping();

    CTOverlap getOverlap();

    CTBarSer getSerArray(int i5);

    CTBarSer[] getSerArray();

    CTChartLines getSerLinesArray(int i5);

    CTChartLines[] getSerLinesArray();

    List<CTChartLines> getSerLinesList();

    List<CTBarSer> getSerList();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i5);

    CTBarSer insertNewSer(int i5);

    CTChartLines insertNewSerLines(int i5);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetGapWidth();

    boolean isSetGrouping();

    boolean isSetOverlap();

    boolean isSetVaryColors();

    void removeAxId(int i5);

    void removeSer(int i5);

    void removeSerLines(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setBarDir(CTBarDir cTBarDir);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGapWidth(CTGapAmount cTGapAmount);

    void setGrouping(CTBarGrouping cTBarGrouping);

    void setOverlap(CTOverlap cTOverlap);

    void setSerArray(int i5, CTBarSer cTBarSer);

    void setSerArray(CTBarSer[] cTBarSerArr);

    void setSerLinesArray(int i5, CTChartLines cTChartLines);

    void setSerLinesArray(CTChartLines[] cTChartLinesArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    int sizeOfSerLinesArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetGapWidth();

    void unsetGrouping();

    void unsetOverlap();

    void unsetVaryColors();
}
