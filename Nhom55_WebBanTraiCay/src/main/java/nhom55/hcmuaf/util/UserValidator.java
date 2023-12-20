package nhom55.hcmuaf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Pattern;

public class UserValidator {
    public static String validateName(String userName) {
        if (userName == null || userName.trim().isEmpty()) {
            return "Vui lòng nhập vào tên người dùng";
        }

        // Adjust the regular expression to match your requirements
        if (!userName.matches("^\\p{L}[\\p{L}\\s']*")) {
            return "Tên sản phẩm chỉ chứa ký tự chữ cái, khoảng trắng.";
        }

        return "";
    }

    public static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return "Vui lòng nhập vào email";
        }

        // Adjust the regular expression to match your requirements
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        if (!Pattern.matches(emailRegex, email)) {
            return "Địa chỉ email không hợp lệ";
        }

        return "";
    }

    public static String validateAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            return "Vui lòng nhập vào địa chỉ";
        }

        if (!address.matches("^\\p{L}[\\p{L}\\s']*")) {
            return "Địa chỉ chỉ chứa ký tự chữ cái, khoảng trắng.";
        }

        return "";
    }

    public static String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return "Vui lòng nhập vào số điện thoại";
        }

        String phoneRegex = "^[0-9]{10}$";

        if (!Pattern.matches(phoneRegex, phoneNumber.replaceAll("[\\s\\-()]+", ""))) {
            return "Số điện thoại không hợp lệ";
        }

        return "";
    }

    public static String validateDateOfBirth(LocalDate dateOfBirth) {
            if (dateOfBirth == null) {
                return "Vui lòng chọn ngày sinh nhật";
            }
            return "";
    }


}
