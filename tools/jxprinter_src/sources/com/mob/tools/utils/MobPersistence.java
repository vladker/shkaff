package com.mob.tools.utils;

/* JADX INFO: loaded from: classes3.dex */
public class MobPersistence {

    public static class NoValidDataException extends Exception {
        public NoValidDataException() {
            this("No valid data found");
        }

        public NoValidDataException(String str) {
            super(str);
        }
    }
}
