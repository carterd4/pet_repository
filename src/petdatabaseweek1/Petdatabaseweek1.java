/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabaseweek1;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author dlcar
 */

class Pet{
    private String petName;
    private int petAge;

    /**
     * @return the petName
     */
    public String getPetName() {
        return petName;
    }

    /**
     * @param petName the petName to set
     */
    public void setPetName(String petName) {
        this.petName = petName;
    }

    /**
     * @return the petAge
     */
    public int getPetAge() {
        return petAge;
    }

    /**
     * @param petAge the petAge to set
     */
    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
    
}
public class Petdatabaseweek1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        ArrayList<Pet> petList= new ArrayList<Pet>();
        boolean continuity= true;
        while(continuity){
        System.out.println("What would you like to do?"+
"  \n1) View all pets"+
"  \n2) Add more pets"+
"  \n3) Update an existing pet"+
"  \n4) Remove an existing pet"+
"  \n5) Search pets by name"+
"  \n6) Search pets by age"+
"  \n7) Exit program"
);
        System.out.print("\nYour choice: ");
        int userChoice=input.nextInt();
        switch(userChoice){
            case 1:{
                System.out.println("+-----------------------+");
                System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',"ID",'|',
                        "NAME",'|',"AGE",'|' );
                System.out.println("+-----------------------+");
                for(int i=0; i<petList.size();i++){
                    System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',i,
                            '|',petList.get(i).getPetName(),'|',
                            petList.get(i).getPetAge(),'|' );
                }
                System.out.println("+-----------------------+\n"+petList.size()+
                        " rows in a set.\n");
                break;
            }
            case 2:{
                int petCounter=0;
                boolean continuousPegasus=true;
                while(continuousPegasus){
                    System.out.print("add pet (name, age): ");
                    String name=input.next();
                    
                    if(name.equals("done")){
                        System.out.println(petCounter+ " pets added.\n");
                        continuousPegasus=false;
                        break;
                    }
                    else{
                        int age=input.nextInt();
                        Pet pet=new Pet();
                        pet.setPetName(name);
                        pet.setPetAge(age);
                        petList.add(pet);
                        petCounter++;
                    }
                }
            }
            case 3:break;
            case 4:break;
            case 5: break;
            case 6:break;
            case 7:{ System.out.println("Goodbye!"); continuity=false;break;}
        }
            
        }
    
    }
}
