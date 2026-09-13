package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPlaceholder extends XmlObject {
    public static final DocumentFactory<CTPlaceholder> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPlaceholder> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctplaceholder9efctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionListModify addNewExtLst();

    CTExtensionListModify getExtLst();

    boolean getHasCustomPrompt();

    long getIdx();

    STDirection$Enum getOrient();

    STPlaceholderSize.Enum getSz();

    STPlaceholderType.Enum getType();

    boolean isSetExtLst();

    boolean isSetHasCustomPrompt();

    boolean isSetIdx();

    boolean isSetOrient();

    boolean isSetSz();

    boolean isSetType();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHasCustomPrompt(boolean z6);

    void setIdx(long j6);

    void setOrient(STDirection$Enum sTDirection$Enum);

    void setSz(STPlaceholderSize.Enum r6);

    void setType(STPlaceholderType.Enum r6);

    void unsetExtLst();

    void unsetHasCustomPrompt();

    void unsetIdx();

    void unsetOrient();

    void unsetSz();

    void unsetType();

    XmlBoolean xgetHasCustomPrompt();

    XmlUnsignedInt xgetIdx();

    STDirection xgetOrient();

    STPlaceholderSize xgetSz();

    STPlaceholderType xgetType();

    void xsetHasCustomPrompt(XmlBoolean xmlBoolean);

    void xsetIdx(XmlUnsignedInt xmlUnsignedInt);

    void xsetOrient(STDirection sTDirection);

    void xsetSz(STPlaceholderSize sTPlaceholderSize);

    void xsetType(STPlaceholderType sTPlaceholderType);
}
