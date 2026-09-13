package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTColorScale extends XmlObject {
    public static final DocumentFactory<CTColorScale> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTColorScale> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcolorscale1a70type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTCfvo addNewCfvo();

    CTColor addNewColor();

    CTCfvo getCfvoArray(int i5);

    CTCfvo[] getCfvoArray();

    List<CTCfvo> getCfvoList();

    CTColor getColorArray(int i5);

    CTColor[] getColorArray();

    List<CTColor> getColorList();

    CTCfvo insertNewCfvo(int i5);

    CTColor insertNewColor(int i5);

    void removeCfvo(int i5);

    void removeColor(int i5);

    void setCfvoArray(int i5, CTCfvo cTCfvo);

    void setCfvoArray(CTCfvo[] cTCfvoArr);

    void setColorArray(int i5, CTColor cTColor);

    void setColorArray(CTColor[] cTColorArr);

    int sizeOfCfvoArray();

    int sizeOfColorArray();
}
