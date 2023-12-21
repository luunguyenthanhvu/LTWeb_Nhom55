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

        public static String validateFileUpload(String fileName) {
            if (fileName == null || fileName.trim().isEmpty()) {
                return "Vui lòng chọn file ảnh.";
            }
            return "";
        }

        public static String validateGender(String gender) {
            if (gender == null || gender.trim().isEmpty()) {
                return "Vui lòng chọn giới tính";
            }
            String lowerCaseGender = gender.toLowerCase();

            // Thêm kiểm tra cho giới tính là nam hoặc nữ
            if (!lowerCaseGender.equals("nam") && !lowerCaseGender.equals("nữ")) {
                return "Giới tính không hợp lệ. Vui lòng chọn 'nam' hoặc 'nữ'.";
            }

            return "";
        }
        public static String validatePass(String password) {
            if (password == null || password.trim().isEmpty()) {
                return "Vui lòng nhập vào mật khẩu";
            }
            return "";
        }

        public static String validatePassword(String oldPassword, String newPassword, String retypePassword) {
            if (oldPassword == null || oldPassword.trim().isEmpty()) {
                return "Vui lòng nhập mật khẩu cũ.";
            }

            if (newPassword == null || newPassword.trim().isEmpty()) {
                return "Vui lòng nhập mật khẩu mới.";
            }

            if (retypePassword == null || retypePassword.trim().isEmpty()) {
                return "Vui lòng nhập lại mật khẩu mới.";
            }

            if (newPassword.length() <= 6) {
                return "Mật khẩu phải có độ dài lớn hơn 6 ký tự.";
            }
            // Kiểm tra xem có ít nhất 1 chữ cái viết hoa không
            if (!newPassword.matches(".*[A-Z].*")) {
                return "Mật khẩu phải chứa ít nhất 1 chữ cái viết hoa.";
            }

            if (!newPassword.equals(retypePassword)) {
                return "Mật khẩu mới và mật khẩu nhập lại không khớp.";
            }

            if (oldPassword.equals(newPassword)) {
                return "Mật khẩu mới không được giống mật khẩu cũ.";
            }

            return ""; // Mật khẩu nhập lại hợp lệ
        }


    }
