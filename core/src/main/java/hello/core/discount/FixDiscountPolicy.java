package hello.core.discount;

import hello.core.member.Member;
import hello.core.member.Grade;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;  // 1000원 할인
    // Member 가 VIP냐 BASIC이냐에 따라서 정액할인 받을 값을 리턴해 준다.
    @Override
    public int discount(Member member, int price){
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }

}
