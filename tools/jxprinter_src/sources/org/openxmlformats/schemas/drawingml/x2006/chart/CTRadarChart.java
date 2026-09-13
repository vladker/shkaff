package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTRadarChart extends XmlObject {
    public static final DocumentFactory<CTRadarChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTRadarChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctradarchart0f04type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTRadarStyle addNewRadarStyle();

    CTRadarSer addNewSer();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTRadarStyle getRadarStyle();

    CTRadarSer getSerArray(int i5);

    CTRadarSer[] getSerArray();

    List<CTRadarSer> getSerList();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i5);

    CTRadarSer insertNewSer(int i5);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetVaryColors();

    void removeAxId(int i5);

    void removeSer(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setRadarStyle(CTRadarStyle cTRadarStyle);

    void setSerArray(int i5, CTRadarSer cTRadarSer);

    void setSerArray(CTRadarSer[] cTRadarSerArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetVaryColors();
}
