package fr.rflv.appaurion.services.aurion.impl.parsers

import org.simpleframework.xml.*


@Root(strict = false, name = "update")
class AurionChangesList {
    @field:Attribute(name = "id", required = true)
    lateinit var id: String

    @field:Text(required = false)
    lateinit var text: String
}

@Root(name = "partial-response", strict = false)
class AurionPartialResponse {
    @field:ElementList(name = "changes", required = true)
    lateinit var aurionChanges: List<AurionChangesList>
}