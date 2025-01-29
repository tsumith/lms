package PAT.LMS;
import java.util.Scanner;
public class Lms {
    public static void main(String[] args){
        start();
    }
    public static void start(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to library !");
        System.out.println("Chose what to do :");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("3. Get user details");
        System.out.println("4. Exit");
        int choice=sc.nextInt();
        UsersManager Umng=new UsersManager();
        switch(choice){
            case 1:
                System.out.println("Enter username : ");
                String username=sc.next();
                System.out.println("Enter password : ");
                String password=sc.next();
                
                SignIn signIn=new SignIn(username, password);
                boolean isThere=signIn.findUser(username, password);
                if (isThere) {
                    signIn.showDBoard();
                }else{
                    System.out.println("user not found! please try again.");
                }
              
                break;
            case 2:
                System.out.println("Enter username : ");
                String username1=sc.next();
                System.out.println("Enter password : ");
                String password1=sc.next();
                System.out.println("Enter email : ");
                String email=sc.next();
                System.out.println("Enter phone number : ");
                String phone=sc.next();
                SignUp signup=new SignUp();
                boolean check=signup.addUser(username1,password1,email,phone);
                if (check) {
                    System.out.println("Sign Up successful!");
                    start();
                }else{
                    System.out.println("Sign Up failed! please try again");
                }
                // SignUp signUp=new SignUp(username1, password1, email, phone);
                break;
            case 3:
                System.out.println("Enter username:");
                String username3=sc.next();
                String details=Umng.getDetails(username3);
                System.out.println(details);

                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice !");
        }
        sc.close();
    }

    
    
}
//  class UsersManager{
//     public static boolean addUser(String username,String password,String email,String phone){
//         File usersDb=new File("C:\\sumith\\programming\\java\\PAT\\LMS\\UsersDb.txt");
//         try {
//             if (!usersDb.exists()) {
//                 usersDb.createNewFile();
//             }
        
        
//         if (usersDb.exists()) {
            
//                 try (FileWriter writer = new FileWriter(usersDb,true)) {
//                     writer.write(username+" "+password+" "+email+" "+phone+"\n");
//                 }
//                 return true;
             
//         }
//     }catch(IOException e){
//         System.out.println(e.getMessage());
        
//     }
//     return false;
//     }
//     public static boolean checkUser(String username,String password){
//         File usersDb=new File("UsersDb.txt");
//         if(usersDb.exists()){
//             try {
//                 Scanner sc=new Scanner(usersDb);
//                 while(sc.hasNextLine()){
//                     String userDetails=sc.nextLine();
//                     String[] details=userDetails.split(" ");
//                     if(details[0].equals(username)&&details[1].equals(password)){
//                         return true;
//                     }
//                 }
                
//             } catch (Exception e) {
//                 return false;
//             }   
//         }
//         return false;

//     }
// }
