package nhom55.hcmuaf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserValidator {
    public static String validateTenNguoiDung(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return "Vui lòng nhập tên người dùng";
        }

        // Adjust the regular expression to match your requirements
        if (!userName.matches("^\\p{L}[\\p{L}\\s']*")) {
            return "Tên người dùng chỉ chứa ký tự chữ cái, khoảng trắng.";
        }

        return "";
    }
    public static String validateNgaySinh(String dob) {
        if (dob == null || dob.isEmpty()) {
            return "Vui lòng chọn ngày sinh của người dùng.";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date ngaySinh = dateFormat.parse(dob);

        } catch (ParseException e) {
            return "Chuyển đổi sang ngày không thành công.";
        }

        return "";
    }

    public static String validateFileUpload(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            return "Vui lòng chọn file ảnh.";
        }
        return "";
    }

    public static String validateMatKhau(String matKhau) {
        String regex = "^(?=.*[A-Za-z0-9.@#$%]{8,})[A-Za-z0-9.@#$%]+$";
        if (matKhau == null || matKhau.isEmpty()) {
            return "Vui lòng nhập mật khẩu.";
        }
        if(!(matKhau.matches(regex))) {
            return "Độ dài mật khẩu có ít nhất 8 kí tự";
        }



        return "";
    }

    public static String validateNhapLaiMatKhau(String matKhau, String nhapLaiMK) {
        if (nhapLaiMK == null || nhapLaiMK.isEmpty()) {
            return "Vui lòng nhập mật khẩu.";
        }
        if(!(nhapLaiMK.equals(matKhau))) {
            return "Mật khẩu bạn nhập không giống ở trên. Vui lòng nhập lại";
        }
        return "";
    }

    public static String validateEmail(String email) {
        String regex = "^(([^<>()[\\\\]\\.,;:\\s@\\\"]+(\\.[^<>()[\\\\]\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        if (email == null || email.trim().isEmpty()) {
            return "Vui lòng nhập email.";
        }
        if(!(email.matches(regex))) {
            return "Email của bạn không đúng định dạng abc@xyz.abc . Vui lòng nhập lại.";
        }
        return "";
    }

    public static String validateSDT(String phoneNumber) {
        String regex = "^(0[1-9]|84[1-9])(\\d{8,9})$";
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return "Vui lòng nhập số điện thoại của bạn.";
        }
        if(!(phoneNumber.matches(regex))) {
            return "Không đúng điịnh dạng số điện thoại. Vui lòng nhập lại (Vd: 0982407940).";
        }
        return "";
    }


    public static String validateDiaChi(String address) {
        if (address == null || address.trim().isEmpty()) {
            return "Vui lòng nhập địa chỉ của bạn.";
        }

        // Adjust the regular expression to match your requirements
        if (!address.matches("^[\\s\\S]*$")) {
            return "Địa chỉ chỉ chứa chữ cái, chữ số.";
        }

        return "";
    }
}
