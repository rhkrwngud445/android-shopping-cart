package woowacourse.shopping.presentation.productlist

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import woowacourse.shopping.data.respository.cart.CartRepository
import woowacourse.shopping.data.respository.product.ProductRepository
import woowacourse.shopping.data.respository.recentproduct.RecentProductRepository
import woowacourse.shopping.presentation.model.ProductModel
import woowacourse.shopping.presentation.model.RecentProductModel
import woowacourse.shopping.presentation.view.productlist.ProductContract
import woowacourse.shopping.presentation.view.productlist.ProductListPresenter

class ProductListPresenterTest {
    private lateinit var presenter: ProductContract.Presenter
    private lateinit var view: ProductContract.View
    private lateinit var productRepository: ProductRepository
    private lateinit var recentProductRepository: RecentProductRepository
    private lateinit var cartRepository: CartRepository

    @Before
    fun setUp() {
        view = mockk(relaxed = true)
        productRepository = mockk()
        recentProductRepository = mockk()
        cartRepository = mockk()

        presenter =
            ProductListPresenter(view, productRepository, recentProductRepository, cartRepository)
    }

    @Test
    fun `데이터를 받아와 상품 목록 어댑터를 설정한다`() {
        // given
        every { productRepository.getData(0, 20) } returns dummyData
        val slot = slot<List<ProductModel>>()
        justRun { view.setProductItemsView(capture(slot)) }

        // when
        presenter.loadProductItems()

        // then
        val actual = slot.captured
        val expected = dummyData

        assertEquals(expected, actual)
        verify { productRepository.getData(0, 20) }
        verify { view.setProductItemsView(actual) }
    }

    @Test
    fun `데이터를 받아와 최근 본 상품을 어댑터를 설정한다`() {
        // given
        every { recentProductRepository.getRecentProducts() } returns dummyRecentProduct
        val slot = slot<List<RecentProductModel>>()
        justRun { view.setRecentProductItemsView(capture(slot)) }

        // when
        presenter.loadRecentProductItems()

        // then
        val actual = slot.captured
        val expected = dummyRecentProduct

        assertEquals(expected, actual)
        verify { recentProductRepository.getRecentProducts() }
        verify { view.setRecentProductItemsView(actual) }
    }

    @Test
    fun `업데이트 된 데이터를 받아와 최근 본 상품을 갱신한다`() {
        // given
        every { recentProductRepository.getRecentProducts() } returns dummyRecentProduct

        justRun { view.updateRecentProductItemsView() }
        presenter.loadRecentProductItems()

        // when
        presenter.updateRecentProductItems()

        // then

        verify { recentProductRepository.getRecentProducts() }
        verify { view.updateRecentProductItemsView() }
    }

    @Test
    fun `데이터가 더 존재한다면 추가 데이터를 가져와 갱신한다`() {
        // given
        every { productRepository.getData(0, 20) } returns dummyData
        val slotProducts = slot<List<ProductModel>>()
        justRun { view.updateMoreProductsView(capture(slotProducts)) }

        // when
        presenter.loadMoreData(0)

        // then
        val actual = slotProducts.captured
        assertEquals(1, actual.size)
        verify { productRepository.getData(0, 20) }
        verify { view.updateMoreProductsView(actual) }
    }

    companion object {
        private val dummyData = listOf(
            ProductModel(
                id = 0,
                title = "[선물세트][밀크바오밥] 퍼퓸 화이트 4종 선물세트 (샴푸+트리트먼트+바디워시+바디로션)",
                price = 24_900,
                imageUrl = "https://product-image.kurly.com/product/image/2c392328-104a-4fef-8222-c11be9c5c35f.jpg"
            )
        )

        private val dummyRecentProduct = listOf(
            RecentProductModel(
                id = 0,
                ProductModel(
                    id = 0,
                    title = "[선물세트][밀크바오밥] 퍼퓸 화이트 4종 선물세트 (샴푸+트리트먼트+바디워시+바디로션)",
                    price = 24_900,
                    imageUrl = "https://product-image.kurly.com/product/image/2c392328-104a-4fef-8222-c11be9c5c35f.jpg"
                )
            )
        )
    }
}
