package InternalAssesment;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

        try {
            UserDB.Load();
        } catch (FileNotFoundException ex) {
        System.exit(404);
            ex.printStackTrace();
        }

        new ChooseUser();
        UserDB.TeacherName = "teacher@gmail.com";
        UserDB.TeacherPassword = "1234";
    }

}
