import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thomas
 */

public class VisuJoueursDlg extends javax.swing.JDialog{

    private LesJoueurs lj; // Attribut de type lesJoueurs représentant la liste des joueurs actuels
    
    public VisuJoueursDlg(java.awt.Frame parent, boolean modal, LesJoueurs lstj){
        // Constructeur de la class VisuJoueursDlg
        super(parent, modal); //appel du constructeur de la classe ancetre, ici JDialog
        this.setLocationRelativeTo(null); // on centre la fenêtre
        initComponents();//création de l'interface
        //initialisation de l'attribut
        this.lj = lstj;//récupération du paramètre (lstj) dans l’attribut lj
        initTrombi();//appel à la méthode qui construit les boutons
    }
    
    private void initTrombi(){   
        // Méthode qui créer de manière dynamique les boutons dans le JPanel Panneau
        int nb = this.lj.getNbJoueurs();
        //on fixe le layout de panneau avec nb
        Panneau.setLayout(new GridLayout(1,nb));
        for (int i=0; i< nb; i++){ 
            JButton jb= new JButton(); //création d'un bouton
            jb.setName(""+i); //on change le nom du bouton par le numéro de l'indice du joueur mis sur ce bouton
            //abonnement du bouton à un écouteur de type ActionListener
            jb.addActionListener(new java.awt.event.ActionListener() { //on veut que lorsque le bouton d'un joueur est cliqué, les informations de ce joueur soient affichées dans la zone d'édition
                public void actionPerformed(java.awt.event.ActionEvent evt) { //gestionnaire du clic sur le bouton d'un joueur : on peut cliquer sur le bouton
                    AfficheInfosJoueur(evt); //gestionnaire executé quand on clique sur un des boutons
                }
            }
            ); 
            Panneau.add(jb); //on ajoute le bouton au panneau Panneau
        }this.pack();// pour ajuster correctement la taille des composants après les ajouts si besoin
    }
    
    private void afficheTrombi(){
        // Méthode qui permet d'afficher les informations du joueur selectionné
        for(int i=0 ; i<this.lj.getNbJoueurs() ; i++){
            //on récupère le i-ème bouton
            JButton jb = (JButton) Panneau.getComponent(i);
            Joueur j = this.lj.getJoueur(i);
            Image img = j.getPhoto().getImage().getScaledInstance(jb.getWidth(), jb.getHeight(), Image.SCALE_DEFAULT);
            jb.setIcon(new ImageIcon(img));
        }
    }
    
    private void AfficheInfosJoueur(java.awt.event.ActionEvent evt){
        // Méthode qui permet d'afficher les informations du joueur selectionné
        JButton bout=(JButton)evt.getSource();
        for(int i=0;i<lj.getNbJoueurs(); i++){
            String str=""+i;
            if(str.equals(bout.getName()))
                Edition.setText(lj.getJoueur(i).toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Panneau = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Edition = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Choisissez un joueur pour voir ses caractéristiques");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 893, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        Edition.setColumns(20);
        Edition.setRows(5);
        jScrollPane1.setViewportView(Edition);

        jPanel3.add(jScrollPane1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.EAST);

        jPanel4.setLayout(new java.awt.GridLayout(1, 1));

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel4.add(Afficher);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        // Méthode qui au clic sur le bouton afficher appelle la méthode afficheTrombi
        afficheTrombi();
    }//GEN-LAST:event_AfficherActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JTextArea Edition;
    private javax.swing.JPanel Panneau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}