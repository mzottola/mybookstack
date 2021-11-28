package com.domain.context

import com.mybookstack.domain.spi.stub.SearchBooksStub
import io.cucumber.core.backend.ObjectFactory
import io.cucumber.picocontainer.PicoFactory

class Injector(private val delegate: PicoFactory = PicoFactory()) : ObjectFactory by delegate {
    init {
        addClass(TestContext::class.java)
        addClass(SearchBooksStub::class.java)
    }
}
