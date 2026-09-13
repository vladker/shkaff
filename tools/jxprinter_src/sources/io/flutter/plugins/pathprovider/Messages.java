package io.flutter.plugins.pathprovider;

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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Messages {

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
    public interface PathProviderApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getTemporaryPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationSupportPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationDocumentsPath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getApplicationCachePath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$4(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getExternalStoragePath());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$5(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getExternalCachePaths());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$6(PathProviderApi pathProviderApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, pathProviderApi.getExternalStoragePaths((StorageDirectory) ((ArrayList) obj).get(0)));
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable PathProviderApi pathProviderApi) {
            setUp(binaryMessenger, "", pathProviderApi);
        }

        @Nullable
        String getApplicationCachePath();

        @Nullable
        String getApplicationDocumentsPath();

        @Nullable
        String getApplicationSupportPath();

        @NonNull
        List<String> getExternalCachePaths();

        @Nullable
        String getExternalStoragePath();

        @NonNull
        List<String> getExternalStoragePaths(@NonNull StorageDirectory storageDirectory);

        @Nullable
        String getTemporaryPath();

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @Nullable final PathProviderApi pathProviderApi) {
            String strConcat = str.isEmpty() ? "" : Consts.DOT.concat(str);
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getTemporaryPath", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationSupportPath", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i6 = 1;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationDocumentsPath", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i7 = 2;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getApplicationCachePath", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i8 = 3;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePath", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i9 = 4;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalCachePaths", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi != null) {
                final int i10 = 5;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.path_provider_android.PathProviderApi.getExternalStoragePaths", strConcat), getCodec(), binaryMessenger.makeBackgroundTaskQueue());
            if (pathProviderApi == null) {
                basicMessageChannel7.setMessageHandler(null);
            } else {
                final int i11 = 6;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler(pathProviderApi) { // from class: io.flutter.plugins.pathprovider.a
                    public final /* synthetic */ Messages.PathProviderApi b;

                    {
                        this.b = pathProviderApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i11) {
                            case 0:
                                Messages.PathProviderApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.PathProviderApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.PathProviderApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.PathProviderApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.PathProviderApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.PathProviderApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            default:
                                Messages.PathProviderApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PigeonCodec extends StandardMessageCodec {
        public static final PigeonCodec INSTANCE = new PigeonCodec();

        private PigeonCodec() {
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public Object readValueOfType(byte b, @NonNull ByteBuffer byteBuffer) {
            if (b != -127) {
                return super.readValueOfType(b, byteBuffer);
            }
            Object value = readValue(byteBuffer);
            if (value == null) {
                return null;
            }
            return StorageDirectory.values()[((Long) value).intValue()];
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (!(obj instanceof StorageDirectory)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, Integer.valueOf(((StorageDirectory) obj).index));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum StorageDirectory {
        ROOT(0),
        MUSIC(1),
        PODCASTS(2),
        RINGTONES(3),
        ALARMS(4),
        NOTIFICATIONS(5),
        PICTURES(6),
        MOVIES(7),
        DOWNLOADS(8),
        DCIM(9),
        DOCUMENTS(10);

        final int index;

        StorageDirectory(int i5) {
            this.index = i5;
        }
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
