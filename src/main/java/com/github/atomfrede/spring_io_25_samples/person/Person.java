package com.github.atomfrede.spring_io_25_samples.person;

public class Person {

    private Long id;
    private String name;
    private String quote;

    public Person(Long id, String name, String quote) {
        this.id = id;
        this.name = name;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
