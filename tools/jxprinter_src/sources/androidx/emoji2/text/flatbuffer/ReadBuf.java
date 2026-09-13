package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i5);

    boolean getBoolean(int i5);

    double getDouble(int i5);

    float getFloat(int i5);

    int getInt(int i5);

    long getLong(int i5);

    short getShort(int i5);

    String getString(int i5, int i6);

    int limit();
}
