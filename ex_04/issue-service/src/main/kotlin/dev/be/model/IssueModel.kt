package dev.be.model

import com.fasterxml.jackson.annotation.JsonFormat
import dev.be.domain.Comment
import dev.be.domain.Issue
import dev.be.domain.enums.IssuePriority
import dev.be.domain.enums.IssueStatus
import dev.be.domain.enums.IssueType
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus
)

data class IssueResponse(
    val id: Long,
    val userId: Long,
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    val comments: List<CommentResponse>,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?
) {

    companion object {

        // with 스코프 함수
        operator fun invoke(issue: Issue) =
            with(issue) {
                IssueResponse(
                    id = id!!,
                    userId = userId,
                    summary = summary,
                    description = description,
                    type = type,
                    priority = priority,
                    status = status,
                    comments = comments.sortedByDescending(Comment::id).map(Comment::toResponse),
                    createdAt = createdAt,
                    updatedAt = updatedAt
                )
            }
    }
}