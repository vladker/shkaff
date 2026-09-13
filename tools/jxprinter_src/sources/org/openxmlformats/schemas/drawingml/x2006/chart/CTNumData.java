package org.openxmlformats.schemas.drawingml.x2006.chart;

import java.util.List;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXstring;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface CTNumData extends XmlObject {
    public static final DocumentFactory<CTNumData> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTNumData> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctnumdata4f16type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    CTExtensionList addNewExtLst();

    CTNumVal addNewPt();

    CTUnsignedInt addNewPtCount();

    CTExtensionList getExtLst();

    String getFormatCode();

    CTNumVal getPtArray(int i5);

    CTNumVal[] getPtArray();

    CTUnsignedInt getPtCount();

    List<CTNumVal> getPtList();

    CTNumVal insertNewPt(int i5);

    boolean isSetExtLst();

    boolean isSetFormatCode();

    boolean isSetPtCount();

    void removePt(int i5);

    void setExtLst(CTExtensionList cTExtensionList);

    void setFormatCode(String str);

    void setPtArray(int i5, CTNumVal cTNumVal);

    void setPtArray(CTNumVal[] cTNumValArr);

    void setPtCount(CTUnsignedInt cTUnsignedInt);

    int sizeOfPtArray();

    void unsetExtLst();

    void unsetFormatCode();

    void unsetPtCount();

    STXstring xgetFormatCode();

    void xsetFormatCode(STXstring sTXstring);
}
