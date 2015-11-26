package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;

public class API {

    ServerConnection serverConnection = new ServerConnection();

    public String login(User user) {
        String data = serverConnection.post(new Gson().toJson(user), "login/");

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;
        try {
            Object object = parser.parse(data);
            jsonObject = (JSONObject) object;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jsonObject != null) {

            if (jsonObject.get("userid") != null)
                user.setId((int)(long) jsonObject.get("userid"));

            return(String) jsonObject.get("message");
        }

        return "";
    }

    public ArrayList<User> getUsers() {
        String data = serverConnection.get("users/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<User>>(){}.getType());

    }

    public String createGame(Game game) {
        String data = serverConnection.post(new Gson().toJson(game), "games/");
        HashMap<String, String>hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }
}
