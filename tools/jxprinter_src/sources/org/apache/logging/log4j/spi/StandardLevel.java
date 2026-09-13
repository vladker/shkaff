package org.apache.logging.log4j.spi;

import java.util.EnumSet;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum StandardLevel {
    OFF(0),
    FATAL(100),
    ERROR(200),
    WARN(300),
    INFO(400),
    DEBUG(Videoio.CAP_QT),
    TRACE(600),
    ALL(Integer.MAX_VALUE);

    private static final EnumSet<StandardLevel> LEVELSET = EnumSet.allOf(StandardLevel.class);
    private final int intLevel;

    StandardLevel(int i5) {
        this.intLevel = i5;
    }

    public static StandardLevel getStandardLevel(int i5) {
        StandardLevel standardLevel = OFF;
        for (StandardLevel standardLevel2 : LEVELSET) {
            if (standardLevel2.intLevel() > i5) {
                break;
            }
            standardLevel = standardLevel2;
        }
        return standardLevel;
    }

    public int intLevel() {
        return this.intLevel;
    }
}
