
package Main;

import java.util.Random;


public class Tombok {
    public static void main(String[] args) {
        int [] szamok = new int[10];
        Random random = new Random();
        
        for (int i = 0; i < szamok.length; i++) {
            szamok[i] = random.nextInt(51) - 20;//50 -20 = 30 --> -20 és 30 között
            
        }
        System.out.print("Számok:");
        
        
        
        TombKiiratas(szamok);
        
        double atlag = pozitivakAtlaga(szamok);
        
        System.out.println("a pozitiv számok átlaga:" + atlag);
        legkissebbPozicio(szamok);
        
        int legnagyobb = Legnagyobb(szamok);
        System.out.println("A tömb legnagyobb eleme:" + legnagyobb);
        
        int keresettSzam = 30;
        int keresett = kereses(szamok,keresettSzam);
        
        if(keresett == -1){
            System.out.println("Nincs benne " + keresettSzam);
        }else{
            System.out.println("Van benne "+ keresettSzam);
        }
        
    }
    public static void TombKiiratas(int[] tomb){
        for (int i = 0; i < tomb.length; i++) {
            System.out.print(tomb[i]);
            if (i < tomb.length - 1) { 
        System.out.print(", ");
        
    }
            
        }
        System.out.println("");
    }
            
    private static double pozitivakAtlaga(int[] tomb) {
    int pozitivakOsszege = 0;
    int pozitivakDb = 0;

    for (int i = 0; i < tomb.length; i++) {
        if (tomb[i] > 0) {
            pozitivakOsszege += tomb[i];
            pozitivakDb++;
        }
    }

    if (pozitivakDb == 0) return 0;

    return (double) pozitivakOsszege / pozitivakDb;
}
    
    private static void legkissebbPozicio(int[] tomb) {
    int legkissebbIndex = 0;
    int legkissebb = tomb[0];
    
    for (int i = 1; i < tomb.length; i++) {
        if (tomb[i] < legkissebb) {
            legkissebb = tomb[i];
            legkissebbIndex = i; 
        }
    }
    System.out.println("A legkisebb szám értéke: " + legkissebb + ", pozíciója (index): " + legkissebbIndex);
}
    public static int Legnagyobb(int [] tomb){
        int legnagyobb = tomb[0];
        for (int i = 0; i < tomb.length; i++) {
            if(tomb[i] > legnagyobb){
                legnagyobb = tomb[i];
                
            }
            
        }
        return legnagyobb;
    }
    
    public static int kereses(int [] tomb ,int keresett){
           for (int i = 0; i < tomb.length; i++) {
               if(tomb[i]==keresett){
                   return i;
               }
               
           }
           return -1;
       }
}
