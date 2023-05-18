package woowacourse.shopping.data.respository.cart

import woowacourse.shopping.presentation.model.CartProductModel

interface CartRepository {
    fun getCarts(startPosition: Int, cartItemCount: Int): List<CartProductModel>
    fun deleteCartByProductId(productId: Long)
    fun addCart(productId: Long, productCount: Int)
}
