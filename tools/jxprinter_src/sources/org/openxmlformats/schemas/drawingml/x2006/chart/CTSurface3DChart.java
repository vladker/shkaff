package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTSurface3DChart extends XmlObject {
    public static final DocumentFactory<CTSurface3DChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTSurface3DChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctsurface3dchartae5ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTBandFmts addNewBandFmts();

    CTExtensionList addNewExtLst();

    CTSurfaceSer addNewSer();

    CTBoolean addNewWireframe();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTBandFmts getBandFmts();

    CTExtensionList getExtLst();

    CTSurfaceSer getSerArray(int i5);

    CTSurfaceSer[] getSerArray();

    List<CTSurfaceSer> getSerList();

    CTBoolean getWireframe();

    CTUnsignedInt insertNewAxId(int i5);

    CTSurfaceSer insertNewSer(int i5);

    boolean isSetBandFmts();

    boolean isSetExtLst();

    boolean isSetWireframe();

    void removeAxId(int i5);

    void removeSer(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setBandFmts(CTBandFmts cTBandFmts);

    void setExtLst(CTExtensionList cTExtensionList);

    void setSerArray(int i5, CTSurfaceSer cTSurfaceSer);

    void setSerArray(CTSurfaceSer[] cTSurfaceSerArr);

    void setWireframe(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetBandFmts();

    void unsetExtLst();

    void unsetWireframe();
}
