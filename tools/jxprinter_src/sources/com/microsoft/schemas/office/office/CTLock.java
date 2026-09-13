package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import org.apache.poi.schemas.ooxml.system.ooxml.TypeSystemHolder;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.openxmlformats.schemas.officeDocument.x2006.sharedTypes.STTrueFalse;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface CTLock extends XmlObject {
    public static final DocumentFactory<CTLock> Factory;
    public static final SchemaType type;

    static {
        DocumentFactory<CTLock> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "ctlock6b8etype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    STTrueFalse.Enum getAdjusthandles();

    STTrueFalse.Enum getAspectratio();

    STTrueFalse.Enum getCropping();

    STExt.Enum getExt();

    STTrueFalse.Enum getGrouping();

    STTrueFalse.Enum getPosition();

    STTrueFalse.Enum getRotation();

    STTrueFalse.Enum getSelection();

    STTrueFalse.Enum getShapetype();

    STTrueFalse.Enum getText();

    STTrueFalse.Enum getUngrouping();

    STTrueFalse.Enum getVerticies();

    boolean isSetAdjusthandles();

    boolean isSetAspectratio();

    boolean isSetCropping();

    boolean isSetExt();

    boolean isSetGrouping();

    boolean isSetPosition();

    boolean isSetRotation();

    boolean isSetSelection();

    boolean isSetShapetype();

    boolean isSetText();

    boolean isSetUngrouping();

    boolean isSetVerticies();

    void setAdjusthandles(STTrueFalse.Enum r6);

    void setAspectratio(STTrueFalse.Enum r6);

    void setCropping(STTrueFalse.Enum r6);

    void setExt(STExt.Enum r6);

    void setGrouping(STTrueFalse.Enum r6);

    void setPosition(STTrueFalse.Enum r6);

    void setRotation(STTrueFalse.Enum r6);

    void setSelection(STTrueFalse.Enum r6);

    void setShapetype(STTrueFalse.Enum r6);

    void setText(STTrueFalse.Enum r6);

    void setUngrouping(STTrueFalse.Enum r6);

    void setVerticies(STTrueFalse.Enum r6);

    void unsetAdjusthandles();

    void unsetAspectratio();

    void unsetCropping();

    void unsetExt();

    void unsetGrouping();

    void unsetPosition();

    void unsetRotation();

    void unsetSelection();

    void unsetShapetype();

    void unsetText();

    void unsetUngrouping();

    void unsetVerticies();

    STTrueFalse xgetAdjusthandles();

    STTrueFalse xgetAspectratio();

    STTrueFalse xgetCropping();

    STExt xgetExt();

    STTrueFalse xgetGrouping();

    STTrueFalse xgetPosition();

    STTrueFalse xgetRotation();

    STTrueFalse xgetSelection();

    STTrueFalse xgetShapetype();

    STTrueFalse xgetText();

    STTrueFalse xgetUngrouping();

    STTrueFalse xgetVerticies();

    void xsetAdjusthandles(STTrueFalse sTTrueFalse);

    void xsetAspectratio(STTrueFalse sTTrueFalse);

    void xsetCropping(STTrueFalse sTTrueFalse);

    void xsetExt(STExt sTExt);

    void xsetGrouping(STTrueFalse sTTrueFalse);

    void xsetPosition(STTrueFalse sTTrueFalse);

    void xsetRotation(STTrueFalse sTTrueFalse);

    void xsetSelection(STTrueFalse sTTrueFalse);

    void xsetShapetype(STTrueFalse sTTrueFalse);

    void xsetText(STTrueFalse sTTrueFalse);

    void xsetUngrouping(STTrueFalse sTTrueFalse);

    void xsetVerticies(STTrueFalse sTTrueFalse);
}
