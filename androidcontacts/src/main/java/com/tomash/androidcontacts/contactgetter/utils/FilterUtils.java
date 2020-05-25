package com.tomash.androidcontacts.contactgetter.utils;

import com.tomash.androidcontacts.contactgetter.entity.Address;
import com.tomash.androidcontacts.contactgetter.entity.ContactData;
import com.tomash.androidcontacts.contactgetter.entity.Email;
import com.tomash.androidcontacts.contactgetter.entity.PhoneNumber;
import com.tomash.androidcontacts.contactgetter.interfaces.BaseFilter;
import com.tomash.androidcontacts.contactgetter.interfaces.FieldFilter;
import com.tomash.androidcontacts.contactgetter.interfaces.ListFilter;

import java.util.List;

public class FilterUtils {
    public static BaseFilter<PhoneNumber, String> withPhoneLikeFilter(final String number) {
        return new ListFilter<PhoneNumber, String>() {
            @Override
            protected String getFilterPattern() {
                return number;
            }

            @Override
            protected String getFilterData(PhoneNumber data) {
                return data.getMainData();
            }

            @Override
            protected List<PhoneNumber> getFilterContainer(ContactData contact) {
                return contact.getPhoneList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return formatNumber(data).contains(pattern);
            }

            private String formatNumber(String number) {
                return number.replaceAll("[^0-9+]", "");
            }
        };
    }

    public static BaseFilter<PhoneNumber, String> withPhoneFilter(final String number) {
        return new ListFilter<PhoneNumber, String>() {
            @Override
            protected String getFilterPattern() {
                return number;
            }

            @Override
            protected String getFilterData(PhoneNumber data) {
                return data.getMainData();
            }

            @Override
            protected List<PhoneNumber> getFilterContainer(ContactData contact) {
                return contact.getPhoneList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.equalsIgnoreCase(pattern);
            }
        };
    }

    public static BaseFilter<Email, String> withEmailFilter(final String email) {
        return new ListFilter<Email, String>() {
            @Override
            protected String getFilterPattern() {
                return email;
            }

            @Override
            protected String getFilterData(Email data) {
                return data.getMainData();
            }

            @Override
            protected List<Email> getFilterContainer(ContactData contact) {
                return contact.getEmailList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.equalsIgnoreCase(pattern);
            }
        };
    }

    public static BaseFilter<Email, String> withEmailLikeFilter(final String email) {
        return new ListFilter<Email, String>() {
            @Override
            protected String getFilterPattern() {
                return email;
            }

            @Override
            protected String getFilterData(Email data) {
                return data.getMainData();
            }

            @Override
            protected List<Email> getFilterContainer(ContactData contact) {
                return contact.getEmailList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.toLowerCase().contains(pattern.toLowerCase());
            }
        };
    }

    public static BaseFilter<Address, String> withAddressLikeFilter(final String address) {
        return new ListFilter<Address, String>() {
            @Override
            protected String getFilterPattern() {
                return address;
            }

            @Override
            protected String getFilterData(Address data) {
                return data.getMainData();
            }

            @Override
            protected List<Address> getFilterContainer(ContactData contact) {
                return contact.getAddressesList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.toLowerCase().contains(pattern.toLowerCase());
            }
        };
    }

    public static BaseFilter<Address, String> withAddressFilter(final String address) {
        return new ListFilter<Address, String>() {
            @Override
            protected String getFilterPattern() {
                return address;
            }

            @Override
            protected String getFilterData(Address data) {
                return data.getMainData();
            }

            @Override
            protected List<Address> getFilterContainer(ContactData contact) {
                return contact.getAddressesList();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.equalsIgnoreCase(pattern);
            }
        };
    }

    public static BaseFilter<ContactData, String> withNoteLike(final String noteLike) {
        return new FieldFilter<ContactData, String>() {
            @Override
            protected String getFilterPattern() {
                return noteLike;
            }

            @Override
            protected String getFilterData(ContactData data) {
                return data.getNote();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.toLowerCase().contains(pattern.toLowerCase());
            }
        };
    }

    public static BaseFilter<ContactData, String> withNote(final String note) {
        return new FieldFilter<ContactData, String>() {
            @Override
            protected String getFilterPattern() {
                return note;
            }

            @Override
            protected String getFilterData(ContactData data) {
                return data.getNote();
            }

            @Override
            protected boolean getFilterCondition(String data, String pattern) {
                return data.equalsIgnoreCase(pattern);
            }
        };
    }

}
