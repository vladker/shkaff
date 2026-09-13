package com.orhanobut.hawk;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Hawk {
    static HawkFacade hawkFacade = new HawkFacade.EmptyHawkFacade();

    private Hawk() {
    }

    public static void build(HawkBuilder hawkBuilder) {
        hawkFacade = new DefaultHawkFacade(hawkBuilder);
    }

    public static boolean contains(String str) {
        return hawkFacade.contains(str);
    }

    public static long count() {
        return hawkFacade.count();
    }

    public static boolean delete(String str) {
        return hawkFacade.delete(str);
    }

    public static boolean deleteAll() {
        return hawkFacade.deleteAll();
    }

    public static void destroy() {
        hawkFacade.destroy();
    }

    public static <T> T get(String str) {
        return (T) hawkFacade.get(str);
    }

    public static HawkBuilder init(Context context) {
        HawkUtils.checkNull("Context", context);
        hawkFacade = null;
        return new HawkBuilder(context);
    }

    public static boolean isBuilt() {
        return hawkFacade.isBuilt();
    }

    public static <T> boolean put(String str, T t6) {
        return hawkFacade.put(str, t6);
    }

    public static <T> T get(String str, T t6) {
        return (T) hawkFacade.get(str, t6);
    }
}
