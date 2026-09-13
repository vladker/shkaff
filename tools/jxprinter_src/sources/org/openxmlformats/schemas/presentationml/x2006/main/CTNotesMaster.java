package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNotesMaster extends XmlObject {
    public static final DocumentFactory<CTNotesMaster> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNotesMaster> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnotesmaster69ectype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCommonSlideData addNewCSld();

    CTColorMapping addNewClrMap();

    CTExtensionListModify addNewExtLst();

    CTHeaderFooter addNewHf();

    CTTextListStyle addNewNotesStyle();

    CTCommonSlideData getCSld();

    CTColorMapping getClrMap();

    CTExtensionListModify getExtLst();

    CTHeaderFooter getHf();

    CTTextListStyle getNotesStyle();

    boolean isSetExtLst();

    boolean isSetHf();

    boolean isSetNotesStyle();

    void setCSld(CTCommonSlideData cTCommonSlideData);

    void setClrMap(CTColorMapping cTColorMapping);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setHf(CTHeaderFooter cTHeaderFooter);

    void setNotesStyle(CTTextListStyle cTTextListStyle);

    void unsetExtLst();

    void unsetHf();

    void unsetNotesStyle();
}
