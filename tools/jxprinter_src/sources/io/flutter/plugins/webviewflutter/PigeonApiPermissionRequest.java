package io.flutter.plugins.webviewflutter;

import A3.I;
import android.webkit.PermissionRequest;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.AbstractC1107v;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiPermissionRequest {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiPermissionRequest pigeonApiPermissionRequest, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.PermissionRequest");
            PermissionRequest permissionRequest = (PermissionRequest) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            try {
                pigeonApiPermissionRequest.grant(permissionRequest, (List) obj3);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiPermissionRequest pigeonApiPermissionRequest, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.PermissionRequest");
            try {
                pigeonApiPermissionRequest.deny((PermissionRequest) obj2);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiPermissionRequest pigeonApiPermissionRequest) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiPermissionRequest == null || (pigeonRegistrar = pigeonApiPermissionRequest.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.grant", androidWebkitLibraryPigeonCodec);
            if (pigeonApiPermissionRequest != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.o
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                PigeonApiPermissionRequest.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiPermissionRequest, obj, reply);
                                break;
                            default:
                                PigeonApiPermissionRequest.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiPermissionRequest, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.deny", androidWebkitLibraryPigeonCodec);
            if (pigeonApiPermissionRequest == null) {
                basicMessageChannel2.setMessageHandler(null);
            } else {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.o
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                PigeonApiPermissionRequest.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiPermissionRequest, obj, reply);
                                break;
                            default:
                                PigeonApiPermissionRequest.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiPermissionRequest, obj, reply);
                                break;
                        }
                    }
                });
            }
        }

        private Companion() {
        }
    }

    public PigeonApiPermissionRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.E.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(O3.l lVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            com.google.android.gms.auth.api.accounttransfer.a.o(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str), lVar);
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            AbstractC1125a.q(Q.INSTANCE, lVar);
            return;
        }
        Object obj2 = list.get(0);
        kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
        com.google.android.gms.auth.api.accounttransfer.a.o(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2)), lVar);
    }

    public abstract void deny(PermissionRequest permissionRequest);

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract void grant(PermissionRequest permissionRequest, List<String> list);

    public final void pigeon_newInstance(PermissionRequest pigeon_instanceArg, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
        } else {
            if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
                AbstractC1125a.q(Q.INSTANCE, callback);
                return;
            }
            long jAddHostCreatedInstance = getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg);
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.PermissionRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(I.listOf(Long.valueOf(jAddHostCreatedInstance), resources(pigeon_instanceArg)), new C0666b(13, callback));
        }
    }

    public abstract List<String> resources(PermissionRequest permissionRequest);
}
