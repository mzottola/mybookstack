package com.domain.context

import io.cucumber.core.backend.ObjectFactory
import io.cucumber.picocontainer.PicoFactory

class Injector(private val delegate: PicoFactory = PicoFactory()) : ObjectFactory by delegate {
}
