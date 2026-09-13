package cn.sharesdk.loopshare.utils;

import android.os.Handler;
import android.os.Message;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.LogData;
import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;
import com.mob.tools.utils.UIHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AsyncProtocol {

    /* JADX INFO: renamed from: cn.sharesdk.loopshare.utils.AsyncProtocol$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnonymousClass1 extends RxMob.QuickSubscribe<ConfigData> {
        @Override // com.mob.tools.RxMob.QuickSubscribe
        public void doNext(RxMob.Subscriber<ConfigData> subscriber) {
            subscriber.onNext(e.a());
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.loopshare.utils.AsyncProtocol$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnonymousClass2 extends RxMob.Subscriber<ConfigData> {
        final /* synthetic */ DataListener val$l;

        public AnonymousClass2(DataListener dataListener) {
            this.val$l = dataListener;
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onNext(ConfigData configData) {
            DataListener dataListener = this.val$l;
            if (dataListener != null) {
                dataListener.onReceiveData(configData);
            }
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.loopshare.utils.AsyncProtocol$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnonymousClass3 extends RxMob.QuickSubscribe<SceneData> {
        final /* synthetic */ String val$linkId;

        public AnonymousClass3(String str) {
            this.val$linkId = str;
        }

        @Override // com.mob.tools.RxMob.QuickSubscribe
        public void doNext(RxMob.Subscriber<SceneData> subscriber) {
            subscriber.onNext(e.a(this.val$linkId));
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.loopshare.utils.AsyncProtocol$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnonymousClass4 extends RxMob.Subscriber<SceneData> {
        final /* synthetic */ DataListener val$l;

        public AnonymousClass4(DataListener dataListener) {
            this.val$l = dataListener;
        }

        @Override // com.mob.tools.RxMob.Subscriber
        public void onNext(SceneData sceneData) {
            DataListener dataListener = this.val$l;
            if (dataListener != null) {
                dataListener.onReceiveData(sceneData);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface DataListener<T> {
        void onReceiveData(T t6);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnGetConfigListener {
        void onConfig(int i5, ConfigData configData);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface OnGetSceneListner {
        void onScene(int i5, SceneData sceneData);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static abstract class a<T> implements DataListener<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f2304a;

        public boolean a() {
            if (this.f2304a) {
                return false;
            }
            this.f2304a = true;
            return true;
        }

        public boolean b() {
            return this.f2304a;
        }

        @Override // cn.sharesdk.loopshare.utils.AsyncProtocol.DataListener
        public void onReceiveData(T t6) {
            this.f2304a = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2305a = 3;
        int b;
        int c;
        private String d;

        public b(String str, int i5, int i6) {
            this.d = str;
            this.b = i5;
            this.c = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.f2305a > 0) {
                UIHandler.sendEmptyMessageDelayed(1000, 30000L, new Handler.Callback() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocol.b.1
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        b.this.a();
                        return false;
                    }
                });
            }
        }

        public void a() {
            int i5 = this.f2305a;
            if (i5 > 0) {
                this.f2305a = i5 - 1;
                RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<LogData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocol$UploadTask$1
                    @Override // com.mob.tools.RxMob.QuickSubscribe
                    public void doNext(RxMob.Subscriber<LogData> subscriber) {
                        String str = this.this$0.d;
                        AsyncProtocol.b bVar = this.this$0;
                        subscriber.onNext(e.a(str, bVar.b, bVar.c));
                    }
                });
                subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
                subscribableCreate.observeOn(RxMob.Thread.IMMEDIATE);
                subscribableCreate.subscribe(new RxMob.Subscriber<LogData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocol$UploadTask$2
                    private void onEnd(LogData logData) {
                        if (logData == null || 200 != logData.h()) {
                            this.this$0.b();
                        }
                    }

                    @Override // com.mob.tools.RxMob.Subscriber
                    public void onError(Throwable th) {
                        onEnd(null);
                    }

                    @Override // com.mob.tools.RxMob.Subscriber
                    public void onNext(LogData logData) {
                        onEnd(logData);
                    }
                });
            }
        }
    }

    public static ConfigData a() {
        return e.b();
    }

    public static void b() {
        a(0, null);
    }

    public static void a(String str, int i5, int i6) {
        new b(str, i5, i6).a();
    }

    public static void a(final int i5, final DataListener<SceneData> dataListener) {
        RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocol.5
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(RxMob.Subscriber<SceneData> subscriber) {
                subscriber.onNext(e.a(i5));
            }
        });
        subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
        subscribableCreate.observeOn(RxMob.Thread.IMMEDIATE);
        subscribableCreate.subscribe(new RxMob.Subscriber<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocol.6
            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(SceneData sceneData) {
                DataListener dataListener2 = dataListener;
                if (dataListener2 != null) {
                    dataListener2.onReceiveData(sceneData);
                }
            }
        });
    }
}
