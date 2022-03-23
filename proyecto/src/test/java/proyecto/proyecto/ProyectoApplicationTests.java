package proyecto.proyecto;

import java.time.LocalDateTime;

import org.joda.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.bootcamp.proyecto.detals.AccountDspt;
import com.bootcamp.proyecto.modelo.Account;
import com.bootcamp.proyecto.service.AccountService;
import com.bootcamp.proyecto.service.ClientService;
import com.bootcamp.proyecto.service.ClientServiceImpl;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import  static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.BodyInserters;

@AutoConfigureWebTestClient(timeout = "36000")
@ExtendWith(SpringExtension.class)
@WebFluxTest(AccountDspt.class)
@Import(ClientServiceImpl.class)
@SpringBootTest
class ProyectoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private WebTestClient webTestClient;
	
	@MockBean
    private ClientServiceImpl clientServiceImpl;

	final LocalDateTime dateTime = LocalDateTime.parse("22/03/2022 10:00:00",DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	@Test
    public void saveAccountPayment() {
        
		Account mono = new Account(null, 
				new Account(1,null,null,null,null,null), BigDecimal.TEN, "RETIRO",dateTime,new Client());
        when(AccountService.save(mono)).thenReturn(Mono.just(mono));
        webTestClient.post().uri("/accountPayment/save")
                
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromObject(mono))
                .exchange()
                .expectStatus().isCreated();          
    }

	@Test
    public void getAllAccountDatesProduct() {
        int productId = 1;
        Flux<String> flux = Flux.just("");
        when(clientServiceImpl.getAllAccountDatesProduct(productId,"2022-03-01","2022-03-15")).thenReturn(flux);
        Flux<Account> responseBody = webTestClient.get().
                uri("/accountPayment/list/dates"+"/"+productId+"/2022-03-01/2022-03-15")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Account.class)
                .getResponseBody();
        Duration verifyComplete = StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new Account(null, 
                    new Account(1,null,null,null,null,null), BigDecimal.TEN, "DEPOSITO", dateTime,new Client()))
                .expectNext(new Account(null, 
                    new Account(1,null,null,null,null,null), BigDecimal.TEN, "DEPOSITO", dateTime,new Client()))
                .verifyComplete();
    }
    @Test
    public void getAllAccountCardNumber() {
        String cardNumber = "12345";
        Flux<String> flux = Flux.just("");
        when(clientServiceImpl.getAllAccountCardNumber(cardNumber)).thenReturn(flux);
        Flux<Account> responseBody = webTestClient.get().uri("/accountPayment/list/cardNumber/"+cardNumber)
                .exchange()
                .expectStatus().isOk()
                .returnResult(Account.class)
                .getResponseBody();
    }

}









