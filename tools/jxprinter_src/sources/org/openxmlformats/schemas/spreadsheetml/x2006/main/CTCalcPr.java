package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.schema.DocumentFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public interface CTCalcPr extends XmlObject {
    public static final DocumentFactory<CTCalcPr> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTCalcPr> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctcalcprd480type");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    boolean getCalcCompleted();

    long getCalcId();

    STCalcMode.Enum getCalcMode();

    boolean getCalcOnSave();

    boolean getConcurrentCalc();

    long getConcurrentManualCount();

    boolean getForceFullCalc();

    boolean getFullCalcOnLoad();

    boolean getFullPrecision();

    boolean getIterate();

    long getIterateCount();

    double getIterateDelta();

    STRefMode.Enum getRefMode();

    boolean isSetCalcCompleted();

    boolean isSetCalcId();

    boolean isSetCalcMode();

    boolean isSetCalcOnSave();

    boolean isSetConcurrentCalc();

    boolean isSetConcurrentManualCount();

    boolean isSetForceFullCalc();

    boolean isSetFullCalcOnLoad();

    boolean isSetFullPrecision();

    boolean isSetIterate();

    boolean isSetIterateCount();

    boolean isSetIterateDelta();

    boolean isSetRefMode();

    void setCalcCompleted(boolean z6);

    void setCalcId(long j6);

    void setCalcMode(STCalcMode.Enum r6);

    void setCalcOnSave(boolean z6);

    void setConcurrentCalc(boolean z6);

    void setConcurrentManualCount(long j6);

    void setForceFullCalc(boolean z6);

    void setFullCalcOnLoad(boolean z6);

    void setFullPrecision(boolean z6);

    void setIterate(boolean z6);

    void setIterateCount(long j6);

    void setIterateDelta(double d);

    void setRefMode(STRefMode.Enum r6);

    void unsetCalcCompleted();

    void unsetCalcId();

    void unsetCalcMode();

    void unsetCalcOnSave();

    void unsetConcurrentCalc();

    void unsetConcurrentManualCount();

    void unsetForceFullCalc();

    void unsetFullCalcOnLoad();

    void unsetFullPrecision();

    void unsetIterate();

    void unsetIterateCount();

    void unsetIterateDelta();

    void unsetRefMode();

    XmlBoolean xgetCalcCompleted();

    XmlUnsignedInt xgetCalcId();

    STCalcMode xgetCalcMode();

    XmlBoolean xgetCalcOnSave();

    XmlBoolean xgetConcurrentCalc();

    XmlUnsignedInt xgetConcurrentManualCount();

    XmlBoolean xgetForceFullCalc();

    XmlBoolean xgetFullCalcOnLoad();

    XmlBoolean xgetFullPrecision();

    XmlBoolean xgetIterate();

    XmlUnsignedInt xgetIterateCount();

    XmlDouble xgetIterateDelta();

    STRefMode xgetRefMode();

    void xsetCalcCompleted(XmlBoolean xmlBoolean);

    void xsetCalcId(XmlUnsignedInt xmlUnsignedInt);

    void xsetCalcMode(STCalcMode sTCalcMode);

    void xsetCalcOnSave(XmlBoolean xmlBoolean);

    void xsetConcurrentCalc(XmlBoolean xmlBoolean);

    void xsetConcurrentManualCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetForceFullCalc(XmlBoolean xmlBoolean);

    void xsetFullCalcOnLoad(XmlBoolean xmlBoolean);

    void xsetFullPrecision(XmlBoolean xmlBoolean);

    void xsetIterate(XmlBoolean xmlBoolean);

    void xsetIterateCount(XmlUnsignedInt xmlUnsignedInt);

    void xsetIterateDelta(XmlDouble xmlDouble);

    void xsetRefMode(STRefMode sTRefMode);
}
