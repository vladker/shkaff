package org.apache.xmlbeans.impl.schema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.xmlbeans.ResourceLoader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class PathResourceLoader implements ResourceLoader {
    private ResourceLoader[] _path;

    public PathResourceLoader(ResourceLoader[] resourceLoaderArr) {
        ResourceLoader[] resourceLoaderArr2 = new ResourceLoader[resourceLoaderArr.length];
        this._path = resourceLoaderArr2;
        System.arraycopy(resourceLoaderArr, 0, resourceLoaderArr2, 0, resourceLoaderArr2.length);
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public void close() {
        int i5 = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i5 >= resourceLoaderArr.length) {
                return;
            }
            try {
                resourceLoaderArr[i5].close();
            } catch (Exception unused) {
            }
            i5++;
        }
    }

    @Override // org.apache.xmlbeans.ResourceLoader
    public InputStream getResourceAsStream(String str) {
        int i5 = 0;
        while (true) {
            ResourceLoader[] resourceLoaderArr = this._path;
            if (i5 >= resourceLoaderArr.length) {
                return null;
            }
            InputStream resourceAsStream = resourceLoaderArr[i5].getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
            i5++;
        }
    }

    public PathResourceLoader(File[] fileArr) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            try {
                arrayList.add(new FileResourceLoader(file));
            } catch (IOException unused) {
            }
        }
        this._path = (ResourceLoader[]) arrayList.toArray(new ResourceLoader[arrayList.size()]);
    }
}
