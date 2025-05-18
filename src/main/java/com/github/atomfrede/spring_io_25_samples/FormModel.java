package com.github.atomfrede.spring_io_25_samples;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FormModel {

    @NotBlank(message = "First name is mandatory")
    public String firstName;
    @NotBlank(message = "Last name is mandatory")
    public String lastName;
    @NotBlank(message = "Talk is mandatory")
    @Size(min = 10, max = 120)
    public String talk;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTalk() {
        return talk;
    }

    public void setTalk(String talk) {
        this.talk = talk;
    }
}
