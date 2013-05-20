package com.seigneurin;

public class MuPuzzle {

    public String applyRule(String str, int rule) {
        switch (rule) {
        case 1:
            return applyRule1(str);
        case 2:
            return applyRule2(str);
        case 3:
            return applyRule3(str);
        case 4:
            return applyRule4(str);
        default:
            throw new RuntimeException("Unknown rule: " + rule);
        }
    }

    // Ajouter U à la fin de toute chaîne finissant par I.
    private String applyRule1(String str) {
        if (str.endsWith("I"))
            return str + "U";
        return str;
    }

    // Dupliquer le reste de la chaine après le M initial (cad modifier Mx en Mxx).
    private String applyRule2(String str) {
        String suffix = str.substring(1);
        return "M" + suffix + suffix;
    }

    // Remplacer toutes les occurrences de III de la chaîne par U.
    private String applyRule3(String str) {
        String res = str.replaceAll("III", "U");
        return res;
    }

    // Supprimer toutes les occurrences de UU de la chaîne.
    private String applyRule4(String str) {
        String res = str.replaceAll("UU", "");
        return res;
    }

}
