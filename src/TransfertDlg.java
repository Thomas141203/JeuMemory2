
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Thomas
 */

public class TransfertDlg extends javax.swing.JDialog{

    private LesJoueurs lj; //collection des joueurs, pour initialiser la liste déroulante avec les pseudos des joueurs
    private int indj; //indice joueur courant
    private Transfert tc; // l'action de transfert 
    private boolean ok; // indicateur pour savoir le transfert a bien été effectué.
    private int indjs; //indice du joueur sélectionné dans la liste déroulante
    private String fs; //famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné

    public TransfertDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int indj){
        // Constructeur de la class TransfertDlg
        super(parent, modal); // appel au constructeur de JDialog
        this.setLocationRelativeTo(null); // on centre la fenêtre
        initComponents();//création de l'interface
        this.lj = lj;//on récupère la liste des joueurs du jeu (pour remplir la JComboBox)
        this.indj = indj ;//on récupère l'indice du joueur ayant obtenu tous les personnages de la famille "rares" ou "communs"
        this.tc = null;
        this.ok = false;//on initialise le boolean
        this.fs = null;//on initialise le String indiquant la famille du personnage sélectionné
        ComboJoueurs.removeAllItems();
        initCombo(); // méthode pour remplir la liste déroulante
        indjs = 0;//on initialise l'indice du joueur sélectionné dans la liste déroulante
        Message.setText("Le joueur "+lj.getJoueur(indj).getPseudo()+" a obtenu une famille complète");//on initialise le JLabel "Message"
        Infos.setText("Personnages de "+lj.getJoueur(indj).getPseudo()+" : \n"+lj.getJoueur(indj).getPaquet());//on initialise la zone d’édition
        
    }
    
    public boolean getOk(){
        // accesseur en lecture de ok
        return this.ok;
    }
    
    public Transfert getTransfert(){
        // accesseur en lecture de Transfert
        return this.tc;
    }
    
    public void initCombo(){
        // Méthode qui permet d'initialiser la JComboBox en y mettant tout les pseudos des joueurs 
        for(int i = 0 ; i<lj.getNbJoueurs() ; i++){
            ComboJoueurs.addItem(this.lj.getJoueur(i).getPseudo());
        }
    }
    
    public void initPanneau(){
        // Méthode qui initialise le Panneau de gauche en le remplissant dynamiquement avec des boutons
        PanneauG.removeAll();//on vide le panneau
        this.repaint();//on rafraichit le fenêtre
        LesPersonnages lcs = lj.getJoueur(indjs).getPaquet();//on récupère dans lcs le paquet de cartes du joueur sélectionné
        int t = lcs.getTaille();//on récupère la taille du paquet
        int n = 1+(t-1)/4;//on calcule le nombre de colonnes à avoir
        PanneauG.setLayout(new java.awt.GridLayout(4, n));//on met comme Layout un GridLayout de 4 lignes et n colonnes au PanneauG
        for(int i = 0 ; i<t ; i++){//on va créer autant de boutons qu'il y a de carte dans le paquet
            JButton bt = new JButton();//création du bouton
            bt.setName(lcs.getPerso(i).getFamille());//on donne comme nom au bouton le nom de la famille de la carte correspondant à ce boouton
            bt.addActionListener(new java.awt.event.ActionListener(){//on abonne le bouton à un écouteur
                public void actionPerformed(java.awt.event.ActionEvent evt){
                    boutonActionPerformed(evt);
                }
            });
            PanneauG.add(bt);//on ajoute le bouton au panneau de gauche
        }
        this.pack();
    }
    
    public void affichePanneau(){
        // Cette méthode permet d'affciher visuellement tout les boutons du Panneau gauche
        int taille = lj.getJoueur(indjs).getPaquet().getTaille();//on récupère la taille du paquet de cartes du joueur sélectionné
        for (int i = 0 ; i<taille ; i++){
            Image img = lj.getJoueur(indjs).getPaquet().getPerso(i).getPhoto();//on récupère l'image du personnage du ième bouton
            JButton bt = (JButton)PanneauG.getComponent(i);//on récupère le ième bouton
            bt.setIcon(new ImageIcon(img));//on met l'image correspondant sur le bouton
        }
    }
    
    private void boutonActionPerformed(java.awt.event.ActionEvent evt){
        // Méthode qui au clic sur un des boutons génerer dynamiquement va être entourer d'une bordure aisni de celui de sa famille si y a
        LesPersonnages lp = lj.getJoueur(indjs).getPaquet();//on récupère le paquet du joueur sélectionné
        int t = lp.getTaille();//on récupère la taille du paquet
        JButton bt = (JButton) evt.getSource();//on récupère le bouton grâce à evt
        fs = bt.getName(); // la proprité Name, contient ici le nom de la famille du personnage affiché sur le bouton
        for(int i = 0; i < t; i++){
            JButton b = (JButton)(PanneauG.getComponent(i));//on récupère le ième bouton
            if (b.getName().equals(fs))//si le Name (famille du personnage correspondant au bouton) du bouton est le même que la famille du personnage sélectionné en cliquant sur un des personnages du joueur sélectionné
                b.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 0, 0)));//on encadre ce ième bouton
            else//sinon
                b.setBorder(null);//pas de bordure
        }
        LesPersonnages lps = lp.getPersosFamilles(fs);//on récupère la liste des personnages ayant la même famille que celle du personnage sélectionné
        Infos.setText("Vous pouvez récupérer "+lps.getTaille()+" personnages : \n"+lps);//on affiche dans la zone d'édition le nombre de personnages à récupérer et la liste de ces personnages
    }
    
    private void creePanneau(JPanel jp, LesPersonnages lc){
        // Permet de générer des boutnos sur le Panneau indiquer en paramètre, correspondant à la liste de personnages indiquer en paramètre
        jp.removeAll();
        this.repaint();
        int taille = lc.getTaille();
        int n = 1+(taille-1)/4;
        jp.setLayout(new java.awt.GridLayout(4, n)); // application de la stratégie GridLayout pour le panneau
        for(int i = 0 ; i<taille ; i++){
            JButton bt = new JButton(); // création d'un bouton
            jp.add(bt); // ajout du bouton créer au pannel
        }
        this.pack();
    }
    
    private void dessinePanneau(JPanel jp, LesPersonnages lc){
        // Cette méthode va pour chaque bouton d'un panneau passer en paramètre afficher l'image de chaque carte de la collection de carte passer en paramètre
        int taille = lc.getTaille();
        for (int i = 0 ; i<taille ; i++){
            Image img = lc.getPerso(i).getPhoto();
            JButton bt = (JButton)jp.getComponent(i);
            bt.setIcon(new ImageIcon(img));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanneauG = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Message = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboJoueurs = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Infos = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Transfert = new javax.swing.JButton();
        Fermer = new javax.swing.JButton();
        PanneauD = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 3));

        PanneauG.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauG);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        Message.setText("jLabel1");
        jPanel2.add(Message);

        jLabel2.setText("jLabel2");
        jPanel2.add(jLabel2);

        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3);

        ComboJoueurs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboJoueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJoueursActionPerformed(evt);
            }
        });
        jPanel2.add(ComboJoueurs);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        Infos.setColumns(20);
        Infos.setRows(5);
        jScrollPane1.setViewportView(Infos);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        Transfert.setText("Transfert");
        Transfert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransfertActionPerformed(evt);
            }
        });
        jPanel4.add(Transfert);

        Fermer.setText("Fermer");
        Fermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FermerActionPerformed(evt);
            }
        });
        jPanel4.add(Fermer);

        jPanel3.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1);

        PanneauD.setLayout(new java.awt.GridLayout(1, 1));
        getContentPane().add(PanneauD);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboJoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJoueursActionPerformed
        // Méthode qui au clic sur un élément de la JComboBox va soit effacer le Panneau de gauche si le joueur choisie est le même, 
        // sinon affciher les infos du joueur séléctionner dans la JComboBox
        this.indjs = ComboJoueurs.getSelectedIndex();//on récupère l'indice du joueur de la JComboBox sélectionné par le joueur courant
        if (indjs != -1){//si cet indice est valide
            if (this.indjs == this.indj){//si le joueur courant s'est sélectionné
                Infos.setText("Sélectionnez un joueur différent du joueur courant !");//un message d'erreur est affiché dans la zone d'édition
                PanneauG.removeAll();//on vide le panneau de gauche
                PanneauG.repaint();//on rafraîchit le panneau
            }
            else{
                Infos.setText("Joueur sélectionné: \n"+lj.getJoueur(indjs).toString());//on affiche les informations textuelles sur les personnages possédés par le joueur sélectionné dans la zone d’édition
                initPanneau();//appel de la méthode initPanneau()
                affichePanneau();//appel de la méthode affichePanneau()
            }
        }
    }//GEN-LAST:event_ComboJoueursActionPerformed

    private void FermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FermerActionPerformed
        // On ferme la fenêtre la JDialog au clic sur Fermer 
        if(ok){
            this.setVisible(false);
            this.dispose();
        }
        else
            this.tc.setDeroulement("Il n'y a pas eu de cartes transférées");
    }//GEN-LAST:event_FermerActionPerformed

    private void TransfertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransfertActionPerformed
        // Cette méthode ce déclenche quand on clic sur le bouton Transfert
        // elle va prendre les cartes du panneau gauche séléctionner et l'afficher sur la panneau droite, donc transferer les cartes d'un joueur vers celles du joueur courant
        if(indjs != -1 && fs != null){
            this.tc = new Transfert(this.lj.getJoueur(indj), this.lj.getJoueur(indjs), fs); // création de transfert entre le joueur cibler et courant
            int ndct = tc.execute(); // execution du transfert
            if(ndct>0){ // si le nombre de carte transferer est positif 
                LesPersonnages pt = this.tc.getCartesTransferees();
                creePanneau(PanneauD, pt);
                dessinePanneau(PanneauD, pt);
                this.lj.getJoueur(indjs).getPaquet().retirePersosFamille(fs);
                this.lj.getJoueur(indj).getPaquet().ajoutePersos(pt);
                creePanneau(PanneauG, this.lj.getJoueur(indjs).getPaquet());
                dessinePanneau(PanneauG, this.lj.getJoueur(indjs).getPaquet());
                this.ok = true;
                Transfert.setVisible(false);
            }
        }
        else
            Infos.setText("Il est nécessaire de sélectionner un joueur possédant au moins une paire de cartes.");
    }//GEN-LAST:event_TransfertActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJoueurs;
    private javax.swing.JButton Fermer;
    private javax.swing.JTextArea Infos;
    private javax.swing.JLabel Message;
    private javax.swing.JPanel PanneauD;
    private javax.swing.JPanel PanneauG;
    private javax.swing.JButton Transfert;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
