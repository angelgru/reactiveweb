package com.microservices.reactiveweb

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class CustomerServiceImpl: CustomerService {

    var customers = mutableListOf<Customer>(
            Customer(1, "Kotlin"),
            Customer(2, "Spring"),
            Customer(3, "Microservices",
                    Customer.Telephone("+44", "322322")))

    override fun getCustomer(id: Int): Mono<Customer?> = Mono.just(customers[id])

    override fun searchCustomers(nameFilter: String): Flux<Customer> {
        return Flux.fromIterable(customers.filter { customer: Customer -> customer.name.contains(nameFilter) })
    }

    override fun createCustomer(customer: Mono<Customer>)
            = customer.doOnNext { c: Customer? -> if(c != null) customers.add(c)}.toMono()
}