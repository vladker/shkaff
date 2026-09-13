package org.apache.poi.hssf.usermodel;

import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherProperty;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.usermodel.Shape;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class HSSFShape implements Shape {
    public static final int FILL__FILLCOLOR_DEFAULT = 134217737;
    public static final int LINESTYLE_DASHDOTDOTSYS = 4;
    public static final int LINESTYLE_DASHDOTGEL = 8;
    public static final int LINESTYLE_DASHDOTSYS = 3;
    public static final int LINESTYLE_DASHGEL = 6;
    public static final int LINESTYLE_DASHSYS = 1;
    public static final int LINESTYLE_DEFAULT = -1;
    public static final int LINESTYLE_DOTGEL = 5;
    public static final int LINESTYLE_DOTSYS = 2;
    public static final int LINESTYLE_LONGDASHDOTDOTGEL = 10;
    public static final int LINESTYLE_LONGDASHDOTGEL = 9;
    public static final int LINESTYLE_LONGDASHGEL = 7;
    public static final int LINESTYLE_NONE = -1;
    public static final int LINESTYLE_SOLID = 0;
    public static final int LINESTYLE__COLOR_DEFAULT = 134217792;
    public static final int LINEWIDTH_DEFAULT = 9525;
    public static final int LINEWIDTH_ONE_PT = 12700;
    public static final int NO_FILLHITTEST_FALSE = 65536;
    public static final int NO_FILLHITTEST_TRUE = 1114112;
    public static final boolean NO_FILL_DEFAULT = true;
    private final EscherContainerRecord _escherContainer;
    private final ObjRecord _objRecord;
    private final EscherOptRecord _optRecord;
    private HSSFPatriarch _patriarch;
    HSSFAnchor anchor;
    private HSSFShape parent;

    public HSSFShape(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        this._escherContainer = escherContainerRecord;
        this._objRecord = objRecord;
        this._optRecord = (EscherOptRecord) escherContainerRecord.getChildById(EscherOptRecord.RECORD_ID);
        this.anchor = HSSFAnchor.createAnchorFromEscher(escherContainerRecord);
    }

    public abstract void afterInsert(HSSFPatriarch hSSFPatriarch);

    public abstract void afterRemove(HSSFPatriarch hSSFPatriarch);

    public abstract HSSFShape cloneShape();

    public int countOfAllChildren() {
        return 1;
    }

    public abstract ObjRecord createObjRecord();

    public abstract EscherContainerRecord createSpContainer();

    public EscherContainerRecord getEscherContainer() {
        return this._escherContainer;
    }

    public int getFillColor() {
        EscherRGBProperty escherRGBProperty = (EscherRGBProperty) this._optRecord.lookup(EscherPropertyTypes.FILL__FILLCOLOR);
        return escherRGBProperty == null ? FILL__FILLCOLOR_DEFAULT : escherRGBProperty.getRgbColor();
    }

    public int getLineStyle() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) this._optRecord.lookup(EscherPropertyTypes.LINESTYLE__LINEDASHING);
        if (escherSimpleProperty == null) {
            return -1;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public int getLineStyleColor() {
        EscherRGBProperty escherRGBProperty = (EscherRGBProperty) this._optRecord.lookup(EscherPropertyTypes.LINESTYLE__COLOR);
        return escherRGBProperty == null ? LINESTYLE__COLOR_DEFAULT : escherRGBProperty.getRgbColor();
    }

    public int getLineWidth() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) this._optRecord.lookup(EscherPropertyTypes.LINESTYLE__LINEWIDTH);
        if (escherSimpleProperty == null) {
            return 9525;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public ObjRecord getObjRecord() {
        return this._objRecord;
    }

    public EscherOptRecord getOptRecord() {
        return this._optRecord;
    }

    public HSSFPatriarch getPatriarch() {
        return this._patriarch;
    }

    public int getRotationDegree() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(EscherPropertyTypes.TRANSFORM__ROTATION);
        if (escherSimpleProperty == null) {
            return 0;
        }
        byte[] bArr = new byte[4];
        LittleEndian.putInt(bArr, 0, escherSimpleProperty.getPropertyValue());
        return LittleEndian.getShort(bArr, 2);
    }

    public int getShapeId() {
        return ((EscherSpRecord) this._escherContainer.getChildById(EscherSpRecord.RECORD_ID)).getShapeId();
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public String getShapeName() {
        EscherOptRecord optRecord = getOptRecord();
        if (optRecord == null) {
            return null;
        }
        EscherProperty escherPropertyLookup = optRecord.lookup(EscherPropertyTypes.GROUPSHAPE__SHAPENAME);
        if (escherPropertyLookup instanceof EscherComplexProperty) {
            return StringUtil.getFromUnicodeLE(((EscherComplexProperty) escherPropertyLookup).getComplexData());
        }
        return null;
    }

    public boolean isFlipHorizontal() {
        return (((EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID)).getFlags() & 64) != 0;
    }

    public boolean isFlipVertical() {
        return (((EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID)).getFlags() & 128) != 0;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public boolean isNoFill() {
        EscherBoolProperty escherBoolProperty = (EscherBoolProperty) this._optRecord.lookup(EscherPropertyTypes.FILL__NOFILLHITTEST);
        return escherBoolProperty == null || escherBoolProperty.getPropertyValue() == 1114112;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x009a  */
    public void setAnchor(HSSFAnchor hSSFAnchor) {
        short recordId;
        int i5 = 0;
        if (this.parent == null) {
            if (hSSFAnchor instanceof HSSFChildAnchor) {
                throw new IllegalArgumentException("Must use client anchors for shapes directly attached to sheet.");
            }
            EscherClientAnchorRecord escherClientAnchorRecord = (EscherClientAnchorRecord) this._escherContainer.getChildById(EscherClientAnchorRecord.RECORD_ID);
            if (escherClientAnchorRecord != null) {
                recordId = -1;
                while (i5 < this._escherContainer.getChildCount()) {
                    if (this._escherContainer.getChild(i5).getRecordId() == EscherClientAnchorRecord.RECORD_ID && i5 != this._escherContainer.getChildCount() - 1) {
                        recordId = this._escherContainer.getChild(i5 + 1).getRecordId();
                    }
                    i5++;
                }
                this._escherContainer.removeChildRecord(escherClientAnchorRecord);
            } else {
                recordId = -1;
            }
        } else {
            if (hSSFAnchor instanceof HSSFClientAnchor) {
                throw new IllegalArgumentException("Must use child anchors for shapes attached to groups.");
            }
            EscherChildAnchorRecord escherChildAnchorRecord = (EscherChildAnchorRecord) this._escherContainer.getChildById(EscherChildAnchorRecord.RECORD_ID);
            if (escherChildAnchorRecord != null) {
                recordId = -1;
                while (i5 < this._escherContainer.getChildCount()) {
                    if (this._escherContainer.getChild(i5).getRecordId() == EscherChildAnchorRecord.RECORD_ID && i5 != this._escherContainer.getChildCount() - 1) {
                        recordId = this._escherContainer.getChild(i5 + 1).getRecordId();
                    }
                    i5++;
                }
                this._escherContainer.removeChildRecord(escherChildAnchorRecord);
            } else {
                recordId = -1;
            }
        }
        if (-1 == recordId) {
            this._escherContainer.addChildRecord(hSSFAnchor.getEscherAnchor());
        } else {
            this._escherContainer.addChildBefore(hSSFAnchor.getEscherAnchor(), recordId);
        }
        this.anchor = hSSFAnchor;
    }

    public void setFillColor(int i5) {
        setPropertyValue(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLCOLOR, i5));
    }

    public void setFlipHorizontal(boolean z6) {
        EscherSpRecord escherSpRecord = (EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (z6) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        } else {
            escherSpRecord.setFlags(escherSpRecord.getFlags() & 2147483583);
        }
    }

    public void setFlipVertical(boolean z6) {
        EscherSpRecord escherSpRecord = (EscherSpRecord) getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (z6) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        } else {
            escherSpRecord.setFlags(escherSpRecord.getFlags() & 2147483519);
        }
    }

    public void setLineStyle(int i5) {
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEDASHING, i5));
        if (getLineStyle() != 0) {
            setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEENDCAPSTYLE, 0));
            if (getLineStyle() == -1) {
                setPropertyValue(new EscherBoolProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524288));
            } else {
                setPropertyValue(new EscherBoolProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524296));
            }
        }
    }

    public void setLineStyleColor(int i5) {
        setPropertyValue(new EscherRGBProperty(EscherPropertyTypes.LINESTYLE__COLOR, i5));
    }

    public void setLineWidth(int i5) {
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEWIDTH, i5));
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setNoFill(boolean z6) {
        setPropertyValue(new EscherBoolProperty(EscherPropertyTypes.FILL__NOFILLHITTEST, z6 ? NO_FILLHITTEST_TRUE : 65536));
    }

    public void setParent(HSSFShape hSSFShape) {
        this.parent = hSSFShape;
    }

    public void setPatriarch(HSSFPatriarch hSSFPatriarch) {
        this._patriarch = hSSFPatriarch;
    }

    public void setPropertyValue(EscherProperty escherProperty) {
        this._optRecord.setEscherProperty(escherProperty);
    }

    public void setRotationDegree(short s6) {
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.TRANSFORM__ROTATION, s6 << 16));
    }

    public void setShapeId(int i5) {
        ((EscherSpRecord) this._escherContainer.getChildById(EscherSpRecord.RECORD_ID)).setShapeId(i5);
        ((CommonObjectDataSubRecord) this._objRecord.getSubRecords().get(0)).setObjectId((short) (i5 % 1024));
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public HSSFAnchor getAnchor() {
        return this.anchor;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public HSSFShape getParent() {
        return this.parent;
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setFillColor(int i5, int i6, int i7) {
        setPropertyValue(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLCOLOR, i5 | (i6 << 8) | (i7 << 16)));
    }

    @Override // org.apache.poi.ss.usermodel.Shape
    public void setLineStyleColor(int i5, int i6, int i7) {
        setPropertyValue(new EscherRGBProperty(EscherPropertyTypes.LINESTYLE__COLOR, i5 | (i6 << 8) | (i7 << 16)));
    }

    public HSSFShape(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        this.parent = hSSFShape;
        this.anchor = hSSFAnchor;
        EscherContainerRecord escherContainerRecordCreateSpContainer = createSpContainer();
        this._escherContainer = escherContainerRecordCreateSpContainer;
        this._optRecord = (EscherOptRecord) escherContainerRecordCreateSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        this._objRecord = createObjRecord();
    }
}
