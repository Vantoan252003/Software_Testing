package org.example.bai7;

import java.util.List;

/**
 * Bai 7.1 - OrderProcessor
 * Logic:
 *   1. cart null/empty -> IllegalArgumentException
 *   2. coupon SALE10 -> -10%, SALE20 -> -20%, khac -> IllegalArgumentException
 *   3. phi ship: total < 500000 && COD -> +30000; ONLINE -> mien phi
 *   4. member: GOLD -> -5%; PLATINUM -> -10%
 */
public class OrderProcessor {

    public double processOrder(List<Item> items, String coupon,
                               String memberLevel, String paymentMethod) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Gio hang trong");
        }

        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQty();
        }

        if (coupon != null && !coupon.isEmpty()) {
            switch (coupon) {
                case "SALE10": total *= 0.90; break;
                case "SALE20": total *= 0.80; break;
                default:
                    throw new IllegalArgumentException("Coupon khong hop le: " + coupon);
            }
        }

        if (total < 500_000 && "COD".equalsIgnoreCase(paymentMethod)) {
            total += 30_000;
        }

        if ("GOLD".equalsIgnoreCase(memberLevel)) {
            total *= 0.95;
        } else if ("PLATINUM".equalsIgnoreCase(memberLevel)) {
            total *= 0.90;
        }

        return total;
    }
}
