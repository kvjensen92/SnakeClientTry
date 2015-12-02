package sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.org.mozilla.javascript.internal.json.JsonParser;

import java.lang.reflect.Type;
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
                user.setId((int) (long) jsonObject.get("userid"));

            return (String) jsonObject.get("message");
        }

        return "";
    }

    public ArrayList<User> getUsers() {
        String data = serverConnection.get("users/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<User>>() {
        }.getType());

    }

    public String createGame(Game game) {
        String data = serverConnection.post(new Gson().toJson(game), "games/");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    public ArrayList<Game> getGames(int userID) {
        String data = serverConnection.get("games/pending/" + userID);
        return new Gson().fromJson(data, new TypeToken<ArrayList<Game>>() {
        }.getType());

    }

    public String joinGame(Game startGame) {
        String data = serverConnection.put(new Gson().toJson(startGame), "games/join");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        return hashMap.get("message");
    }

    public String startGame(Game startGame) {
        String data = serverConnection.put(new Gson().toJson(startGame), "games/start");
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

        if (hashMap.get("message") != null)
            return hashMap.get("message");
        else {
            Game g = new Gson().fromJson(data, Game.class);
            startGame.setWinner(g.getWinner());
            System.out.println(g.getName());
            return startGame.getWinner().getId()+ "";
        }
    }

    public ArrayList<Game> getGamesToDelete(int id) {
        String data = serverConnection.get("games/host/" + id);
        return new Gson().fromJson(data, new TypeToken<ArrayList<Game>>() {
        }.getType());

    }

    public String deleteGame(int gameId) {
        String data = serverConnection.delete("games/" + gameId);
        HashMap<String, String> hashMap = new Gson().fromJson(data, HashMap.class);

            return hashMap.get("message");
    }

    public ArrayList<Score> getHighscores() {
        String data = serverConnection.get("Highscores/");
        return new Gson().fromJson(data, new TypeToken<ArrayList<Score>>() {
        }.getType());
    }
}
