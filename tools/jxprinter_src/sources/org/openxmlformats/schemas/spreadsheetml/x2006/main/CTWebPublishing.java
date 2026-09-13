package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTWebPublishing extends XmlObject {
    public static final DocumentFactory<CTWebPublishing> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTWebPublishing> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctwebpublishing4646type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getAllowPng();

    String getCharacterSet();

    long getCodePage();

    boolean getCss();

    long getDpi();

    boolean getLongFileNames();

    STTargetScreenSize$Enum getTargetScreenSize();

    boolean getThicket();

    boolean getVml();

    boolean isSetAllowPng();

    boolean isSetCharacterSet();

    boolean isSetCodePage();

    boolean isSetCss();

    boolean isSetDpi();

    boolean isSetLongFileNames();

    boolean isSetTargetScreenSize();

    boolean isSetThicket();

    boolean isSetVml();

    void setAllowPng(boolean z6);

    void setCharacterSet(String str);

    void setCodePage(long j6);

    void setCss(boolean z6);

    void setDpi(long j6);

    void setLongFileNames(boolean z6);

    void setTargetScreenSize(STTargetScreenSize$Enum sTTargetScreenSize$Enum);

    void setThicket(boolean z6);

    void setVml(boolean z6);

    void unsetAllowPng();

    void unsetCharacterSet();

    void unsetCodePage();

    void unsetCss();

    void unsetDpi();

    void unsetLongFileNames();

    void unsetTargetScreenSize();

    void unsetThicket();

    void unsetVml();

    XmlBoolean xgetAllowPng();

    XmlString xgetCharacterSet();

    XmlUnsignedInt xgetCodePage();

    XmlBoolean xgetCss();

    XmlUnsignedInt xgetDpi();

    XmlBoolean xgetLongFileNames();

    STTargetScreenSize xgetTargetScreenSize();

    XmlBoolean xgetThicket();

    XmlBoolean xgetVml();

    void xsetAllowPng(XmlBoolean xmlBoolean);

    void xsetCharacterSet(XmlString xmlString);

    void xsetCodePage(XmlUnsignedInt xmlUnsignedInt);

    void xsetCss(XmlBoolean xmlBoolean);

    void xsetDpi(XmlUnsignedInt xmlUnsignedInt);

    void xsetLongFileNames(XmlBoolean xmlBoolean);

    void xsetTargetScreenSize(STTargetScreenSize sTTargetScreenSize);

    void xsetThicket(XmlBoolean xmlBoolean);

    void xsetVml(XmlBoolean xmlBoolean);
}
