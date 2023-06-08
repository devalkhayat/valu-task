package com.valu.task.util

import com.google.common.truth.Truth.assertThat
import com.valu.domain.home.models.Product
import com.valu.domain.home.models.Rating

import org.junit.Test

class HelperTest {

    @Test
    fun whenProductIsNullReturnFalse() {
        val result=helper.checkProductIsValid(null)
        assertThat(result).isFalse()
    }

    @Test
    fun whenImageUrlIsNullReturnFalse(){
        val product: Product=Product(image = null)
        val result=helper.checkProductIsValid(product)
        assertThat(result).isFalse()
    }
    @Test
    fun whenTitleIsNullReturnFalse(){
        val product: Product=Product(title = null)
        val result=helper.checkProductIsValid(product)
        assertThat(result).isFalse()
    }
    @Test
    fun whenRatingIsNullReturnFalse(){
        val product: Product=Product(rating = null)
        val result=helper.checkProductIsValid(product)
        assertThat(result).isFalse()
    }
    @Test
    fun whenAllDataValidReturnTrue(){
        val product: Product=Product(title ="product title", image = "url", rating = Rating(rate = 1.0F))
        val result=helper.checkProductIsValid(product)
        assertThat(result).isTrue()
    }
}