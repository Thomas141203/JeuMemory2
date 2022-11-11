import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Timer;


/**
 *
 * @author Thomas
 */

public class JeuMemory extends javax.swing.JFrame{
    
    //attributs
    private LesPersonnages persos;//liste des personnages de la partie
    private LesJoueurs joueurs;//liste des joueurs de la partie
    private Jeu monJeu; // pour la gestion d’un tour de jeu
    private int l1, c1, l2, c2; // pour les cartes sélectionnées à chaque tour de jeu
    private Joueur joueur;//attribut temporaire pour la présentation
    
    public JeuMemory(){
        initComponents();//création de l'interface
        this.setLocationRelativeTo(null); // centrage de la fenêtre
        //initialisation des attributs
        this.persos = new LesPersonnages();
        this.joueurs = new LesJoueurs();
        l1 = -1;
        c1 = -1;
        l2 = -1;
        c2 = -1;
        Joueurs.setVisible(false);
        Cartes.setVisible(false);
        Recommencer.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        Démarrer = new javax.swing.JButton();
        Recommencer = new javax.swing.JButton();
        Panneau = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Options = new javax.swing.JMenuItem();
        AjoutJoueur = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Joueurs = new javax.swing.JMenuItem();
        Cartes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        Transfert_Test = new javax.swing.JMenuItem();
        Bataille_Test = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        createPlayers = new javax.swing.JMenuItem();
        giveCards = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(3, 1));

        jLabel1.setText("Nombre de personnages trouvés : ");
        jPanel4.add(jLabel1);

        jLabel2.setText("Nombre de personnages restants : ");
        jPanel4.add(jLabel2);

