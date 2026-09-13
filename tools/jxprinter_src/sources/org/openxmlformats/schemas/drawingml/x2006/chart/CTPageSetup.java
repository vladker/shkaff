package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STPositiveUniversalMeasure;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPageSetup extends XmlObject {
    public static final DocumentFactory<CTPageSetup> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPageSetup> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctpagesetupdb38type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getBlackAndWhite();

    long getCopies();

    boolean getDraft();

    long getFirstPageNumber();

    int getHorizontalDpi();

    STPageSetupOrientation$Enum getOrientation();

    String getPaperHeight();

    long getPaperSize();

    String getPaperWidth();

    boolean getUseFirstPageNumber();

    int getVerticalDpi();

    boolean isSetBlackAndWhite();

    boolean isSetCopies();

    boolean isSetDraft();

    boolean isSetFirstPageNumber();

    boolean isSetHorizontalDpi();

    boolean isSetOrientation();

    boolean isSetPaperHeight();

    boolean isSetPaperSize();

    boolean isSetPaperWidth();

    boolean isSetUseFirstPageNumber();

    boolean isSetVerticalDpi();

    void setBlackAndWhite(boolean z6);

    void setCopies(long j6);

    void setDraft(boolean z6);

    void setFirstPageNumber(long j6);

    void setHorizontalDpi(int i5);

    void setOrientation(STPageSetupOrientation$Enum sTPageSetupOrientation$Enum);

    void setPaperHeight(String str);

    void setPaperSize(long j6);

    void setPaperWidth(String str);

    void setUseFirstPageNumber(boolean z6);

    void setVerticalDpi(int i5);

    void unsetBlackAndWhite();

    void unsetCopies();

    void unsetDraft();

    void unsetFirstPageNumber();

    void unsetHorizontalDpi();

    void unsetOrientation();

    void unsetPaperHeight();

    void unsetPaperSize();

    void unsetPaperWidth();

    void unsetUseFirstPageNumber();

    void unsetVerticalDpi();

    XmlBoolean xgetBlackAndWhite();

    XmlUnsignedInt xgetCopies();

    XmlBoolean xgetDraft();

    XmlUnsignedInt xgetFirstPageNumber();

    XmlInt xgetHorizontalDpi();

    STPageSetupOrientation xgetOrientation();

    STPositiveUniversalMeasure xgetPaperHeight();

    XmlUnsignedInt xgetPaperSize();

    STPositiveUniversalMeasure xgetPaperWidth();

    XmlBoolean xgetUseFirstPageNumber();

    XmlInt xgetVerticalDpi();

    void xsetBlackAndWhite(XmlBoolean xmlBoolean);

    void xsetCopies(XmlUnsignedInt xmlUnsignedInt);

    void xsetDraft(XmlBoolean xmlBoolean);

    void xsetFirstPageNumber(XmlUnsignedInt xmlUnsignedInt);

    void xsetHorizontalDpi(XmlInt xmlInt);

    void xsetOrientation(STPageSetupOrientation sTPageSetupOrientation);

    void xsetPaperHeight(STPositiveUniversalMeasure sTPositiveUniversalMeasure);

    void xsetPaperSize(XmlUnsignedInt xmlUnsignedInt);

    void xsetPaperWidth(STPositiveUniversalMeasure sTPositiveUniversalMeasure);

    void xsetUseFirstPageNumber(XmlBoolean xmlBoolean);

    void xsetVerticalDpi(XmlInt xmlInt);
}
