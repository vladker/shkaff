package com.zlylib.fileselectorlib.bean;

import A3.AbstractC0157z;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import com.zlylib.fileselectorlib.utils.FileUtils;
import com.zlylib.fileselectorlib.utils.MimeType;
import com.zlylib.fileselectorlib.utils.PathUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class EssFile implements Parcelable {
    public static final int CAPTURE = 0;
    public static final Parcelable.Creator<EssFile> CREATOR = new Parcelable.Creator<EssFile>() { // from class: com.zlylib.fileselectorlib.bean.EssFile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EssFile createFromParcel(Parcel parcel) {
            return new EssFile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public EssFile[] newArray(int i5) {
            return new EssFile[i5];
        }
    };
    public static final int MEDIA = 1;
    private String childFileCount;
    private String childFolderCount;
    private boolean isChecked;
    private boolean isDirectory;
    private boolean isExits;
    private boolean isFile;
    private int itemType;
    private String mFileName;
    private String mFilePath;
    private String mimeType;
    private Uri uri;

    public EssFile(Parcel parcel) {
        this.childFolderCount = "加载中";
        this.childFileCount = "加载中";
        this.isChecked = false;
        this.isExits = false;
        this.isDirectory = false;
        this.isFile = false;
        this.itemType = 1;
        this.mFilePath = parcel.readString();
        this.mimeType = parcel.readString();
        this.childFolderCount = parcel.readString();
        this.childFileCount = parcel.readString();
        this.isChecked = parcel.readByte() != 0;
        this.isExits = parcel.readByte() != 0;
        this.isDirectory = parcel.readByte() != 0;
        this.isFile = parcel.readByte() != 0;
        this.mFileName = parcel.readString();
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.itemType = parcel.readInt();
    }

    public static List<EssFile> getEssFileList(List<File> list, boolean z6) {
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            if (!z6) {
                arrayList.add(new EssFile(file));
            } else if (isFolder(file)) {
                arrayList.add(new EssFile(file));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> getFilePathList(ArrayList<EssFile> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            EssFile essFile = arrayList.get(i5);
            i5++;
            arrayList2.add(essFile.getAbsolutePath());
        }
        return arrayList2;
    }

    public static boolean isFolder(File file) {
        return file.isDirectory();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EssFile)) {
            return false;
        }
        EssFile essFile = (EssFile) obj;
        Uri uri = this.uri;
        return uri == null ? this.mFilePath.equalsIgnoreCase(essFile.getAbsolutePath()) : uri.equals(essFile.getUri());
    }

    public String getAbsolutePath() {
        return this.mFilePath;
    }

    public String getChildFileCount() {
        return this.childFileCount;
    }

    public String getChildFolderCount() {
        return this.childFolderCount;
    }

    public File getFile() {
        return new File(this.mFilePath);
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return new File(this.mFilePath).getName();
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        String str = this.mFilePath;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Uri uri = this.uri;
        return ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.itemType;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isDirectory() {
        return this.isDirectory;
    }

    public boolean isExits() {
        return this.isExits;
    }

    public boolean isFile() {
        return this.isFile;
    }

    public boolean isGif() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        return str.equals(MimeType.GIF.toString());
    }

    public boolean isImage() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        return str.equals(MimeType.JPEG.toString()) || this.mimeType.equals(MimeType.PNG.toString()) || this.mimeType.equals(MimeType.GIF.toString()) || this.mimeType.equals(MimeType.BMP.toString()) || this.mimeType.equals(MimeType.WEBP.toString());
    }

    public boolean isVideo() {
        String str = this.mimeType;
        if (str == null) {
            return false;
        }
        return str.equals(MimeType.MPEG.toString()) || this.mimeType.equals(MimeType.MP4.toString()) || this.mimeType.equals(MimeType.QUICKTIME.toString()) || this.mimeType.equals(MimeType.THREEGPP.toString()) || this.mimeType.equals(MimeType.THREEGPP2.toString()) || this.mimeType.equals(MimeType.MKV.toString()) || this.mimeType.equals(MimeType.WEBM.toString()) || this.mimeType.equals(MimeType.TS.toString()) || this.mimeType.equals(MimeType.AVI.toString());
    }

    public void setChecked(boolean z6) {
        this.isChecked = z6;
    }

    public void setChildCounts(String str, String str2) {
        this.childFileCount = str;
        this.childFolderCount = str2;
    }

    public void setChildFileCount(String str) {
        this.childFileCount = str;
    }

    public void setChildFolderCount(String str) {
        this.childFolderCount = str;
    }

    public void setItemType(int i5) {
        this.itemType = i5;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EssFile{mFilePath='");
        sb.append(this.mFilePath);
        sb.append("', mimeType='");
        sb.append(this.mimeType);
        sb.append("', mFileName='");
        return AbstractC0157z.s(sb, this.mFileName, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.mFilePath);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.childFolderCount);
        parcel.writeString(this.childFileCount);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isExits ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isDirectory ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isFile ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mFileName);
        parcel.writeParcelable(this.uri, i5);
        parcel.writeInt(this.itemType);
    }

    public static ArrayList<EssFile> getEssFileList(Context context, Set<EssFile> set) {
        ArrayList<EssFile> arrayList = new ArrayList<>();
        for (EssFile essFile : set) {
            essFile.mFilePath = PathUtils.getPath(context, essFile.uri);
            arrayList.add(essFile);
        }
        return arrayList;
    }

    public EssFile(String str) {
        this.childFolderCount = "加载中";
        this.childFileCount = "加载中";
        this.isChecked = false;
        this.isExits = false;
        this.isDirectory = false;
        this.isFile = false;
        this.itemType = 1;
        this.mFilePath = str;
        File file = new File(this.mFilePath);
        if (file.exists()) {
            this.isExits = true;
            this.isDirectory = file.isDirectory();
            this.isFile = file.isFile();
            this.mFileName = file.getName();
        }
        this.mimeType = FileUtils.getMimeType(this.mFilePath);
    }

    public EssFile(File file) {
        this.childFolderCount = "加载中";
        this.childFileCount = "加载中";
        this.isChecked = false;
        this.isExits = false;
        this.isDirectory = false;
        this.isFile = false;
        this.itemType = 1;
        this.mFilePath = file.getAbsolutePath();
        if (file.exists()) {
            this.isExits = true;
            this.isDirectory = file.isDirectory();
            this.isFile = file.isFile();
        }
        this.mimeType = FileUtils.getMimeType(file.getAbsolutePath());
    }

    public EssFile(long j6, String str) {
        Uri contentUri;
        this.childFolderCount = "加载中";
        this.childFileCount = "加载中";
        this.isChecked = false;
        this.isExits = false;
        this.isDirectory = false;
        this.isFile = false;
        this.itemType = 1;
        this.mimeType = str;
        if (isImage()) {
            contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (isVideo()) {
            contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            contentUri = MediaStore.Files.getContentUri("external");
        }
        this.uri = ContentUris.withAppendedId(contentUri, j6);
    }
}
