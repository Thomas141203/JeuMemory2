import java.util.ArrayList;

/**
 *
 * @author Thomas
 */

public class LesJoueurs
{
    private ArrayList<Joueur> lstJ; //Attribut de type ArrayList<Joueur> qui correspond à une collection de joueur
    
    public LesJoueurs(){
        //Le Constructeur par défaut qui initialise l'attribut lstJ
        this.lstJ = new ArrayList<Joueur>();
    }
    
    public ArrayList<Joueur> getJoueur(){
        //on récupère la liste complète de joueurs
        return lstJ;
    }
    
    public Joueur getJoueur(int i){
        // Méthode qui renvoie un Joueur selon son indice i dans la collection de joueur 
        if(i>=0 && i<this.lstJ.size())
            return this.lstJ.get(i);
        else 
            return null;
    }
    
    public int getIndiceJoueur(Joueur j){
        // Méthode qui nous renvoie l'indice d'un joueur passé en paramètre
        return this.lstJ.indexOf(j);
    }
    
    public int getNbJoueurs(){
        // Méthode qui renvoie le nombre total de joueur dans la liste
        return this.lstJ.size();
    }
    
    public void ajouteJoueur(Joueur j){
        // Méthode qui ajoute en queue de liste un joueur j donné en paramètre
        this.lstJ.add(j);
    }
    
    public void ajouteJoueurs(LesJoueurs lj){
        // Méthode qui permet d'ajouter une collection de joueur donné en paramètre à la liste courante
        for(int i=0; i < this.getNbJoueurs(); i++){
            this.lstJ.add(getJoueur(i));
        }
    }
    
    public Joueur rechJoueur(String p){
        // Méthode qui recherche un joueur selon un pseudo donné en paramètre et renvoie le joueur si il est trouvé ou la valeur null sinon
        int i=0;
        while(i < getNbJoueurs()){
            if(getJoueur(i).getPseudo().equals(p)){
                return getJoueur(i);
            }
            else i++;
        }
        return null;
    }
    
    public void supprimeJoueur(Joueur j){
        // Méthode qui permet de suppimer un joueur passé en paramètre
        int i=0; 
        boolean trouve = false;
        while(i<getNbJoueurs() && !trouve){
            if(this.getJoueur(i).getPseudo().equals(j.getPseudo())){
                this.lstJ.remove(i);  
                trouve = true;
            }
            else i++;
        } 
    }
    
    public String toString(){
        // Méthode qui renvoie sous forme textuelle les joueurs de la liste en utilisant la méthode toString de la classs Joueur
        String s = "";
        for(int i=0; i<getNbJoueurs(); i++)
            s+=i+"- "+getJoueur(i).toString();
        return s;
    }
    
    public LesJoueurs getGagnants(){
        //méthode qui permet de connaître les gagnants du jeu 
        //elle retourne la liste des joueurs ayant le score le plus élevé
        int max = getJoueur(0).getScore();//on initialise la variable max avec le score du premier joueur
        for(int i=1; i<getNbJoueurs();i++)//on parcours la liste des joueurs (du deuxième joueur au dernier s'il y a d'autres joueurs)
            if (getJoueur(i).getScore()>max)//si le score de l'un des autres joueurs est supérieur au max, 
                max = this.getJoueur(i).getScore();//alors max prend la valeur du score de ce joueur
        //à la fin de la boucle, max a pris la valeur du score le plus élevé de la partie
        LesJoueurs lst = new LesJoueurs();//on crée une liste qui va contenir les joueurs ayant le score le plus élevé (c'est cette liste qu'on va retourner ; elle est encore "vide")
        for(int i=0; i<getNbJoueurs();i++)//on parcours à nouveau la liste des joueurs (du premier au dernier joueur cette fois)
            if (getJoueur(i).getScore()==max)//si le score du joueur est égal au max,
                lst.ajouteJoueur(getJoueur(i));//alors on ajoute ce joueur à la liste lst à retourner
        //à la fin de la boucle, la liste lst contient les joueurs ayant eu le plus grand score
        return lst;//on retoune la liste des gagants de la partie (joueurs ayant eu le plus de point)
    }
    
    public boolean lesAutresJoueursOntDesCartes(LesJoueurs lj){
        // méthode qui renvoie vraie si un des joueurs à encore des cartes
        // on boucle en vérifiant pour chaque joueur si la taille de son paquet est différente de 0
        LesJoueurs lesJ = lj;
        boolean ok = false;
        for(int i = 0 ; i<lesJ.getNbJoueurs() ; i++){
            if(lesJ.getJoueur(i).getPaquet().getTaille() != 0){
                // si un joueur à plus d'une carte
                ok = true;
            }
        }
        return ok;
    }
}