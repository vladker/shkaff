package org.apache.logging.log4j.spi;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import org.apache.logging.log4j.message.MessageFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class LoggerContextKey {
    public static String create(String str) {
        return create(str, AbstractLogger.DEFAULT_MESSAGE_FACTORY_CLASS);
    }

    public static String create(String str, MessageFactory messageFactory) {
        return create(str, (Class<? extends MessageFactory>) (messageFactory != null ? messageFactory.getClass() : AbstractLogger.DEFAULT_MESSAGE_FACTORY_CLASS));
    }

    public static String create(String str, Class<? extends MessageFactory> cls) {
        if (cls == null) {
            cls = AbstractLogger.DEFAULT_MESSAGE_FACTORY_CLASS;
        }
        StringBuilder sbX = AbstractC0157z.x(str, Consts.DOT);
        sbX.append(cls.getName());
        return sbX.toString();
    }
}
