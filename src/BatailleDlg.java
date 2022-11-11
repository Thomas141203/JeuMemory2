import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class BatailleDlg extends javax.swing.JDialog
{
    
    private LesJoueurs lj; //collection des joueurs (en entrée)
    private int indj; //indice du joueur courant (en entrée)
    private Joueur adversaire; //adversaire sélectionné (en sortie)
    private boolean ok; // action faite ou non (en sortie)
    private Bataille b; // action réalisée
    
    public BatailleDlg(java.awt.Frame parent, boolean modal, LesJoueurs lj, int jc){
        // Constructeur de la class BatailleDlg, ont fait appel au constructeur de la class JDialog, on initialise les attributs et créer l'ensmble de l'affichage graphique
        super(parent, modal);
        this.setLocationRelativeTo(null); // on centre la fenêtre
        initComponents();//création de l'interface
        //initialisation des attributs
        this.lj = lj;
        this.indj = jc;
        this.ok=false;
        this.b=null;
        DefaultListModel mod = new DefaultListModel(); // On crée un model de liste par défaut pour la JList
        ListeJ.setModel(mod);
        initListeJ();//on appel la méthode initListe()
        Annuler.setText("Annuler");
        Annuler.setVisible(false); // aucune bataille existe ; le bouton est rendu invisible
        MessageJ.setText(lj.getJoueur(indj).getPseudo()+" va effectuer une bataille contre : ");
    }
    
    public boolean getOk(){
        // Accesseur en lecture de ok
        return ok;
    }
    
    public Joueur getAdversaire(){
        // Accesseur en lecture de adversaire
            return adversaire;
    }
    
    public Bataille getBataille(){
        // Accesseur en lecture de Bataille
        return b;
    }
    
    public void initListeJ(){
        // Méthode pour initialiser la JList en mettant dans le model tout les pseudos des joueurs en liste
        for(int i = 0 ; i<lj.getNbJoueurs() ; i++){
            String s = lj.getJoueur(i).getPseudo();
            DefaultListModel mod = (DefaultListModel)ListeJ.getModel();
            mod.addElement(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Joueur = new javax.swing.JLabel();
        Adversaire = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfosCarte1 = new javax.swing.JTextArea();
        Carte1 = new javax.swing.JButton();
        Carte2 = new javax.swing.JButton();
        Ic2 = new javax.swing.JScrollPane();
        InfosCarte2 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        Vainqueur = new javax.swing.JLabel();
        Annuler = new javax.swing.JButton();
        Demarrer = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        MessageJ = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListeJ = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        Joueur.setText("(Joueur)");
        jPanel2.add(Joueur);

        Adversaire.setText("(Adversaire)");
        jPanel2.add(Adversaire);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4));

        InfosCarte1.setColumns(20);
        InfosCarte1.setRows(5);
        jScrollPane1.setViewportView(InfosCarte1);

        jPanel3.add(jScrollPane1);

        Carte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memory/img/anonyme.png"))); // NOI18N
        jPanel3.add(Carte1);

        Carte2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/memory/img/anonyme.png"))); // NOI18N
        jPanel3.add(Carte2);

        InfosCarte2.setColumns(20);
        InfosCarte2.setRows(5);
        Ic2.setViewportView(InfosCarte2);

        jPanel3.add(Ic2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.GridLayout(1, 3));

        Vainqueur.setBackground(new java.awt.Color(174, 227, 76));
        Vainqueur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Vainqueur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(Vainqueur);

        Annuler.setText("Annuler/Fermer");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel4.add(Annuler);

        Demarrer.setText("Démarrer");
        Demarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DemarrerActionPerformed(evt);
            }
        });
        jPanel4.add(Demarrer);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        MessageJ.setText("jLabel1");
        jPanel5.add(MessageJ);

        ListeJ.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListeJ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListeJMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(ListeJ);

        jPanel5.add(jScrollPane3);

        getContentPane().add(jPanel5, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // Méthode déclencher au clic sur le JButton Annuler
        // Intérompt la bataille en cours et ferme la fenêtre
        this.ok = false;
        if (Annuler.getText().equals("Annuler"))
            this.b.setDeroulement("Bataille interrompue en cours de partie");
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void DemarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DemarrerActionPerformed
        // Méthode déclencher au clic sur le JButton Demarrer
        // Lance le proccessus de bataille et indique qui a gagné
        int resultat = b.execute();
        if(resultat == 0){
            MessageJ.setText("Match nul");
            Vainqueur.setText("");
        }
        if(resultat == 1){
            MessageJ.setText("Le gagnant est "+lj.getJoueur(indj).getPseudo()+" et le perdant est "+b.getAdversaire().getPseudo()+".");
            Vainqueur.setText(lj.getJoueur(indj).getPseudo());
        }
        if(resultat == 2){
            MessageJ.setText("Le gagnant est "+b.getAdversaire().getPseudo()+" et le perdant est "+lj.getJoueur(indj).getPseudo()+".");
            Vainqueur.setText(b.getAdversaire().getPseudo());
        }
        if(lj.getJoueur(indj).getPaquet().getTaille()==0)
            InfosCarte1.setText("Paquet vide");
        else
            InfosCarte1.setText(lj.getJoueur(indj).getPaquet().getPerso(0).toString()+"\n"+lj.getJoueur(indj).getPaquet().toString());
        if(b.getAdversaire().getPaquet().getTaille()==0)
            InfosCarte2.setText("Paquet vide");
        else
            InfosCarte2.setText(b.getAdversaire().getPaquet().getPerso(0).toString()+"\n"+b.getAdversaire().getPaquet().toString());
        this.ok = true;
        if(b.getAdversaire().getPaquet().getTaille() == 0 || lj.getJoueur(indj).getPaquet().getTaille() == 0){
            Demarrer.setVisible(false);
            Annuler.setText("Fermer");
        }
        else{
            Carte1.setIcon(new ImageIcon(lj.getJoueur(indj).getPaquet().getPerso(0).getPhoto()));
            Carte2.setIcon(new ImageIcon(b.getAdversaire().getPaquet().getPerso(0).getPhoto()));
        }
    }//GEN-LAST:event_DemarrerActionPerformed

    private void ListeJMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListeJMouseClicked
        // méthode executer au clic d'un élément de JList
        // C'est pour récuperer le joueur séléctionner contre qui le joueur veut faire une bataille
        String s = ListeJ.getSelectedValue();
        if(lj.getJoueur(indj).getPseudo().equals(s)){
            InfosCarte2.setText("Sélectionnez un joueur différent du joueur courant !");
            Demarrer.setVisible(false);
        }
        else{
            b = new Bataille(lj.getJoueur(indj), lj.rechJoueur(s));
            Annuler.setVisible(true);
            Demarrer.setVisible(true);
            Joueur.setText(lj.getJoueur(indj).getPseudo());
            Adversaire.setText(s);
            InfosCarte1.setText(lj.getJoueur(indj).getPaquet().toString());
            Carte1.setIcon(new ImageIcon(lj.getJoueur(indj).getPaquet().getPerso(0).getPhoto()));
            if(lj.rechJoueur(s).getPaquet().getTaille()>0) {
                InfosCarte2.setText(lj.rechJoueur(s).getPaquet().toString());
                Carte2.setIcon(new ImageIcon(b.getAdversaire().getPaquet().getPerso(0).getPhoto()));
            }
            else
                InfosCarte2.setText("Il est nécessaire de sélectionner un joueur possédant au moins une paire de cartes.");
        }
    }//GEN-LAST:event_ListeJMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Adversaire;
    private javax.swing.JButton Annuler;
    private javax.swing.JButton Carte1;
    private javax.swing.JButton Carte2;
    private javax.swing.JButton Demarrer;
    private javax.swing.JScrollPane Ic2;
    private javax.swing.JTextArea InfosCarte1;
    private javax.swing.JTextArea InfosCarte2;
    private javax.swing.JLabel Joueur;
    private javax.swing.JList<String> ListeJ;
    private javax.swing.JLabel MessageJ;
    private javax.swing.JLabel Vainqueur;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}