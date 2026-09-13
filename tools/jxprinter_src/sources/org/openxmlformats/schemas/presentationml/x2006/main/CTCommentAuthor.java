package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTCommentAuthor extends XmlObject {
    public static final DocumentFactory<CTCommentAuthor> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCommentAuthor> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcommentauthora405type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    long getClrIdx();

    CTExtensionList getExtLst();

    long getId();

    String getInitials();

    long getLastIdx();

    String getName();

    boolean isSetExtLst();

    void setClrIdx(long j6);

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j6);

    void setInitials(String str);

    void setLastIdx(long j6);

    void setName(String str);

    void unsetExtLst();

    XmlUnsignedInt xgetClrIdx();

    XmlUnsignedInt xgetId();

    STName xgetInitials();

    XmlUnsignedInt xgetLastIdx();

    STName xgetName();

    void xsetClrIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetId(XmlUnsignedInt xmlUnsignedInt);

    void xsetInitials(STName sTName);

    void xsetLastIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetName(STName sTName);
}
