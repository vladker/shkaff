package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCustomGeometry2D extends XmlObject {
    public static final DocumentFactory<CTCustomGeometry2D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCustomGeometry2D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcustomgeometry2dca70type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTAdjustHandleList addNewAhLst();

    CTGeomGuideList addNewAvLst();

    CTConnectionSiteList addNewCxnLst();

    CTGeomGuideList addNewGdLst();

    CTPath2DList addNewPathLst();

    CTGeomRect addNewRect();

    CTAdjustHandleList getAhLst();

    CTGeomGuideList getAvLst();

    CTConnectionSiteList getCxnLst();

    CTGeomGuideList getGdLst();

    CTPath2DList getPathLst();

    CTGeomRect getRect();

    boolean isSetAhLst();

    boolean isSetAvLst();

    boolean isSetCxnLst();

    boolean isSetGdLst();

    boolean isSetRect();

    void setAhLst(CTAdjustHandleList cTAdjustHandleList);

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setCxnLst(CTConnectionSiteList cTConnectionSiteList);

    void setGdLst(CTGeomGuideList cTGeomGuideList);

    void setPathLst(CTPath2DList cTPath2DList);

    void setRect(CTGeomRect cTGeomRect);

    void unsetAhLst();

    void unsetAvLst();

    void unsetCxnLst();

    void unsetGdLst();

    void unsetRect();
}
