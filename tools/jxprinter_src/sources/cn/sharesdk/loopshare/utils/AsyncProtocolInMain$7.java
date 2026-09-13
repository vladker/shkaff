package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.beans.SceneData;
import com.mob.tools.RxMob;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AsyncProtocolInMain$7 extends RxMob.QuickSubscribe<SceneData> {
    final /* synthetic */ String val$mobId;

    public AsyncProtocolInMain$7(String str) {
        this.val$mobId = str;
    }

    @Override // com.mob.tools.RxMob.QuickSubscribe
    public void doNext(RxMob.Subscriber<SceneData> subscriber) {
        subscriber.onNext(e.a(this.val$mobId));
    }
}
