package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTScatterChart extends XmlObject {
    public static final DocumentFactory<CTScatterChart> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTScatterChart> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctscatterchart2bfctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTUnsignedInt addNewAxId();

    CTDLbls addNewDLbls();

    CTExtensionList addNewExtLst();

    CTScatterStyle addNewScatterStyle();

    CTScatterSer addNewSer();

    CTBoolean addNewVaryColors();

    CTUnsignedInt getAxIdArray(int i5);

    CTUnsignedInt[] getAxIdArray();

    List<CTUnsignedInt> getAxIdList();

    CTDLbls getDLbls();

    CTExtensionList getExtLst();

    CTScatterStyle getScatterStyle();

    CTScatterSer getSerArray(int i5);

    CTScatterSer[] getSerArray();

    List<CTScatterSer> getSerList();

    CTBoolean getVaryColors();

    CTUnsignedInt insertNewAxId(int i5);

    CTScatterSer insertNewSer(int i5);

    boolean isSetDLbls();

    boolean isSetExtLst();

    boolean isSetVaryColors();

    void removeAxId(int i5);

    void removeSer(int i5);

    void setAxIdArray(int i5, CTUnsignedInt cTUnsignedInt);

    void setAxIdArray(CTUnsignedInt[] cTUnsignedIntArr);

    void setDLbls(CTDLbls cTDLbls);

    void setExtLst(CTExtensionList cTExtensionList);

    void setScatterStyle(CTScatterStyle cTScatterStyle);

    void setSerArray(int i5, CTScatterSer cTScatterSer);

    void setSerArray(CTScatterSer[] cTScatterSerArr);

    void setVaryColors(CTBoolean cTBoolean);

    int sizeOfAxIdArray();

    int sizeOfSerArray();

    void unsetDLbls();

    void unsetExtLst();

    void unsetVaryColors();
}
