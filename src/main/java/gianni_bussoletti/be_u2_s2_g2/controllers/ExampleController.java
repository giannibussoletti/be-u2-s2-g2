package gianni_bussoletti.be_u2_s2_g2.controllers;

import gianni_bussoletti.be_u2_s2_g2.payloads.NewProductPayload;
import gianni_bussoletti.be_u2_s2_g2.payloads.ProductPayloadResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    //    ----------------------------------PATH PARAMETERS----------------------------------
//    Non hanno il punto di domanda ma hanno lo slash
//    il path parameter va specificato nell'url
    @GetMapping("pathParamExample/{param}")
//    Il nome dato al placeholder tra le graffe nel mapping deve essere uguale a quello dato nel parametro del metodo
//     GET http://localhost:5555/examples/pathParamExample/placeholder <--- Le parentesi graffe permettono di avere un segnaposto senza avere una parola specifica
//    GET http://localhost:5555/examples/pathParamExample/223424
//    GET http://localhost:5555/examples/pathParamExample/434343
    public String pathParamExample(@PathVariable String param) {
        return "il parametro passato è: " + param;
    }

    //    ----------------------------------REQUEST BODY----------------------
    @PostMapping("/payloadExample")
//    Per creare un payload da riceve dal client, dobbiamo creare una classe apposita che definisca il tipo del payload, con questa classe andiamo a definire quali sono gli attributi necessari(che riceveremo dal client sotto forma JSON) e il costruttore con tutti gli attributi necessari
//    Se vogliamo ritornare un JSON al client, dobbiamo creare una classe e impostarla come Tipo del metodo, e lo manderà come payload della risposta
    public ProductPayloadResponse payloadExample(@RequestBody NewProductPayload newProductPayload) // @RequestBody si occuperà di convertire il JSON ricevuto in un oggetto vero e proprio
    {
        return new ProductPayloadResponse(1, LocalDateTime.now());
    }
}
