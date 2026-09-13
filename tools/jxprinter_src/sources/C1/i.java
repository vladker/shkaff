package C1;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f124a;
    public final e b;
    public final d c;
    public g d;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f125a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(Context context, String str, String str2, f fVar) {
            this.f125a = context;
            this.b = str;
            this.c = str2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:?, code lost:
        
            throw null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() throws java.lang.Throwable {
            /*
                r5 = this;
                r0 = 0
                C1.i r1 = C1.i.this     // Catch: C1.c -> Ld java.lang.UnsatisfiedLinkError -> Le
                android.content.Context r2 = r5.f125a     // Catch: C1.c -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r3 = r5.b     // Catch: C1.c -> Ld java.lang.UnsatisfiedLinkError -> Le
                java.lang.String r4 = r5.c     // Catch: C1.c -> Ld java.lang.UnsatisfiedLinkError -> Le
                C1.i.a(r1, r2, r3, r4)     // Catch: C1.c -> Ld java.lang.UnsatisfiedLinkError -> Le
                throw r0
            Ld:
                throw r0
            Le:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: C1.i.a.run():void");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class b implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f126a;

        public b(i iVar, String str) {
            this.f126a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f126a);
        }
    }

    public i() {
        this(new j(), new C1.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadLibraryInternal(Context context, String str, String str2) throws Throwable {
        e eVar = this.b;
        HashSet hashSet = this.f124a;
        if (hashSet.contains(str)) {
            log("%s already loaded previously!", str);
            return;
        }
        try {
            ((j) eVar).loadLibrary(str);
            hashSet.add(str);
            log("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            log("Loading the library normally failed: %s", Log.getStackTraceString(e));
            log("%s (%s) was not loaded normally, re-linking...", str, str2);
            File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
            if (!workaroundLibFile.exists()) {
                cleanupOldLibFiles(context, str, str2);
                j jVar = (j) eVar;
                jVar.getClass();
                String[] strArr = Build.SUPPORTED_ABIS;
                if (strArr.length <= 0) {
                    String str3 = Build.CPU_ABI2;
                    strArr = !k.isEmpty(str3) ? new String[]{Build.CPU_ABI, str3} : new String[]{Build.CPU_ABI};
                }
                ((C1.b) this.c).installLibrary(context, strArr, jVar.mapLibraryName(str), workaroundLibFile, this);
            }
            ((j) eVar).loadPath(workaroundLibFile.getAbsolutePath());
            hashSet.add(str);
            log("%s (%s) was re-linked!", str, str2);
        }
    }

    public void cleanupOldLibFiles(Context context, String str, String str2) {
        File workaroundLibDir = getWorkaroundLibDir(context);
        File workaroundLibFile = getWorkaroundLibFile(context, str, str2);
        File[] fileArrListFiles = workaroundLibDir.listFiles(new b(this, ((j) this.b).mapLibraryName(str)));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getAbsolutePath().equals(workaroundLibFile.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public File getWorkaroundLibDir(Context context) {
        return context.getDir("lib", 0);
    }

    public File getWorkaroundLibFile(Context context, String str, String str2) {
        String strMapLibraryName = ((j) this.b).mapLibraryName(str);
        return k.isEmpty(str2) ? new File(getWorkaroundLibDir(context), strMapLibraryName) : new File(getWorkaroundLibDir(context), androidx.collection.a.o(strMapLibraryName, Consts.DOT, str2));
    }

    public void loadLibrary(Context context, String str) {
        loadLibrary(context, str, null, null);
    }

    public i log(g gVar) {
        this.d = gVar;
        return this;
    }

    public void loadLibrary(Context context, String str, String str2) {
        loadLibrary(context, str, str2, null);
    }

    public void log(String str, Object... objArr) {
        log(String.format(Locale.US, str, objArr));
    }

    public void loadLibrary(Context context, String str, f fVar) {
        loadLibrary(context, str, null, fVar);
    }

    public void log(String str) {
        g gVar = this.d;
        if (gVar != null) {
            ((F4.e) gVar).getClass();
            io.flutter.Log.d(FlutterJNI.TAG, str);
        }
    }

    public void loadLibrary(Context context, String str, String str2, f fVar) {
        if (context != null) {
            if (!k.isEmpty(str)) {
                log("Beginning load of %s...", str);
                if (fVar == null) {
                    loadLibraryInternal(context, str, str2);
                    return;
                } else {
                    new Thread(new a(context, str, str2, fVar)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public i(e eVar, d dVar) {
        this.f124a = new HashSet();
        if (eVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (dVar != null) {
            this.b = eVar;
            this.c = dVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }
}
