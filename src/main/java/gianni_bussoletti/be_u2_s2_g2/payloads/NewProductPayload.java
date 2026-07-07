package gianni_bussoletti.be_u2_s2_g2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class NewProductPayload {
    private String name;
    private double price;
    private String description;
}
