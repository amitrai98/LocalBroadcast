package com.evontech.demo.testtest.models;

import java.util.Comparator;

public class UserComprator implements Comparator<Persons> {




        @Override
        public int compare(Persons o1, Persons o2) {
            // Order ascending.
            int ret = o1.getCreatedDate().compareTo(o2.getCreatedDate());

            // Order descending.
            //int ret = o2.getRegistDate().compareTo(o1.getRegistDate());

            return ret;
        }


}

