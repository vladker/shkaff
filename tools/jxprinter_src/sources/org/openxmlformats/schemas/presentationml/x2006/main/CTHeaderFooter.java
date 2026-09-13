package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTHeaderFooter extends XmlObject {
    public static final DocumentFactory<CTHeaderFooter> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHeaderFooter> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctheaderfooterb29dtype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionListModify addNewExtLst();

    boolean getDt();

    CTExtensionListModify getExtLst();

    boolean getFtr();

    boolean getHdr();

    boolean getSldNum();

    boolean isSetDt();

    boolean isSetExtLst();

    boolean isSetFtr();

    boolean isSetHdr();

    boolean isSetSldNum();

    void setDt(boolean z6);

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setFtr(boolean z6);

    void setHdr(boolean z6);

    void setSldNum(boolean z6);

    void unsetDt();

    void unsetExtLst();

    void unsetFtr();

    void unsetHdr();

    void unsetSldNum();

    XmlBoolean xgetDt();

    XmlBoolean xgetFtr();

    XmlBoolean xgetHdr();

    XmlBoolean xgetSldNum();

    void xsetDt(XmlBoolean xmlBoolean);

    void xsetFtr(XmlBoolean xmlBoolean);

    void xsetHdr(XmlBoolean xmlBoolean);

    void xsetSldNum(XmlBoolean xmlBoolean);
}
