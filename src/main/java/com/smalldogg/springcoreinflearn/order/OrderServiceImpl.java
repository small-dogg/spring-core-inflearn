package com.smalldogg.springcoreinflearn.order;


import com.smalldogg.springcoreinflearn.discount.DiscountPolicy;
import com.smalldogg.springcoreinflearn.member.Member;
import com.smalldogg.springcoreinflearn.member.MemberRepository;
import com.smalldogg.springcoreinflearn.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

  private final MemberRepository memberRepository;
  private final DiscountPolicy discountPolicy;

  public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
  }

  @Override
  public Order createOrder(Long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(member, itemPrice);

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
