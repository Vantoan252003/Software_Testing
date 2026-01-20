public class HinhChuNhat {
    private Diem topLeft;      // Điểm trên bên trái
    private Diem bottomRight;  // Điểm dưới bên phải
    
    public HinhChuNhat(Diem topLeft, Diem bottomRight) {
        if (topLeft.getX() >= bottomRight.getX() || 
            topLeft.getY() <= bottomRight.getY()) {
            throw new IllegalArgumentException("Invalid Rectangle Points");
        }
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    public double tinhDienTich() {
        double width = bottomRight.getX() - topLeft.getX();
        double height = topLeft.getY() - bottomRight.getY();
        return width * height;
    }
    
    public boolean kiemTraGiaoNhau(HinhChuNhat other) {
        // Hai hình chữ nhật KHÔNG giao nhau khi:
        // - HCN này nằm hoàn toàn bên trái HCN kia
        // - HCN này nằm hoàn toàn bên phải HCN kia
        // - HCN này nằm hoàn toàn phía trên HCN kia
        // - HCN này nằm hoàn toàn phía dưới HCN kia
        
        if (this.bottomRight.getX() <= other.topLeft.getX() ||     // Bên trái
            this.topLeft.getX() >= other.bottomRight.getX() ||      // Bên phải
            this.bottomRight.getY() >= other.topLeft.getY() ||      // Phía dưới
            this.topLeft.getY() <= other.bottomRight.getY()) {      // Phía trên
            return false;
        }
        
        return true;
    }
    
    public Diem getTopLeft() {
        return topLeft;
    }
    
    public Diem getBottomRight() {
        return bottomRight;
    }
}