package dev.be.web

import dev.be.config.AuthUser
import dev.be.model.IssueRequest
import dev.be.service.IssueService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
        private val issueService: IssueService,
) {

    @PostMapping
    fun create(
            authUser : AuthUser,
            @RequestBody request : IssueRequest
    ) = issueService.create(authUser.userId, request)

}