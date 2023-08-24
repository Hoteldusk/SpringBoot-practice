package com.practice.hello;

import com.practice.hello.member.Grade;
import com.practice.hello.member.Member;
import com.practice.hello.member.MemberService;
import com.practice.hello.order.Order;
import com.practice.hello.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        
        // 스프링 기능 사용(AppConfig Configuration 으로 등록, 메서드들 Bean 으로 등록
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order : " + order);
        System.out.println("order.calculatePrice() : " + order.calculatePrice());
    }
}
