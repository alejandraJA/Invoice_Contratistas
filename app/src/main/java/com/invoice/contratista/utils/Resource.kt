package com.invoice.contratista.utils

data class Resource<out T>(
    val status: Constants.Status,
    val data: T?,
    val exception: String?,
) {
    companion object {
        fun <T> success(data: T?): Resource<T> = Resource(Constants.Status.Success, data, null)
        fun <T> error(exception: String): Resource<T> =
            Resource(Constants.Status.Failure, null, exception)

        fun <T> loading(): Resource<T> = Resource(Constants.Status.Loading, null, null)
    }
}