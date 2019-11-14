package com.fragments.bottomnavassignment.ui.student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StudentViewModel extends ViewModel {

  private String name,age,address,gender;
    static List<StudentViewModel> Lists=new ArrayList<>();

    public static List<StudentViewModel> getLists() {
        return Lists;
    }

    public static void setLists(List<StudentViewModel> lists) {
        Lists = lists;
    }

    public StudentViewModel(String name, String age, String address, String gender) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}