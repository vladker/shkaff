package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTHyperlink extends XmlObject {
    public static final DocumentFactory<CTHyperlink> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTHyperlink> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "cthyperlink4457type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTEmbeddedWAVAudioFile addNewSnd();

    String getAction();

    boolean getEndSnd();

    CTOfficeArtExtensionList getExtLst();

    boolean getHighlightClick();

    boolean getHistory();

    String getId();

    String getInvalidUrl();

    CTEmbeddedWAVAudioFile getSnd();

    String getTgtFrame();

    String getTooltip();

    boolean isSetAction();

    boolean isSetEndSnd();

    boolean isSetExtLst();

    boolean isSetHighlightClick();

    boolean isSetHistory();

    boolean isSetId();

    boolean isSetInvalidUrl();

    boolean isSetSnd();

    boolean isSetTgtFrame();

    boolean isSetTooltip();

    void setAction(String str);

    void setEndSnd(boolean z6);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHighlightClick(boolean z6);

    void setHistory(boolean z6);

    void setId(String str);

    void setInvalidUrl(String str);

    void setSnd(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void setTgtFrame(String str);

    void setTooltip(String str);

    void unsetAction();

    void unsetEndSnd();

    void unsetExtLst();

    void unsetHighlightClick();

    void unsetHistory();

    void unsetId();

    void unsetInvalidUrl();

    void unsetSnd();

    void unsetTgtFrame();

    void unsetTooltip();

    XmlString xgetAction();

    XmlBoolean xgetEndSnd();

    XmlBoolean xgetHighlightClick();

    XmlBoolean xgetHistory();

    STRelationshipId xgetId();

    XmlString xgetInvalidUrl();

    XmlString xgetTgtFrame();

    XmlString xgetTooltip();

    void xsetAction(XmlString xmlString);

    void xsetEndSnd(XmlBoolean xmlBoolean);

    void xsetHighlightClick(XmlBoolean xmlBoolean);

    void xsetHistory(XmlBoolean xmlBoolean);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetInvalidUrl(XmlString xmlString);

    void xsetTgtFrame(XmlString xmlString);

    void xsetTooltip(XmlString xmlString);
}
