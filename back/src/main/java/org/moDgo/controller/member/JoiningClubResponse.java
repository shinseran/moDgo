package org.moDgo.controller.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.moDgo.domain.ApprovalStatus;
import org.moDgo.domain.ClubStatus;
import org.moDgo.domain.Member;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JoiningClubResponse {
    private Long id;
    private Long clubId;
    private String title;
    private String contents;
    private String imgUrl;
    private LocalDate endDate;
    private String tags;
    private int likes;
    private ApprovalStatus approvalStatus;
    private ClubStatus clubStatus;

    public JoiningClubResponse(Member member) {
        this.id = member.getId();
        this.clubId = member.getClub().getId();
        this.title = member.getClub().getTitle();
        this.contents = member.getClub().getContents();
        this.imgUrl = member.getClub().getImgUrl();
        this.endDate = member.getClub().getEndDate();
        this.tags = member.getClub().getTags();
        this.likes = member.getClub().getLikes();
        this.approvalStatus = member.getApprovalStatus();
        this.clubStatus = member.getClub().getClubStatus();
    }
}
