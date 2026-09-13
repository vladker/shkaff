package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTLine3DChart extends XmlObject {
    public static final DocumentFactory<CTLine3DChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLine3DChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctline3dchart214dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTChartLines addNewDropLines();

    CTExtensionList addNewExtLst();

    CTGapAmount addNewGapDepth();

    CTGrouping addNewGrouping();

    CTLineSer addNewSer();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTChartLines getDropLines();

    CTExtensionList getExtLst();

    CTGapAmount getGapDepth();

    CTGrouping getGrouping();

    CTLineSer getSerArray(int i5);

    CTLineSer[] getSerArray();

    List<CTLineSer> getSerList();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i5);

    CTLineSer insertNewSer(int i5);

    boolean isSetDLbls();

    boolean isSetDropLines();

    boolean isSetExtLst();

    boolean isSetGapDepth();

    boolean isSetVaryColors();

    void removeAxId(int i5);

    void removeSer(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setDropLines(CTChartLines cTChartLines);

    void setExtLst(CTExtensionList cTExtensionList);

    void setGapDepth(CTGapAmount cTGapAmount);

    void setGrouping(CTGrouping cTGrouping);

    void setSerArray(int i5, CTLineSer cTLineSer);

    void setSerArray(CTLineSer[] cTLineSerArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetDropLines();

    void unsetExtLst();

    void unsetGapDepth();

    void unsetVaryColors();
}
