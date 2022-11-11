import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thomas
 */

public class Personnage{
    
    private String famille; // Attribut de type String pour avoir la famille auquel le joueur appartient
    private String nom; // Un attribut de type String étant le nom du Personnage 
    private int valeur; // Un attribut de type int qui correpond à la valeur, le score de cette carte Personnage 
    private Image photo; // Un attribut Image qui sert de photo du personnage
    
    public String getFamille(){
        //Getter de l'attribut famille
        return this.famille;
    }

    public void setFamille(String famille){
        //Setter de l'attribut famille
        this.famille = famille;
    }

    public String getNom(){
        //Getter de l'attribut nom
        return nom;
    }

    public void setNom(String nom){
        //Setter de l'attribut nom
        this.nom = nom;
    }

    public int getValeur(){
        //Getter de l'attribut valeur
        return this.valeur;
    }

    public void setValeur(int valeur){
        //Setter de l'attribut valeur
        this.valeur = valeur;
    }

    public Image getPhoto(){
        //Getter de l'attribut photo
        return photo;
    }

    public void setPhoto(Image photo){
        //Setter de l'attribut photo
        this.photo = photo;
    }
    
    public Personnage(){
        // Un constructeur par défaut qui initialise les attributs 
        this.famille = "anonyme";
        this.nom = "anonyme";
        this.valeur= 0;
        this.photo = new ImageIcon(getClass().getResource("/memory/img/anonyme.png")).getImage();
    }
    
    public Personnage(String s, String ss, int v){
        // Un constructeur avec 3 paramètres, un pour le pseudo, un autre pour le nom de la famille et un pour celui de sa valeur
        // On met quoiqu'il arrive par défaut une image de tête anonyme
        this.famille = s;
        this.nom = ss;
        this.valeur = v;
        this.photo = new ImageIcon(getClass().getResource("memory/img/"+ss+".jpg")).getImage();
    }
    
    public String toString(){
        // Une méthode toString pour qui décris textuellement l'instance courante de Perosnnage, avec son nom, sa famile et sa valeur
        // On ne représente pas de manière textuelle sa photo
        return this.nom + " de la famille " + this.famille + ", valeur : " + this.valeur;
    }
    
    public void setImgBouton(JButton jb) {
        // méthode pour mettre une image sur un bouton passé en paramètre
        Image img = photo.getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_SMOOTH);
        jb.setIcon(new ImageIcon(img));
    }    
}