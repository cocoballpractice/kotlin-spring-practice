package dev.be.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "todos")
class Todo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = 0,

    // Spring Data JPA 사용 시 업데이트가 발생할 수 있는 프로퍼티에 대해서는 var를 사용해야 하는 부분이 아쉬움
    // 다른 Spring Data 프로젝트는 val을 사용하더라도 문제가 없었음
    // val을 사용하는 방법도 있긴 하지만 복잡
    // 대안으로 Spring Data JDBC도 있긴 함
    @Column(name = "title")
    var title: String,

    @Lob
    @Column(name = "description")
    var description: String,

    @Column(name = "done")
    var done: Boolean,

    @Column(name = "created_at")
    var createdAt : LocalDateTime,

    @Column(name = "updated_at")
    var updatedAt : LocalDateTime? = null,

) {

    fun update(title: String, description: String, done: Boolean) {
        this.title = title
        this.description = description
        this.done = done
        this.updatedAt = LocalDateTime.now()
    }

}