package org.openxmlformats.schemas.presentationml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCommentAuthorList extends XmlObject {
    public static final DocumentFactory<CTCommentAuthorList> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCommentAuthorList> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcommentauthorlisteb07type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommentAuthor addNewCmAuthor();

    CTCommentAuthor getCmAuthorArray(int i5);

    CTCommentAuthor[] getCmAuthorArray();

    List<CTCommentAuthor> getCmAuthorList();

    CTCommentAuthor insertNewCmAuthor(int i5);

    void removeCmAuthor(int i5);

    void setCmAuthorArray(int i5, CTCommentAuthor cTCommentAuthor);

    void setCmAuthorArray(CTCommentAuthor[] cTCommentAuthorArr);

    int sizeOfCmAuthorArray();
}
