package org.example.bai7;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

/**
 * Bai 7.1 - Basis Path + MC/DC cho OrderProcessor
 * smallCart: 200_000 (< 500_000)
 * bigCart:   600_000 (>= 500_000)
 */
@Feature("Bai 7.1 - OrderProcessor Basis Path + MCDC")
public class OrderProcessorTest {

    private OrderProcessor processor;
    private List<Item> smallCart;
    private List<Item> bigCart;

    @BeforeMethod
    public void setUp() {
        processor = new OrderProcessor();
        smallCart = Collections.singletonList(new Item("Product", 200_000, 1));
        bigCart   = Collections.singletonList(new Item("BigItem",  600_000, 1));
    }

    @Test
    @Story("Path1 - Gio hang rong") @Severity(SeverityLevel.CRITICAL)
    @Description("items=null -> IllegalArgumentException")
    public void testPath_EmptyCart() {
        Assert.assertThrows(IllegalArgumentException.class,
            () -> processor.processOrder(null, null, "NONE", "COD"));
    }

    @Test
    @Story("Path2 - No coupon, no member, COD, total>=500k") @Severity(SeverityLevel.CRITICAL)
    @Description("600k, null coupon, NONE, COD, total>=500k -> no ship fee -> 600000")
    public void testPath_NoCoupon_NoMember_FreeShip() {
        Assert.assertEquals(processor.processOrder(bigCart, null, "NONE", "COD"), 600_000.0, 0.01);
    }

    @Test
    @Story("Path3 - No coupon, no member, COD, total<500k") @Severity(SeverityLevel.CRITICAL)
    @Description("200k, null coupon, NONE, COD -> +30k -> 230000")
    public void testPath_NoCoupon_NoMember_PaidShip_COD() {
        Assert.assertEquals(processor.processOrder(smallCart, null, "NONE", "COD"), 230_000.0, 0.01);
    }

    @Test
    @Story("Path4 - No coupon, no member, ONLINE") @Severity(SeverityLevel.CRITICAL)
    @Description("200k, null coupon, NONE, ONLINE -> free ship -> 200000")
    public void testPath_NoCoupon_NoMember_PaidShip_Online() {
        Assert.assertEquals(processor.processOrder(smallCart, null, "NONE", "ONLINE"), 200_000.0, 0.01);
    }

    @Test
    @Story("Path5 - Coupon SALE10") @Severity(SeverityLevel.CRITICAL)
    @Description("600k, SALE10, NONE, ONLINE -> 540000")
    public void testPath_Coupon_SALE10() {
        Assert.assertEquals(processor.processOrder(bigCart, "SALE10", "NONE", "ONLINE"), 540_000.0, 0.01);
    }

    @Test
    @Story("Path6 - Coupon SALE20") @Severity(SeverityLevel.CRITICAL)
    @Description("600k, SALE20, NONE, ONLINE -> 480000")
    public void testPath_Coupon_SALE20() {
        Assert.assertEquals(processor.processOrder(bigCart, "SALE20", "NONE", "ONLINE"), 480_000.0, 0.01);
    }

    @Test
    @Story("Path7 - Coupon khong hop le") @Severity(SeverityLevel.CRITICAL)
    @Description("coupon=INVALID -> IllegalArgumentException")
    public void testPath_InvalidCoupon() {
        Assert.assertThrows(IllegalArgumentException.class,
            () -> processor.processOrder(bigCart, "INVALID", "NONE", "COD"));
    }

    @Test
    @Story("Path8 - GOLD member") @Severity(SeverityLevel.CRITICAL)
    @Description("600k, null coupon, GOLD, ONLINE -> 600000*0.95=570000")
    public void testPath_GoldMember() {
        Assert.assertEquals(processor.processOrder(bigCart, null, "GOLD", "ONLINE"), 570_000.0, 0.01);
    }

    @Test
    @Story("Path9 - PLATINUM member") @Severity(SeverityLevel.CRITICAL)
    @Description("600k, null coupon, PLATINUM, ONLINE -> 600000*0.9=540000")
    public void testPath_PlatinumMember() {
        Assert.assertEquals(processor.processOrder(bigCart, null, "PLATINUM", "ONLINE"), 540_000.0, 0.01);
    }

    @Test
    @Story("MCDC - Coupon Present doc lap") @Severity(SeverityLevel.NORMAL)
    @Description("SALE10 giam gia so voi khong coupon -> coupon la dieu kien doc lap")
    public void testMCDC_CouponPresent() {
        double withCoupon    = processor.processOrder(bigCart, "SALE10", "NONE", "ONLINE");
        double withoutCoupon = processor.processOrder(bigCart, null,     "NONE", "ONLINE");
        Assert.assertTrue(withCoupon < withoutCoupon, "SALE10 phai giam gia so voi khong coupon");
    }

    @Test
    @Story("MCDC - SALE10 doc lap") @Severity(SeverityLevel.NORMAL)
    @Description("SALE10 vs SALE20 cho ket qua khac nhau -> SALE10 la dieu kien doc lap")
    public void testMCDC_CouponSALE10() {
        double sale10 = processor.processOrder(bigCart, "SALE10", "NONE", "ONLINE");
        double sale20 = processor.processOrder(bigCart, "SALE20", "NONE", "ONLINE");
        Assert.assertNotEquals(sale10, sale20, 0.01, "SALE10 va SALE20 phai cho ket qua khac nhau");
    }
}
