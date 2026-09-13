package cn.sharesdk.loopshare.utils;

import cn.sharesdk.loopshare.MobLink;
import com.mob.commons.logcollector.LogsCollector;
import com.mob.tools.log.NLog;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class MobLinkLog extends NLog {
    public static final String FORMAT = "[MOBLINK]%s";

    private MobLinkLog() {
        NLog.setCollector(MobLink.getSdkTag(), new LogsCollector() { // from class: cn.sharesdk.loopshare.utils.MobLinkLog.1
            @Override // com.mob.commons.logcollector.LogsCollector
            public String getSDKTag() {
                return MobLink.getSdkTag();
            }

            @Override // com.mob.commons.logcollector.LogsCollector
            public int getSDKVersion() {
                return MobLink.getSdkVersion();
            }
        });
    }

    public static NLog getInstance() {
        return NLog.getInstanceForSDK(MobLink.getSdkTag(), true);
    }

    public static MobLinkLog prepare() {
        return new MobLinkLog();
    }
}
