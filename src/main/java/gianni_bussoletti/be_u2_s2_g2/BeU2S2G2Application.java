package gianni_bussoletti.be_u2_s2_g2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeU2S2G2Application {

    static void main(String[] args) {
        SpringApplication.run(BeU2S2G2Application.class, args);
    }
//	Con l'installazione di Spring DevTools l'applicazione diventa un web Server che continua a girare senza uscire
//	dall'applicazione

//    Un pattern architetturale molto diffuso nella realizzazione
//    dei Web Service con Spring Boot è quello che prevede la
//    suddivisione dell'applicazione in quattro layers:
//
//    Controller: Si occupa di esporre gli endpoint,
//    mappare le richieste HTTP in ingresso e validare i
//    parametri. Non contiene logica di business, ma delega
//    il lavoro al livello successivo
//
//    Service: Qui vengono implementate le regole di business, le manipolazioni dei dati e i calcoli
//    complessi. Coordina le operazioni tra i Controller e i Repository
//
//    Repository: Si occupa delle interazioni con il database
//
//    Model: Contiene gli oggetti del dominio applicativo (Entities)

//    CONTROLLER
//    Il controller è una classe che usa delle sue annotazioni per
//    controllare gli endpoint l'annotazione @Controller e @Restcontroller(useremo questa) vale come Component, quindi spring la gestisce
//    Il mapping dei metodi viene effettuato con delle annotazioni che corrispondono ai metodi HTTP
//    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
//    All'interno delle varie annotazioni si possono personalizzare con l'url del mapping
//    @PostMapping("/path/url") <-- questa è la seconda parte dell'url dopo lo slash del link base

//    Spesso ci si ritrova a dover richiamare un end point sempre con lo stesso url di base
//    Es. products
//    In questo caso per semplificare e pulire il codice si usa @RequestMapping("/products")
//    In questa maniera il metodo con i suoi link userà sempre questo come prima notazione del link
//    facendolo seguire poi dalle altre notazioni

//    Per impostare il formato del payload è @ResponseBodyt
}
