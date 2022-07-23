package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        //        return null;
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        return phonebook.containsKey(name) && phonebook.get(name).contains(phoneNumber);
    }

    public List<String> lookup(String name) {
//        return null;
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
//        return null;
//        Map<List <String>, String> reversePhonebook = new LinkedHashMap<>();
//        for (List<String> numberPhone : phonebook.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey))) {
//            if (numberPhone.contains(phoneNumber)) {
//                return reversePhonebook.get(numberPhone);
//            }
//        }
//        return phoneNumber;
//        Map<List <String>, String> reversePhonebook = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> reversePhonebook : phonebook.entrySet())
            if (reversePhonebook.getValue().contains(phoneNumber)) {
                return reversePhonebook.getKey();
            }
        return null;
    }

    public List<String> getAllContactNames() {
//        return null;
        return new ArrayList<>(phonebook.keySet());
    }

    public Map<String, List<String>> getMap() {
//        return null;
        return phonebook;
    }
}
