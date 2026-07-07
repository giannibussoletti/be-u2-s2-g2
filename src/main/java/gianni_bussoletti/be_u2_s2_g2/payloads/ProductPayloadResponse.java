package gianni_bussoletti.be_u2_s2_g2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class ProductPayloadResponse {
    private int id;
    private LocalDateTime createdAt;
}
