package io.flutter.plugins.firebase.analytics;

import A3.AbstractC0157z;
import O3.l;
import S2.f;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;
import p147z3.Q;
import p147z3.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface FirebaseAnalyticsHostApi {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new S2.d(5));

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneratedAndroidFirebaseAnalyticsPigeonCodec codec_delegate$lambda$0() {
            return new GeneratedAndroidFirebaseAnalyticsPigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String str, int i5, Object obj) {
            if ((i5 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, firebaseAnalyticsHostApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
            firebaseAnalyticsHostApi.setAnalyticsCollectionEnabled(((Boolean) obj2).booleanValue(), new f(reply, 8));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            firebaseAnalyticsHostApi.resetAnalyticsData(new f(reply, 6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            firebaseAnalyticsHostApi.setSessionTimeoutDuration(((Long) obj2).longValue(), new f(reply, 14));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$21$lambda$20(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean?>");
            firebaseAnalyticsHostApi.setConsent((Map) obj2, new f(reply, 11));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$21$lambda$20$lambda$19(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$24$lambda$23(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setDefaultEventParameters((Map) ((List) obj).get(0), new f(reply, 7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$24$lambda$23$lambda$22(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$27$lambda$26(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            firebaseAnalyticsHostApi.getAppInstanceId(new f(reply, 13));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$27$lambda$26$lambda$25(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                Object objB = uVar.b();
                if (objB instanceof u.a) {
                    objB = null;
                }
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((String) objB));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any?>");
            firebaseAnalyticsHostApi.logEvent((Map) obj2, new f(reply, 9));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$30$lambda$29(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            firebaseAnalyticsHostApi.getSessionId(new f(reply, 4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$30$lambda$29$lambda$28(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                Object objB = uVar.b();
                if (objB instanceof u.a) {
                    objB = null;
                }
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult((Long) objB));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$33$lambda$32(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String?>");
            firebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement((Map) obj2, new f(reply, 5));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$33$lambda$32$lambda$31(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            firebaseAnalyticsHostApi.setUserId((String) ((List) obj).get(0), new f(reply, 12));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, Object obj, BasicMessageChannel.Reply reply) {
            E.f(reply, "reply");
            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
            firebaseAnalyticsHostApi.setUserProperty((String) obj2, (String) list.get(1), new f(reply, 10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Q setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, u uVar) {
            Throwable thM1362exceptionOrNullimpl = u.m1362exceptionOrNullimpl(uVar.b());
            if (thM1362exceptionOrNullimpl != null) {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
            } else {
                reply.reply(GeneratedAndroidFirebaseAnalyticsPigeonUtils.INSTANCE.wrapResult(null));
            }
            return Q.INSTANCE;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec$delegate.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, FirebaseAnalyticsHostApi firebaseAnalyticsHostApi) {
            E.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, firebaseAnalyticsHostApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final FirebaseAnalyticsHostApi firebaseAnalyticsHostApi, String messageChannelSuffix) {
            E.f(binaryMessenger, "binaryMessenger");
            E.f(messageChannelSuffix, "messageChannelSuffix");
            String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.logEvent", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i5 = 0;
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i5) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserId", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i6 = 3;
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i6) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setUserProperty", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i7 = 4;
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i7) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setAnalyticsCollectionEnabled", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i8 = 5;
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i8) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.resetAnalyticsData", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i9 = 6;
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i9) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setSessionTimeoutDuration", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i10 = 7;
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i10) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setConsent", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i11 = 8;
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i11) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.setDefaultEventParameters", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i12 = 9;
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i12) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getAppInstanceId", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i13 = 10;
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i13) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.getSessionId", strConcat), getCodec());
            if (firebaseAnalyticsHostApi != null) {
                final int i14 = 1;
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i14) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.firebase_analytics_platform_interface.FirebaseAnalyticsHostApi.initiateOnDeviceConversionMeasurement", strConcat), getCodec());
            if (firebaseAnalyticsHostApi == null) {
                basicMessageChannel11.setMessageHandler(null);
            } else {
                final int i15 = 2;
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.analytics.a
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        switch (i15) {
                            case 0:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 1:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 2:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 3:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 4:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 5:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 6:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 7:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 8:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            case 9:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23(firebaseAnalyticsHostApi, obj, reply);
                                break;
                            default:
                                FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26(firebaseAnalyticsHostApi, obj, reply);
                                break;
                        }
                    }
                });
            }
        }
    }

    void getAppInstanceId(l lVar);

    void getSessionId(l lVar);

    void initiateOnDeviceConversionMeasurement(Map<String, String> map, l lVar);

    void logEvent(Map<String, ? extends Object> map, l lVar);

    void resetAnalyticsData(l lVar);

    void setAnalyticsCollectionEnabled(boolean z6, l lVar);

    void setConsent(Map<String, Boolean> map, l lVar);

    void setDefaultEventParameters(Map<String, ? extends Object> map, l lVar);

    void setSessionTimeoutDuration(long j6, l lVar);

    void setUserId(String str, l lVar);

    void setUserProperty(String str, String str2, l lVar);
}
