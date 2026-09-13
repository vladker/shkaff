package com.appdev.standard.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LanguageModel {
    private static final List<LanguageModel> languages;
    private String code;
    private String name;

    static {
        ArrayList arrayList = new ArrayList();
        languages = arrayList;
        arrayList.add(new LanguageModel("zh", "简体中文"));
        arrayList.add(new LanguageModel("en", "English"));
    }

    public LanguageModel(String str, String str2) {
        this.code = str;
        this.name = str2;
    }

    public static List<LanguageModel> getLanguages() {
        return languages;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
