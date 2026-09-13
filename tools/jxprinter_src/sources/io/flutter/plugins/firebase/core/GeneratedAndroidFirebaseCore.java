package io.flutter.plugins.firebase.core;

import A3.AbstractC0157z;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class GeneratedAndroidFirebaseCore {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CoreFirebaseOptions {

        @Nullable
        private String androidClientId;

        @NonNull
        private String apiKey;

        @Nullable
        private String appGroupId;

        @NonNull
        private String appId;

        @Nullable
        private String authDomain;

        @Nullable
        private String databaseURL;

        @Nullable
        private String deepLinkURLScheme;

        @Nullable
        private String iosBundleId;

        @Nullable
        private String iosClientId;

        @Nullable
        private String measurementId;

        @NonNull
        private String messagingSenderId;

        @NonNull
        private String projectId;

        @Nullable
        private String storageBucket;

        @Nullable
        private String trackingId;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private String androidClientId;

            @Nullable
            private String apiKey;

            @Nullable
            private String appGroupId;

            @Nullable
            private String appId;

            @Nullable
            private String authDomain;

            @Nullable
            private String databaseURL;

            @Nullable
            private String deepLinkURLScheme;

            @Nullable
            private String iosBundleId;

            @Nullable
            private String iosClientId;

            @Nullable
            private String measurementId;

            @Nullable
            private String messagingSenderId;

            @Nullable
            private String projectId;

            @Nullable
            private String storageBucket;

            @Nullable
            private String trackingId;

            @NonNull
            public CoreFirebaseOptions build() {
                CoreFirebaseOptions coreFirebaseOptions = new CoreFirebaseOptions();
                coreFirebaseOptions.setApiKey(this.apiKey);
                coreFirebaseOptions.setAppId(this.appId);
                coreFirebaseOptions.setMessagingSenderId(this.messagingSenderId);
                coreFirebaseOptions.setProjectId(this.projectId);
                coreFirebaseOptions.setAuthDomain(this.authDomain);
                coreFirebaseOptions.setDatabaseURL(this.databaseURL);
                coreFirebaseOptions.setStorageBucket(this.storageBucket);
                coreFirebaseOptions.setMeasurementId(this.measurementId);
                coreFirebaseOptions.setTrackingId(this.trackingId);
                coreFirebaseOptions.setDeepLinkURLScheme(this.deepLinkURLScheme);
                coreFirebaseOptions.setAndroidClientId(this.androidClientId);
                coreFirebaseOptions.setIosClientId(this.iosClientId);
                coreFirebaseOptions.setIosBundleId(this.iosBundleId);
                coreFirebaseOptions.setAppGroupId(this.appGroupId);
                return coreFirebaseOptions;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAndroidClientId(@Nullable String str) {
                this.androidClientId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setApiKey(@NonNull String str) {
                this.apiKey = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAppGroupId(@Nullable String str) {
                this.appGroupId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAppId(@NonNull String str) {
                this.appId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAuthDomain(@Nullable String str) {
                this.authDomain = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setDatabaseURL(@Nullable String str) {
                this.databaseURL = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setDeepLinkURLScheme(@Nullable String str) {
                this.deepLinkURLScheme = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setIosBundleId(@Nullable String str) {
                this.iosBundleId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setIosClientId(@Nullable String str) {
                this.iosClientId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setMeasurementId(@Nullable String str) {
                this.measurementId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setMessagingSenderId(@NonNull String str) {
                this.messagingSenderId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setProjectId(@NonNull String str) {
                this.projectId = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setStorageBucket(@Nullable String str) {
                this.storageBucket = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setTrackingId(@Nullable String str) {
                this.trackingId = str;
                return this;
            }
        }

        @NonNull
        public static CoreFirebaseOptions fromList(@NonNull ArrayList<Object> arrayList) {
            CoreFirebaseOptions coreFirebaseOptions = new CoreFirebaseOptions();
            coreFirebaseOptions.setApiKey((String) arrayList.get(0));
            coreFirebaseOptions.setAppId((String) arrayList.get(1));
            coreFirebaseOptions.setMessagingSenderId((String) arrayList.get(2));
            coreFirebaseOptions.setProjectId((String) arrayList.get(3));
            coreFirebaseOptions.setAuthDomain((String) arrayList.get(4));
            coreFirebaseOptions.setDatabaseURL((String) arrayList.get(5));
            coreFirebaseOptions.setStorageBucket((String) arrayList.get(6));
            coreFirebaseOptions.setMeasurementId((String) arrayList.get(7));
            coreFirebaseOptions.setTrackingId((String) arrayList.get(8));
            coreFirebaseOptions.setDeepLinkURLScheme((String) arrayList.get(9));
            coreFirebaseOptions.setAndroidClientId((String) arrayList.get(10));
            coreFirebaseOptions.setIosClientId((String) arrayList.get(11));
            coreFirebaseOptions.setIosBundleId((String) arrayList.get(12));
            coreFirebaseOptions.setAppGroupId((String) arrayList.get(13));
            return coreFirebaseOptions;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CoreFirebaseOptions.class == obj.getClass()) {
                CoreFirebaseOptions coreFirebaseOptions = (CoreFirebaseOptions) obj;
                if (this.apiKey.equals(coreFirebaseOptions.apiKey) && this.appId.equals(coreFirebaseOptions.appId) && this.messagingSenderId.equals(coreFirebaseOptions.messagingSenderId) && this.projectId.equals(coreFirebaseOptions.projectId) && Objects.equals(this.authDomain, coreFirebaseOptions.authDomain) && Objects.equals(this.databaseURL, coreFirebaseOptions.databaseURL) && Objects.equals(this.storageBucket, coreFirebaseOptions.storageBucket) && Objects.equals(this.measurementId, coreFirebaseOptions.measurementId) && Objects.equals(this.trackingId, coreFirebaseOptions.trackingId) && Objects.equals(this.deepLinkURLScheme, coreFirebaseOptions.deepLinkURLScheme) && Objects.equals(this.androidClientId, coreFirebaseOptions.androidClientId) && Objects.equals(this.iosClientId, coreFirebaseOptions.iosClientId) && Objects.equals(this.iosBundleId, coreFirebaseOptions.iosBundleId) && Objects.equals(this.appGroupId, coreFirebaseOptions.appGroupId)) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public String getAndroidClientId() {
            return this.androidClientId;
        }

        @NonNull
        public String getApiKey() {
            return this.apiKey;
        }

        @Nullable
        public String getAppGroupId() {
            return this.appGroupId;
        }

        @NonNull
        public String getAppId() {
            return this.appId;
        }

        @Nullable
        public String getAuthDomain() {
            return this.authDomain;
        }

        @Nullable
        public String getDatabaseURL() {
            return this.databaseURL;
        }

        @Nullable
        public String getDeepLinkURLScheme() {
            return this.deepLinkURLScheme;
        }

        @Nullable
        public String getIosBundleId() {
            return this.iosBundleId;
        }

        @Nullable
        public String getIosClientId() {
            return this.iosClientId;
        }

        @Nullable
        public String getMeasurementId() {
            return this.measurementId;
        }

        @NonNull
        public String getMessagingSenderId() {
            return this.messagingSenderId;
        }

        @NonNull
        public String getProjectId() {
            return this.projectId;
        }

        @Nullable
        public String getStorageBucket() {
            return this.storageBucket;
        }

        @Nullable
        public String getTrackingId() {
            return this.trackingId;
        }

        public int hashCode() {
            return Objects.hash(this.apiKey, this.appId, this.messagingSenderId, this.projectId, this.authDomain, this.databaseURL, this.storageBucket, this.measurementId, this.trackingId, this.deepLinkURLScheme, this.androidClientId, this.iosClientId, this.iosBundleId, this.appGroupId);
        }

        public void setAndroidClientId(@Nullable String str) {
            this.androidClientId = str;
        }

        public void setApiKey(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"apiKey\" is null.");
            }
            this.apiKey = str;
        }

        public void setAppGroupId(@Nullable String str) {
            this.appGroupId = str;
        }

        public void setAppId(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"appId\" is null.");
            }
            this.appId = str;
        }

        public void setAuthDomain(@Nullable String str) {
            this.authDomain = str;
        }

        public void setDatabaseURL(@Nullable String str) {
            this.databaseURL = str;
        }

        public void setDeepLinkURLScheme(@Nullable String str) {
            this.deepLinkURLScheme = str;
        }

        public void setIosBundleId(@Nullable String str) {
            this.iosBundleId = str;
        }

        public void setIosClientId(@Nullable String str) {
            this.iosClientId = str;
        }

        public void setMeasurementId(@Nullable String str) {
            this.measurementId = str;
        }

        public void setMessagingSenderId(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"messagingSenderId\" is null.");
            }
            this.messagingSenderId = str;
        }

        public void setProjectId(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"projectId\" is null.");
            }
            this.projectId = str;
        }

        public void setStorageBucket(@Nullable String str) {
            this.storageBucket = str;
        }

        public void setTrackingId(@Nullable String str) {
            this.trackingId = str;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(14);
            arrayList.add(this.apiKey);
            arrayList.add(this.appId);
            arrayList.add(this.messagingSenderId);
            arrayList.add(this.projectId);
            arrayList.add(this.authDomain);
            arrayList.add(this.databaseURL);
            arrayList.add(this.storageBucket);
            arrayList.add(this.measurementId);
            arrayList.add(this.trackingId);
            arrayList.add(this.deepLinkURLScheme);
            arrayList.add(this.androidClientId);
            arrayList.add(this.iosClientId);
            arrayList.add(this.iosBundleId);
            arrayList.add(this.appGroupId);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class CoreInitializeResponse {

        @Nullable
        private Boolean isAutomaticDataCollectionEnabled;

        @NonNull
        private String name;

        @NonNull
        private CoreFirebaseOptions options;

        @NonNull
        private Map<String, Object> pluginConstants;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private Boolean isAutomaticDataCollectionEnabled;

            @Nullable
            private String name;

            @Nullable
            private CoreFirebaseOptions options;

            @Nullable
            private Map<String, Object> pluginConstants;

            @NonNull
            public CoreInitializeResponse build() {
                CoreInitializeResponse coreInitializeResponse = new CoreInitializeResponse();
                coreInitializeResponse.setName(this.name);
                coreInitializeResponse.setOptions(this.options);
                coreInitializeResponse.setIsAutomaticDataCollectionEnabled(this.isAutomaticDataCollectionEnabled);
                coreInitializeResponse.setPluginConstants(this.pluginConstants);
                return coreInitializeResponse;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setIsAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
                this.isAutomaticDataCollectionEnabled = bool;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setName(@NonNull String str) {
                this.name = str;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setOptions(@NonNull CoreFirebaseOptions coreFirebaseOptions) {
                this.options = coreFirebaseOptions;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setPluginConstants(@NonNull Map<String, Object> map) {
                this.pluginConstants = map;
                return this;
            }
        }

        @NonNull
        public static CoreInitializeResponse fromList(@NonNull ArrayList<Object> arrayList) {
            CoreInitializeResponse coreInitializeResponse = new CoreInitializeResponse();
            coreInitializeResponse.setName((String) arrayList.get(0));
            coreInitializeResponse.setOptions((CoreFirebaseOptions) arrayList.get(1));
            coreInitializeResponse.setIsAutomaticDataCollectionEnabled((Boolean) arrayList.get(2));
            coreInitializeResponse.setPluginConstants((Map) arrayList.get(3));
            return coreInitializeResponse;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CoreInitializeResponse.class == obj.getClass()) {
                CoreInitializeResponse coreInitializeResponse = (CoreInitializeResponse) obj;
                if (this.name.equals(coreInitializeResponse.name) && this.options.equals(coreInitializeResponse.options) && Objects.equals(this.isAutomaticDataCollectionEnabled, coreInitializeResponse.isAutomaticDataCollectionEnabled) && this.pluginConstants.equals(coreInitializeResponse.pluginConstants)) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public Boolean getIsAutomaticDataCollectionEnabled() {
            return this.isAutomaticDataCollectionEnabled;
        }

        @NonNull
        public String getName() {
            return this.name;
        }

        @NonNull
        public CoreFirebaseOptions getOptions() {
            return this.options;
        }

        @NonNull
        public Map<String, Object> getPluginConstants() {
            return this.pluginConstants;
        }

        public int hashCode() {
            return Objects.hash(this.name, this.options, this.isAutomaticDataCollectionEnabled, this.pluginConstants);
        }

        public void setIsAutomaticDataCollectionEnabled(@Nullable Boolean bool) {
            this.isAutomaticDataCollectionEnabled = bool;
        }

        public void setName(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.name = str;
        }

        public void setOptions(@NonNull CoreFirebaseOptions coreFirebaseOptions) {
            if (coreFirebaseOptions == null) {
                throw new IllegalStateException("Nonnull field \"options\" is null.");
            }
            this.options = coreFirebaseOptions;
        }

        public void setPluginConstants(@NonNull Map<String, Object> map) {
            if (map == null) {
                throw new IllegalStateException("Nonnull field \"pluginConstants\" is null.");
            }
            this.pluginConstants = map;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(4);
            arrayList.add(this.name);
            arrayList.add(this.options);
            arrayList.add(this.isAutomaticDataCollectionEnabled);
            arrayList.add(this.pluginConstants);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface FirebaseAppHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(FirebaseAppHostApi firebaseAppHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAppHostApi.setAutomaticDataCollectionEnabled((String) arrayList2.get(0), (Boolean) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.1
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(FirebaseAppHostApi firebaseAppHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseAppHostApi.setAutomaticResourceManagementEnabled((String) arrayList2.get(0), (Boolean) arrayList2.get(1), new VoidResult() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.2
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(FirebaseAppHostApi firebaseAppHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseAppHostApi.delete((String) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseAppHostApi.3
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable FirebaseAppHostApi firebaseAppHostApi) {
            setUp(binaryMessenger, "", firebaseAppHostApi);
        }

        void delete(@NonNull String str, @NonNull VoidResult voidResult);

        void setAutomaticDataCollectionEnabled(@NonNull String str, @NonNull Boolean bool, @NonNull VoidResult voidResult);

        void setAutomaticResourceManagementEnabled(@NonNull String str, @NonNull Boolean bool, @NonNull VoidResult voidResult);

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @Nullable final FirebaseAppHostApi firebaseAppHostApi) {
            String strConcat = str.isEmpty() ? "" : Consts.DOT.concat(str);
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticDataCollectionEnabled", strConcat), getCodec());
            if (firebaseAppHostApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseAppHostApi) { // from class: io.flutter.plugins.firebase.core.c
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi b;

                    {
                        this.b = firebaseAppHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.setAutomaticResourceManagementEnabled", strConcat), getCodec());
            if (firebaseAppHostApi != null) {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseAppHostApi) { // from class: io.flutter.plugins.firebase.core.c
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi b;

                    {
                        this.b = firebaseAppHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseAppHostApi.delete", strConcat), getCodec());
            if (firebaseAppHostApi == null) {
                basicMessageChannel3.setMessageHandler(null);
            } else {
                final int i7 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseAppHostApi) { // from class: io.flutter.plugins.firebase.core.c
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseAppHostApi b;

                    {
                        this.b = firebaseAppHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseAppHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface FirebaseCoreHostApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            firebaseCoreHostApi.initializeApp((String) arrayList2.get(0), (CoreFirebaseOptions) arrayList2.get(1), new Result<CoreInitializeResponse>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.1
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void success(CoreInitializeResponse coreInitializeResponse) {
                    arrayList.add(0, coreInitializeResponse);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseCoreHostApi.initializeCore(new Result<List<CoreInitializeResponse>>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.2
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void success(List<CoreInitializeResponse> list) {
                    arrayList.add(0, list);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(FirebaseCoreHostApi firebaseCoreHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            firebaseCoreHostApi.optionsFromResource(new Result<CoreFirebaseOptions>() { // from class: io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.3
                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void error(Throwable th) {
                    reply.reply(GeneratedAndroidFirebaseCore.wrapError(th));
                }

                @Override // io.flutter.plugins.firebase.core.GeneratedAndroidFirebaseCore.Result
                public void success(CoreFirebaseOptions coreFirebaseOptions) {
                    arrayList.add(0, coreFirebaseOptions);
                    reply.reply(arrayList);
                }
            });
        }

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable FirebaseCoreHostApi firebaseCoreHostApi) {
            setUp(binaryMessenger, "", firebaseCoreHostApi);
        }

        void initializeApp(@NonNull String str, @NonNull CoreFirebaseOptions coreFirebaseOptions, @NonNull Result<CoreInitializeResponse> result);

        void initializeCore(@NonNull Result<List<CoreInitializeResponse>> result);

        void optionsFromResource(@NonNull Result<CoreFirebaseOptions> result);

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @Nullable final FirebaseCoreHostApi firebaseCoreHostApi) {
            String strConcat = str.isEmpty() ? "" : Consts.DOT.concat(str);
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeApp", strConcat), getCodec());
            if (firebaseCoreHostApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseCoreHostApi) { // from class: io.flutter.plugins.firebase.core.d
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi b;

                    {
                        this.b = firebaseCoreHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.initializeCore", strConcat), getCodec());
            if (firebaseCoreHostApi != null) {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseCoreHostApi) { // from class: io.flutter.plugins.firebase.core.d
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi b;

                    {
                        this.b = firebaseCoreHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_core_platform_interface.FirebaseCoreHostApi.optionsFromResource", strConcat), getCodec());
            if (firebaseCoreHostApi == null) {
                basicMessageChannel3.setMessageHandler(null);
            } else {
                final int i7 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(firebaseCoreHostApi) { // from class: io.flutter.plugins.firebase.core.d
                    public final /* synthetic */ GeneratedAndroidFirebaseCore.FirebaseCoreHostApi b;

                    {
                        this.b = firebaseCoreHostApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            default:
                                GeneratedAndroidFirebaseCore.FirebaseCoreHostApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class FlutterError extends RuntimeException {
        public final String code;
        public final Object details;

        public FlutterError(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
            super(str2);
            this.code = str;
            this.details = obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface NullableResult<T> {
        void error(@NonNull Throwable th);

        void success(@Nullable T t6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            if (b != -127) {
                return b != -126 ? super.readValueOfType(b, byteBuffer) : CoreInitializeResponse.fromList((ArrayList) readValue(byteBuffer));
            }
            return CoreFirebaseOptions.fromList((ArrayList) readValue(byteBuffer));
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CoreFirebaseOptions) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((CoreFirebaseOptions) obj).toList());
            } else if (!(obj instanceof CoreInitializeResponse)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((CoreInitializeResponse) obj).toList());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Result<T> {
        void error(@NonNull Throwable th);

        void success(@NonNull T t6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface VoidResult {
        void error(@NonNull Throwable th);

        void success();
    }

    @NonNull
    public static ArrayList<Object> wrapError(@NonNull Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof FlutterError) {
            FlutterError flutterError = (FlutterError) th;
            arrayList.add(flutterError.code);
            arrayList.add(flutterError.getMessage());
            arrayList.add(flutterError.details);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}
