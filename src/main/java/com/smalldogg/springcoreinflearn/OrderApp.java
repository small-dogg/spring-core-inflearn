package com.smalldogg.springcoreinflearn;

import com.smalldogg.springcoreinflearn.member.Grade;
import com.smalldogg.springcoreinflearn.member.Member;
import com.smalldogg.springcoreinflearn.member.MemberService;
import com.smalldogg.springcoreinflearn.member.MemberServiceImpl;
import com.smalldogg.springcoreinflearn.order.Order;
import com.smalldogg.springcoreinflearn.order.OrderService;
import com.smalldogg.springcoreinflearn.order.OrderServiceImpl;

public class OrderApp {

  public static void main(String[] args) {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    Long memberId = 1L;
    Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    Order order = orderService.createOrder(memberId, "orderA", 10000);

    System.out.println("order = " + order);
  }

}
