package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTScene3D extends XmlObject {
    public static final DocumentFactory<CTScene3D> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTScene3D> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctscene3d736etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTBackdrop addNewBackdrop();

    CTCamera addNewCamera();

    CTOfficeArtExtensionList addNewExtLst();

    CTLightRig addNewLightRig();

    CTBackdrop getBackdrop();

    CTCamera getCamera();

    CTOfficeArtExtensionList getExtLst();

    CTLightRig getLightRig();

    boolean isSetBackdrop();

    boolean isSetExtLst();

    void setBackdrop(CTBackdrop cTBackdrop);

    void setCamera(CTCamera cTCamera);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setLightRig(CTLightRig cTLightRig);

    void unsetBackdrop();

    void unsetExtLst();
}
