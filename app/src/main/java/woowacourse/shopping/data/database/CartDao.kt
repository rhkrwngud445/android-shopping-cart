package woowacourse.shopping.data.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.provider.BaseColumns
import woowacourse.shopping.data.model.CartEntity

class CartDao(context: Context) {
    private val db = CartHelper(context).writableDatabase

    fun insertProduct(productId: Long) {
        val value = ContentValues().apply {
            put(CartContract.Cart.PRODUCT_ID, productId)
        }
        db.insert(CartContract.Cart.TABLE_NAME, null, value)
    }

    fun deleteAllProduct(productId: Long) {
        db.delete(
            CartContract.Cart.TABLE_NAME,
            "${CartContract.Cart.PRODUCT_ID} = ?",
            arrayOf(productId.toString())
        )
    }

    fun getItems(startPosition: Int, cartItemCount: Int): List<CartEntity> {
        val result = mutableListOf<CartEntity>()
        val cursor = getCursor(startPosition, cartItemCount)
        with(cursor) {
            while (moveToNext()) {
                val cartId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val productId =
                    getLong(getColumnIndexOrThrow(CartContract.Cart.PRODUCT_ID))
                result.add(CartEntity(cartId, productId))
            }
        }
        cursor.close()

        return result.toList()
    }

    private fun getCursor(startPosition: Int, cartItemCount: Int): Cursor {
        return db.query(
            CartContract.Cart.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null,
            "$startPosition, $cartItemCount"
        )
    }

    companion object {
    }
}
