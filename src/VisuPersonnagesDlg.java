
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Thomas
 */

public class VisuPersonnagesDlg extends javax.swing.JDialog{
    
    private Joueur j; // Attribut de type Joueur correspondant au joueur auquel on veut voir ses cartes
    
    public VisuPersonnagesDlg(java.awt.Frame parent, boolean modal, Joueur jou){
        // Constructeur pour initialiser l'attribut, créer la fenêtre et le Trombinoscope
        // Puis on fait appel au constructeur de la superclass avec un paramètre qui gère la boite et un mode d'ouverture bloquant
        super(parent, modal);
        this.setLocationRelativeTo(null); // on centre la fenêtre
        //initialisation de l'attribut
        this.j = jou;
        initComponents(); //création de l'interface
        initDonnees(); // appel de la méthode initDonnees
        initPanneau(); // appel de la méthode initPanneau
    }
    
    private void initPanneau(){
        // Méthode qui permet d'initialiser le Trombinoscope avec le nombre de boutons nécessaire selon la taille du paquet du joueur
        int n = this.j.getPaquet().getTaille();
        if(n==0 || n==1)
            Trombi.setLayout(new GridLayout(1, 1));
        if(2<=n && n<=4)
            Trombi.setLayout(new GridLayout(2, 2));
        if(5<=n && n<=9)
            Trombi.setLayout(new GridLayout(3, 3));
        if(10<=n && n<=16)
            Trombi.setLayout(new GridLayout(4, 4));
        if(17<=n && n<=25)
            Trombi.setLayout(new GridLayout(5, 5));
        if(26<=n && n<=32)
            Trombi.setLayout(new GridLayout(6, 6));
        for (int i=0; i< n; i++){
            //on va crée le nombre de boutons nécessaire
            JButton jb = new JButton();
            jb.setName(""+i);
            Trombi.add(jb);
        }
        this.pack(); // pour ajuster correctement la taille des composants après les ajouts si besoin
    }
    
    private void initDonnees(){
        // Méthode qui permet le remplissage des données des JLabel avec les pseudos
        String s1 = jLabel1.getText();
        s1 = s1+j.getPseudo();
        jLabel1.setText(s1);
        String s2 = jLabel2.getText();
        int i = j.getScore();
        s2 = s2+i;
        jLabel2.setText(s2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Trombi = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Afficher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel1.setText("Cartes du joueur : ");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout TrombiLayout = new javax.swing.GroupLayout(Trombi);
        Trombi.setLayout(TrombiLayout);
        TrombiLayout.setHorizontalGroup(
            TrombiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1099, Short.MAX_VALUE)
        );
        TrombiLayout.setVerticalGroup(
            TrombiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jPanel2.add(Trombi, java.awt.BorderLayout.CENTER);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel2.setText("Score : ");
        jPanel5.add(jLabel2);

        jPanel2.add(jPanel5, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        Afficher.setText("Afficher");
        Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfficherActionPerformed(evt);
            }
        });
        jPanel3.add(Afficher);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfficherActionPerformed
        // Méthode qui au clic sur le boutons Afficher va remplir les boutons du trombinoscope avec les images des cartes possèder par le joueur courant
        for(int i=0 ; i<this.j.getPaquet().getTaille() ; i++)
        {
            JButton bt = (JButton) Trombi.getComponent(i);
            Personnage p = this.j.getPaquet().getPerso(i);
            Image img = p.getPhoto().getScaledInstance(bt.getWidth(), bt.getHeight(), Image.SCALE_DEFAULT);
            bt.setIcon(new ImageIcon(img));
        }
    }//GEN-LAST:event_AfficherActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Afficher;
    private javax.swing.JPanel Trombi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}