package com.appdev.standard.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class AppBannerModel implements Parcelable {
    public static final Parcelable.Creator<AppBannerModel> CREATOR = new Parcelable.Creator<AppBannerModel>() { // from class: com.appdev.standard.model.AppBannerModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppBannerModel createFromParcel(Parcel parcel) {
            return new AppBannerModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppBannerModel[] newArray(int i5) {
            return new AppBannerModel[i5];
        }
    };
    private String imgUrl;
    private String linkUrl;
    private int type;

    public AppBannerModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getLinkUrl() {
        return this.linkUrl;
    }

    public int getType() {
        return this.type;
    }

    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setLinkUrl(String str) {
        this.linkUrl = str;
    }

    public void setType(int i5) {
        this.type = i5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.linkUrl);
        parcel.writeInt(this.type);
    }

    public AppBannerModel(Parcel parcel) {
        this.imgUrl = parcel.readString();
        this.linkUrl = parcel.readString();
        this.type = parcel.readInt();
    }
}
