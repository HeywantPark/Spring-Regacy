package org.example.dto.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDtoListV1 {
    private static MemberDtoListV1 instance;
    private List<MemberDto> memberDtoList;

    private MemberDtoListV1() {
        this.memberDtoList = new ArrayList<>();
        this.addList("db1648","박혜원");
        this.addList("hihi","이하이");

    }
    public static synchronized MemberDtoListV1 getInstance() {
        if (instance == null) {
            instance = new MemberDtoListV1();
        }
        return instance;
    }
    public void addList(String id, String name) {
        memberDtoList.add(new MemberDto(id, name));
    }
    public List<MemberDto> getList() {
        return memberDtoList;
    }
}
