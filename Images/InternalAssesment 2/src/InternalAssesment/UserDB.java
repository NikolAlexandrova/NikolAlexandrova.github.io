package InternalAssesment;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

    public class UserDB {
        static public ArrayList<User> allUsers = new ArrayList<User>();
        static String TeacherName;
        static String TeacherPassword;
        public static User LoggedUser;

        public static User getLoggedUser() {
            return LoggedUser;
        }

        public static void setLoggedUser(User loggedUser) {
            LoggedUser = loggedUser;
        }

        public static void addUser(String userName, String Password, String[] progresses){
        User newUser = new User();
        newUser.password = Password;
        newUser.username = userName;
        newUser.progress = progresses;
        allUsers.add(newUser);
    }

    public static void addUser(String userName, String Password){
        User newUser = new User();
        newUser.password = Password;
        newUser.username = userName;
        newUser.progress = new String[9];

        for(int i =0; i<newUser.progress.length; i++){
            newUser.progress[i]="Not selected";
        }
        allUsers.add(newUser);
    }
    public static void Save(){
        try{
            FileWriter fw = new FileWriter("login", false);
            for (int i =0; i<UserDB.allUsers.size();i++) {
                User userToSave = UserDB.allUsers.get(i);
                fw.write(userToSave.username + "\t" + userToSave.password + "\t");
                for (int j =0; j<userToSave.progress.length;j++){
                    fw.write(userToSave.progress[j]+"\t" );
                }
                fw.write("\n");
            }
            fw.close();
        } catch(Exception ex){
        }
    }
    static int checkUser(String name, String password) {

        for (int i = 0; i < UserDB.allUsers.size(); i++) {
            if (UserDB.allUsers.get(i).username.compareTo(name) == 0) {
                if (UserDB.allUsers.get(i).password.compareTo(password) == 0) {
                    System.out.println("OK!");
                    return i;
                }
            }
        }
        System.out.println("Wrong password or email!");
        return -1;
    }

    public static void Load() throws FileNotFoundException {
        try {
            String filename = "login";
            Path path = Paths.get(filename);
            InputStream input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String temp = null;
            String user;
            String pass;
            boolean found = false;
            while((temp = reader.readLine()) != null){
                String[] account = temp.split("\t");
                user = account[0];
                pass = account[1];
                String[] progresses = new String[9];
                for(int i = 0; i < 9; i++){
                    progresses[i] = account[i + 2];
                }
                addUser(user, pass, progresses);
            }
        } catch(Exception e){
           System.out.print(e.getMessage());
        }
    }

    public static int indexOf(String[] data, String searchValue){
        for(int i = 0; i < data.length; i++) {
            if(data[i].equals(searchValue)){
                return i;
            }
        }
        return -1;
    }
}

