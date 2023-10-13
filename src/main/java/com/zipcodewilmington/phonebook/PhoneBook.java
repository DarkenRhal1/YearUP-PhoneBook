package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> phonebook) {
        this.phonebook = new LinkedHashMap<>(phonebook);
    }

    public PhoneBook(){
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber){
        if (phonebook.containsKey(name)) {
            List <String> numbers = phonebook.get(name);
            numbers.add(phoneNumber);

        }
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(phoneNumber);
        phonebook.put(name, phoneNumbers);


    }

    public void addAll(String name, String[] phoneNumbers){
        if (phonebook.containsKey(name)) {
            List <String> numbers1 = phonebook.get(name);
            numbers1.add(phoneNumbers[0]);
            numbers1.add(phoneNumbers[1]);
        }
        List <String> phoneNumbers1 = new ArrayList<>(Arrays.asList(phoneNumbers));
        phonebook.put(name, phoneNumbers1);
//        if (!phonebook.containsKey(phoneNumbers)){
//            phonebook.put(name, new ArrayList<>());
//        }
//
//        for (int i = 0; i < phoneNumbers.length; i++) {
//            phonebook.put(name, new ArrayList<>()).add(Arrays.toString(phoneNumbers));
//        }

    }

    public void remove(String name){
        phonebook.remove(name);
    }

    public boolean hasEntry(String name){
        return  phonebook.containsKey(name);
    }

    public List<String> lookup(String name){
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, List<String> > entry : phonebook.entrySet()){
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames(){
        List<String> nameList = new ArrayList<>();
        nameList.addAll(phonebook.keySet());
        return nameList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
