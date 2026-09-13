package org.openxmlformats.schemas.drawingml.x2006.chart;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTPrintSettings extends XmlObject {
    public static final DocumentFactory<CTPrintSettings> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTPrintSettings> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctprintsettings61b6type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHeaderFooter addNewHeaderFooter();

    CTRelId addNewLegacyDrawingHF();

    CTPageMargins addNewPageMargins();

    CTPageSetup addNewPageSetup();

    CTHeaderFooter getHeaderFooter();

    CTRelId getLegacyDrawingHF();

    CTPageMargins getPageMargins();

    CTPageSetup getPageSetup();

    boolean isSetHeaderFooter();

    boolean isSetLegacyDrawingHF();

    boolean isSetPageMargins();

    boolean isSetPageSetup();

    void setHeaderFooter(CTHeaderFooter cTHeaderFooter);

    void setLegacyDrawingHF(CTRelId cTRelId);

    void setPageMargins(CTPageMargins cTPageMargins);

    void setPageSetup(CTPageSetup cTPageSetup);

    void unsetHeaderFooter();

    void unsetLegacyDrawingHF();

    void unsetPageMargins();

    void unsetPageSetup();
}
