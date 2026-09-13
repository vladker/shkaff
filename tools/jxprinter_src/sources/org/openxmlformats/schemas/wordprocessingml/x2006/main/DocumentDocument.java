package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface DocumentDocument extends XmlObject {
    public static final DocumentFactory<DocumentDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<DocumentDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "document2bd9doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTDocument1 addNewDocument();

    CTDocument1 getDocument();

    void setDocument(CTDocument1 cTDocument1);
}
