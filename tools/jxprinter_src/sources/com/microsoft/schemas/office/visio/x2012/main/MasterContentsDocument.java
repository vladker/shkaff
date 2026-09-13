package com.microsoft.schemas.office.visio.x2012.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface MasterContentsDocument extends XmlObject {
    public static final DocumentFactory<MasterContentsDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<MasterContentsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "mastercontentscb9edoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    PageContentsType addNewMasterContents();

    PageContentsType getMasterContents();

    void setMasterContents(PageContentsType pageContentsType);
}
