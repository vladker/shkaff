package org.apache.poi.hssf.usermodel;

import com.google.common.primitives.UnsignedBytes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ddf.EscherArrayProperty;
import org.apache.poi.ddf.EscherBoolProperty;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRGBProperty;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherShapePathProperty;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherSpRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EndSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.sl.usermodel.ShapeType;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFPolygon extends HSSFSimpleShape {
    private static final Logger LOG = LogManager.getLogger((Class<?>) HSSFPolygon.class);
    public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;

    public HSSFPolygon(EscherContainerRecord escherContainerRecord, ObjRecord objRecord, TextObjectRecord textObjectRecord) {
        super(escherContainerRecord, objRecord, textObjectRecord);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public void afterRemove(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().removeShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public ObjRecord createObjRecord() {
        ObjRecord objRecord = new ObjRecord();
        CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
        commonObjectDataSubRecord.setObjectType((short) 30);
        commonObjectDataSubRecord.setLocked(true);
        commonObjectDataSubRecord.setPrintable(true);
        commonObjectDataSubRecord.setAutofill(true);
        commonObjectDataSubRecord.setAutoline(true);
        EndSubRecord endSubRecord = new EndSubRecord();
        objRecord.addSubRecord(commonObjectDataSubRecord);
        objRecord.addSubRecord(endSubRecord);
        return objRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        EscherSpRecord escherSpRecord = new EscherSpRecord();
        EscherOptRecord escherOptRecord = new EscherOptRecord();
        EscherClientDataRecord escherClientDataRecord = new EscherClientDataRecord();
        escherContainerRecord.setRecordId(EscherContainerRecord.SP_CONTAINER);
        escherContainerRecord.setOptions((short) 15);
        escherSpRecord.setRecordId(EscherSpRecord.RECORD_ID);
        escherSpRecord.setOptions((short) ((ShapeType.NOT_PRIMITIVE.nativeId << 4) | 2));
        if (getParent() == null) {
            escherSpRecord.setFlags(2560);
        } else {
            escherSpRecord.setFlags(2562);
        }
        escherOptRecord.setRecordId(EscherOptRecord.RECORD_ID);
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.TRANSFORM__ROTATION, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.GEOMETRY__RIGHT, false, false, 100));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.GEOMETRY__BOTTOM, false, false, 100));
        escherOptRecord.setEscherProperty(new EscherShapePathProperty(EscherPropertyTypes.GEOMETRY__SHAPEPATH, 4));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.GEOMETRY__FILLOK, false, false, 65537));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINESTARTARROWHEAD, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEENDARROWHEAD, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEENDCAPSTYLE, false, false, 0));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEDASHING, 0));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH, 524296));
        escherOptRecord.setEscherProperty(new EscherSimpleProperty(EscherPropertyTypes.LINESTYLE__LINEWIDTH, 9525));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherPropertyTypes.FILL__FILLCOLOR, HSSFShape.FILL__FILLCOLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherRGBProperty(EscherPropertyTypes.LINESTYLE__COLOR, HSSFShape.LINESTYLE__COLOR_DEFAULT));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherPropertyTypes.FILL__NOFILLHITTEST, 1));
        escherOptRecord.setEscherProperty(new EscherBoolProperty(EscherPropertyTypes.GROUPSHAPE__FLAGS, 524288));
        EscherRecord escherAnchor = getAnchor().getEscherAnchor();
        escherClientDataRecord.setRecordId(EscherClientDataRecord.RECORD_ID);
        escherClientDataRecord.setOptions((short) 0);
        escherContainerRecord.addChildRecord(escherSpRecord);
        escherContainerRecord.addChildRecord(escherOptRecord);
        escherContainerRecord.addChildRecord(escherAnchor);
        escherContainerRecord.addChildRecord(escherClientDataRecord);
        return escherContainerRecord;
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public TextObjectRecord createTextObjRecord() {
        return null;
    }

    public int getDrawAreaHeight() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(EscherPropertyTypes.GEOMETRY__BOTTOM);
        if (escherSimpleProperty == null) {
            return 100;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public int getDrawAreaWidth() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(EscherPropertyTypes.GEOMETRY__RIGHT);
        if (escherSimpleProperty == null) {
            return 100;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    public int[] getXPoints() {
        EscherArrayProperty escherArrayProperty = (EscherArrayProperty) getOptRecord().lookup(EscherPropertyTypes.GEOMETRY__VERTICES);
        if (escherArrayProperty == null) {
            return new int[0];
        }
        int[] iArr = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
        for (int i5 = 0; i5 < escherArrayProperty.getNumberOfElementsInArray() - 1; i5++) {
            iArr[i5] = LittleEndian.getShort(escherArrayProperty.getElement(i5), 0);
        }
        return iArr;
    }

    public int[] getYPoints() {
        EscherArrayProperty escherArrayProperty = (EscherArrayProperty) getOptRecord().lookup(EscherPropertyTypes.GEOMETRY__VERTICES);
        if (escherArrayProperty == null) {
            return new int[0];
        }
        int[] iArr = new int[escherArrayProperty.getNumberOfElementsInArray() - 1];
        for (int i5 = 0; i5 < escherArrayProperty.getNumberOfElementsInArray() - 1; i5++) {
            iArr[i5] = LittleEndian.getShort(escherArrayProperty.getElement(i5), 2);
        }
        return iArr;
    }

    public void setPoints(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            LOG.atError().log("xPoint.length must be equal to yPoints.length");
            return;
        }
        if (iArr.length == 0) {
            LOG.atError().log("HSSFPolygon must have at least one point");
        }
        EscherArrayProperty escherArrayProperty = new EscherArrayProperty(EscherPropertyTypes.GEOMETRY__VERTICES, false, 0);
        escherArrayProperty.setNumberOfElementsInArray(iArr.length + 1);
        escherArrayProperty.setNumberOfElementsInMemory(iArr.length + 1);
        escherArrayProperty.setSizeOfElements(65520);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            byte[] bArr = new byte[4];
            LittleEndian.putShort(bArr, 0, (short) iArr[i5]);
            LittleEndian.putShort(bArr, 2, (short) iArr2[i5]);
            escherArrayProperty.setElement(i5, bArr);
        }
        int length = iArr.length;
        byte[] bArr2 = new byte[4];
        LittleEndian.putShort(bArr2, 0, (short) iArr[0]);
        LittleEndian.putShort(bArr2, 2, (short) iArr2[0]);
        escherArrayProperty.setElement(length, bArr2);
        setPropertyValue(escherArrayProperty);
        EscherArrayProperty escherArrayProperty2 = new EscherArrayProperty(EscherPropertyTypes.GEOMETRY__SEGMENTINFO, false, 0);
        escherArrayProperty2.setSizeOfElements(2);
        escherArrayProperty2.setNumberOfElementsInArray((iArr.length * 2) + 4);
        escherArrayProperty2.setNumberOfElementsInMemory((iArr.length * 2) + 4);
        escherArrayProperty2.setElement(0, new byte[]{0, 64});
        escherArrayProperty2.setElement(1, new byte[]{0, -84});
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = i6 * 2;
            escherArrayProperty2.setElement(i7 + 2, new byte[]{1, 0});
            escherArrayProperty2.setElement(i7 + 3, new byte[]{0, -84});
        }
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 2, new byte[]{1, 96});
        escherArrayProperty2.setElement(escherArrayProperty2.getNumberOfElementsInArray() - 1, new byte[]{0, UnsignedBytes.MAX_POWER_OF_TWO});
        setPropertyValue(escherArrayProperty2);
    }

    public void setPolygonDrawArea(int i5, int i6) {
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.GEOMETRY__RIGHT, i5));
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.GEOMETRY__BOTTOM, i6));
    }

    public HSSFPolygon(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    public HSSFPolygon(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
    }
}
