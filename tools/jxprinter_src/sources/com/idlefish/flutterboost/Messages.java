package com.idlefish.flutterboost;

import android.util.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Messages {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CommonParams {
        private Map<String, Object> arguments;
        private String key;
        private Boolean opaque;
        private String pageName;
        private String uniqueId;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {
            private Map<String, Object> arguments;
            private String key;
            private Boolean opaque;
            private String pageName;
            private String uniqueId;

            public CommonParams build() {
                CommonParams commonParams = new CommonParams();
                commonParams.setOpaque(this.opaque);
                commonParams.setKey(this.key);
                commonParams.setPageName(this.pageName);
                commonParams.setUniqueId(this.uniqueId);
                commonParams.setArguments(this.arguments);
                return commonParams;
            }

            public Builder setArguments(Map<String, Object> map) {
                this.arguments = map;
                return this;
            }

            public Builder setKey(String str) {
                this.key = str;
                return this;
            }

            public Builder setOpaque(Boolean bool) {
                this.opaque = bool;
                return this;
            }

            public Builder setPageName(String str) {
                this.pageName = str;
                return this;
            }

            public Builder setUniqueId(String str) {
                this.uniqueId = str;
                return this;
            }
        }

        public static CommonParams fromMap(Map<String, Object> map) {
            CommonParams commonParams = new CommonParams();
            commonParams.setOpaque((Boolean) map.get("opaque"));
            commonParams.setKey((String) map.get(Constants.KEY));
            commonParams.setPageName((String) map.get("pageName"));
            commonParams.setUniqueId((String) map.get("uniqueId"));
            commonParams.setArguments((Map) map.get("arguments"));
            return commonParams;
        }

        public Map<String, Object> getArguments() {
            return this.arguments;
        }

        public String getKey() {
            return this.key;
        }

        public Boolean getOpaque() {
            return this.opaque;
        }

        public String getPageName() {
            return this.pageName;
        }

        public String getUniqueId() {
            return this.uniqueId;
        }

        public void setArguments(Map<String, Object> map) {
            this.arguments = map;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public void setOpaque(Boolean bool) {
            this.opaque = bool;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public void setUniqueId(String str) {
            this.uniqueId = str;
        }

        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("opaque", this.opaque);
            map.put(Constants.KEY, this.key);
            map.put("pageName", this.pageName);
            map.put("uniqueId", this.uniqueId);
            map.put("arguments", this.arguments);
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlutterContainer {
        private List<FlutterPage> pages;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {
            private List<FlutterPage> pages;

            public FlutterContainer build() {
                FlutterContainer flutterContainer = new FlutterContainer();
                flutterContainer.setPages(this.pages);
                return flutterContainer;
            }

            public Builder setPages(List<FlutterPage> list) {
                this.pages = list;
                return this;
            }
        }

        public static FlutterContainer fromMap(Map<String, Object> map) {
            FlutterContainer flutterContainer = new FlutterContainer();
            flutterContainer.setPages((List) map.get("pages"));
            return flutterContainer;
        }

        public List<FlutterPage> getPages() {
            return this.pages;
        }

        public void setPages(List<FlutterPage> list) {
            this.pages = list;
        }

        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("pages", this.pages);
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlutterPage {
        private Map<String, Object> arguments;
        private String pageName;
        private String uniqueId;
        private Boolean withContainer;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {
            private Map<String, Object> arguments;
            private String pageName;
            private String uniqueId;
            private Boolean withContainer;

            public FlutterPage build() {
                FlutterPage flutterPage = new FlutterPage();
                flutterPage.setWithContainer(this.withContainer);
                flutterPage.setPageName(this.pageName);
                flutterPage.setUniqueId(this.uniqueId);
                flutterPage.setArguments(this.arguments);
                return flutterPage;
            }

            public Builder setArguments(Map<String, Object> map) {
                this.arguments = map;
                return this;
            }

            public Builder setPageName(String str) {
                this.pageName = str;
                return this;
            }

            public Builder setUniqueId(String str) {
                this.uniqueId = str;
                return this;
            }

            public Builder setWithContainer(Boolean bool) {
                this.withContainer = bool;
                return this;
            }
        }

        public static FlutterPage fromMap(Map<String, Object> map) {
            FlutterPage flutterPage = new FlutterPage();
            flutterPage.setWithContainer((Boolean) map.get("withContainer"));
            flutterPage.setPageName((String) map.get("pageName"));
            flutterPage.setUniqueId((String) map.get("uniqueId"));
            flutterPage.setArguments((Map) map.get("arguments"));
            return flutterPage;
        }

        public Map<String, Object> getArguments() {
            return this.arguments;
        }

        public String getPageName() {
            return this.pageName;
        }

        public String getUniqueId() {
            return this.uniqueId;
        }

        public Boolean getWithContainer() {
            return this.withContainer;
        }

        public void setArguments(Map<String, Object> map) {
            this.arguments = map;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public void setUniqueId(String str) {
            this.uniqueId = str;
        }

        public void setWithContainer(Boolean bool) {
            this.withContainer = bool;
        }

        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("withContainer", this.withContainer);
            map.put("pageName", this.pageName);
            map.put("uniqueId", this.uniqueId);
            map.put("arguments", this.arguments);
            return map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlutterRouterApi {
        private final BinaryMessenger binaryMessenger;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public interface Reply<T> {
            void reply(T t6);
        }

        public FlutterRouterApi(BinaryMessenger binaryMessenger) {
            this.binaryMessenger = binaryMessenger;
        }

        public static MessageCodec<Object> getCodec() {
            return FlutterRouterApiCodec.INSTANCE;
        }

        public void onBackPressed(Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onBackPressed", getCodec()).send(null, new f(reply, 7));
        }

        public void onBackground(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onBackground", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 8));
        }

        public void onContainerHide(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 9));
        }

        public void onContainerShow(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 6));
        }

        public void onForeground(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onForeground", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 5));
        }

        public void onNativeResult(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 0));
        }

        public void popRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.popRoute", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 3));
        }

        public void pushRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 2));
        }

        public void removeRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 4));
        }

        public void sendEventToFlutter(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", getCodec()).send(new ArrayList(Arrays.asList(commonParams)), new f(reply, 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlutterRouterApiCodec extends StandardMessageCodec {
        public static final FlutterRouterApiCodec INSTANCE = new FlutterRouterApiCodec();

        private FlutterRouterApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            return b != -128 ? super.readValueOfType(b, byteBuffer) : CommonParams.fromMap((Map) readValue(byteBuffer));
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof CommonParams)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CommonParams) obj).toMap());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface NativeRouterApi {
        static MessageCodec<Object> getCodec() {
            return NativeRouterApiCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$0(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
            HashMap map = new HashMap();
            try {
                CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                if (commonParams == null) {
                    throw new NullPointerException("paramArg unexpectedly null.");
                }
                nativeRouterApi.pushNativeRoute(commonParams);
                map.put("result", null);
                reply.reply(map);
            } catch (Error e) {
                e = e;
                map.put("error", Messages.wrapError(e));
            } catch (RuntimeException e6) {
                e = e6;
                map.put("error", Messages.wrapError(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$1(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
            HashMap map = new HashMap();
            try {
                CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                if (commonParams == null) {
                    throw new NullPointerException("paramArg unexpectedly null.");
                }
                nativeRouterApi.pushFlutterRoute(commonParams);
                map.put("result", null);
                reply.reply(map);
            } catch (Error e) {
                e = e;
                map.put("error", Messages.wrapError(e));
            } catch (RuntimeException e6) {
                e = e6;
                map.put("error", Messages.wrapError(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$2(NativeRouterApi nativeRouterApi, Object obj, final BasicMessageChannel.Reply reply) {
            final HashMap map = new HashMap();
            try {
                CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                if (commonParams == null) {
                    throw new NullPointerException("paramArg unexpectedly null.");
                }
                nativeRouterApi.popRoute(commonParams, new Result<Void>() { // from class: com.idlefish.flutterboost.Messages.NativeRouterApi.1
                    @Override // com.idlefish.flutterboost.Messages.Result
                    public void error(Throwable th) {
                        map.put("error", Messages.wrapError(th));
                        reply.reply(map);
                    }

                    @Override // com.idlefish.flutterboost.Messages.Result
                    public void success(Void r6) {
                        map.put("result", null);
                        reply.reply(map);
                    }
                });
            } catch (Error e) {
                e = e;
                map.put("error", Messages.wrapError(e));
                reply.reply(map);
            } catch (RuntimeException e6) {
                e = e6;
                map.put("error", Messages.wrapError(e));
                reply.reply(map);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$3(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
            HashMap map = new HashMap();
            try {
                map.put("result", nativeRouterApi.getStackFromHost());
            } catch (Error | RuntimeException e) {
                map.put("error", Messages.wrapError(e));
            }
            reply.reply(map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$4(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
            HashMap map = new HashMap();
            try {
                StackInfo stackInfo = (StackInfo) ((ArrayList) obj).get(0);
                if (stackInfo == null) {
                    throw new NullPointerException("stackArg unexpectedly null.");
                }
                nativeRouterApi.saveStackToHost(stackInfo);
                map.put("result", null);
                reply.reply(map);
            } catch (Error e) {
                e = e;
                map.put("error", Messages.wrapError(e));
            } catch (RuntimeException e6) {
                e = e6;
                map.put("error", Messages.wrapError(e));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setup$5(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
            HashMap map = new HashMap();
            try {
                CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                if (commonParams == null) {
                    throw new NullPointerException("paramsArg unexpectedly null.");
                }
                nativeRouterApi.sendEventToNative(commonParams);
                map.put("result", null);
                reply.reply(map);
            } catch (Error e) {
                e = e;
                map.put("error", Messages.wrapError(e));
            } catch (RuntimeException e6) {
                e = e6;
                map.put("error", Messages.wrapError(e));
            }
        }

        static void setup(BinaryMessenger binaryMessenger, final NativeRouterApi nativeRouterApi) {
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushNativeRoute", getCodec());
            if (nativeRouterApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushFlutterRoute", getCodec());
            if (nativeRouterApi != null) {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.popRoute", getCodec());
            if (nativeRouterApi != null) {
                final int i7 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.getStackFromHost", getCodec());
            if (nativeRouterApi != null) {
                final int i8 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.saveStackToHost", getCodec());
            if (nativeRouterApi != null) {
                final int i9 = 4;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.sendEventToNative", getCodec());
            if (nativeRouterApi == null) {
                basicMessageChannel6.setMessageHandler(null);
            } else {
                final int i10 = 5;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler(nativeRouterApi) { // from class: com.idlefish.flutterboost.g
                    public final /* synthetic */ Messages.NativeRouterApi b;

                    {
                        this.b = nativeRouterApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                Messages.NativeRouterApi.lambda$setup$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.NativeRouterApi.lambda$setup$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.NativeRouterApi.lambda$setup$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.NativeRouterApi.lambda$setup$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.NativeRouterApi.lambda$setup$4(this.b, obj, reply);
                                break;
                            default:
                                Messages.NativeRouterApi.lambda$setup$5(this.b, obj, reply);
                                break;
                        }
                    }
                });
            }
        }

        StackInfo getStackFromHost();

        void popRoute(CommonParams commonParams, Result<Void> result);

        void pushFlutterRoute(CommonParams commonParams);

        void pushNativeRoute(CommonParams commonParams);

        void saveStackToHost(StackInfo stackInfo);

        void sendEventToNative(CommonParams commonParams);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class NativeRouterApiCodec extends StandardMessageCodec {
        public static final NativeRouterApiCodec INSTANCE = new NativeRouterApiCodec();

        private NativeRouterApiCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case -128:
                    return CommonParams.fromMap((Map) readValue(byteBuffer));
                case -127:
                    return FlutterContainer.fromMap((Map) readValue(byteBuffer));
                case -126:
                    return FlutterPage.fromMap((Map) readValue(byteBuffer));
                case -125:
                    return StackInfo.fromMap((Map) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CommonParams) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CommonParams) obj).toMap());
                return;
            }
            if (obj instanceof FlutterContainer) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((FlutterContainer) obj).toMap());
            } else if (obj instanceof FlutterPage) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((FlutterPage) obj).toMap());
            } else if (!(obj instanceof StackInfo)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((StackInfo) obj).toMap());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Result<T> {
        void error(Throwable th);

        void success(T t6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class StackInfo {
        private Map<String, FlutterContainer> containers;
        private List<String> ids;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {
            private Map<String, FlutterContainer> containers;
            private List<String> ids;

            public StackInfo build() {
                StackInfo stackInfo = new StackInfo();
                stackInfo.setIds(this.ids);
                stackInfo.setContainers(this.containers);
                return stackInfo;
            }

            public Builder setContainers(Map<String, FlutterContainer> map) {
                this.containers = map;
                return this;
            }

            public Builder setIds(List<String> list) {
                this.ids = list;
                return this;
            }
        }

        public static StackInfo fromMap(Map<String, Object> map) {
            StackInfo stackInfo = new StackInfo();
            stackInfo.setIds((List) map.get("ids"));
            stackInfo.setContainers((Map) map.get("containers"));
            return stackInfo;
        }

        public Map<String, FlutterContainer> getContainers() {
            return this.containers;
        }

        public List<String> getIds() {
            return this.ids;
        }

        public void setContainers(Map<String, FlutterContainer> map) {
            this.containers = map;
        }

        public void setIds(List<String> list) {
            this.ids = list;
        }

        public Map<String, Object> toMap() {
            HashMap map = new HashMap();
            map.put("ids", this.ids);
            map.put("containers", this.containers);
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> wrapError(Throwable th) {
        HashMap map = new HashMap();
        map.put(Constants.MESSAGE, th.toString());
        map.put("code", th.getClass().getSimpleName());
        map.put("details", "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return map;
    }
}
