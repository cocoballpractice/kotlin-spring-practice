package dev.be.service

import dev.be.api.model.TodoRequest
import dev.be.domain.Todo
import dev.be.domain.TodoRepository
import org.springframework.data.domain.Sort.Direction
import org.springframework.data.domain.Sort.by
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDateTime

@Service
class TodoService(
    val todoRepository: TodoRepository,
) {

    @Transactional(readOnly = true)
    fun findAll() : List<Todo> =
        todoRepository.findAll(by(Direction.DESC, "id"))

    @Transactional(readOnly = true)
    fun findById(id : Long) : Todo =
        todoRepository.findByIdOrNull(id) // 코틀린 확장 함수
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @Transactional
    fun create(request : TodoRequest?) : Todo {
        checkNotNull(request) { "TodoRequest is null" }

        val todo = Todo(
            // 안전 연산자를 사용하지 않았는데도 컴파일 에러가 발생하지 않는다
            // 왜냐하면 위에서 checkNotNull을 거침으로서 NonNull로 바뀌기 때문
            // 컴파일러는 checkNotNull을 거친 객체에 대해서는 NonNull로 인식한다
            title = request.title,
            description = request.description,
            done = request.done,
            createdAt = LocalDateTime.now()
        )

        return todoRepository.save(todo)
    }

    @Transactional
    fun update(id : Long, request: TodoRequest?) : Todo {
        checkNotNull(request) { "TodoRequest is null" }

        // 스코프 함수 사용
        return findById(id).let {
            // 마찬가지로 checkNotNull을 거침으로서 NonNull로 인식, 안전 연산자 쓰지 않아도 됨
            it.update(request.title, request.description, request.done)
            todoRepository.save(it)
        }

    }

    fun delete(id: Long) = todoRepository.deleteById(id)

}