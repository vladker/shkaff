package org.apache.xmlbeans.impl.soap;

import A3.AbstractC0157z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import org.apache.xmlbeans.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
class FactoryFinder {
    public static Object find(String str, String str2) throws SOAPException {
        try {
            String property = SystemProperties.getProperty(str);
            if (property != null) {
                return newInstance(property);
            }
        } catch (SecurityException unused) {
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemProperties.getProperty("java.home"));
            String str3 = File.separator;
            sb.append(str3);
            sb.append("lib");
            sb.append(str3);
            sb.append("jaxm.properties");
            File file = new File(sb.toString());
            if (file.exists()) {
                Properties properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    return newInstance(properties.getProperty(str));
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        try {
            InputStream resource = getResource(AbstractC0157z.n("META-INF/services/", str));
            if (resource != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8));
                try {
                    String line = bufferedReader.readLine();
                    bufferedReader.close();
                    if (line != null && !"".equals(line)) {
                        return newInstance(line);
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            }
        } catch (Exception unused3) {
        }
        if (str2 != null) {
            return newInstance(str2);
        }
        throw new SOAPException(AbstractC0157z.o("Provider for ", str, " cannot be found"), null);
    }

    private static InputStream getResource(String str) {
        ClassLoader contextClassLoader;
        try {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            contextClassLoader = null;
        }
        InputStream systemResourceAsStream = contextClassLoader == null ? ClassLoader.getSystemResourceAsStream(str) : contextClassLoader.getResourceAsStream(str);
        if (systemResourceAsStream == null) {
            systemResourceAsStream = FactoryFinder.class.getResourceAsStream(str);
        }
        return (systemResourceAsStream != null || FactoryFinder.class.getClassLoader() == null) ? systemResourceAsStream : FactoryFinder.class.getClassLoader().getResourceAsStream(str);
    }

    private static Object newInstance(String str) throws SOAPException {
        Class<?> clsLoadClass;
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            try {
                if (contextClassLoader == null) {
                    try {
                        clsLoadClass = Class.forName(str);
                    } catch (ClassNotFoundException e) {
                        throw new SOAPException(AbstractC0157z.o("Provider ", str, " not found"), e);
                    }
                } else {
                    try {
                        clsLoadClass = contextClassLoader.loadClass(str);
                    } catch (ClassNotFoundException unused) {
                        clsLoadClass = null;
                    }
                }
                if (clsLoadClass == null) {
                    clsLoadClass = FactoryFinder.class.getClassLoader().loadClass(str);
                }
                return clsLoadClass.getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e6) {
                throw new SOAPException("Provider " + str + " could not be instantiated: " + e6, e6);
            }
        } catch (Exception e7) {
            throw new SOAPException(e7.toString(), e7);
        }
    }
}
