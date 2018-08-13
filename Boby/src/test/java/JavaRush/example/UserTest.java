package JavaRush.example;

import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class UserTest {

    @Test
    public void getAllUsers() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        List <User> expected = User.getAllUsers();

        List <User> actual = new ArrayList <>();
        actual.add( user );
        actual.add( user1 );
        actual.add( user2 );

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllUsers_NO_NULL() {
        List <User> expected = User.getAllUsers();
        Assert.assertNotNull( expected );
    }

    @Test
    public void getAllUsers_MALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        List <User> expected = User.getAllUsers( User.Sex.Male );

        List <User> actual = new ArrayList <>();
        actual.add( user );

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllUsers_MALE_NO_NULL() {
        List <User> expected = User.getAllUsers( User.Sex.Male );
        Assert.assertNotNull( expected );
    }

    @Test
    public void getAllUsers_FEMALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        List <User> expected = User.getAllUsers( User.Sex.Female );

        List <User> actual = new ArrayList <>();
        actual.add( user1 );
        actual.add( user2 );

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllUsers_FEMALE_NO_NULL() {
        List <User> expected = User.getAllUsers( User.Sex.Female );
        Assert.assertNotNull( expected );
    }

    @Test
    public void getHowManyUsers() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getHowManyUsers();
        int actual = 3;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getHowManyUsers_MALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getHowManyUsers( User.Sex.Male );
        int actual = 1;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getHowManyUsers_FEMALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getHowManyUsers( User.Sex.Female );
        int actual = 2;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllAgeUsers() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getAllAgeUsers();

        int actual = 35 + 34 + 7;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllAgeUsers_MALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getAllAgeUsers( User.Sex.Male );

        int actual = 35;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void getAllAgeUsers_FEMALE() {
        User user = new User( "Евгений", 35, User.Sex.Male );
        User user1 = new User( "Марина", 34, User.Sex.Female );
        User user2 = new User( "Алина", 7, User.Sex.Female );

        int expected = User.getAllAgeUsers( User.Sex.Female );

        int actual = 34 + 7;

        Assert.assertEquals( expected, actual );
    }

    @Test
    public void newUser_EMPTY_NAME() {
        for (User user : User.getAllUsers()){
            if (user.getName() != null && user.getName().isEmpty()) {
                Assert.fail("Попытка создания пользователя с пустым именем");
            }
        }
    }

    @Test
    public void newUser_AGE_ZERO() {
        for (User user : User.getAllUsers()) {
            if (user.getAge() <= 0) {
                Assert.fail("Попытка создания пользователя c не допустимым возрастом");
            }
        }
    }

    @Test
    public void newUser_SEX_NO_NULL() {
        for (User user : User.getAllUsers()) {
            if (user.getSex() == null) {
                Assert.fail("Попытка создания пользователя с указанием пола = null");
            }
        }
    }
}