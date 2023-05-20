package dev.be.domain

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

    // Optional이 아닌 Nullable 타입으로 반환
    fun findAllByDoneIsFalseOrderByIdDesc() : List<Todo>?

}