package seb39_pre_002.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
@Validated
public class membercontroller {

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody memberPostDto memberDto) {
        return new ResponseEntity<>(memberDto, HttpStatus.CREATED);

//    public String postMember(@RequestParam("email") String email,
//                             @RequestParam("memberName") String memberName,
//                             @RequestParam("memberPassword") String memberPassword) {
//
//        Map<String, String> map = new HashMap<>();
//        System.out.println("# email: " + email);
//        System.out.println("# memberName: " + memberName);
//        System.out.println("# memberPassword: " + memberPassword);
//        String response =
//                "{\"" +
//                        "email\":\""+email+"\"," +
//                        "\"name\":\""+memberName+"\",\"" +
//                        "phone\":\"" + memberPassword+
//                        "\"}";
//        return response;
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody memberPatchDto memberPatchDto) {
        memberPatchDto.setmemberId(memberId);

        return new ResponseEntity<>(memberPatchDto, HttpStatus.OK);
    }


    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# memberId: " + memberId);

        // not implementation
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

        // not implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {
        System.out.println("# memberId: " + memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

