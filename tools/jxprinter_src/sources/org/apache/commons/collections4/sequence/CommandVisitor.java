package org.apache.commons.collections4.sequence;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface CommandVisitor<T> {
    void visitDeleteCommand(T t6);

    void visitInsertCommand(T t6);

    void visitKeepCommand(T t6);
}
