package org.apache.poi.hssf.usermodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherChildAnchorRecord;
import org.apache.poi.ddf.EscherClientAnchorRecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.ddf.EscherSpgrRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.GroupMarkerSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.util.IEEEDouble;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFShapeGroup extends HSSFShape implements HSSFShapeContainer {
    private final EscherSpgrRecord _spgrRecord;
    private final List<HSSFShape> shapes;

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFShapeGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes;

        static {
            int[] iArr = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = iArr;
            try {
                iArr[EscherRecordTypes.CLIENT_ANCHOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.CHILD_ANCHOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.SPGR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HSSFShapeGroup(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
        this.shapes = new ArrayList();
        EscherContainerRecord escherContainerRecord2 = escherContainerRecord.getChildContainers().get(0);
        this._spgrRecord = (EscherSpgrRecord) escherContainerRecord2.getChild(0);
        for (EscherRecord escherRecord : escherContainerRecord2) {
            int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(escherRecord.getRecordId()).ordinal()];
            if (i5 == 1) {
                this.anchor = new HSSFClientAnchor((EscherClientAnchorRecord) escherRecord);
            } else if (i5 == 2) {
                this.anchor = new HSSFChildAnchor((EscherChildAnchorRecord) escherRecord);
            }
        }
    }

    private void onCreate(HSSFShape hSSFShape) {
        if (getPatriarch() != null) {
            EscherContainerRecord escherContainer = hSSFShape.getEscherContainer();
            hSSFShape.setShapeId(getPatriarch().newShapeId());
            getEscherContainer().addChildRecord(escherContainer);
            hSSFShape.afterInsert(getPatriarch());
            EscherSpRecord escherSpRecord = hSSFShape instanceof HSSFShapeGroup ? (EscherSpRecord) hSSFShape.getEscherContainer().getChildContainers().get(0).getChildById(EscherSpRecord.RECORD_ID) : (EscherSpRecord) hSSFShape.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 2);
        }
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void addShape(HSSFShape hSSFShape) {
        hSSFShape.setPatriarch(getPatriarch());
        hSSFShape.setParent(this);
        this.shapes.add(hSSFShape);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public void afterInsert(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().associateShapeToObjRecord(((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public void afterRemove(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildContainers().get(0).getChildById(EscherClientDataRecord.RECORD_ID));
        EscherContainerRecord escherContainer = getEscherContainer();
        HSSFPatriarch patriarch = getPatriarch();
        for (HSSFShape hSSFShape : this.shapes) {
            if (escherContainer.removeChildRecord(hSSFShape.getEscherContainer())) {
                hSSFShape.afterRemove(patriarch);
            }
        }
        this.shapes.clear();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void clear() {
        ArrayList arrayList = new ArrayList(this.shapes);
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            removeShape((HSSFShape) obj);
        }
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public HSSFShape cloneShape() {
        throw new IllegalStateException("Use method cloneShape(HSSFPatriarch patriarch)");
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public int countOfAllChildren() {
        int size = this.shapes.size();
        Iterator<HSSFShape> it = this.shapes.iterator();
        while (it.hasNext()) {
            size += it.next().countOfAllChildren();
        }
        return size;
    }

    public HSSFShapeGroup createGroup(HSSFChildAnchor hSSFChildAnchor) {
        HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(this, hSSFChildAnchor);
        hSSFShapeGroup.setParent(this);
        hSSFShapeGroup.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFShapeGroup);
        onCreate(hSSFShapeGroup);
        return hSSFShapeGroup;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 0);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(true);
        GroupMarkerSubRecord groupMarkerSubRecord = new GroupMarkerSubRecord();
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(groupMarkerSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    public HSSFPicture createPicture(HSSFChildAnchor hSSFChildAnchor, int i5) {
        HSSFPicture hSSFPicture = new HSSFPicture(this, hSSFChildAnchor);
        hSSFPicture.setParent(this);
        hSSFPicture.setAnchor(hSSFChildAnchor);
        hSSFPicture.setPictureIndex(i5);
        this.shapes.add(hSSFPicture);
        onCreate(hSSFPicture);
        EscherSpRecord escherSpRecord = (EscherSpRecord) hSSFPicture.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFPicture.getAnchor().isHorizontallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        }
        if (hSSFPicture.getAnchor().isVerticallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        }
        return hSSFPicture;
    }

    public HSSFPolygon createPolygon(HSSFChildAnchor hSSFChildAnchor) {
        HSSFPolygon hSSFPolygon = new HSSFPolygon(this, hSSFChildAnchor);
        hSSFPolygon.setParent(this);
        hSSFPolygon.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFPolygon);
        onCreate(hSSFPolygon);
        return hSSFPolygon;
    }

    public HSSFSimpleShape createShape(HSSFChildAnchor hSSFChildAnchor) {
        HSSFSimpleShape hSSFSimpleShape = new HSSFSimpleShape(this, hSSFChildAnchor);
        hSSFSimpleShape.setParent(this);
        hSSFSimpleShape.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFSimpleShape);
        onCreate(hSSFSimpleShape);
        EscherSpRecord escherSpRecord = (EscherSpRecord) hSSFSimpleShape.getEscherContainer().getChildById(EscherSpRecord.RECORD_ID);
        if (hSSFSimpleShape.getAnchor().isHorizontallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 64);
        }
        if (hSSFSimpleShape.getAnchor().isVerticallyFlipped()) {
            escherSpRecord.setFlags(escherSpRecord.getFlags() | 128);
        }
        return hSSFSimpleShape;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        EscherSpgrRecord escherSpgrRecord = new EscherSpgrRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherContainerRecord2.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord2.setOptions((short) 15);
        escherSpgrRecord.setRecordId(EscherSpgrRecord.RECORD_ID);
        escherSpgrRecord.setOptions((short) 1);
        escherSpgrRecord.setRectX1(0);
        escherSpgrRecord.setRectY1(0);
        escherSpgrRecord.setRectX2(IEEEDouble.EXPONENT_BIAS);
        escherSpgrRecord.setRectY2(255);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) 2);
        if (getAnchor() instanceof HSSFClientAnchor) {
            escherSpRecord.setFlags(513);
        } else {
            escherSpRecord.setFlags(Videoio.CAP_PROP_XI_LENS_FOCUS_DISTANCE);
        }
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.setOptions((short) 35);
        escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherPropertyTypes.PROTECTION__LOCKAGAINSTGROUPING, 262148));
        escherOptRecord.addEscherProperty(new EscherBoolProperty(EscherPropertyTypes.GROUPSHAPE__FLAGS, 524288));
        EscherRecord escherAnchor = getAnchor().getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        escherContainerRecord2.addChildRecord(escherSpgrRecord);
        escherContainerRecord2.addChildRecord(escherSpRecord);
        escherContainerRecord2.addChildRecord(escherOptRecord);
        escherContainerRecord2.addChildRecord(escherAnchor);
        escherContainerRecord2.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    public HSSFTextbox createTextbox(HSSFChildAnchor hSSFChildAnchor) {
        HSSFTextbox hSSFTextbox = new HSSFTextbox(this, hSSFChildAnchor);
        hSSFTextbox.setParent(this);
        hSSFTextbox.setAnchor(hSSFChildAnchor);
        this.shapes.add(hSSFTextbox);
        onCreate(hSSFTextbox);
        return hSSFTextbox;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public List<HSSFShape> getChildren() {
        return Collections.unmodifiableList(this.shapes);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public int getShapeId() {
        return ((EscherSpRecord) ((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherSpRecord.RECORD_ID)).getShapeId();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getX1() {
        return this._spgrRecord.getRectX1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getX2() {
        return this._spgrRecord.getRectX2();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getY1() {
        return this._spgrRecord.getRectY1();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public int getY2() {
        return this._spgrRecord.getRectY2();
    }

    @Override // java.lang.Iterable
    public Iterator<HSSFShape> iterator() {
        return this.shapes.iterator();
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public boolean removeShape(HSSFShape hSSFShape) {
        boolean zRemoveChildRecord = getEscherContainer().removeChildRecord(hSSFShape.getEscherContainer());
        if (zRemoveChildRecord) {
            hSSFShape.afterRemove(getPatriarch());
            this.shapes.remove(hSSFShape);
        }
        return zRemoveChildRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShapeContainer
    public void setCoordinates(int i5, int i6, int i7, int i8) {
        this._spgrRecord.setRectX1(i5);
        this._spgrRecord.setRectX2(i7);
        this._spgrRecord.setRectY1(i6);
        this._spgrRecord.setRectY2(i8);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFShape
    public void setShapeId(int i5) {
        ((EscherSpRecord) ((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).getChildById(EscherSpRecord.RECORD_ID)).setShapeId(i5);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectId((short) (i5 % 1024));
    }

    @Override // java.lang.Iterable
    public Spliterator<HSSFShape> spliterator() {
        return this.shapes.spliterator();
    }

    public HSSFShape cloneShape(HSSFPatriarch hSSFPatriarch) {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SPGR_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        EscherContainerRecord escherContainerRecord2 = new EscherContainerRecord();
        escherContainerRecord2.fillFields(((EscherContainerRecord) getEscherContainer().getChildById(EscherContainerRecord.SP_CONTAINER)).serialize(), 0, new DefaultEscherRecordFactory());
        escherContainerRecord.addChildRecord(escherContainerRecord2);
        HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord, getObjRecord() != null ? (ObjRecord) getObjRecord().cloneViaReserialise() : null);
        hSSFShapeGroup.setPatriarch(hSSFPatriarch);
        for (HSSFShape hSSFShape : getChildren()) {
            HSSFShape hSSFShapeCloneShape = hSSFShape instanceof HSSFShapeGroup ? ((HSSFShapeGroup) hSSFShape).cloneShape(hSSFPatriarch) : hSSFShape.cloneShape();
            hSSFShapeGroup.addShape(hSSFShapeCloneShape);
            hSSFShapeGroup.onCreate(hSSFShapeCloneShape);
        }
        return hSSFShapeGroup;
    }

    public HSSFShapeGroup(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        this.shapes = new ArrayList();
        this._spgrRecord = (EscherSpgrRecord) ((EscherContainerRecord) getEscherContainer().getChild(0)).getChildById(EscherSpgrRecord.RECORD_ID);
    }
}
