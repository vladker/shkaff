package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNonVisualConnectorProperties extends XmlObject {
    public static final DocumentFactory<CTNonVisualConnectorProperties> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNonVisualConnectorProperties> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnonvisualconnectorproperties6f8etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTConnectorLocking addNewCxnSpLocks();

    CTConnection addNewEndCxn();

    CTOfficeArtExtensionList addNewExtLst();

    CTConnection addNewStCxn();

    CTConnectorLocking getCxnSpLocks();

    CTConnection getEndCxn();

    CTOfficeArtExtensionList getExtLst();

    CTConnection getStCxn();

    boolean isSetCxnSpLocks();

    boolean isSetEndCxn();

    boolean isSetExtLst();

    boolean isSetStCxn();

    void setCxnSpLocks(CTConnectorLocking cTConnectorLocking);

    void setEndCxn(CTConnection cTConnection);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setStCxn(CTConnection cTConnection);

    void unsetCxnSpLocks();

    void unsetEndCxn();

    void unsetExtLst();

    void unsetStCxn();
}
