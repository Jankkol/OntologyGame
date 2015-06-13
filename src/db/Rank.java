package db;

import domain.User;
import helper.SerializationHelper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Jan Kakol on 2015-06-13.
 */
public class Rank implements Serializable {

    public static List<User> userList;

    public static void initRank(String db) {
        try {
            List<User> o = (List<User>) SerializationHelper.deSerialize(db);
            userList = o;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void saveRank(String db) {
        try {
            SerializationHelper.serialize(userList, db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
