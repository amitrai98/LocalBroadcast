package com.evontech.demo.testtest.models;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Persons implements Comparable<Persons> {
    private String name;
    private String city;
    private int age;
    private Date createdDate;

    public Persons(String name, String city, int age) {
        this.name = name; this.city = city; this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override public String toString() {
        return String.format("%s(%s,%d)", name, city, age);
    }
    @Override
    public int hashCode() {
        int hash = 7; hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.city);
        hash = 79 * hash + this.age; return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persons other = (Persons) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        } if (this.age != other.age) {
            return false;
        } return true;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int compareTo(@NonNull Persons o) {
        // Order ascending.
        int ret = this.getCreatedDate().compareTo(o.getCreatedDate());

        // Order descending.
        //int ret = o2.getRegistDate().compareTo(o1.getRegistDate());

        return ret;
    }
}

