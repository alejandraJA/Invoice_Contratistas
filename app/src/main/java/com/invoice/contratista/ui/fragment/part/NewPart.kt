package com.invoice.contratista.ui.fragment.part

import kotlin.properties.Delegates

class NewPart {
    var budgetNumber by Delegates.notNull<Int>()
    lateinit var productsList: List<ProductsItem>
}