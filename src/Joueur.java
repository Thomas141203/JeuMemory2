import javax.swing.ImageIcon;


/**
 *
 * @author Thomas
 */

public class Joueur{
    
    private String pseudo; // Attribut de type String qui permet de récupérer le pseudo d'un joueur
    private String famillePrefere; // Attribut de type String qui permet de savoir la famille préférée que le joueur choisira
    private LesPersonnages paquet; // Attribut de type LesPersonnages qui permet d'avoir la collection des personnages du joueur courant
    private ImageIcon photo; // Attribut de type ImageIcon qui permet de mettre une photo associé au joueur si il le souhaite

    
    public String getPseudo(){
        // Méthode qui recupère le pseudo
        return this.pseudo;
    }
    
    public String getFamillePrefere(){
        // Méthode qui recupère sa famille préférée
        return this.famillePrefere;
    }
    
    public LesPersonnages getPaquet(){
        //Méthode qui recupère le paquet de personnages
        return this.paquet;
    }
    
    
    public ImageIcon getPhoto(){
        //Méthode qui recupère la photo
        return this.photo;
    }

    public void setPseudo(String pseudo){
        //Méthode qui remplace le pseudo
        this.pseudo = pseudo;
    }
    
    public void setFamillePrefere(String famille){
        // Méthode qui remplace la famille préférée
        this.famillePrefere = famille;
    }
    
    public void setPaquet(LesPersonnages paquet){
        //Méthode qui remplace le paquet de personnage
        this.paquet = paquet;
    }
    
    public void setPhoto(ImageIcon photo){
        //Méthode qui remplace la photo
        this.photo = photo;
    }
    
    public Joueur(){
        //Constructeur par défaut, initialise les 4 attributs
        setPseudo("Joueur");
        setFamillePrefere("");
        setPaquet(new LesPersonnages());
        setPhoto(new ImageIcon(getClass().getResource("memory/img/joueurDefaut.png")));
    }
    
    
    public Joueur(String pseudo, String familleprefere){
        //Constructeur avec comme paramètre le pseudo et la famille préférée du joueur
        this.pseudo = pseudo;
        this.famillePrefere = familleprefere;
        setPaquet(new LesPersonnages());
        setPhoto(new ImageIcon(getClass().getResource("memory/img/joueurDefaut.png")));
    }
    
    
    public String toString(){
        //Méthode toString, pour définir l'objet joueur de manière textuelle
        return "Joueur " + this.pseudo + "\n"
                + "famille préférée : " + this.famillePrefere +"\n"
                + "en possession des personnages : " + this.paquet + "\n"
                + "score : " + this.getScore();
    }
    
    public int getScore(){
        //Méthode qui récupere le score du joueur courant en sommant la valeur de chaque carte qu'il possède
        int nb = 0;
        for(int i=0; i< this.paquet.getPersos().size(); i++){
            nb += this.paquet.getScore();
        }
        
        return nb;
    }
    
    public int getNbCartes(){
        //Méthode qui retourne le nombre de carte 
        return this.getPaquet().getTaille();
    }
    
    public void ajoutePersoPaquet(Personnage p){
        //Méthode qui ajoute un personnage passé en paramètre dans la collection du joueur courant
        this.paquet.ajoutePerso(p);
    }
    
    public void initPaquetTest(){
        // Méthode pour les tests de présentation
        ajoutePersoPaquet(new Personnage("communs", "assault-trooper", 10));
        ajoutePersoPaquet(new Personnage("communs", "commando", 20));
        ajoutePersoPaquet(new Personnage("rares", "absolute-zero", 10));
    }
    
}