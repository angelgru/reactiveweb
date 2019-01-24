package com.microservices.reactiveweb

import java.lang.Exception

class CustomerNotFoundException(message: String): Exception(message) {
}