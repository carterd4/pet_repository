/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petdatabaseweek1;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author dlcar
 */

class Pet implements Serializable{
    private String petName;
    private int petAge;
    public Pet(){}
    public Pet (String name,int age){
        this.petName=name;
        this.petAge= age;
    }
    

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
    public static void main(String[] args) throws Exception {
        Scanner input= new Scanner(System.in);
        ArrayList<Pet> petList= new ArrayList<Pet>();
        boolean continuity= true;
        File file = new File("readandwrite.ser");
        file.createNewFile();
        Scanner fileScan = new Scanner(file);
        while(fileScan.hasNextLine()){
            petList.add(new Pet(fileScan.next(), fileScan.nextInt()));
        }
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
        // We use a switch as mechanism of carrier for functionality.
        switch(userChoice){
            case 1:{
                System.out.println("+-----------------------+");
                // Printf is used to properly align the format of the code.
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
                break;
            }
            
            case 3:{ 
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
                System.out.print("\nEnter the pet ID you want to update:" );
                int id=input.nextInt();
                Pet newPet=petList.get(id);
                String orig=newPet.getPetName();
                int oldA=newPet.getPetAge();
                System.out.print("\n Enter new name and new age:");
                newPet.setPetName(input.next());
                newPet.setPetAge(input.nextInt());
                System.out.println(orig+" "+oldA+" changed to "+newPet.getPetName()+" "+newPet.getPetAge()+".\n");
                break;}
            case 4:{
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
                System.out.print("\nEnter the pet ID you want to remove:" );
                int id=input.nextInt();
                Pet newPet=petList.get(id);
                String orig=newPet.getPetName();
                int oldA=newPet.getPetAge();
                petList.remove(petList.get(id));
                System.out.println(orig+" "+oldA+"is removed.\n ");
                break;
            }
            case 5:{
                System.out.print("Enter a name to search:");
                String searchName=input.next();
                System.out.println("+-----------------------+");
                System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',"ID",'|',
                        "NAME",'|',"AGE",'|' );
                System.out.println("+-----------------------+");
                for(int i=0; i<petList.size();i++){
                    if (petList.get(i).getPetName().equalsIgnoreCase(searchName)) {                  
                System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',i,
                            '|',petList.get(i).getPetName(),'|',
                            petList.get(i).getPetAge(),'|' );
                }
                }
                System.out.println("+-----------------------+\n"+petList.size()+
                        " rows in a set.\n");
                break;
            }
            case 6:{
                System.out.print("Enter a age to search:");
               int searchAge=input.nextInt();
                System.out.println("+-----------------------+");
                System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',"ID",'|',
                        "NAME",'|',"AGE",'|' );
                System.out.println("+-----------------------+");
                for(int i=0; i<petList.size();i++){
                    if (petList.get(i).getPetAge()==(searchAge)) {                  
                System.out.printf("%c %-2s %c %-10s %c %3s %c\n",'|',i,
                            '|',petList.get(i).getPetName(),'|',
                            petList.get(i).getPetAge(),'|' );
                }
                }
                System.out.println("+-----------------------+\n"+petList.size()+
                        " rows in a set.\n");
            }
                break;
            case 7:{ System.out.println("Goodbye!"); 
            try {FileWriter fileWrite;
            fileWrite =new FileWriter("readandwrite.ser");
                PrintWriter printWrite=new PrintWriter(fileWrite);
                for (int I = 0; I<petList.size();I++){
                    if (!(I==petList.size()-1)){
                        printWrite.print(petList.get(I).getPetName()+" "
                                +petList.get(I).getPetAge()+"\n");
                        
                    }
                    else{
                         printWrite.print(petList.get(I).getPetName()+" "
                                +petList.get(I).getPetAge());
                         
                    }
                }
                printWrite.close();
            }catch (Exception X){
                X.printStackTrace();
            }
            continuity=false;break;}
        }
            
        }
    
    }
}
