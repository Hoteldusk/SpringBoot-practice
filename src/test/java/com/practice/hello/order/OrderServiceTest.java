package com.practice.hello.order;

import com.practice.hello.AppConfig;
import com.practice.hello.member.Grade;
import com.practice.hello.member.Member;
import com.practice.hello.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(memberId);

        Order order = orderService.createOrder(memberId, findMember.getName(), 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
