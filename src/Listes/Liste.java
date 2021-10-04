package Listes;

class Liste{

    private int val;
    private Liste suiv;

    public Liste(int x){//construit la liste avec un entier x
        this.val = x;
        this.suiv = null;
    }
    public Liste(int x, Liste l){
        this.val = x;
        this.suiv = l;
    }
    public static boolean estVide(Liste l){
        return l==null;
    }

    public static Liste copie(Liste l){
//action : retourne une copie de l (en recopiant tous les maillons)
        if(estVide(l)){
            return null;
        }
        else{
            return new Liste(l.val, copie(l.suiv));
        }
    }
    public static String toString(Liste l){
        if(estVide(l))
            return "";
        else
            return l.val+" "+toString(l.suiv);
    }

    public Liste getSuiv() {
        return suiv;
    }

    public int getVal() {
        return val;
    }

    public void setSuiv(Liste suiv){
        this.suiv = suiv;
    }
}
