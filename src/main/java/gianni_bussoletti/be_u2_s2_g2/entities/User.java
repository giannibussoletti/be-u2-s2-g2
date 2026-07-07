package gianni_bussoletti.be_u2_s2_g2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Random;

@Getter
@Setter
@ToString
public class User {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String avatarURL;
    private LocalDateTime createdAt;

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        Random r = new Random();
        this.id = r.nextInt(1000, 5000);
        this.avatarURL = "https://picsum.photos/200/200";
        this.createdAt = LocalDateTime.now();
    }
}
