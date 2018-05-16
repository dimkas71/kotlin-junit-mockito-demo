package ua.compservice

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mockito


@DisplayName("Examples for using mockito  with kotlin")
@Tag("Active")
class MockitoWithKotlinTest {

    lateinit var bookService: BookService
    lateinit var manager: LandBookManager

    @BeforeEach
    fun setUp() {
        bookService = Mockito.mock(BookService::class.java)

        manager = LandBookManager(bookService)
    }

    @Test
    fun `when book is not available then an exception is thrown`() {
        Mockito.`when`(bookService.inStock(100)).thenReturn(false);
        val exception = assertThrows<IllegalStateException>() {
            manager.checkout(100, 1)
        }
        assertEquals("Book is not available", exception.message);
    }

    @Test
    fun `when book is available then lend method is called`() {
        Mockito.`when`(bookService.inStock(100)).thenReturn(true)
        manager.checkout(100, 1)
        Mockito.verify(bookService).lend(100, 1)
    }




}


interface BookService {
    fun inStock(bookId: Int): Boolean
    fun lend(bookId: Int, memberId: Int)
}

class LandBookManager(val bookService: BookService) {

    fun checkout(bookId: Int, memberId: Int) {
        if (bookService.inStock(bookId)) {
            bookService.lend(bookId, memberId)
        } else {
            throw IllegalStateException("Book is not available")
        }
    }

}
