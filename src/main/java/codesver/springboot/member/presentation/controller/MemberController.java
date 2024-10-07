package codesver.springboot.member.presentation.controller;

import codesver.springboot.common.io.model.RestResponse;
import codesver.springboot.member.application.service.MemberService;
import codesver.springboot.member.domain.Members;
import codesver.springboot.member.presentation.model.request.MemberSearchRequest;
import codesver.springboot.member.presentation.model.response.MemberSearchResponse;
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
        Members members = memberService.getMembers(request.toCommand());
        MemberSearchResponse response = MemberSearchResponse.from(members);
        return RestResponse.of(response);
    }
}
