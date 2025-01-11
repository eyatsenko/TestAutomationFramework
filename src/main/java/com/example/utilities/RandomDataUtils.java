package com.example.utilities;

import com.example.models.User;
import com.github.javafaker.Faker;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.stream.Stream;

public class RandomDataUtils {
    static Faker faker = new Faker();

    public static User getRandomUser() {
        User randomUser = new User();
        String[] subjects = {"Maths", "Arts", "History", "Accounting", "Biology", "Physics", "Computer Science",
                "Commerce", "Chemistry", "Civics", "Hindi", "Social Studies", "English"};
        String[] sex = {"Male", "Female", "Other"};
        String[] hobbies = {"Sports", "Reading", "Music"};
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] citiesUttar = {"Agra", "Lucknow", "Merrut"};
        String[] citiesHaryana = {"Karnal", "Panipat"};
        String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};
        String[] departments = {"Human Resources", "Finance", "Information Technology", "Marketing", "Sales",
                "Operations", "Customer Service", "Research and Development", "Legal", "Procurement"};

        randomUser.setFirstName(faker.name().firstName())
                  .setLastName(faker.name().lastName())
                  .setUsername((randomUser.getFirstName() + randomUser.getLastName()).toLowerCase())
                  .setPassword("Test!12345")
                  .setEmail((randomUser.getFirstName() + "." + randomUser.getLastName()).toLowerCase() + "@fakemail.xyz")
                  .setGender(Stream.of(sex).findAny().get())
                  .setMobileNumber(faker.numerify("##########"))
                  .setDayOfBirth(String.valueOf(faker.number().numberBetween(1, 30)))
                  .setMonthOfBirth(String.valueOf(faker.number().numberBetween(1, 12)))
                  .setYearOfBirth(String.valueOf(faker.number().numberBetween(1950, 2000)))
                  .setAge(String.valueOf(LocalDate.now().getYear() - Integer.parseInt(randomUser.getYearOfBirth())))
                  .setSubjects(new String[] {Stream.of(subjects).findAny().get()})
                  .setHobbies(new String[]{Stream.of(hobbies).findAny().get()})
                  .setPicture(Paths.get("src", "test", "resources", "img.png").toAbsolutePath().toString())
                  .setCurrentAddress(faker.address().fullAddress())
                  .setPermanentAddress(faker.address().fullAddress())
                  .setSalary(String.valueOf(faker.number().numberBetween(3000, 10000)))
                  .setDepartment(Stream.of(departments).findAny().get())
                  .setState(Stream.of(states).findAny().get());

        switch (randomUser.getState()) {
            case "NCR": {
                randomUser.setCity(citiesNCR[faker.random().nextInt(citiesNCR.length)]);
                break;
            }
            case "Uttar Pradesh": {
                randomUser.setCity(citiesUttar[faker.random().nextInt(citiesUttar.length)]);
                break;
            }
            case "Haryana": {
                randomUser.setCity(citiesHaryana[faker.random().nextInt(citiesHaryana.length)]);
                break;
            }
            case "Rajasthan": {
                randomUser.setCity(citiesRajasthan[faker.random().nextInt(citiesRajasthan.length)]);
                break;
            }
        }
        return randomUser;
    }
}
