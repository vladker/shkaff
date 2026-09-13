package p096r;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet f7920a = new HashSet();

    public static Set a(Class cls, ClassLoader classLoader) throws Throwable {
        if (classLoader == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        String strConcat = "META-INF/services/".concat(cls.getName());
        HashSet hashSet2 = new HashSet();
        try {
            Enumeration<URL> resources = classLoader.getResources(strConcat);
            while (resources.hasMoreElements()) {
                URL urlNextElement = resources.nextElement();
                HashSet hashSet3 = f7920a;
                if (!hashSet3.contains(urlNextElement.toString())) {
                    load(urlNextElement, hashSet2);
                    hashSet3.add(urlNextElement.toString());
                }
            }
        } catch (IOException unused) {
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            try {
                hashSet.add(classLoader.loadClass((String) it.next()).newInstance());
            } catch (Exception unused2) {
            }
        }
        return hashSet;
    }

    public static void load(URL url, Set<String> set) throws Throwable {
        InputStream inputStreamOpenStream;
        BufferedReader bufferedReader = null;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStreamOpenStream, "utf-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        int iIndexOf = line.indexOf(35);
                        if (iIndexOf >= 0) {
                            line = line.substring(0, iIndexOf);
                        }
                        String strTrim = line.trim();
                        if (strTrim.length() != 0) {
                            set.add(strTrim);
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        Properties properties = e.f7898a;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                        }
                        if (inputStreamOpenStream == null) {
                            throw th;
                        }
                        try {
                            inputStreamOpenStream.close();
                            throw th;
                        } catch (Exception unused2) {
                            throw th;
                        }
                    }
                }
                Properties properties2 = e.f7898a;
                try {
                    bufferedReader2.close();
                } catch (Exception unused3) {
                }
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Exception unused4) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenStream = null;
        }
    }
}
