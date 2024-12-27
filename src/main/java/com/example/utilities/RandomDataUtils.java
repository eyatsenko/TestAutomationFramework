package com.example.utilities;

import com.example.models.User;
import com.github.javafaker.Faker;

import java.nio.file.Paths;

public class RandomDataUtils {

    public static User getRandomUser() {
        Faker faker = new Faker();
        User randomUser = new User();
        String[] subjects = {"Maths", "Arts", "History", "Accounting", "Biology", "Physics", "Computer Science",
                "Commerce", "Chemistry", "Civics", "Hindi", "Social Studies", "English"};
        String[] sex = {"Male", "Female"};
        String[] hobbies = {"Sports", "Reading", "Music"};
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] citiesUttar = {"Agra", "Lucknow", "Merrut"};
        String[] citiesHaryana = {"Karnal", "Panipat"};
        String[] citiesRajasthan = {"Jaipur", "Jaiselmer"};

        randomUser.setFirstName(faker.name().firstName())
                  .setLastName(faker.name().lastName())
                  .setUsername((randomUser.getFirstName() + randomUser.getLastName()).toLowerCase())
                  .setPassword("Test!12345")
                  .setEmail((randomUser.getFirstName() + "." + randomUser.getLastName()).toLowerCase() + "@fakemail.xyz")
                  .setGender(sex[faker.random().nextInt(sex.length)])
                  .setMobileNumber(faker.numerify("##########"))
                  .setDateOfBirth("12052015") //TODO: add parsing logic
                  .setAge(String.valueOf(faker.random().nextInt(18,60))) //TODO: age should be calculated based on DOB
                  .setSubjects(new String[]{subjects[faker.random().nextInt(subjects.length)]})
                  .setHobbies(new String[]{hobbies[faker.random().nextInt(hobbies.length)]})
                  .setPicture(Paths.get("src", "test", "resources", "img.png").toAbsolutePath().toString())
                  .setCurrentAddress(faker.address().fullAddress())
                  .setPermanentAddress(faker.address().fullAddress())
                  .setSalary(String.valueOf(Math.round(faker.random().nextInt(3000, 10000) / 100.0) * 100))
                  .setDepartment(faker.animal().name()) //TODO: improve random department logic
                  .setState(states[faker.random().nextInt(states.length)]);

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
