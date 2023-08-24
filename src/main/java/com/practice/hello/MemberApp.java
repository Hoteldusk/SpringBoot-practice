package com.practice.hello;

import com.practice.hello.discount.DiscountPolicy;
import com.practice.hello.discount.FixDiscountPolicy;
import com.practice.hello.member.Grade;
import com.practice.hello.member.Member;
import com.practice.hello.member.MemberService;
import com.practice.hello.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

public class MemberApp {
    public static void main(String[] args) {



//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //AppConfig 스프링프레임워크 기능적용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember  = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("find Member = " + findMember);
        System.out.println(member == findMember);

    }
}
