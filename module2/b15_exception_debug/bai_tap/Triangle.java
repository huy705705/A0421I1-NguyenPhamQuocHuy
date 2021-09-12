package b15_exception_debug.bai_tap;

public class Triangle {
    public void isCheckTriangle(int side1, int side2, int side3) throws IllegalTriangleException {
        try {
            boolean isSide1 = (side2 + side3) > side1;
            boolean isSide2 = (side1 + side3) > side2;
            boolean isSide3 = (side1 + side2) > side3;
            boolean isTriangle = isSide1 && isSide2 && isSide3;
            if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
                throw new IllegalTriangleException("khong co canh nao be hon hoac bang 0");
            } else if (!isTriangle) {
                throw new IllegalTriangleException("tong 2 canh khong lon hon 2 canh con lai");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


