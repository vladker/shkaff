package Y3;

import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends g {
    public static final e durationUnitByIsoChar(char c, boolean z6) {
        if (!z6) {
            if (c == 'D') {
                return e.DAYS;
            }
            throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Invalid or unsupported duration ISO non-time unit: ", c));
        }
        if (c == 'H') {
            return e.HOURS;
        }
        if (c == 'M') {
            return e.MINUTES;
        }
        if (c == 'S') {
            return e.SECONDS;
        }
        throw new IllegalArgumentException(androidx.exifinterface.media.a.h("Invalid duration ISO time unit: ", c));
    }

    public static final e durationUnitByShortName(String shortName) {
        E.f(shortName, "shortName");
        int iHashCode = shortName.hashCode();
        if (iHashCode != 100) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 115) {
                        if (iHashCode != 3494) {
                            if (iHashCode != 3525) {
                                if (iHashCode == 3742 && shortName.equals("us")) {
                                    return e.MICROSECONDS;
                                }
                            } else if (shortName.equals("ns")) {
                                return e.NANOSECONDS;
                            }
                        } else if (shortName.equals("ms")) {
                            return e.MILLISECONDS;
                        }
                    } else if (shortName.equals("s")) {
                        return e.SECONDS;
                    }
                } else if (shortName.equals("m")) {
                    return e.MINUTES;
                }
            } else if (shortName.equals("h")) {
                return e.HOURS;
            }
        } else if (shortName.equals("d")) {
            return e.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: ".concat(shortName));
    }

    public static final String shortName(e eVar) {
        E.f(eVar, "<this>");
        switch (eVar.ordinal()) {
            case 0:
                return "ns";
            case 1:
                return "us";
            case 2:
                return "ms";
            case 3:
                return "s";
            case 4:
                return "m";
            case 5:
                return "h";
            case 6:
                return "d";
            default:
                throw new IllegalStateException(("Unknown unit: " + eVar).toString());
        }
    }
}
