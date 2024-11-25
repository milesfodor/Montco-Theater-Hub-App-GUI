import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseInit {
    public static void main(String[] args) throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\default.LAPTOP-A2KHEE23\\OneDrive\\Documents\\CIS111\\montco-theater-hub-app-firebase-adminsdk-ce02d-9e2b56bdaf.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);

    }
}
