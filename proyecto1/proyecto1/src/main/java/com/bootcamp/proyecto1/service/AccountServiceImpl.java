package com.bootcamp.proyecto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.proyecto1.modelo.Account;
import com.bootcamp.proyecto1.modelo.Client;
import com.bootcamp.proyecto1.repository.AccountRepository;
import com.bootcamp.proyecto1.repository.ClientRepository;
import com.bootcamp.proyecto1.repository.TransactionRepository;

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
                        throw new RuntimeException("Dato de ingreso del cliente"); }
                    if (a.getProduct() == null) {
                        throw new RuntimeException("Dato de ingreso del producto"); }
                    if (a.getBaseamount() == null) {
                        throw new RuntimeException("Dato de ingreso del monto base"); }
                    if (a.getAmount() == null) {
                        throw new RuntimeException("Dato de ingreso del monto"); }
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
                .filter(data -> data.getClient().getId() == Id).map(clienttype -> {return clienttype.getProduct().getName() 
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


}