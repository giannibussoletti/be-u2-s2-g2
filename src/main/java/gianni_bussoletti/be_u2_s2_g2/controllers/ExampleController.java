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
    public String putExample() {
        return "La risposta arriva dell'Endpoint PUT ";
    }

    @PatchMapping
    public String patchExample() {
        return "La risposta arriva dell'Endpoint PATCH ";
    }

    @DeleteMapping
    public String deleteExample() {
        return "La risposta arriva dell'Endpoint DELETE ";
    }

    @GetMapping("/getExample")//<-- Questo pezzo andrà dopo /examples, sarà la parte finale dell'url
    // Ci possono essere più endpoint con lo stesso meotodo di richiamo, l'importante è che non abbiano lo stesso url
    public String getExample2() {
        return "GetExamples";
    }

    //    ----------------------- QUERY PARAMETERS --------------------
    @GetMapping("/queryParams")
//    I query parameters vengono definiti solo a livello di metodo
//    GET http://localhost:5555/examples/queryParams?name=Gianni&age=31
//    Attenzione ai valori non passati, avranno valore null con tutte le conseguenze del caso
//    Quindi o faccio dei controlli con if oppure posso sfruttare i defaultValuer, in maniera da non avere mai null
//    Con solo @RequestParam i dati da inserire nell'url sono obbligatori(Se non li inseriamo otterremo una bad request), quindi o mettiamo un defaultValue oppure un required=false che ritorna null come risposta dal server
    public String queryParameters(@RequestParam(defaultValue = "DEFAULT") String name, @RequestParam(defaultValue = "0") Integer age) {
        return "name: " + name + " age: " + age;
    }
}
