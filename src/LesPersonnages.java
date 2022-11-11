import java.util.ArrayList;

/**
 *
 * @author Thomas
 */

public class LesPersonnages{
    
    private ArrayList<Personnage> persos; //Attribut de type ArrayList<Personnage> qui correspond à une collection de personnage
    
    public ArrayList<Personnage> getPersos(){
        // Méthode qui renvoie la liste des personnages 
        return persos;
    }
    
    public LesPersonnages() {
        // Constructeur qui initialise l'attribut persos
        this.persos = new ArrayList<Personnage>();
    }
         
    public int getTaille(){ 
        // Méthode qui renvoie le nombre de personnage de la liste
        return this.persos.size(); 
    }
     
    public int getScore(){ 
        // Méthode qui renvoie le score total de tous les personnages de la liste 
        int sc = 0;
        for(int i=0; i<getTaille(); i++)
           sc += this.getPerso(i).getValeur();
        return sc;
    }
          
    public Personnage getPerso(int i){
        // Méthode qui renvoie un personnage par rapport à un indice donné en paramètre
        if(i>=0 && i<getTaille())
            return this.persos.get(i);
        else 
            return null;
    }
    
    public LesPersonnages getPersosFamilles(String f){
        // Méthode qui renvoie une liste de personnage par rapport à une nom de famille donné en paramètre sans doublons
        LesPersonnages lp = new LesPersonnages();
        for(int i=0; i<getTaille(); i++)
            if(this.getPerso(i).getFamille().equals(f))
                lp.ajoutePerso(getPerso(i));
        return lp;
    }
    
    public ArrayList<String> getFamilles(){
        // Méthode qui retourne sous forme d'une liste de chaine de caractères toute les familles du jeu sans doublons
        ArrayList<String> lst = new ArrayList<String>();
        for(int j=0; j<this.persos.size(); j++){
            Personnage p = this.persos.get(j);
            boolean trouve = false;
            for(int i=0; i<lst.size(); i++){
                if(lst.get(i).equals(p.getFamille()))
                    trouve = true;
            }
            if(!trouve)
                lst.add(p.getFamille());
        }
        return lst;
    }
    
    public void ajoutePerso(Personnage p){
        // Méthode qui permet l'ajout d'un personnage passé en paramètre dans la liste courante
        this.persos.add(p);
    }
    
    public void ajoutePersos(LesPersonnages lp){
        // Méthode qui permet l'ajout d'une collection de personnages passé en paramètre dans la liste courante
        for(int i=0; i < lp.getTaille(); i++){
            this.persos.add(getPerso(i));
        }
    }
    
    public void retirePersos(){
        // Méthode qui permet de retirer tous les personnages de la liste courante
        this.persos.clear();
    }
    
    public void retirePerso(Personnage p){ 
        // Méthode qui permet de retirer un personnage passé en paramètre de la liste courante
        int i=0; 
        boolean trouve = false;
        while(i<getTaille() && !trouve){
            if (this.getPerso(i).getNom().equals(p.getNom())){
                this.persos.remove(i);  
                trouve = true;
            }
            else i++;
        }      
    }
    
    public LesPersonnages retirePersos(int n){ 
        // Méthode qui renvoie une liste correspondant à la liste courante et supprime tout les personnages de la liste courante
        LesPersonnages lcr = new LesPersonnages();
        for (int i=0; i<=n; i++){
            lcr.ajoutePerso(getPerso(0));
            this.persos.remove(0);  
        }
        return lcr;
    } 
    
    public LesPersonnages retirePersosFamille(String f){ 
        // Méthode qui retourne tous les personnages d'une famille passée en paramètre et vide la liste courante persos 
        LesPersonnages lcr = new LesPersonnages();
        int i = 0;
        while(i<getTaille()){
            if (getPerso(i).getFamille().equals(f)){
                lcr.ajoutePerso(getPerso(i));
                this.persos.remove(i);  
            }
            else i++;
        }
        return lcr;
    }
    
    @Override
    public String toString(){
        // Méthode qui permet de renvoyer sous forme textuelle tous les personnages de la liste courante en utilisant la méthode toString de la class Personnage 
        String s = "";
        for(int i=0; i<getTaille(); i++)
            s+=i+"- "+getPerso(i).toString();
        return s;
    }
	
    public LesPersonnages(int nc){
        // Constructeur qui initialise l'attribut persos et qui selon un paramètre nc ajoute un taux de personnage proportionnel au niveau de difficulté choisi
        this.persos = new ArrayList<Personnage>();
        if (nc >= 4){ // 2 familles
            ajoutePerso(new Personnage("communs", "assault-trooper", 10));
            ajoutePerso(new Personnage("communs", "commando", 20));
            ajoutePerso(new Personnage("rares", "absolute-zero", 10));
            ajoutePerso(new Personnage("rares", "arctice-assassin", 20));
        }
        if (nc >= 10){ // 4 familles
            ajoutePerso(new Personnage("communs", "devestrator", 30));
            ajoutePerso(new Personnage("rares", "brawler", 30));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-can", 20));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace", 10));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-can", 20));
        }
        if (nc >= 18){ // 6 familles

            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-chn", 30));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-chn", 30));
            ajoutePerso(new Personnage("legendaires", "power-chord", 10));
            ajoutePerso(new Personnage("legendaires", "raptor", 20));
            ajoutePerso(new Personnage("legendaires", "raven", 30));
            ajoutePerso(new Personnage("epiques", "burnout", 10));
            ajoutePerso(new Personnage("epiques", "funk-ops", 20));
            ajoutePerso(new Personnage("epiques", "rex", 30));
        }
        if (nc == 32){ // 6 familles
            ajoutePerso(new Personnage("communs", "dominator", 40));
            ajoutePerso(new Personnage("communs", "highrise-assault-trooper", 50));
            ajoutePerso(new Personnage("communs", "jungle-scout", 60));
            ajoutePerso(new Personnage("communs", "pathfinder", 70));
            ajoutePerso(new Personnage("rares", "brilliant-striker", 40));
            ajoutePerso(new Personnage("rares", "brite-bomber", 50));
            ajoutePerso(new Personnage("rares", "circuit-breaker", 60));
            ajoutePerso(new Personnage("rares", "dazzle", 70));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-fra", 40));
            ajoutePerso(new Personnage("alpins-femmes", "mogul-master-gbr", 50));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-fra", 40));
            ajoutePerso(new Personnage("as-des-pistes", "alpine-ace-gbr", 50));
            ajoutePerso(new Personnage("legendaires", "red-knight", 40));
            ajoutePerso(new Personnage("epiques", "shadow-ops", 40));
        }
    }    
}