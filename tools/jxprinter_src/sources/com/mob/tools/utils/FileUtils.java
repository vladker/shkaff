package com.mob.tools.utils;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes3.dex */
public class FileUtils implements PublicMemberKeeper {
    public static boolean copyFile(File file, File file2) {
        return cn.fly.tools.utils.FileUtils.copyFile(file, file2);
    }

    public static boolean createFileByDeleteOldFile(File file) {
        return cn.fly.tools.utils.FileUtils.createFileByDeleteOldFile(file);
    }

    public static boolean createOrExistsDir(File file) {
        return cn.fly.tools.utils.FileUtils.createOrExistsDir(file);
    }

    public static boolean deleteAllInDir(String str) {
        return cn.fly.tools.utils.FileUtils.deleteAllInDir(str);
    }

    public static boolean deleteDir(File file) {
        return cn.fly.tools.utils.FileUtils.deleteDir(file);
    }

    public static boolean deleteFile(String str) {
        return cn.fly.tools.utils.FileUtils.deleteFile(str);
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
        return cn.fly.tools.utils.FileUtils.deleteFilesInDirWithFilter(file, fileFilter);
    }

    public static File getFileByPath(String str) {
        return cn.fly.tools.utils.FileUtils.getFileByPath(str);
    }

    public static long getLATime(String str) {
        return cn.fly.tools.utils.FileUtils.getLATime(str);
    }

    public static boolean rename(String str, String str2) {
        return cn.fly.tools.utils.FileUtils.rename(str, str2);
    }

    public static boolean deleteAllInDir(File file) {
        return cn.fly.tools.utils.FileUtils.deleteAllInDir(file);
    }

    public static boolean deleteFile(File file) {
        return cn.fly.tools.utils.FileUtils.deleteFile(file);
    }

    public static boolean rename(File file, String str) {
        return cn.fly.tools.utils.FileUtils.rename(file, str);
    }
}
