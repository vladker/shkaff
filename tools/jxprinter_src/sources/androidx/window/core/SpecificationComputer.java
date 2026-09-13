package androidx.window.core;

import O3.l;
import kotlin.jvm.internal.AbstractC1107v;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1107v abstractC1107v) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i5, Object obj2) {
            if ((i5 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i5 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t6, String tag, VerificationMode verificationMode, Logger logger) {
            E.f(t6, "<this>");
            E.f(tag, "tag");
            E.f(verificationMode, "verificationMode");
            E.f(logger, "logger");
            return new ValidSpecification(t6, tag, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public abstract T compute();

    public final String createMessage(Object value, String message) {
        E.f(value, "value");
        E.f(message, "message");
        return message + " value: " + value;
    }

    public abstract SpecificationComputer<T> require(String str, l lVar);
}
