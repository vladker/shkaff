package org.apache.logging.log4j;

import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.StructuredDataMessage;
import org.apache.logging.log4j.spi.ExtendedLogger;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventLogger {
    public static final Marker EVENT_MARKER = MarkerManager.getMarker("EVENT");
    private static final String FQCN = EventLogger.class.getName();
    private static final String NAME = "EventLogger";
    private static final ExtendedLogger LOGGER = LogManager.getContext(false).getLogger(NAME);

    private EventLogger() {
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage) {
        LOGGER.logIfEnabled(FQCN, Level.OFF, EVENT_MARKER, (Message) structuredDataMessage, (Throwable) null);
    }

    public static void logEvent(StructuredDataMessage structuredDataMessage, Level level) {
        LOGGER.logIfEnabled(FQCN, level, EVENT_MARKER, (Message) structuredDataMessage, (Throwable) null);
    }
}
