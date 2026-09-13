package Y2;

import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpResult;
import com.appdev.standard.page.receipt.ReceiptEditActivity;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.crashlytics.internal.common.Utils;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore;
import io.flutter.util.ViewUtils;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream;
import org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorInputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorInputStream;
import org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.output.ThresholdingOutputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.util.Supplier;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.aggregates.RecordAggregate;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import p007a4.C0306v;
import p007a4.InterfaceC0304u;
import p056k0.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements ViewUtils.ViewVisitor, Interpolator, InputConnectionCompat.OnCommitContentListener, WebViewCompat.WebViewStartUpCallback, j, SynchronizationGuard.CriticalSection, AccessibilityViewCommand, CanvasCompat.CanvasOperation, Deferred.DeferredHandler, Continuation, KeyEventChannel.EventResponseHandler, OnCompleteListener, LZ77Compressor.Callback, ByteUtils.ByteSupplier, IOFunction, RecordAggregate.RecordVisitor, Supplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f872a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i5) {
        this.f872a = i5;
        this.b = obj;
    }

    @Override // org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Callback
    public void accept(LZ77Compressor.Block block) throws IOException {
        switch (this.f872a) {
            case 22:
                ((BlockLZ4CompressorOutputStream) this.b).lambda$new$0(block);
                break;
            default:
                ((SnappyCompressorOutputStream) this.b).lambda$new$0(block);
                break;
        }
    }

    @Override // org.apache.commons.io.function.IOFunction
    public Object apply(Object obj) {
        return IOUtils.lambda$toByteArray$1((UnsynchronizedByteArrayOutputStream) this.b, (ThresholdingOutputStream) obj);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f872a) {
            case 5:
                return Integer.valueOf(((EventStore) this.b).cleanUp());
            case 6:
                return ((ClientHealthMetricsStore) this.b).loadClientMetrics();
            case 7:
                return ((Uploader) this.b).lambda$logAndUpdateState$6();
            default:
                return ((WorkInitializer) this.b).lambda$ensureContextsScheduled$0();
        }
    }

    @Override // org.apache.logging.log4j.util.Supplier
    public Object get() {
        return HSSFSheet.lambda$setPropertiesFromSheet$0((CellValueRecordInterface) this.b);
    }

    @Override // org.apache.commons.compress.utils.ByteUtils.ByteSupplier
    public int getAsByte() {
        switch (this.f872a) {
            case 23:
                return ((FramedLZ4CompressorInputStream) this.b).readOneByte();
            case 24:
                return ((AbstractLZ77CompressorInputStream) this.b).readOneByte();
            default:
                return ((FramedSnappyCompressorInputStream) this.b).readOneByte();
        }
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f6) {
        return Transition.lambda$getInterpolator$0((String) this.b, f6);
    }

    @Override // com.google.firebase.inject.Deferred.DeferredHandler
    public void handle(Provider provider) {
        switch (this.f872a) {
            case 12:
                ((CrashlyticsNativeComponentDeferredProxy) this.b).lambda$new$0(provider);
                break;
            default:
                RemoteConfigDeferredProxy.lambda$setupListener$0((CrashlyticsRemoteConfigListener) this.b, provider);
                break;
        }
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i5, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.b, inputContentInfoCompat, i5, bundle);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f872a) {
            case 19:
                FlutterFirebaseCorePlugin.lambda$listenToVoidResponse$2((GeneratedAndroidFirebaseCore.VoidResult) this.b, task);
                break;
            case 20:
                FlutterFirebaseCorePlugin.lambda$listenToResponse$1((GeneratedAndroidFirebaseCore.Result) this.b, task);
                break;
            default:
                InterfaceC0304u interfaceC0304u = (InterfaceC0304u) this.b;
                Exception exception = task.getException();
                if (exception != null) {
                    interfaceC0304u.completeExceptionally(exception);
                } else if (!task.isCanceled()) {
                    ((C0306v) interfaceC0304u).makeCompleting$kotlinx_coroutines_core(task.getResult());
                } else {
                    interfaceC0304u.cancel((CancellationException) null);
                }
                break;
        }
    }

    @Override // io.flutter.embedding.engine.systemchannels.KeyEventChannel.EventResponseHandler
    public void onFrameworkResponse(boolean z6) {
        ((KeyboardManager.Responder.OnKeyEventHandledCallback) this.b).onKeyEventHandled(z6);
    }

    @Override // p056k0.j
    public void onImagePicked(Uri uri) {
        ((ReceiptEditActivity) this.b).lambda$onReceiptEditMaterialAddClick$0(uri);
    }

    @Override // androidx.webkit.WebViewCompat.WebViewStartUpCallback
    public void onSuccess(WebViewStartUpResult webViewStartUpResult) {
        WebViewCompat.lambda$startUpWebView$1((WebViewCompat.WebViewStartUpCallback) this.b, webViewStartUpResult);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        switch (this.f872a) {
            case 10:
                ((MaskableFrameLayout) this.b).lambda$dispatchDraw$1(canvas);
                break;
            default:
                ((NavigationView) this.b).lambda$dispatchDraw$0(canvas);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        switch (this.f872a) {
            case 14:
                return Boolean.valueOf(((SessionReportingCoordinator) this.b).onReportSendComplete(task));
            case 15:
                return Utils.lambda$awaitEvenIfOnMainThread$0((CountDownLatch) this.b, task);
            case 16:
                return CrashlyticsWorker.lambda$submit$1((Runnable) this.b, task);
            default:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$5((SuccessContinuation) this.b, task);
        }
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate.RecordVisitor
    public void visitRecord(Record record) {
        ((List) this.b).add(record);
    }

    @Override // io.flutter.util.ViewUtils.ViewVisitor
    public boolean run(View view) {
        return ViewUtils.lambda$hasChildViewOfType$1((Class[]) this.b, view);
    }
}
