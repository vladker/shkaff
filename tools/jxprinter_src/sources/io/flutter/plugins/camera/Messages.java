package io.flutter.plugins.camera;

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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class Messages {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface CameraApi {
        @NonNull
        static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$0(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getAvailableCameras());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$1(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = (ArrayList) obj;
            cameraApi.create((String) arrayList2.get(0), (PlatformMediaSettings) arrayList2.get(1), new Result<Long>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.1
                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(Long l6) {
                    arrayList.add(0, l6);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$10(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.resumeVideoRecording();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$11(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.startImageStream();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$12(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.stopImageStream();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$13(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setFlashMode((PlatformFlashMode) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.3
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$14(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposureMode((PlatformExposureMode) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.4
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$15(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposurePoint((PlatformPoint) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.5
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$16(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMinExposureOffset());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$17(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMaxExposureOffset());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$18(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getExposureOffsetStepSize());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$19(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setExposureOffset((Double) ((ArrayList) obj).get(0), new Result<Double>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.6
                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(Double d) {
                    arrayList.add(0, d);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$2(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.initialize((PlatformImageFormatGroup) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$20(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.setFocusMode((PlatformFocusMode) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$21(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setFocusPoint((PlatformPoint) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.7
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$22(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMaxZoomLevel());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$23(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.getMinZoomLevel());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$24(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.setZoomLevel((Double) ((ArrayList) obj).get(0), new VoidResult() { // from class: io.flutter.plugins.camera.Messages.CameraApi.8
                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.VoidResult
                public void success() {
                    arrayList.add(0, null);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$25(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.pausePreview();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$26(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.resumePreview();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$27(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.setDescriptionWhileRecording((String) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$3(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.dispose();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$4(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.lockCaptureOrientation((PlatformDeviceOrientation) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$5(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.unlockCaptureOrientation();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$6(CameraApi cameraApi, Object obj, final BasicMessageChannel.Reply reply) {
            final ArrayList arrayList = new ArrayList();
            cameraApi.takePicture(new Result<String>() { // from class: io.flutter.plugins.camera.Messages.CameraApi.2
                @Override // io.flutter.plugins.camera.Messages.Result
                public void error(Throwable th) {
                    reply.reply(Messages.wrapError(th));
                }

                @Override // io.flutter.plugins.camera.Messages.Result
                public void success(String str) {
                    arrayList.add(0, str);
                    reply.reply(arrayList);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$7(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.startVideoRecording((Boolean) ((ArrayList) obj).get(0));
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$8(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                arrayList.add(0, cameraApi.stopVideoRecording());
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        static /* synthetic */ void lambda$setUp$9(CameraApi cameraApi, Object obj, BasicMessageChannel.Reply reply) {
            ArrayList<Object> arrayList = new ArrayList<>();
            try {
                cameraApi.pauseVideoRecording();
                arrayList.add(0, null);
            } catch (Throwable th) {
                arrayList = Messages.wrapError(th);
            }
            reply.reply(arrayList);
        }

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @Nullable CameraApi cameraApi) {
            setUp(binaryMessenger, "", cameraApi);
        }

        void create(@NonNull String str, @NonNull PlatformMediaSettings platformMediaSettings, @NonNull Result<Long> result);

        void dispose();

        @NonNull
        List<PlatformCameraDescription> getAvailableCameras();

        @NonNull
        Double getExposureOffsetStepSize();

        @NonNull
        Double getMaxExposureOffset();

        @NonNull
        Double getMaxZoomLevel();

        @NonNull
        Double getMinExposureOffset();

        @NonNull
        Double getMinZoomLevel();

        void initialize(@NonNull PlatformImageFormatGroup platformImageFormatGroup);

        void lockCaptureOrientation(@NonNull PlatformDeviceOrientation platformDeviceOrientation);

        void pausePreview();

        void pauseVideoRecording();

        void resumePreview();

        void resumeVideoRecording();

        void setDescriptionWhileRecording(@NonNull String str);

        void setExposureMode(@NonNull PlatformExposureMode platformExposureMode, @NonNull VoidResult voidResult);

        void setExposureOffset(@NonNull Double d, @NonNull Result<Double> result);

        void setExposurePoint(@Nullable PlatformPoint platformPoint, @NonNull VoidResult voidResult);

        void setFlashMode(@NonNull PlatformFlashMode platformFlashMode, @NonNull VoidResult voidResult);

        void setFocusMode(@NonNull PlatformFocusMode platformFocusMode);

        void setFocusPoint(@Nullable PlatformPoint platformPoint, @NonNull VoidResult voidResult);

        void setZoomLevel(@NonNull Double d, @NonNull VoidResult voidResult);

        void startImageStream();

        void startVideoRecording(@NonNull Boolean bool);

        void stopImageStream();

        @NonNull
        String stopVideoRecording();

        void takePicture(@NonNull Result<String> result);

        void unlockCaptureOrientation();

        static void setUp(@NonNull BinaryMessenger binaryMessenger, @NonNull String str, @Nullable final CameraApi cameraApi) {
            String strConcat = str.isEmpty() ? "" : Consts.DOT.concat(str);
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getAvailableCameras", strConcat), getCodec());
            if (cameraApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.create", strConcat), getCodec());
            if (cameraApi != null) {
                final int i6 = 2;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.initialize", strConcat), getCodec());
            if (cameraApi != null) {
                final int i7 = 12;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.dispose", strConcat), getCodec());
            if (cameraApi != null) {
                final int i8 = 13;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.lockCaptureOrientation", strConcat), getCodec());
            if (cameraApi != null) {
                final int i9 = 14;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.unlockCaptureOrientation", strConcat), getCodec());
            if (cameraApi != null) {
                final int i10 = 15;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.takePicture", strConcat), getCodec());
            if (cameraApi != null) {
                final int i11 = 16;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i11) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.startVideoRecording", strConcat), getCodec());
            if (cameraApi != null) {
                final int i12 = 17;
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i12) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.stopVideoRecording", strConcat), getCodec());
            if (cameraApi != null) {
                final int i13 = 18;
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i13) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.pauseVideoRecording", strConcat), getCodec());
            if (cameraApi != null) {
                final int i14 = 19;
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i14) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.resumeVideoRecording", strConcat), getCodec());
            if (cameraApi != null) {
                final int i15 = 11;
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i15) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.startImageStream", strConcat), getCodec());
            if (cameraApi != null) {
                final int i16 = 20;
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i16) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.stopImageStream", strConcat), getCodec());
            if (cameraApi != null) {
                final int i17 = 21;
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i17) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setFlashMode", strConcat), getCodec());
            if (cameraApi != null) {
                final int i18 = 22;
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i18) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setExposureMode", strConcat), getCodec());
            if (cameraApi != null) {
                final int i19 = 23;
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i19) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setExposurePoint", strConcat), getCodec());
            if (cameraApi != null) {
                final int i20 = 24;
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i20) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getMinExposureOffset", strConcat), getCodec());
            if (cameraApi != null) {
                final int i21 = 25;
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i21) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel17.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getMaxExposureOffset", strConcat), getCodec());
            if (cameraApi != null) {
                final int i22 = 26;
                basicMessageChannel18.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i22) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel18.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getExposureOffsetStepSize", strConcat), getCodec());
            if (cameraApi != null) {
                final int i23 = 27;
                basicMessageChannel19.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i23) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel19.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setExposureOffset", strConcat), getCodec());
            if (cameraApi != null) {
                final int i24 = 1;
                basicMessageChannel20.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i24) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel20.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setFocusMode", strConcat), getCodec());
            if (cameraApi != null) {
                final int i25 = 3;
                basicMessageChannel21.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i25) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel21.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setFocusPoint", strConcat), getCodec());
            if (cameraApi != null) {
                final int i26 = 4;
                basicMessageChannel22.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i26) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel22.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel23 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getMaxZoomLevel", strConcat), getCodec());
            if (cameraApi != null) {
                final int i27 = 5;
                basicMessageChannel23.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i27) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel23.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel24 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.getMinZoomLevel", strConcat), getCodec());
            if (cameraApi != null) {
                final int i28 = 6;
                basicMessageChannel24.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i28) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel24.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel25 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setZoomLevel", strConcat), getCodec());
            if (cameraApi != null) {
                final int i29 = 7;
                basicMessageChannel25.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i29) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel25.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel26 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.pausePreview", strConcat), getCodec());
            if (cameraApi != null) {
                final int i30 = 8;
                basicMessageChannel26.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i30) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel26.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel27 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.resumePreview", strConcat), getCodec());
            if (cameraApi != null) {
                final int i31 = 9;
                basicMessageChannel27.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i31) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel27.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel28 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.camera_android.CameraApi.setDescriptionWhileRecording", strConcat), getCodec());
            if (cameraApi == null) {
                basicMessageChannel28.setMessageHandler(null);
            } else {
                final int i32 = 10;
                basicMessageChannel28.setMessageHandler(new BasicMessageChannel.MessageHandler(cameraApi) { // from class: io.flutter.plugins.camera.j
                    public final /* synthetic */ Messages.CameraApi b;

                    {
                        this.b = cameraApi;
                    }

                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i32) {
                            case 0:
                                Messages.CameraApi.lambda$setUp$0(this.b, obj, reply);
                                break;
                            case 1:
                                Messages.CameraApi.lambda$setUp$19(this.b, obj, reply);
                                break;
                            case 2:
                                Messages.CameraApi.lambda$setUp$1(this.b, obj, reply);
                                break;
                            case 3:
                                Messages.CameraApi.lambda$setUp$20(this.b, obj, reply);
                                break;
                            case 4:
                                Messages.CameraApi.lambda$setUp$21(this.b, obj, reply);
                                break;
                            case 5:
                                Messages.CameraApi.lambda$setUp$22(this.b, obj, reply);
                                break;
                            case 6:
                                Messages.CameraApi.lambda$setUp$23(this.b, obj, reply);
                                break;
                            case 7:
                                Messages.CameraApi.lambda$setUp$24(this.b, obj, reply);
                                break;
                            case 8:
                                Messages.CameraApi.lambda$setUp$25(this.b, obj, reply);
                                break;
                            case 9:
                                Messages.CameraApi.lambda$setUp$26(this.b, obj, reply);
                                break;
                            case 10:
                                Messages.CameraApi.lambda$setUp$27(this.b, obj, reply);
                                break;
                            case 11:
                                Messages.CameraApi.lambda$setUp$10(this.b, obj, reply);
                                break;
                            case 12:
                                Messages.CameraApi.lambda$setUp$2(this.b, obj, reply);
                                break;
                            case 13:
                                Messages.CameraApi.lambda$setUp$3(this.b, obj, reply);
                                break;
                            case 14:
                                Messages.CameraApi.lambda$setUp$4(this.b, obj, reply);
                                break;
                            case 15:
                                Messages.CameraApi.lambda$setUp$5(this.b, obj, reply);
                                break;
                            case 16:
                                Messages.CameraApi.lambda$setUp$6(this.b, obj, reply);
                                break;
                            case 17:
                                Messages.CameraApi.lambda$setUp$7(this.b, obj, reply);
                                break;
                            case 18:
                                Messages.CameraApi.lambda$setUp$8(this.b, obj, reply);
                                break;
                            case 19:
                                Messages.CameraApi.lambda$setUp$9(this.b, obj, reply);
                                break;
                            case 20:
                                Messages.CameraApi.lambda$setUp$11(this.b, obj, reply);
                                break;
                            case 21:
                                Messages.CameraApi.lambda$setUp$12(this.b, obj, reply);
                                break;
                            case 22:
                                Messages.CameraApi.lambda$setUp$13(this.b, obj, reply);
                                break;
                            case 23:
                                Messages.CameraApi.lambda$setUp$14(this.b, obj, reply);
                                break;
                            case 24:
                                Messages.CameraApi.lambda$setUp$15(this.b, obj, reply);
                                break;
                            case 25:
                                Messages.CameraApi.lambda$setUp$16(this.b, obj, reply);
                                break;
                            case 26:
                                Messages.CameraApi.lambda$setUp$17(this.b, obj, reply);
                                break;
                            default:
                                Messages.CameraApi.lambda$setUp$18(this.b, obj, reply);
                                break;
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CameraEventApi {

        @NonNull
        private final BinaryMessenger binaryMessenger;
        private final String messageChannelSuffix;

        public CameraEventApi(@NonNull BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$closed$2(VoidResult voidResult, String str, Object obj) {
            if (!(obj instanceof List)) {
                voidResult.error(Messages.createConnectionError(str));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
            } else {
                voidResult.success();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$error$1(VoidResult voidResult, String str, Object obj) {
            if (!(obj instanceof List)) {
                voidResult.error(Messages.createConnectionError(str));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
            } else {
                voidResult.success();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$initialized$0(VoidResult voidResult, String str, Object obj) {
            if (!(obj instanceof List)) {
                voidResult.error(Messages.createConnectionError(str));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
            } else {
                voidResult.success();
            }
        }

        public void closed(@NonNull VoidResult voidResult) {
            String str = "dev.flutter.pigeon.camera_android.CameraEventApi.closed" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(null, new k(voidResult, str, 1));
        }

        public void error(@NonNull String str, @NonNull VoidResult voidResult) {
            String str2 = "dev.flutter.pigeon.camera_android.CameraEventApi.error" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str2, getCodec()).send(new ArrayList(Collections.singletonList(str)), new k(voidResult, str2, 0));
        }

        public void initialized(@NonNull PlatformCameraState platformCameraState, @NonNull VoidResult voidResult) {
            String str = "dev.flutter.pigeon.camera_android.CameraEventApi.initialized" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(new ArrayList(Collections.singletonList(platformCameraState)), new k(voidResult, str, 2));
        }

        public CameraEventApi(@NonNull BinaryMessenger binaryMessenger, @NonNull String str) {
            this.binaryMessenger = binaryMessenger;
            this.messageChannelSuffix = str.isEmpty() ? "" : Consts.DOT.concat(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CameraGlobalEventApi {

        @NonNull
        private final BinaryMessenger binaryMessenger;
        private final String messageChannelSuffix;

        public CameraGlobalEventApi(@NonNull BinaryMessenger binaryMessenger) {
            this(binaryMessenger, "");
        }

        @NonNull
        public static MessageCodec<Object> getCodec() {
            return PigeonCodec.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$deviceOrientationChanged$0(VoidResult voidResult, String str, Object obj) {
            if (!(obj instanceof List)) {
                voidResult.error(Messages.createConnectionError(str));
                return;
            }
            List list = (List) obj;
            if (list.size() > 1) {
                voidResult.error(new FlutterError((String) list.get(0), (String) list.get(1), list.get(2)));
            } else {
                voidResult.success();
            }
        }

        public void deviceOrientationChanged(@NonNull PlatformDeviceOrientation platformDeviceOrientation, @NonNull VoidResult voidResult) {
            String str = "dev.flutter.pigeon.camera_android.CameraGlobalEventApi.deviceOrientationChanged" + this.messageChannelSuffix;
            new BasicMessageChannel(this.binaryMessenger, str, getCodec()).send(new ArrayList(Collections.singletonList(platformDeviceOrientation)), new k(voidResult, str, 3));
        }

        public CameraGlobalEventApi(@NonNull BinaryMessenger binaryMessenger, @NonNull String str) {
            this.binaryMessenger = binaryMessenger;
            this.messageChannelSuffix = str.isEmpty() ? "" : Consts.DOT.concat(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    public @interface CanIgnoreReturnValue {
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
            switch (b) {
                case -127:
                    Object value = readValue(byteBuffer);
                    if (value == null) {
                        return null;
                    }
                    return PlatformCameraLensDirection.values()[((Long) value).intValue()];
                case -126:
                    Object value2 = readValue(byteBuffer);
                    if (value2 == null) {
                        return null;
                    }
                    return PlatformDeviceOrientation.values()[((Long) value2).intValue()];
                case -125:
                    Object value3 = readValue(byteBuffer);
                    if (value3 == null) {
                        return null;
                    }
                    return PlatformExposureMode.values()[((Long) value3).intValue()];
                case -124:
                    Object value4 = readValue(byteBuffer);
                    if (value4 == null) {
                        return null;
                    }
                    return PlatformFocusMode.values()[((Long) value4).intValue()];
                case -123:
                    Object value5 = readValue(byteBuffer);
                    if (value5 == null) {
                        return null;
                    }
                    return PlatformResolutionPreset.values()[((Long) value5).intValue()];
                case -122:
                    Object value6 = readValue(byteBuffer);
                    if (value6 == null) {
                        return null;
                    }
                    return PlatformImageFormatGroup.values()[((Long) value6).intValue()];
                case -121:
                    Object value7 = readValue(byteBuffer);
                    if (value7 == null) {
                        return null;
                    }
                    return PlatformFlashMode.values()[((Long) value7).intValue()];
                case -120:
                    return PlatformCameraDescription.fromList((ArrayList) readValue(byteBuffer));
                case -119:
                    return PlatformCameraState.fromList((ArrayList) readValue(byteBuffer));
                case -118:
                    return PlatformSize.fromList((ArrayList) readValue(byteBuffer));
                case -117:
                    return PlatformPoint.fromList((ArrayList) readValue(byteBuffer));
                case -116:
                    return PlatformMediaSettings.fromList((ArrayList) readValue(byteBuffer));
                default:
                    return super.readValueOfType(b, byteBuffer);
            }
        }

        @Override // io.flutter.plugin.common.StandardMessageCodec
        public void writeValue(@NonNull ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof PlatformCameraLensDirection) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformCameraLensDirection) obj).index));
                return;
            }
            if (obj instanceof PlatformDeviceOrientation) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformDeviceOrientation) obj).index));
                return;
            }
            if (obj instanceof PlatformExposureMode) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformExposureMode) obj).index));
                return;
            }
            if (obj instanceof PlatformFocusMode) {
                byteArrayOutputStream.write(132);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformFocusMode) obj).index));
                return;
            }
            if (obj instanceof PlatformResolutionPreset) {
                byteArrayOutputStream.write(133);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformResolutionPreset) obj).index));
                return;
            }
            if (obj instanceof PlatformImageFormatGroup) {
                byteArrayOutputStream.write(134);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformImageFormatGroup) obj).index));
                return;
            }
            if (obj instanceof PlatformFlashMode) {
                byteArrayOutputStream.write(135);
                writeValue(byteArrayOutputStream, Integer.valueOf(((PlatformFlashMode) obj).index));
                return;
            }
            if (obj instanceof PlatformCameraDescription) {
                byteArrayOutputStream.write(136);
                writeValue(byteArrayOutputStream, ((PlatformCameraDescription) obj).toList());
                return;
            }
            if (obj instanceof PlatformCameraState) {
                byteArrayOutputStream.write(137);
                writeValue(byteArrayOutputStream, ((PlatformCameraState) obj).toList());
                return;
            }
            if (obj instanceof PlatformSize) {
                byteArrayOutputStream.write(138);
                writeValue(byteArrayOutputStream, ((PlatformSize) obj).toList());
            } else if (obj instanceof PlatformPoint) {
                byteArrayOutputStream.write(139);
                writeValue(byteArrayOutputStream, ((PlatformPoint) obj).toList());
            } else if (!(obj instanceof PlatformMediaSettings)) {
                super.writeValue(byteArrayOutputStream, obj);
            } else {
                byteArrayOutputStream.write(140);
                writeValue(byteArrayOutputStream, ((PlatformMediaSettings) obj).toList());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlatformCameraDescription {

        @NonNull
        private PlatformCameraLensDirection lensDirection;

        @NonNull
        private String name;

        @NonNull
        private Long sensorOrientation;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private PlatformCameraLensDirection lensDirection;

            @Nullable
            private String name;

            @Nullable
            private Long sensorOrientation;

            @NonNull
            public PlatformCameraDescription build() {
                PlatformCameraDescription platformCameraDescription = new PlatformCameraDescription();
                platformCameraDescription.setName(this.name);
                platformCameraDescription.setLensDirection(this.lensDirection);
                platformCameraDescription.setSensorOrientation(this.sensorOrientation);
                return platformCameraDescription;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setLensDirection(@NonNull PlatformCameraLensDirection platformCameraLensDirection) {
                this.lensDirection = platformCameraLensDirection;
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
            public Builder setSensorOrientation(@NonNull Long l6) {
                this.sensorOrientation = l6;
                return this;
            }
        }

        @NonNull
        public static PlatformCameraDescription fromList(@NonNull ArrayList<Object> arrayList) {
            PlatformCameraDescription platformCameraDescription = new PlatformCameraDescription();
            platformCameraDescription.setName((String) arrayList.get(0));
            platformCameraDescription.setLensDirection((PlatformCameraLensDirection) arrayList.get(1));
            platformCameraDescription.setSensorOrientation((Long) arrayList.get(2));
            return platformCameraDescription;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PlatformCameraDescription.class == obj.getClass()) {
                PlatformCameraDescription platformCameraDescription = (PlatformCameraDescription) obj;
                if (this.name.equals(platformCameraDescription.name) && this.lensDirection.equals(platformCameraDescription.lensDirection) && this.sensorOrientation.equals(platformCameraDescription.sensorOrientation)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public PlatformCameraLensDirection getLensDirection() {
            return this.lensDirection;
        }

        @NonNull
        public String getName() {
            return this.name;
        }

        @NonNull
        public Long getSensorOrientation() {
            return this.sensorOrientation;
        }

        public int hashCode() {
            return Objects.hash(this.name, this.lensDirection, this.sensorOrientation);
        }

        public void setLensDirection(@NonNull PlatformCameraLensDirection platformCameraLensDirection) {
            if (platformCameraLensDirection == null) {
                throw new IllegalStateException("Nonnull field \"lensDirection\" is null.");
            }
            this.lensDirection = platformCameraLensDirection;
        }

        public void setName(@NonNull String str) {
            if (str == null) {
                throw new IllegalStateException("Nonnull field \"name\" is null.");
            }
            this.name = str;
        }

        public void setSensorOrientation(@NonNull Long l6) {
            if (l6 == null) {
                throw new IllegalStateException("Nonnull field \"sensorOrientation\" is null.");
            }
            this.sensorOrientation = l6;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(3);
            arrayList.add(this.name);
            arrayList.add(this.lensDirection);
            arrayList.add(this.sensorOrientation);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformCameraLensDirection {
        FRONT(0),
        BACK(1),
        EXTERNAL(2);

        final int index;

        PlatformCameraLensDirection(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlatformCameraState {

        @NonNull
        private PlatformExposureMode exposureMode;

        @NonNull
        private Boolean exposurePointSupported;

        @NonNull
        private PlatformFocusMode focusMode;

        @NonNull
        private Boolean focusPointSupported;

        @NonNull
        private PlatformSize previewSize;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private PlatformExposureMode exposureMode;

            @Nullable
            private Boolean exposurePointSupported;

            @Nullable
            private PlatformFocusMode focusMode;

            @Nullable
            private Boolean focusPointSupported;

            @Nullable
            private PlatformSize previewSize;

            @NonNull
            public PlatformCameraState build() {
                PlatformCameraState platformCameraState = new PlatformCameraState();
                platformCameraState.setPreviewSize(this.previewSize);
                platformCameraState.setExposureMode(this.exposureMode);
                platformCameraState.setFocusMode(this.focusMode);
                platformCameraState.setExposurePointSupported(this.exposurePointSupported);
                platformCameraState.setFocusPointSupported(this.focusPointSupported);
                return platformCameraState;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setExposureMode(@NonNull PlatformExposureMode platformExposureMode) {
                this.exposureMode = platformExposureMode;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setExposurePointSupported(@NonNull Boolean bool) {
                this.exposurePointSupported = bool;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setFocusMode(@NonNull PlatformFocusMode platformFocusMode) {
                this.focusMode = platformFocusMode;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setFocusPointSupported(@NonNull Boolean bool) {
                this.focusPointSupported = bool;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setPreviewSize(@NonNull PlatformSize platformSize) {
                this.previewSize = platformSize;
                return this;
            }
        }

        @NonNull
        public static PlatformCameraState fromList(@NonNull ArrayList<Object> arrayList) {
            PlatformCameraState platformCameraState = new PlatformCameraState();
            platformCameraState.setPreviewSize((PlatformSize) arrayList.get(0));
            platformCameraState.setExposureMode((PlatformExposureMode) arrayList.get(1));
            platformCameraState.setFocusMode((PlatformFocusMode) arrayList.get(2));
            platformCameraState.setExposurePointSupported((Boolean) arrayList.get(3));
            platformCameraState.setFocusPointSupported((Boolean) arrayList.get(4));
            return platformCameraState;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PlatformCameraState.class == obj.getClass()) {
                PlatformCameraState platformCameraState = (PlatformCameraState) obj;
                if (this.previewSize.equals(platformCameraState.previewSize) && this.exposureMode.equals(platformCameraState.exposureMode) && this.focusMode.equals(platformCameraState.focusMode) && this.exposurePointSupported.equals(platformCameraState.exposurePointSupported) && this.focusPointSupported.equals(platformCameraState.focusPointSupported)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public PlatformExposureMode getExposureMode() {
            return this.exposureMode;
        }

        @NonNull
        public Boolean getExposurePointSupported() {
            return this.exposurePointSupported;
        }

        @NonNull
        public PlatformFocusMode getFocusMode() {
            return this.focusMode;
        }

        @NonNull
        public Boolean getFocusPointSupported() {
            return this.focusPointSupported;
        }

        @NonNull
        public PlatformSize getPreviewSize() {
            return this.previewSize;
        }

        public int hashCode() {
            return Objects.hash(this.previewSize, this.exposureMode, this.focusMode, this.exposurePointSupported, this.focusPointSupported);
        }

        public void setExposureMode(@NonNull PlatformExposureMode platformExposureMode) {
            if (platformExposureMode == null) {
                throw new IllegalStateException("Nonnull field \"exposureMode\" is null.");
            }
            this.exposureMode = platformExposureMode;
        }

        public void setExposurePointSupported(@NonNull Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"exposurePointSupported\" is null.");
            }
            this.exposurePointSupported = bool;
        }

        public void setFocusMode(@NonNull PlatformFocusMode platformFocusMode) {
            if (platformFocusMode == null) {
                throw new IllegalStateException("Nonnull field \"focusMode\" is null.");
            }
            this.focusMode = platformFocusMode;
        }

        public void setFocusPointSupported(@NonNull Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"focusPointSupported\" is null.");
            }
            this.focusPointSupported = bool;
        }

        public void setPreviewSize(@NonNull PlatformSize platformSize) {
            if (platformSize == null) {
                throw new IllegalStateException("Nonnull field \"previewSize\" is null.");
            }
            this.previewSize = platformSize;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.previewSize);
            arrayList.add(this.exposureMode);
            arrayList.add(this.focusMode);
            arrayList.add(this.exposurePointSupported);
            arrayList.add(this.focusPointSupported);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformDeviceOrientation {
        PORTRAIT_UP(0),
        PORTRAIT_DOWN(1),
        LANDSCAPE_LEFT(2),
        LANDSCAPE_RIGHT(3);

        final int index;

        PlatformDeviceOrientation(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformExposureMode {
        AUTO(0),
        LOCKED(1);

        final int index;

        PlatformExposureMode(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformFlashMode {
        OFF(0),
        AUTO(1),
        ALWAYS(2),
        TORCH(3);

        final int index;

        PlatformFlashMode(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformFocusMode {
        AUTO(0),
        LOCKED(1);

        final int index;

        PlatformFocusMode(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformImageFormatGroup {
        YUV420(0),
        JPEG(1),
        NV21(2);

        final int index;

        PlatformImageFormatGroup(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlatformMediaSettings {

        @Nullable
        private Long audioBitrate;

        @NonNull
        private Boolean enableAudio;

        @Nullable
        private Long fps;

        @NonNull
        private PlatformResolutionPreset resolutionPreset;

        @Nullable
        private Long videoBitrate;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private Long audioBitrate;

            @Nullable
            private Boolean enableAudio;

            @Nullable
            private Long fps;

            @Nullable
            private PlatformResolutionPreset resolutionPreset;

            @Nullable
            private Long videoBitrate;

            @NonNull
            public PlatformMediaSettings build() {
                PlatformMediaSettings platformMediaSettings = new PlatformMediaSettings();
                platformMediaSettings.setResolutionPreset(this.resolutionPreset);
                platformMediaSettings.setFps(this.fps);
                platformMediaSettings.setVideoBitrate(this.videoBitrate);
                platformMediaSettings.setAudioBitrate(this.audioBitrate);
                platformMediaSettings.setEnableAudio(this.enableAudio);
                return platformMediaSettings;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setAudioBitrate(@Nullable Long l6) {
                this.audioBitrate = l6;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setEnableAudio(@NonNull Boolean bool) {
                this.enableAudio = bool;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setFps(@Nullable Long l6) {
                this.fps = l6;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setResolutionPreset(@NonNull PlatformResolutionPreset platformResolutionPreset) {
                this.resolutionPreset = platformResolutionPreset;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setVideoBitrate(@Nullable Long l6) {
                this.videoBitrate = l6;
                return this;
            }
        }

        @NonNull
        public static PlatformMediaSettings fromList(@NonNull ArrayList<Object> arrayList) {
            PlatformMediaSettings platformMediaSettings = new PlatformMediaSettings();
            platformMediaSettings.setResolutionPreset((PlatformResolutionPreset) arrayList.get(0));
            platformMediaSettings.setFps((Long) arrayList.get(1));
            platformMediaSettings.setVideoBitrate((Long) arrayList.get(2));
            platformMediaSettings.setAudioBitrate((Long) arrayList.get(3));
            platformMediaSettings.setEnableAudio((Boolean) arrayList.get(4));
            return platformMediaSettings;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PlatformMediaSettings.class == obj.getClass()) {
                PlatformMediaSettings platformMediaSettings = (PlatformMediaSettings) obj;
                if (this.resolutionPreset.equals(platformMediaSettings.resolutionPreset) && Objects.equals(this.fps, platformMediaSettings.fps) && Objects.equals(this.videoBitrate, platformMediaSettings.videoBitrate) && Objects.equals(this.audioBitrate, platformMediaSettings.audioBitrate) && this.enableAudio.equals(platformMediaSettings.enableAudio)) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        public Long getAudioBitrate() {
            return this.audioBitrate;
        }

        @NonNull
        public Boolean getEnableAudio() {
            return this.enableAudio;
        }

        @Nullable
        public Long getFps() {
            return this.fps;
        }

        @NonNull
        public PlatformResolutionPreset getResolutionPreset() {
            return this.resolutionPreset;
        }

        @Nullable
        public Long getVideoBitrate() {
            return this.videoBitrate;
        }

        public int hashCode() {
            return Objects.hash(this.resolutionPreset, this.fps, this.videoBitrate, this.audioBitrate, this.enableAudio);
        }

        public void setAudioBitrate(@Nullable Long l6) {
            this.audioBitrate = l6;
        }

        public void setEnableAudio(@NonNull Boolean bool) {
            if (bool == null) {
                throw new IllegalStateException("Nonnull field \"enableAudio\" is null.");
            }
            this.enableAudio = bool;
        }

        public void setFps(@Nullable Long l6) {
            this.fps = l6;
        }

        public void setResolutionPreset(@NonNull PlatformResolutionPreset platformResolutionPreset) {
            if (platformResolutionPreset == null) {
                throw new IllegalStateException("Nonnull field \"resolutionPreset\" is null.");
            }
            this.resolutionPreset = platformResolutionPreset;
        }

        public void setVideoBitrate(@Nullable Long l6) {
            this.videoBitrate = l6;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(5);
            arrayList.add(this.resolutionPreset);
            arrayList.add(this.fps);
            arrayList.add(this.videoBitrate);
            arrayList.add(this.audioBitrate);
            arrayList.add(this.enableAudio);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlatformPoint {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @NonNull
        private Double f4094x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @NonNull
        private Double f4095y;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            @Nullable
            private Double f4096x;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            @Nullable
            private Double f4097y;

            @NonNull
            public PlatformPoint build() {
                PlatformPoint platformPoint = new PlatformPoint();
                platformPoint.setX(this.f4096x);
                platformPoint.setY(this.f4097y);
                return platformPoint;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setX(@NonNull Double d) {
                this.f4096x = d;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setY(@NonNull Double d) {
                this.f4097y = d;
                return this;
            }
        }

        @NonNull
        public static PlatformPoint fromList(@NonNull ArrayList<Object> arrayList) {
            PlatformPoint platformPoint = new PlatformPoint();
            platformPoint.setX((Double) arrayList.get(0));
            platformPoint.setY((Double) arrayList.get(1));
            return platformPoint;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PlatformPoint.class == obj.getClass()) {
                PlatformPoint platformPoint = (PlatformPoint) obj;
                if (this.f4094x.equals(platformPoint.f4094x) && this.f4095y.equals(platformPoint.f4095y)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public Double getX() {
            return this.f4094x;
        }

        @NonNull
        public Double getY() {
            return this.f4095y;
        }

        public int hashCode() {
            return Objects.hash(this.f4094x, this.f4095y);
        }

        public void setX(@NonNull Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"x\" is null.");
            }
            this.f4094x = d;
        }

        public void setY(@NonNull Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"y\" is null.");
            }
            this.f4095y = d;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.f4094x);
            arrayList.add(this.f4095y);
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum PlatformResolutionPreset {
        LOW(0),
        MEDIUM(1),
        HIGH(2),
        VERY_HIGH(3),
        ULTRA_HIGH(4),
        MAX(5);

        final int index;

        PlatformResolutionPreset(int i5) {
            this.index = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class PlatformSize {

        @NonNull
        private Double height;

        @NonNull
        private Double width;

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static final class Builder {

            @Nullable
            private Double height;

            @Nullable
            private Double width;

            @NonNull
            public PlatformSize build() {
                PlatformSize platformSize = new PlatformSize();
                platformSize.setWidth(this.width);
                platformSize.setHeight(this.height);
                return platformSize;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setHeight(@NonNull Double d) {
                this.height = d;
                return this;
            }

            @NonNull
            @CanIgnoreReturnValue
            public Builder setWidth(@NonNull Double d) {
                this.width = d;
                return this;
            }
        }

        @NonNull
        public static PlatformSize fromList(@NonNull ArrayList<Object> arrayList) {
            PlatformSize platformSize = new PlatformSize();
            platformSize.setWidth((Double) arrayList.get(0));
            platformSize.setHeight((Double) arrayList.get(1));
            return platformSize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && PlatformSize.class == obj.getClass()) {
                PlatformSize platformSize = (PlatformSize) obj;
                if (this.width.equals(platformSize.width) && this.height.equals(platformSize.height)) {
                    return true;
                }
            }
            return false;
        }

        @NonNull
        public Double getHeight() {
            return this.height;
        }

        @NonNull
        public Double getWidth() {
            return this.width;
        }

        public int hashCode() {
            return Objects.hash(this.width, this.height);
        }

        public void setHeight(@NonNull Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"height\" is null.");
            }
            this.height = d;
        }

        public void setWidth(@NonNull Double d) {
            if (d == null) {
                throw new IllegalStateException("Nonnull field \"width\" is null.");
            }
            this.width = d;
        }

        @NonNull
        public ArrayList<Object> toList() {
            ArrayList<Object> arrayList = new ArrayList<>(2);
            arrayList.add(this.width);
            arrayList.add(this.height);
            return arrayList;
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
    public static FlutterError createConnectionError(@NonNull String str) {
        return new FlutterError("channel-error", AbstractC0157z.o("Unable to establish connection on channel: ", str, Consts.DOT), "");
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
