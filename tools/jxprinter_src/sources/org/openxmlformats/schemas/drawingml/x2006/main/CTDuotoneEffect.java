package org.openxmlformats.schemas.drawingml.x2006.main;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTDuotoneEffect extends XmlObject {
    public static final DocumentFactory<CTDuotoneEffect> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTDuotoneEffect> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctduotoneeffectae52type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTHslColor addNewHslClr();

    CTPresetColor addNewPrstClr();

    CTSchemeColor addNewSchemeClr();

    CTScRgbColor addNewScrgbClr();

    CTSRgbColor addNewSrgbClr();

    CTSystemColor addNewSysClr();

    CTHslColor getHslClrArray(int i5);

    CTHslColor[] getHslClrArray();

    List<CTHslColor> getHslClrList();

    CTPresetColor getPrstClrArray(int i5);

    CTPresetColor[] getPrstClrArray();

    List<CTPresetColor> getPrstClrList();

    CTSchemeColor getSchemeClrArray(int i5);

    CTSchemeColor[] getSchemeClrArray();

    List<CTSchemeColor> getSchemeClrList();

    CTScRgbColor getScrgbClrArray(int i5);

    CTScRgbColor[] getScrgbClrArray();

    List<CTScRgbColor> getScrgbClrList();

    CTSRgbColor getSrgbClrArray(int i5);

    CTSRgbColor[] getSrgbClrArray();

    List<CTSRgbColor> getSrgbClrList();

    CTSystemColor getSysClrArray(int i5);

    CTSystemColor[] getSysClrArray();

    List<CTSystemColor> getSysClrList();

    CTHslColor insertNewHslClr(int i5);

    CTPresetColor insertNewPrstClr(int i5);

    CTSchemeColor insertNewSchemeClr(int i5);

    CTScRgbColor insertNewScrgbClr(int i5);

    CTSRgbColor insertNewSrgbClr(int i5);

    CTSystemColor insertNewSysClr(int i5);

    void removeHslClr(int i5);

    void removePrstClr(int i5);

    void removeSchemeClr(int i5);

    void removeScrgbClr(int i5);

    void removeSrgbClr(int i5);

    void removeSysClr(int i5);

    void setHslClrArray(int i5, CTHslColor cTHslColor);

    void setHslClrArray(CTHslColor[] cTHslColorArr);

    void setPrstClrArray(int i5, CTPresetColor cTPresetColor);

    void setPrstClrArray(CTPresetColor[] cTPresetColorArr);

    void setSchemeClrArray(int i5, CTSchemeColor cTSchemeColor);

    void setSchemeClrArray(CTSchemeColor[] cTSchemeColorArr);

    void setScrgbClrArray(int i5, CTScRgbColor cTScRgbColor);

    void setScrgbClrArray(CTScRgbColor[] cTScRgbColorArr);

    void setSrgbClrArray(int i5, CTSRgbColor cTSRgbColor);

    void setSrgbClrArray(CTSRgbColor[] cTSRgbColorArr);

    void setSysClrArray(int i5, CTSystemColor cTSystemColor);

    void setSysClrArray(CTSystemColor[] cTSystemColorArr);

    int sizeOfHslClrArray();

    int sizeOfPrstClrArray();

    int sizeOfSchemeClrArray();

    int sizeOfScrgbClrArray();

    int sizeOfSrgbClrArray();

    int sizeOfSysClrArray();
}
