package gianni_bussoletti.be_u2_s2_g2.controllers;

import org.springframework.web.bind.annotation.*;

@RestController // diverso da @Controller
//MEGLIO USARE RESTCONTROLLER
//Entrambe sono dei component e si integrano nei meccanismi di spring
@RequestMapping("/examples") // <-- Questa parte verrà attaccata alla parte finale dell'url
public class ExampleController {

//    Andiamo a creare dei metodi che corrisponderanno a un endpoint differente

    @GetMapping() //Metodo GET
    public String getExample() {
        return "La risposta arriva dell'endpoint GET";
    }

    @PostMapping
    public String postExample() {
        return "La risposta arriva dell'Endpoint POST ";
    }

    @PutMapping
    public void putExample() {
    }

    @PatchMapping
    public void patchExample() {
    }

    @DeleteMapping
    public void deleteExample() {
    }

    @GetMapping("/getExample")//<-- Questo pezzo andrà dopo /examples, sarà la parte finale dell'url
    // Ci possono essere più endpoint con lo stesso meotodo di richiamo, l'importante è che non abbiano lo stesso url
    public String getExample2() {
        return "GetExamples";
    }
}
