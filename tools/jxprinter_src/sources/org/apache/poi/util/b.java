package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class b implements GenericRecordJsonWriter.GenericRecordHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7245a;

    public /* synthetic */ b(int i5) {
        this.f7245a = i5;
    }

    @Override // org.apache.poi.util.GenericRecordJsonWriter.GenericRecordHandler
    public final boolean print(GenericRecordJsonWriter genericRecordJsonWriter, String str, Object obj) {
        switch (this.f7245a) {
            case 0:
                return genericRecordJsonWriter.printList(str, obj);
            case 1:
                return genericRecordJsonWriter.printGenericRecord(str, obj);
            case 2:
                return genericRecordJsonWriter.printAnnotatedFlag(str, obj);
            case 3:
                return genericRecordJsonWriter.printBytes(str, obj);
            case 4:
                return genericRecordJsonWriter.printPoint(str, obj);
            case 5:
                return genericRecordJsonWriter.printDimension(str, obj);
            case 6:
                return genericRecordJsonWriter.printRectangle(str, obj);
            case 7:
                return genericRecordJsonWriter.printNull(str, obj);
            case 8:
                return genericRecordJsonWriter.printObject(str, obj);
            case 9:
                return genericRecordJsonWriter.printPath(str, obj);
            case 10:
                return genericRecordJsonWriter.printAffineTransform(str, obj);
            case 11:
                return genericRecordJsonWriter.printColor(str, obj);
            case 12:
                return genericRecordJsonWriter.printImage(str, obj);
            case 13:
                return genericRecordJsonWriter.printArray(str, obj);
            case 14:
                return genericRecordJsonWriter.printNumber(str, obj);
            default:
                return genericRecordJsonWriter.printBoolean(str, obj);
        }
    }
}
