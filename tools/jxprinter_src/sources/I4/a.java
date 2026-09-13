package I4;

import Z3.c;
import androidx.constraintlayout.core.utils.GridCore;
import com.appdev.standard.page.printerlabel.widget.BaseTableView;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;
import kotlin.jvm.internal.E;
import org.apache.commons.compress.archivers.dump.DumpArchiveEntry;
import org.apache.commons.compress.archivers.dump.DumpArchiveInputStream;
import org.apache.commons.compress.harmony.pack200.ClassBands;
import org.apache.commons.compress.harmony.pack200.PackingUtils;
import org.apache.commons.compress.harmony.unpack200.IcBands;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.poi.ddf.EscherDggRecord;
import org.apache.poi.hssf.record.ColumnInfoRecord;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.xslf.usermodel.XSLFGradientPaint;
import org.apache.poi.xssf.util.CTColComparator;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol;
import p147z3.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f345a;

    public /* synthetic */ a(int i5) {
        this.f345a = i5;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0088 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x008a A[RETURN, SYNTHETIC] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f345a) {
            case 0:
                return CTColComparator.lambda$static$0((CTCol) obj, (CTCol) obj2);
            case 1:
                return CTColComparator.lambda$static$1((CTCol) obj, (CTCol) obj2);
            case 2:
                c a6 = (c) obj;
                c b = (c) obj2;
                E.f(a6, "a");
                E.f(b, "b");
                long j6 = a6.f899a;
                long j7 = b.f899a;
                return j6 != j7 ? Long.compareUnsigned(J.m1247constructorimpl(j6), J.m1247constructorimpl(j7)) : Long.compareUnsigned(J.m1247constructorimpl(a6.b), J.m1247constructorimpl(b.b));
            case 3:
                return GridCore.lambda$parseSpans$0((String) obj, (String) obj2);
            case 4:
                return BaseTableView.lambda$removeColumnOnSelectedLeft$5((Integer) obj, (Integer) obj2);
            case 5:
                return BaseTableView.lambda$removeRowOnSelectedTop$1((Integer) obj, (Integer) obj2);
            case 6:
                return BaseTableView.lambda$addColumnOnSelectedLeft$4((Integer) obj, (Integer) obj2);
            case 7:
                return BaseTableView.lambda$addColumnOnSelectedRight$6((Integer) obj, (Integer) obj2);
            case 8:
                return BaseTableView.lambda$removeRowOnSelectedBottom$3((Integer) obj, (Integer) obj2);
            case 9:
                return BaseTableView.lambda$removeColumnOnSelectedRight$7((Integer) obj, (Integer) obj2);
            case 10:
                return BaseTableView.lambda$addRowOnSelectedBottom$2((Integer) obj, (Integer) obj2);
            case 11:
                return BaseTableView.lambda$addRowOnSelectedTop$0((Integer) obj, (Integer) obj2);
            case 12:
                return ((Double) obj).compareTo((Double) obj2);
            case 13:
                return CrashlyticsReportPersistence.lambda$static$0((File) obj, (File) obj2);
            case 14:
                return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
            case 15:
                String str = (String) obj;
                String str2 = (String) obj2;
                int iMin = Math.min(str.length(), str2.length());
                for (int i5 = 4; i5 < iMin; i5++) {
                    char cCharAt = str.charAt(i5);
                    char cCharAt2 = str2.charAt(i5);
                    if (cCharAt != cCharAt2) {
                        if (cCharAt < cCharAt2) {
                            return -1;
                        }
                        return 1;
                    }
                }
                int length = str.length();
                int length2 = str2.length();
                if (length == length2) {
                    return 0;
                }
                if (length < length2) {
                    return -1;
                }
                return 1;
            case 16:
                return DumpArchiveInputStream.lambda$new$0((DumpArchiveEntry) obj, (DumpArchiveEntry) obj2);
            case 17:
                return ClassBands.lambda$finaliseBands$0(obj, obj2);
            case 18:
                return PackingUtils.lambda$reorderPackingFiles$0(obj, obj2);
            case 19:
                return IcBands.lambda$getRelevantIcTuples$0(obj, obj2);
            case 20:
                return ClassConstantPool.lambda$initialSort$0(obj, obj2);
            case 21:
                return ClassConstantPool.lambda$initialSort$1(obj, obj2);
            case 22:
                return ClassConstantPool.lambda$initialSort$2(obj, obj2);
            case 23:
                return BOMInputStream.lambda$static$0((ByteOrderMark) obj, (ByteOrderMark) obj2);
            case 24:
                return EscherDggRecord.FileIdCluster.access$100((EscherDggRecord.FileIdCluster) obj, (EscherDggRecord.FileIdCluster) obj2);
            case 25:
                return ColumnInfoRecordsAggregate.compareColInfos((ColumnInfoRecord) obj, (ColumnInfoRecord) obj2);
            case 26:
                return XSLFGradientPaint.lambda$new$0((CTGradientStop) obj, (CTGradientStop) obj2);
            default:
                return ((String) obj).compareTo((String) obj2);
        }
    }
}
