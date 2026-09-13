package org.apache.poi.ss.format;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public enum CellFormatType {
    GENERAL { // from class: org.apache.poi.ss.format.CellFormatType.1
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellGeneralFormatter();
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(Locale locale, String str) {
            return new CellGeneralFormatter(locale);
        }
    },
    NUMBER { // from class: org.apache.poi.ss.format.CellFormatType.2
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellNumberFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(Locale locale, String str) {
            return new CellNumberFormatter(locale, str);
        }
    },
    DATE { // from class: org.apache.poi.ss.format.CellFormatType.3
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellDateFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            if (c != '\'') {
                return c <= 127 && Character.isLetter(c);
            }
            return true;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(Locale locale, String str) {
            return new CellDateFormatter(locale, str);
        }
    },
    ELAPSED { // from class: org.apache.poi.ss.format.CellFormatType.4
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellElapsedFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(Locale locale, String str) {
            return new CellElapsedFormatter(str);
        }
    },
    TEXT { // from class: org.apache.poi.ss.format.CellFormatType.5
        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(String str) {
            return new CellTextFormatter(str);
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public boolean isSpecial(char c) {
            return false;
        }

        @Override // org.apache.poi.ss.format.CellFormatType
        public CellFormatter formatter(Locale locale, String str) {
            return new CellTextFormatter(str);
        }
    };

    public abstract CellFormatter formatter(String str);

    public abstract CellFormatter formatter(Locale locale, String str);

    public abstract boolean isSpecial(char c);
}
