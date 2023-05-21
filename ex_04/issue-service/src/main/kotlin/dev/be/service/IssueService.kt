package dev.be.service

import dev.be.domain.Issue
import dev.be.domain.IssueRepository
import dev.be.model.IssueRequest
import dev.be.model.IssueResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
        private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(userId : Long, request : IssueRequest) : IssueResponse {

        val issue = Issue(
                summary = request.summary,
                description = request.description,
                userId = userId,
                type = request.type,
                priority = request.priority,
                status = request.status
        )

        // IssueResponse의 invoke 사용
        return IssueResponse(issueRepository.save(issue))

    }
}