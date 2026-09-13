package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCommentList extends XmlObject {
    public static final DocumentFactory<CTCommentList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCommentList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcommentlist7a3ctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTComment addNewComment();

    CTComment getCommentArray(int i5);

    CTComment[] getCommentArray();

    List<CTComment> getCommentList();

    CTComment insertNewComment(int i5);

    void removeComment(int i5);

    void setCommentArray(int i5, CTComment cTComment);

    void setCommentArray(CTComment[] cTCommentArr);

    int sizeOfCommentArray();
}
