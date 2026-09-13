package io.flutter.plugins.webviewflutter;

import A3.I;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1107v;
import kotlinx.serialization.json.internal.AbstractC1125a;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiWebView {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebView.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiWebView.pigeon_defaultConstructor(), ((Long) obj2).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$11$lambda$10(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.E.d(obj4, "null cannot be cast to non-null type kotlin.ByteArray");
            try {
                pigeonApiWebView.postUrl(webView, str, (byte[]) obj4);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$13$lambda$12(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                listWrapError = A3.G.listOf(pigeonApiWebView.getUrl((WebView) obj2));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$15$lambda$14(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                listWrapError = A3.G.listOf(Boolean.valueOf(pigeonApiWebView.canGoBack((WebView) obj2)));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$17$lambda$16(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                listWrapError = A3.G.listOf(Boolean.valueOf(pigeonApiWebView.canGoForward((WebView) obj2)));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$19$lambda$18(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.goBack((WebView) obj2);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$21$lambda$20(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.goForward((WebView) obj2);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$23$lambda$22(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.reload((WebView) obj2);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$25$lambda$24(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebView.clearCache(webView, ((Boolean) obj3).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$28$lambda$27(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            pigeonApiWebView.evaluateJavascript((WebView) obj2, (String) obj3, new k(reply, 1));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUpMessageHandlers$lambda$28$lambda$27$lambda$26(BasicMessageChannel.Reply reply, p147z3.u uVar) {
            Throwable thM1362exceptionOrNullimpl = p147z3.u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                Object objB = uVar.b();
                if (objB instanceof z3.u.a) {
                    objB = null;
                }
                reply.reply(AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapResult((String) objB));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebView.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiWebView.settings(webView), ((Long) obj3).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$30$lambda$29(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                listWrapError = A3.G.listOf(pigeonApiWebView.getTitle((WebView) obj2));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$32$lambda$31(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebView.setWebContentsDebuggingEnabled(((Boolean) obj2).booleanValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$34$lambda$33(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.setWebViewClient((WebView) obj2, (WebViewClient) list.get(1));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$36$lambda$35(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.JavaScriptChannel");
            try {
                pigeonApiWebView.addJavaScriptChannel(webView, (JavaScriptChannel) obj3);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$38$lambda$37(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiWebView.removeJavaScriptChannel(webView, (String) obj3);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$40$lambda$39(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.setDownloadListener((WebView) obj2, (DownloadListener) list.get(1));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$42$lambda$41(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.setWebChromeClient((WebView) obj2, (WebChromeClientProxyApi.WebChromeClientImpl) list.get(1));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$44$lambda$43(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebView.setBackgroundColor(webView, ((Long) obj3).longValue());
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$46$lambda$45(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            try {
                pigeonApiWebView.destroy((WebView) obj2);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiWebView.loadData(webView, (String) obj3, (String) list.get(2), (String) list.get(3));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$7$lambda$6(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            String str = (String) list.get(1);
            Object obj3 = list.get(2);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiWebView.loadDataWithBaseUrl(webView, str, (String) obj3, (String) list.get(3), (String) list.get(4), (String) list.get(5));
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$9$lambda$8(PigeonApiWebView pigeonApiWebView, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.E.f(reply, "reply");
            kotlin.jvm.internal.E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.E.d(obj2, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.E.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.E.d(obj4, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            try {
                pigeonApiWebView.loadUrl(webView, str, (Map) obj4);
                listWrapError = A3.G.listOf(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiWebView pigeonApiWebView) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiWebView == null || (pigeonRegistrar = pigeonApiWebView.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_defaultConstructor", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.settings", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i6 = 2;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.loadData", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i7 = 6;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.loadDataWithBaseUrl", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i8 = 7;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.loadUrl", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i9 = 8;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.postUrl", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i10 = 9;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.getUrl", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i11 = 10;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i11) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoBack", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i12 = 12;
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i12) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.canGoForward", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i13 = 13;
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i13) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.goBack", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i14 = 14;
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i14) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.goForward", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i15 = 11;
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i15) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.reload", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i16 = 15;
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i16) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.clearCache", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i17 = 16;
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i17) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.evaluateJavascript", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i18 = 17;
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i18) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.getTitle", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i19 = 18;
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i19) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebContentsDebuggingEnabled", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i20 = 19;
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i20) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebViewClient", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i21 = 20;
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i21) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel17.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.addJavaScriptChannel", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i22 = 21;
                basicMessageChannel18.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i22) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel18.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.removeJavaScriptChannel", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i23 = 22;
                basicMessageChannel19.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i23) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel19.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.setDownloadListener", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i24 = 1;
                basicMessageChannel20.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i24) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel20.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.setWebChromeClient", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i25 = 3;
                basicMessageChannel21.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i25) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel21.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.setBackgroundColor", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView != null) {
                final int i26 = 4;
                basicMessageChannel22.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i26) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel22.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebView.destroy", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebView == null) {
                basicMessageChannel23.setMessageHandler(null);
            } else {
                final int i27 = 5;
                basicMessageChannel23.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.y
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i27) {
                            case 0:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebView, obj, reply);
                                break;
                            case 1:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$40$lambda$39(pigeonApiWebView, obj, reply);
                                break;
                            case 2:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebView, obj, reply);
                                break;
                            case 3:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$42$lambda$41(pigeonApiWebView, obj, reply);
                                break;
                            case 4:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$44$lambda$43(pigeonApiWebView, obj, reply);
                                break;
                            case 5:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$46$lambda$45(pigeonApiWebView, obj, reply);
                                break;
                            case 6:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebView, obj, reply);
                                break;
                            case 7:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebView, obj, reply);
                                break;
                            case 8:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebView, obj, reply);
                                break;
                            case 9:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebView, obj, reply);
                                break;
                            case 10:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$13$lambda$12(pigeonApiWebView, obj, reply);
                                break;
                            case 11:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$21$lambda$20(pigeonApiWebView, obj, reply);
                                break;
                            case 12:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$15$lambda$14(pigeonApiWebView, obj, reply);
                                break;
                            case 13:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$17$lambda$16(pigeonApiWebView, obj, reply);
                                break;
                            case 14:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$19$lambda$18(pigeonApiWebView, obj, reply);
                                break;
                            case 15:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$23$lambda$22(pigeonApiWebView, obj, reply);
                                break;
                            case 16:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$25$lambda$24(pigeonApiWebView, obj, reply);
                                break;
                            case 17:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$28$lambda$27(pigeonApiWebView, obj, reply);
                                break;
                            case 18:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$30$lambda$29(pigeonApiWebView, obj, reply);
                                break;
                            case 19:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$32$lambda$31(pigeonApiWebView, obj, reply);
                                break;
                            case 20:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$34$lambda$33(pigeonApiWebView, obj, reply);
                                break;
                            case 21:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$36$lambda$35(pigeonApiWebView, obj, reply);
                                break;
                            default:
                                PigeonApiWebView.Companion.setUpMessageHandlers$lambda$38$lambda$37(pigeonApiWebView, obj, reply);
                                break;
                        }
                    }
                });
            }
        }

        private Companion() {
        }
    }

    public PigeonApiWebView(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.E.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScrollChanged$lambda$1(O3.l lVar, String str, Object obj) {
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

    public abstract void addJavaScriptChannel(WebView webView, JavaScriptChannel javaScriptChannel);

    public abstract boolean canGoBack(WebView webView);

    public abstract boolean canGoForward(WebView webView);

    public abstract void clearCache(WebView webView, boolean z6);

    public abstract void destroy(WebView webView);

    public abstract void evaluateJavascript(WebView webView, String str, O3.l lVar);

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract String getTitle(WebView webView);

    public abstract String getUrl(WebView webView);

    public abstract void goBack(WebView webView);

    public abstract void goForward(WebView webView);

    public abstract void loadData(WebView webView, String str, String str2, String str3);

    public abstract void loadDataWithBaseUrl(WebView webView, String str, String str2, String str3, String str4, String str5);

    public abstract void loadUrl(WebView webView, String str, Map<String, String> map);

    public final void onScrollChanged(WebView pigeon_instanceArg, long j6, long j7, long j8, long j9, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
        } else {
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebView.onScrollChanged", getPigeonRegistrar().getCodec()).send(I.listOf(pigeon_instanceArg, Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Long.valueOf(j9)), new u(8, callback));
        }
    }

    public abstract WebView pigeon_defaultConstructor();

    public final PigeonApiView pigeon_getPigeonApiView() {
        return getPigeonRegistrar().getPigeonApiView();
    }

    public final void pigeon_newInstance(WebView pigeon_instanceArg, O3.l callback) {
        kotlin.jvm.internal.E.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.E.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            com.google.android.gms.auth.api.accounttransfer.a.p("ignore-calls-error", "Calls to Dart are being ignored.", "", callback);
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            AbstractC1125a.q(Q.INSTANCE, callback);
        } else {
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebView.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(A3.G.listOf(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new u(9, callback));
        }
    }

    public abstract void postUrl(WebView webView, String str, byte[] bArr);

    public abstract void reload(WebView webView);

    public abstract void removeJavaScriptChannel(WebView webView, String str);

    public abstract void setBackgroundColor(WebView webView, long j6);

    public abstract void setDownloadListener(WebView webView, DownloadListener downloadListener);

    public abstract void setWebChromeClient(WebView webView, WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl);

    public abstract void setWebContentsDebuggingEnabled(boolean z6);

    public abstract void setWebViewClient(WebView webView, WebViewClient webViewClient);

    public abstract WebSettings settings(WebView webView);
}
