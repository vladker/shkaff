package org.apache.poi.hssf.usermodel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ddf.EscherClientDataRecord;
import org.apache.poi.ddf.EscherContainerRecord;
import org.apache.poi.ddf.EscherOptRecord;
import org.apache.poi.ddf.EscherPropertyTypes;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordTypes;
import org.apache.poi.hssf.record.CommonObjectDataSubRecord;
import org.apache.poi.hssf.record.EmbeddedObjectRefSubRecord;
import org.apache.poi.hssf.record.EscherAggregate;
import org.apache.poi.hssf.record.ObjRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SubRecord;
import org.apache.poi.hssf.record.TextObjectRecord;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class HSSFShapeFactory {

    /* JADX INFO: renamed from: org.apache.poi.hssf.usermodel.HSSFShapeFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherRecordTypes;

        static {
            int[] iArr = new int[EscherRecordTypes.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherRecordTypes = iArr;
            try {
                iArr[EscherRecordTypes.CLIENT_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.CLIENT_TEXTBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void createShapeTree(EscherContainerRecord escherContainerRecord, EscherAggregate escherAggregate, HSSFShapeContainer hSSFShapeContainer, DirectoryNode directoryNode) {
        HSSFShape hSSFSimpleShape;
        EscherOptRecord escherOptRecord;
        ObjRecord objRecord = null;
        if (escherContainerRecord.getRecordId() == EscherContainerRecord.SPGR_CONTAINER) {
            EscherClientDataRecord escherClientDataRecord = (EscherClientDataRecord) ((EscherContainerRecord) escherContainerRecord.getChild(0)).getChildById(EscherClientDataRecord.RECORD_ID);
            HSSFShapeGroup hSSFShapeGroup = new HSSFShapeGroup(escherContainerRecord, escherClientDataRecord != null ? (ObjRecord) escherAggregate.getShapeToObjMapping().get(escherClientDataRecord) : null);
            List<EscherContainerRecord> childContainers = escherContainerRecord.getChildContainers();
            if (childContainers.size() > 1) {
                childContainers.subList(1, childContainers.size()).forEach(new a(escherAggregate, 0, hSSFShapeGroup, directoryNode));
            }
            hSSFShapeContainer.addShape(hSSFShapeGroup);
            return;
        }
        if (escherContainerRecord.getRecordId() == EscherContainerRecord.SP_CONTAINER) {
            Map<EscherRecord, Record> shapeToObjMapping = escherAggregate.getShapeToObjMapping();
            TextObjectRecord textObjectRecord = null;
            for (EscherRecord escherRecord : escherContainerRecord) {
                int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherRecordTypes[EscherRecordTypes.forTypeID(escherRecord.getRecordId()).ordinal()];
                if (i5 == 1) {
                    objRecord = (ObjRecord) shapeToObjMapping.get(escherRecord);
                } else if (i5 == 2) {
                    textObjectRecord = (TextObjectRecord) shapeToObjMapping.get(escherRecord);
                }
            }
            if (objRecord == null) {
                throw new RecordFormatException("EscherClientDataRecord can't be found.");
            }
            if (isEmbeddedObject(objRecord)) {
                hSSFShapeContainer.addShape(new HSSFObjectData(escherContainerRecord, objRecord, directoryNode));
                return;
            }
            short objectType = ((CommonObjectDataSubRecord) objRecord.getSubRecords().get(0)).getObjectType();
            if (objectType == 1) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, objRecord);
            } else if (objectType == 2) {
                hSSFSimpleShape = new HSSFSimpleShape(escherContainerRecord, objRecord, textObjectRecord);
            } else if (objectType == 6) {
                hSSFSimpleShape = new HSSFTextbox(escherContainerRecord, objRecord, textObjectRecord);
            } else if (objectType == 8) {
                hSSFSimpleShape = new HSSFPicture(escherContainerRecord, objRecord);
            } else if (objectType == 20) {
                hSSFSimpleShape = new HSSFCombobox(escherContainerRecord, objRecord);
            } else if (objectType != 25) {
                hSSFSimpleShape = (objectType != 30 || (escherOptRecord = (EscherOptRecord) escherContainerRecord.getChildById(EscherOptRecord.RECORD_ID)) == null || escherOptRecord.lookup(EscherPropertyTypes.GEOMETRY__VERTICES) == null) ? new HSSFSimpleShape(escherContainerRecord, objRecord, textObjectRecord) : new HSSFPolygon(escherContainerRecord, objRecord, textObjectRecord);
            } else {
                hSSFSimpleShape = new HSSFComment(escherContainerRecord, objRecord, textObjectRecord, escherAggregate.getNoteRecordByObj(objRecord));
            }
            hSSFShapeContainer.addShape(hSSFSimpleShape);
        }
    }

    private static boolean isEmbeddedObject(ObjRecord objRecord) {
        Iterator<SubRecord> it = objRecord.getSubRecords().iterator();
        while (it.hasNext()) {
            if (it.next() instanceof EmbeddedObjectRefSubRecord) {
                return true;
            }
        }
        return false;
    }
}
