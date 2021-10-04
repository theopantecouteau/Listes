package Listes;

import javax.lang.model.type.NullType;

import java.util.List;

import static Listes.Liste.copie;
import static Listes.Liste.estVide;

public class Exerice1 {

    private Liste l;

    public static void main(String[] args) {
        Liste l1 = new Liste(7);
        Liste l2 = new Liste(9, l1);
        Liste l3 = new Liste(4, l2);
        Liste l = new Liste(2, l3);
        Liste l5 = new Liste(19);

        /*System.out.println(longueur(l));
        System.out.println(estCroissant(l));
        Liste res = ajoutFinV1(l, 19);
        ajoutFinV3(l,19);
        ajoutFinV2(l,29);*/
        Liste res = concatV2(l,l5);
        String liste = Liste.toString(res);
        System.out.println(liste);
    }

    static int longueur(Liste l) {
        if (estVide(l)) {
            return 0;
        } else {
            return longueur(l.getSuiv()) + 1;
        }
    }


    static boolean estCroissant(Liste l) {
        if (estVide(l.getSuiv())) {
            return true;
        } else {
            if (l.getVal() > l.getSuiv().getVal()) {
                return false;
            } else {
                return estCroissant(l.getSuiv());
            }
        }
    }

    public static Liste ajoutFinV3(Liste l, int x) {
        if (estVide(l)) {
            return new Liste(x);
        } else {
            l.setSuiv(ajoutFinV3(l.getSuiv(), x));
            return l;
        }
    }

    public static void ajoutFinV2(Liste l, int x) {
        l.setSuiv(ajoutFinV1(l.getSuiv(), x));

    }

    public static Liste ajoutFinV1(Liste l, int x) {
        if (estVide(l)) {
            return new Liste(x, null);
        } else {
            Liste res = new Liste(l.getVal(), l.getSuiv());
            ajoutFinV1(l.getSuiv(), x);
            res.setSuiv(ajoutFinV1(l.getSuiv(), x));
            return res;
        }
    }

    public static Liste concatV1( Liste l1, Liste l2) {
        if (estVide(l1)) {
            return l2;
        } else {
            Liste res = concatV1(l1.getSuiv(), l2);
            l1.setSuiv(res);
            return l1;
        }
    }

    public static Liste concatV2 (Liste l1, Liste l2){
        if (estVide(l1)){
            Liste tmp = copie(l2);
            return tmp;
        }
        else{
            Liste liste = concatV2(l1.getSuiv(), l2);
            Liste tmp2 =  new Liste(l1.getVal(), liste);
            return tmp2;

        }
    }

}

