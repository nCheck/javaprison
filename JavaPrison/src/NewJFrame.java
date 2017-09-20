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
        
        inmates.forEach((p) -> {
            System.out.println("Name: "+p.name+" Age: "+p.age+" Gender: "+p.gender+" UniqueId: "+p.uniqueiD+" Job Assigned: "+p.job+" Status:"+p.status);
        });
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
public class NewJFrame extends javax.swing.JFrame {
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
        Date defaul = new Date(12 , 11 , 1998);
        
    public NewJFrame() {
        initComponents();
        p[0] = new Prisoner("Ashley" , 17 , "Male" , defaul);
        maleP.addPrisoner(p[0]);
        p[1] = new Prisoner("Nehal" , 18 , "Male" , defaul);
        femaleP.addPrisoner(p[1]);
        p[2] = new Prisoner("Karry" , 19 , "Male" , defaul);
        maleP.addPrisoner(p[2]);
        p[3] = new Prisoner("Sheena" , 28 , "Female" , defaul);
        p[4] = new Prisoner("Maya" , 31 , "Female" , defaul);
        textbox1.setText("Welcome to Mumbai Police Prison Department");//Welcome to Mumbai Police Prison Department
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem9 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        textbox1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        PrisonSection = new javax.swing.JMenu();
        AddPrisoner = new javax.swing.JMenuItem();
        RemovePrisoner = new javax.swing.JMenuItem();
        GrantParole = new javax.swing.JMenuItem();
        DisplayPrison = new javax.swing.JMenuItem();
        GuardSection = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        ServiceSection = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        jMenuItem9.setText("jMenuItem9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(430, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(textbox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(textbox1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addGap(135, 135, 135)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257))
        );

        PrisonSection.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        PrisonSection.setText("Prison Section");
        PrisonSection.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                PrisonSectionMenuSelected(evt);
            }
        });

        AddPrisoner.setText("Add Prisoner");
        AddPrisoner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPrisonerActionPerformed(evt);
            }
        });
        PrisonSection.add(AddPrisoner);

        RemovePrisoner.setText("Remove Prisoner");
        RemovePrisoner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovePrisonerActionPerformed(evt);
            }
        });
        PrisonSection.add(RemovePrisoner);

        GrantParole.setText("Grant Parole");
        GrantParole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrantParoleActionPerformed(evt);
            }
        });
        PrisonSection.add(GrantParole);

        DisplayPrison.setText("Display");
        DisplayPrison.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayPrisonActionPerformed(evt);
            }
        });
        PrisonSection.add(DisplayPrison);

        jMenuBar1.add(PrisonSection);

        GuardSection.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        GuardSection.setText("Guard Section");

        jMenuItem5.setText("Assign Guard");
        GuardSection.add(jMenuItem5);

        jMenuItem6.setText("Display");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        GuardSection.add(jMenuItem6);

        jMenuBar1.add(GuardSection);

        ServiceSection.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ServiceSection.setText("Service Section");

        jMenuItem7.setText("Assign Jobs");
        ServiceSection.add(jMenuItem7);

        jMenuItem8.setText("Check Jobs");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        ServiceSection.add(jMenuItem8);

        jMenuItem10.setText("Display");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        ServiceSection.add(jMenuItem10);

        jMenuBar1.add(ServiceSection);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrisonSectionMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_PrisonSectionMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_PrisonSectionMenuSelected

    private void AddPrisonerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPrisonerActionPerformed
 System.out.println("Enter Name , Age and Gender");
                            String name = sc.next();
                            int age = sc.nextInt();
                            String gender = sc.next();
                            p[pC] = new Prisoner(name , age , gender);
                            if(gender.equals("Male"))
                                maleP.addPrisoner(p[pC++]);
                             else
                                femaleP.addPrisoner(p[pC++]);        // TODO add your handling code here:
    }//GEN-LAST:event_AddPrisonerActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void DisplayPrisonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayPrisonActionPerformed
        // TODO add your handling code here: System.out.println("Male Prison");
                             maleP.displayPrisoner();
                            System.out.println("Female Prison");
                            femaleP.displayPrisoner();
    }//GEN-LAST:event_DisplayPrisonActionPerformed

    private void RemovePrisonerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovePrisonerActionPerformed
System.out.println("Male or Female?");
                            String res = sc.next();
                            System.out.println("Enter Prisoner Unique ID number");
                            int idOut = sc.nextInt();
                            switch(res)
                            {
                                case "Male":
                                    maleP.removePrisoner(idOut);
                                    break;
                                default:
                                    femaleP.removePrisoner(idOut);
                            }        // TODO add your handling code here:
    }//GEN-LAST:event_RemovePrisonerActionPerformed

    private void GrantParoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrantParoleActionPerformed
System.out.println("Enter Prisoner Unique ID");
                            int id = sc.nextInt();
                            if(id < 1500)
                            {
                                 temp = maleP.getPrisoner(id);
                                 maleP.parole(temp, id);
                            }
                            else
                               {
                                  temp = femaleP.getPrisoner(id);
                                  femaleP.parole(temp, id);
                               }        // TODO add your handling code here:
    }//GEN-LAST:event_GrantParoleActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddPrisoner;
    private javax.swing.JMenuItem DisplayPrison;
    private javax.swing.JMenuItem GrantParole;
    private javax.swing.JMenu GuardSection;
    private javax.swing.JMenu PrisonSection;
    private javax.swing.JMenuItem RemovePrisoner;
    private javax.swing.JMenu ServiceSection;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel textbox1;
    // End of variables declaration//GEN-END:variables
}
