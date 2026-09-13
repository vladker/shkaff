package cn.fly.tools;

import android.text.TextUtils;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.x;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.util.HashSet;
import kotlinx.serialization.json.internal.AbstractC1127c;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1596a = new Object();
    private static final Object b = new Object();
    private volatile HashSet<String> c = new HashSet<>();
    private File d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f1597f;

    /* JADX INFO: renamed from: cn.fly.tools.a$a, reason: collision with other inner class name */
    public interface InterfaceC0024a {
        void a(String str);

        boolean a(DH.DHResponse dHResponse);
    }

    public a(String str, String str2, int i5) {
        this.e = i5;
        if (str2 == null) {
            str2 = AbstractC1127c.NULL;
        } else if (TextUtils.isDigitsOnly(str2)) {
            str2 = androidx.collection.a.n(str, str2);
        }
        this.f1597f = str2;
        File dataCacheFile = ResHelper.getDataCacheFile(FlySDK.getContextSafely(), str);
        this.d = dataCacheFile;
        if (dataCacheFile.isDirectory()) {
            return;
        }
        this.d.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        synchronized (this.c) {
            try {
                if (this.c.contains(str)) {
                    return true;
                }
                this.c.add(str);
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(String str) {
        a(str, false);
    }

    public void a(String str, boolean z6) {
        FileWriter fileWriter;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strEncodeToString = Base64.encodeToString(str.getBytes("utf-8"), 2);
        if (TextUtils.isEmpty(strEncodeToString)) {
            return;
        }
        synchronized (f1596a) {
            File fileA = a(z6);
            BufferedWriter bufferedWriter = null;
            try {
                fileWriter = new FileWriter(fileA, true);
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.newLine();
                        bufferedWriter2.write(strEncodeToString);
                        C0396r.a(bufferedWriter2, fileWriter);
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        try {
                            FlyLog.getInstance().d(th);
                            C0396r.a(bufferedWriter, fileWriter);
                        } catch (Throwable th2) {
                            C0396r.a(bufferedWriter, fileWriter);
                            c(fileA.getName());
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                fileWriter = null;
            }
            c(fileA.getName());
        }
    }

    private File a(boolean z6) {
        File file;
        File[] fileArrListFiles = this.d.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            int i5 = 1;
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (name.startsWith(this.f1597f)) {
                    String[] strArrSplit = name.split("_");
                    if (!z6 && strArrSplit.length == 3) {
                        try {
                            int i6 = Integer.parseInt(strArrSplit[2]);
                            if (i6 < this.e && !b(name)) {
                                File file3 = new File(this.d, a(this.f1597f, "_", Integer.valueOf(i5), "_", Integer.valueOf(i6 + 1)));
                                return file2.renameTo(file3) ? file3 : file2;
                            }
                        } catch (Throwable th) {
                            FlyLog.getInstance().d(th);
                        }
                    }
                    if (strArrSplit.length > 1) {
                        try {
                            if (Integer.parseInt(strArrSplit[1]) == i5) {
                                i5++;
                            }
                        } catch (Throwable th2) {
                            FlyLog.getInstance().d(th2);
                        }
                    }
                }
            }
            file = new File(this.d, a(this.f1597f, "_", Integer.valueOf(i5), "_", 0));
        } else {
            file = new File(this.d, a(this.f1597f, "_", 1, "_", 0));
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
        return file;
    }

    public void a(final InterfaceC0024a interfaceC0024a) {
        if (interfaceC0024a == null) {
            return;
        }
        synchronized (b) {
            try {
                final File[] fileArrListFiles = this.d.listFiles(new FilenameFilter() { // from class: cn.fly.tools.a.1
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        return !TextUtils.isEmpty(str) && str.startsWith(a.this.f1597f);
                    }
                });
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    DH.requester(FlySDK.getContext()).getDetailNetworkTypeForStatic().getAppName().getDeviceKey().getODH().request(new DH.DHResponder() { // from class: cn.fly.tools.a.2
                        @Override // cn.fly.tools.utils.DH.DHResponder
                        public void onResponse(DH.DHResponse dHResponse) {
                            BufferedReader bufferedReader;
                            if (x.b("004d2cjMde").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                                return;
                            }
                            for (File file : fileArrListFiles) {
                                String name = file.getName();
                                if (!a.this.b(name)) {
                                    FileReader fileReader = null;
                                    try {
                                        FileReader fileReader2 = new FileReader(file);
                                        try {
                                            bufferedReader = new BufferedReader(fileReader2);
                                            while (true) {
                                                try {
                                                    String line = bufferedReader.readLine();
                                                    if (line == null) {
                                                        break;
                                                    }
                                                    String str = new String(Base64.decode(line, 2), "utf-8");
                                                    if (!TextUtils.isEmpty(str)) {
                                                        interfaceC0024a.a(str);
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    fileReader = fileReader2;
                                                    try {
                                                        FlyLog.getInstance().d(th);
                                                        C0396r.a(bufferedReader, fileReader);
                                                    } catch (Throwable th2) {
                                                        C0396r.a(bufferedReader, fileReader);
                                                        a.this.c(name);
                                                        throw th2;
                                                    }
                                                }
                                            }
                                            if (interfaceC0024a.a(dHResponse)) {
                                                FlyLog.getInstance().d("[LGSM] D l", new Object[0]);
                                                file.delete();
                                            }
                                            C0396r.a(bufferedReader, fileReader2);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            bufferedReader = null;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        bufferedReader = null;
                                    }
                                    a.this.c(name);
                                }
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb.toString();
    }
}
