package org.example.dto.member;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberDtoListV2 {
    private List<MemberDto> memberDtoList;

    private MemberDtoListV2() {
        this.memberDtoList = new ArrayList<>();
        this.addList("db1648","박혜원");
        this.addList("hihi","이하이");

    }
    public void addList(String id, String name) {
        memberDtoList.add(new MemberDto(id, name));
    }
    public List<MemberDto> getList() {
        return memberDtoList;
    }
}
