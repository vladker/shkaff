package org.apache.commons.compress.archivers.dump;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class Dirent {
    private final int ino;
    private final String name;
    private final int parentIno;
    private final int type;

    public Dirent(int i5, int i6, int i7, String str) {
        this.ino = i5;
        this.parentIno = i6;
        this.type = i7;
        this.name = str;
    }

    public int getIno() {
        return this.ino;
    }

    public String getName() {
        return this.name;
    }

    public int getParentIno() {
        return this.parentIno;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return String.format("[%d]: %s", Integer.valueOf(this.ino), this.name);
    }
}
