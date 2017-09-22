/*
*//**
 *
 * @author Ashley Lobo
 */
import java.util.ArrayList;
import java.util.Scanner;


class Prison{
// HAS A TYPE OF RELATIONSHIP POLICE CONTAINS PRISON
    /*
      add prisoner,change guard,change prisoners service,give parole,remove 
    prioner
    */
    static int piD , giD;
    String type;
    String [] a;
    ArrayList<Prisoner> inmates;
    ArrayList<Guards> guards;
    Prison(int code)
    {
        piD = 1000 + code;
        giD = 100+ code;
        guards = new ArrayList<>();
        inmates = new ArrayList<>();
    }
    void addPrisoner(Prisoner p)
    {
        p.status="Active";
        p.job="None";
        p.uniqueiD = piD++;
        System.out.println("Sucefully Added with Unique ID number: " + p.uniqueiD);
        inmates.add(p);
    }
    void addGuard(Guards g)
    {
        g.guardCode = giD++;
        System.out.println("Sucefully Added with GuardCode number: " + g.guardCode);
        guards.add(g);
    }
   void displayPrisoner(){
        
        for(int i=0;i<inmates.size();i++)
            a[i]=("Name: "+inmates.get(i).name+" Age: "+inmates.get(i).age+" Gender: "+inmates.get(i).gender+" UniqueId: "+inmates.get(i).uniqueiD+" Job Assigned: "+inmates.get(i).job+" Status:"+inmates.get(i).status);
        for(String w:a)
            System.out.print(w);
    }
    void displayGuard(){
        for (Guards p : guards) {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" Post: "+p.post+" Years of Experience:"+p.yearsOfExperience );
        }//
    }
    Prisoner getPrisoner(int ID)
    {
           int get = -1;
        for(Prisoner p : inmates)
        {
            if(p.uniqueiD == ID)
            {
                get = inmates.indexOf(p);
                break;
            }
        }
        if(get!=-1)
             return inmates.get(get);
        else
            return null;
    }
    void removePrisoner(int ID)
    {
        int rem = -1;
        for(Prisoner p : inmates)
        {
            if(p.uniqueiD == ID)
            {
                rem = inmates.indexOf(p);
                break;
            }
        }
        if(rem!=-1)
            inmates.remove(rem);
        else
            System.out.println("Wrong Index");
    }
    void parole(Prisoner p,int id){
        Services s =new Services();
        if(s.checkAssign(p)){
            s.removeJob(s.assignment(p),id);
            p.status="Parole";
        }
        else
            p.status="Parole";
        }
}

class Services{
    int earnings;
    int numberOfJobs;
    ArrayList<Prisoner> Cooking;
    ArrayList<Prisoner> Construction;
    ArrayList<Prisoner> Carpentry;
    Services()
    {
        Cooking =new ArrayList<>();
        Construction =new ArrayList<>();
        Carpentry =new ArrayList<>();
    }
    void giveJob(Prisoner p , int ch)
    {
        switch(ch)
        {
            case 1:
                p.job = "Cook";
                Cooking.add(p);
                break;
            case 2:
                p.job = "Constructor";
                Construction.add(p);
                break;
            case 3:
                p.job = "Carpenter";
                Carpentry.add(p);
                break;
        }
    }
    boolean checkAssign(Prisoner p){
        
        return p.job.equals("None");
    }
    String assignment(Prisoner p){
        return p.job;
    }
    void removeJob(String s,int id){
        if(s.equals("Cooking")){
            for (int i=0;i<Cooking.size();i++) {
                if(Cooking.get(i).uniqueiD==id)
                    Cooking.remove(i);
            }
        }
        else if(s.equals("Construction")){
             for (int i=0;i<Construction.size();i++) {
                if(Construction.get(i).uniqueiD==id)
                    Construction.remove(i);
            }
        }
        else if(s.equals("Carpenter")){
             for (int i=0;i<Carpentry.size();i++) {
                if(Carpentry.get(i).uniqueiD==id)
                    Carpentry.remove(i);
            }
        }
    }
    void displayJobs(int ch)
    {
        switch(ch)
        {
            case 1:
                Cooking.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
            case 2:
                Construction.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
            case 3:
                Carpentry.forEach((p) -> {
                    System.out.println(p.name + " Id Number: " + p.uniqueiD);
        });
                break;
        }
    }
}
class Cells{
    // cell a for high level etc etc
    // cells have gaurds and prisoners
}
abstract class Person{
    // will contain for prisoners etc
    // name, age,gender
    String name;
    int age;
    String gender;
    Date birthday;
    Person(String name,int age,String gender)
    {     
    this.name=name;
    this.age=age;
    this.gender=gender;
    birthday = new Date();
    }
    Person(String name,int age,String gender , Date bday)
    {     
    this.name=name;
    this.age=age;
    this.gender=gender;
    bday = birthday;
    }
}
class Prisoner extends Person{
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    int uniqueiD;
    String job;
    String status;
    public Prisoner(String name, int age, String gender)
    {
        super(name, age, gender);
    }

