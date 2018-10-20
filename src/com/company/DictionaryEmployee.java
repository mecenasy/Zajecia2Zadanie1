package com.company;

import java.util.Hashtable;

public class DictionaryEmployee {
    private Hashtable<String,Employee> dictionary;
    private String company;

    public DictionaryEmployee(String company){
        this.dictionary = new Hashtable<>();
        this.company = company;
    }

    private String GenerateEmail (Employee employee, int key) {
        return employee.getName() + '.' + employee.getSurname() + (key != 0 ? key : "");
    }

    private Boolean IsEmployeeExist (Employee employee, int key){
        String employeeKey = this.GenerateEmail(employee, key );
        return dictionary.containsKey(employeeKey);
    }

    public Hashtable<String,Employee> GetDictionary(){
        return dictionary;
    }

    public void SetDictionary (Hashtable<String,Employee> dictionary){
        this.dictionary = dictionary;
    }

    public void AddNewEmployee (String name, String surname){
        Employee employee = new Employee(name, surname);
        int key = 0;

        while (this.IsEmployeeExist(employee, key)){
            key++;
        }

        String eMail = this.GenerateEmail(employee, key);

        employee.setEmail(eMail + "@" + this.company);
        this.dictionary.put(eMail, employee);
    }
}
