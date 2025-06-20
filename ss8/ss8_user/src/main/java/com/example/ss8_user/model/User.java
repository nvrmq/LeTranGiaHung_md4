package com.example.ss8_user.model;
import jakarta.validation.constraints.*;
public class User {

    @NotBlank(message = "Firstname cannot be empty")
    @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters")
    private String firstName;

    @NotBlank(message = "Lastname cannot be empty")
    @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters")
    private String lastName;

    @Pattern(regexp = "^(0[3-9]\\d{8}|(\\+84|84)[3-9]\\d{8})$", message = "Invalid Vietnamese phone number")
    private String phone;

    @Min(value = 18, message = "Must be atleast 18 yrs old")
    private int age;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Thou email shall not be left empty")
    private String email;

    public @NotBlank(message = "Firstname cannot be empty") @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "Firstname cannot be empty") @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters") String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank(message = "Lastname cannot be empty") @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank(message = "Lastname cannot be empty") @Size(min = 5, max = 45, message = "Lastname must have 5 to 45 characters") String lastName) {
        this.lastName = lastName;
    }

    public @Pattern(regexp = "^(0[3-9]\\d{8}|(\\+84|84)[3-9]\\d{8})$", message = "Invalid Vietnamese phone number") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(regexp = "^(0[3-9]\\d{8}|(\\+84|84)[3-9]\\d{8})$", message = "Invalid Vietnamese phone number") String phone) {
        this.phone = phone;
    }

    public @Min(value = 18, message = "Must be atleast 18 yrs old") int getAge() {
        return age;
    }

    public void setAge(@Min(value = 18, message = "Must be atleast 18 yrs old") int age) {
        this.age = age;
    }

    public @Email(message = "Invalid email address") @NotBlank(message = "Thou email shall not be left empty") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Invalid email address") @NotBlank(message = "Thou email shall not be left empty") String email) {
        this.email = email;
    }
}
