package org.apache.poi;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EmptyFileException extends IllegalArgumentException {
    private static final long serialVersionUID = 1536449292174360166L;

    public EmptyFileException() {
        super("The supplied file was empty (zero bytes long)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public EmptyFileException(File file) {
        String str;
        if (file.exists()) {
            str = "The supplied file '" + file.getAbsolutePath() + "' was empty (zero bytes long)";
        } else {
            str = "The file '" + file.getAbsolutePath() + "' does not exist";
        }
        super(str);
    }
}
