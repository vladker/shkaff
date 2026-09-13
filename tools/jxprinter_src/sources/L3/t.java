package L3;

import A3.T;
import X3.W;
import X3.b0;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t extends r {
    public static final ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            String name = file.getName();
            if (!E.a(name, Consts.DOT)) {
                if (!E.a(name, "..")) {
                    arrayList.add(file);
                } else if (arrayList.isEmpty() || E.a(((File) T.last((List) arrayList)).getName(), "..")) {
                    arrayList.add(file);
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        return arrayList;
    }

    public static final String c(File file, File file2) throws IOException {
        g components = o.toComponents(file);
        g gVar = new g(components.getRoot(), b(components.getSegments()));
        g components2 = o.toComponents(file2);
        g gVar2 = new g(components2.getRoot(), b(components2.getSegments()));
        if (!E.a(gVar.getRoot(), gVar2.getRoot())) {
            return null;
        }
        int iA = gVar2.a();
        int iA2 = gVar.a();
        int iMin = Math.min(iA2, iA);
        int i5 = 0;
        while (i5 < iMin && E.a(gVar.getSegments().get(i5), gVar2.getSegments().get(i5))) {
            i5++;
        }
        StringBuilder sb = new StringBuilder();
        int i6 = iA - 1;
        if (i5 <= i6) {
            while (!E.a(gVar2.getSegments().get(i6).getName(), "..")) {
                sb.append("..");
                if (i6 != i5) {
                    sb.append(File.separatorChar);
                }
                if (i6 != i5) {
                    i6--;
                }
            }
            return null;
        }
        if (i5 < iA2) {
            if (i5 < iA) {
                sb.append(File.separatorChar);
            }
            List listDrop = T.drop(gVar.getSegments(), i5);
            String separator = File.separator;
            E.e(separator, "separator");
            T.joinTo(listDrop, sb, separator, "", "", -1, "...", null);
        }
        return sb.toString();
    }

    public static final boolean copyRecursively(File file, File target, boolean z6, O3.p onError) {
        E.f(file, "<this>");
        E.f(target, "target");
        E.f(onError, "onError");
        if (!file.exists()) {
            return onError.invoke(file, new w(file)) != x.f455a;
        }
        try {
            for (File file2 : r.walkTopDown(file).onFail(new s(onError, 0))) {
                if (file2.exists()) {
                    File file3 = new File(target, toRelativeString(file2, file));
                    if (file3.exists() && (!file2.isDirectory() || !file3.isDirectory())) {
                        if (z6) {
                            if (file3.isDirectory()) {
                                if (!deleteRecursively(file3)) {
                                }
                            } else if (!file3.delete()) {
                            }
                        }
                        if (onError.invoke(file3, new f(file2, file3, "The destination file already exists.")) == x.f455a) {
                            return false;
                        }
                    }
                    if (file2.isDirectory()) {
                        file3.mkdirs();
                    } else if (copyTo(file2, file3, z6, 8192).length() != file2.length() && onError.invoke(file2, new IOException("Source file wasn't copied completely, length of destination file differs.")) == x.f455a) {
                        return false;
                    }
                } else if (onError.invoke(file2, new w(file2)) == x.f455a) {
                    return false;
                }
            }
            return true;
        } catch (y unused) {
            return false;
        }
    }

    public static final File copyTo(File file, File target, boolean z6, int i5) throws IllegalAccessException, IOException, InvocationTargetException {
        E.f(file, "<this>");
        E.f(target, "target");
        if (!file.exists()) {
            throw new w(file);
        }
        if (target.exists()) {
            if (!z6) {
                throw new f(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new f(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (target.mkdirs()) {
                return target;
            }
            throw new h(file, target, "Failed to create target directory.");
        }
        File parentFile = target.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(target);
            try {
                c.copyTo(fileInputStream, fileOutputStream, i5);
                d.closeFinally(fileOutputStream, null);
                d.closeFinally(fileInputStream, null);
                return target;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    d.closeFinally(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                d.closeFinally(fileInputStream, th3);
                throw th4;
            }
        }
    }

    public static final File createTempDir(String prefix, String str, File file) throws IOException {
        E.f(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        fileCreateTempFile.delete();
        if (fileCreateTempFile.mkdir()) {
            return fileCreateTempFile;
        }
        throw new IOException("Unable to create temporary directory " + fileCreateTempFile + '.');
    }

    public static final File createTempFile(String prefix, String str, File file) throws IOException {
        E.f(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, str, file);
        E.e(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    public static final boolean deleteRecursively(File file) {
        E.f(file, "<this>");
        while (true) {
            boolean z6 = true;
            for (File file2 : r.walkBottomUp(file)) {
                if (file2.delete() || !file2.exists()) {
                    if (z6) {
                    }
                }
                z6 = false;
            }
            return z6;
        }
    }

    public static final boolean endsWith(File file, File other) {
        E.f(file, "<this>");
        E.f(other, "other");
        g components = o.toComponents(file);
        g components2 = o.toComponents(other);
        if (components2.b()) {
            return file.equals(other);
        }
        int iA = components.a() - components2.a();
        if (iA < 0) {
            return false;
        }
        return components.getSegments().subList(iA, components.a()).equals(components2.getSegments());
    }

    public static String getExtension(File file) {
        E.f(file, "<this>");
        String name = file.getName();
        E.e(name, "getName(...)");
        return b0.substringAfterLast(name, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File file) {
        E.f(file, "<this>");
        char c = File.separatorChar;
        String path = file.getPath();
        E.e(path, "getPath(...)");
        return c != '/' ? W.replace(path, c, '/', false) : path;
    }

    public static final String getNameWithoutExtension(File file) {
        E.f(file, "<this>");
        String name = file.getName();
        E.e(name, "getName(...)");
        return b0.substringBeforeLast(name, Consts.DOT, name);
    }

    public static final File normalize(File file) {
        E.f(file, "<this>");
        g components = o.toComponents(file);
        File root = components.getRoot();
        ArrayList arrayListB = b(components.getSegments());
        String separator = File.separator;
        E.e(separator, "separator");
        return resolve(root, T.g(arrayListB, separator, null, null, null, 62));
    }

    public static final File relativeTo(File file, File base) {
        E.f(file, "<this>");
        E.f(base, "base");
        return new File(toRelativeString(file, base));
    }

    public static final File relativeToOrNull(File file, File base) throws IOException {
        E.f(file, "<this>");
        E.f(base, "base");
        String strC = c(file, base);
        if (strC != null) {
            return new File(strC);
        }
        return null;
    }

    public static final File relativeToOrSelf(File file, File base) throws IOException {
        E.f(file, "<this>");
        E.f(base, "base");
        String strC = c(file, base);
        return strC != null ? new File(strC) : file;
    }

    public static final File resolve(File file, File relative) {
        E.f(file, "<this>");
        E.f(relative, "relative");
        if (o.isRooted(relative)) {
            return relative;
        }
        String string = file.toString();
        E.e(string, "toString(...)");
        if (string.length() != 0) {
            char c = File.separatorChar;
            if (!b0.endsWith((CharSequence) string, c, false)) {
                return new File(string + c + relative);
            }
        }
        return new File(string + relative);
    }

    public static final File resolveSibling(File file, File relative) {
        E.f(file, "<this>");
        E.f(relative, "relative");
        g components = o.toComponents(file);
        return resolve(resolve(components.getRoot(), components.a() == 0 ? new File("..") : components.subPath(0, components.a() - 1)), relative);
    }

    public static final boolean startsWith(File file, File other) {
        E.f(file, "<this>");
        E.f(other, "other");
        g components = o.toComponents(file);
        g components2 = o.toComponents(other);
        if (E.a(components.getRoot(), components2.getRoot()) && components.a() >= components2.a()) {
            return components.getSegments().subList(0, components2.a()).equals(components2.getSegments());
        }
        return false;
    }

    public static final String toRelativeString(File file, File base) throws IOException {
        E.f(file, "<this>");
        E.f(base, "base");
        String strC = c(file, base);
        if (strC != null) {
            return strC;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + base + '.');
    }

    public static final File resolveSibling(File file, String relative) {
        E.f(file, "<this>");
        E.f(relative, "relative");
        return resolveSibling(file, new File(relative));
    }

    public static final File resolve(File file, String relative) {
        E.f(file, "<this>");
        E.f(relative, "relative");
        return resolve(file, new File(relative));
    }

    public static final boolean startsWith(File file, String other) {
        E.f(file, "<this>");
        E.f(other, "other");
        return startsWith(file, new File(other));
    }

    public static final boolean endsWith(File file, String other) {
        E.f(file, "<this>");
        E.f(other, "other");
        return endsWith(file, new File(other));
    }
}
