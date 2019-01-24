package com.microservices.reactiveweb

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
class CustomerController(val customerService: CustomerService) {

    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable("id") id: Int): ResponseEntity<Mono<Customer?>> {
        val customer = customerService.getCustomer(id) ?: throw CustomerNotFoundException("The customer  with id $id was not found")
        return ResponseEntity(customer, HttpStatus.OK)
    }

    @GetMapping(value = ["/customers"])
    fun getCustomers(@RequestParam(required = false,defaultValue = "") nameFilter: String)
            = customerService.searchCustomers(nameFilter)

    @PostMapping(value = ["/customer"])
    fun createCustomer(@RequestBody customer: Mono<Customer>)
            = ResponseEntity(customerService.createCustomer(customer), HttpStatus.CREATED)
}