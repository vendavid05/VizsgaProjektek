
package Main;


public class SzornyProgram {
    public static void main(String[] args) {
        Szorny sz0 = new Szorny();
        Szorny sz1 = new Szorny(Tipusok.ZOMBI,"Feri",-10,5);
        Szorny sz2 = new Szorny(Tipusok.DEMON,"Pippo",15,8);
        Szorny sz3 = new Szorny(Tipusok.SZELLEM,"Jani",5,0);
        
        System.out.println("sz0: " + sz0);
        System.out.println("sz1: " + sz1);
        System.out.println("sz2: " + sz2);
        System.out.println("sz3: " + sz3);

        
        System.out.println("sz1 erősebb mint sz3 --> " + sz1.ErosebbMint(sz3));
        
        harc(sz1,sz2);
    }
    private static void harc(Szorny sz1, Szorny sz2) {
    System.out.println("---------------------");
    System.out.println("HARC: " + sz1.getNev() + " VS " + sz2.getNev());
    
    int hp1 = sz1.getElet();
    int hp2 = sz2.getElet();
    int kor = 1;
    System.out.println(sz1.getNev()+" élete: " + hp1 + "," + sz2.getNev() + " élete: " + hp2);
        
    while (hp1 > 0 && hp2 > 0) {
        System.out.println(kor + ". kör:");
        
        //sz1 támad
        hp2 -= sz1.getSebzes();
        if (hp2 < 0) {
            hp2 = 0;
        }
        System.out.println(sz1.getNev() + " ütött (" + sz1.getSebzes() + " sebzés). " + sz2.getNev() + " élete: " + hp2);

        //sz2 támad
        if (hp2 > 0) {
            hp1 -= sz2.getSebzes();
            if (hp1 < 0) {
                hp1 = 0;
            }
            System.out.println(sz2.getNev() + " visszatámadt (" + sz2.getSebzes() + " sebzés). " + sz1.getNev() + " élete: " + hp1);
        }
        kor++;
        System.out.println("--------------------");
    }

    if (hp1 > 0) {
        System.out.println("Győztes: " + sz1.getNev() + " (maradt élete: " + hp1 + " HP)");
    } else {
        System.out.println("Győztes: " + sz2.getNev() + " (maradt élete: " + hp2 + " HP)");
    }
}
    
}
