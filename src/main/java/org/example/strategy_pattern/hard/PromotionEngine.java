package org.example.strategy_pattern.hard;

public class PromotionEngine {
    public double applyPromotion(String promoCode, double price) {
        if (promoCode.equals("SUMMER")) {
            return price - 20;
        } else if (promoCode.equals("WINTER")) {
            return price * 0.85;
        } else if (promoCode.equals("VIP")) {
            return price * 0.9 - 10;
        } else if (promoCode.equals("NONE")) {
            return price;
        }
        return price;
    }
}
