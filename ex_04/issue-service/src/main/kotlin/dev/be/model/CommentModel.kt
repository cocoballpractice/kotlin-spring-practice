package dev.be.model

import dev.be.domain.Comment

data class CommentRequest(
    val body : String,
)

data class CommentResponse(
    val id : Long,
    val issueId : Long,
    val userId : Long,
    val body : String,
    val username : String?= null
)

// invoke 방식이 아닌 확장 함수를 사용
fun Comment.toResponse() = CommentResponse(
    id = id!!,
    issueId = issue.id!!,
    userId = userId,
    body = body,
    username = username,
)