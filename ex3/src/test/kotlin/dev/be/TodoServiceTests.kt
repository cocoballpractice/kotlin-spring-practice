package dev.be

import com.ninjasquad.springmockk.MockkBean
import dev.be.domain.Todo
import dev.be.domain.TodoRepository
import dev.be.service.TodoService
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
class TodoServiceTests {

    @MockkBean
    lateinit var repository: TodoRepository

    lateinit var service: TodoService

    // 지연 초기화
    val stub : Todo by lazy {
        Todo(
            id = 1,
            title = "테스트",
            description = "테스트 상세",
            done = false,
            createdAt = LocalDateTime.now(),
            updatedAt = LocalDateTime.now(),
        )
    }

    @BeforeEach
    fun setUp() {
        service = TodoService(repository)
    }

    // 백틱을 사용, 띄어쓰기 사용 가능 (스네이크 케이스도 가능)
    @Test
    fun `한개의 TODO를 반환해야 한다`() {

        // given
        every { repository.findByIdOrNull(1) } returns stub

        // when
        val actual = service.findById(1)

        // then
        assertThat(actual).isNotNull
        assertThat(actual).isEqualTo(stub)
    }

}