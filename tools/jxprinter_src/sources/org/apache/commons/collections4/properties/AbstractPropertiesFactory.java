package org.apache.commons.collections4.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractPropertiesFactory<T extends Properties> {
    public abstract T createProperties();

    public T load(ClassLoader classLoader, String str) throws IOException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        try {
            T t6 = (T) load(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public T load(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            T t6 = (T) load(fileInputStream);
            fileInputStream.close();
            return t6;
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

    public T load(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        T t6 = (T) createProperties();
        t6.load(inputStream);
        return t6;
    }

    public T load(Path path) throws IOException {
        InputStream inputStreamNewInputStream = Files.newInputStream(path, new OpenOption[0]);
        try {
            T t6 = (T) load(inputStreamNewInputStream);
            if (inputStreamNewInputStream != null) {
                inputStreamNewInputStream.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamNewInputStream != null) {
                    try {
                        inputStreamNewInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public T load(Reader reader) throws IOException {
        T t6 = (T) createProperties();
        t6.load(reader);
        return t6;
    }

    public T load(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            T t6 = (T) load(fileInputStream);
            fileInputStream.close();
            return t6;
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

    public T load(URI uri) {
        return (T) load(Paths.get(uri));
    }

    public T load(URL url) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            T t6 = (T) load(inputStreamOpenStream);
            if (inputStreamOpenStream != null) {
                inputStreamOpenStream.close();
            }
            return t6;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStreamOpenStream != null) {
                    try {
                        inputStreamOpenStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
