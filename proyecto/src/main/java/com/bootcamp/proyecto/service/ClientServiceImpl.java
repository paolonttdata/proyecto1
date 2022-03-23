package com.bootcamp.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.proyecto.modelo.Client;
import com.bootcamp.proyecto.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public void createCli(Client c) {	
		clientRepository.save(c).subscribe();
	}

	@Override
	public Mono<Client> findByCliId(Integer id) {	
		return clientRepository.findById(id);
	}

	@Override
	public Flux<Client> findAllCli() {
		return clientRepository.findAll();
	}

	@Override
	public Mono<Client> updateCli(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Mono<Void> deleteCli(Integer id) {
		return clientRepository.deleteById(id);
	}

	public Object getAllAccountCardNumber(String cardNumber) {
		return AccountService.getAllAccountCardNumber(cardNumber, true)
                .flatMapMany(data -> {
                    LOG.info(data.toString());
                    return iAccountPaymentRepository.findByAccountClientId(data.getAccountClient().getClient().getId())
                            .sort((obj1, obj2) -> obj2.getDate().compareTo(obj1.getDate())).take(10);
                })
                .map(data2 -> {
                    LOG.info(data2.toString());
                    return data2.getAccountClient().getClient().getName() + " " + data2.getDate() + " " + data2.getAmount() + " " + data2.getMovementtype() + "\n";
                })
                .onErrorResume(ex -> {
                    LOG.info(ex.toString());
                    return Flux.just(ex.getMessage());
                }).defaultIfEmpty("No hay registros");
    }

	public Object getAllAccountDatesProduct(int productId, String string, String string2) {
		return AccountService.findByProductId(productId)
                .flatMap(data -> {
                    LocalDate localDate1 = LocalDate.parse(dateIni);
                    LocalDate localDate2 = LocalDate.parse(dateFin);
                    LOG.info(data.toString());
                    return iAccountPaymentRepository.findByAccountClientIdAndDateBetween(data.getClient().getId(), localDate1, localDate2);
                })
                .map(data2 -> {
                    LOG.info(data2.toString());
                    return data2.getAccountClient().getClient().getName() + " " + data2.getDate() + " " + data2.getAmount() + " " + data2.getMovementtype() + "\n";
                })
                .onErrorResume(ex -> {
                    LOG.info(ex.toString());
                    return Flux.just(ex.getMessage());
                }).defaultIfEmpty("No hay registro");
	}

}

