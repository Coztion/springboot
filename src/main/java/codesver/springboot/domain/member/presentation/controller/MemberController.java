package codesver.springboot.domain.member.presentation.controller;

import codesver.springboot.domain.member.application.service.MemberService;
import codesver.springboot.domain.member.domain.Members;
import codesver.springboot.domain.member.presentation.model.request.MemberSearchRequest;
import codesver.springboot.domain.member.presentation.model.response.MemberSearchResponse;
import codesver.springboot.io.RestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping
    public RestResponse<MemberSearchResponse> searchMembers(@Valid MemberSearchRequest request) {
        Members members = memberService.searchMembers(request.toCommand());
        MemberSearchResponse response = MemberSearchResponse.from(members);
        return RestResponse.of(response);
    }
}
