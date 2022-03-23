package com.bootcamp.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.proyecto.modelo.Account;
import com.bootcamp.proyecto.modelo.Client;
import com.bootcamp.proyecto.repository.AccountRepository;
import com.bootcamp.proyecto.repository.ClientRepository;
import com.bootcamp.proyecto.repository.TransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Mono<Account> save(Account a) throws RuntimeException {

        Flux<Account> flux = findByClientId(a.getClient().getId())
                .map(data -> {
                    if (a.getClient() == null) {
                        throw new RuntimeException("Ingresar el cliente"); }
                    if (a.getProduct() == null) {
                        throw new RuntimeException("Ingresar el producto"); }
                    if (a.getBaseamount() == null) {
                        throw new RuntimeException("Ingresar el monto base"); }
                    if (a.getAmount() == null) {
                        throw new RuntimeException("Ingresar el monto"); }
                    return data;
                })
                .filter(data -> {
                    if (data.getClient().getClienttype().getId() == Constants.CLIENTE_TIPO_PERSONAL_ID) {
                        if (data.getProduct().getId() == e.getProduct().getId()
                                && (data.getProduct().getId() == Constants.CUENTA_AHORROS_ID
                                || data.getProduct().getId() == Constants.CUENTA_CORRIENTE_ID
                                || data.getProduct().getId() == Constants.CUENTA_PLAZO_FIJO_ID)) {
                            throw new RuntimeException("El cliente persona no puede tener mas de una cuenta de ahorro, "
                                    + "corriente o de plazo fijo");
                        }
                    }
                    return false;
                }).filter(data -> {
            if (data.getClient().getClienttype().getId() == Constants.CLIENTE_TIPO_EMPRESARIAL_ID) {
                if (data.getProduct().getId() == a.getProduct().getId()
                        && (data.getProduct().getId() == Constants.CUENTA_AHORROS_ID
                        || data.getProduct().getId() == Constants.CUENTA_PLAZO_FIJO_ID)) {
                    throw new RuntimeException("El cliente de tipo EMPRESARIAL no puede tener mas de una cuenta de ahorro o de plazo fijo");
                }
            }
            return false;
        }).switchIfEmpty(save(a));
        return Mono.from(flux);
    }

	@Override
	public Mono<Account> findById(Integer id) {
		return accountRepository.findById(id);
	}

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll();
	}
	
	@Override
	public Flux<String> findByClient(int id) {
		return accountRepository.findAll()
                .filter(data -> data.getClient().getId() == id).map(clienttype -> {return clienttype.getProduct().getName() 
                		+ "(monto inicial " + clienttype.getBaseamount() + "): " + clienttype.getAmount();});
	}
	@Override
	public Flux<Account> findAllAcco() {
		return accountRepository.findAll();
	}

	@Override
	public Mono<Account> updateAcco(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public Mono<Void> deleteAcco(Integer id) {
		return accountRepository.deleteById(id);
	}

	@Override
	public Flux<Account> findByClienttId(int id) {
		return clientRepository.findById(id);
				
	}
	public Flux<String> getAllAccountCardNumber(String cardNumber) {
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