package com.google.firebase.sessions;

import X3.W;
import java.util.Locale;
import kotlin.jvm.internal.E;
import org.apache.logging.log4j.util.ProcessIdUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class SessionGenerator {
    private final TimeProvider timeProvider;
    private final UuidGenerator uuidGenerator;

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        E.f(timeProvider, "timeProvider");
        E.f(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
    }

    private final String generateSessionId() {
        String string = this.uuidGenerator.next().toString();
        E.e(string, "toString(...)");
        String lowerCase = W.replace(string, ProcessIdUtil.DEFAULT_PROCESSID, "", false).toLowerCase(Locale.ROOT);
        E.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession(SessionDetails sessionDetails) {
        String firstSessionId;
        String strGenerateSessionId = generateSessionId();
        if (sessionDetails == null || (firstSessionId = sessionDetails.getFirstSessionId()) == null) {
            firstSessionId = strGenerateSessionId;
        }
        return new SessionDetails(strGenerateSessionId, firstSessionId, sessionDetails != null ? sessionDetails.getSessionIndex() + 1 : 0, this.timeProvider.currentTime().getUs());
    }
}
