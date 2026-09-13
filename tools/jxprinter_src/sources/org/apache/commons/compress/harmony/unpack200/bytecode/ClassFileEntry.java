package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.io.DataOutputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ClassFileEntry {
    protected static final ClassFileEntry[] NONE = new ClassFileEntry[0];
    private boolean resolved;

    public abstract void doWrite(DataOutputStream dataOutputStream);

    public abstract boolean equals(Object obj);

    public ClassFileEntry[] getNestedClassFileEntries() {
        return NONE;
    }

    public abstract int hashCode();

    public int objectHashCode() {
        return super.hashCode();
    }

    public void resolve(ClassConstantPool classConstantPool) {
        this.resolved = true;
    }

    public abstract String toString();

    public final void write(DataOutputStream dataOutputStream) {
        if (!this.resolved) {
            throw new IllegalStateException("Entry has not been resolved");
        }
        doWrite(dataOutputStream);
    }
}
