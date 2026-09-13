package org.apache.logging.log4j;

import A3.AbstractC0157z;
import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.codec.language.bm.Rule;
import org.apache.logging.log4j.spi.StandardLevel;
import org.apache.logging.log4j.util.Strings;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Level implements Comparable<Level>, Serializable {
    public static final String CATEGORY = "Level";
    private static final long serialVersionUID = 1581082;
    private final int intLevel;
    private final String name;
    private final StandardLevel standardLevel;
    private static final Level[] EMPTY_ARRAY = new Level[0];
    private static final ConcurrentMap<String, Level> LEVELS = new ConcurrentHashMap();
    public static final Level OFF = new Level("OFF", StandardLevel.OFF.intLevel());
    public static final Level FATAL = new Level("FATAL", StandardLevel.FATAL.intLevel());
    public static final Level ERROR = new Level("ERROR", StandardLevel.ERROR.intLevel());
    public static final Level WARN = new Level("WARN", StandardLevel.WARN.intLevel());
    public static final Level INFO = new Level("INFO", StandardLevel.INFO.intLevel());
    public static final Level DEBUG = new Level("DEBUG", StandardLevel.DEBUG.intLevel());
    public static final Level TRACE = new Level("TRACE", StandardLevel.TRACE.intLevel());
    public static final Level ALL = new Level(Rule.ALL, StandardLevel.ALL.intLevel());

    private Level(String str, int i5) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Illegal Level int less than zero.");
        }
        this.name = str;
        this.intLevel = i5;
        this.standardLevel = StandardLevel.getStandardLevel(i5);
        if (LEVELS.putIfAbsent(toUpperCase(str.trim()), this) != null) {
            throw new IllegalStateException(AbstractC0157z.o("Level ", str, " has already been defined."));
        }
    }

    public static Level forName(String str, int i5) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        String upperCase = toUpperCase(str.trim());
        Level level = LEVELS.get(upperCase);
        if (level != null) {
            return level;
        }
        try {
            return new Level(str, i5);
        } catch (IllegalStateException unused) {
            return LEVELS.get(upperCase);
        }
    }

    public static Level getLevel(String str) {
        if (Strings.isEmpty(str)) {
            throw new IllegalArgumentException("Illegal null or empty Level name.");
        }
        return LEVELS.get(toUpperCase(str.trim()));
    }

    public static Level toLevel(String str) {
        return toLevel(str, DEBUG);
    }

    private static String toUpperCase(String str) {
        return str.toUpperCase(Locale.ENGLISH);
    }

    public static Level valueOf(String str) {
        Objects.requireNonNull(str, "No level name given.");
        String upperCase = toUpperCase(str.trim());
        Level level = LEVELS.get(upperCase);
        if (level != null) {
            return level;
        }
        throw new IllegalArgumentException(AbstractC0157z.o("Unknown level constant [", upperCase, "]."));
    }

    public static Level[] values() {
        return (Level[]) LEVELS.values().toArray(EMPTY_ARRAY);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Level) && obj == this;
    }

    public Class<Level> getDeclaringClass() {
        return Level.class;
    }

    public StandardLevel getStandardLevel() {
        return this.standardLevel;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public int intLevel() {
        return this.intLevel;
    }

    public boolean isInRange(Level level, Level level2) {
        int i5 = this.intLevel;
        return i5 >= level.intLevel && i5 <= level2.intLevel;
    }

    public boolean isLessSpecificThan(Level level) {
        return this.intLevel >= level.intLevel;
    }

    public boolean isMoreSpecificThan(Level level) {
        return this.intLevel <= level.intLevel;
    }

    public String name() {
        return this.name;
    }

    public Object readResolve() {
        return valueOf(this.name);
    }

    public String toString() {
        return this.name;
    }

    public static Level toLevel(String str, Level level) {
        Level level2;
        return (str == null || (level2 = LEVELS.get(toUpperCase(str.trim()))) == null) ? level : level2;
    }

    public Level clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    @Override // java.lang.Comparable
    public int compareTo(Level level) {
        int i5 = this.intLevel;
        int i6 = level.intLevel;
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }

    public static <T extends Enum<T>> T valueOf(Class<T> cls, String str) {
        return (T) Enum.valueOf(cls, str);
    }
}
