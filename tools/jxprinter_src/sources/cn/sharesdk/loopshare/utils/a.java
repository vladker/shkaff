package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.ActionListener;
import cn.sharesdk.loopshare.Scene;
import cn.sharesdk.loopshare.beans.ConfigData;
import cn.sharesdk.loopshare.beans.LinkData;
import cn.sharesdk.loopshare.beans.SceneData;
import cn.sharesdk.loopshare.beans.ServerData;
import com.mob.tools.RxMob;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(final Scene scene, final ActionListener<String> actionListener) {
        RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<LinkData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$1
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(RxMob.Subscriber<LinkData> subscriber) {
                subscriber.onNext(e.a(scene.getPath(), scene.getParams()));
            }
        });
        subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
        subscribableCreate.observeOn(RxMob.Thread.UI_THREAD);
        subscribableCreate.subscribe(new RxMob.Subscriber<LinkData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$2
            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(LinkData linkData) {
                if (actionListener == null) {
                    return;
                }
                if (!ServerData.a(linkData)) {
                    actionListener.onError(new Throwable(linkData.i()));
                } else {
                    actionListener.onResult(linkData.a());
                }
            }
        });
    }

    public static void a(final AsyncProtocol.DataListener<ConfigData> dataListener) {
        RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<ConfigData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$3
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(RxMob.Subscriber<ConfigData> subscriber) {
                subscriber.onNext(e.a());
            }
        });
        subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
        subscribableCreate.observeOn(RxMob.Thread.UI_THREAD);
        subscribableCreate.subscribe(new RxMob.Subscriber<ConfigData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$4
            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(ConfigData configData) {
                AsyncProtocol.DataListener dataListener2 = dataListener;
                if (dataListener2 != null) {
                    dataListener2.onReceiveData(configData);
                }
            }
        });
    }

    public static void a(final String str, final AsyncProtocol.DataListener<SceneData> dataListener) {
        RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$5
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(RxMob.Subscriber<SceneData> subscriber) {
                subscriber.onNext(e.a(str));
            }
        });
        subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
        subscribableCreate.observeOn(RxMob.Thread.UI_THREAD);
        subscribableCreate.subscribe(new RxMob.Subscriber<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$6
            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(SceneData sceneData) {
                AsyncProtocol.DataListener dataListener2 = dataListener;
                if (dataListener2 != null) {
                    dataListener2.onReceiveData(sceneData);
                }
            }
        });
    }

    public static void a(final int i5, final AsyncProtocol.DataListener<SceneData> dataListener) {
        RxMob.Subscribable subscribableCreate = RxMob.create(new RxMob.QuickSubscribe<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$9
            @Override // com.mob.tools.RxMob.QuickSubscribe
            public void doNext(RxMob.Subscriber<SceneData> subscriber) {
                subscriber.onNext(e.a(i5));
            }
        });
        subscribableCreate.subscribeOn(RxMob.Thread.NEW_THREAD);
        subscribableCreate.observeOn(RxMob.Thread.UI_THREAD);
        subscribableCreate.subscribe(new RxMob.Subscriber<SceneData>() { // from class: cn.sharesdk.loopshare.utils.AsyncProtocolInMain$10
            @Override // com.mob.tools.RxMob.Subscriber
            public void onNext(SceneData sceneData) {
                AsyncProtocol.DataListener dataListener2 = dataListener;
                if (dataListener2 != null) {
                    dataListener2.onReceiveData(sceneData);
                }
            }
        });
    }
}
