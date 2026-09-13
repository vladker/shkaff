package androidx.datastore.preferences.core;

import L3.t;
import O3.a;
import java.io.File;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.F;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDataStoreFactory$create$delegate$1 extends F implements a {
    final /* synthetic */ a $produceFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(a aVar) {
        super(0);
        this.$produceFile = aVar;
    }

    @Override // O3.a
    public final File invoke() {
        File file = (File) this.$produceFile.invoke();
        if (E.a(t.getExtension(file), "preferences_pb")) {
            File absoluteFile = file.getAbsoluteFile();
            E.e(absoluteFile, "file.absoluteFile");
            return absoluteFile;
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
