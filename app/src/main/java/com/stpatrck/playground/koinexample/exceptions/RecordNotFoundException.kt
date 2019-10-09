package com.stpatrck.playground.koinexample.exceptions

/**
 * Thrown when a specific data record is requested but no matching record is found.
 */
class RecordNotFoundException(message: String) : Exception(message)