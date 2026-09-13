package io.flutter.plugins.webviewflutter;

import android.webkit.WebSettings;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.AbstractC1107v;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiWebSettings {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setDomStorageEnabled(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$11$lambda$10(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setMediaPlaybackRequiresUserGesture(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$13$lambda$12(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setSupportZoom(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$15$lambda$14(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setLoadWithOverviewMode(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$17$lambda$16(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setUseWideViewPort(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$19$lambda$18(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setDisplayZoomControls(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$21$lambda$20(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setBuiltInZoomControls(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$23$lambda$22(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setAllowFileAccess(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$25$lambda$24(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setAllowContentAccess(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$27$lambda$26(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setGeolocationEnabled(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$29$lambda$28(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebSettings.setTextZoom(webSettings, ((Long) obj3).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setJavaScriptCanOpenWindowsAutomatically(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$31$lambda$30(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            try {
                listWrapError = A3.G.listOf(pigeonApiWebSettings.getUserAgentString((WebSettings) obj2));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$33$lambda$32(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.MixedContentMode");
            try {
                pigeonApiWebSettings.setMixedContentMode(webSettings, (MixedContentMode) obj3);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setSupportMultipleWindows(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$7$lambda$6(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            WebSettings webSettings = (WebSettings) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebSettings.setJavaScriptEnabled(webSettings, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$9$lambda$8(PigeonApiWebSettings pigeonApiWebSettings, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebSettings");
            try {
                pigeonApiWebSettings.setUserAgentString((WebSettings) obj2, (String) list.get(1));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiWebSettings pigeonApiWebSettings) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiWebSettings == null || (pigeonRegistrar = pigeonApiWebSettings.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDomStorageEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptCanOpenWindowsAutomatically", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i6 = 15;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportMultipleWindows", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i7 = 16;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setJavaScriptEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i8 = 1;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUserAgentString", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i9 = 2;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMediaPlaybackRequiresUserGesture", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i10 = 3;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setSupportZoom", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i11 = 4;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i11) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setLoadWithOverviewMode", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i12 = 5;
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i12) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setUseWideViewPort", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i13 = 6;
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i13) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setDisplayZoomControls", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i14 = 7;
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i14) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setBuiltInZoomControls", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i15 = 8;
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i15) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowFileAccess", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i16 = 9;
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i16) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setAllowContentAccess", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i17 = 10;
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i17) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setGeolocationEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i18 = 11;
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i18) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setTextZoom", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i19 = 12;
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i19) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.getUserAgentString", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings != null) {
                final int i20 = 13;
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i20) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebSettings.setMixedContentMode", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebSettings == null) {
                basicMessageChannel17.setMessageHandler(null);
            } else {
                final int i21 = 14;
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i21) {
                            case 0:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebSettings, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebSettings, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebSettings, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebSettings, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebSettings, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebSettings, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebSettings, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebSettings, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebSettings, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebSettings, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebSettings, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$27$lambda$26(pigeonApiWebSettings, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$29$lambda$28(pigeonApiWebSettings, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$31$lambda$30(pigeonApiWebSettings, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$33$lambda$32(pigeonApiWebSettings, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebSettings, obj, reply);
                                break;
                            default:
                                PigeonApiWebSettings.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebSettings, obj, reply);
                                break;
                        }
                    }
                });
            }
        }

        private Companion() {
        }
    }

    public PigeonApiWebSettings(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
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

    public abstract String getUserAgentString(WebSettings webSettings);

    public final void pigeon_newInstance(WebSettings pigeon_instanceArg, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            AbstractC1125a.q(Q.INSTANCE, callback);
        } else {
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebSettings.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(A3.G.listOf(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new u(5, callback));
        }
    }

    public abstract void setAllowContentAccess(WebSettings webSettings, boolean z6);

    public abstract void setAllowFileAccess(WebSettings webSettings, boolean z6);

    public abstract void setBuiltInZoomControls(WebSettings webSettings, boolean z6);

    public abstract void setDisplayZoomControls(WebSettings webSettings, boolean z6);

    public abstract void setDomStorageEnabled(WebSettings webSettings, boolean z6);

    public abstract void setGeolocationEnabled(WebSettings webSettings, boolean z6);

    public abstract void setJavaScriptCanOpenWindowsAutomatically(WebSettings webSettings, boolean z6);

    public abstract void setJavaScriptEnabled(WebSettings webSettings, boolean z6);

    public abstract void setLoadWithOverviewMode(WebSettings webSettings, boolean z6);

    public abstract void setMediaPlaybackRequiresUserGesture(WebSettings webSettings, boolean z6);

    public abstract void setMixedContentMode(WebSettings webSettings, MixedContentMode mixedContentMode);

    public abstract void setSupportMultipleWindows(WebSettings webSettings, boolean z6);

    public abstract void setSupportZoom(WebSettings webSettings, boolean z6);

    public abstract void setTextZoom(WebSettings webSettings, long j6);

    public abstract void setUseWideViewPort(WebSettings webSettings, boolean z6);

    public abstract void setUserAgentString(WebSettings webSettings, String str);
}
