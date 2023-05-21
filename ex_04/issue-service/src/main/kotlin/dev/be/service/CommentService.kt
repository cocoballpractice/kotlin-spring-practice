package dev.be.service

import dev.be.domain.Comment
import dev.be.domain.CommentRepository
import dev.be.domain.IssueRepository
import dev.be.exception.NotFountException
import dev.be.model.CommentRequest
import dev.be.model.CommentResponse
import dev.be.model.toResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentService(
    private final val commentRepository: CommentRepository,
    private final val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(issueId : Long, userId : Long, username : String, request : CommentRequest) : CommentResponse {
        val issue = issueRepository.findByIdOrNull(issueId) ?: throw NotFountException("이슈가 존재하지 않습니다")

        val comment = Comment(
            issue = issue,
            userId = userId,
            username = username,
            body = request.body,
        )

        issue.comments.add(comment)
        return commentRepository.save(comment).toResponse() // 명시적 세이브
    }

    @Transactional
    fun edit(id : Long, userId : Long, request: CommentRequest): CommentResponse? {
        // null이 아닐 경우 run 작동
        return commentRepository.findByIdAndUserId(id, userId)?.run {
            body = request.body
            commentRepository.save(this).toResponse()
        }
    }

    @Transactional
    fun delete(issueId: Long, id : Long, userId: Long) {
        val issue = issueRepository.findByIdOrNull(id) ?: throw throw NotFountException("이슈가 존재하지 않습니다")
        commentRepository.findByIdAndUserId(id, userId)?.let { comment ->
            issue.comments.remove(comment)
        }
    }

}