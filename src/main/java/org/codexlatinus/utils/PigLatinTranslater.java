package org.codexlatinus.utils;

public class PigLatinTranslater {

    private static final String VOCALES = "aeiouAEIOU";

    public static String convert(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        if (VOCALES.indexOf(text.charAt(0)) >= 0) {
            return text + "way";
        }

        int firstVowel = 0;
        while (firstVowel < text.length() && VOCALES.indexOf(text.charAt(firstVowel)) < 0) {
            firstVowel++;
        }

        if (firstVowel == text.length()) {
            return text + "ay";
        }

        return text.substring(firstVowel) + text.substring(0, firstVowel) + "ay";
    }

    public static String convertKeyword(String kw) {
        if (kw == null || kw.isEmpty()) return kw;
        return switch (kw) {
            case "VARIABILES>" -> "ARIABILESVAY>";
            case "MUNERA>" -> "UNERAMAY>";
            case "MAIOR>" -> "AIORMAY>";
            case "FINIS", "finis" -> "inisfay";
            case "esto" -> "estoway";
            case "series" -> "eriessay";
            case "structura" -> "ucturastray";
            case "numerus" -> "umerusnay";
            case "decimalis" -> "ecimalisday";
            case "textum" -> "extumtay";
            case "littera" -> "itteralay";
            case "bool" -> "oolbay";
            case "boolean" -> "ooleanbay";
            case "verum" -> "erumvay";
            case "falsus" -> "alsusfay";
            case "si" -> "isay";
            case "aliter" -> "aliterway";
            case "dum" -> "umday";
            case "facere" -> "acerefay";
            case "per" -> "erpay";
            case "actio" -> "actioway";
            case "ratio" -> "atioray";
            case "reddere" -> "eddereray";
            case "interrumpe" -> "interrumpeway";
            case "perge" -> "ergepay";
            case ">>" -> "%OINK";
            case "<<" -> "%OINK_OINK";
            default -> convert(kw);
        };
    }

    public static String traducir(String text) {
        return convertKeyword(text);
    }
}
