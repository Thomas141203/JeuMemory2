import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Thomas
 */

public class SaisieJoueurDlg extends javax.swing.JDialog{
    
    private Joueur joueur; // Attribut de type Joueur permettant de récupérer les informations du joueur en cour de création
    private LesPersonnages persos; // Attribut de type LesPersonnages 
    private boolean modeFermeture; // Attribut de type boolean nous renseignant sur le mode de fermeture de la JDialogue (true si il clic sur valider false sinon)
    private ImageIcon photo; // Attribut de type ImageIcon pour récupérer la photo choisi par le joueur et lui associe
    
    public SaisieJoueurDlg(java.awt.Frame parent, boolean modal, LesPersonnages lp){
        // Constructeur qui initialise les attributs, créer la fenêtre graphique avec la méthode initComponents, initialise la JList
        // et l'appel au constructeur de la superclass en lui donnant comme paramètre le fenêtre qui gère la boite et un mode d'ouverture bloquant
        super(parent, modal);
        this.setLocationRelativeTo(null); // on centre la fenêtre
        initComponents(); //création de l'interface
        this.joueur = null;
        this.persos = lp;
        this.modeFermeture = false;
        this.photo = null;
        DefaultListModel mod = new DefaultListModel();
        ListeFamilles.setModel(mod);
        initListeFamilles();
    }
    
    public Joueur getJoueur(){
        // Méthode qui renvoie l'attribut joueur
        return this.joueur;
    }
    
    public boolean getOk(){
        // Méthode qui renvoie le mode de fermeture de la boite
        return this.modeFermeture;
    }
    
    private void initListeFamilles(){
        // Méthode permettant d'initialiser le JList avec le nom des familles de personnages
        // on y créer un modèle par défault pour pouvoir ajouter par la suite des éléments dans la JList
        if(persos.getTaille() > 0){
            Personnage p = persos.getPerso(0);
            DefaultListModel mod = (DefaultListModel)ListeFamilles.getModel();
            mod.addElement(p.getFamille());
            for(int i=1 ; i<persos.getTaille() ; i++){
                p = persos.getPerso(i);
                boolean vu = false;
                for(int j=0 ; j<mod.getSize() ; j++)
                {
                    if(p.getFamille().equals(mod.getElementAt(j)))
                        vu = true;
                }
                if(vu == false)
                    mod.addElement(p.getFamille());
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        ZEdi = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeFamilles = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        Parcourir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        Photo = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Créez votre joueur !");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(3, 1));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("Donnez votre pseudo : ");
        jPanel7.add(jLabel2);

        jPanel4.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setLayout(new java.awt.GridLayout(1, 1));
        jPanel8.add(ZEdi);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setText("Quelle est votre famille préférée de personnages ?");
        jPanel9.add(jLabel3);

        jPanel5.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel10.setLayout(new java.awt.GridLayout(1, 1));

        ListeFamilles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListeFamilles);

        jPanel10.add(jScrollPane1);

        jPanel5.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel4.setText("Choisissez une photo : ");
        jPanel11.add(jLabel4);

        jPanel6.add(jPanel11, java.awt.BorderLayout.NORTH);

        jPanel12.setLayout(new java.awt.GridLayout(1, 1));

        Parcourir.setText("Parcourir");
        Parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParcourirActionPerformed(evt);
            }
        });
        jPanel12.add(Parcourir);

        jPanel6.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel6);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.GridLayout(1, 1));
        jPanel13.add(Photo);

        jPanel3.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel14.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel14.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel14.add(Valider);

        jPanel3.add(jPanel14, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ParcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParcourirActionPerformed
        // Méthode qui permet à l'utilisateur de parcourir les fichiers de son ordinateur pour choisir une image et l'attribuer à la photo du joueur 
        JFileChooser jf= new JFileChooser();//on ouvre une boîte de dialogue qui permet de sélectionner un fichier
        if (jf.showOpenDialog(this)== JFileChooser.APPROVE_OPTION)
        {
            String path = jf.getSelectedFile().getPath();//path contient le chemin complet pour accéder au fichier sélectionné
            Image img = Toolkit.getDefaultToolkit().getImage(path);//on récupère l'image du fichier
            img = img.getScaledInstance(Photo.getWidth()-10, Photo.getHeight()-10, Image.SCALE_DEFAULT);//on redimensionne l'image
            photo = new ImageIcon(img);//on "transforme" l'image en ImageIcon que l'on affecte à photo
            Photo.setIcon(photo);//l'ImageIcon est mise sur le bouton
        } 
        //permet de mettre une photo sur le bouton Photo
    }//GEN-LAST:event_ParcourirActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // Méthode qui vérifie que le joueur à choisi au moins un pseudo et une famille préférée pour instancier ce nouveau joueur
        String ps = "";
        if((!(ZEdi.getText().equals(""))) && (!(ZEdi.getText().equals("Vous n'avez pas saisi de pseudo !"))) && (!(ZEdi.getText().equals("Vous n'avez pas sélestionné de famille préférée valide !"))) && (!(ZEdi.getText().equals("Vous n'avez ni saisi de pseudo ni sélestionné de famille préférée valide !"))))
            ps = ZEdi.getText();
        if(ZEdi.getText().equals("Vous n'avez pas saisi de pseudo !"))
            ZEdi.setText("");
        if(ZEdi.getText().equals("Vous n'avez pas sélestionné de famille préférée valide !"))
            ZEdi.setText(ps);
        if(ZEdi.getText().equals("Vous n'avez ni saisi de pseudo ni sélestionné de famille préférée valide !"))
            ZEdi.setText("");
        if((!(ZEdi.getText().equals(""))) && (!(ListeFamilles .isSelectionEmpty())) && (!(ListeFamilles.getSelectedValue().equals(""))))
        {
            joueur = new Joueur(ZEdi.getText(), ListeFamilles.getSelectedValue());
            if(photo!=null)
                joueur.setPhoto(photo);
            this.modeFermeture = true;
            this.setVisible(false);
            this.dispose();
        }
        if(ZEdi.getText().equals(""))
            ZEdi.setText("Vous n'avez pas saisi de pseudo !");
        if((ListeFamilles .isSelectionEmpty()) || (ListeFamilles.getSelectedValue().equals("")))
            ZEdi.setText("Vous n'avez pas sélestionné de famille préférée valide !");
        if((ps.equals("")) && ((ListeFamilles .isSelectionEmpty()) || (ListeFamilles.getSelectedValue().equals(""))))
            ZEdi.setText("Vous n'avez ni saisi de pseudo ni sélestionné de famille préférée valide !");
    }//GEN-LAST:event_ValiderActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // Méthode qui au clic sur la bouton annuler change le mode de fermeture et ferme la fenêtre 
        this.modeFermeture = false;
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JList<String> ListeFamilles;
    private javax.swing.JButton Parcourir;
    private javax.swing.JButton Photo;
    private javax.swing.JButton Valider;
    private javax.swing.JTextField ZEdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}