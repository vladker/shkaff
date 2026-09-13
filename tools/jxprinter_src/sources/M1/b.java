package M1;

import androidx.core.os.CancellationSignal;
import androidx.transition.FragmentTransitionSupport;
import androidx.transition.Transition;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsTasks;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.aggregates.CustomViewSettingsRecordAggregate;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionHeader;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4EncryptionVerifier;
import org.apache.poi.poifs.crypt.binaryrc4.BinaryRC4Encryptor;
import org.apache.poi.poifs.crypt.standard.EncryptionRecord;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionHeader;
import org.apache.poi.poifs.crypt.standard.StandardEncryptionVerifier;
import org.apache.poi.poifs.crypt.standard.StandardEncryptor;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements SynchronizationGuard.CriticalSection, CancellationSignal.OnCancelListener, Continuation, RecordAggregate.RecordVisitor, EncryptionRecord, Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f469a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b(Object obj, int i5, Object obj2, Object obj3) {
        this.f469a = i5;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        return ((DefaultScheduler) this.b).lambda$schedule$0((TransportContext) this.c, (EventInternal) this.d);
    }

    @Override // org.apache.logging.log4j.util.Supplier
    public Object get() {
        return WorkbookEvaluator.lambda$evaluateFormula$1((String) this.b, (OperationEvaluationContext) this.c, (Ptg[]) this.d);
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        FragmentTransitionSupport.lambda$setListenerForTransitionEnd$0((Runnable) this.b, (Transition) this.c, (Runnable) this.d);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return CrashlyticsTasks.lambda$race$0((TaskCompletionSource) this.b, (AtomicBoolean) this.c, (CancellationTokenSource) this.d, task);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
    public void visitRecord(Record record) {
        ((PageSettingsBlock) this.b).lambda$positionRecords$0((HashMap) this.c, (CustomViewSettingsRecordAggregate) this.d, record);
    }

    @Override // org.apache.poi.poifs.crypt.standard.EncryptionRecord
    public void write(LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream) {
        switch (this.f469a) {
            case 4:
                BinaryRC4Encryptor.lambda$createEncryptionInfoEntry$0((EncryptionInfo) this.b, (BinaryRC4EncryptionHeader) this.c, (BinaryRC4EncryptionVerifier) this.d, littleEndianByteArrayOutputStream);
                break;
            default:
                StandardEncryptor.lambda$createEncryptionInfoEntry$0((EncryptionInfo) this.b, (StandardEncryptionHeader) this.c, (StandardEncryptionVerifier) this.d, littleEndianByteArrayOutputStream);
                break;
        }
    }
}
