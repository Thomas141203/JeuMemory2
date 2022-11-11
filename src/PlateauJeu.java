
/**
 *
 * @author Thomas
 */

public class PlateauJeu{
    
    private int tab[][]; // Attribut représentant la dimension du plateau de jeu
    private int nbp; // Nombre de personnages sur le plateau qui diminue au cours du jeu
    private int nblig; // Attribut qui correspond au nombre de ligne du plateau de jeu
    private int nbcol; // Attribut qui correspond au nombre de colonne du plateau de jeu
    
    public PlateauJeu(int n){
        // Constructeur de la class PlateauJeu qui attend en paramètre un entier correspondant au nombre de personnages de départ
        // Puis on y initialise les attributs et le Plateau de Jeu
        this.nbp = n;
        this.nblig = (int)(Math.sqrt(nbp*2));
        this.nbcol = this.nbp*2/this.nblig;
        this.tab = new int[this.nblig][this.nbcol];
        initPlateauJeu();
    }
    
    public PlateauJeu(){
        // Constructeur par défaut avec comme nombre de personnages par défaut 4
        this(4);
    }

    public int getNbp(){
        // getteur de l'attribut nbp
        return this.nbp;
    }

    public int getNblig(){
        // getteur de l'attribut nblig
        return this.nblig;
    }

    public int getNbcol(){
        // getteur de l'attribut nbcol
        return this.nbcol;
    }
    
    public int getCase(int l, int c){
        // Méthode qui retourne la case selon la ligne et la colonne passé en paramètres
        return this.tab[l][c];
    }
    
    public int getNbc(){
        // Méthode pour savoir le nombre de case du plateau de jeu
        return this.nblig*this.nbcol/2;
    }
    
    public void initPlateauJeu(){
        // Cette méthode permet d'initialiser le Plateau de jeu
        int k = 0;
        for(int i=0; i<this.nblig; i++){
            for(int j=0; j<this.nbcol; j++){
                tab[i][j] = (k++)%this.nbp;
            }
        }
        //melange();
    }
    
    public void invalide(int l1, int c1, int l2, int c2){
        // Cette méthode indiquent que les cases l1,c1 et l2,c2 sont déjà jouées et qu'il est invalide d'y jouée
        tab[l1][c1] = -1;
        tab[l2][c2] = -1;
        nbp--;
    }
    
    public void melange(){
        // méthode pour mélanger les cartes aléatoirement sur le plateau de jeu
        int aux;
        for(int i = 0 ; i<1000 ; i++){
            int li1 = (int)(0+(nblig-1-0)*Math.random());
            int co1 = (int)(0+(nbcol-1-0)*Math.random());
            int li2 = (int)(0+(nblig-1-0)*Math.random());
            int co2 = (int)(0+(nbcol-1-0)*Math.random());
            aux = tab[li1 ][co1];
            tab[li1][co1] = tab[li2][co2];
            tab[li2][co2] = aux;
        }
    }
    
    public boolean jeuVide(){
        // Cette méthode renvoie true ou false en fonction du nombre de personnages restant sur le plateau, si il en reste 0 alors le jeu est vide
        boolean ok = true;
        for(int i=0; i<this.nblig; i++)
            for(int j=0; j<this.nbcol; j++){
                if(tab[i][j] != -1)
                    ok = false;
            }
        return ok;
    }
    
    public boolean estVide(int l, int c){
        // Cette méthode permet de vérifier si la case a déjà été jouée et donc si elle est occupée
        return tab[l][c] != -1;
    }
    
    public void termineJeu(){
        // Cette méthode permet de mettre toute les cases à -1, soit de terminer le jeu en mettant chaqu'une des cases comme invalide
        // Puis on met le nombre de personnages à 0 
        for(int i=0; i<this.nblig; i++){
            for(int j=0; j<this.nbcol; j++){
                tab[i][j] = -1;
            }
        }
        this.nbp = 0;
    }
}