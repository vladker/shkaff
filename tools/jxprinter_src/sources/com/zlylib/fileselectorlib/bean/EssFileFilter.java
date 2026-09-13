package com.zlylib.fileselectorlib.bean;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class EssFileFilter implements FileFilter {
    private String[] mTypes;

    public EssFileFilter(String[] strArr) {
        this.mTypes = strArr;
    }

    @Override // java.io.FileFilter
    public boolean accept(File file) {
        if (file.isDirectory() && !file.isHidden()) {
            return true;
        }
        String[] strArr = this.mTypes;
        if (strArr == null || strArr.length <= 0) {
            return !file.isHidden();
        }
        for (String str : strArr) {
            if ((file.getName().endsWith(str.toLowerCase()) || file.getName().endsWith(str.toUpperCase())) && !file.isHidden()) {
                return true;
            }
        }
        return false;
    }
}
