package io.flutter.plugins.webviewflutter;

import android.view.View;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.AbstractC1107v;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiView {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            View view = (View) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj3).longValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiView.scrollTo(view, jLongValue, ((Long) obj4).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$11$lambda$10(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            View view = (View) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.OverScrollMode");
            try {
                pigeonApiView.setOverScrollMode(view, (OverScrollMode) obj3);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            View view = (View) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj3).longValue();
            Object obj4 = list.get(2);
            kotlin.jvm.internal.E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiView.scrollBy(view, jLongValue, ((Long) obj4).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            try {
                listWrapError = A3.G.listOf(pigeonApiView.getScrollPosition((View) obj2));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$7$lambda$6(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            View view = (View) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiView.setVerticalScrollBarEnabled(view, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$9$lambda$8(PigeonApiView pigeonApiView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.view.View");
            View view = (View) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiView.setHorizontalScrollBarEnabled(view, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiView pigeonApiView) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiView == null || (pigeonRegistrar = pigeonApiView.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.scrollTo", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.scrollBy", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView != null) {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.getScrollPosition", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView != null) {
                final int i7 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.setVerticalScrollBarEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView != null) {
                final int i8 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.setHorizontalScrollBarEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView != null) {
                final int i9 = 4;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.View.setOverScrollMode", androidWebkitLibraryPigeonCodec);
            if (pigeonApiView == null) {
                basicMessageChannel6.setMessageHandler(null);
            } else {
                final int i10 = 5;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiView, obj, reply);
                                break;
                            case 1:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiView, obj, reply);
                                break;
                            case 2:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiView, obj, reply);
                                break;
                            case 3:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiView, obj, reply);
                                break;
                            case 4:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiView, obj, reply);
                                break;
                            default:
                                PigeonApiView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiView, obj, reply);
                                break;
                        }
                    }
                });
            }
        }

        private Companion() {
        }
    }

    public PigeonApiView(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
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

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract WebViewPoint getScrollPosition(View view);

    public final void pigeon_newInstance(View pigeon_instanceArg, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            AbstractC1125a.q(Q.INSTANCE, callback);
        } else {
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.View.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(A3.G.listOf(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new C0666b(19, callback));
        }
    }

    public abstract void scrollBy(View view, long j6, long j7);

    public abstract void scrollTo(View view, long j6, long j7);

    public abstract void setHorizontalScrollBarEnabled(View view, boolean z6);

    public abstract void setOverScrollMode(View view, OverScrollMode overScrollMode);

    public abstract void setVerticalScrollBarEnabled(View view, boolean z6);
}
