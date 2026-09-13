package W2;

import android.app.Activity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.core.util.Consumer;
import androidx.webkit.WebViewCompat;
import androidx.window.area.WindowAreaControllerImpl;
import androidx.window.area.WindowAreaPresentationSessionCallback;
import androidx.window.area.WindowAreaSessionCallback;
import androidx.window.layout.adapter.extensions.ExtensionWindowBackendApi0;
import com.appdev.standard.dialog.DefaultTipDialog;
import com.appdev.standard.page.quickprinting.QuickPrintingActivity;
import com.appdev.standard.page.webprint.WebViewActivity;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.firebase.installations.FirebaseInstallations;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import p051j0.h;
import t4.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f787a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f787a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j6;
        switch (this.f787a) {
            case 0:
                e eVar = (e) this.b;
                EventChannel.EventSink eventSink = eVar.b;
                a aVar = eVar.f789a;
                eventSink.success(aVar.getCapabilitiesFromNetwork(aVar.f785a.getActiveNetwork()));
                return;
            case 1:
                Z2.d.a((Z2.d) this.b);
                return;
            case 2:
                ((Carousel) this.b).lambda$updateItems$0();
                return;
            case 3:
                WebViewCompat.lambda$startUpWebView$2((WebViewCompat.WebViewStartUpCallback) this.b);
                return;
            case 4:
                WindowAreaControllerImpl.presentContentOnWindowArea$lambda$2((WindowAreaPresentationSessionCallback) this.b);
                return;
            case 5:
                WindowAreaControllerImpl.transferActivityToWindowArea$lambda$1((WindowAreaSessionCallback) this.b);
                return;
            case 6:
                WindowAreaControllerImpl.RearDisplaySessionConsumer.onSessionFinished$lambda$2((WindowAreaControllerImpl.RearDisplaySessionConsumer) this.b);
                return;
            case 7:
                ExtensionWindowBackendApi0.registerLayoutChangeCallback$lambda$0((Consumer) this.b);
                return;
            case 8:
                ((QuickPrintingActivity) this.b).lambda$printTextBitmap$2();
                return;
            case 9:
                ((WebViewActivity) this.b).lambda$captureWebViewAndSave$2();
                return;
            case 10:
                ((WorkInitializer) this.b).lambda$ensureContextsScheduled$1();
                return;
            case 11:
                ((CarouselLayoutManager) this.b).refreshKeylineState();
                return;
            case 12:
                ((MaterialBackOrchestrator) this.b).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            case 13:
                ((FirebaseInstallations) this.b).lambda$getId$1();
                return;
            case 14:
                ((FlutterBoostActivity) this.b).lambda$onResume$0();
                return;
            case 15:
                ((FlutterBoostFragment) this.b).lambda$onResume$2();
                return;
            case 16:
                ((PlatformViewsController) this.b).lambda$onEndFrame$3();
                return;
            case 17:
                Activity activity = (Activity) this.b;
                DefaultTipDialog defaultTipDialog = new DefaultTipDialog(activity);
                defaultTipDialog.c(activity.getString(p113u.g.text_474));
                defaultTipDialog.a(activity.getString(p113u.g.text_254));
                defaultTipDialog.b(activity.getString(p113u.g.confirm));
                defaultTipDialog.f2608a = new h(activity);
                defaultTipDialog.show();
                return;
            case 18:
                i iVar = (i) this.b;
                while (true) {
                    long jNanoTime = System.nanoTime();
                    synchronized (iVar) {
                        try {
                            t4.h hVar = null;
                            long j7 = Long.MIN_VALUE;
                            int i5 = 0;
                            int i6 = 0;
                            for (t4.h hVar2 : iVar.d) {
                                if (iVar.b(hVar2, jNanoTime) > 0) {
                                    i6++;
                                } else {
                                    i5++;
                                    long j8 = jNanoTime - hVar2.f8688q;
                                    if (j8 > j7) {
                                        hVar = hVar2;
                                        j7 = j8;
                                    }
                                }
                            }
                            j6 = iVar.b;
                            if (j7 >= j6 || i5 > iVar.f8690a) {
                                iVar.d.remove(hVar);
                                p107s4.d.d(hVar.e);
                                j6 = 0;
                            } else if (i5 > 0) {
                                j6 -= j7;
                            } else if (i6 <= 0) {
                                iVar.f8691f = false;
                                j6 = -1;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (j6 == -1) {
                        return;
                    }
                    if (j6 > 0) {
                        long j9 = j6 / 1000000;
                        long j10 = j6 - (1000000 * j9);
                        synchronized (iVar) {
                            try {
                                iVar.wait(j9, (int) j10);
                                break;
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
                break;
            case 19:
                ((p125w.d) this.b).onNoUpdateAvailable();
                return;
            default:
                p133x1.g.a((p133x1.g) this.b);
                return;
        }
    }
}
