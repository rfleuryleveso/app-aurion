package fr.rflv.appaurion.services.aurion.impl.parsers

import org.jsoup.nodes.Document


fun extractViewState(doc: Document): String {
    val viewStateEl = doc.selectFirst("input[name=\"javax.faces.ViewState\"]")
    if (viewStateEl == null) {
        throw Error("No viewState");
    }
    val viewStateValue = viewStateEl.attr("value")
    if (viewStateValue == null) {
        throw Error("No viewStateValue");
    }
    return viewStateValue;
}

fun extractViewStateFromPartial(aurionPartialResponse: AurionPartialResponse): String {
    val viewStateEl =
        aurionPartialResponse.aurionChanges.find { it.id == "j_id1:javax.faces.ViewState:0" }
    if (viewStateEl == null) {
        throw Error("ViewState is null");
    }
    return viewStateEl.text;
}