    Prisoner(String name, int age, String gender , Date defaul)
    {
        super(name, age, gender , defaul);
    }
    // level of crime acc level to crime they will be assigned a cell
    // crime date of relaease
    // date of joining ,services assigned
    String getDetails(){
        return "Name: "+name+" Age: "+age+" Gender: "+gender+" UniqueId: "+uniqueiD+" Job Assigned: "+job;
    }

}
class Guards extends Person{
    // level of posting
    // experience in years
    String post;
    int yearsOfExperience;
    int guardCode;
    Scanner sc = new Scanner(System.in).useDelimiter("\\n");
    public Guards(String name, int age, String gender)
    {
        super(name, age, gender);
        System.out.println("Enter Post & Current Experience");
        post = sc.next();
        yearsOfExperience = sc.nextInt();
    }
    // level of posting
    // experience in years
        
    
}

class Date
{
    int dd, mm , yy;
    Date() //Default Constructors
    {
        Scanner d = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("Enter day month year");
        dd = d.nextInt();
        mm = d.nextInt();
        yy = d.nextInt();
    }
    Date(int d , int m ,int y) //Parameterized Constructor
    {
        d = dd;
        m = mm;
        y = yy;
    }
    String getDate()
    {
        return dd+"-"+mm+"-"+yy;
    }
}
public class JavaPrisonGUI extends javax.swing.JFrame {

    /**
     * Creates new form JavaPrisonGUI
     */
    Scanner sc = new Scanner(System.in).useDelimiter("\\n");
       
        Prison maleP = new Prison(0 );//Male Prisoners
        Prison femaleP = new Prison(500 ); //Female Prisoners      
        Prison guard =new Prison(11);//Guard
        Prisoner[] p = new Prisoner[10]; //Our Jail can hold 10 Prisoners
        Guards[] g = new Guards[5]; //Only 5 Guards
        Services s = new Services();
        int pC = 5 , gC = 0;
        Prisoner temp;
        int tempC;
    public JavaPrisonGUI() {
        initComponents();
        Date defaul = new Date(12 , 11 , 1998);
        p[0] = new Prisoner("Ashley" , 17 , "Male" , defaul);
        maleP.addPrisoner(p[0]);
        p[1] = new Prisoner("Nehal" , 18 , "Male" , defaul);
        femaleP.addPrisoner(p[1]);
        p[2] = new Prisoner("Karry" , 19 , "Male" , defaul);
        maleP.addPrisoner(p[2]);
        p[3] = new Prisoner("Sheena" , 28 , "Female" , defaul);
        p[4] = new Prisoner("Maya" , 31 , "Female" , defaul);
        prisonPanel.setVisible(false);
       
        System.out.println("Welcome to Mumbai Police Prison Department");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        prisonSection = new javax.swing.JButton();
        guardSection = new javax.swing.JButton();
        serviceSection = new javax.swing.JButton();
        prisonPanel = new javax.swing.JPanel();
        text1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prisonSection.setText("PrisonSection");
        prisonSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prisonSectionActionPerformed(evt);
            }
        });

        guardSection.setText("GuardSection");
        guardSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardSectionActionPerformed(evt);
            }
        });

        serviceSection.setText("Service Section");
        serviceSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceSectionActionPerformed(evt);
            }
        });

        text1.setText("text area");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        javax.swing.GroupLayout prisonPanelLayout = new javax.swing.GroupLayout(prisonPanel);
        prisonPanel.setLayout(prisonPanelLayout);
        prisonPanelLayout.setHorizontalGroup(
            prisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prisonPanelLayout.createSequentialGroup()
                .addGroup(prisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(prisonPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(prisonPanelLayout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton1))
                    .addGroup(prisonPanelLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        prisonPanelLayout.setVerticalGroup(
            prisonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(prisonPanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(prisonSection, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardSection, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serviceSection, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prisonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prisonSection)
                    .addComponent(guardSection)
                    .addComponent(serviceSection))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(prisonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prisonSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prisonSectionActionPerformed
    prisonPanel.setVisible(true);
        
       // TODO add your handling code here:
    }//GEN-LAST:event_prisonSectionActionPerformed

    private void guardSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardSectionActionPerformed
        prisonPanel.setVisible(false);
       
                  // TODO add your handling code here:
    }//GEN-LAST:event_guardSectionActionPerformed

    private void serviceSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceSectionActionPerformed
        prisonPanel.setVisible(false);
       
       
    }//GEN-LAST:event_serviceSectionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    text1.setText("Male Prison");
   
    maleP.displayPrisoner();              
    
                                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JavaPrisonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaPrisonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaPrisonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaPrisonGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaPrisonGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton guardSection;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel prisonPanel;
    private javax.swing.JButton prisonSection;
    private javax.swing.JButton serviceSection;
    private javax.swing.JTextArea text;
    private javax.swing.JLabel text1;
    // End of variables declaration//GEN-END:variables
}
