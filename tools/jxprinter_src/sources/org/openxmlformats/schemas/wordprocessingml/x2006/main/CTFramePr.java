package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.math.BigInteger;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STOnOff;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTwipsMeasure;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STXAlign;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STYAlign;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTFramePr extends XmlObject {
    public static final DocumentFactory<CTFramePr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTFramePr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctframepr12a3type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Object getAnchorLock();

    STDropCap$Enum getDropCap();

    Object getH();

    STHAnchor.Enum getHAnchor();

    STHeightRule.Enum getHRule();

    Object getHSpace();

    BigInteger getLines();

    STVAnchor.Enum getVAnchor();

    Object getVSpace();

    Object getW();

    STWrap.Enum getWrap();

    Object getX();

    STXAlign.Enum getXAlign();

    Object getY();

    STYAlign.Enum getYAlign();

    boolean isSetAnchorLock();

    boolean isSetDropCap();

    boolean isSetH();

    boolean isSetHAnchor();

    boolean isSetHRule();

    boolean isSetHSpace();

    boolean isSetLines();

    boolean isSetVAnchor();

    boolean isSetVSpace();

    boolean isSetW();

    boolean isSetWrap();

    boolean isSetX();

    boolean isSetXAlign();

    boolean isSetY();

    boolean isSetYAlign();

    void setAnchorLock(Object obj);

    void setDropCap(STDropCap$Enum sTDropCap$Enum);

    void setH(Object obj);

    void setHAnchor(STHAnchor.Enum r6);

    void setHRule(STHeightRule.Enum r6);

    void setHSpace(Object obj);

    void setLines(BigInteger bigInteger);

    void setVAnchor(STVAnchor.Enum r6);

    void setVSpace(Object obj);

    void setW(Object obj);

    void setWrap(STWrap.Enum r6);

    void setX(Object obj);

    void setXAlign(STXAlign.Enum r6);

    void setY(Object obj);

    void setYAlign(STYAlign.Enum r6);

    void unsetAnchorLock();

    void unsetDropCap();

    void unsetH();

    void unsetHAnchor();

    void unsetHRule();

    void unsetHSpace();

    void unsetLines();

    void unsetVAnchor();

    void unsetVSpace();

    void unsetW();

    void unsetWrap();

    void unsetX();

    void unsetXAlign();

    void unsetY();

    void unsetYAlign();

    STOnOff xgetAnchorLock();

    STDropCap xgetDropCap();

    STTwipsMeasure xgetH();

    STHAnchor xgetHAnchor();

    STHeightRule xgetHRule();

    STTwipsMeasure xgetHSpace();

    STDecimalNumber xgetLines();

    STVAnchor xgetVAnchor();

    STTwipsMeasure xgetVSpace();

    STTwipsMeasure xgetW();

    STWrap xgetWrap();

    STSignedTwipsMeasure xgetX();

    STXAlign xgetXAlign();

    STSignedTwipsMeasure xgetY();

    STYAlign xgetYAlign();

    void xsetAnchorLock(STOnOff sTOnOff);

    void xsetDropCap(STDropCap sTDropCap);

    void xsetH(STTwipsMeasure sTTwipsMeasure);

    void xsetHAnchor(STHAnchor sTHAnchor);

    void xsetHRule(STHeightRule sTHeightRule);

    void xsetHSpace(STTwipsMeasure sTTwipsMeasure);

    void xsetLines(STDecimalNumber sTDecimalNumber);

    void xsetVAnchor(STVAnchor sTVAnchor);

    void xsetVSpace(STTwipsMeasure sTTwipsMeasure);

    void xsetW(STTwipsMeasure sTTwipsMeasure);

    void xsetWrap(STWrap sTWrap);

    void xsetX(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetXAlign(STXAlign sTXAlign);

    void xsetY(STSignedTwipsMeasure sTSignedTwipsMeasure);

    void xsetYAlign(STYAlign sTYAlign);
}
