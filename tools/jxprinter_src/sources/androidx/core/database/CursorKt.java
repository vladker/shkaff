package androidx.core.database;

import android.database.Cursor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return cursor.getBlob(i5);
    }

    public static final Double getDoubleOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i5));
    }

    public static final Float getFloatOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i5));
    }

    public static final Integer getIntOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i5));
    }

    public static final Long getLongOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i5));
    }

    public static final Short getShortOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i5));
    }

    public static final String getStringOrNull(Cursor cursor, int i5) {
        if (cursor.isNull(i5)) {
            return null;
        }
        return cursor.getString(i5);
    }
}
