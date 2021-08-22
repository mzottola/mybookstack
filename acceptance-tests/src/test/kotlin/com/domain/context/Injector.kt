package com.domain.context

import com.mybookstack.domain.spi.stub.RetrieveBooksFromLibraryStub
import io.cucumber.core.backend.ObjectFactory
import io.cucumber.picocontainer.PicoFactory

class Injector(private val delegate: PicoFactory = PicoFactory()) : ObjectFactory by delegate {
    init {
        addClass(TestContext::class.java)
        addClass(RetrieveBooksFromLibraryStub::class.java)
    }
}
