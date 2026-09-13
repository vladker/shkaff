package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CmAuthorLstDocument extends XmlObject {
    public static final DocumentFactory<CmAuthorLstDocument> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CmAuthorLstDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cmauthorlst86abdoctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommentAuthorList addNewCmAuthorLst();

    CTCommentAuthorList getCmAuthorLst();

    void setCmAuthorLst(CTCommentAuthorList cTCommentAuthorList);
}
