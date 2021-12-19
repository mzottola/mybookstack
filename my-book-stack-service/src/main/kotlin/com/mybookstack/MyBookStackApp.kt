package com.mybookstack

import com.mybookstack.annotations.DomainService
import com.mybookstack.annotations.Stub
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType

@SpringBootApplication
@ComponentScan(
    basePackages = ["com.mybookstack"],
    includeFilters = [ComponentScan.Filter(
        type = FilterType.ANNOTATION, classes = [DomainService::class, Stub::class]
    )]
)
class MyBookStackApp

fun main(args: Array<String>) {
    runApplication<MyBookStackApp>(*args)
}
