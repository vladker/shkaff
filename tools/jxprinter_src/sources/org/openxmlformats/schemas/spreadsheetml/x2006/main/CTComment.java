package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STGuid;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTComment extends XmlObject {
    public static final DocumentFactory<CTComment> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTComment> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcomment7bfetype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommentPr addNewCommentPr();

    CTRst addNewText();

    long getAuthorId();

    CTCommentPr getCommentPr();

    String getGuid();

    String getRef();

    long getShapeId();

    CTRst getText();

    boolean isSetCommentPr();

    boolean isSetGuid();

    boolean isSetShapeId();

    void setAuthorId(long j6);

    void setCommentPr(CTCommentPr cTCommentPr);

    void setGuid(String str);

    void setRef(String str);

    void setShapeId(long j6);

    void setText(CTRst cTRst);

    void unsetCommentPr();

    void unsetGuid();

    void unsetShapeId();

    XmlUnsignedInt xgetAuthorId();

    STGuid xgetGuid();

    STRef xgetRef();

    XmlUnsignedInt xgetShapeId();

    void xsetAuthorId(XmlUnsignedInt xmlUnsignedInt);

    void xsetGuid(STGuid sTGuid);

    void xsetRef(STRef sTRef);

    void xsetShapeId(XmlUnsignedInt xmlUnsignedInt);
}