        jLabel3.setText("C'est à qui de jouer?");
        jPanel4.add(jLabel3);

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        Démarrer.setText("Démarrer");
        Démarrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DémarrerActionPerformed(evt);
            }
        });
        jPanel5.add(Démarrer);

        Recommencer.setText("Recommencer");
        Recommencer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecommencerActionPerformed(evt);
            }
        });
        jPanel5.add(Recommencer);

        jPanel1.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout PanneauLayout = new javax.swing.GroupLayout(Panneau);
        Panneau.setLayout(PanneauLayout);
        PanneauLayout.setHorizontalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 732, Short.MAX_VALUE)
        );
        PanneauLayout.setVerticalGroup(
            PanneauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        getContentPane().add(Panneau, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Paramètres");

        Options.setText("Options");
        Options.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OptionsActionPerformed(evt);
            }
        });
        jMenu1.add(Options);

        AjoutJoueur.setText("Ajout joueur");
        AjoutJoueur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjoutJoueurActionPerformed(evt);
            }
        });
        jMenu1.add(AjoutJoueur);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Visualiser");

        Joueurs.setText("Joueurs");
        Joueurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoueursActionPerformed(evt);
            }
        });
        jMenu2.add(Joueurs);

        Cartes.setText("Cartes");
        Cartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartesActionPerformed(evt);
            }
        });
        jMenu2.add(Cartes);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tests");

        Transfert_Test.setText("Transfert_Test");
        Transfert_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Transfert_TestActionPerformed(evt);
            }
        });
        jMenu3.add(Transfert_Test);

        Bataille_Test.setText("Bataille_Test");
        Bataille_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bataille_TestActionPerformed(evt);
            }
        });
        jMenu3.add(Bataille_Test);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Presentation");

        createPlayers.setText("creation joueur");
        createPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPlayersActionPerformed(evt);
            }
        });
        jMenu4.add(createPlayers);

        giveCards.setText("donner cartes");
        giveCards.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveCardsActionPerformed(evt);
            }
        });
        jMenu4.add(giveCards);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OptionsActionPerformed
        // Cette méthode permet l'ouverture de la boite de dialogue InitDlg
        InitDlg diag = new InitDlg(this, true);//appel au constructeur de la classe InitDlg
        diag.setVisible(true);//rend la boîte de dialogue visible
        if(diag.getOk()==true){//accesseur pour récupérer l’indicateur (on a appuyé sur Valider, donc, on récupère les informations, sinon, pas de traitement)
            int niveau = diag.getNiveau();
            LesJoueurs lj = diag.getJoueurs();//accesseur pour récupérer le joueur saisi
            this.persos = new LesPersonnages(niveau);
            this.joueurs.ajouteJoueurs(lj);
            this.monJeu = new Jeu(persos, joueurs, niveau);
        }
    }//GEN-LAST:event_OptionsActionPerformed

    private void JoueursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoueursActionPerformed
        // Cette méthode permet l'ouverture de la boite de dialogue VisuJoueurDlg
        VisuJoueursDlg diag = new VisuJoueursDlg(this, true, this.joueurs);//appel au constructeur de la classe VisuJoueursDlg avec comme 3e paramètre la liste des joueurs
        diag.setVisible(true);//rend la boîte de dialogue visible
    }//GEN-LAST:event_JoueursActionPerformed

    private void AjoutJoueurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjoutJoueurActionPerformed
        // Cette méthode permet l'ouverture de la boite de dialogue SaisieJoueurDlg
        SaisieJoueurDlg diag = new SaisieJoueurDlg(this, true, this.persos);//appel au constructeur de la classe SaisieJoueurDlg avec comme 3e paramètre la liste des personnages (cartes du jeu)
        diag.setVisible(true);//rend la boîte de dialogue visible
        if(diag.getOk() == true){//si le bouton "Valider" à été cliqué et donc qu'il y a un joueur créé à récupérer
            this.joueurs.ajouteJoueur(diag.getJoueur());//ajout du joueur créé dans la liste des joueurs
        }
    }//GEN-LAST:event_AjoutJoueurActionPerformed

    private void CartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartesActionPerformed
        // Cette méthode permet l'ouverture de la boite de dialogue VisuPersonnagesDlg
        VisuPersonnagesDlg diag = new VisuPersonnagesDlg(this, true, this.monJeu.getJoueurCourant());//appel constructeur de la classe VisuPersonnagesDlg avec comme 3e paramètre le joueur créé temporairement
        diag.setSize(900,1000);
        diag.setVisible(true);//rend la boîte de dialogue visible
    }//GEN-LAST:event_CartesActionPerformed

    private void Transfert_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Transfert_TestActionPerformed
        // méthode de test pour les futurs avancement avec la class Transfert et présentation
        Joueur j1 = new Joueur("FanMemory0", "rares");//création d'un joueur
        //remplissage du paquet de ce joueur (à la main)
        j1.getPaquet().ajoutePerso(new Personnage("communs", "assault-trooper", 10));
        j1.getPaquet().ajoutePerso(new Personnage("communs", "commando", 20));
        j1.getPaquet().ajoutePerso(new Personnage("rares", "absolute-zero", 10));
        Joueur j2 = new Joueur("FanMemory1", "communs");//création d'un joueur
        //remplissage du paquet de ce joueur (à la main)
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        j2.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        j2.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        //ajout des joueurs à la listes des joueurs du jeu
        this.joueurs.ajouteJoueur(j1);
        this.joueurs.ajouteJoueur(j2);
        TransfertDlg diag = new TransfertDlg(this,true,this.joueurs,0);//appel au constructeur d'une variable de type objet de la class TransfertDls + création de la boîte de dialogue
        diag.setVisible(true);//on rend cette boîte de dialogue visible
    }//GEN-LAST:event_Transfert_TestActionPerformed

    private void Bataille_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bataille_TestActionPerformed
        // méthode de test pour une bataille
        // ajout de cartes aux 2 premiers joueurs
        this.joueurs.getJoueur(0).initPaquetTest();
        this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        this.joueurs.getJoueur(1).getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        // ouverture de la boîte de dialogue, avec le 1er joueur en joueur courant.
        BatailleDlg diag = new BatailleDlg(this, true, this.joueurs, 0);
        diag.setSize(1000,600);
        diag.setVisible(true);
    }//GEN-LAST:event_Bataille_TestActionPerformed

    private void DémarrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DémarrerActionPerformed
        //gestionnaire du clic sur le bouton Démarrer
        //le jeu ne peut démarrer que s'il y a au moins 2 joueurs
        if(joueurs.getNbJoueurs()<2)//si ce n'est pas le cas, on affiche un message d'erreur
            jTextArea1.setText("Il faut au moins 2 joueurs pour démarrer.");
        else{//s'il y a au moins 2 joueurs, on peut commencer ; le Panel "Panneau" est initialisé, et ses boutons (cartes) sont créés dynaiquement
            Démarrer.setVisible(false);
            Recommencer.setVisible(true);
            Options.setVisible(false);
            AjoutJoueur.setVisible(false);
            Joueurs.setVisible(true);
            Cartes.setVisible(true);
            int ndpt = persos.getTaille()-monJeu.getMonP().getNbp();//nombre de personnages trouvés
            jLabel1.setText("Nombre de personnages trouvés : "+ndpt);
            jLabel2.setText("Nombre de personnages restants : "+monJeu.getMonP().getNbp());
            jLabel3.setText("C'est à "+monJeu.getJoueurCourant().getPseudo()+" de jouer!");
            Panneau.removeAll();
            this.repaint();
            //on calcule le nombre de colonne du GridLayout
            int ndb = (persos.getTaille())*2;
            int n = 1+(ndb-1)/4;
            Panneau.setLayout(new java.awt.GridLayout(4, n));
            for(int i = 0 ; i<ndb ; i++){//création dynamique des boutons
                JButton bt = new JButton();
                bt.setName(""+i);
                bt.addActionListener(new java.awt.event.ActionListener(){//on abonne chaque bouton à un écouteur
                    public void actionPerformed(java.awt.event.ActionEvent evt){
                        boutonActionPerformed(evt);//qui fait appel à la méthode "boutonActionPerformed(ActionEvent evt)"
                    }
                });
                Panneau.add(bt);//ajout du bouton à "Panneau"
            }
        }
    }//GEN-LAST:event_DémarrerActionPerformed

    private void RecommencerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecommencerActionPerformed
        //gestionnaire du clic sur le bouton Recommencer
        //on enlève les images des boutons
        for(int i = 0 ; i<(persos.getTaille()*2) ; i++){
            JButton bt = (JButton) Panneau.getComponent(i);
            bt.setIcon(null);
        }
        //on vide la liste des joueurs et des personnages (cartes) du jeu
        this.persos = new LesPersonnages();
        this.joueurs = new LesJoueurs();
        //initialisation
        l1 = -1;
        c1 = -1;
        l2 = -1;
        c2 = -1;
        Démarrer.setVisible(true);
        Options.setVisible(true);
        AjoutJoueur.setVisible(true);
        Joueurs.setVisible(false);
        Cartes.setVisible(false);
        jLabel1.setText("Nombre de personnages trouvés : ");
        jLabel2.setText("Nombre de personnages restants : ");
        jLabel3.setText("C'est à qui de jouer?");
        jTextArea1.setText("");
    }//GEN-LAST:event_RecommencerActionPerformed

    private void createPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPlayersActionPerformed
        Joueur thomas = new Joueur("Thomas", "rares");
        Joueur louise = new Joueur("Louise", "communs");
        thomas.setPhoto(new ImageIcon(getClass().getResource("memory/img/thomas.jpg")));
        louise.setPhoto(new ImageIcon(getClass().getResource("memory/img/louise.jpg")));
        thomas.getPaquet().ajoutePerso(new Personnage("communs", "assault-trooper", 10));
        thomas.getPaquet().ajoutePerso(new Personnage("communs", "commando", 20));
        thomas.getPaquet().ajoutePerso(new Personnage("rares", "absolute-zero", 10));
        louise.getPaquet().ajoutePerso(new Personnage("epiques", "burnout", 20));
        louise.getPaquet().ajoutePerso(new Personnage("epiques", "funk-ops", 30));
        louise.getPaquet().ajoutePerso(new Personnage("alpins-femmes", "mogul-master", 10));
        this.joueurs.ajouteJoueur(thomas);
        this.joueurs.ajouteJoueur(louise);
    }//GEN-LAST:event_createPlayersActionPerformed

    private void giveCardsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveCardsActionPerformed
        
    }//GEN-LAST:event_giveCardsActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new JeuMemory().setVisible(true);
            }
        });
    }
    
    private void boutonActionPerformed(ActionEvent evt){
        // on créer cette méthode pour que chaqu'un des boutons qui sont créer dynamiquement puisse intéragir avec l'utilisateur et réagisse aux évenements
        JButton bt = (JButton) evt.getSource();
        int ind = Integer.parseInt(bt.getName());
        int ndb = (persos.getTaille())*2;//nombre de boutons
        int n = 1+(ndb-1)/4;//nombre de colonne à avoir
        int ligne = ind/n;//ligne du bouton
        int colonne = ind%n;//colonne du bouton
        int indpc = this.monJeu.getMonP().getCase(ligne, colonne);//indice du personnage de la carte
        Personnage pc = persos.getPerso(indpc);//personnage de la carte
        Image img = pc.getPhoto();
        ImageIcon imgic = new ImageIcon(img);
        bt.setIcon(imgic);
        //on regarde si le bouton cliqué est le 1er ou le 2nd afin d'activer ou non le timer
        if(l1 == -1 && c1 == -1){
            l1 = ligne;
            c1 = colonne;
        }
        else
            if(l2 == -1 && c2 == -1){
                l2 = ligne;
                c2 = colonne;
                startTimer();//appel de la méthode startTimer()
            }
    }
    
    private void startTimer(){
        //définit un timer qui lance la vérification des deux personnages au bout d'une demi-seconde
        Timer t = new Timer(500, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                verifPersos();//appel de la méthode verifPersos()
            }
        });
        t.setRepeats(false);
        t.start();
    }
    
    public void verifPersos(){
        //méthode qui vérifie si les 2 cartes cliquées sont identiques ou non et qui gère le futur de ces 2 cartes
        int case1 = this.monJeu.getMonP().getCase(l1, c1);
        int case2 = this.monJeu.getMonP().getCase(l2, c2);
        if(case1 == case2){
            //si le chiffre des deux cases est identique, alors ce sont les mêmes cartes
            String fam = persos.getPerso(case1).getFamille();
            int bonus = this.monJeu.traiterTour(this.monJeu.getJoueurCourant(), case1);//appel de la méthode traiterTour de la classe Jeu qui renvoie un int iindiquant quoi faire
            if(bonus >= 0){
                //si le joueur à récupéré toutes les cartes d'une famille
                jTextArea1.setText("Le joueur "+this.monJeu.getJoueurCourant().getPseudo()+" a gagné tous les personnages de la famille"+fam+".");
                if(bonus == 0){
                    //le joueur courant à toutes les cartes de sa famille préférée, il gagne alors la partie et le jeu s'arrête
                    jTextArea1.append("\n"+this.monJeu.getJoueurCourant().getPseudo()+" a gagné la partie !");
                    monJeu.getMonP().termineJeu();
                }
                if(bonus == 1){
                    //si la famille est communs ou rares (non sa préférée)
                    boolean ok = false;
                    int njadc = 0;//nombre de joueurs avec des cartes
                    for(int i = 0 ; i<joueurs.getNbJoueurs() ; i++){
                        if(joueurs.getJoueur(i).getPaquet().getTaille()>0){
                            njadc++;
                        }
                        if(njadc>=2)
                            ok = true;
                    }
                    if(ok){
                        //s'il y a au moins 2 joueurs avec des cartes, alors le joueur courant peut faire un transfert
                        TransfertDlg diag = new TransfertDlg(this, true, joueurs, monJeu.getIndC());
                        diag.setVisible(true);
                        jTextArea1.setText(diag.getTransfert().getDeroulement());
                    }
                }
                if(bonus == 2){
                    //si la famille est epiques ou légendaires (non sa préférée)
                    boolean ok = false;
                    int njadc = 0;//nombre de joueurs avec des cartes
                    for(int i = 0 ; i<joueurs.getNbJoueurs() ; i++){
                        if(joueurs.getJoueur(i).getPaquet().getTaille()>0){
                            njadc++;
                        }
                        if(njadc>=2)
                            ok = true;
                    }
                    if(ok){
                        //s'il y a au moins 2 joueurs avec des cartes, alors le joueur courant peut faire une bataile
                        BatailleDlg diag = new BatailleDlg(this, true, joueurs, monJeu.getIndC());
                        diag.setVisible(true);
                        jTextArea1.setText(diag.getBataille().getDeroulement());
                    }
                }
                bonus = -1;
            }
            this.monJeu.getMonP().invalide(l1, c1, l2, c2);//si le jeu peut cotinuer, on rend invalide les 2 cartes retournées
            if(this.monJeu.getMonP().jeuVide()){
                //si toutes les cartes sont invalides (toutes les paires de cartes ont été trouvées), c'est la fin du jeu
                LesJoueurs jg = joueurs.getGagnants();
                String s = "";
                for(int i = 0 ; i<jg.getNbJoueurs() ; i++){
                    s+="\n"+jg.getJoueur(i).getPseudo();
                }
                jTextArea1.setText("Le ou la ou les gagnant(e/es/s) est (sont) : "+s);//on affiche les gagnants
            }
            else{
                //sinon, le jeu continue et le joueur courant rejoue
                String s = this.monJeu.getJoueurCourant().getPseudo();
                jTextArea1.append("C'est à "+s+" de jouer!\n");
                jLabel3.setText("C'est à "+s+" de jouer!");
            }
            int ndpt = persos.getTaille()-monJeu.getMonP().getNbp();
            jLabel1.setText("Nombre de personnages trouvés : "+ndpt);
            jLabel2.setText("Nombre de personnages restants : "+monJeu.getMonP().getNbp());
        }
        else{
            //si les 2 cartes sont différentes
            int ndb = (persos.getTaille())*2;
            int n = 1+(ndb-1)/4;
            int ind1 = l1*n+c1;
            int ind2 = l2*n+c2;
            JButton jb1 = (JButton) Panneau.getComponent(ind1);
            JButton jb2 = (JButton) Panneau.getComponent(ind2);
            //on enlève les images des boutons
            jb1.setIcon(null);
            jb2.setIcon(null);
            //on passe au joueur suivant
            String s = this.monJeu.getJoueurSuivant(this.monJeu.getIndC()).getPseudo();
            jTextArea1.append("C'est à "+s+" de jouer!\n");
            jLabel3.setText("C'est à "+s+" de jouer!");
            this.monJeu.setIndC(this.monJeu.getIndSuivant(this.monJeu.getIndC()));
        }
        //on réinitialise les attributs de lignes et de colonnes
        l1 = -1;
        c1 = -1;
        l2 = -1;
        c2 = -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AjoutJoueur;
    private javax.swing.JMenuItem Bataille_Test;
    private javax.swing.JMenuItem Cartes;
    private javax.swing.JButton Démarrer;
    private javax.swing.JMenuItem Joueurs;
    private javax.swing.JMenuItem Options;
    private javax.swing.JPanel Panneau;
    private javax.swing.JButton Recommencer;
    private javax.swing.JMenuItem Transfert_Test;
    private javax.swing.JMenuItem createPlayers;
    private javax.swing.JMenuItem giveCards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}