package com.practice.hello;

import com.practice.hello.discount.DiscountPolicy;
import com.practice.hello.discount.FixDiscountPolicy;
import com.practice.hello.member.MemberRepository;
import com.practice.hello.member.MemberService;
import com.practice.hello.member.MemberServiceImpl;
import com.practice.hello.member.MemoryMemberRepository;
import com.practice.hello.order.OrderService;
import com.practice.hello.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
