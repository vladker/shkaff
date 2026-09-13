package org.apache.poi.hssf.usermodel;

import java.awt.Dimension;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.ddf.DefaultEscherRecordFactory;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherComplexProperty;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherSimpleProperty;
import org.apache.poi.ddf.EscherTextboxRecord;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFPicture extends HSSFSimpleShape implements Picture {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public HSSFPicture(EscherContainerRecord escherContainerRecord, ObjRecord objRecord) {
        super(escherContainerRecord, objRecord);
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public void afterInsert(HSSFPatriarch hSSFPatriarch) {
        hSSFPatriarch.getBoundAggregate().associateShapeToObjRecord(getEscherContainer().getChildById(EscherClientDataRecord.RECORD_ID), getObjRecord());
        if (getPictureIndex() != -1) {
            EscherBSERecord bSERecord = hSSFPatriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
            bSERecord.setRef(bSERecord.getRef() + 1);
        }
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public HSSFShape cloneShape() {
        EscherContainerRecord escherContainerRecord = new EscherContainerRecord();
        escherContainerRecord.fillFields(getEscherContainer().serialize(), 0, new DefaultEscherRecordFactory());
        return new HSSFPicture(escherContainerRecord, (ObjRecord) getObjRecord().cloneViaReserialise());
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape, org.apache.poi.hssf.usermodel.HSSFShape
    public EscherContainerRecord createSpContainer() {
        EscherContainerRecord escherContainerRecordCreateSpContainer = super.createSpContainer();
        EscherOptRecord escherOptRecord = (EscherOptRecord) escherContainerRecordCreateSpContainer.getChildById(EscherOptRecord.RECORD_ID);
        escherOptRecord.removeEscherProperty(EscherPropertyTypes.LINESTYLE__LINEDASHING);
        escherOptRecord.removeEscherProperty(EscherPropertyTypes.LINESTYLE__NOLINEDRAWDASH);
        escherContainerRecordCreateSpContainer.removeChildRecord(escherContainerRecordCreateSpContainer.getChildById(EscherTextboxRecord.RECORD_ID));
        return escherContainerRecordCreateSpContainer;
    }

    public String getFileName() {
        EscherComplexProperty escherComplexProperty = (EscherComplexProperty) getOptRecord().lookup(EscherPropertyTypes.BLIP__BLIPFILENAME);
        return escherComplexProperty == null ? "" : StringUtil.getFromUnicodeLE(escherComplexProperty.getComplexData()).trim();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public Dimension getImageDimension() {
        EscherBSERecord bSERecord = getPatriarch().getSheet().getWorkbook().getWorkbook().getBSERecord(getPictureIndex());
        byte[] picturedata = bSERecord.getBlipRecord().getPicturedata();
        return ImageUtils.getImageDimension(new UnsynchronizedByteArrayInputStream(picturedata), bSERecord.getBlipTypeWin32());
    }

    public int getPictureIndex() {
        EscherSimpleProperty escherSimpleProperty = (EscherSimpleProperty) getOptRecord().lookup(EscherPropertyTypes.BLIP__BLIPTODISPLAY);
        if (escherSimpleProperty == null) {
            return -1;
        }
        return escherSimpleProperty.getPropertyValue();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize() {
        resize(Double.MAX_VALUE);
    }

    public void setFileName(String str) {
        byte[] toUnicodeLE = StringUtil.getToUnicodeLE(str);
        EscherComplexProperty escherComplexProperty = new EscherComplexProperty(EscherPropertyTypes.BLIP__BLIPFILENAME, true, toUnicodeLE.length);
        escherComplexProperty.setComplexData(toUnicodeLE);
        setPropertyValue(escherComplexProperty);
    }

    public void setPictureIndex(int i5) {
        setPropertyValue(new EscherSimpleProperty(EscherPropertyTypes.BLIP__BLIPTODISPLAY, false, true, i5));
    }

    @Override // org.apache.poi.hssf.usermodel.HSSFSimpleShape
    public void setShapeType(int i5) {
        throw new IllegalStateException("Shape type can not be changed in ".concat(getClass().getSimpleName()));
    }

    public HSSFPicture(HSSFShape hSSFShape, HSSFAnchor hSSFAnchor) {
        super(hSSFShape, hSSFAnchor);
        super.setShapeType(75);
        ((CommonObjectDataSubRecord) getObjRecord().getSubRecords().get(0)).setObjectType((short) 8);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getClientAnchor() {
        HSSFAnchor anchor = getAnchor();
        if (anchor instanceof HSSFClientAnchor) {
            return (HSSFClientAnchor) anchor;
        }
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFPictureData getPictureData() {
        int pictureIndex = getPictureIndex();
        if (pictureIndex == -1) {
            return null;
        }
        HSSFPatriarch patriarch = getPatriarch();
        for (HSSFShape parent = getParent(); patriarch == null && parent != null; parent = parent.getParent()) {
            patriarch = parent.getPatriarch();
        }
        if (patriarch != null) {
            return new HSSFPictureData(patriarch.getSheet().getWorkbook().getWorkbook().getBSERecord(pictureIndex).getBlipRecord());
        }
        throw new IllegalStateException("Could not find a patriarch for a HSSPicture");
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFSheet getSheet() {
        return getPatriarch().getSheet();
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d) {
        resize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public void resize(double d, double d6) {
        HSSFClientAnchor clientAnchor = getClientAnchor();
        clientAnchor.setAnchorType(ClientAnchor.AnchorType.MOVE_DONT_RESIZE);
        HSSFClientAnchor preferredSize = getPreferredSize(d, d6);
        int row2 = (preferredSize.getRow2() - preferredSize.getRow1()) + clientAnchor.getRow1();
        clientAnchor.setCol2((short) ((preferredSize.getCol2() - preferredSize.getCol1()) + clientAnchor.getCol1()));
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row2);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    public HSSFClientAnchor getPreferredSize(double d) {
        return getPreferredSize(d, d);
    }

    @Override // org.apache.poi.ss.usermodel.Picture
    public HSSFClientAnchor getPreferredSize(double d, double d6) {
        ImageUtils.setPreferredSize(this, d, d6);
        return getClientAnchor();
    }
}
