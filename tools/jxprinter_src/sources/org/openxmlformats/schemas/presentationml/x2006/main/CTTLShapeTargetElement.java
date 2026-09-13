package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAnimationElementChoice;
import org.openxmlformats.schemas.drawingml.x2006.main.STDrawingElementId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTTLShapeTargetElement extends XmlObject {
    public static final DocumentFactory<CTTLShapeTargetElement> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTTLShapeTargetElement> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cttlshapetargetelement2763type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTEmpty addNewBg();

    CTAnimationElementChoice addNewGraphicEl();

    CTTLOleChartTargetElement addNewOleChartEl();

    CTTLSubShapeId addNewSubSp();

    CTTLTextTargetElement addNewTxEl();

    CTEmpty getBg();

    CTAnimationElementChoice getGraphicEl();

    CTTLOleChartTargetElement getOleChartEl();

    long getSpid();

    CTTLSubShapeId getSubSp();

    CTTLTextTargetElement getTxEl();

    boolean isSetBg();

    boolean isSetGraphicEl();

    boolean isSetOleChartEl();

    boolean isSetSubSp();

    boolean isSetTxEl();

    void setBg(CTEmpty cTEmpty);

    void setGraphicEl(CTAnimationElementChoice cTAnimationElementChoice);

    void setOleChartEl(CTTLOleChartTargetElement cTTLOleChartTargetElement);

    void setSpid(long j6);

    void setSubSp(CTTLSubShapeId cTTLSubShapeId);

    void setTxEl(CTTLTextTargetElement cTTLTextTargetElement);

    void unsetBg();

    void unsetGraphicEl();

    void unsetOleChartEl();

    void unsetSubSp();

    void unsetTxEl();

    STDrawingElementId xgetSpid();

    void xsetSpid(STDrawingElementId sTDrawingElementId);
}
