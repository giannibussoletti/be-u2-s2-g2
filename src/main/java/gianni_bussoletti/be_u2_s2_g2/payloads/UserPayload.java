package gianni_bussoletti.be_u2_s2_g2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserPayload {
    // Attenzione a non confondere il payload con la rispettiva entity.
//    L'unico scopo di questa classe è definire come saranno fatti i payload in fase di creazione di un nuovo utente
//    Deve contenere gli attributi del JSON che il client invierà;
    private String name;
    private String surname;
    private String email;
    private String password;
}
