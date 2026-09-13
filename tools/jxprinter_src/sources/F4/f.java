package F4;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.core.util.function.Consumer;
import com.android.billingclient.api.C0431r0;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0433s0;
import com.appdev.standard.page.printerlabel.util.DataCreateUtil;
import com.appdev.standard.page.scene.CloudSpaceFragment;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.OnSuccessListener;
import com.idlefish.flutterboost.EventListener;
import com.idlefish.flutterboost.FlutterBoostPlugin;
import com.idlefish.flutterboost.ListenerRemover;
import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;
import org.apache.commons.io.function.IOFunction;
import org.apache.commons.io.function.IOSupplier;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.poifs.crypt.dsig.SignatureLine;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSignatureLine;
import p007a4.V;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class f implements IOSupplier, OnSuccessListener, CallbackToFutureAdapter.Resolver, Consumer, p074n0.b, DataCreateUtil.CreateBitmapEventListener, SynchronizationGuard.CriticalSection, Messages.FlutterRouterApi.Reply, ListenerRemover, InterfaceC0433s0, SignatureLine.AddPictureData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f275a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ f(Object obj, Object obj2, int i5) {
        this.f275a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // androidx.window.extensions.core.util.function.Consumer
    public void accept(Object obj) {
        EmbeddingCompat.setEmbeddingCallback$lambda$0((EmbeddingInterfaceCompat.EmbeddingCallbackInterface) this.b, (EmbeddingCompat) this.c, (List) obj);
    }

    @Override // org.apache.poi.poifs.crypt.dsig.SignatureLine.AddPictureData
    public String addPictureData(byte[] bArr, PictureType pictureType) {
        return ((XSSFSignatureLine) this.b).lambda$add$0((XSSFSheet) this.c, bArr, pictureType);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CoroutineAdapterKt.asListenableFuture$lambda$0((V) this.b, this.c, completer);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        switch (this.f275a) {
            case 7:
                return ((Uploader) this.b).lambda$logAndUpdateState$5((Iterable) this.c);
            default:
                return ((Uploader) this.b).lambda$logAndUpdateState$7((HashMap) this.c);
        }
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public Object get() {
        switch (this.f275a) {
            case 0:
                return ((IOFunction) this.b).lambda$compose$2((IOSupplier) this.c);
            default:
                return ((IOFunction) this.b).lambda$compose$3((Supplier) this.c);
        }
    }

    @Override // com.appdev.standard.page.printerlabel.util.DataCreateUtil.CreateBitmapEventListener
    public void onComplete(byte[] bArr) {
        CloudSpaceFragment.lambda$generatePrintData$13((byte[][]) this.b, (CountDownLatch) this.c, bArr);
    }

    @Override // com.android.billingclient.api.InterfaceC0433s0
    public void onQueryPurchasesResponse(H h6, List list) {
        p062l0.e eVar = (p062l0.e) this.b;
        p062l0.c cVar = (p062l0.c) this.c;
        eVar.getClass();
        if (h6.f2433a != 0) {
            p051j0.a.d("GoogleBillingManager", "查询未完成订单失败: " + h6.getDebugMessage());
            return;
        }
        StringBuilder sb = new StringBuilder("查询到 ");
        sb.append(list != null ? list.size() : 0);
        sb.append(" 个购买记录");
        p051j0.a.d("GoogleBillingManager", sb.toString());
        if (list == null || list.isEmpty()) {
            p051j0.a.d("GoogleBillingManager", "没有未完成的购买");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0431r0 c0431r0 = (C0431r0) it.next();
            if (c0431r0.c.optInt("purchaseState", 1) != 4) {
                p051j0.a.d("GoogleBillingManager", "发现未完成的购买: " + c0431r0.getOrderId());
                if (cVar != null) {
                    cVar.onPendingPurchaseFound(c0431r0);
                }
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        P1.b.a((P1.b) this.b, (MethodChannel.Result) this.c, (List) obj);
    }

    @Override // com.idlefish.flutterboost.ListenerRemover
    public void remove() {
        ((LinkedList) this.b).remove((EventListener) this.c);
    }

    @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
    public void reply(Object obj) {
        FlutterBoostPlugin.lambda$onContainerAppeared$10((String) this.b, (Runnable) this.c, (Void) obj);
    }
}
